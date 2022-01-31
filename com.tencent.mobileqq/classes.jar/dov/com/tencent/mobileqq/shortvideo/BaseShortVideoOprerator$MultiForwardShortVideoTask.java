package dov.com.tencent.mobileqq.shortvideo;

import ayvx;
import aywc;
import bkzc;
import blaa;
import blaf;
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
  public ArrayList<blaa> a;
  public ArrayList<blaf> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<blaa> paramArrayList)
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
          if (((blaf)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    blaa localblaa;
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
      localblaa = (blaa)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localblaa.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject = (MessageForShortVideo)localblaa.jdField_a_of_type_JavaLangObject;; localObject = this.this$0.a(localblaa))
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
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
    localaywc.c = ((MessageRecord)localObject).frienduin;
    localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
      localaywc.jdField_b_of_type_Int = 6;
    }
    for (;;)
    {
      localaywc.jdField_a_of_type_JavaLangObject = localblaa;
      localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localaywc.jdField_a_of_type_Boolean = true;
      localaywc.e = 1010;
      localaywc.f = localblaa.e;
      localaywc.i = (localblaa.h + "QQ_&_MoblieQQ_&_QQ" + localblaa.i + "QQ_&_MoblieQQ_&_QQ" + localblaa.j + "QQ_&_MoblieQQ_&_QQ" + localblaa.g);
      localaywc.jdField_a_of_type_Auoq = new bkzc(this, j);
      localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaywc.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      break;
      if (((MessageRecord)localObject).istroop == 3000) {
        localaywc.jdField_b_of_type_Int = 17;
      } else if (((MessageRecord)localObject).istroop == 1) {
        localaywc.jdField_b_of_type_Int = 9;
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
      Object localObject = (blaa)localIterator.next();
      localObject = new blaf();
      ((blaf)localObject).jdField_a_of_type_Int = -2;
      ((blaf)localObject).jdField_a_of_type_Blae = this.this$0.jdField_a_of_type_Blae;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */