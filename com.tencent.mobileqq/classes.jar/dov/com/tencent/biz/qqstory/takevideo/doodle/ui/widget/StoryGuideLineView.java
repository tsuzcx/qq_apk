package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

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
import anzj;
import bqso;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import zlk;
import zll;

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
    LayoutInflater.from(paramContext).inflate(2131562942, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)findViewById(2131374573));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374678));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378046));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378414));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368614));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369998));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374618));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374619);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131374627);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374624);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370006));
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
    if (LiuHaiUtils.b()) {
      d = localDisplayMetrics.heightPixels - this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - LiuHaiUtils.e - LiuHaiUtils.jdField_a_of_type_Int;
    }
  }
  
  public void setFollow()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131713239));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846436);
  }
  
  public void setLinkerObject(bqso parambqso)
  {
    if ((parambqso == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(parambqso.c);
    if (TextUtils.isEmpty(parambqso.c)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(parambqso.a);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
  }
  
  public void setStoryTag(zlk paramzlk)
  {
    if ((paramzlk == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramzlk.a.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView
 * JD-Core Version:    0.7.0.1
 */