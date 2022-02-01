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

class rtc
  implements bliz
{
  rtc(rsx paramrsx, blir paramblir, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.dismiss();
    paramView = this.jdField_a_of_type_Blir.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (rsx.a(this.jdField_a_of_type_Rsx) != null) {
        rsx.a(this.jdField_a_of_type_Rsx, rsx.a(this.jdField_a_of_type_Rsx));
      }
      rsx.a(this.jdField_a_of_type_Rsx, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        rsx.a(this.jdField_a_of_type_Rsx, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = bmtk.a();
          bmtd.c(rsx.a(this.jdField_a_of_type_Rsx), paramView, this.c, 10001);
          rsx.a(this.jdField_a_of_type_Rsx).b(rsx.b(this.jdField_a_of_type_Rsx));
        }
        for (;;)
        {
          rsx.a(this.jdField_a_of_type_Rsx, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(rsx.a(this.jdField_a_of_type_Rsx), 0, 2131718197, 0).b(rsx.a(this.jdField_a_of_type_Rsx).getResources().getDimensionPixelSize(2131299011));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(rsx.a(this.jdField_a_of_type_Rsx), 0, 2131718197, 0).b(rsx.a(this.jdField_a_of_type_Rsx).getResources().getDimensionPixelSize(2131299011));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, rsx.a(this.jdField_a_of_type_Rsx), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(rsx.a(this.jdField_a_of_type_Rsx), 0, 2131718197, 0).b(rsx.a(this.jdField_a_of_type_Rsx).getResources().getDimensionPixelSize(2131299011));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", ozs.f(0));
    rsx.a(this.jdField_a_of_type_Rsx).startActivity(paramView);
    rsx.a(this.jdField_a_of_type_Rsx).b(rsx.b(this.jdField_a_of_type_Rsx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtc
 * JD-Core Version:    0.7.0.1
 */