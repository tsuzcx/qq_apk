package com.tencent.mobileqq.nearby.now.send.uploader;

import aeiy;
import aeja;
import aejc;
import aejd;
import aejg;
import aejh;
import aeji;
import aejj;
import aejk;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive_feeds.ShortVideo.UploadReq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.utils.IOUtils;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.ilive_feeds_tmem.VideoFeed;
import com.tencent.pb.now.ilive_feeds_write.AddFeedReq;
import com.tencent.pb.now.ilive_feeds_write.LbsInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsUploader
{
  public static int a;
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public QQAppInterface a;
  private ImageUploader jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader;
  private UploadSpeedLimit jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderUploadSpeedLimit = new UploadSpeedLimit();
  private VideoFeedsUploader.UploadInfo jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo = new VideoFeedsUploader.UploadInfo();
  private VideoFeedsUploader.UploadListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener;
  private VideoFeedsUploader.UploadResult jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult = new VideoFeedsUploader.UploadResult();
  private boolean b;
  
  static
  {
    if (!VideoFeedsUploader.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_Int = -1024;
      return;
    }
  }
  
  public VideoFeedsUploader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader = new ImageUploader(paramQQAppInterface);
  }
  
  private int a(long paramLong, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "第" + paramInt + "次尝试重试");
    }
    if (a(paramLong))
    {
      paramInt = -1003;
      return paramInt;
    }
    if (paramInt >= 3) {
      return -1009;
    }
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= 15) || (NetworkUtil.a(BaseApplication.getContext())))
      {
        paramInt = i;
        if (NetworkUtil.a(BaseApplication.getContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoFeedsUploader", 2, "当前无网络，重试失败，结束上传!");
        }
        return -1008;
      }
      try
      {
        Thread.sleep(1000L);
        paramInt += 1;
      }
      catch (Exception localException)
      {
        QLog.e("VideoFeedsUploader", 1, localException, new Object[0]);
      }
    }
    return -1010;
  }
  
  private int a(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (0L == paramLong)) {
      return -1;
    }
    Object localObject = "";
    for (;;)
    {
      int i;
      long l;
      String str;
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
        i = 0;
        if (i < paramLong)
        {
          l = IOUtils.a(localByteArrayInputStream, true);
          if (l > 0L) {}
        }
        else
        {
          localByteArrayInputStream.close();
          if (!QLog.isColorLevel()) {
            break label316;
          }
          QLog.i("VideoFeedsUploader", 2, String.format("DebugLog", new Object[] { "read result: contentLen=%d, totalsize=%d, readsize=%d", Long.valueOf(paramLong), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) }));
          break label316;
        }
        str = new String(IOUtils.a(localByteArrayInputStream, Math.min(16384, (int)l)));
        if (((String)localObject).compareToIgnoreCase("fileid") == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_JavaLangString = str;
          if (QLog.isColorLevel()) {
            QLog.i("VideoFeedsUploader", 2, "fileid=" + str);
          }
        }
        else if (((String)localObject).compareToIgnoreCase("cdnurl") == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_g_of_type_JavaLangString = str;
          if (!QLog.isColorLevel()) {
            break label318;
          }
          QLog.i("VideoFeedsUploader", 2, "videoUrl=" + str);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
        QLog.e("VideoFeedsUploader", 1, paramArrayOfByte, new Object[0]);
        return -2;
      }
      if (((String)localObject).compareToIgnoreCase("retcode") == 0)
      {
        Integer localInteger = Integer.valueOf(str);
        if ((localInteger != null) && (localInteger.intValue() != 0))
        {
          i = localInteger.intValue();
          return i;
        }
      }
      for (;;)
      {
        break;
        label316:
        return 0;
        label318:
        i = (int)(l + 4L + i);
        if (str != null) {
          localObject = str;
        }
      }
    }
  }
  
  private long a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderUploadSpeedLimit.getClass();
    return Math.max(1000L * paramLong / 16384, 120000L);
  }
  
  private PublishVideoEntry a(VideoFeedsUploader.UploadResult paramUploadResult, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      paramPublishVideoEntry.putExtra("md5", paramUploadResult.jdField_b_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("file_id", paramUploadResult.jdField_c_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("mask", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("prestep", Integer.valueOf(paramUploadResult.jdField_b_of_type_Int));
      paramPublishVideoEntry.putExtra("preUploadedLen", Long.valueOf(paramUploadResult.jdField_b_of_type_Long));
      paramPublishVideoEntry.putExtra("preCoverUrl", paramUploadResult.jdField_e_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("preDoodleUrl", paramUploadResult.jdField_f_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("preVideoUrl", paramUploadResult.jdField_g_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_i_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("city", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_j_of_type_JavaLangString);
      paramPublishVideoEntry.putExtra("lng", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_h_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo != null)
      {
        paramPublishVideoEntry.putExtra("select_lat", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lat);
        paramPublishVideoEntry.putExtra("select_city", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.city);
        paramPublishVideoEntry.putExtra("select_lng", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lng);
        paramPublishVideoEntry.putExtra("select_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.name);
      }
      paramUploadResult = new JSONArray();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.size())
        {
          paramUploadResult.put(i, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.get(i));
          i += 1;
        }
      }
      paramPublishVideoEntry.putExtra("topic", paramUploadResult);
      return paramPublishVideoEntry;
    }
    catch (JSONException paramUploadResult)
    {
      QLog.e("VideoFeedsUploader", 1, paramUploadResult, new Object[0]);
    }
    return paramPublishVideoEntry;
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
      localUploadInfo.jdField_e_of_type_JavaLangString = paramPublishVideoEntry.thumbPath;
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
          QLog.e("VideoFeedsUploader", 1, paramQQAppInterface, new Object[0]);
        }
      }
    }
    return localUploadInfo;
  }
  
  public static VideoFeedsUploader a(PublishVideoEntry paramPublishVideoEntry, QQAppInterface paramQQAppInterface, VideoFeedsUploader.UploadListener paramUploadListener)
  {
    jdField_a_of_type_Int = -1024;
    VideoFeedsUploader localVideoFeedsUploader = new VideoFeedsUploader(paramQQAppInterface);
    localVideoFeedsUploader.b(a(paramQQAppInterface, paramPublishVideoEntry), paramUploadListener);
    return localVideoFeedsUploader;
  }
  
  private String a(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "step3: uploadLogoImage");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 3;
    if (jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    int j = 1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo == null) {
      i = 0;
    }
    while (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_e_of_type_JavaLangString, new aejg(this));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.l != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.l)))
      {
        i = 0;
      }
      else
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_e_of_type_JavaLangString != null)
        {
          i = j;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_e_of_type_JavaLangString)) {
            i = 0;
          }
        }
      }
    }
    a(90, 0);
    b();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "Step1: upload apply.");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 1;
    if (jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1002;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    ShortVideo.UploadReq localUploadReq = new ShortVideo.UploadReq();
    localUploadReq.ver.set(0);
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      throw new AssertionError();
    }
    new CsTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(24592).b(1).a(new aejd(this)).a(new aejc(this, paramInt)).a(localUploadReq);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    VideoFeedsUploader.UploadInfo localUploadInfo = new VideoFeedsUploader.UploadInfo(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo);
    ThreadManager.getUIHandler().post(new aejk(this, localUploadInfo, paramInt1));
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, String.format("upload process: %d%%, size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  private void a(VideoFeedsUploader.UploadResult paramUploadResult)
  {
    ThreadManager.post(new aeja(this, paramUploadResult), 5, null, false);
  }
  
  private void a(List paramList1, List paramList2, byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    paramList1.add("ver");
    paramList2.add("0".getBytes());
    paramList1.add("seq");
    paramList2.add(String.format("%d", new Object[] { Long.valueOf(l) }).getBytes());
    paramList1.add("openid");
    paramList2.add(String.format("%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) }).getBytes());
    paramList1.add("authkey");
    paramList2.add(paramArrayOfByte);
    paramList1.add("rangestart");
    paramList2.add("0".getBytes());
    paramList1.add("rangeend");
    paramList2.add("0".getBytes());
    paramList1.add("filetype");
    paramList2.add("2306".getBytes());
    paramList1.add("filekey");
    paramList2.add("".getBytes());
    paramList1.add("isneedbitmap");
    paramList2.add("0".getBytes());
    paramList1.add("totalsize");
    paramList2.add(String.format("%d", new Object[] { Long.valueOf(paramLong) }).getBytes());
    paramList1.add("bid");
    paramList2.add("10011".getBytes());
    paramList1.add("subbid");
    paramList2.add("".getBytes());
    paramList1.add("filedata");
    paramList2.add("".getBytes());
    paramList1.add("touser");
    paramList2.add("".getBytes());
    paramList1.add("filemd5");
    paramList2.add("".getBytes());
    paramList2.set(7, paramString.getBytes());
    paramList2.set(14, paramString.getBytes());
  }
  
  /* Error */
  private void a(List paramList, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 66
    //   8: iconst_2
    //   9: ldc_w 635
    //   12: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   19: iconst_2
    //   20: putfield 233	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_b_of_type_Int	I
    //   23: aload_0
    //   24: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   27: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   30: putfield 637	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:d	J
    //   33: getstatic 28	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_Int	I
    //   36: iconst_2
    //   37: if_icmpne +22 -> 59
    //   40: aload_0
    //   41: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   44: sipush -1005
    //   47: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   55: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   58: return
    //   59: aload_0
    //   60: getfield 38	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo;
    //   63: ifnull +22 -> 85
    //   66: aload_0
    //   67: getfield 38	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo;
    //   70: invokevirtual 500	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo:a	()Z
    //   73: ifne +12 -> 85
    //   76: aload_1
    //   77: invokeinterface 639 1 0
    //   82: ifeq +22 -> 104
    //   85: aload_0
    //   86: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   89: sipush -1002
    //   92: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   100: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   103: return
    //   104: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   107: lstore 8
    //   109: aload_0
    //   110: getfield 38	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo;
    //   113: getfield 341	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   116: astore 18
    //   118: ldc_w 641
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_1
    //   128: iconst_0
    //   129: invokeinterface 300 2 0
    //   134: aastore
    //   135: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   138: astore 17
    //   140: lconst_0
    //   141: aload_0
    //   142: getfield 38	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo;
    //   145: getfield 320	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo:jdField_b_of_type_Long	J
    //   148: lcmp
    //   149: ifne +12 -> 161
    //   152: aload_0
    //   153: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   156: lload 8
    //   158: putfield 643	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Long	J
    //   161: aload_0
    //   162: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   165: new 149	java/lang/String
    //   168: dup
    //   169: aload 17
    //   171: invokespecial 644	java/lang/String:<init>	(Ljava/lang/String;)V
    //   174: putfield 645	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   177: aconst_null
    //   178: astore_1
    //   179: new 647	java/io/FileInputStream
    //   182: dup
    //   183: aload 18
    //   185: invokespecial 648	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   188: astore 16
    //   190: new 650	java/io/File
    //   193: dup
    //   194: aload 18
    //   196: invokespecial 651	java/io/File:<init>	(Ljava/lang/String;)V
    //   199: invokevirtual 653	java/io/File:length	()J
    //   202: lstore 12
    //   204: aload_0
    //   205: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   208: lload 12
    //   210: putfield 654	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_g_of_type_Long	J
    //   213: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +61 -> 277
    //   219: ldc 66
    //   221: iconst_2
    //   222: new 68	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 656
    //   232: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 12
    //   237: ldc2_w 657
    //   240: ldiv
    //   241: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   244: ldc_w 660
    //   247: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: getfield 38	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo;
    //   254: getfield 421	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadInfo:jdField_i_of_type_Long	J
    //   257: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: ldc_w 662
    //   263: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 17
    //   268: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: lload 12
    //   279: lconst_0
    //   280: lcmp
    //   281: ifgt +42 -> 323
    //   284: aload 16
    //   286: invokevirtual 663	java/io/FileInputStream:close	()V
    //   289: aload_0
    //   290: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   293: bipush 155
    //   295: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   303: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   306: aload 16
    //   308: ifnull -250 -> 58
    //   311: aload 16
    //   313: invokevirtual 663	java/io/FileInputStream:close	()V
    //   316: return
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   322: return
    //   323: new 668	java/util/ArrayList
    //   326: dup
    //   327: invokespecial 669	java/util/ArrayList:<init>	()V
    //   330: astore 18
    //   332: new 668	java/util/ArrayList
    //   335: dup
    //   336: invokespecial 669	java/util/ArrayList:<init>	()V
    //   339: astore 19
    //   341: aload_0
    //   342: aload 18
    //   344: aload 19
    //   346: aload_2
    //   347: aload_3
    //   348: lload 12
    //   350: invokespecial 671	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Ljava/util/List;Ljava/util/List;[BLjava/lang/String;J)V
    //   353: aload_0
    //   354: getfield 48	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderUploadSpeedLimit	Lcom/tencent/mobileqq/nearby/now/send/uploader/UploadSpeedLimit;
    //   357: iconst_0
    //   358: iconst_0
    //   359: invokevirtual 673	com/tencent/mobileqq/nearby/now/send/uploader/UploadSpeedLimit:a	(II)I
    //   362: istore 5
    //   364: iconst_0
    //   365: istore 4
    //   367: aload_0
    //   368: lload 12
    //   370: invokespecial 91	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(J)Z
    //   373: ifeq +43 -> 416
    //   376: aload 16
    //   378: invokevirtual 663	java/io/FileInputStream:close	()V
    //   381: aload_0
    //   382: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   385: sipush -1003
    //   388: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   396: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   399: aload 16
    //   401: ifnull -343 -> 58
    //   404: aload 16
    //   406: invokevirtual 663	java/io/FileInputStream:close	()V
    //   409: return
    //   410: astore_1
    //   411: aload_1
    //   412: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   415: return
    //   416: iload 5
    //   418: newarray byte
    //   420: astore_1
    //   421: aload 16
    //   423: aload_1
    //   424: iconst_0
    //   425: iload 5
    //   427: invokevirtual 677	java/io/FileInputStream:read	([BII)I
    //   430: istore 6
    //   432: iconst_m1
    //   433: iload 6
    //   435: if_icmpne +113 -> 548
    //   438: aload 16
    //   440: invokevirtual 663	java/io/FileInputStream:close	()V
    //   443: aload_0
    //   444: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   447: getfield 173	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   450: invokevirtual 678	java/lang/String:isEmpty	()Z
    //   453: ifne +16 -> 469
    //   456: aload_0
    //   457: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   460: getfield 180	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 678	java/lang/String:isEmpty	()Z
    //   466: ifeq +986 -> 1452
    //   469: aload_0
    //   470: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   473: sipush -1007
    //   476: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   479: aload_0
    //   480: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   483: lconst_0
    //   484: putfield 238	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_b_of_type_Long	J
    //   487: aload_0
    //   488: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   491: ldc 119
    //   493: putfield 173	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   496: aload_0
    //   497: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   500: ldc 119
    //   502: putfield 180	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   505: aload_0
    //   506: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   509: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   512: aload_0
    //   513: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   516: getfield 637	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:d	J
    //   519: lsub
    //   520: putfield 679	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_f_of_type_Long	J
    //   523: aload_0
    //   524: aload_0
    //   525: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   528: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   531: aload 16
    //   533: ifnull -475 -> 58
    //   536: aload 16
    //   538: invokevirtual 663	java/io/FileInputStream:close	()V
    //   541: return
    //   542: astore_1
    //   543: aload_1
    //   544: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   547: return
    //   548: iload 6
    //   550: iload 5
    //   552: if_icmpge +1006 -> 1558
    //   555: iload 6
    //   557: newarray byte
    //   559: astore_2
    //   560: aload_1
    //   561: iconst_0
    //   562: aload_2
    //   563: iconst_0
    //   564: iload 6
    //   566: invokestatic 683	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   569: aload_2
    //   570: astore_1
    //   571: aload 19
    //   573: iconst_4
    //   574: ldc_w 598
    //   577: iconst_1
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: iload 4
    //   585: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: aastore
    //   589: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   592: invokevirtual 594	java/lang/String:getBytes	()[B
    //   595: invokevirtual 684	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: aload 19
    //   601: iconst_5
    //   602: ldc_w 598
    //   605: iconst_1
    //   606: anewarray 4	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: iload 4
    //   613: iload 6
    //   615: iadd
    //   616: iconst_1
    //   617: isub
    //   618: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aastore
    //   622: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   625: invokevirtual 594	java/lang/String:getBytes	()[B
    //   628: invokevirtual 684	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   631: pop
    //   632: aload 19
    //   634: bipush 12
    //   636: aload_1
    //   637: invokevirtual 684	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   640: pop
    //   641: new 686	java/io/ByteArrayOutputStream
    //   644: dup
    //   645: invokespecial 687	java/io/ByteArrayOutputStream:<init>	()V
    //   648: astore_1
    //   649: iconst_0
    //   650: istore 5
    //   652: iload 5
    //   654: aload 18
    //   656: invokevirtual 688	java/util/ArrayList:size	()I
    //   659: if_icmpge +115 -> 774
    //   662: iload 5
    //   664: aload 19
    //   666: invokevirtual 688	java/util/ArrayList:size	()I
    //   669: if_icmpge +105 -> 774
    //   672: aload_1
    //   673: aload 18
    //   675: iload 5
    //   677: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   680: checkcast 149	java/lang/String
    //   683: invokevirtual 690	java/lang/String:length	()I
    //   686: i2l
    //   687: iconst_1
    //   688: invokestatic 693	com/tencent/mobileqq/nearby/now/utils/IOUtils:a	(Ljava/io/OutputStream;JZ)V
    //   691: aload_1
    //   692: aload 18
    //   694: iload 5
    //   696: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   699: checkcast 149	java/lang/String
    //   702: invokevirtual 594	java/lang/String:getBytes	()[B
    //   705: iconst_0
    //   706: aload 18
    //   708: iload 5
    //   710: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   713: checkcast 149	java/lang/String
    //   716: invokevirtual 690	java/lang/String:length	()I
    //   719: invokevirtual 697	java/io/ByteArrayOutputStream:write	([BII)V
    //   722: aload_1
    //   723: aload 19
    //   725: iload 5
    //   727: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   730: checkcast 699	[B
    //   733: arraylength
    //   734: i2l
    //   735: iconst_1
    //   736: invokestatic 693	com/tencent/mobileqq/nearby/now/utils/IOUtils:a	(Ljava/io/OutputStream;JZ)V
    //   739: aload_1
    //   740: aload 19
    //   742: iload 5
    //   744: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   747: checkcast 699	[B
    //   750: iconst_0
    //   751: aload 19
    //   753: iload 5
    //   755: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   758: checkcast 699	[B
    //   761: arraylength
    //   762: invokevirtual 697	java/io/ByteArrayOutputStream:write	([BII)V
    //   765: iload 5
    //   767: iconst_1
    //   768: iadd
    //   769: istore 5
    //   771: goto -119 -> 652
    //   774: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   777: lstore 8
    //   779: aload_0
    //   780: lload 12
    //   782: invokespecial 701	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(J)J
    //   785: pop2
    //   786: iconst_0
    //   787: istore 5
    //   789: lload 8
    //   791: lstore 10
    //   793: iload 5
    //   795: iconst_3
    //   796: if_icmpge +586 -> 1382
    //   799: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +12 -> 814
    //   805: ldc 66
    //   807: iconst_2
    //   808: ldc_w 703
    //   811: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: lload 8
    //   816: lstore 10
    //   818: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   821: lstore 8
    //   823: lload 8
    //   825: lstore 10
    //   827: aconst_null
    //   828: aload_1
    //   829: invokevirtual 706	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   832: invokestatic 712	com/squareup/okhttp/RequestBody:create	(Lcom/squareup/okhttp/MediaType;[B)Lcom/squareup/okhttp/RequestBody;
    //   835: astore_2
    //   836: lload 8
    //   838: lstore 10
    //   840: new 714	com/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder
    //   843: dup
    //   844: invokespecial 715	com/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder:<init>	()V
    //   847: aload 17
    //   849: invokevirtual 718	com/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder;
    //   852: aload_2
    //   853: invokevirtual 721	com/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder:a	(Lcom/squareup/okhttp/RequestBody;)Lcom/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder;
    //   856: invokevirtual 724	com/tencent/mobileqq/nearby/now/protocol/NowRequest$Builder:a	()Lcom/squareup/okhttp/Request;
    //   859: astore_2
    //   860: lload 8
    //   862: lstore 10
    //   864: new 726	com/squareup/okhttp/OkHttpClient
    //   867: dup
    //   868: invokespecial 727	com/squareup/okhttp/OkHttpClient:<init>	()V
    //   871: astore_3
    //   872: lload 8
    //   874: lstore 10
    //   876: aload_3
    //   877: ldc2_w 728
    //   880: getstatic 735	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   883: invokevirtual 739	com/squareup/okhttp/OkHttpClient:setConnectTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   886: lload 8
    //   888: lstore 10
    //   890: aload_3
    //   891: ldc2_w 728
    //   894: getstatic 735	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   897: invokevirtual 742	com/squareup/okhttp/OkHttpClient:setWriteTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   900: lload 8
    //   902: lstore 10
    //   904: aload_3
    //   905: ldc2_w 728
    //   908: getstatic 735	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   911: invokevirtual 745	com/squareup/okhttp/OkHttpClient:setReadTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   914: lload 8
    //   916: lstore 10
    //   918: aload_3
    //   919: aload_2
    //   920: invokevirtual 749	com/squareup/okhttp/OkHttpClient:newCall	(Lcom/squareup/okhttp/Request;)Lcom/squareup/okhttp/Call;
    //   923: invokevirtual 755	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   926: astore_2
    //   927: lload 8
    //   929: lstore 10
    //   931: aload_2
    //   932: invokevirtual 760	com/squareup/okhttp/Response:isSuccessful	()Z
    //   935: ifeq +142 -> 1077
    //   938: lload 8
    //   940: lstore 10
    //   942: aload_2
    //   943: invokevirtual 764	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   946: invokevirtual 769	com/squareup/okhttp/ResponseBody:contentLength	()J
    //   949: lstore 14
    //   951: lload 8
    //   953: lstore 10
    //   955: aload_2
    //   956: invokevirtual 764	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   959: invokevirtual 772	com/squareup/okhttp/ResponseBody:bytes	()[B
    //   962: astore_3
    //   963: lload 8
    //   965: lstore 10
    //   967: aload_2
    //   968: invokevirtual 764	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   971: invokevirtual 773	com/squareup/okhttp/ResponseBody:close	()V
    //   974: lload 8
    //   976: lstore 10
    //   978: aload_0
    //   979: aload_3
    //   980: lload 14
    //   982: invokespecial 775	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	([BJ)I
    //   985: istore 7
    //   987: lload 8
    //   989: lstore 10
    //   991: iload 7
    //   993: ifeq +389 -> 1382
    //   996: lload 8
    //   998: lstore 10
    //   1000: aload_0
    //   1001: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1004: iload 7
    //   1006: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1009: lload 8
    //   1011: lstore 10
    //   1013: aload_0
    //   1014: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1017: iload 7
    //   1019: putfield 777	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_Int	I
    //   1022: lload 8
    //   1024: lstore 10
    //   1026: aload_0
    //   1027: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1030: iload 4
    //   1032: i2l
    //   1033: putfield 238	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_b_of_type_Long	J
    //   1036: aload_0
    //   1037: lload 12
    //   1039: iload 5
    //   1041: iconst_1
    //   1042: iadd
    //   1043: invokespecial 779	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(JI)I
    //   1046: istore 7
    //   1048: iload 7
    //   1050: ifne +271 -> 1321
    //   1053: aload_0
    //   1054: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1057: astore_2
    //   1058: aload_2
    //   1059: aload_2
    //   1060: getfield 781	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_e_of_type_Int	I
    //   1063: iconst_1
    //   1064: iadd
    //   1065: putfield 781	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_e_of_type_Int	I
    //   1068: iload 5
    //   1070: iconst_1
    //   1071: iadd
    //   1072: istore 5
    //   1074: goto -285 -> 789
    //   1077: lload 8
    //   1079: lstore 10
    //   1081: aload_2
    //   1082: invokevirtual 784	com/squareup/okhttp/Response:code	()I
    //   1085: istore 7
    //   1087: lload 8
    //   1089: lstore 10
    //   1091: aload_2
    //   1092: invokevirtual 764	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   1095: invokevirtual 772	com/squareup/okhttp/ResponseBody:bytes	()[B
    //   1098: astore_3
    //   1099: lload 8
    //   1101: lstore 10
    //   1103: aload_2
    //   1104: invokevirtual 764	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   1107: invokevirtual 773	com/squareup/okhttp/ResponseBody:close	()V
    //   1110: lload 8
    //   1112: lstore 10
    //   1114: ldc 66
    //   1116: iconst_1
    //   1117: new 68	java/lang/StringBuilder
    //   1120: dup
    //   1121: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1124: ldc_w 786
    //   1127: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload_2
    //   1131: invokevirtual 784	com/squareup/okhttp/Response:code	()I
    //   1134: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: ldc_w 788
    //   1140: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: new 149	java/lang/String
    //   1146: dup
    //   1147: aload_3
    //   1148: invokespecial 163	java/lang/String:<init>	([B)V
    //   1151: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1160: lload 8
    //   1162: lstore 10
    //   1164: aload_0
    //   1165: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1168: iload 7
    //   1170: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1173: lload 8
    //   1175: lstore 10
    //   1177: aload_0
    //   1178: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1181: iload 7
    //   1183: putfield 777	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_Int	I
    //   1186: lload 8
    //   1188: lstore 10
    //   1190: aload_2
    //   1191: invokevirtual 784	com/squareup/okhttp/Response:code	()I
    //   1194: invokestatic 791	com/tencent/mobileqq/nearby/now/protocol/NowRequest:a	(I)V
    //   1197: goto -161 -> 1036
    //   1200: astore_2
    //   1201: ldc 66
    //   1203: iconst_1
    //   1204: aload_2
    //   1205: iconst_0
    //   1206: anewarray 4	java/lang/Object
    //   1209: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1212: aload_0
    //   1213: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1216: sipush -1005
    //   1219: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1222: aload_0
    //   1223: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1226: ldc 119
    //   1228: putfield 173	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1231: aload_0
    //   1232: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1235: ldc 119
    //   1237: putfield 180	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1240: lload 10
    //   1242: lstore 8
    //   1244: goto -208 -> 1036
    //   1247: astore_2
    //   1248: aload 16
    //   1250: astore_1
    //   1251: aload_0
    //   1252: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1255: sipush -1005
    //   1258: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1261: aload_0
    //   1262: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1265: lconst_0
    //   1266: putfield 238	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_b_of_type_Long	J
    //   1269: aload_0
    //   1270: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1273: ldc 119
    //   1275: putfield 173	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1278: aload_0
    //   1279: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1282: ldc 119
    //   1284: putfield 180	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1287: aload_0
    //   1288: aload_0
    //   1289: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1292: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   1295: ldc 66
    //   1297: iconst_1
    //   1298: aload_2
    //   1299: iconst_0
    //   1300: anewarray 4	java/lang/Object
    //   1303: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1306: aload_1
    //   1307: ifnull -1249 -> 58
    //   1310: aload_1
    //   1311: invokevirtual 663	java/io/FileInputStream:close	()V
    //   1314: return
    //   1315: astore_1
    //   1316: aload_1
    //   1317: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   1320: return
    //   1321: aload_1
    //   1322: invokevirtual 792	java/io/ByteArrayOutputStream:close	()V
    //   1325: aload 16
    //   1327: invokevirtual 663	java/io/FileInputStream:close	()V
    //   1330: aload_0
    //   1331: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1334: iload 7
    //   1336: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1339: aload_0
    //   1340: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1343: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   1346: aload_0
    //   1347: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1350: getfield 637	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:d	J
    //   1353: lsub
    //   1354: putfield 679	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_f_of_type_Long	J
    //   1357: aload_0
    //   1358: aload_0
    //   1359: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1362: invokespecial 186	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;)V
    //   1365: aload 16
    //   1367: ifnull -1309 -> 58
    //   1370: aload 16
    //   1372: invokevirtual 663	java/io/FileInputStream:close	()V
    //   1375: return
    //   1376: astore_1
    //   1377: aload_1
    //   1378: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   1381: return
    //   1382: aload_1
    //   1383: invokevirtual 792	java/io/ByteArrayOutputStream:close	()V
    //   1386: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   1389: lstore 8
    //   1391: aload_0
    //   1392: getfield 48	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderUploadSpeedLimit	Lcom/tencent/mobileqq/nearby/now/send/uploader/UploadSpeedLimit;
    //   1395: iload 6
    //   1397: sipush 1024
    //   1400: idiv
    //   1401: lload 8
    //   1403: lload 10
    //   1405: lsub
    //   1406: l2i
    //   1407: invokevirtual 673	com/tencent/mobileqq/nearby/now/send/uploader/UploadSpeedLimit:a	(II)I
    //   1410: istore 5
    //   1412: iload 4
    //   1414: iload 6
    //   1416: iadd
    //   1417: istore 4
    //   1419: aload_0
    //   1420: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1423: iload 4
    //   1425: i2l
    //   1426: putfield 238	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_b_of_type_Long	J
    //   1429: aload_0
    //   1430: ldc2_w 793
    //   1433: iload 4
    //   1435: bipush 70
    //   1437: imul
    //   1438: i2l
    //   1439: lload 12
    //   1441: ldiv
    //   1442: ladd
    //   1443: l2i
    //   1444: iload 6
    //   1446: invokespecial 493	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:a	(II)V
    //   1449: goto -1082 -> 367
    //   1452: aload_0
    //   1453: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1456: iconst_0
    //   1457: putfield 183	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_a_of_type_Int	I
    //   1460: aload_0
    //   1461: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1464: iconst_0
    //   1465: putfield 777	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_c_of_type_Int	I
    //   1468: aload_0
    //   1469: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1472: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   1475: aload_0
    //   1476: getfield 43	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader:jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult	Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult;
    //   1479: getfield 637	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:d	J
    //   1482: lsub
    //   1483: putfield 679	com/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader$UploadResult:jdField_f_of_type_Long	J
    //   1486: invokestatic 551	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   1489: new 796	aejf
    //   1492: dup
    //   1493: aload_0
    //   1494: invokespecial 797	aejf:<init>	(Lcom/tencent/mobileqq/nearby/now/send/uploader/VideoFeedsUploader;)V
    //   1497: invokevirtual 562	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1500: pop
    //   1501: aload 16
    //   1503: ifnull -1445 -> 58
    //   1506: aload 16
    //   1508: invokevirtual 663	java/io/FileInputStream:close	()V
    //   1511: return
    //   1512: astore_1
    //   1513: aload_1
    //   1514: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   1517: return
    //   1518: astore_1
    //   1519: aconst_null
    //   1520: astore_2
    //   1521: aload_2
    //   1522: ifnull +7 -> 1529
    //   1525: aload_2
    //   1526: invokevirtual 663	java/io/FileInputStream:close	()V
    //   1529: aload_1
    //   1530: athrow
    //   1531: astore_2
    //   1532: aload_2
    //   1533: invokevirtual 666	java/io/IOException:printStackTrace	()V
    //   1536: goto -7 -> 1529
    //   1539: astore_1
    //   1540: aload 16
    //   1542: astore_2
    //   1543: goto -22 -> 1521
    //   1546: astore_3
    //   1547: aload_1
    //   1548: astore_2
    //   1549: aload_3
    //   1550: astore_1
    //   1551: goto -30 -> 1521
    //   1554: astore_2
    //   1555: goto -304 -> 1251
    //   1558: goto -987 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1561	0	this	VideoFeedsUploader
    //   0	1561	1	paramList	List
    //   0	1561	2	paramArrayOfByte	byte[]
    //   0	1561	3	paramString	String
    //   0	1561	4	paramInt	int
    //   362	1049	5	i	int
    //   430	1015	6	j	int
    //   985	350	7	k	int
    //   107	1295	8	l1	long
    //   791	613	10	l2	long
    //   202	1238	12	l3	long
    //   949	32	14	l4	long
    //   188	1353	16	localFileInputStream	java.io.FileInputStream
    //   138	710	17	str	String
    //   116	591	18	localObject	Object
    //   339	413	19	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   311	316	317	java/io/IOException
    //   404	409	410	java/io/IOException
    //   536	541	542	java/io/IOException
    //   818	823	1200	java/lang/Exception
    //   827	836	1200	java/lang/Exception
    //   840	860	1200	java/lang/Exception
    //   864	872	1200	java/lang/Exception
    //   876	886	1200	java/lang/Exception
    //   890	900	1200	java/lang/Exception
    //   904	914	1200	java/lang/Exception
    //   918	927	1200	java/lang/Exception
    //   931	938	1200	java/lang/Exception
    //   942	951	1200	java/lang/Exception
    //   955	963	1200	java/lang/Exception
    //   967	974	1200	java/lang/Exception
    //   978	987	1200	java/lang/Exception
    //   1000	1009	1200	java/lang/Exception
    //   1013	1022	1200	java/lang/Exception
    //   1026	1036	1200	java/lang/Exception
    //   1081	1087	1200	java/lang/Exception
    //   1091	1099	1200	java/lang/Exception
    //   1103	1110	1200	java/lang/Exception
    //   1114	1160	1200	java/lang/Exception
    //   1164	1173	1200	java/lang/Exception
    //   1177	1186	1200	java/lang/Exception
    //   1190	1197	1200	java/lang/Exception
    //   190	277	1247	java/lang/Exception
    //   284	306	1247	java/lang/Exception
    //   323	364	1247	java/lang/Exception
    //   367	399	1247	java/lang/Exception
    //   416	432	1247	java/lang/Exception
    //   438	469	1247	java/lang/Exception
    //   469	531	1247	java/lang/Exception
    //   555	569	1247	java/lang/Exception
    //   571	649	1247	java/lang/Exception
    //   652	765	1247	java/lang/Exception
    //   774	786	1247	java/lang/Exception
    //   799	814	1247	java/lang/Exception
    //   1036	1048	1247	java/lang/Exception
    //   1053	1068	1247	java/lang/Exception
    //   1201	1240	1247	java/lang/Exception
    //   1321	1365	1247	java/lang/Exception
    //   1382	1412	1247	java/lang/Exception
    //   1419	1449	1247	java/lang/Exception
    //   1452	1501	1247	java/lang/Exception
    //   1310	1314	1315	java/io/IOException
    //   1370	1375	1376	java/io/IOException
    //   1506	1511	1512	java/io/IOException
    //   179	190	1518	finally
    //   1525	1529	1531	java/io/IOException
    //   190	277	1539	finally
    //   284	306	1539	finally
    //   323	364	1539	finally
    //   367	399	1539	finally
    //   416	432	1539	finally
    //   438	469	1539	finally
    //   469	531	1539	finally
    //   555	569	1539	finally
    //   571	649	1539	finally
    //   652	765	1539	finally
    //   774	786	1539	finally
    //   799	814	1539	finally
    //   818	823	1539	finally
    //   827	836	1539	finally
    //   840	860	1539	finally
    //   864	872	1539	finally
    //   876	886	1539	finally
    //   890	900	1539	finally
    //   904	914	1539	finally
    //   918	927	1539	finally
    //   931	938	1539	finally
    //   942	951	1539	finally
    //   955	963	1539	finally
    //   967	974	1539	finally
    //   978	987	1539	finally
    //   1000	1009	1539	finally
    //   1013	1022	1539	finally
    //   1026	1036	1539	finally
    //   1036	1048	1539	finally
    //   1053	1068	1539	finally
    //   1081	1087	1539	finally
    //   1091	1099	1539	finally
    //   1103	1110	1539	finally
    //   1114	1160	1539	finally
    //   1164	1173	1539	finally
    //   1177	1186	1539	finally
    //   1190	1197	1539	finally
    //   1201	1240	1539	finally
    //   1321	1365	1539	finally
    //   1382	1412	1539	finally
    //   1419	1449	1539	finally
    //   1452	1501	1539	finally
    //   1251	1306	1546	finally
    //   179	190	1554	java/lang/Exception
  }
  
  private boolean a(long paramLong)
  {
    long l = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.d) / 1000L;
    paramLong = a(paramLong) / 1000L;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.d > 0L) && (paramLong > 0L) && (l >= paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsUploader", 2, String.format("上传已经耗时%d秒，超出最大耗时%d秒，结束上传!", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "step4: uploadDoodleImage");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 4;
    if (jdField_a_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo == null) {
      i = 0;
    }
    while (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_f_of_type_JavaLangString, new aejh(this));
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.m)) {
        i = 0;
      } else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_f_of_type_JavaLangString)) {
        i = 0;
      }
    }
    a(90, 0);
    c();
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "step0: calcVideoMd5");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 0;
    a(5, 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1002;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return false;
    }
    ThreadManager.post(new aeiy(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_d_of_type_JavaLangString), 5, null, false);
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, "Step5: sendFeeds");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_Int = 5;
    if (jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1005;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.a()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1002;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Int = -1007;
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult);
      return;
    }
    ilive_feeds_write.AddFeedReq localAddFeedReq = new ilive_feeds_write.AddFeedReq();
    localAddFeedReq.feed_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_e_of_type_Int);
    localAddFeedReq.feed_source.set(4);
    localAddFeedReq.feed_upload_status.set(3);
    localAddFeedReq.local_video_flag.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_f_of_type_Int);
    Object localObject1 = new ilive_feeds_tmem.VideoFeed();
    ((ilive_feeds_tmem.VideoFeed)localObject1).anchor_uin.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_j_of_type_Long);
    ((ilive_feeds_tmem.VideoFeed)localObject1).video_time.set((int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_f_of_type_Long);
    ((ilive_feeds_tmem.VideoFeed)localObject1).video_width.set((int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_Long);
    ((ilive_feeds_tmem.VideoFeed)localObject1).video_hight.set((int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_h_of_type_Long);
    ((ilive_feeds_tmem.VideoFeed)localObject1).file_id.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).pic_url.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_e_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).doodle_pic_url.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_f_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).video_url.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_g_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).video_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_c_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).start_time.set((int)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_Long);
    Object localObject2 = ((ilive_feeds_tmem.VideoFeed)localObject1).has_face;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_d_of_type_Int > 0) {}
    for (int i = 1;; i = 2)
    {
      ((PBUInt32Field)localObject2).set(i);
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsUploader", 2, "Step5: sendFeeds.mUploadInfo.topic=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (QLog.isColorLevel()) {
          QLog.i("VideoFeedsUploader", 2, "Step5: sendFeeds.topic=" + str);
        }
        ((ilive_feeds_tmem.VideoFeed)localObject1).topic.add(ByteStringMicro.copyFrom(str.getBytes()));
      }
    }
    ((ilive_feeds_tmem.VideoFeed)localObject1).lng.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_h_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).lat.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_i_of_type_JavaLangString.getBytes()));
    ((ilive_feeds_tmem.VideoFeed)localObject1).city.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_j_of_type_JavaLangString.getBytes()));
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, String.format("LocationInfo", new Object[] { "step5_sendFeeds --- city: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_j_of_type_JavaLangString + ", lat: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_i_of_type_JavaLangString + ", lnt: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_h_of_type_JavaLangString + ", isLocalVideo: " + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_f_of_type_Int }));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_JavaLangString)) {
      ((ilive_feeds_tmem.VideoFeed)localObject1).desc.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_JavaLangString.getBytes()));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaLangString)) {
      ((ilive_feeds_tmem.VideoFeed)localObject1).vid.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaLangString.getBytes()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.size())
      {
        ((List)localObject2).add(ByteStringMicro.copyFrom(((String)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_JavaUtilList.get(i)).getBytes()));
        i += 1;
      }
      ((ilive_feeds_tmem.VideoFeed)localObject1).topic.set((List)localObject2);
    }
    localAddFeedReq.feed_video.set((MessageMicro)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
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
    new CsTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(24608).b(1).a(new aejj(this)).a(new aeji(this)).a(localAddFeedReq);
  }
  
  private void d() {}
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(VideoFeedsUploader.UploadInfo arg1, VideoFeedsUploader.UploadListener paramUploadListener)
  {
    if ((??? == null) || (???.a())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener = paramUploadListener;
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo = new VideoFeedsUploader.UploadInfo(???);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Video_Feeds_Upload_Thread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, ???.a());
    }
    paramUploadListener = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_b_of_type_JavaLangString);
    synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
    {
      PublishManager.jdField_a_of_type_JavaUtilHashMap.put(paramUploadListener.fakeVid, Integer.valueOf(1));
      paramUploadListener.publishState = 3;
      PublishManager.a(a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult, paramUploadListener));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo);
      }
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).c(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
      b();
      return true;
    }
  }
  
  public boolean b(VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadListener arg2)
  {
    if ((paramUploadInfo == null) || (paramUploadInfo.a())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener = ???;
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo = paramUploadInfo;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_b_of_type_JavaLangString;
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
    localPublishVideoEntry.publishState = 3;
    PublishManager.a(localPublishVideoEntry);
    for (;;)
    {
      synchronized (PublishManager.jdField_a_of_type_JavaLangObject)
      {
        PublishManager.jdField_a_of_type_JavaUtilHashMap.put(localPublishVideoEntry.fakeVid, Integer.valueOf(1));
        ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).c(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_AndroidOsHandler == null)
        {
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Video_Feeds_Upload_Thread");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoFeedsUploader", 2, paramUploadInfo.a());
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.n)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_Int <= 2)) {
          break label369;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.l;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.n;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.k;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.m;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_Int == 3) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.l)))
        {
          a();
          return true;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.jdField_g_of_type_Int == 4) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadInfo.m)))
      {
        b();
      }
      else
      {
        c();
        continue;
        label369:
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader
 * JD-Core Version:    0.7.0.1
 */