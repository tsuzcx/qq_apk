package cooperation.qzone.report.lp;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReport_PicInfo_dc02153
  implements LpReportInfo
{
  private static String TAG = "LpReport_PicInfo_dc02153";
  static ExifInterface exif;
  static File imgLocation;
  public String client_time;
  public String exif_balance;
  public String exif_datetime;
  public long exif_flash;
  public long exif_height;
  public String exif_latitude;
  public String exif_longitude;
  public String exif_make;
  public String exif_model;
  public long exif_orientation;
  public long exif_width;
  public long exposure_index;
  public long operation_id;
  public long operation_type;
  public String pathInSDCard;
  public String photo_create_time;
  public String photo_id;
  public String photo_last_modify;
  public long photo_size;
  public String photo_tag1;
  public String photo_tag2;
  public String photo_tag3;
  public long recommend_index;
  public long uin;
  public long upload_index;
  
  private void handleExifCameraInfo()
  {
    try
    {
      imgLocation = new File(this.pathInSDCard);
      if (!TextUtils.isEmpty(this.pathInSDCard))
      {
        boolean bool = imgLocation.exists();
        if (bool) {}
      }
      else
      {
        return;
      }
      if (JpegExifReader.isCrashJpeg(this.pathInSDCard))
      {
        QLog.e(TAG, 4, "handleExifCameraInfo Found Crash Jpeg");
        return;
      }
      exif = new ExifInterface(this.pathInSDCard);
      this.exif_orientation = exif.getAttributeInt("Orientation", 0);
      this.exif_flash = exif.getAttributeInt("Flash", 0);
      this.exif_make = exif.getAttribute("Make");
      this.exif_model = exif.getAttribute("Model");
      this.exif_balance = String.valueOf(exif.getAttributeInt("WhiteBalance", 0));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 4, "handleExifCameraInfo error", localException);
      return;
    }
    finally
    {
      exif = null;
      imgLocation = null;
    }
  }
  
  private boolean isNeedRecheck()
  {
    int i;
    boolean bool1;
    int j;
    label43:
    boolean bool2;
    boolean bool3;
    int k;
    label72:
    int m;
    if (!TextUtils.isEmpty(this.photo_id))
    {
      i = 1;
      bool1 = TextUtils.isEmpty(this.exif_datetime);
      if ((!TextUtils.isEmpty(this.exif_latitude)) || (!TextUtils.isEmpty(this.exif_longitude))) {
        break label140;
      }
      j = 1;
      bool2 = TextUtils.isEmpty(this.photo_last_modify);
      bool3 = TextUtils.isEmpty(this.photo_create_time);
      if (this.photo_size != 0L) {
        break label145;
      }
      k = 1;
      if (this.exif_width != 0L) {
        break label150;
      }
      m = 1;
      label84:
      if (this.exif_height != 0L) {
        break label156;
      }
    }
    label140:
    label145:
    label150:
    label156:
    for (int n = 1;; n = 0)
    {
      if ((i == 0) || ((!bool1) && (j == 0) && (!bool2) && (!bool3) && (k == 0) && (m == 0) && (n == 0))) {
        break label162;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label43;
      k = 0;
      break label72;
      m = 0;
      break label84;
    }
    label162:
    return false;
  }
  
  private void recheck()
  {
    Object localObject3 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    localObject1 = localObject3;
    label44:
    do
    {
      try
      {
        str = this.photo_id;
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localBaseApplication = BaseApplication.getContext();
        if (localBaseApplication != null) {
          break label44;
        }
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Exception localException)
      {
        do
        {
          String str;
          BaseApplication localBaseApplication;
          localObject1 = localCursor1;
          QLog.e(TAG, 4, "recheck error", localException);
        } while (localCursor1 == null);
        localCursor1.close();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          break;
        }
        ((Cursor)localObject1).close();
      }
      return;
      localCursor1 = localCursor2;
      localObject1 = localObject3;
      localCursor2 = localBaseApplication.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "datetaken", "latitude", "longitude", "date_added", "date_modified", "_size", "width", "height" }, "_id= ?", new String[] { str }, "datetaken desc limit 1");
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      if (localCursor2.getCount() == 1)
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localCursor2.moveToNext();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        reset(localCursor2.getColumnIndexOrThrow("datetaken"), localCursor2.getColumnIndexOrThrow("latitude"), localCursor2.getColumnIndexOrThrow("longitude"), localCursor2.getColumnIndexOrThrow("date_added"), localCursor2.getColumnIndexOrThrow("date_modified"), localCursor2.getColumnIndexOrThrow("_size"), localCursor2.getColumnIndexOrThrow("width"), localCursor2.getColumnIndexOrThrow("height"), localCursor2);
      }
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      if (MachinelearningReport.getInstance().needReportExifCameraInfo())
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        handleExifCameraInfo();
      }
    } while (localCursor2 == null);
    localCursor2.close();
  }
  
  private void reset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    try
    {
      long l1 = paramCursor.getLong(paramInt1) / 1000L;
      float f1 = paramCursor.getFloat(paramInt3);
      float f2 = paramCursor.getFloat(paramInt2);
      long l2 = paramCursor.getLong(paramInt4);
      long l3 = paramCursor.getLong(paramInt5);
      long l4 = paramCursor.getLong(paramInt6);
      paramInt1 = paramCursor.getInt(paramInt7);
      paramInt2 = paramCursor.getInt(paramInt8);
      this.exif_datetime = String.valueOf(l1);
      this.exif_latitude = String.valueOf(f2 * 1000000.0F);
      this.exif_longitude = String.valueOf(f1 * 1000000.0F);
      this.photo_create_time = String.valueOf(l2);
      this.photo_last_modify = String.valueOf(l3);
      this.photo_size = l4;
      this.exif_width = paramInt1;
      this.exif_height = paramInt2;
      return;
    }
    catch (Exception paramCursor)
    {
      QLog.e(TAG, 4, "reset error", paramCursor);
    }
  }
  
  public String getSimpleInfo()
  {
    return null;
  }
  
  public void recheckIfNeed()
  {
    if (isNeedRecheck()) {
      recheck();
    }
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.uin <= 1000L)
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localHashMap.put("uin", str);
      if (!TextUtils.isEmpty(this.client_time)) {
        break label383;
      }
    }
    label383:
    for (String str = String.valueOf(System.currentTimeMillis());; str = this.client_time)
    {
      localHashMap.put("client_time", str);
      LpReportUtils.safePut(localHashMap, "photo_id", this.photo_id);
      localHashMap.put("photo_size", String.valueOf(this.photo_size));
      LpReportUtils.safePut(localHashMap, "photo_tag1", this.photo_tag1);
      LpReportUtils.safePut(localHashMap, "photo_tag2", this.photo_tag2);
      LpReportUtils.safePut(localHashMap, "photo_tag3", this.photo_tag3);
      LpReportUtils.safePut(localHashMap, "photo_create_time", this.photo_create_time);
      LpReportUtils.safePut(localHashMap, "photo_last_modify", this.photo_last_modify);
      localHashMap.put("operation_id", String.valueOf(this.operation_id));
      localHashMap.put("operation_type", String.valueOf(this.operation_type));
      localHashMap.put("upload_index", String.valueOf(this.upload_index));
      localHashMap.put("recommend_index", String.valueOf(this.recommend_index));
      localHashMap.put("exposure_index", String.valueOf(this.exposure_index));
      localHashMap.put("exif_orientation", String.valueOf(this.exif_orientation));
      LpReportUtils.safePut(localHashMap, "exif_datetime", this.exif_datetime);
      localHashMap.put("exif_flash", String.valueOf(this.exif_flash));
      LpReportUtils.safePut(localHashMap, "exif_latitude", this.exif_latitude);
      LpReportUtils.safePut(localHashMap, "exif_longitude", this.exif_longitude);
      localHashMap.put("exif_height", String.valueOf(this.exif_height));
      localHashMap.put("exif_width", String.valueOf(this.exif_width));
      LpReportUtils.safePut(localHashMap, "exif_make", this.exif_make);
      LpReportUtils.safePut(localHashMap, "exif_model", this.exif_model);
      LpReportUtils.safePut(localHashMap, "exif_balance", this.exif_balance);
      return localHashMap;
      str = String.valueOf(this.uin);
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = getClass().getDeclaredFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          localStringBuilder.append(arrayOfField[i].getName());
          Object localObject = arrayOfField[i].get(this);
          if (localObject != null) {
            localStringBuilder.append(":").append(localObject).append("\n");
          } else {
            localStringBuilder.append(":null \n");
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return localStringBuilder.toString();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_PicInfo_dc02153
 * JD-Core Version:    0.7.0.1
 */