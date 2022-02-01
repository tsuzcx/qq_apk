package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

public class ShortVideoSoCompressUtil
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "backup" + File.separatorChar;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "backup", "trim_process_pic", "trim_process_pie" };
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static void a()
  {
    ThreadManager.excute(new ShortVideoSoCompressUtil.1(), 64, null, false);
  }
  
  public static void a(String paramString)
  {
    b("ShortVideoSoCompressUtil", paramString, null);
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramFile1.exists())
    {
      a("copySoToFilesDir: fileSource not exist");
      bool1 = false;
    }
    label193:
    long l1;
    long l2;
    do
    {
      String str3;
      String str2;
      do
      {
        return bool1;
        str3 = paramFile1.getAbsolutePath();
        String str1 = paramFile2.getAbsolutePath();
        bool1 = paramFile2.exists();
        a("copySoToFilesDir: srcPath=" + str3 + " dstPath=" + str1 + " dstExists=" + bool1);
        if (!bool1) {
          break label193;
        }
        str2 = ShortVideoSoManager.a(str3);
        a("copySoToFilesDir:[destFile exists] srcMd5=" + str2 + " srcPath=" + str3);
        str3 = ShortVideoSoManager.a(str1);
        a("copySoToFilesDir:[destFile exists] dstMd5=" + str3 + " dstPath=" + str1);
        if ((str2 == null) || ("".equals(str2))) {
          break;
        }
        bool1 = bool2;
      } while (str2.equalsIgnoreCase(str3));
      paramFile2.delete();
      l1 = paramFile1.length();
      FileUtils.b(paramFile1, paramFile2);
      l2 = paramFile2.length();
      a("copySoToFilesDir: soSize=" + l1 + " deSize=" + l2);
      bool1 = bool2;
    } while (l1 == l2);
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
    Object localObject3 = str1 + jdField_a_of_type_JavaLangString;
    a("VideoEnvironment:[uncompressZipSo]destDir=" + (String)localObject3);
    Object localObject2;
    File localFile;
    boolean bool1;
    for (;;)
    {
      try
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          localObject2 = new File((String)localObject3);
          if (!((File)localObject2).exists())
          {
            ((File)localObject2).mkdirs();
            localObject2 = (String)localObject3 + a("AVCodec");
            localFile = new File((String)localObject2);
            if (localFile.exists())
            {
              a("VideoEnvironment:[uncompressZipSo][has back file] path=" + (String)localObject2);
              localFile.delete();
            }
            FileUtils.a(paramString, (String)localObject3, false);
            bool1 = localFile.exists();
            a("VideoEnvironment:[end uncompressZipSo] existsFile=" + bool1);
            if (bool1) {
              break;
            }
            throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
          }
        }
        bool1 = b((String)localObject3, paramInt);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        b("ShortVideoSoCompressUtil", "VideoEnvironment:exp=", paramString);
        return true;
      }
      a("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=" + bool1);
      if (bool1) {
        return false;
      }
    }
    paramString = new File((String)localObject3 + "config_version");
    if (!paramString.exists()) {
      throw new RuntimeException("After uncompressZip,config_version file not exist...");
    }
    localObject3 = ShortVideoSoManager.a(ShortVideoSoManager.a(paramString));
    paramInt = ((ShortVideoSoManager.CfgParser)localObject3).a();
    if (paramInt != 0)
    {
      a("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + paramInt);
      throw new RuntimeException("createParser err=" + paramInt);
    }
    Object localObject4 = ShortVideoSoManager.a((String)localObject2);
    paramString = ((ShortVideoSoManager.CfgParser)localObject3).a();
    a("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject4);
    if (!paramString.equalsIgnoreCase((String)localObject4)) {
      throw new RuntimeException("[Md5 error] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject4);
    }
    long l1 = localFile.length();
    localObject4 = ((ShortVideoSoManager.CfgParser)localObject3).b().trim();
    localObject3 = ShortVideoSoManager.a(paramString, (String)localObject4);
    a("VideoEnvironment:[uncompressZipSo][trim] versionValid=" + (String)localObject4 + " soNewName=" + (String)localObject3);
    str1 = str1 + (String)localObject3;
    localObject4 = new File(str1);
    paramInt = 0;
    long l2;
    String str2;
    if (((File)localObject4).exists())
    {
      l2 = ((File)localObject4).length();
      str2 = ShortVideoSoManager.a(str1);
      if (!paramString.equalsIgnoreCase(str2))
      {
        bool1 = true;
        a("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2);
        if (bool1)
        {
          ((File)localObject4).delete();
          paramInt = 1;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (!localFile.renameTo((File)localObject4))
        {
          throw new RuntimeException("[renameTo error] destFilePath=" + (String)localObject2 + "  loadFilePath=" + str1);
          a("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2 + ",md5Cfg=" + paramString);
          bool1 = a("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", (String)localObject3);
          break label878;
        }
        l2 = ((File)localObject4).length();
        if (l1 == l2)
        {
          a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=" + l2 + "  soNewName=" + (String)localObject3);
          bool1 = a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", (String)localObject3);
        }
      }
      else
      {
        b();
        a();
        return bool1;
      }
      throw new RuntimeException("[length error] destLength=" + l1 + " loadLength=" + l2);
      label878:
      continue;
      bool1 = false;
      break;
      bool1 = false;
      paramInt = 1;
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = ShortVideoSoManager.a(paramString2);
    a(paramString1 + " saveSuccess=" + bool3);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool3 = ShortVideoSoManager.a(paramString2);
      a(paramString1 + " saveSuccessTwo=" + bool3);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = true;
        bool2 = ShortVideoSoManager.a("d000_1");
        a(paramString1 + "clearMemoryOK=" + bool2 + ",signature=" + paramString2);
      }
    }
    return bool1;
  }
  
  private static void b()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
    Object localObject2 = (String)localObject1 + jdField_a_of_type_JavaLangString;
    File localFile1 = new File((String)localObject2 + "trim_process_pie");
    File localFile2 = new File((String)localObject1 + "trim_process_pie");
    boolean bool = localFile1.exists();
    a("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=" + bool);
    if (bool) {
      a(localFile1, localFile2);
    }
    localObject2 = new File((String)localObject2 + "trim_process_pic");
    localObject1 = new File((String)localObject1 + "trim_process_pic");
    bool = ((File)localObject2).exists();
    a("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=" + bool);
    if (bool) {
      a((File)localObject2, (File)localObject1);
    }
  }
  
  private static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(jdField_a_of_type_ArrayOfJavaLangString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean b(String paramString, int paramInt)
  {
    paramString = new File(paramString + "config_version");
    if (!paramString.exists()) {}
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return false;
            paramString = ShortVideoSoManager.a(paramString);
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.trim();
          str = VideoEnvironment.getShortVideoSoLibName();
        } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)));
        paramString = ShortVideoSoManager.a(str);
      } while (paramString.a() != 0);
      paramString = paramString.b().trim();
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase("" + paramInt)));
    return VideoEnvironment.checkAndLoadAVCodec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil
 * JD-Core Version:    0.7.0.1
 */