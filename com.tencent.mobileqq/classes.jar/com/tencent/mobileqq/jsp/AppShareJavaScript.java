package com.tencent.mobileqq.jsp;

import android.content.Context;
import awfv;
import awfw;
import awhh;
import bhny;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

@Deprecated
public class AppShareJavaScript
  extends awfw
{
  Context jdField_a_of_type_AndroidContentContext;
  private awhh jdField_a_of_type_Awhh;
  private boolean jdField_a_of_type_Boolean;
  
  public AppShareJavaScript(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Awhh = new awhh();
    try
    {
      Field localField = awhh.class.getDeclaredField("a");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_Awhh, paramContext);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d("QQApi", 2, "QQApi init error: " + paramContext.getMessage());
    }
  }
  
  public void call(String paramString, List<String> paramList, awfv paramawfv)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("QQApi", 2, "QQApi not ready");
      return;
    }
    int i = paramList.size();
    for (;;)
    {
      try
      {
        if (("isAppInstalled".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(bhny.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0)));
          paramawfv.a(paramList);
          return;
        }
      }
      catch (Exception paramList)
      {
        QLog.d("QQApi", 2, "error in QQApi." + paramString + ": " + paramList.getMessage());
        return;
      }
      if (("checkAppInstalled".equals(paramString)) && (i == 1))
      {
        paramList = bhny.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("checkAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = bhny.b(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("isAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = bhny.c(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("startAppWithPkgName".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(bhny.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0), null));
      }
      else if (("startAppWithPkgNameAndOpenId".equals(paramString)) && (i == 2))
      {
        paramList = Boolean.valueOf(bhny.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0), (String)paramList.get(1)));
      }
      else if (("getOpenidBatch".equals(paramString)) && (i == 1))
      {
        paramList = "";
      }
      else if (("launchAppWithTokens".equals(paramString)) && (i == 4))
      {
        this.jdField_a_of_type_Awhh.a((String)paramList.get(0), (String)paramList.get(1), (String)paramList.get(2), (String)paramList.get(3), null, "");
        paramList = null;
      }
      else if (("getAppsVerionCodeBatch".equals(paramString)) && (i == 1))
      {
        paramList = bhny.d(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("setShareURL".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(false);
      }
      else if (("setShareInfo".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(false);
      }
      else
      {
        if ((!"sendDocToChat".equals(paramString)) || (i != 1)) {
          break;
        }
        paramList = Boolean.valueOf(false);
      }
    }
    paramawfv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppShareJavaScript
 * JD-Core Version:    0.7.0.1
 */