package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import atke;
import atkg;
import java.util.HashSet;
import java.util.Iterator;

public class QQFavProxy$2
  implements Runnable
{
  public QQFavProxy$2(atke paramatke, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = atke.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atkg)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QQFavProxy.2
 * JD-Core Version:    0.7.0.1
 */