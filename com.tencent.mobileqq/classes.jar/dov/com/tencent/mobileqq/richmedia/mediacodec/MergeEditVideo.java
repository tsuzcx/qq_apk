package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder.EncodeFilterRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoderWithAudio;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MergeEditVideo
{
  public static int a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 1280;
  }
  
  private void a(MergeEditVideo.EditParam paramEditParam, DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(j), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + paramEncodeConfig.toString());
      }
      if (bool1)
      {
        if (j != 0)
        {
          paramEncodeConfig.h = j;
          if (i == 0) {
            break label389;
          }
          paramEncodeConfig.g = 0;
        }
        label147:
        j = paramEncodeConfig.jdField_a_of_type_Int;
        i = paramEncodeConfig.b;
        if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14) {
          break label412;
        }
        j = Math.min(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
        i = Math.max(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      }
    }
    for (;;)
    {
      int m = i;
      int k = j;
      if (i > jdField_a_of_type_Int)
      {
        k = (int)(j * jdField_a_of_type_Int / i);
        m = jdField_a_of_type_Int;
      }
      paramEncodeConfig.jdField_a_of_type_Int = CaptureUtil.a(k);
      paramEncodeConfig.b = CaptureUtil.a(m);
      paramDecodeConfig.width = paramEncodeConfig.jdField_a_of_type_Int;
      paramDecodeConfig.height = paramEncodeConfig.b;
      if (paramEncodeConfig.c)
      {
        k = paramEncodeConfig.jdField_a_of_type_Int;
        m = (int)(paramEncodeConfig.jdField_a_of_type_Int * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > jdField_a_of_type_Int)
        {
          i = (int)(k * jdField_a_of_type_Int / m);
          j = jdField_a_of_type_Int;
        }
        paramEncodeConfig.jdField_a_of_type_Int = CaptureUtil.a(i);
        paramEncodeConfig.b = CaptureUtil.a(j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramEncodeConfig.toString());
      }
      return;
      i = 0;
      break;
      label389:
      if (bool2)
      {
        paramEncodeConfig.g = 270;
        break label147;
      }
      paramEncodeConfig.g = 0;
      break label147;
      label412:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
        i = Math.max(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      }
      else
      {
        paramEncodeConfig.d = false;
      }
    }
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, MergeEditVideo.EditParam paramEditParam, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((paramEditParam == null) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null))
    {
      i = -1;
      return i;
    }
    paramEditParam.a(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
    boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    String str = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
    boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
    Object localObject1;
    if (localObject3 == null)
    {
      localObject1 = null;
      bool1 = false;
    }
    label272:
    label446:
    label843:
    for (;;)
    {
      label86:
      if ((paramEditParam.c == 0) && (paramEditParam.b == 0) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool2) && (!paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments))) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new MediaMetadataUtils.MetaData();
        j = MediaMetadataUtils.a(???, (MediaMetadataUtils.MetaData)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.a[0];
        n = localObject2.a[1];
        i1 = localObject2.a[2];
        if (a(paramEditParam, paramPublishVideoEntry, m, n, bool1)) {
          break label272;
        }
        QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
        return -1;
        localObject1 = FilterDesc.parse((JSONArray)localObject3);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label843;
        }
        bool1 = false;
        break label86;
      }
      i = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      int j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
      if (paramEditParam.c == 5)
      {
        ??? = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = true;
          JSONObject localJSONObject = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
          localObject2 = null;
          if (localJSONObject != null) {
            localObject2 = new MusicItemInfo(localJSONObject);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + ((JSONArray)localObject3).toString());
            localObject3 = new StringBuilder().append("getMusicInfo id = ");
            if (localObject2 == null) {
              break label791;
            }
            k = ((MusicItemInfo)localObject2).mItemId;
          }
        }
        for (;;)
        {
          QLog.d("MergeEditVideo", 2, k);
          localObject1 = new QQEncodeFilterRender((List)localObject1, (MusicItemInfo)localObject2, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject2 = new Mp4ReEncoderWithAudio();
            paramString2 = new EncodeConfig(paramString2, m, n, paramEditParam.jdField_a_of_type_Int, 1, 30, paramEditParam.b, false, i1, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, paramEditParam.jdField_a_of_type_Boolean);
            ??? = new DecodeConfig(???, paramEditParam.c, false, true, i, j);
            ???.width = m;
            ???.height = n;
            paramString2.c = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
            a(paramEditParam, ???, paramString2, paramPublishVideoEntry);
            ???.isLocal = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
            ???.isLandscape = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
            ???.adjustRotation = i1;
            paramString2.j = paramEditParam.d;
            paramString2.k = paramEditParam.e;
            if ((paramEditParam.d == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.j = 0;
            }
            localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((Mp4ReEncoder)localObject2).a(DoodleUtil.a((String)localObject3));
            }
            paramEditParam = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
            if (paramEditParam != null) {
              ((Mp4ReEncoder)localObject2).b(TrackerStickerParam.FromString(paramEditParam));
            }
            if (str != null) {
              ((Mp4ReEncoder)localObject2).a(str);
            }
            ((Mp4ReEncoder)localObject2).a(???, paramString2, new MergeEditVideo.1(this, (QQEncodeFilterRender)localObject1, paramString2, paramPublishVideoEntry, (Mp4ReEncoder)localObject2), (Mp4ReEncoder.EncodeFilterRender)localObject1);
            if (this.jdField_a_of_type_Boolean) {}
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            bool1 = this.jdField_a_of_type_Boolean;
            if (!bool1) {}
            try
            {
              this.jdField_a_of_type_JavaLangObject.wait();
              if (paramPublishVideoEntry.isCancel)
              {
                return -16;
                k = -1;
                continue;
                localObject1 = null;
                break label446;
                localObject2 = new Mp4ReEncoder();
              }
            }
            catch (InterruptedException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
        }
        if (((Mp4ReEncoder)localObject2).jdField_a_of_type_Int == 0) {
          return 0;
        }
        return 1;
      }
    }
  }
  
  public boolean a(MergeEditVideo.EditParam paramEditParam, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      if (!paramPublishVideoEntry.isLocalPublish) {
        return false;
      }
      if ((!paramPublishVideoEntry.isMuteRecordVoice) || (!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)))
      {
        long l = ShortVideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir);
        if ((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart <= 0) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd >= l))
        {
          if ((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 11) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 12) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14)) {
            return false;
          }
          paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
          if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {}
          for (paramInt1 = 1; (paramInt1 != 0) && ((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 11) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12)); paramInt1 = 0) {
            return false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */