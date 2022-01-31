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

class qry
  implements bfph
{
  qry(qrt paramqrt, bfpc parambfpc, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfpc.dismiss();
    paramView = this.jdField_a_of_type_Bfpc.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (qrt.a(this.jdField_a_of_type_Qrt) != null) {
        qrt.a(this.jdField_a_of_type_Qrt, qrt.a(this.jdField_a_of_type_Qrt));
      }
      qrt.a(this.jdField_a_of_type_Qrt, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        qrt.a(this.jdField_a_of_type_Qrt, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = bgyw.a();
          bgyp.c(qrt.a(this.jdField_a_of_type_Qrt), paramView, this.c, 10001);
          qrt.a(this.jdField_a_of_type_Qrt).a(qrt.b(this.jdField_a_of_type_Qrt));
        }
        for (;;)
        {
          qrt.a(this.jdField_a_of_type_Qrt, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          bcql.a(qrt.a(this.jdField_a_of_type_Qrt), 0, 2131719553, 0).b(qrt.a(this.jdField_a_of_type_Qrt).getResources().getDimensionPixelSize(2131298865));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          bcql.a(qrt.a(this.jdField_a_of_type_Qrt), 0, 2131719553, 0).b(qrt.a(this.jdField_a_of_type_Qrt).getResources().getDimensionPixelSize(2131298865));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, qrt.a(this.jdField_a_of_type_Qrt), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      bcql.a(qrt.a(this.jdField_a_of_type_Qrt), 0, 2131719553, 0).b(qrt.a(this.jdField_a_of_type_Qrt).getResources().getDimensionPixelSize(2131298865));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", onh.f(0));
    qrt.a(this.jdField_a_of_type_Qrt).startActivity(paramView);
    qrt.a(this.jdField_a_of_type_Qrt).a(qrt.b(this.jdField_a_of_type_Qrt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qry
 * JD-Core Version:    0.7.0.1
 */