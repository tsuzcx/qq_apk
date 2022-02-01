package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LabelBaseCtrl
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c = { HardCodeUtil.a(2131706053), HardCodeUtil.a(2131706055), HardCodeUtil.a(2131706049), HardCodeUtil.a(2131706054), HardCodeUtil.a(2131706052), HardCodeUtil.a(2131706050), HardCodeUtil.a(2131706051) };
  public static final String[] d = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  protected Context a;
  protected LayoutInflater a;
  protected LinearLayout a;
  protected InterestTag a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 6, 7, 1, 2, 3, 4, 8 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130841420, 2130841429, 2130841415, 2130841423, 2130841411, 2130841405, 2130841428 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#DCEBFF" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#4B83D3" };
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i]) {
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
  
  protected void a(int paramInt, LabelContainer paramLabelContainer, ArrayList<InterestTagInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        int i = 0;
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[paramInt]));
        localGradientDrawable.setCornerRadius(m);
        localTextView.setBackgroundDrawable(localGradientDrawable);
        localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[paramInt]));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag != null) {
          while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((InterestTagInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag.jdField_a_of_type_JavaUtilArrayList.get(i)).tagName.equals(localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[7]));
              localTextView.setBackgroundColor(Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[7]));
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
    if (paramArrayOfInterestTag != null)
    {
      if (paramArrayOfInterestTag.length == 0) {
        return false;
      }
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < jdField_a_of_type_ArrayOfInt.length; bool1 = bool2)
      {
        int j = 0;
        for (;;)
        {
          bool2 = bool1;
          if (j >= paramArrayOfInterestTag.length) {
            break;
          }
          if ((jdField_a_of_type_ArrayOfInt[i] == paramArrayOfInterestTag[j].jdField_a_of_type_Int) && ((a()) || ((paramArrayOfInterestTag[j].jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayOfInterestTag[j].jdField_a_of_type_JavaUtilArrayList.size() > 0))))
          {
            View localView = a(i, paramArrayOfInterestTag[j], paramArrayOfInterestTag.length);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
            bool2 = true;
            break;
          }
          j += 1;
        }
        i += 1;
      }
      return bool1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelBaseCtrl
 * JD-Core Version:    0.7.0.1
 */