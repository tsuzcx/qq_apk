package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.PopupWindowCompat;

public class RelativePopupWindow
  extends PopupWindow
{
  public RelativePopupWindow() {}
  
  public RelativePopupWindow(Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1073741824;
    }
    return 0;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(b(paramInt1, paramInt2), a(paramInt1));
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
    }
    return paramInt2;
  }
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, 0, 0);
  }
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    setClippingEnabled(paramBoolean);
    Object localObject = getContentView();
    Rect localRect = new Rect();
    ((View)localObject).getWindowVisibleDisplayFrame(localRect);
    int i = localRect.width();
    int j = localRect.height();
    ((View)localObject).measure(a(getWidth(), i), a(getHeight(), j));
    int n = ((View)localObject).getMeasuredWidth();
    int k = ((View)localObject).getMeasuredHeight();
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    i = localObject[1];
    int m = paramView.getHeight() + i;
    if (!paramBoolean)
    {
      paramInt3 += localObject[0];
      i = paramInt4 + m;
    }
    for (paramInt4 = paramInt3;; paramInt4 = paramInt3)
    {
      paramInt3 = i;
      switch (paramInt1)
      {
      default: 
        paramInt3 = i;
      case 2: 
        paramInt1 = paramInt4;
        switch (paramInt2)
        {
        default: 
          paramInt1 = paramInt4;
        case 3: 
          label215:
          if (!paramBoolean) {
            break label377;
          }
          if (paramInt3 + m < 0) {
            paramInt2 = -m;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        PopupWindowCompat.showAsDropDown(this, paramView, paramInt1, paramInt2, 0);
        return;
        paramInt3 = i - (paramView.getHeight() + k);
        break;
        paramInt3 = i - k;
        break;
        paramInt3 = i - (paramView.getHeight() / 2 + k / 2);
        break;
        paramInt3 = i - paramView.getHeight();
        break;
        paramInt1 = paramInt4 - n;
        break label215;
        paramInt1 = paramInt4 - (n - paramView.getWidth());
        break label215;
        paramInt1 = paramInt4 + (paramView.getWidth() / 2 - n / 2);
        break label215;
        paramInt1 = paramInt4 + paramView.getWidth();
        break label215;
        paramInt2 = paramInt3;
        if (paramInt3 + m + k > j) {
          paramInt2 = j - m - k;
        }
      }
      label377:
      showAtLocation(paramView, 0, paramInt1, paramInt3);
      return;
      i = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */