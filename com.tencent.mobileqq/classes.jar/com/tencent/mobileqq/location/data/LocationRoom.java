package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import awpi;
import awpj;
import awpk;
import awpq;
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
  private awpi jdField_a_of_type_Awpi;
  private volatile awpj jdField_a_of_type_Awpj;
  private awpk jdField_a_of_type_Awpk;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private volatile CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private LinkedHashMap<String, awpi> jdField_a_of_type_JavaUtilLinkedHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public LocationRoom(awpk paramawpk, String paramString)
  {
    this.jdField_a_of_type_Awpk = paramawpk;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Awpi = new awpi(paramString, null, 0.0D);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public awpi a()
  {
    return this.jdField_a_of_type_Awpi;
  }
  
  public awpi a(String paramString)
  {
    return (awpi)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
  }
  
  public awpk a()
  {
    return this.jdField_a_of_type_Awpk;
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
    if ((this.jdField_a_of_type_Awpi == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.jdField_a_of_type_Awpi.a());
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(awpj paramawpj)
  {
    this.jdField_a_of_type_Awpj = paramawpj;
  }
  
  public void a(QQAppInterface paramQQAppInterface, CameraPosition paramCameraPosition)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, "onLeaveMapPage: invoked. lastCameraPosition: " + paramCameraPosition);
    }
    this.jdField_a_of_type_Awpj = null;
    a(false);
    a(null);
    if (awpq.a(paramQQAppInterface).b())
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramCameraPosition;
      return;
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = null;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", paramVenue + " mVenue: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue + " listener: " + this.jdField_a_of_type_Awpj });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference == null) && (this.jdField_a_of_type_Awpj != null)) {
          this.jdField_a_of_type_Awpj.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
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
      } while (this.jdField_a_of_type_Awpj == null);
      this.jdField_a_of_type_Awpj.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference != null))
    {
      paramVenue = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
      if (paramVenue != null) {
        paramVenue.remove();
      }
      if (this.jdField_a_of_type_Awpj != null) {
        this.jdField_a_of_type_Awpj.a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = null;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    this.jdField_a_of_type_Awpi.a(paramLatLng, paramDouble);
  }
  
  public void a(List<awpi> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    awpi localawpi;
    while (((Iterator)localObject).hasNext())
    {
      localawpi = (awpi)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localawpi))
      {
        if (this.jdField_a_of_type_Awpj != null) {
          this.jdField_a_of_type_Awpj.a(localawpi.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localawpi + " listener: " + this.jdField_a_of_type_Awpj });
        }
        ((Iterator)localObject).remove();
      }
    }
    if ((this.jdField_a_of_type_Awpk.a() == 0) && (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 1) && (paramList.size() == 2)) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (awpi)paramList.get(i);
      int j;
      if (((awpi)localObject).equals(this.jdField_a_of_type_Awpi))
      {
        if (this.jdField_a_of_type_Awpi.a() < 0)
        {
          localObject = this.jdField_a_of_type_Awpi;
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((awpi)localObject).a(j);
        }
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.values().contains(this.jdField_a_of_type_Awpi)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(this.jdField_a_of_type_Awpi.a(), this.jdField_a_of_type_Awpi);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localawpi = (awpi)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((awpi)localObject).a());
        if (localawpi == null)
        {
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((awpi)localObject).a(j);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(((awpi)localObject).a(), localObject);
        }
        else
        {
          if (localawpi.a() < 0)
          {
            j = this.jdField_b_of_type_Int;
            this.jdField_b_of_type_Int = (j + 1);
            localawpi.a(j);
          }
          localawpi.a(((awpi)localObject).a(), Double.valueOf(((awpi)localObject).a()));
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
  
  public boolean a(awpk paramawpk)
  {
    return this.jdField_a_of_type_Awpk.equals(paramawpk);
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
      localArrayList.add(((awpi)localIterator.next()).a());
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
  
  public List<awpi> c()
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
    return this.jdField_a_of_type_Awpk.equals(((LocationRoom)paramObject).jdField_a_of_type_Awpk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */