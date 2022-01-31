package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.os.Bundle;

public abstract interface IProvider
{
  public abstract void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void downloadMedia(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void favorite(long paramLong);
  
  public abstract Intent getFavorateParams(long paramLong, int paramInt);
  
  public abstract Intent getForwardData(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int getSaveFileProgress(long paramLong, int paramInt);
  
  public abstract boolean isPingBinder();
  
  public abstract void loadMedias(int paramInt);
  
  public abstract void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle);
  
  public abstract void payFlow(long paramLong, int paramInt);
  
  public abstract void reportData(String paramString, int paramInt);
  
  public abstract void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void saveToWeiyun(long paramLong);
  
  public abstract void sendFileToPC(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.IProvider
 * JD-Core Version:    0.7.0.1
 */