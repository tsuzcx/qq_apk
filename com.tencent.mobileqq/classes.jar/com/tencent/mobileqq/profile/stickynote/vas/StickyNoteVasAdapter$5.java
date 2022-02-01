package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class StickyNoteVasAdapter$5
  implements BusinessObserver
{
  StickyNoteVasAdapter$5(StickyNoteVasAdapter paramStickyNoteVasAdapter, StickyNoteVasAdapter.AuthListener paramAuthListener) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StickyNoteVasAdapter.AuthListener localAuthListener;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localAuthListener = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAuthListener.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.5
 * JD-Core Version:    0.7.0.1
 */