package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class DailyTitleBar
  extends FrameLayout
{
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private final View b;
  private final View c;
  
  public DailyTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370524);
    this.b = findViewById(2131370529);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379938));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)findViewById(2131369527));
    this.c = findViewById(2131378890);
  }
  
  private void a(Context paramContext)
  {
    setPadding(getPaddingLeft(), getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramContext), getPaddingRight(), getPaddingBottom());
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2131560171, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.DailyTitleBar, 0, 0);
    for (;;)
    {
      int i;
      try
      {
        String str = paramAttributeSet.getString(3);
        i = paramAttributeSet.getColor(4, -16777216);
        int j = paramAttributeSet.getResourceId(0, 2131167394);
        k = paramAttributeSet.getResourceId(2, 2130843108);
        m = paramAttributeSet.getResourceId(1, 2130843333);
        setBackgroundResource(j);
        localTextView = (TextView)findViewById(2131379938);
        localTextView.setText(str);
        localTextView.setTextColor(i);
        if ((i != -1) && (i != 16777215)) {
          break label175;
        }
        findViewById(2131369527).setVisibility(8);
      }
      finally
      {
        int k;
        int m;
        TextView localTextView;
        paramAttributeSet.recycle();
      }
      localTextView.setVisibility(8);
      findViewById(2131369289).setBackgroundResource(k);
      findViewById(2131369491).setBackgroundResource(m);
      paramAttributeSet.recycle();
      setClickable(true);
      a(paramContext);
      b(paramContext);
      return;
      label175:
      if (i != -16777216) {
        if (i != 0) {}
      }
    }
  }
  
  private void b(Context paramContext)
  {
    Object localObject1 = (KandianUrlImageView)findViewById(2131369527);
    if (localObject1 != null)
    {
      Object localObject2 = Aladdin.getConfig(226);
      if (localObject2 != null)
      {
        int i = ((AladdinConfig)localObject2).getIntegerFromString("daily_title_url_switch", 0);
        localObject2 = ((AladdinConfig)localObject2).getString("daily_title_url", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initTitleBarImage], urlSwitch = ");
        localStringBuilder.append(i);
        localStringBuilder.append(", url = ");
        localStringBuilder.append((String)localObject2);
        QLog.i("DailyTitleBar", 1, localStringBuilder.toString());
        if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          try
          {
            ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject1, new URL((String)localObject2), paramContext);
            return;
          }
          catch (MalformedURLException paramContext)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[initTitleBarImage], e = ");
            ((StringBuilder)localObject1).append(paramContext);
            QLog.e("DailyTitleBar", 1, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramOnClickListener != null))
    {
      QLog.d("DailyTitleBar", 1, "on startButton click!");
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    View localView = this.b;
    if ((localView != null) && (paramOnClickListener != null)) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (paramOnClickListener != null)) {
      ((TextView)localObject).setOnClickListener(paramOnClickListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    if ((localObject != null) && (paramOnClickListener != null)) {
      ((KandianUrlImageView)localObject).setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleText(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleTextSize(float paramFloat)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextSize(2, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTitleBar
 * JD-Core Version:    0.7.0.1
 */