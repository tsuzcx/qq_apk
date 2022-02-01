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
  public static Map<String, String> a;
  public static int b = 1;
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  HashMap<Long, Bundle> b = new HashMap();
  
  public VideoUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt) {}
  
  public void a(@Nullable Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null) && ((paramObject instanceof TroopMemberApiService))) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = ((TroopMemberApiService)paramObject);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.b(paramString))) {
      a(jdField_a_of_type_Int);
    }
    VideoUploadManager.1 local1 = new VideoUploadManager.1(this);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new VideoUploadManager.2(this);
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    local1.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(local1);
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 54;
    localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localITransFileController.transferAsync(localTransferRequest);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.b.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUploadManager
 * JD-Core Version:    0.7.0.1
 */