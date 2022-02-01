package com.tencent.mobileqq.shortvideo;

import bcwk;
import bcxd;
import bcyf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseShortVideoOprerator$MultiForwardShortVideoTask
  implements Runnable
{
  public int a;
  public ArrayList<bcxd> a;
  public ArrayList<bcyf> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<bcxd> paramArrayList)
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
          if (((bcyf)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    bcxd localbcxd;
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
      localbcxd = (bcxd)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localbcxd.a == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localbcxd.a;
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
      localObject = this.this$0.a(localbcxd);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
      localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
      localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
      localTransferRequest.mFileType = 20;
      localTransferRequest.mExtraObj = localbcxd;
      localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mBusiType = 1010;
      localTransferRequest.mMd5 = localbcxd.e;
      localTransferRequest.mLocalPath = (localbcxd.h + "QQ_&_MoblieQQ_&_QQ" + localbcxd.i + "QQ_&_MoblieQQ_&_QQ" + localbcxd.j + "QQ_&_MoblieQQ_&_QQ" + localbcxd.g);
      localTransferRequest.mUpCallBack = new bcwk(this, j);
      localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localTransferRequest.toString() + " ,cost:" + (System.currentTimeMillis() - l));
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
      Object localObject = (bcxd)localIterator.next();
      localObject = new bcyf();
      ((bcyf)localObject).jdField_a_of_type_Int = -2;
      ((bcyf)localObject).jdField_a_of_type_Bcxr = this.this$0.jdField_a_of_type_Bcxr;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */