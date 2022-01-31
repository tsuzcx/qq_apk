package com.tencent.mobileqq.widget.navbar;

import aciy;
import ajjy;
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
import azve;
import bajq;
import bbpw;
import com.tencent.common.config.AppSetting;

public class NavBarCommon
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbpw jdField_a_of_type_Bbpw;
  private boolean jdField_a_of_type_Boolean = true;
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
    View.inflate(paramContext, 2131493318, this);
    setBackgroundResource(2130848801);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.e = ((TextView)findViewById(2131312188));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303102));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131311586));
    this.g = ((TextView)findViewById(2131311625));
    this.h = ((TextView)findViewById(2131311563));
    this.d = ((TextView)findViewById(2131302832));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302821));
    this.f = ((TextView)findViewById(2131302833));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302816));
    if (AppSetting.c)
    {
      azve.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
      if (this.e != null) {
        azve.b(this.e, Button.class.getName());
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        azve.b(this.jdField_b_of_type_AndroidWidgetImageView, Button.class.getName());
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    ColorStateList localColorStateList;
    TextView localTextView;
    if (paramBoolean)
    {
      i = 2131101537;
      setBackgroundResource(i);
      localColorStateList = getResources().getColorStateList(2131101255);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 2130839699;; i = 2130849303)
    {
      localTextView.setBackgroundResource(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      this.e.setTextColor(localColorStateList);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      this.d.setTextColor(localColorStateList);
      this.f.setTextColor(localColorStateList);
      return;
      i = 2130848801;
      break;
    }
  }
  
  public void b()
  {
    bajq.b(this.jdField_b_of_type_AndroidWidgetTextView, 8);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bbpw == null) {}
    for (;;)
    {
      return;
      int i = 0;
      switch (paramView.getId())
      {
      }
      while (i != 0)
      {
        this.jdField_a_of_type_Bbpw.a(paramView, i);
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
        continue;
        i = 8;
      }
    }
  }
  
  public void setCustomView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, aciy.a(29.0F, getResources()));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams1.addRule(13, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i = aciy.a(24.0F, getResources());
    localLayoutParams2.leftMargin = i;
    localLayoutParams2.rightMargin = i;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, localLayoutParams1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void setLeftBackVisible(int paramInt)
  {
    bajq.b(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
  }
  
  public void setLeftButton(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
    setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setLeftButton(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
    setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setLeftViewName(int paramInt)
  {
    Object localObject2;
    TextView localTextView;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = getContext().getString(paramInt);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject1 = localObject2;
      if ("".equals(localObject2)) {
        localObject1 = getContext().getString(2131625011);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label139;
      }
      localTextView.setText("  ");
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      if (AppSetting.c)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains(getContext().getString(2131625011))) {
          localObject2 = getContext().getString(2131625011) + (String)localObject1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject2);
      }
      return;
      label139:
      localTextView.setText((CharSequence)localObject1);
    }
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBundle != null))
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
              if (((String)localObject).contains(ajjy.a(2131641294))) {
                paramBundle = getContext().getString(2131625011);
              }
            }
          }
        }
        localObject = paramBundle;
        if (paramBundle == null) {
          localObject = getContext().getString(2131625011);
        }
        if (this.jdField_a_of_type_Boolean) {
          localTextView.setText("  ");
        }
        for (;;)
        {
          localTextView.setVisibility(0);
          if (!AppSetting.c) {
            break;
          }
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).contains(getContext().getString(2131625011))) {
            paramBundle = getContext().getString(2131625011) + (String)localObject;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
          return;
          localTextView.setText((CharSequence)localObject);
        }
        return;
      }
      catch (Exception paramBundle) {}
    }
  }
  
  public void setOnItemSelectListener(bbpw parambbpw)
  {
    this.jdField_a_of_type_Bbpw = parambbpw;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.e != null) {
      this.e.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
    if (AppSetting.c) {
      this.d.setContentDescription(this.d.getText() + ajjy.a(2131641295));
    }
  }
  
  public void setRightButton(String paramString)
  {
    this.d.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setText(paramString);
    this.d.setEnabled(true);
    if (AppSetting.c) {
      this.d.setContentDescription(this.d.getText() + ajjy.a(2131641293));
    }
  }
  
  public void setRightButton2(int paramInt)
  {
    this.f.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.f.setText(paramInt);
    this.f.setEnabled(true);
    if (AppSetting.c) {
      this.d.setContentDescription(this.d.getText() + ajjy.a(2131641296));
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
  
  public void setRightViewTextVisible(int paramInt)
  {
    bajq.b(this.d, paramInt);
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
      if ((!TextUtils.equals(paramString, this.jdField_c_of_type_AndroidWidgetTextView.getContentDescription())) && (AppSetting.c)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarCommon
 * JD-Core Version:    0.7.0.1
 */