package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardLbsHBOption
  extends ForwardBaseOption
{
  public ForwardLbsHBOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 31);
    Intent localIntent = new Intent();
    localIntent.putExtra("k_forward_title", paramString);
    localIntent.putExtra("extra_select_all_frd", paramBoolean);
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(paramActivity, localIntent, paramInt);
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
    this.jdField_a_of_type_JavaUtilSet.add(l);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_select_all_frd", true)) {
      this.jdField_a_of_type_JavaUtilSet.add(n);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    paramInt = paramBundle.getInt("uintype");
    String str = paramBundle.getString("uin");
    if ("-1".equals(str)) {
      paramBundle.putString("uinname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438768));
    }
    Object localObject;
    if (paramInt == 1)
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str);
      if (localObject != null) {
        paramBundle.putInt("forward_extra", ((TroopInfo)localObject).wMemberNum);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "buildForwardDialog uinType:" + paramInt + " uin:" + str);
      }
      localIntent.putExtras(paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      if (paramInt == 3000)
      {
        localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        int i = ((DiscussionManager)localObject).a(str);
        localObject = ((DiscussionManager)localObject).a(str);
        paramBundle.putInt("forward_extra", i);
        paramBundle.putString("uinname", ((DiscussionInfo)localObject).discussionName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardLbsHBOption
 * JD-Core Version:    0.7.0.1
 */