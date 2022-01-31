package com.tencent.mobileqq.ocr.data;

import agct;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;

public class OcrConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new agct();
  public static final String TAG = "OcrConfig";
  public int aioOcrOpen;
  public String aioText;
  public long endTime;
  public String iconMd5;
  public String iconPressMD5;
  public String iconPressUrl;
  public String iconText;
  public String iconUrl;
  public int questionResultOpen;
  public int questionScanOpen;
  public int qzoneOcrOpen;
  public int scanOcrOpen;
  public long startTime;
  public String tips;
  public int version;
  
  public OcrConfig() {}
  
  public OcrConfig(Parcel paramParcel)
  {
    this.version = paramParcel.readInt();
    this.scanOcrOpen = paramParcel.readInt();
    this.iconUrl = paramParcel.readString();
    this.iconMd5 = paramParcel.readString();
    this.iconPressUrl = paramParcel.readString();
    this.iconPressMD5 = paramParcel.readString();
    this.iconText = paramParcel.readString();
    this.tips = paramParcel.readString();
    this.aioOcrOpen = paramParcel.readInt();
    this.aioText = paramParcel.readString();
    this.qzoneOcrOpen = paramParcel.readInt();
    this.questionScanOpen = paramParcel.readInt();
    this.questionResultOpen = paramParcel.readInt();
  }
  
  public static void deleteLocalConfig(String paramString)
  {
    paramString = BaseApplicationImpl.getContext().getFileStreamPath("ocr_config_" + paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OcrConfig", 2, "deleteLocalConfig path:" + paramString.getAbsolutePath());
    }
  }
  
  public static OcrConfig parse(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OcrConfig", 2, "OcrConfig.parse, xmlContent:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    OcrConfig localOcrConfig = new OcrConfig();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramString) {}
      int i = localXmlPullParser.next();
      break label710;
      paramString = localXmlPullParser.getName();
      if (paramString.equalsIgnoreCase("ScanCfg"))
      {
        i = localXmlPullParser.next();
        if (i != 1)
        {
          if (i != 2) {
            break label340;
          }
          paramString = localXmlPullParser.getName();
          if (paramString.equalsIgnoreCase("ScanOcrOpen"))
          {
            localOcrConfig.scanOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
            i = localXmlPullParser.next();
          }
        }
        else
        {
          continue;
        }
        if (paramString.equalsIgnoreCase("ScanIconImg"))
        {
          localOcrConfig.iconUrl = localXmlPullParser.nextText();
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("OcrConfig", 2, "parse exception:" + paramString.toString());
          return null;
        }
        if (paramString.equalsIgnoreCase("ScanIconMd5"))
        {
          localOcrConfig.iconMd5 = localXmlPullParser.nextText();
          continue;
        }
        if (paramString.equalsIgnoreCase("ScanIconPressed"))
        {
          localOcrConfig.iconPressUrl = localXmlPullParser.nextText();
          continue;
        }
        if (paramString.equalsIgnoreCase("ScanIconPressedMd5"))
        {
          localOcrConfig.iconPressMD5 = localXmlPullParser.nextText();
          continue;
        }
        if (paramString.equalsIgnoreCase("ScanIconText"))
        {
          localOcrConfig.iconText = localXmlPullParser.nextText();
          continue;
        }
        if (!paramString.equalsIgnoreCase("Scan_Line1")) {
          continue;
        }
        localOcrConfig.tips = localXmlPullParser.nextText();
        continue;
        label340:
        if ((i != 3) || (!localXmlPullParser.getName().equalsIgnoreCase("ScanCfg"))) {
          continue;
        }
        continue;
      }
      if (paramString.equalsIgnoreCase("AioCfg"))
      {
        i = localXmlPullParser.next();
        label378:
        if (i != 1)
        {
          if (i != 2) {
            break label451;
          }
          paramString = localXmlPullParser.getName();
          if (!paramString.equalsIgnoreCase("AioOcrOpen")) {
            break label428;
          }
          localOcrConfig.aioOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
        }
        label428:
        label451:
        while ((i != 3) || (!localXmlPullParser.getName().equalsIgnoreCase("AioCfg"))) {
          for (;;)
          {
            i = localXmlPullParser.next();
            break label378;
            break;
            if (paramString.equalsIgnoreCase("AioText")) {
              localOcrConfig.aioText = localXmlPullParser.nextText();
            }
          }
        }
      }
      else if (paramString.equalsIgnoreCase("QzoneCfg"))
      {
        i = localXmlPullParser.next();
        label489:
        if (i != 1)
        {
          if (i != 2) {
            break label537;
          }
          if (localXmlPullParser.getName().equalsIgnoreCase("QzoneOcrOpen")) {
            localOcrConfig.qzoneOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
          }
        }
        label537:
        while ((i != 3) || (!localXmlPullParser.getName().equalsIgnoreCase("QzoneCfg")))
        {
          i = localXmlPullParser.next();
          break label489;
          break;
        }
      }
      else if (paramString.equalsIgnoreCase("QuestionCfg"))
      {
        i = localXmlPullParser.next();
        label575:
        if (i != 1)
        {
          if (i != 2) {
            break label651;
          }
          paramString = localXmlPullParser.getName();
          if (!paramString.equalsIgnoreCase("ScanEnter")) {
            break label625;
          }
          localOcrConfig.questionScanOpen = Integer.parseInt(localXmlPullParser.nextText());
        }
        label625:
        do
        {
          do
          {
            for (;;)
            {
              i = localXmlPullParser.next();
              break label575;
              break;
              if (paramString.equalsIgnoreCase("ResultPageEnter")) {
                localOcrConfig.questionResultOpen = Integer.parseInt(localXmlPullParser.nextText());
              }
            }
          } while (i != 3);
          bool = localXmlPullParser.getName().equalsIgnoreCase("QuestionCfg");
        } while (!bool);
        label651:
        label710:
        while (i == 1)
        {
          boolean bool;
          if (QLog.isColorLevel()) {
            QLog.d("OcrConfig", 2, "parse:" + localOcrConfig);
          }
          return localOcrConfig;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  /* Error */
  public static OcrConfig readFromFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 14
    //   8: iconst_2
    //   9: ldc 233
    //   11: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +19 -> 37
    //   21: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 14
    //   29: iconst_2
    //   30: ldc 235
    //   32: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aconst_null
    //   36: areturn
    //   37: invokestatic 87	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   40: new 89	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   47: ldc 92
    //   49: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 105	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 111	java/io/File:exists	()Z
    //   67: ifne +19 -> 86
    //   70: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -38 -> 35
    //   76: ldc 14
    //   78: iconst_2
    //   79: ldc 237
    //   81: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aconst_null
    //   85: areturn
    //   86: new 239	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 242	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore_1
    //   95: new 244	java/io/ObjectInputStream
    //   98: dup
    //   99: new 246	java/io/BufferedInputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 249	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: invokespecial 250	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore 5
    //   112: aload 5
    //   114: astore_3
    //   115: aload_1
    //   116: astore_2
    //   117: aload 5
    //   119: invokevirtual 254	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   122: checkcast 2	com/tencent/mobileqq/ocr/data/OcrConfig
    //   125: astore 4
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 257	java/io/FileInputStream:close	()V
    //   135: aload 4
    //   137: astore_0
    //   138: aload 5
    //   140: ifnull +11 -> 151
    //   143: aload 5
    //   145: invokevirtual 258	java/io/ObjectInputStream:close	()V
    //   148: aload 4
    //   150: astore_0
    //   151: aload_0
    //   152: areturn
    //   153: astore_0
    //   154: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -22 -> 135
    //   160: aload_0
    //   161: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   164: goto -29 -> 135
    //   167: astore_1
    //   168: aload 4
    //   170: astore_0
    //   171: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -23 -> 151
    //   177: aload_1
    //   178: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   181: aload 4
    //   183: astore_0
    //   184: goto -33 -> 151
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_0
    //   194: astore_3
    //   195: aload_1
    //   196: astore_2
    //   197: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +37 -> 237
    //   203: aload_0
    //   204: astore_3
    //   205: aload_1
    //   206: astore_2
    //   207: ldc 14
    //   209: iconst_2
    //   210: new 89	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 263
    //   220: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 4
    //   225: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 257	java/io/FileInputStream:close	()V
    //   245: aload_0
    //   246: ifnull +120 -> 366
    //   249: aload_0
    //   250: invokevirtual 258	java/io/ObjectInputStream:close	()V
    //   253: aconst_null
    //   254: astore_0
    //   255: goto -104 -> 151
    //   258: astore_1
    //   259: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -17 -> 245
    //   265: aload_1
    //   266: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   269: goto -24 -> 245
    //   272: astore_0
    //   273: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +7 -> 283
    //   279: aload_0
    //   280: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   283: aconst_null
    //   284: astore_0
    //   285: goto -134 -> 151
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 257	java/io/FileInputStream:close	()V
    //   301: aload_3
    //   302: ifnull +7 -> 309
    //   305: aload_3
    //   306: invokevirtual 258	java/io/ObjectInputStream:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_1
    //   312: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq -14 -> 301
    //   318: aload_1
    //   319: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   322: goto -21 -> 301
    //   325: astore_1
    //   326: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -20 -> 309
    //   332: aload_1
    //   333: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   336: goto -27 -> 309
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -49 -> 293
    //   345: astore_0
    //   346: aload_2
    //   347: astore_1
    //   348: goto -55 -> 293
    //   351: astore 4
    //   353: aconst_null
    //   354: astore_0
    //   355: goto -162 -> 193
    //   358: astore 4
    //   360: aload 5
    //   362: astore_0
    //   363: goto -170 -> 193
    //   366: aconst_null
    //   367: astore_0
    //   368: goto -217 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramString	String
    //   94	38	1	localFileInputStream	java.io.FileInputStream
    //   167	11	1	localIOException1	java.io.IOException
    //   192	50	1	localObject1	Object
    //   258	8	1	localIOException2	java.io.IOException
    //   292	6	1	localObject2	Object
    //   311	8	1	localIOException3	java.io.IOException
    //   325	8	1	localIOException4	java.io.IOException
    //   347	1	1	localObject3	Object
    //   116	231	2	localObject4	Object
    //   114	228	3	localObject5	Object
    //   125	57	4	localOcrConfig	OcrConfig
    //   187	37	4	localException1	Exception
    //   351	1	4	localException2	Exception
    //   358	1	4	localException3	Exception
    //   110	251	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   131	135	153	java/io/IOException
    //   143	148	167	java/io/IOException
    //   86	95	187	java/lang/Exception
    //   241	245	258	java/io/IOException
    //   249	253	272	java/io/IOException
    //   86	95	288	finally
    //   297	301	311	java/io/IOException
    //   305	309	325	java/io/IOException
    //   95	112	339	finally
    //   117	127	345	finally
    //   197	203	345	finally
    //   207	237	345	finally
    //   95	112	351	java/lang/Exception
    //   117	127	358	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isEntryOpen()
  {
    return this.scanOcrOpen == 1;
  }
  
  /* Error */
  public void saveToFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 14
    //   17: iconst_2
    //   18: ldc_w 270
    //   21: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 87	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: new 89	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   35: ldc 92
    //   37: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 105	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   50: astore 8
    //   52: invokestatic 87	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: new 89	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   62: ldc 92
    //   64: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 272
    //   74: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 105	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   83: astore 9
    //   85: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +33 -> 121
    //   91: ldc 14
    //   93: iconst_2
    //   94: new 89	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 274
    //   104: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 8
    //   109: invokevirtual 124	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 9
    //   123: invokevirtual 111	java/io/File:exists	()Z
    //   126: ifeq +9 -> 135
    //   129: aload 9
    //   131: invokevirtual 114	java/io/File:delete	()Z
    //   134: pop
    //   135: aload 9
    //   137: invokevirtual 277	java/io/File:createNewFile	()Z
    //   140: pop
    //   141: new 279	java/io/FileOutputStream
    //   144: dup
    //   145: aload 9
    //   147: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: astore_3
    //   151: new 282	java/io/BufferedOutputStream
    //   154: dup
    //   155: aload_3
    //   156: invokespecial 285	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   159: astore_1
    //   160: new 287	java/io/ObjectOutputStream
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 288	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   168: astore 4
    //   170: aload_3
    //   171: astore 7
    //   173: aload_1
    //   174: astore 6
    //   176: aload 4
    //   178: astore 5
    //   180: aload 4
    //   182: aload_0
    //   183: invokevirtual 292	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   186: aload_3
    //   187: astore 7
    //   189: aload_1
    //   190: astore 6
    //   192: aload 4
    //   194: astore 5
    //   196: aload 4
    //   198: invokevirtual 295	java/io/ObjectOutputStream:flush	()V
    //   201: aload_3
    //   202: astore 7
    //   204: aload_1
    //   205: astore 6
    //   207: aload 4
    //   209: astore 5
    //   211: aload 8
    //   213: invokevirtual 111	java/io/File:exists	()Z
    //   216: ifeq +19 -> 235
    //   219: aload_3
    //   220: astore 7
    //   222: aload_1
    //   223: astore 6
    //   225: aload 4
    //   227: astore 5
    //   229: aload 8
    //   231: invokevirtual 114	java/io/File:delete	()Z
    //   234: pop
    //   235: aload_3
    //   236: astore 7
    //   238: aload_1
    //   239: astore 6
    //   241: aload 4
    //   243: astore 5
    //   245: aload 9
    //   247: aload 8
    //   249: invokevirtual 299	java/io/File:renameTo	(Ljava/io/File;)Z
    //   252: pop
    //   253: aload_3
    //   254: astore 7
    //   256: aload_1
    //   257: astore 6
    //   259: aload 4
    //   261: astore 5
    //   263: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +22 -> 288
    //   269: aload_3
    //   270: astore 7
    //   272: aload_1
    //   273: astore 6
    //   275: aload 4
    //   277: astore 5
    //   279: ldc 14
    //   281: iconst_2
    //   282: ldc_w 301
    //   285: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_3
    //   289: ifnull +7 -> 296
    //   292: aload_3
    //   293: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   304: aload 4
    //   306: ifnull -282 -> 24
    //   309: aload 4
    //   311: invokevirtual 304	java/io/ObjectOutputStream:close	()V
    //   314: return
    //   315: astore_1
    //   316: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -295 -> 24
    //   322: aload_1
    //   323: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   326: return
    //   327: astore_2
    //   328: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq -35 -> 296
    //   334: aload_2
    //   335: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   338: goto -42 -> 296
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   346: goto -42 -> 304
    //   349: astore 4
    //   351: aconst_null
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_1
    //   355: aload 4
    //   357: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   360: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +33 -> 396
    //   366: ldc 14
    //   368: iconst_2
    //   369: new 89	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 306
    //   379: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 4
    //   384: invokevirtual 307	java/io/IOException:toString	()Ljava/lang/String;
    //   387: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_3
    //   397: ifnull +7 -> 404
    //   400: aload_3
    //   401: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   404: aload_2
    //   405: ifnull +7 -> 412
    //   408: aload_2
    //   409: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   412: aload_1
    //   413: ifnull -389 -> 24
    //   416: aload_1
    //   417: invokevirtual 304	java/io/ObjectOutputStream:close	()V
    //   420: return
    //   421: astore_1
    //   422: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -401 -> 24
    //   428: aload_1
    //   429: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: astore_3
    //   434: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq -33 -> 404
    //   440: aload_3
    //   441: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   444: goto -40 -> 404
    //   447: astore_2
    //   448: aload_2
    //   449: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   452: goto -40 -> 412
    //   455: astore_2
    //   456: aconst_null
    //   457: astore 8
    //   459: aconst_null
    //   460: astore_3
    //   461: aconst_null
    //   462: astore_1
    //   463: aload 8
    //   465: astore 7
    //   467: aload_3
    //   468: astore 6
    //   470: aload_1
    //   471: astore 5
    //   473: ldc 14
    //   475: iconst_2
    //   476: new 89	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 309
    //   486: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_2
    //   490: invokevirtual 312	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   493: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload 8
    //   504: ifnull +8 -> 512
    //   507: aload 8
    //   509: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   512: aload_3
    //   513: ifnull +7 -> 520
    //   516: aload_3
    //   517: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   520: aload_1
    //   521: ifnull -497 -> 24
    //   524: aload_1
    //   525: invokevirtual 304	java/io/ObjectOutputStream:close	()V
    //   528: return
    //   529: astore_1
    //   530: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq -509 -> 24
    //   536: aload_1
    //   537: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   540: return
    //   541: astore_2
    //   542: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq -33 -> 512
    //   548: aload_2
    //   549: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   552: goto -40 -> 512
    //   555: astore_2
    //   556: aload_2
    //   557: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   560: goto -40 -> 520
    //   563: astore_2
    //   564: aconst_null
    //   565: astore 4
    //   567: aconst_null
    //   568: astore_1
    //   569: aconst_null
    //   570: astore_3
    //   571: aload 4
    //   573: ifnull +8 -> 581
    //   576: aload 4
    //   578: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   581: aload_1
    //   582: ifnull +7 -> 589
    //   585: aload_1
    //   586: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   589: aload_3
    //   590: ifnull +7 -> 597
    //   593: aload_3
    //   594: invokevirtual 304	java/io/ObjectOutputStream:close	()V
    //   597: aload_2
    //   598: athrow
    //   599: astore 4
    //   601: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   604: ifeq -23 -> 581
    //   607: aload 4
    //   609: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   612: goto -31 -> 581
    //   615: astore_1
    //   616: aload_1
    //   617: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   620: goto -31 -> 589
    //   623: astore_1
    //   624: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq -30 -> 597
    //   630: aload_1
    //   631: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   634: goto -37 -> 597
    //   637: astore_2
    //   638: aconst_null
    //   639: astore_1
    //   640: aconst_null
    //   641: astore 5
    //   643: aload_3
    //   644: astore 4
    //   646: aload 5
    //   648: astore_3
    //   649: goto -78 -> 571
    //   652: astore_2
    //   653: aconst_null
    //   654: astore 5
    //   656: aload_3
    //   657: astore 4
    //   659: aload 5
    //   661: astore_3
    //   662: goto -91 -> 571
    //   665: astore_2
    //   666: aload 7
    //   668: astore 4
    //   670: aload 6
    //   672: astore_1
    //   673: aload 5
    //   675: astore_3
    //   676: goto -105 -> 571
    //   679: astore 4
    //   681: aload_1
    //   682: astore 5
    //   684: aload_2
    //   685: astore_1
    //   686: aload 4
    //   688: astore_2
    //   689: aload_3
    //   690: astore 4
    //   692: aload 5
    //   694: astore_3
    //   695: goto -124 -> 571
    //   698: astore_2
    //   699: aconst_null
    //   700: astore 4
    //   702: aconst_null
    //   703: astore_1
    //   704: aload_3
    //   705: astore 8
    //   707: aload 4
    //   709: astore_3
    //   710: goto -247 -> 463
    //   713: astore_2
    //   714: aconst_null
    //   715: astore 4
    //   717: aload_3
    //   718: astore 8
    //   720: aload_1
    //   721: astore_3
    //   722: aload 4
    //   724: astore_1
    //   725: goto -262 -> 463
    //   728: astore_2
    //   729: aload_3
    //   730: astore 8
    //   732: aload_1
    //   733: astore_3
    //   734: aload 4
    //   736: astore_1
    //   737: goto -274 -> 463
    //   740: astore 4
    //   742: aconst_null
    //   743: astore_1
    //   744: goto -389 -> 355
    //   747: astore 4
    //   749: aconst_null
    //   750: astore 5
    //   752: aload_1
    //   753: astore_2
    //   754: aload 5
    //   756: astore_1
    //   757: goto -402 -> 355
    //   760: astore_2
    //   761: aload 4
    //   763: astore 5
    //   765: aload_2
    //   766: astore 4
    //   768: aload_1
    //   769: astore_2
    //   770: aload 5
    //   772: astore_1
    //   773: goto -418 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	this	OcrConfig
    //   0	776	1	paramString	String
    //   1	1	2	localObject1	Object
    //   327	82	2	localIOException1	java.io.IOException
    //   447	2	2	localIOException2	java.io.IOException
    //   455	35	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   541	8	2	localIOException3	java.io.IOException
    //   555	2	2	localIOException4	java.io.IOException
    //   563	35	2	localObject2	Object
    //   637	1	2	localObject3	Object
    //   652	1	2	localObject4	Object
    //   665	20	2	localObject5	Object
    //   688	1	2	localObject6	Object
    //   698	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   713	1	2	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   728	1	2	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   753	1	2	str1	String
    //   760	6	2	localIOException5	java.io.IOException
    //   769	1	2	str2	String
    //   150	251	3	localFileOutputStream	java.io.FileOutputStream
    //   433	8	3	localIOException6	java.io.IOException
    //   460	274	3	localObject7	Object
    //   168	142	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   349	34	4	localIOException7	java.io.IOException
    //   565	12	4	localObject8	Object
    //   599	9	4	localIOException8	java.io.IOException
    //   644	25	4	localObject9	Object
    //   679	8	4	localObject10	Object
    //   690	45	4	localObject11	Object
    //   740	1	4	localIOException9	java.io.IOException
    //   747	15	4	localIOException10	java.io.IOException
    //   766	1	4	localIOException11	java.io.IOException
    //   178	593	5	localObject12	Object
    //   174	497	6	localObject13	Object
    //   171	496	7	localObject14	Object
    //   50	681	8	localObject15	Object
    //   83	163	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   309	314	315	java/io/IOException
    //   292	296	327	java/io/IOException
    //   300	304	341	java/io/IOException
    //   135	151	349	java/io/IOException
    //   416	420	421	java/io/IOException
    //   400	404	433	java/io/IOException
    //   408	412	447	java/io/IOException
    //   135	151	455	java/lang/OutOfMemoryError
    //   524	528	529	java/io/IOException
    //   507	512	541	java/io/IOException
    //   516	520	555	java/io/IOException
    //   135	151	563	finally
    //   576	581	599	java/io/IOException
    //   585	589	615	java/io/IOException
    //   593	597	623	java/io/IOException
    //   151	160	637	finally
    //   160	170	652	finally
    //   180	186	665	finally
    //   196	201	665	finally
    //   211	219	665	finally
    //   229	235	665	finally
    //   245	253	665	finally
    //   263	269	665	finally
    //   279	288	665	finally
    //   473	502	665	finally
    //   355	396	679	finally
    //   151	160	698	java/lang/OutOfMemoryError
    //   160	170	713	java/lang/OutOfMemoryError
    //   180	186	728	java/lang/OutOfMemoryError
    //   196	201	728	java/lang/OutOfMemoryError
    //   211	219	728	java/lang/OutOfMemoryError
    //   229	235	728	java/lang/OutOfMemoryError
    //   245	253	728	java/lang/OutOfMemoryError
    //   263	269	728	java/lang/OutOfMemoryError
    //   279	288	728	java/lang/OutOfMemoryError
    //   151	160	740	java/io/IOException
    //   160	170	747	java/io/IOException
    //   180	186	760	java/io/IOException
    //   196	201	760	java/io/IOException
    //   211	219	760	java/io/IOException
    //   229	235	760	java/io/IOException
    //   245	253	760	java/io/IOException
    //   263	269	760	java/io/IOException
    //   279	288	760	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OcrConfig{");
    localStringBuilder.append("version:").append(this.version).append("scanOcrOpen,:").append(this.scanOcrOpen).append(",iconUrl:").append(this.iconUrl).append(",iconMd5:").append(this.iconMd5).append(",iconPressUrl:").append(this.iconPressUrl).append(",iconPressMD5:").append(this.iconPressMD5).append(",iconText:").append(this.iconText).append(",tips:").append(this.tips).append("aioOcrOpen,:").append(this.aioOcrOpen).append(",qzoneOcrOpen:").append(this.qzoneOcrOpen).append(",questionScanOpen:").append(this.questionScanOpen).append(",questionResultOpen:").append(this.questionResultOpen);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.scanOcrOpen);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.iconMd5);
    paramParcel.writeString(this.iconPressUrl);
    paramParcel.writeString(this.iconPressMD5);
    paramParcel.writeString(this.iconText);
    paramParcel.writeString(this.tips);
    paramParcel.writeInt(this.aioOcrOpen);
    paramParcel.writeString(this.aioText);
    paramParcel.writeInt(this.qzoneOcrOpen);
    paramParcel.writeInt(this.questionScanOpen);
    paramParcel.writeInt(this.questionResultOpen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrConfig
 * JD-Core Version:    0.7.0.1
 */