package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
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
    paramVarArgs = null;
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject1 = (PicFowardInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject3 = (PicResult)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      Object localObject2 = paramVarArgs;
      if (((PicResult)localObject3).jdField_a_of_type_Int == -2)
      {
        localObject2 = MultiPicsProtoCallBack.a(this.a, (PicFowardInfo)localObject1);
        boolean bool = true;
        Object localObject4;
        if (localObject2 != null)
        {
          localObject3 = this.a.b;
          localObject4 = this.a.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Upload [");
          localStringBuilder.append(i);
          localStringBuilder.append("]mLocalPath ＝ ");
          localStringBuilder.append((String)localObject2);
          Logger.a((String)localObject3, (String)localObject4, "uploadForwardMultiMsgPics.uploadFiles", localStringBuilder.toString());
          localObject3 = new TransferRequest();
          ((TransferRequest)localObject3).needSendMsg = false;
          ((TransferRequest)localObject3).mSelfUin = ((AppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((TransferRequest)localObject3).mPeerUin = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((TransferRequest)localObject3).mSecondId = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((TransferRequest)localObject3).mUinType = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((TransferRequest)localObject3).mFileType = 1;
          ((TransferRequest)localObject3).mUniseq = (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          localObject4 = (ITransFileController)((AppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(ITransFileController.class, "");
          while (((ITransFileController)localObject4).containsProcessor(((TransferRequest)localObject3).mPeerUin, ((TransferRequest)localObject3).mUniseq)) {
            ((TransferRequest)localObject3).mUniseq += 100L;
          }
          ((TransferRequest)localObject3).mIsUp = true;
          ((TransferRequest)localObject3).mBusiType = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
          ((TransferRequest)localObject3).mLocalPath = ((String)localObject2);
          localObject4 = new TransferRequest.PicUpExtraInfo();
          if (((PicFowardInfo)localObject1).jdField_a_of_type_Int < 0)
          {
            ((TransferRequest.PicUpExtraInfo)localObject4).mIsRaw = false;
          }
          else
          {
            if (((PicFowardInfo)localObject1).jdField_a_of_type_Int != 2) {
              bool = false;
            }
            ((TransferRequest.PicUpExtraInfo)localObject4).mIsRaw = bool;
          }
          ((TransferRequest)localObject3).mExtraObj = localObject4;
          ((TransferRequest)localObject3).mUpCallBack = new MultiMsgPicsUpCallBack(this.a.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask, this.a.jdField_a_of_type_JavaLangRefWeakReference, i, (String)localObject2);
          ((ITransFileController)((AppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(ITransFileController.class, "")).transferAsync((TransferRequest)localObject3);
          localObject2 = paramVarArgs;
        }
        else
        {
          ((PicResult)localObject3).jdField_a_of_type_Int = -1;
          ((PicResult)localObject3).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
          localObject2 = ((PicResult)localObject3).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Get target pic filepath of [");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("] failed");
          ((PicInfoInterface.ErrInfo)localObject2).b = ((StringBuilder)localObject4).toString();
          if ((((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 1) && (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 3000)) {
            ((PicResult)localObject3).jdField_a_of_type_JavaLangObject = this.a.a(null, null, i);
          } else {
            ((PicResult)localObject3).jdField_a_of_type_JavaLangObject = this.a.a(null, null, i);
          }
          localObject1 = paramVarArgs;
          if (QLog.isColorLevel())
          {
            localObject1 = paramVarArgs;
            if (paramVarArgs == null) {
              localObject1 = new StringBuilder();
            }
            ((StringBuilder)localObject1).append("Upload [");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("] failed, errDec ＝ ");
            ((StringBuilder)localObject1).append(((PicResult)localObject3).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
            ((StringBuilder)localObject1).append("\n");
          }
          this.a.a();
          localObject2 = localObject1;
          if (this.a.a() == 0)
          {
            this.a.b();
            localObject2 = localObject1;
          }
        }
      }
      i += 1;
      paramVarArgs = (Void[])localObject2;
    }
    if (paramVarArgs != null) {
      Logger.b(this.a.b, this.a.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsProtoCallBack.1
 * JD-Core Version:    0.7.0.1
 */