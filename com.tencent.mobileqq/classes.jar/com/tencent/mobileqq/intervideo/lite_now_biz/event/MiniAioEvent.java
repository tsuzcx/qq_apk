package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.ilive.base.event.ModuleEventInterface;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ParcelCreator"})
public class MiniAioEvent
  implements ModuleEventInterface
{
  public static final Parcelable.Creator<MiniAioEvent> CREATOR = new MiniAioEvent.1();
  private String a;
  private int b;
  
  protected MiniAioEvent(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public MiniAioEvent(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("action", this.a);
      localJSONObject2.put("unReadC", this.b);
      localJSONObject1.put("options", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.MiniAioEvent
 * JD-Core Version:    0.7.0.1
 */