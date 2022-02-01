package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bmbx;
import bmzm;
import bmzn;
import bmzo;
import bmzp;
import bmzq;
import bodx;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QIMSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private static final int DEFAULT_ROUNDED_SIZE = 2;
  public static final String KEY_CHECKED_IMAGE_BG_ID = "checked_image_bg_id";
  public static final String KEY_NOMAL_IMAGE_BG_ID = "normal_image_bg_id";
  private static final String TAG = "SlidingTabView";
  private boolean mCheckX;
  private int mCurrentIndex;
  private int mIndicatorColor = -16776961;
  private int mIndicatorHeight = 4;
  private int mIndicatorPadding;
  private int mIndicatorStartX;
  private LinearLayout.LayoutParams mLayoutParam;
  private bmzp mListener;
  private Paint mPaint;
  private int mPrevIndex;
  private LinearLayout mRootLayout;
  private int mScrollOffset = 52;
  private ArrayList<View> mTabItemList = new ArrayList(5);
  private int mTabPadding = 15;
  private int mTabStartEndMargin;
  private int mTabTextSize = 14;
  private int mTextColorChecked = -16777216;
  private int mTextColorNormal = -7829368;
  private int mUnderlineColor = -3355444;
  private int mUnderlineHeight = 1;
  private int roundedSize = 2;
  private int roundedSizeDP = 2;
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext, paramAttributeSet);
  }
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext, paramAttributeSet);
  }
  
  private int addTabItem(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    paramView.setOnClickListener(new bmzn(this, paramInt));
    this.mTabItemList.add(paramInt, paramView);
    this.mRootLayout.addView(paramView, paramInt);
    return 0;
  }
  
  @TargetApi(11)
  private void doIndicatorAnimation()
  {
    if (this.mPrevIndex != this.mCurrentIndex)
    {
      Object localObject = this.mRootLayout.getChildAt(this.mPrevIndex);
      View localView = this.mRootLayout.getChildAt(this.mCurrentIndex);
      int i;
      int j;
      if ((localObject != null) && (localView != null))
      {
        i = ((View)localObject).getLeft();
        j = localView.getLeft();
        if ((i == 0) && (j == 0)) {
          this.mCheckX = true;
        }
      }
      else
      {
        return;
      }
      this.mCheckX = false;
      localObject = ValueAnimator.ofInt(new int[] { i, j });
      ((ValueAnimator)localObject).setDuration(100L);
      ((ValueAnimator)localObject).addUpdateListener(new bmzo(this));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.mIndicatorStartX = this.mRootLayout.getChildAt(this.mCurrentIndex).getLeft();
    this.mCheckX = true;
    invalidate();
  }
  
  private void initUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mLayoutParam = new LinearLayout.LayoutParams(-2, -1);
    this.mRootLayout = new LinearLayout(paramContext);
    this.mRootLayout.setOrientation(0);
    this.mRootLayout.setLayoutParams(this.mLayoutParam);
    addView(this.mRootLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mTabStartEndMargin = ((int)TypedValue.applyDimension(1, this.mTabStartEndMargin, localDisplayMetrics));
    this.mScrollOffset = ((int)TypedValue.applyDimension(1, this.mScrollOffset, localDisplayMetrics));
    this.mIndicatorHeight = ((int)TypedValue.applyDimension(1, this.mIndicatorHeight, localDisplayMetrics));
    this.mUnderlineHeight = ((int)TypedValue.applyDimension(1, this.mUnderlineHeight, localDisplayMetrics));
    this.mTabPadding = ((int)TypedValue.applyDimension(1, this.mTabPadding, localDisplayMetrics));
    this.mTabTextSize = ((int)TypedValue.applyDimension(1, this.mTabTextSize, localDisplayMetrics));
    this.mIndicatorPadding = ((int)TypedValue.applyDimension(1, this.mIndicatorPadding, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.mTabStartEndMargin = paramContext.getDimensionPixelSize(4, this.mTabStartEndMargin);
    this.mTabPadding = paramContext.getDimensionPixelSize(3, this.mTabPadding);
    this.mIndicatorColor = paramContext.getColor(0, this.mIndicatorColor);
    this.mIndicatorHeight = paramContext.getDimensionPixelSize(1, this.mIndicatorHeight);
    this.mTextColorNormal = paramContext.getColor(6, this.mTextColorNormal);
    this.mTextColorChecked = paramContext.getColor(5, this.mTextColorChecked);
    this.mUnderlineColor = paramContext.getColor(8, this.mUnderlineColor);
    this.mUnderlineHeight = paramContext.getDimensionPixelSize(9, this.mUnderlineHeight);
    this.mTabTextSize = paramContext.getDimensionPixelSize(7, this.mTabTextSize);
    this.mIndicatorPadding = paramContext.getDimensionPixelSize(2, this.mIndicatorPadding);
    paramContext.recycle();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.mIndicatorColor);
    this.mPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.roundedSize = bodx.a(this.roundedSizeDP);
  }
  
  private void resetTabItemLayoutParams()
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mRootLayout.getChildAt(i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (i == 0) {
        localLayoutParams.setMargins(this.mTabStartEndMargin, 0, 0, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        i += 1;
        break;
        if (i == j - 1) {
          localLayoutParams.setMargins(0, 0, this.mTabStartEndMargin, 0);
        }
      }
    }
  }
  
  private void scrollToTab(int paramInt)
  {
    View localView = this.mRootLayout.getChildAt(paramInt);
    int i;
    if (localView != null)
    {
      paramInt = getScrollX();
      i = this.mTabPadding * 4;
      int j = localView.getRight() - paramInt - getWidth() + i;
      if (j <= 0) {
        break label53;
      }
      smoothScrollBy(j, 0);
    }
    label53:
    do
    {
      return;
      paramInt = localView.getLeft() - paramInt - i;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  private void setTabChangeBackgroud(int paramInt)
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.mRootLayout.getChildAt(i);
      View localView;
      if ((this.mTabItemList != null) && (i < this.mTabItemList.size()))
      {
        localView = (View)this.mTabItemList.get(i);
        if (i != paramInt) {
          break label188;
        }
        if (!(localView instanceof ImageView)) {
          break label109;
        }
        localObject = (Bundle)localView.getTag();
        if (localObject != null) {
          ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("checked_image_bg_id", 2130846570));
        }
      }
      label188:
      for (;;)
      {
        i += 1;
        break;
        label109:
        if ((localView instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject).setTextColor(this.mTextColorChecked);
          ((RedDotTextView)localObject).a(false);
        }
        else if ((localView instanceof TextView))
        {
          ((TextView)localObject).setTextColor(this.mTextColorChecked);
        }
        else if ((localView instanceof QIMSlidingItemView))
        {
          ((QIMSlidingItemView)localObject).a(this.mTextColorChecked, true);
          continue;
          if ((localView instanceof ImageView))
          {
            localObject = (Bundle)localView.getTag();
            if (localObject != null) {
              ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("normal_image_bg_id", 2130846569));
            }
          }
          else if ((localView instanceof RedDotTextView))
          {
            ((RedDotTextView)localObject).setTextColor(this.mTextColorNormal);
          }
          else if ((localView instanceof TextView))
          {
            ((TextView)localObject).setTextColor(this.mTextColorNormal);
          }
          else if ((localView instanceof QIMSlidingItemView))
          {
            ((QIMSlidingItemView)localObject).a(this.mTextColorNormal, false);
          }
        }
      }
    }
  }
  
  public int getTabCount()
  {
    return this.mTabItemList.size();
  }
  
  public ArrayList<View> getmTabItemList()
  {
    return this.mTabItemList;
  }
  
  public void initTabItemsWithIconString(ArrayList<bmzm> paramArrayList)
  {
    this.mRootLayout.removeAllViews();
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject;
      if (((bmzm)paramArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setText(((bmzm)paramArrayList.get(i)).jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setTextSize(0, this.mTabTextSize);
        ((TextView)localObject).setPadding(this.mTabPadding, 0, this.mTabPadding, 0);
        addTabItem(i, (View)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = new QIMSlidingItemView(getContext());
        ((QIMSlidingItemView)localObject).a(this.mTabTextSize, this.mTabPadding);
        ((QIMSlidingItemView)localObject).setData((bmzm)paramArrayList.get(i));
        addTabItem(i, (View)localObject);
      }
    }
    resetTabItemLayoutParams();
    onTabChecked(0);
  }
  
  public void initTabItemsWithRedDot(ArrayList<bmzq> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.mRootLayout.removeAllViews();
      return;
    }
    this.mTabItemList.clear();
    this.mRootLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(((bmzq)paramArrayList.get(i)).jdField_a_of_type_JavaLangString);
      localRedDotTextView.setGravity(17);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setTextSize(0, this.mTabTextSize);
      localRedDotTextView.setPadding(this.mTabPadding, 0, this.mTabPadding, 0);
      localRedDotTextView.a(((bmzq)paramArrayList.get(i)).jdField_a_of_type_Boolean);
      String str = ((bmzq)paramArrayList.get(i)).b;
      if (!TextUtils.isEmpty(str)) {
        localRedDotTextView.setContentDescription(str);
      }
      addTabItem(i, localRedDotTextView);
      i += 1;
    }
    resetTabItemLayoutParams();
  }
  
  public void initTabItemsWithString(ArrayList<String> paramArrayList)
  {
    this.mRootLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setText((CharSequence)paramArrayList.get(i));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(0, this.mTabTextSize);
      localTextView.setPadding(this.mTabPadding, 0, this.mTabPadding, 0);
      addTabItem(i, localTextView);
      i += 1;
    }
    resetTabItemLayoutParams();
    onTabChecked(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    View localView = this.mRootLayout.getChildAt(this.mCurrentIndex);
    if (localView != null)
    {
      if (this.mCheckX)
      {
        this.mIndicatorStartX = localView.getLeft();
        scrollToTab(this.mCurrentIndex);
        this.mCheckX = false;
      }
      if ((this.mCurrentIndex == 0) && (this.mIndicatorStartX < localView.getLeft())) {
        this.mIndicatorStartX = localView.getLeft();
      }
      this.mPaint.setColor(this.mIndicatorColor);
      float f1 = this.mIndicatorStartX + this.mIndicatorPadding;
      float f2 = i - this.mIndicatorHeight;
      int j = this.mIndicatorStartX;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + j - this.mIndicatorPadding, i), this.roundedSize, this.roundedSize, this.mPaint);
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    bmbx.a("SlidingTabView", "selected index: " + paramInt);
    if ((paramInt < 0) || (paramInt >= this.mTabItemList.size())) {
      return;
    }
    this.mCurrentIndex = paramInt;
    setTabChangeBackgroud(paramInt);
    scrollToTab(paramInt);
    doIndicatorAnimation();
    if (this.mListener != null) {
      this.mListener.onTabChecked(paramInt);
    }
    this.mPrevIndex = this.mCurrentIndex;
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.mIndicatorColor = paramInt;
    this.mPaint.setColor(this.mIndicatorColor);
    invalidate();
  }
  
  public void setTabCheckListener(bmzp parambmzp)
  {
    this.mListener = parambmzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingTabView
 * JD-Core Version:    0.7.0.1
 */