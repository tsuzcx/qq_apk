import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.ProgressView;

public class nhn
  implements Runnable
{
  public nhn(VideoPlayModeBase paramVideoPlayModeBase, Context paramContext, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$ProgressView = new VideoPlayModeBase.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$ProgressView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$ProgressView.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhn
 * JD-Core Version:    0.7.0.1
 */