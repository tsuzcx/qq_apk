package com.tencent.mobileqq.troop.widget.troopmemberlevel;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class TroopMemberNewLevelView
  extends RelativeLayout
{
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2130846391, 2130846392, 2130846393, 2130846394, 2130846395, 2130846396, 2130846397, 2130846398, 2130846399, 2130846400, 2130846401 };
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt = null;
  private int jdField_c_of_type_Int = 0;
  
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
  }
  
  private void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setId(View.generateViewId());
    } else {
      paramView.setId(getChildCount() + 1);
    }
    paramLayoutParams.addRule(15);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    int i = getChildCount();
    if (i >= 1)
    {
      View localView = getChildAt(i - 1);
      if (localView == null) {
        return;
      }
      if (localView.getId() == -1) {
        return;
      }
      paramLayoutParams.addRule(1, localView.getId());
    }
  }
  
  public float a()
  {
    Object localObject = String.valueOf(this.jdField_a_of_type_Int).toCharArray();
    boolean bool = this.jdField_b_of_type_Boolean;
    float f1 = 0.0F;
    float f2;
    if ((bool) && (this.jdField_a_of_type_Boolean))
    {
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return 0.0F;
        }
        f2 = localObject.length * 5.0F + 14.5F + (localObject.length - 1) * 0.0F + 3.0F;
        f1 = ViewUtils.c(this.jdField_a_of_type_Float);
      }
      else
      {
        return 0.0F;
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label119;
      }
      f2 = localObject.length * 5.0F + 14.5F;
      f1 = (localObject.length - 1) * 0.0F;
    }
    f1 = f2 + f1 + 4.0F + 1.0F;
    break label145;
    label119:
    if (this.jdField_b_of_type_Boolean) {
      f1 = 0.0F + (ViewUtils.c(this.jdField_a_of_type_Float) + 4.0F + 4.0F + 1.0F);
    }
    label145:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("width:");
      ((StringBuilder)localObject).append(f1);
      QLog.d("TroopMemberNewLevelView", 2, ((StringBuilder)localObject).toString());
    }
    return ViewUtils.a(f1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void setTroopMemberNewLevel(TroopMemberRankItem paramTroopMemberRankItem)
  {
    if (paramTroopMemberRankItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel item is null");
      }
      return;
    }
    setTroopMemberNewLevel(paramTroopMemberRankItem.jdField_a_of_type_Boolean, paramTroopMemberRankItem.jdField_b_of_type_Boolean, paramTroopMemberRankItem.jdField_b_of_type_Int, paramTroopMemberRankItem.jdField_a_of_type_JavaLangString, paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt, paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt, paramTroopMemberRankItem.d, paramTroopMemberRankItem.jdField_c_of_type_Int, paramTroopMemberRankItem.jdField_b_of_type_JavaLangString);
  }
  
  public void setTroopMemberNewLevel(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramBoolean1) && (!paramBoolean2) && ((paramInt1 < 1) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length < 2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("setTroopMemberNewLevel error isShowLevel : ");
        paramString1.append(paramBoolean1);
        paramString1.append(", isShowRank:");
        paramString1.append(paramBoolean2);
        paramString1.append(",newLevel:");
        paramString1.append(paramInt1);
        QLog.d("TroopMemberNewLevelView", 2, paramString1.toString());
      }
      return;
    }
    if ((paramBoolean2) && ((TextUtils.isEmpty(paramString1)) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length < 2)))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfInt1 = new StringBuilder();
        paramArrayOfInt1.append("setTroopMemberNewLevel error isShowRank:");
        paramArrayOfInt1.append(paramBoolean2);
        paramArrayOfInt1.append(",rankTitle:");
        paramArrayOfInt1.append(paramString1);
        QLog.d("TroopMemberNewLevelView", 2, paramArrayOfInt1.toString());
      }
      return;
    }
    if ((this.jdField_a_of_type_Boolean == paramBoolean1) && (this.jdField_b_of_type_Boolean == paramBoolean2) && (this.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)) && (Arrays.equals(paramArrayOfInt1, this.jdField_a_of_type_ArrayOfInt)) && (Arrays.equals(paramArrayOfInt2, this.jdField_b_of_type_ArrayOfInt)) && (this.jdField_b_of_type_Int == paramInt2) && (this.jdField_c_of_type_Int == paramInt3) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString2)))
    {
      setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel normal");
      }
      return;
    }
    removeAllViews();
    setVisibility(8);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    Object localObject;
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
      paramArrayOfInt1.setCornerRadius(ViewUtils.b(3.0F));
      setBackgroundDrawable(paramArrayOfInt1);
      setGravity(16);
      paramArrayOfInt1 = new RelativeLayout.LayoutParams(ViewUtils.a(10.0F), ViewUtils.a(6.0F));
      paramArrayOfInt1.leftMargin = ViewUtils.a(4.0F);
      paramArrayOfInt1.rightMargin = ViewUtils.a(0.5F);
      paramArrayOfInt2 = new ImageView(getContext());
      paramArrayOfInt2.setImageResource(jdField_c_of_type_ArrayOfInt[10]);
      paramArrayOfInt2.setColorFilter(paramInt2);
      paramArrayOfInt2.setContentDescription(HardCodeUtil.a(2131699502));
      a(paramArrayOfInt2, paramArrayOfInt1);
      addView(paramArrayOfInt2, paramArrayOfInt1);
      paramArrayOfInt2 = String.valueOf(paramInt1).toCharArray();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt2.length)
      {
        int i = paramArrayOfInt2[paramInt1] - '0';
        if ((i >= 0) && (i < 10))
        {
          localObject = new RelativeLayout.LayoutParams(ViewUtils.a(5.0F), ViewUtils.a(7.0F));
          ImageView localImageView = new ImageView(getContext());
          localImageView.setImageResource(jdField_c_of_type_ArrayOfInt[i]);
          localImageView.setColorFilter(paramInt2);
          if (paramInt1 != paramArrayOfInt2.length - 1) {
            ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(0.0F);
          }
          localImageView.setContentDescription(String.valueOf(i));
          a(localImageView, (RelativeLayout.LayoutParams)localObject);
          a((RelativeLayout.LayoutParams)localObject);
          addView(localImageView, (ViewGroup.LayoutParams)localObject);
        }
        paramInt1 += 1;
      }
      paramArrayOfInt2 = new TextView(getContext());
      paramArrayOfInt2.setText(paramString1);
      paramArrayOfInt2.setGravity(48);
      paramArrayOfInt2.setTextSize(2, 12.0F);
      paramArrayOfInt2.setIncludeFontPadding(false);
      paramArrayOfInt2.setEllipsize(TextUtils.TruncateAt.END);
      paramArrayOfInt2.setSingleLine();
      paramArrayOfInt2.setTypeface(Typeface.defaultFromStyle(1));
      paramArrayOfInt2.setTextColor(paramInt3);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(3.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(4.0F);
      a(paramArrayOfInt2, (RelativeLayout.LayoutParams)localObject);
      a((RelativeLayout.LayoutParams)localObject);
      paramArrayOfInt1.topMargin = ViewUtils.a(0.5F);
      paramArrayOfInt1.bottomMargin = ViewUtils.a(0.5F);
      this.jdField_a_of_type_Float = paramArrayOfInt2.getPaint().measureText(paramString1);
      addView(paramArrayOfInt2, (ViewGroup.LayoutParams)localObject);
      setVisibility(0);
    }
    else if (paramBoolean1)
    {
      paramString1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt1);
      paramString1.setCornerRadius(ViewUtils.b(3.0F));
      setBackgroundDrawable(paramString1);
      setGravity(16);
      paramArrayOfInt1 = new RelativeLayout.LayoutParams(ViewUtils.a(10.0F), ViewUtils.a(6.0F));
      paramArrayOfInt1.leftMargin = ViewUtils.a(4.0F);
      paramArrayOfInt1.rightMargin = ViewUtils.a(0.5F);
      paramString1 = new ImageView(getContext());
      paramString1.setColorFilter(paramInt2);
      paramString1.setImageResource(jdField_c_of_type_ArrayOfInt[10]);
      paramString1.setContentDescription(HardCodeUtil.a(2131699502));
      a(paramString1, paramArrayOfInt1);
      addView(paramString1, paramArrayOfInt1);
      paramArrayOfInt1 = String.valueOf(paramInt1).toCharArray();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt1.length)
      {
        paramInt3 = paramArrayOfInt1[paramInt1] - '0';
        if ((paramInt3 >= 0) && (paramInt3 < 10))
        {
          paramArrayOfInt2 = new RelativeLayout.LayoutParams(ViewUtils.a(5.0F), ViewUtils.a(7.0F));
          localObject = new ImageView(getContext());
          ((ImageView)localObject).setImageResource(jdField_c_of_type_ArrayOfInt[paramInt3]);
          paramString1.setColorFilter(paramInt2);
          if (paramInt1 == paramArrayOfInt1.length - 1) {
            paramArrayOfInt2.rightMargin = ViewUtils.a(4.0F);
          } else {
            paramArrayOfInt2.rightMargin = ViewUtils.a(0.0F);
          }
          paramArrayOfInt2.bottomMargin = ViewUtils.a(3.0F);
          paramArrayOfInt2.topMargin = ViewUtils.a(3.0F);
          ((ImageView)localObject).setContentDescription(String.valueOf(paramInt3));
          a((View)localObject, paramArrayOfInt2);
          a(paramArrayOfInt2);
          addView((View)localObject, paramArrayOfInt2);
        }
        paramInt1 += 1;
      }
      setVisibility(0);
    }
    else if (paramBoolean2)
    {
      paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
      paramArrayOfInt1.setCornerRadius(ViewUtils.b(3.0F));
      setBackgroundDrawable(paramArrayOfInt1);
      paramArrayOfInt1 = new TextView(getContext());
      paramArrayOfInt1.setText(paramString1);
      paramArrayOfInt1.setGravity(48);
      paramArrayOfInt1.setTextSize(2, 12.0F);
      paramArrayOfInt1.setIncludeFontPadding(false);
      paramArrayOfInt1.setEllipsize(TextUtils.TruncateAt.END);
      paramArrayOfInt1.setSingleLine();
      paramArrayOfInt1.setTypeface(Typeface.defaultFromStyle(1));
      paramArrayOfInt1.setTextColor(paramInt3);
      paramArrayOfInt2 = new RelativeLayout.LayoutParams(-2, -2);
      paramArrayOfInt2.leftMargin = ViewUtils.a(4.0F);
      paramArrayOfInt2.rightMargin = ViewUtils.a(4.0F);
      paramArrayOfInt2.topMargin = ViewUtils.a(0.5F);
      paramArrayOfInt2.bottomMargin = ViewUtils.a(0.5F);
      this.jdField_a_of_type_Float = paramArrayOfInt1.getPaint().measureText(paramString1);
      a(paramArrayOfInt1, paramArrayOfInt2);
      addView(paramArrayOfInt1, paramArrayOfInt2);
      setVisibility(0);
    }
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).clothEffectView(getContext(), this, (int)a(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView
 * JD-Core Version:    0.7.0.1
 */