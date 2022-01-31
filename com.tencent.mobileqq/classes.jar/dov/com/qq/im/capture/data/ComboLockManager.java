package dov.com.qq.im.capture.data;

import ajed;
import ajfi;
import ajfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import baig;
import bhfc;
import bhhe;
import bhhf;
import bhhg;
import bjad;
import bjae;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import sgi;

public class ComboLockManager
  implements IEventReceiver
{
  public static final String a;
  int jdField_a_of_type_Int = -1;
  ajfo jdField_a_of_type_Ajfo = new bhhf(this);
  bhhg jdField_a_of_type_Bhhg;
  bjad jdField_a_of_type_Bjad;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bhfc.a();
  public LockedCategory a;
  public QIMFilterCategoryItem a;
  WeakReference<MessengerService> jdField_a_of_type_JavaLangRefWeakReference;
  HashMap<String, LockedCategory> jdField_a_of_type_JavaUtilHashMap;
  volatile boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aT + "/tencent/qim/share/";
  }
  
  public ComboLockManager()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    MessengerService localMessengerService = (MessengerService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localMessengerService != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "ipc_f_c_s");
      localBundle.putBoolean("k_r", paramBoolean);
      localBundle.putString("k_s_p_c", paramString1);
      localBundle.putString("k_f_id", paramString2);
      localMessengerService.a(localBundle);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bhhg == null)
    {
      this.jdField_a_of_type_Bhhg = new bhhg(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "registerStoryReceiver");
      }
      sgi.a().registerSubscriber(this.jdField_a_of_type_Bhhg);
    }
  }
  
  public LockedCategory a(String paramString)
  {
    return (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhhg != null)
    {
      this.jdField_a_of_type_Bhhg = new bhhg(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "unregisterStoryReceiver");
      }
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Bhhg);
      this.jdField_a_of_type_Bhhg = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bjad parambjad)
  {
    if (this.jdField_a_of_type_Bjad == parambjad) {
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "same data");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "updateConfigData isfrist " + this.jdField_b_of_type_Boolean + " sendStory " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData first card.snedSrory " + this.jdField_a_of_type_Boolean);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = parambjad.jdField_a_of_type_JavaUtilHashMap;
      this.jdField_a_of_type_Bjad = parambjad;
      parambjad = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (parambjad.hasNext())
      {
        Object localObject = (String)parambjad.next();
        localObject = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((LockedCategory)localObject).jdField_a_of_type_Boolean = a(((LockedCategory)localObject).jdField_a_of_type_JavaLangString);
        if ((((LockedCategory)localObject).jdField_a_of_type_Boolean) && (((LockedCategory)localObject).jdField_a_of_type_Int == 2))
        {
          this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory = ((LockedCategory)localObject);
          c();
        }
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData " + localObject + " lock " + ((LockedCategory)localObject).jdField_a_of_type_Boolean);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    LockedCategory localLockedCategory;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      bool1 = false;
      i = -1;
      localLockedCategory = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("ComboLockManager", 2, "is locke " + paramString + " code" + i);
        if (i == 3) {
          QLog.i("ComboLockManager", 2, "islock result" + bool1 + " type " + localLockedCategory.jdField_a_of_type_Int + " mHaveSendStory " + this.jdField_a_of_type_Boolean);
        }
      }
      return bool1;
      localLockedCategory = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localLockedCategory == null)
      {
        bool1 = false;
      }
      else if (!localLockedCategory.jdField_a_of_type_Boolean)
      {
        bool1 = false;
        i = 1;
      }
      else if (localLockedCategory.a())
      {
        bool1 = false;
        i = 2;
      }
      else if (localLockedCategory.jdField_a_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString.equals(paramString)) {}
          }
        }
        else
        {
          bool1 = true;
        }
        i = 3;
      }
      else if (localLockedCategory.jdField_a_of_type_Int == 1)
      {
        if (!localLockedCategory.jdField_b_of_type_Boolean)
        {
          localLockedCategory.jdField_a_of_type_Boolean = baig.y(BaseApplicationImpl.getApplication(), paramString);
          localLockedCategory.jdField_b_of_type_Boolean = true;
        }
        bool1 = localLockedCategory.jdField_a_of_type_Boolean;
        i = 3;
      }
      else
      {
        bool1 = false;
        i = 3;
      }
    }
  }
  
  public boolean a(String paramString, Context paramContext)
  {
    boolean bool = false;
    if (a(paramString))
    {
      Object localObject2 = a(paramString).jdField_b_of_type_JavaLangString;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("FilterComboShare", 1, "empty jump url");
        localObject1 = "https://ti.qq.com/unlocked/index.html?_wv=536870912&id=" + paramString;
      }
      localObject2 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("k_f_id", paramString);
      paramContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "handleLockItemClick id " + paramString);
      }
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "handleSendStory");
    }
    this.jdField_a_of_type_Boolean = true;
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Bhhg);
    Object localObject = (ajfi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajfo, true);
    if (this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory != null)
    {
      localObject = BaseApplicationImpl.getContext();
      bhhe localbhhe = new bhhe(this, (Context)localObject);
      ThreadManager.getUIHandler().postDelayed(new ComboLockManager.2(this, (Context)localObject, localbhhe), 1000L);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_Bjad.a(this.jdField_a_of_type_Int).a;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        Object localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if (((FilterCategory)localObject2).a != null)
        {
          localObject2 = ((FilterCategory)localObject2).a.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!paramString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)) {
              break;
            }
            this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = localQIMFilterCategoryItem;
          }
        }
      }
    }
    label101:
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "setLockingItem " + paramString + " result " + this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboLockManager
 * JD-Core Version:    0.7.0.1
 */