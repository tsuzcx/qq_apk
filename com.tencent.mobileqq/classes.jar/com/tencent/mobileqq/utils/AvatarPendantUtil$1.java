package com.tencent.mobileqq.utils;

import bdfp;
import bdug;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class AvatarPendantUtil$1
  implements Runnable
{
  public AvatarPendantUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bdfp.jdField_a_of_type_Boolean = false;
    do
    {
      synchronized (bdfp.jdField_a_of_type_JavaUtilArrayList)
      {
        String[] arrayOfString1 = new String[bdfp.jdField_a_of_type_JavaUtilArrayList.size()];
        bdfp.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfString1);
        bdfp.jdField_a_of_type_JavaUtilArrayList.clear();
        if (arrayOfString1.length == 0) {
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, getStrangerInfo, size=" + arrayOfString2.length);
      }
      ??? = (bdug)this.a.a(71);
    } while (??? == null);
    ((bdug)???).a(arrayOfString2, new int[] { 40530, 27025, 27201, 27235, 27238, 27254 });
    bdfp.a(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil.1
 * JD-Core Version:    0.7.0.1
 */