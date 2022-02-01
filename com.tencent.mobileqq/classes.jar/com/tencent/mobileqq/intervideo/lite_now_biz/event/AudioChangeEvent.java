package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ParcelCreator"})
public class AudioChangeEvent
  implements ModuleEventInterface
{
  public static final Parcelable.Creator<AudioChangeEvent> CREATOR = new AudioChangeEvent.1();
  public int a;
  public List<String> a;
  
  public AudioChangeEvent() {}
  
  public AudioChangeEvent(int paramInt, List<String> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected AudioChangeEvent(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createStringArrayList();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put((String)localIterator.next());
      }
      localJSONObject2.put("identifiers", localObject);
      localJSONObject1.put("type", this.jdField_a_of_type_Int);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildJSONData error: ");
      ((StringBuilder)localObject).append(localJSONException);
      QLog.e("AudioChangeEvent", 1, ((StringBuilder)localObject).toString());
    }
    return localJSONObject1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent
 * JD-Core Version:    0.7.0.1
 */