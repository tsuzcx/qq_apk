package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.filemanager.activity.adapter.DelDownloadHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private float a;
  private float b;
  private float c;
  private boolean d;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private QfilePinnedHeaderExpandableListView.OnSelectListener i;
  private boolean j;
  private int k;
  private boolean l = false;
  
  public QfilePinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    setNeedCheckSpringback(true);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setSelector(2131168376);
    setGroupIndicator(null);
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    int m = getFirstVisiblePosition();
    Object localObject = (ViewGroup)getChildAt(pointToPosition(paramInt1, paramInt2) - m);
    if (localObject == null) {
      return null;
    }
    paramInt2 = ((ViewGroup)localObject).getChildCount();
    m = this.k;
    if (m == 0) {
      return null;
    }
    if (paramInt1 > m * paramInt2) {
      paramInt1 = paramInt2 - 1;
    } else {
      paramInt1 /= m;
    }
    localObject = ((ViewGroup)localObject).getChildAt(paramInt1);
    if (localObject == null) {
      return null;
    }
    localObject = ((View)localObject).getTag();
    if (localObject != null)
    {
      if ((localObject instanceof ImageHolder))
      {
        localObject = (ImageHolder)localObject;
        return new int[] { ((ImageHolder)localObject).h, ((ImageHolder)localObject).g };
      }
      if (DelDownloadHolder.class.isInstance(localObject))
      {
        localObject = (DelDownloadHolder)localObject;
        return new int[] { ((DelDownloadHolder)localObject).i, ((DelDownloadHolder)localObject).h };
      }
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j)
    {
      int m = paramMotionEvent.getAction();
      if ((m == 2) && (this.l)) {
        return true;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      m &= 0xFF;
      if (m != 0)
      {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3) {
              break label233;
            }
          }
          else
          {
            float f3 = Math.abs(f1 - this.a);
            if ((f3 <= Math.abs(f2 - this.b) * 1.73F) || (f3 <= this.c)) {
              break label233;
            }
            this.l = true;
            this.a = f1;
            this.b = f2;
            break label233;
          }
        }
        boolean bool = this.l;
        this.l = false;
        this.g = -1;
        this.e = -1;
        this.h = -1;
        this.f = -1;
        this.d = false;
        if (bool) {
          return true;
        }
      }
      else
      {
        this.a = f1;
        this.b = f2;
        int[] arrayOfInt = a((int)f1, (int)f2);
        if (arrayOfInt != null)
        {
          m = arrayOfInt[0];
          this.g = m;
          this.e = m;
          m = arrayOfInt[1];
          this.h = m;
          this.f = m;
        }
      }
      label233:
      if (this.l) {
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j)
    {
      int m = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      m &= 0xFF;
      if (m != 0)
      {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3) {
              break label461;
            }
          }
          else
          {
            if (!this.l)
            {
              float f3 = Math.abs(f1 - this.a);
              if ((f3 > Math.abs(f2 - this.b) * 1.73F) && (f3 > this.c))
              {
                this.l = true;
                this.a = f1;
                this.b = f2;
              }
              else
              {
                localObject = this.i;
                if (localObject != null) {
                  ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(true);
                }
              }
            }
            if (!this.l) {
              break label461;
            }
            int n;
            if (!this.d)
            {
              m = this.e;
              if (m != -1)
              {
                n = this.f;
                if (n != -1)
                {
                  localObject = this.i;
                  if (localObject != null) {
                    ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(m, n);
                  }
                  this.d = true;
                }
              }
            }
            localObject = a((int)f1, (int)f2);
            if (localObject != null)
            {
              n = localObject[0];
              m = localObject[1];
            }
            else
            {
              m = -1;
              n = -1;
            }
            if ((n == -1) || (m == -1)) {
              break label461;
            }
            if (!this.d)
            {
              this.g = n;
              this.e = n;
              this.h = m;
              this.f = m;
              localObject = this.i;
              if (localObject != null) {
                ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(this.e, this.f);
              }
              this.d = true;
              break label461;
            }
            this.g = n;
            this.h = m;
            localObject = this.i;
            if (localObject == null) {
              break label461;
            }
            ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(this.e, this.f, this.g, this.h);
            break label461;
          }
        }
        boolean bool = this.l;
        Object localObject = this.i;
        if (localObject != null)
        {
          if (bool) {
            ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).b(this.g, this.h);
          }
          this.i.a(false);
        }
        this.g = -1;
        this.e = -1;
        this.h = -1;
        this.f = -1;
        this.l = false;
        this.d = false;
        if (bool) {
          return true;
        }
      }
      else
      {
        this.a = f1;
        this.b = f2;
      }
      label461:
      if (this.l) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setGridSize(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setOnIndexChangedListener(QfilePinnedHeaderExpandableListView.OnSelectListener paramOnSelectListener)
  {
    this.i = paramOnSelectListener;
  }
  
  public void setTouchSlop(Context paramContext)
  {
    this.c = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
  }
  
  public void setWhetherImageTab(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */