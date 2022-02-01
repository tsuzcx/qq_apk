package dov.com.tencent.mobileqq.shortvideo;

import bpqm;
import bpra;
import bprg;
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
  public ArrayList<bpra> a;
  public ArrayList<bprg> b;
  
  public BaseShortVideoOprerator$MultiForwardShortVideoTask(ArrayList<bpra> paramArrayList)
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
          if (((bprg)localIterator.next()).jdField_a_of_type_Int == -2) {
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
    bpra localbpra;
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
      localbpra = (bpra)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localbpra.a == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject = (MessageForShortVideo)localbpra.a;; localObject = this.this$0.a(localbpra))
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
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
    localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
    localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
    if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
      localTransferRequest.mFileType = 6;
    }
    for (;;)
    {
      localTransferRequest.mExtraObj = localbpra;
      localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mBusiType = 1010;
      localTransferRequest.mMd5 = localbpra.e;
      localTransferRequest.mLocalPath = (localbpra.h + "QQ_&_MoblieQQ_&_QQ" + localbpra.i + "QQ_&_MoblieQQ_&_QQ" + localbpra.j + "QQ_&_MoblieQQ_&_QQ" + localbpra.g);
      localTransferRequest.mUpCallBack = new bpqm(this, j);
      localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localTransferRequest.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      break;
      if (((MessageRecord)localObject).istroop == 3000) {
        localTransferRequest.mFileType = 17;
      } else if (((MessageRecord)localObject).istroop == 1) {
        localTransferRequest.mFileType = 9;
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
      Object localObject = (bpra)localIterator.next();
      localObject = new bprg();
      ((bprg)localObject).jdField_a_of_type_Int = -2;
      ((bprg)localObject).jdField_a_of_type_Bprf = this.this$0.jdField_a_of_type_Bprf;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */