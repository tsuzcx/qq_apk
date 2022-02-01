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
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new CalloutPopupWindow.InnerHandler();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private int jdField_b_of_type_Int = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c = 81;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, -2, paramInt2);
  }
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    if (paramInt1 >= 0)
    {
      this.e = paramInt3;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
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
        int i = DisplayUtil.a(paramView.getContext(), 300.0F);
        j = DisplayUtil.a(paramView.getContext(), 120.0F);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(i, j);
        this.jdField_b_of_type_Int = DisplayUtil.a(paramView.getContext(), this.jdField_b_of_type_Int);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        int m = localRect.right - localRect.left;
        int n = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        j = this.e;
        int k = 0;
        i = 0;
        float f1;
        if ((j != 51) && (this.e != 52))
        {
          j = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicHeight();
          if (this.e == 49)
          {
            paramInt2 = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight() + paramView.getHeight() + j) * -1 - this.jdField_b_of_type_Int;
          }
          else
          {
            if (this.e != 50) {
              break label730;
            }
            paramInt2 = this.jdField_b_of_type_Int;
          }
          if (this.c == 83)
          {
            f1 = (localRect.centerX() - arrayOfInt[0]) / m;
            paramInt1 = (int)((paramView.getWidth() - getWidth()) / 2 + f1 * getWidth() / 2.0F);
            j = paramInt2;
          }
          else
          {
            if (this.c != 82) {
              break label733;
            }
            paramInt1 = (paramView.getWidth() - getWidth()) / 2;
            j = paramInt2;
          }
        }
        else
        {
          j = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + j);
          if (this.e == 51)
          {
            paramInt1 = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth() + j) * -1 - this.jdField_b_of_type_Int;
          }
          else
          {
            if (this.e != 52) {
              break label739;
            }
            paramInt1 = paramView.getWidth() + j + this.jdField_b_of_type_Int;
          }
          if (this.c == 83)
          {
            f1 = (localRect.centerY() - arrayOfInt[1]) / n;
            paramInt2 = (int)((paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) / 2 - f1 * this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth() / 2.0F) * -1;
            break label742;
          }
          if (this.c != 82) {
            break label745;
          }
          paramInt2 = (paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) * -1 / 2;
          break label742;
        }
        int i1 = arrayOfInt[0] + paramInt1;
        paramInt2 = getWidth();
        int i2 = arrayOfInt[1] + j;
        int i3 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight() + i2;
        if ((this.e != 51) && (this.e != 52))
        {
          if (paramInt2 + i1 > m - this.jdField_a_of_type_Int) {
            paramInt1 = m - this.jdField_a_of_type_Int - getWidth() - arrayOfInt[0];
          }
          paramInt2 = paramInt1;
          i = k;
          if (i1 < localRect.left + this.jdField_a_of_type_Int)
          {
            paramInt2 = localRect.left + this.jdField_a_of_type_Int - arrayOfInt[0];
            i = k;
          }
        }
        else
        {
          if (i3 > n - this.jdField_a_of_type_Int) {
            i = i3 - (n - this.jdField_a_of_type_Int);
          }
          paramInt2 = paramInt1;
          if (i2 < localRect.top + this.jdField_a_of_type_Int)
          {
            i = localRect.top + this.jdField_a_of_type_Int - i2;
            paramInt2 = paramInt1;
          }
        }
        d(paramView, paramInt2, i);
        SLog.b("CalloutPopupWindow.VASH", "show tips xoff=%d, yAnchorOff=%d, yoff=%d", Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j));
        super.showAsDropDown(paramView, paramInt2, j + i);
        if (this.d > 0)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new WeakReference(this)), this.d * 1000);
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
      int j = paramInt2;
      continue;
      label739:
      continue;
      label742:
      label745:
      j = paramInt2;
    }
  }
  
  private void d(View paramView, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    int i = this.e;
    if ((i != 51) && (i != 52))
    {
      paramInt2 = paramView.getWidth();
      i = localDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding((paramInt2 - i) / 2 - paramInt1, 0, 0, 0);
      return;
    }
    paramInt1 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
    i = localDrawable.getIntrinsicHeight();
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, (paramInt1 - i) / 2 - paramInt2, 0, 0);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView.getWidth() == 0) && (paramView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new CalloutPopupWindow.1(this, paramView, paramInt1, paramInt2));
      return;
    }
    c(paramView, paramInt1, paramInt2);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        i = DisplayUtil.a(paramView.getContext(), 300.0F);
        j = DisplayUtil.a(paramView.getContext(), 120.0F);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(i, j);
        this.jdField_b_of_type_Int = DisplayUtil.a(paramView.getContext(), this.jdField_b_of_type_Int);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        int i1 = localRect.right - localRect.left;
        int i2 = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        i = this.e;
        int n = 0;
        int k = 0;
        float f1;
        if ((i != 51) && (this.e != 52))
        {
          i = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicHeight();
          if (this.e == 49)
          {
            j = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight() + paramView.getHeight() + i) * -1 - this.jdField_b_of_type_Int;
          }
          else
          {
            if (this.e != 50) {
              break label748;
            }
            j = this.jdField_b_of_type_Int;
          }
          if (this.c == 83)
          {
            f1 = (localRect.centerX() - arrayOfInt[0]) / i1;
            i = (int)((paramView.getWidth() - getWidth()) / 2 + f1 * getWidth() / 2.0F);
            m = j;
          }
          else
          {
            if (this.c != 82) {
              break label754;
            }
            i = (paramView.getWidth() - getWidth()) / 2;
            m = j;
          }
        }
        else
        {
          i = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + i);
          if (this.e == 51)
          {
            i = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth() + i) * -1 - this.jdField_b_of_type_Int;
          }
          else
          {
            if (this.e != 52) {
              break label764;
            }
            i = paramView.getWidth() + i + this.jdField_b_of_type_Int;
          }
          if (this.c == 83)
          {
            f1 = (localRect.centerY() - arrayOfInt[1]) / i2;
            j = (int)((paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) / 2 - f1 * this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth() / 2.0F) * -1;
            break label770;
          }
          if (this.c != 82) {
            break label773;
          }
          j = (paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) * -1 / 2;
          break label770;
        }
        int i3 = arrayOfInt[0] + i;
        j = getWidth();
        int i4 = arrayOfInt[1] + m;
        int i5 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight() + i4;
        if ((this.e != 51) && (this.e != 52))
        {
          if (j + i3 > i1 - this.jdField_a_of_type_Int) {
            i = i1 - this.jdField_a_of_type_Int - getWidth() - arrayOfInt[0];
          }
          j = i;
          k = n;
          if (i3 < localRect.left + this.jdField_a_of_type_Int)
          {
            j = localRect.left + this.jdField_a_of_type_Int - arrayOfInt[0];
            k = n;
          }
        }
        else
        {
          if (i5 > i2 - this.jdField_a_of_type_Int) {
            k = i5 - (i2 - this.jdField_a_of_type_Int);
          }
          j = i;
          if (i4 < localRect.top + this.jdField_a_of_type_Int)
          {
            k = localRect.top + this.jdField_a_of_type_Int - i4;
            j = i;
          }
        }
        d(paramView, j, k);
        super.showAtLocation(paramView, 51, j + paramInt1, arrayOfInt[1] + m + k + paramView.getHeight() + paramInt2);
        if (this.d > 0)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new WeakReference(this)), this.d * 1000);
          return;
        }
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
      }
      return;
      label748:
      int j = 0;
      continue;
      label754:
      int i = 0;
      int m = j;
      continue;
      label764:
      i = 0;
      continue;
      label770:
      break label776;
      label773:
      j = 0;
      label776:
      m = j;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramDrawable);
    super.setBackgroundDrawable(new ColorDrawable());
  }
  
  public void setContentView(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Drawable localDrawable;
      switch (this.e)
      {
      default: 
        break;
      case 52: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, -2, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -2, -2);
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.g);
        }
        break;
      case 51: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -2, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, -2, -2);
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.g);
        }
        a(this.jdField_a_of_type_AndroidWidgetImageView);
        break;
      case 50: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, -2, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -2, -2);
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.f);
        }
        break;
      case 49: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -2, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, -2, -2);
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.f);
        }
        a(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, -2, -2);
      super.setContentView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow
 * JD-Core Version:    0.7.0.1
 */