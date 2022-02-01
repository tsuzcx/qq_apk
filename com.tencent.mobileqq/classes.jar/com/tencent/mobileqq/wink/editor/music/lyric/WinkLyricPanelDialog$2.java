package com.tencent.mobileqq.wink.editor.music.lyric;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout.OnDragCallback;

class WinkLyricPanelDialog$2
  implements MoreLyricLayout.OnDragCallback
{
  WinkLyricPanelDialog$2(WinkLyricPanelDialog paramWinkLyricPanelDialog) {}
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = WinkLyricPanelDialog.a(this.a);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localRelativeLayout.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.2
 * JD-Core Version:    0.7.0.1
 */