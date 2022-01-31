package com.tencent.mobileqq.shortvideo;

import axda;
import axdt;
import axes;
import ayvv;
import aywa;
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
  public ArrayList<axdt> a;
  public ArrayList<axes> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<axdt> paramArrayList)
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
          if (((axes)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    axdt localaxdt;
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
      localaxdt = (axdt)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localaxdt.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localaxdt.jdField_a_of_type_JavaLangObject;
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
      localObject = this.this$0.a(localaxdt);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      aywa localaywa = new aywa();
      localaywa.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
      localaywa.c = ((MessageRecord)localObject).frienduin;
      localaywa.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
      localaywa.jdField_b_of_type_Int = 20;
      localaywa.jdField_a_of_type_JavaLangObject = localaxdt;
      localaywa.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localaywa.jdField_a_of_type_Boolean = true;
      localaywa.e = 1010;
      localaywa.f = localaxdt.e;
      localaywa.i = (localaxdt.h + "QQ_&_MoblieQQ_&_QQ" + localaxdt.i + "QQ_&_MoblieQQ_&_QQ" + localaxdt.j + "QQ_&_MoblieQQ_&_QQ" + localaxdt.g);
      localaywa.jdField_a_of_type_Auoo = new axda(this, j);
      localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaywa.toString() + " ,cost:" + (System.currentTimeMillis() - l));
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
      Object localObject = (axdt)localIterator.next();
      localObject = new axes();
      ((axes)localObject).jdField_a_of_type_Int = -2;
      ((axes)localObject).jdField_a_of_type_Axeg = this.this$0.jdField_a_of_type_Axeg;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */