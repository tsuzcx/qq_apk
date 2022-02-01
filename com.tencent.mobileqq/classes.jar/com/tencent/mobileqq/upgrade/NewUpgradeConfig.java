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
  private static NewUpgradeConfig jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig;
  private static String jdField_a_of_type_JavaLangString = "NewUpgradeConfig";
  public NewUpgradeConfig.Dialog dialog;
  
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
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      Object localObject = Xml.newPullParser();
      jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.prepareDialog();
      try
      {
        ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        for (int i = ((XmlPullParser)localObject).getEventType(); i != 1; i = ((XmlPullParser)localObject).next()) {
          if (i == 2)
          {
            paramString = ((XmlPullParser)localObject).getName();
            if (paramString.equalsIgnoreCase("configId")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
            } else if (paramString.equalsIgnoreCase("taskName")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("taskTime")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long = OlympicUtil.a(((XmlPullParser)localObject).nextText());
            } else if (paramString.equalsIgnoreCase("showTime")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long = OlympicUtil.a(((XmlPullParser)localObject).nextText());
            } else if (paramString.equalsIgnoreCase("title")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("content")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.c = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("desc")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.d = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("installFail")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("info")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.f = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("yellowBar")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
            } else if (paramString.equalsIgnoreCase("barContent")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("barContent2")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h = ((XmlPullParser)localObject).nextText();
            } else if (paramString.equalsIgnoreCase("lBtnText")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i = ((XmlPullParser)localObject).getText();
            } else if (paramString.equalsIgnoreCase("rBtnText")) {
              jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j = ((XmlPullParser)localObject).getText();
            }
          }
        }
        StringBuilder localStringBuilder;
        return;
      }
      catch (Exception paramString)
      {
        jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog = null;
        if (QLog.isDevelopLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeConfig
 * JD-Core Version:    0.7.0.1
 */