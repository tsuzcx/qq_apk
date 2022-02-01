package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDraftboxItem$ReadInJoyDraftboxContent
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ReadInJoyDraftboxContent> CREATOR = new ReadInJoyDraftboxItem.ReadInJoyDraftboxContent.1();
  private static final long serialVersionUID = 1L;
  public int adTag;
  public ArrayList<ReadInJoyDraftboxItem.PicData> adapterList;
  public String answerTitle;
  public int articleType;
  public String commentString;
  public ArrayList<BiuCommentInfo> multiBiuStruct;
  public int originFrom;
  public ArrayList<ReadInJoyDraftboxItem.PicData> picDataList;
  public ArrayList<ReadInJoyDraftboxItem.PicData> realList;
  public String richTextContent;
  public int srcSize;
  public String topicId;
  public List<Integer> typeList;
  public String ugcEditCookie;
  
  public ReadInJoyDraftboxItem$ReadInJoyDraftboxContent() {}
  
  public ReadInJoyDraftboxItem$ReadInJoyDraftboxContent(Parcel paramParcel)
  {
    this.topicId = paramParcel.readString();
    this.ugcEditCookie = paramParcel.readString();
    this.adTag = paramParcel.readInt();
    this.commentString = paramParcel.readString();
    this.typeList = paramParcel.readArrayList(Integer.class.getClassLoader());
    this.srcSize = paramParcel.readInt();
    this.multiBiuStruct = paramParcel.createTypedArrayList(BiuCommentInfo.CREATOR);
    this.picDataList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.realList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.adapterList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
    this.richTextContent = paramParcel.readString();
    this.answerTitle = paramParcel.readString();
    this.articleType = paramParcel.readInt();
    this.originFrom = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyDraftboxContent{topicId='");
    localStringBuilder.append(this.topicId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ugcEditCookie='");
    localStringBuilder.append(this.ugcEditCookie);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adTag=");
    localStringBuilder.append(this.adTag);
    localStringBuilder.append(", commentString='");
    localStringBuilder.append(this.commentString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", typeList=");
    localStringBuilder.append(this.typeList);
    localStringBuilder.append(", srcSize=");
    localStringBuilder.append(this.srcSize);
    localStringBuilder.append(", multiBiuStruct=");
    localStringBuilder.append(this.multiBiuStruct);
    localStringBuilder.append(", picDataList=");
    localStringBuilder.append(this.picDataList);
    localStringBuilder.append(", realList=");
    localStringBuilder.append(this.realList);
    localStringBuilder.append(", adapterList=");
    localStringBuilder.append(this.adapterList);
    localStringBuilder.append(", richTextContent='");
    localStringBuilder.append(this.richTextContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", answerTitle='");
    localStringBuilder.append(this.answerTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleType=");
    localStringBuilder.append(this.articleType);
    localStringBuilder.append(", originFrom=");
    localStringBuilder.append(this.originFrom);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.topicId);
    paramParcel.writeString(this.ugcEditCookie);
    paramParcel.writeInt(this.adTag);
    paramParcel.writeString(this.commentString);
    paramParcel.writeList(this.typeList);
    paramParcel.writeInt(this.srcSize);
    paramParcel.writeTypedList(this.multiBiuStruct);
    paramParcel.writeTypedList(this.picDataList);
    paramParcel.writeTypedList(this.realList);
    paramParcel.writeTypedList(this.adapterList);
    paramParcel.writeString(this.richTextContent);
    paramParcel.writeString(this.answerTitle);
    paramParcel.writeInt(this.articleType);
    paramParcel.writeInt(this.originFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent
 * JD-Core Version:    0.7.0.1
 */