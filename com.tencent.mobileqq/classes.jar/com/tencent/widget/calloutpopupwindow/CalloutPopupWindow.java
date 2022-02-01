package com.tencent.widget.calloutpopupwindow;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.util.DisplayUtil;
import java.lang.ref.WeakReference;

public class CalloutPopupWindow
  extends PopupWindow
{
  private LinearLayout a;
  private ImageView b;
  private FrameLayout c;
  private int d;
  private int e = 0;
  private int f = 81;
  private int g = 0;
  private Handler h = new CalloutPopupWindow.InnerHandler();
  private int i;
  private int j;
  private int k;
  private Drawable l;
  private Drawable m;
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, -2, paramInt2);
  }
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    if (paramInt1 >= 0)
    {
      this.i = paramInt3;
      this.a = new LinearLayout(paramContext);
      this.a.setPadding(0, 0, 0, 0);
      this.a.setOrientation(1);
      this.b = new ImageView(paramContext);
      this.c = new FrameLayout(paramContext);
      setBackgroundDrawable(new ColorDrawable());
      setOutsideTouchable(true);
      setFocusable(false);
      return;
    }
    throw new RuntimeException("You must specify the window width explicitly(do not use WRAP_CONTENT or MATCH_PARENT)!!!");
  }
  
  public static CalloutPopupWindow.Builder a(Context paramContext)
  {
    return new CalloutPopupWindow.Builder(paramContext, null);
  }
  
  private void a(ImageView paramImageView)
  {
    Rect localRect = new Rect(0, 0, paramImageView.getDrawable().getIntrinsicWidth(), paramImageView.getDrawable().getIntrinsicHeight());
    Matrix localMatrix = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    localMatrix.postRotate(180.0F, localRect.width() / 2, localRect.height() / 2);
    paramImageView.setImageMatrix(localMatrix);
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int n = DisplayUtil.a(paramView.getContext(), 300.0F);
        i1 = DisplayUtil.a(paramView.getContext(), 120.0F);
        this.c.measure(n, i1);
        this.e = DisplayUtil.a(paramView.getContext(), this.e);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        int i3 = localRect.right - localRect.left;
        int i4 = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        i1 = this.i;
        int i2 = 0;
        n = 0;
        float f1;
        if ((i1 != 51) && (this.i != 52))
        {
          i1 = this.b.getDrawable().getIntrinsicHeight();
          if (this.i == 49)
          {
            paramInt2 = (this.c.getMeasuredHeight() + paramView.getHeight() + i1) * -1 - this.e;
          }
          else
          {
            if (this.i != 50) {
              break label730;
            }
            paramInt2 = this.e;
          }
          if (this.f == 83)
          {
            f1 = (localRect.centerX() - arrayOfInt[0]) / i3;
            paramInt1 = (int)((paramView.getWidth() - getWidth()) / 2 + f1 * getWidth() / 2.0F);
            i1 = paramInt2;
          }
          else
          {
            if (this.f != 82) {
              break label733;
            }
            paramInt1 = (paramView.getWidth() - getWidth()) / 2;
            i1 = paramInt2;
          }
        }
        else
        {
          i1 = this.b.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + i1);
          if (this.i == 51)
          {
            paramInt1 = (this.c.getMeasuredWidth() + i1) * -1 - this.e;
          }
          else
          {
            if (this.i != 52) {
              break label739;
            }
            paramInt1 = paramView.getWidth() + i1 + this.e;
          }
          if (this.f == 83)
          {
            f1 = (localRect.centerY() - arrayOfInt[1]) / i4;
            paramInt2 = (int)((paramView.getHeight() + this.c.getMeasuredHeight()) / 2 - f1 * this.c.getMeasuredWidth() / 2.0F) * -1;
            break label742;
          }
          if (this.f != 82) {
            break label745;
          }
          paramInt2 = (paramView.getHeight() + this.c.getMeasuredHeight()) * -1 / 2;
          break label742;
        }
        int i5 = arrayOfInt[0] + paramInt1;
        paramInt2 = getWidth();
        int i6 = arrayOfInt[1] + i1;
        int i7 = this.c.getMeasuredHeight() + i6;
        if ((this.i != 51) && (this.i != 52))
        {
          if (paramInt2 + i5 > i3 - this.d) {
            paramInt1 = i3 - this.d - getWidth() - arrayOfInt[0];
          }
          paramInt2 = paramInt1;
          n = i2;
          if (i5 < localRect.left + this.d)
          {
            paramInt2 = localRect.left + this.d - arrayOfInt[0];
            n = i2;
          }
        }
        else
        {
          if (i7 > i4 - this.d) {
            n = i7 - (i4 - this.d);
          }
          paramInt2 = paramInt1;
          if (i6 < localRect.top + this.d)
          {
            n = localRect.top + this.d - i6;
            paramInt2 = paramInt1;
          }
        }
        d(paramView, paramInt2, n);
        SLog.b("CalloutPopupWindow.VASH", "show tips xoff=%d, yAnchorOff=%d, yoff=%d", Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i1));
        super.showAsDropDown(paramView, paramInt2, i1 + n);
        if (this.g > 0)
        {
          this.h.sendMessageDelayed(this.h.obtainMessage(1, new WeakReference(this)), this.g * 1000);
          return;
        }
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
      }
      return;
      label730:
      continue;
      label733:
      int i1 = paramInt2;
      continue;
      label739:
      continue;
      label742:
      label745:
      i1 = paramInt2;
    }
  }
  
  private void d(View paramView, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.b.getDrawable();
    int n = this.i;
    if ((n != 51) && (n != 52))
    {
      paramInt2 = paramView.getWidth();
      n = localDrawable.getIntrinsicWidth();
      this.b.setPadding((paramInt2 - n) / 2 - paramInt1, 0, 0, 0);
      return;
    }
    paramInt1 = this.c.getMeasuredHeight();
    n = localDrawable.getIntrinsicHeight();
    this.b.setPadding(0, (paramInt1 - n) / 2 - paramInt2, 0, 0);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView.getWidth() == 0) && (paramView.getVisibility() == 0))
    {
      this.h.post(new CalloutPopupWindow.1(this, paramView, paramInt1, paramInt2));
      return;
    }
    c(paramView, paramInt1, paramInt2);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(Drawable paramDrawable)
  {
    this.m = paramDrawable;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        n = DisplayUtil.a(paramView.getContext(), 300.0F);
        i1 = DisplayUtil.a(paramView.getContext(), 120.0F);
        this.c.measure(n, i1);
        this.e = DisplayUtil.a(paramView.getContext(), this.e);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        int i5 = localRect.right - localRect.left;
        int i6 = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        n = this.i;
        int i4 = 0;
        int i2 = 0;
        float f1;
        if ((n != 51) && (this.i != 52))
        {
          n = this.b.getDrawable().getIntrinsicHeight();
          if (this.i == 49)
          {
            i1 = (this.c.getMeasuredHeight() + paramView.getHeight() + n) * -1 - this.e;
          }
          else
          {
            if (this.i != 50) {
              break label748;
            }
            i1 = this.e;
          }
          if (this.f == 83)
          {
            f1 = (localRect.centerX() - arrayOfInt[0]) / i5;
            n = (int)((paramView.getWidth() - getWidth()) / 2 + f1 * getWidth() / 2.0F);
            i3 = i1;
          }
          else
          {
            if (this.f != 82) {
              break label754;
            }
            n = (paramView.getWidth() - getWidth()) / 2;
            i3 = i1;
          }
        }
        else
        {
          n = this.b.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + n);
          if (this.i == 51)
          {
            n = (this.c.getMeasuredWidth() + n) * -1 - this.e;
          }
          else
          {
            if (this.i != 52) {
              break label764;
            }
            n = paramView.getWidth() + n + this.e;
          }
          if (this.f == 83)
          {
            f1 = (localRect.centerY() - arrayOfInt[1]) / i6;
            i1 = (int)((paramView.getHeight() + this.c.getMeasuredHeight()) / 2 - f1 * this.c.getMeasuredWidth() / 2.0F) * -1;
            break label770;
          }
          if (this.f != 82) {
            break label773;
          }
          i1 = (paramView.getHeight() + this.c.getMeasuredHeight()) * -1 / 2;
          break label770;
        }
        int i7 = arrayOfInt[0] + n;
        i1 = getWidth();
        int i8 = arrayOfInt[1] + i3;
        int i9 = this.c.getMeasuredHeight() + i8;
        if ((this.i != 51) && (this.i != 52))
        {
          if (i1 + i7 > i5 - this.d) {
            n = i5 - this.d - getWidth() - arrayOfInt[0];
          }
          i1 = n;
          i2 = i4;
          if (i7 < localRect.left + this.d)
          {
            i1 = localRect.left + this.d - arrayOfInt[0];
            i2 = i4;
          }
        }
        else
        {
          if (i9 > i6 - this.d) {
            i2 = i9 - (i6 - this.d);
          }
          i1 = n;
          if (i8 < localRect.top + this.d)
          {
            i2 = localRect.top + this.d - i8;
            i1 = n;
          }
        }
        d(paramView, i1, i2);
        super.showAtLocation(paramView, 51, i1 + paramInt1, arrayOfInt[1] + i3 + i2 + paramView.getHeight() + paramInt2);
        if (this.g > 0)
        {
          this.h.sendMessageDelayed(this.h.obtainMessage(1, new WeakReference(this)), this.g * 1000);
          return;
        }
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
      }
      return;
      label748:
      int i1 = 0;
      continue;
      label754:
      int n = 0;
      int i3 = i1;
      continue;
      label764:
      n = 0;
      continue;
      label770:
      break label776;
      label773:
      i1 = 0;
      label776:
      i3 = i1;
    }
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void dismiss()
  {
    this.h.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void e(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.c.setBackgroundDrawable(paramDrawable);
    super.setBackgroundDrawable(new ColorDrawable());
  }
  
  public void setContentView(View paramView)
  {
    if (paramView != null)
    {
      this.a.removeAllViews();
      Drawable localDrawable;
      switch (this.i)
      {
      default: 
        break;
      case 52: 
        this.a.setOrientation(0);
        this.a.addView(this.b, -2, -2);
        this.a.addView(this.c, -2, -2);
        localDrawable = this.m;
        if (localDrawable != null) {
          this.b.setImageDrawable(localDrawable);
        } else {
          this.b.setImageResource(this.k);
        }
        break;
      case 51: 
        this.a.setOrientation(0);
        this.a.addView(this.c, -2, -2);
        this.a.addView(this.b, -2, -2);
        localDrawable = this.m;
        if (localDrawable != null) {
          this.b.setImageDrawable(localDrawable);
        } else {
          this.b.setImageResource(this.k);
        }
        a(this.b);
        break;
      case 50: 
        this.a.addView(this.b, -2, -2);
        this.a.addView(this.c, -2, -2);
        localDrawable = this.l;
        if (localDrawable != null) {
          this.b.setImageDrawable(localDrawable);
        } else {
          this.b.setImageResource(this.j);
        }
        break;
      case 49: 
        this.a.addView(this.c, -2, -2);
        this.a.addView(this.b, -2, -2);
        localDrawable = this.l;
        if (localDrawable != null) {
          this.b.setImageDrawable(localDrawable);
        } else {
          this.b.setImageResource(this.j);
        }
        a(this.b);
      }
      this.c.addView(paramView, -2, -2);
      super.setContentView(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow
 * JD-Core Version:    0.7.0.1
 */