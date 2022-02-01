package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.LocationInfo;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.PhoneInfo;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.RspBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.PhoneInfo;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.ReqBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.RspBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgGetChannelInfoRsp;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.PhoneInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.ReqBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.RspBody;

public class ChannelCoverInfoModule
  extends ChannelInfoModule
{
  public static boolean a = false;
  private final Object b = new Object();
  private LinkedHashMap<Integer, ChannelCoverInfo> c = new LinkedHashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> d = new LinkedHashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> e = new LinkedHashMap();
  private HashMap<Integer, List<ChannelCoverInfo>> f = new HashMap();
  private HashMap<Integer, Integer> g = new HashMap();
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private long k = 0L;
  private List<ChannelSection> l = new ArrayList();
  private IFindRemovedEntity<TabChannelCoverInfo> m = new ChannelCoverInfoModule.1(this);
  private IFindRemovedEntity<ChannelCoverInfo> n = new ChannelCoverInfoModule.2(this);
  
  public ChannelCoverInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(TabChannelCoverInfo.class, this.m);
    registerEntityFinder(ChannelCoverInfo.class, this.n);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface != null)
    {
      if (paramInt == 0) {
        return paramQQAppInterface.getInt("readInJoy_mian_channel_cover_seq", 0);
      }
      if (paramInt == 56) {
        return paramQQAppInterface.getInt("readInJoy_video_channel_cover_seq", 0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readInJoy_sub_channel_cover_seq");
      ((StringBuilder)localObject).append(paramInt);
      return paramQQAppInterface.getInt(((StringBuilder)localObject).toString(), 0);
    }
    return 0;
  }
  
  private ChannelCoverInfo a(int paramInt, List<ChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (localChannelCoverInfo.mChannelCoverId == paramInt) {
          return localChannelCoverInfo;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.h = paramInt2;
      return;
    }
    if (paramInt1 == 56)
    {
      this.i = paramInt2;
      return;
    }
    this.g.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      if (paramInt2 == 0)
      {
        paramQQAppInterface.putInt("readInJoy_mian_channel_cover_seq", paramInt1);
      }
      else if (paramInt2 == 56)
      {
        paramQQAppInterface.putInt("readInJoy_video_channel_cover_seq", paramInt1);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readInJoy_sub_channel_cover_seq");
        ((StringBuilder)localObject).append(paramInt2);
        paramQQAppInterface.putInt(((StringBuilder)localObject).toString(), paramInt1);
      }
      paramQQAppInterface.commit();
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateChannelCoverSeqConfig, seq =");
        paramQQAppInterface.append(paramInt1);
        paramQQAppInterface.append(" ;channelId = ");
        paramQQAppInterface.append(paramInt2);
        QLog.d("ChannelCoverInfoModule", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(List<TabChannelCoverInfo> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" tabChannelCoverInfo [");
        QLog.d("ChannelCoverInfoModule", 1, new Object[] { localStringBuilder.toString(), Integer.valueOf(i1), "]: ", ((TabChannelCoverInfo)paramList.get(i1)).shortLogString() });
        i1 += 1;
      }
    }
  }
  
  private void a(List<ChannelSection> paramList1, List<ChannelSection> paramList2)
  {
    SparseArray localSparseArray = new SparseArray();
    paramList2 = paramList2.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList2.hasNext())
    {
      localObject1 = ((ChannelSection)paramList2.next()).d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TabChannelCoverInfo)((Iterator)localObject1).next();
        localSparseArray.put(((TabChannelCoverInfo)localObject2).mChannelCoverId, localObject2);
      }
    }
    paramList2 = paramList1.iterator();
    while (paramList2.hasNext())
    {
      localObject1 = (ChannelSection)paramList2.next();
      localObject2 = ((ChannelSection)localObject1).d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject2).next();
        TabChannelCoverInfo localTabChannelCoverInfo2 = (TabChannelCoverInfo)localSparseArray.get(localTabChannelCoverInfo1.mChannelCoverId);
        if (localTabChannelCoverInfo2 != null) {
          if (localTabChannelCoverInfo1.redPoint != null)
          {
            if ((!localTabChannelCoverInfo1.redPoint.a) && (localTabChannelCoverInfo2.redPoint != null)) {
              localTabChannelCoverInfo1.redPoint.a = localTabChannelCoverInfo2.redPoint.a;
            }
          }
          else {
            localTabChannelCoverInfo1.redPoint = localTabChannelCoverInfo2.redPoint;
          }
        }
        int i1;
        if (ChannelModeConfigHandler.a()) {
          i1 = 11;
        } else {
          i1 = 6;
        }
        int i3 = paramList1.indexOf(localObject1);
        int i2 = 0;
        if ((i3 == 0) && (((ChannelSection)localObject1).d.indexOf(localTabChannelCoverInfo1) < i1)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (RIJChannelHelper.a(localTabChannelCoverInfo1) != -1) {
          i2 = 1;
        }
        if ((i2 != 0) && (i1 == 0)) {
          a(true);
        }
      }
    }
  }
  
  private boolean a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo == null) {
      return false;
    }
    paramChannelCoverInfo = paramChannelCoverInfo.clone();
    b(paramChannelCoverInfo, paramInt);
    this.mExecutorService.execute(new ChannelCoverInfoModule.5(this, paramChannelCoverInfo));
    return true;
  }
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    if (paramList != null)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i1);
        if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == paramTabChannelCoverInfo.mChannelCoverId) && (localTabChannelCoverInfo.mChannelId == paramTabChannelCoverInfo.mChannelId)) {
          try
          {
            paramList.set(i1, paramTabChannelCoverInfo);
            return true;
          }
          catch (Exception paramTabChannelCoverInfo)
          {
            paramList = new StringBuilder();
            paramList.append("findAndReplaceChannel channelCoverInfoList error!!,index:");
            paramList.append(i1);
            paramList.append(" size:channelCoverInfoList.size(),msg:");
            paramList.append(paramTabChannelCoverInfo.toString());
            QLog.e("ChannelCoverInfoModule", 1, paramList.toString());
            return true;
          }
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = c(paramInt1, paramInt2);
    if (localChannelCoverInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeChannelCoverInfoFromDBAndCache channelID=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ;channelCoverId = ");
      localStringBuilder.append(paramInt1);
      QLog.i("ChannelCoverInfoModule", 1, localStringBuilder.toString());
      c(localChannelCoverInfo, paramInt2);
      this.mExecutorService.execute(new ChannelCoverInfoModule.4(this, localChannelCoverInfo));
    }
  }
  
  private void b(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.b;
    if (paramInt == 0) {}
    try
    {
      this.c.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      break label151;
      if (paramInt == 56)
      {
        this.d.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (paramInt == 41402)
      {
        this.e.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (this.f.containsKey(Integer.valueOf(paramInt)))
      {
        ((List)this.f.get(Integer.valueOf(paramInt))).add(paramChannelCoverInfo);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramChannelCoverInfo);
        this.f.put(Integer.valueOf(paramInt), localArrayList);
      }
      label151:
      return;
    }
    finally
    {
      label154:
      break label154;
    }
    throw paramChannelCoverInfo;
  }
  
  private void b(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private ChannelCoverInfo c(int paramInt1, int paramInt2)
  {
    Object localObject3 = this.b;
    if (paramInt2 == 0) {}
    try
    {
      localChannelCoverInfo = (ChannelCoverInfo)this.c.get(Integer.valueOf(paramInt1));
    }
    finally
    {
      for (;;)
      {
        ChannelCoverInfo localChannelCoverInfo;
        continue;
        Object localObject2 = null;
      }
    }
    if (paramInt2 == 56)
    {
      localChannelCoverInfo = (ChannelCoverInfo)this.d.get(Integer.valueOf(paramInt1));
    }
    else if (paramInt2 == 41402)
    {
      localChannelCoverInfo = (ChannelCoverInfo)this.e.get(Integer.valueOf(paramInt1));
    }
    else
    {
      if (!this.f.containsKey(Integer.valueOf(paramInt2))) {
        break label131;
      }
      localChannelCoverInfo = a(paramInt1, (List)this.f.get(Integer.valueOf(paramInt2)));
    }
    return localChannelCoverInfo;
    throw localChannelCoverInfo;
  }
  
  private void c(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.b;
    if (paramInt == 0) {}
    try
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == paramChannelCoverInfo.mChannelCoverId)
        {
          localIterator.remove();
          break;
          if (paramInt == 56)
          {
            localIterator = this.d.keySet().iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId);
            localIterator.remove();
          }
          else if (paramInt == 41402)
          {
            localIterator = this.e.keySet().iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId);
            localIterator.remove();
          }
          else if (this.f.containsKey(Integer.valueOf(paramInt)))
          {
            ((List)this.f.get(Integer.valueOf(paramInt))).remove(paramChannelCoverInfo);
          }
        }
      }
      return;
    }
    finally
    {
      label224:
      break label224;
    }
    for (;;)
    {
      throw paramChannelCoverInfo;
    }
  }
  
  public static boolean e(int paramInt)
  {
    boolean bool = false;
    if (!((Boolean)RIJSPUtils.b("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, switch is off.");
      return false;
    }
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localObject1 != null)
    {
      localObject1 = (ReadInJoyLogicManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject1 != null)
      {
        localObject1 = ((ReadInJoyLogicManager)localObject1).getReadInJoyLogicEngine().H();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          TabChannelCoverInfo localTabChannelCoverInfo;
          do
          {
            localObject1 = ((List)localObject1).iterator();
            Object localObject2;
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = ((ChannelSection)((Iterator)localObject1).next()).d;
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
            localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject2).next();
          } while (localTabChannelCoverInfo.mChannelCoverId != paramInt);
          QLog.d("ChannelCoverInfoModule", 1, new Object[] { "isSupportChannelDynamicOrder, name = ", localTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramInt), ", dynamicSort = ", Integer.valueOf(localTabChannelCoverInfo.dynamicSort) });
          if (localTabChannelCoverInfo.dynamicSort == 1) {
            bool = true;
          }
          return bool;
        }
      }
    }
    QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, channel dynamic order is off.");
    return false;
  }
  
  private int f(int paramInt)
  {
    if (paramInt == 0) {
      return this.h;
    }
    if (paramInt == 56) {
      return this.i;
    }
    if (this.g.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.g.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  public static int g()
  {
    return RIJMainChannelUtil.a.c();
  }
  
  private List<ChannelCoverInfo> g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFromDb with selection=");
      localStringBuilder.append("mChannelID = ?");
      localStringBuilder.append(", channelId=");
      localStringBuilder.append(paramInt);
      QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
    }
    return this.mEntityManager.query(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private List<TabChannelCoverInfo> g(List<TabChannelCoverInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i1 = 0;
      while (paramList.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = ((TabChannelCoverInfo)paramList.next()).clone();
        localTabChannelCoverInfo.channelConfigType = paramInt;
        localTabChannelCoverInfo.seq = i1;
        localArrayList.add(localTabChannelCoverInfo);
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  public static String h()
  {
    return RIJMainChannelUtil.a.d();
  }
  
  private List<TabChannelCoverInfo> h(List<ChannelSection> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i1 = 0;
      while (paramList.hasNext())
      {
        ChannelSection localChannelSection = (ChannelSection)paramList.next();
        if ((localChannelSection.d != null) && (!localChannelSection.d.isEmpty()))
        {
          Iterator localIterator = localChannelSection.d.iterator();
          int i2 = i1;
          for (;;)
          {
            i1 = i2;
            if (!localIterator.hasNext()) {
              break;
            }
            TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
            localTabChannelCoverInfo.channelConfigType = localChannelSection.a;
            localTabChannelCoverInfo.seq = i2;
            localArrayList.add(localTabChannelCoverInfo);
            i2 += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List<ChannelSection> i(List<ChannelSection> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i1 = 0;
      while (paramList.hasNext())
      {
        Object localObject = (ChannelSection)paramList.next();
        ChannelSection localChannelSection = new ChannelSection(((ChannelSection)localObject).a, ((ChannelSection)localObject).b, ((ChannelSection)localObject).c);
        localObject = ((ChannelSection)localObject).d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject).next();
          TabChannelCoverInfo localTabChannelCoverInfo2 = localTabChannelCoverInfo1.clone();
          localTabChannelCoverInfo2.channelConfigType = localTabChannelCoverInfo1.channelConfigType;
          localTabChannelCoverInfo2.seq = i1;
          localChannelSection.d.add(localTabChannelCoverInfo2);
          i1 += 1;
        }
        localArrayList.add(localChannelSection);
      }
    }
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> j(List<TabChannelCoverInfo> paramList)
  {
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    Iterator localIterator = ((List)localObject1).iterator();
    List<TabChannelCoverInfo> localList = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    while (localIterator.hasNext())
    {
      paramList = (TabChannelCoverInfo)localIterator.next();
      Object localObject3 = localObject4;
      if (paramList.mChannelCoverId == 0) {
        localObject3 = paramList;
      }
      Object localObject5 = localObject2;
      if (paramList.mChannelCoverId == 70) {
        localObject5 = paramList;
      }
      localObject4 = localObject3;
      localObject2 = localObject5;
      if (paramList.mChannelCoverId == g())
      {
        localList = paramList;
        localObject4 = localObject3;
        localObject2 = localObject5;
      }
    }
    if (localList != null)
    {
      QLog.d("ChannelCoverInfoModule", 1, "configMainChannel not null");
      ((List)localObject1).remove(localList);
    }
    if (localObject4 != null)
    {
      QLog.d("ChannelCoverInfoModule", 1, "recommendChannel not null");
      ((List)localObject1).remove(localObject4);
    }
    ((List)localObject1).add(0, v());
    if (localObject2 != null)
    {
      QLog.d("ChannelCoverInfoModule", 1, "followChannel not null");
      ((List)localObject1).remove(localObject2);
      ((List)localObject1).add(0, localObject2);
    }
    return localObject1;
  }
  
  private void k(List<ChannelSection> paramList)
  {
    if (paramList != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (ChannelSection)paramList.next();
          if (localObject != null)
          {
            localObject = ((ChannelSection)localObject).d;
            if (localObject != null)
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
                if (localTabChannelCoverInfo != null)
                {
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mIconUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mIconUrl, true).downloadImediatly();
                  }
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mChannelCoverPicUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mChannelCoverPicUrl, true).downloadImediatly();
                  }
                }
              }
            }
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("ChannelCoverInfoModule", 1, paramList.getMessage());
      }
    }
  }
  
  private void n()
  {
    try
    {
      localReqBody = new oidb_cmd0xbe6.ReqBody();
      localObject = new oidb_cmd0xbe6.PhoneInfo();
      str = RIJDeviceUtil.a();
      if (!TextUtils.isEmpty(str))
      {
        str = MD5Utils.toMD5(str.toLowerCase()).toLowerCase();
        ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        ((oidb_cmd0xbe6.PhoneInfo)localObject).uint32_muid_type.set(1);
      }
      else
      {
        str = DeviceInfoUtil.d(BaseApplication.getContext());
        if (!TextUtils.isEmpty(str))
        {
          str = MD5Utils.toMD5(str.replaceAll(":", "").toUpperCase()).toLowerCase();
          ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
          ((oidb_cmd0xbe6.PhoneInfo)localObject).uint32_muid_type.set(3);
        }
      }
      i1 = PublicAccountAdUtil.a();
      ((oidb_cmd0xbe6.PhoneInfo)localObject).uint32_conn.set(i1);
      i1 = 0;
    }
    catch (Throwable localThrowable)
    {
      oidb_cmd0xbe6.ReqBody localReqBody;
      String str;
      int i1;
      int i2;
      label149:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestWeiShiChannelCoverListFromServer failed for param error:");
      ((StringBuilder)localObject).append(RIJLogUtil.a(localThrowable));
      QLog.e("ChannelCoverInfoModule", 2, ((StringBuilder)localObject).toString());
      return;
    }
    try
    {
      i2 = DeviceInfoUtil.X();
      i1 = i2;
    }
    catch (Exception localException)
    {
      break label149;
    }
    ((oidb_cmd0xbe6.PhoneInfo)localObject).uint32_carrier.set(i1);
    str = DeviceInfoUtil.g();
    ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
    str = DeviceInfoUtil.e();
    ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
    i1 = AppSetting.d();
    ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i1)));
    str = DatalineMathUtil.a(DatalineMathUtil.a());
    ((oidb_cmd0xbe6.PhoneInfo)localObject).bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
    ((oidb_cmd0xbe6.PhoneInfo)localObject).uint32_os_type.set(2);
    localReqBody.msg_phone_info.set((MessageMicro)localObject, true);
    if ((this.mApp instanceof QQAppInterface)) {
      localReqBody.string_channel_version.set(a((QQAppInterface)this.mApp));
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xbe6", 3046, 1, localReqBody.toByteArray()));
  }
  
  private boolean o()
  {
    int i1 = this.j;
    if (i1 < 3)
    {
      this.j = (i1 + 1);
      return true;
    }
    this.j = 0;
    RIJSPUtils.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
    return false;
  }
  
  private List<ChannelCoverInfo> p()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.c.size());
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.c.get(localInteger));
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private List<ChannelCoverInfo> q()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.d.size());
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.d.get(localInteger));
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private List<ChannelCoverInfo> r()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(this.e.size());
      Iterator localIterator = this.e.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.e.get(localInteger));
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private List<TabChannelCoverInfo> s()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(51, HardCodeUtil.a(2131899772)));
    localArrayList.add(new TabChannelCoverInfo(58, HardCodeUtil.a(2131899760)));
    localArrayList.add(new TabChannelCoverInfo(59, HardCodeUtil.a(2131899759)));
    localArrayList.add(new TabChannelCoverInfo(10, HardCodeUtil.a(2131899762)));
    localArrayList.add(new TabChannelCoverInfo(52, HardCodeUtil.a(2131899774)));
    localArrayList.add(new TabChannelCoverInfo(53, HardCodeUtil.a(2131899757)));
    localArrayList.add(new TabChannelCoverInfo(9, HardCodeUtil.a(2131899766)));
    localArrayList.add(new TabChannelCoverInfo(54, HardCodeUtil.a(2131899752)));
    localArrayList.add(new TabChannelCoverInfo(55, HardCodeUtil.a(2131899754)));
    localArrayList.add(new TabChannelCoverInfo(40007, HardCodeUtil.a(2131899756)));
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb");
    }
    return this.mEntityManager.query(TabChannelCoverInfo.class);
  }
  
  private static String u()
  {
    return RIJMainChannelUtil.a.e();
  }
  
  private static TabChannelCoverInfo v()
  {
    int i1;
    if (g() != -1) {
      i1 = g();
    } else {
      i1 = 0;
    }
    if (!TextUtils.isEmpty(h())) {
      localObject = h();
    } else {
      localObject = HardCodeUtil.a(2131899745);
    }
    Object localObject = new TabChannelCoverInfo(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, i1, (String)localObject, 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0");
    String str = u();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        ((TabChannelCoverInfo)localObject).mChannelJumpUrl = URLDecoder.decode(str, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[getMainChannelInfo], e = ");
        localStringBuilder2.append(localUnsupportedEncodingException);
        QLog.e("ChannelCoverInfoModule", 1, localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[getMainChannelInfo], channelCoverInfo = ");
    localStringBuilder1.append(localObject);
    QLog.i("ChannelCoverInfoModule", 1, localStringBuilder1.toString());
    return localObject;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString("readInJoy_weishi_channel_cover_seq", "");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestRecommendAndMyChannelCoverListFromServer");
    }
    int i1 = 0;
    if ((((Boolean)RIJSPUtils.b("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false))).booleanValue()) && (o()))
    {
      QLog.d("ChannelCoverInfoModule", 2, "requestRecommendAndMyChannelCoverListFromServer, do not refresh because 0xbbc is requesting or request is failed.");
      a(this.l, 3);
      return;
    }
    if (a)
    {
      QLog.d("ChannelCoverInfoModule", 2, "requestRecommendAndMyChannelCoverListFromServer slide channel ,but local data is right ");
      return;
    }
    if (System.currentTimeMillis() / 1000L < this.k) {
      return;
    }
    oidb_cmd0xbbb.ReqBody localReqBody = new oidb_cmd0xbbb.ReqBody();
    localReqBody.bytes_city.set(ByteStringMicro.copyFromUtf8(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCity()));
    localReqBody.str_city.set(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
    Object localObject1 = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(((QQAppInterface)this.mApp).getCurrentUin());
    if (localObject1 != null)
    {
      localReqBody.uint32_age.set(((Friends)localObject1).age);
      localReqBody.uint32_sex.set(((Friends)localObject1).gender);
    }
    localObject1 = new oidb_cmd0xbbb.PhoneInfo();
    Object localObject2 = RIJDeviceUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject2 = ((String)localObject2).toLowerCase();
    }
    try
    {
      localObject2 = MD5Utils.toMD5((String)localObject2).toLowerCase();
      ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    }
    catch (Exception localException1)
    {
      label259:
      int i2;
      break label259;
    }
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_muid.set(ByteStringMicro.copyFromUtf8(""));
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).uint32_muid_type.set(1);
    break label345;
    localObject2 = DeviceInfoUtil.d(BaseApplication.getContext());
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = MD5Utils.toMD5(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
      ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((oidb_cmd0xbbb.PhoneInfo)localObject1).uint32_muid_type.set(3);
    }
    label345:
    i2 = PublicAccountAdUtil.a();
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).uint32_conn.set(i2);
    try
    {
      i2 = DeviceInfoUtil.X();
      i1 = i2;
    }
    catch (Exception localException2)
    {
      label364:
      break label364;
    }
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).uint32_carrier.set(i1);
    localObject2 = DeviceInfoUtil.g();
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = DeviceInfoUtil.e();
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    i1 = AppSetting.d();
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i1)));
    localObject2 = DatalineMathUtil.a(DatalineMathUtil.a());
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    ((oidb_cmd0xbbb.PhoneInfo)localObject1).uint32_os_type.set(2);
    localReqBody.msg_phone_type.set((MessageMicro)localObject1, true);
    localObject1 = ReadInJoyLogicEngine.a().j();
    if (localObject1 != null)
    {
      localObject1 = ((SelectPositionModule)localObject1).b();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestRecommendAndMyChannelCoverListFromServer positionData = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("ChannelCoverInfoModule", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((PositionData)localObject1).city)))
      {
        localObject2 = new oidb_cmd0xbbb.LocationInfo();
        ((oidb_cmd0xbbb.LocationInfo)localObject2).bytes_city.set(ByteStringMicro.copyFromUtf8(((PositionData)localObject1).city));
        ((oidb_cmd0xbbb.LocationInfo)localObject2).bytes_province.set(ByteStringMicro.copyFromUtf8(((PositionData)localObject1).province));
        ((oidb_cmd0xbbb.LocationInfo)localObject2).bytes_country.set(ByteStringMicro.copyFromUtf8(((PositionData)localObject1).country));
        ((oidb_cmd0xbbb.LocationInfo)localObject2).bytes_city_code.set(ByteStringMicro.copyFromUtf8(((PositionData)localObject1).cityCode));
        localReqBody.msg_location_info.set((MessageMicro)localObject2);
      }
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xbbb", 3003, 1, localReqBody.toByteArray()));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    if (paramInt == 41402)
    {
      n();
      return;
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l1 = Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramInt);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(1);
    if (paramInt == 0) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(7L);
    } else if (paramInt == 56) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(3L);
    } else {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(4L);
    }
    int i2 = f(paramInt);
    int i1 = i2;
    if (i2 == 0)
    {
      i1 = i2;
      if (this.mApp != null)
      {
        i1 = i2;
        if ((this.mApp instanceof QQAppInterface)) {
          i1 = a((QQAppInterface)this.mApp, paramInt);
        }
      }
    }
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(i1);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
    if (paramInt == 0) {
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(3));
    } else if (paramInt == 56) {
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(4));
    }
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_channel_id", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updateMainChannelCoverInfo, channelCoverId = ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" ;articleTitle = ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(" ;articleId = ");
      ((StringBuilder)???).append(paramLong);
      QLog.d("ChannelCoverInfoModule", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.b)
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)this.c.get(Integer.valueOf(paramInt));
      if (localChannelCoverInfo != null)
      {
        localChannelCoverInfo.mChannelCoverSummary = paramString;
        localChannelCoverInfo.mArticleId = paramLong;
        a(localChannelCoverInfo, 0);
        f(p(), 0);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("readInJoy_weishi_channel_cover_seq", paramString);
      paramQQAppInterface.commit();
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateChannelCoverSeqConfig, version =");
        paramQQAppInterface.append(paramString);
        QLog.d("ChannelCoverInfoModule", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateChannel: ");
    Object localObject;
    if (paramTabChannelCoverInfo != null) {
      localObject = paramTabChannelCoverInfo.toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
    if (paramTabChannelCoverInfo != null)
    {
      paramTabChannelCoverInfo = paramTabChannelCoverInfo.clone();
      localObject = this.l;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (a(paramTabChannelCoverInfo, ((ChannelSection)((Iterator)localObject).next()).d)) {
            QLog.d("ChannelCoverInfoModule", 2, "updateChannel found in channelCoverInfoList!");
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new ChannelCoverInfoModule.3(this, paramTabChannelCoverInfo));
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbbb.RspBody();
    int i1 = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handle0xbbbGetChannelList, result=");
    paramFromServiceMsg.append(i1);
    QLog.d("ChannelCoverInfoModule", 1, paramFromServiceMsg.toString());
    if (i1 == 0)
    {
      if ((paramToServiceMsg.uint64_next_req_time.has()) && (paramToServiceMsg.uint64_next_req_time.get() > 0L)) {
        this.k = paramToServiceMsg.uint64_next_req_time.get();
      }
      if (paramToServiceMsg.rpt_msg_section.has()) {
        a(paramToServiceMsg.rpt_msg_section.get());
      }
    }
    else
    {
      b(false, null);
    }
  }
  
  public void a(List<channel_button.Section> paramList)
  {
    if (paramList == null) {}
    try
    {
      QLog.d("ChannelCoverInfoModule", 1, "saveChannelSection null");
      return;
    }
    finally
    {
      List localList;
      JSONArray localJSONArray;
      break label230;
    }
    localList = this.l;
    this.l = new ArrayList(paramList.size());
    localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (channel_button.Section)paramList.next();
      ChannelSection localChannelSection = new ChannelSection((channel_button.Section)localObject);
      localJSONArray.put(localChannelSection.a());
      localChannelSection.d = ReadInJoyMSFHandlerUtils.b(((channel_button.Section)localObject).rpt_msg_channel.get());
      this.l.add(localChannelSection);
      localObject = localChannelSection.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveChannelSection ");
      localStringBuilder.append(localChannelSection.a);
      a((List)localObject, localStringBuilder.toString());
    }
    a(this.l, localList);
    c(this.l);
    a(localList, this.l, true);
    if (localJSONArray.length() > 0) {
      ThreadManager.executeOnFileThread(new ChannelCoverInfoModule.12(this, localJSONArray));
    }
    return;
    label230:
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<ChannelSection> paramList, int paramInt)
  {
    QLog.d("ChannelCoverInfoModule", 1, "requestUpdateChannelLists. ");
    Object localObject1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ChannelSection)((Iterator)localObject1).next();
          localObject3 = ((ChannelSection)localObject2).d;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("0xbbc update sectionId=");
          ((StringBuilder)localObject4).append(((ChannelSection)localObject2).a);
          a((List)localObject3, ((StringBuilder)localObject4).toString());
        }
      }
      localObject1 = new oidb_cmd0xbbc.ReqBody();
      localObject2 = new ArrayList();
      Object localObject3 = paramList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ChannelSection)((Iterator)localObject3).next();
        channel_button.Section localSection = new channel_button.Section();
        ArrayList localArrayList = new ArrayList();
        if (((ChannelSection)localObject4).d != null)
        {
          Iterator localIterator = ((ChannelSection)localObject4).d.iterator();
          while (localIterator.hasNext())
          {
            paramList = (TabChannelCoverInfo)localIterator.next();
            channel_button.Channel localChannel = new channel_button.Channel();
            localChannel.uint64_channel_id.set(paramList.mChannelCoverId);
            localChannel.enum_reason.set(paramList.reason);
            PBStringField localPBStringField = localChannel.str_proxy;
            if (TextUtils.isEmpty(paramList.proxy)) {
              paramList = "";
            } else {
              paramList = paramList.proxy;
            }
            localPBStringField.set(paramList);
            localArrayList.add(localChannel);
          }
        }
        if (!localArrayList.isEmpty())
        {
          localSection.uint64_section_id.set(((ChannelSection)localObject4).a);
          localSection.str_section_name.set(((ChannelSection)localObject4).b);
          localSection.str_note_text.set(((ChannelSection)localObject4).c);
          localSection.rpt_msg_channel.set(localArrayList);
          ((List)localObject2).add(localSection);
        }
      }
      ((oidb_cmd0xbbc.ReqBody)localObject1).rpt_msg_section.set((List)localObject2);
      paramList = new oidb_cmd0xbbc.PhoneInfo();
      localObject2 = RIJDeviceUtil.a();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = MD5Utils.toMD5(((String)localObject2).toLowerCase()).toLowerCase();
        paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        paramList.uint32_muid_type.set(1);
      }
      else
      {
        localObject2 = DeviceInfoUtil.d(BaseApplication.getContext());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = MD5Utils.toMD5(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
          paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
          paramList.uint32_muid_type.set(3);
        }
      }
      i1 = PublicAccountAdUtil.a();
      paramList.uint32_conn.set(i1);
      i1 = 0;
    }
    try
    {
      int i2 = DeviceInfoUtil.X();
      i1 = i2;
    }
    catch (Exception localException)
    {
      label518:
      break label518;
    }
    paramList.uint32_carrier.set(i1);
    Object localObject2 = DeviceInfoUtil.g();
    paramList.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = DeviceInfoUtil.e();
    paramList.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    int i1 = AppSetting.d();
    paramList.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i1)));
    localObject2 = DatalineMathUtil.a(DatalineMathUtil.a());
    paramList.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    paramList.uint32_os_type.set(2);
    ((oidb_cmd0xbbc.ReqBody)localObject1).msg_phone_type.set(paramList, true);
    ((oidb_cmd0xbbc.ReqBody)localObject1).uint32_set_type.set(paramInt);
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xbbc", 3004, 1, ((oidb_cmd0xbbc.ReqBody)localObject1).toByteArray()));
    RIJSPUtils.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(true));
    return;
    QLog.d("ChannelCoverInfoModule", 2, "mChannelSectionList is null, do not requestUpdateChannelLists.");
  }
  
  public void a(List<ChannelSection> paramList1, List<ChannelSection> paramList2, boolean paramBoolean)
  {
    if (paramList1 == null) {}
    try
    {
      QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] oldSectionList is null");
      if (paramList2 == null) {
        QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] sectionList is null");
      }
      paramList1 = h(paramList1);
      this.l = i(paramList2);
      paramList2 = h(this.l);
      if (paramBoolean) {
        b(true, ((ChannelSection)this.l.get(0)).d);
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb remove oldList");
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb save newList");
      localIterator = paramList2.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      this.mExecutorService.execute(new ChannelCoverInfoModule.11(this, paramList1, paramList2));
      return;
    }
    finally
    {
      label200:
      break label200;
    }
    for (;;)
    {
      throw paramList1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new ChannelCoverInfoModule.10(this, paramBoolean));
    }
  }
  
  public List<TabChannelCoverInfo> b()
  {
    try
    {
      List localList;
      if ((this.l != null) && (!this.l.isEmpty())) {
        localList = ((ChannelSection)this.l.get(0)).d;
      } else {
        localList = null;
      }
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    try
    {
      List localList;
      if (this.l != null) {
        localList = ((ChannelSection)this.l.get(paramInt)).d;
      } else {
        localList = null;
      }
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbbc.RspBody());
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "handleOxbbcUpChannelList, result = ", Integer.valueOf(i1) });
    if (i1 == 0)
    {
      RIJSPUtils.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
      return;
    }
    QLog.d("ChannelCoverInfoModule", 1, "0xbbcUpChannelList failed.");
  }
  
  public void b(List<oidb_cmd0x69f.ChannelInfo> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder1 = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("saveChannelCoverList channelID=");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append("\n");
        localStringBuilder1 = new StringBuilder(localStringBuilder1.toString());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo1 = ReadInJoyMSFHandlerUtils.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
        if ((localChannelCoverInfo1.mChannelCoverName != null) && (!"".equals(localChannelCoverInfo1.mChannelCoverName)))
        {
          a(localChannelCoverInfo1);
          if ((localChannelCoverInfo1.mChannelCoverSummary == null) || ("".equals(localChannelCoverInfo1.mChannelCoverSummary)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverSummary is null");
            }
            ChannelCoverInfo localChannelCoverInfo2 = c(localChannelCoverInfo1.mChannelCoverId, paramInt);
            if ((localChannelCoverInfo2 != null) && (localChannelCoverInfo2.mChannelCoverSummary != null) && (!"".equals(localChannelCoverInfo2.mChannelCoverSummary)))
            {
              localChannelCoverInfo1.mChannelCoverSummary = localChannelCoverInfo2.mChannelCoverSummary;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("saveChannelCoverList modify coverSummary, summary is ");
                localStringBuilder2.append(localChannelCoverInfo2.mChannelCoverSummary);
                QLog.d("ChannelCoverInfoModule", 2, localStringBuilder2.toString());
              }
            }
          }
          localArrayList.add(localChannelCoverInfo1);
          if ((QLog.isColorLevel()) && (localStringBuilder1 != null))
          {
            localStringBuilder1.append("[channelCoverId=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelCoverId);
            localStringBuilder1.append(", mChannelCoverName=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelCoverName);
            localStringBuilder1.append(", mChannelCoverStyle=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelCoverStyle);
            localStringBuilder1.append(", mChannelCoverSummary=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelCoverSummary);
            localStringBuilder1.append(", mChannelCoverPicUrl=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelCoverPicUrl);
            localStringBuilder1.append(", mChannelJumpUrl=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelJumpUrl);
            localStringBuilder1.append(", mArticleIds=");
            localStringBuilder1.append(localChannelCoverInfo1.mArticleId);
            localStringBuilder1.append(", mChannelType=");
            localStringBuilder1.append(localChannelCoverInfo1.mChannelType);
            localStringBuilder1.append(", isExternalExposure = ");
            localStringBuilder1.append(localChannelCoverInfo1.isExternalExposure);
            localStringBuilder1.append(", externalExposureIcon : ");
            localStringBuilder1.append(localChannelCoverInfo1.externalExposureBackgroundUrl);
            localStringBuilder1.append("]\n");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverName is null, filter this info");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder1 != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder1.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
    }
  }
  
  public List<ChannelCoverInfo> c(int paramInt)
  {
    if (paramInt == 0) {
      return p();
    }
    if (paramInt == 56) {
      return q();
    }
    if (paramInt == 41402) {
      return r();
    }
    if (this.f.containsKey(Integer.valueOf(paramInt))) {
      return new ArrayList((Collection)this.f.get(Integer.valueOf(paramInt)));
    }
    return null;
  }
  
  public void c()
  {
    try
    {
      if (this.l == null)
      {
        this.l = new ArrayList();
        this.l.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, HardCodeUtil.a(2131899746), HardCodeUtil.a(2131899750)));
        this.l.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, HardCodeUtil.a(2131899753), HardCodeUtil.a(2131899763)));
      }
      this.mExecutorService.execute(new ChannelCoverInfoModule.6(this));
      return;
    }
    finally {}
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i4 = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    int i1 = ((Integer)paramToServiceMsg.getAttribute("req_channellist_channel_id", Integer.valueOf(0))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int i2 = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetChannelAndSubscribeList, result=");
    paramFromServiceMsg.append(i2);
    QLog.d("ChannelCoverInfoModule", 1, paramFromServiceMsg.toString());
    if (i2 == 0)
    {
      i1 = -1;
      if (paramToServiceMsg.uint32_req_channel_id.has()) {
        i1 = paramToServiceMsg.uint32_req_channel_id.get();
      }
      if (paramToServiceMsg.uint32_channel_seq.has())
      {
        int i5 = paramToServiceMsg.uint32_channel_seq.get();
        int i3 = f(i1);
        i2 = i3;
        if (i3 == 0)
        {
          i2 = i3;
          if (this.mApp != null)
          {
            i2 = i3;
            if ((this.mApp instanceof QQAppInterface)) {
              i2 = a((QQAppInterface)this.mApp, i1);
            }
          }
        }
        if (i5 <= i2)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetChannelAndSubscribeList, seq is ");
          paramToServiceMsg.append(i5);
          paramToServiceMsg.append(" ;lastseq = ");
          paramToServiceMsg.append(i2);
          paramToServiceMsg.append("; not need to update");
          QLog.d("ChannelCoverInfoModule", 1, paramToServiceMsg.toString());
          return;
        }
        a(i1, i5);
        if ((this.mApp != null) && ((this.mApp instanceof QQAppInterface))) {
          a((QQAppInterface)this.mApp, i5, i1);
        }
      }
      if ((i4 == 3) && (i1 == 0))
      {
        if (paramToServiceMsg.rpt_channel_list.has()) {
          b(paramToServiceMsg.rpt_channel_list.get(), 0);
        }
      }
      else if ((i4 == 4) && (i1 == 56))
      {
        if (paramToServiceMsg.rpt_channel_list.has()) {
          b(paramToServiceMsg.rpt_channel_list.get(), 56);
        }
      }
      else
      {
        if (paramToServiceMsg.rpt_channel_list.has())
        {
          b(paramToServiceMsg.rpt_channel_list.get(), i1);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handle0x69fGetChannelList resp.rpt_channel_list null , channelId = ");
          paramToServiceMsg.append(i1);
          QLog.d("ChannelCoverInfoModule", 2, paramToServiceMsg.toString());
        }
      }
    }
    else
    {
      if (i4 == 3) {
        ReadInJoyLogicEngineEventDispatcher.a().f(false, null);
      } else if (i4 == 4) {
        ReadInJoyLogicEngineEventDispatcher.a().g(false, null);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(i1, false, null);
    }
  }
  
  public void c(List<oidb_cmd0xbe6.MsgChannelInfo> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveChannelCoverList channelID=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("\n");
        localStringBuilder = new StringBuilder(localStringBuilder.toString());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = ReadInJoyMSFHandlerUtils.a((oidb_cmd0xbe6.MsgChannelInfo)paramList.next(), paramInt);
        localArrayList.add(localChannelCoverInfo);
        if ((QLog.isColorLevel()) && (localStringBuilder != null))
        {
          localStringBuilder.append("[channelCoverId=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverId);
          localStringBuilder.append(", mChannelCoverName=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverName);
          localStringBuilder.append(", mChannelCoverStyle=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverStyle);
          localStringBuilder.append(", mChannelCoverSummary=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverSummary);
          localStringBuilder.append(", mChannelCoverPicUrl=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverPicUrl);
          localStringBuilder.append(", mChannelJumpUrl=");
          localStringBuilder.append(localChannelCoverInfo.mChannelJumpUrl);
          localStringBuilder.append(", mArticleIds=");
          localStringBuilder.append(localChannelCoverInfo.mArticleId);
          localStringBuilder.append(", mChannelType=");
          localStringBuilder.append(localChannelCoverInfo.mChannelType);
          localStringBuilder.append(", isExternalExposure = ");
          localStringBuilder.append(localChannelCoverInfo.isExternalExposure);
          localStringBuilder.append(", externalExposureIcon : ");
          localStringBuilder.append(localChannelCoverInfo.externalExposureBackgroundUrl);
          localStringBuilder.append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
    }
  }
  
  public List<TabChannelCoverInfo> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, 0, HardCodeUtil.a(2131899758), 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0"));
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo(56, HardCodeUtil.a(2131899767));
    localTabChannelCoverInfo.reason = 4;
    localTabChannelCoverInfo.mChannelType = 3;
    localArrayList.add(localTabChannelCoverInfo);
    localArrayList.add(new TabChannelCoverInfo(40531, HardCodeUtil.a(2131899769)));
    localArrayList.add(new TabChannelCoverInfo(14, HardCodeUtil.a(2131899755)));
    localArrayList.add(new TabChannelCoverInfo(8, HardCodeUtil.a(2131899771)));
    localArrayList.add(new TabChannelCoverInfo(1, HardCodeUtil.a(2131899761)));
    localArrayList.add(new TabChannelCoverInfo(13, HardCodeUtil.a(2131899748)));
    localArrayList.add(new TabChannelCoverInfo(5, HardCodeUtil.a(2131899776)));
    localArrayList.add(new TabChannelCoverInfo(11, HardCodeUtil.a(2131899747)));
    localArrayList.add(new TabChannelCoverInfo(40466, HardCodeUtil.a(2131899770)));
    localArrayList.add(new TabChannelCoverInfo(40013, HardCodeUtil.a(2131899768)));
    localArrayList.add(new TabChannelCoverInfo(16, HardCodeUtil.a(2131899764)));
    localArrayList.add(new TabChannelCoverInfo(15, HardCodeUtil.a(2131899751)));
    return localArrayList;
  }
  
  public void d(int paramInt)
  {
    this.mExecutorService.execute(new ChannelCoverInfoModule.7(this, paramInt));
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbe6.RspBody();
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      boolean bool2 = this.mApp instanceof QQAppInterface;
      boolean bool1 = true;
      if (bool2)
      {
        bool1 = true ^ TextUtils.equals(a((QQAppInterface)this.mApp), paramToServiceMsg.string_channel_version.get());
        a((QQAppInterface)this.mApp, paramToServiceMsg.string_channel_version.get());
      }
      if ((bool1) && (paramToServiceMsg.msg_get_channel_info_rsp.get() != null) && (paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get() != null)) {
        c(paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get(), 41402);
      }
    }
  }
  
  void d(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)((Iterator)localObject).next();
      localLinkedHashMap.put(Integer.valueOf(localChannelCoverInfo.mChannelCoverId), localChannelCoverInfo);
    }
    localObject = this.b;
    if (paramInt == 0) {}
    try
    {
      this.c.clear();
      this.c.putAll(localLinkedHashMap);
      break label173;
      if (paramInt == 56)
      {
        this.d.clear();
        this.d.putAll(localLinkedHashMap);
      }
      else if (paramInt == 41402)
      {
        this.e.clear();
        this.e.putAll(localLinkedHashMap);
      }
      else
      {
        this.f.remove(Integer.valueOf(paramInt));
        this.f.put(Integer.valueOf(paramInt), new ArrayList(paramList));
      }
      label173:
      return;
    }
    finally
    {
      label177:
      break label177;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public List<ChannelSection> e()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = new StringBuilder();
      Object localObject3 = BaseApplicationImpl.getApplication();
      int i1 = 0;
      ((StringBuilder)localObject2).append(((BaseApplicationImpl)localObject3).getDir("readinjoy", 0).getAbsolutePath());
      ((StringBuilder)localObject2).append("/channel_section_data");
      localObject2 = FileUtils.readFileContent(new File(((StringBuilder)localObject2).toString()));
      if (localObject2 != null) {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          while (i1 < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i1);
            if (localObject3 != null) {
              localArrayList.add(new ChannelSection((JSONObject)localObject3));
            }
            i1 += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void e(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = c(paramInt);
    if ((localObject != null) && (paramList != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveNewAndRemoveOldChannelCoverInfo removeListSize =");
      localStringBuilder.append(((List)localObject).size());
      localStringBuilder.append(" ;addListSize = ");
      localStringBuilder.append(paramList.size());
      QLog.d("ChannelCoverInfoModule", 1, localStringBuilder.toString());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((ChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId, paramInt);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next(), paramInt);
    }
    f(c(paramInt), paramInt);
  }
  
  public List<ChannelSection> f()
  {
    return this.l;
  }
  
  void f(List<ChannelCoverInfo> paramList, int paramInt)
  {
    d(paramList);
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new ChannelCoverInfoModule.9(this, paramInt, paramList));
    }
  }
  
  public void unInitialize()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "unInitialize!");
    }
    synchronized (this.b)
    {
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule
 * JD-Core Version:    0.7.0.1
 */