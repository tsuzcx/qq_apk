package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;

class NoteCardProteusItem$4
  implements ViewBase.OnClickListener
{
  NoteCardProteusItem$4(NoteCardProteusItem paramNoteCardProteusItem, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = BaseApplicationImpl.getContext();
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (paramViewBase != null) && (paramViewBase.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (ReadInJoyNoteCardUtil.a() == 1) && ((this.a.getContext() instanceof Activity))) {
      NoteCardProteusItem.a(this.b, (Activity)this.a.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem.4
 * JD-Core Version:    0.7.0.1
 */