package com.tencent.mobileqq.onlinestatus;

import actn;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import auja;
import aujd;
import aujh;
import aykp;
import bftj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;

public class OnlineStatusItemView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public aujh a;
  public boolean a;
  public boolean b;
  
  public OnlineStatusItemView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a()
  {
    return "";
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131371047);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371048);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (localObject = "#FFFFFF";; localObject = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor((String)localObject));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = actn.a(8.0F, getResources());
      addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public void a()
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    setOrientation(0);
    setGravity(17);
    if (bool) {}
    for (int i = 2130839159;; i = 2130839160)
    {
      setBackgroundResource(i);
      this.jdField_a_of_type_Int = actn.a(16.0F, getResources());
      b(bool);
      return;
    }
  }
  
  public void a(aujh paramaujh)
  {
    if (paramaujh == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Aujh = paramaujh;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaujh.jdField_a_of_type_JavaLangString);
      if (paramaujh.jdField_a_of_type_Int == 2) {
        paramaujh = aujd.a(paramaujh.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      while (paramaujh != null)
      {
        paramaujh.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramaujh);
        return;
        if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(a())))
        {
          paramaujh = new ayki(a(), 3).a[0];
          if ((paramaujh instanceof aykp)) {
            paramaujh = ((aykp)paramaujh).a();
          }
        }
        else
        {
          if (auja.a().a(paramaujh))
          {
            int i = auja.a();
            paramaujh = new bftj().a(i, 1);
            continue;
          }
          paramaujh = URLDrawable.getDrawable(this.jdField_a_of_type_Aujh.b, URLDrawable.URLDrawableOptions.obtain());
          continue;
        }
        paramaujh = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    int i;
    TextView localTextView;
    String str;
    if (bool)
    {
      i = 2130839159;
      setBackgroundResource(i);
      this.b = paramBoolean;
      setSelected(paramBoolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label65;
      }
      str = "#FFFFFF";
    }
    for (;;)
    {
      localTextView.setTextColor(Color.parseColor(str));
      invalidate();
      return;
      i = 2130839160;
      break;
      label65:
      if (paramBoolean) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */