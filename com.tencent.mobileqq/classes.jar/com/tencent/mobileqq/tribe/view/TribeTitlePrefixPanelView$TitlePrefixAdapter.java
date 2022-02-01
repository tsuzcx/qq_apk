package com.tencent.mobileqq.tribe.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class TribeTitlePrefixPanelView$TitlePrefixAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private TribeTitlePrefixPanelView.ClickListenerImp jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$ClickListenerImp;
  private List<TribeTitlePrefixPanelView.TitlePrefixItem> jdField_a_of_type_JavaUtilList;
  private List<TribeTitlePrefixPanelView.TitlePrefixItem> b;
  
  public TribeTitlePrefixPanelView$TitlePrefixAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$ClickListenerImp = new TribeTitlePrefixPanelView.ClickListenerImp(this);
  }
  
  private void a()
  {
    this.b.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_Int != i) {
        this.b.add(this.jdField_a_of_type_JavaUtilList.get(i));
      }
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
    notifyDataSetChanged();
  }
  
  private void a(View paramView)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(ViewUtils.a(17.0F));
    localGradientDrawable.setColor(Color.parseColor("#FBFBFB"));
    localGradientDrawable.setStroke(1, Color.parseColor("#E7E7EE"));
    paramView.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$ClickListenerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$ClickListenerImp.a(paramPrefixSelectedListener);
    }
  }
  
  public void a(List<TribeTitlePrefixPanelView.TitlePrefixItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (QLog.isColorLevel()) {
      QLog.d(TribeTitlePrefixPanelView.a(), 2, new Object[] { "mPrefixList size: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.jdField_a_of_type_Int = 0;
    a();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new TribeTitlePrefixPanelView.ViewHolder(null);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560039, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131373435));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373437));
      localView.setTag(paramView);
      localObject = (TribeTitlePrefixPanelView.TitlePrefixItem)this.b.get(paramInt);
      if (localObject != null) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TribeTitlePrefixPanelView.TitlePrefixItem)localObject).a + ((TribeTitlePrefixPanelView.TitlePrefixItem)localObject).b + ((TribeTitlePrefixPanelView.TitlePrefixItem)localObject).c);
      }
      a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label198;
      }
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$ClickListenerImp);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TribeTitlePrefixPanelView.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label198:
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixAdapter
 * JD-Core Version:    0.7.0.1
 */