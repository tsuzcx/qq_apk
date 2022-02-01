package com.tencent.mobileqq.editor.database;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishVideoEntry
  extends Entity
  implements Copyable
{
  public static final String ENTRY_KEY_BACKGROUND_VOLUME = "backgroundVolume";
  public static final String ENTRY_KEY_IS_MIX_ORIGINAL = "isMixOriginal";
  public static final String ENTRY_KEY_ORIGINAL_RECORD_VOLUME = "originalRecordVolume";
  public static final String ENTRY_KEY_SUBTITLE = "subtitleData";
  public static int VIDEO_PROCESS_STATE_COMPOSITE_FAILED = -1;
  public static int VIDEO_PROCESS_STATE_COMPOSITE_SUC = 1;
  public static int VIDEO_PROCESS_STATE_UPLOAD_SUC = 2;
  public String atDoodlePath;
  public String atJsonData;
  public int backgroundMusicDuration;
  public int backgroundMusicOffset;
  public String backgroundMusicPath;
  public int businessId;
  public long createTime;
  public String doodlePath;
  public String doodleRawPath;
  @notColumn
  private JSONObject extraJson;
  public String extraJsonString;
  @unique
  public String fakeVid;
  @Deprecated
  public int fragmentGroupId;
  public String fragments;
  public String gpsFilterDescription;
  public boolean hasFragments;
  @notColumn
  public int hwBitrateMode = -1;
  public boolean hwEncodeRecordVideo;
  @notColumn
  public boolean isCancel = false;
  @notColumn
  public boolean isEdited;
  public boolean isLocalPublish;
  @notColumn
  public boolean isMixOriginal;
  public boolean isMuteRecordVoice;
  @notColumn
  public boolean isNeedHighProfile;
  public boolean isPicture;
  public String localCreateCity;
  public String mAudioFilePath;
  public String mIFrameVideoPath;
  public String mLocalDate;
  public String mLocalRawPicPath;
  public String mLocalRawVideoDir;
  public byte[] mMosaicMask;
  public int mMosaicSize;
  @notColumn
  public String manualSavedPath;
  public String mbgmAudioFilePath;
  public String miniThumbPath;
  public String mosaicPath;
  public String multiFragmentGroupId;
  public String name;
  public int publishFrom;
  public int publishState;
  public byte[] readerConfBytes;
  public int recordFrames;
  public double recordTime;
  public int saveMode;
  public byte[] spreadGroupBytes;
  public byte[] tagInfoBytes;
  public String thumbPath;
  public long timeZoneOffset;
  @notColumn
  public boolean useSrcFile;
  public String videoAddress;
  public String videoCreateAddress;
  public long videoCreateTime;
  public String videoDoodleDescription;
  public long videoDuration;
  public int videoHeight;
  public String videoLabel;
  public int videoLatitude;
  public String videoLocationDescription;
  public int videoLongitude;
  public int videoMaxrate;
  public int videoMinrate;
  public boolean videoNeedRotate;
  public int videoProcessState;
  public int videoRangeEnd;
  public int videoRangeStart;
  public String videoUploadGroupTempDir;
  public String videoUploadTempDir;
  public int videoWidth;
  
  /* Error */
  @android.support.annotation.NonNull
  private JSONObject getExtraJson()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJson	Lorg/json/JSONObject;
    //   6: ifnonnull +66 -> 72
    //   9: aload_0
    //   10: getfield 121	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJsonString	Ljava/lang/String;
    //   13: ifnull +21 -> 34
    //   16: aload_0
    //   17: new 123	org/json/JSONObject
    //   20: dup
    //   21: aload_0
    //   22: getfield 121	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJsonString	Ljava/lang/String;
    //   25: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: putfield 119	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJson	Lorg/json/JSONObject;
    //   31: goto +41 -> 72
    //   34: aload_0
    //   35: new 123	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 127	org/json/JSONObject:<init>	()V
    //   42: putfield 119	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJson	Lorg/json/JSONObject;
    //   45: goto +27 -> 72
    //   48: astore_1
    //   49: goto +32 -> 81
    //   52: astore_1
    //   53: ldc 129
    //   55: ldc 131
    //   57: aload_1
    //   58: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: aload_0
    //   62: new 123	org/json/JSONObject
    //   65: dup
    //   66: invokespecial 127	org/json/JSONObject:<init>	()V
    //   69: putfield 119	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJson	Lorg/json/JSONObject;
    //   72: aload_0
    //   73: getfield 119	com/tencent/mobileqq/editor/database/PublishVideoEntry:extraJson	Lorg/json/JSONObject;
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: areturn
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	PublishVideoEntry
    //   48	1	1	localObject	Object
    //   52	6	1	localJSONException	JSONException
    //   76	8	1	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	31	48	finally
    //   34	45	48	finally
    //   53	72	48	finally
    //   72	77	48	finally
    //   2	31	52	org/json/JSONException
    //   34	45	52	org/json/JSONException
  }
  
  public static String getGroupIdNoArgs()
  {
    return "multiFragmentGroupId=?";
  }
  
  public static String getVidSelectionNoArgs()
  {
    return "fakeVid=?";
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (PublishVideoEntry)paramObject;
    this.fakeVid = paramObject.fakeVid;
    this.createTime = paramObject.createTime;
    this.mLocalDate = paramObject.mLocalDate;
    this.timeZoneOffset = paramObject.timeZoneOffset;
    this.businessId = paramObject.businessId;
    this.name = paramObject.name;
    this.mLocalRawVideoDir = paramObject.mLocalRawVideoDir;
    this.mLocalRawPicPath = paramObject.mLocalRawPicPath;
    this.mMosaicMask = paramObject.mMosaicMask;
    this.mMosaicSize = paramObject.mMosaicSize;
    this.backgroundMusicPath = paramObject.backgroundMusicPath;
    this.backgroundMusicOffset = paramObject.backgroundMusicOffset;
    this.backgroundMusicDuration = paramObject.backgroundMusicDuration;
    this.isMuteRecordVoice = paramObject.isMuteRecordVoice;
    this.recordTime = paramObject.recordTime;
    this.recordFrames = paramObject.recordFrames;
    this.saveMode = paramObject.saveMode;
    this.isPicture = paramObject.isPicture;
    this.isLocalPublish = paramObject.isLocalPublish;
    this.publishFrom = paramObject.publishFrom;
    this.videoCreateTime = paramObject.videoCreateTime;
    this.fragmentGroupId = paramObject.fragmentGroupId;
    this.multiFragmentGroupId = paramObject.multiFragmentGroupId;
    this.videoRangeStart = paramObject.videoRangeStart;
    this.videoRangeEnd = paramObject.videoRangeEnd;
    this.videoCreateAddress = paramObject.videoCreateAddress;
    this.tagInfoBytes = paramObject.tagInfoBytes;
    this.videoUploadTempDir = paramObject.videoUploadTempDir;
    this.videoUploadGroupTempDir = paramObject.videoUploadGroupTempDir;
    this.publishState = paramObject.publishState;
    this.thumbPath = paramObject.thumbPath;
    this.doodlePath = paramObject.doodlePath;
    this.doodleRawPath = paramObject.doodleRawPath;
    this.videoLabel = paramObject.videoLabel;
    this.videoDoodleDescription = paramObject.videoDoodleDescription;
    this.videoLocationDescription = paramObject.videoLocationDescription;
    this.gpsFilterDescription = paramObject.gpsFilterDescription;
    this.videoAddress = paramObject.videoAddress;
    this.videoWidth = paramObject.videoWidth;
    this.videoHeight = paramObject.videoHeight;
    this.videoDuration = paramObject.videoDuration;
    this.videoMaxrate = paramObject.videoMaxrate;
    this.videoMinrate = paramObject.videoMinrate;
    this.atDoodlePath = paramObject.atDoodlePath;
    this.atJsonData = paramObject.atJsonData;
    this.localCreateCity = paramObject.localCreateCity;
    this.videoLatitude = paramObject.videoLatitude;
    this.videoLongitude = paramObject.videoLongitude;
    this.videoNeedRotate = paramObject.videoNeedRotate;
    this.hwEncodeRecordVideo = paramObject.hwEncodeRecordVideo;
    this.mAudioFilePath = paramObject.mAudioFilePath;
    this.mIFrameVideoPath = paramObject.mIFrameVideoPath;
    this.mosaicPath = paramObject.mosaicPath;
    this.readerConfBytes = paramObject.readerConfBytes;
    this.spreadGroupBytes = paramObject.spreadGroupBytes;
    this.videoProcessState = paramObject.videoProcessState;
    this.extraJsonString = paramObject.extraJsonString;
    this.extraJson = paramObject.extraJson;
    this.manualSavedPath = paramObject.manualSavedPath;
    this.isEdited = paramObject.isEdited;
    this.isNeedHighProfile = paramObject.isNeedHighProfile;
    this.hwBitrateMode = paramObject.hwBitrateMode;
    this.mbgmAudioFilePath = paramObject.mbgmAudioFilePath;
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    return getExtraJson().optBoolean(paramString, paramBoolean);
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    return getExtraJson().optInt(paramString, paramInt);
  }
  
  public JSONArray getJSONArrayExtra(String paramString)
  {
    return getExtraJson().optJSONArray(paramString);
  }
  
  public JSONObject getJSONExtra(String paramString)
  {
    return getExtraJson().optJSONObject(paramString);
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    return getExtraJson().optLong(paramString, paramLong);
  }
  
  public String getStringExtra(String paramString1, String paramString2)
  {
    return getExtraJson().optString(paramString1, paramString2);
  }
  
  protected void postRead()
  {
    super.postRead();
    this.isNeedHighProfile = getBooleanExtra("isNeedHighProfile", false);
    this.hwBitrateMode = getIntExtra("hwBitrateMode", -1);
  }
  
  protected void prewrite()
  {
    super.prewrite();
    putExtra("isNeedHighProfile", Boolean.valueOf(this.isNeedHighProfile));
    putExtra("hwBitrateMode", Integer.valueOf(this.hwBitrateMode));
  }
  
  public boolean putExtra(String paramString, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = getExtraJson();
      localJSONObject.put(paramString, paramObject);
      this.extraJsonString = localJSONObject.toString();
      return true;
    }
    catch (JSONException paramString)
    {
      SLog.c("PublishVideoEntry", "putStringExtra error", paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishVideoEntry{fakeVid='");
    localStringBuilder.append(this.fakeVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(", mLocalDate='");
    localStringBuilder.append(this.mLocalDate);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fragmentGroupId=");
    localStringBuilder.append(this.fragmentGroupId);
    localStringBuilder.append(", multiFragmentGroupId='");
    localStringBuilder.append(this.multiFragmentGroupId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeZoneOffset=");
    localStringBuilder.append(this.timeZoneOffset);
    localStringBuilder.append(", mLocalRawVideoDir='");
    localStringBuilder.append(this.mLocalRawVideoDir);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLocalRawPicPath='");
    localStringBuilder.append(this.mLocalRawPicPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMosaicSize=");
    localStringBuilder.append(this.mMosaicSize);
    localStringBuilder.append(", backgroundMusicPath='");
    localStringBuilder.append(this.backgroundMusicPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backgroundMusicOffset=");
    localStringBuilder.append(this.backgroundMusicOffset);
    localStringBuilder.append(", backgroundMusicDuration=");
    localStringBuilder.append(this.backgroundMusicDuration);
    localStringBuilder.append(", isMuteRecordVoice=");
    localStringBuilder.append(this.isMuteRecordVoice);
    localStringBuilder.append(", recordTime=");
    localStringBuilder.append(this.recordTime);
    localStringBuilder.append(", recordFrames=");
    localStringBuilder.append(this.recordFrames);
    localStringBuilder.append(", saveMode=");
    localStringBuilder.append(this.saveMode);
    localStringBuilder.append(", isPicture=");
    localStringBuilder.append(this.isPicture);
    localStringBuilder.append(", isLocalPublish=");
    localStringBuilder.append(this.isLocalPublish);
    localStringBuilder.append(", publishFrom=");
    localStringBuilder.append(this.publishFrom);
    localStringBuilder.append(", videoCreateTime=");
    localStringBuilder.append(this.videoCreateTime);
    localStringBuilder.append(", hasFragments=");
    localStringBuilder.append(this.hasFragments);
    localStringBuilder.append(", fragments='");
    localStringBuilder.append(this.fragments);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoRangeStart=");
    localStringBuilder.append(this.videoRangeStart);
    localStringBuilder.append(", videoRangeEnd=");
    localStringBuilder.append(this.videoRangeEnd);
    localStringBuilder.append(", videoUploadTempDir='");
    localStringBuilder.append(this.videoUploadTempDir);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUploadGroupTempDir='");
    localStringBuilder.append(this.videoUploadGroupTempDir);
    localStringBuilder.append('\'');
    localStringBuilder.append(", publishState=");
    localStringBuilder.append(this.publishState);
    localStringBuilder.append(", thumbPath='");
    localStringBuilder.append(this.thumbPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodlePath='");
    localStringBuilder.append(this.doodlePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleRawPath='");
    localStringBuilder.append(this.doodleRawPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoWidth=");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.videoHeight);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.videoDuration);
    localStringBuilder.append(", videoMaxrate=");
    localStringBuilder.append(this.videoMaxrate);
    localStringBuilder.append(", videoMinrate=");
    localStringBuilder.append(this.videoMinrate);
    localStringBuilder.append(", videoNeedRotate=");
    localStringBuilder.append(this.videoNeedRotate);
    localStringBuilder.append(", hwEncodeRecordVideo=");
    localStringBuilder.append(this.hwEncodeRecordVideo);
    localStringBuilder.append(", mAudioFilePath='");
    localStringBuilder.append(this.mAudioFilePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIFrameVideoPath='");
    localStringBuilder.append(this.mIFrameVideoPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mosaicPath='");
    localStringBuilder.append(this.mosaicPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoProcessState=");
    localStringBuilder.append(this.videoProcessState);
    localStringBuilder.append(", extraJsonString=");
    localStringBuilder.append(this.extraJsonString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.database.PublishVideoEntry
 * JD-Core Version:    0.7.0.1
 */