package cooperation.dingdong;

import QQService.AddDiscussMemberInfo;
import alut;
import aluv;
import aluw;
import alux;
import aluy;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.OfficeCenterConfigLoader;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class DingdongPluginRemoteCmdHandler
{
  private int jdField_a_of_type_Int = 0;
  private aluy jdField_a_of_type_Aluy = new aluy(this);
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new alux(this);
  private RemoteCommand jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand = new alut(this, "dingDongRemoteCmd");
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  private int a(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle1.getInt("_attachment_count");
    int i = paramBundle1.getInt("_source_type_");
    paramBundle2 = paramBundle1.getString("_source_id_");
    Object localObject1 = paramBundle1.getString("_feed_id_");
    paramBundle1.getString("_from_uin_");
    paramBundle1.getString("_concern_uin_list_str_");
    paramBundle1 = paramBundle1.getString("_feed_brief_");
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    localObject1 = "mqqapi://asyncmsg/showdetail?src_type=internal&version=1&feedsid=" + (String)localObject1 + "&fsc=" + paramBundle2 + "&fst=" + i;
    localObject1 = ((AbsShareMsg.Builder)localObject2).b(61).a(BaseApplicationImpl.getApplication().getString(2131427943) + paramBundle1).a(11).a("plugin", "", (String)localObject1, "", "").b(BaseApplicationImpl.getApplication().getString(2131427942)).a();
    localObject2 = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject2).a(BaseApplicationImpl.getApplication().getString(2131427945), BaseApplicationImpl.getApplication().getString(2131427941), paramBundle1, 0);
    paramBundle1 = new StructMsgItemLayout6();
    paramBundle1.a(new StructMsgItemHr());
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    ((AbsShareMsg)localObject1).addItem(paramBundle1);
    ShareMsgHelper.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle2, paramBundle2, DingdongPluginHelper.b(i), (AbsStructMsg)localObject1, null);
    return 0;
  }
  
  private void a(int paramInt)
  {
    Looper localLooper = Looper.getMainLooper();
    if (localLooper != Looper.myLooper())
    {
      new Handler(localLooper).post(new aluw(this, paramInt));
      return;
    }
    b(paramInt);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    String str1 = paramString;
    for (;;)
    {
      try
      {
        if (paramString.getBytes("utf-8").length > 48)
        {
          int j = paramString.length();
          i = 1;
          str1 = paramString;
          if (i <= j)
          {
            if (paramString.substring(0, i).getBytes("utf-8").length <= 48) {
              continue;
            }
            str1 = paramString.substring(0, i - 1);
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        String str2 = paramString;
        continue;
      }
      paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.a(6);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramLong, str1);
      }
      return;
      i += 1;
    }
  }
  
  private int b(Bundle paramBundle1, Bundle paramBundle2)
  {
    int i = paramBundle1.getInt("_source_type_");
    Object localObject = paramBundle1.getString("_source_id_");
    String str = paramBundle1.getString("_create_uin_");
    TroopGagMgr localTroopGagMgr;
    if (1 == i)
    {
      paramBundle1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localTroopGagMgr = (TroopGagMgr)paramBundle1.getManager(47);
      if (localTroopGagMgr.a((String)localObject, str)) {
        paramBundle1 = paramBundle1.getApplication().getString(2131427878);
      }
    }
    for (;;)
    {
      if (paramBundle1 != null) {
        paramBundle2.putString("_create_err_msg_", paramBundle1);
      }
      return 0;
      localObject = localTroopGagMgr.a((String)localObject);
      if ((localObject != null) && (((TroopGagMgr.TroopGagInfo)localObject).jdField_a_of_type_Long > 0L)) {
        paramBundle1 = paramBundle1.getApplication().getString(2131427879);
      } else {
        paramBundle1 = null;
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      QLog.e("DingdongPluginRemoteCmdHandler", 1, "handleDiscussCreate2 fatal error, app is null");
    }
    Object localObject2;
    do
    {
      return;
      if (paramInt == 0)
      {
        long l = this.jdField_a_of_type_Aluy.jdField_a_of_type_Long;
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("reqCode", 5);
        if (l > 0L) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject5).putExtra("isSuccess", bool);
          ((Intent)localObject5).putExtra("roomId", this.jdField_a_of_type_Aluy.jdField_a_of_type_Long);
          ((Intent)localObject5).putExtra("createdFlag", 0);
          ((Intent)localObject5).putExtra("discuss_create_reason", this.b);
          if (l > 0L)
          {
            localObject2 = ContactUtils.c(localQQAppInterface, l + "");
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (!((String)localObject2).equals("")) {}
            }
            else
            {
              localObject1 = l + "";
            }
            ((Intent)localObject5).putExtra("discussName", (String)localObject1);
          }
          if (this.jdField_a_of_type_Int != 1) {
            break;
          }
          DingdongPluginHelper.a(10, (Intent)localObject5);
          return;
        }
        DingdongPluginHelper.a(2, (Intent)localObject5);
        return;
      }
    } while (paramInt != 1);
    if (!this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_Boolean = true;
    }
    Object localObject5 = new ArrayList();
    Object localObject1 = ContactUtils.j(localQQAppInterface, localQQAppInterface.getCurrentAccountUin());
    FriendsManager localFriendsManager = (FriendsManager)localQQAppInterface.getManager(50);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    ResultRecord localResultRecord;
    String str;
    if (paramInt >= 0)
    {
      localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject2 = new AddDiscussMemberInfo();
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        ((ArrayList)localObject5).add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label543;
        }
        localObject1 = localFriendsManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject1 == null) {
          break label867;
        }
        localObject1 = ((Friends)localObject1).name;
      }
    }
    for (;;)
    {
      label426:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        for (;;)
        {
          paramInt -= 1;
          break;
          try
          {
            ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
            ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DingdongPluginRemoteCmdHandler", 2, "doCreateDiscussForDingdong, NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
            }
          }
        }
        continue;
        label543:
        Object localObject6;
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localObject6 = DBUtils.a().a(localQQAppInterface, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localNumberFormatException;
          if (localObject6 == null) {
            break label426;
          }
          localObject1 = localNumberFormatException;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject6).friendnick)) {
            break label426;
          }
          localObject1 = ((TroopMemberInfo)localObject6).friendnick;
          break label426;
        }
        if (localResultRecord.jdField_a_of_type_Int == 2)
        {
          localObject6 = ((DiscussionManager)localQQAppInterface.getManager(52)).a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localNumberFormatException;
          if (localObject6 == null) {
            break label426;
          }
          localObject1 = localNumberFormatException;
          if (((DiscussionMemberInfo)localObject6).inteRemark == null) {
            break label426;
          }
          localObject1 = localNumberFormatException;
          if (((DiscussionMemberInfo)localObject6).inteRemark.length() <= 0) {
            break label426;
          }
          localObject1 = ((DiscussionMemberInfo)localObject6).inteRemark;
          break label426;
        }
        if (localResultRecord.jdField_a_of_type_Int == 3)
        {
          localObject1 = localResultRecord.b;
          break label426;
        }
        localObject1 = localNumberFormatException;
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label426;
        }
        localObject1 = localResultRecord.b;
        break label426;
        localObject1 = str + (String)localObject1;
      }
      Object localObject3 = localObject1;
      for (;;)
      {
        try
        {
          if (((String)localObject1).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject1).length();
            paramInt = i;
            localObject3 = localObject1;
            if (paramInt <= j)
            {
              if (((String)localObject1).substring(0, paramInt).getBytes("utf-8").length <= 48) {
                continue;
              }
              localObject3 = ((String)localObject1).substring(0, paramInt - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Object localObject4 = localObject1;
          continue;
        }
        localObject1 = (DiscussionHandler)localQQAppInterface.a(6);
        if (localObject1 == null) {
          break;
        }
        ((DiscussionHandler)localObject1).a((String)localObject3, (ArrayList)localObject5, 1004);
        return;
        paramInt += 1;
      }
      label867:
      localObject1 = null;
    }
  }
  
  private int c(Bundle paramBundle1, Bundle paramBundle2)
  {
    int i = paramBundle1.getInt("_req_code_", 0);
    if (i == 1) {
      OfficeCenterConfigLoader.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    do
    {
      do
      {
        return 0;
        if (i == 2)
        {
          paramBundle1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + paramBundle1.getLongAccountUin(), false);
          ((DingdongPluginBizHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(75)).a(5, false, null);
          return 0;
        }
      } while (i != 3);
      paramBundle1 = paramBundle1.getLongArray("_troop_uin_long_array_");
    } while ((paramBundle1 == null) || (paramBundle1.length <= 0));
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBundle2 = new long[paramBundle1.length];
    i = 0;
    while (i < paramBundle1.length)
    {
      paramBundle2[i] = 0L;
      Iterator localIterator = ((TroopManager)((QQAppInterface)localObject).getManager(51)).a().iterator();
      while (localIterator.hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
        if ((localTroopInfo != null) && (localTroopInfo.troopuin.equals(paramBundle1[i] + ""))) {
          paramBundle2[i] = 1L;
        }
      }
      i += 1;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("reqCode", 6);
    ((Intent)localObject).putExtra("_troop_uin_long_array_", paramBundle1);
    ((Intent)localObject).putExtra("_troop_FLAG_long_array_", paramBundle2);
    DingdongPluginHelper.a(2, (Intent)localObject);
    return 0;
  }
  
  private int d(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (!this.jdField_a_of_type_Aluy.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle1.getParcelableArrayList("resultRecords");
      this.jdField_a_of_type_JavaLangString = paramBundle1.getString("discussName");
      this.b = paramBundle1.getInt("discuss_create_reason");
      this.jdField_a_of_type_Int = paramBundle1.getInt("discuss_create_form", 0);
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        return 1;
      }
      this.jdField_a_of_type_Aluy.a(this.jdField_a_of_type_JavaUtilArrayList);
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginRemoteCmdHandler", 2, "doCreateDiscussForDingdong, is running!!!");
    }
    return 1;
  }
  
  private int e(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Int = paramBundle1.getInt("discuss_create_form", 0);
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle1.getParcelableArrayList("resultRecords");
    this.jdField_a_of_type_JavaLangString = paramBundle1.getString("discussName");
    String str = paramBundle1.getString("discussRoomId");
    if (TextUtils.isEmpty(str)) {}
    QQAppInterface localQQAppInterface;
    DiscussionManager localDiscussionManager;
    for (long l = 0L;; l = Long.valueOf(str).longValue())
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localDiscussionManager = (DiscussionManager)localQQAppInterface.getManager(52);
      if (localDiscussionManager.a(str, localQQAppInterface.getCurrentAccountUin()) != null) {
        break;
      }
      paramBundle1.putInt("discuss_create_reason", 2);
      d(paramBundle1, paramBundle2);
      return 0;
    }
    new aluv(this, localDiscussionManager, str, l, localQQAppInterface).execute(new Void[] { null, null, null });
    return 0;
  }
  
  private int f(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle1 = paramBundle1.getString("_uin_");
    if (paramBundle1 != null) {
      ((DingdongPluginManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(114)).d(paramBundle1);
    }
    return 0;
  }
  
  private int g(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle2 = paramBundle1.getString("_source_id_");
    int i = paramBundle1.getInt("_source_type_");
    long l = paramBundle1.getLong("_operation_time_");
    ((DingdongPluginManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(114)).b(paramBundle2, i, l);
    return 0;
  }
  
  @TargetApi(23)
  private int h(Bundle paramBundle1, Bundle paramBundle2)
  {
    bool2 = true;
    paramBundle1 = BaseApplicationImpl.getContext().getApplicationContext().getPackageName();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 23) {
          continue;
        }
        AppOpsManager localAppOpsManager = (AppOpsManager)BaseApplicationImpl.getContext().getSystemService("appops");
        int j = BaseApplicationImpl.getContext().getApplicationInfo().uid;
        int i = localAppOpsManager.noteOpNoThrow("android:write_calendar", j, paramBundle1);
        j = localAppOpsManager.noteOpNoThrow("android:read_calendar", j, paramBundle1);
        if ((i != 0) || (j != 0)) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramBundle1)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("hasCalendarPermission", 2, "checkPermission failed");
        bool1 = bool2;
        continue;
      }
      paramBundle2.putBoolean("calendar_check_permission", bool1);
      return 0;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  public Bundle a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    long l = paramBundle.getLong("_cmd_seq_");
    int k = paramBundle.getInt("_inner_cmd_");
    int j = 1;
    Bundle localBundle = new Bundle();
    localBundle.putLong("_cmd_seq_", l);
    int i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (paramOnInvokeFinishLinstener != null) {
        paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
      }
      localBundle.putLong("_cmd_seq_", l);
      localBundle.putInt("_result_code_", i);
      return localBundle;
      i = a(paramBundle, localBundle);
      continue;
      i = b(paramBundle, localBundle);
      continue;
      i = c(paramBundle, localBundle);
      continue;
      i = d(paramBundle, localBundle);
      continue;
      i = e(paramBundle, localBundle);
      continue;
      i = f(paramBundle, localBundle);
      continue;
      i = g(paramBundle, localBundle);
      continue;
      i = h(paramBundle, localBundle);
    }
  }
  
  public void a()
  {
    if (!PluginCommunicationHandler.getInstance().containsCmd("dingDongRemoteCmd")) {
      PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginRemoteCmdHandler
 * JD-Core Version:    0.7.0.1
 */