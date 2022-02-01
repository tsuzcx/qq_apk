package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class BaseShortVideoOprerator$MultiForwardShortVideoTask
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  ArrayList<ShortVideoForwardInfo> jdField_a_of_type_JavaUtilArrayList;
  ArrayList<ShortVideoResult> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
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
          if (((ShortVideoResult)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    ShortVideoForwardInfo localShortVideoForwardInfo;
    Object localObject;
    if (this.jdField_a_of_type_Int + BaseShortVideoOprerator.d < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      i = this.jdField_a_of_type_Int + BaseShortVideoOprerator.d;
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " ,uploadStartIndex:" + this.jdField_a_of_type_Int + " ,finishIndex:" + i);
      }
      j = this.jdField_a_of_type_Int;
      if (j >= i) {
        break label463;
      }
      localShortVideoForwardInfo = (ShortVideoForwardInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localShortVideoForwardInfo.a == null) {
        break label178;
      }
      localObject = (MessageForShortVideo)localShortVideoForwardInfo.a;
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
      localObject = this.this$0.a(localShortVideoForwardInfo);
      break label141;
      label192:
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
      localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
      localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
      localTransferRequest.mFileType = 20;
      localTransferRequest.mExtraObj = localShortVideoForwardInfo;
      localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mBusiType = 1010;
      localTransferRequest.mMd5 = localShortVideoForwardInfo.e;
      localTransferRequest.mLocalPath = (localShortVideoForwardInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.g);
      localTransferRequest.mUpCallBack = new BaseShortVideoOprerator.MultiForwardShortVideoTask.MultiForwardVideoUpCallback(this, j);
      localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localTransferRequest.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      }
    }
    label463:
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
      Object localObject = (ShortVideoForwardInfo)localIterator.next();
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).jdField_a_of_type_Int = -2;
      ((ShortVideoResult)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */