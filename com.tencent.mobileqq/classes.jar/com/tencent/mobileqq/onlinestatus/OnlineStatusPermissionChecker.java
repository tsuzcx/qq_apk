package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class OnlineStatusPermissionChecker
{
  public static OnlineStatusPermissionChecker.OnlineStatusPermissionItem a(Intent paramIntent, int paramInt, Context paramContext, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramAppRuntime == null) {
        return null;
      }
      boolean bool = QLog.isColorLevel();
      int i = 0;
      if (bool) {
        QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error responseCode=", Integer.valueOf(paramInt), " data=", paramIntent });
      }
      if (paramInt == -1) {
        paramAppRuntime = "0X800AE77";
      } else {
        paramAppRuntime = "0X800AE78";
      }
      ReportController.b(null, "dc00898", "", "", paramAppRuntime, paramAppRuntime, 0, 0, "", "", "", "");
      if (paramInt == -1)
      {
        if (paramIntent == null) {
          return null;
        }
        paramAppRuntime = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
        Object localObject = paramIntent.getParcelableArrayListExtra("result_set");
        if ((paramAppRuntime != null) && (localObject != null) && (((ArrayList)localObject).size() != 0))
        {
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
          OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$002(paramAppRuntime, false);
          OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$102(paramAppRuntime, paramIntent);
          if (paramBoolean) {
            a(paramContext, paramAppRuntime);
          }
          return paramAppRuntime;
        }
        if (QLog.isColorLevel())
        {
          if (localObject == null) {
            paramInt = i;
          } else {
            paramInt = ((ArrayList)localObject).size();
          }
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error onlineItem=", paramAppRuntime, " friendlistSize=", Integer.valueOf(paramInt) });
        }
      }
    }
    return null;
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  public static void a(Context paramContext, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.online);
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$200(paramOnlineStatusPermissionItem));
    QPublicFragmentActivity.start(paramContext, localIntent, AccountOnlineStateActivity.class);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$100(paramOnlineStatusPermissionItem).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      ResultRecord localResultRecord = new ResultRecord();
      localResultRecord.uin = String.valueOf(localLong);
      localArrayList.add(a(localResultRecord.uin, "", 0, "-1"));
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("param_only_friends", true);
    ((Bundle)localObject).putParcelableArrayList("param_selected_records_for_create_discussion", localArrayList);
    ((Bundle)localObject).putInt("param_entrance", 40);
    ((Bundle)localObject).putBoolean("param_add_passed_members_to_result_set", true);
    ((Bundle)localObject).putInt("param_max", 1000);
    ((Bundle)localObject).putString("param_title", paramActivity.getString(2131896402));
    ((Bundle)localObject).putSerializable("online_status_permission_item", paramOnlineStatusPermissionItem);
    ((Bundle)localObject).putString("param_done_button_wording", paramActivity.getString(2131896403));
    ((Bundle)localObject).putString("param_done_button_highlight_wording", paramActivity.getString(2131896404));
    paramOnlineStatusPermissionItem = new ArrayList(1);
    ((Bundle)localObject).putStringArrayList("param_uins_hide", paramOnlineStatusPermissionItem);
    ((Bundle)localObject).putBoolean("filer_robot", true);
    paramOnlineStatusPermissionItem.add(paramAppRuntime.getCurrentAccountUin());
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, (Bundle)localObject, 100);
    if (paramBoolean) {
      paramActivity.overridePendingTransition(2130771996, 2130771997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker
 * JD-Core Version:    0.7.0.1
 */