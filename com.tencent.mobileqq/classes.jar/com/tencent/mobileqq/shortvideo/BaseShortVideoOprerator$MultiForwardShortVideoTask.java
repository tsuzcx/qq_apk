package com.tencent.mobileqq.shortvideo;

import bcwg;
import bcwz;
import bcyb;
import beyb;
import beyg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseShortVideoOprerator$MultiForwardShortVideoTask
  implements Runnable
{
  public int a;
  public ArrayList<bcwz> a;
  public ArrayList<bcyb> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<bcwz> paramArrayList)
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  private int a()
  {
    ArrayList localArrayList = this.b;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          if (((bcyb)localIterator.next()).jdField_a_of_type_Int == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    int i;
    int j;
    label105:
    bcwz localbcwz;
    Object localObject;
    if (this.jdField_a_of_type_Int + BaseShortVideoOprerator.d < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      i = this.jdField_a_of_type_Int + BaseShortVideoOprerator.d;
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " ,uploadStartIndex:" + this.jdField_a_of_type_Int + " ,finishIndex:" + i);
      }
      j = this.jdField_a_of_type_Int;
      if (j >= i) {
        break label456;
      }
      localbcwz = (bcwz)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localbcwz.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localbcwz.jdField_a_of_type_JavaLangObject;
      label141:
      if (localObject != null) {
        break label192;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mr is null");
      }
    }
    for (;;)
    {
      j += 1;
      break label105;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label178:
      localObject = this.this$0.a(localbcwz);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      beyg localbeyg = new beyg();
      localbeyg.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
      localbeyg.c = ((MessageRecord)localObject).frienduin;
      localbeyg.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
      localbeyg.jdField_b_of_type_Int = 20;
      localbeyg.jdField_a_of_type_JavaLangObject = localbcwz;
      localbeyg.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localbeyg.jdField_a_of_type_Boolean = true;
      localbeyg.e = 1010;
      localbeyg.f = localbcwz.e;
      localbeyg.i = (localbcwz.h + "QQ_&_MoblieQQ_&_QQ" + localbcwz.i + "QQ_&_MoblieQQ_&_QQ" + localbcwz.j + "QQ_&_MoblieQQ_&_QQ" + localbcwz.g);
      localbeyg.jdField_a_of_type_Azrg = new bcwg(this, j);
      localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localbeyg.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      }
    }
    label456:
    this.jdField_a_of_type_Int += BaseShortVideoOprerator.d;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
      }
      return;
    }
    if (this.b == null) {
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bcwz)localIterator.next();
      localObject = new bcyb();
      ((bcyb)localObject).jdField_a_of_type_Int = -2;
      ((bcyb)localObject).jdField_a_of_type_Bcxn = this.this$0.jdField_a_of_type_Bcxn;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */