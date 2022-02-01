package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.Utils;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONObject;

public class MusicItemInfo
  implements Parcelable
{
  public static final int CAPTURE_VIDEO_LENGTH = 10000;
  public static final Parcelable.Creator<MusicItemInfo> CREATOR = new MusicItemInfo.1();
  public static final int ITEM_ID_ADD = -3;
  public static final int ITEM_ID_BGM_RECOGNITION = -6;
  public static final int ITEM_ID_HUM_HUNT = -4;
  public static final int ITEM_ID_MOCK = -5;
  public static final int ITEM_ID_MUTE = -2;
  public static final int ITEM_ID_ORIGIN = -1;
  public static final int ITEM_ID_WS_BANNER = -7;
  public static final float NOT_RECOGNITION_RESULT_OFFSET = -1.0F;
  public static final int TYPE_ADD = 4;
  public static final int TYPE_BGM_RECOGNITION_TAB = 8;
  public static final int TYPE_COMMON = 1;
  public static final int TYPE_DOV_BANNER = 11;
  public static final int TYPE_HUM_NO_MATCH = 7;
  public static final int TYPE_HUM_RECOGNITION_TAB = 6;
  public static final int TYPE_MUTE = 3;
  public static final int TYPE_ORIGIN = 2;
  public static final int TYPE_QQ_MUSIC = 5;
  public static final int TYPE_WS_BANNER = 10;
  public int downLv;
  public long fileSize;
  public String jumpWs;
  public int mAccuracy;
  public String mAlbumUrl;
  public boolean mHasCopyright;
  public int mItemId;
  public String mMusicName;
  private String mPath;
  public int mProgress = -1;
  public float mRecognitionOffset = -1.0F;
  public String mSingername;
  public String mSongMid;
  public String mTagName;
  public int mType;
  public String mUrl;
  public int musicDuration;
  public int musicEnd;
  public int musicStart;
  
  public MusicItemInfo()
  {
    this.mType = 1;
    this.musicStart = 0;
    this.musicEnd = 0;
    this.musicDuration = 0;
    this.fileSize = 0L;
    this.downLv = 0;
  }
  
  public MusicItemInfo(Parcel paramParcel)
  {
    boolean bool = true;
    this.mType = 1;
    this.musicStart = 0;
    this.musicEnd = 0;
    this.musicDuration = 0;
    this.fileSize = 0L;
    this.downLv = 0;
    this.mMusicName = paramParcel.readString();
    this.mSingername = paramParcel.readString();
    this.mUrl = paramParcel.readString();
    this.mTagName = paramParcel.readString();
    this.mItemId = paramParcel.readInt();
    this.mType = paramParcel.readInt();
    this.musicStart = paramParcel.readInt();
    this.musicEnd = paramParcel.readInt();
    this.musicDuration = paramParcel.readInt();
    this.mSongMid = paramParcel.readString();
    this.mRecognitionOffset = paramParcel.readFloat();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.mHasCopyright = bool;
    this.mAccuracy = paramParcel.readInt();
    this.jumpWs = paramParcel.readString();
    this.downLv = paramParcel.readInt();
    this.mAlbumUrl = paramParcel.readString();
  }
  
  public MusicItemInfo(String paramString)
  {
    this.mType = 1;
    this.musicStart = 0;
    this.musicEnd = 0;
    this.musicDuration = 0;
    this.fileSize = 0L;
    this.downLv = 0;
    paramString = new JSONObject(paramString);
    this.mMusicName = paramString.optString("title");
    this.mUrl = paramString.optString("audio_url");
    this.mSingername = paramString.optString("author");
    this.mItemId = paramString.optInt("item_id");
    if (paramString.has("type")) {
      this.mType = paramString.optInt("type");
    } else {
      this.mType = 1;
    }
    this.jumpWs = paramString.optString("jump_ws");
    this.downLv = paramString.optInt("downLv", 0);
    this.mAlbumUrl = paramString.optString("image_url");
  }
  
  public MusicItemInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mType = 1;
    this.musicStart = 0;
    this.musicEnd = 0;
    this.musicDuration = 0;
    this.fileSize = 0L;
    this.downLv = 0;
    this.mType = 5;
    this.mMusicName = paramString1;
    this.mUrl = paramString2;
    this.mSingername = paramString3;
    this.mItemId = paramInt1;
    this.mSongMid = paramString4;
    this.musicStart = paramInt2;
    this.musicEnd = paramInt3;
    this.musicDuration = paramInt4;
    this.mHasCopyright = paramBoolean;
  }
  
  public MusicItemInfo(JSONObject paramJSONObject)
  {
    this.mType = 1;
    this.musicStart = 0;
    this.musicEnd = 0;
    this.musicDuration = 0;
    this.fileSize = 0L;
    this.downLv = 0;
    try
    {
      if (paramJSONObject.has("mMusicName")) {
        this.mMusicName = paramJSONObject.getString("mMusicName");
      }
      if (paramJSONObject.has("mSingername")) {
        this.mSingername = paramJSONObject.getString("mSingername");
      }
      if (paramJSONObject.has("mUrl")) {
        this.mUrl = paramJSONObject.getString("mUrl");
      }
      if (paramJSONObject.has("mTagName")) {
        this.mTagName = paramJSONObject.getString("mTagName");
      }
      if (paramJSONObject.has("mPath")) {
        this.mPath = paramJSONObject.getString("mPath");
      }
      this.mItemId = paramJSONObject.getInt("mItemId");
      this.mType = paramJSONObject.getInt("mType");
      this.musicStart = paramJSONObject.getInt("musicStart");
      this.musicEnd = paramJSONObject.getInt("musicEnd");
      this.musicDuration = paramJSONObject.getInt("musicDuration");
      if (paramJSONObject.has("mSongMid")) {
        this.mSongMid = paramJSONObject.getString("mSongMid");
      }
      this.mRecognitionOffset = ((float)paramJSONObject.getDouble("mRecognitionOffset"));
      this.mHasCopyright = paramJSONObject.getBoolean("mHasCopyright");
      this.mAccuracy = paramJSONObject.getInt("mAccuracy");
      if (paramJSONObject.has("jump_ws")) {
        this.jumpWs = paramJSONObject.getString("jump_ws");
      }
      this.downLv = paramJSONObject.optInt("downLv", 0);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private String getMusicSuffix()
  {
    int i = this.mType;
    Object localObject2 = ".mp3";
    Object localObject3 = localObject2;
    Object localObject4;
    if (i == 5)
    {
      i = -1;
      int k;
      Object localObject1;
      try
      {
        int j = this.mUrl.indexOf(".m4a");
        k = j;
        localObject1 = localObject2;
        if (j >= 0)
        {
          i = j;
          localObject1 = this.mUrl.substring(j, j + 4);
          k = j;
        }
      }
      catch (Exception localException)
      {
        if (SLog.isEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getMusicSuffix e:");
          ((StringBuilder)localObject1).append(localException.toString());
          SLog.d("MusicItemInfo", ((StringBuilder)localObject1).toString());
        }
        k = i;
        localObject1 = localObject2;
        if (SLog.isEnable())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getMusicSuffix e:");
          ((StringBuilder)localObject1).append(localException.toString());
          SLog.d("MusicItemInfo", ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
          k = i;
        }
      }
      localObject4 = localObject1;
      if (SLog.isEnable())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getMusicSuffix ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" vIndex=");
        ((StringBuilder)localObject2).append(k);
        SLog.d("MusicItemInfo", ((StringBuilder)localObject2).toString());
        localObject4 = localObject1;
      }
    }
    return localObject4;
  }
  
  public static MusicItemInfo mock()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = "稻香";
    localMusicItemInfo.mSingername = "周杰伦";
    return localMusicItemInfo;
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.mMusicName != null) {
        localJSONObject.put("mMusicName", this.mMusicName);
      }
      if (this.mSingername != null) {
        localJSONObject.put("mSingername", this.mSingername);
      }
      if (this.mUrl != null) {
        localJSONObject.put("mUrl", this.mUrl);
      }
      if (this.mTagName != null) {
        localJSONObject.put("mTagName", this.mTagName);
      }
      if (this.mPath != null) {
        localJSONObject.put("mPath", this.mPath);
      }
      localJSONObject.put("mItemId", this.mItemId);
      localJSONObject.put("mType", this.mType);
      localJSONObject.put("musicStart", this.musicStart);
      localJSONObject.put("musicEnd", this.musicEnd);
      localJSONObject.put("musicDuration", this.musicDuration);
      if (this.mSongMid != null) {
        localJSONObject.put("mSongMid", this.mSongMid);
      }
      localJSONObject.put("mRecognitionOffset", this.mRecognitionOffset);
      localJSONObject.put("mHasCopyright", this.mHasCopyright);
      localJSONObject.put("mAccuracy", this.mAccuracy);
      localJSONObject.put("downLv", this.downLv);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      label218:
      break label218;
    }
    return null;
  }
  
  public MusicItemInfo copy()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = this.mMusicName;
    localMusicItemInfo.mSingername = this.mSingername;
    localMusicItemInfo.mUrl = this.mUrl;
    localMusicItemInfo.mTagName = this.mTagName;
    localMusicItemInfo.mItemId = this.mItemId;
    localMusicItemInfo.mType = this.mType;
    localMusicItemInfo.musicStart = this.musicStart;
    localMusicItemInfo.musicEnd = this.musicEnd;
    localMusicItemInfo.musicDuration = this.musicDuration;
    localMusicItemInfo.mSongMid = this.mSongMid;
    localMusicItemInfo.mPath = this.mPath;
    localMusicItemInfo.mRecognitionOffset = this.mRecognitionOffset;
    localMusicItemInfo.mHasCopyright = this.mHasCopyright;
    localMusicItemInfo.mAccuracy = this.mAccuracy;
    localMusicItemInfo.jumpWs = this.jumpWs;
    return localMusicItemInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MusicItemInfo paramMusicItemInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramMusicItemInfo != null)
    {
      int i = paramMusicItemInfo.mType;
      if ((i != 1) && (i != 5))
      {
        if (this.mType == i) {
          bool1 = true;
        }
        return bool1;
      }
    }
    bool1 = bool2;
    if (paramMusicItemInfo != null)
    {
      bool1 = bool2;
      if (paramMusicItemInfo.mItemId == this.mItemId)
      {
        bool1 = bool2;
        if (paramMusicItemInfo.mType == this.mType)
        {
          paramMusicItemInfo = paramMusicItemInfo.mMusicName;
          String str = this.mMusicName;
          if (paramMusicItemInfo != str)
          {
            bool1 = bool2;
            if (paramMusicItemInfo != null)
            {
              bool1 = bool2;
              if (!paramMusicItemInfo.equals(str)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getLocalPath()
  {
    try
    {
      if (TextUtils.isEmpty(this.mPath))
      {
        StringBuilder localStringBuilder = new StringBuilder(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
        if ((this.mType == 5) && (TextUtils.isEmpty(this.mUrl)))
        {
          this.mPath = null;
          return this.mPath;
        }
        if ((!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMusicName)))
        {
          localStringBuilder.append(Utils.Crc64String(this.mUrl));
          localStringBuilder.append("_");
          localStringBuilder.append(this.mMusicName.hashCode());
          localStringBuilder.append(getMusicSuffix());
        }
        this.mPath = localStringBuilder.toString();
      }
    }
    catch (Exception localException)
    {
      label131:
      break label131;
    }
    return this.mPath;
  }
  
  public int hashCode()
  {
    int i;
    if ((!TextUtils.isEmpty(this.mMusicName)) && (!TextUtils.isEmpty(this.mSongMid))) {
      i = this.mMusicName.hashCode() + this.mSongMid.hashCode() + this.mItemId;
    }
    for (int j = this.mType;; j = this.mType)
    {
      return i + j;
      i = this.mItemId;
    }
  }
  
  public boolean isDownloading()
  {
    int i = this.mProgress;
    return (i > -1) && (i < 100);
  }
  
  public boolean isFileExist()
  {
    int i = this.mType;
    return ((i == 5) || (i == 1)) && (FileUtil.fileExistsAndNotEmpty(getLocalPath()));
  }
  
  public boolean isMute()
  {
    return this.mType != 2;
  }
  
  public boolean isMyMusicInfo()
  {
    return this.mType == 5;
  }
  
  public boolean isWsBanner()
  {
    int i = this.mType;
    return (i == 10) || (i == 11);
  }
  
  public boolean needPlay()
  {
    int i = this.mType;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 5) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void setPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mPath = paramString;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicItemInfo: ");
    localStringBuilder.append(this.mSingername);
    localStringBuilder.append(" - ");
    localStringBuilder.append(this.mMusicName);
    localStringBuilder.append(" - ");
    localStringBuilder.append("mRecognitionOffset=");
    localStringBuilder.append(this.mRecognitionOffset);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMusicName);
    paramParcel.writeString(this.mSingername);
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mTagName);
    paramParcel.writeInt(this.mItemId);
    paramParcel.writeInt(this.mType);
    paramParcel.writeInt(this.musicStart);
    paramParcel.writeInt(this.musicEnd);
    paramParcel.writeInt(this.musicDuration);
    paramParcel.writeString(this.mSongMid);
    paramParcel.writeFloat(this.mRecognitionOffset);
    paramParcel.writeByte((byte)this.mHasCopyright);
    paramParcel.writeInt(this.mAccuracy);
    paramParcel.writeString(this.jumpWs);
    paramParcel.writeInt(this.downLv);
    paramParcel.writeString(this.mAlbumUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo
 * JD-Core Version:    0.7.0.1
 */