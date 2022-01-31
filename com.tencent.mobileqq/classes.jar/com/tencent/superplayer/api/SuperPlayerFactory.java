package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.superplayer.datatransport.SPlayerDownloaderImpl;
import com.tencent.superplayer.datatransport.SPlayerPreLoaderImpl;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;

public class SuperPlayerFactory
{
  public static ISPlayerDownloader createDownloader(Context paramContext, int paramInt)
  {
    return new SPlayerDownloaderImpl(paramContext, paramInt);
  }
  
  public static ISuperPlayer createMediaPlayer(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    return new SuperPlayerMgr(paramContext, paramInt, paramISPlayerVideoView);
  }
  
  public static ISPlayerVideoView createPlayerVideoView(Context paramContext)
  {
    return new SPlayerVideoView(paramContext, true);
  }
  
  public static ISPlayerVideoView createPlayerVideoView(Context paramContext, boolean paramBoolean)
  {
    return new SPlayerVideoView(paramContext, paramBoolean);
  }
  
  public static ISPlayerPreLoader createPreLoader(Context paramContext, int paramInt)
  {
    return new SPlayerPreLoaderImpl(paramContext, paramInt);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(int paramInt, String paramString)
  {
    return new SuperPlayerVideoInfo(1, 1, paramInt, paramString);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(int paramInt, String paramString1, String paramString2)
  {
    return new SuperPlayerVideoInfo(1, 2, paramInt, paramString1, paramString2);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(String paramString)
  {
    return new SuperPlayerVideoInfo(1, 1, paramString);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForTVideo(String paramString1, String paramString2)
  {
    return new SuperPlayerVideoInfo(1, 2, paramString1, paramString2);
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String paramString1, int paramInt, String paramString2)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramString1);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString2);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramString1);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString2);
    localSuperPlayerVideoInfo.setLocalSavePath(paramString3);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] paramArrayOfString, int paramInt, String paramString)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramArrayOfString);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString);
    return localSuperPlayerVideoInfo;
  }
  
  public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] paramArrayOfString, int paramInt, String paramString1, String paramString2)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3);
    localSuperPlayerVideoInfo.setPlayUrl(paramArrayOfString);
    localSuperPlayerVideoInfo.setFormat(paramInt);
    localSuperPlayerVideoInfo.setFileId(paramString1);
    localSuperPlayerVideoInfo.setLocalSavePath(paramString2);
    return localSuperPlayerVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerFactory
 * JD-Core Version:    0.7.0.1
 */