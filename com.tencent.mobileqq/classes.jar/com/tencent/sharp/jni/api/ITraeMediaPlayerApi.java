package com.tencent.sharp.jni.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.sharp.jni.callback.OnCompletionListener;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ITraeMediaPlayerApi
  extends QRouteApi
{
  public static final int TRAE_MEDIA_PLAYER_DATASOURCE_FILEPATH = 2;
  public static final int TRAE_MEDIA_PLAYER_DATASOURCE_RID = 0;
  public static final int TRAE_MEDIA_PLAYER_DATASOURCE_URI = 1;
  
  public abstract int getDuration();
  
  public abstract int getStreamType();
  
  public abstract boolean hasCall();
  
  public abstract void init(Context paramContext, OnCompletionListener paramOnCompletionListener);
  
  public abstract boolean playRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4);
  
  public abstract void stopRing(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sharp.jni.api.ITraeMediaPlayerApi
 * JD-Core Version:    0.7.0.1
 */