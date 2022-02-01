package com.tencent.qzonehub.api.music.impl;

import android.os.Parcelable;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import cooperation.qzone.music.QzoneMusicHelper;
import org.json.JSONObject;

public class QzoneMusicHelperImpl
  implements IQzoneMusicHelper
{
  public Parcelable convertSongInfo(JSONObject paramJSONObject)
  {
    return QzoneMusicHelper.convertSongInfo(paramJSONObject);
  }
  
  public long getFMID(String paramString)
  {
    return QzoneMusicHelper.getFMID(paramString);
  }
  
  public long getSongIDWithMid(String paramString)
  {
    return QzoneMusicHelper.getSongIDWithMid(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.music.impl.QzoneMusicHelperImpl
 * JD-Core Version:    0.7.0.1
 */