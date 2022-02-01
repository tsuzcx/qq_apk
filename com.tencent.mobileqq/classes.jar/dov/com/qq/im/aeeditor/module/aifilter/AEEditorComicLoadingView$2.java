package dov.com.qq.im.aeeditor.module.aifilter;

import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import bpes;

public class AEEditorComicLoadingView$2
  implements Runnable
{
  AEEditorComicLoadingView$2(AEEditorComicLoadingView paramAEEditorComicLoadingView) {}
  
  public void run()
  {
    this.this$0.a.animate().alpha(0.0F).setDuration(500L).setListener(new bpes(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView.2
 * JD-Core Version:    0.7.0.1
 */