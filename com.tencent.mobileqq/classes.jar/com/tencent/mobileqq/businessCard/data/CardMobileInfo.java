package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardMobileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardMobileInfo> CREATOR = new CardMobileInfo.1();
  public String a;
  public String b;
  public boolean c;
  public String d;
  public String e;
  
  public CardMobileInfo() {}
  
  public CardMobileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public static String a(List<CardMobileInfo> paramList)
  {
    JSONArray localJSONArray1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localJSONArray1 = new JSONArray();
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          CardMobileInfo localCardMobileInfo = (CardMobileInfo)paramList.next();
          JSONArray localJSONArray2 = new JSONArray();
          localJSONArray2.put(0, localCardMobileInfo.a);
          localJSONArray2.put(1, localCardMobileInfo.e);
          localJSONArray2.put(2, localCardMobileInfo.c);
          localJSONArray2.put(3, localCardMobileInfo.d);
          localJSONArray2.put(4, localCardMobileInfo.b);
          localJSONArray1.put(localJSONArray2);
        }
        return localJSONArray1.toString();
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
    return "";
  }
  
  public static List<CardMobileInfo> a(String paramString)
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
        JSONArray localJSONArray = (JSONArray)paramString.get(i);
        CardMobileInfo localCardMobileInfo = new CardMobileInfo();
        localCardMobileInfo.a = ((String)localJSONArray.get(0));
        localCardMobileInfo.e = localJSONArray.getString(1);
        localCardMobileInfo.c = localJSONArray.getBoolean(2);
        localCardMobileInfo.d = localJSONArray.getString(3);
        localCardMobileInfo.b = ((String)localJSONArray.get(4));
        localArrayList.add(localCardMobileInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackMoblieInfos has exception");
      }
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CardMobileInfo{, isFriend=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("bindqq='");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",nickName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mobile='");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",format= ");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardMobileInfo
 * JD-Core Version:    0.7.0.1
 */