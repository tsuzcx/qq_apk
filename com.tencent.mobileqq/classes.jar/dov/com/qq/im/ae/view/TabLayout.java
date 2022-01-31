package dov.com.qq.im.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bljr;
import bljs;
import bljt;
import blju;
import java.util.ArrayList;
import java.util.List;

public class TabLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView = new View(getContext());
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private bljt jdField_a_of_type_Bljt;
  private List<blju> jdField_a_of_type_JavaUtilList = new ArrayList();
  
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837620);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(getContext(), 5.0F), a(getContext(), 5.0F));
    localLayoutParams.addRule(12);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bljt != null) {
      this.jdField_a_of_type_Bljt.a(paramInt);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      blju localblju = (blju)this.jdField_a_of_type_JavaUtilList.get(i);
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localblju.a(bool);
        i += 1;
        break;
      }
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    float f1 = this.jdField_a_of_type_AndroidViewView.getX();
    float f2 = ((blju)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getX();
    float f3 = ((blju)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getWidth() / 2.0F;
    float f4 = this.jdField_a_of_type_AndroidViewView.getWidth() / 2.0F;
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "x", new float[] { f1, f3 + f2 - f4 }).setDuration(300L).start();
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    while (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    if ((this.jdField_a_of_type_Bljt != null) && (!this.jdField_a_of_type_Bljt.a(paramInt)))
    {
      this.jdField_a_of_type_Bljt.a(paramInt);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    c(paramInt);
    b(paramInt);
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    paramViewPager.setOnPageChangeListener(new bljs(this));
  }
  
  public void setTabSelectedCallback(bljt parambljt)
  {
    this.jdField_a_of_type_Bljt = parambljt;
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
        blju localblju = new blju(getContext());
        localblju.a().setText((CharSequence)paramList.get(i));
        if (paramInt == i) {}
        for (boolean bool = true;; bool = false)
        {
          localblju.a(bool);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams.weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localblju, localLayoutParams);
          this.jdField_a_of_type_JavaUtilList.add(localblju);
          localblju.setOnClickListener(new bljr(this, i));
          i += 1;
          break;
        }
      }
      a();
      if (paramList.size() > 1) {
        ((blju)this.jdField_a_of_type_JavaUtilList.get(0)).post(new TabLayout.2(this));
      }
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Int == 0);
    b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */