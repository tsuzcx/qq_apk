package com.tencent.mobileqq.studyroom.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStudyRoomUploader
  extends QRouteApi
{
  public static final String KEY_LOCAL_PATH = "localPath";
  
  public abstract void cancelPicUpload(Bundle paramBundle);
  
  public abstract boolean isPicUploadEnd(Bundle paramBundle);
  
  public abstract void startPicUpload(Bundle paramBundle, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.IStudyRoomUploader
 * JD-Core Version:    0.7.0.1
 */