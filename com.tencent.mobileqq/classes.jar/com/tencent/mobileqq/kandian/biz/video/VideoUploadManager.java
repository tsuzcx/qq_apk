package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.video.upload.api.IVideoUploadManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class VideoUploadManager
  implements IVideoUploadManager, Manager
{
  public static int a = 0;
  public static int b = 1;
  public static Map<String, String> c;
  TroopMemberApiService d;
  HashMap<Long, Bundle> e = new HashMap();
  HashMap<Long, Bundle> f = new HashMap();
  private QQAppInterface g;
  private boolean h = true;
  
  public VideoUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.g = paramQQAppInterface;
  }
  
  private void a(int paramInt) {}
  
  public void a(@Nullable Object paramObject)
  {
    if ((this.d == null) && ((paramObject instanceof TroopMemberApiService))) {
      this.d = ((TroopMemberApiService)paramObject);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.c(paramString))) {
      a(a);
    }
    VideoUploadManager.1 local1 = new VideoUploadManager.1(this);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new VideoUploadManager.2(this);
    ITransFileController localITransFileController = (ITransFileController)this.g.getRuntimeService(ITransFileController.class);
    local1.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(local1);
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 54;
    localTransferRequest.mSelfUin = this.g.getCurrentUin();
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localITransFileController.transferAsync(localTransferRequest);
    this.e.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.f.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUploadManager
 * JD-Core Version:    0.7.0.1
 */