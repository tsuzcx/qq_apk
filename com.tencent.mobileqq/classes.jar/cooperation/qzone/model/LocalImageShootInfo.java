package cooperation.qzone.model;

import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LocalImageShootInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalImageShootInfo> CREATOR = new LocalImageShootInfo.1();
  private static final String TAG = "LocalImageShootInfo";
  public long captureTime;
  public GpsInfo4LocalImage gpsInfo;
  public long modifyTime;
  public String path;
  
  public LocalImageShootInfo() {}
  
  public LocalImageShootInfo(Parcel paramParcel)
  {
    this.captureTime = paramParcel.readLong();
    this.modifyTime = paramParcel.readLong();
    this.path = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      this.gpsInfo = new GpsInfo4LocalImage(paramParcel);
    }
  }
  
  private LocalImageShootInfo(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("file:///")) {
        str = paramString.replaceFirst("file://", "");
      }
    }
    paramString = new File(str);
    if ((!paramString.exists()) || (paramString.isDirectory())) {
      throw new Exception();
    }
    this.path = paramString.getAbsolutePath();
    this.modifyTime = paramString.lastModified();
  }
  
  public static boolean appendCaptureDate(LocalImageShootInfo paramLocalImageShootInfo)
  {
    if (paramLocalImageShootInfo == null) {}
    Object localObject;
    do
    {
      return false;
      try
      {
        if (JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.path))
        {
          paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
          QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
          return false;
        }
      }
      catch (Exception localException)
      {
        paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
        QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.", localException);
        return false;
      }
      localObject = new ExifInterface(paramLocalImageShootInfo.path).getAttribute("DateTime");
      if (localObject == null) {
        break;
      }
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject);
    } while (localObject == null);
    paramLocalImageShootInfo.captureTime = ((Date)localObject).getTime();
    return true;
    paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
    QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
    return false;
  }
  
  public static boolean appendGpsInfo(LocalImageShootInfo paramLocalImageShootInfo)
  {
    boolean bool = true;
    if (paramLocalImageShootInfo == null) {
      bool = false;
    }
    while (paramLocalImageShootInfo.gpsInfo != null) {
      return bool;
    }
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.path))
      {
        ExifInterface localExifInterface = new ExifInterface(paramLocalImageShootInfo.path);
        float[] arrayOfFloat = new float[2];
        if (localExifInterface.getLatLong(arrayOfFloat))
        {
          paramLocalImageShootInfo.gpsInfo = new GpsInfo4LocalImage(arrayOfFloat[0], arrayOfFloat[1]);
          return true;
        }
      }
    }
    catch (Exception paramLocalImageShootInfo)
    {
      paramLocalImageShootInfo.printStackTrace();
    }
    return false;
  }
  
  public static LocalImageShootInfo createFrom(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label21;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        label21:
        paramString = new LocalImageShootInfo(paramString);
        localObject1 = paramString;
        if (paramString == null) {
          continue;
        }
        appendCaptureDate(paramString);
        appendGpsInfo(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject2;
        }
      }
    }
  }
  
  public static GpsInfo4LocalImage getGpsInfoForVideo(MediaMetadataRetriever paramMediaMetadataRetriever, String paramString)
  {
    int i = 0;
    if ((paramMediaMetadataRetriever == null) || (paramString == null)) {
      return null;
    }
    char[] arrayOfChar;
    int m;
    int k;
    char c;
    try
    {
      paramMediaMetadataRetriever.setDataSource(paramString);
      if (Build.VERSION.SDK_INT < 15) {
        break label152;
      }
      paramString = paramMediaMetadataRetriever.extractMetadata(23);
      if (paramString == null) {
        break label152;
      }
      try
      {
        localArrayList = new ArrayList(3);
        localStringBuilder = new StringBuilder();
        arrayOfChar = paramString.toCharArray();
        m = arrayOfChar.length;
        k = 0;
      }
      catch (NumberFormatException paramString) {}
      int j = i;
      if (localStringBuilder.length() > 0)
      {
        localArrayList.add(Double.valueOf(Double.parseDouble(localStringBuilder.toString())));
        localStringBuilder.setLength(0);
        j = i + 1;
      }
      localStringBuilder.append(c);
      i = j;
    }
    catch (Throwable paramString)
    {
      ArrayList localArrayList;
      label124:
      do
      {
        StringBuilder localStringBuilder;
        for (;;)
        {
          QLog.e("LocalImageShootInfo", 2, "getGpsInfoForVideo fail : " + paramString.getMessage());
          paramMediaMetadataRetriever.release();
        }
        if (localStringBuilder.length() > 0) {
          localArrayList.add(Double.valueOf(Double.parseDouble(localStringBuilder.toString())));
        }
      } while ((localArrayList == null) || (localArrayList.size() < 2));
      label152:
      paramString = new GpsInfo4LocalImage(((Double)localArrayList.get(0)).floatValue(), ((Double)localArrayList.get(1)).floatValue());
      return paramString;
    }
    finally
    {
      paramMediaMetadataRetriever.release();
    }
    if ((Character.isDigit(c)) || (c == '.'))
    {
      localStringBuilder.append(c);
      break label354;
      paramMediaMetadataRetriever.release();
      return null;
    }
    else
    {
      QLog.e("LocalImageShootInfo", 2, "Can not under stand the location string: " + paramString + " !");
    }
    for (;;)
    {
      if (k < m)
      {
        c = arrayOfChar[k];
        if (i < 2)
        {
          if ((c == '+') || (c == '-') || (c == '\n')) {
            break;
          }
          if (c != 0) {
            break label124;
          }
          break;
          label354:
          k += 1;
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof LocalImageShootInfo));
    paramObject = (LocalImageShootInfo)paramObject;
    if ((this.captureTime == paramObject.captureTime) && (this.gpsInfo.equals(paramObject))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.captureTime);
    paramParcel.writeLong(this.modifyTime);
    paramParcel.writeString(this.path);
    if (this.gpsInfo != null)
    {
      paramParcel.writeInt(1);
      this.gpsInfo.writeToParcel(paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.LocalImageShootInfo
 * JD-Core Version:    0.7.0.1
 */