package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

class DiskLoader
  extends Loader
{
  private static File jdField_a_of_type_JavaIoFile;
  private final int jdField_a_of_type_Int;
  
  DiskLoader(String paramString, int paramInt)
  {
    super(paramString);
    jdField_a_of_type_JavaLangString = "DiskLoader";
    this.jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getCacheDir(), "/poi/");
    jdField_a_of_type_JavaIoFile.mkdirs();
  }
  
  private void a()
  {
    Object localObject1 = null;
    int i = a();
    if (i > this.jdField_a_of_type_Int - 1)
    {
      int k = i - this.jdField_a_of_type_Int + 1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] handlerCacheSizeLimit. curCacheSize: " + i + " mDiskCacheSizeLimit: " + this.jdField_a_of_type_Int + " overFlowSize: " + k);
      }
      i = 0;
      while (i < k)
      {
        File[] arrayOfFile = jdField_a_of_type_JavaIoFile.listFiles();
        int m = arrayOfFile.length;
        int j = 0;
        if (j < m)
        {
          File localFile = arrayOfFile[j];
          Object localObject2;
          if (localObject1 == null) {
            localObject2 = localFile;
          }
          for (;;)
          {
            j += 1;
            localObject1 = localObject2;
            break;
            localObject2 = localFile;
            if (localFile.lastModified() >= localObject1.lastModified()) {
              localObject2 = localObject1;
            }
          }
        }
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] handlerCacheSizeLimit. delete: " + localObject1.getAbsolutePath() + " lastModified: " + localObject1.lastModified());
          }
          localObject1.delete();
        }
        i += 1;
      }
    }
  }
  
  private void a(PoiBean paramPoiBean, File paramFile)
  {
    Gson localGson = new GsonBuilder().create();
    paramFile = new FileWriter(paramFile);
    localGson.toJson(paramPoiBean, paramFile);
    paramFile.flush();
    paramFile.close();
  }
  
  public int a()
  {
    String[] arrayOfString = jdField_a_of_type_JavaIoFile.list();
    if (arrayOfString == null) {
      return 0;
    }
    return arrayOfString.length;
  }
  
  PoiBean a(File paramFile)
  {
    return (PoiBean)new GsonBuilder().create().fromJson(new FileReader(paramFile), PoiBean.class);
  }
  
  public LatLng a(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = paramFile.split("-");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] disk getLatLngFromPoiFile file: " + paramFile + " array: " + Arrays.toString(arrayOfString));
    }
    if (arrayOfString.length >= 3) {
      try
      {
        paramFile = new LatLng(Double.parseDouble(arrayOfString[1]), Double.parseDouble(arrayOfString[2]));
        return paramFile;
      }
      catch (NumberFormatException paramFile)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] PoiCache Parse File To LatLng Error", paramFile);
        }
      }
    }
    return null;
  }
  
  public File a(LatLng paramLatLng)
  {
    return new File(jdField_a_of_type_JavaIoFile, "poi-" + paramLatLng.latitude + "-" + paramLatLng.longitude);
  }
  
  public void a(LatLng paramLatLng, int paramInt, PoiBean paramPoiBean)
  {
    if (a(paramLatLng, paramInt, new DiskLoader.1(this, paramLatLng, paramInt, paramPoiBean))) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskPut [fail already exist]. latLng: " + paramLatLng + " acceptAccuracy: " + paramInt + " poiBean: " + paramPoiBean);
      }
    }
    do
    {
      return;
      a();
      try
      {
        a("diskPut", paramPoiBean);
        File localFile = a(paramLatLng);
        localFile.createNewFile();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskPut. latLng: " + paramLatLng + " cacheFile: " + localFile.getName() + " poiBean: " + paramPoiBean);
        }
        a(paramPoiBean, localFile);
        return;
      }
      catch (IOException paramLatLng) {}
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] PoiCache diskPut Error", paramLatLng);
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    File[] arrayOfFile = jdField_a_of_type_JavaIoFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskGet. latLng: " + paramLatLng + " no cache files found");
      }
      return false;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if (a(a(localFile), paramLatLng, paramInt)) {
        try
        {
          PoiBean localPoiBean = a(localFile);
          a("diskGet", localPoiBean);
          paramOnPoiLoadListener.a(localPoiBean);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskGet. latLng: " + paramLatLng + " result: " + localPoiBean);
          }
          if (!localFile.setLastModified(System.currentTimeMillis()))
          {
            long l1 = localFile.lastModified();
            a(localPoiBean, localFile);
            long l2 = localFile.lastModified();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskGet. poiCacheFile: " + localFile + " oldTime: " + l1 + " newTime: " + l2);
            }
          }
          return true;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] PoiCache diskGet Error", localException);
          }
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] diskGet. latLng: " + paramLatLng + " result: null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.DiskLoader
 * JD-Core Version:    0.7.0.1
 */