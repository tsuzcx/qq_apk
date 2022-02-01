package com.tencent.mobileqq.guild.api;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildTRTCFocusApi
  extends QRouteApi
{
  public abstract void onReleaseTRTCFocus(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener);
  
  public abstract void requestTRTCFocus(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener, @NonNull IGuildTRTCFocusApi.TRTCRequestFocusCallback paramTRTCRequestFocusCallback, @Nullable Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi
 * JD-Core Version:    0.7.0.1
 */