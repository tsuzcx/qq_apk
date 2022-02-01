package com.tencent.mobileqq.emoticonview;

public abstract class AbsEmoticonPanelLifecycleObserver
  extends AbstractEmoticonPanelHelper<IEmoticonPanelController>
{
  int providerID = -1;
  
  public AbsEmoticonPanelLifecycleObserver(int paramInt)
  {
    super(null);
    this.providerID = paramInt;
  }
  
  void setPanelController(IEmoticonPanelController paramIEmoticonPanelController)
  {
    this.mPanelController = paramIEmoticonPanelController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */