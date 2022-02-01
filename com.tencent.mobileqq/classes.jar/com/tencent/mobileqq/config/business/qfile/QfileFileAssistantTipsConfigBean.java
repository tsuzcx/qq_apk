package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileFileAssistantTipsConfigBean
  implements IFileAssistantTipsConfig, IQStorageSafable<String>
{
  public String a = "{}";
  private boolean b = false;
  private String c = "";
  private String d = "";
  private int e = 5;
  private int f = 30;
  private int g = 10;
  private String h = "";
  private String i = "";
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private long m = 0L;
  
  private void h()
  {
    Object localObject1 = QQFileManagerUtilImpl.l();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    ((IFileManagerReporter)QRoute.api(IFileManagerReporter.class)).addData("0X800AD01");
    Object localObject2 = ((BaseQQAppInterface)localObject1).getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qfile_file_assistant_tips");
    localStringBuilder.append(((BaseQQAppInterface)localObject1).getCurrentUin());
    localObject1 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.j += 1;
      this.k += 1;
      ((JSONObject)localObject2).put("local_day_last_time", MessageCache.c());
      ((JSONObject)localObject2).put("local_day_times", this.j);
      ((JSONObject)localObject2).put("local_max_times", this.k);
      localObject2 = ((JSONObject)localObject2).toString();
      if (QLog.isDebugVersion()) {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, (String)localObject2);
      }
      ((SharedPreferences)localObject1).edit().putString("qfile_file_assistant_tips", (String)localObject2).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void i()
  {
    Object localObject1 = QQFileManagerUtilImpl.l();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    Object localObject2 = ((BaseQQAppInterface)localObject1).getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qfile_file_assistant_tips");
    localStringBuilder.append(((BaseQQAppInterface)localObject1).getCurrentUin());
    localObject1 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.k += this.e;
      this.j = 9999;
      ((JSONObject)localObject2).put("local_day_times", this.j);
      ((JSONObject)localObject2).put("local_max_times", this.k);
      localObject2 = ((JSONObject)localObject2).toString();
      if (QLog.isDebugVersion()) {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, (String)localObject2);
      }
      ((SharedPreferences)localObject1).edit().putString("qfile_file_assistant_tips", (String)localObject2).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void j()
  {
    Object localObject1 = QQFileManagerUtilImpl.l();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    ((IFileManagerReporter)QRoute.api(IFileManagerReporter.class)).addData("0X800AD02");
    Object localObject2 = ((BaseQQAppInterface)localObject1).getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qfile_file_assistant_tips");
    localStringBuilder.append(((BaseQQAppInterface)localObject1).getCurrentUin());
    localObject1 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.l += 1;
      ((JSONObject)localObject2).put("local_click_times", this.l);
      localObject2 = ((JSONObject)localObject2).toString();
      if (QLog.isDebugVersion()) {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, (String)localObject2);
      }
      ((SharedPreferences)localObject1).edit().putString("qfile_file_assistant_tips", (String)localObject2).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "receiveAllConfigs|type: 606configContent is empty");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString);
    }
    this.a = paramString;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("local_day_times")) {
          this.j = paramString.getInt("local_day_times");
        }
        if (!paramString.has("local_day_last_time")) {
          break label594;
        }
        this.m = paramString.getLong("local_day_last_time");
        long l1 = MessageCache.c();
        if (!QQFileManagerUtilImpl.a(this.m * 1000L, l1 * 1000L, TimeZone.getDefault()))
        {
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "is not one day, set mLocalDayTims:0");
          this.j = 0;
        }
        if (paramString.has("local_max_times")) {
          this.k = paramString.getInt("local_max_times");
        }
        this.f = paramString.optInt("max_count");
        if (this.k >= this.f)
        {
          paramString = new StringBuilder();
          paramString.append("mLocalMaxTimes:");
          paramString.append(this.k);
          paramString.append(" >= mMaxTimes:");
          paramString.append(this.f);
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString.toString());
          this.b = false;
          return;
        }
        if (paramString.has("local_click_times")) {
          this.l = paramString.getInt("local_click_times");
        }
        if (this.l >= this.g)
        {
          this.b = false;
          paramString = new StringBuilder();
          paramString.append("mLocalClickTimes:");
          paramString.append(this.l);
          paramString.append(" >= mMaxClickTimes:");
          paramString.append(this.g);
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString.toString());
          return;
        }
        if (paramString.getInt("switch") != 1) {
          break label597;
        }
        bool = true;
        this.b = bool;
        this.c = paramString.getString("txt_content");
        this.d = paramString.getString("jump_txt");
        this.e = paramString.getInt("one_day_max");
        if (this.j >= this.e)
        {
          this.b = false;
          paramString = new StringBuilder();
          paramString.append("mLocalDayTims:");
          paramString.append(this.j);
          paramString.append(" >= mOneDayMaxTimes:");
          paramString.append(this.e);
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString.toString());
          return;
        }
        this.g = paramString.getInt("click_max");
        this.h = paramString.getString("jump_type");
        if (this.h.equalsIgnoreCase("url"))
        {
          this.i = new JSONObject(paramString.getString("url")).getString("url");
          return;
        }
        if (this.h.equalsIgnoreCase("mqqapi"))
        {
          this.i = new JSONObject(paramString.getString("mqqapi")).getString("url");
          return;
        }
        if (this.h.equalsIgnoreCase("custom"))
        {
          this.i = new JSONObject(paramString.getString("custom")).toString();
          return;
        }
        if (this.h.equalsIgnoreCase("system"))
        {
          this.i = new JSONObject(paramString.getString("system")).getString("url");
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label594:
      continue;
      label597:
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (this.l >= this.g)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLocalClickTimes:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" >= mMaxClickTimes:");
      localStringBuilder.append(this.g);
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, localStringBuilder.toString());
      this.b = false;
    }
    if (this.j >= this.e)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLocalDayTims:");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" >= mOneDayMaxTimes:");
      localStringBuilder.append(this.e);
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, localStringBuilder.toString());
      this.b = false;
    }
    if (this.k >= this.f)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLocalMaxTimes:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" >= mMaxTimes:");
      localStringBuilder.append(this.f);
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, localStringBuilder.toString());
      this.b = false;
    }
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public IFileAssistantTipsConfig.IBaseJump d()
  {
    if (this.h.equalsIgnoreCase("url")) {
      return new QfileFileAssistantTipsConfigBean.1(this);
    }
    if (this.h.equalsIgnoreCase("mqqapi")) {
      return new QfileFileAssistantTipsConfigBean.2(this);
    }
    if (this.h.equalsIgnoreCase("system")) {
      return new QfileFileAssistantTipsConfigBean.3(this);
    }
    if (this.h.equalsIgnoreCase("custom")) {
      return new QfileFileAssistantTipsConfigBean.4(this);
    }
    return null;
  }
  
  public void e()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.5(this));
  }
  
  public void f()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.6(this));
  }
  
  public void g()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */