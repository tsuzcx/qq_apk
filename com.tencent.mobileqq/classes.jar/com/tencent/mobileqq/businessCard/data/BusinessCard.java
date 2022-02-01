package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqkr;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class BusinessCard
  extends Entity
  implements Parcelable
{
  public static final int CARD_SRC_AB = 3;
  public static final int CARD_SRC_BA = 4;
  public static final int CARD_SRC_FX = 2;
  public static final int CARD_SRC_SS = 1;
  public static final int CARD_SRC_ZL = 5;
  public static final Parcelable.Creator<BusinessCard> CREATOR = new aqkr();
  public static final int TYPE_CARD_ADD = 2;
  public static final int TYPE_CARD_MINE = 1;
  public static final int TYPE_CARD_MINE_ADD = 3;
  public static final int TYPE_CARD_OTHER = 0;
  @notColumn
  public CardOCRInfo OCRInfo;
  public String OCRInfoPacked;
  public String allPinyin;
  public String bindMobile;
  public String bindUin;
  @unique
  public String cardId;
  public String cardName;
  public int cardSrc = 1;
  public int cardType;
  public String company;
  @notColumn
  public List<String> descs = new ArrayList();
  public String descsPacked;
  @notColumn
  public String firstPinyin;
  public int lastUpdateTime;
  @notColumn
  public List<CardMobileInfo> mobileInfos = new ArrayList();
  @notColumn
  public List<String> mobilesNum = new ArrayList();
  public String moblieInfoPacked;
  public String mobulesNumPacked;
  public String picUrl;
  @notColumn
  public List<String> qqNum = new ArrayList();
  public String sortDesc;
  public String uinInfoPacked;
  @notColumn
  public List<CardUinInfo> uinInfos = new ArrayList();
  
  public BusinessCard() {}
  
  public BusinessCard(Parcel paramParcel)
  {
    this.cardId = paramParcel.readString();
    this.cardName = paramParcel.readString();
    this.company = paramParcel.readString();
    this.picUrl = paramParcel.readString();
    this.bindUin = paramParcel.readString();
    this.bindMobile = paramParcel.readString();
    this.cardSrc = paramParcel.readInt();
    paramParcel.readList(this.mobilesNum, getClass().getClassLoader());
    paramParcel.readList(this.qqNum, getClass().getClassLoader());
    paramParcel.readList(this.descs, getClass().getClassLoader());
    paramParcel.readList(this.mobileInfos, getClass().getClassLoader());
    paramParcel.readList(this.uinInfos, getClass().getClassLoader());
    this.OCRInfo = ((CardOCRInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    this.cardType = paramParcel.readInt();
    this.lastUpdateTime = paramParcel.readInt();
    this.sortDesc = paramParcel.readString();
  }
  
  public static String pack(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray.toString();
  }
  
  public static List<String> unPack(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramString.get(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CardMobileInfo getMobileInfoByMobile(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (this.mobileInfos != null)
    {
      Iterator localIterator = this.mobileInfos.iterator();
      while (localIterator.hasNext())
      {
        CardMobileInfo localCardMobileInfo = (CardMobileInfo)localIterator.next();
        if (paramString.equals(localCardMobileInfo.a)) {
          return localCardMobileInfo;
        }
      }
    }
    return null;
  }
  
  public void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.mobulesNumPacked)) {
      this.mobilesNum = unPack(this.mobulesNumPacked);
    }
    if (!TextUtils.isEmpty(this.descsPacked)) {
      this.descs = unPack(this.descsPacked);
    }
    if (!TextUtils.isEmpty(this.moblieInfoPacked)) {
      this.mobileInfos = CardMobileInfo.a(this.moblieInfoPacked);
    }
    if (!TextUtils.isEmpty(this.uinInfoPacked)) {
      this.uinInfos = CardUinInfo.a(this.uinInfoPacked);
    }
    if (!TextUtils.isEmpty(this.OCRInfoPacked)) {
      this.OCRInfo = CardOCRInfo.a(this.OCRInfoPacked);
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (this.mobilesNum.size() > 0) {
      this.mobulesNumPacked = pack(this.mobilesNum);
    }
    if (this.descs.size() > 0) {
      this.descsPacked = pack(this.descs);
    }
    if (this.mobileInfos.size() > 0) {
      this.moblieInfoPacked = CardMobileInfo.a(this.mobileInfos);
    }
    if (this.uinInfos.size() > 0) {
      this.uinInfoPacked = CardUinInfo.a(this.uinInfos);
    }
    this.OCRInfoPacked = CardOCRInfo.a(this.OCRInfo);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BusinessCard{").append("cardId=" + this.cardId).append(", bindUin=" + this.bindUin).append(", bindMobile = " + this.bindMobile).append("\n picUrl=" + this.picUrl).append("\n ocrInfo=" + this.OCRInfo).append("\n qqNum=" + this.qqNum).append("\n uinInfo=" + this.uinInfos).append("\n mobilesNum=" + this.mobilesNum).append("\n mobileInfo=" + this.mobileInfos).append(", cardType=" + this.cardType).append(", lastUpdateTime=" + this.lastUpdateTime).append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cardId);
    paramParcel.writeString(this.cardName);
    paramParcel.writeString(this.company);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeString(this.bindUin);
    paramParcel.writeString(this.bindMobile);
    paramParcel.writeInt(this.cardSrc);
    paramParcel.writeList(this.mobilesNum);
    paramParcel.writeList(this.qqNum);
    paramParcel.writeList(this.descs);
    paramParcel.writeList(this.mobileInfos);
    paramParcel.writeList(this.uinInfos);
    paramParcel.writeParcelable(this.OCRInfo, 0);
    paramParcel.writeInt(this.cardType);
    paramParcel.writeInt(this.lastUpdateTime);
    paramParcel.writeString(this.sortDesc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.BusinessCard
 * JD-Core Version:    0.7.0.1
 */