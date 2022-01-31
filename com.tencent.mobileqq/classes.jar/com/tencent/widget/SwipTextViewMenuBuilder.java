package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;

public abstract class SwipTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  public final int a;
  public final int[] a;
  public final int[] b;
  public final int[] c;
  public final int[] d;
  
  public SwipTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.d = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.c = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = paramObject;
    if (paramSwipRightMenuItem != null)
    {
      localObject1 = paramObject;
      if (paramSwipRightMenuItem.jdField_a_of_type_Int >= 0)
      {
        if (paramSwipRightMenuItem.b >= 0) {
          break label35;
        }
        localObject1 = paramObject;
      }
    }
    label35:
    int i;
    int j;
    int k;
    do
    {
      return localObject1;
      paramObject = localObject2;
      if ((paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
        paramObject = (SimpleTextView)paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView;
      }
      i = this.b[paramSwipRightMenuItem.b];
      j = this.c[paramSwipRightMenuItem.b];
      k = this.jdField_a_of_type_ArrayOfInt[paramSwipRightMenuItem.b];
      localObject1 = paramObject;
    } while (paramObject == null);
    paramObject.setVisibility(0);
    paramObject.setText(paramObject.getContext().getResources().getString(i));
    paramObject.setBackgroundResource(j);
    paramObject.setId(k);
    paramObject.setTag("tag_swip_icon_menu_item");
    paramObject.setTag(-2, Integer.valueOf(i));
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    paramObject.setContentDescription(paramObject.getResources().getString(i));
    paramObject.setOnClickListener(paramOnClickListener);
    paramSwipRightMenuItem.c = this.d[paramSwipRightMenuItem.jdField_a_of_type_Int];
    paramSwipRightMenuItem.d = this.jdField_a_of_type_Int;
    return paramObject;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d[paramInt], this.jdField_a_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.SwipTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */