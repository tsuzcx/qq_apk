package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastAudio
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastAudio> CREATOR = new BroadcastAudio.1();
  public BroadcastUrl a;
  public ArrayList<BroadcastUrl> a;
  
  public BroadcastAudio()
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public BroadcastAudio(Parcel paramParcel)
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl = ((BroadcastUrl)paramParcel.readParcelable(BroadcastUrl.class.getClassLoader()));
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(BroadcastUrl.class.getClassLoader());
  }
  
  public static BroadcastAudio a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio paramBroadcastAudio)
  {
    BroadcastAudio localBroadcastAudio = new BroadcastAudio();
    localBroadcastAudio.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl = BroadcastUrl.a(paramBroadcastAudio.masterUrl);
    localBroadcastAudio.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramBroadcastAudio.slaveUrl != null)
    {
      paramBroadcastAudio = paramBroadcastAudio.slaveUrl.iterator();
      while (paramBroadcastAudio.hasNext())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.a((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl)paramBroadcastAudio.next());
        localBroadcastAudio.jdField_a_of_type_JavaUtilArrayList.add(localBroadcastUrl);
      }
    }
    return localBroadcastAudio;
  }
  
  public static BroadcastAudio a(String paramString)
  {
    BroadcastAudio localBroadcastAudio = new BroadcastAudio();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastAudio.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl = BroadcastUrl.a(paramString.getString("masterUrl"));
      paramString = paramString.getJSONArray("slaveUrl");
      localBroadcastAudio.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.a(paramString.optString(i));
        localBroadcastAudio.jdField_a_of_type_JavaUtilArrayList.add(localBroadcastUrl);
        i += 1;
      }
      return localBroadcastAudio;
    }
    catch (Exception paramString) {}
    return localBroadcastAudio;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastUrl, paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastAudio
 * JD-Core Version:    0.7.0.1
 */