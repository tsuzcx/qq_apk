package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class StickyNoteVasAdapter$2
  implements StickyNoteVasAdapter.AuthListener
{
  StickyNoteVasAdapter$2(StickyNoteVasAdapter paramStickyNoteVasAdapter) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (StickyNoteVasAdapter.a(this.a) == null) {
      return;
    }
    if (!paramBoolean)
    {
      if ((paramUniBusiGetOneItemWithCheckRsp != null) && (paramUniBusiGetOneItemWithCheckRsp.stDetail != null))
      {
        if (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId == StickyNoteVasAdapter.a(this.a).itemId)
        {
          if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
          {
            StickyNoteVasAdapter.a(this.a, false);
            this.a.b();
            return;
          }
          if (StickyNoteVasAdapter.a(this.a))
          {
            paramUniBusiGetOneItemWithCheckRsp = this.a;
            StickyNoteVasAdapter.a(paramUniBusiGetOneItemWithCheckRsp, StickyNoteVasAdapter.a(paramUniBusiGetOneItemWithCheckRsp), StickyNoteVasAdapter.a(this.a).stAidInfo.androidAid, StickyNoteVasAdapter.a(this.a).stAidInfo.payType, StickyNoteVasAdapter.a(this.a).stAidInfo.errMsg, StickyNoteVasAdapter.a(this.a).stAidInfo.month);
          }
        }
      }
      else
      {
        StickyNoteVasAdapter.a(this.a, false);
        QQToast.a(StickyNoteVasAdapter.a(this.a), HardCodeUtil.a(2131714908), 0).a();
        StickyNoteVasAdapter.a(this.a, null);
        StickyNoteVasAdapter.a(this.a, -1);
      }
    }
    else {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.2
 * JD-Core Version:    0.7.0.1
 */