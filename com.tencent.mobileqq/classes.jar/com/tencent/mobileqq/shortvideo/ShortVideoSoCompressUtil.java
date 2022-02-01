package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

public class ShortVideoSoCompressUtil
{
  private static final String[] a = { "backup", "trim_process_pic", "trim_process_pie" };
  private static final Object b = new Object();
  private static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("backup");
    localStringBuilder.append(File.separatorChar);
    c = localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    b("ShortVideoSoCompressUtil", paramString, null);
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool2 = paramFile1.exists();
    boolean bool1 = false;
    if (!bool2)
    {
      a("copySoToFilesDir: fileSource not exist");
      return false;
    }
    String str2 = paramFile1.getAbsolutePath();
    String str1 = paramFile2.getAbsolutePath();
    bool2 = paramFile2.exists();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("copySoToFilesDir: srcPath=");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" dstPath=");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" dstExists=");
    ((StringBuilder)localObject).append(bool2);
    a(((StringBuilder)localObject).toString());
    if (bool2)
    {
      localObject = ShortVideoSoManager.b(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("copySoToFilesDir:[destFile exists] srcMd5=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" srcPath=");
      localStringBuilder.append(str2);
      a(localStringBuilder.toString());
      str2 = ShortVideoSoManager.b(str1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("copySoToFilesDir:[destFile exists] dstMd5=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" dstPath=");
      localStringBuilder.append(str1);
      a(localStringBuilder.toString());
      if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).equalsIgnoreCase(str2))) {
        return true;
      }
      paramFile2.delete();
    }
    long l1 = paramFile1.length();
    FileUtils.renameFile(paramFile1, paramFile2);
    long l2 = paramFile2.length();
    paramFile1 = new StringBuilder();
    paramFile1.append("copySoToFilesDir: soSize=");
    paramFile1.append(l1);
    paramFile1.append(" deSize=");
    paramFile1.append(l2);
    a(paramFile1.toString());
    if (l1 == l2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
    ??? = new StringBuilder();
    ((StringBuilder)???).append(str1);
    ((StringBuilder)???).append(c);
    String str2 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("VideoEnvironment:[uncompressZipSo]destDir=");
    ((StringBuilder)???).append(str2);
    a(((StringBuilder)???).toString());
    label1102:
    label1109:
    for (;;)
    {
      boolean bool2;
      try
      {
        synchronized (b)
        {
          Object localObject2 = new File(str2);
          bool1 = ((File)localObject2).exists();
          bool2 = false;
          if (!bool1)
          {
            ((File)localObject2).mkdirs();
          }
          else
          {
            bool1 = b(str2, paramInt);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=");
            ((StringBuilder)localObject2).append(bool1);
            a(((StringBuilder)localObject2).toString());
            if (bool1) {
              return false;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(d("AVCodec"));
          localObject2 = ((StringBuilder)localObject2).toString();
          File localFile = new File((String)localObject2);
          Object localObject3;
          if (localFile.exists())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("VideoEnvironment:[uncompressZipSo][has back file] path=");
            ((StringBuilder)localObject3).append((String)localObject2);
            a(((StringBuilder)localObject3).toString());
            localFile.delete();
          }
          FileUtils.uncompressZip(paramString, str2, false);
          bool1 = localFile.exists();
          paramString = new StringBuilder();
          paramString.append("VideoEnvironment:[end uncompressZipSo] existsFile=");
          paramString.append(bool1);
          a(paramString.toString());
          if (bool1)
          {
            paramString = new StringBuilder();
            paramString.append(str2);
            paramString.append("config_version");
            paramString = new File(paramString.toString());
            if (paramString.exists())
            {
              localObject3 = ShortVideoSoManager.d(ShortVideoSoManager.a(paramString));
              paramInt = ((ShortVideoSoManager.CfgParser)localObject3).e();
              if (paramInt == 0)
              {
                str2 = ShortVideoSoManager.b((String)localObject2);
                paramString = ((ShortVideoSoManager.CfgParser)localObject3).a();
                Object localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=");
                ((StringBuilder)localObject4).append(paramString);
                ((StringBuilder)localObject4).append(" md5Cmp=");
                ((StringBuilder)localObject4).append(str2);
                a(((StringBuilder)localObject4).toString());
                if (paramString.equalsIgnoreCase(str2))
                {
                  long l1 = localFile.length();
                  localObject3 = ((ShortVideoSoManager.CfgParser)localObject3).b().trim();
                  str2 = ShortVideoSoManager.a(paramString, (String)localObject3);
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("VideoEnvironment:[uncompressZipSo][trim] versionValid=");
                  ((StringBuilder)localObject4).append((String)localObject3);
                  ((StringBuilder)localObject4).append(" soNewName=");
                  ((StringBuilder)localObject4).append(str2);
                  a(((StringBuilder)localObject4).toString());
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(str1);
                  ((StringBuilder)localObject3).append(str2);
                  str1 = ((StringBuilder)localObject3).toString();
                  localObject3 = new File(str1);
                  if (!((File)localObject3).exists()) {
                    break label1102;
                  }
                  long l2 = ((File)localObject3).length();
                  localObject4 = ShortVideoSoManager.b(str1);
                  if (!paramString.equalsIgnoreCase((String)localObject4))
                  {
                    bool1 = true;
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=");
                    localStringBuilder.append(bool1);
                    localStringBuilder.append(" fileSize=");
                    localStringBuilder.append(l2);
                    localStringBuilder.append(" alreadySoMd5=");
                    localStringBuilder.append((String)localObject4);
                    a(localStringBuilder.toString());
                    if (bool1)
                    {
                      ((File)localObject3).delete();
                      break label1102;
                    }
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=");
                    localStringBuilder.append(bool1);
                    localStringBuilder.append(" fileSize=");
                    localStringBuilder.append(l2);
                    localStringBuilder.append(" alreadySoMd5=");
                    localStringBuilder.append((String)localObject4);
                    localStringBuilder.append(",md5Cfg=");
                    localStringBuilder.append(paramString);
                    a(localStringBuilder.toString());
                    bool1 = a("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", str2);
                    paramInt = 0;
                    if (paramInt == 0) {
                      break label1109;
                    }
                    if (localFile.renameTo((File)localObject3))
                    {
                      l2 = ((File)localObject3).length();
                      if (l1 == l2)
                      {
                        paramString = new StringBuilder();
                        paramString.append("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=");
                        paramString.append(l2);
                        paramString.append("  soNewName=");
                        paramString.append(str2);
                        a(paramString.toString());
                        bool1 = a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", str2);
                      }
                      else
                      {
                        paramString = new StringBuilder();
                        paramString.append("[length error] destLength=");
                        paramString.append(l1);
                        paramString.append(" loadLength=");
                        paramString.append(l2);
                        throw new RuntimeException(paramString.toString());
                      }
                    }
                    else
                    {
                      paramString = new StringBuilder();
                      paramString.append("[renameTo error] destFilePath=");
                      paramString.append((String)localObject2);
                      paramString.append("  loadFilePath=");
                      paramString.append(str1);
                      throw new RuntimeException(paramString.toString());
                    }
                    c();
                    b();
                    return bool1;
                  }
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("[Md5 error] md5Cfg=");
                  ((StringBuilder)localObject2).append(paramString);
                  ((StringBuilder)localObject2).append(" md5Cmp=");
                  ((StringBuilder)localObject2).append(str2);
                  throw new RuntimeException(((StringBuilder)localObject2).toString());
                }
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=");
                paramString.append(paramInt);
                a(paramString.toString());
                paramString = new StringBuilder();
                paramString.append("createParser err=");
                paramString.append(paramInt);
                throw new RuntimeException(paramString.toString());
              }
            }
            else
            {
              throw new RuntimeException("After uncompressZip,config_version file not exist...");
            }
          }
          else
          {
            throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
          }
        }
        bool1 = false;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        b("ShortVideoSoCompressUtil", "VideoEnvironment:exp=", paramString);
        return true;
      }
      continue;
      paramInt = 1;
      boolean bool1 = bool2;
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool = ShortVideoSoManager.a(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" saveSuccess=");
    localStringBuilder.append(bool);
    a(localStringBuilder.toString());
    if (!bool)
    {
      bool = ShortVideoSoManager.a(paramString2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" saveSuccessTwo=");
      localStringBuilder.append(bool);
      a(localStringBuilder.toString());
      if (!bool)
      {
        bool = ShortVideoSoManager.a("d000_1");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("clearMemoryOK=");
        localStringBuilder.append(bool);
        localStringBuilder.append(",signature=");
        localStringBuilder.append(paramString2);
        a(localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
  
  private static void b()
  {
    ThreadManager.excute(new ShortVideoSoCompressUtil.1(), 64, null, false);
  }
  
  private static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  private static boolean b(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("config_version");
    paramString = new File(((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      return false;
    }
    paramString = ShortVideoSoManager.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    localObject = VideoEnvironment.getShortVideoSoLibName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    if (((String)localObject).equalsIgnoreCase(paramString))
    {
      paramString = ShortVideoSoManager.d((String)localObject);
      if (paramString.e() != 0) {
        return false;
      }
      paramString = paramString.b().trim();
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      if (paramString.equalsIgnoreCase(((StringBuilder)localObject).toString())) {
        return VideoEnvironment.checkAndLoadAVCodec();
      }
    }
    return false;
  }
  
  private static void c()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(c);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("trim_process_pie");
    localObject3 = new File(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("trim_process_pie");
    localObject4 = new File(((StringBuilder)localObject4).toString());
    boolean bool = ((File)localObject3).exists();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=");
    localStringBuilder.append(bool);
    a(localStringBuilder.toString());
    if (bool) {
      a((File)localObject3, (File)localObject4);
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("trim_process_pic");
    localObject2 = new File(((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("trim_process_pic");
    localObject1 = new File(((StringBuilder)localObject3).toString());
    bool = ((File)localObject2).exists();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=");
    ((StringBuilder)localObject3).append(bool);
    a(((StringBuilder)localObject3).toString());
    if (bool) {
      a((File)localObject2, (File)localObject1);
    }
  }
  
  private static boolean c(String paramString)
  {
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = a;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString.equals(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil
 * JD-Core Version:    0.7.0.1
 */