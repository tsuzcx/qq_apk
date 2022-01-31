package com.tencent.mobileqq.mini.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ToastView
{
  public static final int DEFAULT_DURATION = 1500;
  public static final String ICON_LOADING = "loading";
  public static final String ICON_NONE = "none";
  public static final String ICON_SUCCESS = "success";
  public static final String ICON_WARN = "warn";
  public static final int MODE_LOADING = 1;
  public static final int MODE_TOAST = 0;
  public static final String TAG = "ToastView";
  Handler handler = new Handler();
  Runnable hideJob = new ToastView.1(this);
  private Drawable icon;
  private Context mContext;
  private int mDuration = 1500;
  private LayoutInflater mInflater;
  ViewGroup mParentView;
  private Resources mResources;
  private CharSequence message;
  private ObjectAnimator objectAnimator;
  View toastLayout;
  
  public ToastView(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = paramContext.getResources();
    this.mInflater = LayoutInflater.from(paramContext);
    this.mParentView = paramViewGroup;
  }
  
  private void create(int paramInt, boolean paramBoolean)
  {
    this.toastLayout = this.mInflater.inflate(2131493697, null);
    this.toastLayout.setClickable(paramBoolean);
    Object localObject = (TextView)this.toastLayout.findViewById(2131311708);
    ImageView localImageView = (ImageView)this.toastLayout.findViewById(2131311705);
    this.objectAnimator = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 360.0F });
    this.objectAnimator.setInterpolator(new LinearInterpolator());
    this.objectAnimator.setDuration(2000L);
    this.objectAnimator.setRepeatMode(1);
    this.objectAnimator.setRepeatCount(-1);
    ((TextView)localObject).setEms(7);
    if (this.icon != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(this.icon);
      ((TextView)localObject).setMaxLines(1);
    }
    while (TextUtils.isEmpty(this.message))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = localImageView.getLayoutParams();
      if (localObject != null)
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      localImageView.setVisibility(8);
      ((TextView)localObject).setGravity(17);
      if (paramInt == 1)
      {
        ((TextView)localObject).setMaxLines(1);
      }
      else if (paramInt == 0)
      {
        ((TextView)localObject).setEms(18);
        ((TextView)localObject).setMaxLines(2);
      }
    }
    ((TextView)localObject).setText(this.message);
  }
  
  public static int getIconRes(String paramString)
  {
    if ("success".equals(paramString)) {
      return 2130846703;
    }
    if ("warn".equals(paramString)) {
      return 2130846702;
    }
    if ("loading".equals(paramString)) {
      return 2130840601;
    }
    return 2130838991;
  }
  
  private void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  private void setToastIcon(int paramInt)
  {
    if (paramInt != 0) {
      setToastIcon(this.mResources.getDrawable(paramInt));
    }
  }
  
  private void setToastIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  private void setToastMsg(CharSequence paramCharSequence)
  {
    this.message = paramCharSequence;
  }
  
  private void show()
  {
    QLog.d("ToastView", 4, "show mParentView=" + this.mParentView + ",toastLayout=" + this.toastLayout);
    if ((this.mParentView != null) && (this.toastLayout != null))
    {
      this.mParentView.addView(this.toastLayout, new ViewGroup.LayoutParams(-1, -1));
      if (this.mDuration > -1) {
        this.handler.postDelayed(this.hideJob, this.mDuration);
      }
    }
    if (this.objectAnimator != null) {
      this.objectAnimator.start();
    }
  }
  
  public void hide()
  {
    this.handler.removeCallbacks(this.hideJob);
    QLog.d("ToastView", 4, "hide mParentView=" + this.mParentView + ",toastLayout=" + this.toastLayout);
    if ((this.mParentView != null) && (this.toastLayout != null)) {
      this.mParentView.removeView(this.toastLayout);
    }
    if (this.objectAnimator != null)
    {
      this.objectAnimator.cancel();
      this.objectAnimator = null;
    }
    this.icon = null;
  }
  
  public void show(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    QLog.d("ToastView", 4, "show iconType=" + paramString1 + ",localIconPath=" + paramString2 + ",msg=" + paramCharSequence + ",duration=" + paramInt2 + ",mask=" + paramBoolean);
    hide();
    if (!TextUtils.isEmpty(paramString2)) {
      setToastIcon(new BitmapDrawable(paramString2));
    }
    for (;;)
    {
      setToastMsg(paramCharSequence);
      setDuration(paramInt2);
      create(paramInt1, paramBoolean);
      show();
      return;
      setToastIcon(getIconRes(paramString1));
    }
  }
  
  public boolean shown()
  {
    if (this.toastLayout == null) {}
    while (this.toastLayout.getParent() == null) {
      return false;
    }
    return true;
  }
  
  public void updateMsg(String paramString)
  {
    if (this.toastLayout == null) {
      return;
    }
    setToastMsg(paramString);
    paramString = (TextView)this.toastLayout.findViewById(2131311708);
    if (TextUtils.isEmpty(this.message))
    {
      paramString.setVisibility(8);
      return;
    }
    paramString.setVisibility(0);
    paramString.setText(this.message);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.ToastView
 * JD-Core Version:    0.7.0.1
 */