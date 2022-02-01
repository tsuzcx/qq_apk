package com.tencent.qqlive.tvkplayer.vinfo.common;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.AudioTrackInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.SubTitle;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.HlsNode;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.ReferUrl;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoFormatInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoUrlInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TVKVideoInfoTransfer
{
  private static final String TAG = "VideoInfo[TVKVideoInfoTransfer.java]";
  
  private static void addAudioTrack2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      if (paramTVKCGIVideoInfo == null) {
        return;
      }
      int i = 0;
      while (i < paramTVKCGIVideoInfo.getAudioTrackInfos().size())
      {
        TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo localTVKCGIVideoAudioTrackInfo = (TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)paramTVKCGIVideoInfo.getAudioTrackInfos().get(i);
        TVKNetVideoInfo.AudioTrackInfo localAudioTrackInfo = new TVKNetVideoInfo.AudioTrackInfo();
        localAudioTrackInfo.setAudioShowName(localTVKCGIVideoAudioTrackInfo.getName());
        localAudioTrackInfo.setAudioTrack(localTVKCGIVideoAudioTrackInfo.getTrack());
        localAudioTrackInfo.setKeyId(localTVKCGIVideoAudioTrackInfo.getKeyid());
        localAudioTrackInfo.setAudioPrePlayTime(localTVKCGIVideoAudioTrackInfo.getPreview());
        localAudioTrackInfo.setAudioType(localTVKCGIVideoAudioTrackInfo.getAudio());
        int k = localTVKCGIVideoAudioTrackInfo.getLmt();
        int j = k;
        if (k != 0) {
          j = 1;
        }
        localAudioTrackInfo.setVip(j);
        localAudioTrackInfo.setAudioUrlList(localTVKCGIVideoAudioTrackInfo.getUrlList());
        localAudioTrackInfo.setAction(localTVKCGIVideoAudioTrackInfo.getAction());
        if (localTVKCGIVideoAudioTrackInfo.getSl() == 1) {
          paramTVKVideoInfo.setCurAudioTrack(localAudioTrackInfo);
        }
        paramTVKVideoInfo.addAudioTrack(localAudioTrackInfo);
        i += 1;
      }
    }
  }
  
  private static TVKVideoInfo addDefinition2VideoInfo(TVKVideoInfo paramTVKVideoInfo, TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    TVKNetVideoInfo.DefnInfo localDefnInfo = dealDef(paramDefnInfo);
    boolean bool = localDefnInfo.getDefn().equalsIgnoreCase("hd");
    Object localObject = null;
    int k = 0;
    int m = 1;
    paramDefnInfo = localObject;
    int i = k;
    int j = m;
    if (bool)
    {
      paramDefnInfo = localObject;
      i = k;
      j = m;
      if (paramTVKVideoInfo.getDefinitionList() != null)
      {
        Iterator localIterator = paramTVKVideoInfo.getDefinitionList().iterator();
        do
        {
          paramDefnInfo = localObject;
          i = k;
          j = m;
          if (!localIterator.hasNext()) {
            break;
          }
          paramDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
        } while (paramDefnInfo.getDefn().compareToIgnoreCase("hd") != 0);
        if (localDefnInfo.getDefnName().compareToIgnoreCase(TVKDefinitionUtils.getDefShowName("hd")) != 0)
        {
          i = 1;
          j = m;
        }
        else
        {
          j = 0;
          i = k;
          paramDefnInfo = localObject;
        }
      }
    }
    if ((paramTVKVideoInfo.getDefinitionList() != null) && (i != 0) && (paramDefnInfo != null))
    {
      TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "isNeedRemove");
      paramTVKVideoInfo.getDefinitionList().remove(paramDefnInfo);
    }
    if (j != 0) {
      paramTVKVideoInfo.addDefinition(localDefnInfo);
    }
    return paramTVKVideoInfo;
  }
  
  private static void addReferUrl2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      if (paramTVKCGIVideoInfo == null) {
        return;
      }
      int i = 0;
      while (i < paramTVKCGIVideoInfo.getUrlInfos().size())
      {
        TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)paramTVKCGIVideoInfo.getUrlInfos().get(i);
        TVKVideoInfo.ReferUrl localReferUrl = new TVKVideoInfo.ReferUrl();
        localReferUrl.setUrl(localTVKCGIVideoUrlInfo.getUrl());
        Object localObject = localTVKCGIVideoUrlInfo.getUrl();
        Pattern localPattern = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localObject = localPattern.matcher((CharSequence)localObject);
          if ((((Matcher)localObject).find()) && (((Matcher)localObject).group() != null)) {
            paramTVKVideoInfo.addVideoDownloadHostItem(Integer.valueOf(i), ((Matcher)localObject).group());
          }
        }
        localReferUrl.setVt(localTVKCGIVideoUrlInfo.getVt());
        localReferUrl.setPath(localTVKCGIVideoUrlInfo.getPath());
        localReferUrl.setSpip(localTVKCGIVideoUrlInfo.getSpip());
        localObject = new TVKVideoInfo.HlsNode();
        ((TVKVideoInfo.HlsNode)localObject).setHk(localTVKCGIVideoUrlInfo.getHk());
        ((TVKVideoInfo.HlsNode)localObject).setPt(localTVKCGIVideoUrlInfo.getPt());
        localReferUrl.setHlsNode((TVKVideoInfo.HlsNode)localObject);
        paramTVKVideoInfo.addReferUrlItem(i, localReferUrl);
        i += 1;
      }
    }
  }
  
  private static void addSectionItem2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      if (paramTVKCGIVideoInfo == null) {
        return;
      }
      int i = 0;
      while (i < paramTVKCGIVideoInfo.getMp4ClipInfos().size())
      {
        TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo localTVKCGIVideoMp4ClipInfo = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)paramTVKCGIVideoInfo.getMp4ClipInfos().get(i);
        TVKVideoInfo.Section localSection = new TVKVideoInfo.Section();
        localSection.setDuration(localTVKCGIVideoMp4ClipInfo.getDuration());
        localSection.setSize((int)localTVKCGIVideoMp4ClipInfo.getSize());
        localSection.setVbkeyId(localTVKCGIVideoMp4ClipInfo.getKeyid());
        localSection.setVbkey(localTVKCGIVideoMp4ClipInfo.getVkey());
        localSection.setIndexName(paramTVKCGIVideoInfo.getFn(), localTVKCGIVideoMp4ClipInfo.getIdx());
        localSection.setIdx(localTVKCGIVideoMp4ClipInfo.getIdx());
        paramTVKVideoInfo.addSectionItem(localSection);
        i += 1;
      }
    }
  }
  
  private static void addSubTitle2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      if (paramTVKCGIVideoInfo == null) {
        return;
      }
      int i = 0;
      while (i < paramTVKCGIVideoInfo.getSubtitleInfos().size())
      {
        TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo localTVKCGIVideoSubtitleInfo = (TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo)paramTVKCGIVideoInfo.getSubtitleInfos().get(i);
        TVKNetVideoInfo.SubTitle localSubTitle = new TVKNetVideoInfo.SubTitle();
        localSubTitle.setmName(localTVKCGIVideoSubtitleInfo.getName());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localTVKCGIVideoSubtitleInfo.getUrl());
        localSubTitle.setUrlList(localArrayList);
        localSubTitle.setmKeyId(localTVKCGIVideoSubtitleInfo.getKeyid());
        paramTVKVideoInfo.addSubTitle(localSubTitle);
        i += 1;
      }
    }
  }
  
  public static String[] compriseBackPlayUrl(TVKVideoInfo paramTVKVideoInfo, TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    int j = paramTVKVideoInfo.getUrlList().size();
    String[] arrayOfString = new String[j - 1];
    int i = 1;
    while (i < j)
    {
      boolean bool = paramTVKVideoInfo.isHLSDownloadType();
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        localObject2 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getUrl();
        if ((!TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) && (TVideoMgr.mFreeNetFlowRequestMap != null) && (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) != 1))
        {
          arrayOfString[(i - 1)] = localObject2;
          break label455;
        }
        localObject1 = localObject2;
        if (((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getPt());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject1 = Uri.parse((String)localObject1).buildUpon();
        localObject2 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"empty".equals(localObject2))) {
          ((Uri.Builder)localObject1).appendQueryParameter("hlskey", ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk());
        } else {
          ((Uri.Builder)localObject1).appendQueryParameter("hlskey", "");
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getUrl());
        ((StringBuilder)localObject2).append(paramTVKVideoInfo.getFileName());
        localObject2 = Uri.parse(((StringBuilder)localObject2).toString()).buildUpon();
        ((Uri.Builder)localObject2).appendQueryParameter("platform", String.valueOf(paramTVKVideoInfoParams.getPlatForm()));
        ((Uri.Builder)localObject2).appendQueryParameter("br", paramTVKVideoInfo.getBitrate());
        if (paramTVKVideoInfo.getCurDefinition() != null) {
          localObject1 = paramTVKVideoInfo.getCurDefinition().getDefn();
        }
        ((Uri.Builder)localObject2).appendQueryParameter("fmt", (String)localObject1);
        ((Uri.Builder)localObject2).appendQueryParameter("vkey", paramTVKVideoInfo.getVKey());
        ((Uri.Builder)localObject2).appendQueryParameter("level", paramTVKVideoInfo.getLevel());
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramTVKVideoInfo.getSha()))
        {
          ((Uri.Builder)localObject2).appendQueryParameter("sha", paramTVKVideoInfo.getSha());
          localObject1 = localObject2;
        }
      }
      ((Uri.Builder)localObject1).appendQueryParameter("sdtfrom", paramTVKVideoInfoParams.getSdtFrom());
      ((Uri.Builder)localObject1).appendQueryParameter("guid", TVideoMgr.getStaGuid());
      arrayOfString[(i - 1)] = ((Uri.Builder)localObject1).toString();
      label455:
      i += 1;
    }
    return arrayOfString;
  }
  
  private static void dealClipUrl(TVKVideoInfo paramTVKVideoInfo, TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    if (paramTVKVideoInfo != null)
    {
      int j = paramTVKVideoInfo.getSectionList().size();
      String[] arrayOfString = new String[j];
      int i = 0;
      while (i < j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramTVKVideoInfo.getFirstCdnServer());
        localStringBuilder.append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getIndexName());
        localStringBuilder.append("?&vkey=");
        localStringBuilder.append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkey());
        localStringBuilder.append("&platform=");
        localStringBuilder.append(paramTVKVideoInfoParams.getPlatForm());
        localStringBuilder.append("&fmt=");
        String str;
        if (paramTVKVideoInfo.getCurDefinition() == null) {
          str = "";
        } else {
          str = paramTVKVideoInfo.getCurDefinition().getDefn();
        }
        localStringBuilder.append(str);
        localStringBuilder.append("&br=");
        localStringBuilder.append(String.valueOf(paramTVKVideoInfo.getBitrate()));
        localStringBuilder.append("&sdtfrom=");
        localStringBuilder.append(paramTVKVideoInfoParams.getSdtFrom());
        localStringBuilder.append("&guid=");
        localStringBuilder.append(TVideoMgr.getStaGuid());
        localStringBuilder.append("&keyid=");
        localStringBuilder.append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkeyId());
        arrayOfString[i] = localStringBuilder.toString();
        i += 1;
      }
      paramTVKVideoInfo.setClipUrl(arrayOfString);
    }
  }
  
  private static TVKNetVideoInfo.DefnInfo dealDef(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    if (paramDefnInfo == null) {
      return null;
    }
    if (paramDefnInfo.getDefn().equalsIgnoreCase("mp4"))
    {
      paramDefnInfo.setDefn("hd");
      paramDefnInfo.setDefnName(TVKDefinitionUtils.getDefShowName("hd"));
    }
    if (TextUtils.isEmpty(paramDefnInfo.getDefnName())) {
      paramDefnInfo.setDefnName(TVKDefinitionUtils.getDefShowName(paramDefnInfo.getDefn()));
    }
    return paramDefnInfo;
  }
  
  private static void setPrePlayTime2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      if (paramTVKCGIVideoInfo == null) {
        return;
      }
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview.getValue()).booleanValue())
      {
        if ((paramTVKVideoInfo.getExem() <= 0) && (paramTVKVideoInfo.getSt() != 8))
        {
          if (paramTVKVideoInfo.getSt() == 2)
          {
            paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
            return;
          }
          paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
          return;
        }
        paramTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
        return;
      }
      if (paramTVKVideoInfo.getSt() == 2)
      {
        paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
        return;
      }
      if ((paramTVKVideoInfo.getSt() != 8) && (paramTVKVideoInfo.getExem() <= 0))
      {
        paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
        return;
      }
      paramTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
    }
  }
  
  public static TVKVideoInfo transfer(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    TVKVideoInfo localTVKVideoInfo = new TVKVideoInfo();
    if (paramTVKCGIVideoInfo == null) {
      return localTVKVideoInfo;
    }
    localTVKVideoInfo.setXml(paramTVKCGIVideoInfo.getVinfoXml());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getvinfo=");
    ((StringBuilder)localObject1).append(paramTVKCGIVideoInfo.getVinfoXml());
    TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", ((StringBuilder)localObject1).toString());
    localTVKVideoInfo.setTestId(paramTVKCGIVideoInfo.getTstid());
    localTVKVideoInfo.setFp2p(paramTVKCGIVideoInfo.getFp2p());
    addAudioTrack2VideoInfo(paramTVKCGIVideoInfo, localTVKVideoInfo);
    int k = 0;
    int i = 0;
    Object localObject2;
    while (i < paramTVKCGIVideoInfo.getFormatInfos().size())
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoFormatInfo)paramTVKCGIVideoInfo.getFormatInfos().get(i);
      localObject2 = new TVKNetVideoInfo.DefnInfo();
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDefn(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getName());
      int m = ((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getLmt();
      int j = m;
      if (m != 0) {
        j = 1;
      }
      ((TVKNetVideoInfo.DefnInfo)localObject2).setVip(j);
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnId(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getId());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setFileSize(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getFs());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setAudioCodec(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getAudio());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setVideoCodec(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getVideo());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDrm(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getDrm());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setHdr10EnHance(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getHdr10enh());
      String str2 = ((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getCname();
      if (!TextUtils.isEmpty(str2)) {
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnShowName(TVKUtils.convertDefnName(str2));
      } else {
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnShowName(TVKDefinitionUtils.getDefShowName(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getName()));
      }
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnRate(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getResolution());
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnName(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getSname());
      if (((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getSl() == 1) {
        localTVKVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject2);
      }
      localTVKVideoInfo = addDefinition2VideoInfo(localTVKVideoInfo, (TVKNetVideoInfo.DefnInfo)localObject2);
      i += 1;
    }
    addSubTitle2VideoInfo(paramTVKCGIVideoInfo, localTVKVideoInfo);
    localTVKVideoInfo.setDownloadType(paramTVKCGIVideoInfo.getDltype());
    localTVKVideoInfo.setSectionNum(paramTVKCGIVideoInfo.getFc());
    if (paramTVKCGIVideoInfo.getFc() > 0) {
      localTVKVideoInfo.setDownloadType(4);
    }
    i = 0;
    while (i < paramTVKCGIVideoInfo.getMp4ClipInfos().size())
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)paramTVKCGIVideoInfo.getMp4ClipInfos().get(i);
      localObject2 = new TVKVideoInfo.Section();
      ((TVKVideoInfo.Section)localObject2).setUrl(((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getUrl());
      ((TVKVideoInfo.Section)localObject2).setDuration(((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getDuration());
      ((TVKVideoInfo.Section)localObject2).setSize((int)((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getSize());
      ((TVKVideoInfo.Section)localObject2).setVbkeyId(((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getKeyid());
      ((TVKVideoInfo.Section)localObject2).setVbkey(((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getVkey());
      ((TVKVideoInfo.Section)localObject2).setIndexName(paramTVKCGIVideoInfo.getFn(), ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getIdx());
      ((TVKVideoInfo.Section)localObject2).setIdx(((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject1).getIdx());
      localTVKVideoInfo.addSectionItem((TVKVideoInfo.Section)localObject2);
      i += 1;
    }
    localTVKVideoInfo.setDanmuState(paramTVKCGIVideoInfo.getDm());
    localTVKVideoInfo.setPayCh(paramTVKCGIVideoInfo.getCh());
    localTVKVideoInfo.setSt(paramTVKCGIVideoInfo.getSt());
    localTVKVideoInfo.setDuration((int)paramTVKCGIVideoInfo.getTd());
    localTVKVideoInfo.setFileSize(paramTVKCGIVideoInfo.getFs());
    localTVKVideoInfo.setTitle(paramTVKCGIVideoInfo.getTi());
    localTVKVideoInfo.setTargetId(String.valueOf(paramTVKCGIVideoInfo.getTargetid()));
    localTVKVideoInfo.setCkc(paramTVKCGIVideoInfo.getCkc());
    localTVKVideoInfo.setPLType(2);
    localTVKVideoInfo.setPLString(paramTVKCGIVideoInfo.getPlInfoXml());
    localTVKVideoInfo.setLnk(paramTVKCGIVideoInfo.getLnk());
    localTVKVideoInfo.setDrm(paramTVKCGIVideoInfo.getDrm());
    localTVKVideoInfo.setEnc(paramTVKCGIVideoInfo.getEnc());
    if (paramTVKCGIVideoInfo.getHevc() == 0) {
      localTVKVideoInfo.setIsHevc(false);
    } else {
      localTVKVideoInfo.setIsHevc(true);
    }
    localTVKVideoInfo.setFileName(paramTVKCGIVideoInfo.getFn());
    localTVKVideoInfo.setIFlag(paramTVKCGIVideoInfo.getIflag());
    localTVKVideoInfo.setEncryptionVideo(TextUtils.isEmpty(paramTVKCGIVideoInfo.getBase()) ^ true);
    localTVKVideoInfo.setWidth(paramTVKCGIVideoInfo.getVw());
    localTVKVideoInfo.setHeight(paramTVKCGIVideoInfo.getVh());
    localTVKVideoInfo.setVid(paramTVKCGIVideoInfo.getVid());
    localTVKVideoInfo.setMediaVideoState(paramTVKCGIVideoInfo.getMst());
    localTVKVideoInfo.setWHRadio(paramTVKCGIVideoInfo.getWh());
    localTVKVideoInfo.setMediaVideoType(paramTVKCGIVideoInfo.getVr());
    localTVKVideoInfo.setStartPos(paramTVKCGIVideoInfo.getHead());
    localTVKVideoInfo.setEndPos(paramTVKCGIVideoInfo.getTail());
    localTVKVideoInfo.setVideoType(paramTVKCGIVideoInfo.getVideotype());
    localTVKVideoInfo.setVst(paramTVKCGIVideoInfo.getVst());
    localTVKVideoInfo.setTie(paramTVKCGIVideoInfo.getTie());
    localTVKVideoInfo.setAdsid(paramTVKCGIVideoInfo.getAdsid());
    addReferUrl2VideoInfo(paramTVKCGIVideoInfo, localTVKVideoInfo);
    localTVKVideoInfo.setActionUrl(paramTVKCGIVideoInfo.getAction());
    localTVKVideoInfo.setExem(paramTVKCGIVideoInfo.getExem());
    setPrePlayTime2VideoInfo(paramTVKCGIVideoInfo, localTVKVideoInfo);
    localTVKVideoInfo.setWanIP(paramTVKCGIVideoInfo.getIp());
    localTVKVideoInfo.setVKey(paramTVKCGIVideoInfo.getFvkey());
    localTVKVideoInfo.setBitrate(String.valueOf(paramTVKCGIVideoInfo.getBr()));
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramTVKCGIVideoInfo.getActualFormat())) && (localTVKVideoInfo.getCurDefinition() != null) && (!TextUtils.isEmpty(localTVKVideoInfo.getCurDefinition().getDefn())) && (!paramTVKCGIVideoInfo.getActualFormat().equalsIgnoreCase(localTVKVideoInfo.getCurDefinition().getDefn())))
        {
          i = k;
          if (i < localTVKVideoInfo.getDefinitionList().size())
          {
            localObject1 = (TVKNetVideoInfo.DefnInfo)localTVKVideoInfo.getDefinitionList().get(i);
            if (!((TVKNetVideoInfo.DefnInfo)localObject1).getDefn().equalsIgnoreCase(paramTVKCGIVideoInfo.getActualFormat())) {
              break label1034;
            }
            localTVKVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject1);
          }
        }
        localTVKVideoInfo.setLocalVideo(paramTVKCGIVideoInfo.isLocalVideo());
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onPlayInfoSuccess catch error ==");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", ((StringBuilder)localObject2).toString());
      }
      String str1 = paramTVKCGIVideoInfo.getUrl();
      localObject2 = compriseBackPlayUrl(localTVKVideoInfo, paramTVKVideoInfoParams);
      localTVKVideoInfo.setPlayUrl(str1);
      localTVKVideoInfo.setBackPlayUrl((String[])localObject2);
      if (paramTVKCGIVideoInfo.getUrl().contains("<?xml")) {
        dealClipUrl(localTVKVideoInfo, paramTVKVideoInfoParams);
      }
      localTVKVideoInfo.setCGIVideoInfo(paramTVKCGIVideoInfo);
      localTVKVideoInfo.setWatermarkInfos(paramTVKCGIVideoInfo.getWatermarkInfos());
      return localTVKVideoInfo;
      label1034:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoTransfer
 * JD-Core Version:    0.7.0.1
 */