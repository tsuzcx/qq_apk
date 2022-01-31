package com.tencent.mobileqq.teamwork.spread;

import aise;
import aisg;
import aisi;
import aisk;
import aisl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigSetting
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private WtTicketPromise jdField_a_of_type_OicqWlogin_sdkRequestWtTicketPromise = new aisi(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ConfigSetting(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new aisg(this));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      try
      {
        localJSONArray = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) == 0) {
          break label179;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (Exception paramJSONObject)
      {
        int k;
        int j;
        JSONObject localJSONObject;
        ConfigSetting.TeamworkKeyWords localTeamworkKeyWords;
        QLog.e("ConfigSetting", 2, paramJSONObject.toString());
      }
      if (i < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getJSONObject(i);
        k = paramJSONObject.optInt("template_type", -1);
        if (paramJSONObject.optJSONArray("infos") != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("infos");
          j = 0;
          if (j < paramJSONObject.length())
          {
            localJSONObject = paramJSONObject.getJSONObject(j);
            localTeamworkKeyWords = new ConfigSetting.TeamworkKeyWords(this);
            localTeamworkKeyWords.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
            localTeamworkKeyWords.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
            if (localTeamworkKeyWords.jdField_a_of_type_Int == -1) {
              QLog.d("ConfigSetting", 2, "template has no id");
            }
            localTeamworkKeyWords.jdField_b_of_type_Int = k;
            this.jdField_a_of_type_JavaUtilList.add(localTeamworkKeyWords);
            j += 1;
            continue;
          }
        }
        i += 1;
      }
      else
      {
        label179:
        while (localJSONArray == null) {
          return;
        }
        i = 0;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, SharedPreferences.Editor paramEditor)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      aisl localaisl = new aisl(this, null);
      this.f = paramJSONObject.optInt("containKeyword");
      if (paramEditor != null) {
        paramEditor.putInt("text_str_key_words_case", this.f);
      }
      if (this.f == 1) {
        localaisl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
      }
      for (localaisl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");; localaisl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localaisl);
        i += 1;
        break;
        localaisl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
      }
    }
  }
  
  private String[] a(String paramString)
  {
    int i = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    if (!localStringTokenizer.hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfigSetting", 1, "split String faild :" + paramString);
      }
      return new String[0];
    }
    paramString = new String[localStringTokenizer.countTokens()];
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString[i] = localStringTokenizer.nextToken();
      i += 1;
    }
    return paramString;
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit();
        Object localObject = ((TeamWorkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a();
        if ((localObject != null) && (((JSONObject)localObject).optInt("retcode", -1) == 0))
        {
          a((JSONObject)localObject);
          if (((JSONObject)localObject).toString() != null)
          {
            localObject = ((JSONObject)localObject).toString();
            localEditor.putString("text_id_templates", (String)localObject);
            localEditor.apply();
          }
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
          continue;
        }
        String str = "";
      }
      catch (Exception localException)
      {
        QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + localException.toString());
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public float a()
  {
    return (float)this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ConfigSetting.TeamworkKeyWords a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ConfigSetting.TeamworkKeyWords localTeamworkKeyWords = (ConfigSetting.TeamworkKeyWords)localIterator.next();
      if (localTeamworkKeyWords.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localTeamworkKeyWords;
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    Iterator localIterator;
    if (((paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips)) || ((paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aisl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aisl)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aisl)localObject).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramBaseTimAIOTipsProcessor instanceof TeamWorkTextMsgTipsProcessor))
      {
        paramBaseTimAIOTipsProcessor = paramBaseTimAIOTipsProcessor.a();
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (ConfigSetting.TeamworkKeyWords)localIterator.next();
          if ((paramBaseTimAIOTipsProcessor.contains(((ConfigSetting.TeamworkKeyWords)localObject).jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int) != null)) {
            return ((aisl)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.executeOnSubThread(new aise(this, paramConfig));
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForText)) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new aisk(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String[] a(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    int i = 0;
    Iterator localIterator;
    if (((paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips)) || ((paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aisl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aisl)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aisl)localObject).jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      paramBaseTimAIOTipsProcessor = new String[this.jdField_a_of_type_JavaUtilList.size()];
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramBaseTimAIOTipsProcessor[i] = ((ConfigSetting.TeamworkKeyWords)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return paramBaseTimAIOTipsProcessor;
    }
    return new String[0];
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String b(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    Iterator localIterator;
    if (((paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips)) || ((paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aisl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aisl)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aisl)localObject).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramBaseTimAIOTipsProcessor instanceof TeamWorkTextMsgTipsProcessor))
      {
        paramBaseTimAIOTipsProcessor = paramBaseTimAIOTipsProcessor.a();
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (ConfigSetting.TeamworkKeyWords)localIterator.next();
          if ((paramBaseTimAIOTipsProcessor.contains(((ConfigSetting.TeamworkKeyWords)localObject).jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int) != null)) {
            return ((aisl)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public boolean b()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > this.g * 1000;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting
 * JD-Core Version:    0.7.0.1
 */