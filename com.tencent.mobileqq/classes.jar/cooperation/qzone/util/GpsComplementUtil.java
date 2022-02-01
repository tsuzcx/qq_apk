package cooperation.qzone.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class GpsComplementUtil
{
  private static final String TAG = "ExifComplement";
  
  public static boolean complementByDB(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) == 0) || (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0)) {
      return false;
    }
    if (JpegExifReader.isCrashJpeg(paramString)) {
      return false;
    }
    ExifInterface localExifInterface;
    try
    {
      localExifInterface = new ExifInterface(paramString);
      if (localExifInterface == null) {
        return false;
      }
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    QLog.i("ExifComplement", 2, "complementByDB destPath:" + paramString + "\nlat: " + paramDouble2 + " lng:" + paramDouble1 + "\nTAG_GPS_LATITUDE:" + localExifInterface.getAttribute("GPSLatitude"));
    if ((paramDouble1 == 0.0D) || (paramDouble2 == 0.0D) || (!TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude")))) {
      return false;
    }
    QZLog.i("ExifComplement", 2, "[Complement] complementByDB gps lat: " + paramDouble2 + " lng:" + paramDouble1);
    localExifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(paramDouble2));
    localExifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(paramDouble1));
    if (paramDouble1 > 0.0D)
    {
      paramString = "E";
      localExifInterface.setAttribute("GPSLongitudeRef", paramString);
      if (paramDouble2 <= 0.0D) {
        break label320;
      }
    }
    label320:
    for (paramString = "N";; paramString = "S")
    {
      localExifInterface.setAttribute("GPSLatitudeRef", paramString);
      localExifInterface.setAttribute("DateTime", new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
      try
      {
        localExifInterface.saveAttributes();
        paramString = new HashMap();
        paramString.put("gpsPicEdit", String.valueOf(1));
        paramString.put("gpsComplementByDB", String.valueOf(1));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "gpsComplement", true, 0L, 0L, paramString, null, true);
        return true;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = "W";
      break;
    }
    return false;
  }
  
  public static boolean complementByExif(String paramString1, String paramString2)
  {
    if ((QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) == 0) || (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0)) {
      return false;
    }
    if ((JpegExifReader.isCrashJpeg(paramString2)) || (JpegExifReader.isCrashJpeg(paramString1))) {
      return false;
    }
    ExifInterface localExifInterface1;
    ExifInterface localExifInterface2;
    try
    {
      localExifInterface1 = new ExifInterface(paramString2);
      localExifInterface2 = new ExifInterface(paramString1);
      if ((localExifInterface2 == null) || (localExifInterface1 == null)) {
        return false;
      }
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    QLog.i("ExifComplement", 2, "complementByExif srcPath:" + paramString1 + "\ndestPath:" + paramString2 + "\nTAG_GPS_LONGITUDE:" + localExifInterface1.getAttribute("GPSLongitude"));
    paramString1 = new HashMap();
    if ((localExifInterface2 != null) && (TextUtils.isEmpty(localExifInterface1.getAttribute("GPSLongitude"))))
    {
      paramString2 = localExifInterface2.getAttribute("GPSLongitude");
      String str = localExifInterface2.getAttribute("GPSLatitude");
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str)))
      {
        QZLog.i("ExifComplement", 2, "[Complement] complementByExif lat: " + str + " lng:" + paramString2);
        localExifInterface1.setAttribute("GPSLongitude", paramString2);
        localExifInterface1.setAttribute("GPSLatitude", str);
        if (localExifInterface2.getAttribute("GPSLongitudeRef") != null) {
          localExifInterface1.setAttribute("GPSLongitudeRef", localExifInterface2.getAttribute("GPSLongitudeRef"));
        }
        if (localExifInterface2.getAttribute("GPSLatitudeRef") != null) {
          localExifInterface1.setAttribute("GPSLatitudeRef", localExifInterface2.getAttribute("GPSLatitudeRef"));
        }
        if (localExifInterface2.getAttribute("DateTime") != null) {
          localExifInterface1.setAttribute("DateTime", localExifInterface2.getAttribute("DateTime"));
        }
        if (localExifInterface2.getAttribute("Make") != null) {
          localExifInterface1.setAttribute("Make", localExifInterface2.getAttribute("Make"));
        }
        if (localExifInterface2.getAttribute("Model") != null) {
          localExifInterface1.setAttribute("Model", localExifInterface2.getAttribute("Model"));
        }
        try
        {
          localExifInterface1.saveAttributes();
          paramString1.put("gpsPicEdit", String.valueOf(1));
          paramString1.put("gpsComplementByExif", String.valueOf(1));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "gpsComplement", true, 0L, 0L, paramString1, null, true);
          return true;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return false;
        }
      }
    }
    return false;
  }
  
  public static boolean complementByLocal(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) == 0) || (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0)) {
      return false;
    }
    if ((paramDouble1 == 4.9E-324D) || (paramDouble2 == 4.9E-324D)) {
      return false;
    }
    if (!JpegExifReader.isCrashJpeg(paramString)) {
      for (;;)
      {
        try
        {
          ExifInterface localExifInterface = new ExifInterface(paramString);
          QLog.i("ExifComplement", 2, "complementByLocal path:" + paramString + "\nlat: " + paramDouble2 + " lng:" + paramDouble1 + "\nTAG_GPS_LATITUDE:" + localExifInterface.getAttribute("GPSLatitude"));
          if ((localExifInterface == null) || (!TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude")))) {
            break;
          }
          QLog.i("ExifComplement", 2, "[Complement] complementByLocal lat: " + paramDouble2 + " lng:" + paramDouble1);
          localExifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(paramDouble2));
          localExifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(paramDouble1));
          if (paramDouble1 > 0.0D)
          {
            paramString = "E";
            localExifInterface.setAttribute("GPSLongitudeRef", paramString);
            if (paramDouble2 <= 0.0D) {
              break label320;
            }
            paramString = "N";
            localExifInterface.setAttribute("GPSLatitudeRef", paramString);
            localExifInterface.setAttribute("DateTime", new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
          }
          paramString = "W";
        }
        catch (IOException paramString)
        {
          try
          {
            localExifInterface.saveAttributes();
            paramString = new HashMap();
            paramString.put("gpsCapturePic", String.valueOf(1));
            paramString.put("gpsComplementByLocal", String.valueOf(1));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "gpsComplement", true, 0L, 0L, paramString, null, true);
            return true;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return false;
          }
          paramString = paramString;
          paramString.printStackTrace();
          return false;
        }
        continue;
        label320:
        paramString = "S";
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.GpsComplementUtil
 * JD-Core Version:    0.7.0.1
 */