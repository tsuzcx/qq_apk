import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class mat
  implements DialogInterface.OnClickListener
{
  mat(mas parammas, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Mas.a.a, VideoFeedsAdapter.a(this.jdField_a_of_type_Mas.a).getIntent().getExtras().getString("thumbfile_md5") + ".mp4", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mat
 * JD-Core Version:    0.7.0.1
 */