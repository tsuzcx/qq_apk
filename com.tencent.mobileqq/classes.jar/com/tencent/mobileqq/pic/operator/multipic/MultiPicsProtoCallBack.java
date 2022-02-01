package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
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

public class MultiPicsProtoCallBack
  extends MultiPicsBaseClass
  implements RichProtoProc.RichProtoCallback
{
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  boolean jdField_a_of_type_Boolean = false;
  
  public MultiPicsProtoCallBack(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, MessageRecord paramMessageRecord, WeakReference<AppInterface> paramWeakReference)
  {
    super(paramMultiPicsUploadTask, paramWeakReference);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private String a(PicFowardInfo paramPicFowardInfo)
  {
    int i;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramPicFowardInfo.jdField_a_of_type_Int >= 0) {
      return paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
    }
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject1 = new CompressInfo(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString, 0, 1009);
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      localObject2 = this.b;
      localObject3 = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Compress raw to big compress image at ");
      localStringBuilder.append((String)localObject1);
      Logger.a((String)localObject2, (String)localObject3, "uploadForwardMultiMsgPics.getTargetPicFilepath", localStringBuilder.toString());
    }
    else
    {
      localObject1 = null;
    }
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramPicFowardInfo, 1, null);
      if (localObject2 != null) {
        localObject2 = AbsDownloader.getFilePath(((URL)localObject2).toString());
      } else {
        localObject2 = null;
      }
      if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
      {
        paramPicFowardInfo = this.b;
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("find big compress image at ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Logger.a(paramPicFowardInfo, (String)localObject1, "uploadForwardMultiMsgPics.getTargetPicFilepath", ((StringBuilder)localObject3).toString());
        return localObject2;
      }
      localObject2 = localObject1;
      if (i != 0)
      {
        localObject2 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramPicFowardInfo, 131075, null);
        if (localObject2 != null) {
          localObject3 = AbsDownloader.getFilePath(((URL)localObject2).toString());
        } else {
          localObject3 = null;
        }
        localObject2 = localObject1;
        if (FileUtils.fileExistsAndNotEmpty((String)localObject3))
        {
          localObject1 = new CompressInfo((String)localObject3, 0);
          ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
          ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
          localObject2 = ((CompressInfo)localObject1).e;
          localObject1 = this.b;
          localObject3 = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Compress raw to big compress image at ");
          localStringBuilder.append((String)localObject2);
          Logger.a((String)localObject1, (String)localObject3, "uploadForwardMultiMsgPics.getTargetPicFilepath", localStringBuilder.toString());
        }
      }
      localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramPicFowardInfo, 65537, null);
        paramPicFowardInfo = localObject4;
        if (localObject1 != null) {
          paramPicFowardInfo = AbsDownloader.getFilePath(((URL)localObject1).toString());
        }
        localObject3 = localObject2;
        if (FileUtils.fileExistsAndNotEmpty(paramPicFowardInfo))
        {
          localObject1 = this.b;
          localObject2 = this.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("find thumb image at ");
          ((StringBuilder)localObject3).append(paramPicFowardInfo);
          Logger.a((String)localObject1, (String)localObject2, "uploadForwardMultiMsgPics.getTargetPicFilepath", ((StringBuilder)localObject3).toString());
          localObject3 = paramPicFowardInfo;
        }
      }
    }
    return localObject3;
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Object localObject = this.b;
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicFowardInfo);
      Logger.a((String)localObject, str, "checkFowardPicInfo", localStringBuilder.toString());
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1000) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1020) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1004)) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d == null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("secondId invalid,uinType:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b);
        ((StringBuilder)localObject).append(",secondId:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d);
        paramPicFowardInfo.a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
        return false;
      }
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("protocolType invalid,protocolType:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
        paramPicFowardInfo.a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
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
  
  protected void a(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[uploadForwardMultiMsgPics] need upload [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("] pictures");
      QLog.d("MultiPicsOperator", 2, ((StringBuilder)localObject1).toString());
    }
    paramInt = 0;
    int j;
    for (int i = 0; paramInt < this.jdField_a_of_type_JavaUtilArrayList.size(); i = j)
    {
      localObject1 = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject2 = (PicResult)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  ");
        localStringBuilder.append(((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
        QLog.d("MultiPicsOperator", 2, localStringBuilder.toString());
      }
      j = i;
      if (((PicResult)localObject2).jdField_a_of_type_Int == -2)
      {
        j = i;
        if (!a((PicFowardInfo)localObject1))
        {
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getPicDefaultPath();
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString = FileUtils.calcMd5(((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l = 1;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j = 242;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k = 192;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getPicDefaultSize();
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int = 192;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e = 242;
          ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
          ((PicResult)localObject2).b = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  ");
            ((StringBuilder)localObject2).append(((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
            QLog.d("MultiPicsOperator", 2, ((StringBuilder)localObject2).toString());
          }
          j = 1;
        }
      }
      paramInt += 1;
    }
    if ((i != 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqPicOperatorMultipicMultiPicsOperator$MultiPicsUploadTask.a(new Void[0]);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  protected void a(RichProto.RichProtoReq paramRichProtoReq, int paramInt, PicFowardInfo paramPicFowardInfo, PicResult paramPicResult, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp)
  {
    Object localObject = this.b;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CPicUpResp[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("],");
    localStringBuilder.append(paramC2CPicUpResp.toString());
    Logger.a((String)localObject, str, "uploadForwardMultiMsgPics.onBusiProtoResp", localStringBuilder.toString());
    if ((paramC2CPicUpResp.result == 0) && (paramC2CPicUpResp.isExist))
    {
      paramRichProtoReq = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(paramInt), paramC2CPicUpResp, paramInt);
      if ((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 1) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 3000))
      {
        if (paramRichProtoReq != null)
        {
          paramPicResult.jdField_a_of_type_Int = 0;
          paramPicResult.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
          a();
          if (QLog.isColorLevel())
          {
            paramRichProtoReq = new StringBuilder();
            paramRichProtoReq.append("[uploadForwardMultiMsgPics] upload [");
            paramRichProtoReq.append(paramInt);
            paramRichProtoReq.append("] success, picture is exsit");
            QLog.d("MultiPicsOperator", 2, paramRichProtoReq.toString());
          }
        }
      }
      else
      {
        paramPicFowardInfo = this.b;
        paramC2CPicUpResp = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convert2CustomFace for [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("] ");
        Logger.a(paramPicFowardInfo, paramC2CPicUpResp, "uploadForwardMultiMsgPics.onBusiProtoResp", ((StringBuilder)localObject).toString());
        paramRichProtoReq = a(paramRichProtoReq);
        if (paramRichProtoReq != null)
        {
          paramPicResult.jdField_a_of_type_Int = 0;
          paramPicResult.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
          a();
          if (QLog.isColorLevel())
          {
            paramRichProtoReq = new StringBuilder();
            paramRichProtoReq.append("[uploadForwardMultiMsgPics] upload [");
            paramRichProtoReq.append(paramInt);
            paramRichProtoReq.append("] success, picture is exsit");
            QLog.d("MultiPicsOperator", 2, paramRichProtoReq.toString());
          }
        }
      }
    }
  }
  
  protected void a(RichProto.RichProtoReq paramRichProtoReq, int paramInt, PicFowardInfo paramPicFowardInfo, PicResult paramPicResult, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp)
  {
    Object localObject = this.b;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GroupPicUpResp[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("],");
    localStringBuilder.append(paramGroupPicUpResp.toString());
    Logger.a((String)localObject, str, "uploadForwardMultiMsgPics.onBusiProtoResp", localStringBuilder.toString());
    if ((paramGroupPicUpResp.result == 0) && (paramGroupPicUpResp.isExist))
    {
      paramRichProtoReq = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(paramInt), paramGroupPicUpResp, paramInt);
      if ((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 1) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 3000))
      {
        paramPicFowardInfo = this.b;
        paramGroupPicUpResp = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convert2NotOnlineImage for [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("] ");
        Logger.a(paramPicFowardInfo, paramGroupPicUpResp, "uploadForwardMultiMsgPics.onBusiProtoResp", ((StringBuilder)localObject).toString());
        paramRichProtoReq = a(paramRichProtoReq);
        if (paramRichProtoReq != null)
        {
          paramPicResult.jdField_a_of_type_Int = 0;
          paramPicResult.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
          a();
          if (QLog.isColorLevel())
          {
            paramRichProtoReq = new StringBuilder();
            paramRichProtoReq.append("[uploadForwardMultiMsgPics] upload [");
            paramRichProtoReq.append(paramInt);
            paramRichProtoReq.append("] success, picture is exsit");
            QLog.d("MultiPicsOperator", 2, paramRichProtoReq.toString());
          }
        }
      }
      else if (paramRichProtoReq != null)
      {
        paramPicResult.jdField_a_of_type_Int = 0;
        paramPicResult.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
        a();
        if (QLog.isColorLevel())
        {
          paramRichProtoReq = new StringBuilder();
          paramRichProtoReq.append("[uploadForwardMultiMsgPics] upload [");
          paramRichProtoReq.append(paramInt);
          paramRichProtoReq.append("] success, picture is exsit");
          QLog.d("MultiPicsOperator", 2, paramRichProtoReq.toString());
        }
      }
    }
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    Object localObject1 = this.b;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("start,remiao:");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Boolean);
    Logger.a((String)localObject1, (String)localObject2, "uploadForwardMultiMsgPics.onBusiProtoResp", ((StringBuilder)localObject3).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onBusiProtoResp miao size =  [");
      ((StringBuilder)localObject1).append(paramRichProtoResp.resps.size());
      QLog.d("MultiPicsOperator", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramRichProtoReq != null) && (paramRichProtoResp != null))
    {
      i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        localObject2 = (PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        localObject3 = (PicResult)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if ((localObject1 instanceof RichProto.RichProtoResp.C2CPicUpResp))
        {
          a(paramRichProtoReq, i, (PicFowardInfo)localObject2, (PicResult)localObject3, (RichProto.RichProtoResp.C2CPicUpResp)localObject1);
        }
        else if ((localObject1 instanceof RichProto.RichProtoResp.GroupPicUpResp))
        {
          a(paramRichProtoReq, i, (PicFowardInfo)localObject2, (PicResult)localObject3, (RichProto.RichProtoResp.GroupPicUpResp)localObject1);
        }
        else
        {
          localObject2 = this.b;
          localObject3 = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unkown response type[");
          localStringBuilder.append(i);
          localStringBuilder.append("] ");
          localStringBuilder.append(localObject1.getClass().getSimpleName());
          Logger.b((String)localObject2, (String)localObject3, "uploadForwardMultiMsgPics.onBusiProtoResp", localStringBuilder.toString());
        }
        i += 1;
      }
    }
    int i = a();
    if (i > 0)
    {
      a(i);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsProtoCallBack
 * JD-Core Version:    0.7.0.1
 */