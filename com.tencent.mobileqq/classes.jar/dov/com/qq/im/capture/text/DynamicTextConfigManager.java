package dov.com.qq.im.capture.text;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import blqj;
import bltq;
import blxf;
import blxg;
import blxh;
import blxj;
import blzq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ndr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicTextConfigManager
  extends blqj
{
  public static File a;
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + "usable" + File.separator;
  public int a;
  private blxh jdField_a_of_type_Blxh = new blxh(this);
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(blzq.a(), "dynamic_text");
  }
  
  public DynamicTextConfigManager()
  {
    this.jdField_a_of_type_Int = 120;
  }
  
  public static String a(@NonNull blxg paramblxg)
  {
    return new File(jdField_a_of_type_JavaIoFile, paramblxg.a()).getPath();
  }
  
  private ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString).getJSONArray("texts");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = DynamicTextConfigManager.DynamicTextConfigBean.convertFrom(paramString.getJSONObject(i));
        if (localDynamicTextConfigBean != null)
        {
          localDynamicTextConfigBean.iconDrawableId = blxf.a(localDynamicTextConfigBean.text_id);
          localArrayList.add(localDynamicTextConfigBean);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("text_guide");
        if (paramString == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DText", 2, paramString.toString());
        }
        this.jdField_b_of_type_JavaLangString = paramString.optString("default");
        this.jdField_c_of_type_JavaLangString = paramString.optString("local_slides");
        this.d = paramString.optString("local_singlePhoto");
        this.e = paramString.optString("local_singleVideo");
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
        if (localSharedPreferences == null) {
          return;
        }
        if (paramString.optInt("is_text_guide_on") == 1)
        {
          this.jdField_c_of_type_Boolean = bool;
          localSharedPreferences.edit().putBoolean("dynamic_text_key_is_hint_on", this.jdField_c_of_type_Boolean).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_default", this.jdField_b_of_type_JavaLangString).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_local_slides", this.jdField_c_of_type_JavaLangString).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_photo", this.d).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_video", this.e).apply();
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  public static boolean b()
  {
    boolean bool = new File(jdField_a_of_type_JavaIoFile + File.separator + "dynamic_text_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "DynamicTextConfigManager isStickerConfigFileExist" + bool);
    }
    return bool;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(String arg1)
  {
    try
    {
      i = Integer.valueOf(???).intValue();
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = (DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next();
          if ((localDynamicTextConfigBean != null) && (localDynamicTextConfigBean.text_id == i)) {
            return localDynamicTextConfigBean;
          }
        }
        return null;
      }
    }
    catch (Exception ???)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public String a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DText", 2, "hint get from:" + paramInt);
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
    if (paramInt == 1)
    {
      if (this.jdField_c_of_type_JavaLangString != null) {
        return this.jdField_c_of_type_JavaLangString;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dynamic_text_hint_local_slides", "");
      }
    }
    else if (paramInt == 2)
    {
      if (this.d != null) {
        return this.d;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dtext_hint_single_photo", "");
      }
    }
    else if (paramInt == 3)
    {
      if (this.e != null) {
        return this.e;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dtext_hint_single_video", "");
      }
    }
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("key_dynamic_text_hint_default", "");
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<DynamicTextConfigManager.DynamicTextConfigBean> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a() {}
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, blxj paramblxj)
  {
    if ((paramDynamicTextConfigBean == null) || (paramDynamicTextConfigBean.fontInfos == null)) {
      return;
    }
    ThreadManager.postImmediately(new DynamicTextConfigManager.1(this, paramDynamicTextConfigBean, paramblxj), null, true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "handleDynamicTextConfig config is: " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())))
    {
      Object localObject2 = a(paramString);
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
          b(paramString);
          this.jdField_a_of_type_Boolean = true;
          a().notifyObservers(bltq.class, 3, false, null);
          ??? = ((ArrayList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)???).next();
            if ((((DynamicTextConfigManager.DynamicTextConfigBean)localObject2).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2)) && (NetConnInfoCenter.isWifiConn())) {
              a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2, null);
            }
          }
        }
        blzq.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg", paramString);
      }
    }
  }
  
  public void a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)localObject).next()).text_id == 28) {
            ((Iterator)localObject).remove();
          }
        }
      } while (!paramBoolean);
      localObject = new DynamicTextConfigManager.DynamicTextConfigBean();
      ((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id = 28;
      ((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId = blxf.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
    } while ((paramList == null) || (paramList.size() <= 1));
    paramList.add(1, localObject);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(blxg paramblxg)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramblxg == null) || (TextUtils.isEmpty(paramblxg.jdField_c_of_type_JavaLangString))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramblxg.jdField_a_of_type_JavaLangString));
      if (!new File(jdField_a_of_type_JavaIoFile, paramblxg.a()).exists()) {
        return false;
      }
      bool1 = bool2;
    } while (new File(jdField_a_of_type_JavaLangString + paramblxg.jdField_c_of_type_JavaLangString).exists());
    return false;
  }
  
  public boolean a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean)
  {
    if (paramDynamicTextConfigBean == null) {
      return false;
    }
    if (paramDynamicTextConfigBean.fontInfos == null) {
      return true;
    }
    paramDynamicTextConfigBean = paramDynamicTextConfigBean.fontInfos.iterator();
    while (paramDynamicTextConfigBean.hasNext()) {
      if (!a((blxg)paramDynamicTextConfigBean.next())) {
        return false;
      }
    }
    return true;
  }
  
  public String b(blxg paramblxg)
  {
    if (paramblxg == null) {
      return null;
    }
    return jdField_a_of_type_JavaLangString + paramblxg.jdField_c_of_type_JavaLangString + File.separator;
  }
  
  public void b() {}
  
  public boolean b(blxg paramblxg)
  {
    try
    {
      ndr.a(new File(jdField_a_of_type_JavaIoFile, paramblxg.a()), jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramblxg)
    {
      if (QLog.isColorLevel()) {
        paramblxg.printStackTrace();
      }
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile start");
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "initConfigListByFile return by mIsInitByCache");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        ??? = blzq.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg");
        Object localObject1 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile dir=" + jdField_a_of_type_JavaIoFile + " file=" + "dynamic_text_config.cfg");
          localObject1 = ???;
        }
      }
      Object localObject3;
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
            break;
          }
          return;
        }
        ??? = blzq.a("dynamic_text_config.cfg");
        localObject3 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile read from asset");
          localObject3 = ???;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ArrayList localArrayList = a((String)localObject3);
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      }
      b((String)localObject3);
      this.jdField_b_of_type_Boolean = true;
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)localObject3).next();
          if ((((DynamicTextConfigManager.DynamicTextConfigBean)???).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)???)) && (NetConnInfoCenter.isWifiConn())) {
            a((DynamicTextConfigManager.DynamicTextConfigBean)???, null);
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("dynamic_text_key_is_hint_on", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager
 * JD-Core Version:    0.7.0.1
 */