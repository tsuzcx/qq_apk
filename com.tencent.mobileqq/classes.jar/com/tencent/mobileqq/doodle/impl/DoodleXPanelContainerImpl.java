package com.tencent.mobileqq.doodle.impl;

import com.tencent.mobileqq.doodle.IDoodleXPanelContainer;
import com.tencent.widget.XPanelContainer;

public class DoodleXPanelContainerImpl
  implements IDoodleXPanelContainer
{
  public int getExternalPanelheight()
  {
    return XPanelContainer.a;
  }
  
  public int getXPanelContainerNONE()
  {
    return 0;
  }
  
  public void setExternalPanelheight(int paramInt)
  {
    XPanelContainer.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.impl.DoodleXPanelContainerImpl
 * JD-Core Version:    0.7.0.1
 */