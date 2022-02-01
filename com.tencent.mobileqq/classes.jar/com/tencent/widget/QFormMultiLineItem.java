package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839622);
          }
          return paramResources.getDrawable(2130839629);
        }
        return paramResources.getDrawable(2130839632);
      }
      return paramResources.getDrawable(2130839638);
    }
    return paramResources.getDrawable(2130839622);
  }
  
  /* Error */
  private void initTypedArray(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	com/tencent/widget/QFormMultiLineItem:getContext	()Landroid/content/Context;
    //   4: aload_1
    //   5: getstatic 82	com/tencent/mobileqq/qqui/R$styleable:bO	[I
    //   8: invokevirtual 88	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 34	com/tencent/widget/QFormMultiLineItem:mLineNum	I
    //   16: ifge +15 -> 31
    //   19: aload_0
    //   20: aload_1
    //   21: getstatic 91	com/tencent/mobileqq/qqui/R$styleable:bT	I
    //   24: iconst_2
    //   25: invokevirtual 97	android/content/res/TypedArray:getInt	(II)I
    //   28: putfield 34	com/tencent/widget/QFormMultiLineItem:mLineNum	I
    //   31: aload_0
    //   32: aload_1
    //   33: getstatic 100	com/tencent/mobileqq/qqui/R$styleable:bR	I
    //   36: iconst_0
    //   37: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   40: putfield 44	com/tencent/widget/QFormMultiLineItem:mImageWidth	I
    //   43: aload_0
    //   44: aload_1
    //   45: getstatic 106	com/tencent/mobileqq/qqui/R$styleable:bQ	I
    //   48: iconst_0
    //   49: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   52: putfield 42	com/tencent/widget/QFormMultiLineItem:mImageHeight	I
    //   55: aload_0
    //   56: aload_1
    //   57: getstatic 109	com/tencent/mobileqq/qqui/R$styleable:bU	I
    //   60: iconst_0
    //   61: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   64: putfield 40	com/tencent/widget/QFormMultiLineItem:minHeight	I
    //   67: aload_0
    //   68: invokevirtual 113	com/tencent/widget/QFormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   71: ldc 114
    //   73: invokevirtual 117	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   76: istore_2
    //   77: aload_0
    //   78: invokevirtual 113	com/tencent/widget/QFormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   81: ldc 118
    //   83: invokevirtual 117	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   86: istore_3
    //   87: aload_0
    //   88: invokevirtual 113	com/tencent/widget/QFormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   91: ldc 119
    //   93: invokevirtual 117	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   96: istore 4
    //   98: aload_0
    //   99: aload_1
    //   100: getstatic 122	com/tencent/mobileqq/qqui/R$styleable:bS	I
    //   103: iload_2
    //   104: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   107: putfield 46	com/tencent/widget/QFormMultiLineItem:mMarginLeft	I
    //   110: aload_0
    //   111: aload_1
    //   112: getstatic 125	com/tencent/mobileqq/qqui/R$styleable:bW	I
    //   115: iload_3
    //   116: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   119: putfield 48	com/tencent/widget/QFormMultiLineItem:mMarginRight	I
    //   122: aload_0
    //   123: aload_1
    //   124: getstatic 128	com/tencent/mobileqq/qqui/R$styleable:bV	I
    //   127: iload 4
    //   129: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   132: putfield 50	com/tencent/widget/QFormMultiLineItem:mMarginBetweenPictureAndText	I
    //   135: aload_0
    //   136: aload_1
    //   137: getstatic 131	com/tencent/mobileqq/qqui/R$styleable:bP	I
    //   140: iconst_0
    //   141: invokevirtual 134	android/content/res/TypedArray:getInteger	(II)I
    //   144: putfield 136	com/tencent/widget/QFormMultiLineItem:mBgType	I
    //   147: goto +27 -> 174
    //   150: astore 5
    //   152: goto +27 -> 179
    //   155: astore 5
    //   157: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +14 -> 174
    //   163: ldc 144
    //   165: iconst_2
    //   166: aload 5
    //   168: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_1
    //   175: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   178: return
    //   179: aload_1
    //   180: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   183: aload 5
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	QFormMultiLineItem
    //   0	186	1	paramAttributeSet	AttributeSet
    //   76	28	2	i	int
    //   86	30	3	j	int
    //   96	32	4	k	int
    //   150	1	5	localObject	Object
    //   155	29	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	31	150	finally
    //   31	147	150	finally
    //   157	174	150	finally
    //   12	31	155	java/lang/Exception
    //   31	147	155	java/lang/Exception
  }
  
  private void initView()
  {
    int i = this.mLineNum;
    if ((i < 2) && (i > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int m = getResources().getDimensionPixelSize(2131297095);
    int j = getResources().getDimensionPixelSize(2131297104);
    int k = getResources().getDimensionPixelSize(2131297093);
    if (this.mLineNum == 2) {
      i = getResources().getDimensionPixelSize(2131297078);
    } else {
      i = getResources().getDimensionPixelSize(2131297094);
    }
    this.mMarginLine = k;
    setBackgroundDrawable(getSelectorByType(getResources(), this.mBgType));
    setMinimumHeight(this.minHeight);
    setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
    this.mHeaderView = new ImageView(getContext());
    this.mHeaderView.setId(2131433621);
    this.mHeaderView.setFocusable(false);
    this.mHeaderView.setClickable(false);
    this.mHeaderView.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mHeaderView);
    this.mLines = new ArrayList();
    QMultiImageTextView localQMultiImageTextView = new QMultiImageTextView(getContext());
    localQMultiImageTextView.setId(2131433618);
    localQMultiImageTextView.setTextSize(0, m);
    localQMultiImageTextView.setTextColor(getResources().getColor(2131168102));
    localQMultiImageTextView.setSingleLine(true);
    localQMultiImageTextView.setDuplicateParentStateEnabled(true);
    localQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    localQMultiImageTextView.setText(HardCodeUtil.a(2131902725));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131433621);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
    this.mLines.add(localQMultiImageTextView);
    addView(localQMultiImageTextView, localLayoutParams);
    i = 1;
    while (i < this.mLineNum)
    {
      localQMultiImageTextView = new QMultiImageTextView(getContext());
      localQMultiImageTextView.setTextSize(0, j);
      localQMultiImageTextView.setTextColor(getResources().getColor(2131168125));
      localQMultiImageTextView.setSingleLine(true);
      localQMultiImageTextView.setDuplicateParentStateEnabled(true);
      localQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localQMultiImageTextView.setText(HardCodeUtil.a(2131902727));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
      localLayoutParams.addRule(1, 2131433621);
      if (i == 1) {
        localQMultiImageTextView.setId(2131433625);
      } else if (i == 2) {
        localQMultiImageTextView.setId(2131433626);
      }
      if (i != this.mLineNum - 1) {
        localLayoutParams.bottomMargin = k;
      }
      addView(localQMultiImageTextView, localLayoutParams);
      this.mLines.add(localQMultiImageTextView);
      i += 1;
    }
  }
  
  private void setLineLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    while (paramInt2 < this.mLineNum)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((QMultiImageTextView)this.mLines.get(paramInt2)).getLayoutParams();
      localLayoutParams.topMargin = paramInt1;
      localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
      paramInt1 += ((QMultiImageTextView)this.mLines.get(paramInt2)).getMeasuredHeight();
      ((QMultiImageTextView)this.mLines.get(paramInt2)).setLayoutParams(localLayoutParams);
      paramInt2 += 1;
    }
  }
  
  public ImageView getHeaderView()
  {
    return this.mHeaderView;
  }
  
  public QMultiImageTextView getLineAt(int paramInt)
  {
    if ((paramInt < this.mLineNum) && (paramInt >= 0)) {
      return (QMultiImageTextView)this.mLines.get(paramInt);
    }
    throw new RuntimeException("Qui MultiLineItem array index out of range");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mImageHeight == 0) {
      if (this.mLineNum == 2) {
        this.mImageHeight = getResources().getDimensionPixelSize(2131297077);
      } else {
        this.mImageHeight = getResources().getDimensionPixelSize(2131297092);
      }
    }
    if (this.mImageWidth == 0) {
      if (this.mLineNum == 2) {
        this.mImageWidth = getResources().getDimensionPixelSize(2131297077);
      } else {
        this.mImageWidth = getResources().getDimensionPixelSize(2131297092);
      }
    }
    if (this.minHeight == 0) {
      if (this.mLineNum == 2) {
        this.minHeight = getResources().getDimensionPixelSize(2131297076);
      } else {
        this.minHeight = getResources().getDimensionPixelSize(2131297091);
      }
    }
    setMinimumHeight(this.minHeight);
    int i = this.mMarginLeft;
    int k = this.mMarginRight;
    int j = 0;
    setPadding(i, 0, k, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
    this.mHeaderView.setLayoutParams(localLayoutParams);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    i = 0;
    while (j < this.mLineNum)
    {
      ((QMultiImageTextView)this.mLines.get(j)).measure(paramInt1, paramInt2);
      i += ((QMultiImageTextView)this.mLines.get(j)).getMeasuredHeight();
      j += 1;
    }
    this.mHeaderView.measure(paramInt1, paramInt2);
    if ((this.mHeaderView.getMeasuredHeight() <= i) && (this.mLineNum > 3))
    {
      i = getResources().getDimensionPixelSize(2131297089);
      j = getResources().getDimensionPixelSize(2131297084);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHeaderView.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.mHeaderView.setLayoutParams(localLayoutParams);
      setLineLayout(i, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((QMultiImageTextView)this.mLines.get(this.mLineNum - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = j;
      ((QMultiImageTextView)this.mLines.get(this.mLineNum - 1)).setLayoutParams(localLayoutParams);
    }
    else
    {
      j = this.mMarginLine;
      k = this.mLineNum;
      setLineLayout((this.minHeight - (i + j * (k - 1))) / 2, paramInt1, paramInt2);
    }
    super.onMeasure(paramInt1, paramInt2);
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
    ImageView localImageView = this.mHeaderView;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt >= 2)
    {
      int i = this.mLineNum;
      if (i != paramInt) {
        if (i < paramInt)
        {
          int j = getResources().getDimensionPixelSize(2131297104);
          int k = this.mLineNum;
          i = 0;
          while (i < paramInt - k)
          {
            localObject = new QMultiImageTextView(getContext());
            ((QMultiImageTextView)localObject).setTextSize(0, j);
            ((QMultiImageTextView)localObject).setTextColor(getResources().getColor(2131168125));
            ((QMultiImageTextView)localObject).setSingleLine(true);
            ((QMultiImageTextView)localObject).setDuplicateParentStateEnabled(true);
            ((QMultiImageTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
            ((QMultiImageTextView)localObject).setText(HardCodeUtil.a(2131902726));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = this.mMarginBetweenPictureAndText;
            localLayoutParams.addRule(1, 2131433621);
            this.mLines.add(localObject);
            addView((View)localObject, localLayoutParams);
            i += 1;
          }
          this.mLineNum = paramInt;
        }
        else if (i > paramInt)
        {
          while (i > paramInt)
          {
            this.mLines.remove(this.mLineNum - 1);
            i -= 1;
          }
          this.mLineNum = paramInt;
        }
      }
      postInvalidate();
      return;
    }
    Object localObject = new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    for (;;)
    {
      throw ((Throwable)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QFormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */