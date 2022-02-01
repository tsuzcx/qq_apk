package com.tencent.mobileqq.filebrowser.view;

import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;

class MusicFileBrowserView$1
  implements Runnable
{
  MusicFileBrowserView$1(MusicFileBrowserView paramMusicFileBrowserView, String paramString) {}
  
  public void run()
  {
    MusicFileBrowserView.a(this.this$0).setText(QQFileManagerUtil.a(this.a, false, MusicFileBrowserView.a(this.this$0).getMeasuredWidth(), MusicFileBrowserView.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView.1
 * JD-Core Version:    0.7.0.1
 */