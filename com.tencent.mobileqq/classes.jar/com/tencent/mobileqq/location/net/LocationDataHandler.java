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
  private final String a;
  private final Map<LocationRoom.RoomKey, LocationRoom> b = new LinkedHashMap();
  private final List<OnUpdateUserLocationListener> c = new ArrayList();
  
  LocationDataHandler(String paramString)
  {
    this.a = paramString;
  }
  
  public LocationRoom a(LocationRoom.RoomKey paramRoomKey)
  {
    synchronized (this.b)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.b.get(paramRoomKey);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramRoomKey, this.a);
        this.b.put(paramRoomKey, localLocationRoom1);
      }
      if (QLog.isColorLevel())
      {
        paramRoomKey = new StringBuilder();
        paramRoomKey.append("getLocationRoom: invoked. mLocationRoomMap size: ");
        paramRoomKey.append(this.b.size());
        paramRoomKey.append(" locationRoom: ");
        paramRoomKey.append(localLocationRoom1);
        QLog.d("LocationDataHandler", 2, paramRoomKey.toString());
      }
      return localLocationRoom1;
    }
  }
  
  public void a()
  {
    synchronized (this.b)
    {
      this.b.clear();
      return;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    paramString = new LocationRoom.RoomKey(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((OnUpdateUserLocationListener)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.i());
      }
    }
  }
  
  public void a(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    synchronized (this.c)
    {
      this.c.remove(paramOnUpdateUserLocationListener);
      return;
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (this.b.containsKey(paramRoomKey)) {
      synchronized (this.b)
      {
        this.b.remove(paramRoomKey);
        ??? = this.c.iterator();
        if (((Iterator)???).hasNext()) {
          ((OnUpdateUserLocationListener)((Iterator)???).next()).b(paramRoomKey, paramInt);
        }
      }
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnUpdateUserLocationListener)localIterator.next()).a(paramRoomKey, paramInt1, paramInt2);
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    LocationRoom localLocationRoom = a(paramRoomKey);
    localLocationRoom.a(paramVenue);
    localLocationRoom.a(paramList);
    paramList = this.c.iterator();
    while (paramList.hasNext()) {
      ((OnUpdateUserLocationListener)paramList.next()).a(paramRoomKey, paramVenue, localLocationRoom.i());
    }
  }
  
  public void b(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramOnUpdateUserLocationListener)) {
        this.c.add(paramOnUpdateUserLocationListener);
      }
      return;
    }
  }
  
  void b(LocationRoom.RoomKey paramRoomKey)
  {
    synchronized (this.b)
    {
      paramRoomKey = (LocationRoom)this.b.get(paramRoomKey);
      if ((paramRoomKey != null) && (paramRoomKey.f() != null)) {
        paramRoomKey.f().d();
      }
      return;
    }
  }
  
  void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    synchronized (this.b)
    {
      this.b.remove(paramRoomKey);
      ??? = this.c.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationDataHandler
 * JD-Core Version:    0.7.0.1
 */