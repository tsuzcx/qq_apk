package com.tencent.mobileqq.widget;

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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QQToast
{
  private static int jdField_a_of_type_Int = 1;
  private static QQToast.ToastHandler jdField_a_of_type_ComTencentMobileqqWidgetQQToast$ToastHandler = new QQToast.ToastHandler(Looper.getMainLooper(), null);
  private static BlockingQueue<QQToast.ShowToastMessage> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  private static boolean jdField_b_of_type_Boolean = false;
  private static boolean jdField_c_of_type_Boolean = true;
  private static boolean d = QQUIDelegate.jdField_a_of_type_Boolean;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private QQToast.RightActionParams jdField_a_of_type_ComTencentMobileqqWidgetQQToast$RightActionParams = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private int jdField_c_of_type_Int = 0;
  private boolean e = false;
  
  public QQToast(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 3: 
    case 6: 
    default: 
      return 2130839417;
    case 1: 
    case 4: 
      return 2130848172;
    }
    return 2130848173;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt1);
    paramContext.c(paramInt2);
    paramContext.d(paramInt3);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt1);
    paramContext.a(paramCharSequence);
    paramContext.d(paramInt2);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  private void a(Toast paramToast, LinearLayout paramLinearLayout, QQToast.RightActionParams paramRightActionParams)
  {
    if ((paramRightActionParams.jdField_a_of_type_JavaLangString == null) || (paramRightActionParams.jdField_a_of_type_JavaLangString.isEmpty()))
    {
      QLog.e("QQToast", 1, "addRightActionView params isNullOrEmpty");
      return;
    }
    Context localContext = paramLinearLayout.getContext();
    Object localObject = new View(localContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(localContext);
    ((TextView)localObject).setOnClickListener(new QQToast.2(this, paramRightActionParams, paramToast));
    ((TextView)localObject).setText(paramRightActionParams.jdField_a_of_type_JavaLangString);
    if (paramRightActionParams.jdField_a_of_type_Int == 0) {
      paramRightActionParams.jdField_a_of_type_Int = localContext.getResources().getColor(2131165525);
    }
    ((TextView)localObject).setTextColor(paramRightActionParams.jdField_a_of_type_Int);
    if (paramRightActionParams.jdField_b_of_type_Int == 0) {
      paramRightActionParams.jdField_b_of_type_Int = 16;
    }
    ((TextView)localObject).setTextSize(1, paramRightActionParams.jdField_b_of_type_Int);
    paramToast = new LinearLayout.LayoutParams(-2, -2);
    paramToast.rightMargin = QQUIDelegate.a(localContext, 22.0F);
    paramLinearLayout.addView((View)localObject, paramToast);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int == 1;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 3: 
    case 6: 
    default: 
      return -15550475;
    case 1: 
    case 4: 
      return -1;
    }
    return -7745469;
  }
  
  public static boolean b()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  public static boolean c()
  {
    return Build.BOARD.contains("mx2");
  }
  
  public int a()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public Toast a()
  {
    if (c()) {}
    for (Toast localToast = a(a()); (d) && (!jdField_c_of_type_Boolean); localToast = a(0)) {
      return localToast;
    }
    localToast.show();
    this.e = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return localToast;
  }
  
  public Toast a(int paramInt)
  {
    return a(paramInt, 2131561669, null);
  }
  
  public Toast a(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    QQToast.ProtectedToast localProtectedToast = new QQToast.ProtectedToast(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    Object localObject = localView.findViewById(2131379611);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject).setElevation(6.0F);
    }
    AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772251);
    localObject = (LinearLayout)localView.findViewById(2131379616);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$RightActionParams != null) {
      a(localProtectedToast, (LinearLayout)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$RightActionParams);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localObject = (ImageView)localView.findViewById(2131379614);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((ImageView)localObject).setColorFilter(b(this.jdField_b_of_type_Int), PorterDuff.Mode.MULTIPLY);
      if (this.jdField_a_of_type_JavaLangCharSequence != null)
      {
        localObject = (TextView)localView.findViewById(2131379617);
        ((TextView)localObject).setTextColor(c(this.jdField_b_of_type_Int));
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangCharSequence);
        String str = this.jdField_a_of_type_JavaLangCharSequence.toString();
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        float f1 = localTextPaint.measureText(str);
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
        float f2 = localDisplayMetrics.densityDpi / 160 * 50;
        f2 = localDisplayMetrics.widthPixels - f2;
        if (f1 > f2) {
          ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          f1 = localTextPaint.measureText(str);
          if (f1 > f2) {
            ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
          }
        }
      }
      if (!b()) {
        break label395;
      }
      localProtectedToast.setGravity(55, 0, 0);
    }
    for (;;)
    {
      localProtectedToast.setView(localView);
      localProtectedToast.setDuration(this.jdField_c_of_type_Int);
      if (b()) {
        localView.setOnTouchListener(new QQToast.1(this, localProtectedToast, paramOnTouchListener));
      }
      return localProtectedToast;
      ((ImageView)localView.findViewById(2131379614)).setVisibility(8);
      break;
      label395:
      if (paramInt1 == 6316128) {
        localProtectedToast.setGravity(55, 0, a());
      } else {
        localProtectedToast.setGravity(55, 0, b());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(QQToast.IToastValidListener paramIToastValidListener)
  {
    paramIToastValidListener = new QQToast.ShowToastMessage(this, paramIToastValidListener);
    jdField_a_of_type_JavaUtilConcurrentBlockingQueue.add(paramIToastValidListener);
    jdField_a_of_type_ComTencentMobileqqWidgetQQToast$ToastHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQToast", 2, "current queue size is " + jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size());
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int b()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 44.0F + 0.5D);
  }
  
  public Toast b(int paramInt)
  {
    Toast localToast = a(paramInt);
    if ((d) && (!jdField_c_of_type_Boolean)) {
      return localToast;
    }
    localToast.show();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.e = false;
    return localToast;
  }
  
  public Toast b(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    paramOnTouchListener = a(paramInt1, paramInt2, paramOnTouchListener);
    if ((d) && (!jdField_c_of_type_Boolean)) {
      return paramOnTouchListener;
    }
    paramOnTouchListener.show();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.e = false;
    return paramOnTouchListener;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean d()
  {
    if (this.jdField_c_of_type_Int == 0) {}
    for (long l = 2000L; (System.currentTimeMillis() - this.jdField_a_of_type_Long > l) || (this.e); l = 3500L) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast
 * JD-Core Version:    0.7.0.1
 */