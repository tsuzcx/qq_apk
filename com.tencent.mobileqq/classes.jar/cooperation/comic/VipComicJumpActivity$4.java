package cooperation.comic;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

final class VipComicJumpActivity$4
  implements Runnable
{
  VipComicJumpActivity$4(Activity paramActivity, VipComicJumpActivity.LoadingCondition paramLoadingCondition) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition.a = new BoodoPluginLoadingDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition);
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition.a.show();
      return;
    }
    QLog.e("VipComicJumpActivity", 1, "showHippyLoading activity is finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.4
 * JD-Core Version:    0.7.0.1
 */