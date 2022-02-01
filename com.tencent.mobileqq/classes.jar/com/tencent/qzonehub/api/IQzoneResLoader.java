package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneResLoader
  extends QRouteApi
{
  public static final int INVALID_RES_ID = -1;
  public static final int TYPE_AIO_PIC_TENCENT_FOLDER_NOT_EXIST_TOAST = 1;
  public static final int TYPE_QQSTR_LOOPQUEU_3A326EF8 = 2;
  public static final int TYPE_QQSTR_LOOPQUEU_8920D273 = 3;
  public static final int TYPE_QQSTR_QZONEEMO_0DBF8D59 = 5;
  public static final int TYPE_QQSTR_QZONEEMO_EBCA573C = 4;
  
  public abstract String getString(String paramString);
  
  public abstract int getStringId(int paramInt);
  
  public abstract int getStringId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneResLoader
 * JD-Core Version:    0.7.0.1
 */