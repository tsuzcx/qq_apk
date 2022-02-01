package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QQToast
{
  public static final int ICON_DEFAULT = 0;
  public static final int ICON_ERROR = 1;
  public static final int ICON_NONE = -1;
  public static final int ICON_QZONE_DEFAULT = 3;
  public static final int ICON_QZONE_ERROR = 4;
  public static final int ICON_QZONE_SHARE_MOOD = 6;
  public static final int ICON_QZONE_SUCCESS = 5;
  public static final int ICON_SUCCESS = 2;
  public static final int LENGTH_LONG = 1;
  public static final int LENGTH_SHORT = 0;
  public static final String TAG = "QQToast";
  public static final int UNDERTHE_STATUS_BAR = 6316128;
  private static QQToast.ToastHandler mHandler = new QQToast.ToastHandler(Looper.getMainLooper(), null);
  private static boolean mIsNeedShowToast = true;
  private static BlockingQueue<QQToast.ShowToastMessage> mToastQueue = new LinkedBlockingQueue();
  private static boolean mUseNewToast = false;
  private static boolean sTestSwitch = QQUIDelegate.a;
  private static int sUseCustomToast = 1;
  private Drawable icon = null;
  private boolean isUserTouched = false;
  boolean mAutoTextSize = false;
  private Context mContext;
  private int mDuration = 0;
  private LayoutInflater mInflater;
  private long mLastShowedTime = 0L;
  private Resources mResources;
  private int mToastType = 0;
  private CharSequence message = null;
  private QQToast.RightActionParams rightActionParams = null;
  
  public QQToast(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = this.mContext.getResources();
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  private void addRightActionView(Toast paramToast, LinearLayout paramLinearLayout, QQToast.RightActionParams paramRightActionParams)
  {
    if ((paramRightActionParams.text != null) && (!paramRightActionParams.text.isEmpty()))
    {
      Context localContext = paramLinearLayout.getContext();
      Object localObject = new View(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = new TextView(localContext);
      ((TextView)localObject).setOnClickListener(new QQToast.2(this, paramRightActionParams, paramToast));
      ((TextView)localObject).setText(paramRightActionParams.text);
      if (paramRightActionParams.textColor == 0) {
        paramRightActionParams.textColor = localContext.getResources().getColor(2131165826);
      }
      ((TextView)localObject).setTextColor(paramRightActionParams.textColor);
      if (paramRightActionParams.textSizeDp == 0) {
        paramRightActionParams.textSizeDp = 16;
      }
      ((TextView)localObject).setTextSize(1, paramRightActionParams.textSizeDp);
      paramToast = new LinearLayout.LayoutParams(-2, -2);
      paramToast.rightMargin = QQUIDelegate.a(localContext, 22.0F);
      paramLinearLayout.addView((View)localObject, paramToast);
      return;
    }
    QLog.e("QQToast", 1, "addRightActionView params isNullOrEmpty");
  }
  
  public static boolean canUseCustomToast()
  {
    return sUseCustomToast == 1;
  }
  
  public static int getBgColor(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (useIOSLikeUI()) {
        return -1;
      }
      break;
    case 2: 
    case 5: 
      if (useIOSLikeUI()) {
        return -1;
      }
      return -452984832;
    case 1: 
    case 4: 
      if (useIOSLikeUI()) {
        return -103316;
      }
      return -436310932;
    case 0: 
    case 3: 
    case 6: 
      if (useIOSLikeUI()) {
        return -1;
      }
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
    case 2: 
    case 5: 
      return -7745469;
    case 1: 
    case 4: 
      return -1;
    }
    return -15550475;
  }
  
  public static int getIconRes(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130839453;
    case 2: 
    case 5: 
      return 2130849706;
    case 1: 
    case 4: 
      return 2130849705;
    }
    return 2130839453;
  }
  
  private static int getTextColorType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    default: 
      return -16777216;
    case 1: 
    case 4: 
      return -16578533;
    }
    return -16777216;
  }
  
  public static boolean isMX2()
  {
    return Build.BOARD.contains("mx2");
  }
  
  public static QQToast makeText(Context paramContext, int paramInt1, int paramInt2)
  {
    return makeText(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static QQToast makeText(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new QQToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramInt2);
    paramContext.setDuration(paramInt3);
    return paramContext;
  }
  
  public static QQToast makeText(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramCharSequence);
    paramContext.setDuration(paramInt2);
    return paramContext;
  }
  
  public static QQToast makeText(Context paramContext, int paramInt1, CharSequence paramCharSequence, QQToast.RightActionParams paramRightActionParams, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramCharSequence);
    paramContext.setDuration(paramInt2);
    paramContext.setRightActionParams(paramRightActionParams);
    return paramContext;
  }
  
  public static QQToast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return makeText(paramContext, 0, paramCharSequence, paramInt);
  }
  
  public static void setIsNeedShowToast(boolean paramBoolean)
  {
    if (sTestSwitch) {
      mIsNeedShowToast = paramBoolean;
    }
  }
  
  public static void setTestSwitch(boolean paramBoolean)
  {
    sTestSwitch = paramBoolean;
  }
  
  public static void setUseCustomToast(int paramInt)
  {
    sUseCustomToast = paramInt;
  }
  
  public static void setUseNew(int paramInt)
  {
    mUseNewToast = true;
  }
  
  public static boolean useIOSLikeUI()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  public Toast create(int paramInt)
  {
    return create(paramInt, 2131627878, null);
  }
  
  public Toast create(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    QQToast.ProtectedToast localProtectedToast = new QQToast.ProtectedToast(this.mContext);
    boolean bool = QQTheme.isNowSimpleUI();
    View localView = this.mInflater.inflate(paramInt2, null);
    Object localObject1 = localView.findViewById(2131447667);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject1).setElevation(6.0F);
    }
    if (bool)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setColor(this.mResources.getColor(2131168094));
      ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(this.mContext, 4.0F));
      ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
    }
    localObject1 = (LinearLayout)localView.findViewById(2131447671);
    Object localObject2 = this.rightActionParams;
    if (localObject2 != null) {
      addRightActionView(localProtectedToast, (LinearLayout)localObject1, (QQToast.RightActionParams)localObject2);
    }
    if (this.icon != null)
    {
      localObject1 = (ImageView)localView.findViewById(2131447670);
      ((ImageView)localObject1).setImageDrawable(this.icon);
      if (!bool)
      {
        ((ImageView)localObject1).setColorFilter(getIconColor(this.mToastType), PorterDuff.Mode.MULTIPLY);
      }
      else
      {
        paramInt2 = DisplayUtil.a(this.mContext, 28.0F);
        localObject1 = ((ImageView)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
      }
    }
    else
    {
      ((ImageView)localView.findViewById(2131447670)).setVisibility(8);
    }
    if (this.message != null)
    {
      localObject1 = (TextView)localView.findViewById(2131447672);
      if (bool)
      {
        ((TextView)localObject1).setTextColor(this.mResources.getColorStateList(2131168056));
        ((TextView)localObject1).setTextSize(2, 16.0F);
      }
      else
      {
        ((TextView)localObject1).setTextColor(getTextColorType(this.mToastType));
      }
      ((TextView)localObject1).setText(this.message);
      localObject2 = this.message.toString();
      TextPaint localTextPaint = ((TextView)localObject1).getPaint();
      float f1 = localTextPaint.measureText((String)localObject2);
      DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
      float f2 = localDisplayMetrics.densityDpi / 160 * 50;
      f2 = localDisplayMetrics.widthPixels - f2;
      if (f1 > f2) {
        ((TextView)localObject1).setTextSize(2, ((TextView)localObject1).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
      }
      if (this.mAutoTextSize)
      {
        f1 = localTextPaint.measureText((String)localObject2);
        if (f1 > f2) {
          ((TextView)localObject1).setTextSize(2, ((TextView)localObject1).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
        }
      }
    }
    if (useIOSLikeUI()) {
      localProtectedToast.setGravity(55, 0, 0);
    } else if (paramInt1 == 6316128) {
      localProtectedToast.setGravity(55, 0, getStatusBarHeight());
    } else {
      localProtectedToast.setGravity(55, 0, getTitleBarHeight());
    }
    localProtectedToast.setView(localView);
    localProtectedToast.setDuration(this.mDuration);
    if (useIOSLikeUI())
    {
      if (bool)
      {
        localObject1 = (TextView)localView.findViewById(2131449842);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(this.mResources.getColor(2131168057));
          ((TextView)localObject1).setTextSize(2, 16.0F);
        }
      }
      localView.setOnTouchListener(new QQToast.1(this, localProtectedToast, paramOnTouchListener));
    }
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
  
  public void setRightActionParams(QQToast.RightActionParams paramRightActionParams)
  {
    this.rightActionParams = paramRightActionParams;
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
    Toast localToast;
    if (isMX2()) {
      localToast = create(getStatusBarHeight());
    } else {
      localToast = create(0);
    }
    if ((sTestSwitch) && (!mIsNeedShowToast)) {
      return localToast;
    }
    localToast.show();
    this.isUserTouched = false;
    this.mLastShowedTime = System.currentTimeMillis();
    return localToast;
  }
  
  public Toast show(int paramInt)
  {
    Toast localToast = create(paramInt);
    if ((sTestSwitch) && (!mIsNeedShowToast)) {
      return localToast;
    }
    localToast.show();
    this.mLastShowedTime = System.currentTimeMillis();
    this.isUserTouched = false;
    return localToast;
  }
  
  public void showByQueue(QQToast.IToastValidListener paramIToastValidListener)
  {
    paramIToastValidListener = new QQToast.ShowToastMessage(this, paramIToastValidListener);
    mToastQueue.add(paramIToastValidListener);
    mHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel())
    {
      paramIToastValidListener = new StringBuilder();
      paramIToastValidListener.append("current queue size is ");
      paramIToastValidListener.append(mToastQueue.size());
      QLog.d("QQToast", 2, paramIToastValidListener.toString());
    }
  }
  
  public Toast showTouchableToast(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    paramOnTouchListener = create(paramInt1, paramInt2, paramOnTouchListener);
    if ((sTestSwitch) && (!mIsNeedShowToast)) {
      return paramOnTouchListener;
    }
    paramOnTouchListener.show();
    this.mLastShowedTime = System.currentTimeMillis();
    this.isUserTouched = false;
    return paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast
 * JD-Core Version:    0.7.0.1
 */