package com.tencent.qqmini.sdk.widget;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
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
  
  static
  {
    sAppOpsClass = null;
    sCheckOpNoThrow = null;
    sOpPostNotification = null;
  }
  
  public MiniToast(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = this.mContext.getResources();
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public static boolean canUseCustomToast(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return false;
      if ((useCustomToast == -1) || (paramBoolean))
      {
        int i = useCustomToast;
        useCustomToast = isNotificationEnabled(paramContext);
        QMLog.d("QQToast", "canUseCustomToast = " + useCustomToast);
        if ((i == 0) && (useCustomToast == 1)) {
          QMLog.d("QQToast", "Temp Report mark: now Notification from disable to Enabled ");
        }
      }
    } while (useCustomToast == 1);
    return true;
  }
  
  public static int getBgColor(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (!useIOSLikeUI()) {
        break;
      }
    case 1: 
    case 2: 
      do
      {
        return -1;
        if (useIOSLikeUI()) {
          return -103316;
        }
        return -436310932;
      } while (useIOSLikeUI());
      return -452984832;
    }
    return -452984832;
  }
  
  public static int getIconColor(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -15550475;
    case 1: 
      return -1;
    }
    return -7745469;
  }
  
  public static int getIconRes(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.drawable.mini_sdk_black_tips_icon_info;
    case 1: 
      return R.drawable.mini_sdk_black_tips_icon_caution;
    }
    return R.drawable.mini_sdk_black_tips_icon_success;
  }
  
  private static int getTextColorType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  public static boolean isMX2()
  {
    return Build.BOARD.contains("mx2");
  }
  
  @TargetApi(19)
  public static int isNotificationEnabled(Context paramContext)
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        return 2;
      }
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      while (QMLog.isColorLevel())
      {
        QMLog.d("PushOpenNotify", "isNotificationEnabled,  isEnabled, " + bool);
        break;
        AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        paramContext = paramContext.getApplicationContext().getPackageName();
        int j = localApplicationInfo.uid;
        if (sAppOpsClass == null) {
          sAppOpsClass = Class.forName(AppOpsManager.class.getName());
        }
        if (sCheckOpNoThrow == null) {
          sCheckOpNoThrow = sAppOpsClass.getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        }
        if (sOpPostNotification == null) {
          sOpPostNotification = sAppOpsClass.getDeclaredField("OP_POST_NOTIFICATION");
        }
        int k = ((Integer)sOpPostNotification.get(Integer.class)).intValue();
        j = ((Integer)sCheckOpNoThrow.invoke(localAppOpsManager, new Object[] { Integer.valueOf(k), Integer.valueOf(j), paramContext })).intValue();
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      while (bool) {}
    }
    catch (Throwable paramContext)
    {
      if (QMLog.isColorLevel()) {
        QMLog.d("PushOpenNotify", " isNotificationEnabled, get except, " + paramContext.getMessage());
      }
      i = 2;
      return i;
    }
    return 0;
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
  
  public static boolean useIOSLikeUI()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
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
      if (!useIOSLikeUI()) {
        break label377;
      }
      localProtectedToast.setGravity(55, 0, 0);
    }
    for (;;)
    {
      localProtectedToast.setView(localView);
      localProtectedToast.setDuration(this.mDuration);
      if (useIOSLikeUI()) {
        localView.setOnTouchListener(new MiniToast.1(this, localProtectedToast, paramOnTouchListener));
      }
      return localProtectedToast;
      ((ImageView)localView.findViewById(R.id.toast_icon)).setVisibility(8);
      break;
      label377:
      if (paramInt1 == 6316128) {
        localProtectedToast.setGravity(55, 0, getStatusBarHeight());
      } else {
        localProtectedToast.setGravity(55, 0, getTitleBarHeight());
      }
    }
  }
  
  public int getStatusBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.mResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public int getTitleBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.mResources.getDisplayMetrics().density * 44.0F + 0.5D);
  }
  
  public boolean isShowing()
  {
    if (this.mDuration == 0) {}
    for (long l = 2000L; (System.currentTimeMillis() - this.mLastShowedTime > l) || (this.isUserTouched); l = 3500L) {
      return false;
    }
    return true;
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
    for (;;)
    {
      this.isUserTouched = false;
      this.mLastShowedTime = System.currentTimeMillis();
      return this.mShowingToast;
      this.mShowingToast = create(0);
      this.mShowingToast.show();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast
 * JD-Core Version:    0.7.0.1
 */