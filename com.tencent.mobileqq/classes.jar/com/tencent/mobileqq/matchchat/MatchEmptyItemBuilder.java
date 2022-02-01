package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class MatchEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  int a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramRecentFaceDecoder = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof MatchEmptyItemBuilder.ViewHolder))) {
        break label179;
      }
      paramRecentFaceDecoder = (MatchEmptyItemBuilder.ViewHolder)paramRecentFaceDecoder;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.a;
      if (paramInt >= 0) {
        break label382;
      }
      paramInt = (int)(this.a * 1.5F);
    }
    label81:
    label382:
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
          if (paramInt != 20) {
            break label292;
          }
          paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839549);
          if ((paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698923);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramRecentFaceDecoder = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561226, null);
        paramRecentFaceDecoder = new MatchEmptyItemBuilder.ViewHolder();
        paramRecentFaceDecoder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370057));
        paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368603));
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380726));
        paramView.setTag(paramRecentFaceDecoder);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298359) + paramOnClickListener.getDimensionPixelSize(2131298361) + paramOnClickListener.getDimensionPixelSize(2131298360));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = BitmapManager.a(paramContext.getResources(), 2130845238);
      if (paramObject != null)
      {
        paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_SQURE);
      }
      for (;;)
      {
        paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText(2131698922);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */