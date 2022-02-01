package cooperation.qqcircle.lbs.util;

import FileUpload.stPoi;
import android.os.Parcel;
import android.os.Parcelable;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class LbsUtils
{
  public static final String TAG = "LbsUtils";
  
  public static String MD5(String paramString)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    for (;;)
    {
      Object localObject;
      int k;
      int j;
      try
      {
        paramString = paramString.getBytes();
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString);
        paramString = ((MessageDigest)localObject).digest();
        k = paramString.length;
        localObject = new char[k * 2];
        j = 0;
      }
      catch (Exception paramString)
      {
        return "";
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < k)
      {
        int m = paramString[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
  
  public static byte[] addHeader(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeShort(65535);
      localDataOutputStream.writeShort(1);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label75:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label75;
      }
    }
  }
  
  public static long byteToLong(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static long dayToMS(int paramInt)
  {
    return 86400000L * paramInt;
  }
  
  public static long getCurrentTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1970, 0, 1, 8, 0, 0);
    return (Calendar.getInstance().getTimeInMillis() - localCalendar.getTimeInMillis()) / 1000L;
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = rad(paramDouble1 / 1000000.0D);
    paramDouble3 = rad(paramDouble3 / 1000000.0D);
    paramDouble2 = rad(paramDouble2 / 1000000.0D);
    paramDouble4 = rad(paramDouble4 / 1000000.0D);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 1000.0D;
  }
  
  public static int getGeoCacheTime()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheTime", 7);
  }
  
  public static stPoi getStPoi4PoiInfo(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo == null) {
      paramPoiInfo = null;
    }
    stPoi localstPoi;
    do
    {
      return paramPoiInfo;
      localstPoi = new stPoi();
      if (paramPoiInfo.gpsInfo != null)
      {
        localstPoi.poi_x = String.valueOf(paramPoiInfo.gpsInfo.lon / 1000000.0D);
        localstPoi.poi_y = String.valueOf(paramPoiInfo.gpsInfo.lat / 1000000.0D);
      }
      localstPoi.poi_name = paramPoiInfo.poiName;
      localstPoi.poi_address = paramPoiInfo.address;
      localstPoi.poi_id = paramPoiInfo.poiId;
      localstPoi.show_poi = paramPoiInfo.show_poi;
      if (localstPoi.poi_name == null) {
        localstPoi.poi_name = "";
      }
      if (localstPoi.poi_address == null) {
        localstPoi.poi_address = "";
      }
      paramPoiInfo = localstPoi;
    } while (localstPoi.poi_id != null);
    localstPoi.poi_id = "";
    return localstPoi;
  }
  
  public static LbsDataV2.GpsInfo gpsInfoToGpsInfo(GpsInfo4LocalImage paramGpsInfo4LocalImage)
  {
    if (paramGpsInfo4LocalImage == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.gpsType = 0;
    localGpsInfo.alt = 0;
    localGpsInfo.lat = ((int)(paramGpsInfo4LocalImage.latitude * 1000000.0F));
    localGpsInfo.lon = ((int)(paramGpsInfo4LocalImage.longtitude * 1000000.0F));
    return localGpsInfo;
  }
  
  public static ArrayList<LbsDataV2.GpsInfo> gpsInfoToGpsInfoList(List<GpsInfo4LocalImage> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(gpsInfoToGpsInfo((GpsInfo4LocalImage)paramList.next()));
    }
    return localArrayList;
  }
  
  public static boolean gpsIsValid(LbsDataV2.GpsInfo paramGpsInfo)
  {
    return (paramGpsInfo != null) && (paramGpsInfo.isValid());
  }
  
  public static byte[] marshall(Parcelable paramParcelable)
  {
    Object localObject2 = null;
    if (paramParcelable == null) {
      return null;
    }
    Object localObject1 = localObject2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localObject2;
      paramParcelable.writeToParcel(localParcel, 0);
      localObject1 = localObject2;
      paramParcelable = localParcel.marshall();
      localObject1 = paramParcelable;
      localParcel.recycle();
      return paramParcelable;
    }
    catch (Exception paramParcelable) {}
    return localObject1;
  }
  
  public static double rad(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static Parcel unmarshall(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.util.LbsUtils
 * JD-Core Version:    0.7.0.1
 */