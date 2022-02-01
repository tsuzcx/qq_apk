package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout7
  extends AbsStructMsgItem
{
  private static final int az = Color.rgb(255, 221, 227);
  
  private StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int m = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    int k = 0;
    paramInt = m;
    while (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int n = k << 5;
      m = paramInt - n;
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - n;
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - n;
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      } else {
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.b(14.0F, paramResources));
      }
      k += 1;
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setOrientation(1);
    return paramContext;
  }
  
  @TargetApi(16)
  public void a(View paramView)
  {
    if (paramView != null)
    {
      int i = AIOUtils.b(14.0F, paramView.getResources());
      Object localObject = null;
      int j = a();
      if (j != 0)
      {
        float f;
        if (j != 1)
        {
          if (j == 2)
          {
            localObject = new float[8];
            localObject[0] = 0.0F;
            localObject[1] = 0.0F;
            localObject[2] = 0.0F;
            localObject[3] = 0.0F;
            f = i;
            localObject[4] = f;
            localObject[5] = f;
            localObject[6] = f;
            localObject[7] = f;
          }
        }
        else
        {
          localObject = new float[8];
          f = i;
          localObject[0] = f;
          localObject[1] = f;
          localObject[2] = f;
          localObject[3] = f;
          localObject[4] = 0.0F;
          localObject[5] = 0.0F;
          localObject[6] = 0.0F;
          localObject[7] = 0.0F;
        }
      }
      else
      {
        localObject = new float[8];
      }
      localObject = a(paramView.getResources(), az, (float[])localObject);
      if (Build.VERSION.SDK_INT < 16)
      {
        paramView.setBackgroundDrawable((Drawable)localObject);
        return;
      }
      paramView.setBackground((Drawable)localObject);
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject2 = (LinearLayout)paramView;
      if ((((LinearLayout)localObject2).getChildCount() == 2) && ((((LinearLayout)localObject2).getChildAt(0).getTag() instanceof StructMsgItemLayout7.ViewHolder)))
      {
        localObject3 = (StructMsgItemLayout7.ViewHolder)((LinearLayout)localObject2).getChildAt(0).getTag();
        if (((StructMsgItemLayout7.ViewHolder)localObject3).a != null) {
          ((StructMsgItemLayout7.ViewHolder)localObject3).a.setVisibility(8);
        }
        if (((StructMsgItemLayout7.ViewHolder)localObject3).b != null) {
          ((StructMsgItemLayout7.ViewHolder)localObject3).b.setVisibility(8);
        }
        if (((StructMsgItemLayout7.ViewHolder)localObject3).c != null) {
          ((StructMsgItemLayout7.ViewHolder)localObject3).c.setVisibility(8);
        }
        localObject1 = localObject2;
        paramView = (View)localObject3;
        if (((StructMsgItemLayout7.ViewHolder)localObject3).d == null) {
          break label285;
        }
        ((StructMsgItemLayout7.ViewHolder)localObject3).d.setVisibility(8);
        localObject1 = localObject2;
        paramView = (View)localObject3;
        break label285;
      }
    }
    paramView = new StructMsgItemLayout7.ViewHolder();
    paramView.f = new LinearLayout(paramContext);
    ((LinearLayout)paramView.f).setOrientation(1);
    Object localObject1 = new LinearLayout.LayoutParams(0, -2);
    ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    ((LinearLayout.LayoutParams)localObject1).setMargins(AIOUtils.b(15.0F, localResources), 0, 0, 0);
    paramView.e = new LinearLayout(paramContext);
    paramView.e.setTag(paramView);
    paramView.e.addView(paramView.f, (ViewGroup.LayoutParams)localObject1);
    localObject1 = a(paramContext);
    ((LinearLayout)localObject1).addView(paramView.e, new LinearLayout.LayoutParams(-1, AIOUtils.b(75.0F, localResources)));
    label285:
    Object localObject2 = null;
    Object localObject3 = this.ax.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
      ((AbsStructMsgElement)localObject4).ar = this.ar;
      Object localObject5 = ((AbsStructMsgElement)localObject4).b;
      if ("title".equals(localObject5))
      {
        if ((localObject4 instanceof StructMsgItemTitle))
        {
          localObject5 = (StructMsgItemTitle)localObject4;
          ((StructMsgItemTitle)localObject5).a(d(), 0);
          ((StructMsgItemTitle)localObject5).a(true);
        }
        localObject4 = ((AbsStructMsgElement)localObject4).a(paramContext, paramView.a, paramBundle);
        localObject5 = (TextView)((View)localObject4).findViewById(2131448814);
        if (localObject5 != null) {
          ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
        }
        if (paramView.a == null)
        {
          paramView.a = ((View)localObject4);
          paramView.f.addView((View)localObject4);
        }
        else
        {
          paramView.a.setVisibility(0);
        }
      }
      else if ("summary".equals(localObject5))
      {
        localObject4 = ((AbsStructMsgElement)localObject4).a(paramContext, paramView.b, paramBundle);
        if (paramView.b == null)
        {
          paramView.b = ((View)localObject4);
          localObject5 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject5).setMargins(0, AIOUtils.b(4.0F, localResources), 0, 0);
          paramView.f.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.b.setVisibility(0);
        }
      }
      else if ((!"picture".equals(localObject5)) && (!"video".equals(localObject5)))
      {
        if ("remark".equals(localObject5)) {
          localObject2 = ((AbsStructMsgElement)localObject4).a(paramContext, paramView.d, paramBundle);
        }
      }
      else
      {
        int i = AIOUtils.b(50.0F, localResources);
        localObject4 = ((AbsStructMsgElement)localObject4).a(paramContext, paramView.c, paramBundle);
        if (paramView.c == null)
        {
          paramView.c = ((View)localObject4);
          localObject5 = new LinearLayout.LayoutParams(i, i);
          i = AIOUtils.b(12.0F, localResources);
          int j = AIOUtils.b(10.0F, localResources);
          ((LinearLayout.LayoutParams)localObject5).setMargins(j, i, j, i);
          ((LinearLayout.LayoutParams)localObject5).gravity = 16;
          paramView.e.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.c.setVisibility(0);
        }
      }
    }
    if (paramView.b != null) {
      paramView.b.bringToFront();
    }
    if (localObject2 != null)
    {
      if (paramView.d == null)
      {
        paramView.d = ((View)localObject2);
        ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(-1, AIOUtils.b(25.0F, localResources)));
        float f = AIOUtils.b(14.0F, localResources);
        ((View)localObject2).setBackgroundDrawable(a(localResources, -1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f }));
        ((View)localObject2).setPadding(AIOUtils.b(12.0F, localResources), AIOUtils.b(5.0F, localResources), 0, 0);
        return localObject1;
      }
      paramView.d.setVisibility(0);
    }
    return localObject1;
  }
  
  protected int c()
  {
    return 7;
  }
  
  public String e()
  {
    return "Layout7";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7
 * JD-Core Version:    0.7.0.1
 */