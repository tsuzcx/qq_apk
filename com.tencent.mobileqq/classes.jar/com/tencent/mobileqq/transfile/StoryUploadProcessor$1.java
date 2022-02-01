package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryPic;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NumberUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.HashMap;

class StoryUploadProcessor$1
  implements ITransactionCallback
{
  StoryUploadProcessor$1(StoryUploadProcessor paramStoryUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    NumberUtils.a((String)paramHashMap.get("upFlow_WiFi"), -1L);
    NumberUtils.a((String)paramHashMap.get("dwFlow_WiFi"), -1L);
    NumberUtils.a((String)paramHashMap.get("upFlow_Xg"), -1L);
    NumberUtils.a((String)paramHashMap.get("dwFlow_Xg"), -1L);
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    SLog.c(StoryUploadProcessor.TAG, "Transaction End : Failed. take time:" + (l - this.val$startTime) + "ms");
    this.this$0.mReportInfo.put("X-piccachetime", paramArrayOfByte);
    this.this$0.mReportInfo.put("param_BdhTrans", str1);
    this.this$0.mReportInfo.put("param_segspercnt", str2);
    this.this$0.mReportInfo.put("param_conf_segSize", str3);
    this.this$0.mReportInfo.put("param_conf_segNum", str4);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.setError(paramInt, "OnFailed.", "", this.this$0.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    SLog.c(StoryUploadProcessor.TAG, "Transaction End : Success. New : SendTotalCost:" + (l - this.val$startTime) + "ms ,fileSize:" + this.this$0.file.fileSize + " transInfo:" + str2);
    this.this$0.mReportInfo.put("X-piccachetime", str1);
    this.this$0.mReportInfo.put("param_BdhTrans", str2);
    this.this$0.mReportInfo.put("param_segspercnt", str3);
    this.this$0.mReportInfo.put("param_conf_segSize", str4);
    this.this$0.mReportInfo.put("param_conf_segNum", str5);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.mStepTrans.logFinishTime();
    this.this$0.mStepTrans.result = 1;
    this.this$0.mTransferedSize = this.this$0.mFileSize;
    SLog.c(StoryUploadProcessor.TAG, "ITransactionCallback.onSuccess()");
    if (paramArrayOfByte == null) {
      this.this$0.onError();
    }
    for (;;)
    {
      this.this$0.file.closeInputStream();
      return;
      int i;
      if (this.this$0.file.fileType == 196610)
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryPic();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label548;
          }
          this.this$0.mPhotoUrl = paramHashMap.url.get().toStringUtf8();
          SLog.a(StoryUploadProcessor.TAG, "upload file %s return url %s", this.this$0.mFileName, this.this$0.mPhotoUrl);
          if (!TextUtils.isEmpty(this.this$0.mPhotoUrl)) {
            break label538;
          }
          this.this$0.errCode = 940010;
          this.this$0.errDesc = String.format("return illegal arg url:%s", new Object[] { this.this$0.mPhotoUrl });
          this.this$0.onError();
          paramHashMap = HexUtil.bytes2HexStr(paramArrayOfByte);
          str1 = StoryUploadProcessor.TAG;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          SLog.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          SLog.d(StoryUploadProcessor.TAG, "parser buffer exception");
          this.this$0.onError();
        }
        continue;
        label538:
        this.this$0.onSuccess();
        continue;
        label548:
        this.this$0.errCode = i;
        this.this$0.errDesc = paramHashMap.msg.get().toStringUtf8();
        this.this$0.onError();
      }
      else if ((this.this$0.file.fileType == 196609) || (this.this$0.file.fileType == 327681))
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryVideo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label856;
          }
          this.this$0.mVideoUrl = paramHashMap.cdn_url.get().toStringUtf8();
          if (this.this$0.file.fileType == 196609) {
            this.this$0.mVideoUrl = UIUtils.a(this.this$0.mVideoUrl, "authkey");
          }
          this.this$0.mVid = paramHashMap.file_key.get().toStringUtf8();
          if ((!TextUtils.isEmpty(this.this$0.mVideoUrl)) && (!TextUtils.isEmpty(this.this$0.mVid))) {
            break label846;
          }
          this.this$0.errCode = 940010;
          this.this$0.errDesc = String.format("return illegal arg vid:%s, url:%s", new Object[] { this.this$0.mVid, this.this$0.mVideoUrl });
          this.this$0.onError();
          paramHashMap = HexUtil.bytes2HexStr(paramArrayOfByte);
          str1 = StoryUploadProcessor.TAG;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          SLog.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          SLog.d(StoryUploadProcessor.TAG, "parser buffer exception");
          this.this$0.onError();
        }
        continue;
        label846:
        this.this$0.onSuccess();
        continue;
        label856:
        this.this$0.errCode = i;
        this.this$0.errDesc = paramHashMap.msg.get().toStringUtf8();
        this.this$0.onError();
      }
      else
      {
        this.this$0.sendMessageToUpdate(1005);
        this.this$0.onError();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    SLog.a(StoryUploadProcessor.TAG, "onTransStart %s", this.this$0.mUiRequest.mLocalPath);
    long l1 = System.currentTimeMillis();
    long l2 = StoryUploadProcessor.access$000(this.this$0);
    String str2 = StoryReportor.a(BaseApplication.getContext());
    if (this.this$0.file.fileType == 196610) {}
    for (String str1 = "pic";; str1 = "video")
    {
      StoryReportor.b("publish_story", "publish_bdh", 0, 0, new String[] { "", String.valueOf(l1 - l2), str2, str1 });
      this.this$0.mStepTrans.logStartTime();
      StoryUploadProcessor.access$102(this.this$0, System.currentTimeMillis());
      return;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    StoryUploadProcessor localStoryUploadProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localStoryUploadProcessor.mTransferedSize = l;
    if ((paramInt <= this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StoryUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */