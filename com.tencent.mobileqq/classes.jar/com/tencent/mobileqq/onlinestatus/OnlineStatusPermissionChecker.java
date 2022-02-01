package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import bdla;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class OnlineStatusPermissionChecker
{
  public static OnlineStatusPermissionChecker.OnlineStatusPermissionItem a(Intent paramIntent, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      paramIntent = null;
    }
    label177:
    do
    {
      return paramIntent;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error responseCode=", Integer.valueOf(paramInt), " data=", paramIntent });
      }
      if (paramInt == -1) {}
      for (paramQQAppInterface = "0X800AE77";; paramQQAppInterface = "0X800AE78")
      {
        bdla.b(null, "dc00898", "", "", paramQQAppInterface, paramQQAppInterface, 0, 0, "", "", "", "");
        if ((paramInt == -1) && (paramIntent != null)) {
          break;
        }
        return null;
      }
      paramQQAppInterface = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
      Object localObject = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramQQAppInterface == null) || (localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        if (QLog.isColorLevel()) {
          if (localObject != null) {
            break label177;
          }
        }
        for (paramInt = 0;; paramInt = ((ArrayList)localObject).size())
        {
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error onlineItem=", paramQQAppInterface, " friendlistSize=", Integer.valueOf(paramInt) });
          return null;
        }
      }
      paramIntent = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        paramIntent.add(Long.valueOf(localResultRecord.uin));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param uin=", localResultRecord.uin });
        }
      }
      OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$002(paramQQAppInterface, false);
      OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$102(paramQQAppInterface, paramIntent);
      paramIntent = paramQQAppInterface;
    } while (!paramBoolean);
    a(paramContext, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.online);
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$200(paramOnlineStatusPermissionItem));
    PublicFragmentActivity.a(paramContext, localIntent, AccountOnlineStateActivity.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$100(paramOnlineStatusPermissionItem).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      ResultRecord localResultRecord = new ResultRecord();
      localResultRecord.uin = String.valueOf(localLong);
      localArrayList.add(SelectMemberActivity.constructAResultRecord(localResultRecord.uin, "", 0, "-1"));
    }
    localObject = new Intent(paramActivity, SelectMemberActivity.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("param_only_friends", true);
    ((Intent)localObject).putExtra("param_selected_records_for_create_discussion", localArrayList);
    ((Intent)localObject).putExtra("param_entrance", 40);
    ((Intent)localObject).putExtra("param_add_passed_members_to_result_set", true);
    ((Intent)localObject).putExtra("param_max", 1000);
    ((Intent)localObject).putExtra("param_title", paramActivity.getString(2131698121));
    ((Intent)localObject).putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    ((Intent)localObject).putExtra("param_done_button_wording", paramActivity.getString(2131698122));
    ((Intent)localObject).putExtra("param_done_button_highlight_wording", paramActivity.getString(2131698123));
    paramOnlineStatusPermissionItem = new ArrayList(1);
    ((Intent)localObject).putStringArrayListExtra("param_uins_hide", paramOnlineStatusPermissionItem);
    ((Intent)localObject).putExtra("filer_robot", true);
    paramOnlineStatusPermissionItem.add(paramQQAppInterface.getCurrentAccountUin());
    paramActivity.startActivityForResult((Intent)localObject, 100);
    if (paramBoolean) {
      paramActivity.overridePendingTransition(2130771979, 2130771980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker
 * JD-Core Version:    0.7.0.1
 */