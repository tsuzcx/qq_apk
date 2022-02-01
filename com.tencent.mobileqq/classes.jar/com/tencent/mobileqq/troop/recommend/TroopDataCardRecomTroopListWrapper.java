package com.tencent.mobileqq.troop.recommend;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopDataCardRecomTroopListWrapper
  extends RecommendTroopListWrapper
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  ArrayList<RecommendTroopItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  TextView b;
  
  public TroopDataCardRecomTroopListWrapper(AppInterface paramAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback, String paramString, boolean paramBoolean, TextView paramTextView, View paramView)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper$RecommendTroopListWrapperCallback = paramRecommendTroopListWrapperCallback;
    this.e = false;
    this.c = paramBoolean;
    this.b = paramTextView;
    this.jdField_a_of_type_AndroidViewView = paramView;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramAppInterface)
    {
      QLog.d("TroopDataCardRecomTroopListWrapper", 1, "TroopDataCardRecomTroopListWrapper NumberFormatException ", paramAppInterface);
    }
    a();
  }
  
  protected RecommendTroopAdapter a()
  {
    return new TroopDataCardRecomTroopAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, true);
  }
  
  protected void a()
  {
    super.a();
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.b);
      this.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopDataCardRecommendTroopList isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",troopUIN = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",serverPageID = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",dataListSize = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",newDataListSize = ");
      localStringBuilder.append(j);
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if ((paramBoolean1) && (this.jdField_a_of_type_Long == paramLong))
    {
      if (j + i >= 50)
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, 50 - i));
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetTroopDataCardRecommendTroopList reach limit,this.dataList.size() = ");
          paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList.size());
          QLog.d("TroopDataCardRecomTroopListWrapper", 2, paramArrayList.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
      b();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
        }
      }
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    if (!this.c) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListView,this.dataList.size() = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void b(boolean paramBoolean)
  {
    ((ITroopRecommendHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRecommendHandlerName())).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 25);
  }
  
  public void f()
  {
    if (this.c)
    {
      this.c = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopListWrapper
 * JD-Core Version:    0.7.0.1
 */