package dov.com.tencent.mobileqq.shortvideo.common;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import java.io.File;

public class GloableValue
{
  public static int a;
  public static long a;
  public static Context a;
  public static String a;
  public static final int[] a;
  public static int b;
  private static String b;
  public static final int[] b;
  public static int c;
  private static String c;
  public static final int[] c;
  public static int d;
  private static String d;
  public static final int[] d;
  private static String e;
  public static final int[] e;
  private static String f;
  public static final int[] f;
  public static final int[] g = { 1280, 800 };
  public static final int[] h = { 720, 480 };
  
  static
  {
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.getContext();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 640;
    jdField_d_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.getContext().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = FileUtils.a();
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
      }
      return bool1;
    }
    Object localObject = StorageManager.a().jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "sdcardDirPath = empty");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + (String)localObject);
    }
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) || (!localFile.isDirectory()) || (!localFile.canWrite()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
      }
      return false;
    }
    jdField_a_of_type_JavaLangString = (String)localObject + File.separator + "trimvideo";
    localFile = new File(jdField_a_of_type_JavaLangString);
    bool1 = localFile.mkdirs();
    boolean bool2 = localFile.isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
    }
    if ((!bool1) && (!bool2)) {
      return false;
    }
    jdField_e_of_type_JavaLangString = (String)localObject + "/Product";
    jdField_d_of_type_JavaLangString = (String)localObject + "/Material";
    jdField_f_of_type_JavaLangString = jdField_d_of_type_JavaLangString + "/ProcessedMaterial";
    jdField_b_of_type_JavaLangString = (String)localObject + "/log.txt";
    jdField_c_of_type_JavaLangString = (String)localObject + File.separator + "Source";
    localObject = new File(jdField_c_of_type_JavaLangString);
    bool1 = ((File)localObject).mkdirs();
    bool2 = ((File)localObject).isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
    }
    return (bool1) || (bool2);
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)VideoEnvironment.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void c()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */