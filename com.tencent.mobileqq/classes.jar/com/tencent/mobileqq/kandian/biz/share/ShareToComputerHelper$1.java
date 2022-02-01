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
        QQToast.makeText(BaseApplicationImpl.getApplication(), 2, 2131916258, 0).show(paramLong.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131916242, 0).show(paramLong.getResources().getDimensionPixelSize(2131299920));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ShareToComputerHelper.1
 * JD-Core Version:    0.7.0.1
 */