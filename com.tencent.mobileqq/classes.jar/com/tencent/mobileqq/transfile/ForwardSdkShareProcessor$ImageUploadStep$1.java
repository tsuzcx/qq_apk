package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  ForwardSdkShareProcessor$ImageUploadStep$1(ForwardSdkShareProcessor.ImageUploadStep paramImageUploadStep) {}
  
  public void run()
  {
    int j = 0;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|run|retry=" + ForwardSdkShareProcessor.ImageUploadStep.access$1100(this.this$1));
    if (this.this$1.isCancelled.get())
    {
      this.this$1.doCancel();
      return;
    }
    String str = this.this$1.this$0.app.getCurrentUin();
    long l = System.currentTimeMillis();
    int i;
    byte b;
    if ((!TextUtils.isEmpty(this.this$1.this$0.mLocalImgUrl)) && (TextUtils.isEmpty(this.this$1.this$0.mRemoteImgUrl)))
    {
      i = 1;
      if (i == 0) {
        break label156;
      }
      b = 2;
    }
    Object localObject1;
    label156:
    Object localObject2;
    boolean bool;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.this$1.this$0.mLocalImgUrl;
        if (this.this$1.isCancelled.get())
        {
          this.this$1.doCancel();
          return;
          i = 0;
          break;
          b = 4;
          continue;
        }
        localObject2 = this.this$1.instanceUpload((String)localObject1, l);
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).second))
        {
          this.this$1.this$0.mRemoteImgUrl = ((String)((Pair)localObject2).second);
          ForwardSdkShareProcessor.access$900(this.this$1.this$0).set(true);
          bool = true;
          i = j;
          if (!bool) {}
        }
        else
        {
          try
          {
            localObject2 = new File((String)localObject1).toURL().toString();
            localObject1 = localObject2;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              label290:
              QLog.d("Q.share.ForwardSdkShareProcessor", 1, "srcPath to URL err:" + localMalformedURLException.getMessage());
            }
          }
          ForwardStatisticsReporter.a("reuse_image_for_aio");
          ShareProcessorUtil.a(true, (String)localObject1, this.this$1.this$0.mLocalImgUrl, this.this$1.this$0.mRemoteImgUrl);
          ForwardStatisticsReporter.a("reuse_image_for_aio", str, true);
          b = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = this.this$1.this$0.app.getMessageFacade().b(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq);
      if (((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        ((AbsShareMsg)localObject1).updateCover(this.this$1.this$0.mRemoteImgUrl);
        ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
        this.this$1.this$0.app.getMessageFacade().a(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject1).getBytes());
      }
      ForwardSdkShareProcessor.access$1000(this.this$1.this$0).set(true);
      this.this$1.doNextStep();
      return;
      if (this.this$1.isCancelled.get())
      {
        this.this$1.doCancel();
        return;
      }
      localObject2 = this.this$1.uploadImage(l);
      i = ((Integer)((Pair)localObject2).first).intValue();
      bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      break;
      if ((i == 100000) && (ForwardSdkShareProcessor.access$1200(this.this$1.this$0) < 2))
      {
        ForwardSdkShareProcessor.access$1208(this.this$1.this$0);
        ForwardSdkShareProcessor.access$202(this.this$1.this$0, null);
        ForwardSdkShareProcessor.access$102(this.this$1.this$0, true);
        ForwardSdkShareProcessor.access$1300(this.this$1.this$0);
        return;
      }
      if (ForwardSdkShareProcessor.ImageUploadStep.access$1108(this.this$1) < 2)
      {
        run();
        return;
      }
      this.this$1.this$0.mRemoteImgUrl = this.this$1.this$0.mAppInfo.sourceIconBig;
      if (TextUtils.isEmpty(this.this$1.this$0.mRemoteImgUrl)) {
        this.this$1.this$0.mRemoteImgUrl = "https://pub.idqqimg.com/pc/misc/files/20191015/32ed5b691a1138ac452a59e42f3f83b5.png";
      }
      QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep.process: upload image fail, use default remoteImageUrl instead: " + this.this$1.this$0.mRemoteImgUrl);
      break label290;
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "skip ImageUploadStep change remote url : " + this.this$1.this$0.mRemoteImgUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */