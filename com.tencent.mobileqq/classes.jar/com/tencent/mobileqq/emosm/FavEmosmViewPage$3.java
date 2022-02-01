package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(paramInt);
  }
  
  public void a(EmotionSaveResult paramEmotionSaveResult)
  {
    if ((paramEmotionSaveResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.isFinishing()))
    {
      int i = paramEmotionSaveResult.a;
      if (i != -1)
      {
        if (i == 0) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131718379), 0).a();
        }
      }
      else if (paramEmotionSaveResult.b == 10006) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131718370), 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getString(2131718374), 0).a();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramEmotionSaveResult = new StringBuilder();
      paramEmotionSaveResult.append("onSaveComplete ");
      paramEmotionSaveResult.append(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.isFinishing());
      QLog.i("MultiEmotionSaveManager", 2, paramEmotionSaveResult.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a().b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.3
 * JD-Core Version:    0.7.0.1
 */