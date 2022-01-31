package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import bgvx;
import bgvy;
import bgvz;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

public class EngineChannel
  implements Parcelable
{
  public static final Parcelable.Creator<EngineChannel> CREATOR = new bgvx();
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private bgvz jdField_a_of_type_Bgvz;
  private String jdField_a_of_type_JavaLangString = "Unknown";
  
  public EngineChannel()
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = new EngineChannel.MyReceiver(this, new bgvy(ThreadManager.a().getLooper()));
  }
  
  private EngineChannel(ResultReceiver paramResultReceiver)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(paramInt, paramBundle);
    }
  }
  
  public void a(bgvz parambgvz)
  {
    this.jdField_a_of_type_Bgvz = parambgvz;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "EngineChannel{channelName=" + this.jdField_a_of_type_JavaLangString + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineChannel
 * JD-Core Version:    0.7.0.1
 */