package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msgbackup.controller.ResDownloadObject;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class MsgProcessImport
  extends MsgProcessConstant
{
  protected Map<String, String> b;
  protected MsgBackupResEntity c;
  
  public MsgProcessImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    this.b = c(paramMsgBackupResEntity.extraDataStr);
    this.c = paramMsgBackupResEntity;
  }
  
  protected static int a()
  {
    return AppConstants.SDCARD_PATH.length();
  }
  
  public static HashMap<String, String> c(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, paramString.get(str).toString());
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      int i = FileUtils.quickMove(paramString1, paramString2);
      if (QLog.isColorLevel())
      {
        File localFile = new File(paramString2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("restore,quickMove: ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" status:");
        localStringBuilder.append(i);
        localStringBuilder.append(" size:");
        if (localFile.exists()) {
          paramString1 = Long.valueOf(localFile.length());
        } else {
          paramString1 = "-1";
        }
        localStringBuilder.append(paramString1);
        b(localStringBuilder.toString());
      }
      return;
    }
    b("importFile null error ");
  }
  
  public abstract ResDownloadObject b();
  
  public abstract String c();
  
  public abstract String d();
  
  public void e()
  {
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("import resEntity:");
    ((StringBuilder)localObject2).append(((MsgBackupResEntity)localObject1).toLogString());
    b(((StringBuilder)localObject2).toString());
    localObject1 = d();
    localObject2 = c();
    try
    {
      a((String)localObject2, (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessImport
 * JD-Core Version:    0.7.0.1
 */