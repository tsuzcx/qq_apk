package com.tencent.mobileqq.filemanager.app;

import asej;
import aseo;
import aseq;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.HashMap;
import java.util.List;

public class QFileAppStorePromoteManager$FetchAppInfoCallback$1
  implements Runnable
{
  public QFileAppStorePromoteManager$FetchAppInfoCallback$1(aseo paramaseo, int paramInt1, int paramInt2, List paramList) {}
  
  public void run()
  {
    aseq localaseq = (aseq)asej.a(this.jdField_a_of_type_Aseo.a).get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localaseq != null) {
      if (this.b != 0) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      localaseq.a(bool, (AppDetail)this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */