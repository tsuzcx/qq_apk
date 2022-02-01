package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;

final class SharePlugin$1
  implements Runnable
{
  SharePlugin$1(int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    String str;
    if ((i & 0x20) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(32));
    } else if ((i & 0x10) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(16));
    } else if ((i & 0x8) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(8));
    } else if ((i & 0x4) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(4));
    } else if ((i & 0x2) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(2));
    } else if ((i & 0x1) != 0) {
      str = (String)SharePlugin.a().get(Integer.valueOf(1));
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str)) {
      QQToast.a(BaseApplicationImpl.getContext(), str, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.SharePlugin.1
 * JD-Core Version:    0.7.0.1
 */