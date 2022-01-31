package com.tencent.mobileqq.nearby.now.send.uploader;

import aeiq;
import aeit;
import aeiu;
import aeiv;
import aeix;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.NowPublishParam;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsManager
{
  public QQAppInterface a;
  public EditVideoUi a;
  private PublishManager jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager;
  private VideoFeedsUploader.UploadListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener = new aeiq(this);
  private VideoFeedsUploader jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader;
  public boolean a;
  
  public VideoFeedsManager(QQAppInterface paramQQAppInterface, EditVideoUi paramEditVideoUi, PublishManager paramPublishManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader = new VideoFeedsUploader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager = paramPublishManager;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi = paramEditVideoUi;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", paramUploadResult.d);
      localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
      localJSONObject.put("feed_type", 3);
      localJSONObject.put("cover_pic", paramUploadResult.e);
      localJSONObject.put("city", paramUploadInfo.j);
      localJSONObject.put("like_num", 0);
      localJSONObject.put("pic_url", paramUploadResult.e);
      localJSONObject.put("video_width", paramUploadInfo.jdField_g_of_type_Long);
      localJSONObject.put("video_height", paramUploadInfo.jdField_h_of_type_Long);
      localJSONObject.put("video_url", paramUploadResult.jdField_g_of_type_JavaLangString);
      if (paramUploadInfo.a != null)
      {
        localJSONObject.put("longitude", paramUploadInfo.a.lng);
        localJSONObject.put("latitude", paramUploadInfo.a.lat);
      }
      localJSONObject.put("desc", paramUploadInfo.jdField_g_of_type_JavaLangString);
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("VideoFeedsManager", 1, "createExtraDataForJS faile", paramQQAppInterface);
      }
    }
    return localJSONObject.toString();
  }
  
  private void a(VideoFeedsUploader.UploadInfo paramUploadInfo)
  {
    SosoInterface.a(new aeiu(this, 3, true, true, 600000L, false, false, "NearbyNowliveTab", paramUploadInfo));
  }
  
  private void a(VideoFeedsUploader.UploadInfo paramUploadInfo, LocationInfo paramLocationInfo)
  {
    if (paramUploadInfo != null)
    {
      paramUploadInfo.i = new String(paramLocationInfo.getLat());
      paramUploadInfo.jdField_h_of_type_JavaLangString = new String(paramLocationInfo.getLng());
      paramUploadInfo.j = new String(paramLocationInfo.getCity());
      if (QLog.isColorLevel()) {
        QLog.i("LocationInfo", 2, "startUploadStoryVideo --- city: " + paramUploadInfo.j + ", lat: " + paramUploadInfo.i + ", lnt: " + paramUploadInfo.jdField_h_of_type_JavaLangString);
      }
      ThreadManager.post(new aeiv(this, paramUploadInfo), 5, null, false);
      return;
    }
    QLog.w("VideoFeedsManager", 1, "tmpInfo == null, upload fail!");
  }
  
  public int a(VideoFeedsUploader.UploadInfo paramUploadInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader.a()) {
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader.a(paramUploadInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener);
    return 0;
  }
  
  public void a(NowPublishParam paramNowPublishParam)
  {
    ThreadManager.post(new aeit(this, paramNowPublishParam), 5, null, false);
  }
  
  public void a(NowPublishParam paramNowPublishParam, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a() != null) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a(), 1, "已有任务上传中!", 1).a();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener.a(new VideoFeedsUploader.UploadInfo());
    WordsCheck.a(paramQQAppInterface, paramString, new aeix(this, paramNowPublishParam));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager
 * JD-Core Version:    0.7.0.1
 */