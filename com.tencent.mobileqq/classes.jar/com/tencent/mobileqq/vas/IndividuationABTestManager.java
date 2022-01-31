package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import org.json.JSONObject;

public class IndividuationABTestManager
  implements Manager
{
  public int a;
  QQAppInterface a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public IndividuationABTestManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "parseJson jsonStr empty");
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("personalSwitch");
        this.jdField_a_of_type_JavaLangString = paramString.optString("enterUrl");
        if (paramString.has("isShowRed"))
        {
          i = paramString.getInt("isShowRed");
          this.jdField_b_of_type_Int = i;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("IndividuationABTestManager", 1, "parseJson error e = " + paramString.getMessage());
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaLangString = "";
        this.jdField_b_of_type_Int = -1;
        paramString.printStackTrace();
        return;
      }
      int i = -1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationABTestManager", 2, "handlePostTask version = " + paramInt);
    }
    paramString = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
    try
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_b_of_type_Int = -1;
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        Object localObject = null;
        File localFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
        this.jdField_b_of_type_Boolean = true;
        paramString = localObject;
        try
        {
          if (localFile.exists()) {
            paramString = FileUtils.a(localFile);
          }
          if (TextUtils.isEmpty(paramString))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("IndividuationABTestManager", 2, "parseJsonFromFile jsont str is empty");
          }
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "parseJsonFromFile fileStr = " + paramString);
      }
    } while (this.jdField_a_of_type_Boolean);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "updateJsonInfo jsonStr or uin empty");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "updateJsonInfo jsonStr = " + paramString1);
      }
      this.jdField_a_of_type_Boolean = true;
      b(paramString1);
      String str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "individuationABTestFile_" + paramString2;
      try
      {
        boolean bool = FileUtils.a(str, paramString1);
        if (!bool) {
          continue;
        }
        SharedPreUtils.e(BaseApplicationImpl.getContext(), paramInt, paramString2);
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationABTestManager
 * JD-Core Version:    0.7.0.1
 */