package dov.com.qq.im.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bmby;
import bmcn;
import bmco;
import bmcp;
import bmcq;
import java.util.ArrayList;
import java.util.List;

public class TabLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView = new View(getContext());
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private bmcp jdField_a_of_type_Bmcp;
  private List<bmcq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bmby.a();
  @DrawableRes
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = 2130837687;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_b_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(getContext(), 7.0F), a(getContext(), 7.0F));
    localLayoutParams.addRule(12);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bmcp != null) {
      this.jdField_a_of_type_Bmcp.a(paramInt);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bmcq localbmcq = (bmcq)this.jdField_a_of_type_JavaUtilList.get(i);
      if (paramInt == 0)
      {
        if (paramInt == i) {}
        for (bool = true;; bool = false)
        {
          localbmcq.a(bool, false);
          i += 1;
          break;
        }
      }
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localbmcq.a(bool, this.jdField_b_of_type_Boolean);
        break;
      }
    }
    if (this.jdField_a_of_type_Int == 0) {
      i = this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
      }
      return;
      if (this.jdField_b_of_type_Boolean) {
        i = 2130837686;
      } else {
        i = this.jdField_b_of_type_Int;
      }
    }
  }
  
  private void c(int paramInt)
  {
    float f1 = this.jdField_a_of_type_AndroidViewView.getX();
    float f2 = ((bmcq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getX();
    float f3 = ((bmcq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getWidth() / 2.0F;
    float f4 = this.jdField_a_of_type_AndroidViewView.getWidth() / 2.0F;
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "x", new float[] { f1, f3 + f2 - f4 }).setDuration(250L).start();
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    while (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    if ((this.jdField_a_of_type_Bmcp != null) && (!this.jdField_a_of_type_Bmcp.a(paramInt)))
    {
      this.jdField_a_of_type_Bmcp.a(paramInt);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    c(paramInt);
    b(paramInt);
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    paramViewPager.setOnPageChangeListener(new bmco(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bmcq localbmcq = (bmcq)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Int == i) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localbmcq.a(paramBoolean, false);
          i += 1;
          break;
        }
      }
      if (this.jdField_a_of_type_Int == i) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbmcq.a(paramBoolean, this.jdField_b_of_type_Boolean);
        break;
      }
    }
    if (this.jdField_a_of_type_Int == 0) {
      i = this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
      return;
      if (this.jdField_b_of_type_Boolean) {
        i = 2130837686;
      } else {
        i = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void setTabSelectedCallback(bmcp parambmcp)
  {
    this.jdField_a_of_type_Bmcp = parambmcp;
  }
  
  public void setTabs(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    do
    {
      return;
      int j = paramList.size();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setWeightSum(j);
      int i = 0;
      if (i < j)
      {
        bmcq localbmcq = new bmcq(getContext(), this.jdField_a_of_type_Boolean);
        localbmcq.a().setText((CharSequence)paramList.get(i));
        if (paramInt == i) {}
        for (boolean bool = true;; bool = false)
        {
          localbmcq.a(bool, this.jdField_b_of_type_Boolean);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams.weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localbmcq, localLayoutParams);
          this.jdField_a_of_type_JavaUtilList.add(localbmcq);
          localbmcq.setOnClickListener(new bmcn(this, i));
          i += 1;
          break;
        }
      }
      a();
      if (paramList.size() > 1) {
        ((bmcq)this.jdField_a_of_type_JavaUtilList.get(0)).post(new TabLayout.2(this, paramInt));
      }
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Int == 0);
    b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */