package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.extra.tools.LibraryLoadUtils;
import org.xmlpull.v1.XmlPullParser;

public class PAGFont
{
  private static final String DefaultLanguage = "zh-Hans";
  private static final Pattern FILENAME_WHITESPACE_PATTERN;
  private static final String[] FallbackFontFileNames = { "/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf" };
  private static final String SystemFontConfigPath_JellyBean = "/system/etc/fallback_fonts.xml";
  private static final String SystemFontConfigPath_Lollipop = "/system/etc/fonts.xml";
  private static final String SystemFontPath = "/system/fonts/";
  private static boolean systemFontLoaded;
  public String fontFamily = "";
  public String fontStyle = "";
  
  static
  {
    FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    systemFontLoaded = false;
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGFont() {}
  
  public PAGFont(String paramString1, String paramString2)
  {
    this.fontFamily = paramString1;
    this.fontStyle = paramString2;
  }
  
  private static void RegisterFallbackFonts()
  {
    if (systemFontLoaded) {
      return;
    }
    systemFontLoaded = true;
    int j = 0;
    Object localObject1 = new PAGFont.FontConfig[0];
    if (new File("/system/etc/fonts.xml").exists()) {
      try
      {
        PAGFont.FontConfig[] arrayOfFontConfig1 = parseLollipop();
        localObject1 = arrayOfFontConfig1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else {
      try
      {
        PAGFont.FontConfig[] arrayOfFontConfig2 = parseJellyBean();
        localObject1 = arrayOfFontConfig2;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject4 = getFontByLanguage((PAGFont.FontConfig[])localObject1, "zh-Hans");
    if (localObject4 != null) {
      addFont((PAGFont.FontConfig)localObject4, (ArrayList)localObject3, (ArrayList)localObject2);
    }
    localObject4 = FallbackFontFileNames;
    int k = localObject4.length;
    int i = 0;
    while (i < k)
    {
      Object localObject5 = localObject4[i];
      PAGFont.FontConfig localFontConfig = new PAGFont.FontConfig(null);
      localFontConfig.fileName = localObject5;
      addFont(localFontConfig, (ArrayList)localObject3, (ArrayList)localObject2);
      i += 1;
    }
    k = localObject1.length;
    i = 0;
    while (i < k)
    {
      addFont(localObject1[i], (ArrayList)localObject3, (ArrayList)localObject2);
      i += 1;
    }
    if (!((ArrayList)localObject3).isEmpty())
    {
      localObject1 = new String[((ArrayList)localObject3).size()];
      ((ArrayList)localObject3).toArray((Object[])localObject1);
      localObject3 = new int[((ArrayList)localObject2).size()];
      localObject2 = ((ArrayList)localObject2).iterator();
      i = j;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3[i] = ((Integer)((Iterator)localObject2).next()).intValue();
        i += 1;
      }
      SetFallbackFontPaths((String[])localObject1, (int[])localObject3);
    }
  }
  
  public static PAGFont RegisterFont(AssetManager paramAssetManager, String paramString)
  {
    return RegisterFont(paramAssetManager, paramString, 0);
  }
  
  public static PAGFont RegisterFont(AssetManager paramAssetManager, String paramString, int paramInt)
  {
    return RegisterFont(paramAssetManager, paramString, paramInt, "", "");
  }
  
  public static native PAGFont RegisterFont(AssetManager paramAssetManager, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public static PAGFont RegisterFont(String paramString)
  {
    return RegisterFont(paramString, 0);
  }
  
  public static PAGFont RegisterFont(String paramString, int paramInt)
  {
    return RegisterFont(paramString, paramInt, "", "");
  }
  
  public static native PAGFont RegisterFont(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static PAGFont RegisterFontBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return RegisterFontBytes(paramArrayOfByte, paramInt1, paramInt2, "", "");
  }
  
  private static native PAGFont RegisterFontBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  private static native void SetFallbackFontPaths(String[] paramArrayOfString, int[] paramArrayOfInt);
  
  private static native void UnregisterFont(String paramString1, String paramString2);
  
  public static void UnregisterFont(PAGFont paramPAGFont)
  {
    UnregisterFont(paramPAGFont.fontFamily, paramPAGFont.fontStyle);
  }
  
  private static void addFont(PAGFont.FontConfig paramFontConfig, ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if (paramArrayList.contains(paramFontConfig.fileName)) {
      return;
    }
    if (!new File(paramFontConfig.fileName).exists()) {
      return;
    }
    paramArrayList.add(paramFontConfig.fileName);
    paramArrayList1.add(Integer.valueOf(paramFontConfig.ttcIndex));
  }
  
  private static PAGFont.FontConfig getFontByLanguage(PAGFont.FontConfig[] paramArrayOfFontConfig, String paramString)
  {
    paramString = paramString.toLowerCase();
    int j = paramArrayOfFontConfig.length;
    int i = 0;
    while (i < j)
    {
      PAGFont.FontConfig localFontConfig = paramArrayOfFontConfig[i];
      if (localFontConfig.language.toLowerCase().equals(paramString)) {
        return localFontConfig;
      }
      i += 1;
    }
    return null;
  }
  
  private static native void nativeInit();
  
  private static PAGFont.FontConfig[] parseJellyBean()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
      try
      {
        Object localObject1 = Xml.newPullParser();
        ((XmlPullParser)localObject1).setInput(localFileInputStream, null);
        ((XmlPullParser)localObject1).nextTag();
        localObject1 = readFamiliesJellyBean((XmlPullParser)localObject1);
        return localObject1;
      }
      finally
      {
        localFileInputStream.close();
      }
      return new PAGFont.FontConfig[0];
    }
    catch (IOException localIOException) {}
  }
  
  private static PAGFont.FontConfig[] parseLollipop()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/system/etc/fonts.xml");
      try
      {
        Object localObject1 = Xml.newPullParser();
        ((XmlPullParser)localObject1).setInput(localFileInputStream, null);
        ((XmlPullParser)localObject1).nextTag();
        localObject1 = readFamilies((XmlPullParser)localObject1);
        return localObject1;
      }
      finally
      {
        localFileInputStream.close();
      }
      return new PAGFont.FontConfig[0];
    }
    catch (IOException localIOException) {}
  }
  
  private static PAGFont.FontConfig[] readFamilies(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          readFamily(paramXmlPullParser, localArrayList);
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new PAGFont.FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    return paramXmlPullParser;
  }
  
  private static PAGFont.FontConfig[] readFamiliesJellyBean(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
              if (paramXmlPullParser.getName().equals("fileset")) {
                readFileset(paramXmlPullParser, localArrayList);
              } else {
                skip(paramXmlPullParser);
              }
            }
          }
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new PAGFont.FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    return paramXmlPullParser;
  }
  
  private static void readFamily(XmlPullParser paramXmlPullParser, ArrayList<PAGFont.FontConfig> paramArrayList)
  {
    Object localObject = null;
    paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "lang");
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    Iterator localIterator = localArrayList.iterator();
    do
    {
      paramXmlPullParser = (XmlPullParser)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramXmlPullParser = (PAGFont.FontConfig)localIterator.next();
    } while (paramXmlPullParser.weight != 400);
    localObject = paramXmlPullParser;
    if (paramXmlPullParser == null) {
      localObject = (PAGFont.FontConfig)localArrayList.get(0);
    }
    if (!((PAGFont.FontConfig)localObject).fileName.isEmpty())
    {
      paramXmlPullParser = str;
      if (str == null) {
        paramXmlPullParser = "";
      }
      ((PAGFont.FontConfig)localObject).language = paramXmlPullParser;
      paramArrayList.add(localObject);
    }
  }
  
  private static void readFileset(XmlPullParser paramXmlPullParser, ArrayList<PAGFont.FontConfig> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("file")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    Object localObject = null;
    Iterator localIterator = localArrayList.iterator();
    do
    {
      paramXmlPullParser = (XmlPullParser)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramXmlPullParser = (PAGFont.FontConfig)localIterator.next();
    } while (paramXmlPullParser.weight != 400);
    localObject = paramXmlPullParser;
    if (paramXmlPullParser == null) {
      localObject = (PAGFont.FontConfig)localArrayList.get(0);
    }
    if (!((PAGFont.FontConfig)localObject).fileName.isEmpty()) {
      paramArrayList.add(localObject);
    }
  }
  
  private static PAGFont.FontConfig readFont(XmlPullParser paramXmlPullParser)
  {
    PAGFont.FontConfig localFontConfig = new PAGFont.FontConfig(null);
    Object localObject = paramXmlPullParser.getAttributeValue(null, "index");
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = Integer.parseInt((String)localObject);
    }
    localFontConfig.ttcIndex = i;
    localObject = paramXmlPullParser.getAttributeValue(null, "weight");
    if (localObject == null) {
      i = 400;
    } else {
      i = Integer.parseInt((String)localObject);
    }
    localFontConfig.weight = i;
    localObject = new StringBuilder();
    while (paramXmlPullParser.next() != 3)
    {
      if (paramXmlPullParser.getEventType() == 4) {
        ((StringBuilder)localObject).append(paramXmlPullParser.getText());
      }
      if (paramXmlPullParser.getEventType() == 2) {
        skip(paramXmlPullParser);
      }
    }
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append("/system/fonts/");
    paramXmlPullParser.append(FILENAME_WHITESPACE_PATTERN.matcher((CharSequence)localObject).replaceAll(""));
    localFontConfig.fileName = paramXmlPullParser.toString();
    return localFontConfig;
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i -= 1;
        }
      }
      else {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGFont
 * JD-Core Version:    0.7.0.1
 */