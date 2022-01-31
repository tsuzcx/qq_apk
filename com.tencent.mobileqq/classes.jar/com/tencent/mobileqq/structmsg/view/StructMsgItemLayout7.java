package com.tencent.mobileqq.structmsg.view;

import ahvf;
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
  private static final int i = Color.rgb(255, 221, 227);
  
  private StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int m = Color.red(paramInt);
    int j = Color.green(paramInt);
    int k = Color.blue(paramInt);
    paramInt = m;
    m = 0;
    if (m < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[m] = new GradientDrawable();
      arrayOfGradientDrawable[m].setShape(0);
      int n = paramInt - (m << 5);
      paramInt = n;
      if (n < 0) {
        paramInt = 0;
      }
      n = j - (m << 5);
      j = n;
      if (n < 0) {
        j = 0;
      }
      n = k - (m << 5);
      k = n;
      if (n < 0) {
        k = 0;
      }
      arrayOfGradientDrawable[m].setColor(Color.rgb(paramInt, j, k));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[m].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        m += 1;
        break;
        arrayOfGradientDrawable[m].setCornerRadius(AIOUtils.a(14.0F, paramResources));
      }
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
    int j;
    Object localObject1;
    if (paramView != null)
    {
      j = AIOUtils.a(14.0F, paramView.getResources());
      Object localObject2 = null;
      localObject1 = localObject2;
      switch (a())
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject1 = a(paramView.getResources(), i, (float[])localObject1);
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
      paramView.setBackgroundDrawable((Drawable)localObject1);
      return;
      localObject1 = new float[8];
      continue;
      localObject1 = new float[8];
      localObject1[0] = j;
      localObject1[1] = j;
      localObject1[2] = j;
      localObject1[3] = j;
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
      localObject1[4] = j;
      localObject1[5] = j;
      localObject1[6] = j;
      localObject1[7] = j;
    }
    paramView.setBackground((Drawable)localObject1);
  }
  
  protected int b()
  {
    return 7;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    ahvf localahvf;
    label148:
    Object localObject1;
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == 2) && ((((LinearLayout)paramView).getChildAt(0).getTag() instanceof ahvf)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localahvf = (ahvf)localLinearLayout.getChildAt(0).getTag();
      if (localahvf.jdField_a_of_type_AndroidViewView != null) {
        localahvf.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (localahvf.jdField_b_of_type_AndroidViewView != null) {
        localahvf.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (localahvf.c != null) {
        localahvf.c.setVisibility(8);
      }
      if (localahvf.d != null) {
        localahvf.d.setVisibility(8);
      }
      paramView = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (!localIterator.hasNext()) {
        break label707;
      }
      localObject1 = (AbsStructMsgElement)localIterator.next();
      ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject2 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label447;
      }
      if ((localObject1 instanceof StructMsgItemTitle))
      {
        ((StructMsgItemTitle)localObject1).a(a(), 0);
        ((StructMsgItemTitle)localObject1).a(true);
      }
      localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, localahvf.jdField_a_of_type_AndroidViewView, paramBundle);
      localObject2 = (TextView)((View)localObject1).findViewById(2131361926);
      if (localObject2 != null) {
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      }
      if (localahvf.jdField_a_of_type_AndroidViewView != null) {
        break label435;
      }
      localahvf.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localahvf.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
    }
    for (;;)
    {
      break label148;
      localahvf = new ahvf();
      localahvf.jdField_b_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      ((LinearLayout)localahvf.jdField_b_of_type_AndroidViewViewGroup).setOrientation(1);
      paramView = new LinearLayout.LayoutParams(0, -2);
      paramView.weight = 1.0F;
      paramView.gravity = 16;
      paramView.setMargins(AIOUtils.a(15.0F, localResources), 0, 0, 0);
      localahvf.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      localahvf.jdField_a_of_type_AndroidViewViewGroup.setTag(localahvf);
      localahvf.jdField_a_of_type_AndroidViewViewGroup.addView(localahvf.jdField_b_of_type_AndroidViewViewGroup, paramView);
      localLinearLayout = a(paramContext);
      localLinearLayout.addView(localahvf.jdField_a_of_type_AndroidViewViewGroup, new LinearLayout.LayoutParams(-1, AIOUtils.a(75.0F, localResources)));
      break;
      label435:
      localahvf.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      label447:
      if ("summary".equals(localObject2))
      {
        localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, localahvf.jdField_b_of_type_AndroidViewView, paramBundle);
        if (localahvf.jdField_b_of_type_AndroidViewView == null)
        {
          localahvf.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.a(4.0F, localResources), 0, 0);
          localahvf.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localahvf.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if (("picture".equals(localObject2)) || ("video".equals(localObject2)))
      {
        int j = AIOUtils.a(50.0F, localResources);
        localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, localahvf.c, paramBundle);
        if (localahvf.c == null)
        {
          localahvf.c = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(j, j);
          j = AIOUtils.a(12.0F, localResources);
          int k = AIOUtils.a(10.0F, localResources);
          ((LinearLayout.LayoutParams)localObject2).setMargins(k, j, k, j);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          localahvf.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localahvf.c.setVisibility(0);
        }
      }
      if ("remark".equals(localObject2))
      {
        paramView = ((AbsStructMsgElement)localObject1).a(paramContext, localahvf.d, paramBundle);
        continue;
        label707:
        if (localahvf.jdField_b_of_type_AndroidViewView != null) {
          localahvf.jdField_b_of_type_AndroidViewView.bringToFront();
        }
        if (paramView != null)
        {
          if (localahvf.d == null)
          {
            localahvf.d = paramView;
            localLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, AIOUtils.a(25.0F, localResources)));
            float f = AIOUtils.a(14.0F, localResources);
            paramView.setBackgroundDrawable(a(localResources, -1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f }));
            paramView.setPadding(AIOUtils.a(12.0F, localResources), AIOUtils.a(5.0F, localResources), 0, 0);
          }
        }
        else {
          return localLinearLayout;
        }
        localahvf.d.setVisibility(0);
        return localLinearLayout;
      }
    }
  }
  
  public String b()
  {
    return "Layout7";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7
 * JD-Core Version:    0.7.0.1
 */