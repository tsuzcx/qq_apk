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
  private final View a;
  private final View b;
  private final TextView c;
  private final View d;
  private final KandianUrlImageView e;
  
  public DailyTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    this.a = findViewById(2131437797);
    this.b = findViewById(2131437802);
    this.c = ((TextView)findViewById(2131448824));
    this.e = ((KandianUrlImageView)findViewById(2131436617));
    this.d = findViewById(2131447592);
  }
  
  private void a(Context paramContext)
  {
    setPadding(getPaddingLeft(), getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramContext), getPaddingRight(), getPaddingBottom());
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2131626218, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.DailyTitleBar, 0, 0);
    for (;;)
    {
      int i;
      try
      {
        String str = paramAttributeSet.getString(3);
        i = paramAttributeSet.getColor(4, -16777216);
        int j = paramAttributeSet.getResourceId(0, 2131168464);
        k = paramAttributeSet.getResourceId(2, 2130844063);
        m = paramAttributeSet.getResourceId(1, 2130844287);
        setBackgroundResource(j);
        localTextView = (TextView)findViewById(2131448824);
        localTextView.setText(str);
        localTextView.setTextColor(i);
        if ((i != -1) && (i != 16777215)) {
          break label175;
        }
        findViewById(2131436617).setVisibility(8);
      }
      finally
      {
        int k;
        int m;
        TextView localTextView;
        paramAttributeSet.recycle();
      }
      localTextView.setVisibility(8);
      findViewById(2131436275).setBackgroundResource(k);
      findViewById(2131436567).setBackgroundResource(m);
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
    Object localObject1 = (KandianUrlImageView)findViewById(2131436617);
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
    if ((this.a != null) && (paramOnClickListener != null))
    {
      QLog.d("DailyTitleBar", 1, "on startButton click!");
      this.a.setOnClickListener(paramOnClickListener);
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
    Object localObject = this.c;
    if ((localObject != null) && (paramOnClickListener != null)) {
      ((TextView)localObject).setOnClickListener(paramOnClickListener);
    }
    localObject = this.e;
    if ((localObject != null) && (paramOnClickListener != null)) {
      ((KandianUrlImageView)localObject).setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleText(String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleTextSize(float paramFloat)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setTextSize(2, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTitleBar
 * JD-Core Version:    0.7.0.1
 */