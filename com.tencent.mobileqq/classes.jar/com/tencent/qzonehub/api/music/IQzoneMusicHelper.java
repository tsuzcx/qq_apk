package com.tencent.qzonehub.api.music;

import android.os.Parcelable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQzoneMusicHelper
  extends QRouteApi
{
  public abstract Parcelable convertSongInfo(JSONObject paramJSONObject);
  
  public abstract long getFMID(String paramString);
  
  public abstract long getSongIDWithMid(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.music.IQzoneMusicHelper
 * JD-Core Version:    0.7.0.1
 */