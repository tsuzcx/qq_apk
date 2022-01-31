package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mapsdk.raster.model.GeoPoint;

public class OverlayItem
  implements Parcelable
{
  public static final Parcelable.Creator<OverlayItem> CREATOR = new Parcelable.Creator()
  {
    public final OverlayItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OverlayItem(paramAnonymousParcel);
    }
    
    public final OverlayItem[] newArray(int paramAnonymousInt)
    {
      return new OverlayItem[paramAnonymousInt];
    }
  };
  protected boolean boDragable = true;
  private Drawable mMarker;
  protected GeoPoint mPoint;
  protected final String mSnippet;
  protected final String mTitle;
  
  protected OverlayItem(Parcel paramParcel)
  {
    this.mPoint = ((GeoPoint)paramParcel.readValue(GeoPoint.class.getClassLoader()));
    this.mTitle = paramParcel.readString();
    this.mSnippet = paramParcel.readString();
  }
  
  public OverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    this.mPoint = paramGeoPoint.Copy();
    this.mTitle = paramString1;
    this.mSnippet = paramString2;
    this.mMarker = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getMarker()
  {
    return this.mMarker;
  }
  
  public GeoPoint getPoint()
  {
    return this.mPoint;
  }
  
  public String getSnippet()
  {
    return this.mSnippet;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isDragable()
  {
    return this.boDragable;
  }
  
  public void setDragable(boolean paramBoolean)
  {
    this.boDragable = paramBoolean;
  }
  
  public void setMarker(Drawable paramDrawable)
  {
    this.mMarker = paramDrawable;
    if (this.mMarker == null) {}
    do
    {
      return;
      paramDrawable = this.mMarker.getBounds();
      if (paramDrawable == null)
      {
        ItemizedOverlay.boundCenterBottom(this.mMarker);
        return;
      }
    } while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0));
    ItemizedOverlay.boundCenterBottom(this.mMarker);
  }
  
  public void setPoint(GeoPoint paramGeoPoint)
  {
    this.mPoint = paramGeoPoint.Copy();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.mPoint);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSnippet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.OverlayItem
 * JD-Core Version:    0.7.0.1
 */