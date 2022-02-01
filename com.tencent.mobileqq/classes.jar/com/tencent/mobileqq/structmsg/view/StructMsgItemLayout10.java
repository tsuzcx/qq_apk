package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
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
        paramViewHolder.a.setId(2131363033);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramViewHolder.a);
      }
      if (paramViewHolder.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        int i;
        if (FontSettingManager.getFontLevel() > 16.0F) {
          i = AIOUtils.b(5.0F, paramContext);
        } else {
          i = AIOUtils.b(10.0F, paramContext);
        }
        paramBundle.setMargins(AIOUtils.b(20.0F, paramContext), 0, AIOUtils.b(20.0F, paramContext), i);
        paramBundle.addRule(12);
        ((RelativeLayout)paramView).addView(paramViewHolder.b, paramBundle);
      }
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3;
    Object localObject4;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof StructMsgItemLayout10.ViewHolder)))
    {
      localObject3 = (StructMsgItemLayout10.ViewHolder)paramView.getTag();
      localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      Object localObject1 = paramView;
      Object localObject5;
      int j;
      int i;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (AbsStructMsgElement)((Iterator)localObject4).next();
        ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localObject1;
          localObject5 = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).f();
          i = j;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {}
        }
      }
      try
      {
        i = Integer.parseInt((String)localObject5);
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (i * f > 36.0F)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append((int)(36.0F / f));
          ((StructMsgItemTitle)localObject2).c(((StringBuilder)localObject5).toString());
        }
        else
        {
          ((StructMsgItemTitle)localObject2).c((String)localObject5);
        }
        ((StructMsgItemLayout10.ViewHolder)localObject3).b = ((AbsStructMsgElement)localObject1).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject3).b, paramBundle);
        continue;
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        ((StructMsgItemLayout10.ViewHolder)localObject3).a = ((AbsStructMsgElement)localObject1).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject3).a, paramBundle);
        continue;
        paramView = paramContext.getResources();
        localObject2 = new StructMsgItemLayout10.ViewHolder();
        localObject1 = new RelativeLayout(paramContext);
        i = AIOUtils.b(15.0F, paramView);
        ((View)localObject1).setPadding(i, i, i, i);
        ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)((BaseChatItemLayout.b - AIOUtils.b(46.0F, paramView)) * 26.0F / 63.0F) + AIOUtils.b(30.0F, paramView)));
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (paramView.hasNext())
        {
          localObject3 = (AbsStructMsgElement)paramView.next();
          ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject4 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject4))
          {
            localObject4 = (StructMsgItemTitle)localObject3;
            localObject5 = ((StructMsgItemTitle)localObject4).c();
            j = ((StructMsgItemTitle)localObject4).f();
            i = j;
            if (TextUtils.isEmpty((CharSequence)localObject5)) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt((String)localObject5);
            float f = FontSettingManager.getFontLevel() / 16.0F;
            if (i * f > 36.0F)
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append((int)(36.0F / f));
              ((StructMsgItemTitle)localObject4).c(((StringBuilder)localObject5).toString());
            }
            else
            {
              ((StructMsgItemTitle)localObject4).c((String)localObject5);
            }
            ((StructMsgItemLayout10.ViewHolder)localObject2).b = ((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject2).b, paramBundle);
            continue;
            if ("paaudio".equals(localObject4)) {
              ((StructMsgItemLayout10.ViewHolder)localObject2).a = ((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject2).a, paramBundle);
            }
          }
          a(paramContext, (View)localObject1, (StructMsgItemLayout10.ViewHolder)localObject2, paramBundle);
          if (((StructMsgItemLayout10.ViewHolder)localObject2).b != null) {
            ((TextView)((StructMsgItemLayout10.ViewHolder)localObject2).b).setMaxLines(1);
          }
          ((View)localObject1).setTag(localObject2);
          return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10
 * JD-Core Version:    0.7.0.1
 */