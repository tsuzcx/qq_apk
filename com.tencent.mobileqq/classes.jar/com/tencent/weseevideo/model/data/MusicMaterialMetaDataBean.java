package com.tencent.weseevideo.model.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MusicMaterialMetaDataBean
  implements Parcelable, BaseColumns, Serializable, Cloneable
{
  public static final int CHOOSE_STATE = 4;
  public static final String COL_ID = "_id";
  public static final String COL_LAST_USE_TIME = "last_use_time";
  public static final String COL_MUSIC_ID = "music_id";
  public static final String COL_START_TIME = "start_time";
  public static final String COL_USER_ID = "user_id";
  public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.tencent.ttpic.music";
  public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.tencent.ttpic.music";
  public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.weishi.provider.DatabaseManager/history_music");
  public static final Parcelable.Creator<MusicMaterialMetaDataBean> CREATOR = new MusicMaterialMetaDataBean.1();
  public static final String DEFAULT_SORT_ORDER = "last_use_time DESC";
  public static final String DELETE_SORT_ORDER = "last_use_time";
  public static final int FORM_TYPE_INIT = 3;
  public static final int FORM_TYPE_NONE = 1;
  public static final int FORM_TYPE_SELECTED = 2;
  public static final int FromStorageFile = 3;
  public static final int FromstMetaMaterialType = 1;
  public static final int FromstMusicFullInfoType = 2;
  public static final int LOADING_STATE = 3;
  public static final int MAX_HISTORY_COUNT = 99;
  public static final int MAX_MUSIC_RECORD = 999;
  public static final String MUSIC_SEARCH_DATA = "MUSIC_SEARCH_DATA";
  public static final int NORAML = 0;
  public static final int PAUSE_STATE = 2;
  public static final int PLAY_STATE = 1;
  public static final int ReferDefault = 0;
  public static final int ReferDuiQi = 2;
  public static final int ReferLocalVideo = 1;
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS history_music (_id INTEGER PRIMARY KEY, music_id TEXT, start_time INTEGER, last_use_time INTEGER, user_id TEXT);";
  public static final String SQL_CREATE_INDEX_ID = "CREATE INDEX musicIdIndex ON history_music(music_id);";
  public static final String TABLE_NAME = "history_music";
  private static final long serialVersionUID = 1L;
  public int audioDuration;
  public byte autoPlay;
  public String categroyId = "";
  public long collectTime;
  public String desc;
  @SerializedName("descindex")
  public List<MusicMaterialMetaDataBean.HighlightIndex> descIndices;
  public int endTime;
  public int exclusive;
  public int feedNum;
  public String feedlist_hot_id;
  public String feedlist_time_id;
  public String followFeedId = "";
  public int formType = 1;
  public int iSource = 0;
  public String id;
  public int indexInCategory;
  public boolean isCloseLyric = false;
  public int isCollected;
  public boolean isStuckPoint;
  public String label;
  public String lyric = "";
  public String lyricFormat = "";
  public int mDefaultFeedPosition = 0;
  public int mDefaultTogetherFeed = 0;
  public int mFeedUseType = 0;
  public int mFromDataType = -1;
  public String mTogetherFeed = "";
  public int mTogetherType = 0;
  public int mTotalTime = -1;
  public int mask;
  public int miniSptVersion;
  public String music_from = "";
  public String name;
  @SerializedName("titleindex")
  public List<MusicMaterialMetaDataBean.HighlightIndex> nameIndices;
  public int orgStartTime;
  public String packageUrl;
  public String path;
  public String recommendInfo = "";
  public int refer = 0;
  public int rich_flag;
  public String secLyric = "";
  public String secLyricFormat = "";
  public int segDuration;
  public String shortName;
  public long sid;
  public Map<Integer, String> songLabels;
  public int startTime;
  public int state = -1;
  public String stuckPointJsonUrl;
  public String thumbUrl;
  public String title;
  public List<String> topic_ids;
  public String type;
  public int version;
  
  public MusicMaterialMetaDataBean() {}
  
  protected MusicMaterialMetaDataBean(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.sid = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.type = paramParcel.readString();
    this.thumbUrl = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.miniSptVersion = paramParcel.readInt();
    this.packageUrl = paramParcel.readString();
    this.path = paramParcel.readString();
    this.feedlist_time_id = paramParcel.readString();
    this.feedlist_hot_id = paramParcel.readString();
    this.topic_ids = paramParcel.createStringArrayList();
    this.mask = paramParcel.readInt();
    this.shortName = paramParcel.readString();
    this.rich_flag = paramParcel.readInt();
    this.startTime = paramParcel.readInt();
    this.endTime = paramParcel.readInt();
    this.audioDuration = paramParcel.readInt();
    this.isCollected = paramParcel.readInt();
    this.autoPlay = paramParcel.readByte();
    this.lyric = paramParcel.readString();
    this.secLyric = paramParcel.readString();
    this.lyricFormat = paramParcel.readString();
    this.secLyricFormat = paramParcel.readString();
    this.label = paramParcel.readString();
    this.mFromDataType = paramParcel.readInt();
    this.mTotalTime = paramParcel.readInt();
    this.followFeedId = paramParcel.readString();
    this.orgStartTime = paramParcel.readInt();
    this.refer = paramParcel.readInt();
    this.iSource = paramParcel.readInt();
    this.mTogetherFeed = paramParcel.readString();
    this.mTogetherType = paramParcel.readInt();
    this.mFeedUseType = paramParcel.readInt();
    this.segDuration = paramParcel.readInt();
    this.recommendInfo = paramParcel.readString();
    this.music_from = paramParcel.readString();
    this.categroyId = paramParcel.readString();
    this.songLabels = paramParcel.readHashMap(getClass().getClassLoader());
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isStuckPoint = bool;
      this.stuckPointJsonUrl = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public static boolean isGenpaiMusic(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    if (paramMusicMaterialMetaDataBean == null) {}
    while ((TextUtils.isEmpty(paramMusicMaterialMetaDataBean.followFeedId)) || (paramMusicMaterialMetaDataBean.orgStartTime != paramMusicMaterialMetaDataBean.startTime)) {
      return false;
    }
    return true;
  }
  
  public MusicMaterialMetaDataBean clone()
  {
    try
    {
      MusicMaterialMetaDataBean localMusicMaterialMetaDataBean = (MusicMaterialMetaDataBean)super.clone();
      return localMusicMaterialMetaDataBean;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ContentValues fill()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("music_id", this.id);
    localContentValues.put("start_time", Integer.valueOf(this.startTime));
    return localContentValues;
  }
  
  public String getMusicFrom()
  {
    return this.music_from;
  }
  
  public MusicMaterialMetaDataBean load(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex("music_id");
    if (i != -1) {
      this.id = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("start_time");
    if (i != -1) {
      this.startTime = paramCursor.getInt(i);
    }
    return this;
  }
  
  public void setMusicFrom(String paramString)
  {
    this.music_from = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeLong(this.sid);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.miniSptVersion);
    paramParcel.writeString(this.packageUrl);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.feedlist_time_id);
    paramParcel.writeString(this.feedlist_hot_id);
    paramParcel.writeStringList(this.topic_ids);
    paramParcel.writeInt(this.mask);
    paramParcel.writeString(this.shortName);
    paramParcel.writeInt(this.rich_flag);
    paramParcel.writeInt(this.startTime);
    paramParcel.writeInt(this.endTime);
    paramParcel.writeInt(this.audioDuration);
    paramParcel.writeInt(this.isCollected);
    paramParcel.writeByte(this.autoPlay);
    paramParcel.writeString(this.lyric);
    paramParcel.writeString(this.secLyric);
    paramParcel.writeString(this.lyricFormat);
    paramParcel.writeString(this.secLyricFormat);
    paramParcel.writeString(this.label);
    paramParcel.writeInt(this.mFromDataType);
    paramParcel.writeInt(this.mTotalTime);
    paramParcel.writeString(this.followFeedId);
    paramParcel.writeInt(this.orgStartTime);
    paramParcel.writeInt(this.refer);
    paramParcel.writeInt(this.iSource);
    paramParcel.writeString(this.mTogetherFeed);
    paramParcel.writeInt(this.mTogetherType);
    paramParcel.writeInt(this.mFeedUseType);
    paramParcel.writeInt(this.segDuration);
    paramParcel.writeString(this.recommendInfo);
    paramParcel.writeString(this.music_from);
    paramParcel.writeString(this.categroyId);
    paramParcel.writeMap(this.songLabels);
    if (this.isStuckPoint) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.stuckPointJsonUrl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean
 * JD-Core Version:    0.7.0.1
 */