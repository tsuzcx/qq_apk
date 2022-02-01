package com.tencent.mobileqq.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.lang.ref.SoftReference;

public class LocationRoom$Venue
  implements Parcelable
{
  public static final Parcelable.Creator<Venue> CREATOR = new LocationRoom.Venue.1();
  public SoftReference<Marker> a;
  public String b;
  public String c;
  public String d;
  public LatLng e;
  
  public LocationRoom$Venue() {}
  
  protected LocationRoom$Venue(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
  }
  
  public static Venue a(String paramString, Poi paramPoi)
  {
    Venue localVenue = new Venue();
    localVenue.b = paramString;
    localVenue.c = paramPoi.title;
    localVenue.d = paramPoi.address;
    localVenue.e = paramPoi.latLng;
    return localVenue;
  }
  
  public static Venue a(String paramString, SearchResultObject.SearchResultData paramSearchResultData)
  {
    Venue localVenue = new Venue();
    localVenue.b = paramString;
    localVenue.c = paramSearchResultData.title;
    localVenue.d = paramSearchResultData.address;
    localVenue.e = paramSearchResultData.latLng;
    return localVenue;
  }
  
  public static Venue a(String paramString, SuggestionResultObject.SuggestionData paramSuggestionData)
  {
    Venue localVenue = new Venue();
    localVenue.b = paramString;
    localVenue.c = paramSuggestionData.title;
    localVenue.d = paramSuggestionData.address;
    localVenue.e = paramSuggestionData.latLng;
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
      return this.e.equals(paramObject.e);
    }
    return super.equals(paramObject);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Venue{ name = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" address: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" authorUin: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" point: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" marker: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom.Venue
 * JD-Core Version:    0.7.0.1
 */