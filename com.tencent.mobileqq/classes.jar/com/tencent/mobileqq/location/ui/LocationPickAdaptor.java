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
  private Context a;
  private int b = -1;
  private int c = -1;
  private boolean d = true;
  private LocationPoiDataFromMapHelper e;
  private List<LocationRoom.Venue> f;
  private LocationPickAdaptor.OnDataLoadStateChangeListener g;
  
  LocationPickAdaptor(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public LocationRoom.Venue a(int paramInt)
  {
    if ((this.f != null) && (paramInt < getCount())) {
      return (LocationRoom.Venue)this.f.get(paramInt);
    }
    return null;
  }
  
  void a()
  {
    if (this.e.a())
    {
      LocationPickAdaptor.OnDataLoadStateChangeListener localOnDataLoadStateChangeListener = this.g;
      if (localOnDataLoadStateChangeListener != null) {
        localOnDataLoadStateChangeListener.a(1);
      }
    }
  }
  
  public void a(LocationPickAdaptor.OnDataLoadStateChangeListener paramOnDataLoadStateChangeListener)
  {
    this.g = paramOnDataLoadStateChangeListener;
  }
  
  public void a(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.e = new LocationPoiDataFromMapHelper(paramTencentMap, paramLatLng, paramString);
    this.e.a(new LocationPickAdaptor.1(this, paramString));
    if (this.e.a())
    {
      paramTencentMap = this.g;
      if (paramTencentMap != null) {
        paramTencentMap.a(0);
      }
    }
    this.c = -1;
    this.b = -1;
    paramTencentMap = this.f;
    if (paramTencentMap != null) {
      paramTencentMap.clear();
    }
  }
  
  int b()
  {
    return this.b;
  }
  
  void b(int paramInt)
  {
    Object localObject = (LocationRoom.Venue)this.f.get(paramInt);
    if (this.c > 0)
    {
      LocationRoom.Venue localVenue = (LocationRoom.Venue)this.f.remove(0);
      this.f.add(this.c, localVenue);
    }
    this.f.remove(localObject);
    this.f.add(0, localObject);
    this.c = paramInt;
    this.b = 0;
    notifyDataSetChanged();
    localObject = this.g;
    if (localObject != null) {
      ((LocationPickAdaptor.OnDataLoadStateChangeListener)localObject).a(4);
    }
  }
  
  LocationRoom.Venue c()
  {
    int i = this.b;
    if (i < 0) {
      return null;
    }
    return a(i);
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public int getCount()
  {
    if (this.f != null)
    {
      if (this.e.b()) {
        return this.f.size() + 1;
      }
      return this.f.size();
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
      paramView = LayoutInflater.from(this.a).inflate(2131625200, null);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).a = paramView.findViewById(2131431787);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131439135));
      ((LocationPickAdaptor.ItemViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131427833));
      ((LocationPickAdaptor.ItemViewHolder)localObject1).d = paramView.findViewById(2131445527);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).d.setVisibility(4);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).e = paramView.findViewById(2131438871);
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (LocationPickAdaptor.ItemViewHolder)paramView.getTag();
    }
    if ((this.e.b()) && (paramInt == this.f.size()))
    {
      ((LocationPickAdaptor.ItemViewHolder)localObject1).e.setVisibility(0);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).a.setVisibility(8);
    }
    else
    {
      ((LocationPickAdaptor.ItemViewHolder)localObject1).e.setVisibility(8);
      ((LocationPickAdaptor.ItemViewHolder)localObject1).a.setVisibility(0);
      Object localObject2 = a(paramInt);
      if (localObject2 != null)
      {
        ((LocationPickAdaptor.ItemViewHolder)localObject1).e.setVisibility(8);
        ((LocationPickAdaptor.ItemViewHolder)localObject1).a.setVisibility(0);
        ((LocationPickAdaptor.ItemViewHolder)localObject1).c.setText(((LocationRoom.Venue)localObject2).d);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).c);
        ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).d);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (paramInt == this.b)
        {
          ((LocationPickAdaptor.ItemViewHolder)localObject1).b.setText(String.format(this.a.getString(2131891394), new Object[] { ((LocationRoom.Venue)localObject2).c }));
          ((LocationPickAdaptor.ItemViewHolder)localObject1).d.setVisibility(0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((LocationPickAdaptor.ItemViewHolder)localObject1).b.getText().toString());
          ((StringBuilder)localObject3).append(((LocationRoom.Venue)localObject2).d);
          localObject1 = ((StringBuilder)localObject3).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.a.getString(2131892670));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          ((LocationPickAdaptor.ItemViewHolder)localObject1).b.setText(((LocationRoom.Venue)localObject2).c);
          ((LocationPickAdaptor.ItemViewHolder)localObject1).d.setVisibility(4);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(this.a.getString(2131892671));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramView.setContentDescription((CharSequence)localObject1);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickAdaptor
 * JD-Core Version:    0.7.0.1
 */