package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import bhhz;
import bhia;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public final class SyncLoadTask$1
  implements Runnable
{
  public SyncLoadTask$1(ArrayList paramArrayList1, Resources paramResources, bhia parambhia, ArrayList paramArrayList2) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bhhz localbhhz = (bhhz)localIterator.next();
      if (localbhhz.runOnSubThread(this.jdField_a_of_type_AndroidContentResResources))
      {
        localArrayList1.add(localbhhz);
      }
      else
      {
        localbhhz.clean();
        localArrayList2.add(localbhhz);
      }
    }
    ThreadManager.getUIHandler().post(new SyncLoadTask.1.1(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1
 * JD-Core Version:    0.7.0.1
 */