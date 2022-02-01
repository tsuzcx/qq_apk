package com.tencent.mobileqq.flashchat;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RichTextChatManager
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713372);
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131713373);
  private boolean jdField_c_of_type_Boolean;
  private String d = "";
  private String e = "";
  
  public RichTextChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Boolean = SharedPreUtils.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static RichTextChatManager a(QQAppInterface paramQQAppInterface)
  {
    return (RichTextChatManager)paramQQAppInterface.getManager(QQManagerFactory.RICH_TEXT_CHAT_MANAGER);
  }
  
  private static ArrayList a(ArrayList<Integer> paramArrayList)
  {
    Object localObject = new LinkedHashSet();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LinkedHashSet)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    paramArrayList.clear();
    localObject = ((LinkedHashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayList.add(((Iterator)localObject).next());
    }
    return paramArrayList;
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_chat_config_content");
    paramSharedPreferences = paramSharedPreferences.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("get content from sp:");
      paramString.append(paramSharedPreferences);
      QLog.d("RichTextChatManager", 2, paramString.toString());
    }
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      a(paramSharedPreferences);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateHiBoomSwith: enable=");
    localStringBuilder.append(bool);
    QLog.d("RichTextChatManager", 2, localStringBuilder.toString());
    paramQQAppInterface = ((IVasService)paramQQAppInterface.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.updateHiBoomSwitch(bool);
    }
  }
  
  private boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("first_insatll_entry", 0);
        if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= 6)) {
          this.jdField_a_of_type_Int = 0;
        }
        Object localObject1 = new ArrayList();
        ??? = paramString.optJSONArray("enrty_orders");
        int i;
        if (??? != null)
        {
          i = 0;
          if (i < ((JSONArray)???).length())
          {
            int j = ((JSONArray)???).getInt(i);
            if ((j < 0) || (j >= 6)) {
              break label294;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(j));
            break label294;
          }
        }
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
          a(this.jdField_a_of_type_JavaUtilArrayList);
          localObject1 = paramString.optString("zhitu_title");
          ??? = paramString.optString("zhitu_legal_wording");
          if (paramString.has("aio_input_shan_icon_url1")) {
            this.d = paramString.optString("aio_input_shan_icon_url1");
          }
          if (paramString.has("aio_input_shan_icon_url2")) {
            this.e = paramString.optString("aio_input_shan_icon_url2");
          }
          if (paramString.optInt("zhitu_legal_switch") != 1) {
            break label301;
          }
          bool = true;
          this.jdField_c_of_type_Boolean = bool;
          this.jdField_b_of_type_Int = paramString.optInt("zhitu_style", 0);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)???)) {
            this.jdField_c_of_type_JavaLangString = ((String)???);
          }
          this.jdField_a_of_type_Boolean = true;
          return true;
        }
        i += 1;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTextChatManager", 2, paramString, new Object[0]);
        }
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
      label294:
      continue;
      label301:
      boolean bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    int i = EmotionSharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("last Memoried Tab:");
      localStringBuilder.append(i);
      QLog.d("RichTextChatManager", 2, localStringBuilder.toString());
    }
    if (i == -1)
    {
      if (!SharedPreUtils.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
      {
        int j = paramArrayList.indexOf(Integer.valueOf(a(paramQQAppInterface)));
        SharedPreUtils.n(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Accourding to : selectedTab:");
          paramQQAppInterface.append(i);
          QLog.d("RichTextChatManager", 2, paramQQAppInterface.toString());
        }
        if (j != -1) {
          return j;
        }
      }
      return 0;
    }
    i = paramArrayList.indexOf(Integer.valueOf(i));
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Accourding to orderlist, currentTabPosition:");
      paramQQAppInterface.append(i);
      QLog.d("RichTextChatManager", 2, paramQQAppInterface.toString());
    }
    if (-1 != i) {
      return i;
    }
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<Integer> a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Integer paramInteger, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.aC(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.aD(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 1, String.format("received richTextChat remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      SharedPreUtils.R(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    if (j != i)
    {
      paramInteger = ConfigServlet.b(paramConfig, i, paramInteger.intValue());
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("content:");
        paramConfig.append(paramInteger);
        QLog.d("RichTextChatManager", 1, paramConfig.toString());
      }
      if (!TextUtils.isEmpty(paramInteger))
      {
        if (a(paramInteger))
        {
          SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, paramInteger);
          a(paramQQAppInterface);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RichTextChatManager", 1, "config content parse error , do nothing");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RichTextChatManager", 1, "config content is null , do nothing");
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaLangString.equals(str)))
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("rich_text_chat_config_version");
        if (localSharedPreferences.contains(localStringBuilder.toString()))
        {
          a(localSharedPreferences, str);
          if ((paramAppRuntime instanceof QQAppInterface)) {
            a((QQAppInterface)paramAppRuntime);
          }
        }
        this.jdField_a_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("first install entry:");
      paramAppRuntime.append(this.jdField_a_of_type_Int);
      paramAppRuntime.append(" mOder:");
      paramAppRuntime.append(this.jdField_a_of_type_JavaUtilArrayList);
      QLog.d("RichTextChatManager", 2, paramAppRuntime.toString());
    }
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreUtils.o(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a(paramQQAppInterface).a(paramQQAppInterface);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    FlashChatManager localFlashChatManager = (FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    localObject = ((ArrayList)localObject).iterator();
    boolean bool2 = false;
    while (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      boolean bool1 = true;
      if (i == 1)
      {
        if (localFlashChatManager.a().size() <= 0) {
          bool1 = false;
        }
        bool2 |= bool1;
      }
      else if (i == 2)
      {
        bool2 |= HiBoomConstants.a(paramQQAppInterface).isMemorySupport();
      }
      else if (i == 0)
      {
        bool2 |= true;
      }
      else
      {
        if (i == 3) {}
        for (;;)
        {
          bool2 = true;
          break;
          if (i != 4) {
            if (i != 5) {
              break;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      paramAppRuntime = a(paramAppRuntime);
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!paramAppRuntime.hasNext()) {
            break;
          }
          if (((Integer)paramAppRuntime.next()).intValue() == 0) {
            bool1 = true;
          }
        }
      }
      return bool2;
    }
    for (;;)
    {
      throw paramAppRuntime;
    }
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface)) && (this.jdField_b_of_type_Boolean);
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.RichTextChatManager
 * JD-Core Version:    0.7.0.1
 */