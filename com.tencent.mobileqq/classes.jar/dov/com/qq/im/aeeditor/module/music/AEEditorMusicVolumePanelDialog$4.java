package dov.com.qq.im.aeeditor.module.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorMusicVolumePanelDialog$4
  implements View.OnClickListener
{
  AEEditorMusicVolumePanelDialog$4(AEEditorMusicVolumePanelDialog paramAEEditorMusicVolumePanelDialog) {}
  
  public void onClick(View paramView)
  {
    if (!AEEditorMusicVolumePanelDialog.b(this.a).isEnabled()) {
      AEEditorMusicVolumePanelDialog.a(this.a, 2131689752);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicVolumePanelDialog.4
 * JD-Core Version:    0.7.0.1
 */