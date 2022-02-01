package com.tencent.mobileqq.pic.operator.multipic;

import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MultiPicsOperator$MultiPicsUploadTask
  extends AsyncTask<Void, Void, Void>
{
  final RichProtoProc.RichProtoCallback jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
  public String a;
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<PicResult> jdField_a_of_type_JavaUtilArrayList;
  List<PicFowardInfo> jdField_a_of_type_JavaUtilList;
  public String b;
  
  public MultiPicsOperator$MultiPicsUploadTask(AppInterface paramAppInterface, List<PicFowardInfo> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramAppInterface.jdField_a_of_type_JavaLangString;
    this.b = paramAppInterface.b;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(localObject.size());
    int i = 0;
    while (i < localObject.size())
    {
      paramList = new PicResult();
      paramList.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramAppInterface.jdField_a_of_type_ComTencentMobileqqPicPicReq;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = new MultiPicsProtoCallBack(this, MultiPicsOperator.a(paramAppInterface), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    int i = 0;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      paramVarArgs = null;
      if (i >= j) {
        break;
      }
      localObject2 = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localPicUpReq.peerUin = MultiPicsOperator.b(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).frienduin;
      localPicUpReq.uinType = MultiPicsOperator.c(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).istroop;
      localPicUpReq.secondUin = MultiPicsOperator.d(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).senderuin;
      boolean bool;
      if (localPicUpReq.uinType == 1006) {
        bool = true;
      } else {
        bool = false;
      }
      localPicUpReq.isContact = bool;
      localPicUpReq.md5 = HexUtil.hexStr2Bytes(((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f);
      if (((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localPicUpReq.isRaw = bool;
      if (((PicFowardInfo)localObject2).jdField_a_of_type_Int == 2) {
        localPicUpReq.isRaw = true;
      }
      Object localObject3;
      if ((((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j != 0) && (((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k != 0) && (0L != ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c))
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] Get width/height/filesize from UploadInfo");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localPicUpReq.width = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j;
        localPicUpReq.height = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
        localPicUpReq.fileSize = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("] Get width/height/filesize from File");
        Logger.a((String)localObject1, (String)localObject3, "uploadForwardMultiMsgPics", localStringBuilder.toString());
        if (FileUtils.fileExistsAndNotEmpty(((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g))
        {
          paramVarArgs = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
        }
        else
        {
          if (localPicUpReq.isRaw) {
            localObject1 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((PicUiInterface)localObject2, 131075, null);
          } else {
            localObject1 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((PicUiInterface)localObject2, 1, null);
          }
          if (localObject1 != null) {
            paramVarArgs = AbsDownloader.getFilePath(((URL)localObject1).toString());
          }
        }
        if (FileUtils.fileExistsAndNotEmpty(paramVarArgs))
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, (BitmapFactory.Options)localObject1);
          localPicUpReq.width = ((BitmapFactory.Options)localObject1).outWidth;
          localPicUpReq.height = ((BitmapFactory.Options)localObject1).outHeight;
          localPicUpReq.fileSize = FileUtils.getFileSizes(paramVarArgs);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(i);
          localStringBuilder.append("] Get width/height/filesize from File failed, targetPicFilepath = ");
          localStringBuilder.append(paramVarArgs);
          Logger.a((String)localObject1, (String)localObject3, "uploadForwardMultiMsgPics", localStringBuilder.toString());
        }
      }
      if ((localPicUpReq.uinType != 1) && (localPicUpReq.uinType != 3000))
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] is C2C message");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localRichProtoReq.protoKey = "c2c_pic_up";
      }
      else
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] is Troop/Discussion message");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localRichProtoReq.protoKey = "grp_pic_up";
      }
      localPicUpReq.fileName = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f;
      localRichProtoReq.reqs.add(localPicUpReq);
      i += 1;
    }
    if (!localRichProtoReq.reqs.isEmpty())
    {
      localRichProtoReq.callback = this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
      localRichProtoReq.protoReqMgr = ((IProtoReqManager)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IProtoReqManager.class, ""));
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestStart:");
      ((StringBuilder)localObject2).append(localRichProtoReq.toString());
      Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject2).toString());
      RichProtoProc.procRichProtoReq(localRichProtoReq);
      return null;
    }
    a();
    return null;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b();
  }
  
  public void a(PicResult paramPicResult)
  {
    MultiPicsOperator.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator, 6, 0, paramPicResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator.MultiPicsUploadTask
 * JD-Core Version:    0.7.0.1
 */