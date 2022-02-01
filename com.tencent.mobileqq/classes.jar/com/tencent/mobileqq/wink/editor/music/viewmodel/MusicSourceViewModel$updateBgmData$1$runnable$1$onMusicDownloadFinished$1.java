package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MusicSourceViewModel$updateBgmData$1$runnable$1$onMusicDownloadFinished$1
  implements Runnable
{
  MusicSourceViewModel$updateBgmData$1$runnable$1$onMusicDownloadFinished$1(MusicSourceViewModel.updateBgmData.1.runnable.1 param1, WinkEditorMusicInfo paramWinkEditorMusicInfo, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    Object localObject;
    if (this.this$0.a.a.h() != null)
    {
      localObject = this.this$0.a.a.h();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if ((!((WinkEditorMusicInfo)localObject).a()) && (!this.a.a()))
      {
        localObject = this.this$0.a.a.h();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual(((WinkEditorMusicInfo)localObject).c(), this.a.c()))
        {
          i = 1;
          break label99;
        }
      }
    }
    int i = 0;
    label99:
    if (!this.b)
    {
      localObject = MusicSourceViewModel.a(this.this$0.a.a, this.a, this.b);
      if (localObject != null) {
        this.this$0.a.a.a().postValue(localObject);
      }
      if (i != 0) {
        this.this$0.a.a.j().postValue(Integer.valueOf(2131892038));
      }
    }
    else if (i != 0)
    {
      this.this$0.a.a.a(this.a, 50.0F, 50.0F, this.c);
      if (MusicSourceViewModel.b(this.this$0.a.a) != null) {
        this.this$0.a.a.b(this.a);
      }
      MusicSourceViewModel.a(this.this$0.a.a, (Intent)null);
      localObject = MusicSourceViewModel.a(this.this$0.a.a, this.a, this.b);
      if (localObject != null) {
        this.this$0.a.a.a().postValue(localObject);
      }
    }
    else
    {
      localObject = MusicSourceViewModel.a(this.this$0.a.a, this.a, this.b);
      if (localObject != null) {
        this.this$0.a.a.a().postValue(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.updateBgmData.1.runnable.1.onMusicDownloadFinished.1
 * JD-Core Version:    0.7.0.1
 */