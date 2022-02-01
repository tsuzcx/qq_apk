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
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.b(4.0F, paramResources));
      }
      k += 1;
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
      if (this.p == 0)
      {
        super.a(paramView);
        return;
      }
      int i = AIOUtils.b(4.0F, paramView.getResources());
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
      localObject = a(paramView.getResources(), this.p, (float[])localObject);
      if (Build.VERSION.SDK_INT < 16)
      {
        paramView.setBackgroundDrawable((Drawable)localObject);
        return;
      }
      paramView.setBackground((Drawable)localObject);
    }
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
    Object localObject;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      paramView = localRelativeLayout;
      if (j == localRelativeLayout.getChildCount())
      {
        i = 0;
        for (;;)
        {
          paramView = localRelativeLayout;
          if (i >= j) {
            break;
          }
          if (i > 2)
          {
            paramView = localRelativeLayout;
            break;
          }
          paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject = paramView.jdField_a_of_type_JavaLangString;
          if ("picture".equals(localObject))
          {
            paramView = (ImageView)paramView.a(paramContext, localRelativeLayout.findViewById(1), paramBundle);
            localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          else if ("title".equals(localObject))
          {
            localObject = (StructMsgItemTitle)paramView;
            ((StructMsgItemTitle)localObject).c("30");
            ((StructMsgItemTitle)localObject).a(true);
            ((StructMsgItemTitle)localObject).a(a(), this.p);
            paramView = paramView.a(paramContext, localRelativeLayout.findViewById(2), paramBundle);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          else if ("summary".equals(localObject))
          {
            localObject = (StructMsgItemSummary)paramView;
            ((StructMsgItemSummary)localObject).c("28");
            ((StructMsgItemSummary)localObject).a(true);
            if (this.p != 0) {
              ((StructMsgItemSummary)localObject).a(a(), this.p);
            } else {
              ((StructMsgItemSummary)localObject).b("black");
            }
            paramView = paramView.a(paramContext, localRelativeLayout.findViewById(3), paramBundle);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          i += 1;
        }
      }
    }
    else
    {
      localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(40.0F, localResources)));
      i = 0;
      for (;;)
      {
        paramView = localRelativeLayout;
        if (i >= j) {
          break;
        }
        if (i > 2)
        {
          paramView = localRelativeLayout;
          break;
        }
        paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject = paramView.jdField_a_of_type_JavaLangString;
        if ("picture".equals(localObject))
        {
          paramView = (ImageView)paramView.a(paramContext, null, paramBundle);
          paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView.setId(1);
          localObject = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, localResources), AIOUtils.b(30.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          break;
          if ("title".equals(localObject))
          {
            localObject = (StructMsgItemTitle)paramView;
            ((StructMsgItemTitle)localObject).c("30");
            ((StructMsgItemTitle)localObject).a(true);
            ((StructMsgItemTitle)localObject).a(a(), this.p);
            paramView = paramView.a(paramContext, null, paramBundle);
            paramView.setId(2);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
          }
          else if ("summary".equals(localObject))
          {
            localObject = (StructMsgItemSummary)paramView;
            ((StructMsgItemSummary)localObject).c("28");
            ((StructMsgItemSummary)localObject).a(true);
            if (this.p != 0) {
              ((StructMsgItemSummary)localObject).a(a(), this.p);
            } else {
              ((StructMsgItemSummary)localObject).b("black");
            }
            paramView = paramView.a(paramContext, null, paramBundle);
            int k = localResources.getDisplayMetrics().widthPixels;
            int m = AIOUtils.b(89.5F, localResources);
            localObject = (TextView)paramView;
            ((TextView)localObject).setMaxWidth(k - m);
            ((TextView)localObject).setSingleLine(true);
            paramView.setId(3);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
          }
        }
        i += 1;
      }
    }
    paramContext = paramView.findViewById(2);
    if (paramContext != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
      paramBundle.addRule(0, 3);
      paramBundle.rightMargin = AIOUtils.b(7.5F, localResources);
      if (paramView.findViewById(1) != null)
      {
        paramBundle.addRule(1, 1);
        paramContext.setPadding(AIOUtils.b(7.5F, localResources), 0, 0, 0);
      }
      else
      {
        paramBundle.addRule(9, -1);
        paramContext.setPadding(0, 0, 0, 0);
      }
      paramContext.setLayoutParams(paramBundle);
    }
    if (Build.VERSION.SDK_INT < 16) {
      paramView.setBackgroundDrawable(null);
    } else {
      paramView.setBackground(null);
    }
    a(paramView);
    paramView.setPadding(AIOUtils.b(11.0F, localResources), 0, AIOUtils.b(11.0F, localResources), 0);
    return paramView;
  }
  
  public String b()
  {
    return "Layout8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8
 * JD-Core Version:    0.7.0.1
 */