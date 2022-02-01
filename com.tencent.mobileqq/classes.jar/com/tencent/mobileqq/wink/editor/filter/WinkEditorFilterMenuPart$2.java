package com.tencent.mobileqq.wink.editor.filter;

import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.StartPointSeekBar.OnSeekBarChangeListener;

class WinkEditorFilterMenuPart$2
  implements StartPointSeekBar.OnSeekBarChangeListener
{
  WinkEditorFilterMenuPart$2(WinkEditorFilterMenuPart paramWinkEditorFilterMenuPart) {}
  
  public void a(StartPointSeekBar paramStartPointSeekBar) {}
  
  public void a(StartPointSeekBar paramStartPointSeekBar, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Math.round(paramInt));
    localStringBuilder.append("%");
    StartPointSeekBar.a(paramStartPointSeekBar, localStringBuilder.toString(), WinkEditorFilterMenuPart.c(this.a));
    WinkEditorFilterMenuPart.d(this.a).a(paramStartPointSeekBar.getProgress() / 100.0F);
  }
  
  public void b(StartPointSeekBar paramStartPointSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart.2
 * JD-Core Version:    0.7.0.1
 */