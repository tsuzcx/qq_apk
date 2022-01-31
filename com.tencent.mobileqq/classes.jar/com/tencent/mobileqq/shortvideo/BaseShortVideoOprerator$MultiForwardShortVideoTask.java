package com.tencent.mobileqq.shortvideo;

import axdc;
import axdv;
import axeu;
import ayvx;
import aywc;
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
  public ArrayList<axdv> a;
  public ArrayList<axeu> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<axdv> paramArrayList)
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
          if (((axeu)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    axdv localaxdv;
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
      localaxdv = (axdv)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localaxdv.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localaxdv.jdField_a_of_type_JavaLangObject;
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
      localObject = this.this$0.a(localaxdv);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      aywc localaywc = new aywc();
      localaywc.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
      localaywc.c = ((MessageRecord)localObject).frienduin;
      localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
      localaywc.jdField_b_of_type_Int = 20;
      localaywc.jdField_a_of_type_JavaLangObject = localaxdv;
      localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localaywc.jdField_a_of_type_Boolean = true;
      localaywc.e = 1010;
      localaywc.f = localaxdv.e;
      localaywc.i = (localaxdv.h + "QQ_&_MoblieQQ_&_QQ" + localaxdv.i + "QQ_&_MoblieQQ_&_QQ" + localaxdv.j + "QQ_&_MoblieQQ_&_QQ" + localaxdv.g);
      localaywc.jdField_a_of_type_Auoq = new axdc(this, j);
      localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaywc.toString() + " ,cost:" + (System.currentTimeMillis() - l));
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
      Object localObject = (axdv)localIterator.next();
      localObject = new axeu();
      ((axeu)localObject).jdField_a_of_type_Int = -2;
      ((axeu)localObject).jdField_a_of_type_Axei = this.this$0.jdField_a_of_type_Axei;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */