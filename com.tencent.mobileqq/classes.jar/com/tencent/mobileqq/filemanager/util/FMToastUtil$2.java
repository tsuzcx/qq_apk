package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class FMToastUtil$2
  implements Runnable
{
  FMToastUtil$2(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, this.a, 0).b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.2
 * JD-Core Version:    0.7.0.1
 */