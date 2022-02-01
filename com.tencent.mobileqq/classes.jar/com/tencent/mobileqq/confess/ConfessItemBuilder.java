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
      paramView = LayoutInflater.from(paramContext).inflate(2131561020, null);
      paramRecentFaceDecoder = new ConfessItemBuilder.ViewHolder();
      paramRecentFaceDecoder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369736));
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379994));
      paramView.setTag(paramRecentFaceDecoder);
      this.a = (paramOnClickListener.getDimensionPixelSize(2131298215) + paramOnClickListener.getDimensionPixelSize(2131298217) + paramOnClickListener.getDimensionPixelSize(2131298216) * 2);
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
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839406);
        if ((paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
        }
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698705);
        return paramView;
      }
      if (paramInt == 17)
      {
        if ((paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
        }
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698704);
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */