package dov.com.tencent.biz.qqstory.takevideo.artfilter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anww;
import anwx;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.io.File;

public class ArtFilterItemView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public Handler a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public ArtFilterItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(paramContext, 2130969186, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365540));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365537));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365538));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365539));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(38);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      localObject = new File(this.jdField_a_of_type_JavaLangString).listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          Drawable localDrawable = Drawable.createFromPath(localObject[i].getAbsolutePath());
          if (localDrawable != null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(localDrawable, 50);
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() != 0)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      }
    }
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(38);
    ((Message)localObject).arg1 = paramInt;
    ((Message)localObject).arg2 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 100L);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterItemView", 2, "updateProgress:updateCount:" + paramInt + ",hasFinished:" + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("100%");
        postDelayed(new anww(this), 100L);
        return;
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView.getText().equals("100&"));
    paramInt += 1;
    if (paramInt <= 40) {
      paramInt = (int)(paramInt * 1.25D);
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 100) {
        i = 99;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "%");
      return;
      if (paramInt <= 50) {
        paramInt = (int)((paramInt - 40) * 2.5D + 50.0D);
      } else {
        paramInt = (paramInt - 50) / 6 + 75;
      }
    }
  }
  
  public void a(EditVideoArtFilter paramEditVideoArtFilter)
  {
    a();
    this.jdField_a_of_type_Boolean = true;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(0L);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setAnimationListener(new anwx(this, paramEditVideoArtFilter));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b()
  {
    setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, AIOUtils.a(190.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0.0F);
    localTranslateAnimation.setInterpolator(new OvershootInterpolator());
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(0L);
    localTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setHandler(Handler paramHandler, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView
 * JD-Core Version:    0.7.0.1
 */