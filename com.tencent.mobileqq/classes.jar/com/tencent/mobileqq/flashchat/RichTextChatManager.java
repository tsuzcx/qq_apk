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
  private String a = "";
  private boolean b;
  private ArrayList<Integer> c = new ArrayList();
  private int d = 0;
  private boolean e;
  private String f = HardCodeUtil.a(2131910925);
  private String g = HardCodeUtil.a(2131910926);
  private boolean h;
  private int i = 0;
  private String j = "";
  private String k = "";
  
  public RichTextChatManager(QQAppInterface paramQQAppInterface)
  {
    this.c.clear();
    this.e = SharedPreUtils.bP(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
  
  private boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.d = paramString.optInt("first_insatll_entry", 0);
        if ((this.d < 0) || (this.d >= 6)) {
          this.d = 0;
        }
        Object localObject1 = new ArrayList();
        ??? = paramString.optJSONArray("enrty_orders");
        int m;
        if (??? != null)
        {
          m = 0;
          if (m < ((JSONArray)???).length())
          {
            int n = ((JSONArray)???).getInt(m);
            if ((n < 0) || (n >= 6)) {
              break label294;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(n));
            break label294;
          }
        }
        synchronized (this.c)
        {
          this.c.clear();
          this.c.addAll((Collection)localObject1);
          a(this.c);
          localObject1 = paramString.optString("zhitu_title");
          ??? = paramString.optString("zhitu_legal_wording");
          if (paramString.has("aio_input_shan_icon_url1")) {
            this.j = paramString.optString("aio_input_shan_icon_url1");
          }
          if (paramString.has("aio_input_shan_icon_url2")) {
            this.k = paramString.optString("aio_input_shan_icon_url2");
          }
          if (paramString.optInt("zhitu_legal_switch") != 1) {
            break label301;
          }
          bool = true;
          this.h = bool;
          this.i = paramString.optInt("zhitu_style", 0);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.f = ((String)localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)???)) {
            this.g = ((String)???);
          }
          this.b = true;
          return true;
        }
        m += 1;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTextChatManager", 2, paramString, new Object[0]);
        }
        this.b = true;
        return false;
      }
      label294:
      continue;
      label301:
      boolean bool = false;
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.c.contains(Integer.valueOf(2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateHiBoomSwith: enable=");
    localStringBuilder.append(bool);
    QLog.d("RichTextChatManager", 2, localStringBuilder.toString());
    paramQQAppInterface = ((IVasService)paramQQAppInterface.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.updateHiBoomSwitch(bool);
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    int m = EmotionSharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("last Memoried Tab:");
      localStringBuilder.append(m);
      QLog.d("RichTextChatManager", 2, localStringBuilder.toString());
    }
    if (m == -1)
    {
      if (!SharedPreUtils.bO(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
      {
        int n = paramArrayList.indexOf(Integer.valueOf(a(paramQQAppInterface)));
        SharedPreUtils.m(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Accourding to : selectedTab:");
          paramQQAppInterface.append(m);
          QLog.d("RichTextChatManager", 2, paramQQAppInterface.toString());
        }
        if (n != -1) {
          return n;
        }
      }
      return 0;
    }
    m = paramArrayList.indexOf(Integer.valueOf(m));
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Accourding to orderlist, currentTabPosition:");
      paramQQAppInterface.append(m);
      QLog.d("RichTextChatManager", 2, paramQQAppInterface.toString());
    }
    if (-1 != m) {
      return m;
    }
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    d(paramAppRuntime);
    return this.d;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Integer paramInteger, ConfigurationService.Config paramConfig)
  {
    int n = paramConfig.version.get();
    int m = SharedPreUtils.bM(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int i1 = SharedPreUtils.bN(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int i2 = AppSetting.d();
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 1, String.format("received richTextChat remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(i2) }));
    }
    if (i1 != i2)
    {
      SharedPreUtils.V(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i2);
      m = 0;
    }
    if (n != m)
    {
      paramInteger = ConfigServlet.b(paramConfig, m, paramInteger.intValue());
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
          SharedPreUtils.g(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), n, paramInteger);
          d(paramQQAppInterface);
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
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.e = paramBoolean;
    SharedPreUtils.n(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public ArrayList<Integer> b(AppRuntime paramAppRuntime)
  {
    d(paramAppRuntime);
    return this.c;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a(paramQQAppInterface).b(paramQQAppInterface);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    FlashChatManager localFlashChatManager = (FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    localObject = ((ArrayList)localObject).iterator();
    boolean bool2 = false;
    while (((Iterator)localObject).hasNext())
    {
      int m = ((Integer)((Iterator)localObject).next()).intValue();
      boolean bool1 = true;
      if (m == 1)
      {
        if (localFlashChatManager.g().size() <= 0) {
          bool1 = false;
        }
        bool2 |= bool1;
      }
      else if (m == 2)
      {
        bool2 |= HiBoomConstants.a(paramQQAppInterface).isMemorySupport();
      }
      else if (m == 0)
      {
        bool2 |= true;
      }
      else
      {
        if (m == 3) {}
        for (;;)
        {
          bool2 = true;
          break;
          if (m != 4) {
            if (m != 5) {
              break;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return (b(paramQQAppInterface)) && (this.e);
  }
  
  public boolean c(AppRuntime paramAppRuntime)
  {
    synchronized (this.c)
    {
      paramAppRuntime = b(paramAppRuntime);
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
  
  public void d(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!this.b) || (!this.a.equals(str)))
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
            d((QQAppInterface)paramAppRuntime);
          }
        }
        this.a = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("first install entry:");
      paramAppRuntime.append(this.d);
      paramAppRuntime.append(" mOder:");
      paramAppRuntime.append(this.c);
      QLog.d("RichTextChatManager", 2, paramAppRuntime.toString());
    }
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.j;
  }
  
  public String g()
  {
    return this.k;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.RichTextChatManager
 * JD-Core Version:    0.7.0.1
 */