import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class rhk
  implements bhuk
{
  rhk(rhf paramrhf, bhuf parambhuf, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
    paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (rhf.a(this.jdField_a_of_type_Rhf) != null) {
        rhf.a(this.jdField_a_of_type_Rhf, rhf.a(this.jdField_a_of_type_Rhf));
      }
      rhf.a(this.jdField_a_of_type_Rhf, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        rhf.a(this.jdField_a_of_type_Rhf, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = bjea.a();
          bjdt.c(rhf.a(this.jdField_a_of_type_Rhf), paramView, this.c, 10001);
          rhf.a(this.jdField_a_of_type_Rhf).a(rhf.b(this.jdField_a_of_type_Rhf));
        }
        for (;;)
        {
          rhf.a(this.jdField_a_of_type_Rhf, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(rhf.a(this.jdField_a_of_type_Rhf), 0, 2131720097, 0).b(rhf.a(this.jdField_a_of_type_Rhf).getResources().getDimensionPixelSize(2131298914));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(rhf.a(this.jdField_a_of_type_Rhf), 0, 2131720097, 0).b(rhf.a(this.jdField_a_of_type_Rhf).getResources().getDimensionPixelSize(2131298914));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, rhf.a(this.jdField_a_of_type_Rhf), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(rhf.a(this.jdField_a_of_type_Rhf), 0, 2131720097, 0).b(rhf.a(this.jdField_a_of_type_Rhf).getResources().getDimensionPixelSize(2131298914));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", ors.f(0));
    rhf.a(this.jdField_a_of_type_Rhf).startActivity(paramView);
    rhf.a(this.jdField_a_of_type_Rhf).a(rhf.b(this.jdField_a_of_type_Rhf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhk
 * JD-Core Version:    0.7.0.1
 */