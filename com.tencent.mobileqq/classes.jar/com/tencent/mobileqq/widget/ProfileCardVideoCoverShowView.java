package com.tencent.mobileqq.widget;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import benc;
import beou;
import beov;
import beow;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ProfileCardVideoCoverShowView
  extends FrameLayout
  implements AdapterView.OnItemClickListener, benc
{
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new beou(this);
  private beov jdField_a_of_type_Beov;
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private ArrayList<beow> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131561147, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = ((OverScrollCallbackHorizontalListView)findViewById(2131369541));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(aekt.a(2.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
  }
  
  public void a(OverScrollCallbackHorizontalListView paramOverScrollCallbackHorizontalListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMicroVideoContentView", 2, "onOverScrollRight");
    }
    if (this.jdField_a_of_type_Beov != null) {
      this.jdField_a_of_type_Beov.a(this);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMicroVideoContentView", 2, "onItemClick " + paramInt);
    }
    if (this.jdField_a_of_type_Beov != null) {
      this.jdField_a_of_type_Beov.a(this, paramView, (beow)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
  
  public void setCallback(beov parambeov)
  {
    this.jdField_a_of_type_Beov = parambeov;
  }
  
  public void setData(List<beow> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("setData list=");
      if (paramList == null)
      {
        localObject = "null";
        QLog.i("ProfileCardMicroVideoContentView", 2, localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      }
      if ((paramList != null) && (paramList.size() != 0)) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
      label116:
      int i = getResources().getDisplayMetrics().widthPixels;
      int j = aekt.a(114.0F, getResources());
      if (paramList.size() > i * 1.0F / j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView
 * JD-Core Version:    0.7.0.1
 */