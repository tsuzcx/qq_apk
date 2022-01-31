package dov.com.tencent.mobileqq.shortvideo;

import axvo;
import axvt;
import bjia;
import bjiy;
import bjjd;
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
  public ArrayList<bjiy> a;
  public ArrayList<bjjd> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<bjiy> paramArrayList)
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
          if (((bjjd)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    bjiy localbjiy;
    if (this.jdField_a_of_type_Int + BaseShortVideoOprerator.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      i = this.jdField_a_of_type_Int + BaseShortVideoOprerator.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " ,uploadStartIndex:" + this.jdField_a_of_type_Int + " ,finishIndex:" + i);
      }
      j = this.jdField_a_of_type_Int;
      if (j >= i) {
        break label515;
      }
      localbjiy = (bjiy)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localbjiy.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject = (MessageForShortVideo)localbjiy.jdField_a_of_type_JavaLangObject;; localObject = this.this$0.a(localbjiy))
    {
      if (localObject != null) {
        break label192;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mr is null");
      }
      j += 1;
      break label105;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
    }
    label192:
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
    localaxvt.c = ((MessageRecord)localObject).frienduin;
    localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
      localaxvt.jdField_b_of_type_Int = 6;
    }
    for (;;)
    {
      localaxvt.jdField_a_of_type_JavaLangObject = localbjiy;
      localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localaxvt.jdField_a_of_type_Boolean = true;
      localaxvt.e = 1010;
      localaxvt.f = localbjiy.e;
      localaxvt.i = (localbjiy.h + "QQ_&_MoblieQQ_&_QQ" + localbjiy.i + "QQ_&_MoblieQQ_&_QQ" + localbjiy.j + "QQ_&_MoblieQQ_&_QQ" + localbjiy.g);
      localaxvt.jdField_a_of_type_Atqq = new bjia(this, j);
      localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaxvt.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      break;
      if (((MessageRecord)localObject).istroop == 3000) {
        localaxvt.jdField_b_of_type_Int = 17;
      } else if (((MessageRecord)localObject).istroop == 1) {
        localaxvt.jdField_b_of_type_Int = 9;
      }
    }
    label515:
    this.jdField_a_of_type_Int += BaseShortVideoOprerator.jdField_a_of_type_Int;
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
      Object localObject = (bjiy)localIterator.next();
      localObject = new bjjd();
      ((bjjd)localObject).jdField_a_of_type_Int = -2;
      ((bjjd)localObject).jdField_a_of_type_Bjjc = this.this$0.jdField_a_of_type_Bjjc;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */