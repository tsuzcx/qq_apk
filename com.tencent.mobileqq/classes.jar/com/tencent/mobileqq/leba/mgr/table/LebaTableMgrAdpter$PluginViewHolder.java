package com.tencent.mobileqq.leba.mgr.table;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class LebaTableMgrAdpter$PluginViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public LebaTableMgrAdpter$PluginViewHolder(View paramView, Context paramContext, GridLayoutManager paramGridLayoutManager, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369387));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369269));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376656));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165764));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165766));
      paramBoolean = true;
    }
    else
    {
      paramBoolean = false;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165763));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165765));
    }
    if ((paramGridLayoutManager != null) && (paramGridLayoutManager.getWidth() > 0))
    {
      paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = (paramGridLayoutManager.getWidth() / 3);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("plugin height =");
        paramContext.append(paramView.height);
        paramContext.append(",isNight");
        paramContext.append(paramBoolean);
        QLog.i("LebaTableMgrAdpter", 2, paramContext.toString());
      }
    }
    else
    {
      QLog.i("LebaTableMgrAdpter", 1, "plugin getWidth error ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrAdpter.PluginViewHolder
 * JD-Core Version:    0.7.0.1
 */