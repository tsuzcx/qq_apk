package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardApolloActionSendOption
  extends ForwardBaseOption
{
  public ForwardApolloActionSendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && ((localRecentUser.type == 0) || (localRecentUser.type == 1))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("apollo_forward_key", true);
    this.jdField_a_of_type_AndroidOsBundle.putInt("apollo_actionid_key", paramBundle.getInt("apollo_actionid_key"));
    this.jdField_a_of_type_AndroidOsBundle.putInt("apollo_pkgid_key", paramBundle.getInt("apollo_pkgid_key"));
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    this.jdField_a_of_type_AndroidContentIntent = AIOUtils.a(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public boolean a()
  {
    super.a();
    return true;
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardApolloActionSendOption
 * JD-Core Version:    0.7.0.1
 */