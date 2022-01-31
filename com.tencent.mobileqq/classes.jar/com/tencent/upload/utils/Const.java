package com.tencent.upload.utils;

import java.util.HashMap;
import java.util.Map;

public class Const
{
  public static final String ENTRANCE_KEY = "EX_IMAGE_UPLOAD_ENTRANCE";
  public static final String UPLOAD_ENTRANCE_TAG = "photo_upload_entrance";
  private static Map retMap = new HashMap();
  
  static
  {
    Const.UploadRetCode[] arrayOfUploadRetCode = Const.UploadRetCode.values();
    int j = arrayOfUploadRetCode.length;
    int i = 0;
    while (i < j)
    {
      Const.UploadRetCode localUploadRetCode = arrayOfUploadRetCode[i];
      retMap.put(Integer.valueOf(Const.UploadRetCode.access$000(localUploadRetCode)), localUploadRetCode);
      i += 1;
    }
  }
  
  public static int getReadSource(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 6;
    case 11: 
      return 5;
    case 12: 
      return 2;
    }
    return 4;
  }
  
  public static Const.UploadRetCode getRetCode(int paramInt)
  {
    if (retMap.containsKey(Integer.valueOf(paramInt))) {
      return (Const.UploadRetCode)retMap.get(Integer.valueOf(paramInt));
    }
    return Const.UploadRetCode.UNKNOWN_EXCEPTION;
  }
  
  public static boolean isNetworkError(int paramInt)
  {
    Const.UploadRetCode localUploadRetCode = getRetCode(paramInt);
    switch (Const.1.$SwitchMap$com$tencent$upload$utils$Const$UploadRetCode[localUploadRetCode.ordinal()])
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.Const
 * JD-Core Version:    0.7.0.1
 */