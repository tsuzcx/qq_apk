package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;

class SimpleFileViewer$3$1
  implements ITencentDocConvertABTestUtil.DocClickTypeRunnable
{
  SimpleFileViewer$3$1(SimpleFileViewer.3 param3, QQAppInterface paramQQAppInterface) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      SimpleFileViewer.a(this.b.this$0, this.a, this.b.a);
      return;
    }
    TeamWorkConvertUtils.a(this.a, this.b.this$0.c, "FileBrowserViewBase", this.b.a, new SimpleFileViewer.3.1.1(this));
  }
  
  public void a(ImageView paramImageView)
  {
    SimpleFileViewer.b(this.b.this$0, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.3.1
 * JD-Core Version:    0.7.0.1
 */