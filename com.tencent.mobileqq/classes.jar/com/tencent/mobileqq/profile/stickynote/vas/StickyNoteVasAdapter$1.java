package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
      QQToast.a(StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter), HardCodeUtil.a(2131714989), 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter).a;
    StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter);
    if (i == 2)
    {
      if (9 == StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.notifyDataSetChanged();
        StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
        StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter, true);
        this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a(StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a);
        break;
      }
    }
    if (9 == StickyNoteVasAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.1
 * JD-Core Version:    0.7.0.1
 */