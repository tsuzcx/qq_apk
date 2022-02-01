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
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;

class sag
  implements bjoe
{
  sag(sab paramsab, bjnw parambjnw, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.dismiss();
    paramView = this.jdField_a_of_type_Bjnw.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (sab.a(this.jdField_a_of_type_Sab) != null) {
        sab.a(this.jdField_a_of_type_Sab, sab.a(this.jdField_a_of_type_Sab));
      }
      sab.a(this.jdField_a_of_type_Sab, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        sab.a(this.jdField_a_of_type_Sab, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = QZoneHelper.UserInfo.getInstance();
          QZoneHelper.forwardToPublishMood(sab.a(this.jdField_a_of_type_Sab), paramView, this.c, 10001);
          sab.a(this.jdField_a_of_type_Sab).b(sab.b(this.jdField_a_of_type_Sab));
        }
        for (;;)
        {
          sab.a(this.jdField_a_of_type_Sab, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(sab.a(this.jdField_a_of_type_Sab), 0, 2131718438, 0).b(sab.a(this.jdField_a_of_type_Sab).getResources().getDimensionPixelSize(2131299076));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(sab.a(this.jdField_a_of_type_Sab), 0, 2131718438, 0).b(sab.a(this.jdField_a_of_type_Sab).getResources().getDimensionPixelSize(2131299076));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, sab.a(this.jdField_a_of_type_Sab), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(sab.a(this.jdField_a_of_type_Sab), 0, 2131718438, 0).b(sab.a(this.jdField_a_of_type_Sab).getResources().getDimensionPixelSize(2131299076));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", pay.f(0));
    sab.a(this.jdField_a_of_type_Sab).startActivity(paramView);
    sab.a(this.jdField_a_of_type_Sab).b(sab.b(this.jdField_a_of_type_Sab));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sag
 * JD-Core Version:    0.7.0.1
 */