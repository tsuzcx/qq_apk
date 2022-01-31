package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import angn;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
{
  public static final String a;
  public static Bitmap b;
  protected ImageView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aZ + "qqstory/animation_cover.jpg";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.jdField_a_of_type_AndroidWidgetImageView);
    if ((b != null) && (!b.isRecycled())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(b);
    }
    b = null;
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new angn(this), 150L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */