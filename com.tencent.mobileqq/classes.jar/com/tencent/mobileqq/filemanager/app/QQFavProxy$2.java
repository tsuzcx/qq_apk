package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import atbt;
import atbv;
import java.util.HashSet;
import java.util.Iterator;

public class QQFavProxy$2
  implements Runnable
{
  public QQFavProxy$2(atbt paramatbt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = atbt.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atbv)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QQFavProxy.2
 * JD-Core Version:    0.7.0.1
 */