package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.graphics.Paint;
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
import bfnm;
import bgtn;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class TroopMemberNewLevelView
  extends LinearLayout
{
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2130846189, 2130846190, 2130846191, 2130846192, 2130846193, 2130846194, 2130846195, 2130846196, 2130846197, 2130846198, 2130846199 };
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
      f = 0.0F * (arrayOfChar.length - 1) + (f * 5.0F + 14.5F) + 3.0F + bgtn.c(this.jdField_a_of_type_Float) + 4.0F + 1.0F;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "width:" + f);
      }
      return bgtn.a(f);
      if (this.jdField_a_of_type_Boolean)
      {
        f = arrayOfChar.length;
        f = 0.0F * (arrayOfChar.length - 1) + (f * 5.0F + 14.5F) + 4.0F + 1.0F;
      }
      else if (this.jdField_b_of_type_Boolean)
      {
        f = 0.0F + (bgtn.c(this.jdField_a_of_type_Float) + 4.0F + 4.0F + 1.0F);
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
  
  public void setTroopMemberNewLevel(bfnm parambfnm)
  {
    if (parambfnm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel item is null");
      }
      return;
    }
    setTroopMemberNewLevel(parambfnm.jdField_a_of_type_Boolean, parambfnm.jdField_b_of_type_Boolean, parambfnm.jdField_b_of_type_Int, parambfnm.jdField_a_of_type_JavaLangString, parambfnm.jdField_b_of_type_ArrayOfInt, parambfnm.jdField_a_of_type_ArrayOfInt, parambfnm.d, parambfnm.jdField_c_of_type_Int);
  }
  
  public void setTroopMemberNewLevel(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    if ((paramBoolean1) && (!paramBoolean2) && ((paramInt1 < 1) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length < 2))) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel error isShowLevel : " + paramBoolean1 + ", isShowRank:" + paramBoolean2 + ",newLevel:" + paramInt1);
      }
    }
    label951:
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
        paramArrayOfInt1.setCornerRadius(bgtn.b(3.0F));
        setBackgroundDrawable(paramArrayOfInt1);
        setGravity(16);
        paramArrayOfInt1 = new LinearLayout.LayoutParams(bgtn.a(10.0F), bgtn.a(6.0F));
        paramArrayOfInt1.leftMargin = bgtn.a(4.0F);
        paramArrayOfInt1.rightMargin = bgtn.a(0.5F);
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
            localObject = new LinearLayout.LayoutParams(bgtn.a(5.0F), bgtn.a(7.0F));
            ImageView localImageView = new ImageView(getContext());
            localImageView.setImageResource(jdField_c_of_type_ArrayOfInt[i]);
            localImageView.setColorFilter(paramInt2);
            if (paramInt1 != paramArrayOfInt2.length - 1) {
              ((LinearLayout.LayoutParams)localObject).rightMargin = bgtn.a(0.0F);
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
        paramArrayOfInt2.setTextColor(paramInt3);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = bgtn.a(3.0F);
        ((LinearLayout.LayoutParams)localObject).rightMargin = bgtn.a(4.0F);
        paramArrayOfInt1.topMargin = bgtn.a(0.5F);
        paramArrayOfInt1.bottomMargin = bgtn.a(0.5F);
        this.jdField_a_of_type_Float = paramArrayOfInt2.getPaint().measureText(paramString);
        addView(paramArrayOfInt2, (ViewGroup.LayoutParams)localObject);
        setVisibility(0);
        return;
      }
      if (paramBoolean1)
      {
        paramString = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt1);
        paramString.setCornerRadius(bgtn.b(3.0F));
        setBackgroundDrawable(paramString);
        setGravity(16);
        paramArrayOfInt1 = new LinearLayout.LayoutParams(bgtn.a(10.0F), bgtn.a(6.0F));
        paramArrayOfInt1.leftMargin = bgtn.a(4.0F);
        paramArrayOfInt1.rightMargin = bgtn.a(0.5F);
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
            paramArrayOfInt2 = new LinearLayout.LayoutParams(bgtn.a(5.0F), bgtn.a(7.0F));
            localObject = new ImageView(getContext());
            ((ImageView)localObject).setImageResource(jdField_c_of_type_ArrayOfInt[paramInt3]);
            paramString.setColorFilter(paramInt2);
            if (paramInt1 != paramArrayOfInt1.length - 1) {
              break label951;
            }
          }
          for (paramArrayOfInt2.rightMargin = bgtn.a(4.0F);; paramArrayOfInt2.rightMargin = bgtn.a(0.0F))
          {
            paramArrayOfInt2.bottomMargin = bgtn.a(3.0F);
            paramArrayOfInt2.topMargin = bgtn.a(3.0F);
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
    paramArrayOfInt1.setCornerRadius(bgtn.b(3.0F));
    setBackgroundDrawable(paramArrayOfInt1);
    paramArrayOfInt1 = new TextView(getContext());
    paramArrayOfInt1.setText(paramString);
    paramArrayOfInt1.setGravity(48);
    paramArrayOfInt1.setTextSize(2, 12.0F);
    paramArrayOfInt1.setIncludeFontPadding(false);
    paramArrayOfInt1.setEllipsize(TextUtils.TruncateAt.END);
    paramArrayOfInt1.setSingleLine();
    paramArrayOfInt1.setTextColor(paramInt3);
    paramArrayOfInt2 = new LinearLayout.LayoutParams(-2, -2);
    paramArrayOfInt2.leftMargin = bgtn.a(4.0F);
    paramArrayOfInt2.rightMargin = bgtn.a(4.0F);
    paramArrayOfInt2.topMargin = bgtn.a(0.5F);
    paramArrayOfInt2.bottomMargin = bgtn.a(0.5F);
    this.jdField_a_of_type_Float = paramArrayOfInt1.getPaint().measureText(paramString);
    addView(paramArrayOfInt1, paramArrayOfInt2);
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView
 * JD-Core Version:    0.7.0.1
 */