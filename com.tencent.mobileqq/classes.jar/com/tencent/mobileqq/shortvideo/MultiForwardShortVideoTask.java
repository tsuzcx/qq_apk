package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class MultiForwardShortVideoTask
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  public final BaseShortVideoUpOperator a;
  ArrayList<ShortVideoForwardInfo> jdField_a_of_type_JavaUtilArrayList;
  ArrayList<ShortVideoResult> b;
  
  public MultiForwardShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator = paramBaseShortVideoUpOperator;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.b;
    int i = 0;
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((ShortVideoResult)localIterator.next()).jdField_a_of_type_Int == -2) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public TransferRequest a(int paramInt, ShortVideoForwardInfo paramShortVideoForwardInfo, MessageRecord paramMessageRecord)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramMessageRecord.selfuin;
    localTransferRequest.mPeerUin = paramMessageRecord.frienduin;
    localTransferRequest.mUinType = paramMessageRecord.istroop;
    localTransferRequest.mFileType = 20;
    localTransferRequest.mExtraObj = paramShortVideoForwardInfo;
    localTransferRequest.mUniseq = paramMessageRecord.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = 1010;
    localTransferRequest.mMd5 = paramShortVideoForwardInfo.e;
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append(paramShortVideoForwardInfo.h);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.i);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.j);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.g);
    localTransferRequest.mLocalPath = paramMessageRecord.toString();
    localTransferRequest.mUpCallBack = new MultiForwardVideoUpCallback(this, paramInt);
    localTransferRequest.mRec = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    return localTransferRequest;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int + 3 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      i = this.jdField_a_of_type_Int + 3;
    } else {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mInfoList:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject1).append(" ,uploadStartIndex:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" ,finishIndex:");
      ((StringBuilder)localObject1).append(i);
      QLog.d("BaseShortVideoOprerator", 2, ((StringBuilder)localObject1).toString());
    }
    int j = this.jdField_a_of_type_Int;
    while (j < i)
    {
      Object localObject2 = (ShortVideoForwardInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (((ShortVideoForwardInfo)localObject2).a != null) {
        localObject1 = (MessageForShortVideo)((ShortVideoForwardInfo)localObject2).a;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a((ShortVideoForwardInfo)localObject2);
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mr is null");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
        long l = System.currentTimeMillis();
        localObject1 = a(j, (ShortVideoForwardInfo)localObject2, (MessageRecord)localObject1);
        a((TransferRequest)localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("MultiForwardShortVideo req");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(": ");
          ((StringBuilder)localObject2).append(((TransferRequest)localObject1).toString());
          ((StringBuilder)localObject2).append(" ,cost:");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
          QLog.d("BaseShortVideoOprerator", 2, ((StringBuilder)localObject2).toString());
        }
      }
      j += 1;
    }
    this.jdField_a_of_type_Int += 3;
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
      }
      return;
    }
    if (this.b == null) {
      this.b = new ArrayList(((ArrayList)localObject1).size());
    }
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ShortVideoForwardInfo)((Iterator)localObject1).next();
      localObject2 = new ShortVideoResult();
      ((ShortVideoResult)localObject2).jdField_a_of_type_Int = -2;
      ((ShortVideoResult)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
      this.b.add(localObject2);
    }
    a();
  }
  
  public void run()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */