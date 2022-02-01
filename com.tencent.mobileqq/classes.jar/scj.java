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

class scj
  implements bkhw
{
  scj(sce paramsce, bkho parambkho, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    paramView = this.jdField_a_of_type_Bkho.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (sce.a(this.jdField_a_of_type_Sce) != null) {
        sce.a(this.jdField_a_of_type_Sce, sce.a(this.jdField_a_of_type_Sce));
      }
      sce.a(this.jdField_a_of_type_Sce, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        sce.a(this.jdField_a_of_type_Sce, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = blsi.a();
          blsb.c(sce.a(this.jdField_a_of_type_Sce), paramView, this.c, 10001);
          sce.a(this.jdField_a_of_type_Sce).a(sce.b(this.jdField_a_of_type_Sce));
        }
        for (;;)
        {
          sce.a(this.jdField_a_of_type_Sce, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(sce.a(this.jdField_a_of_type_Sce), 0, 2131718064, 0).b(sce.a(this.jdField_a_of_type_Sce).getResources().getDimensionPixelSize(2131298998));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(sce.a(this.jdField_a_of_type_Sce), 0, 2131718064, 0).b(sce.a(this.jdField_a_of_type_Sce).getResources().getDimensionPixelSize(2131298998));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, sce.a(this.jdField_a_of_type_Sce), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(sce.a(this.jdField_a_of_type_Sce), 0, 2131718064, 0).b(sce.a(this.jdField_a_of_type_Sce).getResources().getDimensionPixelSize(2131298998));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", pha.f(0));
    sce.a(this.jdField_a_of_type_Sce).startActivity(paramView);
    sce.a(this.jdField_a_of_type_Sce).a(sce.b(this.jdField_a_of_type_Sce));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scj
 * JD-Core Version:    0.7.0.1
 */