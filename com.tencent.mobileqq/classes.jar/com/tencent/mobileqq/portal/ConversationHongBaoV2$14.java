package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

class ConversationHongBaoV2$14
  implements IPreloadRes.OnDownloadCallback
{
  ConversationHongBaoV2$14(ConversationHongBaoV2 paramConversationHongBaoV2, String paramString, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)) && ((paramObject instanceof Bitmap)) && (this.c.c != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPrepareCountDown pendantBmp onDownloadCallback suc,url = ");
        localStringBuilder.append(paramString);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      paramString = (Bitmap)paramObject;
      this.c.c.b(paramString);
      this.b.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.14
 * JD-Core Version:    0.7.0.1
 */