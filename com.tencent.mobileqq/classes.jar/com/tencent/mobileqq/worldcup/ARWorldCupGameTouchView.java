package com.tencent.mobileqq.worldcup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class ARWorldCupGameTouchView
  extends FrameLayout
{
  int jdField_a_of_type_Int = 300;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TouchSliceView jdField_a_of_type_ComTencentMobileqqWorldcupTouchSliceView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = true;
  
  public ARWorldCupGameTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    LayoutInflater.from(paramContext).inflate(2130970197, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369519));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369520));
    this.jdField_a_of_type_ComTencentMobileqqWorldcupTouchSliceView = ((TouchSliceView)findViewById(2131369518));
  }
  
  public ARWorldCupGameTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130970197, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369519));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369520));
    this.jdField_a_of_type_ComTencentMobileqqWorldcupTouchSliceView = ((TouchSliceView)findViewById(2131369518));
  }
  
  public void a()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable_ARWorldCupGameTouchView", 2, "initView " + this.jdField_b_of_type_Boolean);
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString + "/res/worldcup/grid.png");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_JavaLangString + "/res/worldcup/right_left_";
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning())) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
          Bitmap localBitmap1 = BitmapFactory.decodeFile((String)localObject + "01.png");
          Bitmap localBitmap2 = BitmapFactory.decodeFile((String)localObject + "02.png");
          Bitmap localBitmap3 = BitmapFactory.decodeFile((String)localObject + "03.png");
          Object localObject = BitmapFactory.decodeFile((String)localObject + "04.png");
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(new BitmapDrawable(localBitmap1), this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(new BitmapDrawable(localBitmap2), this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(new BitmapDrawable(localBitmap3), this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(new BitmapDrawable((Bitmap)localObject), this.jdField_a_of_type_Int);
          localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).height = ViewUtils.b(300.0F);
          ((FrameLayout.LayoutParams)localObject).setMargins(ViewUtils.b(30.0F), 0, 0, ViewUtils.b(90.0F));
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          String str;
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        continue;
        str = this.jdField_a_of_type_JavaLangString + "/res/worldcup/middle_";
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    }
  }
  
  public void c()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable_ARWorldCupGameTouchView", 2, "ARWorldGC ARWorldCupGameTouchView uninit");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWorldcupTouchSliceView.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setGameExtendResourcePath(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setGameMainResourcePath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setIsShowExtend(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean) {
      this.c = true;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupGameTouchView
 * JD-Core Version:    0.7.0.1
 */