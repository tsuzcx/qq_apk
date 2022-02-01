package dov.com.qq.im.aeeditor.module.music;

import android.graphics.Color;
import android.widget.FrameLayout;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout.LyricBackgroundEffect;

class AEEditorLyricPanelDialog$2
  implements MoreLyricLayout.LyricBackgroundEffect
{
  AEEditorLyricPanelDialog$2(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void a(float paramFloat)
  {
    AEEditorLyricPanelDialog.a(this.a).setAlpha(1.0F - paramFloat);
    AEEditorLyricPanelDialog.a(this.a).setBackgroundColor(Color.argb((int)(255.0F * paramFloat * 0.7F), 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.2
 * JD-Core Version:    0.7.0.1
 */