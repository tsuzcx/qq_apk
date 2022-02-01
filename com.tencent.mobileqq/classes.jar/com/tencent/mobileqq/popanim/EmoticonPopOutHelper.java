package com.tencent.mobileqq.popanim;

import com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import mqq.util.WeakReference;

public class EmoticonPopOutHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
{
  private WeakReference<EmoticonPopOutHelper.PopOutHelpListener> a;
  
  public EmoticonPopOutHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void a(EmoticonPopOutHelper.PopOutHelpListener paramPopOutHelpListener)
  {
    this.a = new WeakReference(paramPopOutHelpListener);
  }
  
  public String getTag()
  {
    return "EmoticonPopOutHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 4 };
  }
  
  public void onHide(boolean paramBoolean)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((EmoticonPopOutHelper.PopOutHelpListener)this.a.get()).b();
    }
  }
  
  public void onPause()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((EmoticonPopOutHelper.PopOutHelpListener)this.a.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.EmoticonPopOutHelper
 * JD-Core Version:    0.7.0.1
 */