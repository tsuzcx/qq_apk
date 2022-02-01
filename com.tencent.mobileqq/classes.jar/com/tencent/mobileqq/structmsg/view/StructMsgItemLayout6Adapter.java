package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout6Adapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsStructMsgItem jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem;
  private int b;
  
  public StructMsgItemLayout6Adapter(AbsStructMsgItem paramAbsStructMsgItem, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem = paramAbsStructMsgItem;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296444);
  }
  
  private TextView a(StructMsgItemSummary paramStructMsgItemSummary, View paramView)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 0, 0, 0);
      localTextView.setLayoutParams(paramView);
      localTextView.setMaxLines(3);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setLineSpacing(AIOUtils.b(2.5F, localResources), 1.0F);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      int i = AIOUtils.b(15.0F, localResources);
      int j = AIOUtils.b(12.0F, localResources);
      localTextView.setPadding(j, AIOUtils.b(18.0F, localResources), j, i);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramStructMsgItemSummary.b()))
      {
        localTextView.setText(paramStructMsgItemSummary.b().trim());
        return localTextView;
      }
    }
    else
    {
      localTextView = (TextView)paramView;
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramStructMsgItemSummary.b()))
      {
        localTextView.setText(paramStructMsgItemSummary.b().trim());
        paramView = localTextView;
      }
    }
    return paramView;
  }
  
  private TextView a(String paramString, View paramView, boolean paramBoolean)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setMaxLines(2);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 19.0F);
      localTextView.setMaxLines(2);
      localTextView.setLineSpacing(AIOUtils.b(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setIncludeFontPadding(false);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130841704);
      }
      int i = AIOUtils.b(8.0F, localResources);
      int j = AIOUtils.b(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131378087);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView.setText(paramString);
        return localTextView;
      }
    }
    else
    {
      localTextView = (TextView)paramView;
      if (!TextUtils.isEmpty(paramString)) {
        localTextView.setText(paramString);
      }
      paramView = localTextView;
      if (paramBoolean)
      {
        paramView = localTextView;
        if (localTextView.getBackground() == null)
        {
          localTextView.setBackgroundResource(2130841704);
          paramView = localTextView;
        }
      }
    }
    return paramView;
  }
  
  public static boolean a(AbsStructMsgItem paramAbsStructMsgItem, int paramInt)
  {
    Object localObject;
    if (BaseApplicationImpl.sApplication != null) {
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!TextUtils.isEmpty(paramAbsStructMsgItem.ab)))
    {
      if ((!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript((AppInterface)localObject, paramAbsStructMsgItem.ab)) && (!"2909288299".equals(paramAbsStructMsgItem.ab)) && (!"3338705755".equals(paramAbsStructMsgItem.ab))) {
        return false;
      }
      if (paramInt != 0) {
        return false;
      }
      paramInt = 0;
      int j = 0;
      int i = 0;
      while (paramInt < paramAbsStructMsgItem.a.size())
      {
        localObject = ((AbsStructMsgElement)paramAbsStructMsgItem.a.get(paramInt)).a;
        int k;
        int m;
        if ("picture".equals(localObject))
        {
          k = j + 1;
          m = i;
        }
        else if ("summary".equals(localObject))
        {
          k = j;
          m = i;
          if (j != 0)
          {
            m = i + 1;
            k = j;
          }
        }
        else
        {
          if (!"title".equals(localObject)) {
            break label206;
          }
          m = i;
          k = j;
        }
        paramInt += 1;
        j = k;
        i = m;
        continue;
        label206:
        return false;
      }
      return (j == 1) && (i <= 1);
    }
    return false;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramContext.getResources();
    if (!a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem, this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a(paramContext, paramView, paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout6Adapter", 2, "layout6 use new style!");
    }
    Object localObject3;
    Object localObject2;
    int k;
    Object localObject4;
    String str;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject1 = (LinearLayout)paramView;
      localObject3 = (FrameLayout)((LinearLayout)localObject1).findViewById(2131378069);
      if (localObject3 != null)
      {
        localObject2 = new ArrayList();
        paramContext = null;
        paramView = paramContext;
        k = 0;
        int m = 0;
        i = 0;
        while (k < this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a.size())
        {
          localObject4 = (AbsStructMsgElement)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a.get(k);
          str = ((AbsStructMsgElement)localObject4).a;
          if ("title".equals(str))
          {
            paramContext = ((StructMsgItemTitle)localObject4).b();
          }
          else if ("picture".equals(str))
          {
            paramView = a((AbsStructMsgElement)localObject4, (View)localObject3, paramBundle);
            m = 1;
          }
          else
          {
            j = i;
            if ("summary".equals(str))
            {
              localObject4 = (StructMsgItemSummary)localObject4;
              j = i;
              if (m != 0)
              {
                j = i;
                if (!TextUtils.isEmpty(((StructMsgItemSummary)localObject4).b())) {
                  if (((StructMsgItemSummary)localObject4).b().trim().length() <= 0)
                  {
                    j = i;
                  }
                  else
                  {
                    ((ArrayList)localObject2).add(a((StructMsgItemSummary)localObject4, ((LinearLayout)localObject1).findViewById(i + 2131378086)));
                    j = i + 1;
                  }
                }
              }
            }
            i = j;
          }
          k += 1;
        }
        ((LinearLayout)localObject1).removeAllViews();
        if (paramView != null)
        {
          paramBundle = (TextView)paramView.findViewById(2131378084);
          if (!TextUtils.isEmpty(paramContext))
          {
            if (paramBundle == null)
            {
              paramContext = a(paramContext, null, true);
              paramContext.setId(2131378084);
              paramBundle = new ViewGroup.LayoutParams(-1, this.b);
              ((ViewGroup)paramView).addView(paramContext, paramBundle);
            }
            else
            {
              a(paramContext, paramBundle, true);
            }
          }
          else if (paramBundle != null) {
            ((ViewGroup)paramView).removeView(paramBundle);
          }
          ((LinearLayout)localObject1).addView(paramView);
        }
        else if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = a(paramContext.trim(), null, false);
          paramView = new ViewGroup.LayoutParams(-1, -2);
          paramContext.setGravity(16);
          ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          paramContext = ((ArrayList)localObject2).iterator();
          while (paramContext.hasNext()) {
            ((LinearLayout)localObject1).addView((View)paramContext.next());
          }
        }
        return localObject1;
      }
      ((LinearLayout)localObject1).removeAllViews();
      paramView = (View)localObject1;
    }
    else
    {
      paramView = null;
    }
    Object localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = new LinearLayout(paramContext);
      ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject1).setOrientation(1);
    }
    paramContext = null;
    paramView = paramContext;
    int i = 0;
    for (int j = 0; i < this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a.size(); j = k)
    {
      localObject4 = (AbsStructMsgElement)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a.get(i);
      str = ((AbsStructMsgElement)localObject4).a;
      if ("title".equals(str))
      {
        localObject3 = ((StructMsgItemTitle)localObject4).b();
        localObject2 = paramContext;
        k = j;
      }
      else if ("picture".equals(str))
      {
        localObject2 = a((AbsStructMsgElement)localObject4, null, paramBundle);
        ((LinearLayout)localObject1).addView((View)localObject2);
        k = 1;
        localObject3 = paramView;
      }
      else
      {
        localObject2 = paramContext;
        localObject3 = paramView;
        k = j;
        if ("summary".equals(str))
        {
          localObject4 = (StructMsgItemSummary)localObject4;
          localObject2 = paramContext;
          localObject3 = paramView;
          k = j;
          if (j != 0)
          {
            localObject2 = paramContext;
            localObject3 = paramView;
            k = j;
            if (!TextUtils.isEmpty(((StructMsgItemSummary)localObject4).b())) {
              if (((StructMsgItemSummary)localObject4).b().trim().length() <= 0)
              {
                localObject2 = paramContext;
                localObject3 = paramView;
                k = j;
              }
              else
              {
                localObject2 = a((StructMsgItemSummary)localObject4, null);
                ((TextView)localObject2).setId(i + 2131378086);
                ((LinearLayout)localObject1).addView((View)localObject2);
                k = j;
                localObject3 = paramView;
                localObject2 = paramContext;
              }
            }
          }
        }
      }
      i += 1;
      paramContext = (Context)localObject2;
      paramView = (View)localObject3;
    }
    if ((paramContext != null) && (!TextUtils.isEmpty(paramView)))
    {
      paramBundle = new ViewGroup.LayoutParams(-1, this.b);
      paramView = a(paramView.trim(), null, true);
      paramView.setId(2131378084);
      ((ViewGroup)paramContext).addView(paramView, paramBundle);
      return localObject1;
    }
    if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
    {
      paramContext = a(paramView.trim(), null, false);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramContext.setGravity(16);
      ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
    }
    return localObject1;
  }
  
  public View a(AbsStructMsgElement paramAbsStructMsgElement, View paramView, Bundle paramBundle)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      paramView = (FrameLayout)paramView;
      paramAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, paramView.findViewById(2131368633), paramBundle);
      return paramView;
    }
    paramView = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramView.setId(2131378069);
    if (paramBundle != null) {
      paramBundle.putBoolean("pa_should_change", true);
    }
    paramAbsStructMsgElement = (ImageView)paramAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, null, paramBundle).findViewById(2131368633);
    paramBundle = new FrameLayout.LayoutParams(-1, this.b);
    if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof PAImageView))) {
      ((PAImageView)paramAbsStructMsgElement).setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296443));
    }
    paramView.addView(paramAbsStructMsgElement, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6Adapter
 * JD-Core Version:    0.7.0.1
 */