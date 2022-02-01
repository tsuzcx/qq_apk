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
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) != 0)
    {
      if (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0) {
        return false;
      }
      if (JpegExifReader.isCrashJpeg(paramString)) {
        return false;
      }
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("complementByDB destPath:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\nlat: ");
        localStringBuilder.append(paramDouble2);
        localStringBuilder.append(" lng:");
        localStringBuilder.append(paramDouble1);
        localStringBuilder.append("\nTAG_GPS_LATITUDE:");
        localStringBuilder.append(localExifInterface.getAttribute("GPSLatitude"));
        QLog.i("ExifComplement", 2, localStringBuilder.toString());
        if ((paramDouble1 != 0.0D) && (paramDouble2 != 0.0D))
        {
          if (!TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude"))) {
            return false;
          }
          paramString = new StringBuilder();
          paramString.append("[Complement] complementByDB gps lat: ");
          paramString.append(paramDouble2);
          paramString.append(" lng:");
          paramString.append(paramDouble1);
          QZLog.i("ExifComplement", 2, paramString.toString());
          localExifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(paramDouble2));
          localExifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(paramDouble1));
          if (paramDouble1 > 0.0D) {
            paramString = "E";
          } else {
            paramString = "W";
          }
          localExifInterface.setAttribute("GPSLongitudeRef", paramString);
          if (paramDouble2 > 0.0D) {
            paramString = "N";
          } else {
            paramString = "S";
          }
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
        }
        return false;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean complementByExif(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) != 0)
    {
      if (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0) {
        return false;
      }
      if (!JpegExifReader.isCrashJpeg(paramString2))
      {
        if (JpegExifReader.isCrashJpeg(paramString1)) {
          return false;
        }
        try
        {
          ExifInterface localExifInterface1 = new ExifInterface(paramString2);
          ExifInterface localExifInterface2 = new ExifInterface(paramString1);
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("complementByExif srcPath:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("\ndestPath:");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("\nTAG_GPS_LONGITUDE:");
          ((StringBuilder)localObject).append(localExifInterface1.getAttribute("GPSLongitude"));
          QLog.i("ExifComplement", 2, ((StringBuilder)localObject).toString());
          paramString1 = new HashMap();
          if (TextUtils.isEmpty(localExifInterface1.getAttribute("GPSLongitude")))
          {
            paramString2 = localExifInterface2.getAttribute("GPSLongitude");
            localObject = localExifInterface2.getAttribute("GPSLatitude");
            if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[Complement] complementByExif lat: ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" lng:");
              localStringBuilder.append(paramString2);
              QZLog.i("ExifComplement", 2, localStringBuilder.toString());
              localExifInterface1.setAttribute("GPSLongitude", paramString2);
              localExifInterface1.setAttribute("GPSLatitude", (String)localObject);
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
              }
            }
          }
          return false;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public static boolean complementByLocal(String paramString, double paramDouble1, double paramDouble2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneGpsComplement", 1) != 0)
    {
      if (LocalMultiProcConfig.getInt("Qzone_gps_switch", 1) == 0) {
        return false;
      }
      if (paramDouble1 != 4.9E-324D)
      {
        if (paramDouble2 == 4.9E-324D) {
          return false;
        }
        if (!JpegExifReader.isCrashJpeg(paramString)) {
          try
          {
            ExifInterface localExifInterface = new ExifInterface(paramString);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("complementByLocal path:");
            localStringBuilder.append(paramString);
            localStringBuilder.append("\nlat: ");
            localStringBuilder.append(paramDouble2);
            localStringBuilder.append(" lng:");
            localStringBuilder.append(paramDouble1);
            localStringBuilder.append("\nTAG_GPS_LATITUDE:");
            localStringBuilder.append(localExifInterface.getAttribute("GPSLatitude"));
            QLog.i("ExifComplement", 2, localStringBuilder.toString());
            if (TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude")))
            {
              paramString = new StringBuilder();
              paramString.append("[Complement] complementByLocal lat: ");
              paramString.append(paramDouble2);
              paramString.append(" lng:");
              paramString.append(paramDouble1);
              QLog.i("ExifComplement", 2, paramString.toString());
              localExifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(paramDouble2));
              localExifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(paramDouble1));
              if (paramDouble1 > 0.0D) {
                paramString = "E";
              } else {
                paramString = "W";
              }
              localExifInterface.setAttribute("GPSLongitudeRef", paramString);
              if (paramDouble2 > 0.0D) {
                paramString = "N";
              } else {
                paramString = "S";
              }
              localExifInterface.setAttribute("GPSLatitudeRef", paramString);
              localExifInterface.setAttribute("DateTime", new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
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
            }
            return false;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.GpsComplementUtil
 * JD-Core Version:    0.7.0.1
 */