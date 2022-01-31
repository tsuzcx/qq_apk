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
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoUrlInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TVKVideoInfoTransfer
{
  private static final String TAG = "VideoInfo[TVKVideoInfoTransfer.java]";
  
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
  
  public static String[] compriseBackPlayUrl(TVKVideoInfo paramTVKVideoInfo)
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
            break label403;
          }
          localObject1 = (String)localObject1 + ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getPt();
        }
      }
    }
    label403:
    for (;;)
    {
      localObject1 = Uri.parse((String)localObject1).buildUpon();
      Object localObject2 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"empty".equals(localObject2))) {
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getHlsNode().getHk());
      }
      for (;;)
      {
        ((Uri.Builder)localObject1).appendQueryParameter("sdtfrom", TVideoMgr.getVinfoSdtfrom());
        ((Uri.Builder)localObject1).appendQueryParameter("guid", TVideoMgr.getStaGuid());
        arrayOfString[(i - 1)] = ((Uri.Builder)localObject1).toString();
        break;
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", "");
      }
      localObject2 = Uri.parse(((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(i)).getUrl() + paramTVKVideoInfo.getFileName()).buildUpon();
      ((Uri.Builder)localObject2).appendQueryParameter("platform", String.valueOf(TVideoMgr.getVinfoPlatform()));
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
  
  public static String comprisePlayUrl(TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo.isHLSDownloadType())
    {
      if ((!TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) && (TVideoMgr.mFreeNetFlowRequestMap != null) && (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) != 1))
      {
        if (paramTVKVideoInfo.getUrlList().size() > 0) {
          return ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(0)).getUrl();
        }
        return null;
      }
      localObject1 = Uri.parse(paramTVKVideoInfo.getFirstCdnHlsPlayUrl()).buildUpon();
      localObject2 = ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(0)).getHlsNode().getHk();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"empty".equals(localObject2))) {
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", ((TVKVideoInfo.ReferUrl)paramTVKVideoInfo.getUrlList().get(0)).getHlsNode().getHk());
      }
      for (;;)
      {
        paramTVKVideoInfo = (TVKVideoInfo)localObject1;
        paramTVKVideoInfo.appendQueryParameter("sdtfrom", TVideoMgr.getVinfoSdtfrom());
        paramTVKVideoInfo.appendQueryParameter("guid", TVideoMgr.getStaGuid());
        return paramTVKVideoInfo.toString();
        ((Uri.Builder)localObject1).appendQueryParameter("hlskey", "");
      }
    }
    Object localObject2 = Uri.parse(paramTVKVideoInfo.getFirstCdnServer() + paramTVKVideoInfo.getFileName()).buildUpon();
    ((Uri.Builder)localObject2).appendQueryParameter("platform", String.valueOf(TVideoMgr.getVinfoPlatform()));
    ((Uri.Builder)localObject2).appendQueryParameter("br", paramTVKVideoInfo.getBitrate());
    if (paramTVKVideoInfo.getCurDefinition() == null) {}
    for (Object localObject1 = "";; localObject1 = paramTVKVideoInfo.getCurDefinition().getDefn())
    {
      ((Uri.Builder)localObject2).appendQueryParameter("fmt", (String)localObject1);
      ((Uri.Builder)localObject2).appendQueryParameter("vkey", paramTVKVideoInfo.getVKey());
      ((Uri.Builder)localObject2).appendQueryParameter("level", paramTVKVideoInfo.getLevel());
      if (!TextUtils.isEmpty(paramTVKVideoInfo.getSha())) {
        ((Uri.Builder)localObject2).appendQueryParameter("sha", paramTVKVideoInfo.getSha());
      }
      paramTVKVideoInfo = (TVKVideoInfo)localObject2;
      break;
    }
  }
  
  private static void dealClipUrl(TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo != null)
    {
      int j = paramTVKVideoInfo.getSectionList().size();
      String[] arrayOfString = new String[j];
      int i = 0;
      if (i < j)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramTVKVideoInfo.getFirstCdnServer()).append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getIndexName()).append("?&vkey=").append(((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkey()).append("&platform=").append(TVideoMgr.getVinfoPlatform()).append("&fmt=");
        if (paramTVKVideoInfo.getCurDefinition() == null) {}
        for (String str = "";; str = paramTVKVideoInfo.getCurDefinition().getDefn())
        {
          arrayOfString[i] = (str + "&br=" + String.valueOf(paramTVKVideoInfo.getBitrate()) + "&sdtfrom=" + TVideoMgr.getVinfoSdtfrom() + "&guid=" + TVideoMgr.getStaGuid() + "&keyid=" + ((TVKVideoInfo.Section)paramTVKVideoInfo.getSectionList().get(i)).getVbkeyId());
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
  
  public static TVKVideoInfo transfer(TVKCGIVideoInfo paramTVKCGIVideoInfo)
  {
    int k = 0;
    TVKVideoInfo localTVKVideoInfo = new TVKVideoInfo();
    if (paramTVKCGIVideoInfo == null) {
      return localTVKVideoInfo;
    }
    localTVKVideoInfo.setXml(paramTVKCGIVideoInfo.getVinfoXml());
    TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "getvinfo=" + paramTVKCGIVideoInfo.getVinfoXml());
    localTVKVideoInfo.setTestId(paramTVKCGIVideoInfo.getTstid());
    localTVKVideoInfo.setFp2p(paramTVKCGIVideoInfo.getFp2p());
    int i = 0;
    Object localObject1;
    Object localObject2;
    int m;
    int j;
    while (i < paramTVKCGIVideoInfo.getAudioTrackInfos().size())
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)paramTVKCGIVideoInfo.getAudioTrackInfos().get(i);
      localObject2 = new TVKNetVideoInfo.AudioTrackInfo();
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAudioShowName(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getName());
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAudioTrack(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getTrack());
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setKeyId(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getKeyid());
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAudioPrePlayTime(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getPreview());
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAudioType(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getAudio());
      m = ((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getLmt();
      j = m;
      if (m != 0) {
        j = 1;
      }
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setVip(j);
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAudioUrlList(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getUrlList());
      ((TVKNetVideoInfo.AudioTrackInfo)localObject2).setAction(((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getAction());
      if (((TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo)localObject1).getSl() == 1) {
        localTVKVideoInfo.setCurAudioTrack((TVKNetVideoInfo.AudioTrackInfo)localObject2);
      }
      localTVKVideoInfo.addAudioTrack((TVKNetVideoInfo.AudioTrackInfo)localObject2);
      i += 1;
    }
    i = 0;
    Object localObject3;
    if (i < paramTVKCGIVideoInfo.getFormatInfos().size())
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoFormatInfo)paramTVKCGIVideoInfo.getFormatInfos().get(i);
      localObject2 = new TVKNetVideoInfo.DefnInfo();
      ((TVKNetVideoInfo.DefnInfo)localObject2).setDefn(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getName());
      m = ((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getLmt();
      j = m;
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
      localObject3 = ((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getCname();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnName(TVKUtils.convertDefnName((String)localObject3));
      }
      for (;;)
      {
        if (((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getSl() == 1) {
          localTVKVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject2);
        }
        localTVKVideoInfo = addDefinition2VideoInfo(localTVKVideoInfo, (TVKNetVideoInfo.DefnInfo)localObject2);
        i += 1;
        break;
        ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnName(TVKDefinitionUtils.getDefShowName(((TVKCGIVideoInfo.TVKCGIVideoFormatInfo)localObject1).getName()));
      }
    }
    i = 0;
    while (i < paramTVKCGIVideoInfo.getSubtitleInfos().size())
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo)paramTVKCGIVideoInfo.getSubtitleInfos().get(i);
      localObject2 = new TVKNetVideoInfo.SubTitle();
      ((TVKNetVideoInfo.SubTitle)localObject2).setmName(((TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo)localObject1).getName());
      localObject3 = new ArrayList();
      ((List)localObject3).add(((TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo)localObject1).getUrl());
      ((TVKNetVideoInfo.SubTitle)localObject2).setUrlList((List)localObject3);
      ((TVKNetVideoInfo.SubTitle)localObject2).setmKeyId(((TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo)localObject1).getKeyid());
      localTVKVideoInfo.addSubTitle((TVKNetVideoInfo.SubTitle)localObject2);
      i += 1;
    }
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
        break label1155;
      }
    }
    label1155:
    for (boolean bool = true;; bool = false)
    {
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
      i = 0;
      while (i < paramTVKCGIVideoInfo.getUrlInfos().size())
      {
        localObject1 = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)paramTVKCGIVideoInfo.getUrlInfos().get(i);
        localObject2 = new TVKVideoInfo.ReferUrl();
        ((TVKVideoInfo.ReferUrl)localObject2).setUrl(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl());
        localObject3 = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl();
        Pattern localPattern = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject3 = localPattern.matcher((CharSequence)localObject3);
          if ((((Matcher)localObject3).find()) && (((Matcher)localObject3).group() != null)) {
            localTVKVideoInfo.addVideoDownloadHostItem(Integer.valueOf(i), ((Matcher)localObject3).group());
          }
        }
        ((TVKVideoInfo.ReferUrl)localObject2).setVt(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getVt());
        ((TVKVideoInfo.ReferUrl)localObject2).setPath(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getPath());
        ((TVKVideoInfo.ReferUrl)localObject2).setSpip(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getSpip());
        localObject3 = new TVKVideoInfo.HlsNode();
        ((TVKVideoInfo.HlsNode)localObject3).setHk(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getHk());
        ((TVKVideoInfo.HlsNode)localObject3).setPt(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getPt());
        ((TVKVideoInfo.ReferUrl)localObject2).setHlsNode((TVKVideoInfo.HlsNode)localObject3);
        localTVKVideoInfo.addReferUrlItem(i, (TVKVideoInfo.ReferUrl)localObject2);
        i += 1;
      }
      localTVKVideoInfo.setIsHevc(true);
      break;
    }
    localTVKVideoInfo.setActionUrl(paramTVKCGIVideoInfo.getAction());
    localTVKVideoInfo.setExem(paramTVKCGIVideoInfo.getExem());
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview.getValue()).booleanValue()) {
      if ((localTVKVideoInfo.getExem() > 0) || (localTVKVideoInfo.getSt() == 8))
      {
        localTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
        if (paramTVKCGIVideoInfo.getTvLogoInfos().size() > 0)
        {
          localTVKVideoInfo.setLogHeight(((TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo)paramTVKCGIVideoInfo.getTvLogoInfos().get(0)).getTvLogoH());
          localTVKVideoInfo.setLogWidth(((TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo)paramTVKCGIVideoInfo.getTvLogoInfos().get(0)).getTvLogoW());
          localTVKVideoInfo.setLogX(((TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo)paramTVKCGIVideoInfo.getTvLogoInfos().get(0)).getTvLogoX());
          localTVKVideoInfo.setLogY(((TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo)paramTVKCGIVideoInfo.getTvLogoInfos().get(0)).getTvLogoY());
          if (((TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo)paramTVKCGIVideoInfo.getTvLogoInfos().get(0)).getTvLogoShow() != 0) {
            break label1629;
          }
          localTVKVideoInfo.setmIsLogShow(false);
        }
        label1331:
        localTVKVideoInfo.setWanIP(paramTVKCGIVideoInfo.getIp());
        localTVKVideoInfo.setVKey(paramTVKCGIVideoInfo.getFvkey());
        localTVKVideoInfo.setBitrate(String.valueOf(paramTVKCGIVideoInfo.getBr()));
      }
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
        label1629:
        TVKLogUtil.i("VideoInfo[TVKVideoInfoTransfer.java]", "onPlayInfoSuccess catch error ==" + localThrowable.getMessage());
        continue;
      }
      localObject1 = paramTVKCGIVideoInfo.getUrl();
      localObject2 = compriseBackPlayUrl(localTVKVideoInfo);
      localTVKVideoInfo.setPlayUrl((String)localObject1);
      localTVKVideoInfo.setBackPlayUrl((String[])localObject2);
      if (paramTVKCGIVideoInfo.getUrl().contains("<?xml")) {
        dealClipUrl(localTVKVideoInfo);
      }
      localTVKVideoInfo.setCGIVideoInfo(paramTVKCGIVideoInfo);
      return localTVKVideoInfo;
      if (localTVKVideoInfo.getSt() == 2)
      {
        localTVKVideoInfo.setPrePlayTime(localTVKVideoInfo.getDuration());
        break;
      }
      localTVKVideoInfo.setPrePlayTime(localTVKVideoInfo.getDuration());
      break;
      if (localTVKVideoInfo.getSt() == 2)
      {
        localTVKVideoInfo.setPrePlayTime(localTVKVideoInfo.getDuration());
        break;
      }
      if ((localTVKVideoInfo.getSt() == 8) || (localTVKVideoInfo.getExem() > 0))
      {
        localTVKVideoInfo.setPrePlayTime(paramTVKCGIVideoInfo.getPreview());
        break;
      }
      localTVKVideoInfo.setPrePlayTime(localTVKVideoInfo.getDuration());
      break;
      localTVKVideoInfo.setmIsLogShow(true);
      break label1331;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoTransfer
 * JD-Core Version:    0.7.0.1
 */