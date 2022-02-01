package cooperation.comic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VipComicJumpActivity$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  VipComicJumpActivity$LaunchCompletedObserver(VipComicJumpActivity paramVipComicJumpActivity) {}
  
  private void a(Intent paramIntent)
  {
    this.b = paramIntent.getStringExtra("pluginsdk_extraInfo");
    if ((this.b != null) && ("success".equals(this.b))) {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "launch activity finish, leave jump activity.");
      }
      return;
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a, -2);
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive mExtraInfo: " + this.b);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    paramContext = paramIntent.getStringExtra("pluginsdk_launchReceiver");
    String str = paramIntent.getAction();
    if (((!TextUtils.isEmpty(str)) && ("com.tencent.mobileqq.PreLoadComicProcess".equals(str))) || ((paramContext != null) && (paramContext.equals("com.qqcomic.app.VipPreloadComicProcess"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "onReceive getExtras:" + paramIntent.getExtras());
      }
      VipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity, paramIntent);
    }
    while ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("comic_plugin.apk"))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive: " + this.jdField_a_of_type_JavaLangString);
    }
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */