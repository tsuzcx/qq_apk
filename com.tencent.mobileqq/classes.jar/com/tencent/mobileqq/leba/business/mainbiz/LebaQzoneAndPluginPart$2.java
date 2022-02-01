package com.tencent.mobileqq.leba.business.mainbiz;

import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class LebaQzoneAndPluginPart$2
  implements Runnable
{
  LebaQzoneAndPluginPart$2(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QBaseActivity paramQBaseActivity, String paramString1, SharedPreferences paramSharedPreferences, String paramString2, LebaQzoneAndPluginPart.CheckEnterAppListener paramCheckEnterAppListener) {}
  
  public void run()
  {
    QBaseActivity localQBaseActivity = this.a;
    DialogUtil.a(localQBaseActivity, localQBaseActivity.getResources().getString(2131891142), this.a.getResources().getString(2131891140, new Object[] { this.b }), this.a.getResources().getString(2131891141), new LebaQzoneAndPluginPart.2.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.2
 * JD-Core Version:    0.7.0.1
 */