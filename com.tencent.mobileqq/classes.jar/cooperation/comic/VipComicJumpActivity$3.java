package cooperation.comic;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.BoodoHippyBirdge.ICheckPluginListener;

final class VipComicJumpActivity$3
  implements BoodoHippyBirdge.ICheckPluginListener
{
  VipComicJumpActivity$3(VipComicJumpActivity.LoadingCondition paramLoadingCondition, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("VipComicJumpActivity", 1, "checkBoodoPlugin retCode:" + paramInt + " msg:" + paramString);
    VipComicJumpActivity.a(paramInt, this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */