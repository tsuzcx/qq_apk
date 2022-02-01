package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MusicSourceViewModel$updateBgmData$1$runnable$1$onMusicDownloadUpdate$1
  implements Runnable
{
  MusicSourceViewModel$updateBgmData$1$runnable$1$onMusicDownloadUpdate$1(MusicSourceViewModel.updateBgmData.1.runnable.1 param1, int paramInt, WinkEditorMusicInfo paramWinkEditorMusicInfo) {}
  
  public final void run()
  {
    int j = this.a;
    int i = j;
    if (j > 100) {
      i = 100;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    List localList = MusicSourceViewModel.a(this.this$0.a.a, this.b, 1, j);
    if (localList != null) {
      this.this$0.a.a.a().postValue(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.updateBgmData.1.runnable.1.onMusicDownloadUpdate.1
 * JD-Core Version:    0.7.0.1
 */