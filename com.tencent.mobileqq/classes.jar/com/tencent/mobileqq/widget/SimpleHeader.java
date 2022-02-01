package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;

public class SimpleHeader
  extends RelativeLayout
  implements IPullRefreshHeaderControl
{
  public SimpleHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramObject = (RelativeLayout)findViewById(2131444554);
      localObject = (RelativeLayout.LayoutParams)paramObject.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramObject.setBackgroundColor(getResources().getColor(2131168188));
      return;
    }
    if (paramInt == 2)
    {
      paramObject = (View)paramObject;
      paramObject.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.getScreenHeight()));
      localObject = (ViewGroup)findViewById(2131438474);
      if (indexOfChild(paramObject) < 0) {
        ((ViewGroup)localObject).addView(paramObject);
      }
      ((ViewGroup)localObject).setVisibility(0);
      return;
    }
    if (paramInt == 23)
    {
      ((RelativeLayout)findViewById(2131438474)).setAlpha(((Float)paramObject).floatValue());
      return;
    }
    if (paramInt == 4)
    {
      ((RelativeLayout)findViewById(2131444554)).setVisibility(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 22) {
      ((RelativeLayout.LayoutParams)((RelativeLayout)findViewById(2131438474)).getLayoutParams()).bottomMargin = ((Integer)paramObject).intValue();
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong) {}
  
  public Object b(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      paramObject = (RelativeLayout)findViewById(2131444554);
      boolean bool;
      if ((paramObject != null) && (paramObject.getVisibility() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    return null;
  }
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
  
  public void f() {}
  
  public long g()
  {
    return 0L;
  }
  
  public View getHeaderView()
  {
    return null;
  }
  
  public void setHeaderBgColor(int paramInt) {}
  
  public void setHeaderBgDrawable(Drawable paramDrawable) {}
  
  public void setHeaderBgRes(int paramInt) {}
  
  public void setPullType(int paramInt) {}
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SimpleHeader
 * JD-Core Version:    0.7.0.1
 */