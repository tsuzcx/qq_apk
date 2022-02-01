package com.tencent.mobileqq.filebrowser.view;

import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;

class DocFileBrowserView$5$1
  implements ITencentDocConvertABTestUtil.DocClickTypeRunnable
{
  DocFileBrowserView$5$1(DocFileBrowserView.5 param5, AppInterface paramAppInterface) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      DocFileBrowserView.a(this.b.this$0, this.a, this.b.a);
      return;
    }
    TeamWorkConvertUtils.a(this.a, this.b.this$0.e, "FileBrowserViewBase", this.b.a, new DocFileBrowserView.5.1.1(this));
  }
  
  public void a(ImageView paramImageView)
  {
    DocFileBrowserView.b(this.b.this$0, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.5.1
 * JD-Core Version:    0.7.0.1
 */