package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;

public class CustomButton
{
  private static final String TAG = "CustomButton";
  private Context mContext;
  private ImageButton mImageButton;
  private CustomButton.ButtonParam mParams;
  private Button mTextButton;
  
  public CustomButton(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Drawable getBackgroundDrawable(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramFloat);
    return localGradientDrawable;
  }
  
  private void setImageButton(CustomButton.ButtonParam paramButtonParam)
  {
    if ((this.mImageButton == null) || (paramButtonParam == null)) {
      return;
    }
    if ((paramButtonParam.style == null) || (!TextUtils.isEmpty(paramButtonParam.style.borderColor))) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor(paramButtonParam.style.borderColor);
        if (Build.VERSION.SDK_INT < 16) {
          break label139;
        }
        this.mImageButton.setBackground(getBackgroundDrawable(0, paramButtonParam.style.borderWidth, i, paramButtonParam.style.borderRadius));
        this.mImageButton.setPadding(paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth);
        this.mImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("CustomButton", "setmImageButton strokeColor error ", localThrowable);
      }
      int i = 0;
      continue;
      label139:
      this.mImageButton.setBackgroundDrawable(getBackgroundDrawable(0, paramButtonParam.style.borderWidth, i, paramButtonParam.style.borderRadius));
    }
  }
  
  private void setTextAlign(CustomButton.ButtonParam paramButtonParam)
  {
    if ("left".equals(paramButtonParam.style.textAlign)) {
      this.mTextButton.setGravity(8388611);
    }
    do
    {
      return;
      if ("center".equals(paramButtonParam.style.textAlign))
      {
        this.mTextButton.setGravity(1);
        return;
      }
    } while (!"right".equals(paramButtonParam.style.textAlign));
    this.mTextButton.setGravity(8388613);
  }
  
  private void setTextButton(CustomButton.ButtonParam paramButtonParam)
  {
    if ((this.mTextButton == null) || (paramButtonParam == null)) {}
    do
    {
      return;
      this.mTextButton.setText(paramButtonParam.text);
      this.mTextButton.setPadding(0, 0, 0, 0);
    } while (paramButtonParam.style == null);
    if (!TextUtils.isEmpty(paramButtonParam.style.backgroundColor)) {}
    for (;;)
    {
      try
      {
        i = ColorUtils.parseColor(paramButtonParam.style.backgroundColor);
        if (TextUtils.isEmpty(paramButtonParam.style.borderColor)) {
          break label277;
        }
      }
      catch (Throwable localThrowable1)
      {
        QMLog.e("CustomButton", "setmTextButton bgColor error ", localThrowable1);
      }
      try
      {
        j = ColorUtils.parseColor(paramButtonParam.style.borderColor);
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.mTextButton.setBackground(getBackgroundDrawable(i, paramButtonParam.style.borderWidth, j, paramButtonParam.style.borderRadius));
          if (!TextUtils.isEmpty(paramButtonParam.style.color)) {
            i = -16777216;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        QMLog.e("CustomButton", "setmTextButton strokeColor error ", localThrowable2);
      }
      try
      {
        j = ColorUtils.parseColor(paramButtonParam.style.color);
        i = j;
      }
      catch (Throwable localThrowable3)
      {
        QMLog.e("CustomButton", "setmTextButton textColor error ", localThrowable3);
        continue;
      }
      this.mTextButton.setTextColor(i);
      setTextAlign(paramButtonParam);
      if (paramButtonParam.style.fontSize > 0) {
        this.mTextButton.setTextSize(paramButtonParam.style.fontSize);
      }
      if (paramButtonParam.style.lineHeight < 0) {
        break;
      }
      int i = this.mTextButton.getPaint().getFontMetricsInt(null);
      i = paramButtonParam.style.lineHeight - i;
      this.mTextButton.setLineSpacing(i, 1.0F);
      i /= 2;
      this.mTextButton.setPadding(0, i, 0, 0);
      return;
      i = 0;
      continue;
      label277:
      int j = 0;
      continue;
      this.mTextButton.setBackgroundDrawable(getBackgroundDrawable(i, paramButtonParam.style.borderWidth, j, paramButtonParam.style.borderRadius));
    }
  }
  
  public void destroy()
  {
    this.mContext = null;
    this.mImageButton = null;
    this.mTextButton = null;
  }
  
  public View getButton()
  {
    if (this.mTextButton != null) {
      return this.mTextButton;
    }
    if (this.mImageButton != null) {
      return this.mImageButton;
    }
    return null;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.mImageButton != null) && (paramDrawable != null)) {
      this.mImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setParam(CustomButton.ButtonParam paramButtonParam, View.OnClickListener paramOnClickListener)
  {
    this.mParams = paramButtonParam;
    if (this.mParams != null)
    {
      if ((!"text".equals(this.mParams.type)) || (this.mTextButton != null)) {
        break label73;
      }
      this.mTextButton = new Button(this.mContext);
      this.mTextButton.setOnClickListener(paramOnClickListener);
    }
    label73:
    do
    {
      while (this.mTextButton != null)
      {
        setTextButton(this.mParams);
        return;
        if (("image".equals(this.mParams.type)) && (this.mImageButton == null))
        {
          this.mImageButton = new ImageButton(this.mContext);
          this.mImageButton.setOnClickListener(paramOnClickListener);
        }
      }
    } while (this.mImageButton == null);
    setImageButton(this.mParams);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    View localView;
    if (getButton() != null)
    {
      localView = getButton();
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.CustomButton
 * JD-Core Version:    0.7.0.1
 */