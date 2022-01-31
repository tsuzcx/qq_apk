package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bism;
import bjeh;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import vik;
import vil;

public class StoryGuideLineView
  extends LinearLayout
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public StoryGuideLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131496848, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)findViewById(2131307518));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307624));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310738));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131311049));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302445));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303582));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131307564));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131307565);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131307573);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131307570);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303590));
    setViewAlpha(this.jdField_c_of_type_AndroidWidgetLinearLayout);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      requestLayout();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_AndroidWidgetLinearLayout.getVisibility() == 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      requestLayout();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      requestLayout();
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      requestLayout();
    }
  }
  
  public void e()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void g()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void h()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void i()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void j()
  {
    g();
    i();
    e();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChild(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramInt1, paramInt2);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
    jdField_b_of_type_Int = localDisplayMetrics.widthPixels - this.jdField_c_of_type_AndroidViewView.getMeasuredWidth();
    jdField_c_of_type_Int = 0;
    d = localDisplayMetrics.heightPixels - this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
    if (bjeh.b()) {
      d = localDisplayMetrics.heightPixels - this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - bjeh.e - bjeh.jdField_a_of_type_Int;
    }
  }
  
  public void setFollow()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648645));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845338);
  }
  
  public void setLinkerObject(bism parambism)
  {
    if ((parambism == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(parambism.c);
    if (TextUtils.isEmpty(parambism.c)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(parambism.a);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839330);
  }
  
  public void setStoryTag(vik paramvik)
  {
    if ((paramvik == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramvik.a.a);
  }
  
  public void setUserHead(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setUserName(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setViewAlpha(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    if (j == 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          setViewAlpha((ViewGroup)localView);
        }
        if (localView.getBackground() != null) {
          localView.getBackground().mutate().setAlpha(60);
        }
        localView.setAlpha(0.6F);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView
 * JD-Core Version:    0.7.0.1
 */