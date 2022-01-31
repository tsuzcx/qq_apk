import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.ProgressView;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ntg
  implements Runnable
{
  public ntg(QQStoryBaseActivity paramQQStoryBaseActivity, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.isFinishing())
    {
      SLog.d("Q.qqstory.QQStoryBaseActivity", "Activity has been destroy.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView = new QQStoryBaseActivity.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntg
 * JD-Core Version:    0.7.0.1
 */