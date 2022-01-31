import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class qsb
  implements bfoq
{
  qsb(qrw paramqrw, bfol parambfol, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.dismiss();
    paramView = this.jdField_a_of_type_Bfol.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (qrw.a(this.jdField_a_of_type_Qrw) != null) {
        qrw.a(this.jdField_a_of_type_Qrw, qrw.a(this.jdField_a_of_type_Qrw));
      }
      qrw.a(this.jdField_a_of_type_Qrw, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        qrw.a(this.jdField_a_of_type_Qrw, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = bgyf.a();
          bgxy.c(qrw.a(this.jdField_a_of_type_Qrw), paramView, this.c, 10001);
          qrw.a(this.jdField_a_of_type_Qrw).a(qrw.b(this.jdField_a_of_type_Qrw));
        }
        for (;;)
        {
          qrw.a(this.jdField_a_of_type_Qrw, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          bcpw.a(qrw.a(this.jdField_a_of_type_Qrw), 0, 2131719542, 0).b(qrw.a(this.jdField_a_of_type_Qrw).getResources().getDimensionPixelSize(2131298865));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          bcpw.a(qrw.a(this.jdField_a_of_type_Qrw), 0, 2131719542, 0).b(qrw.a(this.jdField_a_of_type_Qrw).getResources().getDimensionPixelSize(2131298865));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, qrw.a(this.jdField_a_of_type_Qrw), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      bcpw.a(qrw.a(this.jdField_a_of_type_Qrw), 0, 2131719542, 0).b(qrw.a(this.jdField_a_of_type_Qrw).getResources().getDimensionPixelSize(2131298865));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", onk.f(0));
    qrw.a(this.jdField_a_of_type_Qrw).startActivity(paramView);
    qrw.a(this.jdField_a_of_type_Qrw).a(qrw.b(this.jdField_a_of_type_Qrw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsb
 * JD-Core Version:    0.7.0.1
 */