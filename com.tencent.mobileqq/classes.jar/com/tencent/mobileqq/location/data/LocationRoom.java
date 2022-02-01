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
  private final LocationRoom.RoomKey a;
  private LocationRoom.Venue b;
  private int c = -1;
  private final LocationItem d;
  private final LinkedHashMap<String, LocationItem> e;
  private volatile LocationRoom.OnNewLocationListener f;
  private volatile boolean g = false;
  private volatile CameraPosition h = null;
  private int i = 0;
  private volatile boolean j = false;
  
  public LocationRoom(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    this.a = paramRoomKey;
    this.e = new LinkedHashMap();
    this.d = new LocationItem(paramString, null, 0.0D);
  }
  
  public LocationItem a(String paramString)
  {
    return (LocationItem)this.e.get(paramString);
  }
  
  public LocationRoom.Venue a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(LocationRoom.OnNewLocationListener paramOnNewLocationListener)
  {
    this.f = paramOnNewLocationListener;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramVenue);
      ((StringBuilder)localObject).append(" mVenue: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" listener: ");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", ((StringBuilder)localObject).toString() });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.b))
      {
        if ((this.b.a == null) && (this.f != null)) {
          this.f.a(this.b);
        }
        return;
      }
      localObject = this.b;
      if ((localObject != null) && (((LocationRoom.Venue)localObject).a != null))
      {
        localObject = (Marker)this.b.a.get();
        this.b.a = null;
        if (localObject != null) {
          ((Marker)localObject).remove();
        }
      }
      this.b = paramVenue;
      if (this.f != null) {
        this.f.a(this.b);
      }
    }
    else
    {
      paramVenue = this.b;
      if ((paramVenue != null) && (paramVenue.a != null))
      {
        paramVenue = (Marker)this.b.a.get();
        this.b.a = null;
        if (paramVenue != null) {
          paramVenue.remove();
        }
        if (this.f != null) {
          this.f.a();
        }
      }
      this.b = null;
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
    this.f = null;
    a(false);
    a(null);
    if (((ILocationShareService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ILocationShareService.class, "")).isCurrentUserSharing())
    {
      this.h = paramCameraPosition;
      return;
    }
    this.h = null;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    this.d.a(paramLatLng, paramDouble);
  }
  
  public void a(List<LocationItem> paramList)
  {
    Object localObject = this.e.entrySet().iterator();
    int m;
    LocationItem localLocationItem;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      m = 0;
      if (!bool) {
        break;
      }
      localLocationItem = (LocationItem)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localLocationItem))
      {
        if (this.f != null) {
          this.f.a(localLocationItem.c());
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localLocationItem);
          localStringBuilder.append(" listener: ");
          localStringBuilder.append(this.f);
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localStringBuilder.toString() });
        }
        ((Iterator)localObject).remove();
      }
    }
    int k = m;
    if (this.a.a() == 0)
    {
      k = m;
      if (this.e.size() == 1)
      {
        k = m;
        if (paramList.size() == 2)
        {
          this.g = true;
          k = m;
        }
      }
    }
    while (k < paramList.size())
    {
      localObject = (LocationItem)paramList.get(k);
      if (((LocationItem)localObject).equals(this.d))
      {
        if (this.d.e() < 0)
        {
          localObject = this.d;
          m = this.i;
          this.i = (m + 1);
          ((LocationItem)localObject).a(m);
        }
        if (!this.e.containsValue(this.d)) {
          this.e.put(this.d.c(), this.d);
        }
      }
      else
      {
        localLocationItem = (LocationItem)this.e.get(((LocationItem)localObject).c());
        if (localLocationItem == null)
        {
          m = this.i;
          this.i = (m + 1);
          ((LocationItem)localObject).a(m);
          this.e.put(((LocationItem)localObject).c(), localObject);
        }
        else
        {
          if (localLocationItem.e() < 0)
          {
            m = this.i;
            this.i = (m + 1);
            localLocationItem.a(m);
          }
          localLocationItem.a(((LocationItem)localObject).a(), Double.valueOf(((LocationItem)localObject).b()));
        }
      }
      k += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a(LocationRoom.RoomKey paramRoomKey)
  {
    return this.a.equals(paramRoomKey);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public int c()
  {
    int k = this.i;
    this.i = (k + 1);
    return k;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public LocationRoom.RoomKey e()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof LocationRoom)) {
      return false;
    }
    return this.a.equals(((LocationRoom)paramObject).a);
  }
  
  public LocationItem f()
  {
    return this.d;
  }
  
  public List<LatLng> g()
  {
    if (this.b == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.d.a());
    localArrayList.add(this.b.e);
    return localArrayList;
  }
  
  public List<LatLng> h()
  {
    ArrayList localArrayList = new ArrayList(this.e.size());
    Object localObject = this.e.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((LocationItem)((Iterator)localObject).next()).a());
    }
    localObject = this.b;
    if (localObject != null) {
      localArrayList.add(((LocationRoom.Venue)localObject).e);
    }
    return localArrayList;
  }
  
  public List<LocationItem> i()
  {
    ArrayList localArrayList = new ArrayList(this.e.size() + 1);
    localArrayList.addAll(this.e.values());
    return localArrayList;
  }
  
  public List<String> j()
  {
    ArrayList localArrayList = new ArrayList(30);
    localArrayList.addAll(this.e.keySet());
    return localArrayList;
  }
  
  public CameraPosition k()
  {
    return this.h;
  }
  
  public boolean l()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */