package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QFormMultiLineItem
  extends RelativeLayout
{
  private ImageView mArrowView;
  private int mBgType;
  private ImageView mHeaderView;
  private int mImageHeight = 0;
  private int mImageWidth = 0;
  private boolean mIsFreeForm = false;
  private int mLineNum = -1;
  private ArrayList<QMultiImageTextView> mLines;
  private int mMarginBetweenPictureAndText = 0;
  private int mMarginLeft = 0;
  private int mMarginLine = 0;
  private int mMarginRight = 0;
  private int minHeight = 0;
  
  public QFormMultiLineItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initTypedArray(paramAttributeSet);
    initView();
  }
  
  public static Drawable getSelectorByType(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839575);
    case 0: 
      return paramResources.getDrawable(2130839575);
    case 1: 
      return paramResources.getDrawable(2130839591);
    case 2: 
      return paramResources.getDrawable(2130839585);
    }
    return paramResources.getDrawable(2130839582);
  }
  
  private void initTypedArray(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Y);
    try
    {
      if (this.mLineNum < 0) {
        this.mLineNum = paramAttributeSet.getInt(R.styleable.A, 2);
      }
      this.mImageWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.y, 0);
      this.mImageHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.x, 0);
      this.minHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.B, 0);
      int i = getResources().getDimensionPixelSize(2131296774);
      int j = getResources().getDimensionPixelSize(2131296776);
      int k = getResources().getDimensionPixelSize(2131296772);
      this.mMarginLeft = paramAttributeSet.getDimensionPixelSize(R.styleable.z, i);
      this.mMarginRight = paramAttributeSet.getDimensionPixelSize(R.styleable.D, j);
      this.mMarginBetweenPictureAndText = paramAttributeSet.getDimensionPixelSize(R.styleable.C, k);
      this.mBgType = paramAttributeSet.getInteger(R.styleable.w, 0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormMultiLineItem", 2, localException.toString());
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void initView()
  {
    if ((this.mLineNum < 2) && (this.mLineNum > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int m = getResources().getDimensionPixelSize(2131296784);
    int j = getResources().getDimensionPixelSize(2131296793);
    int k = getResources().getDimensionPixelSize(2131296782);
    int i;
    QMultiImageTextView localQMultiImageTextView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.mLineNum == 2)
    {
      i = getResources().getDimensionPixelSize(2131296767);
      this.mMarginLine = k;
      setBackgroundDrawable(getSelectorByType(getResources(), this.mBgType));
      setMinimumHeight(this.minHeight);
      setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
      this.mHeaderView = new ImageView(getContext());
      this.mHeaderView.setId(2131367383);
      this.mHeaderView.setFocusable(false);
      this.mHeaderView.setClickable(false);
      this.mHeaderView.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.mHeaderView);
      this.mLines = new ArrayList();
      localQMultiImageTextView = new QMultiImageTextView(getContext());
      localQMultiImageTextView.setId(2131367381);
      localQMultiImageTextView.setTextSize(0, m);
      localQMultiImageTextView.setTextColor(getResources().getColor(2131167100));
      localQMultiImageTextView.setSingleLine(true);
      localQMultiImageTextView.setDuplicateParentStateEnabled(true);
      localQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localQMultiImageTextView.setText(HardCodeUtil.a(2131704748));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131367383);
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
      this.mLines.add(localQMultiImageTextView);
      addView(localQMultiImageTextView, localLayoutParams);
      i = 1;
      label314:
      if (i >= this.mLineNum) {
        return;
      }
      localQMultiImageTextView = new QMultiImageTextView(getContext());
      localQMultiImageTextView.setTextSize(0, j);
      localQMultiImageTextView.setTextColor(getResources().getColor(2131167119));
      localQMultiImageTextView.setSingleLine(true);
      localQMultiImageTextView.setDuplicateParentStateEnabled(true);
      localQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localQMultiImageTextView.setText(HardCodeUtil.a(2131704750));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
      localLayoutParams.addRule(1, 2131367383);
      if (i != 1) {
        break label487;
      }
      localQMultiImageTextView.setId(2131367387);
    }
    for (;;)
    {
      if (i != this.mLineNum - 1) {
        localLayoutParams.bottomMargin = k;
      }
      addView(localQMultiImageTextView, localLayoutParams);
      this.mLines.add(localQMultiImageTextView);
      i += 1;
      break label314;
      i = getResources().getDimensionPixelSize(2131296783);
      break;
      label487:
      if (i == 2) {
        localQMultiImageTextView.setId(2131367388);
      }
    }
  }
  
  private void setLineLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = 0;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (paramInt1 < this.mLineNum)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((QMultiImageTextView)this.mLines.get(paramInt1)).getLayoutParams();
      localLayoutParams.topMargin = paramInt2;
      localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
      paramInt2 += ((QMultiImageTextView)this.mLines.get(paramInt1)).getMeasuredHeight();
      ((QMultiImageTextView)this.mLines.get(paramInt1)).setLayoutParams(localLayoutParams);
      paramInt1 += 1;
    }
  }
  
  public ImageView getHeaderView()
  {
    return this.mHeaderView;
  }
  
  public QMultiImageTextView getLineAt(int paramInt)
  {
    if ((paramInt >= this.mLineNum) || (paramInt < 0)) {
      throw new RuntimeException("Qui MultiLineItem array index out of range");
    }
    return (QMultiImageTextView)this.mLines.get(paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mImageHeight == 0)
    {
      if (this.mLineNum == 2) {
        this.mImageHeight = getResources().getDimensionPixelSize(2131296766);
      }
    }
    else
    {
      if (this.mImageWidth == 0)
      {
        if (this.mLineNum != 2) {
          break label226;
        }
        this.mImageWidth = getResources().getDimensionPixelSize(2131296766);
      }
      label58:
      if (this.minHeight == 0) {
        if (this.mLineNum != 2) {
          break label243;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    int j;
    int i;
    label226:
    label243:
    for (this.minHeight = getResources().getDimensionPixelSize(2131296765);; this.minHeight = getResources().getDimensionPixelSize(2131296780))
    {
      setMinimumHeight(this.minHeight);
      setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
      localLayoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
      this.mHeaderView.setLayoutParams(localLayoutParams);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(15, -1);
      j = 0;
      i = 0;
      while (j < this.mLineNum)
      {
        ((QMultiImageTextView)this.mLines.get(j)).measure(paramInt1, paramInt2);
        i += ((QMultiImageTextView)this.mLines.get(j)).getMeasuredHeight();
        j += 1;
      }
      this.mImageHeight = getResources().getDimensionPixelSize(2131296781);
      break;
      this.mImageWidth = getResources().getDimensionPixelSize(2131296781);
      break label58;
    }
    this.mHeaderView.measure(paramInt1, paramInt2);
    if ((this.mHeaderView.getMeasuredHeight() > i) || (this.mLineNum <= 3))
    {
      j = this.mMarginLine;
      int k = this.mLineNum;
      setLineLayout((this.minHeight - (j * (k - 1) + i)) / 2, paramInt1, paramInt2);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      i = getResources().getDimensionPixelSize(2131296778);
      j = getResources().getDimensionPixelSize(2131296773);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHeaderView.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.mHeaderView.setLayoutParams(localLayoutParams);
      setLineLayout(i, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((QMultiImageTextView)this.mLines.get(this.mLineNum - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = j;
      ((QMultiImageTextView)this.mLines.get(this.mLineNum - 1)).setLayoutParams(localLayoutParams);
    }
  }
  
  public void setAllTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
    Iterator localIterator = this.mLines.iterator();
    while (localIterator.hasNext()) {
      ((QMultiImageTextView)localIterator.next()).setTextColor(localColorStateList);
    }
  }
  
  public void setAllTextSize(float paramFloat)
  {
    Iterator localIterator = this.mLines.iterator();
    while (localIterator.hasNext()) {
      ((QMultiImageTextView)localIterator.next()).setTextSize(paramFloat);
    }
  }
  
  public void setBackGroundByType(int paramInt)
  {
    setBackgroundDrawable(getSelectorByType(getResources(), paramInt));
  }
  
  public void setHeaderView(int paramInt)
  {
    if (this.mHeaderView != null) {
      this.mHeaderView.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt < 2) {
      throw new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    }
    if (this.mLineNum == paramInt) {}
    for (;;)
    {
      postInvalidate();
      return;
      int i;
      if (this.mLineNum < paramInt)
      {
        int j = getResources().getDimensionPixelSize(2131296793);
        int k = this.mLineNum;
        i = 0;
        while (i < paramInt - k)
        {
          QMultiImageTextView localQMultiImageTextView = new QMultiImageTextView(getContext());
          localQMultiImageTextView.setTextSize(0, j);
          localQMultiImageTextView.setTextColor(getResources().getColor(2131167119));
          localQMultiImageTextView.setSingleLine(true);
          localQMultiImageTextView.setDuplicateParentStateEnabled(true);
          localQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
          localQMultiImageTextView.setText(HardCodeUtil.a(2131704749));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
          localLayoutParams.addRule(1, 2131367383);
          this.mLines.add(localQMultiImageTextView);
          addView(localQMultiImageTextView, localLayoutParams);
          i += 1;
        }
        this.mLineNum = paramInt;
      }
      else if (this.mLineNum > paramInt)
      {
        i = this.mLineNum;
        while (i > paramInt)
        {
          this.mLines.remove(this.mLineNum - 1);
          i -= 1;
        }
        this.mLineNum = paramInt;
      }
    }
  }
  
  public void setMarginLeftRight(int paramInt1, int paramInt2)
  {
    this.mMarginLeft = paramInt1;
    this.mMarginRight = paramInt2;
  }
  
  public void setmMinHeight(int paramInt)
  {
    this.minHeight = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QFormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */