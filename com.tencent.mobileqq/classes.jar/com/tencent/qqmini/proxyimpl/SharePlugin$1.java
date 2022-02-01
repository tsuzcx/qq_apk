package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bkqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;

public final class SharePlugin$1
  implements Runnable
{
  public SharePlugin$1(int paramInt) {}
  
  public void run()
  {
    String str = null;
    if ((this.a & 0x20) != 0) {
      str = (String)bkqy.a().get(Integer.valueOf(32));
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        QQToast.a(BaseApplicationImpl.getContext(), str, 1).a();
      }
      return;
      if ((this.a & 0x10) != 0) {
        str = (String)bkqy.a().get(Integer.valueOf(16));
      } else if ((this.a & 0x8) != 0) {
        str = (String)bkqy.a().get(Integer.valueOf(8));
      } else if ((this.a & 0x4) != 0) {
        str = (String)bkqy.a().get(Integer.valueOf(4));
      } else if ((this.a & 0x2) != 0) {
        str = (String)bkqy.a().get(Integer.valueOf(2));
      } else if ((this.a & 0x1) != 0) {
        str = (String)bkqy.a().get(Integer.valueOf(1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.SharePlugin.1
 * JD-Core Version:    0.7.0.1
 */