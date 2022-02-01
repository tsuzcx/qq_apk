package com.tencent.mobileqq.upgrade;

import android.os.Parcel;
import android.util.Xml;
import azet;
import bhdl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;

public class NewUpgradeConfig
  implements Serializable
{
  private static NewUpgradeConfig jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig;
  private static String jdField_a_of_type_JavaLangString = "NewUpgradeConfig";
  public bhdl dialog;
  
  private NewUpgradeConfig() {}
  
  public NewUpgradeConfig(Parcel paramParcel) {}
  
  public static NewUpgradeConfig getInstance()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig = new NewUpgradeConfig();
      }
      NewUpgradeConfig localNewUpgradeConfig = jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig;
      return localNewUpgradeConfig;
    }
    finally {}
  }
  
  public void parseConfig4Dialog(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.prepareDialog();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        int i = localXmlPullParser.getEventType();
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          paramString = localXmlPullParser.getName();
          if (paramString.equalsIgnoreCase("configId")) {
            jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          }
        }
        else
        {
          i = localXmlPullParser.next();
          continue;
        }
        if (paramString.equalsIgnoreCase("taskName"))
        {
          jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString = localXmlPullParser.nextText();
          continue;
        }
        if (!paramString.equalsIgnoreCase("taskTime")) {
          break label212;
        }
      }
      catch (Exception paramString)
      {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog = null;
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "updateDialogParseFail : " + paramString.getMessage());
        }
        paramString.printStackTrace();
        return;
      }
      jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long = azet.a(localXmlPullParser.nextText());
      continue;
      label212:
      if (paramString.equalsIgnoreCase("showTime")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long = azet.a(localXmlPullParser.nextText());
      } else if (paramString.equalsIgnoreCase("title")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("content")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.c = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("desc")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.d = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("installFail")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("info")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.f = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("yellowBar")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
      } else if (paramString.equalsIgnoreCase("barContent")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("barContent2")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("lBtnText")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i = localXmlPullParser.getText();
      } else if (paramString.equalsIgnoreCase("rBtnText")) {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j = localXmlPullParser.getText();
      }
    }
  }
  
  public void prepareDialog()
  {
    this.dialog = new bhdl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeConfig
 * JD-Core Version:    0.7.0.1
 */