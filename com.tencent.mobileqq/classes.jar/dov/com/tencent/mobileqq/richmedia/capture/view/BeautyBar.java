package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import mqq.app.AppRuntime;

public class BeautyBar
  extends LinearLayout
{
  public static float a;
  public static long a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new BeautyBar.1(this);
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public SeekBar.OnSeekBarChangeListener a;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BeautyBar.BeautyBarListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewBeautyBar$BeautyBarListener;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Float = 0.6F;
    jdField_a_of_type_Long = 1500L;
  }
  
  public BeautyBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new BeautyBar.2(this);
  }
  
  public BeautyBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new BeautyBar.2(this);
  }
  
  public BeautyBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new BeautyBar.2(this);
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131363564));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new BeautyBar.3(this));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846003);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363566));
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = null;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i = localSharedPreferences.getInt("beauty_level" + str, (int)(jdField_a_of_type_Float * 100.0F));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
    post(new BeautyBar.4(this, i));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701158) + paramInt + "%");
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    for (int i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetSeekBar.getLayoutParams()).leftMargin + j / 2;; i = 0)
    {
      int k = this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
      int m = this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth();
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = (i - k / 2 + (m - j) * paramInt / 100);
      if (paramInt < 50) {}
      for (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = ((int)(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin - (50.0F - paramInt) / 50.0F * AIOUtils.a(7.0F, getResources())));; this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = ((int)(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin + (paramInt - 50.0F) / 50.0F * AIOUtils.a(5.0F, getResources()))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        if ((paramBoolean) || (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  public void setBeautyBarListener(BeautyBar.BeautyBarListener paramBeautyBarListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewBeautyBar$BeautyBarListener = paramBeautyBarListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar
 * JD-Core Version:    0.7.0.1
 */