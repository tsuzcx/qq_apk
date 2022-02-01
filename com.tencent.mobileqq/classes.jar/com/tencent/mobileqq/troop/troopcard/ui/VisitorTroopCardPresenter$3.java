package com.tencent.mobileqq.troop.troopcard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardPresenter$3
  implements DecodeTaskCompletionListener
{
  VisitorTroopCardPresenter$3(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (VisitorTroopCardPresenter.b(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if (!TextUtils.isEmpty(paramString)) {
        VisitorTroopCardPresenter.b(this.a).b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.3
 * JD-Core Version:    0.7.0.1
 */