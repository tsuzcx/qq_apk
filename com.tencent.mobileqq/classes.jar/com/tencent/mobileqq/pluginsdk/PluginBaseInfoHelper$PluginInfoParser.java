package com.tencent.mobileqq.pluginsdk;

import android.util.Xml;
import java.io.StringWriter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlSerializer;

public class PluginBaseInfoHelper$PluginInfoParser
  extends DefaultHandler
{
  private static final String TAG_CUR_VERSION = "CurVersion";
  private static final String TAG_FINGER = "Finger";
  private static final String TAG_FORCE_URL = "ForceUrl";
  private static final String TAG_ID = "ID";
  private static final String TAG_INSTALLED_PATH = "InstalledPath";
  private static final String TAG_INSTALL_TYPE = "InstallType";
  private static final String TAG_LENGTH = "Length";
  private static final String TAG_MD5 = "MD5";
  private static final String TAG_NAME = "Name";
  private static final String TAG_PACKAGE_NAME = "PackageName";
  private static final String TAG_PLUGIN_INFO = "PluginInfo";
  private static final String TAG_PROCESSES = "Processes";
  private static final String TAG_STATE = "State";
  private static final String TAG_SUB_TYPE = "SubType";
  private static final String TAG_TYPE = "Type";
  private static final String TAG_UPDATE_TYPE = "UpdateType";
  private static final String TAG_URL = "URL";
  private static final String TAG_VERSION = "Version";
  private StringBuilder mBuilder;
  private PluginBaseInfo mResult;
  private Class<? extends PluginBaseInfo> mResultClass;
  
  public static String pluginToXML(PluginBaseInfo paramPluginBaseInfo)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("utf-8", null);
    localXmlSerializer.startTag("", "PluginInfo");
    localXmlSerializer.startTag("", "ID");
    localXmlSerializer.text(paramPluginBaseInfo.mID);
    localXmlSerializer.endTag("", "ID");
    localXmlSerializer.startTag("", "Name");
    localXmlSerializer.text(paramPluginBaseInfo.mName);
    localXmlSerializer.endTag("", "Name");
    localXmlSerializer.startTag("", "Version");
    localXmlSerializer.text(paramPluginBaseInfo.mVersion);
    localXmlSerializer.endTag("", "Version");
    localXmlSerializer.startTag("", "URL");
    localXmlSerializer.text(paramPluginBaseInfo.mURL);
    localXmlSerializer.endTag("", "URL");
    localXmlSerializer.startTag("", "MD5");
    localXmlSerializer.text(paramPluginBaseInfo.mMD5);
    localXmlSerializer.endTag("", "MD5");
    localXmlSerializer.startTag("", "Finger");
    localXmlSerializer.text(paramPluginBaseInfo.mFingerPrint);
    localXmlSerializer.endTag("", "Finger");
    localXmlSerializer.startTag("", "Type");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mType));
    localXmlSerializer.endTag("", "Type");
    localXmlSerializer.startTag("", "SubType");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mSubType));
    localXmlSerializer.endTag("", "SubType");
    localXmlSerializer.startTag("", "PackageName");
    localXmlSerializer.text(paramPluginBaseInfo.mPackageName);
    localXmlSerializer.endTag("", "PackageName");
    localXmlSerializer.startTag("", "CurVersion");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mCurVersion));
    localXmlSerializer.endTag("", "CurVersion");
    localXmlSerializer.startTag("", "Length");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mLength));
    localXmlSerializer.endTag("", "Length");
    localXmlSerializer.startTag("", "State");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mState));
    localXmlSerializer.endTag("", "State");
    if (paramPluginBaseInfo.mProcesses != null)
    {
      String[] arrayOfString = paramPluginBaseInfo.mProcesses;
      int j = arrayOfString.length;
      int i = 0;
      String str1 = "";
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        str2 = arrayOfString[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        localStringBuilder.append("|");
        str1 = localStringBuilder.toString();
        i += 1;
      }
    }
    String str2 = "";
    localXmlSerializer.startTag("", "Processes");
    localXmlSerializer.text(str2);
    localXmlSerializer.endTag("", "Processes");
    localXmlSerializer.startTag("", "UpdateType");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mUpdateType));
    localXmlSerializer.endTag("", "UpdateType");
    localXmlSerializer.startTag("", "InstallType");
    localXmlSerializer.text(String.valueOf(paramPluginBaseInfo.mInstallType));
    localXmlSerializer.endTag("", "InstallType");
    localXmlSerializer.startTag("", "InstalledPath");
    if (paramPluginBaseInfo.mInstalledPath == null) {
      paramPluginBaseInfo = "";
    } else {
      paramPluginBaseInfo = paramPluginBaseInfo.mInstalledPath;
    }
    localXmlSerializer.text(paramPluginBaseInfo);
    localXmlSerializer.endTag("", "InstalledPath");
    localXmlSerializer.endTag("", "PluginInfo");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.mBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endDocument()
  {
    this.mBuilder = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mBuilder.toString();
    if ("ID".equals(paramString2))
    {
      this.mResult.mID = paramString1;
      return;
    }
    if ("Name".equals(paramString2))
    {
      this.mResult.mName = paramString1;
      return;
    }
    if ("Version".equals(paramString2))
    {
      this.mResult.mVersion = paramString1;
      return;
    }
    if ("URL".equals(paramString2))
    {
      this.mResult.mURL = paramString1;
      return;
    }
    if ("MD5".equals(paramString2))
    {
      this.mResult.mMD5 = paramString1;
      return;
    }
    if ("Finger".equals(paramString2))
    {
      this.mResult.mFingerPrint = paramString1;
      return;
    }
    if ("Type".equals(paramString2))
    {
      this.mResult.mType = Integer.valueOf(paramString1).intValue();
      return;
    }
    if ("SubType".equals(paramString2))
    {
      this.mResult.mSubType = Integer.valueOf(paramString1).intValue();
      return;
    }
    if ("PackageName".equals(paramString2))
    {
      this.mResult.mPackageName = paramString1;
      return;
    }
    if ("CurVersion".equals(paramString2))
    {
      this.mResult.mCurVersion = Long.parseLong(paramString1);
      return;
    }
    if ("Length".equals(paramString2))
    {
      this.mResult.mLength = Long.parseLong(paramString1);
      return;
    }
    if ("State".equals(paramString2))
    {
      this.mResult.mState = Integer.parseInt(paramString1);
      return;
    }
    if ("Processes".equals(paramString2))
    {
      if (paramString1 != null)
      {
        this.mResult.mProcesses = paramString1.split("\\|");
        return;
      }
      this.mResult.mProcesses = new String[0];
      return;
    }
    if ("UpdateType".equals(paramString2))
    {
      this.mResult.mUpdateType = Integer.parseInt(paramString1);
      return;
    }
    if ("InstallType".equals(paramString2))
    {
      this.mResult.mInstallType = Integer.parseInt(paramString1);
      return;
    }
    if ("InstalledPath".equals(paramString2))
    {
      if ((paramString1 != null) && (paramString1.length() != 0))
      {
        this.mResult.mInstalledPath = paramString1;
        return;
      }
      this.mResult.mInstalledPath = null;
      return;
    }
    if (("ForceUrl".equals(paramString2)) && (paramString1 != null) && (paramString1.length() > 0)) {
      this.mResult.mForceUrl = 1;
    }
  }
  
  public PluginBaseInfo getResult()
  {
    return this.mResult;
  }
  
  public void setResultClass(Class<? extends PluginBaseInfo> paramClass)
  {
    this.mResultClass = paramClass;
  }
  
  public void startDocument()
  {
    this.mBuilder = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.mBuilder.setLength(0);
    if ("PluginInfo".equals(paramString2)) {}
    try
    {
      this.mResult = ((PluginBaseInfo)this.mResultClass.newInstance());
      return;
    }
    catch (Exception paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.PluginInfoParser
 * JD-Core Version:    0.7.0.1
 */