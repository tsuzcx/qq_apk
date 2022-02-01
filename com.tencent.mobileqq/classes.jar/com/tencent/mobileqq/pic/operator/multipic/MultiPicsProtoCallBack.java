package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class MultiPicsProtoCallBack
  extends MultiPicsBaseClass
  implements RichProtoProc.RichProtoCallback
{
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  boolean jdField_a_of_type_Boolean = false;
  
  public MultiPicsProtoCallBack(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, MessageRecord paramMessageRecord, WeakReference<QQAppInterface> paramWeakReference)
  {
    super(paramMultiPicsUploadTask, paramWeakReference);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private String a(PicFowardInfo paramPicFowardInfo)
  {
    Object localObject3 = null;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {}
    Object localObject1;
    for (int i = 1; paramPicFowardInfo.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (FileUtils.b(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString, 0, 1009);
      CompressOperator.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = URLDrawableHelper.getURL(paramPicFowardInfo, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = AbsDownloader.getFilePath(((URL)localObject2).toString()); FileUtils.b((String)localObject2); localObject2 = null)
        {
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = URLDrawableHelper.getURL(paramPicFowardInfo, 131075, null);
          if (localObject2 == null) {
            break label368;
          }
        }
        label368:
        for (String str = AbsDownloader.getFilePath(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (FileUtils.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            CompressOperator.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = URLDrawableHelper.getURL(paramPicFowardInfo, 65537, null);
          paramPicFowardInfo = localObject3;
          if (localObject1 != null) {
            paramPicFowardInfo = AbsDownloader.getFilePath(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!FileUtils.b(paramPicFowardInfo)) {
            break;
          }
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramPicFowardInfo);
          return paramPicFowardInfo;
        }
      }
      return localObject1;
      localObject1 = null;
    }
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1000) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1020) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1004)) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d == null))
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b + ",secondId:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d);
        return false;
      }
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int == -1)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramPicFowardInfo) != null) {
        return true;
      }
      paramPicFowardInfo.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void c()
  {
    new MultiPicsProtoCallBack.1(this).execute(new Void[0]);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "start,remiao:" + this.jdField_a_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + paramRichProtoResp.resps.size());
    }
    if ((paramRichProtoReq != null) && (paramRichProtoResp != null))
    {
      i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        Object localObject1 = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        PicResult localPicResult = (PicResult)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if ((localObject2 instanceof RichProto.RichProtoResp.C2CPicUpResp))
        {
          localObject2 = (RichProto.RichProtoResp.C2CPicUpResp)localObject2;
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.C2CPicUpResp)localObject2).toString());
          if ((((RichProto.RichProtoResp.C2CPicUpResp)localObject2).result == 0) && (((RichProto.RichProtoResp.C2CPicUpResp)localObject2).isExist))
          {
            localObject2 = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(i), (RichProto.RichProtoResp.C2CPicUpResp)localObject2, i);
            if ((((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 1) && (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 3000)) {
              break label376;
            }
            Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localPicResult.jdField_a_of_type_Int = 0;
              localPicResult.jdField_a_of_type_JavaLangObject = localObject1;
              a();
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              }
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label376:
          if (localObject2 != null)
          {
            localPicResult.jdField_a_of_type_Int = 0;
            localPicResult.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof RichProto.RichProtoResp.GroupPicUpResp))
              {
                localObject2 = (RichProto.RichProtoResp.GroupPicUpResp)localObject2;
                Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.GroupPicUpResp)localObject2).toString());
                if ((((RichProto.RichProtoResp.GroupPicUpResp)localObject2).result == 0) && (((RichProto.RichProtoResp.GroupPicUpResp)localObject2).isExist))
                {
                  localObject2 = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(i), (RichProto.RichProtoResp.GroupPicUpResp)localObject2, i);
                  if ((((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 1) || (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localPicResult.jdField_a_of_type_Int = 0;
                      localPicResult.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localPicResult.jdField_a_of_type_Int = 0;
                      localPicResult.jdField_a_of_type_JavaLangObject = localObject1;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                }
              }
              else
              {
                Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
              }
            }
          }
        }
      }
    }
    int i = a();
    if (i > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] need upload [" + i + "] pictures");
      }
      int k = 0;
      for (int j = 0; k < this.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        paramRichProtoReq = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(k);
        paramRichProtoResp = (PicResult)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (paramRichProtoResp.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(paramRichProtoReq))
          {
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString = MultiMsgManager.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString = FileUtils.c(paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l = 1;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j = 242;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k = 192;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = MultiMsgManager.a();
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int = 192;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e = 242;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
            paramRichProtoResp.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsProtoCallBack
 * JD-Core Version:    0.7.0.1
 */