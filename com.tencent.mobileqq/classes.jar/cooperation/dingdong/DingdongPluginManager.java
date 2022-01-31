package cooperation.dingdong;

import amku;
import amkv;
import amkw;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.FeedConfirmNotifyData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.FeedStateUpdateData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.LastMsgUpdateData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.NodeUpdateData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleChangeNotifyData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleNotificationData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.UnreadNumUpdateData;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.ScheduleReminderMgr;
import cooperation.dingdong.data.ScheduleReminderMgr.onScheduleTipsListener;
import cooperation.dingdong.data.ScheduleTipsDialog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class DingdongPluginManager
  extends DingdongPluginBizObserver
  implements Manager
{
  public static final long a;
  private int jdField_a_of_type_Int;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new amku(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final DingdongPluginRemoteCmdHandler jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler;
  private ScheduleReminderMgr jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  
  static
  {
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  public DingdongPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler = new DingdongPluginRemoteCmdHandler();
    this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr = new ScheduleReminderMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private boolean a(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("actionType", 1);
      if (paramBoolean)
      {
        localJSONObject.put("actionUin", AppConstants.al);
        localJSONObject.put("actionUinType", 9999);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localJSONObject);
      return true;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr.a(null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.al, 9999);
    if (paramInt1 == i) {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongPluginManager", 2, "new unreadNum is the same with current unreadNum[" + i + "].");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.al, 9999, paramInt1 - i);
      a(true);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!QLog.isColorLevel());
    QLog.i("DingdongPluginManager", 2, "setUnreadNum:mCacheUnreadVersion[" + this.jdField_b_of_type_Int + "], mCacheUnreadNum[" + this.jdField_a_of_type_Int + "]");
  }
  
  public void a(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        amkw localamkw = (amkw)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        if (localamkw == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DingdongPluginManager", 2, "updateSystemCalendarForDel del null data ");
          }
          return;
          DingdongPluginBizObserver.ScheduleMoreSummaryData localScheduleMoreSummaryData = new DingdongPluginBizObserver.ScheduleMoreSummaryData();
          Object localObject2 = new DingdongPluginDataFactory.ScheduleSummaryData();
          localScheduleMoreSummaryData.jdField_a_of_type_Long = paramLong;
          ((DingdongPluginDataFactory.ScheduleSummaryData)localObject2).id = localamkw.jdField_a_of_type_JavaLangString;
          localScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = ((DingdongPluginDataFactory.ScheduleSummaryData)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("DingdongPluginManager", 2, "updateSystemCalendarForDel type = " + i);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_schedule_del_data", 0);
          ((SharedPreferences)localObject2).edit().putLong(localamkw.jdField_a_of_type_JavaLangString, localamkw.jdField_b_of_type_Long);
          ((SharedPreferences)localObject2).edit().commit();
          DingdongCalendarSyncUtil.a(i, localScheduleMoreSummaryData);
          return;
        }
      }
      while (localObject1 != null)
      {
        i = localObject1.jdField_a_of_type_Int;
        break;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (!this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr.a()) {
      return;
    }
    paramQQAppInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ScheduleTipsDialog.class);
    paramQQAppInterface.setFlags(335544320);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().startActivity(paramQQAppInterface);
  }
  
  public void a(DingdongPluginBizObserver.FeedConfirmNotifyData paramFeedConfirmNotifyData)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramFeedConfirmNotifyData.jdField_a_of_type_Int == 0) {}
      Object localObject1;
      switch (paramFeedConfirmNotifyData.jdField_c_of_type_Int)
      {
      default: 
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("_source_type_", paramFeedConfirmNotifyData.jdField_b_of_type_Int);
        ((Intent)localObject1).putExtra("_source_id_", paramFeedConfirmNotifyData.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("_from_uin_", paramFeedConfirmNotifyData.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("_changed_type_", paramFeedConfirmNotifyData.jdField_c_of_type_Int);
        ((Intent)localObject1).putExtra("_feed_id_", paramFeedConfirmNotifyData.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("_push_proto_", 1);
        DingdongPluginHelper.a(1, (Intent)localObject1);
        if (DingdongPluginHelper.a()) {
          QQToast.a(BaseApplication.getContext(), "事项确认变化push，errCode[" + paramFeedConfirmNotifyData.jdField_a_of_type_Int + "].", 1).a();
        }
        return;
      }
      boolean bool2 = false;
      String str;
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramFeedConfirmNotifyData.d))
      {
        str = DingdongPluginHelper.a(paramFeedConfirmNotifyData.jdField_b_of_type_Int, paramFeedConfirmNotifyData.jdField_b_of_type_JavaLangString, paramFeedConfirmNotifyData.jdField_c_of_type_JavaLangString) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131427861);
        bool1 = bool2;
        localObject1 = str;
        if (2 == paramFeedConfirmNotifyData.jdField_c_of_type_Int)
        {
          localObject1 = str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131427860);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131427863);
        int i = ((String)localObject1).lastIndexOf(str);
        Object localObject2 = "mqqapi://asyncmsg/showdetail?src_type=internal&version=1&feedsid=" + paramFeedConfirmNotifyData.jdField_a_of_type_JavaLangString + "&fsc=" + paramFeedConfirmNotifyData.jdField_b_of_type_JavaLangString + "&fst=" + paramFeedConfirmNotifyData.jdField_b_of_type_Int;
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 3);
        localBundle.putString("key_action_DATA", (String)localObject2);
        localBundle.putString("key_a_action_DATA", (String)localObject2);
        localObject2 = (MessageForGrayTips)MessageRecordFactory.a(-2034);
        ((MessageForGrayTips)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFeedConfirmNotifyData.jdField_b_of_type_JavaLangString, paramFeedConfirmNotifyData.jdField_c_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTime(), -2034, DingdongPluginHelper.b(paramFeedConfirmNotifyData.jdField_b_of_type_Int), 0L);
        ((MessageForGrayTips)localObject2).msg = ((String)localObject1);
        ((MessageForGrayTips)localObject2).addHightlightItem(i, str.length() + i, localBundle);
        ((MessageForGrayTips)localObject2).isread = bool1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break;
        bool1 = true;
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131427862), new Object[] { DingdongPluginHelper.a(paramFeedConfirmNotifyData.jdField_b_of_type_Int, paramFeedConfirmNotifyData.jdField_b_of_type_JavaLangString, paramFeedConfirmNotifyData.d) });
      }
    }
    QLog.e("DingdongPluginManager", 1, "onFeedConfirmNotify error: manager has been destroyed!");
  }
  
  public void a(DingdongPluginBizObserver.FeedStateUpdateData paramFeedStateUpdateData)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramFeedStateUpdateData.jdField_a_of_type_Int == 0) {
        switch (paramFeedStateUpdateData.jdField_c_of_type_Int)
        {
        }
      }
      for (;;)
      {
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("_source_type_", paramFeedStateUpdateData.jdField_b_of_type_Int);
        ((Intent)localObject).putExtra("_source_id_", paramFeedStateUpdateData.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("_from_uin_", paramFeedStateUpdateData.jdField_c_of_type_JavaLangString);
        ((Intent)localObject).putExtra("_changed_type_", paramFeedStateUpdateData.jdField_c_of_type_Int);
        ((Intent)localObject).putExtra("_feed_id_", paramFeedStateUpdateData.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("_del_index_list_", paramFeedStateUpdateData.jdField_a_of_type_JavaUtilArrayList);
        ((Intent)localObject).putExtra("_push_proto_", 2);
        DingdongPluginHelper.a(1, (Intent)localObject);
        if (DingdongPluginHelper.a()) {
          QQToast.a(BaseApplication.getContext(), "事项状态变化push，errCode[" + paramFeedStateUpdateData.jdField_a_of_type_Int + "].", 1).a();
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramFeedStateUpdateData.jdField_c_of_type_JavaLangString)) && (6 == paramFeedStateUpdateData.jdField_c_of_type_Int))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131427864);
          MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-2034);
          localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFeedStateUpdateData.jdField_b_of_type_JavaLangString, paramFeedStateUpdateData.jdField_c_of_type_JavaLangString, (String)localObject, NetConnInfoCenter.getServerTime(), -2034, DingdongPluginHelper.b(paramFeedStateUpdateData.jdField_b_of_type_Int), 0L);
          localMessageForGrayTips.msg = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
    }
    QLog.e("DingdongPluginManager", 1, "onFeedStateUpdate error: manager has been destroyed!");
  }
  
  public void a(DingdongPluginBizObserver.NodeUpdateData paramNodeUpdateData)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if ((paramNodeUpdateData.jdField_a_of_type_Int == 0) && (((paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData == null) || (paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData.jdField_a_of_type_Int != 0)) || ((paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData != null) && (paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData.jdField_a_of_type_Int == 0)))) {
        a(paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData.jdField_b_of_type_Int, paramNodeUpdateData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData.jdField_c_of_type_Int);
      }
      if (DingdongPluginHelper.a()) {
        QQToast.a(BaseApplication.getContext(), "节点数据更新，errCode[" + paramNodeUpdateData.jdField_a_of_type_Int + "].", 1).a();
      }
      return;
    }
    QLog.e("DingdongPluginManager", 1, "onLastMessageUpdate error: manager has been destroyed!");
  }
  
  public void a(DingdongPluginBizObserver.ScheduleChangeNotifyData paramScheduleChangeNotifyData)
  {
    if (paramScheduleChangeNotifyData.jdField_a_of_type_Int == 0) {
      switch (paramScheduleChangeNotifyData.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      super.a(paramScheduleChangeNotifyData);
      return;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        int i = paramScheduleChangeNotifyData.jdField_b_of_type_Int;
        DingdongPluginBizObserver.ScheduleMoreSummaryData localScheduleMoreSummaryData = new DingdongPluginBizObserver.ScheduleMoreSummaryData();
        DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
        localScheduleSummaryData.id = paramScheduleChangeNotifyData.jdField_a_of_type_JavaLangString;
        localScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = localScheduleSummaryData;
        DingdongCalendarSyncUtil.a(i, localScheduleMoreSummaryData);
      }
    }
  }
  
  public void a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    amkw localamkw;
    if (paramScheduleMoreSummaryData != null)
    {
      localamkw = (amkw)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramScheduleMoreSummaryData.jdField_a_of_type_Long));
      if (localamkw != null) {
        break label83;
      }
    }
    label83:
    for (int i = 0;; i = localamkw.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongPluginManager", 2, "onGetScheduleDetailNotify type = " + i);
      }
      new amkv(this, i, localamkw).execute(new DingdongPluginBizObserver.ScheduleMoreSummaryData[] { paramScheduleMoreSummaryData });
      return;
    }
  }
  
  public void a(DingdongPluginBizObserver.ScheduleNotificationData paramScheduleNotificationData)
  {
    if ((paramScheduleNotificationData.jdField_a_of_type_Int == 0) && (paramScheduleNotificationData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData != null))
    {
      if (paramScheduleNotificationData.jdField_a_of_type_Boolean == true) {
        this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr.a(paramScheduleNotificationData);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr.b(paramScheduleNotificationData);
  }
  
  public void a(DingdongPluginBizObserver.UnreadNumUpdateData paramUnreadNumUpdateData)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramUnreadNumUpdateData.jdField_a_of_type_Int == 0) {
        a(paramUnreadNumUpdateData.jdField_b_of_type_Int, paramUnreadNumUpdateData.jdField_c_of_type_Int);
      }
      if (DingdongPluginHelper.a()) {
        QQToast.a(BaseApplication.getContext(), "未读数变化push，errCode[" + paramUnreadNumUpdateData.jdField_a_of_type_Int + "].", 1).a();
      }
      return;
    }
    QLog.e("DingdongPluginManager", 1, "onUnreadNumUpdate error: manager has been destroyed!");
  }
  
  public void a(MessageForDingdongSchedule paramMessageForDingdongSchedule, long paramLong)
  {
    int i = paramMessageForDingdongSchedule.notificationType;
    paramMessageForDingdongSchedule = paramMessageForDingdongSchedule.getSummaryData();
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginManager", 2, "updateSystemCalendar type = " + i + " summaryData =" + paramMessageForDingdongSchedule);
    }
    amkw localamkw = new amkw(this, null);
    long l = this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = (1L + l);
    localamkw.jdField_a_of_type_Long = l;
    localamkw.jdField_a_of_type_Int = i;
    localamkw.jdField_b_of_type_Long = paramLong;
    localamkw.jdField_a_of_type_JavaLangString = paramMessageForDingdongSchedule.id;
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localamkw.jdField_a_of_type_Long), localamkw);
    ((DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75)).a(localamkw.jdField_a_of_type_Long, paramMessageForDingdongSchedule.id);
  }
  
  public void a(ScheduleReminderMgr.onScheduleTipsListener paramonScheduleTipsListener)
  {
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr.a(paramonScheduleTipsListener);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    DingdongPluginHelper.a(5, localIntent);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    localIntent.putExtra("_from_uin_", String.valueOf(paramLong));
    localIntent.putExtra("_source_type_", paramInt);
    DingdongPluginHelper.a(2, localIntent);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (!paramBoolean3) {
        ((DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75)).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.al, 9999, paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void b()
  {
    ((DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75)).b();
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    DingdongPluginHelper.a(7, localIntent);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginManager", 2, "updateSystemCalendar type = " + paramInt + " id =" + paramString);
    }
    amkw localamkw = new amkw(this, null);
    long l = this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = (1L + l);
    localamkw.jdField_a_of_type_Long = l;
    localamkw.jdField_a_of_type_Int = paramInt;
    localamkw.jdField_b_of_type_Long = paramLong;
    localamkw.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localamkw.jdField_a_of_type_Long), localamkw);
    ((DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75)).a(localamkw.jdField_a_of_type_Long, paramString);
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("_source_id_", paramString);
    DingdongPluginHelper.a(6, localIntent);
  }
  
  public void d(String paramString)
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    if ((str != null) && (!str.equalsIgnoreCase(paramString)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("_uin_", paramString);
      localIntent.putExtra("_nick_", str);
      DingdongPluginHelper.a(4, localIntent);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginManager
 * JD-Core Version:    0.7.0.1
 */