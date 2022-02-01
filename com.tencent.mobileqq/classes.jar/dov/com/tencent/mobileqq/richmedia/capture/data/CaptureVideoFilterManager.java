package dov.com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CaptureVideoFilterManager
{
  public static int a;
  public static Object a;
  public static final String a;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  public static String c;
  private static int d;
  public static String d;
  private static int jdField_e_of_type_Int = -1;
  private static final String jdField_e_of_type_JavaLangString;
  private static int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public CaptureRedDotConfig a;
  private CaptureVideoFilterManager.OnResourceDownloadListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener;
  HashMap<String, FilterDesc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList<FilterCategoryItem> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = PathUtils.jdField_d_of_type_JavaLangString + "pddata/prd/dov_capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    jdField_b_of_type_Boolean = false;
    jdField_e_of_type_JavaLangString = PathUtils.jdField_d_of_type_JavaLangString + "qav" + File.separator + "beauty" + File.separator;
    jdField_f_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "SKINCOLOR" + File.separator;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "lowlight";
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
  }
  
  private CaptureVideoFilterManager()
  {
    this.jdField_a_of_type_Boolean = false;
    GraphicRenderMgr.loadSo();
    String str = DeviceInfoUtil.h() + " " + DeviceInfoUtil.d();
    QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + str);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a()
  {
    File localFile = new File(jdField_d_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          jdField_a_of_type_Int = jdField_e_of_type_Int;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("CaptureVideoFilterManager", 2, "LowLightTools saveBitmap:" + localException);
        }
        jdField_a_of_type_Int = jdField_c_of_type_Int;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */