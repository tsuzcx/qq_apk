package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.NativeWebVideoCoverGetCallback;
import mqq.os.MqqHandler;

final class FastWebVideoItemUtils$1
  implements NativeWebVideoCoverGetCallback
{
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString1))) {
      ThreadManager.getUIHandler().post(new FastWebVideoItemUtils.1.1(this, paramString2, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebVideoItemUtils.1
 * JD-Core Version:    0.7.0.1
 */