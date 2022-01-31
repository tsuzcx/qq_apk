package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awga;
import balw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class RobotChatTipLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference<awga> jdField_a_of_type_JavaLangRefWeakReference;
  
  public RobotChatTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(awga paramawga)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramawga);
    LayoutInflater.from(getContext()).inflate(2131561149, this);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378370));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368533));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)) {
      setBackgroundColor(-1);
    }
    for (;;)
    {
      setVisibility(8);
      return;
      setBackgroundColor(-5066062);
      findViewById(2131368557).setBackgroundColor(-10197916);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramView = (awga)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(this);
      }
    }
  }
  
  public void setRobotName(String paramString)
  {
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = getResources().getString(2131718801);
    }
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    String str2;
    if ((paramString != null) && ((paramString instanceof QQAppInterface)))
    {
      str2 = ((balw)((QQAppInterface)paramString).getManager(203)).a();
      paramString = str2;
      if (TextUtils.isEmpty(str2)) {}
    }
    int i;
    do
    {
      for (;;)
      {
        try
        {
          paramString = str2.replace("[name]", "%1$s");
          str2 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str2 = getResources().getString(2131718796);
          }
          paramString = String.format(str2, new Object[] { str1 });
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString))) {
            break;
          }
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("RobotChatTipLayout", 2, "setRobotName exception: " + paramString);
        }
        paramString = null;
      }
      i = paramString.indexOf(str1, 4);
    } while (i < 0);
    paramString = new SpannableString(paramString);
    paramString.setSpan(new ForegroundColorSpan(-11692801), i, str1.length() + i, 33);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatTipLayout
 * JD-Core Version:    0.7.0.1
 */