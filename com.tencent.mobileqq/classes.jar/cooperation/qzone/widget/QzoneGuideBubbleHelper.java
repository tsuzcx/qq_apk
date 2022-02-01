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
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class QzoneGuideBubbleHelper
{
  public static final long GUIDE_BUBBLE_NODELAY = 0L;
  public static final int GUIDE_DIRECTION_BOTTOM = 1;
  public static final int GUIDE_DIRECTION_TOP = 0;
  public static final int GUIDE_SHOW_TYPE_POPUPWINDOW = 0;
  public static final int GUIDE_SHOW_TYPE_SUBVIEW = 1;
  private static volatile QzoneGuideBubbleHelper sInstance;
  private Runnable disMissRunnable = new QzoneGuideBubbleHelper.1(this);
  private WeakReference<View> mAtachView = null;
  private WeakReference<Context> mContext = null;
  private Handler mHandler = new Handler();
  private QzoneBubblePopWindow mPopupWindow;
  private int mShowType = 0;
  
  private int[] createContentView(ViewGroup paramViewGroup, View paramView, String paramString, float paramFloat, int paramInt1, int paramInt2, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt3, int paramInt4)
  {
    if ((this.mContext == null) || (this.mContext.get() == null)) {
      return null;
    }
    paramView = getViewAbsoluteLocation(paramView);
    if ((paramView.left <= 0) && (paramView.right <= 0) && (paramView.top <= 0) && (paramView.bottom <= 0)) {
      return null;
    }
    TextView localTextView = new TextView((Context)this.mContext.get());
    localTextView.setId(2131375979);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(paramFloat);
    localTextView.setText(paramString);
    int n = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298724);
    if (paramCompoundDrawableInfo != null)
    {
      paramString = ((Context)this.mContext.get()).getResources().getDrawable(paramCompoundDrawableInfo.drawableId);
      if (paramString != null)
      {
        paramString.setBounds(0, 0, paramCompoundDrawableInfo.drawableWidth, paramCompoundDrawableInfo.drawableHeight);
        localTextView.setCompoundDrawables(paramString, null, null, null);
        localTextView.setCompoundDrawablePadding(paramCompoundDrawableInfo.drawableMarginRight);
      }
    }
    int i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298726);
    int j = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298725);
    localTextView.setPadding(j, i, j, i);
    localTextView.setGravity(17);
    if (paramInt4 > 0)
    {
      localTextView.setMaxLines(paramInt4);
      localTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }
    i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298727);
    setViewBackground(localTextView, createRoundCornerShapeDrawable(i, 0.0F, paramInt2));
    paramString = new TriangleView((Context)this.mContext.get(), paramInt1, paramInt2);
    paramString.setId(2131375977);
    paramCompoundDrawableInfo = new RelativeLayout.LayoutParams(-2, -2);
    int k = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298723);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298722));
    int m;
    if (paramInt1 == 0)
    {
      paramCompoundDrawableInfo.addRule(10);
      localLayoutParams.addRule(3, 2131375979);
      paramCompoundDrawableInfo.addRule(14);
      localLayoutParams.leftMargin = paramInt3;
      paramViewGroup.addView(localTextView, paramCompoundDrawableInfo);
      paramViewGroup.addView(paramString, localLayoutParams);
      paramInt2 = dpToPx(12.0F);
      paramViewGroup.measure(View.MeasureSpec.makeMeasureSpec(getScreenWidth() - dpToPx(12.0F) * 2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
      m = paramViewGroup.getMeasuredWidth();
      paramInt3 = paramViewGroup.getMeasuredHeight();
      j = paramView.left + (paramView.right - paramView.left) / 2 - m / 2;
      if (paramInt1 != 0) {
        break label646;
      }
      paramInt4 = paramView.top - paramInt3 - n;
      label546:
      paramInt1 = getScreenWidth();
      if (j >= paramInt2) {
        break label661;
      }
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      label563:
      j = paramView.left - paramInt1 + (paramView.right - paramView.left - k) / 2;
      if (j < i) {
        paramInt2 = i;
      }
      for (;;)
      {
        ViewHelper.g(paramString, paramInt2);
        return new int[] { paramInt1, paramInt4, paramInt2, paramInt3 };
        if (paramInt1 != 1) {
          break;
        }
        paramCompoundDrawableInfo.addRule(3, 2131375977);
        break;
        label646:
        paramInt4 = paramView.bottom + n;
        paramInt3 = 0;
        break label546;
        label661:
        if (j <= paramInt1 - m - paramInt2) {
          break label717;
        }
        paramInt1 = paramInt1 - m - paramInt2;
        break label563;
        paramInt2 = j;
        if (j + k > m - i) {
          paramInt2 = m - i - k;
        }
      }
      label717:
      paramInt1 = j;
    }
  }
  
  private int[] createGuideBubble(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, boolean paramBoolean, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt3, int paramInt4)
  {
    if ((this.mShowType == 0) && (this.mPopupWindow == null) && (this.mContext != null) && (this.mContext.get() != null))
    {
      this.mPopupWindow = new QzoneBubblePopWindow((Context)this.mContext.get());
      this.mPopupWindow.setWidth(-2);
      this.mPopupWindow.setHeight(-2);
      this.mPopupWindow.setTouchable(paramBoolean);
      if (paramBoolean) {
        paramViewGroup.setOnTouchListener(new QzoneGuideBubbleHelper.2(this));
      }
      this.mPopupWindow.setOutsideTouchable(true);
      this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    }
    paramView = createContentView(paramViewGroup, paramView, paramString, paramFloat, paramInt1, paramInt2, paramCompoundDrawableInfo, paramInt3, paramInt4);
    if (paramView == null) {}
    while (this.mPopupWindow == null) {
      return paramView;
    }
    this.mPopupWindow.setContentView(paramViewGroup);
    this.mPopupWindow.update();
    return paramView;
  }
  
  public static ShapeDrawable createRoundCornerShapeDrawable(float paramFloat1, float paramFloat2, int paramInt)
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
  
  private static FrameLayout getBubbleParentView(Context paramContext)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity))) {
      return null;
    }
    paramContext = (ViewGroup)((Activity)paramContext).getWindow().getDecorView();
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131375978);
    if (localFrameLayout == null) {
      return (FrameLayout)paramContext.findViewById(16908290);
    }
    return localFrameLayout;
  }
  
  public static QzoneGuideBubbleHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QzoneGuideBubbleHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  private static Rect getViewAbsoluteLocation(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getMeasuredWidth(), arrayOfInt[1] + paramView.getMeasuredHeight());
  }
  
  public void dismissGuideBubble()
  {
    switch (this.mShowType)
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
          } while (this.mPopupWindow == null);
          this.mHandler.removeCallbacks(this.disMissRunnable);
          try
          {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
            return;
          }
          catch (Exception localException)
          {
            return;
          }
        } while (this.mContext == null);
        localFrameLayout = getBubbleParentView((Context)this.mContext.get());
      } while (localFrameLayout == null);
      localView = localFrameLayout.findViewById(2131375980);
    } while (localView == null);
    localFrameLayout.removeViewInLayout(localView);
  }
  
  public int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public float getDensity()
  {
    float f = -1.0F;
    if (-1.0F < 0.0F) {
      f = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return f;
  }
  
  public int getScreenWidth()
  {
    int i;
    int j;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      i = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      if (i <= j) {}
    }
    int k;
    do
    {
      return i;
      return j;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      i = j;
    } while (k > j);
    return k;
  }
  
  @TargetApi(16)
  public void setViewBackground(View paramView, Drawable paramDrawable)
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
  
  public void showGuideBubble(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt4)
  {
    showGuideBubble(paramActivity, paramView, paramString, paramInt1, paramFloat, paramDouble1, paramDouble2, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramCompoundDrawableInfo, paramInt4, 0, 0);
  }
  
  public void showGuideBubble(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mShowType = paramInt6;
    dismissGuideBubble();
    if ((paramActivity == null) || (paramView == null) || (paramInt1 < 0) || (paramInt1 > 1)) {}
    label29:
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      this.mContext = new WeakReference(paramActivity);
      paramActivity = new RelativeLayout(paramActivity);
      switch (this.mShowType)
      {
      }
      for (;;)
      {
        for (;;)
        {
          paramString = createGuideBubble(paramView, paramActivity, paramString, paramFloat, paramInt1, paramDouble1, paramDouble2, paramInt2, paramBoolean2, paramCompoundDrawableInfo, paramInt4, paramInt5);
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
          switch (this.mShowType)
          {
          default: 
            return;
          case 0: 
            try
            {
              this.mPopupWindow.showAtLocation(paramView, 0, paramInt4, paramInt1);
              paramActivity.setVisibility(0);
              if (paramLong <= 0L) {
                break label29;
              }
              this.mHandler.postDelayed(this.disMissRunnable, paramLong);
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
      paramView = getBubbleParentView((Context)this.mContext.get());
    } while (paramView == null);
    paramActivity.setId(2131375980);
    paramString = (FrameLayout.LayoutParams)paramActivity.getLayoutParams();
    paramString.leftMargin = Math.max(paramInt4, ViewUtils.a(12.0F));
    paramString.topMargin = paramInt1;
    paramString.rightMargin = ViewUtils.a(12.0F);
    paramView.addView(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneGuideBubbleHelper
 * JD-Core Version:    0.7.0.1
 */