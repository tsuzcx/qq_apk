package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout10
  extends AbsStructMsgItem
{
  private void a(Context paramContext, View paramView, StructMsgItemLayout10.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (paramViewHolder.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramViewHolder.a.setId(2131366605);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramViewHolder.a);
      }
      if (paramViewHolder.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (FontSettingManager.a() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = AIOUtils.a(5.0F, paramContext);; i = AIOUtils.a(10.0F, paramContext))
    {
      paramBundle.setMargins(AIOUtils.a(20.0F, paramContext), 0, AIOUtils.a(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(paramViewHolder.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    StructMsgItemLayout10.ViewHolder localViewHolder;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof StructMsgItemLayout10.ViewHolder)))
    {
      localViewHolder = (StructMsgItemLayout10.ViewHolder)paramView.getTag();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      AbsStructMsgElement localAbsStructMsgElement;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject1).next();
        localAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localAbsStructMsgElement;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).e();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = FontSettingManager.a() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
        }
        for (;;)
        {
          localViewHolder.b = localAbsStructMsgElement.a(paramContext, localViewHolder.b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).c(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        localViewHolder.a = localAbsStructMsgElement.a(paramContext, localViewHolder.a, paramBundle);
        continue;
        paramContext = localViewHolder;
        if (paramContext.b != null) {
          ((TextView)paramContext.b).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        localViewHolder = new StructMsgItemLayout10.ViewHolder();
        paramView = new RelativeLayout(paramContext);
        i = AIOUtils.a(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.a - AIOUtils.a(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.a(30.0F, (Resources)localObject1) + i));
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject1).next();
          localAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localAbsStructMsgElement;
            str = ((StructMsgItemTitle)localObject2).c();
            j = ((StructMsgItemTitle)localObject2).e();
            i = j;
            if (TextUtils.isEmpty(str)) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(str);
            float f = FontSettingManager.a() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
            }
            for (;;)
            {
              localViewHolder.b = localAbsStructMsgElement.a(paramContext, localViewHolder.b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).c(str);
            }
            if ("paaudio".equals(localObject2))
            {
              localViewHolder.a = localAbsStructMsgElement.a(paramContext, localViewHolder.a, paramBundle);
              continue;
              a(paramContext, paramView, localViewHolder, paramBundle);
              paramContext = localViewHolder;
            }
          }
          localException1 = localException1;
          i = j;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout10";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10
 * JD-Core Version:    0.7.0.1
 */