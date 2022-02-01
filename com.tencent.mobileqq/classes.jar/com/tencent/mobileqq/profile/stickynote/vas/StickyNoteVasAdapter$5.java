package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class StickyNoteVasAdapter$5
  implements BusinessObserver
{
  StickyNoteVasAdapter$5(StickyNoteVasAdapter paramStickyNoteVasAdapter, StickyNoteVasAdapter.AuthListener paramAuthListener) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StickyNoteVasAdapter.AuthListener localAuthListener = this.a;
    if (localAuthListener != null)
    {
      boolean bool = paramObject instanceof UniBusiGetOneItemWithCheckRsp;
      paramBoolean = false;
      if (bool)
      {
        paramObject = (UniBusiGetOneItemWithCheckRsp)paramObject;
        if (paramObject.ret == 0) {
          paramBoolean = true;
        }
        localAuthListener.a(paramBoolean, paramObject);
        return;
      }
      localAuthListener.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.5
 * JD-Core Version:    0.7.0.1
 */