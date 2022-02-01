package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bewz;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class TroopMemberNewLevelView
  extends LinearLayout
{
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2130846097, 2130846098, 2130846099, 2130846100, 2130846101, 2130846102, 2130846103, 2130846104, 2130846105, 2130846106, 2130846107 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  
  public TroopMemberNewLevelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberNewLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopMemberNewLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  public float a()
  {
    float f = 0.0F;
    char[] arrayOfChar = String.valueOf(this.jdField_a_of_type_Int).toCharArray();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if ((arrayOfChar == null) || (arrayOfChar.length == 0)) {
        return 0.0F;
      }
      f = arrayOfChar.length;
      f = 0.0F * (arrayOfChar.length - 1) + (f * 5.0F + 14.5F) + 3.0F + ViewUtils.PxToDp(this.jdField_a_of_type_Float) + 4.0F + 1.0F;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "width:" + f);
      }
      return ViewUtils.dip2px(f);
      if (this.jdField_a_of_type_Boolean)
      {
        f = arrayOfChar.length;
        f = 0.0F * (arrayOfChar.length - 1) + (f * 5.0F + 14.5F) + 4.0F + 1.0F;
      }
      else if (this.jdField_b_of_type_Boolean)
      {
        f = 0.0F + (ViewUtils.PxToDp(this.jdField_a_of_type_Float) + 4.0F + 4.0F + 1.0F);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void setTroopMemberNewLevel(bewz parambewz)
  {
    if (parambewz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel item is null");
      }
      return;
    }
    setTroopMemberNewLevel(parambewz.jdField_a_of_type_Boolean, parambewz.jdField_b_of_type_Boolean, parambewz.jdField_b_of_type_Int, parambewz.jdField_a_of_type_JavaLangString, parambewz.jdField_b_of_type_ArrayOfInt, parambewz.jdField_a_of_type_ArrayOfInt, parambewz.d, parambewz.jdField_c_of_type_Int);
  }
  
  public void setTroopMemberNewLevel(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    if ((paramBoolean1) && (!paramBoolean2) && ((paramInt1 < 1) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length < 2))) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel error isShowLevel : " + paramBoolean1 + ", isShowRank:" + paramBoolean2 + ",newLevel:" + paramInt1);
      }
    }
    label960:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((!paramBoolean2) || ((!TextUtils.isEmpty(paramString)) && (paramArrayOfInt2 != null) && (paramArrayOfInt2.length >= 2))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel error isShowRank:" + paramBoolean2 + ",rankTitle:" + paramString);
          return;
          if ((this.jdField_a_of_type_Boolean != paramBoolean1) || (this.jdField_b_of_type_Boolean != paramBoolean2) || (this.jdField_a_of_type_Int != paramInt1) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)) || (!Arrays.equals(paramArrayOfInt1, this.jdField_a_of_type_ArrayOfInt)) || (!Arrays.equals(paramArrayOfInt2, this.jdField_b_of_type_ArrayOfInt)) || (this.jdField_b_of_type_Int != paramInt2) || (this.jdField_c_of_type_Int != paramInt3)) {
            break;
          }
          setVisibility(0);
        } while (!QLog.isColorLevel());
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel normal");
        return;
        removeAllViews();
        setVisibility(8);
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Boolean = paramBoolean1;
        this.jdField_b_of_type_Boolean = paramBoolean2;
        this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
        this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_c_of_type_Int = paramInt3;
      } while ((!paramBoolean1) && (!paramBoolean2));
      Object localObject;
      if ((paramBoolean1) && (paramBoolean2))
      {
        paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
        paramArrayOfInt1.setCornerRadius(ViewUtils.dpToPx(3.0F));
        setBackgroundDrawable(paramArrayOfInt1);
        setGravity(16);
        paramArrayOfInt1 = new LinearLayout.LayoutParams(ViewUtils.dip2px(10.0F), ViewUtils.dip2px(6.0F));
        paramArrayOfInt1.leftMargin = ViewUtils.dip2px(4.0F);
        paramArrayOfInt1.rightMargin = ViewUtils.dip2px(0.5F);
        paramArrayOfInt2 = new ImageView(getContext());
        paramArrayOfInt2.setImageResource(jdField_c_of_type_ArrayOfInt[10]);
        paramArrayOfInt2.setColorFilter(paramInt2);
        addView(paramArrayOfInt2, paramArrayOfInt1);
        paramArrayOfInt2 = String.valueOf(paramInt1).toCharArray();
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfInt2.length)
        {
          int i = paramArrayOfInt2[paramInt1] - '0';
          if ((i >= 0) && (i < 10))
          {
            localObject = new LinearLayout.LayoutParams(ViewUtils.dip2px(5.0F), ViewUtils.dip2px(7.0F));
            ImageView localImageView = new ImageView(getContext());
            localImageView.setImageResource(jdField_c_of_type_ArrayOfInt[i]);
            localImageView.setColorFilter(paramInt2);
            if (paramInt1 != paramArrayOfInt2.length - 1) {
              ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(0.0F);
            }
            addView(localImageView, (ViewGroup.LayoutParams)localObject);
          }
          paramInt1 += 1;
        }
        paramArrayOfInt2 = new TextView(getContext());
        paramArrayOfInt2.setText(paramString);
        paramArrayOfInt2.setGravity(48);
        paramArrayOfInt2.setTextSize(2, 12.0F);
        paramArrayOfInt2.setIncludeFontPadding(false);
        paramArrayOfInt2.setEllipsize(TextUtils.TruncateAt.END);
        paramArrayOfInt2.setSingleLine();
        paramArrayOfInt2.setTypeface(Typeface.defaultFromStyle(1));
        paramArrayOfInt2.setTextColor(paramInt3);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(3.0F);
        ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(4.0F);
        paramArrayOfInt1.topMargin = ViewUtils.dip2px(0.5F);
        paramArrayOfInt1.bottomMargin = ViewUtils.dip2px(0.5F);
        this.jdField_a_of_type_Float = paramArrayOfInt2.getPaint().measureText(paramString);
        addView(paramArrayOfInt2, (ViewGroup.LayoutParams)localObject);
        setVisibility(0);
        return;
      }
      if (paramBoolean1)
      {
        paramString = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt1);
        paramString.setCornerRadius(ViewUtils.dpToPx(3.0F));
        setBackgroundDrawable(paramString);
        setGravity(16);
        paramArrayOfInt1 = new LinearLayout.LayoutParams(ViewUtils.dip2px(10.0F), ViewUtils.dip2px(6.0F));
        paramArrayOfInt1.leftMargin = ViewUtils.dip2px(4.0F);
        paramArrayOfInt1.rightMargin = ViewUtils.dip2px(0.5F);
        paramString = new ImageView(getContext());
        paramString.setColorFilter(paramInt2);
        paramString.setImageResource(jdField_c_of_type_ArrayOfInt[10]);
        addView(paramString, paramArrayOfInt1);
        paramArrayOfInt1 = String.valueOf(paramInt1).toCharArray();
        paramInt1 = 0;
        if (paramInt1 < paramArrayOfInt1.length)
        {
          paramInt3 = paramArrayOfInt1[paramInt1] - '0';
          if ((paramInt3 >= 0) && (paramInt3 < 10))
          {
            paramArrayOfInt2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(5.0F), ViewUtils.dip2px(7.0F));
            localObject = new ImageView(getContext());
            ((ImageView)localObject).setImageResource(jdField_c_of_type_ArrayOfInt[paramInt3]);
            paramString.setColorFilter(paramInt2);
            if (paramInt1 != paramArrayOfInt1.length - 1) {
              break label960;
            }
          }
          for (paramArrayOfInt2.rightMargin = ViewUtils.dip2px(4.0F);; paramArrayOfInt2.rightMargin = ViewUtils.dip2px(0.0F))
          {
            paramArrayOfInt2.bottomMargin = ViewUtils.dip2px(3.0F);
            paramArrayOfInt2.topMargin = ViewUtils.dip2px(3.0F);
            addView((View)localObject, paramArrayOfInt2);
            paramInt1 += 1;
            break;
          }
        }
        setVisibility(0);
        return;
      }
    } while (!paramBoolean2);
    paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
    paramArrayOfInt1.setCornerRadius(ViewUtils.dpToPx(3.0F));
    setBackgroundDrawable(paramArrayOfInt1);
    paramArrayOfInt1 = new TextView(getContext());
    paramArrayOfInt1.setText(paramString);
    paramArrayOfInt1.setGravity(48);
    paramArrayOfInt1.setTextSize(2, 12.0F);
    paramArrayOfInt1.setIncludeFontPadding(false);
    paramArrayOfInt1.setEllipsize(TextUtils.TruncateAt.END);
    paramArrayOfInt1.setSingleLine();
    paramArrayOfInt1.setTypeface(Typeface.defaultFromStyle(1));
    paramArrayOfInt1.setTextColor(paramInt3);
    paramArrayOfInt2 = new LinearLayout.LayoutParams(-2, -2);
    paramArrayOfInt2.leftMargin = ViewUtils.dip2px(4.0F);
    paramArrayOfInt2.rightMargin = ViewUtils.dip2px(4.0F);
    paramArrayOfInt2.topMargin = ViewUtils.dip2px(0.5F);
    paramArrayOfInt2.bottomMargin = ViewUtils.dip2px(0.5F);
    this.jdField_a_of_type_Float = paramArrayOfInt1.getPaint().measureText(paramString);
    addView(paramArrayOfInt1, paramArrayOfInt2);
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView
 * JD-Core Version:    0.7.0.1
 */