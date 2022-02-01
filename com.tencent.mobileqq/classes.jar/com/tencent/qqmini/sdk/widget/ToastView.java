package com.tencent.qqmini.sdk.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class ToastView
{
  public static final int DEFAULT_DURATION = 1500;
  public static final String ICON_DEFAULT = "default";
  public static final String ICON_LOADING = "loading";
  public static final String ICON_NONE = "none";
  public static final String ICON_SUCCESS = "success";
  public static final String ICON_WARN = "warn";
  public static final int MODE_LOADING = 1;
  public static final int MODE_TOAST = 0;
  public static final String TAG = "ToastView";
  public static final int UNDERTHE_STATUS_BAR = 6316128;
  Handler handler = new Handler();
  Runnable hideJob = new ToastView.1(this);
  private Drawable icon = null;
  private Context mContext;
  private int mDuration = 1500;
  private LayoutInflater mInflater;
  ViewGroup mParentView;
  private Resources mResources;
  private CharSequence message = null;
  private ObjectAnimator objectAnimator;
  View toastLayout;
  
  public ToastView(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = paramContext.getResources();
    this.mInflater = LayoutInflater.from(paramContext);
    this.mParentView = paramViewGroup;
  }
  
  private void create(int paramInt, String paramString, boolean paramBoolean)
  {
    int i;
    if (isToastModeLoading(paramInt, paramString)) {
      i = R.layout.mini_sdk_loading_toast;
    } else {
      i = R.layout.mini_sdk_toast_main_layout;
    }
    if (!isToastModeLoading(paramInt, paramString)) {
      paramBoolean = false;
    }
    this.toastLayout = this.mInflater.inflate(i, null);
    this.toastLayout.setClickable(paramBoolean);
    TextView localTextView = (TextView)this.toastLayout.findViewById(R.id.toast_msg);
    ImageView localImageView = (ImageView)this.toastLayout.findViewById(R.id.toast_icon);
    if (paramInt == 1)
    {
      this.objectAnimator = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 360.0F });
      this.objectAnimator.setInterpolator(new LinearInterpolator());
      this.objectAnimator.setDuration(2000L);
      this.objectAnimator.setRepeatMode(1);
      this.objectAnimator.setRepeatCount(-1);
    }
    if (this.icon != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(this.icon);
      localTextView.setMaxLines(1);
    }
    else
    {
      localImageView.setVisibility(8);
      localTextView.setGravity(17);
      if (isToastModeLoading(paramInt, paramString))
      {
        localTextView.setMaxLines(1);
      }
      else
      {
        localTextView.setEms(18);
        localTextView.setMaxLines(2);
      }
    }
    if (TextUtils.isEmpty(this.message))
    {
      localTextView.setVisibility(8);
      paramString = localImageView.getLayoutParams();
      if (paramString != null)
      {
        paramString = (LinearLayout.LayoutParams)paramString;
        paramString.gravity = 17;
        paramString.topMargin = 0;
        localImageView.setLayoutParams(paramString);
      }
    }
    else
    {
      if (!isToastModeLoading(paramInt, paramString)) {
        localTextView.setTextColor(getTextColorType(paramString));
      }
      localTextView.setText(this.message);
    }
    this.toastLayout.setX(0.0F);
    this.toastLayout.setY(getStatusBarHeight());
  }
  
  public static int getIconRes(String paramString)
  {
    if ("success".equals(paramString)) {
      return R.drawable.mini_sdk_black_tips_icon_success;
    }
    if ("warn".equals(paramString)) {
      return R.drawable.mini_sdk_black_tips_icon_caution;
    }
    if ("loading".equals(paramString)) {
      return R.drawable.mini_sdk_loading_toast_img;
    }
    return R.drawable.mini_sdk_black_tips_icon_info;
  }
  
  private static int getTextColorType(String paramString)
  {
    if ("warn".equals(paramString)) {
      return -16578533;
    }
    if ("success".equals(paramString)) {}
    return -16777216;
  }
  
  public static boolean isMX2()
  {
    return Build.BOARD.contains("mx2");
  }
  
  private boolean isToastModeLoading(int paramInt, String paramString)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if ((paramInt == 0) && ("loading".equals(paramString))) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show mParentView=");
    ((StringBuilder)localObject).append(this.mParentView);
    ((StringBuilder)localObject).append(",toastLayout=");
    ((StringBuilder)localObject).append(this.toastLayout);
    QMLog.d("ToastView", ((StringBuilder)localObject).toString());
    localObject = this.mParentView;
    if (localObject != null)
    {
      View localView = this.toastLayout;
      if (localView != null)
      {
        ((ViewGroup)localObject).addView(localView, new ViewGroup.LayoutParams(-1, -1));
        int i = this.mDuration;
        if (i > -1) {
          this.handler.postDelayed(this.hideJob, i);
        }
      }
    }
    localObject = this.objectAnimator;
    if (localObject != null) {
      ((ObjectAnimator)localObject).start();
    }
  }
  
  public static boolean useIOSLikeUI()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  public int getStatusBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException)
    {
      label24:
      double d;
      break label24;
    }
    d = this.mResources.getDisplayMetrics().density * 25.0F;
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  public int getTitleBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException)
    {
      label24:
      double d;
      break label24;
    }
    d = this.mResources.getDisplayMetrics().density * 44.0F;
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  public void hide()
  {
    this.handler.removeCallbacks(this.hideJob);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hide mParentView=");
    ((StringBuilder)localObject).append(this.mParentView);
    ((StringBuilder)localObject).append(",toastLayout=");
    ((StringBuilder)localObject).append(this.toastLayout);
    QMLog.d("ToastView", ((StringBuilder)localObject).toString());
    localObject = this.mParentView;
    if (localObject != null)
    {
      View localView = this.toastLayout;
      if (localView != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
    localObject = this.objectAnimator;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).cancel();
      this.objectAnimator = null;
    }
    this.icon = null;
  }
  
  public void show(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show iconType=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",localIconPath=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",msg=");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(",duration=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",mask=");
    localStringBuilder.append(paramBoolean);
    QMLog.d("ToastView", localStringBuilder.toString());
    hide();
    if (!TextUtils.isEmpty(paramString2)) {
      setToastIcon(new BitmapDrawable(paramString2));
    } else {
      setToastIcon(getIconRes(paramString1));
    }
    setToastMsg(paramCharSequence);
    setDuration(paramInt2);
    create(paramInt1, paramString1, paramBoolean);
    show();
  }
  
  public boolean shown()
  {
    View localView = this.toastLayout;
    boolean bool = false;
    if (localView == null) {
      return false;
    }
    if (localView.getParent() != null) {
      bool = true;
    }
    return bool;
  }
  
  public void updateMsg(String paramString)
  {
    if (this.toastLayout == null) {
      return;
    }
    setToastMsg(paramString);
    paramString = (TextView)this.toastLayout.findViewById(R.id.toast_msg);
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
 * Qualified Name:     com.tencent.qqmini.sdk.widget.ToastView
 * JD-Core Version:    0.7.0.1
 */