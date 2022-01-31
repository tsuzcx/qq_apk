package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.text.TextUtils;

public class ExcitingTransferHostInfo
{
  public final boolean mbInvaild;
  public final int mport;
  public final String mstrIp;
  
  public ExcitingTransferHostInfo()
  {
    this.mstrIp = null;
    this.mport = 0;
    this.mbInvaild = true;
  }
  
  public ExcitingTransferHostInfo(String paramString, int paramInt)
  {
    this.mstrIp = paramString;
    this.mport = paramInt;
    if (TextUtils.isEmpty(paramString))
    {
      this.mbInvaild = true;
      return;
    }
    this.mbInvaild = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo
 * JD-Core Version:    0.7.0.1
 */