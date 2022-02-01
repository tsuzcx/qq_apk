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
    if (StickyNoteVasAdapter.e(this.a) == null) {
      return;
    }
    if (!paramBoolean)
    {
      if ((paramUniBusiGetOneItemWithCheckRsp != null) && (paramUniBusiGetOneItemWithCheckRsp.stDetail != null))
      {
        if (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId == StickyNoteVasAdapter.e(this.a).itemId)
        {
          if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
          {
            StickyNoteVasAdapter.a(this.a, false);
            this.a.b();
            return;
          }
          if (StickyNoteVasAdapter.f(this.a))
          {
            paramUniBusiGetOneItemWithCheckRsp = this.a;
            StickyNoteVasAdapter.a(paramUniBusiGetOneItemWithCheckRsp, StickyNoteVasAdapter.c(paramUniBusiGetOneItemWithCheckRsp), StickyNoteVasAdapter.e(this.a).stAidInfo.androidAid, StickyNoteVasAdapter.e(this.a).stAidInfo.payType, StickyNoteVasAdapter.e(this.a).stAidInfo.errMsg, StickyNoteVasAdapter.e(this.a).stAidInfo.month);
          }
        }
      }
      else
      {
        StickyNoteVasAdapter.a(this.a, false);
        QQToast.makeText(StickyNoteVasAdapter.c(this.a), HardCodeUtil.a(2131912406), 0).show();
        StickyNoteVasAdapter.a(this.a, null);
        StickyNoteVasAdapter.a(this.a, -1);
      }
    }
    else {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.2
 * JD-Core Version:    0.7.0.1
 */