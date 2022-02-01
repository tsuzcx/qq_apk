package com.tencent.mobileqq.flashshow.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.api.interfaces.IFlashShowController;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IFlashShowServiceApi
  extends QRouteApi
{
  public abstract void enterBySchemeAction(Context paramContext, String paramString, @NonNull HashMap<String, String> paramHashMap);
  
  public abstract IFlashShowController getFlashShowController();
  
  public abstract void reportTo1101(DataBuilder paramDataBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFlashShowServiceApi
 * JD-Core Version:    0.7.0.1
 */