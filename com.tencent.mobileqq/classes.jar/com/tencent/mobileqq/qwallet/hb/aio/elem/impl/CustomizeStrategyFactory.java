package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class CustomizeStrategyFactory
  implements Handler.Callback, IQWalletConfigService.ConfigUpdateListener, ICustomizeStrategyFactory
{
  public static float a;
  private static volatile CustomizeStrategyFactory jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory;
  public static byte[] a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<CustomizeStrategyFactory.HBCustomizeStrategy> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
  private QQLruCache<String, InterfaceRedPkgElem> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new CustomizeStrategyFactory.1(this, 1020, 30, 10000);
  public IQWalletConfigService a;
  private HashMap<Object, ICustomizeStrategyFactory.OnCustomizeListener> jdField_a_of_type_JavaUtilHashMap;
  public boolean a;
  public boolean b;
  private byte[] b;
  private boolean c = false;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_Float = 1.0F;
  }
  
  public CustomizeStrategyFactory()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ArrayOfByte = new byte[0];
    c();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    jdField_a_of_type_Float = MobileQQ.getContext().getResources().getDisplayMetrics().density;
  }
  
  private CustomizeStrategyFactory.HBCustomizeStrategy a(int paramInt, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCustomizeStrategy type =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("CustomizeStrategyFactory", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (CustomizeStrategyFactory.HBCustomizeStrategy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (2 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.VIPHBStrategy(paramBaseQQAppInterface);
    } else if (1 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.ThemeCustomizeStrategy(paramBaseQQAppInterface);
    } else if (4 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.ThemeAnimStrategy(paramBaseQQAppInterface);
    } else if (5 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.SkinRedPacketStrategy(paramBaseQQAppInterface);
    } else if (6 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.VoiceResStrategy(paramBaseQQAppInterface);
    } else if (7 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.PanelStrategy(paramBaseQQAppInterface);
    } else {
      paramBaseQQAppInterface = null;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramBaseQQAppInterface);
    return paramBaseQQAppInterface;
  }
  
  public static CustomizeStrategyFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory = new CustomizeStrategyFactory();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory;
  }
  
  private void b(RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo != null) && (paramRedPacketInfo.jdField_b_of_type_Boolean) && (paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig != null))
    {
      if (TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig.jdField_a_of_type_JavaLangString)) {
        return;
      }
      paramRedPacketInfo = new CustomizeStrategyFactory.3(this, paramRedPacketInfo);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ThreadManager.post(paramRedPacketInfo, 5, null, true);
        return;
      }
      paramRedPacketInfo.run();
    }
  }
  
  private void c()
  {
    ThreadManager.post(new CustomizeStrategyFactory.2(this), 5, null, true);
  }
  
  public RedPacketInfo a(BaseQQAppInterface paramBaseQQAppInterface, RedPacketInfo paramRedPacketInfo, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    if ((paramRedPacketInfo != null) && (paramOnCustomizeListener != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRedPacketInfo.type);
      if (paramRedPacketInfo.type == 5)
      {
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.skinType);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.skinId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.bigAnimId);
      }
      else
      {
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.templateId);
        if ((paramRedPacketInfo.type == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_JavaLangString)))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramRedPacketInfo.jdField_a_of_type_JavaLangString);
        }
      }
      paramRedPacketInfo.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      paramBaseQQAppInterface = a(paramRedPacketInfo.type, paramBaseQQAppInterface);
      if (paramBaseQQAppInterface == null) {
        return paramRedPacketInfo;
      }
      localObject = (InterfaceRedPkgElem)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramRedPacketInfo.jdField_b_of_type_JavaLangString);
      if (localObject == null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramRedPacketInfo, paramOnCustomizeListener);
        paramBaseQQAppInterface.a(paramRedPacketInfo);
        return paramRedPacketInfo;
      }
      paramBaseQQAppInterface.a(paramRedPacketInfo, (InterfaceRedPkgElem)localObject);
      return paramRedPacketInfo;
    }
    return null;
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramRedPacketInfo != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyCustomizeFinish-type:");
        ((StringBuilder)localObject).append(paramRedPacketInfo.type);
        ((StringBuilder)localObject).append(" isAnimation:");
        ((StringBuilder)localObject).append(paramRedPacketInfo.jdField_b_of_type_Boolean);
        QLog.d("CustomizeStrategyFactory", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramRedPacketInfo.type == 2) && (paramRedPacketInfo.jdField_b_of_type_Boolean) && (!paramRedPacketInfo.c))
      {
        b(paramRedPacketInfo);
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramRedPacketInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setInAIO isInAIO=");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(",refreshListView=");
      ((StringBuilder)???).append(this.c);
      QLog.d("CustomizeStrategyFactory", 2, ((StringBuilder)???).toString());
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        jdField_a_of_type_ArrayOfByte.notifyAll();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLockFlag lockFlag");
          localStringBuilder.append(this.jdField_a_of_type_Boolean);
          QLog.d("CustomizeStrategyFactory", 2, localStringBuilder.toString());
        }
        if (this.c)
        {
          this.c = false;
          ??? = QWalletHelperImpl.getAppRuntime();
          if ((??? instanceof BaseQQAppInterface))
          {
            ??? = ((BaseQQAppInterface)???).getHandler(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getChatActivityClass());
            if (??? != null)
            {
              ((MqqHandler)???).sendEmptyMessage(12);
              return;
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    a();
    ??? = this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
    if (??? != null) {
      ((QQLruCache)???).evictAll();
    }
    ??? = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (??? != null)
    {
      int j = ((SparseArray)???).size();
      int i = 0;
      while (i < j)
      {
        ((CustomizeStrategyFactory.HBCustomizeStrategy)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService.unRegisterUpdateListener("redPack", this);
      }
      this.d = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler = null;
      jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemImplCustomizeStrategyFactory = null;
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRefreshListView refreshListView=");
      localStringBuilder.append(paramBoolean);
      QLog.d("CustomizeStrategyFactory", 2, localStringBuilder.toString());
    }
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      RedPacketInfo localRedPacketInfo = (RedPacketInfo)paramMessage.obj;
      ICustomizeStrategyFactory.OnCustomizeListener localOnCustomizeListener = (ICustomizeStrategyFactory.OnCustomizeListener)this.jdField_a_of_type_JavaUtilHashMap.remove(localRedPacketInfo);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage info type=");
        paramMessage.append(localRedPacketInfo.type);
        paramMessage.append("| listener=");
        paramMessage.append(localOnCustomizeListener);
        paramMessage.append("| templateId=");
        paramMessage.append(localRedPacketInfo.templateId);
        paramMessage.append("| content=");
        paramMessage.append(localRedPacketInfo.jdField_a_of_type_JavaLangString);
        paramMessage.append("| info=");
        paramMessage.append(localRedPacketInfo);
        paramMessage.append("|");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("CustomizeStrategyFactory", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(localRedPacketInfo.jdField_b_of_type_JavaLangString))
      {
        paramMessage = null;
        if (localRedPacketInfo.type == 2)
        {
          paramMessage = new VipRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
        else if ((localRedPacketInfo.type != 1) && (localRedPacketInfo.type != 4))
        {
          if (localRedPacketInfo.type == 5)
          {
            if (localRedPacketInfo.skinType == 1)
            {
              paramMessage = new SkinRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
              paramMessage.a(localRedPacketInfo);
              localRedPacketInfo.icon = paramMessage.a(localRedPacketInfo);
            }
            else if ((localRedPacketInfo.skinType != 2) && (localRedPacketInfo.skinType != 4))
            {
              if (localRedPacketInfo.skinType == 3)
              {
                paramMessage = new BigAnimRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
                paramMessage.a(localRedPacketInfo);
              }
            }
            else
            {
              paramMessage = new ResPathRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
              paramMessage.a(localRedPacketInfo);
            }
          }
          else if (localRedPacketInfo.type == 6)
          {
            paramMessage = new VoiceResElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
            paramMessage.a(localRedPacketInfo);
          }
          else if (localRedPacketInfo.type == 7)
          {
            paramMessage = new PanelRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
            paramMessage.a(localRedPacketInfo);
          }
        }
        else
        {
          paramMessage = new ThemeRedPkgElem(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
        if ((paramMessage != null) && (paramMessage.a())) {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localRedPacketInfo.jdField_b_of_type_JavaLangString, paramMessage);
        }
      }
      if (localOnCustomizeListener != null) {
        localOnCustomizeListener.a(localRedPacketInfo.type, localRedPacketInfo);
      }
    }
    return false;
  }
  
  public void onUpdate(String paramString1, String paramString2, ConfigInfo paramConfigInfo)
  {
    paramString1 = this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
    if (paramString1 == null) {
      return;
    }
    paramString1 = paramString1.snapshot().entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (InterfaceRedPkgElem)((Map.Entry)paramString1.next()).getValue();
      if (((paramString2 instanceof SkinRedPkgElem)) || ((paramString2 instanceof BigAnimRedPkgElem))) {
        paramString1.remove();
      }
    }
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).onUpdate(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */