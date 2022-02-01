package com.tencent.mobileqq.editor.composite.step;

import android.text.TextUtils;
import com.tencent.mobileqq.editor.composite.util.CompositeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.QQEncodeFilterRender;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder.EncodeFilterRender;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoderWithAudio;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MergeEditVideo
{
  public static int a = 1280;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private void a(MergeEditVideo.EditParam paramEditParam, DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int j = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    if (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId == 14) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(j), ", isLocalImport:", Boolean.valueOf(bool1) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("before adjust config: ");
      localStringBuilder.append(paramEncodeConfig.toString());
      QLog.d("MergeEditVideo", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      if (j != 0)
      {
        paramEncodeConfig.h = j;
        if (i != 0) {
          paramEncodeConfig.g = 0;
        } else if (bool2) {
          paramEncodeConfig.g = 270;
        } else {
          paramEncodeConfig.g = 0;
        }
      }
      i = paramEncodeConfig.jdField_a_of_type_Int;
      j = paramEncodeConfig.b;
      if (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId != 14)
      {
        i = Math.min(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
        j = Math.max(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      }
      else if ((!paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) && (bool2))
      {
        paramEncodeConfig.d = false;
      }
      else
      {
        i = Math.min(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
        j = Math.max(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      }
      int k = jdField_a_of_type_Int;
      double d1;
      double d2;
      double d3;
      if (j > k)
      {
        d1 = i;
        d2 = k;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d3 = j;
        Double.isNaN(d3);
        i = (int)(d1 * d2 / d3);
        j = k;
      }
      paramEncodeConfig.jdField_a_of_type_Int = CompositeUtil.a(i);
      paramEncodeConfig.b = CompositeUtil.a(j);
      paramDecodeConfig.width = paramEncodeConfig.jdField_a_of_type_Int;
      paramDecodeConfig.height = paramEncodeConfig.b;
      if (paramEncodeConfig.c)
      {
        int m = paramEncodeConfig.jdField_a_of_type_Int;
        int n = (int)(paramEncodeConfig.jdField_a_of_type_Int * 16.0F / 9.0F);
        k = jdField_a_of_type_Int;
        j = m;
        i = n;
        if (n > k)
        {
          d1 = m;
          d2 = k;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d3 = n;
          Double.isNaN(d3);
          j = (int)(d1 * d2 / d3);
          i = k;
        }
        paramEncodeConfig.jdField_a_of_type_Int = CompositeUtil.a(j);
        paramEncodeConfig.b = CompositeUtil.a(i);
      }
    }
    if (QLog.isColorLevel())
    {
      paramEditParam = new StringBuilder();
      paramEditParam.append("adjust encodeConfig result:");
      paramEditParam.append(paramEncodeConfig.toString());
      QLog.d("MergeEditVideo", 2, paramEditParam.toString());
    }
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, MergeEditVideo.EditParam paramEditParam, PublishVideoEntry paramPublishVideoEntry)
  {
    int k = -1;
    if (paramEditParam != null)
    {
      if (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry == null) {
        return -1;
      }
      paramEditParam.a(paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.saveMode);
      boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
      Object localObject3 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
      String str = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
      boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
      Object localObject1;
      if (localObject3 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        bool1 = false;
        break;
        localObject1 = FilterDesc.parse((JSONArray)localObject3);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break;
        }
      }
      if ((paramEditParam.c == 0) && (paramEditParam.b == 0) && (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath == null) && (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject2 = new MediaMetadataUtils.MetaData();
      int i = MediaMetadataUtils.a(???, (MediaMetadataUtils.MetaData)localObject2);
      if (i != 0) {
        return i;
      }
      int m = localObject2.a[0];
      int n = localObject2.a[1];
      int i1 = localObject2.a[2];
      if (!a(paramEditParam, paramPublishVideoEntry, m, n, bool1))
      {
        QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
        return -1;
      }
      i = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoRangeStart;
      int j = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoRangeEnd;
      if (paramEditParam.c == 5)
      {
        ??? = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mIFrameVideoPath;
        i = 0;
        j = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
        if (localObject2 != null) {
          localObject2 = new MusicItemInfo((JSONObject)localObject2);
        } else {
          localObject2 = null;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAVFilterJSONArray ");
          localStringBuilder.append(((JSONArray)localObject3).toString());
          QLog.d("MergeEditVideo", 2, localStringBuilder.toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getMusicInfo id = ");
          if (localObject2 != null) {
            k = ((MusicItemInfo)localObject2).mItemId;
          }
          ((StringBuilder)localObject3).append(k);
          QLog.d("MergeEditVideo", 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = new QQEncodeFilterRender((List)localObject1, (MusicItemInfo)localObject2, m, n, null);
      }
      else
      {
        localObject1 = null;
      }
      if ((!a(paramPublishVideoEntry)) && (!paramPublishVideoEntry.isMixOriginal))
      {
        localObject2 = new Mp4ReEncoder();
      }
      else
      {
        QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
        localObject2 = new Mp4ReEncoderWithAudio();
      }
      paramString2 = new EncodeConfig(paramString2, m, n, paramEditParam.jdField_a_of_type_Int, 1, 30, paramEditParam.b, false, i1, paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mosaicPath, null, paramEditParam.jdField_a_of_type_Boolean);
      ??? = new DecodeConfig(???, paramEditParam.c, false, true, i, j);
      ???.width = m;
      ???.height = n;
      paramString2.c = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
      a(paramEditParam, ???, paramString2, paramPublishVideoEntry);
      ???.isLocal = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
      ???.isLandscape = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
      ???.adjustRotation = i1;
      paramString2.i = paramEditParam.d;
      paramString2.j = paramEditParam.e;
      paramEditParam = paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
      if (paramEditParam != null) {
        ((Mp4ReEncoder)localObject2).a(CompositeUtil.a(paramEditParam));
      }
      if (str != null) {
        ((Mp4ReEncoder)localObject2).a(str);
      }
      ((Mp4ReEncoder)localObject2).a(???, paramString2, new MergeEditVideo.1(this, (QQEncodeFilterRender)localObject1, paramString2, paramPublishVideoEntry, (Mp4ReEncoder)localObject2), (Mp4ReEncoder.EncodeFilterRender)localObject1);
      if (!this.jdField_a_of_type_Boolean) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool1 = this.jdField_a_of_type_Boolean;
          if (!bool1) {
            try
            {
              this.jdField_a_of_type_JavaLangObject.wait();
            }
            catch (InterruptedException paramString2)
            {
              paramString2.printStackTrace();
            }
          }
        }
      }
      if (paramPublishVideoEntry.isCancel) {
        return -16;
      }
      if (((Mp4ReEncoder)localObject2).jdField_a_of_type_Int == 0) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public boolean a(MergeEditVideo.EditParam paramEditParam, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return true;
    }
    if (!paramPublishVideoEntry.isLocalPublish) {
      return false;
    }
    if ((paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath))) {
      return true;
    }
    long l = CompositeUtil.a(paramPublishVideoEntry.mLocalRawVideoDir);
    if (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoRangeStart <= 0)
    {
      if (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoRangeEnd < l) {
        return true;
      }
      if ((paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId != 11) && (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId != 12) && (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId != 14)) {
        return false;
      }
      paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
      if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((paramInt1 != 0) && ((paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId == 11) || (paramEditParam.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.businessId == 12))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */