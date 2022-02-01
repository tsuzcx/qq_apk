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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneGuideBubbleHelperProxy;
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
    Object localObject = this.mContext;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return null;
      }
      paramView = getViewAbsoluteLocation(paramView);
      if ((paramView.left <= 0) && (paramView.right <= 0) && (paramView.top <= 0) && (paramView.bottom <= 0)) {
        return null;
      }
      localObject = new TextView((Context)this.mContext.get());
      ((TextView)localObject).setId(2131375495);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(paramFloat);
      ((TextView)localObject).setText(paramString);
      int n = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298719);
      if (paramCompoundDrawableInfo != null)
      {
        paramString = ((Context)this.mContext.get()).getResources().getDrawable(paramCompoundDrawableInfo.drawableId);
        if (paramString != null)
        {
          paramString.setBounds(0, 0, paramCompoundDrawableInfo.drawableWidth, paramCompoundDrawableInfo.drawableHeight);
          ((TextView)localObject).setCompoundDrawables(paramString, null, null, null);
          ((TextView)localObject).setCompoundDrawablePadding(paramCompoundDrawableInfo.drawableMarginRight);
        }
      }
      int i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298721);
      int j = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298720);
      ((TextView)localObject).setPadding(j, i, j, i);
      ((TextView)localObject).setGravity(17);
      if (paramInt4 > 0)
      {
        ((TextView)localObject).setMaxLines(paramInt4);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      }
      i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298722);
      setViewBackground((View)localObject, createRoundCornerShapeDrawable(i, 0.0F, paramInt2));
      paramString = new TriangleView((Context)this.mContext.get(), paramInt1, paramInt2);
      paramString.setId(2131375493);
      paramCompoundDrawableInfo = new RelativeLayout.LayoutParams(-2, -2);
      int k = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298718);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131298717));
      if (paramInt1 == 0)
      {
        paramCompoundDrawableInfo.addRule(10);
        localLayoutParams.addRule(3, 2131375495);
      }
      else if (paramInt1 == 1)
      {
        paramCompoundDrawableInfo.addRule(3, 2131375493);
      }
      paramCompoundDrawableInfo.addRule(14);
      localLayoutParams.leftMargin = paramInt3;
      paramViewGroup.addView((View)localObject, paramCompoundDrawableInfo);
      paramViewGroup.addView(paramString, localLayoutParams);
      j = dpToPx(12.0F);
      paramViewGroup.measure(View.MeasureSpec.makeMeasureSpec(getScreenWidth() - dpToPx(12.0F) * 2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
      int m = paramViewGroup.getMeasuredWidth();
      paramInt3 = paramViewGroup.getMeasuredHeight();
      paramInt2 = paramView.left + (paramView.right - paramView.left) / 2 - m / 2;
      if (paramInt1 == 0)
      {
        paramInt4 = paramView.top - paramInt3 - n;
      }
      else
      {
        paramInt4 = paramView.bottom + n;
        paramInt3 = 0;
      }
      paramInt1 = getScreenWidth();
      if (paramInt2 < j)
      {
        paramInt1 = j;
      }
      else
      {
        paramInt1 = paramInt1 - m - j;
        if (paramInt2 <= paramInt1) {
          paramInt1 = paramInt2;
        }
      }
      paramInt2 = paramView.left - paramInt1 + (paramView.right - paramView.left - k) / 2;
      if (paramInt2 < i)
      {
        paramInt2 = i;
      }
      else
      {
        i = m - i;
        if (paramInt2 + k > i) {
          paramInt2 = i - k;
        }
      }
      ((IQzoneGuideBubbleHelperProxy)QRoute.api(IQzoneGuideBubbleHelperProxy.class)).setX(paramString, paramInt2);
      return new int[] { paramInt1, paramInt4, paramInt2, paramInt3 };
    }
    return null;
  }
  
  private int[] createGuideBubble(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, boolean paramBoolean, QzoneGuideBubbleHelper.CompoundDrawableInfo paramCompoundDrawableInfo, int paramInt3, int paramInt4)
  {
    if ((this.mShowType == 0) && (this.mPopupWindow == null))
    {
      WeakReference localWeakReference = this.mContext;
      if ((localWeakReference != null) && (localWeakReference.get() != null))
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
    }
    paramView = createContentView(paramViewGroup, paramView, paramString, paramFloat, paramInt1, paramInt2, paramCompoundDrawableInfo, paramInt3, paramInt4);
    if (paramView == null) {
      return paramView;
    }
    paramString = this.mPopupWindow;
    if (paramString != null)
    {
      paramString.setContentView(paramViewGroup);
      this.mPopupWindow.update();
    }
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
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)paramContext).getWindow().getDecorView();
      FrameLayout localFrameLayout = (FrameLayout)localViewGroup.findViewById(2131375494);
      paramContext = localFrameLayout;
      if (localFrameLayout == null) {
        paramContext = (FrameLayout)localViewGroup.findViewById(16908290);
      }
      return paramContext;
    }
    return null;
  }
  
  public static QzoneGuideBubbleHelper getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QzoneGuideBubbleHelper();
        }
      }
      finally {}
    }
    return sInstance;
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
    int i = this.mShowType;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      Object localObject = this.mContext;
      if (localObject != null)
      {
        localObject = getBubbleParentView((Context)((WeakReference)localObject).get());
        if (localObject != null)
        {
          View localView = ((FrameLayout)localObject).findViewById(2131375496);
          if (localView != null) {
            ((FrameLayout)localObject).removeViewInLayout(localView);
          }
        }
      }
    }
    else if (this.mPopupWindow != null)
    {
      this.mHandler.removeCallbacks(this.disMissRunnable);
    }
    try
    {
      this.mPopupWindow.dismiss();
      this.mPopupWindow = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public int dpToPx(float paramFloat)
  {
    return Math.round(paramFloat * getDensity());
  }
  
  public float getDensity()
  {
    return BaseApplication.getContext().getResources().getDisplayMetrics().density;
  }
  
  public int getScreenWidth()
  {
    int k;
    int j;
    int i;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      k = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      i = j;
      if (k > j) {
        return k;
      }
    }
    do
    {
      return i;
      k = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      i = j;
    } while (j <= k);
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
    if ((paramActivity != null) && (paramView != null) && (paramInt1 >= 0) && (paramInt1 <= 1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.mContext = new WeakReference(paramActivity);
      paramActivity = new RelativeLayout(paramActivity);
      paramInt6 = this.mShowType;
      if (paramInt6 != 0)
      {
        if (paramInt6 == 1) {
          paramActivity.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
      }
      else {
        paramActivity.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      paramString = createGuideBubble(paramView, paramActivity, paramString, paramFloat, paramInt1, paramDouble1, paramDouble2, paramInt2, paramBoolean2, paramCompoundDrawableInfo, paramInt4, paramInt5);
      if (paramString == null) {
        return;
      }
      paramInt2 = paramString[0] - paramInt4;
      paramInt4 = paramString[1];
      if (paramInt1 == 0) {
        paramInt3 = -paramInt3;
      }
      paramInt1 = paramInt4 + paramInt3;
      paramInt3 = this.mShowType;
      if (paramInt3 != 0)
      {
        if (paramInt3 != 1) {
          return;
        }
        paramView = getBubbleParentView((Context)this.mContext.get());
        if (paramView == null) {
          break label303;
        }
        paramActivity.setId(2131375496);
        paramString = (FrameLayout.LayoutParams)paramActivity.getLayoutParams();
        paramString.leftMargin = Math.max(paramInt2, ViewUtils.a(12.0F));
        paramString.topMargin = paramInt1;
        paramString.rightMargin = ViewUtils.a(12.0F);
        paramView.addView(paramActivity);
      }
    }
    try
    {
      this.mPopupWindow.showAtLocation(paramView, 0, paramInt2, paramInt1);
      paramActivity.setVisibility(0);
      if (paramLong > 0L) {
        this.mHandler.postDelayed(this.disMissRunnable, paramLong);
      }
      label303:
      return;
    }
    catch (Exception paramActivity) {}
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneGuideBubbleHelper
 * JD-Core Version:    0.7.0.1
 */