package com.tencent.mobileqq.kandian.biz.biu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ReadInJoyDeliverBiuActivity$12
  implements Runnable
{
  public void run()
  {
    Object localObject = this.this$0.app.getCurrentAccountUin();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append((String)localObject);
    localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putString("readinjoy_deliver_biu_guide_time", this.a);
      ((SharedPreferences)localObject).edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.12
 * JD-Core Version:    0.7.0.1
 */