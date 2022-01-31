package com.tencent.mobileqq.jsp;

import android.content.Context;
import atgu;
import atgv;
import atid;
import bdiv;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

@Deprecated
public class AppShareJavaScript
  extends atgv
{
  Context jdField_a_of_type_AndroidContentContext;
  private atid jdField_a_of_type_Atid;
  private boolean jdField_a_of_type_Boolean;
  
  public AppShareJavaScript(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Atid = new atid();
    try
    {
      Field localField = atid.class.getDeclaredField("a");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_Atid, paramContext);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d("QQApi", 2, "QQApi init error: " + paramContext.getMessage());
    }
  }
  
  public void call(String paramString, List<String> paramList, atgu paramatgu)
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
          paramList = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0)));
          paramatgu.a(paramList);
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
        paramList = bdiv.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("checkAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = bdiv.b(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("isAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = bdiv.c(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
      }
      else if (("startAppWithPkgName".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0), null));
      }
      else if (("startAppWithPkgNameAndOpenId".equals(paramString)) && (i == 2))
      {
        paramList = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0), (String)paramList.get(1)));
      }
      else if (("getOpenidBatch".equals(paramString)) && (i == 1))
      {
        paramList = "";
      }
      else if (("launchAppWithTokens".equals(paramString)) && (i == 4))
      {
        this.jdField_a_of_type_Atid.a((String)paramList.get(0), (String)paramList.get(1), (String)paramList.get(2), (String)paramList.get(3), null, "");
        paramList = null;
      }
      else if (("getAppsVerionCodeBatch".equals(paramString)) && (i == 1))
      {
        paramList = bdiv.d(this.jdField_a_of_type_AndroidContentContext, (String)paramList.get(0));
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
    paramatgu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppShareJavaScript
 * JD-Core Version:    0.7.0.1
 */