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

class qgd
  implements begw
{
  qgd(qfy paramqfy, begr parambegr, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Begr.dismiss();
    paramView = this.jdField_a_of_type_Begr.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (qfy.a(this.jdField_a_of_type_Qfy) != null) {
        qfy.a(this.jdField_a_of_type_Qfy, qfy.a(this.jdField_a_of_type_Qfy));
      }
      qfy.a(this.jdField_a_of_type_Qfy, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        qfy.a(this.jdField_a_of_type_Qfy, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = bfpy.a();
          bfpr.c(qfy.a(this.jdField_a_of_type_Qfy), paramView, this.c, 10001);
          qfy.a(this.jdField_a_of_type_Qfy).a(qfy.b(this.jdField_a_of_type_Qfy));
        }
        for (;;)
        {
          qfy.a(this.jdField_a_of_type_Qfy, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          bbmy.a(qfy.a(this.jdField_a_of_type_Qfy), 0, 2131653658, 0).b(qfy.a(this.jdField_a_of_type_Qfy).getResources().getDimensionPixelSize(2131167766));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          bbmy.a(qfy.a(this.jdField_a_of_type_Qfy), 0, 2131653658, 0).b(qfy.a(this.jdField_a_of_type_Qfy).getResources().getDimensionPixelSize(2131167766));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, qfy.a(this.jdField_a_of_type_Qfy), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      bbmy.a(qfy.a(this.jdField_a_of_type_Qfy), 0, 2131653658, 0).b(qfy.a(this.jdField_a_of_type_Qfy).getResources().getDimensionPixelSize(2131167766));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", obz.f(0));
    qfy.a(this.jdField_a_of_type_Qfy).startActivity(paramView);
    qfy.a(this.jdField_a_of_type_Qfy).a(qfy.b(this.jdField_a_of_type_Qfy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgd
 * JD-Core Version:    0.7.0.1
 */