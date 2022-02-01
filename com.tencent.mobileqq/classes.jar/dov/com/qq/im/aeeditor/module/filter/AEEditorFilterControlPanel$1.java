package dov.com.qq.im.aeeditor.module.filter;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorFilterControlPanel$1
  implements SeekBar.OnSeekBarChangeListener
{
  AEEditorFilterControlPanel$1(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramSeekBar.getVisibility() == 0))
    {
      if (AEEditorFilterControlPanel.a(this.a) != null) {
        AEEditorFilterControlPanel.a(this.a).setText(paramInt + "%");
      }
      if (AEEditorFilterControlPanel.a(this.a) != null) {
        AEEditorFilterControlPanel.a(this.a).a(this.a.a(), paramInt / 100.0F);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(0);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).x();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(4);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).y();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.1
 * JD-Core Version:    0.7.0.1
 */