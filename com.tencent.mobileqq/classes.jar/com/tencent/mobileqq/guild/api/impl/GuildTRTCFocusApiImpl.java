package com.tencent.mobileqq.guild.api.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCFocusListener;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCRequestFocusCallback;
import com.tencent.mobileqq.guild.audio.TRTCFocusManager;

public class GuildTRTCFocusApiImpl
  implements IGuildTRTCFocusApi
{
  public void onReleaseTRTCFocus(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener)
  {
    TRTCFocusManager.a().a(paramTRTCFocusListener);
  }
  
  public void requestTRTCFocus(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener, @NonNull IGuildTRTCFocusApi.TRTCRequestFocusCallback paramTRTCRequestFocusCallback, @Nullable Handler paramHandler)
  {
    TRTCFocusManager.a().a(paramTRTCFocusListener, paramTRTCRequestFocusCallback, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTRTCFocusApiImpl
 * JD-Core Version:    0.7.0.1
 */