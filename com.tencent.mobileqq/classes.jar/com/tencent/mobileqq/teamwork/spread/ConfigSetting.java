package com.tencent.mobileqq.teamwork.spread;

import ainf;
import aing;
import ainh;
import aini;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
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
    ThreadManager.executeOnSubThread(new aing(this));
  }
  
  private void a(JSONObject paramJSONObject, SharedPreferences.Editor paramEditor)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject1 = localJSONArray.getJSONObject(i);
      int k = ((JSONObject)localObject1).optInt("template_type", -1);
      Object localObject2 = new aini(this, null);
      this.f = paramJSONObject.optInt("containKeyword");
      if (paramEditor != null) {
        paramEditor.putInt("text_str_key_words_case", this.f);
      }
      label105:
      int j;
      if (this.f == 1)
      {
        ((aini)localObject2).jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
        ((aini)localObject2).jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");
        j = k;
        if (k == -1) {
          j = i;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject2);
        localObject1 = ((JSONObject)localObject1).optJSONArray("infos");
        if (localObject1 != null) {
          break label175;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ((aini)localObject2).jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
        ((aini)localObject2).jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0");
        break label105;
        label175:
        k = 0;
        while (k < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(k);
          ConfigSetting.TeamworkKeyWords localTeamworkKeyWords = new ConfigSetting.TeamworkKeyWords(this);
          localTeamworkKeyWords.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("template_name");
          localTeamworkKeyWords.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("template_id", -1);
          if (localTeamworkKeyWords.jdField_a_of_type_Int == -1) {
            QLog.d("ConfigSetting", 2, "template has no id");
          }
          localTeamworkKeyWords.jdField_b_of_type_Int = j;
          this.jdField_a_of_type_JavaUtilList.add(localTeamworkKeyWords);
          k += 1;
        }
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
  
  public float a()
  {
    return (float)this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    if ((paramBaseTimAIOTipsProcessor instanceof TeamWorkTextMsgTipsProcessor)) {
      return this.f;
    }
    return this.e;
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
      localObject = (aini)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aini)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aini)localObject).jdField_a_of_type_JavaLangString;
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
            return ((aini)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.executeOnSubThread(new ainf(this, paramConfig));
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForText)) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new ainh(this));
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
      localObject = (aini)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aini)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aini)localObject).jdField_a_of_type_ArrayOfJavaLangString;
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
      localObject = (aini)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      String[] arrayOfString = ((aini)localObject).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return ((aini)localObject).jdField_b_of_type_JavaLangString;
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
            return ((aini)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(((ConfigSetting.TeamworkKeyWords)localObject).jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting
 * JD-Core Version:    0.7.0.1
 */