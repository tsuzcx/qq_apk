package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;

public class AIOEmoticonPanelServiceImpl
  implements IAIOEmoticonPanelService
{
  public void destroyViewPool() {}
  
  public void removeStickerMask(View paramView)
  {
    if ((paramView instanceof EmoticonMainPanel))
    {
      paramView = (EmoticonMainPanel)paramView;
      paramView.removeView(paramView.stickerMaskLayout);
    }
  }
  
  public void setOpenStartTime(long paramLong)
  {
    EmoticonMainPanel.sOpenStartTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.AIOEmoticonPanelServiceImpl
 * JD-Core Version:    0.7.0.1
 */