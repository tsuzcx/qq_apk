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
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.mobileqq.filemanager.tem.util.FileManagerUtil;
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
  private int jdField_a_of_type_Int = 5;
  private long jdField_a_of_type_Long = 0L;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 30;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 10;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "";
  private int f = 0;
  
  public QfileFileAssistantTipsConfigBean()
  {
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  private void d()
  {
    Object localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    ((IFileManagerReporter)QRoute.api(IFileManagerReporter.class)).addData("0X800AD01");
    localObject1 = ((BaseQQAppInterface)localObject1).getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + ((BaseQQAppInterface)localObject1).getCurrentUin(), 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.jdField_d_of_type_Int += 1;
      this.jdField_e_of_type_Int += 1;
      ((JSONObject)localObject2).put("local_day_last_time", MessageCache.a());
      ((JSONObject)localObject2).put("local_day_times", this.jdField_d_of_type_Int);
      ((JSONObject)localObject2).put("local_max_times", this.jdField_e_of_type_Int);
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
  
  private void e()
  {
    Object localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    localObject1 = ((BaseQQAppInterface)localObject1).getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + ((BaseQQAppInterface)localObject1).getCurrentUin(), 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.jdField_e_of_type_Int += this.jdField_a_of_type_Int;
      this.jdField_d_of_type_Int = 9999;
      ((JSONObject)localObject2).put("local_day_times", this.jdField_d_of_type_Int);
      ((JSONObject)localObject2).put("local_max_times", this.jdField_e_of_type_Int);
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
  
  private void f()
  {
    Object localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    if (localObject1 == null)
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
      return;
    }
    ((IFileManagerReporter)QRoute.api(IFileManagerReporter.class)).addData("0X800AD02");
    localObject1 = ((BaseQQAppInterface)localObject1).getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + ((BaseQQAppInterface)localObject1).getCurrentUin(), 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.f += 1;
      ((JSONObject)localObject2).put("local_click_times", this.f);
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
  
  public IFileAssistantTipsConfig.IBaseJump a()
  {
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("url")) {
      return new QfileFileAssistantTipsConfigBean.1(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("mqqapi")) {
      return new QfileFileAssistantTipsConfigBean.2(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("system")) {
      return new QfileFileAssistantTipsConfigBean.3(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("custom")) {
      return new QfileFileAssistantTipsConfigBean.4(this);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.5(this));
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "receiveAllConfigs|type: 606configContent is empty");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("local_day_times")) {
        this.jdField_d_of_type_Int = paramString.getInt("local_day_times");
      }
      if (paramString.has("local_day_last_time"))
      {
        this.jdField_a_of_type_Long = paramString.getLong("local_day_last_time");
        long l = MessageCache.a();
        if (!FileManagerUtil.a(this.jdField_a_of_type_Long * 1000L, l * 1000L, TimeZone.getDefault()))
        {
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "is not one day, set mLocalDayTims:0");
          this.jdField_d_of_type_Int = 0;
        }
      }
      if (paramString.has("local_max_times")) {
        this.jdField_e_of_type_Int = paramString.getInt("local_max_times");
      }
      this.jdField_b_of_type_Int = paramString.optInt("max_count");
      if (this.jdField_e_of_type_Int >= this.jdField_b_of_type_Int)
      {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.jdField_e_of_type_Int + " >= mMaxTimes:" + this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (paramString.has("local_click_times")) {
      this.f = paramString.getInt("local_click_times");
    }
    if (this.f >= this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.f + " >= mMaxClickTimes:" + this.jdField_c_of_type_Int);
      return;
    }
    if (paramString.getInt("switch") == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = paramString.getString("txt_content");
      this.jdField_c_of_type_JavaLangString = paramString.getString("jump_txt");
      this.jdField_a_of_type_Int = paramString.getInt("one_day_max");
      if (this.jdField_d_of_type_Int >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.jdField_d_of_type_Int + " >= mOneDayMaxTimes:" + this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_c_of_type_Int = paramString.getInt("click_max");
      this.jdField_d_of_type_JavaLangString = paramString.getString("jump_type");
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("url"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("url")).getString("url");
        return;
      }
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("mqqapi"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("mqqapi")).getString("url");
        return;
      }
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("custom"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("custom")).toString();
        return;
      }
      if (!this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("system")) {
        break;
      }
      this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("system")).getString("url");
      return;
      bool = false;
    }
  }
  
  public boolean a()
  {
    if (this.f >= this.jdField_c_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.f + " >= mMaxClickTimes:" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Int >= this.jdField_a_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.jdField_d_of_type_Int + " >= mOneDayMaxTimes:" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Int >= this.jdField_b_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.jdField_e_of_type_Int + " >= mMaxTimes:" + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.6(this));
  }
  
  public void c()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */