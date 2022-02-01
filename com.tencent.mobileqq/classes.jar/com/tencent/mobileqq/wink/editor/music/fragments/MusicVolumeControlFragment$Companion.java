package com.tencent.mobileqq.wink.editor.music.fragments;

import android.os.Bundle;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$Companion;", "", "()V", "KEY_SCENE", "", "SEEK_BAR_MAX", "", "SEEK_BAR_MIN", "TAG", "kotlin.jvm.PlatformType", "newInstance", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "scene", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicVolumeControlFragment$Companion
{
  @NotNull
  public final MusicVolumeControlFragment a(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    MusicVolumeControlFragment localMusicVolumeControlFragment = new MusicVolumeControlFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("scene", (Serializable)paramScene);
    localMusicVolumeControlFragment.setArguments(localBundle);
    return localMusicVolumeControlFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.Companion
 * JD-Core Version:    0.7.0.1
 */