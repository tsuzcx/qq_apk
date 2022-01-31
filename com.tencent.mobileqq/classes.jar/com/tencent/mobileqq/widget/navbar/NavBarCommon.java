package com.tencent.mobileqq.widget.navbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class NavBarCommon
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OnItemSelectListener jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public NavBarCommon(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2130968838, this);
    setBackgroundResource(2130845871);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.e = ((TextView)findViewById(2131363995));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363994));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363473));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363380));
    this.g = ((TextView)findViewById(2131363470));
    this.h = ((TextView)findViewById(2131363471));
    this.d = ((TextView)findViewById(2131363428));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363475));
    this.f = ((TextView)findViewById(2131364024));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363474));
    if (AppSetting.b)
    {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
      if (this.e != null) {
        AccessibilityUtil.b(this.e, Button.class.getName());
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        AccessibilityUtil.b(this.jdField_b_of_type_AndroidWidgetImageView, Button.class.getName());
      }
    }
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void a(boolean paramBoolean)
  {
    ColorStateList localColorStateList;
    TextView localTextView;
    if (paramBoolean)
    {
      i = 2131492969;
      setBackgroundResource(i);
      localColorStateList = getResources().getColorStateList(2131494211);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 2130839142;; i = 2130846264)
    {
      localTextView.setBackgroundResource(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      this.e.setTextColor(localColorStateList);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      this.d.setTextColor(localColorStateList);
      this.f.setTextColor(localColorStateList);
      return;
      i = 2130845871;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener == null) {}
    for (;;)
    {
      return;
      int i = 0;
      switch (paramView.getId())
      {
      }
      while (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener.a(paramView, i);
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 4;
        continue;
        i = 3;
        continue;
        i = 5;
        continue;
        i = 7;
      }
    }
  }
  
  public void setCustomView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, AIOUtils.a(29.0F, getResources()));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams1.addRule(13, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i = AIOUtils.a(24.0F, getResources());
    localLayoutParams2.leftMargin = i;
    localLayoutParams2.rightMargin = i;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, localLayoutParams1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void setLeftButton(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363473));
    setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setLeftButton(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363473));
    setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      String str2 = getContext().getString(paramInt);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str1 = str2;
      if ("".equals(str2)) {
        str1 = getContext().getString(2131433698);
      }
      localTextView.setText(str1);
      localTextView.setVisibility(0);
      if (AppSetting.b)
      {
        str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        str1 = str2;
        if (!str2.contains(getContext().getString(2131433698))) {
          str1 = getContext().getString(2131433698) + str2;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str1);
      }
    }
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBundle != null)) {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      Object localObject = paramBundle.getString("leftViewText");
      int i = paramBundle.getInt("individuation_url_type");
      paramBundle = (Bundle)localObject;
      if (i >= 40300)
      {
        paramBundle = (Bundle)localObject;
        if (i <= 40313)
        {
          paramBundle = (Bundle)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramBundle = (Bundle)localObject;
            if (((String)localObject).contains("消息")) {
              paramBundle = getContext().getString(2131433698);
            }
          }
        }
      }
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = getContext().getString(2131433698);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.b)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramBundle = (Bundle)localObject;
        if (!((String)localObject).contains(getContext().getString(2131433698))) {
          paramBundle = getContext().getString(2131433698) + (String)localObject;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public void setOnItemSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener = paramOnItemSelectListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.e != null) {
      this.e.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    this.d.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public void setRightButton(int paramInt)
  {
    this.d.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setText(paramInt);
    this.d.setEnabled(true);
    if (AppSetting.b) {
      this.d.setContentDescription(this.d.getText() + "按钮");
    }
  }
  
  public void setRightButton(String paramString)
  {
    this.d.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setText(paramString);
    this.d.setEnabled(true);
    if (AppSetting.b) {
      this.d.setContentDescription(this.d.getText() + "按钮");
    }
  }
  
  public void setRightButton2(int paramInt)
  {
    this.f.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.f.setText(paramInt);
    this.f.setEnabled(true);
    if (AppSetting.b) {
      this.d.setContentDescription(this.d.getText() + "按钮");
    }
  }
  
  public void setRightImage(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setRightImage2(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.f.setVisibility(8);
  }
  
  public void setRightImage2Desc(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightImageDesc(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (!TextUtils.equals(paramCharSequence1, this.g.getText()))
    {
      this.g.setText(paramCharSequence1);
      this.g.setContentDescription(paramCharSequence2);
    }
    if (!TextUtils.equals(paramCharSequence3, this.h.getText()))
    {
      this.h.setText(paramCharSequence3);
      this.h.setContentDescription(paramCharSequence4);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!TextUtils.equals(paramCharSequence, this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      if ((!TextUtils.equals(paramString, this.jdField_c_of_type_AndroidWidgetTextView.getContentDescription())) && (AppSetting.b)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      }
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void setTitleColor(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarCommon
 * JD-Core Version:    0.7.0.1
 */