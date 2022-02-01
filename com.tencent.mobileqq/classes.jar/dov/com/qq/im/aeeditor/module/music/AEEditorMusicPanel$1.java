package dov.com.qq.im.aeeditor.module.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;

class AEEditorMusicPanel$1
  implements View.OnClickListener
{
  AEEditorMusicPanel$1(AEEditorMusicPanel paramAEEditorMusicPanel) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (!AEEditorMusicPanel.a(this.a).isChecked())
    {
      bool = true;
      AEEditorMusicPanel.a(this.a).setChecked(bool);
      AEEditorMusicPanel.b(this.a).setChecked(bool);
      if (AEEditorMusicPanel.a(this.a) != null) {
        AEEditorMusicPanel.a(this.a).i(bool);
      }
      if (!bool) {
        break label83;
      }
    }
    label83:
    for (int i = 3;; i = 4)
    {
      AEReportUtils.b(i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanel.1
 * JD-Core Version:    0.7.0.1
 */