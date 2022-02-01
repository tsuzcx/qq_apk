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

class sml
  implements bkzq
{
  sml(smg paramsmg, bkzi parambkzi, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (smg.a(this.jdField_a_of_type_Smg) != null) {
        smg.a(this.jdField_a_of_type_Smg, smg.a(this.jdField_a_of_type_Smg));
      }
      smg.a(this.jdField_a_of_type_Smg, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        smg.a(this.jdField_a_of_type_Smg, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = QZoneHelper.UserInfo.getInstance();
          QZoneHelper.forwardToPublishMood(smg.a(this.jdField_a_of_type_Smg), paramView, this.c, 10001);
          smg.a(this.jdField_a_of_type_Smg).b(smg.b(this.jdField_a_of_type_Smg));
        }
        for (;;)
        {
          smg.a(this.jdField_a_of_type_Smg, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(smg.a(this.jdField_a_of_type_Smg), 0, 2131718824, 0).b(smg.a(this.jdField_a_of_type_Smg).getResources().getDimensionPixelSize(2131299080));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(smg.a(this.jdField_a_of_type_Smg), 0, 2131718824, 0).b(smg.a(this.jdField_a_of_type_Smg).getResources().getDimensionPixelSize(2131299080));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, smg.a(this.jdField_a_of_type_Smg), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(smg.a(this.jdField_a_of_type_Smg), 0, 2131718824, 0).b(smg.a(this.jdField_a_of_type_Smg).getResources().getDimensionPixelSize(2131299080));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", pqx.a(0));
    smg.a(this.jdField_a_of_type_Smg).startActivity(paramView);
    smg.a(this.jdField_a_of_type_Smg).b(smg.b(this.jdField_a_of_type_Smg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sml
 * JD-Core Version:    0.7.0.1
 */