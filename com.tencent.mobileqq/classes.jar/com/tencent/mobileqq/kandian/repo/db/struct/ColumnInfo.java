package com.tencent.mobileqq.kandian.repo.db.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import org.jetbrains.annotations.NotNull;
import tencent.kandian.ugc.topic_info.TopicInfo;
import tencent.kandian.ugc.topic_info.TopicInfoExt;

public class ColumnInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<ColumnInfo> CREATOR = new ColumnInfo.1();
  public static final int SOURCE_UGC = 5;
  public static final int TYPE_ALLOW_SUBMIT = 1;
  public static final int TYPE_FORBID_SUBMIT = 0;
  public int columnID = 0;
  public int commentCount = 0;
  public String coverUrl = "";
  public String intro = "";
  public int source = 0;
  public int submitPermission = 0;
  public int subscribeCount = 0;
  public String title = "";
  private long uid = 0L;
  public int videoCount = 0;
  
  public ColumnInfo() {}
  
  public ColumnInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.columnID = paramInt1;
    this.coverUrl = paramString1;
    this.title = paramString2;
    this.intro = paramString3;
    this.submitPermission = paramInt2;
  }
  
  protected ColumnInfo(Parcel paramParcel)
  {
    this.columnID = paramParcel.readInt();
    this.coverUrl = paramParcel.readString();
    this.title = paramParcel.readString();
    this.intro = paramParcel.readString();
    this.submitPermission = paramParcel.readInt();
    this.source = paramParcel.readInt();
    this.uid = paramParcel.readLong();
    this.subscribeCount = paramParcel.readInt();
    this.commentCount = paramParcel.readInt();
    this.videoCount = paramParcel.readInt();
  }
  
  public ColumnInfo(topic_info.TopicInfo paramTopicInfo)
  {
    this.columnID = paramTopicInfo.id.get();
    if (paramTopicInfo.cover_img.has()) {
      this.coverUrl = paramTopicInfo.cover_img.get();
    }
    if (paramTopicInfo.title.has()) {
      this.title = paramTopicInfo.title.get();
    }
    if (paramTopicInfo.intro.has()) {
      this.intro = paramTopicInfo.intro.get();
    }
    this.submitPermission = paramTopicInfo.submit_permission.get();
    this.source = paramTopicInfo.source.get();
    this.uid = paramTopicInfo.creator_uid.get();
    this.subscribeCount = paramTopicInfo.ext.subscribe_num.get();
    this.commentCount = paramTopicInfo.ext.comment_num.get();
    this.videoCount = paramTopicInfo.ext.content_count.get();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getUid()
  {
    return this.uid;
  }
  
  public topic_info.TopicInfo parseToTopicInfo()
  {
    topic_info.TopicInfo localTopicInfo = new topic_info.TopicInfo();
    localTopicInfo.id.set(this.columnID);
    PBStringField localPBStringField = localTopicInfo.cover_img;
    String str = this.coverUrl;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localPBStringField = localTopicInfo.title;
    str = this.title;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localPBStringField = localTopicInfo.intro;
    str = this.intro;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localTopicInfo.submit_permission.set(this.submitPermission);
    localTopicInfo.source.set(this.source);
    localTopicInfo.creator_uid.set(this.uid);
    localTopicInfo.ext.subscribe_num.set(this.subscribeCount);
    localTopicInfo.ext.comment_num.set(this.commentCount);
    localTopicInfo.ext.content_count.set(this.videoCount);
    return localTopicInfo;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColumnInfo{columnID='");
    localStringBuilder.append(this.columnID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", intro='");
    localStringBuilder.append(this.intro);
    localStringBuilder.append('\'');
    localStringBuilder.append(", submitPermission='");
    localStringBuilder.append(this.submitPermission);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.source);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.uid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subscribeCount='");
    localStringBuilder.append(this.subscribeCount);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentCount='");
    localStringBuilder.append(this.commentCount);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCount='");
    localStringBuilder.append(this.videoCount);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean valid()
  {
    return (!TextUtils.isEmpty(this.title)) && (this.columnID != 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.columnID);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.intro);
    paramParcel.writeInt(this.submitPermission);
    paramParcel.writeInt(this.source);
    paramParcel.writeLong(this.uid);
    paramParcel.writeInt(this.subscribeCount);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeInt(this.videoCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */