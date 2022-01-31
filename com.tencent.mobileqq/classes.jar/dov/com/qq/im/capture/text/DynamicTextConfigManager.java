package dov.com.qq.im.capture.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import anwg;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.util.QIMFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicTextConfigManager
  extends IQIMManager
{
  public static File a;
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + "usable" + File.separator;
  private DynamicTextConfigManager.DynamicTextResDownloader jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextResDownloader = new DynamicTextConfigManager.DynamicTextResDownloader(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "dynamic_text");
  }
  
  public static String a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    return new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()).getPath();
  }
  
  private ArrayList a(String paramString)
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
          localDynamicTextConfigBean.iconDrawableId = DynamicTextBuilder.a(localDynamicTextConfigBean.text_id);
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
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a() {}
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback)
  {
    if ((paramDynamicTextConfigBean == null) || (paramDynamicTextConfigBean.fontInfos == null)) {
      return;
    }
    ThreadManager.postImmediately(new anwg(this, paramDynamicTextConfigBean, paramIDynamicTextResDownloadCallback), null, true);
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
          this.jdField_a_of_type_Boolean = true;
          a().notifyObservers(CaptureConfigUpdateObserver.class, 3, false, null);
          ??? = ((ArrayList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (DynamicTextConfigManager.DynamicTextConfigBean)((Iterator)???).next();
            if ((((DynamicTextConfigManager.DynamicTextConfigBean)localObject2).predownload == 1) && (!a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2)) && (NetConnInfoCenter.isWifiConn())) {
              a((DynamicTextConfigManager.DynamicTextConfigBean)localObject2, null);
            }
          }
        }
        QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg", paramString);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
  
  public boolean a(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramDynamicTextFontInfo == null) || (TextUtils.isEmpty(paramDynamicTextFontInfo.c))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramDynamicTextFontInfo.jdField_a_of_type_JavaLangString));
      if (!new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()).exists()) {
        return false;
      }
      bool1 = bool2;
    } while (new File(jdField_a_of_type_JavaLangString + paramDynamicTextFontInfo.c).exists());
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
      if (!a((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)paramDynamicTextConfigBean.next())) {
        return false;
      }
    }
    return true;
  }
  
  public String b(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo == null) {
      return null;
    }
    return jdField_a_of_type_JavaLangString + paramDynamicTextFontInfo.c + File.separator;
  }
  
  public void b() {}
  
  public boolean b(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    try
    {
      ZipUtils.a(new File(jdField_a_of_type_JavaIoFile, paramDynamicTextFontInfo.a()), jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramDynamicTextFontInfo)
    {
      if (QLog.isColorLevel()) {
        paramDynamicTextFontInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile start");
    }
    if ((this.b) || (this.jdField_a_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "initConfigListByFile return by mIsInitByCache");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        ??? = QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "dynamic_text_config.cfg");
        Object localObject1 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile dir=" + jdField_a_of_type_JavaIoFile + " file=" + "dynamic_text_config.cfg");
          localObject1 = ???;
        }
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break;
          }
          return;
        }
        ??? = QIMFileUtils.a("dynamic_text_config.cfg");
        localObject3 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile read from asset");
          localObject3 = ???;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      Object localObject3 = a((String)localObject3);
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty())) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject3);
      }
      this.b = true;
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
      {
        localObject3 = ((ArrayList)localObject3).iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager
 * JD-Core Version:    0.7.0.1
 */