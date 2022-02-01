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
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int = 0;
  private boolean e = false;
  
  public QQToast(Context paramContext)
  {
    this.b = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130839273;
    case 2: 
    case 5: 
      return 2130848044;
    case 1: 
    case 4: 
      return 2130848043;
    }
    return 2130839273;
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
    if ((paramRightActionParams.jdField_a_of_type_JavaLangString != null) && (!paramRightActionParams.jdField_a_of_type_JavaLangString.isEmpty()))
    {
      Context localContext = paramLinearLayout.getContext();
      Object localObject = new View(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = new TextView(localContext);
      ((TextView)localObject).setOnClickListener(new QQToast.2(this, paramRightActionParams, paramToast));
      ((TextView)localObject).setText(paramRightActionParams.jdField_a_of_type_JavaLangString);
      if (paramRightActionParams.jdField_a_of_type_Int == 0) {
        paramRightActionParams.jdField_a_of_type_Int = localContext.getResources().getColor(2131165501);
      }
      ((TextView)localObject).setTextColor(paramRightActionParams.jdField_a_of_type_Int);
      if (paramRightActionParams.b == 0) {
        paramRightActionParams.b = 16;
      }
      ((TextView)localObject).setTextSize(1, paramRightActionParams.b);
      paramToast = new LinearLayout.LayoutParams(-2, -2);
      paramToast.rightMargin = QQUIDelegate.a(localContext, 22.0F);
      paramLinearLayout.addView((View)localObject, paramToast);
      return;
    }
    QLog.e("QQToast", 1, "addRightActionView params isNullOrEmpty");
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int == 1;
  }
  
  public static int b(int paramInt)
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
  
  public static boolean b()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  private static int c(int paramInt)
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
    catch (Exception localException)
    {
      label22:
      double d1;
      break label22;
    }
    d1 = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F;
    Double.isNaN(d1);
    return (int)(d1 + 0.5D);
  }
  
  public Toast a()
  {
    Toast localToast;
    if (c()) {
      localToast = a(a());
    } else {
      localToast = a(0);
    }
    if ((d) && (!jdField_c_of_type_Boolean)) {
      return localToast;
    }
    localToast.show();
    this.e = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return localToast;
  }
  
  public Toast a(int paramInt)
  {
    return a(paramInt, 2131561517, null);
  }
  
  public Toast a(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    QQToast.ProtectedToast localProtectedToast = new QQToast.ProtectedToast(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    Object localObject1 = localView.findViewById(2131378958);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject1).setElevation(6.0F);
    }
    localObject1 = (LinearLayout)localView.findViewById(2131378962);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$RightActionParams;
    if (localObject2 != null) {
      a(localProtectedToast, (LinearLayout)localObject1, (QQToast.RightActionParams)localObject2);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localObject1 = (ImageView)localView.findViewById(2131378961);
      ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((ImageView)localObject1).setColorFilter(b(this.b), PorterDuff.Mode.MULTIPLY);
    }
    else
    {
      ((ImageView)localView.findViewById(2131378961)).setVisibility(8);
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = (TextView)localView.findViewById(2131378963);
      ((TextView)localObject1).setTextColor(c(this.b));
      ((TextView)localObject1).setText(this.jdField_a_of_type_JavaLangCharSequence);
      localObject2 = this.jdField_a_of_type_JavaLangCharSequence.toString();
      TextPaint localTextPaint = ((TextView)localObject1).getPaint();
      float f1 = localTextPaint.measureText((String)localObject2);
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
      float f2 = localDisplayMetrics.densityDpi / 160 * 50;
      f2 = localDisplayMetrics.widthPixels - f2;
      if (f1 > f2) {
        ((TextView)localObject1).setTextSize(2, ((TextView)localObject1).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        f1 = localTextPaint.measureText((String)localObject2);
        if (f1 > f2) {
          ((TextView)localObject1).setTextSize(2, ((TextView)localObject1).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
        }
      }
    }
    if (b()) {
      localProtectedToast.setGravity(55, 0, 0);
    } else if (paramInt1 == 6316128) {
      localProtectedToast.setGravity(55, 0, a());
    } else {
      localProtectedToast.setGravity(55, 0, b());
    }
    localProtectedToast.setView(localView);
    localProtectedToast.setDuration(this.jdField_c_of_type_Int);
    if (b()) {
      localView.setOnTouchListener(new QQToast.1(this, localProtectedToast, paramOnTouchListener));
    }
    return localProtectedToast;
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
    if (QLog.isColorLevel())
    {
      paramIToastValidListener = new StringBuilder();
      paramIToastValidListener.append("current queue size is ");
      paramIToastValidListener.append(jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size());
      QLog.d("QQToast", 2, paramIToastValidListener.toString());
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
    catch (Exception localException)
    {
      label23:
      double d1;
      break label23;
    }
    d1 = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 44.0F;
    Double.isNaN(d1);
    return (int)(d1 + 0.5D);
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
    this.b = paramInt;
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
    long l;
    if (this.jdField_c_of_type_Int == 0) {
      l = 2000L;
    } else {
      l = 3500L;
    }
    return (System.currentTimeMillis() - this.jdField_a_of_type_Long <= l) && (!this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast
 * JD-Core Version:    0.7.0.1
 */