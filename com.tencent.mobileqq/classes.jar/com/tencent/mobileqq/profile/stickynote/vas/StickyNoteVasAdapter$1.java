package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StickyNoteVasAdapter$1
  implements View.OnClickListener
{
  StickyNoteVasAdapter$1(StickyNoteVasAdapter paramStickyNoteVasAdapter, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((StickyNoteVasAdapter.a(this.b) == 5) && (StickyNoteVasAdapter.b(this.b) != null) && ((StickyNoteVasAdapter.b(this.b) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)StickyNoteVasAdapter.b(this.b)).g()))
    {
      QQToast.makeText(StickyNoteVasAdapter.c(this.b), HardCodeUtil.a(2131912410), 0).show();
    }
    else
    {
      StickyNoteVasAdapter.a(this.b, this.a.itemId);
      int i = StickyNoteVasAdapter.d(this.b).b;
      StickyNoteVasAdapter.d(this.b);
      if (i == 2)
      {
        if (9 == StickyNoteVasAdapter.a(this.b)) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        VasWebviewUtil.a("strangers_makefriend", "item_click", "", 0, "", (String)localObject);
      }
      else
      {
        if (9 == StickyNoteVasAdapter.a(this.b)) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        VasWebviewUtil.a("friend_wall", "item_click", "", 0, "", (String)localObject);
      }
      this.b.notifyDataSetChanged();
      StickyNoteVasAdapter.a(this.b, this.a);
      StickyNoteVasAdapter.a(this.b, true);
      Object localObject = this.b;
      ((StickyNoteVasAdapter)localObject).a(StickyNoteVasAdapter.a((StickyNoteVasAdapter)localObject), this.a.itemId, this.a.feeType, this.b.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.1
 * JD-Core Version:    0.7.0.1
 */