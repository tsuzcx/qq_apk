package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.TroopSystemNotificationConstants;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.handler.TroopNotificationHandler;
import com.tencent.mobileqq.troop.recommend.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.utils.TroopRecommendTransUtils;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RecommendInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.ReqBody;
import tencent.im.oidb.cmd0x935.oidb_0x935.RgroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class RecommendTroopServiceImpl
  implements IRecommendTroopService
{
  protected static final String TAG = "RecommendTroopServiceImpl";
  private AppInterface app;
  public int curPage;
  protected EntityManager em;
  protected Object firstLock = new Object();
  public int isEnd;
  protected int mDBDataStatus = -1;
  protected SparseArray<Boolean> mGetRecommmendTroopLock = new SparseArray();
  protected SparseArray<Long> mGetRecommmendTroopTime = new SparseArray();
  private ArrayList<oidb_0x935.NotifyInfo> mGroupSysNotifyReportData = new ArrayList(5);
  private SosoInterfaceOnLocationListener mOnLocationListener = new RecommendTroopServiceImpl.1(this, 3, true, true, 60000L, false, false, "TroopNotificationFragment");
  private TroopNotificationHandler mTroopNotificationHandler;
  private int notificationUnReadNum;
  public List<RecommendTroopItem> pageAddedData = new ArrayList();
  SharedPreferences pref;
  public boolean showNewRecommend;
  protected final String spKeyNotificationRecommendTroop = "recommendtroop_notification_status";
  protected final String spNotificationRecommendTroop = "recommendtroop_notification";
  
  private void parseRecommendTroop(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
        if ((localOIDBSSOPkg.uint32_result.has()) && (localOIDBSSOPkg.uint32_result.get() == 0) && (localOIDBSSOPkg.bytes_bodybuffer.has()) && (localOIDBSSOPkg.bytes_bodybuffer.get() != null))
        {
          paramArrayOfByte = new oidb_0x935.RspBody();
          paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
          if (paramInt == 1) {
            return;
          }
          if (paramInt == 2) {
            ThreadManager.post(new RecommendTroopServiceImpl.3(this, paramLong, paramArrayOfByte), 8, null, true);
          }
        }
        else
        {
          if (!localOIDBSSOPkg.uint32_result.has()) {
            break label217;
          }
          paramInt = localOIDBSSOPkg.uint32_result.get();
          if (!localOIDBSSOPkg.str_error_msg.has()) {
            break label224;
          }
          paramArrayOfByte = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("RecommendTroopServiceImpl", 1, String.format("parseRecommendTroop, errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramArrayOfByte }));
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopServiceImpl", 2, "parseRecommendTroop sso error");
        }
      }
      return;
      label217:
      paramInt = -8888;
      continue;
      label224:
      paramArrayOfByte = "";
    }
  }
  
  private void saveNotificationRecommendTroop(long paramLong, oidb_0x935.RspBody paramRspBody)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveNotificationRecommendTroop, lastuin = ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("RecommendTroopServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    this.isEnd = paramRspBody.is_end.get();
    int j = 50 - this.pageAddedData.size();
    if (paramRspBody.cur_pos.get() == 1)
    {
      clearRecommendTroop();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopServiceImpl", 2, "get first page clear the db");
      }
    }
    Object localObject1 = paramRspBody.recommend_info.get();
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = ((List)localObject1).iterator();
    Object localObject2;
    if (localIterator1.hasNext())
    {
      localObject1 = (oidb_0x935.RecommendInfo)localIterator1.next();
      if (j < 0)
      {
        this.isEnd = 1;
      }
      else
      {
        localObject1 = ((oidb_0x935.RecommendInfo)localObject1).msg_groups.get();
        if (localObject1 == null) {
          return;
        }
        localEntityTransaction.begin();
        Iterator localIterator2 = ((List)localObject1).iterator();
        int i = j;
        for (;;)
        {
          j = i;
          if (!localIterator2.hasNext()) {
            break;
          }
          oidb_0x935.RgroupInfo localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator2.next();
          if (i < 0)
          {
            this.isEnd = 1;
            j = i;
            break;
          }
          NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
          if (localRgroupInfo.uint64_group_code.has())
          {
            localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localNotificationRecommendTroopItem.labelList = TroopRecommendTransUtils.a(localRgroupInfo.rpt_group_label.get());
            localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            boolean bool = localRgroupInfo.bytes_algorithm.has();
            localObject2 = "";
            if (bool) {
              localObject1 = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            } else {
              localObject1 = "";
            }
            localNotificationRecommendTroopItem.recomAlgol = ((String)localObject1);
            localObject1 = localObject2;
            if (localRgroupInfo.bytes_join_group_auth.has()) {
              localObject1 = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            }
            localNotificationRecommendTroopItem.authSig = ((String)localObject1);
            if (localRgroupInfo.uint32_activity.has()) {
              j = localRgroupInfo.uint32_activity.get();
            } else {
              j = 0;
            }
            localNotificationRecommendTroopItem.activity = j;
            if (localRgroupInfo.int32_uin_privilege.has()) {
              j = localRgroupInfo.int32_uin_privilege.get();
            } else {
              j = -1;
            }
            localNotificationRecommendTroopItem.privilege = j;
            this.em.persistOrReplace(localNotificationRecommendTroopItem);
            localArrayList.add(localNotificationRecommendTroopItem);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("saveNotificationRecommendTroop into db, recommend troop = ");
              ((StringBuilder)localObject1).append(localNotificationRecommendTroopItem);
              QLog.d("RecommendTroopServiceImpl", 2, ((StringBuilder)localObject1).toString());
            }
            i -= 1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        try
        {
          localEntityTransaction.commit();
          localEntityTransaction.end();
        }
        finally
        {
          continue;
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("RecommendTroopServiceImpl", 2, "saveNotificationRecommendTroop commit error");
      }
    }
    if (localArrayList.size() > 0) {
      updateDBStatsus(0);
    }
    if ((this.curPage == paramRspBody.cur_pos.get() - 1) || (paramRspBody.cur_pos.get() == 1))
    {
      this.pageAddedData.addAll(localArrayList);
      this.curPage = paramRspBody.cur_pos.get();
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("getNotificationRecommendTroopList add page");
        paramRspBody.append(localArrayList.size());
        QLog.d("RecommendTroopServiceImpl", 2, paramRspBody.toString());
        paramRspBody = localArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          localObject1 = (RecommendTroopItem)paramRspBody.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecommendTroop from network = ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("RecommendTroopServiceImpl", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    this.mTroopNotificationHandler.notifyUI(TroopSystemNotificationConstants.b, true, this.pageAddedData);
    return;
    localEntityTransaction.end();
    for (;;)
    {
      throw paramRspBody;
    }
  }
  
  public void clearGroupSysNotifyReportData()
  {
    ArrayList localArrayList = this.mGroupSysNotifyReportData;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public void clearRecommendTroop()
  {
    Object localObject = this.em;
    if (localObject != null) {
      ((EntityManager)localObject).drop(NotificationRecommendTroopItem.class);
    }
    localObject = (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null)
    {
      ((IMessageFacade)localObject).clearRecommendTroopMsgByMsgType(-1039);
      ((IMessageFacade)localObject).clearRecommendTroopMsgByMsgType(-1040);
    }
    this.pref.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void delRecommendTroopFromMsg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    IMessageFacade localIMessageFacade = (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade != null)
    {
      List localList = localIMessageFacade.getMsgList(AppConstants.RECOMMEND_TROOP_UIN, 4001);
      if ((localList != null) && (localList.size() > 0))
      {
        i = localList.size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if ((localMessageRecord.msgtype == -1039) && (!TextUtils.isEmpty(localMessageRecord.extStr)) && (localMessageRecord.extStr.equals(paramString)))
          {
            localIMessageFacade.removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
            localList.remove(i);
          }
          i -= 1;
        }
      }
    }
    int i = RecommendTroopUtils.a(this.app);
    this.pref.edit().putInt("unread_recommend_troop_count", i).commit();
  }
  
  public boolean downloadRecommendTroop()
  {
    synchronized (this.firstLock)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.mOnLocationListener);
      return true;
    }
  }
  
  public List<RecommendTroopItem> getAddedData()
  {
    return this.pageAddedData;
  }
  
  public int getDBDataStatus()
  {
    int i = this.mDBDataStatus;
    if (i != -1) {
      return i;
    }
    if (i == -1) {
      this.mDBDataStatus = this.app.getApp().getSharedPreferences("recommendtroop_notification", 0).getInt("recommendtroop_notification_status", 0);
    }
    return this.mDBDataStatus;
  }
  
  public String getLastMessage()
  {
    try
    {
      Object localObject = (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "");
      if (localObject != null)
      {
        localObject = ((IMessageFacade)localObject).getMsgList(AppConstants.RECOMMEND_TROOP_UIN, 4001);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = ((List)localObject).size() - 1;
          while (i >= 0)
          {
            MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
            if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0))
            {
              localObject = localMessageRecord.msg;
              return localObject;
            }
            i -= 1;
          }
        }
      }
      return "";
    }
    catch (NullPointerException localNullPointerException) {}
    return "";
  }
  
  public void getNotificationRecommendTroopFromServer(long paramLong, oidb_0x935.GPS paramGPS, int paramInt)
  {
    getRecommendTroopFromServer(2, paramGPS, paramInt, new RecommendTroopServiceImpl.2(this, paramLong));
  }
  
  public void getRecommendTroopFromServer(int paramInt1, oidb_0x935.GPS paramGPS, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopServiceImpl", 4, "getRecommend0x935TroopFromServer() start getRecommend0x935TroopFromServer");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopServiceImpl", 4, "getRecommendTroopFromServer() start getRecommendTroopFromServer");
    }
    if ((this.mGetRecommmendTroopLock.get(paramInt1) != null) && (((Boolean)this.mGetRecommmendTroopLock.get(paramInt1)).booleanValue())) {
      return;
    }
    if (this.mGetRecommmendTroopTime.get(paramInt1) != null) {
      l = ((Long)this.mGetRecommmendTroopTime.get(paramInt1)).longValue();
    } else {
      l = 0L;
    }
    long l = System.currentTimeMillis() / 1000L;
    this.mGetRecommmendTroopTime.append(paramInt1, Long.valueOf(l));
    this.mGetRecommmendTroopLock.append(paramInt1, Boolean.valueOf(true));
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopServiceImpl", 4, "getRecommendTroopFromServer() start");
    }
    Object localObject1 = new oidb_0x935.ReqBody();
    ((oidb_0x935.ReqBody)localObject1).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject1).uint32_pos.set(this.curPage);
    if (paramGPS != null) {
      ((oidb_0x935.ReqBody)localObject1).msg_gps.set(paramGPS);
    }
    paramGPS = this.mGroupSysNotifyReportData;
    if ((paramGPS != null) && (!paramGPS.isEmpty()))
    {
      if (QLog.isDevelopLevel())
      {
        paramGPS = new StringBuilder();
        localObject2 = this.mGroupSysNotifyReportData.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          oidb_0x935.NotifyInfo localNotifyInfo = (oidb_0x935.NotifyInfo)((Iterator)localObject2).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localNotifyInfo.uint64_notify_gc.get());
          localStringBuilder.append(",");
          localStringBuilder.append(localNotifyInfo.uint32_notify_type.get());
          localStringBuilder.append(" ");
          paramGPS.append(localStringBuilder.toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getRecommendTroopFromServer() report ");
        ((StringBuilder)localObject2).append(paramGPS.toString());
        QLog.d("RecommendTroopServiceImpl", 4, ((StringBuilder)localObject2).toString());
      }
      ((oidb_0x935.ReqBody)localObject1).msg_notify_info.set(this.mGroupSysNotifyReportData);
    }
    paramGPS = new oidb_sso.OIDBSSOPkg();
    paramGPS.uint32_command.set(2357);
    paramGPS.uint32_result.set(0);
    paramGPS.uint32_service_type.set(paramInt2);
    paramGPS.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.app.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject1).setWithouLogin(true);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OidbSvc.0x935_");
    ((StringBuilder)localObject2).append(String.valueOf(paramInt2));
    ((NewIntent)localObject1).putExtra("cmd", ((StringBuilder)localObject2).toString());
    ((NewIntent)localObject1).putExtra("data", paramGPS.toByteArray());
    ((NewIntent)localObject1).setObserver(paramBusinessObserver);
    this.app.startServlet((NewIntent)localObject1);
  }
  
  public int getUnreadNum()
  {
    return this.notificationUnReadNum;
  }
  
  public int isEnd()
  {
    return this.isEnd;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.app = ((AppInterface)paramAppRuntime);
      paramAppRuntime = this.app.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recommend_troop_info");
      localStringBuilder.append(this.app.getAccount());
      this.pref = paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
      this.em = this.app.getEntityManagerFactory().createEntityManager();
    }
  }
  
  public void onDestroy() {}
  
  public void reSetConfig()
  {
    this.curPage = 0;
    this.isEnd = 0;
    this.pageAddedData.clear();
  }
  
  public void saveAddedData(List<RecommendTroopItem> paramList)
  {
    this.pageAddedData = paramList;
  }
  
  public void saveGroupSysNotifyReportData(ArrayList<oidb_0x935.NotifyInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveGroupSysNotifyReportData ");
      if (paramArrayList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramArrayList.size());
      }
      localStringBuilder.append(localObject);
      QLog.d("RecommendTroopServiceImpl", 2, localStringBuilder.toString());
    }
    Object localObject = this.mGroupSysNotifyReportData;
    if ((localObject != null) && (paramArrayList != null))
    {
      ((ArrayList)localObject).clear();
      this.mGroupSysNotifyReportData.addAll(paramArrayList);
    }
  }
  
  public void sendReadConfirm()
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade != null)
    {
      localIMessageFacade.setRecommendTroopMsgReaded(-1039);
      localIMessageFacade.setRecommendTroopMsgReaded(-1040);
    }
    this.pref.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void setEnd(int paramInt)
  {
    this.isEnd = paramInt;
  }
  
  public void setRecommendTroopDeleted(String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new oidb_0x935.ReqBody();
    try
    {
      l = Long.valueOf(paramString).longValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label20:
      StringBuilder localStringBuilder;
      break label20;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecommendTroopDeleted NumberFormatException + ");
      localStringBuilder.append(paramString);
      QLog.i("RecommendTroopServiceImpl", 2, localStringBuilder.toString());
    }
    l = 0L;
    if (l == 0L) {
      return;
    }
    ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject).uint64_black_gc.set(l);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2357);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(7);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.app.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x935_7");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void setUnreadNum(int paramInt)
  {
    this.notificationUnReadNum = paramInt;
  }
  
  public void updateDBStatsus(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDBStatsus:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RecommendTroopServiceImpl", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.app.getApp().getSharedPreferences("recommendtroop_notification", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("recommendtroop_notification_status", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
    this.mDBDataStatus = paramInt;
  }
  
  public void updateTroopRecommend(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTroopRecommend content:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",\n uin: ");
      localStringBuilder.append(this.app.getAccount());
      localStringBuilder.append(", version:");
      localStringBuilder.append(paramInt);
      QLog.d("RecommendTroopServiceImpl", 2, localStringBuilder.toString());
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("showNewTroopRecommend") == 1)
        {
          bool = true;
          this.showNewRecommend = bool;
          paramString = this.app.getPreferences();
          paramString.edit().putBoolean("show_new_troop_recommend", bool);
          paramString.edit().commit();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLebaConfig e:");
        localStringBuilder.append(paramString.toString());
        QLog.d("RecommendTroopServiceImpl", 1, localStringBuilder.toString());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.RecommendTroopServiceImpl
 * JD-Core Version:    0.7.0.1
 */