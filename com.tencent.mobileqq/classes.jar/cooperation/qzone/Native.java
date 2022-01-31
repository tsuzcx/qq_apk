package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import bjeb;
import bjih;
import bjtz;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.DataUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Native
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static File a()
  {
    String str = b();
    return new File(str + File.separator + "qzlib");
  }
  
  private static String a()
  {
    try
    {
      String str = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static String a(InputStream paramInputStream)
  {
    return a(paramInputStream, "MD5");
  }
  
  /* Error */
  public static String a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 115	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   4: astore_1
    //   5: sipush 1024
    //   8: newarray byte
    //   10: astore_3
    //   11: aload_0
    //   12: aload_3
    //   13: invokevirtual 121	java/io/InputStream:read	([B)I
    //   16: istore_2
    //   17: iload_2
    //   18: ifle +21 -> 39
    //   21: aload_1
    //   22: aload_3
    //   23: iconst_0
    //   24: iload_2
    //   25: invokevirtual 125	java/security/MessageDigest:update	([BII)V
    //   28: goto -17 -> 11
    //   31: astore_1
    //   32: aload_0
    //   33: invokestatic 131	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   36: pop
    //   37: aconst_null
    //   38: areturn
    //   39: aload_1
    //   40: invokevirtual 135	java/security/MessageDigest:digest	()[B
    //   43: invokestatic 138	cooperation/qzone/Native:a	([B)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 131	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   51: pop
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aload_0
    //   56: invokestatic 131	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: aload_0
    //   64: invokestatic 131	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramInputStream	InputStream
    //   0	70	1	paramString	String
    //   16	9	2	i	int
    //   10	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	11	31	java/io/IOException
    //   11	17	31	java/io/IOException
    //   21	28	31	java/io/IOException
    //   39	47	31	java/io/IOException
    //   0	11	54	java/security/NoSuchAlgorithmException
    //   11	17	54	java/security/NoSuchAlgorithmException
    //   21	28	54	java/security/NoSuchAlgorithmException
    //   39	47	54	java/security/NoSuchAlgorithmException
    //   0	11	62	finally
    //   11	17	62	finally
    //   21	28	62	finally
    //   39	47	62	finally
  }
  
  private static String a(String paramString)
  {
    return "lib/armeabi" + File.separator + paramString;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return "check_" + paramString1 + "_" + paramString2;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static List<File> a(String paramString)
  {
    Object localObject;
    File localFile;
    boolean bool;
    if (a())
    {
      localObject = new File(bjih.o);
      localFile = new File((File)localObject, "wns_network_lib.zip");
      if (localFile.exists()) {
        localFile.delete();
      }
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      QLog.w("LibraryLoader", 1, "Prepare to Download Native Libs From Network ... Url = http://14.17.34.200/sngapp/qzone/client/20140812163037_9933/qzone_so_for_5_0.zip");
      bool = bjeb.a(bjeb.a("http://14.17.34.200/sngapp/qzone/client/20140812163037_9933/qzone_so_for_5_0.zip", localFile));
      QLog.w("LibraryLoader", 1, "Download Native Libs => " + bool);
      if (bool) {
        break label113;
      }
      paramString = null;
    }
    label113:
    do
    {
      return paramString;
      localObject = jdField_a_of_type_AndroidContentContext.getCacheDir();
      break;
      QLog.w("LibraryLoader", 1, "Prepare to Install Native Libs ...");
      localObject = new HashSet();
      if (!TextUtils.isEmpty(paramString)) {
        ((Set)localObject).add(paramString);
      }
      localObject = bjtz.a(localFile, a(), (Set)localObject);
      QLog.w("LibraryLoader", 1, "Install Native Libs => " + bool);
      paramString = (String)localObject;
    } while (!localFile.exists());
    localFile.delete();
    return localObject;
  }
  
  private static void a(long paramLong, boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if ((!paramBoolean) || (l - paramLong <= 0L)) {
      return;
    }
    QLog.e("LibraryLoader", 1, "report force copy to mm " + paramString);
  }
  
  public static void a(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  private static void a(String paramString)
  {
    QLog.e("LibraryLoader", 1, "try to copy " + paramString);
    String str = a(paramString);
    try
    {
      a(paramString, str, a().getAbsolutePath());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new Native.NativeException("copy file:" + paramString + " failed!", localThrowable);
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("guarder", 0);
    paramString1 = a(paramString1, paramString2);
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        a(str);
        a(paramString, str, true);
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  private static boolean a(String paramString)
  {
    return a(paramString, "lib/armeabi");
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    boolean bool3 = false;
    jdField_a_of_type_AndroidContentContext = paramContext;
    String str1 = "lib" + paramString + ".so";
    paramContext = new File(a(), str1);
    jdField_a_of_type_JavaUtilHashMap.put(paramString, null);
    for (;;)
    {
      boolean bool2;
      try
      {
        QLog.d("LibraryLoader", 1, "try to load library: " + paramString + " from system lib");
        System.loadLibrary(paramString);
        bool2 = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localUnsatisfiedLinkError2);
        l = System.currentTimeMillis();
        if ((paramContext.exists()) && (b(a(), str1))) {
          break label506;
        }
        if (a(str1)) {
          break label392;
        }
        localObject1 = a(str1);
        bool2 = bool3;
        if (localObject1 == null) {
          continue;
        }
        bool2 = bool3;
        if (((List)localObject1).isEmpty()) {
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localFile = (File)((Iterator)localObject1).next();
        a(a(), localFile.getName(), true);
        continue;
      }
      catch (Exception localException2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localException2);
        continue;
      }
      catch (Error localError2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localError2);
        continue;
        bool1 = false;
        if (!paramContext.exists()) {
          break label550;
        }
      }
      return bool2;
      try
      {
        Object localObject1;
        String str2 = paramContext.getAbsolutePath();
        QLog.d("LibraryLoader", 1, "try to load library: " + str2 + " from qzlib");
        System.load(str2);
        jdField_a_of_type_JavaUtilHashMap.put(paramString, str2);
        a(l, bool1, paramString);
        return true;
        label392:
        QLog.e("LibraryLoader", 1, str1 + " not exist,try to forceCopy!");
        try
        {
          a(a(), new String[] { str1 });
          bool1 = true;
        }
        catch (Native.NativeException localNativeException1)
        {
          QLog.e("LibraryLoader", 1, str1 + "forceCopy failed!", localNativeException1);
          bool1 = false;
        }
        catch (Exception localException3)
        {
          QLog.e("LibraryLoader", 1, str1 + "forceCopy failed!", localException3);
        }
        label506:
        bool1 = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        File localFile;
        QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localUnsatisfiedLinkError3);
        if (a(str1))
        {
          if (!paramContext.exists())
          {
            QLog.e("LibraryLoader", 1, "Copy Lib For NOT_EXIST");
            i = 1;
            if (i == 0) {
              try
              {
                Object localObject2 = a(str1);
                bool2 = bool3;
                if (((List)localObject2).isEmpty()) {
                  continue;
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localFile = (File)((Iterator)localObject2).next();
                  a(a(), localFile.getName(), true);
                }
                bool2 = bool1;
              }
              catch (Throwable localThrowable) {}
            }
            if (i != 0) {
              QLog.e("LibraryLoader", 1, str1 + " is something wrong,try to forceCopy again!");
            }
          }
          try
          {
            a(a(), new String[] { str1 });
            bool2 = true;
          }
          catch (Native.NativeException localNativeException2)
          {
            for (;;)
            {
              QLog.e("LibraryLoader", 1, str1 + "forceCopy failed again!", localNativeException2);
              bool2 = bool1;
            }
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              QLog.e("LibraryLoader", 1, str1 + "forceCopy failed again!", localException5);
              bool2 = bool1;
            }
          }
          if (!paramContext.exists())
          {
            QLog.e("LibraryLoader", 1, str1 + "forceCopy done,but the sofile is not exist!");
            return false;
          }
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localException4);
        }
      }
      catch (Error localError3)
      {
        for (;;)
        {
          long l;
          boolean bool1;
          label550:
          int i;
          QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localError3);
          continue;
          if (!c(str1))
          {
            QLog.e("LibraryLoader", 1, "Copy Lib For DIFF_LENGTHS");
            i = 1;
          }
          else
          {
            if (!b(str1))
            {
              QLog.e("LibraryLoader", 1, "Copy Lib For DEBUG_AND_MD5");
              i = 1;
              continue;
              try
              {
                str1 = paramContext.getAbsolutePath();
                QLog.e("LibraryLoader", 1, "try to load library: " + str1 + " from qzlib again!");
                System.load(str1);
                jdField_a_of_type_JavaUtilHashMap.put(paramString, str1);
                a(l, bool2, paramString);
                return true;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
              {
                QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localUnsatisfiedLinkError1);
                jdField_a_of_type_JavaUtilHashMap.put(paramString, null);
                return false;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localException1);
                }
              }
              catch (Error localError1)
              {
                for (;;)
                {
                  QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localError1);
                }
              }
            }
            i = 0;
          }
        }
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 67	cooperation/qzone/Native:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5: invokevirtual 402	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: astore_3
    //   9: new 46	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 55	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 408	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +13 -> 54
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 411	java/io/InputStream:close	()V
    //   52: iload_2
    //   53: ireturn
    //   54: iconst_0
    //   55: istore_2
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: ldc 174
    //   62: iconst_1
    //   63: new 46	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 413
    //   73: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aconst_null
    //   84: invokestatic 336	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: iconst_0
    //   88: ifeq +11 -> 99
    //   91: new 415	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 416	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 415	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 416	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: iload_2
    //   118: ireturn
    //   119: astore_0
    //   120: goto -21 -> 99
    //   123: astore_1
    //   124: goto -10 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString1	String
    //   0	127	1	paramString2	String
    //   1	117	2	bool	boolean
    //   8	27	3	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   34	40	59	java/io/IOException
    //   34	40	101	finally
    //   60	87	101	finally
    //   48	52	116	java/io/IOException
    //   91	99	119	java/io/IOException
    //   106	114	123	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    localFileOutputStream = null;
    boolean bool = true;
    for (;;)
    {
      Context localContext;
      try
      {
        localContext = jdField_a_of_type_AndroidContentContext;
        if ((localContext == null) || (paramString2 == null))
        {
          bool = false;
          return bool;
        }
        if (paramString3 != null)
        {
          str = paramString3;
          if (paramString3.trim().length() != 0) {}
        }
        else
        {
          QLog.e("LibraryLoader", 1, "not define lib out path");
          str = localContext.getFilesDir().getAbsolutePath();
        }
        new File(str).mkdirs();
        QLog.d("LibraryLoader", 1, "copy lib:" + paramString2 + " to " + str);
      }
      finally {}
      try
      {
        paramString2 = localContext.getAssets().open(paramString2);
      }
      catch (Throwable paramString1)
      {
        label230:
        paramString2 = null;
        str = null;
        paramString3 = localFileOutputStream;
        continue;
      }
      try
      {
        paramString1 = new File(str, paramString1);
      }
      catch (Throwable paramString1)
      {
        localFileOutputStream = null;
        str = null;
        paramString3 = paramString2;
        paramString2 = localFileOutputStream;
        continue;
      }
      try
      {
        if (paramString1.exists()) {
          a(paramString1);
        }
        localFileOutputStream = new FileOutputStream(paramString1);
        try
        {
          paramString3 = new byte[4096];
          if (paramString2.available() <= 0) {
            break label230;
          }
          int i = paramString2.read(paramString3);
          if (i <= 0) {
            break label230;
          }
          localFileOutputStream.write(paramString3, 0, i);
          continue;
          DataUtils.closeDataObject(paramString2);
        }
        catch (Throwable localThrowable1)
        {
          str = paramString1;
          paramString3 = paramString2;
          paramString2 = localFileOutputStream;
          paramString1 = localThrowable1;
        }
      }
      catch (Throwable localThrowable2)
      {
        localFileOutputStream = null;
        paramString3 = paramString2;
        str = paramString1;
        paramString1 = localThrowable2;
        paramString2 = localFileOutputStream;
        continue;
      }
      DataUtils.closeDataObject(paramString3);
      a(str);
      throw paramString1;
      localFileOutputStream.close();
      paramString2.close();
    }
  }
  
  @SuppressLint({"SdCardPath"})
  private static String b()
  {
    File localFile2 = jdField_a_of_type_AndroidContentContext.getFilesDir();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = jdField_a_of_type_AndroidContentContext.getCacheDir();
    }
    if (localFile1 != null) {
      return localFile1.getParent();
    }
    return "/data/data/" + jdField_a_of_type_AndroidContentContext.getPackageName();
  }
  
  private static boolean b(String paramString)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    boolean bool2 = bool4;
    try
    {
      String str1 = a(jdField_a_of_type_AndroidContentContext.getAssets().open(a(paramString)));
      bool1 = bool3;
      bool2 = bool4;
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
      bool1 = bool3;
      bool2 = bool4;
      String str2 = a(new FileInputStream(new File(a(), paramString)));
      bool1 = bool3;
      bool2 = bool4;
      bool3 = str1.equals(str2);
      bool1 = bool3;
      bool2 = bool3;
      String str3 = a() + File.separator + paramString;
      bool1 = bool3;
      bool2 = bool3;
      QLog.e("LibraryLoader", 1, a(paramString) + " md5 = " + str1 + "," + str3 + " md5 = " + str2);
      return bool3;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return bool1;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return bool2;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return jdField_a_of_type_AndroidContentContext.getSharedPreferences("guarder", 0).getBoolean(a(paramString1, paramString2), false);
  }
  
  /* Error */
  private static boolean c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 44	java/io/File
    //   5: dup
    //   6: new 44	java/io/File
    //   9: dup
    //   10: invokestatic 218	cooperation/qzone/Native:a	()Ljava/io/File;
    //   13: aload_0
    //   14: invokespecial 163	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: invokevirtual 253	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: getstatic 67	cooperation/qzone/Native:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   28: invokevirtual 402	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: astore 9
    //   33: aload_0
    //   34: invokestatic 250	cooperation/qzone/Native:a	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_0
    //   38: aload 9
    //   40: aload_0
    //   41: invokevirtual 483	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   44: astore 10
    //   46: aload 10
    //   48: ifnonnull +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: ldc 174
    //   55: iconst_1
    //   56: new 46	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 485
    //   70: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 10
    //   75: invokevirtual 490	android/content/res/AssetFileDescriptor:getLength	()J
    //   78: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc_w 471
    //   84: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 8
    //   89: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: ldc_w 485
    //   95: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 8
    //   100: invokevirtual 495	java/io/File:length	()J
    //   103: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   106: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload 8
    //   114: invokevirtual 495	java/io/File:length	()J
    //   117: lstore_2
    //   118: aload 10
    //   120: invokevirtual 490	android/content/res/AssetFileDescriptor:getLength	()J
    //   123: lstore 4
    //   125: lload_2
    //   126: lload 4
    //   128: lcmp
    //   129: ifne +166 -> 295
    //   132: iconst_1
    //   133: istore 6
    //   135: iload 6
    //   137: istore 7
    //   139: iload_1
    //   140: ifeq +161 -> 301
    //   143: iload 6
    //   145: istore 7
    //   147: aload 9
    //   149: aload_0
    //   150: invokevirtual 408	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   153: astore 9
    //   155: ldc 174
    //   157: iconst_1
    //   158: new 46	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   165: aload_0
    //   166: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 497
    //   172: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 9
    //   177: invokevirtual 444	java/io/InputStream:available	()I
    //   180: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc_w 471
    //   186: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 8
    //   191: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: ldc_w 485
    //   197: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 8
    //   202: invokevirtual 495	java/io/File:length	()J
    //   205: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 8
    //   216: invokevirtual 495	java/io/File:length	()J
    //   219: lstore_2
    //   220: aload 9
    //   222: invokevirtual 444	java/io/InputStream:available	()I
    //   225: istore_1
    //   226: lload_2
    //   227: iload_1
    //   228: i2l
    //   229: lcmp
    //   230: ifne +6 -> 236
    //   233: iconst_1
    //   234: istore 6
    //   236: iload 6
    //   238: istore 7
    //   240: aload 9
    //   242: invokevirtual 411	java/io/InputStream:close	()V
    //   245: iload 6
    //   247: istore 7
    //   249: goto +52 -> 301
    //   252: astore_0
    //   253: iload 6
    //   255: istore 7
    //   257: aload 9
    //   259: invokevirtual 411	java/io/InputStream:close	()V
    //   262: iload 6
    //   264: istore 7
    //   266: goto +35 -> 301
    //   269: astore_0
    //   270: iload 6
    //   272: istore 7
    //   274: aload 9
    //   276: invokevirtual 411	java/io/InputStream:close	()V
    //   279: iload 6
    //   281: istore 7
    //   283: aload_0
    //   284: athrow
    //   285: astore_0
    //   286: iconst_0
    //   287: istore 7
    //   289: goto +12 -> 301
    //   292: astore_0
    //   293: iconst_1
    //   294: ireturn
    //   295: iconst_0
    //   296: istore 6
    //   298: goto -163 -> 135
    //   301: iload 7
    //   303: ireturn
    //   304: astore 10
    //   306: iconst_0
    //   307: istore 6
    //   309: iconst_1
    //   310: istore_1
    //   311: goto -176 -> 135
    //   314: astore_0
    //   315: goto -14 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramString	String
    //   1	310	1	i	int
    //   117	110	2	l1	long
    //   123	4	4	l2	long
    //   133	175	6	bool1	boolean
    //   137	165	7	bool2	boolean
    //   23	192	8	localFile	File
    //   31	244	9	localObject	Object
    //   44	75	10	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   304	1	10	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   155	226	252	java/io/IOException
    //   155	226	269	finally
    //   38	46	285	java/lang/Exception
    //   53	125	285	java/lang/Exception
    //   38	46	292	java/io/FileNotFoundException
    //   53	125	292	java/io/FileNotFoundException
    //   38	46	304	java/io/IOException
    //   53	125	304	java/io/IOException
    //   147	155	314	java/lang/Exception
    //   240	245	314	java/lang/Exception
    //   257	262	314	java/lang/Exception
    //   274	279	314	java/lang/Exception
    //   283	285	314	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.Native
 * JD-Core Version:    0.7.0.1
 */