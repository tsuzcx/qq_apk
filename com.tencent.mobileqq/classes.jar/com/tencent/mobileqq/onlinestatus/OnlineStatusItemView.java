package com.tencent.mobileqq.onlinestatus;

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
import axuy;
import axvd;
import axvj;
import bjsc;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.theme.ThemeUtil;
import mun;

public class OnlineStatusItemView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public axvj a;
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
    int i = AIOUtils.dp2px(16.0F, getResources());
    int j = AIOUtils.dp2px(7.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(null);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(getResources().getDrawable(2130840288));
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
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131372027);
    localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131372028);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = AIOUtils.dp2px(4.0F, getResources());
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = AIOUtils.dp2px(24.0F, getResources());
    c();
    if (this.e) {
      b();
    }
    setOnTouchListener(new mun());
  }
  
  public void a(axvj paramaxvj)
  {
    if (paramaxvj == null) {
      return;
    }
    this.jdField_a_of_type_Axvj = paramaxvj;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaxvj.jdField_a_of_type_JavaLangString);
    if (paramaxvj.jdField_a_of_type_Int == 2) {
      paramaxvj = axvd.a(paramaxvj.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    for (;;)
    {
      if (paramaxvj != null)
      {
        paramaxvj.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramaxvj);
      }
      boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
      int i;
      label82:
      int j;
      label92:
      TextView localTextView;
      if (this.c)
      {
        i = 2130839466;
        if (!this.d) {
          break label235;
        }
        j = 2130839427;
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
      for (paramaxvj = "#FFFFFF";; paramaxvj = "#03081A")
      {
        localTextView.setTextColor(Color.parseColor(paramaxvj));
        return;
        if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(a())))
        {
          paramaxvj = new com.tencent.mobileqq.text.QQText(a(), 3).mSpans[0];
          if (!(paramaxvj instanceof QQText.EmoticonSpan)) {
            break label249;
          }
          paramaxvj = ((QQText.EmoticonSpan)paramaxvj).getDrawable();
          break;
        }
        if (axuy.a().a(paramaxvj))
        {
          i = axuy.a();
          paramaxvj = new bjsc().a(i, 1);
          break;
        }
        paramaxvj = URLDrawable.getDrawable(this.jdField_a_of_type_Axvj.b, URLDrawable.URLDrawableOptions.obtain());
        break;
        i = 2130839465;
        break label82;
        j = 2130839464;
        break label92;
      }
      label249:
      paramaxvj = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    int i;
    int j;
    if (this.c)
    {
      i = 2130839466;
      if (!this.d) {
        break label103;
      }
      j = 2130839427;
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
      i = 2130839465;
      break;
      j = 2130839464;
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