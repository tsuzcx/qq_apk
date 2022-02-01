package com.tencent.mobileqq.voicechange;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVoiceTuneUtil
  extends QRouteApi
{
  public static final int CHANGE_VOICE_TYPE_NORMAL = 0;
  public static final int MAX_TYPES = VOICE_TYPES.length;
  public static final int[] VOICE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
  
  public abstract void deleteAllFiles(String paramString1, String paramString2);
  
  public abstract void deleteAllFilesOnExit(String paramString1, String paramString2);
  
  public abstract void deleteOtherTmpFiles(String paramString1, String paramString2, int paramInt);
  
  public abstract String getChangedSoundFilePath(String paramString, int paramInt);
  
  public abstract boolean isExternalStorageReady(Context paramContext);
  
  public abstract String renameFileToPcm(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.IVoiceTuneUtil
 * JD-Core Version:    0.7.0.1
 */