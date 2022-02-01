package com.tencent.mobileqq.upgrade;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.ApkWriteCodeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AuthCodeWriter
  implements ApkWriteCodeListener
{
  private AuthCodeWriter.ICheckCodeListener a;
  private String b;
  
  public AuthCodeWriter(String paramString, AuthCodeWriter.ICheckCodeListener paramICheckCodeListener)
  {
    this.b = paramString;
    this.a = paramICheckCodeListener;
  }
  
  public int a(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    boolean bool = paramString1.equals(BaseApplicationImpl.sApplication.getPackageName());
    paramInt = -1;
    int i = paramInt;
    if (bool)
    {
      paramBundle = this.b;
      i = -20;
      paramString1 = null;
      if (paramBundle != null)
      {
        if (paramBundle.length() == 0) {}
        for (;;)
        {
          paramInt = 0;
          break;
          try
          {
            paramBundle = new File(paramString2);
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append("~tmp");
            localObject = new File(((StringBuilder)localObject).toString());
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            paramBundle.renameTo((File)localObject);
            ApkExternalInfoTool.a((File)localObject, this.b);
            ((File)localObject).renameTo(paramBundle);
          }
          catch (Exception paramString1)
          {
            paramInt = -20;
          }
          catch (IOException paramString1)
          {
            paramInt = i;
            if (paramString1.getMessage() != null)
            {
              paramInt = i;
              if (paramString1.getMessage().contains("space")) {
                paramInt = -10;
              }
            }
          }
          catch (FileNotFoundException paramString1)
          {
            paramInt = -30;
          }
        }
      }
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.b(paramInt);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("writeCodeToApk:");
      paramBundle.append(this.b);
      paramBundle.append(", forFile:");
      paramBundle.append(paramString2);
      paramBundle.append(" result: ");
      paramBundle.append(paramInt);
      QLog.d("UpgradeController", 1, paramBundle.toString(), paramString1);
      i = paramInt;
    }
    return i;
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (BaseApplicationImpl.sApplication.getPackageName().equals(paramString))
    {
      if (QLog.isDevelopLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("syncVersionCodeToTool:");
        paramBundle.append(paramString);
        paramBundle.append(", versionCode:");
        paramBundle.append(paramInt);
        QLog.d("UpgradeController", 4, paramBundle.toString());
      }
      paramString = this.a;
      if ((paramString != null) && (!paramString.a(paramInt))) {
        this.b = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.AuthCodeWriter
 * JD-Core Version:    0.7.0.1
 */