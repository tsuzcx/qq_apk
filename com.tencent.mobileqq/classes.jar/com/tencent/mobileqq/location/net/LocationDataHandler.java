package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LocationDataHandler
{
  private final String jdField_a_of_type_JavaLangString;
  private final List<OnUpdateUserLocationListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<LocationRoom.RoomKey, LocationRoom> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  
  LocationDataHandler(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LocationRoom a(LocationRoom.RoomKey paramRoomKey)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramRoomKey);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramRoomKey, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(paramRoomKey, localLocationRoom1);
      }
      if (QLog.isColorLevel())
      {
        paramRoomKey = new StringBuilder();
        paramRoomKey.append("getLocationRoom: invoked. mLocationRoomMap size: ");
        paramRoomKey.append(this.jdField_a_of_type_JavaUtilMap.size());
        paramRoomKey.append(" locationRoom: ");
        paramRoomKey.append(localLocationRoom1);
        QLog.d("LocationDataHandler", 2, paramRoomKey.toString());
      }
      return localLocationRoom1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    paramString = new LocationRoom.RoomKey(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((OnUpdateUserLocationListener)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.c());
      }
    }
  }
  
  public void a(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnUpdateUserLocationListener);
      return;
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramRoomKey = (LocationRoom)this.jdField_a_of_type_JavaUtilMap.get(paramRoomKey);
      if ((paramRoomKey != null) && (paramRoomKey.a() != null)) {
        paramRoomKey.a().a();
      }
      return;
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramRoomKey)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramRoomKey);
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)???).hasNext()) {
          ((OnUpdateUserLocationListener)((Iterator)???).next()).b(paramRoomKey, paramInt);
        }
      }
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnUpdateUserLocationListener)localIterator.next()).a(paramRoomKey, paramInt1, paramInt2);
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    LocationRoom localLocationRoom = a(paramRoomKey);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((OnUpdateUserLocationListener)paramList.next()).a(paramRoomKey, paramVenue, localLocationRoom.c());
    }
  }
  
  public void b(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramOnUpdateUserLocationListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramOnUpdateUserLocationListener);
      }
      return;
    }
  }
  
  void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramRoomKey);
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)???).hasNext()) {
        ((OnUpdateUserLocationListener)((Iterator)???).next()).a(paramRoomKey, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramRoomKey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationDataHandler
 * JD-Core Version:    0.7.0.1
 */