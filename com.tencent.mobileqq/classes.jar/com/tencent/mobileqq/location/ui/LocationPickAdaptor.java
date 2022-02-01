package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class LocationPickAdaptor
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LocationPickAdaptor.OnDataLoadStateChangeListener jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor$OnDataLoadStateChangeListener;
  private LocationPoiDataFromMapHelper jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper;
  private List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = -1;
  
  LocationPickAdaptor(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  LocationRoom.Venue a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i < 0) {
      return null;
    }
    return a(i);
  }
  
  public LocationRoom.Venue a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper.a())
    {
      LocationPickAdaptor.OnDataLoadStateChangeListener localOnDataLoadStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor$OnDataLoadStateChangeListener;
      if (localOnDataLoadStateChangeListener != null) {
        localOnDataLoadStateChangeListener.a(1);
      }
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.b > 0)
    {
      LocationRoom.Venue localVenue = (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.remove(0);
      this.jdField_a_of_type_JavaUtilList.add(this.b, localVenue);
    }
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    this.jdField_a_of_type_JavaUtilList.add(0, localObject);
    this.b = paramInt;
    this.jdField_a_of_type_Int = 0;
    notifyDataSetChanged();
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor$OnDataLoadStateChangeListener;
    if (localObject != null) {
      ((LocationPickAdaptor.OnDataLoadStateChangeListener)localObject).a(4);
    }
  }
  
  public void a(LocationPickAdaptor.OnDataLoadStateChangeListener paramOnDataLoadStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor$OnDataLoadStateChangeListener = paramOnDataLoadStateChangeListener;
  }
  
  public void a(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper = new LocationPoiDataFromMapHelper(paramTencentMap, paramLatLng, paramString);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper.a(new LocationPickAdaptor.1(this, paramString));
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper.a())
    {
      paramTencentMap = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor$OnDataLoadStateChangeListener;
      if (paramTencentMap != null) {
        paramTencentMap.a(0);
      }
    }
    this.b = -1;
    this.jdField_a_of_type_Int = -1;
    paramTencentMap = this.jdField_a_of_type_JavaUtilList;
    if (paramTencentMap != null) {
      paramTencentMap.clear();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper.b()) {
        return this.jdField_a_of_type_JavaUtilList.size() + 1;
      }
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"InflateParams"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new LocationPickAdaptor.ItemViewHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559278, null);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365560);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371709));
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362252));
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377149);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(4);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).c = paramView.findViewById(2131371496);
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (LocationPickAdaptor.ItemViewHolder)paramView.getTag();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper.b()) && (paramInt == this.jdField_a_of_type_JavaUtilList.size()))
    {
      ((LocationPickAdaptor.ItemViewHolder)localObject1).c.setVisibility(0);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      ((LocationPickAdaptor.ItemViewHolder)localObject1).c.setVisibility(8);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      Object localObject2 = a(paramInt);
      if (localObject2 != null)
      {
        ((LocationPickAdaptor.ItemViewHolder)localObject1).c.setVisibility(8);
        ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((LocationRoom.Venue)localObject2).c);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).b);
        ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).c);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (paramInt == this.jdField_a_of_type_Int)
        {
          ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693818), new Object[] { ((LocationRoom.Venue)localObject2).b }));
          ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).c);
          localObject1 = ((StringBuilder)localObject3).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131694943));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((LocationRoom.Venue)localObject2).b);
          ((LocationPickAdaptor.ItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(4);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131694944));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramView.setContentDescription((CharSequence)localObject1);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickAdaptor
 * JD-Core Version:    0.7.0.1
 */