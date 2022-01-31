package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LabelBaseCtrl
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c = { "喜欢的电影", "喜欢的明星", "喜欢的游戏", "去过的地方", "爱吃的美食", "常用的品牌", "喜欢的运动" };
  public static final String[] d = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  protected Context a;
  protected LayoutInflater a;
  protected LinearLayout a;
  protected InterestTag a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 6, 7, 1, 2, 3, 4, 8 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130839502, 2130839511, 2130839496, 2130839505, 2130839492, 2130839486, 2130839510 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#AF4EFB" };
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramInt == jdField_a_of_type_ArrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected abstract int a();
  
  protected View a(int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    a(paramInt1, a(localView, paramInt1, paramInterestTag, paramInt2), paramInterestTag.jdField_a_of_type_JavaUtilArrayList);
    return localView;
  }
  
  protected abstract LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2);
  
  protected void a(int paramInt, LabelContainer paramLabelContainer, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.5F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 12.0F);
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[paramInt]));
        localGradientDrawable.setCornerRadius(m);
        localTextView.setBackgroundDrawable(localGradientDrawable);
        localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[paramInt]));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag != null)
        {
          int i = 0;
          while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((InterestTagInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag.jdField_a_of_type_JavaUtilArrayList.get(i)).tagName.equals(localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[7]));
              this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag.jdField_a_of_type_JavaUtilArrayList.remove(i);
            }
            i += 1;
          }
        }
        if (localInterestTagInfo.tagName != null)
        {
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\005", "");
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\006", "");
        }
        localTextView.setText(localInterestTagInfo.tagName);
        localTextView.setPadding(j, k, j, k);
        localTextView.setGravity(17);
        paramLabelContainer.addView(localTextView);
      }
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(InterestTag paramInterestTag)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag = paramInterestTag;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(InterestTag[] paramArrayOfInterestTag)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    boolean bool2;
    if ((paramArrayOfInterestTag == null) || (paramArrayOfInterestTag.length == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = 0;
      bool1 = false;
      bool2 = bool1;
    } while (i >= jdField_a_of_type_ArrayOfInt.length);
    int j = 0;
    for (;;)
    {
      bool2 = bool1;
      if (j < paramArrayOfInterestTag.length)
      {
        if ((jdField_a_of_type_ArrayOfInt[i] == paramArrayOfInterestTag[j].jdField_a_of_type_Int) && ((a()) || ((paramArrayOfInterestTag[j].jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayOfInterestTag[j].jdField_a_of_type_JavaUtilArrayList.size() > 0))))
        {
          View localView = a(i, paramArrayOfInterestTag[j], paramArrayOfInterestTag.length);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          bool2 = true;
        }
      }
      else
      {
        i += 1;
        bool1 = bool2;
        break;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelBaseCtrl
 * JD-Core Version:    0.7.0.1
 */