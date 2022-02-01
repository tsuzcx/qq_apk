package com.tencent.mobileqq.kandian.biz.common;

import android.content.Intent;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.qphone.base.util.BaseApplication;

public class ReadInJoyManager$ReadInJoyPublicAccountObserver
  implements Ox978RespCallBack
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public ReadInJoyManager$ReadInJoyPublicAccountObserver(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    paramString = new Intent("notify_main_subscribe_follow_state");
    paramString.putExtra("follow_uin", this.jdField_a_of_type_JavaLangString);
    paramString.putExtra("follow_uin_position", this.jdField_a_of_type_Int);
    paramString.putExtra("follow_uin_smooth_dx", this.b);
    paramString.putExtra("follow_uin_status", paramBoolean);
    BaseApplication.getContext().sendBroadcast(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.ReadInJoyPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */