package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GuildDefaultThemeNavBarCommon
  extends RelativeLayout
  implements View.OnClickListener
{
  protected boolean a = false;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private TextView g;
  private ImageView h;
  private TextView i;
  private ImageView j;
  private RelativeLayout k;
  private TextView l;
  private TextView m;
  private OnItemSelectListener n;
  private ViewStub o;
  private boolean p = true;
  private RelativeLayout q;
  private TextView r;
  
  public GuildDefaultThemeNavBarCommon(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GuildDefaultThemeNavBarCommon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public GuildDefaultThemeNavBarCommon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131625035, this);
    setBackgroundResource(2130840817);
    this.b = ((TextView)findViewById(2131436180));
    this.g = ((TextView)findViewById(2131448219));
    this.h = ((ImageView)findViewById(2131436666));
    this.c = ((TextView)findViewById(2131436182));
    this.d = ((TextView)findViewById(2131436227));
    this.k = ((RelativeLayout)findViewById(2131447534));
    this.l = ((TextView)findViewById(2131447581));
    this.m = ((TextView)findViewById(2131447497));
    this.e = ((TextView)findViewById(2131436211));
    this.j = ((ImageView)findViewById(2131436199));
    this.i = ((TextView)findViewById(2131436212));
    this.f = ((ImageView)findViewById(2131436194));
    this.o = ((ViewStub)findViewById(2131447498));
    this.q = ((RelativeLayout)findViewById(2131445049));
    this.r = ((TextView)this.q.findViewById(2131436211));
    a(true);
    if (AppSetting.e)
    {
      AccessibilityUtil.b(this.b, Button.class.getName());
      paramContext = this.g;
      if (paramContext != null) {
        AccessibilityUtil.b(paramContext, Button.class.getName());
      }
      paramContext = this.h;
      if (paramContext != null) {
        AccessibilityUtil.b(paramContext, Button.class.getName());
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
    int i1;
    if (paramBoolean) {
      i1 = 2131168464;
    } else {
      i1 = 2130840817;
    }
    setBackgroundResource(i1);
    ColorStateList localColorStateList = getResources().getColorStateList(2131166201);
    this.b.setTextColor(localColorStateList);
    TextView localTextView = this.b;
    if (paramBoolean) {
      i1 = 2130840740;
    } else {
      i1 = 2130841044;
    }
    localTextView.setBackgroundResource(i1);
    this.c.setTextColor(localColorStateList);
    this.g.setTextColor(localColorStateList);
    this.d.setTextColor(localColorStateList);
    this.e.setTextColor(localColorStateList);
    this.i.setTextColor(localColorStateList);
    this.r.setTextColor(localColorStateList);
  }
  
  public TextView getLeftBackIcon()
  {
    return this.b;
  }
  
  public TextView getRightViewText2()
  {
    return this.i;
  }
  
  public void onClick(View paramView)
  {
    if (this.n != null)
    {
      int i1 = 0;
      int i2 = paramView.getId();
      if ((i2 != 2131436180) && (i2 != 2131448219) && (i2 != 2131436666))
      {
        if (i2 == 2131436211) {
          i1 = 2;
        } else if (i2 == 2131436194) {
          i1 = 4;
        } else if (i2 == 2131436212) {
          i1 = 3;
        } else if (i2 == 2131436199) {
          i1 = 5;
        } else if ((i2 != 2131436227) && (i2 != 2131447534))
        {
          if (i2 == 2131436182) {
            i1 = 8;
          }
        }
        else {
          i1 = 7;
        }
      }
      else {
        i1 = 1;
      }
      if (i1 != 0) {
        this.n.onItemSelect(paramView, i1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCustomView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0F));
    this.d.setVisibility(8);
    localLayoutParams1.addRule(13, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    int i1 = ViewUtils.dip2px(24.0F);
    localLayoutParams2.leftMargin = i1;
    localLayoutParams2.rightMargin = i1;
    this.k.setLayoutParams(localLayoutParams2);
    this.k.addView(paramView, localLayoutParams1);
    this.k.setVisibility(0);
  }
  
  public void setLeftBackVisible(int paramInt)
  {
    ViewUtils.setVisible(this.b, paramInt);
  }
  
  public void setLeftButton(int paramInt)
  {
    this.b.setVisibility(8);
    this.c = ((TextView)findViewById(2131436182));
    setLayerType(this.c);
    this.c.setVisibility(0);
    this.c.setText(paramInt);
  }
  
  public void setLeftButton(String paramString)
  {
    this.b.setVisibility(8);
    this.c = ((TextView)findViewById(2131436182));
    setLayerType(this.c);
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if (this.b != null)
    {
      Object localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      Object localObject2 = getContext().getString(paramInt);
      TextView localTextView = this.b;
      localObject1 = localObject2;
      if ("".equals(localObject2)) {
        localObject1 = getContext().getString(2131887625);
      }
      if (this.p) {
        localTextView.setText("  ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains(getContext().getString(2131887625)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getContext().getString(2131887625));
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        this.b.setContentDescription((CharSequence)localObject2);
      }
    }
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    Object localObject;
    if ((this.b != null) && (paramBundle != null))
    {
      localObject = this.c;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.b;
      String str = paramBundle.getString("leftViewText");
      int i1 = paramBundle.getInt("individuation_url_type");
      localObject = str;
      if (i1 >= 40300)
      {
        localObject = str;
        if (i1 <= 40313)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (str.contains(HardCodeUtil.a(2131904954))) {
              localObject = getContext().getString(2131887625);
            }
          }
        }
      }
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = getContext().getString(2131887625);
      }
      if (this.p) {
        localTextView.setText("  ");
      } else {
        localTextView.setText(paramBundle);
      }
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject = paramBundle;
        if (!paramBundle.contains(getContext().getString(2131887625)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(getContext().getString(2131887625));
          ((StringBuilder)localObject).append(paramBundle);
          localObject = ((StringBuilder)localObject).toString();
        }
        this.b.setContentDescription((CharSequence)localObject);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public void setNotShowLeftText(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setOnItemSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.n = paramOnItemSelectListener;
    this.b.setOnClickListener(this);
    paramOnItemSelectListener = this.g;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    paramOnItemSelectListener = this.h;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    paramOnItemSelectListener = this.c;
    if (paramOnItemSelectListener != null) {
      paramOnItemSelectListener.setOnClickListener(this);
    }
    this.e.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public void setRightButton(int paramInt)
  {
    this.e.setVisibility(0);
    this.j.setVisibility(8);
    this.e.setText(paramInt);
    this.e.setEnabled(true);
    if (AppSetting.e)
    {
      TextView localTextView = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getText());
      localStringBuilder.append(HardCodeUtil.a(2131904955));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightButton(String paramString)
  {
    this.e.setVisibility(0);
    this.j.setVisibility(8);
    this.e.setText(paramString);
    this.e.setEnabled(true);
    if (AppSetting.e)
    {
      paramString = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getText());
      localStringBuilder.append(HardCodeUtil.a(2131904955));
      paramString.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightButton2(int paramInt)
  {
    this.i.setVisibility(0);
    this.f.setVisibility(8);
    this.i.setText(paramInt);
    this.i.setEnabled(true);
    if (AppSetting.e)
    {
      TextView localTextView = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getText());
      localStringBuilder.append(HardCodeUtil.a(2131904955));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void setRightImage(Drawable paramDrawable)
  {
    this.j.setVisibility(0);
    this.e.setVisibility(8);
    this.j.setImageDrawable(paramDrawable);
  }
  
  public void setRightImage(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.j.setVisibility(0);
    this.e.setVisibility(8);
    this.j.setImageDrawable(paramDrawable1);
    this.j.setBackgroundDrawable(paramDrawable2);
  }
  
  public void setRightImage2(Drawable paramDrawable)
  {
    this.f.setImageDrawable(paramDrawable);
    this.f.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  public void setRightImage2Desc(String paramString)
  {
    this.f.setContentDescription(paramString);
  }
  
  public void setRightImageDesc(String paramString)
  {
    this.j.setContentDescription(paramString);
  }
  
  public void setRightViewTextVisible(int paramInt)
  {
    ViewUtils.setVisible(this.e, paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      localTextView.setText(paramCharSequence);
      this.d.setVisibility(0);
    }
    paramCharSequence = this.k;
    if (paramCharSequence != null) {
      paramCharSequence.setVisibility(8);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    if (this.d.getVisibility() != 8) {
      this.d.setVisibility(8);
    }
    if (this.k.getVisibility() != 0) {
      this.k.setVisibility(0);
    }
    if (!TextUtils.equals(paramCharSequence1, this.l.getText()))
    {
      this.l.setText(paramCharSequence1);
      this.l.setContentDescription(paramCharSequence2);
    }
    if (!TextUtils.equals(paramCharSequence3, this.m.getText()))
    {
      this.m.setText(paramCharSequence3);
      this.m.setContentDescription(paramCharSequence4);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      if (localTextView.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
      if (!TextUtils.equals(paramCharSequence, this.d.getText())) {
        this.d.setText(paramCharSequence);
      }
      if ((!TextUtils.equals(paramString, this.d.getContentDescription())) && (AppSetting.e)) {
        this.d.setContentDescription(paramString);
      }
    }
    paramCharSequence = this.k;
    if ((paramCharSequence != null) && (paramCharSequence.getVisibility() != 8)) {
      this.k.setVisibility(8);
    }
  }
  
  public void setTitleColor(int paramInt)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      localTextView.setTextColor(paramInt);
      this.d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon
 * JD-Core Version:    0.7.0.1
 */