package com.tencent.mobileqq.triton.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;
import java.util.Set;

public abstract interface IQQEnv
{
  public abstract int blackScreenDetectInterval();
  
  public abstract void cleanCache();
  
  public abstract boolean download(String paramString, ITDownloadListener paramITDownloadListener);
  
  public abstract boolean enableOpengles3();
  
  public abstract int frameNoChangeLimit();
  
  public abstract boolean gameErrorDialogEnable();
  
  public abstract String getAppId();
  
  public abstract String getBaseEnginePath();
  
  public abstract int getBenchmarkLevel();
  
  public abstract Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo);
  
  public abstract String getGameConfig(MiniGameInfo paramMiniGameInfo, String paramString);
  
  @NonNull
  public abstract String getGameEnvVersion();
  
  @NonNull
  public abstract String getGlobalConfig();
  
  public abstract Set<String> getLogBlackList();
  
  public abstract Set<String> getLogWhiteList();
  
  public abstract String getPlatformName();
  
  public abstract String getPlatformVersion();
  
  public abstract String getResPath(String paramString1, String paramString2, MiniGameInfo paramMiniGameInfo);
  
  public abstract String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString);
  
  public abstract String getWxFilePath(String paramString);
  
  public abstract boolean isDebug();
  
  public abstract boolean isNotchValid();
  
  public abstract int jsErrorDetectInterval();
  
  public abstract void killSelf(Context paramContext);
  
  public abstract int noPresentDurationLimit();
  
  public abstract int noPresentTouchLimit();
  
  public abstract int parseColor(String paramString);
  
  public abstract void postRunable(Runnable paramRunnable);
  
  public abstract void postRunableDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract int presentDetectInterval();
  
  public abstract String readFileToString(File paramFile);
  
  public abstract void reportDC04266(int paramInt, String paramString);
  
  public abstract void reportDC04902(String paramString, long paramLong);
  
  public abstract void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback);
  
  public abstract void updateDisplayFrameTime(long paramLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.IQQEnv
 * JD-Core Version:    0.7.0.1
 */