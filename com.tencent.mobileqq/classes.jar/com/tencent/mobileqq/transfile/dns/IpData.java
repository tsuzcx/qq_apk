package com.tencent.mobileqq.transfile.dns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class IpData
  implements Parcelable
{
  public static final Parcelable.Creator<IpData> CREATOR = new IpData.1();
  public static final String IP = "i";
  public static final int IPV4 = 1;
  public static final int IPV6 = 28;
  public static final String PORT = "p";
  public static final String TYPE = "t";
  public int mFailedCount;
  public String mIp;
  public int mPort;
  public int mType;
  
  public IpData() {}
  
  protected IpData(Parcel paramParcel)
  {
    this.mIp = paramParcel.readString();
    this.mPort = paramParcel.readInt();
    this.mFailedCount = paramParcel.readInt();
    this.mType = paramParcel.readInt();
  }
  
  public IpData(String paramString, int paramInt1, int paramInt2)
  {
    this.mIp = paramString;
    this.mPort = paramInt1;
    this.mType = paramInt2;
  }
  
  public static String parse(List<IpData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IpData localIpData = (IpData)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localIpData.mIp);
        if (localIpData.mPort != 80) {
          localJSONObject.put("p", localIpData.mPort);
        }
        if (localIpData.mType != 1) {
          localJSONObject.put("t", localIpData.mType);
        }
        localJSONArray.put(localJSONObject);
      }
      paramList = localJSONArray.toString();
      return paramList;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<IpData> unParse(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList.add(new IpData(localJSONObject.getString("i"), localJSONObject.optInt("p", 80), localJSONObject.optInt("t", 1)));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mIp);
    paramParcel.writeInt(this.mPort);
    paramParcel.writeInt(this.mFailedCount);
    paramParcel.writeInt(this.mType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.IpData
 * JD-Core Version:    0.7.0.1
 */