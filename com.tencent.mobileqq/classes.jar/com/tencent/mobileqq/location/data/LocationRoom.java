package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import awir;
import awis;
import awit;
import awiz;
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
  private awir jdField_a_of_type_Awir;
  private volatile awis jdField_a_of_type_Awis;
  private awit jdField_a_of_type_Awit;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private volatile CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private LinkedHashMap<String, awir> jdField_a_of_type_JavaUtilLinkedHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public LocationRoom(awit paramawit, String paramString)
  {
    this.jdField_a_of_type_Awit = paramawit;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Awir = new awir(paramString, null, 0.0D);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public awir a()
  {
    return this.jdField_a_of_type_Awir;
  }
  
  public awir a(String paramString)
  {
    return (awir)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
  }
  
  public awit a()
  {
    return this.jdField_a_of_type_Awit;
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
    if ((this.jdField_a_of_type_Awir == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.jdField_a_of_type_Awir.a());
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(awis paramawis)
  {
    this.jdField_a_of_type_Awis = paramawis;
  }
  
  public void a(QQAppInterface paramQQAppInterface, CameraPosition paramCameraPosition)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, "onLeaveMapPage: invoked. lastCameraPosition: " + paramCameraPosition);
    }
    this.jdField_a_of_type_Awis = null;
    a(false);
    a(null);
    if (awiz.a(paramQQAppInterface).b())
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramCameraPosition;
      return;
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = null;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", paramVenue + " mVenue: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue + " listener: " + this.jdField_a_of_type_Awis });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference == null) && (this.jdField_a_of_type_Awis != null)) {
          this.jdField_a_of_type_Awis.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
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
      } while (this.jdField_a_of_type_Awis == null);
      this.jdField_a_of_type_Awis.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference != null))
    {
      paramVenue = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference.get();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.jdField_a_of_type_JavaLangRefSoftReference = null;
      if (paramVenue != null) {
        paramVenue.remove();
      }
      if (this.jdField_a_of_type_Awis != null) {
        this.jdField_a_of_type_Awis.a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = null;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    this.jdField_a_of_type_Awir.a(paramLatLng, paramDouble);
  }
  
  public void a(List<awir> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    awir localawir;
    while (((Iterator)localObject).hasNext())
    {
      localawir = (awir)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localawir))
      {
        if (this.jdField_a_of_type_Awis != null) {
          this.jdField_a_of_type_Awis.a(localawir.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localawir + " listener: " + this.jdField_a_of_type_Awis });
        }
        ((Iterator)localObject).remove();
      }
    }
    if ((this.jdField_a_of_type_Awit.a() == 0) && (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 1) && (paramList.size() == 2)) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (awir)paramList.get(i);
      int j;
      if (((awir)localObject).equals(this.jdField_a_of_type_Awir))
      {
        if (this.jdField_a_of_type_Awir.a() < 0)
        {
          localObject = this.jdField_a_of_type_Awir;
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((awir)localObject).a(j);
        }
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.values().contains(this.jdField_a_of_type_Awir)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(this.jdField_a_of_type_Awir.a(), this.jdField_a_of_type_Awir);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localawir = (awir)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((awir)localObject).a());
        if (localawir == null)
        {
          j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          ((awir)localObject).a(j);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(((awir)localObject).a(), localObject);
        }
        else
        {
          if (localawir.a() < 0)
          {
            j = this.jdField_b_of_type_Int;
            this.jdField_b_of_type_Int = (j + 1);
            localawir.a(j);
          }
          localawir.a(((awir)localObject).a(), Double.valueOf(((awir)localObject).a()));
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
  
  public boolean a(awit paramawit)
  {
    return this.jdField_a_of_type_Awit.equals(paramawit);
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
      localArrayList.add(((awir)localIterator.next()).a());
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
  
  public List<awir> c()
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
    return this.jdField_a_of_type_Awit.equals(((LocationRoom)paramObject).jdField_a_of_type_Awit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */