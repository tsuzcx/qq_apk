package com.tencent.mobileqq.pic.operator;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GuildPicDownloadProcessor;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.UrlDownloader;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadPicOperator
  extends BasePicOperator
  implements DownCallBack
{
  DownCallBack h = this;
  private TransferResult j;
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      if (paramTransferRequest.mResult.mResult == -2)
      {
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
        paramBaseTransProcessor.wait();
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "waitfin", "");
        return;
      }
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  private void c(DownCallBack.DownResult paramDownResult)
  {
    if ((paramDownResult != null) && (this.c.l != null) && (paramDownResult.e != null))
    {
      MessageForPic localMessageForPic = this.c.l;
      paramDownResult = new File(paramDownResult.e);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramDownResult)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId == MessageForPic.defaultSuMsgId)
        {
          paramDownResult = ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
          if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramDownResult))
          {
            ((IMsgStructing)QRoute.api(IMsgStructing.class)).updateMsgAfterDownload(this.e, paramDownResult, localMessageForPic);
            return;
          }
          Logger.a(this.b, this.a, "onDownload", "Update GIF flag of MessageForPic");
          ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
          return;
        }
        paramDownResult = ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramDownResult)) {
          ((IMsgMixed)QRoute.api(IMsgMixed.class)).updateMsgAfterDownload(this.e, paramDownResult, localMessageForPic);
        }
      }
    }
  }
  
  TransferRequest a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    paramPicDownloadInfo.d = this.e.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mUinType = paramPicDownloadInfo.c;
    boolean bool;
    if (paramPicDownloadInfo.t == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localTransferRequest.mFileType = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType(paramString, bool);
    localTransferRequest.mUniseq = paramPicDownloadInfo.g;
    localTransferRequest.mSubMsgId = paramPicDownloadInfo.C;
    localTransferRequest.mSelfUin = paramPicDownloadInfo.d;
    localTransferRequest.mPeerUin = paramPicDownloadInfo.e;
    localTransferRequest.mServerPath = paramPicDownloadInfo.n;
    localTransferRequest.mLocalPath = null;
    localTransferRequest.mDownCallBack = this.h;
    localTransferRequest.useOutputstream = false;
    localTransferRequest.bEnableEnc = paramPicDownloadInfo.G;
    localTransferRequest.mOutFilePath = paramPicDownloadInfo.f();
    if ((this.c != null) && (this.c.l != null)) {
      localTransferRequest.mRec = this.c.l;
    }
    paramString = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("outFilePath:");
    localStringBuilder.append(localTransferRequest.mOutFilePath);
    localStringBuilder.append("info.protocol:");
    localStringBuilder.append(paramPicDownloadInfo.l);
    Logger.a(paramString, str, "convert2TranferRequest", localStringBuilder.toString());
    paramString = new TransferRequest.PicDownExtraInfo();
    localTransferRequest.mExtraObj = paramString;
    a(paramPicDownloadInfo, localTransferRequest, paramString);
    localTransferRequest.mMd5 = paramPicDownloadInfo.m;
    localTransferRequest.mGroupFileID = paramPicDownloadInfo.o;
    localTransferRequest.mDbRecVersion = paramPicDownloadInfo.j;
    localTransferRequest.mBusiType = paramPicDownloadInfo.b;
    localTransferRequest.mNeedReport = true;
    localTransferRequest.mDownMode = paramPicDownloadInfo.E;
    localTransferRequest.mMsgTime = paramPicDownloadInfo.u;
    if ((paramPicDownloadInfo.D != null) && (paramPicDownloadInfo.c == 10014))
    {
      localTransferRequest.mExtentionInfo = paramPicDownloadInfo.D.getBytes();
      localTransferRequest.mSecondId = paramPicDownloadInfo.f;
    }
    return localTransferRequest;
  }
  
  public TransferResult a(ITransFileController paramITransFileController, TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    if (paramITransFileController.isWorking().get())
    {
      if (paramTransferRequest.mFileType == 131076) {
        paramITransFileController = new UrlDownloader((BaseTransFileController)paramITransFileController, paramTransferRequest);
      } else if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000))
      {
        if (paramTransferRequest.mUinType == 10014) {
          paramITransFileController = new GuildPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
        } else {
          paramITransFileController = new C2CPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
        }
      }
      else {
        paramITransFileController = new GroupPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
      }
      a(paramTransferRequest, paramITransFileController, BaseTransFileController.makeReceiveKey(paramTransferRequest), true);
    }
    else
    {
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
    }
    return paramTransferRequest.mResult;
  }
  
  public void a()
  {
    if (this.c.n == 1280)
    {
      d(this.c);
      return;
    }
    c(this.c);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.a = 0;
    localPicResult.d = Integer.valueOf(paramInt);
    localPicResult.g = paramBoolean;
    a(1, 0, localPicResult);
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (this.c != null)
    {
      c(paramDownResult);
      b(paramDownResult);
      if (paramDownResult == null)
      {
        paramDownResult = new PicInfoInterface.ErrInfo();
        paramDownResult.b = "result == null";
        paramDownResult.a = "onDownload";
        a(0, paramDownResult);
        return;
      }
      Object localObject1 = this.b;
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result:");
      localStringBuilder.append(paramDownResult.a);
      Logger.a((String)localObject1, (String)localObject2, "onDownload", localStringBuilder.toString());
      localObject1 = new PicResult();
      ((PicResult)localObject1).a = paramDownResult.a;
      ((PicResult)localObject1).d = paramDownResult;
      ((PicResult)localObject1).e = paramDownResult.j;
      if (paramDownResult.a == 0)
      {
        a(0, (PicResult)localObject1);
        return;
      }
      if (paramDownResult.d == null)
      {
        localObject1 = new PicInfoInterface.ErrInfo();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramDownResult.b);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramDownResult.c);
        ((PicInfoInterface.ErrInfo)localObject1).b = ((StringBuilder)localObject2).toString();
        ((PicInfoInterface.ErrInfo)localObject1).a = "onDownload";
        a(0, (PicInfoInterface.ErrInfo)localObject1);
        return;
      }
      a(0, paramDownResult.d);
    }
  }
  
  void a(PicDownloadInfo paramPicDownloadInfo, TransferRequest paramTransferRequest, TransferRequest.PicDownExtraInfo paramPicDownExtraInfo)
  {
    if (paramTransferRequest.mFileType == 65537)
    {
      if (paramPicDownloadInfo.F != null)
      {
        paramPicDownloadInfo.F.e = paramPicDownloadInfo.E;
        paramPicDownloadInfo.F.d = PicPreDownloadUtils.a();
        paramPicDownloadInfo.F.f = (System.currentTimeMillis() - paramPicDownloadInfo.F.b);
        paramPicDownloadInfo.F.a = 1;
      }
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.p;
      return;
    }
    if (paramTransferRequest.mFileType == 1)
    {
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.q;
      if (paramPicDownloadInfo.F != null)
      {
        paramPicDownloadInfo.F.g = paramPicDownloadInfo.E;
        paramPicDownloadInfo.F.i = PicPreDownloadUtils.a();
        paramPicDownloadInfo.F.h = (System.currentTimeMillis() - paramPicDownloadInfo.F.b);
        paramPicDownloadInfo.F.a = 2;
      }
    }
    else if (paramTransferRequest.mFileType == 131075)
    {
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.r;
      if (paramPicDownloadInfo.F != null)
      {
        paramPicDownloadInfo.F.g = paramPicDownloadInfo.E;
        paramPicDownloadInfo.F.i = PicPreDownloadUtils.a();
        paramPicDownloadInfo.F.h = (System.currentTimeMillis() - paramPicDownloadInfo.F.b);
        paramPicDownloadInfo.F.a = 2;
      }
    }
  }
  
  void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "sync ";
    } else {
      str = "aync ";
    }
    if (paramBoolean) {
      ((PicPreDownloadImpl)this.e.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader.a(paramString);
    }
    ConcurrentHashMap localConcurrentHashMap = ((ITransFileController)this.e.getRuntimeService(ITransFileController.class, "")).getProcessMap();
    ??? = (IHttpCommunicatorListener)localConcurrentHashMap.get(paramString);
    if (??? != null) {
      if (!(??? instanceof BaseDownloadProcessor)) {
        break label639;
      }
    }
    for (;;)
    {
      synchronized ((BaseDownloadProcessor)???)
      {
        l1 = ((BaseDownloadProcessor)???).getFileStatus();
        TransferRequest localTransferRequest = ((BaseDownloadProcessor)???).getTransferRequest();
        i = paramTransferRequest.mUinType;
        bool = paramTransferRequest.mIsUp;
        k = paramTransferRequest.mFileType;
        long l2 = paramTransferRequest.mUniseq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("startDownloadProcessor");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("status:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",key:");
        localStringBuilder.append(paramString);
        RichMediaUtil.log(i, bool, k, String.valueOf(l2), str, localStringBuilder.toString());
        if ((l1 != -1L) && (l1 != 2002L))
        {
          if (l1 != 2001L) {
            break label640;
          }
          continue;
          if (l1 != 2003L) {
            continue;
          }
          paramTransferRequest.mResult = localTransferRequest.mResult;
          if (paramTransferRequest.mDownCallBack != null)
          {
            paramBaseTransProcessor = new DownCallBack.DownResult();
            paramBaseTransProcessor.a = 0;
            paramBaseTransProcessor.e = paramTransferRequest.mOutFilePath;
            paramBaseTransProcessor.g = paramTransferRequest.mMd5;
            paramBaseTransProcessor.h = paramTransferRequest.mFileType;
            paramBaseTransProcessor.i = paramTransferRequest.mDownMode;
            paramTransferRequest.mDownCallBack.a(paramBaseTransProcessor);
          }
          return;
          if (paramBaseTransProcessor == null) {
            continue;
          }
          localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
          paramBaseTransProcessor.setKey(paramString);
          if (paramBaseTransProcessor.checkParam() != 0) {
            continue;
          }
          PicPreDownloadUtils.a(this.e, paramTransferRequest);
          paramBaseTransProcessor.start();
          if (!paramBoolean) {
            continue;
          }
          try
          {
            RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
            ???.wait();
          }
          catch (InterruptedException paramTransferRequest)
          {
            paramTransferRequest.printStackTrace();
          }
        }
        paramTransferRequest.mResult = localTransferRequest.mResult;
        if (paramTransferRequest.mDownCallBack != null) {
          ((BaseDownloadProcessor)???).mDownCallBacks.add(paramTransferRequest.mDownCallBack);
        }
        if (paramBoolean) {
          a(paramTransferRequest, (BaseTransProcessor)???);
        }
        return;
      }
      int i = paramTransferRequest.mUinType;
      boolean bool = paramTransferRequest.mIsUp;
      int k = paramTransferRequest.mFileType;
      long l1 = paramTransferRequest.mUniseq;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append("startDownloadProcessor");
      str = ((StringBuilder)???).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("firs time ,key:");
      ((StringBuilder)???).append(paramString);
      RichMediaUtil.log(i, bool, k, String.valueOf(l1), str, ((StringBuilder)???).toString());
      localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
      paramBaseTransProcessor.setKey(paramString);
      if (paramBaseTransProcessor.checkParam() == 0)
      {
        PicPreDownloadUtils.a(this.e, paramTransferRequest);
        paramBaseTransProcessor.start();
        if (paramBoolean) {
          try
          {
            a(paramTransferRequest, paramBaseTransProcessor);
            return;
          }
          finally {}
        }
      }
      label639:
      return;
      label640:
      if (l1 != 2004L) {
        if (l1 != 2005L) {}
      }
    }
  }
  
  boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      String str1 = this.b;
      String str2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicDownloadInfo);
      Logger.a(str1, str2, "checkPicDownloadInfo", localStringBuilder.toString());
      return paramPicDownloadInfo.b();
    }
    Logger.b(this.b, this.a, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  TransferRequest b(PicReq paramPicReq)
  {
    PicDownloadInfo localPicDownloadInfo = paramPicReq.f;
    if (!a(localPicDownloadInfo))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.a = -1;
      paramPicReq.d = localPicDownloadInfo.H;
      this.h.a(paramPicReq);
      return null;
    }
    MessageForPic localMessageForPic = paramPicReq.l;
    int k = paramPicReq.n;
    TransferRequest localTransferRequest = a(localPicDownloadInfo, localPicDownloadInfo.l);
    String str = localTransferRequest.mOutFilePath;
    long l = new File(str).length();
    int i = 0;
    if ((1537 == k) && (l > 0L) && (l < paramPicReq.l.size))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.a = 0;
      paramPicReq.e = localTransferRequest.mOutFilePath;
      paramPicReq.g = localTransferRequest.mMd5;
      paramPicReq.h = localTransferRequest.mFileType;
      paramPicReq.i = localPicDownloadInfo.E;
      paramPicReq.j = true;
      this.h.a(paramPicReq);
      if (QLog.isDevelopLevel())
      {
        paramPicReq = new StringBuilder();
        paramPicReq.append("BasePicOperator.downloadBigPic():head download second pass ");
        paramPicReq.append(str);
        QLog.d("peak_pgjpeg", 4, paramPicReq.toString());
      }
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (l == 0L)
    {
      localTransferRequest.mRequestOffset = 0;
      if (localMessageForPic.mDownloadLength == paramPicReq.l.size)
      {
        localTransferRequest.mRequestLength = 0;
      }
      else
      {
        if (k != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localTransferRequest.mRequestLength = i;
      }
      localStringBuilder.append("nofile:");
    }
    else
    {
      if (l >= paramPicReq.l.size) {
        break label517;
      }
      localTransferRequest.mRequestOffset = localMessageForPic.mDownloadLength;
      localTransferRequest.mRequestLength = 0;
      localStringBuilder.append("part1:");
    }
    paramPicReq = new StringBuilder();
    paramPicReq.append("mRequestOffset is ");
    paramPicReq.append(localTransferRequest.mRequestOffset);
    paramPicReq.append(", mRequestLength is ");
    paramPicReq.append(localTransferRequest.mRequestLength);
    paramPicReq.append(", ");
    localStringBuilder.append(paramPicReq.toString());
    paramPicReq = new StringBuilder();
    paramPicReq.append("outPath is ");
    paramPicReq.append(str);
    localStringBuilder.append(paramPicReq.toString());
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
    }
    localTransferRequest.mRequestDisplayLength = localMessageForPic.mShowLength;
    localTransferRequest.mDisplayOutFilePath = localPicDownloadInfo.g();
    if (!TextUtils.isEmpty(this.e.getAccount())) {
      b((ITransFileController)this.e.getRuntimeService(ITransFileController.class, ""), localTransferRequest);
    }
    return localTransferRequest;
    label517:
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.a = 0;
    paramPicReq.e = localTransferRequest.mOutFilePath;
    paramPicReq.g = localTransferRequest.mMd5;
    paramPicReq.h = localTransferRequest.mFileType;
    paramPicReq.i = localPicDownloadInfo.E;
    paramPicReq.j = false;
    this.h.a(paramPicReq);
    if (QLog.isDevelopLevel())
    {
      paramPicReq = new StringBuilder();
      paramPicReq.append("BasePicOperator.downloadBigPic():complete download second pass");
      paramPicReq.append(str);
      QLog.d("peak_pgjpeg", 4, paramPicReq.toString());
    }
    return null;
  }
  
  public TransferResult b()
  {
    return this.j;
  }
  
  public TransferResult b(ITransFileController paramITransFileController, TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    Object localObject = paramITransFileController.isWorking();
    if (((AtomicBoolean)localObject).get())
    {
      synchronized (paramITransFileController.isWorking())
      {
        if (((AtomicBoolean)localObject).get())
        {
          localObject = this.e;
          if (localObject == null) {}
        }
        try
        {
          if (paramTransferRequest.mFileType == 131076) {
            paramITransFileController = new UrlDownloader((BaseTransFileController)paramITransFileController, paramTransferRequest);
          } else if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000))
          {
            if (paramTransferRequest.mUinType == 10014) {
              paramITransFileController = new GuildPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
            } else {
              paramITransFileController = new C2CPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
            }
          }
          else {
            paramITransFileController = new GroupPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
          }
          a(paramTransferRequest, paramITransFileController, BaseTransFileController.makeReceiveKey(paramTransferRequest), false);
        }
        catch (NullPointerException paramITransFileController)
        {
          label181:
          break label181;
        }
        paramITransFileController = paramTransferRequest.mResult;
        paramITransFileController.mResult = -1;
        paramITransFileController.mErrCode = 9366L;
        paramITransFileController.mErrDesc = "transfilecontroller closed";
        paramITransFileController = paramTransferRequest.mResult;
        return paramITransFileController;
        paramITransFileController = paramTransferRequest.mResult;
        paramITransFileController.mResult = -1;
        paramITransFileController.mErrCode = 9366L;
        paramITransFileController.mErrDesc = "transfilecontroller closed";
        paramITransFileController = paramTransferRequest.mResult;
        return paramITransFileController;
      }
    }
    else
    {
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
      return paramTransferRequest.mResult;
    }
  }
  
  void b(DownCallBack.DownResult paramDownResult)
  {
    ThreadManagerV2.excute(new DownloadPicOperator.1(this, paramDownResult), 128, null, true);
  }
  
  public void c(PicReq paramPicReq)
  {
    Object localObject1 = this.b;
    Object localObject2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject1, (String)localObject2, "downloadPic", localStringBuilder.toString());
    localObject1 = paramPicReq.f;
    if (a((PicDownloadInfo)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(((PicDownloadInfo)localObject1).g);
      this.a = ((StringBuilder)localObject2).toString();
      if (!((PicDownloadInfo)localObject1).l.equals("chatimg"))
      {
        paramPicReq = a((PicDownloadInfo)localObject1, ((PicDownloadInfo)localObject1).l);
        if (!new File(paramPicReq.mOutFilePath).exists())
        {
          b((ITransFileController)this.e.getRuntimeService(ITransFileController.class, ""), paramPicReq);
          return;
        }
        localObject2 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject2).a = 0;
        ((DownCallBack.DownResult)localObject2).e = paramPicReq.mOutFilePath;
        ((DownCallBack.DownResult)localObject2).g = paramPicReq.mMd5;
        ((DownCallBack.DownResult)localObject2).h = paramPicReq.mFileType;
        ((DownCallBack.DownResult)localObject2).i = ((PicDownloadInfo)localObject1).E;
        this.h.a((DownCallBack.DownResult)localObject2);
        return;
      }
      b(paramPicReq);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.a = -1;
    paramPicReq.d = ((PicDownloadInfo)localObject1).H;
    this.h.a(paramPicReq);
  }
  
  void d(PicReq paramPicReq)
  {
    Object localObject1 = paramPicReq.f;
    Object localObject2 = ((PicDownloadInfo)localObject1).l;
    paramPicReq = paramPicReq.r;
    Object localObject3 = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject3, str, "downloadPicSync", localStringBuilder.toString());
    if (a((PicDownloadInfo)localObject1))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.a);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(((PicDownloadInfo)localObject1).g);
      this.a = ((StringBuilder)localObject3).toString();
      localObject3 = (ITransFileController)this.e.getRuntimeService(ITransFileController.class, "");
      localObject1 = a((PicDownloadInfo)localObject1, (String)localObject2);
      if ((((TransferRequest)localObject1).mExtraObj != null) && ((((TransferRequest)localObject1).mExtraObj instanceof TransferRequest.PicDownExtraInfo)) && (paramPicReq != null) && ((paramPicReq instanceof URLDrawableHandler))) {
        ((TransferRequest.PicDownExtraInfo)((TransferRequest)localObject1).mExtraObj).mHandler = ((URLDrawableHandler)paramPicReq);
      }
      this.j = a((ITransFileController)localObject3, (TransferRequest)localObject1);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.a = -1;
    paramPicReq.d = ((PicDownloadInfo)localObject1).H;
    this.h.a(paramPicReq);
    paramPicReq = new TransferResult();
    paramPicReq.mResult = -1;
    paramPicReq.mErrCode = 9302L;
    if (((PicDownloadInfo)localObject1).H != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadPicSync,");
      ((StringBuilder)localObject2).append(((PicDownloadInfo)localObject1).H.b);
      paramPicReq.mErrDesc = ((StringBuilder)localObject2).toString();
    }
    else
    {
      paramPicReq.mErrDesc = "downloadPicSync param check error";
    }
    this.j = paramPicReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.DownloadPicOperator
 * JD-Core Version:    0.7.0.1
 */