package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qphone.base.util.QLog;

class ConversationHongBaoV2$6
  implements IPreloadRes.OnDownloadCallback
{
  ConversationHongBaoV2$6(ConversationHongBaoV2 paramConversationHongBaoV2, String paramString, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)) && ((paramObject instanceof Bitmap)) && (this.c.a != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showShuaYiShuaTask progress nameBmp onDownloadCallback suc,url = ");
        localStringBuilder.append(paramString);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      paramString = (Bitmap)paramObject;
      this.c.a.setProgressNameBitmap(paramString, null, false);
      this.b.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.6
 * JD-Core Version:    0.7.0.1
 */