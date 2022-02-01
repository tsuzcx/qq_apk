package com.tencent.mobileqq.onlinestatus;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azhq;
import azhv;
import azib;
import begw;
import blns;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import mve;

public class OnlineStatusItemView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public azib a;
  public boolean a;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public OnlineStatusItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a()
  {
    return "";
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
    this.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    int i = agej.a(16.0F, getResources());
    int j = agej.a(7.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(null);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(getResources().getDrawable(2130840250));
    addView(this.jdField_a_of_type_AndroidWidgetCheckBox, localLayoutParams);
  }
  
  private void c()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    addView(localLinearLayout, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131372062);
    localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131372063);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = agej.a(4.0F, getResources());
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = agej.a(24.0F, getResources());
    c();
    if (this.e) {
      b();
    }
    setOnTouchListener(new mve());
  }
  
  public void a(azib paramazib)
  {
    if (paramazib == null) {
      return;
    }
    this.jdField_a_of_type_Azib = paramazib;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramazib.jdField_a_of_type_JavaLangString);
    if (paramazib.jdField_a_of_type_Int == 2) {
      paramazib = azhv.a(paramazib.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    for (;;)
    {
      if (paramazib != null)
      {
        paramazib.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramazib);
      }
      boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
      int i;
      label82:
      int j;
      label92:
      TextView localTextView;
      if (this.c)
      {
        i = 2130839431;
        if (!this.d) {
          break label235;
        }
        j = 2130839392;
        if (bool) {
          i = j;
        }
        setBackgroundResource(i);
        localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!bool) {
          break label242;
        }
      }
      label235:
      label242:
      for (paramazib = "#FFFFFF";; paramazib = "#03081A")
      {
        localTextView.setTextColor(Color.parseColor(paramazib));
        return;
        if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(a())))
        {
          paramazib = new begp(a(), 3).a[0];
          if (!(paramazib instanceof begw)) {
            break label249;
          }
          paramazib = ((begw)paramazib).a();
          break;
        }
        if (azhq.a().a(paramazib))
        {
          i = azhq.a();
          paramazib = new blns().a(i, 1);
          break;
        }
        paramazib = URLDrawable.getDrawable(this.jdField_a_of_type_Azib.b, URLDrawable.URLDrawableOptions.obtain());
        break;
        i = 2130839430;
        break label82;
        j = 2130839429;
        break label92;
      }
      label249:
      paramazib = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    int i;
    int j;
    if (this.c)
    {
      i = 2130839431;
      if (!this.d) {
        break label103;
      }
      j = 2130839392;
      label29:
      if (bool) {
        i = j;
      }
      setBackgroundResource(i);
      this.b = paramBoolean;
      if (!this.e) {
        break label118;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label110;
      }
    }
    label103:
    label110:
    for (String str = "#FFFFFF";; str = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor(str));
      setSelected(false);
      invalidate();
      return;
      i = 2130839430;
      break;
      j = 2130839429;
      break label29;
    }
    label118:
    setSelected(paramBoolean);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {
      str = "#FFFFFF";
    }
    for (;;)
    {
      localTextView.setTextColor(Color.parseColor(str));
      break;
      if (paramBoolean) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
  
  public void setMultiMode(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setUseLightNightBg(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setUseWhiteBg(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */