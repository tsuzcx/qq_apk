package com.tencent.mobileqq.search.rich;

import aysi;
import com.tencent.qphone.base.util.QLog;

public class ArkNodeContainer$1
  implements Runnable
{
  public ArkNodeContainer$1(aysi paramaysi, String paramString) {}
  
  public void run()
  {
    this.this$0.a.getAppFromLocal = true;
    this.this$0.a.endOfGetApp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
    }
    this.this$0.a(this.a, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeContainer.1
 * JD-Core Version:    0.7.0.1
 */