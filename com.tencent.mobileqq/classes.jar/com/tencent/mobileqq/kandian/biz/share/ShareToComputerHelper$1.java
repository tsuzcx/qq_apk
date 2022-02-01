package com.tencent.mobileqq.kandian.biz.share;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.widget.QQToast;

class ShareToComputerHelper$1
  extends DataLineObserver
{
  ShareToComputerHelper$1(ShareToComputerHelper paramShareToComputerHelper) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(ShareToComputerHelper.a(this.a))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131718752, 0).b(paramLong.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131718739, 0).b(paramLong.getResources().getDimensionPixelSize(2131299168));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ShareToComputerHelper.1
 * JD-Core Version:    0.7.0.1
 */