package dov.com.qq.im.aeeditor.module.clip.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorMvClipMenu$2
  implements View.OnClickListener
{
  AEEditorMvClipMenu$2(AEEditorMvClipMenu paramAEEditorMvClipMenu) {}
  
  public void onClick(View paramView)
  {
    if (AEEditorMvClipMenu.a(this.a) != null) {
      AEEditorMvClipMenu.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu.2
 * JD-Core Version:    0.7.0.1
 */