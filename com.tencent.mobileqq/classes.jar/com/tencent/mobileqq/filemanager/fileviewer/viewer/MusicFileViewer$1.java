package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class MusicFileViewer$1
  implements Runnable
{
  MusicFileViewer$1(MusicFileViewer paramMusicFileViewer, String paramString) {}
  
  public void run()
  {
    MusicFileViewer.a(this.this$0).setText(FileManagerUtil.a(this.a, false, MusicFileViewer.a(this.this$0).getMeasuredWidth(), MusicFileViewer.a(this.this$0).getPaint(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer.1
 * JD-Core Version:    0.7.0.1
 */