package com.tencent.mobileqq.olympic;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import atiu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.xmlpull.v1.XmlPullParser;

public class OlympicActConfig
  implements Serializable
{
  public static final String KEY_CONFIG_VERSION = "config_version";
  public static final String SAVE_PATH = "olympic_act_cfg_";
  public static final String TAG = "OlympicActConfig";
  public static final long serialVersionUID = 3L;
  private HashMap<Integer, List<OlympicActConfig.CityImage>> mAllCityImageMap = new HashMap();
  private HashMap<String, OlympicActConfig.BusiBanner> mBusiBannerMap = new HashMap();
  private ArrayList<OlympicActConfig.CityImage> mChosenCityImageList = new ArrayList();
  private HashMap<String, OlympicActConfig.HomePageBg> mCityBgMap = new HashMap();
  private HashMap<String, String> mConfigs = new HashMap();
  private HashMap<String, OlympicActConfig.TorchImage> mTorchImageMap = new HashMap();
  public int version = 1;
  
  /* Error */
  private void a(AppRuntime paramAppRuntime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 16
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 67
    //   12: aastore
    //   13: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_1
    //   17: checkcast 75	com/tencent/common/app/AppInterface
    //   20: invokevirtual 79	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   23: invokestatic 85	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   26: lstore_2
    //   27: lload_2
    //   28: bipush 32
    //   30: lshl
    //   31: invokestatic 91	java/lang/System:nanoTime	()J
    //   34: lor
    //   35: invokestatic 97	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   38: invokevirtual 101	java/lang/String:hashCode	()I
    //   41: i2l
    //   42: lstore 4
    //   44: lload 4
    //   46: lstore_2
    //   47: lload 4
    //   49: lconst_0
    //   50: lcmp
    //   51: ifne +7 -> 58
    //   54: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   57: lstore_2
    //   58: new 106	java/util/Random
    //   61: dup
    //   62: lload_2
    //   63: invokespecial 109	java/util/Random:<init>	(J)V
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 51	com/tencent/mobileqq/olympic/OlympicActConfig:mAllCityImageMap	Ljava/util/HashMap;
    //   71: invokevirtual 113	java/util/HashMap:keySet	()Ljava/util/Set;
    //   74: astore 6
    //   76: aload_0
    //   77: getfield 56	com/tencent/mobileqq/olympic/OlympicActConfig:mChosenCityImageList	Ljava/util/ArrayList;
    //   80: invokevirtual 116	java/util/ArrayList:clear	()V
    //   83: aload 6
    //   85: invokeinterface 122 1 0
    //   90: astore 6
    //   92: aload 6
    //   94: invokeinterface 128 1 0
    //   99: ifeq +123 -> 222
    //   102: aload 6
    //   104: invokeinterface 132 1 0
    //   109: checkcast 134	java/lang/Integer
    //   112: astore 7
    //   114: aload_0
    //   115: getfield 51	com/tencent/mobileqq/olympic/OlympicActConfig:mAllCityImageMap	Ljava/util/HashMap;
    //   118: aload 7
    //   120: invokevirtual 138	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 140	java/util/List
    //   126: astore 7
    //   128: aload 7
    //   130: invokeinterface 143 1 0
    //   135: ifle -43 -> 92
    //   138: aload 7
    //   140: aload_1
    //   141: aload 7
    //   143: invokeinterface 143 1 0
    //   148: invokevirtual 147	java/util/Random:nextInt	(I)I
    //   151: invokeinterface 150 2 0
    //   156: checkcast 152	com/tencent/mobileqq/olympic/OlympicActConfig$CityImage
    //   159: astore 7
    //   161: aload_0
    //   162: getfield 56	com/tencent/mobileqq/olympic/OlympicActConfig:mChosenCityImageList	Ljava/util/ArrayList;
    //   165: aload 7
    //   167: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: ldc 16
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: ldc 158
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 7
    //   186: invokevirtual 161	com/tencent/mobileqq/olympic/OlympicActConfig$CityImage:toString	()Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -101 -> 92
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 16
    //   210: iconst_2
    //   211: ldc 67
    //   213: aload_1
    //   214: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: lconst_0
    //   218: lstore_2
    //   219: goto -192 -> 27
    //   222: aload_0
    //   223: monitorexit
    //   224: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	OlympicActConfig
    //   0	225	1	paramAppRuntime	AppRuntime
    //   26	193	2	l1	long
    //   42	6	4	l2	long
    //   74	29	6	localObject1	Object
    //   112	73	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	196	finally
    //   16	27	196	finally
    //   27	44	196	finally
    //   54	58	196	finally
    //   58	92	196	finally
    //   92	193	196	finally
    //   202	217	196	finally
    //   16	27	201	java/lang/Throwable
  }
  
  public static boolean deleteFile(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        atiu.b("OlympicActConfig", new Object[] { "deleteFile()" });
        if (paramQQAppInterface == null)
        {
          atiu.b("OlympicActConfig", new Object[] { "deleteFile(), app is null" });
          return bool;
        }
        paramQQAppInterface = paramContext.getFileStreamPath("olympic_act_cfg_" + paramQQAppInterface.getCurrentAccountUin());
        if (!paramQQAppInterface.exists()) {
          atiu.b("OlympicActConfig", new Object[] { "deleteFile, config file not exist" });
        } else {
          bool = paramQQAppInterface.delete();
        }
      }
      finally {}
    }
  }
  
  public static OlympicActConfig parse(AppRuntime paramAppRuntime, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      atiu.b("OlympicActConfig", new Object[] { "parse(), xmlContent is empty" });
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    OlympicActConfig localOlympicActConfig = new OlympicActConfig();
    localObject1 = "";
    localObject4 = null;
    atiu.b("OlympicActConfig", new Object[] { "parse(), start parse" });
    localObject5 = localObject1;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        localObject5 = localObject1;
        i = localXmlPullParser.getEventType();
        localObject2 = null;
        paramString = "";
        localObject1 = null;
        localObject3 = null;
      }
      catch (Exception paramString)
      {
        paramAppRuntime = (AppRuntime)localObject5;
        continue;
        continue;
        continue;
        int i = -1;
        continue;
        if (i == 1) {
          continue;
        }
        localObject5 = localObject4;
        switch (i)
        {
        case 0: 
        case 4: 
        case 2: 
        default: 
          localObject5 = localObject4;
        }
        localObject4 = localObject3;
        Object localObject3 = localObject2;
        Object localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject5;
        continue;
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject5;
        continue;
        localObject5 = null;
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject5;
        continue;
      }
      localObject5 = paramString;
      i = localXmlPullParser.next();
      localObject5 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject5;
      continue;
      localObject5 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      localObject5 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      try
      {
        String str = localXmlPullParser.getName();
        atiu.b("OlympicActConfig", new Object[] { "startTag=", str, ", depth=", Integer.valueOf(localXmlPullParser.getDepth()) });
        if ("Olympic".equalsIgnoreCase(str))
        {
          localObject5 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject5;
        }
        else
        {
          Object localObject6;
          if (localXmlPullParser.getDepth() == 2)
          {
            localObject6 = localObject1;
            localObject5 = localObject2;
            paramString = str;
            localObject1 = localObject3;
            localObject2 = localObject6;
            localObject3 = localObject5;
          }
          else if ("TorchImage".equalsIgnoreCase(paramString))
          {
            if ("companyId".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.TorchImage();
              ((OlympicActConfig.TorchImage)localObject5).hasBg = true;
              ((OlympicActConfig.TorchImage)localObject5).companyId = tryParseInt(localXmlPullParser.nextText());
              localObject2 = localObject3;
              localObject3 = localObject5;
              localObject5 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject5;
            }
            else if ("FileUrl".equalsIgnoreCase(str))
            {
              if (localObject2 != null)
              {
                localObject2.url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "TorchImage, FileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"FileMd5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject2 != null)
              {
                localObject2.md5 = localXmlPullParser.nextText();
                localOlympicActConfig.mTorchImageMap.put(localObject2.companyId + "", localObject2);
                localObject5 = null;
                localObject2 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "TorchImage, FileMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
          }
          else if (("CityImage".equalsIgnoreCase(paramString)) || ("City2Image".equalsIgnoreCase(paramString)))
          {
            if ("companyId".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.CityImage();
              ((OlympicActConfig.CityImage)localObject5).companyId = tryParseInt(localXmlPullParser.nextText());
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
            }
            else if ("PicId".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).picId = tryParseLong(localXmlPullParser.nextText());
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "CityImage, PicId 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("FileUrl".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "CityImage, FileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("FileMd5".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).md5 = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "CityImage, FileMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("StarFileUrl".equalsIgnoreCase(str))
            {
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).starUrl = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "CityImage, StarFileUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"StarFileMd5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject1 != null)
              {
                ((OlympicActConfig.CityImage)localObject1).starMd5 = localXmlPullParser.nextText();
                if ("CityImage".equalsIgnoreCase(paramString))
                {
                  i = 1;
                  if (i <= 0) {
                    continue;
                  }
                  localObject6 = (List)localOlympicActConfig.mAllCityImageMap.get(Integer.valueOf(i));
                  localObject5 = localObject6;
                  if (localObject6 == null) {
                    localObject5 = new ArrayList();
                  }
                  ((List)localObject5).add(localObject1);
                  localOlympicActConfig.mAllCityImageMap.put(Integer.valueOf(i), localObject5);
                  localObject1 = null;
                  continue;
                }
                if (!"City2Image".equalsIgnoreCase(paramString)) {
                  continue;
                }
                i = 2;
                continue;
              }
              atiu.b("OlympicActConfig", new Object[] { "CityImage, StarFileMd5 错误的tag顺序!" });
              localObject5 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
          }
          else if ("HomePageBG".equalsIgnoreCase(paramString))
          {
            if ("Cityid".equalsIgnoreCase(str))
            {
              localObject5 = new OlympicActConfig.HomePageBg();
              ((OlympicActConfig.HomePageBg)localObject5).cityId = localXmlPullParser.nextText();
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
            else if ("Url".equalsIgnoreCase(str))
            {
              if (localObject3 != null)
              {
                localObject3.url = localXmlPullParser.nextText();
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "HomePageBG, Url 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"Md5".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject3 != null)
              {
                localObject3.md5 = localXmlPullParser.nextText();
                localOlympicActConfig.mCityBgMap.put(localObject3.cityId, localObject3);
                localObject5 = null;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "HomePageBG, Md5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
          }
          else if ("BusiBanner".equalsIgnoreCase(paramString))
          {
            if ("BannerId".equalsIgnoreCase(str))
            {
              localObject4 = new OlympicActConfig.BusiBanner();
              ((OlympicActConfig.BusiBanner)localObject4).BannerId = localXmlPullParser.nextText();
              localObject5 = localObject4;
              if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).BannerId)) {
                continue;
              }
              localObject5 = null;
              atiu.b("OlympicActConfig", new Object[] { "BannerId is empty" });
              localObject4 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject4;
              localObject4 = localObject5;
            }
            else if ("Text".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).Text = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).Text)) {
                  continue;
                }
                localObject5 = null;
                atiu.b("OlympicActConfig", new Object[] { "Text is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "BusiBanner, Text 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("RemindText".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).RemindText = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).RemindText)) {
                  continue;
                }
                localObject5 = null;
                atiu.b("OlympicActConfig", new Object[] { "RemindText is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "BusiBanner, RemindText 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("ImgUrl".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).ImgUrl = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).ImgUrl)) {
                  continue;
                }
                localObject5 = null;
                atiu.b("OlympicActConfig", new Object[] { "ImgUrl is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "BusiBanner, ImgUrl 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else if ("ImgMd5".equalsIgnoreCase(str))
            {
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).ImgMd5 = localXmlPullParser.nextText();
                localObject5 = localObject4;
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).ImgMd5)) {
                  continue;
                }
                localObject5 = null;
                atiu.b("OlympicActConfig", new Object[] { "ImgMd5 is empty" });
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject5;
              }
              else
              {
                atiu.b("OlympicActConfig", new Object[] { "BusiBanner, ImgMd5 错误的tag顺序!" });
                localObject5 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject5;
              }
            }
            else
            {
              localObject5 = localObject4;
              if (!"BusiBannerJump".equalsIgnoreCase(str)) {
                continue;
              }
              if (localObject4 != null)
              {
                ((OlympicActConfig.BusiBanner)localObject4).BusiBannerJump = localXmlPullParser.nextText();
                if (!TextUtils.isEmpty(((OlympicActConfig.BusiBanner)localObject4).BusiBannerJump)) {
                  continue;
                }
                localObject4 = null;
                atiu.b("OlympicActConfig", new Object[] { "BusiBannerJump is empty" });
                if (localObject4 == null) {
                  continue;
                }
                localOlympicActConfig.mBusiBannerMap.put(((OlympicActConfig.BusiBanner)localObject4).BannerId, localObject4);
                continue;
              }
              atiu.b("OlympicActConfig", new Object[] { "BusiBanner, BusiBannerJump 错误的tag顺序!" });
              localObject5 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject5;
            }
          }
          else
          {
            localObject5 = localXmlPullParser.nextText();
            localOlympicActConfig.mConfigs.put(paramString + "_" + str, localObject5);
            localObject5 = localObject4;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        localObject1 = paramString;
        paramString = paramAppRuntime;
        paramAppRuntime = (AppRuntime)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = "null";
      }
      QLog.d("OlympicActConfig", 2, new Object[] { "parse(), prefix=", localObject1, ", exception=, ", paramString });
    }
    for (;;)
    {
      for (paramAppRuntime = null;; paramAppRuntime = localOlympicActConfig)
      {
        atiu.b("OlympicActConfig", new Object[] { "parse(), end parse" });
        return paramAppRuntime;
        localOlympicActConfig.a(paramAppRuntime);
      }
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = "null";
      }
      QLog.d("OlympicActConfig", 1, new Object[] { "parse(), prefix=", localObject1, ", exception=, ", paramString.getMessage() });
    }
  }
  
  /* Error */
  public static OlympicActConfig readFromFile(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 16
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 440
    //   18: aastore
    //   19: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ifnonnull +25 -> 48
    //   26: ldc 16
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 442
    //   37: aastore
    //   38: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_2
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: areturn
    //   48: aload_1
    //   49: new 178	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   56: ldc 13
    //   58: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   65: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 193	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 198	java/io/File:exists	()Z
    //   79: ifne +29 -> 108
    //   82: ldc 16
    //   84: iconst_1
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc_w 444
    //   93: aastore
    //   94: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: astore_0
    //   99: goto -56 -> 43
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    //   108: ldc_w 445
    //   111: newarray byte
    //   113: astore_2
    //   114: new 447	java/io/FileInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore_1
    //   123: aload_1
    //   124: aload_2
    //   125: invokevirtual 454	java/io/FileInputStream:read	([B)I
    //   128: pop
    //   129: new 456	java/io/ObjectInputStream
    //   132: dup
    //   133: new 228	java/io/ByteArrayInputStream
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 235	java/io/ByteArrayInputStream:<init>	([B)V
    //   141: invokespecial 459	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: astore 5
    //   146: aload 5
    //   148: astore_3
    //   149: aload_1
    //   150: astore_2
    //   151: aload 5
    //   153: invokevirtual 462	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   156: checkcast 2	com/tencent/mobileqq/olympic/OlympicActConfig
    //   159: astore 4
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 465	java/io/FileInputStream:close	()V
    //   169: aload 4
    //   171: astore_0
    //   172: aload 5
    //   174: ifnull +11 -> 185
    //   177: aload 5
    //   179: invokevirtual 466	java/io/ObjectInputStream:close	()V
    //   182: aload 4
    //   184: astore_0
    //   185: goto -142 -> 43
    //   188: astore_0
    //   189: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -23 -> 169
    //   195: aload_0
    //   196: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   199: goto -30 -> 169
    //   202: astore_1
    //   203: aload 4
    //   205: astore_0
    //   206: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -24 -> 185
    //   212: aload_1
    //   213: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   216: aload 4
    //   218: astore_0
    //   219: goto -34 -> 185
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_0
    //   229: astore_3
    //   230: aload_1
    //   231: astore_2
    //   232: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +18 -> 253
    //   238: aload_0
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: ldc 16
    //   244: iconst_2
    //   245: ldc_w 471
    //   248: aload 4
    //   250: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 465	java/io/FileInputStream:close	()V
    //   261: aload_0
    //   262: ifnull +116 -> 378
    //   265: aload_0
    //   266: invokevirtual 466	java/io/ObjectInputStream:close	()V
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -86 -> 185
    //   274: astore_1
    //   275: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq -17 -> 261
    //   281: aload_1
    //   282: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   285: goto -24 -> 261
    //   288: astore_0
    //   289: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -116 -> 185
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_1
    //   307: aload_1
    //   308: ifnull +7 -> 315
    //   311: aload_1
    //   312: invokevirtual 465	java/io/FileInputStream:close	()V
    //   315: aload_3
    //   316: ifnull +7 -> 323
    //   319: aload_3
    //   320: invokevirtual 466	java/io/ObjectInputStream:close	()V
    //   323: aload_0
    //   324: athrow
    //   325: astore_1
    //   326: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -14 -> 315
    //   332: aload_1
    //   333: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   336: goto -21 -> 315
    //   339: astore_1
    //   340: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq -20 -> 323
    //   346: aload_1
    //   347: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   350: goto -27 -> 323
    //   353: astore_0
    //   354: goto -47 -> 307
    //   357: astore_0
    //   358: aload_2
    //   359: astore_1
    //   360: goto -53 -> 307
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_0
    //   367: goto -139 -> 228
    //   370: astore 4
    //   372: aload 5
    //   374: astore_0
    //   375: goto -147 -> 228
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -195 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramQQAppInterface	QQAppInterface
    //   0	383	1	paramContext	Context
    //   3	356	2	localObject1	Object
    //   1	319	3	localObject2	Object
    //   159	58	4	localOlympicActConfig	OlympicActConfig
    //   222	27	4	localException1	Exception
    //   363	1	4	localException2	Exception
    //   370	1	4	localException3	Exception
    //   144	229	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   7	22	102	finally
    //   26	41	102	finally
    //   48	97	102	finally
    //   165	169	102	finally
    //   177	182	102	finally
    //   189	199	102	finally
    //   206	216	102	finally
    //   257	261	102	finally
    //   265	269	102	finally
    //   275	285	102	finally
    //   289	299	102	finally
    //   311	315	102	finally
    //   319	323	102	finally
    //   323	325	102	finally
    //   326	336	102	finally
    //   340	350	102	finally
    //   165	169	188	java/io/IOException
    //   177	182	202	java/io/IOException
    //   108	123	222	java/lang/Exception
    //   257	261	274	java/io/IOException
    //   265	269	288	java/io/IOException
    //   108	123	304	finally
    //   311	315	325	java/io/IOException
    //   319	323	339	java/io/IOException
    //   123	146	353	finally
    //   151	161	357	finally
    //   232	238	357	finally
    //   242	253	357	finally
    //   123	146	363	java/lang/Exception
    //   151	161	370	java/lang/Exception
  }
  
  public static int tryParseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      atiu.b("OlympicActConfig", new Object[] { "tryParseInt, exception, str=", paramString });
    }
    return -1;
  }
  
  public static long tryParseLong(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      atiu.b("OlympicActConfig", new Object[] { "tryParseInt, exception, str=", paramString });
    }
    return -1L;
  }
  
  public OlympicActConfig.BusiBanner getBusiBanner(int paramInt)
  {
    if (this.mBusiBannerMap == null) {
      return null;
    }
    String str2 = Integer.toString(paramInt);
    String str1 = str2;
    if (paramInt < 10) {
      str1 = "0" + str2;
    }
    if (this.mBusiBannerMap.containsKey(str1)) {
      return (OlympicActConfig.BusiBanner)this.mBusiBannerMap.get(str1);
    }
    return null;
  }
  
  public ArrayList<OlympicActConfig.CityImage> getChosenCityImageList()
  {
    return this.mChosenCityImageList;
  }
  
  public String getConfigString(String paramString1, String paramString2)
  {
    if (this.mConfigs == null) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    return (String)this.mConfigs.get(paramString1);
  }
  
  public OlympicActConfig.HomePageBg getHomePageBg(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mCityBgMap != null))
    {
      paramString = "0" + paramString;
      if (this.mCityBgMap.containsKey(paramString)) {
        return (OlympicActConfig.HomePageBg)this.mCityBgMap.get(paramString);
      }
    }
    return null;
  }
  
  public Map<String, OlympicActConfig.TorchImage> getTorchImageMap()
  {
    return this.mTorchImageMap;
  }
  
  /* Error */
  public boolean save2File(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc 16
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 502
    //   19: aastore
    //   20: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: ifnonnull +25 -> 49
    //   27: ldc 16
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 504
    //   38: aastore
    //   39: invokestatic 73	atiu:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: iload 4
    //   44: istore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: aload_2
    //   50: new 178	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   57: ldc 13
    //   59: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   66: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 193	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   75: astore 8
    //   77: aload_2
    //   78: new 178	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   85: ldc 13
    //   87: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   94: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 506
    //   100: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 193	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   109: astore_1
    //   110: aload 8
    //   112: invokevirtual 510	java/io/File:getParentFile	()Ljava/io/File;
    //   115: invokevirtual 513	java/io/File:mkdirs	()Z
    //   118: pop
    //   119: aload_1
    //   120: invokevirtual 516	java/io/File:createNewFile	()Z
    //   123: pop
    //   124: new 518	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 519	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore 6
    //   134: new 521	java/io/ByteArrayOutputStream
    //   137: dup
    //   138: ldc_w 445
    //   141: invokespecial 524	java/io/ByteArrayOutputStream:<init>	(I)V
    //   144: astore 5
    //   146: new 526	java/io/ObjectOutputStream
    //   149: dup
    //   150: aload 5
    //   152: invokespecial 529	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   155: astore_2
    //   156: aload_2
    //   157: aload_0
    //   158: invokevirtual 533	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   161: aload_2
    //   162: invokevirtual 536	java/io/ObjectOutputStream:flush	()V
    //   165: aload 5
    //   167: aload 6
    //   169: invokevirtual 539	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   172: aload 5
    //   174: invokevirtual 540	java/io/ByteArrayOutputStream:flush	()V
    //   177: aload 6
    //   179: invokevirtual 541	java/io/FileOutputStream:flush	()V
    //   182: aload 8
    //   184: invokevirtual 198	java/io/File:exists	()Z
    //   187: ifeq +9 -> 196
    //   190: aload 8
    //   192: invokevirtual 203	java/io/File:delete	()Z
    //   195: pop
    //   196: aload_1
    //   197: aload 8
    //   199: invokevirtual 545	java/io/File:renameTo	(Ljava/io/File;)Z
    //   202: istore_3
    //   203: iload_3
    //   204: istore 4
    //   206: aload 6
    //   208: ifnull +8 -> 216
    //   211: aload 6
    //   213: invokevirtual 546	java/io/FileOutputStream:close	()V
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 547	java/io/ObjectOutputStream:close	()V
    //   224: iload 4
    //   226: istore_3
    //   227: aload 5
    //   229: ifnull -184 -> 45
    //   232: aload 5
    //   234: invokevirtual 548	java/io/ByteArrayOutputStream:close	()V
    //   237: iload 4
    //   239: istore_3
    //   240: goto -195 -> 45
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   248: iload 4
    //   250: istore_3
    //   251: goto -206 -> 45
    //   254: astore_1
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_1
    //   258: athrow
    //   259: astore_1
    //   260: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -47 -> 216
    //   266: aload_1
    //   267: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   270: goto -54 -> 216
    //   273: astore_1
    //   274: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -53 -> 224
    //   280: aload_1
    //   281: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   284: goto -60 -> 224
    //   287: astore 5
    //   289: aconst_null
    //   290: astore 6
    //   292: aconst_null
    //   293: astore_1
    //   294: aload 7
    //   296: astore_2
    //   297: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +14 -> 314
    //   303: ldc 16
    //   305: iconst_2
    //   306: ldc_w 550
    //   309: aload 5
    //   311: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: aload 6
    //   316: ifnull +8 -> 324
    //   319: aload 6
    //   321: invokevirtual 546	java/io/FileOutputStream:close	()V
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 547	java/io/ObjectOutputStream:close	()V
    //   332: iload 4
    //   334: istore_3
    //   335: aload_2
    //   336: ifnull -291 -> 45
    //   339: aload_2
    //   340: invokevirtual 548	java/io/ByteArrayOutputStream:close	()V
    //   343: iload 4
    //   345: istore_3
    //   346: goto -301 -> 45
    //   349: astore_1
    //   350: aload_1
    //   351: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   354: iload 4
    //   356: istore_3
    //   357: goto -312 -> 45
    //   360: astore 5
    //   362: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -41 -> 324
    //   368: aload 5
    //   370: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   373: goto -49 -> 324
    //   376: astore_1
    //   377: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq -48 -> 332
    //   383: aload_1
    //   384: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   387: goto -55 -> 332
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 6
    //   394: aconst_null
    //   395: astore 5
    //   397: aconst_null
    //   398: astore_2
    //   399: aload 6
    //   401: ifnull +8 -> 409
    //   404: aload 6
    //   406: invokevirtual 546	java/io/FileOutputStream:close	()V
    //   409: aload_2
    //   410: ifnull +7 -> 417
    //   413: aload_2
    //   414: invokevirtual 547	java/io/ObjectOutputStream:close	()V
    //   417: aload 5
    //   419: ifnull +8 -> 427
    //   422: aload 5
    //   424: invokevirtual 548	java/io/ByteArrayOutputStream:close	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore 6
    //   431: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -25 -> 409
    //   437: aload 6
    //   439: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   442: goto -33 -> 409
    //   445: astore_2
    //   446: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq -32 -> 417
    //   452: aload_2
    //   453: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   456: goto -39 -> 417
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   464: goto -37 -> 427
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 5
    //   471: aconst_null
    //   472: astore_2
    //   473: goto -74 -> 399
    //   476: astore_1
    //   477: aconst_null
    //   478: astore_2
    //   479: goto -80 -> 399
    //   482: astore_1
    //   483: goto -84 -> 399
    //   486: astore 5
    //   488: aload_1
    //   489: astore 7
    //   491: aload 5
    //   493: astore_1
    //   494: aload_2
    //   495: astore 5
    //   497: aload 7
    //   499: astore_2
    //   500: goto -101 -> 399
    //   503: astore 5
    //   505: aconst_null
    //   506: astore_1
    //   507: aload 7
    //   509: astore_2
    //   510: goto -213 -> 297
    //   513: astore 7
    //   515: aconst_null
    //   516: astore_1
    //   517: aload 5
    //   519: astore_2
    //   520: aload 7
    //   522: astore 5
    //   524: goto -227 -> 297
    //   527: astore 8
    //   529: aload 5
    //   531: astore_1
    //   532: aload_2
    //   533: astore 7
    //   535: aload 8
    //   537: astore 5
    //   539: aload_1
    //   540: astore_2
    //   541: aload 7
    //   543: astore_1
    //   544: goto -247 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	OlympicActConfig
    //   0	547	1	paramQQAppInterface	QQAppInterface
    //   0	547	2	paramContext	Context
    //   44	313	3	bool1	boolean
    //   4	351	4	bool2	boolean
    //   144	89	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   287	23	5	localException1	Exception
    //   360	9	5	localIOException1	java.io.IOException
    //   395	75	5	localObject1	Object
    //   486	6	5	localObject2	Object
    //   495	1	5	localContext1	Context
    //   503	15	5	localException2	Exception
    //   522	16	5	localException3	Exception
    //   132	273	6	localFileOutputStream	java.io.FileOutputStream
    //   429	9	6	localIOException2	java.io.IOException
    //   1	507	7	localQQAppInterface	QQAppInterface
    //   513	8	7	localException4	Exception
    //   533	9	7	localContext2	Context
    //   75	123	8	localFile	File
    //   527	9	8	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   232	237	243	java/io/IOException
    //   8	23	254	finally
    //   27	42	254	finally
    //   49	119	254	finally
    //   211	216	254	finally
    //   220	224	254	finally
    //   232	237	254	finally
    //   244	248	254	finally
    //   260	270	254	finally
    //   274	284	254	finally
    //   319	324	254	finally
    //   328	332	254	finally
    //   339	343	254	finally
    //   350	354	254	finally
    //   362	373	254	finally
    //   377	387	254	finally
    //   404	409	254	finally
    //   413	417	254	finally
    //   422	427	254	finally
    //   427	429	254	finally
    //   431	442	254	finally
    //   446	456	254	finally
    //   460	464	254	finally
    //   211	216	259	java/io/IOException
    //   220	224	273	java/io/IOException
    //   119	134	287	java/lang/Exception
    //   339	343	349	java/io/IOException
    //   319	324	360	java/io/IOException
    //   328	332	376	java/io/IOException
    //   119	134	390	finally
    //   404	409	429	java/io/IOException
    //   413	417	445	java/io/IOException
    //   422	427	459	java/io/IOException
    //   134	146	467	finally
    //   146	156	476	finally
    //   156	196	482	finally
    //   196	203	482	finally
    //   297	314	486	finally
    //   134	146	503	java/lang/Exception
    //   146	156	513	java/lang/Exception
    //   156	196	527	java/lang/Exception
    //   196	203	527	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=").append(this.version);
    if (QLog.isColorLevel())
    {
      Iterator localIterator;
      Object localObject;
      if (this.mConfigs != null)
      {
        localIterator = this.mConfigs.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          localStringBuilder.append(", ").append((String)localObject).append((String)this.mConfigs.get(localObject));
        }
      }
      if (this.mTorchImageMap != null)
      {
        localIterator = this.mTorchImageMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          localStringBuilder.append(", ").append((String)localObject).append(this.mTorchImageMap.get(localObject));
        }
      }
      if (this.mAllCityImageMap != null)
      {
        localIterator = this.mAllCityImageMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Integer)localIterator.next();
          localStringBuilder.append(", ").append(localObject).append(this.mAllCityImageMap.get(localObject));
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicActConfig
 * JD-Core Version:    0.7.0.1
 */