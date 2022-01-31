package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TVKNetVideoInfo
  implements Serializable
{
  public static final int AUDIO_CODEC_FORMAT_AAC = 1;
  public static final int AUDIO_CODEC_FORMAT_DOLBY_ATMOS = 3;
  public static final int AUDIO_CODEC_FORMAT_DOLBY_SURROUND = 2;
  public static final String FORMAT_AUDIO = "audio";
  public static final String FORMAT_FHD = "fhd";
  public static final String FORMAT_HD = "hd";
  public static final String FORMAT_HDR10 = "hdr10";
  public static final String FORMAT_MP4 = "mp4";
  public static final String FORMAT_MSD = "msd";
  public static final String FORMAT_SD = "sd";
  public static final String FORMAT_SHD = "shd";
  public static final int TYPE_JSON = 1;
  public static final int TYPE_PictureNode = 3;
  public static final int TYPE_XML = 2;
  public static final int VIDEO_CODEC_FORMAT_AUDIO = 5;
  public static final int VIDEO_CODEC_FORMAT_DOLLBYVISION = 4;
  public static final int VIDEO_CODEC_FORMAT_H264 = 1;
  public static final int VIDEO_CODEC_FORMAT_H265 = 2;
  public static final int VIDEO_CODEC_FORMAT_HDR10 = 3;
  public static final int VIDEO_CODEC_FORMAT_SDR = 7;
  public static final int VIDEO_CODEC_FORMAT_SDRPLUS = 6;
  public static final int VIDEO_HDR_TONEMAPPING_SUPPORT = 1;
  private static final long serialVersionUID = -1L;
  private ArrayList<TVKNetVideoInfo.AudioTrackInfo> mAudioTrackList;
  private TVKCGIVideoInfo mCGIVideoInfo;
  private int mChargeState = 0;
  private TVKNetVideoInfo.AudioTrackInfo mCurAudioTrack;
  private TVKNetVideoInfo.DefnInfo mCurDefinition;
  private TVKNetVideoInfo.SubTitle mCurSubtitle = null;
  private int mDanmuState = 0;
  private ArrayList<TVKNetVideoInfo.DefnInfo> mDefinitionList;
  private int mDuration = 0;
  private int mEndPos;
  private String mErrInfo;
  private String mErrTitle;
  private int mExem;
  private long mFileSize = 0L;
  private int mHlsP2p;
  private int mIRetDetailCode = 0;
  private boolean mIsHevc;
  private boolean mIsLocalVideo = false;
  private int mIsPay = 0;
  private int mLimit = 0;
  private String mLnk;
  private int mMediaVideoState;
  private int mNeedPay = 0;
  private String mPLString;
  private int mPLType = 0;
  private Object mPicList;
  private long mPlayBackStart;
  private long mPlayBackTime;
  private long mPlayTime;
  private int mPrePlayCountPerDay = 0;
  private long mPrePlayEndPos;
  private long mPrePlayStartPos;
  private long mPrePlayTime = 0L;
  private int mQueueRank;
  private String mQueueSessionKey;
  private int mQueueStatus;
  private int mQueueVipJump;
  private int mRestPrePlayCount = 0;
  private int mRetCode;
  private int mStartPos;
  private int mState = 2;
  private int mStatus;
  private int mSubErrType;
  private ArrayList<TVKNetVideoInfo.SubTitle> mSubTitleList = new ArrayList();
  private long mSvrTick;
  private int mTestId;
  private int mTie;
  private String mTitle;
  private String mVid;
  private HashMap<Integer, String> mVideoDownloadHostMap = new HashMap();
  private int mVideoType;
  private int mVst = 0;
  private float mWHRadio;
  private String mWanIP;
  ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> mWatermarkInfos;
  
  public void addAudioTrack(TVKNetVideoInfo.AudioTrackInfo paramAudioTrackInfo)
  {
    if (this.mAudioTrackList == null) {
      this.mAudioTrackList = new ArrayList();
    }
    this.mAudioTrackList.add(paramAudioTrackInfo);
  }
  
  public void addDefinition(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    if (this.mDefinitionList == null) {
      this.mDefinitionList = new ArrayList();
    }
    this.mDefinitionList.add(paramDefnInfo);
  }
  
  public void addSubTitle(TVKNetVideoInfo.SubTitle paramSubTitle)
  {
    this.mSubTitleList.add(paramSubTitle);
  }
  
  public void addVideoDownloadHostItem(Integer paramInteger, String paramString)
  {
    this.mVideoDownloadHostMap.put(paramInteger, paramString);
  }
  
  public TVKNetVideoInfo.AudioTrackInfo getAudioTrackByTrackName(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mAudioTrackList == null) || (this.mAudioTrackList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.mAudioTrackList.iterator();
    while (localIterator.hasNext())
    {
      TVKNetVideoInfo.AudioTrackInfo localAudioTrackInfo = (TVKNetVideoInfo.AudioTrackInfo)localIterator.next();
      if (TVKNetVideoInfo.AudioTrackInfo.access$000(localAudioTrackInfo).equals(paramString)) {
        return localAudioTrackInfo;
      }
    }
    return null;
  }
  
  public List<TVKNetVideoInfo.AudioTrackInfo> getAudioTrackList()
  {
    return this.mAudioTrackList;
  }
  
  public TVKCGIVideoInfo getCGIVideoInfo()
  {
    return this.mCGIVideoInfo;
  }
  
  public TVKNetVideoInfo.AudioTrackInfo getCurAudioTrack()
  {
    return this.mCurAudioTrack;
  }
  
  public TVKNetVideoInfo.DefnInfo getCurDefinition()
  {
    return this.mCurDefinition;
  }
  
  public TVKNetVideoInfo.SubTitle getCurSubtitle()
  {
    return this.mCurSubtitle;
  }
  
  public int getDanmuState()
  {
    return this.mDanmuState;
  }
  
  public ArrayList<TVKNetVideoInfo.DefnInfo> getDefinitionList()
  {
    return this.mDefinitionList;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getEndPos()
  {
    return this.mEndPos;
  }
  
  public String getErrInfo()
  {
    return this.mErrInfo;
  }
  
  public String getErrtitle()
  {
    return this.mErrTitle;
  }
  
  public int getExem()
  {
    return this.mExem;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public int getHlsp2p()
  {
    return this.mHlsP2p;
  }
  
  public int getIretDetailCode()
  {
    return this.mIRetDetailCode;
  }
  
  public int getIsPay()
  {
    return this.mIsPay;
  }
  
  public int getLimit()
  {
    return this.mLimit;
  }
  
  public String getLnk()
  {
    return this.mLnk;
  }
  
  public int getMediaVideoState()
  {
    return this.mMediaVideoState;
  }
  
  public int getMediaVideoType()
  {
    return this.mVideoType;
  }
  
  public int getNeedPay()
  {
    return this.mNeedPay;
  }
  
  public String getPLString()
  {
    return this.mPLString;
  }
  
  public int getPLType()
  {
    return this.mPLType;
  }
  
  public int getPayCh()
  {
    return this.mChargeState;
  }
  
  public Object getPictureList()
  {
    return this.mPicList;
  }
  
  public long getPlayBackStart()
  {
    return this.mPlayBackStart;
  }
  
  public long getPlayBackTime()
  {
    return this.mPlayBackTime;
  }
  
  public long getPlayTime()
  {
    return this.mPlayTime;
  }
  
  public int getPrePlayCountPerDay()
  {
    return this.mPrePlayCountPerDay;
  }
  
  public long getPrePlayEndPos()
  {
    return this.mPrePlayEndPos;
  }
  
  public long getPrePlayStartPos()
  {
    return this.mPrePlayStartPos;
  }
  
  public long getPrePlayTime()
  {
    return this.mPrePlayTime;
  }
  
  public int getQueueRank()
  {
    return this.mQueueRank;
  }
  
  public String getQueueSessionKey()
  {
    return this.mQueueSessionKey;
  }
  
  public int getQueueStatus()
  {
    return this.mQueueStatus;
  }
  
  public int getQueueVipJump()
  {
    return this.mQueueVipJump;
  }
  
  public int getRestPrePlayCount()
  {
    return this.mRestPrePlayCount;
  }
  
  public int getRetCode()
  {
    return this.mRetCode;
  }
  
  public int getSt()
  {
    return this.mState;
  }
  
  public int getStartPos()
  {
    return this.mStartPos;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public int getSubErrType()
  {
    return this.mSubErrType;
  }
  
  public TVKNetVideoInfo.SubTitle getSubIndex(String paramString)
  {
    Iterator localIterator = this.mSubTitleList.iterator();
    while (localIterator.hasNext())
    {
      TVKNetVideoInfo.SubTitle localSubTitle = (TVKNetVideoInfo.SubTitle)localIterator.next();
      if (localSubTitle.getmLang().equalsIgnoreCase(paramString)) {
        return localSubTitle;
      }
    }
    return null;
  }
  
  public ArrayList<TVKNetVideoInfo.SubTitle> getSubTitleList()
  {
    return this.mSubTitleList;
  }
  
  public long getSvrTick()
  {
    return this.mSvrTick;
  }
  
  public int getTestId()
  {
    return this.mTestId;
  }
  
  public int getTie()
  {
    return this.mTie;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public HashMap<Integer, String> getVideoDownloadHostMap()
  {
    return this.mVideoDownloadHostMap;
  }
  
  public int getVst()
  {
    return this.mVst;
  }
  
  public float getWHRadio()
  {
    return this.mWHRadio;
  }
  
  public String getWanIP()
  {
    return this.mWanIP;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> getWatermarkInfos()
  {
    return this.mWatermarkInfos;
  }
  
  public boolean isHevc()
  {
    return this.mIsHevc;
  }
  
  public boolean isLocalVideo()
  {
    return this.mIsLocalVideo;
  }
  
  public void removeAudioTrack(TVKNetVideoInfo.AudioTrackInfo paramAudioTrackInfo)
  {
    if (this.mAudioTrackList == null) {
      return;
    }
    this.mAudioTrackList.remove(paramAudioTrackInfo);
  }
  
  public void removeDefinition(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    if (this.mDefinitionList == null)
    {
      this.mDefinitionList = new ArrayList();
      return;
    }
    this.mDefinitionList.remove(paramDefnInfo);
  }
  
  public void setCGIVideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo)
  {
    this.mCGIVideoInfo = paramTVKCGIVideoInfo;
  }
  
  public void setCurAudioTrack(TVKNetVideoInfo.AudioTrackInfo paramAudioTrackInfo)
  {
    this.mCurAudioTrack = paramAudioTrackInfo;
  }
  
  public void setCurDefinition(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    this.mCurDefinition = paramDefnInfo;
  }
  
  public void setCurSubtitle(TVKNetVideoInfo.SubTitle paramSubTitle)
  {
    this.mCurSubtitle = paramSubTitle;
  }
  
  public void setDanmuState(int paramInt)
  {
    this.mDanmuState = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setEndPos(int paramInt)
  {
    this.mEndPos = paramInt;
  }
  
  public void setErrInfo(String paramString)
  {
    this.mErrInfo = paramString;
  }
  
  public void setErrtitle(String paramString)
  {
    this.mErrTitle = paramString;
  }
  
  public void setExem(int paramInt)
  {
    this.mExem = paramInt;
  }
  
  public void setFileSize(long paramLong)
  {
    this.mFileSize = paramLong;
  }
  
  public void setHlsp2p(int paramInt)
  {
    this.mHlsP2p = paramInt;
  }
  
  public void setIretDetailCode(int paramInt)
  {
    this.mIRetDetailCode = paramInt;
  }
  
  public void setIsHevc(boolean paramBoolean)
  {
    this.mIsHevc = paramBoolean;
  }
  
  public void setLimit(int paramInt)
  {
    this.mLimit = paramInt;
  }
  
  public void setLnk(String paramString)
  {
    this.mLnk = paramString;
  }
  
  public void setLocalVideo(boolean paramBoolean)
  {
    this.mIsLocalVideo = paramBoolean;
  }
  
  public void setMediaVideoState(int paramInt)
  {
    this.mMediaVideoState = paramInt;
  }
  
  public void setMediaVideoType(int paramInt)
  {
    this.mVideoType = paramInt;
  }
  
  public void setNeedPay(int paramInt)
  {
    this.mNeedPay = paramInt;
  }
  
  public void setPLString(String paramString)
  {
    this.mPLString = paramString;
  }
  
  public void setPLType(int paramInt)
  {
    this.mPLType = paramInt;
  }
  
  public void setPay(int paramInt)
  {
    this.mIsPay = paramInt;
  }
  
  public void setPayCh(int paramInt)
  {
    this.mChargeState = paramInt;
  }
  
  public void setPictureList(Object paramObject)
  {
    this.mPicList = paramObject;
  }
  
  public void setPlayBackStart(long paramLong)
  {
    this.mPlayBackStart = paramLong;
  }
  
  public void setPlayBackTime(long paramLong)
  {
    this.mPlayBackTime = paramLong;
  }
  
  public void setPlayTime(long paramLong)
  {
    this.mPlayTime = paramLong;
  }
  
  public void setPrePlayCountPerDay(int paramInt)
  {
    this.mPrePlayCountPerDay = paramInt;
  }
  
  public void setPrePlayEndPos(long paramLong)
  {
    this.mPrePlayEndPos = paramLong;
  }
  
  public void setPrePlayStartPos(long paramLong)
  {
    this.mPrePlayStartPos = paramLong;
  }
  
  public void setPrePlayTime(long paramLong)
  {
    this.mPrePlayTime = paramLong;
  }
  
  public void setQueueRank(int paramInt)
  {
    this.mQueueRank = paramInt;
  }
  
  public void setQueueSessionKey(String paramString)
  {
    this.mQueueSessionKey = paramString;
  }
  
  public void setQueueStatus(int paramInt)
  {
    this.mQueueStatus = paramInt;
  }
  
  public void setQueueVipJump(int paramInt)
  {
    this.mQueueVipJump = paramInt;
  }
  
  public void setRestPrePlayCount(int paramInt)
  {
    this.mRestPrePlayCount = paramInt;
  }
  
  public void setRetCode(int paramInt)
  {
    this.mRetCode = paramInt;
  }
  
  public void setSt(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void setStartPos(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  public void setSubErrType(int paramInt)
  {
    this.mSubErrType = paramInt;
  }
  
  public void setSvrTick(long paramLong)
  {
    this.mSvrTick = paramLong;
  }
  
  public void setTestId(int paramInt)
  {
    this.mTestId = paramInt;
  }
  
  public void setTie(int paramInt)
  {
    this.mTie = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public void setVid(String paramString)
  {
    this.mVid = paramString;
  }
  
  public void setVst(int paramInt)
  {
    this.mVst = paramInt;
  }
  
  public void setWHRadio(float paramFloat)
  {
    this.mWHRadio = paramFloat;
  }
  
  public void setWanIP(String paramString)
  {
    this.mWanIP = paramString;
  }
  
  public void setWatermarkInfos(ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> paramArrayList)
  {
    this.mWatermarkInfos = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo
 * JD-Core Version:    0.7.0.1
 */