package com.tencent.mobileqq.kandian.repo.video.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SimpleChannelInfo;
import com.tencent.mobileqq.kandian.repo.video.VideoProtoHelper;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.readinjoy.Readinjoy.ArticleSummary;
import tencent.im.oidb.readinjoy.Readinjoy.VideoData;

public class BaseVideoArticleInfo
  extends AbsBaseVideoArticleInfo
  implements Parcelable, Cloneable, Comparable<BaseVideoArticleInfo>
{
  public static final Parcelable.Creator<BaseVideoArticleInfo> CREATOR = new BaseVideoArticleInfo.1();
  public static final String TAG = "VideoArticleInfo";
  @notColumn
  public List<BaseVideoArticleInfo> articleList;
  public byte[] articleListBytes;
  @notColumn
  public List<Readinjoy.ArticleSummary> articleListObj;
  @notColumn
  public List<SimpleChannelInfo> labelList;
  @notColumn
  public VideoData videoData;
  @notColumn
  public Readinjoy.VideoData videoDataObj;
  
  public BaseVideoArticleInfo() {}
  
  protected BaseVideoArticleInfo(Parcel paramParcel)
  {
    this.articleID = paramParcel.readLong();
    this.rowkey = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.isUgc = bool;
    this.uptime = paramParcel.readInt();
    this.feedsType = paramParcel.readInt();
    this.videoCount = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.pagePicUrl = paramParcel.readString();
    this.articleContentUrl = paramParcel.readString();
    this.time = paramParcel.readLong();
    this.subscribeName = paramParcel.readString();
    this.subscribeIcon = paramParcel.readString();
    this.subscribeID = paramParcel.readString();
    this.commentCount = paramParcel.readInt();
    this.recommendTime = paramParcel.readLong();
    this.recommendSeq = paramParcel.readLong();
    this.algorithmID = paramParcel.readLong();
    this.strategyID = paramParcel.readInt();
    this.recommendReason = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      this.videoDataBytes = null;
    }
    else
    {
      this.videoDataBytes = new byte[i];
      paramParcel.readByteArray(this.videoDataBytes);
      Readinjoy.VideoData localVideoData = new Readinjoy.VideoData();
      try
      {
        localVideoData.mergeFrom(this.videoDataBytes);
        this.videoData = VideoProtoHelper.a(localVideoData);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        this.videoData = null;
      }
    }
    this.channelID = paramParcel.readInt();
    this.channelType = paramParcel.readInt();
    this.pushContext = paramParcel.readString();
    this.videoPlayCount = paramParcel.readInt();
    this.adsJumpUrl = paramParcel.readString();
    this.adsJumpType = paramParcel.readInt();
    this.videoReportInfo = paramParcel.readString();
    this.articleStyle = paramParcel.readInt();
    paramParcel.readByteArray(this.businessInfo);
    i = paramParcel.readInt();
    if (i <= 0)
    {
      this.articleListBytes = null;
    }
    else
    {
      this.articleListBytes = new byte[i];
      paramParcel.readByteArray(this.articleListBytes);
    }
    postRead();
  }
  
  public BaseVideoArticleInfo clone()
  {
    try
    {
      BaseVideoArticleInfo localBaseVideoArticleInfo = (BaseVideoArticleInfo)super.clone();
      return localBaseVideoArticleInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ArticleInfo CloneNotSupportedException e= ");
        localStringBuilder.append(localCloneNotSupportedException);
        QLog.d("VideoArticleInfo", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public int compareTo(@NonNull BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (this.time == paramBaseVideoArticleInfo.time) {
      return 0;
    }
    if (this.time < paramBaseVideoArticleInfo.time) {
      return -1;
    }
    return 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void postRead()
  {
    if ((this.videoDataBytes != null) && (this.videoDataBytes.length > 0))
    {
      this.videoDataObj = new Readinjoy.VideoData();
      try
      {
        this.videoDataObj.mergeFrom(this.videoDataBytes);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        this.videoDataObj = null;
      }
      localObject = this.videoDataObj;
      if (localObject != null) {
        this.videoData = VideoProtoHelper.a((Readinjoy.VideoData)localObject);
      }
    }
    Object localObject = this.articleListBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      CodedInputStreamMicro localCodedInputStreamMicro = CodedInputStreamMicro.newInstance((byte[])localObject);
      localObject = PBField.initRepeatMessage(Readinjoy.ArticleSummary.class);
      try
      {
        while (!localCodedInputStreamMicro.isAtEnd())
        {
          localCodedInputStreamMicro.readTag();
          ((PBRepeatMessageField)localObject).readFrom(localCodedInputStreamMicro);
        }
        int i;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.articleListObj = ((PBRepeatMessageField)localObject).get();
        if (this.articleListObj != null)
        {
          this.articleList = new ArrayList();
          i = 0;
          while (i < this.articleListObj.size())
          {
            this.articleList.add(VideoProtoHelper.a((Readinjoy.ArticleSummary)this.articleListObj.get(i)));
            i += 1;
          }
        }
      }
    }
  }
  
  protected void prewrite()
  {
    Object localObject1 = this.videoData;
    if (localObject1 != null)
    {
      this.videoDataObj = VideoProtoHelper.a((VideoData)localObject1);
      localObject1 = this.videoDataObj;
      if (localObject1 != null) {
        this.videoDataBytes = ((Readinjoy.VideoData)localObject1).toByteArray();
      }
    }
    if (this.articleList != null)
    {
      this.articleListObj = new ArrayList();
      localObject1 = this.articleList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseVideoArticleInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          this.articleListObj.add(VideoProtoHelper.a((BaseVideoArticleInfo)localObject2));
        }
      }
      if (!this.articleListObj.isEmpty())
      {
        localObject1 = PBField.initRepeatMessage(Readinjoy.ArticleSummary.class);
        ((PBRepeatMessageField)localObject1).addAll(this.articleListObj);
        localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
        try
        {
          CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
          ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
          localCodedOutputStreamMicro.flush();
          this.articleListBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseVideoArticleInfo{rowKey=");
    localStringBuilder.append(this.rowkey);
    localStringBuilder.append("\n,mArticleID=");
    localStringBuilder.append(this.articleID);
    localStringBuilder.append("\n, mRecommendSeq=");
    localStringBuilder.append(this.recommendSeq);
    localStringBuilder.append("\n, mTitle='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    prewrite();
    paramParcel.writeLong(this.articleID);
    paramParcel.writeString(this.rowkey);
    paramParcel.writeByte((byte)this.isUgc);
    paramParcel.writeInt(this.uptime);
    paramParcel.writeInt(this.feedsType);
    paramParcel.writeInt(this.videoCount);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.pagePicUrl);
    paramParcel.writeString(this.articleContentUrl);
    paramParcel.writeLong(this.time);
    paramParcel.writeString(this.subscribeName);
    paramParcel.writeString(this.subscribeIcon);
    paramParcel.writeString(this.subscribeID);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeLong(this.recommendTime);
    paramParcel.writeLong(this.recommendSeq);
    paramParcel.writeLong(this.algorithmID);
    paramParcel.writeInt(this.strategyID);
    paramParcel.writeString(this.recommendReason);
    byte[] arrayOfByte = this.videoDataBytes;
    int i = -1;
    if (arrayOfByte == null) {
      paramInt = -1;
    } else {
      paramInt = this.videoDataBytes.length;
    }
    paramParcel.writeInt(paramInt);
    if (paramInt > 0) {
      paramParcel.writeByteArray(this.videoDataBytes);
    }
    paramParcel.writeInt(this.channelID);
    paramParcel.writeInt(this.channelType);
    paramParcel.writeString(this.pushContext);
    paramParcel.writeInt(this.videoPlayCount);
    paramParcel.writeString(this.adsJumpUrl);
    paramParcel.writeInt(this.adsJumpType);
    paramParcel.writeString(this.videoReportInfo);
    paramParcel.writeInt(this.articleStyle);
    paramParcel.writeByteArray(this.businessInfo);
    arrayOfByte = this.articleListBytes;
    if (arrayOfByte == null) {
      paramInt = i;
    } else {
      paramInt = arrayOfByte.length;
    }
    paramParcel.writeInt(paramInt);
    if (paramInt > 0) {
      paramParcel.writeByteArray(this.articleListBytes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.BaseVideoArticleInfo
 * JD-Core Version:    0.7.0.1
 */