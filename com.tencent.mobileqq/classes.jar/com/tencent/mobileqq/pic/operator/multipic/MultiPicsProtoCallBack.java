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
  boolean a = false;
  MessageRecord b;
  
  public MultiPicsProtoCallBack(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, MessageRecord paramMessageRecord, WeakReference<AppInterface> paramWeakReference)
  {
    super(paramMultiPicsUploadTask, paramWeakReference);
    this.b = paramMessageRecord;
  }
  
  private String a(PicFowardInfo paramPicFowardInfo)
  {
    int i;
    if (paramPicFowardInfo.b.F == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramPicFowardInfo.e >= 0) {
      return paramPicFowardInfo.b.n;
    }
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramPicFowardInfo.b.n);
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject1 = new CompressInfo(paramPicFowardInfo.b.n, 0, 1009);
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).l;
      localObject2 = this.f;
      localObject3 = this.e;
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
        paramPicFowardInfo = this.f;
        localObject1 = this.e;
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
          ((CompressInfo)localObject1).b = 1009;
          ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
          localObject2 = ((CompressInfo)localObject1).l;
          localObject1 = this.f;
          localObject3 = this.e;
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
          localObject1 = this.f;
          localObject2 = this.e;
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
  
  private boolean b(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Object localObject = this.f;
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicFowardInfo);
      Logger.a((String)localObject, str, "checkFowardPicInfo", localStringBuilder.toString());
      if (paramPicFowardInfo.b == null)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramPicFowardInfo.b.c == 1000) || (paramPicFowardInfo.b.c == 1020) || (paramPicFowardInfo.b.c == 1004)) && (paramPicFowardInfo.b.f == null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("secondId invalid,uinType:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.b.c);
        ((StringBuilder)localObject).append(",secondId:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.b.f);
        paramPicFowardInfo.a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
        return false;
      }
      if (paramPicFowardInfo.b.s == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("protocolType invalid,protocolType:");
        ((StringBuilder)localObject).append(paramPicFowardInfo.b.s);
        paramPicFowardInfo.a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
        return false;
      }
      if (a(paramPicFowardInfo) != null) {
        return true;
      }
      paramPicFowardInfo.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    Logger.b(this.f, this.e, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void d()
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
    for (int i = 0; paramInt < this.h.size(); i = j)
    {
      localObject1 = (PicFowardInfo)this.i.get(paramInt);
      Object localObject2 = (PicResult)this.h.get(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  ");
        localStringBuilder.append(((PicFowardInfo)localObject1).b.n);
        QLog.d("MultiPicsOperator", 2, localStringBuilder.toString());
      }
      j = i;
      if (((PicResult)localObject2).a == -2)
      {
        j = i;
        if (!b((PicFowardInfo)localObject1))
        {
          ((PicFowardInfo)localObject1).b.n = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getPicDefaultPath();
          ((PicFowardInfo)localObject1).b.m = FileUtils.calcMd5(((PicFowardInfo)localObject1).b.n);
          ((PicFowardInfo)localObject1).b.F = 1;
          ((PicFowardInfo)localObject1).b.C = 242;
          ((PicFowardInfo)localObject1).b.D = 192;
          ((PicFowardInfo)localObject1).b.E = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getPicDefaultSize();
          ((PicFowardInfo)localObject1).b.o = ((PicFowardInfo)localObject1).b.n;
          ((PicFowardInfo)localObject1).b.q = 192;
          ((PicFowardInfo)localObject1).b.p = 242;
          ((PicFowardInfo)localObject1).c.m = ((PicFowardInfo)localObject1).b.m;
          ((PicResult)localObject2).f = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  ");
            ((StringBuilder)localObject2).append(((PicFowardInfo)localObject1).b.n);
            QLog.d("MultiPicsOperator", 2, ((StringBuilder)localObject2).toString());
          }
          j = 1;
        }
      }
      paramInt += 1;
    }
    if ((i != 0) && (!this.a))
    {
      this.a = true;
      this.j.a(new Void[0]);
      return;
    }
    this.a = false;
    d();
  }
  
  protected void a(RichProto.RichProtoReq paramRichProtoReq, int paramInt, PicFowardInfo paramPicFowardInfo, PicResult paramPicResult, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp)
  {
    Object localObject = this.f;
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CPicUpResp[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("],");
    localStringBuilder.append(paramC2CPicUpResp.toString());
    Logger.a((String)localObject, str, "uploadForwardMultiMsgPics.onBusiProtoResp", localStringBuilder.toString());
    if ((paramC2CPicUpResp.result == 0) && (paramC2CPicUpResp.isExist))
    {
      paramRichProtoReq = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(paramInt), paramC2CPicUpResp, paramInt);
      if ((paramPicFowardInfo.c.c != 1) && (paramPicFowardInfo.c.c != 3000))
      {
        if (paramRichProtoReq != null)
        {
          paramPicResult.a = 0;
          paramPicResult.d = paramRichProtoReq;
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
        paramPicFowardInfo = this.f;
        paramC2CPicUpResp = this.e;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convert2CustomFace for [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("] ");
        Logger.a(paramPicFowardInfo, paramC2CPicUpResp, "uploadForwardMultiMsgPics.onBusiProtoResp", ((StringBuilder)localObject).toString());
        paramRichProtoReq = a(paramRichProtoReq);
        if (paramRichProtoReq != null)
        {
          paramPicResult.a = 0;
          paramPicResult.d = paramRichProtoReq;
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
    Object localObject = this.f;
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GroupPicUpResp[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("],");
    localStringBuilder.append(paramGroupPicUpResp.toString());
    Logger.a((String)localObject, str, "uploadForwardMultiMsgPics.onBusiProtoResp", localStringBuilder.toString());
    if ((paramGroupPicUpResp.result == 0) && (paramGroupPicUpResp.isExist))
    {
      paramRichProtoReq = a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(paramInt), paramGroupPicUpResp, paramInt);
      if ((paramPicFowardInfo.c.c != 1) && (paramPicFowardInfo.c.c != 3000))
      {
        paramPicFowardInfo = this.f;
        paramGroupPicUpResp = this.e;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convert2NotOnlineImage for [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("] ");
        Logger.a(paramPicFowardInfo, paramGroupPicUpResp, "uploadForwardMultiMsgPics.onBusiProtoResp", ((StringBuilder)localObject).toString());
        paramRichProtoReq = a(paramRichProtoReq);
        if (paramRichProtoReq != null)
        {
          paramPicResult.a = 0;
          paramPicResult.d = paramRichProtoReq;
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
        paramPicResult.a = 0;
        paramPicResult.d = paramRichProtoReq;
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
    Object localObject1 = this.f;
    Object localObject2 = this.e;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("start,remiao:");
    ((StringBuilder)localObject3).append(this.a);
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
        localObject2 = (PicFowardInfo)this.i.get(i);
        localObject3 = (PicResult)this.h.get(i);
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
          localObject2 = this.f;
          localObject3 = this.e;
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
    int i = c();
    if (i > 0)
    {
      a(i);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsProtoCallBack
 * JD-Core Version:    0.7.0.1
 */