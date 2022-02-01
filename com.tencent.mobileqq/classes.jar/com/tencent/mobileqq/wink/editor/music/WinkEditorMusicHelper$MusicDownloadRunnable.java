package com.tencent.mobileqq.wink.editor.music;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class WinkEditorMusicHelper$MusicDownloadRunnable
  implements Runnable
{
  private AppRuntime a;
  private WinkEditorMusicInfo b;
  private String c;
  private String d;
  private WeakReference<WinkEditorMusicHelper.MusicDownloadCallback> e;
  
  public WinkEditorMusicHelper$MusicDownloadRunnable(@NonNull AppRuntime paramAppRuntime, @NonNull WinkEditorMusicInfo paramWinkEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @NonNull WinkEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    this.a = paramAppRuntime;
    this.b = paramWinkEditorMusicInfo;
    this.c = paramString1;
    this.d = paramString2;
    this.e = new WeakReference(paramMusicDownloadCallback);
  }
  
  public void run()
  {
    WinkEditorMusicHelper.a(this.a, this.b, this.c, this.d, (WinkEditorMusicHelper.MusicDownloadCallback)this.e.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */