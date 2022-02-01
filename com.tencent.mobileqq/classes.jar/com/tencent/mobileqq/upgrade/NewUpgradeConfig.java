package com.tencent.mobileqq.upgrade;

import android.os.Parcel;
import android.util.Xml;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;

public class NewUpgradeConfig
  implements Serializable
{
  private static String a = "NewUpgradeConfig";
  private static NewUpgradeConfig b;
  public NewUpgradeConfig.Dialog dialog;
  
  private NewUpgradeConfig() {}
  
  public NewUpgradeConfig(Parcel paramParcel) {}
  
  public static NewUpgradeConfig getInstance()
  {
    try
    {
      if (b == null) {
        b = new NewUpgradeConfig();
      }
      NewUpgradeConfig localNewUpgradeConfig = b;
      return localNewUpgradeConfig;
    }
    finally {}
  }
  
  public void parseConfig4Dialog(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      Object localObject = Xml.newPullParser();
      b.prepareDialog();
      try
      {
        ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        for (int i = ((XmlPullParser)localObject).getEventType(); i != 1; i = ((XmlPullParser)localObject).next()) {
          if (i == 2)
          {
            paramString = ((XmlPullParser)localObject).getName();
            if (paramString.equalsIgnoreCase("configId")) {
              b.dialog.a = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
            } else if (paramString.equalsIgnoreCase("taskName")) {
              b.dialog.b = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("taskTime")) {
              b.dialog.c = OlympicUtil.a(((XmlPullParser)localObject).nextText());
            } else if (paramString.equalsIgnoreCase("showTime")) {
              b.dialog.d = OlympicUtil.a(((XmlPullParser)localObject).nextText());
            } else if (paramString.equalsIgnoreCase("title")) {
              b.dialog.e = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("content")) {
              b.dialog.f = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("desc")) {
              b.dialog.g = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("installFail")) {
              b.dialog.h = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("info")) {
              b.dialog.i = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("yellowBar")) {
              b.dialog.j = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
            } else if (paramString.equalsIgnoreCase("barContent")) {
              b.dialog.k = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("barContent2")) {
              b.dialog.l = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("lBtnText")) {
              b.dialog.m = ((XmlPullParser)localObject).getText();
            } else if (paramString.equalsIgnoreCase("rBtnText")) {
              b.dialog.n = ((XmlPullParser)localObject).getText();
            }
          }
        }
        StringBuilder localStringBuilder;
        return;
      }
      catch (Exception paramString)
      {
        b.dialog = null;
        if (QLog.isDevelopLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateDialogParseFail : ");
          localStringBuilder.append(paramString.getMessage());
          QLog.d((String)localObject, 4, localStringBuilder.toString());
        }
        paramString.printStackTrace();
      }
    }
  }
  
  public void prepareDialog()
  {
    this.dialog = new NewUpgradeConfig.Dialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeConfig
 * JD-Core Version:    0.7.0.1
 */