package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
{
  public static final String a;
  public static boolean a;
  public static Bitmap b = null;
  protected ImageView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "qqstory/animation_cover.jpg";
    jdField_a_of_type_Boolean = false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new QQStoryTakeVideoCloseAnimationActivity.1(this), 150L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */