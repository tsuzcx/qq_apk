package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qphone.base.util.QLog;

class ConversationHongBaoV2$5
  implements IPreloadRes.OnDownloadCallback
{
  ConversationHongBaoV2$5(ConversationHongBaoV2 paramConversationHongBaoV2, String paramString, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)) && ((paramObject instanceof Bitmap)) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showShuaYiShuaTask progressLogo onDownloadCallback suc,url = " + paramString);
      }
      paramString = (Bitmap)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a.setProgressLogo(paramString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.5
 * JD-Core Version:    0.7.0.1
 */