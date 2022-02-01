package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.mobileqq.app.HardCodeUtil;

public class XLoadMoreLayout
  extends FrameLayout
  implements ILoadMoreLayout
{
  protected int a;
  protected View a;
  protected ProgressBar a;
  protected TextView a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  
  public XLoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  private void a()
  {
    b();
    c();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
                break;
              }
            } while (paramInt2 != 5);
            return true;
            if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
              break;
            }
          } while (paramInt2 != 5);
          return true;
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4)) {
            break;
          }
        } while (paramInt2 != 5);
        return true;
        if ((paramInt2 == 0) || (paramInt2 == 1)) {
          break;
        }
      } while (paramInt2 != 3);
      return true;
      if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {
        break;
      }
    } while (paramInt2 != 3);
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716848);
    this.c = HardCodeUtil.a(2131716849);
    this.d = HardCodeUtil.a(2131716850);
    this.b = StoryApi.a(2131699774);
    this.e = HardCodeUtil.a(2131716851);
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131560506, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373697);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131373701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373702));
    c(0);
  }
  
  private boolean c(int paramInt)
  {
    if (!a(this.jdField_a_of_type_Int, paramInt)) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a(int paramInt)
  {
    return c(paramInt);
  }
  
  public boolean b(int paramInt)
  {
    return a(this.jdField_a_of_type_Int, paramInt);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */