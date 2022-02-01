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
    if ((StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter) == 5) && (StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter) != null) && ((StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter)).a()))
    {
      QQToast.a(StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter), HardCodeUtil.a(2131714912), 0).a();
    }
    else
    {
      StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
      int i = StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter).a;
      StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter);
      if (i == 2)
      {
        if (9 == StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter)) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        VasWebviewUtil.a("strangers_makefriend", "item_click", "", 0, "", (String)localObject);
      }
      else
      {
        if (9 == StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter)) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        VasWebviewUtil.a("friend_wall", "item_click", "", 0, "", (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.notifyDataSetChanged();
      StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
      StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, true);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter;
      ((StickyNoteVasAdapter)localObject).a(StickyNoteVasAdapter.a((StickyNoteVasAdapter)localObject), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.1
 * JD-Core Version:    0.7.0.1
 */