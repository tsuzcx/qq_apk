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
    if ((paramTVKVideoInfo == null) || (paramTVKCGIVideoInfo == null)) {}
    for (;;)
    {
      return;
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
    int j = 1;
    TVKNetVideoInfo.DefnInfo localDefnInfo = dealDef(paramDefnInfo);
    int i;
    if ((localDefnInfo.getDefn().equalsIgnoreCase("hd")) && (paramTVKVideoInfo.getDefinitionList() != null))
    {
      Iterator localIterator = paramTVKVideoInfo.getDefinitionList().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
          if (paramDefnInfo.getDefn().compareToIgnoreCase("hd") == 0) {
            if (localDefnInfo.getDefnName().compareToIgnoreCase(TVKDefinitionUtils.getDefShowName("hd")) != 0) {
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramTVKVideoInfo.getDefinitionList() != null) && (i != 0) && (paramDefnInfo != null))
      {
        TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "isNeedRemove");
        paramTVKVideoInfo.getDefinitionList().remove(paramDefnInfo);
      }
      if (j != 0) {
        paramTVKVideoInfo.addDefinition(localDefnInfo);
      }
      return paramTVKVideoInfo;
      paramDefnInfo = null;
      j = 0;
      i = 0;
      continue;
      paramDefnInfo = null;
      i = 0;
    }
  }
  
  private static void addReferUrl2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if ((paramTVKVideoInfo == null) || (paramTVKCGIVideoInfo == null)) {}
    for (;;)
    {
      return;
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
    if ((paramTVKVideoInfo == null) || (paramTVKCGIVideoInfo == null)) {}
    for (;;)
    {
      return;
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
    if ((paramTVKVideoInfo == null) || (paramTVKCGIVideoInfo == null)) {}
    for (;;)
    {
      return;
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
    Object localObject1;
    for (;;)
    {
      if (i < j) {
        if (paramTVKVideoInfo.isHLSDownloadType())
        {
          localObject1 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getUrl();
          if ((!TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) && (TVideoMgr.mFreeNetFlowRequestMap != null) && (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) != 1))
          {
            arrayOfString[(i - 1)] = localObject1;
            i += 1;
            continue;
          }
          if (((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode() == null) {
            break label433;
          }
          localObject1 = (String)localObject1 + ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getPt();
        }
      }
    }
    label433:
    for (;;)
    {
      localObject1 = Uri.parse((String)localObject1).buildUpon();
      Object localObject2 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"empty".equals(localObject2))) {
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk());
      }
      for (;;)
      {
        ((Uri.Builder)localObject1).appendQueryParameter("sdtfrom", paramTVKVideoInfoParams.getSdtFrom());
        ((Uri.Builder)localObject1).appendQueryParameter("guid", TVideoMgr.getStaGuid());
        arrayOfString[(i - 1)] = ((Uri.Builder)localObject1).toString();
        break;
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", "");
      }
      localObject2 = Uri.parse(((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getUrl() + paramTVKVideoInfo.getFileName()).buildUpon();
      ((Uri.Builder)localObject2).appendQueryParameter("platform", String.valueOf(paramTVKVideoInfoParams.getPlatForm()));
      ((Uri.Builder)localObject2).appendQueryParameter("br", paramTVKVideoInfo.getBitrate());
      if (paramTVKVideoInfo.getCurDefinition() == null) {}
      for (localObject1 = "";; localObject1 = paramTVKVideoInfo.getCurDefinition().getDefn())
      {
        ((Uri.Builder)localObject2).appendQueryParameter("fmt", (String)localObject1);
        ((Uri.Builder)localObject2).appendQueryParameter("vkey", paramTVKVideoInfo.getVKey());
        ((Uri.Builder)localObject2).appendQueryParameter("level", paramTVKVideoInfo.getLevel());
        if (!TextUtils.isEmpty(paramTVKVideoInfo.getSha())) {
          ((Uri.Builder)localObject2).appendQueryParameter("sha", paramTVKVideoInfo.getSha());
        }
        localObject1 = localObject2;
        break;
      }
      return arrayOfString;
    }
  }
  
  private static void dealClipUrl(TVKVideoInfo paramTVKVideoInfo, TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    if (paramTVKVideoInfo != null)
    {
      int j = paramTVKVideoInfo.getSectionList().size();
      String[] arrayOfString = new String[j];
      int i = 0;
      if (i < j)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramTVKVideoInfo.getFirstCdnServer()).append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getIndexName()).append("?&vkey=").append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkey()).append("&platform=").append(paramTVKVideoInfoParams.getPlatForm()).append("&fmt=");
        if (paramTVKVideoInfo.getCurDefinition() == null) {}
        for (String str = "";; str = paramTVKVideoInfo.getCurDefinition().getDefn())
        {
          arrayOfString[i] = (str + "&br=" + String.valueOf(paramTVKVideoInfo.getBitrate()) + "&sdtfrom=" + paramTVKVideoInfoParams.getSdtFrom() + "&guid=" + TVideoMgr.getStaGuid() + "&keyid=" + ((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkeyId());
          i += 1;
          break;
        }
      }
      paramTVKVideoInfo.setClipUrl(arrayOfString);
    }
  }
  
  private static TVKNetVideoInfo.DefnInfo dealDef(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    TVKNetVideoInfo.DefnInfo localDefnInfo;
    if (paramDefnInfo == null) {
      localDefnInfo = null;
    }
    do
    {
      return localDefnInfo;
      if (paramDefnInfo.getDefn().equalsIgnoreCase("mp4"))
      {
        paramDefnInfo.setDefn("hd");
        paramDefnInfo.setDefnName(TVKDefinitionUtils.getDefShowName("hd"));
      }
      localDefnInfo = paramDefnInfo;
    } while (!TextUtils.isEmpty(paramDefnInfo.getDefnName()));
    paramDefnInfo.setDefnName(TVKDefinitionUtils.getDefShowName(paramDefnInfo.getDefn()));
    return paramDefnInfo;
  }
  
  private static void setPrePlayTime2VideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    if ((paramTVKVideoInfo == null) || (paramTVKCGIVideoInfo == null)) {
      return;
    }
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview.getValue()).booleanValue())
    {
      if ((paramTVKVideoInfo.getExem() > 0) || (paramTVKVideoInfo.getSt() == 8))
      {
        paramTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
        return;
      }
      if (paramTVKVideoInfo.getSt() == 2)
      {
        paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
        return;
      }
      paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
      return;
    }
    if (paramTVKVideoInfo.getSt() == 2)
    {
      paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
      return;
    }
    if ((paramTVKVideoInfo.getSt() == 8) || (paramTVKVideoInfo.getExem() > 0))
    {
      paramTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
      return;
    }
    paramTVKVideoInfo.setPrePlayTime(paramTVKVideoInfo.getDuration());
  }
  
  public static TVKVideoInfo transfer(TVKCGIVideoInfo paramTVKCGIVideoInfo, TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    boolean bool = true;
    int k = 0;
    TVKVideoInfo localTVKVideoInfo = new TVKVideoInfo();
    if (paramTVKCGIVideoInfo == null) {
      return localTVKVideoInfo;
    }
    localTVKVideoInfo.setXml(paramTVKCGIVideoInfo.getVinfoXml());
    TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "getvinfo=" + paramTVKCGIVideoInfo.getVinfoXml());
    localTVKVideoInfo.setTestId(paramTVKCGIVideoInfo.getTstid());
    localTVKVideoInfo.setFp2p(paramTVKCGIVideoInfo.getFp2p());
    addAudioTrack2VideoInfo(paramTVKCGIVideoInfo, localTVKVideoInfo);
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramTVKCGIVideoInfo.getFormatInfos().size())
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
      String str = ((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getCname();
      if (!TextUtils.isEmpty(str)) {
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnShowName(TVKUtils.convertDefnName(str));
      }
      for (;;)
      {
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnRate(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getResolution());
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnName(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getSname());
        if (((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getSl() == 1) {
          localTVKVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject2);
        }
        localTVKVideoInfo = addDefinition2VideoInfo(localTVKVideoInfo, (TVKNetVideoInfo.DefnInfo)localObject2);
        i += 1;
        break;
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnShowName(TVKDefinitionUtils.getDefShowName(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getName()));
      }
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
    if (paramTVKCGIVideoInfo.getHevc() == 0)
    {
      localTVKVideoInfo.setIsHevc(false);
      localTVKVideoInfo.setFileName(paramTVKCGIVideoInfo.getFn());
      localTVKVideoInfo.setIFlag(paramTVKCGIVideoInfo.getIflag());
      if (TextUtils.isEmpty(paramTVKCGIVideoInfo.getBase())) {
        break label983;
      }
      label624:
      localTVKVideoInfo.setEncryptionVideo(bool);
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
    }
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
              continue;
            }
            localTVKVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject1);
          }
        }
        localTVKVideoInfo.setLocalVideo(paramTVKCGIVideoInfo.isLocalVideo());
      }
      catch (Throwable localThrowable)
      {
        label983:
        TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "onPlayInfoSuccess catch error ==" + localThrowable.getMessage());
        continue;
      }
      localObject1 = paramTVKCGIVideoInfo.getUrl();
      localObject2 = compriseBackPlayUrl(localTVKVideoInfo, paramTVKVideoInfoParams);
      localTVKVideoInfo.setPlayUrl((String)localObject1);
      localTVKVideoInfo.setBackPlayUrl((String[])localObject2);
      if (paramTVKCGIVideoInfo.getUrl().contains("<?xml")) {
        dealClipUrl(localTVKVideoInfo, paramTVKVideoInfoParams);
      }
      localTVKVideoInfo.setCGIVideoInfo(paramTVKCGIVideoInfo);
      localTVKVideoInfo.setWatermarkInfos(paramTVKCGIVideoInfo.getWatermarkInfos());
      return localTVKVideoInfo;
      localTVKVideoInfo.setIsHevc(true);
      break;
      bool = false;
      break label624;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoTransfer
 * JD-Core Version:    0.7.0.1
 */