package com.tencent.mobileqq.kandian.repo.db.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeishiRedDotInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiRedDotInfo> CREATOR = new WeishiRedDotInfo.1();
  private List<String> a = new ArrayList();
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  protected WeishiRedDotInfo(Parcel paramParcel)
  {
    this.a = paramParcel.createStringArrayList();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public WeishiRedDotInfo(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg;
      if (paramMessageForStructing.mAlgorithmIds != null) {
        this.c = paramMessageForStructing.mAlgorithmIds;
      }
      if (paramMessageForStructing.mStrategyIds != null) {
        this.d = paramMessageForStructing.mStrategyIds;
      }
      if (paramMessageForStructing.mMsgBrief != null) {
        this.b = paramMessageForStructing.mMsgBrief;
      }
      if (!TextUtils.isEmpty(paramMessageForStructing.mArticleIds)) {
        this.a.addAll(Arrays.asList(paramMessageForStructing.mArticleIds.split("\\|")));
      }
      if (paramMessageForStructing.mMsgActionData != null) {
        this.e = paramMessageForStructing.mMsgActionData;
      }
    }
  }
  
  public List<String> a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo
 * JD-Core Version:    0.7.0.1
 */