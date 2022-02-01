package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBaseDecorator;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PicUploadExtra;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

public class UploadPicOperator
  extends BasePicOperator
  implements UpCallBack, IPicInfoBuilder.UploadInfoBuilder
{
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.a, "attachRichText2Msg", "");
    if ((this.i != null) && ((this.i instanceof MessageForRichText))) {
      ((MessageForRichText)this.i).richText = paramRichText;
    }
    return this.i;
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = b(paramIntent);
      if (localObject == null) {
        return null;
      }
      localObject = ((PicUploadInfo.Builder)localObject).k();
      int i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        String str = paramIntent.getStringExtra("key_qzone_album_id");
        ((PicUploadInfo)localObject).L = i;
        ((PicUploadInfo)localObject).O = str;
        ((PicUploadInfo)localObject).N = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((PicUploadInfo)localObject).P = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((PicUploadInfo)localObject).Q = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      boolean bool1 = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
      boolean bool2 = paramIntent.getBooleanExtra("HOT_PIC_SEND_PIC", false);
      i = paramIntent.getIntExtra("key_pic_send_source", 0);
      if (((PicUploadInfo)localObject).ac == null) {
        ((PicUploadInfo)localObject).ac = new PicUploadExtra();
      }
      ((PicUploadInfo)localObject).ac.h = i;
      ((PicUploadInfo)localObject).ac.f = bool1;
      ((PicUploadInfo)localObject).ac.g = bool2;
      Logger.a(this.b, this.a, "createPicUploadInfo", "");
      return localObject;
    }
    Logger.a(this.b, this.a, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  protected PicUploadInfo a(PicUploadInfo paramPicUploadInfo)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramPicUploadInfo.n, 0);
    CompressOperator.b(localCompressInfo);
    if (localCompressInfo.l != null)
    {
      paramPicUploadInfo.o = localCompressInfo.l;
      paramPicUploadInfo.p = localCompressInfo.m;
      paramPicUploadInfo.q = localCompressInfo.n;
    }
    return paramPicUploadInfo;
  }
  
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    b();
    Object localObject1 = c(a(paramPicUploadInfo));
    if (localObject1 == null)
    {
      Logger.a(this.b, "doSendPic", "error, mr==null, return");
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doSendPic, entrance: ");
      ((StringBuilder)localObject2).append(((MessageForPic)localObject1).msgVia);
      QLog.d("MsgVia", 2, ((StringBuilder)localObject2).toString());
    }
    a((MessageRecord)localObject1, paramPicReq);
    if (MessageForPic.class.isInstance(localObject1))
    {
      a(paramPicReq, (MessageRecord)localObject1, paramPicUploadInfo);
      b((MessageForPic)localObject1);
    }
    if ((((MessageRecord)localObject1).istroop == 1) && (paramPicUploadInfo.ad == null)) {
      ((IDep)QRoute.api(IDep.class)).bindAnonymousInfo((MessageRecord)localObject1);
    }
    if (paramPicUploadInfo.w) {
      try
      {
        paramPicUploadInfo.i = localObject1;
        paramPicUploadInfo.notifyAll();
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("PresendStatus: destPath:");
        ((StringBuilder)localObject3).append(paramPicUploadInfo.n);
        ((StringBuilder)localObject3).append(",uuid:");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        Logger.a(localObject2, "doSendPic ", ((StringBuilder)localObject3).toString());
        if (paramPicUploadInfo.h == 3)
        {
          Logger.a(this.b, this.a, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          paramPicReq = this.b;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PresendStatus: destPath:");
          ((StringBuilder)localObject1).append(paramPicUploadInfo.n);
          ((StringBuilder)localObject1).append(",uuid:");
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          Logger.a(paramPicReq, "doSendPic", ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      finally {}
    }
    this.i = ((MessageRecord)localObject1);
    long l = System.currentTimeMillis();
    paramPicReq = a(paramPicReq, paramPicUploadInfo, (MessageRecord)localObject1);
    if (paramPicUploadInfo.w) {
      try
      {
        if (paramPicUploadInfo.x)
        {
          Logger.a(this.b, this.a, "PresendPic doSendPic cancel transferAsync!", "");
          paramPicReq = this.b;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PresendStatus: destPath:");
          ((StringBuilder)localObject1).append(paramPicUploadInfo.n);
          ((StringBuilder)localObject1).append(",uuid:");
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
          Logger.a(paramPicReq, "doSendPic ", ((StringBuilder)localObject1).toString());
          return null;
        }
        Logger.a(this.b, this.a, "PresendPic doSendPic start transferAsync!", "");
        ((ITransFileController)this.e.getRuntimeService(ITransFileController.class, "")).transferAsync(paramPicReq);
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("PresendStatus: destPath:");
        ((StringBuilder)localObject3).append(paramPicUploadInfo.n);
        ((StringBuilder)localObject3).append(",uuid:");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        Logger.a(localObject2, "doSendPic ", ((StringBuilder)localObject3).toString());
      }
      finally {}
    } else {
      ((ITransFileController)this.e.getRuntimeService(ITransFileController.class, "")).transferAsync(paramPicReq);
    }
    Object localObject2 = this.b;
    Object localObject3 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a((String)localObject2, (String)localObject3, "sendReq", localStringBuilder.toString());
    if ((paramPicUploadInfo.v) && (!paramPicUploadInfo.w))
    {
      Logger.a(this.b, this.a, "sendPic", "@#addMsg");
      a((MessageRecord)localObject1, paramPicUploadInfo.T);
    }
    Logger.a(this.b, this.a, "getSendTask.start", "");
    return paramPicReq;
  }
  
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo, MessageRecord paramMessageRecord)
  {
    paramPicReq = new TransferRequest();
    paramPicReq.mSelfUin = this.e.getAccount();
    paramPicReq.mPeerUin = paramMessageRecord.frienduin;
    paramPicReq.mSecondId = paramMessageRecord.senderuin;
    paramPicReq.mUinType = paramMessageRecord.istroop;
    boolean bool = true;
    paramPicReq.mFileType = 1;
    paramPicReq.mUniseq = paramMessageRecord.uniseq;
    paramPicReq.mIsUp = true;
    paramPicReq.mBusiType = paramPicUploadInfo.b;
    paramPicReq.mLocalPath = paramPicUploadInfo.n;
    paramPicReq.mMd5 = paramPicUploadInfo.m;
    paramMessageRecord = new TransferRequest.PicUpExtraInfo();
    if (paramPicUploadInfo.j() != 1) {
      bool = false;
    }
    paramMessageRecord.mIsRaw = bool;
    paramPicReq.mExtraObj = paramMessageRecord;
    paramPicReq.mUpCallBack = this;
    paramPicReq.mRec = this.i;
    paramPicReq.mIsPresend = paramPicUploadInfo.w;
    paramPicReq.myPresendInvalid = paramPicUploadInfo.y;
    if (paramPicUploadInfo.ac != null) {
      paramPicReq.mPicSendSource = paramPicUploadInfo.ac.h;
    }
    return paramPicReq;
  }
  
  String a(String paramString)
  {
    str = "";
    long l = System.currentTimeMillis();
    try
    {
      try
      {
        localObject = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
        paramString = (String)localObject;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject;
      label34:
      break label34;
    }
    localObject = new File(paramString);
    paramString = str;
    if (((File)localObject).exists()) {}
    try
    {
      paramString = MD5FileUtil.a((File)localObject);
      if (paramString == null) {
        paramString = "";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        paramString = str;
      }
    }
    str = this.b;
    localObject = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("md5:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(str, (String)localObject, "calcMD5", localStringBuilder.toString());
    return paramString;
  }
  
  public void a()
  {
    b(this.c);
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindConfessInfo((BaseQQAppInterface)this.e, paramMessageForPic, paramPicUploadInfo.e, paramPicUploadInfo.c, paramPicUploadInfo.K);
    if (paramPicUploadInfo.c == 0) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo((BaseQQAppInterface)this.e, paramMessageForPic, paramPicUploadInfo.e);
    } else if (paramPicUploadInfo.c == 1) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo((BaseQQAppInterface)this.e, paramMessageForPic, paramPicUploadInfo.e);
    }
    if (paramPicUploadInfo.L == 1)
    {
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramPicUploadInfo.O);
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramPicUploadInfo.N));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramPicUploadInfo.s));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramPicUploadInfo.P));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramPicUploadInfo.Q));
    }
    if (paramPicUploadInfo.c == 10007) {
      RoleIdUtil.c(paramMessageForPic);
    }
    if (paramPicUploadInfo.V) {
      paramMessageForPic.isStoryPhoto = true;
    }
    PicMessageExtraData localPicMessageExtraData2 = paramMessageForPic.picExtraData;
    PicMessageExtraData localPicMessageExtraData1 = localPicMessageExtraData2;
    if (localPicMessageExtraData2 == null) {
      localPicMessageExtraData1 = new PicMessageExtraData();
    }
    if (paramPicUploadInfo.h()) {
      localPicMessageExtraData1.imageBizType = 13;
    } else if (paramPicUploadInfo.i()) {
      localPicMessageExtraData1.imageBizType = 2;
    }
    paramMessageForPic.picExtraData = localPicMessageExtraData1;
  }
  
  protected void a(MessageRecord paramMessageRecord, PicReq paramPicReq)
  {
    ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(paramMessageRecord.uniseq, 0L, paramPicReq.m);
  }
  
  protected void a(PicReq paramPicReq, MessageRecord paramMessageRecord, PicUploadInfo paramPicUploadInfo)
  {
    Object localObject1;
    if (paramPicReq.i != null)
    {
      localObject1 = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject1).picExtraData = paramPicReq.i;
      localObject2 = paramPicReq.i;
      ((IDep)QRoute.api(IDep.class)).fillStickInfo((MessageForPic)localObject1, (PicMessageExtraData)localObject2);
    }
    Object localObject2 = (MessageForPic)paramMessageRecord;
    if (((MessageForPic)localObject2).checkGif())
    {
      localObject1 = ((MessageForPic)localObject2).picExtraData;
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject1 == null) {
        paramMessageRecord = new PicMessageExtraData();
      }
      if (TextUtils.isEmpty(paramMessageRecord.textSummary)) {
        paramMessageRecord.textSummary = this.e.getApp().getString(2131888229);
      }
      paramMessageRecord.emojiPkgId = String.valueOf(paramPicUploadInfo.ab);
      paramMessageRecord.from = paramPicUploadInfo.W;
      paramMessageRecord.source = paramPicUploadInfo.X;
      paramMessageRecord.webUrl = paramPicUploadInfo.Y;
      paramMessageRecord.iconUrl = paramPicUploadInfo.Z;
      paramMessageRecord.packageName = paramPicUploadInfo.aa;
      if ((paramMessageRecord.imageBizType <= 0) && ((paramPicReq.b == 1050) || (paramPicReq.b == 1051) || (paramPicReq.b == 1052))) {
        paramMessageRecord.imageBizType = 11;
      }
      ((MessageForPic)localObject2).picExtraData = paramMessageRecord;
    }
    if ((paramPicUploadInfo.ac != null) && (!TextUtils.isEmpty(paramPicUploadInfo.ac.a)))
    {
      localObject1 = ((MessageForPic)localObject2).picExtraData;
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject1 == null) {
        paramMessageRecord = new PicMessageExtraData();
      }
      paramMessageRecord.mTemplateId = paramPicUploadInfo.ac.a;
      paramMessageRecord.mTemplateName = paramPicUploadInfo.ac.b;
      ((MessageForPic)localObject2).picExtraData = paramMessageRecord;
    }
    if (paramPicReq.b == 1053)
    {
      paramMessageRecord = ((MessageForPic)localObject2).picExtraData;
      paramPicReq = paramMessageRecord;
      if (paramMessageRecord == null) {
        paramPicReq = new PicMessageExtraData();
      }
      paramPicReq.imageBizType = 14;
      ((MessageForPic)localObject2).picExtraData = paramPicReq;
    }
  }
  
  void a(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    Object localObject = new File(paramPicUploadInfo.n);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        paramMessageForPic.imageType = 2000;
      } else {
        paramMessageForPic.imageType = PicBusUtil.c(paramPicUploadInfo.n);
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(paramPicUploadInfo.n, (BitmapFactory.Options)localObject);
      paramMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      paramMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(paramPicUploadInfo.n))
      {
        paramMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        paramMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel())
        {
          paramPicUploadInfo = this.b;
          String str = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" pic is Landscape,swap w,h; options.outWidth = ");
          localStringBuilder.append(((BitmapFactory.Options)localObject).outWidth);
          localStringBuilder.append(",options.outHeight = ");
          localStringBuilder.append(((BitmapFactory.Options)localObject).outHeight);
          localStringBuilder.append(",mr.width = ");
          localStringBuilder.append(paramMessageForPic.width);
          localStringBuilder.append(",mr.height = ");
          localStringBuilder.append(paramMessageForPic.height);
          Logger.a(paramPicUploadInfo, str, "packMsg", localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Object localObject = this.b;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resut:");
      localStringBuilder.append(paramSendResult);
      Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
      localObject = (MessageForPic)this.i;
      ((MessageForPic)localObject).size = paramSendResult.e;
      ((MessageForPic)localObject).uuid = paramSendResult.f;
      ((MessageForPic)localObject).groupFileID = paramSendResult.h;
      ((MessageForPic)localObject).md5 = paramSendResult.g;
      try
      {
        if ((((MessageForPic)localObject).picExtraData != null) && (paramSendResult.o != null) && (this.i.istroop == 10014)) {
          ((MessageForPic)localObject).picExtraData.mDownloadIndex = new String(paramSendResult.o, "utf-8");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateMsg error:  index");
          localStringBuilder.append(Arrays.toString(paramSendResult.o));
          localStringBuilder.append(localUnsupportedEncodingException);
          QLog.d("UploadPicOperator", 2, localStringBuilder.toString());
        }
      }
      ((MessageForPic)localObject).serial();
      c((MessageForPic)localObject);
    }
  }
  
  protected PicUploadInfo.Builder b(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("troop_uin");
    int i = paramIntent.getIntExtra("uintype", 1003);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    String str3 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
    int m = paramIntent.getIntExtra("entrance", 0);
    int n = paramIntent.getIntExtra("key_confess_topicid", 0);
    boolean bool = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
    String str1 = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.d((String)localObject);
    localBuilder.a(str3);
    localBuilder.e(i);
    localBuilder.e(str2);
    localBuilder.d(k);
    localBuilder.f(j);
    localBuilder.l(n);
    localBuilder.k(m);
    localBuilder.a(bool);
    if (!TextUtils.isEmpty(str1))
    {
      localObject = new PicUploadExtra();
      ((PicUploadExtra)localObject).a = str1;
      ((PicUploadExtra)localObject).b = paramIntent;
      localBuilder.a((PicUploadExtra)localObject);
    }
    return localBuilder;
  }
  
  void b()
  {
    this.e.getHwEngine().preConnect();
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    ((IPicHelper)QRoute.api(IPicHelper.class)).cachePicToDisk(paramMessageForPic);
  }
  
  public void b(PicReq paramPicReq)
  {
    Logger.a(this.b, this.a, "sendPic.start", "");
    if (b(paramPicReq.g))
    {
      c(paramPicReq);
      return;
    }
    a(3, paramPicReq.g.H);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(3, null);
      return;
    }
    if ((this.c != null) && ((this.c.a == 2) || (this.c.a == 4)))
    {
      if (paramSendResult.a == 0)
      {
        a(paramSendResult);
        c(paramSendResult);
        localObject = new PicResult();
        ((PicResult)localObject).a = 0;
        ((PicResult)localObject).d = paramSendResult;
        a(3, (PicResult)localObject);
        return;
      }
      Object localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.c;
      a(3, (PicInfoInterface.ErrInfo)localObject);
    }
  }
  
  protected boolean b(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      String str1 = this.b;
      String str2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicUploadInfo);
      Logger.a(str1, str2, "checkPicUploadInfo", localStringBuilder.toString());
      if ((paramPicUploadInfo.b()) && (d(paramPicUploadInfo))) {
        return true;
      }
    }
    else
    {
      Logger.b(this.b, this.a, "checkPicUploadInfo", "info == null");
    }
    return false;
  }
  
  public MessageRecord c(PicUploadInfo paramPicUploadInfo)
  {
    long l = System.currentTimeMillis();
    if (paramPicUploadInfo != null)
    {
      MessageForPic localMessageForPic = (MessageForPic)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.e, paramPicUploadInfo.e, paramPicUploadInfo.f, paramPicUploadInfo.c);
      localMessageForPic.busiType = paramPicUploadInfo.b;
      localMessageForPic.path = paramPicUploadInfo.n;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramPicUploadInfo.s == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      localMessageForPic.localUUID = paramPicUploadInfo.a;
      Object localObject = this.b;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMessageForPic.localUUID);
      localStringBuilder.append("|");
      localStringBuilder.append(localMessageForPic.uniseq);
      Logger.a((String)localObject, str, "bindUrlKeyAndUniseq", localStringBuilder.toString());
      localMessageForPic.md5 = a(localMessageForPic.path);
      c(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.thumbWidth = paramPicUploadInfo.p;
      localMessageForPic.thumbHeight = paramPicUploadInfo.q;
      a(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.extLong = paramPicUploadInfo.A;
      localMessageForPic.extStr = paramPicUploadInfo.B;
      localMessageForPic.msgVia = paramPicUploadInfo.I;
      localMessageForPic.sync2Story = paramPicUploadInfo.M;
      str = MessageConstants.m;
      if (localMessageForPic.sync2Story) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
      a(localMessageForPic, paramPicUploadInfo);
      localObject = paramPicUploadInfo.r;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        b(paramPicUploadInfo, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
      localMessageForPic.serial();
      if (localMessageForPic.istroop == 10014) {
        ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(localMessageForPic, ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildIdOf(localMessageForPic.frienduin));
      }
      paramPicUploadInfo.g = localMessageForPic.uniseq;
      localObject = this.b;
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      Logger.a((String)localObject, str, "packMsg", localStringBuilder.toString());
      a(localMessageForPic);
      localMessageForPic.DSKey = paramPicUploadInfo.u;
      return localMessageForPic;
    }
    return null;
  }
  
  void c(MessageForPic paramMessageForPic)
  {
    ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.i.frienduin, this.i.istroop, this.i.uniseq, paramMessageForPic.msgData);
  }
  
  protected void c(PicReq paramPicReq)
  {
    PicUploadInfo localPicUploadInfo = paramPicReq.g;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(new UploadPicOperator.2(this, paramPicReq, localPicUploadInfo), 16, null, false);
      return;
    }
    a(paramPicReq, localPicUploadInfo);
  }
  
  void c(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramMessageForPic.thumbMsgUrl = paramPicUploadInfo.o;
  }
  
  void c(UpCallBack.SendResult paramSendResult)
  {
    PicStatisticsManager localPicStatisticsManager = ((PicPreDownloadImpl)this.e.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
    if (localPicStatisticsManager != null) {
      localPicStatisticsManager.a(13057, paramSendResult.e);
    }
  }
  
  protected boolean d(PicUploadInfo paramPicUploadInfo)
  {
    Object localObject = paramPicUploadInfo.n;
    int i = paramPicUploadInfo.s;
    int j = paramPicUploadInfo.b;
    localObject = PhotoIncompatibleBase.c((String)localObject);
    boolean bool2 = true;
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = new PhotoIncompatibleBaseDecorator((PhotoIncompatibleBase)localObject);
      if (i == 1)
      {
        localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
        if (localObject != null)
        {
          paramPicUploadInfo.n = ((String)localObject);
          break label165;
        }
        paramPicUploadInfo.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
      }
      else if (j == 1006)
      {
        localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
        if (localObject != null)
        {
          paramPicUploadInfo.n = ((String)localObject);
          break label165;
        }
        paramPicUploadInfo.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("incompatible file,and not PROTOCOL_RAW_PIC:");
        ((StringBuilder)localObject).append(i);
        paramPicUploadInfo.a("PicBaseInfo.check", ((StringBuilder)localObject).toString());
      }
      bool1 = false;
      label165:
      bool2 = bool1;
      if (!bool1)
      {
        ThreadManagerV2.getUIHandlerV2().post(new UploadPicOperator.1(this));
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.UploadPicOperator
 * JD-Core Version:    0.7.0.1
 */