package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocationRoom
{
  private int jdField_a_of_type_Int = -1;
  private final LocationItem jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem;
  private volatile LocationRoom.OnNewLocationListener jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener;
  private final LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private volatile CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = null;
  private final LinkedHashMap<String, LocationItem> jdField_a_of_type_JavaUtilLinkedHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public LocationRoom(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem = new LocationItem(paramString, null, 0.0D);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem;
  }
  
  public LocationItem a(String paramString)
  {
    return (LocationItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
  }
  
  public LocationRoom.RoomKey a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  }
  
  public LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  }
  
  public CameraPosition a()
  {
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  }
  
  public List<LatLng> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem.a());
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(LocationRoom.OnNewLocationListener paramOnNewLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener = paramOnNewLocationListener;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramVenue);
      ((StringBuilder)localObject).append(" mVenue: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      ((StringBuilder)localObject).append(" listener: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener);
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", ((StringBuilder)localObject).toString() });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference == null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
        }
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
      if ((localObject != null) && (((LocationRoom.Venue)localObject).jdField_a_of_type_JavaLangRefSoftReference != null))
      {
        localObject = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
        if (localObject != null) {
          ((Marker)localObject).remove();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramVenue;
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      }
    }
    else
    {
      paramVenue = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
      if ((paramVenue != null) && (paramVenue.jdField_a_of_type_JavaLangRefSoftReference != null))
      {
        paramVenue = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
        if (paramVenue != null) {
          paramVenue.remove();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener.a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = null;
    }
  }
  
  public void a(CameraPosition paramCameraPosition)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLeaveMapPage: invoked. lastCameraPosition: ");
      localStringBuilder.append(paramCameraPosition);
      QLog.d("LocationRoom", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener = null;
    a(false);
    a(null);
    if (((ILocationShareService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ILocationShareService.class, "")).isCurrentUserSharing())
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramCameraPosition;
      return;
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = null;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem.a(paramLatLng, paramDouble);
  }
  
  public void a(List<LocationItem> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int j;
    LocationItem localLocationItem;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      localLocationItem = (LocationItem)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localLocationItem))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener.a(localLocationItem.a());
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localLocationItem);
          localStringBuilder.append(" listener: ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$OnNewLocationListener);
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localStringBuilder.toString() });
        }
        ((Iterator)localObject).remove();
      }
    }
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 0)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 1)
      {
        i = j;
        if (paramList.size() == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          i = j;
        }
      }
    }
    while (i < paramList.size())
    {
      localObject = (LocationItem)paramList.get(i);
      if (((LocationItem)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem.a() < 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem;
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((LocationItem)localObject).a(j);
        }
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsValue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationItem);
        }
      }
      else
      {
        localLocationItem = (LocationItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((LocationItem)localObject).a());
        if (localLocationItem == null)
        {
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((LocationItem)localObject).a(j);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(((LocationItem)localObject).a(), localObject);
        }
        else
        {
          if (localLocationItem.a() < 0)
          {
            j = this.jdField_b_of_type_Int;
            this.jdField_b_of_type_Int = (j + 1);
            localLocationItem.a(j);
          }
          localLocationItem.a(((LocationItem)localObject).a(), Double.valueOf(((LocationItem)localObject).a()));
        }
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(LocationRoom.RoomKey paramRoomKey)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.equals(paramRoomKey);
  }
  
  public int b()
  {
    int i = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = (i + 1);
    return i;
  }
  
  public List<LatLng> b()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((LocationItem)((Iterator)localObject).next()).a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
    if (localObject != null) {
      localArrayList.add(((LocationRoom.Venue)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    }
    return localArrayList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public List<LocationItem> c()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + 1);
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilLinkedHashMap.values());
    return localArrayList;
  }
  
  public List<String> d()
  {
    ArrayList localArrayList = new ArrayList(30);
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    return localArrayList;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof LocationRoom)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.equals(((LocationRoom)paramObject).jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */