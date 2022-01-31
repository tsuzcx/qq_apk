package com.tencent.mobileqq.shortvideo;

import ayyg;
import ayyz;
import azaa;
import batw;
import baub;
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
  public ArrayList<ayyz> a;
  public ArrayList<azaa> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<ayyz> paramArrayList)
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
          if (((azaa)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    ayyz localayyz;
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
      localayyz = (ayyz)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localayyz.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localayyz.jdField_a_of_type_JavaLangObject;
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
      localObject = this.this$0.a(localayyz);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      baub localbaub = new baub();
      localbaub.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
      localbaub.c = ((MessageRecord)localObject).frienduin;
      localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
      localbaub.jdField_b_of_type_Int = 20;
      localbaub.jdField_a_of_type_JavaLangObject = localayyz;
      localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localbaub.jdField_a_of_type_Boolean = true;
      localbaub.e = 1010;
      localbaub.f = localayyz.e;
      localbaub.i = (localayyz.h + "QQ_&_MoblieQQ_&_QQ" + localayyz.i + "QQ_&_MoblieQQ_&_QQ" + localayyz.j + "QQ_&_MoblieQQ_&_QQ" + localayyz.g);
      localbaub.jdField_a_of_type_Awfy = new ayyg(this, j);
      localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localbaub.toString() + " ,cost:" + (System.currentTimeMillis() - l));
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
      Object localObject = (ayyz)localIterator.next();
      localObject = new azaa();
      ((azaa)localObject).jdField_a_of_type_Int = -2;
      ((azaa)localObject).jdField_a_of_type_Ayzo = this.this$0.jdField_a_of_type_Ayzo;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */