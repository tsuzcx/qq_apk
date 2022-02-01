package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;

public abstract interface UploadVideoRequesterV3
{
  public abstract void getActReflectData(UploadVideoRequesterV3.ActReflectResponse paramActReflectResponse);
  
  public abstract void request(ActionReflectReq paramActionReflectReq, UploadVideoRequesterV3.UploadVideoResponse paramUploadVideoResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3
 * JD-Core Version:    0.7.0.1
 */