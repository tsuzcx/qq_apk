package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class ConfessItemBuilder
  extends RecentItemBaseBuilder
{
  int a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null) {
      paramRecentFaceDecoder = null;
    } else {
      paramRecentFaceDecoder = paramView.getTag();
    }
    if ((paramView != null) && ((paramView.getTag() instanceof ConfessItemBuilder.ViewHolder)))
    {
      paramRecentFaceDecoder = (ConfessItemBuilder.ViewHolder)paramRecentFaceDecoder;
    }
    else
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131627361, null);
      paramRecentFaceDecoder = new ConfessItemBuilder.ViewHolder();
      paramRecentFaceDecoder.a = ((ViewGroup)paramView.findViewById(2131436854));
      paramRecentFaceDecoder.b = ((ImageView)paramView.findViewById(2131435219));
      paramRecentFaceDecoder.c = ((TextView)paramView.findViewById(2131448897));
      paramView.setTag(paramRecentFaceDecoder);
      this.a = (paramOnClickListener.getDimensionPixelSize(2131298914) + paramOnClickListener.getDimensionPixelSize(2131298916) + paramOnClickListener.getDimensionPixelSize(2131298915) * 2);
    }
    paramInt = paramViewGroup.getMeasuredHeight();
    int j = this.a;
    int i = paramInt - j;
    paramInt = i;
    if (i < 0) {
      paramInt = (int)(j * 1.5F);
    }
    if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
      paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
    } else {
      paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
    }
    paramViewGroup.width = -1;
    paramViewGroup.height = paramInt;
    paramView.setLayoutParams(paramViewGroup);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if (paramInt == 16)
      {
        paramRecentFaceDecoder.b.setImageResource(2130839590);
        if ((paramRecentFaceDecoder.b.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.b.getDrawable()).start();
        }
        paramRecentFaceDecoder.c.setText(2131896663);
        return paramView;
      }
      if (paramInt == 17)
      {
        if ((paramRecentFaceDecoder.b.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.b.getDrawable()).stop();
        }
        paramRecentFaceDecoder.b.setImageDrawable(null);
        paramRecentFaceDecoder.c.setText(2131896662);
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */