package com.tencent.mobileqq.kandian.biz.ugc.capture;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyUgcVideoReportItem
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyUgcVideoReportItem> CREATOR = new ReadInJoyUgcVideoReportItem.1();
  public double a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public long i;
  public int j;
  public String k;
  
  public ReadInJoyUgcVideoReportItem() {}
  
  protected ReadInJoyUgcVideoReportItem(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("op_duration", this.a);
      localJSONObject.put("msg_id", this.b);
      localJSONObject.put("msg_feature", this.c);
      localJSONObject.put("content_source", this.d);
      localJSONObject.put("element_type", this.e);
      localJSONObject.put("element_tag", this.f);
      localJSONObject.put("element_id", this.g);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyUgcVideoReportItem
 * JD-Core Version:    0.7.0.1
 */