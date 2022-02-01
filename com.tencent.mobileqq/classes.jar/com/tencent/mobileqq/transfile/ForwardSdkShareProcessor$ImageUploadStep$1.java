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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ImageUploadStep|run|retry=");
    ((StringBuilder)localObject1).append(ForwardSdkShareProcessor.ImageUploadStep.access$1100(this.this$1));
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    if (this.this$1.isCancelled.get())
    {
      this.this$1.doCancel();
      return;
    }
    String str = this.this$1.this$0.app.getCurrentUin();
    long l = System.currentTimeMillis();
    boolean bool = TextUtils.isEmpty(this.this$1.this$0.mLocalImgUrl);
    int j = 0;
    int i;
    if ((!bool) && (TextUtils.isEmpty(this.this$1.this$0.mRemoteImgUrl))) {
      i = 1;
    } else {
      i = 0;
    }
    byte b;
    if (i != 0) {
      b = 2;
    } else {
      b = 4;
    }
    if (i != 0)
    {
      localObject1 = this.this$1.this$0.mLocalImgUrl;
      if (this.this$1.isCancelled.get())
      {
        this.this$1.doCancel();
        return;
      }
      Object localObject2 = this.this$1.instanceUpload((String)localObject1, l);
      if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).second))
      {
        this.this$1.this$0.mRemoteImgUrl = ((String)((Pair)localObject2).second);
        ForwardSdkShareProcessor.access$900(this.this$1.this$0).set(true);
        bool = true;
        i = j;
      }
      else
      {
        if (this.this$1.isCancelled.get())
        {
          this.this$1.doCancel();
          return;
        }
        localObject2 = this.this$1.uploadImage(l);
        i = ((Integer)((Pair)localObject2).first).intValue();
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (bool)
      {
        try
        {
          localObject2 = new File((String)localObject1).toURL().toString();
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("srcPath to URL err:");
          localStringBuilder.append(localMalformedURLException.getMessage());
          QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
        }
        ForwardStatisticsReporter.a("reuse_image_for_aio");
        ShareProcessorUtil.a(true, (String)localObject1, this.this$1.this$0.mLocalImgUrl, this.this$1.this$0.mRemoteImgUrl);
        ForwardStatisticsReporter.a("reuse_image_for_aio", str, true);
      }
      else
      {
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
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ImageUploadStep.process: upload image fail, use default remoteImageUrl instead: ");
        ((StringBuilder)localObject1).append(this.this$1.this$0.mRemoteImgUrl);
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
      }
      b = 1;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("skip ImageUploadStep change remote url : ");
      ((StringBuilder)localObject1).append(this.this$1.this$0.mRemoteImgUrl);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.this$1.this$0.app.getMessageFacade().b(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq);
    if ((localObject1 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject1;
      if ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        ((AbsShareMsg)localObject1).updateCover(this.this$1.this$0.mRemoteImgUrl);
        ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
        this.this$1.this$0.app.getMessageFacade().a(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject1).getBytes());
      }
    }
    ForwardSdkShareProcessor.access$1000(this.this$1.this$0).set(true);
    this.this$1.doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */