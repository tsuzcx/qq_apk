package dov.com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryFollowCaptureResManager
{
  private static QQStoryFollowCaptureResManager jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager;
  private static File jdField_a_of_type_JavaIoFile;
  private static String jdField_a_of_type_JavaLangString = "QQStoryFollowCaptureResManager";
  private static File jdField_b_of_type_JavaIoFile = a(jdField_a_of_type_JavaIoFile, "follow_capture_template");
  private static File c = a(jdField_a_of_type_JavaIoFile, "follow_capture_original_video");
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager = null;
    jdField_a_of_type_JavaIoFile = a(new File(PathUtils.d), "qqstroy_follow_capture");
    c();
  }
  
  public static QQStoryFollowCaptureResManager a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager == null) {
        jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager = new QQStoryFollowCaptureResManager();
      }
      return jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager;
    }
    finally {}
  }
  
  private static File a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  private static List<File> a(File paramFile)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isFile()) {
        return localArrayList1;
      }
      ArrayList localArrayList2 = new ArrayList();
      paramFile = paramFile.listFiles();
      int i;
      if ((paramFile != null) && (paramFile.length != 0))
      {
        int j = paramFile.length;
        i = 0;
        while (i < j)
        {
          localArrayList2.add(paramFile[i]);
          i += 1;
        }
      }
      while (localArrayList2.size() > 0)
      {
        paramFile = (File)localArrayList2.remove(0);
        localArrayList1.add(paramFile);
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          i = 0;
          while (i < paramFile.length)
          {
            localArrayList2.add(paramFile[i]);
            i += 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private static void a(File paramFile, boolean paramBoolean)
  {
    List localList = a(paramFile);
    int i = localList.size() - 1;
    while (i >= 0)
    {
      ((File)localList.get(i)).delete();
      i -= 1;
    }
    if (paramBoolean) {
      paramFile.delete();
    }
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramString.optBoolean("enableFollowCapture"));
        this.jdField_b_of_type_JavaLangString = paramString.optString("guideVideoUrl");
        return true;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "parse follow capture config error", paramString);
        }
        return false;
      }
      finally
      {
        if (this.jdField_a_of_type_JavaLangBoolean == null) {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        }
      }
    }
  }
  
  public static void b()
  {
    a(c, false);
    a(jdField_b_of_type_JavaIoFile, false);
  }
  
  private static boolean b(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "template zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = FileUtils.c(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label70;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label70:
      bool = false;
    }
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (b(paramString1, paramString2)) {
      return c(paramString1, paramString2);
    }
    paramString1.delete();
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "template zip md5 is wrong");
    }
    return false;
  }
  
  private static void c()
  {
    File localFile = new File(jdField_a_of_type_JavaIoFile, ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "create .nomedia file error");
    }
  }
  
  private static boolean c(File paramFile, String paramString)
  {
    try
    {
      paramString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + paramString + File.separator;
      a(new File(paramString), true);
      File localFile = new File(paramString + "complete");
      if (localFile.exists()) {
        return true;
      }
      ZipUtils.unZipFile(paramFile, paramString);
      localFile.createNewFile();
      return true;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "uncompress template zip file error", paramFile);
      }
    }
    return false;
  }
  
  public void a()
  {
    try
    {
      StoryConfigManager.d();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(StoryConfigManager.d());
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!a(paramString)) {
      return false;
    }
    StoryConfigManager.e(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QQStoryFollowCaptureResManager
 * JD-Core Version:    0.7.0.1
 */