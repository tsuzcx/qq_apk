package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class MultiPicsProtoCallBack$1
  extends AsyncTask<Void, Void, Void>
{
  MultiPicsProtoCallBack$1(MultiPicsProtoCallBack paramMultiPicsProtoCallBack) {}
  
  protected Void a(Void... paramVarArgs)
  {
    Logger.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (PicResult)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        Object localObject3;
        if (((PicResult)localObject2).jdField_a_of_type_Int == -2)
        {
          localObject1 = MultiPicsProtoCallBack.a(this.a, localPicFowardInfo);
          if (localObject1 == null) {
            break label465;
          }
          Logger.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + (String)localObject1);
          localObject2 = new TransferRequest();
          ((TransferRequest)localObject2).needSendMsg = false;
          ((TransferRequest)localObject2).mSelfUin = ((QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((TransferRequest)localObject2).mPeerUin = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((TransferRequest)localObject2).mSecondId = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((TransferRequest)localObject2).mUinType = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((TransferRequest)localObject2).mFileType = 1;
          ((TransferRequest)localObject2).mUniseq = (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          localObject3 = (ITransFileController)((QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(ITransFileController.class);
          while (((ITransFileController)localObject3).containsProcessor(((TransferRequest)localObject2).mPeerUin, ((TransferRequest)localObject2).mUniseq)) {
            ((TransferRequest)localObject2).mUniseq += 100L;
          }
          ((TransferRequest)localObject2).mIsUp = true;
          ((TransferRequest)localObject2).mBusiType = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
          ((TransferRequest)localObject2).mLocalPath = ((String)localObject1);
          localObject3 = new TransferRequest.PicUpExtraInfo();
          if (localPicFowardInfo.jdField_a_of_type_Int < 0)
          {
            ((TransferRequest.PicUpExtraInfo)localObject3).mIsRaw = false;
            ((TransferRequest)localObject2).mExtraObj = localObject3;
            ((TransferRequest)localObject2).mUpCallBack = new MultiMsgPicsUpCallBack(this.a.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask, this.a.jdField_a_of_type_JavaLangRefWeakReference, i, (String)localObject1);
            ((ITransFileController)((QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localPicFowardInfo.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((TransferRequest.PicUpExtraInfo)localObject3).mIsRaw = bool;
          break;
        }
        label465:
        ((PicResult)localObject2).jdField_a_of_type_Int = -1;
        ((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        ((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = ("Get target pic filepath of [" + i + "] failed");
        if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 1) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 3000))
        {
          ((PicResult)localObject2).jdField_a_of_type_JavaLangObject = this.a.a(null, null, i);
          label556:
          if (!QLog.isColorLevel()) {
            break label686;
          }
          if (paramVarArgs != null) {
            break label683;
          }
          paramVarArgs = new StringBuilder();
          label574:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b).append("\n");
        }
      }
    }
    label683:
    label686:
    for (;;)
    {
      this.a.a();
      if (this.a.a() == 0) {
        this.a.b();
      }
      localObject1 = paramVarArgs;
      break;
      ((PicResult)localObject2).jdField_a_of_type_JavaLangObject = this.a.a(null, null, i);
      break label556;
      if (paramVarArgs != null) {
        Logger.b(this.a.b, this.a.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label574;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsProtoCallBack.1
 * JD-Core Version:    0.7.0.1
 */