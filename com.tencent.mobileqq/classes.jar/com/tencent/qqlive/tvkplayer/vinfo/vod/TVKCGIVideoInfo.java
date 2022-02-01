package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class TVKCGIVideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoInfo> CREATOR = new TVKCGIVideoInfo.1();
  private String action;
  private String actualFormat;
  private String adsid;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo> audioTrackInfos = new ArrayList();
  private String base;
  private int br;
  private int ch;
  private String ckc;
  private int ct;
  private int dltype;
  private int dm;
  private int drm;
  private double duration;
  private int em;
  private int enc;
  private int exem;
  private int fc;
  private String fmd5;
  private String fn;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoFormatInfo> formatInfos = new ArrayList();
  private int fp2p = 0;
  private String fps;
  private long fs;
  private int fst;
  private String fvkey;
  private int head;
  private int hevc;
  private int iflag;
  private String ip;
  private String keyid;
  private String lnk;
  private boolean localVideo;
  private String m3u8;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo> mp4ClipInfos = new ArrayList();
  private int mst;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoPictureInfo> pictureInfos = new ArrayList();
  private String plInfoXml;
  private int preview;
  private long responseTime;
  private String s;
  private long selectedFilesize;
  private String selectedFormat;
  private int selectedFormatID;
  private int st;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo> subtitleInfos = new ArrayList();
  private int swhdcp;
  private int tail;
  private long targetid;
  private float td;
  private String ti;
  private int tie;
  private long tm;
  private int tstid = 0;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo> tvLogoInfos = new ArrayList();
  private int type;
  private String url = "";
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoUrlInfo> urlInfos = new ArrayList();
  private ArrayList<String> urlList = new ArrayList();
  private int vh;
  private String vid;
  private int videotype;
  private String vinfoXml = "";
  private int vr;
  private int vst;
  private int vw;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> watermarkInfos = new ArrayList();
  private float wh;
  
  public TVKCGIVideoInfo() {}
  
  private TVKCGIVideoInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public void addAudioTrackInfos(TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo paramTVKCGIVideoAudioTrackInfo)
  {
    this.audioTrackInfos.add(paramTVKCGIVideoAudioTrackInfo);
  }
  
  public void addFormatInfo(TVKCGIVideoInfo.TVKCGIVideoFormatInfo paramTVKCGIVideoFormatInfo)
  {
    this.formatInfos.add(paramTVKCGIVideoFormatInfo);
  }
  
  public void addMp4ClipInfo(TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo paramTVKCGIVideoMp4ClipInfo)
  {
    this.mp4ClipInfos.add(paramTVKCGIVideoMp4ClipInfo);
  }
  
  public void addPictureInfo(TVKCGIVideoInfo.TVKCGIVideoPictureInfo paramTVKCGIVideoPictureInfo)
  {
    this.pictureInfos.add(paramTVKCGIVideoPictureInfo);
  }
  
  public void addSubtitleInfo(TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo paramTVKCGIVideoSubtitleInfo)
  {
    this.subtitleInfos.add(paramTVKCGIVideoSubtitleInfo);
  }
  
  public void addTVLogoInfo(TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo paramTVKCGIVideoTVLogoInfo)
  {
    this.tvLogoInfos.add(paramTVKCGIVideoTVLogoInfo);
  }
  
  public void addUrlInfos(TVKCGIVideoInfo.TVKCGIVideoUrlInfo paramTVKCGIVideoUrlInfo)
  {
    this.urlInfos.add(paramTVKCGIVideoUrlInfo);
  }
  
  public void addWatermarkInfos(TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo paramTVKCGIVideoWatermarkInfo)
  {
    this.watermarkInfos.add(paramTVKCGIVideoWatermarkInfo);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getActualFormat()
  {
    return this.actualFormat;
  }
  
  public String getAdsid()
  {
    return this.adsid;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo> getAudioTrackInfos()
  {
    return this.audioTrackInfos;
  }
  
  public String getBase()
  {
    return this.base;
  }
  
  public int getBr()
  {
    return this.br;
  }
  
  public int getCh()
  {
    return this.ch;
  }
  
  public String getCkc()
  {
    return this.ckc;
  }
  
  public int getCt()
  {
    return this.ct;
  }
  
  public int getDltype()
  {
    return this.dltype;
  }
  
  public int getDm()
  {
    return this.dm;
  }
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public double getDuration()
  {
    return this.duration;
  }
  
  public int getEm()
  {
    return this.em;
  }
  
  public int getEnc()
  {
    return this.enc;
  }
  
  public int getExem()
  {
    return this.exem;
  }
  
  public int getFc()
  {
    return this.fc;
  }
  
  public String getFmd5()
  {
    return this.fmd5;
  }
  
  public String getFn()
  {
    return this.fn;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoFormatInfo> getFormatInfos()
  {
    return this.formatInfos;
  }
  
  public int getFp2p()
  {
    return this.fp2p;
  }
  
  public String getFps()
  {
    return this.fps;
  }
  
  public long getFs()
  {
    return this.fs;
  }
  
  public int getFst()
  {
    return this.fst;
  }
  
  public String getFvkey()
  {
    return this.fvkey;
  }
  
  public int getHead()
  {
    return this.head;
  }
  
  public int getHevc()
  {
    return this.hevc;
  }
  
  public int getIflag()
  {
    return this.iflag;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getKeyid()
  {
    return this.keyid;
  }
  
  public String getLnk()
  {
    return this.lnk;
  }
  
  public String getM3u8()
  {
    return this.m3u8;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo> getMp4ClipInfos()
  {
    return this.mp4ClipInfos;
  }
  
  public int getMst()
  {
    return this.mst;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoPictureInfo> getPictureInfos()
  {
    return this.pictureInfos;
  }
  
  public String getPlInfoXml()
  {
    return this.plInfoXml;
  }
  
  public int getPreview()
  {
    return this.preview;
  }
  
  public long getResponseTime()
  {
    return this.responseTime;
  }
  
  public String getS()
  {
    return this.s;
  }
  
  public long getSelectedFilesize()
  {
    return this.selectedFilesize;
  }
  
  public String getSelectedFormat()
  {
    return this.selectedFormat;
  }
  
  public int getSelectedFormatID()
  {
    return this.selectedFormatID;
  }
  
  public int getSt()
  {
    return this.st;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo> getSubtitleInfos()
  {
    return this.subtitleInfos;
  }
  
  public int getSwhdcp()
  {
    return this.swhdcp;
  }
  
  public int getTail()
  {
    return this.tail;
  }
  
  public long getTargetid()
  {
    return this.targetid;
  }
  
  public float getTd()
  {
    return this.td;
  }
  
  public String getTi()
  {
    return this.ti;
  }
  
  public int getTie()
  {
    return this.tie;
  }
  
  public long getTm()
  {
    return this.tm;
  }
  
  public int getTstid()
  {
    return this.tstid;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo> getTvLogoInfos()
  {
    return this.tvLogoInfos;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoUrlInfo> getUrlInfos()
  {
    return this.urlInfos;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public int getVh()
  {
    return this.vh;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public int getVideotype()
  {
    return this.videotype;
  }
  
  public String getVinfoXml()
  {
    return this.vinfoXml;
  }
  
  public int getVr()
  {
    return this.vr;
  }
  
  public int getVst()
  {
    return this.vst;
  }
  
  public int getVw()
  {
    return this.vw;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> getWatermarkInfos()
  {
    return this.watermarkInfos;
  }
  
  public float getWh()
  {
    return this.wh;
  }
  
  public boolean isLocalVideo()
  {
    return this.localVideo;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.s = paramParcel.readString();
    this.em = paramParcel.readInt();
    this.exem = paramParcel.readInt();
    this.preview = paramParcel.readInt();
    this.dltype = paramParcel.readInt();
    this.tm = paramParcel.readLong();
    this.fp2p = paramParcel.readInt();
    this.tstid = paramParcel.readInt();
    this.ip = paramParcel.readString();
    this.base = paramParcel.readString();
    this.ch = paramParcel.readInt();
    this.ckc = paramParcel.readString();
    this.ct = paramParcel.readInt();
    this.dm = paramParcel.readInt();
    this.drm = paramParcel.readInt();
    this.enc = paramParcel.readInt();
    this.fmd5 = paramParcel.readString();
    this.fn = paramParcel.readString();
    this.fps = paramParcel.readString();
    this.keyid = paramParcel.readString();
    this.fs = paramParcel.readLong();
    this.fst = paramParcel.readInt();
    this.head = paramParcel.readInt();
    this.hevc = paramParcel.readInt();
    this.iflag = paramParcel.readInt();
    this.lnk = paramParcel.readString();
    this.mst = paramParcel.readInt();
    this.st = paramParcel.readInt();
    this.tail = paramParcel.readInt();
    this.targetid = paramParcel.readLong();
    this.td = paramParcel.readFloat();
    this.ti = paramParcel.readString();
    this.tie = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.vh = paramParcel.readInt();
    this.vw = paramParcel.readInt();
    this.wh = paramParcel.readFloat();
    this.vid = paramParcel.readString();
    this.videotype = paramParcel.readInt();
    this.vr = paramParcel.readInt();
    this.vst = paramParcel.readInt();
    this.swhdcp = paramParcel.readInt();
    this.br = paramParcel.readInt();
    this.fc = paramParcel.readInt();
    this.fvkey = paramParcel.readString();
    this.duration = paramParcel.readDouble();
    this.action = paramParcel.readString();
    this.adsid = paramParcel.readString();
    this.formatInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoFormatInfo.class.getClassLoader());
    this.audioTrackInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo.class.getClassLoader());
    this.subtitleInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo.class.getClassLoader());
    this.pictureInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoPictureInfo.class.getClassLoader());
    this.urlInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoUrlInfo.class.getClassLoader());
    this.watermarkInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo.class.getClassLoader());
    this.mp4ClipInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo.class.getClassLoader());
    this.tvLogoInfos = paramParcel.readArrayList(TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo.class.getClassLoader());
    this.url = paramParcel.readString();
    this.vinfoXml = paramParcel.readString();
    this.actualFormat = paramParcel.readString();
    this.plInfoXml = paramParcel.readString();
    this.selectedFormat = paramParcel.readString();
    this.selectedFormatID = paramParcel.readInt();
    this.selectedFilesize = paramParcel.readLong();
    if (paramParcel.readInt() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.localVideo = bool;
      return;
    }
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setActualFormat(String paramString)
  {
    this.actualFormat = paramString;
  }
  
  public void setAdsid(String paramString)
  {
    this.adsid = paramString;
  }
  
  public void setBase(String paramString)
  {
    this.base = paramString;
  }
  
  public void setBr(int paramInt)
  {
    this.br = paramInt;
  }
  
  public void setCh(int paramInt)
  {
    this.ch = paramInt;
  }
  
  public void setCkc(String paramString)
  {
    this.ckc = paramString;
  }
  
  public void setCt(int paramInt)
  {
    this.ct = paramInt;
  }
  
  public void setDltype(int paramInt)
  {
    this.dltype = paramInt;
  }
  
  public void setDm(int paramInt)
  {
    this.dm = paramInt;
  }
  
  public void setDrm(int paramInt)
  {
    this.drm = paramInt;
  }
  
  public void setDuration(double paramDouble)
  {
    this.duration = paramDouble;
  }
  
  public void setEm(int paramInt)
  {
    this.em = paramInt;
  }
  
  public void setEnc(int paramInt)
  {
    this.enc = paramInt;
  }
  
  public void setExem(int paramInt)
  {
    this.exem = paramInt;
  }
  
  public void setFc(int paramInt)
  {
    this.fc = paramInt;
  }
  
  public void setFmd5(String paramString)
  {
    this.fmd5 = paramString;
  }
  
  public void setFn(String paramString)
  {
    this.fn = paramString;
  }
  
  public void setFp2p(int paramInt)
  {
    this.fp2p = paramInt;
  }
  
  public void setFps(String paramString)
  {
    this.fps = paramString;
  }
  
  public void setFs(long paramLong)
  {
    this.fs = paramLong;
  }
  
  public void setFst(int paramInt)
  {
    this.fst = paramInt;
  }
  
  public void setFvkey(String paramString)
  {
    this.fvkey = paramString;
  }
  
  public void setHead(int paramInt)
  {
    this.head = paramInt;
  }
  
  public void setHevc(int paramInt)
  {
    this.hevc = paramInt;
  }
  
  public void setIflag(int paramInt)
  {
    this.iflag = paramInt;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setIsLocalVideo(boolean paramBoolean)
  {
    this.localVideo = paramBoolean;
  }
  
  public void setKeyid(String paramString)
  {
    this.keyid = paramString;
  }
  
  public void setLnk(String paramString)
  {
    this.lnk = paramString;
  }
  
  public void setM3u8(String paramString)
  {
    this.m3u8 = paramString;
  }
  
  public void setMst(int paramInt)
  {
    this.mst = paramInt;
  }
  
  public void setPlInfoXml(String paramString)
  {
    this.plInfoXml = paramString;
  }
  
  public void setPreview(int paramInt)
  {
    this.preview = paramInt;
  }
  
  public void setResponseTime(long paramLong)
  {
    this.responseTime = paramLong;
  }
  
  public void setS(String paramString)
  {
    this.s = paramString;
  }
  
  public void setSelectedFilesize(long paramLong)
  {
    this.selectedFilesize = paramLong;
  }
  
  public void setSelectedFormat(String paramString)
  {
    this.selectedFormat = paramString;
  }
  
  public void setSelectedFormatID(int paramInt)
  {
    this.selectedFormatID = paramInt;
  }
  
  public void setSt(int paramInt)
  {
    this.st = paramInt;
  }
  
  public void setSwhdcp(int paramInt)
  {
    this.swhdcp = paramInt;
  }
  
  public void setTail(int paramInt)
  {
    this.tail = paramInt;
  }
  
  public void setTargetid(long paramLong)
  {
    this.targetid = paramLong;
  }
  
  public void setTd(float paramFloat)
  {
    this.td = paramFloat;
  }
  
  public void setTi(String paramString)
  {
    this.ti = paramString;
  }
  
  public void setTie(int paramInt)
  {
    this.tie = paramInt;
  }
  
  public void setTm(long paramLong)
  {
    this.tm = paramLong;
  }
  
  public void setTstid(int paramInt)
  {
    this.tstid = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUrlList(ArrayList<String> paramArrayList)
  {
    this.urlList = paramArrayList;
  }
  
  public void setVh(int paramInt)
  {
    this.vh = paramInt;
  }
  
  public void setVid(String paramString)
  {
    this.vid = paramString;
  }
  
  public void setVideotype(int paramInt)
  {
    this.videotype = paramInt;
  }
  
  public void setVinfoXml(String paramString)
  {
    this.vinfoXml = paramString;
  }
  
  public void setVr(int paramInt)
  {
    this.vr = paramInt;
  }
  
  public void setVst(int paramInt)
  {
    this.vst = paramInt;
  }
  
  public void setVw(int paramInt)
  {
    this.vw = paramInt;
  }
  
  public void setWh(float paramFloat)
  {
    this.wh = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.em);
    paramParcel.writeInt(this.exem);
    paramParcel.writeInt(this.preview);
    paramParcel.writeInt(this.dltype);
    paramParcel.writeLong(this.tm);
    paramParcel.writeInt(this.fp2p);
    paramParcel.writeInt(this.tstid);
    paramParcel.writeString(this.ip);
    paramParcel.writeString(this.base);
    paramParcel.writeInt(this.ch);
    paramParcel.writeString(this.ckc);
    paramParcel.writeInt(this.ct);
    paramParcel.writeInt(this.dm);
    paramParcel.writeInt(this.drm);
    paramParcel.writeInt(this.enc);
    paramParcel.writeString(this.fmd5);
    paramParcel.writeString(this.fn);
    paramParcel.writeString(this.fps);
    paramParcel.writeString(this.keyid);
    paramParcel.writeLong(this.fs);
    paramParcel.writeInt(this.fst);
    paramParcel.writeInt(this.head);
    paramParcel.writeInt(this.hevc);
    paramParcel.writeInt(this.iflag);
    paramParcel.writeString(this.lnk);
    paramParcel.writeInt(this.mst);
    paramParcel.writeInt(this.st);
    paramParcel.writeInt(this.tail);
    paramParcel.writeLong(this.targetid);
    paramParcel.writeFloat(this.td);
    paramParcel.writeString(this.ti);
    paramParcel.writeInt(this.tie);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.vh);
    paramParcel.writeInt(this.vw);
    paramParcel.writeFloat(this.wh);
    paramParcel.writeString(this.vid);
    paramParcel.writeInt(this.videotype);
    paramParcel.writeInt(this.vr);
    paramParcel.writeInt(this.vst);
    paramParcel.writeInt(this.swhdcp);
    paramParcel.writeInt(this.br);
    paramParcel.writeInt(this.fc);
    paramParcel.writeString(this.fvkey);
    paramParcel.writeDouble(this.duration);
    paramParcel.writeString(this.action);
    paramParcel.writeString(this.adsid);
    paramParcel.writeList(this.formatInfos);
    paramParcel.writeList(this.audioTrackInfos);
    paramParcel.writeList(this.subtitleInfos);
    paramParcel.writeList(this.pictureInfos);
    paramParcel.writeList(this.urlInfos);
    paramParcel.writeList(this.watermarkInfos);
    paramParcel.writeList(this.mp4ClipInfos);
    paramParcel.writeList(this.tvLogoInfos);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.vinfoXml);
    paramParcel.writeString(this.actualFormat);
    paramParcel.writeString(this.plInfoXml);
    paramParcel.writeString(this.selectedFormat);
    paramParcel.writeInt(this.selectedFormatID);
    paramParcel.writeLong(this.selectedFilesize);
    if (this.localVideo) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo
 * JD-Core Version:    0.7.0.1
 */