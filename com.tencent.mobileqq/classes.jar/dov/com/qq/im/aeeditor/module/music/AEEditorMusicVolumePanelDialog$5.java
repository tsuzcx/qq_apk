package dov.com.qq.im.aeeditor.module.music;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import dov.com.qq.im.AEReportUtils;

class AEEditorMusicVolumePanelDialog$5
  implements SeekBar.OnSeekBarChangeListener
{
  AEEditorMusicVolumePanelDialog$5(AEEditorMusicVolumePanelDialog paramAEEditorMusicVolumePanelDialog) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEEditorMusicVolumePanelDialog.a(this.a) != null) {
      AEEditorMusicVolumePanelDialog.a(this.a).a(paramInt / 100.0F);
    }
    if (paramBoolean) {
      AEEditorMusicVolumePanelDialog.a(this.a, paramInt);
    }
    AEReportUtils.b(7);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicVolumePanelDialog.5
 * JD-Core Version:    0.7.0.1
 */