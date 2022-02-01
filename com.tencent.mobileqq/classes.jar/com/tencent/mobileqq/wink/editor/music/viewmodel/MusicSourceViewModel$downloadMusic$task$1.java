package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadCallback;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$downloadMusic$task$1", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicHelper$MusicDownloadCallback;", "onMusicDownloadFinished", "", "editorMusicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "succeeded", "", "localPath", "", "onMusicDownloadUpdate", "progress", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSourceViewModel$downloadMusic$task$1
  implements WinkEditorMusicHelper.MusicDownloadCallback
{
  public void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "editorMusicInfo");
    paramWinkEditorMusicInfo.d = 1;
    paramWinkEditorMusicInfo.e = paramInt;
    WinkEditorMusicHelper.MusicDownloadCallback localMusicDownloadCallback = this.b;
    if (localMusicDownloadCallback != null) {
      localMusicDownloadCallback.a(paramWinkEditorMusicInfo, paramInt);
    }
    this.c.postValue(paramWinkEditorMusicInfo);
  }
  
  public void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "editorMusicInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    paramWinkEditorMusicInfo.d = i;
    paramWinkEditorMusicInfo.e = 0;
    WinkEditorMusicHelper.MusicDownloadCallback localMusicDownloadCallback = this.b;
    if (localMusicDownloadCallback != null) {
      localMusicDownloadCallback.a(paramWinkEditorMusicInfo, paramBoolean, paramString);
    }
    this.c.postValue(paramWinkEditorMusicInfo);
    MusicSourceViewModel.a(this.a).remove(this.d.c());
    if (!paramBoolean) {
      this.a.j().postValue(Integer.valueOf(2131892038));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.downloadMusic.task.1
 * JD-Core Version:    0.7.0.1
 */