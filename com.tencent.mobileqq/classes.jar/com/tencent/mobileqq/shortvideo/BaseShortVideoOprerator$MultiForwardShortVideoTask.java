package com.tencent.mobileqq.shortvideo;

import awds;
import awel;
import awfk;
import axvo;
import axvt;
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
  public ArrayList<awel> a;
  public ArrayList<awfk> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<awel> paramArrayList)
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
          if (((awfk)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    awel localawel;
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
      localawel = (awel)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localawel.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localawel.jdField_a_of_type_JavaLangObject;
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
      localObject = this.this$0.a(localawel);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      axvt localaxvt = new axvt();
      localaxvt.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
      localaxvt.c = ((MessageRecord)localObject).frienduin;
      localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
      localaxvt.jdField_b_of_type_Int = 20;
      localaxvt.jdField_a_of_type_JavaLangObject = localawel;
      localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localaxvt.jdField_a_of_type_Boolean = true;
      localaxvt.e = 1010;
      localaxvt.f = localawel.e;
      localaxvt.i = (localawel.h + "QQ_&_MoblieQQ_&_QQ" + localawel.i + "QQ_&_MoblieQQ_&_QQ" + localawel.j + "QQ_&_MoblieQQ_&_QQ" + localawel.g);
      localaxvt.jdField_a_of_type_Atqq = new awds(this, j);
      localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaxvt.toString() + " ,cost:" + (System.currentTimeMillis() - l));
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
      Object localObject = (awel)localIterator.next();
      localObject = new awfk();
      ((awfk)localObject).jdField_a_of_type_Int = -2;
      ((awfk)localObject).jdField_a_of_type_Awey = this.this$0.jdField_a_of_type_Awey;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */