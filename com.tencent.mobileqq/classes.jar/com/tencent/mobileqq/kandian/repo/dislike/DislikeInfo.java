package com.tencent.mobileqq.kandian.repo.dislike;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.ArrayList;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;

public class DislikeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DislikeInfo> CREATOR = new DislikeInfo.1();
  public String c;
  public int d;
  public long e;
  public String f;
  public byte[] g;
  
  public DislikeInfo() {}
  
  protected DislikeInfo(Parcel paramParcel)
  {
    this.d = paramParcel.readInt();
    this.e = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return "";
      }
      int j = paramArrayList.size();
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(PkgTools.toHexStr(((DislikeInfo)paramArrayList.get(i)).g));
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (i != j - 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("_");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        i += 1;
      }
    }
    return localObject2;
  }
  
  public static ArrayList<DislikeInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("_");
    int i = paramString.length;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramString.length)
    {
      articlesummary.DisLikeInfo localDisLikeInfo = new articlesummary.DisLikeInfo();
      DislikeInfo localDislikeInfo = new DislikeInfo();
      try
      {
        localDisLikeInfo.mergeFrom(PkgTools.hexToBytes(paramString[i]));
        localDislikeInfo.a(localDisLikeInfo);
        localArrayList.add(localDislikeInfo);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(articlesummary.DisLikeInfo paramDisLikeInfo)
  {
    this.c = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.d = paramDisLikeInfo.type.get();
    this.f = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.e = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.g = paramDisLikeInfo.toByteArray();
  }
  
  public void a(oidb_0x6cf.DisLikeInfo paramDisLikeInfo)
  {
    this.c = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.d = paramDisLikeInfo.type.get();
    this.f = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.e = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.g = paramDisLikeInfo.toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DislikeInfo{type=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", tagID=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", describe='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo
 * JD-Core Version:    0.7.0.1
 */