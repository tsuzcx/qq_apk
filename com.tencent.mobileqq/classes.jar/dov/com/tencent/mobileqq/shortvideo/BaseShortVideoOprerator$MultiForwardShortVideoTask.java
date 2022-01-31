package dov.com.tencent.mobileqq.shortvideo;

import batw;
import baub;
import bnkm;
import bnlk;
import bnlp;
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
  public ArrayList<bnlk> a;
  public ArrayList<bnlp> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<bnlk> paramArrayList)
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
          if (((bnlp)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    bnlk localbnlk;
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
      localbnlk = (bnlk)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localbnlk.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject = (MessageForShortVideo)localbnlk.jdField_a_of_type_JavaLangObject;; localObject = this.this$0.a(localbnlk))
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
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
    localbaub.c = ((MessageRecord)localObject).frienduin;
    localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
      localbaub.jdField_b_of_type_Int = 6;
    }
    for (;;)
    {
      localbaub.jdField_a_of_type_JavaLangObject = localbnlk;
      localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localbaub.jdField_a_of_type_Boolean = true;
      localbaub.e = 1010;
      localbaub.f = localbnlk.e;
      localbaub.i = (localbnlk.h + "QQ_&_MoblieQQ_&_QQ" + localbnlk.i + "QQ_&_MoblieQQ_&_QQ" + localbnlk.j + "QQ_&_MoblieQQ_&_QQ" + localbnlk.g);
      localbaub.jdField_a_of_type_Awfy = new bnkm(this, j);
      localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localbaub.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      break;
      if (((MessageRecord)localObject).istroop == 3000) {
        localbaub.jdField_b_of_type_Int = 17;
      } else if (((MessageRecord)localObject).istroop == 1) {
        localbaub.jdField_b_of_type_Int = 9;
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
      Object localObject = (bnlk)localIterator.next();
      localObject = new bnlp();
      ((bnlp)localObject).jdField_a_of_type_Int = -2;
      ((bnlp)localObject).jdField_a_of_type_Bnlo = this.this$0.jdField_a_of_type_Bnlo;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */