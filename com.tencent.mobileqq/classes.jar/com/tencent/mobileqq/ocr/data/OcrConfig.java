package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class OcrConfig
  implements Parcelable, Serializable
{
  public static final String CHINESE = "zh";
  public static final Parcelable.Creator<OcrConfig> CREATOR = new OcrConfig.1();
  public static final String DEFAULT_SUPPORT_LANGUAGE = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th";
  public static final String ENGLISH = "en";
  public static final String TAG = "OcrConfig";
  private static final HashMap<String, String> a = new HashMap();
  public int aioOcrOpen = 0;
  public String aioText;
  public int chatFileOcrOpen = 0;
  public long endTime;
  public String iconMd5;
  public String iconPressMD5;
  public String iconPressUrl;
  public String iconText;
  public String iconUrl;
  public int questionResultOpen = 0;
  public int questionScanOpen = 0;
  public int qzoneOcrOpen = 0;
  public int scanOcrOpen = 0;
  public long startTime;
  public String tips;
  public HashMap<String, String> translateLanguageNames;
  public HashMap<String, List<String>> translateSupportLanguages;
  public int version = 0;
  
  static
  {
    a.put("zh", HardCodeUtil.a(2131905511));
    a.put("en", HardCodeUtil.a(2131905523));
    a.put("af", HardCodeUtil.a(2131905552));
    a.put("ar", HardCodeUtil.a(2131905568));
    a.put("eu", HardCodeUtil.a(2131905533));
    a.put("be", HardCodeUtil.a(2131905547));
    a.put("hr", HardCodeUtil.a(2131905521));
    a.put("da", HardCodeUtil.a(2131905566));
    a.put("nl", HardCodeUtil.a(2131905528));
    a.put("fo", HardCodeUtil.a(2131905517));
    a.put("fi", HardCodeUtil.a(2131905532));
    a.put("fr", HardCodeUtil.a(2131905537));
    a.put("gd", HardCodeUtil.a(2131905545));
    a.put("de", HardCodeUtil.a(2131905524));
    a.put("he", HardCodeUtil.a(2131905555));
    a.put("hu", HardCodeUtil.a(2131905560));
    a.put("id", HardCodeUtil.a(2131905543));
    a.put("it", HardCodeUtil.a(2131905531));
    a.put("kr", HardCodeUtil.a(2131905558));
    a.put("ko", HardCodeUtil.a(2131905541));
    a.put("lv", HardCodeUtil.a(2131905570));
    a.put("mk", HardCodeUtil.a(2131905546));
    a.put("mt", HardCodeUtil.a(2131905535));
    a.put("no", HardCodeUtil.a(2131905559));
    a.put("pt", HardCodeUtil.a(2131905556));
    a.put("rm", HardCodeUtil.a(2131905554));
    a.put("ro", HardCodeUtil.a(2131905538));
    a.put("sr", HardCodeUtil.a(2131905569));
    a.put("sk", HardCodeUtil.a(2131905550));
    a.put("sb", HardCodeUtil.a(2131905536));
    a.put("es", HardCodeUtil.a(2131905542));
    a.put("sx", HardCodeUtil.a(2131905551));
    a.put("sv", HardCodeUtil.a(2131905548));
    a.put("ts", HardCodeUtil.a(2131905525));
    a.put("tr", HardCodeUtil.a(2131905515));
    a.put("ur", HardCodeUtil.a(2131905510));
    a.put("vi", HardCodeUtil.a(2131905562));
    a.put("ji", HardCodeUtil.a(2131905519));
    a.put("sq", HardCodeUtil.a(2131905534));
    a.put("bg", HardCodeUtil.a(2131905539));
    a.put("ca", HardCodeUtil.a(2131905518));
    a.put("cs", HardCodeUtil.a(2131905563));
    a.put("et", HardCodeUtil.a(2131905564));
    a.put("fa", HardCodeUtil.a(2131905520));
    a.put("ga", HardCodeUtil.a(2131905557));
    a.put("el", HardCodeUtil.a(2131905516));
    a.put("hi", HardCodeUtil.a(2131905530));
    a.put("is", HardCodeUtil.a(2131905514));
    a.put("jp", HardCodeUtil.a(2131905565));
    a.put("ja", HardCodeUtil.a(2131905567));
    a.put("lt", HardCodeUtil.a(2131905553));
    a.put("ms", HardCodeUtil.a(2131905529));
    a.put("pl", HardCodeUtil.a(2131905544));
    a.put("ru", HardCodeUtil.a(2131905549));
    a.put("sz", HardCodeUtil.a(2131905561));
    a.put("sl", HardCodeUtil.a(2131905540));
    a.put("th", HardCodeUtil.a(2131905509));
    a.put("tn", HardCodeUtil.a(2131905512));
    a.put("uk", HardCodeUtil.a(2131905522));
    a.put("ve", HardCodeUtil.a(2131905571));
    a.put("xh", HardCodeUtil.a(2131905527));
    a.put("zu", HardCodeUtil.a(2131905526));
    a.put("jap", HardCodeUtil.a(2131905565));
    a.put("unk", HardCodeUtil.a(2131905513));
  }
  
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
    this.chatFileOcrOpen = paramParcel.readInt();
  }
  
  public static void deleteLocalConfig(String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocr_config_");
    localStringBuilder.append(paramString);
    paramString = ((MobileQQ)localObject).getFileStreamPath(localStringBuilder.toString());
    if (paramString.exists()) {
      paramString.delete();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteLocalConfig path:");
      ((StringBuilder)localObject).append(paramString.getAbsolutePath());
      QLog.d("OcrConfig", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static String getDefaultLanguageName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return HardCodeUtil.a(2131905513);
    }
    String str2 = (String)a.get(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131905513);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OcrConfig", 2, String.format("getDefaultLanguageName, code:%s, name:%s", new Object[] { paramString, str1 }));
    }
    return str1;
  }
  
  public static List<String> getDefaultSupportLanguages(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramString.equalsIgnoreCase("zh"))
    {
      paramString = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".split("/");
      if (paramString.length > 0) {
        Collections.addAll(localArrayList, paramString);
      }
    }
    else
    {
      localArrayList.add("zh");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getDefaultSupportLanguages, list = ");
      paramString.append(localArrayList);
      QLog.d("OcrConfig", 2, paramString.toString());
    }
    return localArrayList;
  }
  
  public static OcrConfig parse(String paramString)
  {
    Object localObject2 = "QuestionCfg";
    Object localObject1 = "QzoneCfg";
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("OcrConfig.parse, xmlContent:");
      ((StringBuilder)localObject3).append(paramString);
      QLog.d("OcrConfig", 2, ((StringBuilder)localObject3).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    OcrConfig localOcrConfig = new OcrConfig();
    int i;
    try
    {
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = localXmlPullParser.getEventType();
      paramString = (String)localObject2;
    }
    catch (Exception paramString)
    {
      boolean bool;
      if (!QLog.isColorLevel()) {
        break label1664;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse exception:");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.d("OcrConfig", 2, ((StringBuilder)localObject1).toString());
      return null;
    }
    String str = localXmlPullParser.getName();
    if (str.equalsIgnoreCase("ScanCfg")) {
      for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          localObject2 = localXmlPullParser.getName();
          if (((String)localObject2).equalsIgnoreCase("ScanOcrOpen")) {
            localOcrConfig.scanOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
          } else if (((String)localObject2).equalsIgnoreCase("ScanIconImg")) {
            localOcrConfig.iconUrl = localXmlPullParser.nextText();
          } else if (((String)localObject2).equalsIgnoreCase("ScanIconMd5")) {
            localOcrConfig.iconMd5 = localXmlPullParser.nextText();
          } else if (((String)localObject2).equalsIgnoreCase("ScanIconPressed")) {
            localOcrConfig.iconPressUrl = localXmlPullParser.nextText();
          } else if (((String)localObject2).equalsIgnoreCase("ScanIconPressedMd5")) {
            localOcrConfig.iconPressMD5 = localXmlPullParser.nextText();
          } else if (((String)localObject2).equalsIgnoreCase("ScanIconText")) {
            localOcrConfig.iconText = localXmlPullParser.nextText();
          } else if (((String)localObject2).equalsIgnoreCase("Scan_Line1")) {
            localOcrConfig.tips = localXmlPullParser.nextText();
          }
        }
        else if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase("ScanCfg")))
        {
          localObject3 = paramString;
          localObject2 = localObject1;
          break;
        }
      }
    }
    if (str.equalsIgnoreCase("AioCfg")) {
      for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          localObject2 = localXmlPullParser.getName();
          if (((String)localObject2).equalsIgnoreCase("AioOcrOpen")) {
            localOcrConfig.aioOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
          } else if (((String)localObject2).equalsIgnoreCase("AioText")) {
            localOcrConfig.aioText = localXmlPullParser.nextText();
          }
        }
        else if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase("AioCfg")))
        {
          localObject3 = paramString;
          localObject2 = localObject1;
          break;
        }
      }
    }
    if (str.equalsIgnoreCase("ChatFileCfg")) {
      for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          if (localXmlPullParser.getName().equalsIgnoreCase("ChatFileOcrOpen")) {
            localOcrConfig.chatFileOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
          }
        }
        else if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase("ChatFileCfg")))
        {
          localObject3 = paramString;
          localObject2 = localObject1;
          break;
        }
      }
    }
    if (str.equalsIgnoreCase((String)localObject1)) {
      for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          if (localXmlPullParser.getName().equalsIgnoreCase("QzoneOcrOpen")) {
            localOcrConfig.qzoneOcrOpen = Integer.parseInt(localXmlPullParser.nextText());
          }
        }
        else if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase((String)localObject1)))
        {
          localObject3 = paramString;
          localObject2 = localObject1;
          break;
        }
      }
    }
    if (str.equalsIgnoreCase(paramString)) {
      for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          localObject2 = localXmlPullParser.getName();
          if (((String)localObject2).equalsIgnoreCase("ScanEnter")) {
            localOcrConfig.questionScanOpen = Integer.parseInt(localXmlPullParser.nextText());
          } else if (((String)localObject2).equalsIgnoreCase("ResultPageEnter")) {
            localOcrConfig.questionResultOpen = Integer.parseInt(localXmlPullParser.nextText());
          }
        }
        else if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase(paramString)))
        {
          localObject3 = paramString;
          localObject2 = localObject1;
          break;
        }
      }
    }
    Object localObject3 = paramString;
    localObject2 = localObject1;
    if (str.equalsIgnoreCase("translate"))
    {
      i = localXmlPullParser.next();
      label925:
      localObject3 = paramString;
      localObject2 = localObject1;
      if (i != 1)
      {
        if (i == 2)
        {
          localObject2 = localXmlPullParser.getName();
          bool = ((String)localObject2).equalsIgnoreCase("languages");
          if (bool) {
            for (;;)
            {
              if (i == 1) {
                break label1717;
              }
              if (i == 2)
              {
                str = paramString;
                localObject3 = localObject1;
                if (!localXmlPullParser.getName().equalsIgnoreCase("item")) {
                  break label1710;
                }
                localObject4 = null;
                localObject2 = null;
                for (;;)
                {
                  str = paramString;
                  localObject3 = localObject1;
                  if (i == 1) {
                    break label1710;
                  }
                  if (i == 2)
                  {
                    localObject3 = localXmlPullParser.getName();
                    if (((String)localObject3).equalsIgnoreCase("src"))
                    {
                      localObject4 = localXmlPullParser.nextText();
                    }
                    else
                    {
                      if (!((String)localObject3).equalsIgnoreCase("dst")) {
                        break label1707;
                      }
                      localObject2 = localXmlPullParser.nextText();
                    }
                  }
                  else
                  {
                    if ((i != 3) || (!localXmlPullParser.getName().equalsIgnoreCase("item"))) {
                      break label1707;
                    }
                    str = paramString;
                    localObject3 = localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject4)) {
                      break label1710;
                    }
                    str = paramString;
                    localObject3 = localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label1710;
                    }
                    if (localOcrConfig.translateSupportLanguages == null) {
                      localOcrConfig.translateSupportLanguages = new HashMap();
                    }
                    localObject2 = ((String)localObject2).split("/");
                    str = paramString;
                    localObject3 = localObject1;
                    if (localObject2 == null) {
                      break label1710;
                    }
                    str = paramString;
                    localObject3 = localObject1;
                    if (localObject2.length <= 0) {
                      break label1710;
                    }
                    localObject3 = new ArrayList();
                    int j = localObject2.length;
                    i = 0;
                    while (i < j)
                    {
                      ((List)localObject3).add(localObject2[i]);
                      i += 1;
                    }
                    localOcrConfig.translateSupportLanguages.put(localObject4, localObject3);
                    localObject2 = paramString;
                    localObject3 = localObject1;
                    break;
                  }
                  label1243:
                  i = localXmlPullParser.next();
                }
              }
              str = paramString;
              Object localObject4 = localObject1;
              localObject2 = str;
              localObject3 = localObject4;
              if (i == 3)
              {
                localObject2 = str;
                localObject3 = localObject4;
                if (localXmlPullParser.getName().equalsIgnoreCase("languages")) {
                  break label1717;
                }
              }
              label1301:
              i = localXmlPullParser.next();
              paramString = (String)localObject2;
              localObject1 = localObject3;
            }
          }
          if (!((String)localObject2).equalsIgnoreCase("name")) {
            break label1723;
          }
          label1491:
          for (i = localXmlPullParser.next();; i = localXmlPullParser.next())
          {
            if (i == 1) {
              break label1723;
            }
            if (i == 2)
            {
              if (!localXmlPullParser.getName().equalsIgnoreCase("item")) {
                break;
              }
              localObject2 = localXmlPullParser.nextText();
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              localObject3 = ((String)localObject2).split("-");
              if ((localObject3 == null) || (localObject3.length != 2)) {
                break;
              }
              if (localOcrConfig.translateLanguageNames == null) {
                localOcrConfig.translateLanguageNames = new HashMap();
              }
              localObject2 = localObject3[0];
              localObject3 = localObject3[1];
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
                localOcrConfig.translateLanguageNames.put(localObject2, localObject3);
              }
            }
            else
            {
              if ((i == 3) && (localXmlPullParser.getName().equalsIgnoreCase("name"))) {
                break label1723;
              }
            }
          }
        }
        localObject2 = paramString;
        localObject3 = localObject1;
        paramString = (String)localObject2;
        localObject1 = localObject3;
        if (i == 3)
        {
          paramString = (String)localObject2;
          localObject1 = localObject3;
          if (localXmlPullParser.getName().equalsIgnoreCase("translate")) {
            break label1558;
          }
        }
      }
    }
    label1558:
    label1707:
    label1710:
    label1717:
    label1723:
    for (;;)
    {
      i = localXmlPullParser.next();
      break label925;
      for (;;)
      {
        i = localXmlPullParser.next();
        paramString = (String)localObject2;
        localObject1 = localObject3;
        while (i == 1)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("parse:");
            paramString.append(localOcrConfig);
            QLog.d("OcrConfig", 2, paramString.toString());
          }
          return localOcrConfig;
        }
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i != 0)
        {
          if (i == 2) {
            break;
          }
          localObject2 = localObject1;
          localObject3 = paramString;
        }
        paramString = (String)localObject2;
        localObject2 = localObject3;
        localObject3 = paramString;
      }
      break label1243;
      localObject2 = str;
      break label1301;
      continue;
      break label1491;
    }
  }
  
  /* Error */
  public static OcrConfig readFromFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 24
    //   8: iconst_2
    //   9: ldc_w 512
    //   12: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +20 -> 39
    //   22: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 24
    //   30: iconst_2
    //   31: ldc_w 514
    //   34: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: areturn
    //   39: getstatic 307	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   42: astore_1
    //   43: new 309	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: ldc_w 312
    //   55: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_0
    //   61: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 323	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 329	java/io/File:exists	()Z
    //   78: ifne +20 -> 98
    //   81: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +12 -> 96
    //   87: ldc 24
    //   89: iconst_2
    //   90: ldc_w 516
    //   93: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aconst_null
    //   97: areturn
    //   98: new 518	java/io/FileInputStream
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 521	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore_0
    //   107: new 523	java/io/ObjectInputStream
    //   110: dup
    //   111: new 525	java/io/BufferedInputStream
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 528	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: invokespecial 529	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore 4
    //   124: aload_0
    //   125: astore_1
    //   126: aload 4
    //   128: astore_2
    //   129: aload 4
    //   131: invokevirtual 533	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   134: checkcast 2	com/tencent/mobileqq/ocr/data/OcrConfig
    //   137: astore_3
    //   138: aload_0
    //   139: invokevirtual 536	java/io/FileInputStream:close	()V
    //   142: goto +14 -> 156
    //   145: astore_0
    //   146: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   156: aload 4
    //   158: invokevirtual 540	java/io/ObjectInputStream:close	()V
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +164 -> 333
    //   172: aload_1
    //   173: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   176: aload_3
    //   177: areturn
    //   178: astore_1
    //   179: aload_0
    //   180: astore_3
    //   181: aload 4
    //   183: astore_0
    //   184: aload_1
    //   185: astore 4
    //   187: goto +34 -> 221
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: goto +145 -> 338
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_0
    //   201: astore_3
    //   202: aload_1
    //   203: astore_0
    //   204: goto +17 -> 221
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_0
    //   210: aload_0
    //   211: astore_2
    //   212: goto +126 -> 338
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_3
    //   219: aload_3
    //   220: astore_0
    //   221: aload_3
    //   222: astore_1
    //   223: aload_0
    //   224: astore_2
    //   225: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +59 -> 287
    //   231: aload_3
    //   232: astore_1
    //   233: aload_0
    //   234: astore_2
    //   235: new 309	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   242: astore 5
    //   244: aload_3
    //   245: astore_1
    //   246: aload_0
    //   247: astore_2
    //   248: aload 5
    //   250: ldc_w 542
    //   253: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: astore_1
    //   259: aload_0
    //   260: astore_2
    //   261: aload 5
    //   263: aload 4
    //   265: invokevirtual 507	java/lang/Exception:toString	()Ljava/lang/String;
    //   268: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_3
    //   273: astore_1
    //   274: aload_0
    //   275: astore_2
    //   276: ldc 24
    //   278: iconst_2
    //   279: aload 5
    //   281: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_3
    //   288: ifnull +21 -> 309
    //   291: aload_3
    //   292: invokevirtual 536	java/io/FileInputStream:close	()V
    //   295: goto +14 -> 309
    //   298: astore_1
    //   299: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   309: aload_0
    //   310: ifnull +21 -> 331
    //   313: aload_0
    //   314: invokevirtual 540	java/io/ObjectInputStream:close	()V
    //   317: goto +14 -> 331
    //   320: astore_0
    //   321: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +7 -> 331
    //   327: aload_0
    //   328: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   331: aconst_null
    //   332: astore_0
    //   333: aload_0
    //   334: areturn
    //   335: astore_3
    //   336: aload_1
    //   337: astore_0
    //   338: aload_0
    //   339: ifnull +21 -> 360
    //   342: aload_0
    //   343: invokevirtual 536	java/io/FileInputStream:close	()V
    //   346: goto +14 -> 360
    //   349: astore_0
    //   350: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +7 -> 360
    //   356: aload_0
    //   357: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   360: aload_2
    //   361: ifnull +21 -> 382
    //   364: aload_2
    //   365: invokevirtual 540	java/io/ObjectInputStream:close	()V
    //   368: goto +14 -> 382
    //   371: astore_0
    //   372: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +7 -> 382
    //   378: aload_0
    //   379: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   382: aload_3
    //   383: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   42	84	1	localObject1	Object
    //   163	10	1	localIOException1	java.io.IOException
    //   178	7	1	localException1	Exception
    //   199	75	1	localObject2	Object
    //   298	39	1	localIOException2	java.io.IOException
    //   50	315	2	localObject3	Object
    //   137	44	3	localObject4	Object
    //   190	1	3	localObject5	Object
    //   201	1	3	str	String
    //   207	1	3	localObject6	Object
    //   218	74	3	localObject7	Object
    //   335	48	3	localObject8	Object
    //   122	64	4	localObject9	Object
    //   196	1	4	localException2	Exception
    //   215	49	4	localException3	Exception
    //   242	38	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   138	142	145	java/io/IOException
    //   156	161	163	java/io/IOException
    //   129	138	178	java/lang/Exception
    //   107	124	190	finally
    //   107	124	196	java/lang/Exception
    //   98	107	207	finally
    //   98	107	215	java/lang/Exception
    //   291	295	298	java/io/IOException
    //   313	317	320	java/io/IOException
    //   129	138	335	finally
    //   225	231	335	finally
    //   235	244	335	finally
    //   248	257	335	finally
    //   261	272	335	finally
    //   276	287	335	finally
    //   342	346	349	java/io/IOException
    //   364	368	371	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getTranslateLanguageName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = null;
    HashMap localHashMap = this.translateLanguageNames;
    if (localHashMap != null) {
      str = (String)localHashMap.get(paramString);
    }
    if (TextUtils.isEmpty(str)) {
      str = getDefaultLanguageName(paramString);
    } else {
      QLog.d("OcrConfig", 1, "translateLanguageNames == null");
    }
    if (QLog.isColorLevel()) {
      QLog.d("OcrConfig", 2, String.format("getTranslateLanguageName, code:%s, name:%s", new Object[] { paramString, str }));
    }
    return str;
  }
  
  public List<String> getTranslateSupportLanguages(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    List localList = null;
    if (bool) {
      return null;
    }
    Object localObject = this.translateSupportLanguages;
    if (localObject != null) {
      localList = (List)((HashMap)localObject).get(paramString);
    } else {
      QLog.d("OcrConfig", 1, "translateSupportLanguages == null");
    }
    if (localList != null)
    {
      localObject = localList;
      if (localList.size() != 0) {}
    }
    else
    {
      localObject = getDefaultSupportLanguages(paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getTranslateSupportLanguages, list = ");
      paramString.append(localObject);
      QLog.d("OcrConfig", 2, paramString.toString());
    }
    return localObject;
  }
  
  public boolean isEntryOpen()
  {
    return this.scanOcrOpen == 1;
  }
  
  /* Error */
  public void saveToFile(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 24
    //   15: iconst_2
    //   16: ldc_w 568
    //   19: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: return
    //   23: getstatic 307	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   26: astore_2
    //   27: new 309	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: ldc_w 312
    //   39: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: aload_3
    //   51: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 323	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   57: astore 7
    //   59: getstatic 307	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   62: astore_2
    //   63: new 309	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc_w 312
    //   75: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc_w 570
    //   89: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: aload_3
    //   95: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 323	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   101: astore 9
    //   103: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +39 -> 145
    //   109: new 309	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   116: astore_1
    //   117: aload_1
    //   118: ldc_w 572
    //   121: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: aload 7
    //   128: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 24
    //   137: iconst_2
    //   138: aload_1
    //   139: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 9
    //   147: invokevirtual 329	java/io/File:exists	()Z
    //   150: ifeq +9 -> 159
    //   153: aload 9
    //   155: invokevirtual 332	java/io/File:delete	()Z
    //   158: pop
    //   159: aconst_null
    //   160: astore 8
    //   162: aconst_null
    //   163: astore_3
    //   164: aconst_null
    //   165: astore 4
    //   167: aconst_null
    //   168: astore 5
    //   170: aload 9
    //   172: invokevirtual 575	java/io/File:createNewFile	()Z
    //   175: pop
    //   176: new 577	java/io/FileOutputStream
    //   179: dup
    //   180: aload 9
    //   182: invokespecial 578	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   185: astore_1
    //   186: new 580	java/io/BufferedOutputStream
    //   189: dup
    //   190: aload_1
    //   191: invokespecial 583	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   194: astore_2
    //   195: aload_3
    //   196: astore 4
    //   198: aload_1
    //   199: astore 5
    //   201: aload_2
    //   202: astore 6
    //   204: new 585	java/io/ObjectOutputStream
    //   207: dup
    //   208: aload_2
    //   209: invokespecial 586	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   212: astore_3
    //   213: aload_3
    //   214: aload_0
    //   215: invokevirtual 590	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   218: aload_3
    //   219: invokevirtual 593	java/io/ObjectOutputStream:flush	()V
    //   222: aload 7
    //   224: invokevirtual 329	java/io/File:exists	()Z
    //   227: ifeq +9 -> 236
    //   230: aload 7
    //   232: invokevirtual 332	java/io/File:delete	()Z
    //   235: pop
    //   236: aload 9
    //   238: aload 7
    //   240: invokevirtual 597	java/io/File:renameTo	(Ljava/io/File;)Z
    //   243: pop
    //   244: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +12 -> 259
    //   250: ldc 24
    //   252: iconst_2
    //   253: ldc_w 599
    //   256: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_1
    //   260: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   263: goto +14 -> 277
    //   266: astore_1
    //   267: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   277: aload_2
    //   278: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   289: aload_3
    //   290: invokevirtual 602	java/io/ObjectOutputStream:close	()V
    //   293: return
    //   294: astore_1
    //   295: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +409 -> 707
    //   301: aload_1
    //   302: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   305: return
    //   306: astore 5
    //   308: aload_3
    //   309: astore 4
    //   311: aload 5
    //   313: astore_3
    //   314: goto +212 -> 526
    //   317: astore 5
    //   319: aload_2
    //   320: astore 4
    //   322: aload_3
    //   323: astore_2
    //   324: aload 5
    //   326: astore_3
    //   327: goto +54 -> 381
    //   330: astore 4
    //   332: aload_1
    //   333: astore 7
    //   335: aload 4
    //   337: astore_1
    //   338: goto +201 -> 539
    //   341: astore_3
    //   342: aconst_null
    //   343: astore 5
    //   345: aload_2
    //   346: astore 4
    //   348: aload 5
    //   350: astore_2
    //   351: goto +30 -> 381
    //   354: astore 4
    //   356: aload 8
    //   358: astore_3
    //   359: aload_1
    //   360: astore 7
    //   362: aload 4
    //   364: astore_1
    //   365: goto +174 -> 539
    //   368: astore_3
    //   369: aconst_null
    //   370: astore_2
    //   371: goto +344 -> 715
    //   374: astore_3
    //   375: aconst_null
    //   376: astore 4
    //   378: aload 4
    //   380: astore_2
    //   381: aload_1
    //   382: astore 5
    //   384: aload 4
    //   386: astore_1
    //   387: goto +32 -> 419
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_2
    //   394: aload 8
    //   396: astore_3
    //   397: aload_1
    //   398: astore 7
    //   400: aload 4
    //   402: astore_1
    //   403: goto +136 -> 539
    //   406: astore_3
    //   407: aconst_null
    //   408: astore_1
    //   409: aload_1
    //   410: astore_2
    //   411: goto +304 -> 715
    //   414: astore_3
    //   415: aconst_null
    //   416: astore_1
    //   417: aload_1
    //   418: astore_2
    //   419: new 309	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   426: astore 4
    //   428: aload 4
    //   430: ldc_w 604
    //   433: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 4
    //   439: aload_3
    //   440: invokevirtual 607	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: ldc 24
    //   449: iconst_2
    //   450: aload 4
    //   452: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload 5
    //   460: ifnull +22 -> 482
    //   463: aload 5
    //   465: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   468: goto +14 -> 482
    //   471: astore_3
    //   472: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +7 -> 482
    //   478: aload_3
    //   479: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   482: aload_1
    //   483: ifnull +15 -> 498
    //   486: aload_1
    //   487: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   490: goto +8 -> 498
    //   493: astore_1
    //   494: aload_1
    //   495: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   498: aload_2
    //   499: ifnull +208 -> 707
    //   502: aload_2
    //   503: invokevirtual 602	java/io/ObjectOutputStream:close	()V
    //   506: return
    //   507: astore_1
    //   508: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +196 -> 707
    //   514: goto -213 -> 301
    //   517: astore_3
    //   518: aload_2
    //   519: astore 4
    //   521: aload_1
    //   522: astore_2
    //   523: aload 5
    //   525: astore_1
    //   526: goto +189 -> 715
    //   529: astore_1
    //   530: aconst_null
    //   531: astore 7
    //   533: aload 7
    //   535: astore_2
    //   536: aload 8
    //   538: astore_3
    //   539: aload_3
    //   540: astore 4
    //   542: aload 7
    //   544: astore 5
    //   546: aload_2
    //   547: astore 6
    //   549: aload_1
    //   550: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   553: aload_3
    //   554: astore 4
    //   556: aload 7
    //   558: astore 5
    //   560: aload_2
    //   561: astore 6
    //   563: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +82 -> 648
    //   569: aload_3
    //   570: astore 4
    //   572: aload 7
    //   574: astore 5
    //   576: aload_2
    //   577: astore 6
    //   579: new 309	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   586: astore 8
    //   588: aload_3
    //   589: astore 4
    //   591: aload 7
    //   593: astore 5
    //   595: aload_2
    //   596: astore 6
    //   598: aload 8
    //   600: ldc_w 609
    //   603: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_3
    //   608: astore 4
    //   610: aload 7
    //   612: astore 5
    //   614: aload_2
    //   615: astore 6
    //   617: aload 8
    //   619: aload_1
    //   620: invokevirtual 610	java/io/IOException:toString	()Ljava/lang/String;
    //   623: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload_3
    //   628: astore 4
    //   630: aload 7
    //   632: astore 5
    //   634: aload_2
    //   635: astore 6
    //   637: ldc 24
    //   639: iconst_2
    //   640: aload 8
    //   642: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aload 7
    //   650: ifnull +22 -> 672
    //   653: aload 7
    //   655: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   658: goto +14 -> 672
    //   661: astore_1
    //   662: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq +7 -> 672
    //   668: aload_1
    //   669: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   672: aload_2
    //   673: ifnull +15 -> 688
    //   676: aload_2
    //   677: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   680: goto +8 -> 688
    //   683: astore_1
    //   684: aload_1
    //   685: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   688: aload_3
    //   689: ifnull +18 -> 707
    //   692: aload_3
    //   693: invokevirtual 602	java/io/ObjectOutputStream:close	()V
    //   696: return
    //   697: astore_1
    //   698: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +6 -> 707
    //   704: goto -403 -> 301
    //   707: return
    //   708: astore_3
    //   709: aload 6
    //   711: astore_2
    //   712: aload 5
    //   714: astore_1
    //   715: aload_1
    //   716: ifnull +21 -> 737
    //   719: aload_1
    //   720: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   723: goto +14 -> 737
    //   726: astore_1
    //   727: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +7 -> 737
    //   733: aload_1
    //   734: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   737: aload_2
    //   738: ifnull +15 -> 753
    //   741: aload_2
    //   742: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   745: goto +8 -> 753
    //   748: astore_1
    //   749: aload_1
    //   750: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   753: aload 4
    //   755: ifnull +22 -> 777
    //   758: aload 4
    //   760: invokevirtual 602	java/io/ObjectOutputStream:close	()V
    //   763: goto +14 -> 777
    //   766: astore_1
    //   767: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq +7 -> 777
    //   773: aload_1
    //   774: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   777: goto +5 -> 782
    //   780: aload_3
    //   781: athrow
    //   782: goto -2 -> 780
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	this	OcrConfig
    //   0	785	1	paramString	String
    //   26	716	2	localObject1	Object
    //   34	293	3	localObject2	Object
    //   341	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   358	1	3	localObject3	Object
    //   368	1	3	localObject4	Object
    //   374	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   396	1	3	localObject5	Object
    //   406	1	3	localObject6	Object
    //   414	26	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   471	8	3	localIOException1	java.io.IOException
    //   517	1	3	localObject7	Object
    //   538	155	3	localObject8	Object
    //   708	73	3	localObject9	Object
    //   165	156	4	localObject10	Object
    //   330	6	4	localIOException2	java.io.IOException
    //   346	1	4	localObject11	Object
    //   354	9	4	localIOException3	java.io.IOException
    //   376	9	4	localObject12	Object
    //   390	11	4	localIOException4	java.io.IOException
    //   426	333	4	localObject13	Object
    //   168	32	5	str	String
    //   306	6	5	localObject14	Object
    //   317	8	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   343	370	5	localObject15	Object
    //   202	508	6	localObject16	Object
    //   57	597	7	localObject17	Object
    //   160	481	8	localStringBuilder	StringBuilder
    //   101	136	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   259	263	266	java/io/IOException
    //   277	281	284	java/io/IOException
    //   289	293	294	java/io/IOException
    //   213	236	306	finally
    //   236	259	306	finally
    //   213	236	317	java/lang/OutOfMemoryError
    //   236	259	317	java/lang/OutOfMemoryError
    //   213	236	330	java/io/IOException
    //   236	259	330	java/io/IOException
    //   204	213	341	java/lang/OutOfMemoryError
    //   204	213	354	java/io/IOException
    //   186	195	368	finally
    //   186	195	374	java/lang/OutOfMemoryError
    //   186	195	390	java/io/IOException
    //   170	186	406	finally
    //   170	186	414	java/lang/OutOfMemoryError
    //   463	468	471	java/io/IOException
    //   486	490	493	java/io/IOException
    //   502	506	507	java/io/IOException
    //   419	458	517	finally
    //   170	186	529	java/io/IOException
    //   653	658	661	java/io/IOException
    //   676	680	683	java/io/IOException
    //   692	696	697	java/io/IOException
    //   204	213	708	finally
    //   549	553	708	finally
    //   563	569	708	finally
    //   579	588	708	finally
    //   598	607	708	finally
    //   617	627	708	finally
    //   637	648	708	finally
    //   719	723	726	java/io/IOException
    //   741	745	748	java/io/IOException
    //   758	763	766	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OcrConfig{");
    localStringBuilder.append("version:");
    localStringBuilder.append(this.version);
    localStringBuilder.append(",scanOcrOpen,:");
    localStringBuilder.append(this.scanOcrOpen);
    localStringBuilder.append(",iconUrl:");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append(",iconMd5:");
    localStringBuilder.append(this.iconMd5);
    localStringBuilder.append(",iconPressUrl:");
    localStringBuilder.append(this.iconPressUrl);
    localStringBuilder.append(",iconPressMD5:");
    localStringBuilder.append(this.iconPressMD5);
    localStringBuilder.append(",iconText:");
    localStringBuilder.append(this.iconText);
    localStringBuilder.append(",tips:");
    localStringBuilder.append(this.tips);
    localStringBuilder.append(",aioOcrOpen,:");
    localStringBuilder.append(this.aioOcrOpen);
    localStringBuilder.append(",aioText:");
    localStringBuilder.append(this.aioText);
    localStringBuilder.append(",chatFileOcrOpen:");
    localStringBuilder.append(this.chatFileOcrOpen);
    localStringBuilder.append(",qzoneOcrOpen:");
    localStringBuilder.append(this.qzoneOcrOpen);
    localStringBuilder.append(",questionScanOpen:");
    localStringBuilder.append(this.questionScanOpen);
    localStringBuilder.append(",questionResultOpen:");
    localStringBuilder.append(this.questionResultOpen);
    localStringBuilder.append(",translateLanguageNames:");
    HashMap localHashMap = this.translateLanguageNames;
    int j = 0;
    int i;
    if (localHashMap == null) {
      i = 0;
    } else {
      i = localHashMap.size();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",translateSupportLanguages:");
    localHashMap = this.translateSupportLanguages;
    if (localHashMap == null) {
      i = j;
    } else {
      i = localHashMap.size();
    }
    localStringBuilder.append(i);
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
    paramParcel.writeInt(this.chatFileOcrOpen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrConfig
 * JD-Core Version:    0.7.0.1
 */