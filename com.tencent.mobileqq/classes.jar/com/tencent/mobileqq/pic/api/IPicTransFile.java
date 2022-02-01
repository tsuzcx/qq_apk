package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IPicTransFile
  extends IRuntimeService
{
  public static final int C2C_PIC_DOWNLOAD = 1004;
  public static final String C2C_PIC_DOWNLOAD_DOMAIN = "c2cpicdw.qpic.cn";
  public static final int FLAG_NOT_UPLOAD = 3;
  public static final int FLAG_UPLOADINFO_ERROR = 4;
  public static final int GROUP_PIC_DOWNLOAD = 1000;
  public static final String GROUP_PIC_DOWNLOAD_DOMAIN = "gchat.qpic.cn";
  public static final String GUILD_PIC_DOWNLOAD_DOMAIN = "gchat.qpic.cn/qmeetpic";
  public static final boolean NEW_STORE_FLAG = true;
  
  public abstract Class getC2CPicDownloadProClass();
  
  public abstract Class getC2CUploadProClass();
  
  public abstract Class getGroupDownloadProClass();
  
  public abstract Class getGroupUploadProClass();
  
  public abstract Class getGuildDownloadProClass();
  
  public abstract Class getGuildUploadProClass();
  
  public abstract byte[] getSessionKey();
  
  public abstract void setSig(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicTransFile
 * JD-Core Version:    0.7.0.1
 */