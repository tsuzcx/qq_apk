package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HotPicTab
  extends HorizontalListView
{
  private static int k;
  private static final int l;
  private static final int m;
  private static final int n;
  private static final float o;
  private static final int p;
  private static final int q;
  public final Paint a;
  HotPicTab.HotPicTabAdapter b;
  Paint c = new Paint();
  int d = -1;
  private Context e;
  private float f;
  private int g = -1;
  private int h = -1;
  private Set<Integer> i = new HashSet();
  private ArrayList<Integer> j = new ArrayList();
  private Handler r = new HotPicTab.1(this);
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    k = localResources.getDisplayMetrics().widthPixels;
    l = (int)(localResources.getDisplayMetrics().density * 40.0F + 0.5F);
    m = (int)(localResources.getDisplayMetrics().density * 4.0F + 0.5F);
    n = 14;
    o = localResources.getDisplayMetrics().density;
    p = localResources.getColor(2131168138);
    q = localResources.getColor(2131168139);
  }
  
  public HotPicTab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    this.a = new Paint();
    this.a.setColor(p);
  }
  
  public int a(int paramInt)
  {
    int i1 = this.mNextX + paramInt;
    if (i1 < 0) {
      return -1;
    }
    if (i1 > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public void a()
  {
    setAdapter(null);
    this.j.clear();
    setOnItemClickListener(null);
    this.b = null;
    this.i.clear();
  }
  
  public void a(List<HotPicTagInfo> paramList, int paramInt)
  {
    boolean bool1 = false;
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      i1 = 2131167913;
    } else {
      i1 = 2131168487;
    }
    setBackgroundResource(i1);
    paramList = new ArrayList(paramList);
    this.c.setTextSize(n * o + 0.5F);
    Iterator localIterator = paramList.iterator();
    int i1 = 0;
    HotPicTagInfo localHotPicTagInfo;
    while (localIterator.hasNext())
    {
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
      int i2 = (int)((int)(this.c.measureText(localHotPicTagInfo.tagName) + 0.5F) + o * 26.0F);
      this.j.add(Integer.valueOf(i2));
      i1 += i2;
    }
    if (i1 < k)
    {
      boolean bool2 = true;
      this.j.clear();
      float f1 = k / i1;
      localIterator = paramList.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        i1 = (int)((int)((int)(this.c.measureText(localHotPicTagInfo.tagName) + 0.5F) + o * 26.0F) * f1);
        this.j.add(Integer.valueOf(i1));
      }
    }
    this.b = new HotPicTab.HotPicTabAdapter(this, paramList, this.j, bool1);
    this.d = paramInt;
    setAdapter(this.b);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i2 = k;
    int i1 = this.h;
    int i3 = this.mLeftViewAdapterIndex;
    int i5 = 0;
    if (i1 < i3) {
      i1 = 0;
    }
    View localView;
    do
    {
      do
      {
        i2 = 0;
        break;
        if (this.h > this.mRightViewAdapterIndex)
        {
          i3 = k;
          i1 = i2;
          i2 = i3;
          break;
        }
        localView = getChild(this.h);
        i1 = i2;
      } while (localView == null);
      i1 = i2;
    } while (localView.getTag() == null);
    Object localObject = (HotPicTab.ViewHolder)localView.getTag();
    i2 = (int)(localView.getLeft() + ((HotPicTab.ViewHolder)localObject).a.getLeft() - o * 5.0F);
    i1 = (int)(localView.getLeft() + ((HotPicTab.ViewHolder)localObject).a.getRight() + o * 5.0F);
    int i4 = i1;
    i3 = i2;
    if (this.f > 0.0F)
    {
      localView = getSelectedView();
      if ((localView != null) && (localView.getTag() != null))
      {
        localObject = ((HotPicTab.ViewHolder)localView.getTag()).a;
        i4 = (int)(localView.getLeft() + ((TextView)localObject).getLeft() - o * 5.0F);
        i3 = (int)(localView.getLeft() + ((TextView)localObject).getRight() + o * 5.0F);
      }
      else
      {
        i3 = 0;
        i4 = i5;
      }
      float f1 = i2;
      float f2 = this.f;
      i2 = (int)(f1 + (i4 - i2) * f2);
      i4 = (int)(i1 + f2 * (i3 - i1));
      i3 = i2;
    }
    paramCanvas.drawRect(i3, getHeight() - m, i4, getHeight(), this.a);
  }
  
  public int getCurrentSelected()
  {
    return this.mCurrentlySelectedAdapterIndex;
  }
  
  public HotPicTagInfo getSelectedTag()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((HotPicTab.HotPicTabAdapter)localObject).a;
      if (((List)localObject).size() > this.mCurrentlySelectedAdapterIndex)
      {
        localObject = (HotPicTagInfo)((List)localObject).get(this.mCurrentlySelectedAdapterIndex);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (AppSetting.e) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 50, paramInt8, paramBoolean);
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.reset(paramBoolean);
      return;
    }
    initView(this.isFromRightToLeft);
    removeAllViewsInLayout();
    if (this.d != -1)
    {
      int i1 = 0;
      int i2 = 0;
      while ((i1 < this.d) && (i1 < this.j.size()))
      {
        i2 += ((Integer)this.j.get(i1)).intValue();
        i1 += 1;
      }
      i1 = i2 + ((Integer)this.j.get(this.d)).intValue() * 1 / 2;
      i2 = k * 1 / 2;
      if (i1 > i2) {
        this.mCurrentX = (i1 - i2);
      } else {
        this.mCurrentX = 0;
      }
      i1 = this.d;
      this.mCurrentlySelectedAdapterIndex = i1;
      this.h = i1;
      this.f = 1.0F;
      this.mDataChanged = true;
    }
    else
    {
      this.mCurrentlySelectedAdapterIndex = 0;
      this.h = 0;
    }
    requestLayout();
  }
  
  public void setSelection(int paramInt)
  {
    if (this.mCurrentlySelectedAdapterIndex == paramInt) {
      return;
    }
    super.setSelection(paramInt);
    int i5 = k;
    if (this.mAdapter == null) {
      return;
    }
    if (paramInt < this.mAdapter.getCount())
    {
      if (paramInt < 0) {
        return;
      }
      int i3 = getFirstVisiblePosition();
      int i4 = getLastVisiblePosition();
      int i1;
      int i2;
      if ((paramInt > i4) && (i4 != -1))
      {
        i1 = 0;
        i2 = 0;
        while (i1 <= paramInt)
        {
          i2 += ((Integer)this.j.get(i1)).intValue();
          i1 += 1;
        }
        paramInt = i2 - this.mNextX - i5;
      }
      else if ((paramInt < i3) && (i3 != -1))
      {
        i1 = 0;
        i2 = 0;
        while (i1 < paramInt)
        {
          i2 += ((Integer)this.j.get(i1)).intValue();
          i1 += 1;
        }
        paramInt = i2 - this.mNextX;
      }
      else
      {
        View localView;
        int[] arrayOfInt;
        if (paramInt == i3)
        {
          localView = getChildAt(0);
          arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          paramInt = arrayOfInt[0];
        }
        else
        {
          if (paramInt == i4)
          {
            localView = getChildAt(getChildCount() - 1);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            i1 = ((Integer)this.j.get(paramInt)).intValue() - (i5 - arrayOfInt[0]);
            paramInt = i1;
            if (i1 >= 0) {
              break label277;
            }
          }
          else if (DEBUG)
          {
            QLog.isDevelopLevel();
          }
          paramInt = 0;
        }
      }
      label277:
      if (paramInt != 0) {
        a(paramInt);
      } else if ((i3 == -1) && (i4 == -1)) {
        ViewCompat.postOnAnimation(this, new HotPicTab.2(this));
      } else {
        requestLayout();
      }
      this.f = 0.0F;
      this.r.removeCallbacksAndMessages(null);
      if (Build.MODEL.equalsIgnoreCase("OPPO R7"))
      {
        this.r.sendEmptyMessage(2);
        return;
      }
      this.r.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab
 * JD-Core Version:    0.7.0.1
 */