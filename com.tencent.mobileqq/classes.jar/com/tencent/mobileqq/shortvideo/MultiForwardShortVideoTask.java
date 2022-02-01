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
  public final BaseShortVideoUpOperator a;
  ArrayList<ShortVideoForwardInfo> b;
  ArrayList<ShortVideoResult> c;
  int d = 0;
  
  public MultiForwardShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
    this.a = paramBaseShortVideoUpOperator;
    this.b = paramArrayList;
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
    localTransferRequest.mMd5 = paramShortVideoForwardInfo.i;
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append(paramShortVideoForwardInfo.p);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.q);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.u);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.k);
    localTransferRequest.mLocalPath = paramMessageRecord.toString();
    localTransferRequest.mUpCallBack = new MultiForwardVideoUpCallback(this, paramInt);
    localTransferRequest.mRec = this.a.f;
    return localTransferRequest;
  }
  
  public void a()
  {
    if (this.d >= this.b.size()) {
      return;
    }
    int i;
    if (this.d + 3 < this.b.size()) {
      i = this.d + 3;
    } else {
      i = this.b.size();
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mInfoList:");
      ((StringBuilder)localObject1).append(this.b.size());
      ((StringBuilder)localObject1).append(" ,uploadStartIndex:");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(" ,finishIndex:");
      ((StringBuilder)localObject1).append(i);
      QLog.d("BaseShortVideoOprerator", 2, ((StringBuilder)localObject1).toString());
    }
    int j = this.d;
    while (j < i)
    {
      Object localObject2 = (ShortVideoForwardInfo)this.b.get(j);
      if (((ShortVideoForwardInfo)localObject2).v != null) {
        localObject1 = (MessageForShortVideo)((ShortVideoForwardInfo)localObject2).v;
      } else {
        localObject1 = this.a.a((ShortVideoForwardInfo)localObject2);
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mr is null");
        }
      }
      else
      {
        this.a.f = ((MessageRecord)localObject1);
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
    this.d += 3;
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.a.a.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  public void b()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
      }
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList(((ArrayList)localObject1).size());
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ShortVideoForwardInfo)((Iterator)localObject1).next();
      localObject2 = new ShortVideoResult();
      ((ShortVideoResult)localObject2).a = -2;
      ((ShortVideoResult)localObject2).c = this.a.b;
      this.c.add(localObject2);
    }
    a();
  }
  
  public int c()
  {
    ArrayList localArrayList = this.c;
    int i = 0;
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((ShortVideoResult)localIterator.next()).a == -2) {
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
  
  public void run()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */