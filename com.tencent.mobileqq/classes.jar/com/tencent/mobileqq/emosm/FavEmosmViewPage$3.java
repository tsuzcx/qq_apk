package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class FavEmosmViewPage$3
  implements MultiEmotionSaveManager.ISaveCallBack
{
  FavEmosmViewPage$3(FavEmosmViewPage paramFavEmosmViewPage, FileSaveDialog paramFileSaveDialog) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage);
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(paramInt);
  }
  
  public void a(EmotionSaveResult paramEmotionSaveResult)
  {
    if ((paramEmotionSaveResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.isFinishing())) {
      switch (paramEmotionSaveResult.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
      }
      FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage);
      FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getString(2131718661), 0).a();
      continue;
      if (paramEmotionSaveResult.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getString(2131718652), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.getString(2131718656), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(0);
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(new FavEmosmViewPage.3.1(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.3
 * JD-Core Version:    0.7.0.1
 */