package com.tencent.mobileqq.rely;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;

public abstract class SwipTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  protected final int[] e;
  protected final int[] f;
  protected final int[] g;
  protected final int[] h;
  protected final int i;
  
  public SwipTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.h = paramArrayOfInt1;
    this.i = paramInt3;
    this.e = paramArrayOfInt2;
    this.f = paramArrayOfInt3;
    this.g = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = localObject2;
    if (paramSwipRightMenuItem != null)
    {
      localObject1 = localObject2;
      if (paramSwipRightMenuItem.a >= 0)
      {
        if (paramSwipRightMenuItem.b < 0) {
          return null;
        }
        if ((paramSwipRightMenuItem.e instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)paramSwipRightMenuItem.e;
        }
        int j = this.f[paramSwipRightMenuItem.b];
        int k = this.g[paramSwipRightMenuItem.b];
        int m = this.e[paramSwipRightMenuItem.b];
        localObject1 = paramObject;
        if (paramObject != null)
        {
          paramObject.setVisibility(0);
          paramObject.setText(paramObject.getContext().getResources().getString(j));
          paramObject.setBackgroundResource(k);
          paramObject.setId(m);
          paramObject.setTag("tag_swip_icon_menu_item");
          paramObject.setTag(-2, Integer.valueOf(j));
          paramObject.setTag(-1, Integer.valueOf(paramInt));
          paramObject.setContentDescription(paramObject.getResources().getString(j));
          paramObject.setOnClickListener(paramOnClickListener);
          paramSwipRightMenuItem.c = this.h[paramSwipRightMenuItem.a];
          paramSwipRightMenuItem.d = this.i;
          localObject1 = paramObject;
        }
      }
    }
    return localObject1;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.h[paramInt], this.i));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.rely.SwipTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */