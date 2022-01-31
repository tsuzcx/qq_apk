package com.tencent.mobileqq.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import atpr;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.lang.ref.SoftReference;

public class LocationRoom$Venue
  implements Parcelable
{
  public static final Parcelable.Creator<Venue> CREATOR = new atpr();
  public LatLng a;
  public String a;
  public SoftReference<Marker> a;
  public String b;
  public String c;
  
  public LocationRoom$Venue() {}
  
  public LocationRoom$Venue(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
  }
  
  public static Venue a(String paramString, Poi paramPoi)
  {
    Venue localVenue = new Venue();
    localVenue.jdField_a_of_type_JavaLangString = paramString;
    localVenue.b = paramPoi.title;
    localVenue.c = paramPoi.address;
    localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramPoi.latLng;
    return localVenue;
  }
  
  public static Venue a(String paramString, SearchResultObject.SearchResultData paramSearchResultData)
  {
    Venue localVenue = new Venue();
    localVenue.jdField_a_of_type_JavaLangString = paramString;
    localVenue.b = paramSearchResultData.title;
    localVenue.c = paramSearchResultData.address;
    localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramSearchResultData.latLng;
    return localVenue;
  }
  
  public static Venue a(String paramString, SuggestionResultObject.SuggestionData paramSuggestionData)
  {
    Venue localVenue = new Venue();
    localVenue.jdField_a_of_type_JavaLangString = paramString;
    localVenue.b = paramSuggestionData.title;
    localVenue.c = paramSuggestionData.address;
    localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramSuggestionData.latLng;
    return localVenue;
  }
  
  public static Venue a(String paramString, LBSShare.POI paramPOI)
  {
    Venue localVenue = new Venue();
    localVenue.jdField_a_of_type_JavaLangString = paramString;
    localVenue.b = paramPOI.name.get();
    localVenue.c = paramPOI.addr.get();
    localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = new LatLng(paramPOI.lat.get() / 1000000.0D, paramPOI.lng.get() / 1000000.0D);
    return localVenue;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Venue))
    {
      paramObject = (Venue)paramObject;
      return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.equals(paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    }
    return super.equals(paramObject);
  }
  
  @NonNull
  public String toString()
  {
    return "Venue{ name = " + this.b + " address: " + this.c + " authorUin: " + this.jdField_a_of_type_JavaLangString + " point: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " marker: " + this.jdField_a_of_type_JavaLangRefSoftReference + " }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom.Venue
 * JD-Core Version:    0.7.0.1
 */