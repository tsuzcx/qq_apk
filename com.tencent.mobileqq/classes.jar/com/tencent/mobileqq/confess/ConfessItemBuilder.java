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
    if (paramView == null)
    {
      paramRecentFaceDecoder = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof ConfessItemBuilder.ViewHolder))) {
        break label179;
      }
      paramRecentFaceDecoder = (ConfessItemBuilder.ViewHolder)paramRecentFaceDecoder;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.a;
      if (paramInt >= 0) {
        break label348;
      }
      paramInt = (int)(this.a * 1.5F);
    }
    label81:
    label348:
    for (;;)
    {
      if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams))
      {
        paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
        paramViewGroup.width = -1;
        paramViewGroup.height = paramInt;
        paramView.setLayoutParams(paramViewGroup);
        if ((paramObject instanceof Integer))
        {
          paramInt = ((Integer)paramObject).intValue();
          if (paramInt != 16) {
            break label294;
          }
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839549);
          if ((paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698639);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramRecentFaceDecoder = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561157, null);
        paramRecentFaceDecoder = new ConfessItemBuilder.ViewHolder();
        paramRecentFaceDecoder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370057));
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380726));
        paramView.setTag(paramRecentFaceDecoder);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298220) + paramOnClickListener.getDimensionPixelSize(2131298222) + paramOnClickListener.getDimensionPixelSize(2131298221) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698638);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */