package com.tencent.mobileqq.vas.handler.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IClubContentUpdateHandler
  extends QRouteApi
{
  public abstract void checkJsonVersion(Context paramContext);
  
  public abstract void saveQVIPResConfigContent(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */