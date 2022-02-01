package com.tencent.mobileqq.msgforward;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import java.util.List;

class AIOShareActionSheet$10
  implements ISaveCallBack
{
  AIOShareActionSheet$10(AIOShareActionSheet paramAIOShareActionSheet, FileSaveDialog paramFileSaveDialog, MultiRichMediaSaveManager paramMultiRichMediaSaveManager, List paramList) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(new AIOShareActionSheet.10.1(this));
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet) != null) && (AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet).t())) {
      switch (paramFileSaveResult.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
      }
      if (AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet) != null) {
        AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet).a(false, null, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
      return;
      FileSaveToastUtils.a(AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet));
      continue;
      FileSaveToastUtils.b(AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet));
      continue;
      FileSaveToastUtils.c(AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet));
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(paramInt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    if (AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet) != null) {
      AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet).a(false, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(AIOShareActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet), this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.10
 * JD-Core Version:    0.7.0.1
 */