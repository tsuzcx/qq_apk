package com.tencent.mobileqq.pic.operator.multipic;

import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<PicResult> jdField_a_of_type_JavaUtilArrayList;
  List<PicFowardInfo> jdField_a_of_type_JavaUtilList;
  public String b;
  
  public MultiPicsOperator$MultiPicsUploadTask(QQAppInterface paramQQAppInterface, List<PicFowardInfo> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.jdField_a_of_type_JavaLangString;
    this.b = paramQQAppInterface.b;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(localObject.size());
    int i = 0;
    while (i < localObject.size())
    {
      paramList = new PicResult();
      paramList.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqPicPicReq;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = new MultiPicsProtoCallBack(this, MultiPicsOperator.a(paramQQAppInterface), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localPicUpReq.peerUin = MultiPicsOperator.b(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).frienduin;
      localPicUpReq.uinType = MultiPicsOperator.c(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).istroop;
      localPicUpReq.secondUin = MultiPicsOperator.d(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator).senderuin;
      boolean bool;
      if (localPicUpReq.uinType == 1006)
      {
        bool = true;
        label124:
        localPicUpReq.isContact = bool;
        localPicUpReq.md5 = HexUtil.hexStr2Bytes(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f);
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l != 1) {
          break label406;
        }
        bool = true;
        label160:
        localPicUpReq.isRaw = bool;
        if (localPicFowardInfo.jdField_a_of_type_Int == 2) {
          localPicUpReq.isRaw = true;
        }
        if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j == 0) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k == 0) || (0L == localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c)) {
          break label411;
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localPicUpReq.width = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j;
        localPicUpReq.height = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
        localPicUpReq.fileSize = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
        label298:
        if ((localPicUpReq.uinType != 1) && (localPicUpReq.uinType != 3000)) {
          break label637;
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localRichProtoReq.protoKey = "grp_pic_up";; localRichProtoReq.protoKey = "c2c_pic_up")
      {
        localPicUpReq.fileName = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f;
        localRichProtoReq.reqs.add(localPicUpReq);
        i += 1;
        break;
        bool = false;
        break label124;
        label406:
        bool = false;
        break label160;
        label411:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (FileUtils.b(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g)) {
          paramVarArgs = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
        }
        for (;;)
        {
          if (!FileUtils.b(paramVarArgs)) {
            break label586;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localPicUpReq.width = localOptions.outWidth;
          localPicUpReq.height = localOptions.outHeight;
          localPicUpReq.fileSize = FileUtil.a(paramVarArgs);
          break;
          if (localPicUpReq.isRaw) {}
          for (paramVarArgs = URLDrawableHelper.getURL(localPicFowardInfo, 131075, null);; paramVarArgs = URLDrawableHelper.getURL(localPicFowardInfo, 1, null))
          {
            if (paramVarArgs == null) {
              break label581;
            }
            paramVarArgs = AbsDownloader.getFilePath(paramVarArgs.toString());
            break;
          }
          label581:
          paramVarArgs = null;
        }
        label586:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label298;
        label637:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localRichProtoReq.reqs.isEmpty())
    {
      localRichProtoReq.callback = this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
      localRichProtoReq.protoReqMgr = ((IProtoReqManager)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IProtoReqManager.class, ""));
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.b, this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localRichProtoReq.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator.MultiPicsUploadTask
 * JD-Core Version:    0.7.0.1
 */