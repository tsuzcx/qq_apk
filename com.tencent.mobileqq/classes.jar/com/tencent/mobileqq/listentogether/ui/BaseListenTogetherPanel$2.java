package com.tencent.mobileqq.listentogether.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BaseListenTogetherPanel$2
  extends ListenTogetherObserver
{
  BaseListenTogetherPanel$2(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  protected void a(int paramInt, String paramString)
  {
    QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.a.b) }));
    if ((this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int == paramInt))
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
        return;
      }
      paramString = ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(paramInt, paramString);
      if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.b != 3))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.c != 2)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693661, 0).a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.b == 4)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693663, 0).a();
          return;
        }
        MusicInfo localMusicInfo = paramString.a();
        ListenTogetherPlayFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, localMusicInfo, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Boolean, null);
        return;
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693659, 0).a();
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    BaseListenTogetherPanel.a(this.a, paramInt, paramString1, paramString2);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.a.a(paramInt, paramString, paramBoolean);
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    this.a.a(paramListenTogetherSession);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramString, paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if ((paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString)) && (!paramBoolean))
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693665);
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, 0).a();
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  protected void h(int paramInt, String paramString)
  {
    this.a.b(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.2
 * JD-Core Version:    0.7.0.1
 */