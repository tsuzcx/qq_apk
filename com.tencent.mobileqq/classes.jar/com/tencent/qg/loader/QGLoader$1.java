package com.tencent.qg.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class QGLoader$1
  implements Runnable
{
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getApplication(), this.a, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.loader.QGLoader.1
 * JD-Core Version:    0.7.0.1
 */