package com.tencent.mobileqq.nearby.now.send.uploader;

import aevi;
import aevl;
import aevm;
import aevn;
import aevo;
import aevp;
import aevq;
import aevr;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_feeds_tmem.PicFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicInfo;
import com.tencent.pb.now.ilive_feeds_write.AddFeedReq;
import com.tencent.pb.now.ilive_feeds_write.LbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageFeedsUploader
{
  public QQAppInterface a;
  private PicFeedUploadInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo = new PicFeedUploadInfo();
  private EditVideoUi jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi;
  private ImageFeedsUploader.UploadListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener = new aevi(this);
  private ImageUploader jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader;
  private VideoFeedsUploader.UploadResult jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult = new VideoFeedsUploader.UploadResult();
  public boolean a;
  
  public ImageFeedsUploader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader = new ImageUploader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ImageFeedsUploader(QQAppInterface paramQQAppInterface, PicFeedUploadInfo paramPicFeedUploadInfo, EditVideoUi paramEditVideoUi)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi = paramEditVideoUi;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo = paramPicFeedUploadInfo;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader = new ImageUploader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private PublishVideoEntry a(VideoFeedsUploader.UploadResult paramUploadResult, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      paramPublishVideoEntry.putExtra("md5", paramUploadResult.jdField_b_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("file_id", paramUploadResult.jdField_c_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("mask", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.desc);
      paramPublishVideoEntry.putExtra("prestep", Integer.valueOf(paramUploadResult.jdField_b_of_type_Int));
      paramPublishVideoEntry.putExtra("preUploadedLen", Long.valueOf(paramUploadResult.jdField_b_of_type_Long));
      paramPublishVideoEntry.putExtra("preCoverUrl", paramUploadResult.e);
      paramPublishVideoEntry.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.lat);
      paramPublishVideoEntry.putExtra("city", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.city);
      paramPublishVideoEntry.putExtra("lng", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.lng);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo != null)
      {
        paramPublishVideoEntry.putExtra("select_lat", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.lat);
        paramPublishVideoEntry.putExtra("select_city", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.city);
        paramPublishVideoEntry.putExtra("select_lng", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.lng);
        paramPublishVideoEntry.putExtra("select_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.name);
      }
      paramUploadResult = new JSONArray();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.topic != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.topic.size())
        {
          paramUploadResult.put(i, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.topic.get(i));
          i += 1;
        }
      }
      paramPublishVideoEntry.putExtra("topic", paramUploadResult);
      return paramPublishVideoEntry;
    }
    catch (JSONException paramUploadResult)
    {
      QLog.e("ImageFeedsUploader", 1, paramUploadResult, new Object[0]);
    }
    return paramPublishVideoEntry;
  }
  
  public static ImageFeedsUploader a(PublishVideoEntry paramPublishVideoEntry, QQAppInterface paramQQAppInterface, ImageFeedsUploader.UploadListener paramUploadListener)
  {
    paramPublishVideoEntry = a(paramQQAppInterface, paramPublishVideoEntry);
    ImageFeedsUploader localImageFeedsUploader = new ImageFeedsUploader(paramQQAppInterface);
    localImageFeedsUploader.a(paramQQAppInterface, paramPublishVideoEntry, paramUploadListener);
    return localImageFeedsUploader;
  }
  
  public static VideoFeedsUploader.UploadInfo a(QQAppInterface paramQQAppInterface, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return null;
    }
    VideoFeedsUploader.UploadInfo localUploadInfo = new VideoFeedsUploader.UploadInfo();
    localUploadInfo.jdField_b_of_type_JavaLangString = paramPublishVideoEntry.fakeVid;
    localUploadInfo.jdField_f_of_type_Long = paramPublishVideoEntry.videoDuration;
    localUploadInfo.jdField_b_of_type_Long = 0L;
    localUploadInfo.jdField_g_of_type_Long = paramPublishVideoEntry.videoWidth;
    localUploadInfo.jdField_h_of_type_Long = paramPublishVideoEntry.videoHeight;
    if (localUploadInfo.jdField_g_of_type_Long > localUploadInfo.jdField_h_of_type_Long)
    {
      localUploadInfo.jdField_g_of_type_Long = paramPublishVideoEntry.videoHeight;
      localUploadInfo.jdField_h_of_type_Long = paramPublishVideoEntry.videoWidth;
    }
    int i;
    if (paramPublishVideoEntry.isLocalPublish) {
      i = 1;
    }
    for (;;)
    {
      localUploadInfo.jdField_f_of_type_Int = i;
      localUploadInfo.jdField_d_of_type_JavaLangString = paramPublishVideoEntry.mLocalRawVideoDir;
      localUploadInfo.e = paramPublishVideoEntry.thumbPath;
      localUploadInfo.jdField_f_of_type_JavaLangString = paramPublishVideoEntry.doodlePath;
      String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getString("nick", "");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramQQAppInterface.getCurrentNickname();
      }
      localUploadInfo.o = str1;
      localUploadInfo.jdField_c_of_type_Long = paramQQAppInterface.getLongAccountUin();
      localUploadInfo.jdField_j_of_type_Long = paramQQAppInterface.getLongAccountUin();
      if (!TextUtils.isEmpty(paramPublishVideoEntry.extraJsonString)) {
        try
        {
          paramQQAppInterface = new JSONObject(paramPublishVideoEntry.extraJsonString);
          localUploadInfo.jdField_c_of_type_JavaLangString = paramQQAppInterface.optString("md5");
          localUploadInfo.k = paramQQAppInterface.optString("file_id");
          localUploadInfo.jdField_g_of_type_JavaLangString = paramQQAppInterface.optString("mask");
          localUploadInfo.jdField_g_of_type_Int = paramQQAppInterface.optInt("prestep");
          localUploadInfo.jdField_i_of_type_Long = paramQQAppInterface.optLong("preUploadedLen");
          localUploadInfo.l = paramQQAppInterface.optString("preCoverUrl");
          localUploadInfo.m = paramQQAppInterface.optString("preDoodleUrl");
          localUploadInfo.n = paramQQAppInterface.optString("preVideoUrl");
          localUploadInfo.jdField_j_of_type_JavaLangString = paramQQAppInterface.optString("city");
          localUploadInfo.jdField_i_of_type_JavaLangString = paramQQAppInterface.optString("lat");
          localUploadInfo.jdField_h_of_type_JavaLangString = paramQQAppInterface.optString("lng");
          localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
          localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.setLat(paramQQAppInterface.optString("select_lat"));
          localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.setCity(paramQQAppInterface.optString("select_city"));
          localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.setLng(paramQQAppInterface.optString("select_lng"));
          localUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.setName(paramQQAppInterface.optString("select_name"));
          paramQQAppInterface = paramQQAppInterface.optJSONArray("topic");
          if (paramQQAppInterface != null)
          {
            i = 0;
            while (i < paramQQAppInterface.length())
            {
              localUploadInfo.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface.getString(i));
              i += 1;
              continue;
              i = 0;
            }
          }
        }
        catch (JSONException paramQQAppInterface)
        {
          QLog.e("ImageFeedsUploader", 1, paramQQAppInterface, new Object[0]);
        }
      }
    }
    return localUploadInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", paramPicFeedUploadInfo.feedId);
      localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
      localJSONObject.put("feed_type", 4);
      localJSONObject.put("cover_pic", paramUploadResult.e);
      localJSONObject.put("city", paramPicFeedUploadInfo.city);
      localJSONObject.put("like_num", 0);
      localJSONObject.put("pic_url", paramUploadResult.e);
      if ((paramPicFeedUploadInfo != null) && (!paramPicFeedUploadInfo.photoInfo.isEmpty()))
      {
        paramQQAppInterface = (LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0);
        localJSONObject.put("video_width", paramQQAppInterface.c);
        localJSONObject.put("video_height", paramQQAppInterface.jdField_d_of_type_Int);
      }
      localJSONObject.put("video_url", paramUploadResult.e);
      if (paramPicFeedUploadInfo != null)
      {
        localJSONObject.put("longitude", paramPicFeedUploadInfo.locationInfo.lng);
        localJSONObject.put("latitude", paramPicFeedUploadInfo.locationInfo.lat);
        localJSONObject.put("desc", paramPicFeedUploadInfo.desc);
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("ImageFeedsUploader", 1, "createExtraDataForJS faile", paramQQAppInterface);
      }
    }
    return localJSONObject.toString();
  }
  
  private void a(PicFeedUploadInfo paramPicFeedUploadInfo)
  {
    paramPicFeedUploadInfo.uploadStatus = 1;
    ThreadManager.getUIHandler().post(new aevq(this, paramPicFeedUploadInfo));
  }
  
  private void a(VideoFeedsUploader.UploadResult paramUploadResult)
  {
    ThreadManager.post(new aevr(this, paramUploadResult), 5, null, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 1;
    ??? = VideoCompositeHelper.a(((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.photoInfo.get(0)).jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString = ((PublishVideoEntry)???).fakeVid;
    ((PublishVideoEntry)???).publishState = 3;
    PublishVideoEntry localPublishVideoEntry = a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult, (PublishVideoEntry)???);
    PublishManager.a(localPublishVideoEntry);
    synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
    {
      PublishManager.jdField_a_of_type_JavaUtilHashMap.put(localPublishVideoEntry.fakeVid, Integer.valueOf(1));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo);
      }
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).c(localPublishVideoEntry.fakeVid);
      if (VideoFeedsUploader.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.b(3, ((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.photoInfo.get(0)).jdField_b_of_type_JavaLangString, new aevp(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface, VideoFeedsUploader.UploadInfo paramUploadInfo, ImageFeedsUploader.UploadListener paramUploadListener)
  {
    VideoFeedsUploader.jdField_a_of_type_Int = -1024;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 1;
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(paramUploadInfo.jdField_b_of_type_JavaLangString);
    localPublishVideoEntry.publishState = 3;
    PublishManager.a(localPublishVideoEntry);
    synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
    {
      PublishManager.jdField_a_of_type_JavaUtilHashMap.put(localPublishVideoEntry.fakeVid, Integer.valueOf(1));
      ((NearbyMomentManager)paramQQAppInterface.getManager(262)).c(localPublishVideoEntry.fakeVid);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader = new ImageUploader(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo = new PicFeedUploadInfo();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.photoInfo = new ArrayList();
      a(paramUploadListener);
      paramQQAppInterface = new LocalMediaInfo();
      paramQQAppInterface.jdField_b_of_type_JavaLangString = paramUploadInfo.e;
      paramQQAppInterface.c = ((int)paramUploadInfo.jdField_g_of_type_Long);
      paramQQAppInterface.jdField_d_of_type_Int = ((int)paramUploadInfo.jdField_h_of_type_Long);
      paramQQAppInterface.jdField_d_of_type_JavaLangString = paramUploadInfo.l;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.photoInfo.add(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.topic = paramUploadInfo.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.feedId = paramUploadInfo.k;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.city = paramUploadInfo.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.lat = paramUploadInfo.jdField_i_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.lng = paramUploadInfo.jdField_h_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.desc = paramUploadInfo.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo = new LocationInfo();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.city = paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.city;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.lat = paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lat;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.lng = paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lng;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.locationInfo.name = paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.name;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString = paramUploadInfo.jdField_b_of_type_JavaLangString;
      if (paramUploadInfo.jdField_g_of_type_Int == 2)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo, 3, null);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.b(3, ((LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo.photoInfo.get(0)).jdField_b_of_type_JavaLangString, new aevo(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a() != null) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a(), 1, "已有任务上传中!", 1).a();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a(new PicFeedUploadInfo());
    WordsCheck.a(paramQQAppInterface, paramString, new aevl(this));
  }
  
  public void a(PicFeedUploadInfo paramPicFeedUploadInfo, int paramInt, ImageFeedsUploader.IFetchFeedListener paramIFetchFeedListener)
  {
    if (paramPicFeedUploadInfo == null)
    {
      QLog.e("ImageFeedsUploader", 1, "fetch feeds info is null");
      return;
    }
    ilive_feeds_write.AddFeedReq localAddFeedReq = new ilive_feeds_write.AddFeedReq();
    localAddFeedReq.feed_type.set(4);
    localAddFeedReq.feed_source.set(4);
    localAddFeedReq.feed_upload_status.set(paramInt);
    Object localObject2;
    if (paramInt == 3)
    {
      localObject1 = new ilive_feeds_tmem.PicFeed();
      ((ilive_feeds_tmem.PicFeed)localObject1).feed_md5.set(ByteStringMicro.copyFrom(paramPicFeedUploadInfo.feedId.getBytes()));
      ((ilive_feeds_tmem.PicFeed)localObject1).desc.set(ByteStringMicro.copyFrom(paramPicFeedUploadInfo.desc.getBytes()));
      int i;
      if ((paramPicFeedUploadInfo.topic != null) && (paramPicFeedUploadInfo.topic.size() > 0))
      {
        localObject2 = new ArrayList();
        i = 0;
        while (i < paramPicFeedUploadInfo.topic.size())
        {
          ((List)localObject2).add(ByteStringMicro.copyFrom(((String)paramPicFeedUploadInfo.topic.get(i)).getBytes()));
          i += 1;
        }
        ((ilive_feeds_tmem.PicFeed)localObject1).topic.set((List)localObject2);
      }
      if ((paramPicFeedUploadInfo.photoInfo != null) && (paramPicFeedUploadInfo.photoInfo.size() > 0))
      {
        localObject2 = new ArrayList();
        i = 0;
        while (i < paramPicFeedUploadInfo.photoInfo.size())
        {
          ilive_feeds_tmem.PicInfo localPicInfo = new ilive_feeds_tmem.PicInfo();
          localPicInfo.url.set(ByteStringMicro.copyFrom(((LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0)).jdField_d_of_type_JavaLangString.getBytes()));
          localPicInfo.width.set(((LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0)).c);
          localPicInfo.hight.set(((LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0)).jdField_d_of_type_Int);
          localPicInfo.file_id.set(ByteStringMicro.copyFrom(((LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0)).e.getBytes()));
          localPicInfo.pic_md5.set(ByteStringMicro.copyFrom(((LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0)).jdField_f_of_type_JavaLangString.getBytes()));
          localPicInfo.lng.set(ByteStringMicro.copyFrom(paramPicFeedUploadInfo.lng.getBytes()));
          localPicInfo.lat.set(ByteStringMicro.copyFrom(paramPicFeedUploadInfo.lat.getBytes()));
          localPicInfo.city.set(ByteStringMicro.copyFrom(paramPicFeedUploadInfo.city.getBytes()));
          ((List)localObject2).add(localPicInfo);
          i += 1;
        }
        ((ilive_feeds_tmem.PicFeed)localObject1).infos.set((List)localObject2);
      }
      localAddFeedReq.pic_info.set((MessageMicro)localObject1);
    }
    Object localObject1 = paramPicFeedUploadInfo.locationInfo;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((LocationInfo)localObject1).getCity())))
    {
      localObject2 = new ilive_feeds_write.LbsInfo();
      ((ilive_feeds_write.LbsInfo)localObject2).lng.set(ByteStringMicro.copyFrom(((LocationInfo)localObject1).getLng().getBytes()));
      ((ilive_feeds_write.LbsInfo)localObject2).lat.set(ByteStringMicro.copyFrom(((LocationInfo)localObject1).getLat().getBytes()));
      ((ilive_feeds_write.LbsInfo)localObject2).city.set(ByteStringMicro.copyFrom(((LocationInfo)localObject1).getCity().getBytes()));
      if (!TextUtils.isEmpty(((LocationInfo)localObject1).getName())) {
        ((ilive_feeds_write.LbsInfo)localObject2).name.set(ByteStringMicro.copyFrom(((LocationInfo)localObject1).getName().getBytes()));
      }
      localAddFeedReq.lbs_info.set((MessageMicro)localObject2);
    }
    new CsTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(22528).b(4).a(new aevn(this, paramIFetchFeedListener, paramPicFeedUploadInfo, paramInt)).a(new aevm(this, paramIFetchFeedListener, paramInt)).a(localAddFeedReq);
  }
  
  public void a(ImageFeedsUploader.UploadListener paramUploadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener = paramUploadListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader
 * JD-Core Version:    0.7.0.1
 */