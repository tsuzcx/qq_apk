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
  private Object b = new Object();
  private volatile boolean c = false;
  
  private void a(MergeEditVideo.EditParam paramEditParam, DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = paramEditParam.b.getBooleanExtra("local_import", false);
    int j = paramEditParam.b.getIntExtra("video_rotation", 0);
    boolean bool2 = paramEditParam.b.getBooleanExtra("landscape_video", false);
    int i;
    if (paramEditParam.b.businessId == 14) {
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
        paramEncodeConfig.m = j;
        if (i != 0) {
          paramEncodeConfig.l = 0;
        } else if (bool2) {
          paramEncodeConfig.l = 270;
        } else {
          paramEncodeConfig.l = 0;
        }
      }
      i = paramEncodeConfig.c;
      j = paramEncodeConfig.d;
      if (paramEditParam.b.businessId != 14)
      {
        i = Math.min(paramEncodeConfig.c, paramEncodeConfig.d);
        j = Math.max(paramEncodeConfig.c, paramEncodeConfig.d);
      }
      else if ((!paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) && (bool2))
      {
        paramEncodeConfig.u = false;
      }
      else
      {
        i = Math.min(paramEncodeConfig.c, paramEncodeConfig.d);
        j = Math.max(paramEncodeConfig.c, paramEncodeConfig.d);
      }
      int k = a;
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
      paramEncodeConfig.c = CompositeUtil.a(i);
      paramEncodeConfig.d = CompositeUtil.a(j);
      paramDecodeConfig.width = paramEncodeConfig.c;
      paramDecodeConfig.height = paramEncodeConfig.d;
      if (paramEncodeConfig.r)
      {
        int m = paramEncodeConfig.c;
        int n = (int)(paramEncodeConfig.c * 16.0F / 9.0F);
        k = a;
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
        paramEncodeConfig.c = CompositeUtil.a(j);
        paramEncodeConfig.d = CompositeUtil.a(i);
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
      if (paramEditParam.b == null) {
        return -1;
      }
      paramEditParam.a(paramEditParam.b.saveMode);
      boolean bool1 = paramEditParam.b.getBooleanExtra("hasAVFilter", false);
      Object localObject3 = paramEditParam.b.getJSONArrayExtra("jsonAVFilterData");
      String str = paramEditParam.b.getStringExtra("transfer_effect_data", null);
      boolean bool2 = paramEditParam.b.getBooleanExtra("extra_is_need_gaussion_blur", false);
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
      if ((paramEditParam.d == 0) && (paramEditParam.c == 0) && (paramEditParam.b.doodlePath == null) && (paramEditParam.b.mosaicPath == null) && (!bool1) && (str == null) && (!bool2)) {
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
      i = paramEditParam.b.videoRangeStart;
      int j = paramEditParam.b.videoRangeEnd;
      if (paramEditParam.d == 5)
      {
        ??? = paramEditParam.b.mIFrameVideoPath;
        i = 0;
        j = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = paramEditParam.b.getJSONExtra("jsonMusicData");
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
      paramString2 = new EncodeConfig(paramString2, m, n, paramEditParam.a, 1, 30, paramEditParam.c, false, i1, paramEditParam.b.doodlePath, paramEditParam.b.mosaicPath, null, paramEditParam.g);
      ??? = new DecodeConfig(???, paramEditParam.d, false, true, i, j);
      ???.width = m;
      ???.height = n;
      paramString2.r = paramEditParam.b.getBooleanExtra("extra_is_need_gaussion_blur", false);
      a(paramEditParam, ???, paramString2, paramPublishVideoEntry);
      ???.isLocal = paramEditParam.b.getBooleanExtra("local_import", false);
      ???.isLandscape = paramEditParam.b.getBooleanExtra("landscape_video", false);
      ???.adjustRotation = i1;
      paramString2.p = paramEditParam.e;
      paramString2.q = paramEditParam.f;
      paramEditParam = paramEditParam.b.getStringExtra("dynamic_Sticker_data", null);
      if (paramEditParam != null) {
        ((Mp4ReEncoder)localObject2).a(CompositeUtil.b(paramEditParam));
      }
      if (str != null) {
        ((Mp4ReEncoder)localObject2).a(str);
      }
      ((Mp4ReEncoder)localObject2).a(???, paramString2, new MergeEditVideo.1(this, (QQEncodeFilterRender)localObject1, paramString2, paramPublishVideoEntry, (Mp4ReEncoder)localObject2), (Mp4ReEncoder.EncodeFilterRender)localObject1);
      if (!this.c) {
        synchronized (this.b)
        {
          bool1 = this.c;
          if (!bool1) {
            try
            {
              this.b.wait();
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
      if (((Mp4ReEncoder)localObject2).e == 0) {
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
    if (paramEditParam.b.videoRangeStart <= 0)
    {
      if (paramEditParam.b.videoRangeEnd < l) {
        return true;
      }
      if ((paramEditParam.b.businessId != 11) && (paramEditParam.b.businessId != 12) && (paramEditParam.b.businessId != 14)) {
        return false;
      }
      paramEditParam.b.getBooleanExtra("landscape_video", false);
      if (Math.max(paramInt1, paramInt2) <= a) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((paramInt1 != 0) && ((paramEditParam.b.businessId == 11) || (paramEditParam.b.businessId == 12))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */