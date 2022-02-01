package com.tencent.qqmini.sdk.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmini.sdk.R.anim;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@MiniKeep
public class MiniToast
{
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final int ICON_DEFAULT = 0;
  public static final int ICON_ERROR = 1;
  public static final int ICON_NONE = -1;
  public static final int ICON_SUCCESS = 2;
  public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS = 1;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  public static final String TAG = "QQToast";
  public static final int UNDERTHE_STATUS_BAR = 6316128;
  private static MiniToast.ToastHandler mHandler = new MiniToast.ToastHandler(Looper.getMainLooper(), null);
  private static BlockingQueue<WeakReference<MiniToast>> mToastQueue = new LinkedBlockingQueue();
  private static Class sAppOpsClass;
  private static Method sCheckOpNoThrow;
  private static Field sOpPostNotification;
  private static int useCustomToast = -1;
  private Drawable icon = null;
  private boolean isUserTouched = false;
  boolean mAutoTextSize = false;
  private Context mContext;
  private int mDuration = 0;
  private long mDurationInMillisecond = 2000L;
  private LayoutInflater mInflater;
  private boolean mIsShowing;
  private long mLastShowedTime = 0L;
  private Resources mResources;
  private Toast mShowingToast;
  private long mToastEndTimeInMillisecond;
  private int mToastType = 0;
  private CharSequence message = null;
  
