package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import aupt;
import bdla;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Set;

public class ForwardEmojiPacketSendOption
  extends aupt
{
  int e;
  
  public ForwardEmojiPacketSendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void a()
  {
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (q()) {
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
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    this.jdField_a_of_type_AndroidContentIntent = AIOUtils.setOpenAIOIntent(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
    this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
  }
  
  public boolean a()
  {
    super.a();
    this.e = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    return true;
  }
  
  public void c()
  {
    super.c();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardEmojiPacketSendOption
 * JD-Core Version:    0.7.0.1
 */