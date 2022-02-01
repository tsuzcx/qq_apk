package com.tencent.mobileqq.filemanager.util;

import audr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$5
  implements Runnable
{
  public FMToastUtil$5(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.a, 1).b(audr.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.5
 * JD-Core Version:    0.7.0.1
 */