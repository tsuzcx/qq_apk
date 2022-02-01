package com.tencent.mobileqq.guild.audio.data;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/data/AudioRoomLiveData;", "", "()V", "closeDialog", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/audio/data/DIALOG_STATUS;", "getCloseDialog", "()Landroidx/lifecycle/MutableLiveData;", "hasOtherDialogShowing", "", "getHasOtherDialogShowing", "isAudioRoomEmpty", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomLiveData
{
  public static final AudioRoomLiveData a = new AudioRoomLiveData();
  @NotNull
  private static final MutableLiveData<DIALOG_STATUS> b = new MutableLiveData();
  @NotNull
  private static final MutableLiveData<Boolean> c = new MutableLiveData();
  @NotNull
  private static final MutableLiveData<Boolean> d = new MutableLiveData();
  
  @NotNull
  public final MutableLiveData<DIALOG_STATUS> a()
  {
    return b;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> b()
  {
    return c;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> c()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData
 * JD-Core Version:    0.7.0.1
 */