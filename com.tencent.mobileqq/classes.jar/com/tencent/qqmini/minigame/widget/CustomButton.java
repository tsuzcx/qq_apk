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
    if (this.mImageButton != null)
    {
      if (paramButtonParam == null) {
        return;
      }
      if (paramButtonParam.style != null)
      {
        int i;
        if (!TextUtils.isEmpty(paramButtonParam.style.borderColor)) {
          try
          {
            i = Color.parseColor(paramButtonParam.style.borderColor);
          }
          catch (Throwable localThrowable)
          {
            QMLog.e("CustomButton", "setmImageButton strokeColor error ", localThrowable);
          }
        } else {
          i = 0;
        }
        if (Build.VERSION.SDK_INT >= 16) {
          this.mImageButton.setBackground(getBackgroundDrawable(0, paramButtonParam.style.borderWidth, i, paramButtonParam.style.borderRadius));
        } else {
          this.mImageButton.setBackgroundDrawable(getBackgroundDrawable(0, paramButtonParam.style.borderWidth, i, paramButtonParam.style.borderRadius));
        }
        this.mImageButton.setPadding(paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth, paramButtonParam.style.borderWidth);
      }
      this.mImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void setTextAlign(CustomButton.ButtonParam paramButtonParam)
  {
    if ("left".equals(paramButtonParam.style.textAlign))
    {
      this.mTextButton.setGravity(8388611);
      return;
    }
    if ("center".equals(paramButtonParam.style.textAlign))
    {
      this.mTextButton.setGravity(1);
      return;
    }
    if ("right".equals(paramButtonParam.style.textAlign)) {
      this.mTextButton.setGravity(8388613);
    }
  }
  
  private void setTextButton(CustomButton.ButtonParam paramButtonParam)
  {
    Button localButton = this.mTextButton;
    if (localButton != null)
    {
      if (paramButtonParam == null) {
        return;
      }
      localButton.setText(paramButtonParam.text);
      this.mTextButton.setPadding(0, 0, 0, 0);
      if (paramButtonParam.style != null)
      {
        int i;
        if (!TextUtils.isEmpty(paramButtonParam.style.backgroundColor)) {
          try
          {
            i = ColorUtils.parseColor(paramButtonParam.style.backgroundColor);
          }
          catch (Throwable localThrowable1)
          {
            QMLog.e("CustomButton", "setmTextButton bgColor error ", localThrowable1);
          }
        } else {
          i = 0;
        }
        int j;
        if (!TextUtils.isEmpty(paramButtonParam.style.borderColor)) {
          try
          {
            j = ColorUtils.parseColor(paramButtonParam.style.borderColor);
          }
          catch (Throwable localThrowable2)
          {
            QMLog.e("CustomButton", "setmTextButton strokeColor error ", localThrowable2);
          }
        } else {
          j = 0;
        }
        if (Build.VERSION.SDK_INT >= 16) {
          this.mTextButton.setBackground(getBackgroundDrawable(i, paramButtonParam.style.borderWidth, j, paramButtonParam.style.borderRadius));
        } else {
          this.mTextButton.setBackgroundDrawable(getBackgroundDrawable(i, paramButtonParam.style.borderWidth, j, paramButtonParam.style.borderRadius));
        }
        if (!TextUtils.isEmpty(paramButtonParam.style.color))
        {
          i = -16777216;
          try
          {
            j = ColorUtils.parseColor(paramButtonParam.style.color);
            i = j;
          }
          catch (Throwable localThrowable3)
          {
            QMLog.e("CustomButton", "setmTextButton textColor error ", localThrowable3);
          }
          this.mTextButton.setTextColor(i);
        }
        setTextAlign(paramButtonParam);
        if (paramButtonParam.style.fontSize > 0) {
          this.mTextButton.setTextSize(paramButtonParam.style.fontSize);
        }
        if (paramButtonParam.style.lineHeight >= 0)
        {
          i = this.mTextButton.getPaint().getFontMetricsInt(null);
          i = paramButtonParam.style.lineHeight - i;
          this.mTextButton.setLineSpacing(i, 1.0F);
          i /= 2;
          this.mTextButton.setPadding(0, i, 0, 0);
        }
      }
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
    Object localObject = this.mTextButton;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mImageButton;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    ImageButton localImageButton = this.mImageButton;
    if ((localImageButton != null) && (paramDrawable != null)) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setParam(CustomButton.ButtonParam paramButtonParam, View.OnClickListener paramOnClickListener)
  {
    this.mParams = paramButtonParam;
    paramButtonParam = this.mParams;
    if (paramButtonParam != null) {
      if (("text".equals(paramButtonParam.type)) && (this.mTextButton == null))
      {
        this.mTextButton = new Button(this.mContext);
        this.mTextButton.setOnClickListener(paramOnClickListener);
      }
      else if (("image".equals(this.mParams.type)) && (this.mImageButton == null))
      {
        this.mImageButton = new ImageButton(this.mContext);
        this.mImageButton.setOnClickListener(paramOnClickListener);
      }
    }
    if (this.mTextButton != null)
    {
      setTextButton(this.mParams);
      return;
    }
    if (this.mImageButton != null) {
      setImageButton(this.mParams);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (getButton() != null)
    {
      View localView = getButton();
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.CustomButton
 * JD-Core Version:    0.7.0.1
 */