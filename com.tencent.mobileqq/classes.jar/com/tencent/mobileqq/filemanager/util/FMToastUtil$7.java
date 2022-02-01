package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class FMToastUtil$7
  implements Runnable
{
  FMToastUtil$7(int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, this.a, 0).b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.7
 * JD-Core Version:    0.7.0.1
 */