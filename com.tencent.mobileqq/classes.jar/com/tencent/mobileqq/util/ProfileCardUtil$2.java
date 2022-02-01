package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;

final class ProfileCardUtil$2
  implements Runnable
{
  public void run()
  {
    String str1 = CardHandler.a(this.a, CardHandler.b(BaseApplication.getContext()));
    int i = CardHandler.c(BaseApplication.getContext());
    String str2 = CardHandler.a(this.a, i);
    ImageUtil.a(this.b, str1);
    ImageUtil.a(this.b, str2, i, i);
    FileUtils.delete(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.2
 * JD-Core Version:    0.7.0.1
 */