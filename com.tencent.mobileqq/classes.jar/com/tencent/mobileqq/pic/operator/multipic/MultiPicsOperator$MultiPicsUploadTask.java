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
  public String a;
  public String b;
  WeakReference<AppInterface> c;
  ArrayList<PicResult> d;
  List<PicFowardInfo> e;
  final RichProtoProc.RichProtoCallback f;
  
  public MultiPicsOperator$MultiPicsUploadTask(AppInterface paramAppInterface, List<PicFowardInfo> paramList)
  {
    this.a = paramAppInterface.a;
    this.b = paramAppInterface.b;
    this.c = new WeakReference(paramList);
    Object localObject;
    this.e = localObject;
    this.d = new ArrayList(localObject.size());
    int i = 0;
    while (i < localObject.size())
    {
      paramList = new PicResult();
      paramList.c = paramAppInterface.c;
      this.d.add(paramList);
      i += 1;
    }
    this.f = new MultiPicsProtoCallBack(this, MultiPicsOperator.a(paramAppInterface), this.c);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    int i = 0;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      int j = this.e.size();
      paramVarArgs = null;
      if (i >= j) {
        break;
      }
      localObject2 = (PicFowardInfo)this.e.get(i);
      RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = ((AppInterface)this.c.get()).getAccount();
      localPicUpReq.peerUin = MultiPicsOperator.b(this.g).frienduin;
      localPicUpReq.uinType = MultiPicsOperator.c(this.g).istroop;
      localPicUpReq.secondUin = MultiPicsOperator.d(this.g).senderuin;
      boolean bool;
      if (localPicUpReq.uinType == 1006) {
        bool = true;
      } else {
        bool = false;
      }
      localPicUpReq.isContact = bool;
      localPicUpReq.md5 = HexUtil.hexStr2Bytes(((PicFowardInfo)localObject2).b.m);
      if (((PicFowardInfo)localObject2).b.F == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localPicUpReq.isRaw = bool;
      if (((PicFowardInfo)localObject2).e == 2) {
        localPicUpReq.isRaw = true;
      }
      Object localObject3;
      if ((((PicFowardInfo)localObject2).b.C != 0) && (((PicFowardInfo)localObject2).b.D != 0) && (0L != ((PicFowardInfo)localObject2).b.E))
      {
        paramVarArgs = this.g.b;
        localObject1 = this.g.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] Get width/height/filesize from UploadInfo");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localPicUpReq.width = ((PicFowardInfo)localObject2).b.C;
        localPicUpReq.height = ((PicFowardInfo)localObject2).b.D;
        localPicUpReq.fileSize = ((PicFowardInfo)localObject2).b.E;
      }
      else
      {
        localObject1 = this.g.b;
        localObject3 = this.g.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("] Get width/height/filesize from File");
        Logger.a((String)localObject1, (String)localObject3, "uploadForwardMultiMsgPics", localStringBuilder.toString());
        if (FileUtils.fileExistsAndNotEmpty(((PicFowardInfo)localObject2).b.n))
        {
          paramVarArgs = ((PicFowardInfo)localObject2).b.n;
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
          localObject1 = this.g.b;
          localObject3 = this.g.a;
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
        paramVarArgs = this.g.b;
        localObject1 = this.g.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] is C2C message");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localRichProtoReq.protoKey = "c2c_pic_up";
      }
      else
      {
        paramVarArgs = this.g.b;
        localObject1 = this.g.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] is Troop/Discussion message");
        Logger.a(paramVarArgs, (String)localObject1, "uploadForwardMultiMsgPics", ((StringBuilder)localObject3).toString());
        localRichProtoReq.protoKey = "grp_pic_up";
      }
      localPicUpReq.fileName = ((PicFowardInfo)localObject2).b.m;
      localRichProtoReq.reqs.add(localPicUpReq);
      i += 1;
    }
    if (!localRichProtoReq.reqs.isEmpty())
    {
      localRichProtoReq.callback = this.f;
      localRichProtoReq.protoReqMgr = ((IProtoReqManager)((AppInterface)this.c.get()).getRuntimeService(IProtoReqManager.class, ""));
      paramVarArgs = this.g.b;
      localObject1 = this.g.a;
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
    this.g.h.addAll(this.d);
    this.g.b();
  }
  
  public void a(PicResult paramPicResult)
  {
    MultiPicsOperator.a(this.g, 6, 0, paramPicResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator.MultiPicsUploadTask
 * JD-Core Version:    0.7.0.1
 */