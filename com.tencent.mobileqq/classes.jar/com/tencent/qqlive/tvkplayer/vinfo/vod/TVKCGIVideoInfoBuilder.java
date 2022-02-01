package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TVKCGIVideoInfoBuilder
{
  private int br;
  private int clipCount = 0;
  private int dltype;
  private int em = -1;
  private int exem = -1;
  private String fn;
  private String format;
  private int formatId;
  private String fvkey;
  private String linkvid;
  private ArrayList<TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo> mVkeyInfos = new ArrayList();
  private int st;
  private String url;
  private ArrayList<String> urlList = new ArrayList();
  private String vid;
  private TVKCGIVideoInfo videoInfo = new TVKCGIVideoInfo();
  private TVKVideoInfoParams videoInfoParams;
  private Map<String, Class> vinfoFormatNodeNameMap = new HashMap();
  private Map<String, TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction> vinfoViActionMap = new HashMap();
  private String vinfoXml;
  
  public TVKCGIVideoInfoBuilder()
  {
    initVinfoViActionMap();
    initVinfoFormatNodeNameMap();
  }
  
  private void buildClipMp4CdnUrl(String paramString)
  {
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    ((StringBuffer)localObject2).append("<CLIPMP4><VERSION>2</VERSION><CLIPSINFO>");
    Object localObject3 = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getUrl();
    Object localObject4 = this.videoInfo.getMp4ClipInfos().iterator();
    Object localObject1;
    while (((Iterator)localObject4).hasNext())
    {
      TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo localTVKCGIVideoMp4ClipInfo = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)((Iterator)localObject4).next();
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(generateClipMp4Filename(this.fn, localTVKCGIVideoMp4ClipInfo.getIdx()));
        localObject1 = generateMp4url(((StringBuilder)localObject1).toString(), localTVKCGIVideoMp4ClipInfo.getVkey(), localTVKCGIVideoMp4ClipInfo.getKeyid());
      }
      else
      {
        localObject1 = localTVKCGIVideoMp4ClipInfo.getUrl();
      }
      ((StringBuffer)localObject2).append("<CLIPINFO>");
      ((StringBuffer)localObject2).append("<DURATION>");
      ((StringBuffer)localObject2).append(localTVKCGIVideoMp4ClipInfo.getDuration() * 1000.0D * 1000.0D);
      ((StringBuffer)localObject2).append("</DURATION>");
      ((StringBuffer)localObject2).append("<CLIPSIZE>");
      ((StringBuffer)localObject2).append(localTVKCGIVideoMp4ClipInfo.getSize());
      ((StringBuffer)localObject2).append("</CLIPSIZE>");
      ((StringBuffer)localObject2).append("<URL>");
      ((StringBuffer)localObject2).append(((String)localObject1).replaceAll("&", "&amp;"));
      ((StringBuffer)localObject2).append("</URL>");
      ((StringBuffer)localObject2).append("<URLPARAM>");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clipid=");
      ((StringBuilder)localObject1).append(localTVKCGIVideoMp4ClipInfo.getIdx());
      ((StringBuffer)localObject2).append(((StringBuilder)localObject1).toString());
      ((StringBuffer)localObject2).append("</URLPARAM>");
      ((StringBuffer)localObject2).append("</CLIPINFO>");
    }
    ((StringBuffer)localObject2).append("</CLIPSINFO></CLIPMP4>");
    this.url = ((StringBuffer)localObject2).toString();
    localObject2 = this.videoInfo.getMp4ClipInfos().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)((Iterator)localObject2).next();
      int i = 0;
      while (i < this.videoInfo.getUrlInfos().size())
      {
        localObject1 = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(i)).getUrl();
        if (TextUtils.isEmpty(paramString))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(generateClipMp4Filename(this.fn, ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).getIdx()));
          localObject1 = generateMp4url(((StringBuilder)localObject4).toString(), ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).getVkey(), ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).getKeyid());
        }
        else
        {
          localObject1 = ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).getUrl();
        }
        if (i == 0) {
          ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).setUrl((String)localObject1);
        }
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject3).addUrlList((String)localObject1);
        i += 1;
      }
    }
  }
  
  private void buildHlsCdnUrl(String paramString)
  {
    String str = getSdtfrom();
    Object localObject2;
    if (this.videoInfo.getUrlInfos().size() > 0)
    {
      localObject1 = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0);
      if (localObject1 != null) {
        if (TextUtils.isEmpty(paramString))
        {
          int i = this.dltype;
          if (i == 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl());
            ((StringBuilder)localObject2).append(String.format("%s&hlskey=%s&sdtfrom=%s", new Object[] { ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getPt(), ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getHk(), str }));
            this.url = ((StringBuilder)localObject2).toString();
          }
          else if (i == 8)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl());
            ((StringBuilder)localObject2).append("&sdtfrom=");
            ((StringBuilder)localObject2).append(str);
            this.url = ((StringBuilder)localObject2).toString();
          }
        }
        else
        {
          this.url = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl();
        }
      }
    }
    Object localObject1 = this.videoInfo.getUrlInfos().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject2).getUrl());
        if (TextUtils.isEmpty(paramString))
        {
          if (this.dltype == 3)
          {
            localStringBuffer.append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject2).getPt());
            localStringBuffer.append("&hlskey=");
            localStringBuffer.append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject2).getHk());
          }
          localStringBuffer.append("&sdtfrom=");
          localStringBuffer.append(str);
        }
        this.urlList.add(localStringBuffer.toString());
      }
    }
    this.videoInfo.setUrlList(this.urlList);
  }
  
  private void buildMp4CdnUrl(String paramString)
  {
    Object localObject1 = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0);
    if (localObject1 != null)
    {
      this.url = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl();
      if (TextUtils.isEmpty(paramString))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject1).getUrl());
        ((StringBuilder)localObject2).append(this.fn);
        this.url = generateMp4url(((StringBuilder)localObject2).toString(), this.fvkey, "");
      }
    }
    Object localObject2 = this.videoInfo.getUrlInfos().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)((Iterator)localObject2).next();
      localObject1 = localTVKCGIVideoUrlInfo.getUrl();
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localTVKCGIVideoUrlInfo.getUrl());
        ((StringBuilder)localObject1).append(this.fn);
        localObject1 = generateMp4url(((StringBuilder)localObject1).toString(), this.fvkey, "");
      }
      this.urlList.add(localObject1);
    }
    this.videoInfo.setUrlList(this.urlList);
  }
  
  private String convertNodeToXmlString(Node paramNode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        boolean bool = paramNode.hasChildNodes();
        if ((!bool) || (!paramNode.getFirstChild().hasChildNodes())) {
          break label262;
        }
        localStringBuilder.append("<");
        localStringBuilder.append(paramNode.getNodeName());
        localStringBuilder.append(">");
        i = 1;
        bool = paramNode.hasChildNodes();
        if (bool)
        {
          Node localNode = paramNode.getFirstChild();
          if (localNode.hasChildNodes())
          {
            localStringBuilder.append(convertNodeToXmlString(localNode));
          }
          else
          {
            localStringBuilder.append("<");
            localStringBuilder.append(localNode.getParentNode().getNodeName());
            localStringBuilder.append(">");
            localStringBuilder.append(localNode.getNodeValue());
            localStringBuilder.append("</");
            localStringBuilder.append(localNode.getParentNode().getNodeName());
            localStringBuilder.append(">");
          }
          paramNode.removeChild(paramNode.getFirstChild());
          continue;
        }
        if (i != 0)
        {
          localStringBuilder.append("</");
          localStringBuilder.append(paramNode.getNodeName());
          localStringBuilder.append(">");
        }
      }
      catch (Exception paramNode)
      {
        paramNode.printStackTrace();
      }
      return localStringBuilder.toString();
      label262:
      int i = 0;
    }
  }
  
  private String generateClipMp4Filename(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return String.format("%s%d%s", new Object[] { paramString.substring(0, i + 1), Integer.valueOf(paramInt), paramString.substring(i) });
  }
  
  private String generateMp4url(String paramString1, String paramString2, String paramString3)
  {
    String str1 = getSdtfrom();
    String str2 = TVideoMgr.getStaGuid();
    paramString2 = String.format("%s?vkey=%s&platform=%d&br=%d&fmt=%s&sdtfrom=%s&guid=%s", new Object[] { paramString1, paramString2, Integer.valueOf(getPlatform()), Integer.valueOf(this.br), this.format, str1, str2 });
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("&keyid=");
      paramString1 = paramString1.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString1 = paramString2.toString();
    }
    return paramString1;
  }
  
  private String getFirstChildNodeValue(Node paramNode)
  {
    if ((paramNode != null) && (paramNode.getFirstChild() != null)) {
      return paramNode.getFirstChild().getNodeValue();
    }
    return "";
  }
  
  private int getPlatform()
  {
    TVKVideoInfoParams localTVKVideoInfoParams = this.videoInfoParams;
    if (localTVKVideoInfoParams != null) {
      return localTVKVideoInfoParams.getPlatForm();
    }
    return TVideoMgr.getVinfoPlatform();
  }
  
  private String getSdtfrom()
  {
    TVKVideoInfoParams localTVKVideoInfoParams = this.videoInfoParams;
    if (localTVKVideoInfoParams != null) {
      return TVideoMgr.getVinfoSdtfrom(localTVKVideoInfoParams.getPlatForm());
    }
    return TVideoMgr.getVinfoSdtfrom();
  }
  
  private void initVinfoFormatNodeNameMap()
  {
    this.vinfoFormatNodeNameMap.put("id", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("name", String.class);
    this.vinfoFormatNodeNameMap.put("br", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("fs", Long.TYPE);
    this.vinfoFormatNodeNameMap.put("sl", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("cname", String.class);
    this.vinfoFormatNodeNameMap.put("lmt", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("profile", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("drm", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("super", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("video", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("audio", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("sb", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("hdr10enh", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("sname", String.class);
    this.vinfoFormatNodeNameMap.put("resolution", String.class);
  }
  
  private void initVinfoViActionMap()
  {
    this.vinfoViActionMap.put("vi", new TVKCGIVideoInfoBuilder.ViParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("vid", new TVKCGIVideoInfoBuilder.VidParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fn", new TVKCGIVideoInfoBuilder.FnParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("st", new TVKCGIVideoInfoBuilder.StParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("lnk", new TVKCGIVideoInfoBuilder.LnkParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fvkey", new TVKCGIVideoInfoBuilder.FvkeyParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("base", new TVKCGIVideoInfoBuilder.BaseParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("duration", new TVKCGIVideoInfoBuilder.DurationParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ch", new TVKCGIVideoInfoBuilder.ChParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ckc", new TVKCGIVideoInfoBuilder.ChkParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ct", new TVKCGIVideoInfoBuilder.CtParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("dm", new TVKCGIVideoInfoBuilder.DmParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("drm", new TVKCGIVideoInfoBuilder.DrmParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("enc", new TVKCGIVideoInfoBuilder.EncParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fmd5", new TVKCGIVideoInfoBuilder.Fmd5ParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fps", new TVKCGIVideoInfoBuilder.FpsParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("keyid", new TVKCGIVideoInfoBuilder.KeyidParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fs", new TVKCGIVideoInfoBuilder.FsParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("fst", new TVKCGIVideoInfoBuilder.FstParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("head", new TVKCGIVideoInfoBuilder.HeadParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("hevc", new TVKCGIVideoInfoBuilder.HevcParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("iflag", new TVKCGIVideoInfoBuilder.IflagParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("mst", new TVKCGIVideoInfoBuilder.MstParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("tail", new TVKCGIVideoInfoBuilder.TailParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("targetid", new TVKCGIVideoInfoBuilder.TargetIdParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("td", new TVKCGIVideoInfoBuilder.TdParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ti", new TVKCGIVideoInfoBuilder.TiParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("tie", new TVKCGIVideoInfoBuilder.TieParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("type", new TVKCGIVideoInfoBuilder.TypeParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("vh", new TVKCGIVideoInfoBuilder.VhParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("vw", new TVKCGIVideoInfoBuilder.VwParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("wh", new TVKCGIVideoInfoBuilder.WhParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("videotype", new TVKCGIVideoInfoBuilder.VideotypeParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("vr", new TVKCGIVideoInfoBuilder.VrParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("vst", new TVKCGIVideoInfoBuilder.VstParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("swhdcp", new TVKCGIVideoInfoBuilder.SwhdcpParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("br", new TVKCGIVideoInfoBuilder.BrParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("cl", new TVKCGIVideoInfoBuilder.ClParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ul", new TVKCGIVideoInfoBuilder.UlParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("pl", new TVKCGIVideoInfoBuilder.PlParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("wl", new TVKCGIVideoInfoBuilder.WlParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ad", new TVKCGIVideoInfoBuilder.AdParseVinfoViNodeAction(this));
    this.vinfoViActionMap.put("ll", new TVKCGIVideoInfoBuilder.LlParseVinfoViNodeAction(this));
  }
  
  private void innerParseVinfoFormatNode(Node paramNode, TVKCGIVideoInfo.TVKCGIVideoFormatInfo paramTVKCGIVideoFormatInfo)
  {
    if (paramNode.getNodeType() == 1)
    {
      String str = paramNode.getNodeName().toLowerCase();
      if (str.equals("fi"))
      {
        parseVinfoFormatNode(paramNode.getChildNodes());
        return;
      }
      if (this.vinfoFormatNodeNameMap.containsKey(str))
      {
        if (this.vinfoFormatNodeNameMap.get(str) == Integer.TYPE)
        {
          TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, Integer.TYPE, Integer.valueOf(TVKUtils.optInt(getFirstChildNodeValue(paramNode), 0)));
          return;
        }
        if (this.vinfoFormatNodeNameMap.get(str) == Long.TYPE)
        {
          TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, Long.TYPE, Long.valueOf(TVKUtils.optLong(getFirstChildNodeValue(paramNode), 0L)));
          return;
        }
        if (this.vinfoFormatNodeNameMap.get(str) == String.class) {
          TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, String.class, getFirstChildNodeValue(paramNode));
        }
      }
    }
  }
  
  private void parseTvLogoNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo localTVKCGIVideoTVLogoInfo = new TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("li")) {
            parseTvLogoNode(localNode.getChildNodes());
          } else if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("x")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoX(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("y")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoY(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("show")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoShow(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
        }
        i += 1;
      }
      if ((localTVKCGIVideoTVLogoInfo.getTvLogoH() != 0) || ((localTVKCGIVideoTVLogoInfo.getTvLogoW() != 0) && (localTVKCGIVideoTVLogoInfo.getTvLogoX() != 0)) || (localTVKCGIVideoTVLogoInfo.getTvLogoY() != 0)) {
        this.videoInfo.addTVLogoInfo(localTVKCGIVideoTVLogoInfo);
      }
    }
  }
  
  private void parseVinfoAdNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if ((localNode.getNodeType() == 1) && (localNode.getNodeName().equalsIgnoreCase("adsid"))) {
          this.videoInfo.setAdsid(getFirstChildNodeValue(localNode));
        }
        i += 1;
      }
    }
  }
  
  private void parseVinfoAlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo localTVKCGIVideoAudioTrackInfo = new TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("ai"))
          {
            parseVinfoAlNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("sl"))
          {
            localTVKCGIVideoAudioTrackInfo.setSl(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("action"))
          {
            localTVKCGIVideoAudioTrackInfo.setAction(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("audio"))
          {
            localTVKCGIVideoAudioTrackInfo.setAudio(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("lmt"))
          {
            localTVKCGIVideoAudioTrackInfo.setLmt(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("keyid"))
          {
            localTVKCGIVideoAudioTrackInfo.setKeyid(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("name"))
          {
            localTVKCGIVideoAudioTrackInfo.setName(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("preview"))
          {
            localTVKCGIVideoAudioTrackInfo.setPreview(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("track"))
          {
            localTVKCGIVideoAudioTrackInfo.setTrack(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("ul"))
          {
            int j = 0;
            while (j < localNode.getChildNodes().getLength())
            {
              localTVKCGIVideoAudioTrackInfo.addUrlList(localNode.getChildNodes().item(j).getFirstChild().getFirstChild().getNodeValue());
              j += 1;
            }
          }
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoAudioTrackInfo.getName())) {
        this.videoInfo.addAudioTrackInfos(localTVKCGIVideoAudioTrackInfo);
      }
    }
  }
  
  private void parseVinfoClipNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo localTVKCGIVideoMp4ClipInfo = new TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("fc"))
          {
            this.clipCount = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setFc(this.clipCount);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("ci"))
          {
            parseVinfoClipNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("idx"))
          {
            localTVKCGIVideoMp4ClipInfo.setIdx(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("cs"))
          {
            localTVKCGIVideoMp4ClipInfo.setSize(TVKUtils.optLong(getFirstChildNodeValue(localNode), 0L));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("cd"))
          {
            localTVKCGIVideoMp4ClipInfo.setDuration(TVKUtils.optFloat(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("cmd5"))
          {
            localTVKCGIVideoMp4ClipInfo.setCmd5(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("keyid"))
          {
            localTVKCGIVideoMp4ClipInfo.setKeyid(getFirstChildNodeValue(localNode));
          }
        }
        i += 1;
      }
      if (localTVKCGIVideoMp4ClipInfo.getIdx() > 0) {
        this.videoInfo.addMp4ClipInfo(localTVKCGIVideoMp4ClipInfo);
      }
    }
  }
  
  private void parseVinfoFormatNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoFormatInfo localTVKCGIVideoFormatInfo = new TVKCGIVideoInfo.TVKCGIVideoFormatInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        innerParseVinfoFormatNode(paramNodeList.item(i), localTVKCGIVideoFormatInfo);
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoFormatInfo.getName())) {
        this.videoInfo.addFormatInfo(localTVKCGIVideoFormatInfo);
      }
      if (localTVKCGIVideoFormatInfo.getSl() == 1)
      {
        this.videoInfo.setSelectedFormat(localTVKCGIVideoFormatInfo.getName());
        this.videoInfo.setSelectedFormatID(localTVKCGIVideoFormatInfo.getId());
        this.videoInfo.setSelectedFilesize(localTVKCGIVideoFormatInfo.getFs());
        this.formatId = localTVKCGIVideoFormatInfo.getId();
        this.format = localTVKCGIVideoFormatInfo.getName();
        this.br = localTVKCGIVideoFormatInfo.getBr();
      }
    }
  }
  
  private void parseVinfoPlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoPictureInfo localTVKCGIVideoPictureInfo = new TVKCGIVideoInfo.TVKCGIVideoPictureInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("pd")) {
            parseVinfoPlNode(localNode.getChildNodes());
          } else if (localNode.getNodeName().equalsIgnoreCase("cd")) {
            localTVKCGIVideoPictureInfo.setCd(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoPictureInfo.setH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoPictureInfo.setW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("r")) {
            localTVKCGIVideoPictureInfo.setR(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("c")) {
            localTVKCGIVideoPictureInfo.setC(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("fmt")) {
            localTVKCGIVideoPictureInfo.setFmt(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("fn")) {
            localTVKCGIVideoPictureInfo.setFn(getFirstChildNodeValue(localNode));
          }
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoPictureInfo.getFn())) {
        this.videoInfo.addPictureInfo(localTVKCGIVideoPictureInfo);
      }
    }
  }
  
  private void parseVinfoRootNode(Document paramDocument)
  {
    if (paramDocument != null)
    {
      paramDocument = paramDocument.getFirstChild().getChildNodes();
      int i = 0;
      while (i < paramDocument.getLength())
      {
        Node localNode = paramDocument.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("em"))
          {
            this.em = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setEm(this.em);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("exem"))
          {
            this.exem = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setExem(this.exem);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("dltype"))
          {
            this.dltype = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setDltype(this.dltype);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("preview"))
          {
            this.videoInfo.setPreview(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("s"))
          {
            this.videoInfo.setS(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("tm"))
          {
            this.videoInfo.setTm(TVKUtils.optLong(getFirstChildNodeValue(localNode), 0L));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("fp2p"))
          {
            this.videoInfo.setFp2p(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("tstid"))
          {
            this.videoInfo.setTstid(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("ip"))
          {
            this.videoInfo.setIp(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("fl"))
          {
            parseVinfoFormatNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("al"))
          {
            parseVinfoAlNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("vl"))
          {
            parseVinfoViNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("sfl"))
          {
            parseVinfoSflNode(localNode.getChildNodes());
          }
        }
        i += 1;
      }
    }
  }
  
  private void parseVinfoSflNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo localTVKCGIVideoSubtitleInfo = new TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("fi")) {
            parseVinfoSflNode(localNode.getChildNodes());
          } else if (localNode.getNodeName().equalsIgnoreCase("keyid")) {
            localTVKCGIVideoSubtitleInfo.setKeyid(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("name")) {
            localTVKCGIVideoSubtitleInfo.setName(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("url")) {
            localTVKCGIVideoSubtitleInfo.setUrl(getFirstChildNodeValue(localNode));
          }
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoSubtitleInfo.getKeyid())) {
        this.videoInfo.addSubtitleInfo(localTVKCGIVideoSubtitleInfo);
      }
    }
  }
  
  private void parseVinfoUrlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = new TVKCGIVideoInfo.TVKCGIVideoUrlInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Object localObject = paramNodeList.item(i);
        if (((Node)localObject).getNodeType() == 1) {
          if (((Node)localObject).getNodeName().equalsIgnoreCase("ui"))
          {
            parseVinfoUrlNode(((Node)localObject).getChildNodes());
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("url"))
          {
            localTVKCGIVideoUrlInfo.setUrl(getFirstChildNodeValue((Node)localObject));
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("m3u8"))
          {
            localObject = getFirstChildNodeValue((Node)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              this.videoInfo.setM3u8((String)localObject);
            }
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("vt"))
          {
            localTVKCGIVideoUrlInfo.setVt(TVKUtils.optInt(getFirstChildNodeValue((Node)localObject), 0));
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("spip"))
          {
            localTVKCGIVideoUrlInfo.setSpip(getFirstChildNodeValue((Node)localObject));
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("spport"))
          {
            localTVKCGIVideoUrlInfo.setSpport(getFirstChildNodeValue((Node)localObject));
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("path"))
          {
            localTVKCGIVideoUrlInfo.setPath(getFirstChildNodeValue((Node)localObject));
          }
          else if (((Node)localObject).getNodeName().equalsIgnoreCase("hls"))
          {
            localObject = ((Node)localObject).getChildNodes();
            int j = 0;
            while (j < ((NodeList)localObject).getLength())
            {
              Node localNode = ((NodeList)localObject).item(j);
              if (localNode.getNodeType() == 1) {
                if (localNode.getNodeName().equalsIgnoreCase("hk")) {
                  localTVKCGIVideoUrlInfo.setHk(getFirstChildNodeValue(localNode));
                } else if (localNode.getNodeName().equalsIgnoreCase("pt")) {
                  localTVKCGIVideoUrlInfo.setPt(getFirstChildNodeValue(localNode));
                }
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
      if (!localTVKCGIVideoUrlInfo.getUrl().isEmpty()) {
        this.videoInfo.addUrlInfos(localTVKCGIVideoUrlInfo);
      }
    }
  }
  
  private void parseVinfoViNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (localNode.getNodeName() != null) {
            localObject = localNode.getNodeName().toLowerCase();
          } else {
            localObject = "";
          }
          Object localObject = (TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction)this.vinfoViActionMap.get(localObject);
          if (localObject != null) {
            ((TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction)localObject).onParseVinfoViNode(localNode);
          }
        }
        i += 1;
      }
    }
  }
  
  private void parseVinfoWlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo localTVKCGIVideoWatermarkInfo = new TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName().equalsIgnoreCase("wi")) {
            parseVinfoWlNode(localNode.getChildNodes());
          } else if (localNode.getNodeName().equalsIgnoreCase("id")) {
            localTVKCGIVideoWatermarkInfo.setId(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("x")) {
            localTVKCGIVideoWatermarkInfo.setX(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("y")) {
            localTVKCGIVideoWatermarkInfo.setY(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoWatermarkInfo.setH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoWatermarkInfo.setW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("a")) {
            localTVKCGIVideoWatermarkInfo.setA(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("md5")) {
            localTVKCGIVideoWatermarkInfo.setMd5(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("url")) {
            localTVKCGIVideoWatermarkInfo.setUrl(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("surl")) {
            localTVKCGIVideoWatermarkInfo.setSurl(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("action")) {
            this.videoInfo.setAction(getFirstChildNodeValue(localNode));
          }
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoWatermarkInfo.getMd5())) {
        this.videoInfo.addWatermarkInfos(localTVKCGIVideoWatermarkInfo);
      }
    }
  }
  
  public void buildCdnUrl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.dltype == 1)
    {
      if (this.clipCount > 0)
      {
        buildClipMp4CdnUrl(str);
        return;
      }
      buildMp4CdnUrl(str);
      return;
    }
    buildHlsCdnUrl(str);
  }
  
  public int getClipCount()
  {
    return this.clipCount;
  }
  
  public int getDltype()
  {
    return this.dltype;
  }
  
  public int getEm()
  {
    return this.em;
  }
  
  public int getExem()
  {
    return this.exem;
  }
  
  public int getFormatId()
  {
    return this.formatId;
  }
  
  public String getLinkvid()
  {
    return this.linkvid;
  }
  
  public String getPath()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getPath();
    }
    return "";
  }
  
  public String getSpip()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getSpip();
    }
    return "";
  }
  
  public String getSpport()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getSpport();
    }
    return "";
  }
  
  public int getSt()
  {
    return this.st;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public TVKVideoInfoParams getVideoInfoParams()
  {
    return this.videoInfoParams;
  }
  
  public String getVinfoXml()
  {
    return this.vinfoXml;
  }
  
  public int getVkeyCount()
  {
    return this.mVkeyInfos.size();
  }
  
  public int getVt()
  {
    return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getVt();
  }
  
  public TVKCGIVideoInfo parseVinfo(Document paramDocument)
  {
    try
    {
      parseVinfoRootNode(paramDocument);
      if (this.videoInfo.getMp4ClipInfos().size() > 0)
      {
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(0)).setUrl(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getUrl());
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(0)).setVkey(this.fvkey);
        paramDocument = new TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo();
        paramDocument.setIdx(1);
        paramDocument.setVkey(this.fvkey);
        this.mVkeyInfos.add(paramDocument);
      }
    }
    catch (Throwable paramDocument)
    {
      paramDocument.printStackTrace();
    }
    return this.videoInfo;
  }
  
  public void parseVkeyInfo(Document paramDocument)
  {
    if (paramDocument != null)
    {
      Object localObject1 = paramDocument.getElementsByTagName("em");
      Object localObject2 = paramDocument.getElementsByTagName("exem");
      if (((NodeList)localObject1).getLength() > 0)
      {
        this.em = TVKUtils.optInt(getFirstChildNodeValue(((NodeList)localObject1).item(0)), 0);
        this.exem = TVKUtils.optInt(getFirstChildNodeValue(((NodeList)localObject2).item(0)), 0);
        if (this.em > 0) {
          return;
        }
      }
      paramDocument = paramDocument.getElementsByTagName("cl").item(0).getChildNodes();
      int i = 0;
      while (i < paramDocument.getLength())
      {
        localObject1 = paramDocument.item(i);
        if ((((Node)localObject1).getNodeType() == 1) && (((Node)localObject1).getNodeName().equalsIgnoreCase("ci")))
        {
          localObject1 = ((Node)localObject1).getChildNodes();
          localObject2 = new TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo();
          int j = 0;
          while (j < ((NodeList)localObject1).getLength())
          {
            Node localNode = ((NodeList)localObject1).item(j);
            if (localNode.getNodeType() == 1) {
              if (localNode.getNodeName().equalsIgnoreCase("idx"))
              {
                ((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).setIdx(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
              }
              else if (localNode.getNodeName().equalsIgnoreCase("key"))
              {
                ((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).setVkey(getFirstChildNodeValue(localNode));
              }
              else if ((localNode.getNodeName().equalsIgnoreCase("ul")) && (localNode.getFirstChild() != null))
              {
                localNode = localNode.getFirstChild().getFirstChild();
                if ((localNode != null) && (localNode.getNodeName().equalsIgnoreCase("url"))) {
                  ((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).setUrl(getFirstChildNodeValue(localNode));
                }
              }
            }
            j += 1;
          }
          this.mVkeyInfos.add(localObject2);
          j = ((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).getIdx() - 1;
          if ((j > 0) && (this.videoInfo.getMp4ClipInfos().get(j) != null) && (((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).getIdx() == ((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).getIdx()))
          {
            ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).setUrl(((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).getUrl());
            ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).setVkey(((TVKCGIVideoInfoBuilder.TVKCGIVideoInfoVkeyInfo)localObject2).getVkey());
          }
        }
        i += 1;
      }
    }
  }
  
  public void setVideoInfoParams(TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    this.videoInfoParams = paramTVKVideoInfoParams;
  }
  
  public void setVinfoXml(String paramString)
  {
    this.vinfoXml = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder
 * JD-Core Version:    0.7.0.1
 */