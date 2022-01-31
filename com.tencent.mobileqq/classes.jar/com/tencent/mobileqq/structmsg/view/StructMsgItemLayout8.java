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
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;

public class StructMsgItemLayout8
  extends AbsStructMsgItem
{
  private StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int k = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    paramInt = k;
    k = 0;
    if (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int m = paramInt - (k << 5);
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - (k << 5);
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - (k << 5);
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        k += 1;
        break;
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.a(4.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  @TargetApi(16)
  public void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.f == 0) {
        super.a(paramView);
      }
    }
    else {
      return;
    }
    int i = AIOUtils.a(4.0F, paramView.getResources());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (a())
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = a(paramView.getResources(), this.f, (float[])localObject1);
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
      paramView.setBackgroundDrawable((Drawable)localObject1);
      return;
      localObject1 = new float[8];
      continue;
      localObject1 = new float[8];
      localObject1[0] = i;
      localObject1[1] = i;
      localObject1[2] = i;
      localObject1[3] = i;
      localObject1[4] = 0.0F;
      localObject1[5] = 0.0F;
      localObject1[6] = 0.0F;
      localObject1[7] = 0.0F;
      continue;
      localObject1 = new float[8];
      localObject1[0] = 0.0F;
      localObject1[1] = 0.0F;
      localObject1[2] = 0.0F;
      localObject1[3] = 0.0F;
      localObject1[4] = i;
      localObject1[5] = i;
      localObject1[6] = i;
      localObject1[7] = i;
    }
    paramView.setBackground((Drawable)localObject1);
  }
  
  protected int b()
  {
    return 8;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    RelativeLayout localRelativeLayout;
    int i;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      paramView = localRelativeLayout;
      if (j == localRelativeLayout.getChildCount())
      {
        i = 0;
        paramView = localRelativeLayout;
        if (i < j)
        {
          if (i <= 2) {
            break label175;
          }
          paramView = localRelativeLayout;
        }
      }
      label67:
      paramContext = paramView.findViewById(2);
      if (paramContext != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
        paramBundle.addRule(0, 3);
        paramBundle.rightMargin = AIOUtils.a(7.5F, localResources);
        if (paramView.findViewById(1) == null) {
          break label873;
        }
        paramBundle.addRule(1, 1);
        paramContext.setPadding(AIOUtils.a(7.5F, localResources), 0, 0, 0);
        label130:
        paramContext.setLayoutParams(paramBundle);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        break label891;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      a(paramView);
      paramView.setPadding(AIOUtils.a(11.0F, localResources), 0, AIOUtils.a(11.0F, localResources), 0);
      return paramView;
      label175:
      paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      Object localObject = paramView.jdField_a_of_type_JavaLangString;
      if ("picture".equals(localObject))
      {
        paramView = (ImageView)paramView.a(paramContext, localRelativeLayout.findViewById(1), paramBundle);
        localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      label353:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!"title".equals(localObject)) {
            break label353;
          }
          ((StructMsgItemTitle)paramView).c("30");
          ((StructMsgItemTitle)paramView).a(true);
          ((StructMsgItemTitle)paramView).a(a(), this.f);
          paramView = paramView.a(paramContext, localRelativeLayout.findViewById(2), paramBundle);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (!"summary".equals(localObject));
      ((StructMsgItemSummary)paramView).c("28");
      ((StructMsgItemSummary)paramView).a(true);
      if (this.f != 0) {
        ((StructMsgItemSummary)paramView).a(a(), this.f);
      }
      for (;;)
      {
        paramView = paramView.a(paramContext, localRelativeLayout.findViewById(3), paramBundle);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break;
        ((StructMsgItemSummary)paramView).b("black");
      }
      localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.a(40.0F, localResources)));
      i = 0;
      paramView = localRelativeLayout;
      if (i >= j) {
        break label67;
      }
      paramView = localRelativeLayout;
      if (i > 2) {
        break label67;
      }
      paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject = paramView.jdField_a_of_type_JavaLangString;
      if ("picture".equals(localObject))
      {
        paramView = (ImageView)paramView.a(paramContext, null, paramBundle);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setId(1);
        localObject = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, localResources), AIOUtils.a(30.0F, localResources));
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
      label720:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!"title".equals(localObject)) {
            break label720;
          }
          ((StructMsgItemTitle)paramView).c("30");
          ((StructMsgItemTitle)paramView).a(true);
          ((StructMsgItemTitle)paramView).a(a(), this.f);
          paramView = paramView.a(paramContext, null, paramBundle);
          paramView.setId(2);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
      } while (!"summary".equals(localObject));
      ((StructMsgItemSummary)paramView).c("28");
      ((StructMsgItemSummary)paramView).a(true);
      if (this.f != 0) {
        ((StructMsgItemSummary)paramView).a(a(), this.f);
      }
      for (;;)
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        int k = localResources.getDisplayMetrics().widthPixels;
        int m = AIOUtils.a(89.5F, localResources);
        ((TextView)paramView).setMaxWidth(k - m);
        ((TextView)paramView).setSingleLine(true);
        paramView.setId(3);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        break;
        ((StructMsgItemSummary)paramView).b("black");
      }
      label873:
      paramBundle.addRule(9, -1);
      paramContext.setPadding(0, 0, 0, 0);
      break label130;
      label891:
      paramView.setBackground(null);
    }
  }
  
  public String b()
  {
    return "Layout8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8
 * JD-Core Version:    0.7.0.1
 */