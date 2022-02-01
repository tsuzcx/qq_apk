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
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  protected MiniAioEvent(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public MiniAioEvent(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("action", this.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("unReadC", this.jdField_a_of_type_Int);
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
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.MiniAioEvent
 * JD-Core Version:    0.7.0.1
 */