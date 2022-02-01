package com.tencent.open.agent;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class BindGroupAdapter
  extends FacePreloadBaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<TroopInfo> jdField_a_of_type_JavaUtilList;
  
  public BindGroupAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(BindGroupAdapter.ViewHolder paramViewHolder, TroopInfo paramTroopInfo)
  {
    paramViewHolder.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    paramViewHolder.jdField_c_of_type_Int = 4;
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopInfo.getTroopDisplayName());
    if (paramTroopInfo.isThirdAppBind())
    {
      paramViewHolder.b.setVisibility(0);
      paramViewHolder.b.setText(HardCodeUtil.a(2131701203));
    }
    for (;;)
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramTroopInfo.troopuin));
      return;
      paramViewHolder.b.setVisibility(8);
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    return (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<TroopInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        notifyDataSetChanged();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new BindGroupAdapter.1(this, paramList));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560079, null);
      paramView = new BindGroupAdapter.ViewHolder();
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368996));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380812));
      paramView.b = ((TextView)localView.findViewById(2131380821));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramView, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      BindGroupAdapter.ViewHolder localViewHolder = (BindGroupAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupAdapter
 * JD-Core Version:    0.7.0.1
 */