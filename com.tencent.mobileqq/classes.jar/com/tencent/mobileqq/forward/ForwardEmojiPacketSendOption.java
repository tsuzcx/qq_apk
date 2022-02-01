package com.tencent.mobileqq.forward;

import agej;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import auxu;
import bdll;
import bhpc;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.Set;

public class ForwardEmojiPacketSendOption
  extends auxu
{
  int e;
  
  public ForwardEmojiPacketSendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    this.jdField_a_of_type_AndroidContentIntent = agej.a(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
    this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardEmojiPacketSendOption
 * JD-Core Version:    0.7.0.1
 */