  public MiniToast(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = this.mContext.getResources();
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public static boolean canUseCustomToast(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    if ((useCustomToast == -1) || (paramBoolean))
    {
      int i = useCustomToast;
      useCustomToast = isNotificationEnabled(paramContext);
      paramContext = new StringBuilder();
      paramContext.append("canUseCustomToast = ");
      paramContext.append(useCustomToast);
      QMLog.d("QQToast", paramContext.toString());
      if ((i == 0) && (useCustomToast == 1)) {
        QMLog.d("QQToast", "Temp Report mark: now Notification from disable to Enabled ");
      }
    }
    return useCustomToast != 1;
  }
  
  public static int getBgColor(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (useIOSLikeUI()) {
          return -1;
        }
        return -452984832;
      }
      if (useIOSLikeUI()) {
        return -1;
      }
      return -452984832;
    }
    if (useIOSLikeUI()) {
      return -103316;
    }
    return -436310932;
  }
  
  private static long getDelay(TextView paramTextView)
  {
    if ((paramTextView != null) && (paramTextView.getText().length() < 6)) {
      return 900L;
    }
    return 1900L;
  }
  
  public static int getIconColor(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return -15550475;
      }
      return -7745469;
    }
    return -1;
  }
  
  public static int getIconRes(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return R.drawable.mini_sdk_black_tips_icon_info;
      }
      return R.drawable.mini_sdk_black_tips_icon_success;
    }
    return R.drawable.mini_sdk_black_tips_icon_caution;
  }
  
  private static int getTextColorType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {}
      return -16777216;
    }
    return -16578533;
  }
  
  public static boolean isMX2()
  {
    return Build.BOARD.contains("mx2");
  }
  
  private static boolean isMeizuPhone()
  {
    return ((Build.BRAND.equals("Meizu")) && (Build.MODEL.equals("U20"))) || ((Build.BRAND.equals("Meizu")) && (Build.MODEL.equals("M3s")));
  }
  
  @TargetApi(19)
  public static int isNotificationEnabled(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static MiniToast makeText(Context paramContext, int paramInt1, int paramInt2)
  {
    return makeText(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static MiniToast makeText(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new MiniToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramInt2);
    paramContext.setDuration(paramInt3);
    return paramContext;
  }
  
  public static MiniToast makeText(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new MiniToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramCharSequence);
    paramContext.setDuration(paramInt2);
    return paramContext;
  }
  
  public static MiniToast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return makeText(paramContext, 0, paramCharSequence, paramInt);
  }
  
  private void setGravity(int paramInt, Toast paramToast)
  {
    if (useIOSLikeUI())
    {
      paramToast.setGravity(55, 0, 0);
      return;
    }
    if (paramInt == 6316128)
    {
      paramToast.setGravity(55, 0, getStatusBarHeight());
      return;
    }
    paramToast.setGravity(55, 0, getTitleBarHeight());
  }
  
  private void setOnTouchListener(View.OnTouchListener paramOnTouchListener, Toast paramToast, View paramView)
  {
    if (useIOSLikeUI()) {
      paramView.setOnTouchListener(new MiniToast.1(this, paramToast, paramOnTouchListener));
    }
  }
  
  public static boolean useIOSLikeUI()
  {
    return (!isMeizuPhone()) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  public void cancel()
  {
    this.mIsShowing = false;
    mHandler.sendEmptyMessage(2);
  }
  
  public Toast create(int paramInt)
  {
    return create(paramInt, R.layout.mini_sdk_toast_main_layout, null);
  }
  
  public Toast create(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    MiniToast.ProtectedToast localProtectedToast = new MiniToast.ProtectedToast(this.mContext);
    View localView = this.mInflater.inflate(paramInt2, null);
    Object localObject = localView.findViewById(R.id.toast_background);
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      ((View)localObject).setElevation(6.0F);
    }
    AnimationUtils.loadAnimation(this.mContext, R.anim.mini_sdk_toast_enter_anim);
    localView.findViewById(R.id.toast_main);
    if (this.icon != null)
    {
      localObject = (ImageView)localView.findViewById(R.id.toast_icon);
      ((ImageView)localObject).setImageDrawable(this.icon);
      ((ImageView)localObject).setColorFilter(getIconColor(this.mToastType), PorterDuff.Mode.MULTIPLY);
    }
    else
    {
      ((ImageView)localView.findViewById(R.id.toast_icon)).setVisibility(8);
    }
    if (this.message != null)
    {
      localObject = (TextView)localView.findViewById(R.id.toast_msg);
      ((TextView)localObject).setTextColor(getTextColorType(this.mToastType));
      ((TextView)localObject).setText(this.message);
      String str = this.message.toString();
      TextPaint localTextPaint = ((TextView)localObject).getPaint();
      float f1 = localTextPaint.measureText(str);
      DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
      float f2 = localDisplayMetrics.densityDpi / 160 * 50;
      f2 = localDisplayMetrics.widthPixels - f2;
      if (f1 > f2) {
        ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
      }
      if (this.mAutoTextSize)
      {
        f1 = localTextPaint.measureText(str);
        if (f1 > f2) {
          ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
        }
      }
    }
    setGravity(paramInt1, localProtectedToast);
    localProtectedToast.setView(localView);
    localProtectedToast.setDuration(this.mDuration);
    setOnTouchListener(paramOnTouchListener, localProtectedToast, localView);
    return localProtectedToast;
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
  
  public boolean isShowing()
  {
    long l;
    if (this.mDuration == 0) {
      l = 2000L;
    } else {
      l = 3500L;
    }
    return (System.currentTimeMillis() - this.mLastShowedTime <= l) && (!this.isUserTouched);
  }
  
  public void setAutoTextSize()
  {
    this.mAutoTextSize = true;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setToastIcon(int paramInt)
  {
    setToastIcon(this.mResources.getDrawable(paramInt));
  }
  
  public void setToastIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  public void setToastMsg(int paramInt)
  {
    setToastMsg(this.mResources.getString(paramInt));
  }
  
  public void setToastMsg(CharSequence paramCharSequence)
  {
    this.message = paramCharSequence;
  }
  
  public void setType(int paramInt)
  {
    this.mToastType = paramInt;
  }
  
  public Toast show()
  {
    if (isMX2())
    {
      this.mShowingToast = create(getStatusBarHeight());
      this.mShowingToast.show();
    }
    else
    {
      this.mShowingToast = create(0);
      this.mShowingToast.show();
    }
    this.isUserTouched = false;
    this.mLastShowedTime = System.currentTimeMillis();
    return this.mShowingToast;
  }
  
  public Toast show(int paramInt)
  {
    Toast localToast = create(paramInt);
    localToast.show();
    this.mLastShowedTime = System.currentTimeMillis();
    this.isUserTouched = false;
    return localToast;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast
 * JD-Core Version:    0.7.0.1
 */