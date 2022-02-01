package com.tencent.mobileqq.upgrade;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
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
  public static final Parcelable.Creator<UpgradeTIMWrapper> CREATOR = new UpgradeTIMWrapper.1();
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
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_tim_banner_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject = new UpgradeTIMWrapper();
    ((UpgradeTIMWrapper)localObject).jdField_a_of_type_Int = paramQQAppInterface.getInt("upgrade_tim_banner_switch", 0);
    ((UpgradeTIMWrapper)localObject).f = paramQQAppInterface.getString("upgrade_tim_banner_title", "");
    ((UpgradeTIMWrapper)localObject).g = paramQQAppInterface.getString("upgrade_tim_banner_url", "");
    return localObject;
  }
  
  public static UpgradeTIMWrapper a(String paramString)
  {
    localUpgradeTIMWrapper = new UpgradeTIMWrapper();
    Object localObject = Xml.newPullParser();
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = ((XmlPullParser)localObject).getEventType(); i != 1; i = ((XmlPullParser)localObject).next()) {
        if (i == 2)
        {
          paramString = ((XmlPullParser)localObject).getName();
          if (paramString.equalsIgnoreCase("title"))
          {
            localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("content"))
          {
            localUpgradeTIMWrapper.b = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("downloadPageUrlAndroid"))
          {
            localUpgradeTIMWrapper.c = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("lBtnText"))
          {
            localUpgradeTIMWrapper.d = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("rBtnText"))
          {
            localUpgradeTIMWrapper.e = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("tipOn"))
          {
            paramString = ((XmlPullParser)localObject).nextText();
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
            localUpgradeTIMWrapper.f = ((XmlPullParser)localObject).nextText();
          }
          else if (paramString.equalsIgnoreCase("androidTipURL"))
          {
            localUpgradeTIMWrapper.g = ((XmlPullParser)localObject).nextText();
          }
        }
      }
      return localUpgradeTIMWrapper;
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseConfig UpgradeTIMWrapper : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("UpgradeTIMWrapper", 4, ((StringBuilder)localObject).toString());
      }
      paramString.printStackTrace();
    }
  }
  
  public static String a()
  {
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2;
    try
    {
      Object localObject1 = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("upgrade_config_tim_info");
      localObject1 = FileUtils.fileToBytes(new File(localStringBuilder.toString()));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
      localObject2 = null;
    }
    Object localObject4;
    if (localObject2 != null)
    {
      if (localObject2.length <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        localObject2 = new String((byte[])localObject2);
      } else {
        try
        {
          localObject2 = new String((byte[])localObject2, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localObject2 = localObject5;
          if (QLog.isDevelopLevel())
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject2 = localObject5;
          }
        }
      }
      localObject4 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("UpgradeTIMWrapper load local content:");
        ((StringBuilder)localObject4).append((String)localObject2);
        QLog.i("UpgradeTIMWrapper", 2, ((StringBuilder)localObject4).toString());
        localObject4 = localObject2;
      }
    }
    return localObject4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, new Object[] { "save tim tip configs, banner on: ", Integer.valueOf(paramUpgradeTIMWrapper.jdField_a_of_type_Int) });
    }
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_tim_banner_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit();
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
    if (!TextUtils.isEmpty("upgrade_config_tim_info"))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      FileUtils.writeFile(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath(), "upgrade_config_tim_info", paramString);
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper save upgrade_config_tim to file finish.");
      }
    }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("upgrade_config_tim_info");
        FileUtils.deleteFile(localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("UpgradeTIMWrapper delUpgradeConfig : ");
          localStringBuilder.append(str);
          localStringBuilder.append("upgrade_config_tim_info");
          QLog.i("UpgradeTIMWrapper", 2, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("upgrade_config_tim_info");
    return FileUtils.fileExists(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMWrapper
 * JD-Core Version:    0.7.0.1
 */