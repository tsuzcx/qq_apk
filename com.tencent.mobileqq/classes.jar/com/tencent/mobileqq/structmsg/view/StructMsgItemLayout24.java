package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout24
  extends AbsStructMsgItem
{
  public int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    StructMsgItemLayout24.ViewHolder localViewHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof StructMsgItemLayout24.ViewHolder)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localViewHolder = (StructMsgItemLayout24.ViewHolder)paramView.getTag();
      localViewHolder.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        if ("picture".equals(((AbsStructMsgElement)localObject2).a))
        {
          localObject2 = ((StructMsgItemCover)localObject2).a(paramContext, localViewHolder.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = AIOUtils.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = AIOUtils.a(10.0F, paramContext.getResources());
          int k = AIOUtils.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, AIOUtils.a(11.0F, paramContext.getResources()));
          localViewHolder = new StructMsgItemLayout24.ViewHolder(null);
          break;
          if ("title".equals(((AbsStructMsgElement)localObject2).a))
          {
            localObject2 = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, localViewHolder.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, AIOUtils.a(30.0F, paramContext.getResources())));
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((AbsStructMsgElement)localObject2).a))
          {
            ((StructMsgItemSummary)localObject2).b(2147483647);
            localObject2 = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, localViewHolder.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = AIOUtils.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = AIOUtils.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localViewHolder.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = AIOUtils.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localViewHolder);
      return paramView;
    }
    catch (Exception paramContext) {}
    return paramView;
  }
  
  public String b()
  {
    return "layout24";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout24
 * JD-Core Version:    0.7.0.1
 */