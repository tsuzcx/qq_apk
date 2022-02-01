package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import asfi;
import asfk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelFavHelper$2
  implements Runnable
{
  EmoticonPanelFavHelper$2(EmoticonPanelFavHelper paramEmoticonPanelFavHelper, QQAppInterface paramQQAppInterface, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    if (this.val$app == null) {
      return;
    }
    if (!this.val$isDelOverflow)
    {
      asfk localasfk = (asfk)this.val$app.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
      List localList1 = localasfk.a();
      if ((localList1 != null) && (localList1.size() > asfi.a))
      {
        List localList2 = localList1.subList(0, localList1.size() - asfi.a);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
        }
        localasfk.b(localList2);
        this.this$0.updateFavEmoticonPanel();
      }
      this.val$sp.edit().putBoolean("local_overflow" + this.val$uin, true).apply();
      this.this$0.startSyncFavEmoticon();
      return;
    }
    this.this$0.startSyncFavEmoticon();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2
 * JD-Core Version:    0.7.0.1
 */