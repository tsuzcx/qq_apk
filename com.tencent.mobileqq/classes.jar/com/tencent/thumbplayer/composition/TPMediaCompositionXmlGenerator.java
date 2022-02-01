package com.tencent.thumbplayer.composition;

import android.util.Xml;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDrmType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class TPMediaCompositionXmlGenerator
{
  private static final String TAG = "TPMediaCompositionXmlGenerator";
  
  static String buildAssetXmlFromComposition(ITPMediaComposition paramITPMediaComposition)
  {
    if (paramITPMediaComposition == null) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    List localList1 = paramITPMediaComposition.getAllAVTracks();
    if (!TPCommonUtils.isEmpty(localList1))
    {
      dealWithTrackInfo(localXmlSerializer, localList1, 1, 0L);
    }
    else
    {
      localList1 = paramITPMediaComposition.getAllVideoTracks();
      List localList2 = paramITPMediaComposition.getAllAudioTracks();
      if ((TPCommonUtils.isEmpty(localList1)) && (TPCommonUtils.isEmpty(localList2))) {
        return "";
      }
      paramITPMediaComposition = (TPMediaComposition)paramITPMediaComposition;
      long l = paramITPMediaComposition.getVideoDuration();
      dealWithTrackInfo(localXmlSerializer, localList1, 2, paramITPMediaComposition.getAudioDuration());
      dealWithTrackInfo(localXmlSerializer, localList2, 3, l);
    }
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  private static void buildWithTrackClipWithTags(XmlSerializer paramXmlSerializer, List<ITPMediaTrackClip> paramList, String paramString1, String paramString2)
  {
    paramXmlSerializer.startTag("", paramString1);
    paramXmlSerializer.startTag("", paramString2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dealWithClipInfo(paramXmlSerializer, (ITPMediaTrackClip)paramList.next());
    }
    paramXmlSerializer.endTag("", paramString2);
    paramXmlSerializer.endTag("", paramString1);
  }
  
  public static String buildXmlPathFromAudioClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    if (paramITPMediaTrackClip == null) {
      return "";
    }
    if (paramITPMediaTrackClip.getMediaType() != 3) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    localXmlSerializer.startTag("", "audio_tracks");
    localXmlSerializer.startTag("", "audio_track");
    dealWithClipInfo(localXmlSerializer, paramITPMediaTrackClip);
    localXmlSerializer.endTag("", "audio_track");
    localXmlSerializer.endTag("", "audio_tracks");
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  static String buildXmlPathFromDrmAsset(ITPMediaDRMAsset paramITPMediaDRMAsset)
  {
    if (paramITPMediaDRMAsset == null) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    localXmlSerializer.startTag("", "av_tracks");
    localXmlSerializer.startTag("", "av_track");
    localXmlSerializer.startTag("", "track_clip");
    localXmlSerializer.startTag("", "clip_id");
    localXmlSerializer.text(Integer.toString(0));
    localXmlSerializer.endTag("", "clip_id");
    localXmlSerializer.startTag("", "clip_placeHolder");
    localXmlSerializer.text("0");
    localXmlSerializer.endTag("", "clip_placeHolder");
    localXmlSerializer.startTag("", "clip_path");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmPlayUrl());
    localXmlSerializer.endTag("", "clip_path");
    localXmlSerializer.startTag("", "clip_drmType");
    localXmlSerializer.text(String.valueOf(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapDrmType.class, paramITPMediaDRMAsset.getDrmType())));
    localXmlSerializer.endTag("", "clip_drmType");
    localXmlSerializer.startTag("", "clip_drmProvisionUrl");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_provision_url", ""));
    localXmlSerializer.endTag("", "clip_drmProvisionUrl");
    localXmlSerializer.startTag("", "clip_drmLicenseUrl");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_license_url", ""));
    localXmlSerializer.endTag("", "clip_drmLicenseUrl");
    localXmlSerializer.startTag("", "clip_drmUseL1");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_use_l1", "1"));
    localXmlSerializer.endTag("", "clip_drmUseL1");
    localXmlSerializer.startTag("", "clip_drmSavePath");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_save_path", ""));
    localXmlSerializer.endTag("", "clip_drmSavePath");
    localXmlSerializer.startTag("", "clip_drmGuid");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_guid", ""));
    localXmlSerializer.endTag("", "clip_drmGuid");
    localXmlSerializer.startTag("", "clip_drmPlatform");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_platform", ""));
    localXmlSerializer.endTag("", "clip_drmPlatform");
    localXmlSerializer.startTag("", "clip_drmAppVersion");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_app_ver", ""));
    localXmlSerializer.endTag("", "clip_drmAppVersion");
    localXmlSerializer.startTag("", "clip_drmCookie");
    localXmlSerializer.text(paramITPMediaDRMAsset.getDrmProperty("drm_property_cookie", ""));
    localXmlSerializer.endTag("", "clip_drmCookie");
    localXmlSerializer.endTag("", "track_clip");
    localXmlSerializer.endTag("", "av_track");
    localXmlSerializer.endTag("", "av_tracks");
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  public static String buildXmlPathFromMediaTrackClip(@Nullable ITPMediaTrackClip paramITPMediaTrackClip1, @Nullable ITPMediaTrackClip paramITPMediaTrackClip2)
  {
    if ((paramITPMediaTrackClip1 == null) && (paramITPMediaTrackClip2 == null)) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    if ((paramITPMediaTrackClip1 != null) && (paramITPMediaTrackClip1.getMediaType() == 2))
    {
      localXmlSerializer.startTag("", "video_tracks");
      localXmlSerializer.startTag("", "video_track");
      dealWithClipInfo(localXmlSerializer, paramITPMediaTrackClip1);
      localXmlSerializer.endTag("", "video_track");
      localXmlSerializer.endTag("", "video_tracks");
    }
    if ((paramITPMediaTrackClip2 != null) && (paramITPMediaTrackClip2.getMediaType() == 3))
    {
      localXmlSerializer.startTag("", "audio_tracks");
      localXmlSerializer.startTag("", "audio_track");
      dealWithClipInfo(localXmlSerializer, paramITPMediaTrackClip2);
      localXmlSerializer.endTag("", "audio_track");
      localXmlSerializer.endTag("", "audio_tracks");
    }
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  static String buildXmlPathFromRtcAsset(ITPMediaRTCAsset paramITPMediaRTCAsset)
  {
    if (paramITPMediaRTCAsset == null) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    localXmlSerializer.startTag("", "av_tracks");
    localXmlSerializer.startTag("", "av_track");
    localXmlSerializer.startTag("", "track_clip");
    localXmlSerializer.startTag("", "clip_id");
    localXmlSerializer.text(Integer.toString(0));
    localXmlSerializer.endTag("", "clip_id");
    localXmlSerializer.startTag("", "clip_placeHolder");
    localXmlSerializer.text("0");
    localXmlSerializer.endTag("", "clip_placeHolder");
    localXmlSerializer.startTag("", "clip_path");
    localXmlSerializer.text(paramITPMediaRTCAsset.getRtcStreamUrl());
    localXmlSerializer.endTag("", "clip_path");
    localXmlSerializer.startTag("", "clip_rtcServerUrl");
    localXmlSerializer.text(paramITPMediaRTCAsset.getRtcServerUrl());
    localXmlSerializer.endTag("", "clip_rtcServerUrl");
    localXmlSerializer.endTag("", "track_clip");
    localXmlSerializer.endTag("", "av_track");
    localXmlSerializer.endTag("", "av_tracks");
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  static String buildXmlPathFromTrackInfo(List<ITPMediaTrackClip> paramList, int paramInt)
  {
    if (TPCommonUtils.isEmpty(paramList)) {
      return "";
    }
    String str2;
    String str1;
    if (paramInt == 1)
    {
      str2 = "av_tracks";
      str1 = "av_track";
    }
    else if (paramInt == 2)
    {
      str2 = "video_tracks";
      str1 = "video_track";
    }
    else
    {
      if (paramInt != 3) {
        break label130;
      }
      str2 = "audio_tracks";
      str1 = "audio_track";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    buildWithTrackClipWithTags(localXmlSerializer, paramList, str2, str1);
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
    label130:
    return "";
  }
  
  public static String buildXmlPathFromVideoClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    if (paramITPMediaTrackClip == null) {
      return "";
    }
    if (paramITPMediaTrackClip.getMediaType() != 2) {
      return "";
    }
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
    localXmlSerializer.startTag("", "assets");
    localXmlSerializer.startTag("", "video_tracks");
    localXmlSerializer.startTag("", "video_track");
    dealWithClipInfo(localXmlSerializer, paramITPMediaTrackClip);
    localXmlSerializer.endTag("", "video_track");
    localXmlSerializer.endTag("", "video_tracks");
    localXmlSerializer.endTag("", "assets");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  private static void dealClipWithInterval(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    if ((paramITPMediaTrackClip instanceof TPEmptyTrackClip))
    {
      dealEmptyTrackClip(paramXmlSerializer, paramITPMediaTrackClip, paramLong);
      return;
    }
    if ((paramITPMediaTrackClip instanceof TPMediaCompositionTrackClip)) {
      dealNormalTrackClip(paramXmlSerializer, paramITPMediaTrackClip, paramLong);
    }
  }
  
  private static void dealEmptyTrackClip(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(paramITPMediaTrackClip.getClipId()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("1");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_playTimeMs");
    if (paramLong > 0L) {
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs() - paramLong));
    } else {
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
    }
    paramXmlSerializer.endTag("", "clip_playTimeMs");
    paramXmlSerializer.endTag("", "track_clip");
  }
  
  private static void dealNormalTrackClip(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(paramITPMediaTrackClip.getClipId()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("0");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_path");
    paramXmlSerializer.text(paramITPMediaTrackClip.getFilePath());
    paramXmlSerializer.endTag("", "clip_path");
    paramXmlSerializer.startTag("", "clip_startTimeMs");
    paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getStartTimeMs()));
    paramXmlSerializer.endTag("", "clip_startTimeMs");
    paramXmlSerializer.startTag("", "clip_durationMs");
    paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
    paramXmlSerializer.endTag("", "clip_durationMs");
    if (paramLong > 0L)
    {
      long l1 = paramITPMediaTrackClip.getEndTimeMs();
      long l2 = paramITPMediaTrackClip.getOriginalDurationMs();
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(l1 - paramLong));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(l2 - paramLong));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
    else
    {
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getEndTimeMs()));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
    paramXmlSerializer.endTag("", "track_clip");
  }
  
  private static void dealWithClipInfo(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip)
  {
    dealClipWithInterval(paramXmlSerializer, paramITPMediaTrackClip, 0L);
  }
  
  private static void dealWithTrackInfo(XmlSerializer paramXmlSerializer, List<ITPMediaTrack> paramList, int paramInt, long paramLong)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          String str1 = getTrackTagWithMediaType(paramInt, true);
          String str2 = getTrackTagWithMediaType(paramInt, false);
          paramXmlSerializer.startTag("", str1);
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject = (ITPMediaTrack)paramList.next();
            if (((ITPMediaTrack)localObject).getMediaType() == paramInt)
            {
              paramXmlSerializer.startTag("", str2);
              paramXmlSerializer.startTag("", "track_id");
              paramXmlSerializer.text(Integer.toString(((ITPMediaTrack)localObject).getTrackId()));
              paramXmlSerializer.endTag("", "track_id");
              long l;
              if ((paramInt != 1) && (TPMediaCompositionHelper.composition_duration_strategy.equals("base_audio")) && (((ITPMediaTrack)localObject).getTimelineDurationMs() > paramLong))
              {
                l = 0L;
                localObject = ((ITPMediaTrack)localObject).getAllTrackClips().iterator();
              }
              while (((Iterator)localObject).hasNext())
              {
                ITPMediaTrackClip localITPMediaTrackClip = (ITPMediaTrackClip)((Iterator)localObject).next();
                l += localITPMediaTrackClip.getOriginalDurationMs();
                if (l > paramLong)
                {
                  dealClipWithInterval(paramXmlSerializer, localITPMediaTrackClip, l - paramLong);
                }
                else
                {
                  dealWithClipInfo(paramXmlSerializer, localITPMediaTrackClip);
                  continue;
                  localObject = ((ITPMediaTrack)localObject).getAllTrackClips().iterator();
                  while (((Iterator)localObject).hasNext()) {
                    dealWithClipInfo(paramXmlSerializer, (ITPMediaTrackClip)((Iterator)localObject).next());
                  }
                }
              }
              paramXmlSerializer.endTag("", str2);
            }
          }
          paramXmlSerializer.endTag("", str1);
          return;
        }
      }
      catch (IOException paramXmlSerializer)
      {
        TPLogUtil.e("TPMediaCompositionXmlGenerator", paramXmlSerializer);
      }
    }
  }
  
  private static String getTrackTagWithMediaType(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return "av_tracks";
      }
      return "av_track";
    }
    if (paramInt == 2)
    {
      if (paramBoolean) {
        return "video_tracks";
      }
      return "video_track";
    }
    if (paramInt == 3)
    {
      if (paramBoolean) {
        return "audio_tracks";
      }
      return "audio_track";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaCompositionXmlGenerator
 * JD-Core Version:    0.7.0.1
 */