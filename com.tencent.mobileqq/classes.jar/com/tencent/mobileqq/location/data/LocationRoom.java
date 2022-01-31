package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import atlf;
import atlg;
import atlh;
import atln;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class LocationRoom
{
  private int jdField_a_of_type_Int = -1;
  private atlf jdField_a_of_type_Atlf;
  private volatile atlg jdField_a_of_type_Atlg;
  private atlh jdField_a_of_type_Atlh;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private volatile CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private LinkedHashMap<String, atlf> jdField_a_of_type_JavaUtilLinkedHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public LocationRoom(atlh paramatlh, String paramString)
  {
    this.jdField_a_of_type_Atlh = paramatlh;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Atlf = new atlf(paramString, null, 0.0D);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public atlf a()
  {
    return this.jdField_a_of_type_Atlf;
  }
  
  public atlf a(String paramString)
  {
    return (atlf)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
  }
  
  public atlh a()
  {
    return this.jdField_a_of_type_Atlh;
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
    if ((this.jdField_a_of_type_Atlf == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.jdField_a_of_type_Atlf.a());
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(atlg paramatlg)
  {
    this.jdField_a_of_type_Atlg = paramatlg;
  }
  
  public void a(QQAppInterface paramQQAppInterface, CameraPosition paramCameraPosition)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, "onLeaveMapPage: invoked. lastCameraPosition: " + paramCameraPosition);
    }
    this.jdField_a_of_type_Atlg = null;
    a(false);
    a(null);
    if (atln.a(paramQQAppInterface).b())
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramCameraPosition;
      return;
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = null;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", paramVenue + " mVenue: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue + " listener: " + this.jdField_a_of_type_Atlg });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference == null) && (this.jdField_a_of_type_Atlg != null)) {
          this.jdField_a_of_type_Atlg.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
        }
      }
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference != null))
        {
          Marker localMarker = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
          if (localMarker != null) {
            localMarker.remove();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramVenue;
      } while (this.jdField_a_of_type_Atlg == null);
      this.jdField_a_of_type_Atlg.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference != null))
    {
      paramVenue = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
      if (paramVenue != null) {
        paramVenue.remove();
      }
      if (this.jdField_a_of_type_Atlg != null) {
        this.jdField_a_of_type_Atlg.a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = null;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    this.jdField_a_of_type_Atlf.a(paramLatLng, paramDouble);
  }
  
  public void a(List<atlf> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    atlf localatlf;
    while (((Iterator)localObject).hasNext())
    {
      localatlf = (atlf)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localatlf))
      {
        if (this.jdField_a_of_type_Atlg != null) {
          this.jdField_a_of_type_Atlg.a(localatlf.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localatlf + " listener: " + this.jdField_a_of_type_Atlg });
        }
        ((Iterator)localObject).remove();
      }
    }
    if ((this.jdField_a_of_type_Atlh.a() == 0) && (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 1) && (paramList.size() == 2)) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (atlf)paramList.get(i);
      int j;
      if (((atlf)localObject).equals(this.jdField_a_of_type_Atlf))
      {
        if (this.jdField_a_of_type_Atlf.a() < 0)
        {
          localObject = this.jdField_a_of_type_Atlf;
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((atlf)localObject).a(j);
        }
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.values().contains(this.jdField_a_of_type_Atlf)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(this.jdField_a_of_type_Atlf.a(), this.jdField_a_of_type_Atlf);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localatlf = (atlf)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((atlf)localObject).a());
        if (localatlf == null)
        {
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((atlf)localObject).a(j);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(((atlf)localObject).a(), localObject);
        }
        else
        {
          if (localatlf.a() < 0)
          {
            j = this.jdField_b_of_type_Int;
            this.jdField_b_of_type_Int = (j + 1);
            localatlf.a(j);
          }
          localatlf.a(((atlf)localObject).a(), Double.valueOf(((atlf)localObject).a()));
        }
      }
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
  
  public boolean a(atlh paramatlh)
  {
    return this.jdField_a_of_type_Atlh.equals(paramatlh);
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((atlf)localIterator.next()).a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) {
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
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
  
  public List<atlf> c()
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
    return this.jdField_a_of_type_Atlh.equals(((LocationRoom)paramObject).jdField_a_of_type_Atlh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */