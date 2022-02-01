package com.tencent.mobileqq.tribe.videoupload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class TribeVideoFileObject
  extends UploadObject
{
  public UploadResult a;
  public String a;
  
  public TribeVideoFileObject(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadUploadResult = new UploadResult();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new TribeVideoFileObject.1(this);
    localTransferRequest.mLocalPath = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 327681;
    QQStoryContext.a();
    localTransferRequest.mSelfUin = QQStoryContext.a().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    ((ITransFileController)QQStoryContext.a().getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!FileUtils.c(this.jdField_a_of_type_JavaLangString)))
    {
      SLog.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.videoupload.TribeVideoFileObject
 * JD-Core Version:    0.7.0.1
 */