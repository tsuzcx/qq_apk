package cooperation.qzone.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anec;
import aned;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class QzoneGuideBubbleHelper
{
  private static volatile QzoneGuideBubbleHelper jdField_a_of_type_CooperationQzoneWidgetQzoneGuideBubbleHelper;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private QzoneBubblePopWindow jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable = new anec(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  private static Rect a(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getMeasuredWidth(), arrayOfInt[1] + paramView.getMeasuredHeight());
  }
  
  public static ShapeDrawable a(float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject = new float[8];
    float[] arrayOfFloat = new float[8];
    int i = 0;
    while (i < 8)
    {
      localObject[i] = (paramFloat1 + paramFloat2);
      arrayOfFloat[i] = paramFloat1;
      i += 1;
    }
    localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, new RectF(paramFloat2, paramFloat2, paramFloat2, paramFloat2), arrayOfFloat));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return localObject;
  }
  
  private static FrameLayout a(Context paramContext)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity))) {
      return null;
    }
    paramContext = (ViewGroup)((Activity)paramContext).getWindow().getDecorView();
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131362649);
    if (localFrameLayout == null) {
      return (FrameLayout)paramContext.findViewById(16908290);
    }
    return localFrameLayout;
  }
  
  public static QzoneGuideBubbleHelper a()
  {
    if (jdField_a_of_type_CooperationQzoneWidgetQzoneGuideBubbleHelper == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneWidgetQzoneGuideBubbleHelper == null) {
        jdField_a_of_type_CooperationQzoneWidgetQzoneGuideBubbleHelper = new QzoneGuideBubbleHelper();
      }
      return jdField_a_of_type_CooperationQzoneWidgetQzoneGuideBubbleHelper;
    }
    finally {}
  }
  
  private int[] a(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, boolean paramBoolean, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow = new QzoneBubblePopWindow((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setWidth(-2);
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setHeight(-2);
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setTouchable(paramBoolean);
      if (paramBoolean) {
        paramViewGroup.setOnTouchListener(new aned(this));
      }
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setBackgroundDrawable(new ColorDrawable(0));
    }
    paramView = a(paramViewGroup, paramView, paramString, paramFloat, paramInt1, paramInt2, paramCompoundDrawableInfo, paramInt3, paramInt4);
    if (paramView == null) {}
    while (this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow == null) {
      return paramView;
    }
    this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.setContentView(paramViewGroup);
    this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.update();
    return paramView;
  }
  
  private int[] a(ViewGroup paramViewGroup, View paramView, String paramString, float paramFloat, int paramInt1, int paramInt2, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return null;
    }
    paramView = a(paramView);
    if ((paramView.left <= 0) && (paramView.right <= 0) && (paramView.top <= 0) && (paramView.bottom <= 0)) {
      return null;
    }
    TextView localTextView = new TextView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localTextView.setId(2131362651);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(paramFloat);
    localTextView.setText(paramString);
    int n = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560323);
    if (paramCompoundDrawableInfo != null)
    {
      paramString = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(paramCompoundDrawableInfo.jdField_a_of_type_Int);
      if (paramString != null)
      {
        paramString.setBounds(0, 0, paramCompoundDrawableInfo.b, paramCompoundDrawableInfo.c);
        localTextView.setCompoundDrawables(paramString, null, null, null);
        localTextView.setCompoundDrawablePadding(paramCompoundDrawableInfo.d);
      }
    }
    int i = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560324);
    int j = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560325);
    localTextView.setPadding(j, i, j, i);
    localTextView.setGravity(17);
    if (paramInt4 > 0)
    {
      localTextView.setMaxLines(paramInt4);
      localTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }
    i = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560326);
    a(localTextView, a(i, 0.0F, paramInt2));
    paramString = new TriangleView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramInt1, paramInt2);
    paramString.setId(2131362652);
    paramCompoundDrawableInfo = new RelativeLayout.LayoutParams(-2, -2);
    int k = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560327);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext().getResources().getDimensionPixelSize(2131560328));
    int m;
    if (paramInt1 == 0)
    {
      paramCompoundDrawableInfo.addRule(10);
      localLayoutParams.addRule(3, 2131362651);
      paramCompoundDrawableInfo.addRule(14);
      localLayoutParams.leftMargin = paramInt3;
      paramViewGroup.addView(localTextView, paramCompoundDrawableInfo);
      paramViewGroup.addView(paramString, localLayoutParams);
      paramInt2 = a(12.0F);
      paramViewGroup.measure(View.MeasureSpec.makeMeasureSpec(a() - a(12.0F) * 2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
      m = paramViewGroup.getMeasuredWidth();
      paramInt3 = paramViewGroup.getMeasuredHeight();
      j = paramView.left + (paramView.right - paramView.left) / 2 - m / 2;
      if (paramInt1 != 0) {
        break label654;
      }
      paramInt4 = paramView.top - paramInt3 - n;
      label553:
      paramInt1 = a();
      if (j >= paramInt2) {
        break label669;
      }
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      label570:
      j = paramView.left - paramInt1 + (paramView.right - paramView.left - k) / 2;
      if (j < i) {
        paramInt2 = i;
      }
      for (;;)
      {
        ViewHelper.h(paramString, paramInt2);
        return new int[] { paramInt1, paramInt4, paramInt2, paramInt3 };
        if (paramInt1 != 1) {
          break;
        }
        paramCompoundDrawableInfo.addRule(3, 2131362652);
        break;
        label654:
        paramInt4 = paramView.bottom + n;
        paramInt3 = 0;
        break label553;
        label669:
        if (j <= paramInt1 - m - paramInt2) {
          break label725;
        }
        paramInt1 = paramInt1 - m - paramInt2;
        break label570;
        paramInt2 = j;
        if (j + k > m - i) {
          paramInt2 = m - i - k;
        }
      }
      label725:
      paramInt1 = j;
    }
  }
  
  public float a()
  {
    float f = -1.0F;
    if (-1.0F < 0.0F) {
      f = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return f;
  }
  
  public int a()
  {
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
      return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
  }
  
  public int a(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  public void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    FrameLayout localFrameLayout;
    View localView;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow == null);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          try
          {
            this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.dismiss();
            this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow = null;
            return;
          }
          catch (Exception localException)
          {
            return;
          }
        } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
        localFrameLayout = a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      } while (localFrameLayout == null);
      localView = localFrameLayout.findViewById(2131362650);
    } while (localView == null);
    localFrameLayout.removeViewInLayout(localView);
  }
  
  public void a(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt4)
  {
    a(paramActivity, paramView, paramString, paramInt1, paramFloat, paramDouble1, paramDouble2, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramCompoundDrawableInfo, paramInt4, 0, 0);
  }
  
  public void a(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Int = paramInt6;
    a();
    if ((paramActivity == null) || (paramView == null) || (paramInt1 < 0) || (paramInt1 > 1)) {}
    label29:
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      paramActivity = new RelativeLayout(paramActivity);
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        for (;;)
        {
          paramString = a(paramView, paramActivity, paramString, paramFloat, paramInt1, paramDouble1, paramDouble2, paramInt2, paramBoolean2, paramCompoundDrawableInfo, paramInt4, paramInt5);
          if (paramString == null) {
            break;
          }
          paramInt4 = paramString[0] - paramInt4;
          paramInt5 = paramString[1];
          paramInt2 = paramInt3;
          if (paramInt1 == 0) {
            paramInt2 = -paramInt3;
          }
          paramInt1 = paramInt5 + paramInt2;
          switch (this.jdField_a_of_type_Int)
          {
          default: 
            return;
          case 0: 
            try
            {
              this.jdField_a_of_type_CooperationQzoneWidgetQzoneBubblePopWindow.showAtLocation(paramView, 0, paramInt4, paramInt1);
              paramActivity.setVisibility(0);
              if (paramLong <= 0L) {
                break label29;
              }
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
              return;
            }
            catch (Exception paramActivity)
            {
              return;
            }
          }
        }
        paramActivity.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        continue;
        paramActivity.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      }
      paramView = a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    } while (paramView == null);
    paramActivity.setId(2131362650);
    paramString = (FrameLayout.LayoutParams)paramActivity.getLayoutParams();
    paramString.leftMargin = Math.max(paramInt4, ViewUtils.a(12.0F));
    paramString.topMargin = paramInt1;
    paramString.rightMargin = ViewUtils.a(12.0F);
    paramView.addView(paramActivity);
  }
  
  @TargetApi(16)
  public void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneGuideBubbleHelper
 * JD-Core Version:    0.7.0.1
 */