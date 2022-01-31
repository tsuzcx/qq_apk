package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import anwm;
import bbdj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class QQSysAndEmojiBaseInfo
{
  private static JSONObject a;
  public ArrayList<Integer> a;
  public HashMap<Integer, QQSysAndEmojiBaseInfo.QQEmoConfigItem> a;
  
  public QQSysAndEmojiBaseInfo()
  {
    a();
  }
  
  public static JSONObject a()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_OrgJsonJSONObject == null)
        {
          String str = null;
          long l = System.currentTimeMillis();
          File localFile = new File(anwm.b() + "face_config.json");
          if (!localFile.exists()) {
            continue;
          }
          str = bbdj.a(localFile);
          if (!TextUtils.isEmpty(str))
          {
            jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
            if (QLog.isColorLevel()) {
              QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "getFaceConfigJson len:", Integer.valueOf(jdField_a_of_type_OrgJsonJSONObject.length()), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      return jdField_a_of_type_OrgJsonJSONObject;
      QLog.d("QQSysAndEmojiBaseInfo", 1, "getFaceConfigJson not exist!");
      ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiBaseInfo.1());
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_OrgJsonJSONObject = null;
    a();
  }
  
  public abstract ArrayList<Integer> a();
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return a((QQSysAndEmojiBaseInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  public boolean a(QQSysAndEmojiBaseInfo.QQEmoConfigItem paramQQEmoConfigItem)
  {
    return "1".equals(paramQQEmoConfigItem.QHide);
  }
  
  public ArrayList<Integer> b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiBaseInfo", 2, "config is null, use old order!");
    }
    return a();
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return "1".equals(((QQSysAndEmojiBaseInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo
 * JD-Core Version:    0.7.0.1
 */