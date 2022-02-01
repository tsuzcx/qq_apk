package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadCallback;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$updateBgmData$1$runnable$1", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicHelper$MusicDownloadCallback;", "onMusicDownloadFinished", "", "editorMusicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "succeeded", "", "localPath", "", "onMusicDownloadUpdate", "progress", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSourceViewModel$updateBgmData$1$runnable$1
  implements WinkEditorMusicHelper.MusicDownloadCallback
{
  public void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "editorMusicInfo");
    ThreadManager.getUIHandler().post((Runnable)new MusicSourceViewModel.updateBgmData.1.runnable.1.onMusicDownloadUpdate.1(this, paramInt, paramWinkEditorMusicInfo));
  }
  
  public void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "editorMusicInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    ThreadManager.getUIHandler().post((Runnable)new MusicSourceViewModel.updateBgmData.1.runnable.1.onMusicDownloadFinished.1(this, paramWinkEditorMusicInfo, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.updateBgmData.1.runnable.1
 * JD-Core Version:    0.7.0.1
 */