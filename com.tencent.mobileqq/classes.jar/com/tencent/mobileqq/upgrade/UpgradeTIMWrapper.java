package com.tencent.mobileqq.upgrade;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import bgwe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class UpgradeTIMWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeTIMWrapper> CREATOR = new bgwe();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public UpgradeTIMWrapper() {}
  
  public UpgradeTIMWrapper(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_Int = paramInt;
    this.f = paramString6;
    this.g = paramString7;
  }
  
  public static UpgradeTIMWrapper a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (b())
      {
        String str = a();
        localObject1 = localObject3;
        if (str != null) {
          localObject1 = a(str);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public static UpgradeTIMWrapper a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("upgrade_tim_banner_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    UpgradeTIMWrapper localUpgradeTIMWrapper = new UpgradeTIMWrapper();
    localUpgradeTIMWrapper.jdField_a_of_type_Int = paramQQAppInterface.getInt("upgrade_tim_banner_switch", 0);
    localUpgradeTIMWrapper.f = paramQQAppInterface.getString("upgrade_tim_banner_title", "");
    localUpgradeTIMWrapper.g = paramQQAppInterface.getString("upgrade_tim_banner_url", "");
    return localUpgradeTIMWrapper;
  }
  
  public static UpgradeTIMWrapper a(String paramString)
  {
    UpgradeTIMWrapper localUpgradeTIMWrapper = new UpgradeTIMWrapper();
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        int i = localXmlPullParser.getEventType();
        if (i != 1)
        {
          if (i == 2)
          {
            paramString = localXmlPullParser.getName();
            if (paramString.equalsIgnoreCase("title")) {
              localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString = localXmlPullParser.nextText();
            }
          }
          else
          {
            i = localXmlPullParser.next();
            continue;
          }
          if (paramString.equalsIgnoreCase("content"))
          {
            localUpgradeTIMWrapper.b = localXmlPullParser.nextText();
            continue;
          }
        }
        else
        {
          return localUpgradeTIMWrapper;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeTIMWrapper", 4, "parseConfig UpgradeTIMWrapper : " + paramString.getMessage());
        }
        paramString.printStackTrace();
      }
      if (paramString.equalsIgnoreCase("downloadPageUrlAndroid"))
      {
        localUpgradeTIMWrapper.c = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("lBtnText"))
      {
        localUpgradeTIMWrapper.d = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("rBtnText"))
      {
        localUpgradeTIMWrapper.e = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("tipOn"))
      {
        paramString = localXmlPullParser.nextText();
        try
        {
          localUpgradeTIMWrapper.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          QLog.w("UpgradeTIMWrapper", 2, paramString.getMessage());
        }
      }
      else if (paramString.equalsIgnoreCase("tipTitle"))
      {
        localUpgradeTIMWrapper.f = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("androidTipURL"))
      {
        localUpgradeTIMWrapper.g = localXmlPullParser.nextText();
      }
    }
  }
  
  public static String a()
  {
    Object localObject4;
    Object localObject2;
    try
    {
      Object localObject1 = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
      localObject1 = FileUtils.fileToBytes(new File((String)localObject1 + "upgrade_config_tim_info"));
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        localObject4 = null;
        return localObject4;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        localObject2 = null;
      }
    }
    if (Build.VERSION.SDK_INT <= 8) {
      localObject2 = new String((byte[])localObject2);
    }
    for (;;)
    {
      localObject4 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper load local content:" + (String)localObject2);
      return localObject2;
      try
      {
        localObject2 = new String((byte[])localObject2, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isDevelopLevel()) {
          localUnsupportedEncodingException.printStackTrace();
        }
        Object localObject3 = null;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, new Object[] { "save tim tip configs, banner on: ", Integer.valueOf(paramUpgradeTIMWrapper.jdField_a_of_type_Int) });
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("upgrade_tim_banner_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      paramQQAppInterface.putInt("upgrade_tim_banner_switch", paramUpgradeTIMWrapper.jdField_a_of_type_Int);
      paramQQAppInterface.putString("upgrade_tim_banner_title", paramUpgradeTIMWrapper.f);
      paramQQAppInterface.putString("upgrade_tim_banner_url", paramUpgradeTIMWrapper.g);
      paramQQAppInterface.commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if ((TextUtils.isEmpty("upgrade_config_tim_info")) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      FileUtils.writeFile(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath(), "upgrade_config_tim_info", paramString);
    } while (!QLog.isColorLevel());
    QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper save upgrade_config_tim to file finish.");
  }
  
  public static void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper delUpgradeConfig");
      }
      if (b())
      {
        String str = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
        FileUtils.deleteFile(str + "upgrade_config_tim_info");
        if (QLog.isColorLevel()) {
          QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper delUpgradeConfig : " + str + "upgrade_config_tim_info");
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean b()
  {
    if (TextUtils.isEmpty("upgrade_config_tim_info")) {
      return false;
    }
    String str = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
    return FileUtils.fileExists(str + "upgrade_config_tim_info");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMWrapper
 * JD-Core Version:    0.7.0.1
 */