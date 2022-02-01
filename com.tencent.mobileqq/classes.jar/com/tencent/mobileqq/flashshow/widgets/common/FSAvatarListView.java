package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.flashshow.impl.R.styleable;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.mobileqq.flashshow.view.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;

public class FSAvatarListView
  extends ViewGroup
{
  private int a;
  private float b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private List<String> i = new ArrayList();
  private List<String> j = new ArrayList();
  private boolean k;
  private int l;
  private int m;
  
  public FSAvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSAvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSAvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    int n = 0;
    while (n < 3)
    {
      addView(b().a());
      n += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = getChildCount();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addOrHideIconHolder  childCount = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" , size = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("FSAvatarListView", 1, ((StringBuilder)localObject).toString());
    int n = i1;
    if (i1 >= paramInt) {
      while (paramInt < i1)
      {
        localObject = getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
    }
    while (n < paramInt)
    {
      addView(b().a());
      n += 1;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aH);
    if (paramContext != null)
    {
      this.a = paramContext.getInteger(R.styleable.aJ, 90);
      this.b = paramContext.getFloat(R.styleable.aQ, 0.8F);
      this.d = ((int)paramContext.getDimension(R.styleable.aK, 30.0F));
      this.e = ((int)paramContext.getDimension(R.styleable.aI, 30.0F));
      this.c = paramContext.getBoolean(R.styleable.aP, false);
      this.f = ((int)paramContext.getDimension(R.styleable.aM, 0.0F));
      this.g = paramContext.getBoolean(R.styleable.aR, false);
      this.h = paramContext.getResourceId(R.styleable.aL, 0);
      this.k = paramContext.getBoolean(R.styleable.aS, false);
      this.l = paramContext.getResourceId(R.styleable.aN, 0);
      this.m = ((int)paramContext.getDimension(R.styleable.aO, 0.0F));
      paramContext.recycle();
    }
    a();
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if ((getChildAt(paramInt) instanceof FrameLayout)) {
      localObject1 = (FrameLayout)getChildAt(paramInt);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    ((FrameLayout)localObject1).setVisibility(0);
    if ((((FrameLayout)localObject1).getChildCount() > 0) && ((((FrameLayout)localObject1).getChildAt(0) instanceof RoundCornerImageView)))
    {
      Object localObject2 = (RoundCornerImageView)((FrameLayout)localObject1).getChildAt(0);
      if (this.g)
      {
        ((RoundCornerImageView)localObject2).setBackgroundColor(this.h);
      }
      else
      {
        localObject2 = new Option().setTargetView((ImageView)localObject2).setRequestWidth(this.d + this.f * 2).setRequestHeight(this.e + this.f * 2).setUrl(paramString2);
        QCircleFeedPicLoader.g().loadImage((Option)localObject2, null);
      }
    }
    if ((((FrameLayout)localObject1).getChildCount() > 1) && ((((FrameLayout)localObject1).getChildAt(1) instanceof RoundCornerImageView)))
    {
      localObject1 = (RoundCornerImageView)((FrameLayout)localObject1).getChildAt(1);
      if (paramBoolean) {
        QCircleFeedPicLoader.g().loadImage(new Option().setTargetView((ImageView)localObject1).setUrl(paramString1), null);
      } else {
        ((RoundCornerImageView)localObject1).setImageDrawable(HostFaceUtils.getFaceDrawable(1, 4, paramString1));
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setIconHolderData  i = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" , picUrl = ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" , bgPicUrl = ");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.i("FSAvatarListView", 1, ((StringBuilder)localObject1).toString());
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      int n = 0;
      setVisibility(0);
      int i1 = paramList1.size();
      a(i1);
      while (n < i1)
      {
        int i2 = paramList1.size();
        String str3 = "";
        String str1;
        if (i2 < n) {
          str1 = "";
        } else {
          str1 = (String)paramList1.get(n);
        }
        String str2 = str3;
        if (paramList2 != null) {
          if (paramList2.size() < n) {
            str2 = str3;
          } else {
            str2 = (String)paramList2.get(n);
          }
        }
        if (this.c) {
          a(str1, str2, a(str1), i1 - 1 - n);
        } else {
          a(str1, str2, a(str1), n);
        }
        n += 1;
      }
      return;
    }
    setVisibility(8);
  }
  
  private void a(List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      int n = 0;
      setVisibility(0);
      int i1 = paramList1.size();
      a(i1);
      while (n < i1)
      {
        int i2 = paramList1.size();
        String str3 = "";
        String str1;
        if (i2 < n) {
          str1 = "";
        } else {
          str1 = (String)paramList1.get(n);
        }
        String str2 = str3;
        if (paramList2 != null) {
          if (paramList2.size() < n) {
            str2 = str3;
          } else {
            str2 = (String)paramList2.get(n);
          }
        }
        if (this.c) {
          a(str1, str2, paramBoolean, i1 - 1 - n);
        } else {
          a(str1, str2, paramBoolean, n);
        }
        n += 1;
      }
      return;
    }
    setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private FSAvatarListView.SingleIconHolder b()
  {
    return new FSAvatarListView.SingleIconHolder(null).a(this.d).b(this.e).c(this.a).d(this.f).a(this.g).e(this.h).b(this.k).f(getContext().getResources().getColor(this.l)).g(this.m).a(getContext());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    View localView;
    int n;
    int i1;
    if (this.c)
    {
      paramInt1 = paramInt3 - paramInt1;
      paramInt4 -= 1;
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      while (paramInt2 >= 0)
      {
        localView = getChildAt(paramInt4 - paramInt2);
        if (localView.getVisibility() != 8)
        {
          n = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          if (paramInt2 == paramInt4) {
            paramInt1 -= n;
          } else {
            paramInt1 = (int)(paramInt1 - n * this.b);
          }
          localView.layout(paramInt1, 0, paramInt3, i1);
          paramInt3 = (int)(paramInt3 - n * this.b);
        }
        paramInt2 -= 1;
      }
    }
    paramInt2 = 0;
    paramInt1 = 0;
    paramInt3 = 0;
    while (paramInt2 < paramInt4)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        n = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        if (paramInt2 == 0) {
          paramInt1 += n;
        } else {
          paramInt1 = (int)(paramInt1 + n * this.b);
        }
        localView.layout(paramInt3, 0, paramInt1, i1);
        paramInt3 = (int)(paramInt3 + n * this.b);
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i7 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    while (i2 < i7)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        int i9 = localView.getMeasuredWidth();
        int i8 = localView.getMeasuredHeight();
        if (i2 == 0) {
          i1 += i9;
        } else {
          i1 = (int)(i1 + i9 * this.b);
        }
        n = Math.max(n, i8);
      }
      i2 += 1;
    }
    if (i6 == 1073741824) {
      paramInt1 = i4;
    } else {
      paramInt1 = i1;
    }
    if (i5 == 1073741824) {
      n = i3;
    }
    setMeasuredDimension(paramInt1, n);
  }
  
  public void setData(List<String> paramList)
  {
    setData(paramList, null, false);
  }
  
  public void setData(List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      this.i.clear();
      this.i.addAll(paramList1);
    }
    if ((paramList2 != null) && (paramList2.size() != 0))
    {
      this.j.clear();
      this.j.addAll(paramList2);
    }
    a(paramList1, paramList2, paramBoolean);
  }
  
  public void setDataGeneral(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      this.i.clear();
      this.i.addAll(paramList1);
    }
    if ((paramList2 != null) && (paramList2.size() != 0))
    {
      this.j.clear();
      this.j.addAll(paramList2);
    }
    a(paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSAvatarListView
 * JD-Core Version:    0.7.0.1
 */