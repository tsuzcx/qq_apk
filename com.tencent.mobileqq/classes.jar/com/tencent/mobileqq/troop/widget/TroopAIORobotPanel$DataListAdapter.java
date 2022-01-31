package com.tencent.mobileqq.troop.widget;

import ajey;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BaseDraggableGridViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopAIORobotPanel$DataListAdapter
  extends BaseDraggableGridViewAdapter
{
  public TroopAIORobotPanel$DataListAdapter(TroopAIORobotPanel paramTroopAIORobotPanel) {}
  
  public int a()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return ((TroopAIORobotPanel.RobotPanelListData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969939, paramViewGroup, false);
    paramViewGroup = new ajey(this.a, null);
    paramViewGroup.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131365658);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362943));
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131362942));
    paramLayoutInflater.setTag(paramViewGroup);
    return paramLayoutInflater;
  }
  
  public View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130969938, paramViewGroup, false);
  }
  
  public TroopAIORobotPanel.RobotPanelItemData a(int paramInt1, int paramInt2)
  {
    return (TroopAIORobotPanel.RobotPanelItemData)((TroopAIORobotPanel.RobotPanelListData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
  }
  
  public TroopAIORobotPanel.RobotPanelListData a(int paramInt)
  {
    return (TroopAIORobotPanel.RobotPanelListData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    paramView.setText(a(paramInt).jdField_a_of_type_JavaLangString);
    if (paramInt == 0) {
      paramView.setPadding(DisplayUtil.a(this.a.getContext(), 5.0F), DisplayUtil.a(this.a.getContext(), 10.0F), 0, DisplayUtil.a(this.a.getContext(), 10.0F));
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    ajey localajey = (ajey)paramView.getTag();
    paramView = a(paramInt1, paramInt2);
    Object localObject;
    if (paramView.a())
    {
      localObject = this.a.a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotPanel", 2, "troopRobotManager = null");
        }
        return;
      }
      paramView.jdField_b_of_type_Boolean = ((TroopRobotManager)localObject).a();
    }
    if (paramView.jdField_b_of_type_Boolean)
    {
      paramView = paramView.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData;
      localajey.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_JavaLangString);
      localajey.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(paramView.jdField_b_of_type_JavaLangString)) {
        break label286;
      }
      localajey.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    for (;;)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(this.a.getContext(), 50.0F));
      ((GradientDrawable)localObject).setColor(paramView.jdField_a_of_type_Int);
      ((GradientDrawable)localObject).setStroke(1, paramView.c);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setCornerRadius(DisplayUtil.a(this.a.getContext(), 50.0F));
      localGradientDrawable.setColor(paramView.jdField_a_of_type_Int);
      localGradientDrawable.setStroke(1, paramView.c);
      localGradientDrawable.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      paramView = new StateListDrawable();
      paramView.addState(new int[] { 16842919 }, localGradientDrawable);
      paramView.addState(new int[0], (Drawable)localObject);
      localajey.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramView);
      return;
      paramView = paramView.a;
      break;
      label286:
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localajey.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localajey.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.DataListAdapter
 * JD-Core Version:    0.7.0.1
 */