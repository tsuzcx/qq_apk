package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TenDocWebViewPool
{
  private static int jdField_a_of_type_Int;
  private static volatile TenDocWebViewPool jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool;
  public static HashMap<String, Integer> a;
  private static List<TouchWebView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool = null;
    jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  private TenDocWebViewPool()
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static TenDocWebViewPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool == null) {
          jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool = new TenDocWebViewPool();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTeamworkTenDocWebViewPool;
  }
  
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (paramString != null)
      {
        Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localInteger == null)
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
        }
        else
        {
          int i = localInteger.intValue();
          jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + 1));
        }
      }
      ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).sendDocsDataBack(paramString, paramTouchWebView);
      return;
    }
    finally {}
  }
  
  public TouchWebView a(Context paramContext)
  {
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    TouchWebView localTouchWebView = null;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tendocpreload getWebView =  ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilList.size());
      QLog.e("TenDocWebViewPool", 1, ((StringBuilder)localObject).toString());
      if (jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localTouchWebView = (TouchWebView)jdField_a_of_type_JavaUtilList.get(0);
        jdField_a_of_type_JavaUtilList.remove(0);
        localObject = (ViewGroup)localTouchWebView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localTouchWebView);
        }
        ((MutableContextWrapper)localTouchWebView.getContext()).setBaseContext(paramContext);
      }
      return localTouchWebView;
    }
    finally {}
  }
  
  public List<TouchWebView> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
    if (paramTouchWebView != null)
    {
      ??? = (ViewGroup)paramTouchWebView.getParent();
      if (??? != null) {
        ((ViewGroup)???).removeView(paramTouchWebView);
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if ((paramTouchWebView instanceof SwiftReuseTouchWebView))
        {
          Context localContext = paramTouchWebView.getContext();
          if ((localContext instanceof MutableContextWrapper)) {
            ((MutableContextWrapper)localContext).setBaseContext(BaseApplication.getContext());
          }
          if (jdField_a_of_type_JavaUtilList.size() < jdField_a_of_type_Int)
          {
            QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
            jdField_a_of_type_JavaUtilList.add(paramTouchWebView);
          }
          else
          {
            paramTouchWebView.destroy();
          }
        }
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("tendocpreload init");
    ((StringBuilder)???).append(a());
    QLog.i("TenDocWebViewPool", 1, ((StringBuilder)???).toString());
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (!a())
      {
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).webAcceleratorSmartSchedule();
        QLog.i("TenDocWebViewPool", 1, "init");
        SwiftReuseTouchWebView localSwiftReuseTouchWebView = SwiftReuseTouchWebView.a(BaseApplication.getContext());
        localSwiftReuseTouchWebView.setWebViewClient(new TenDocWebViewPool.WebViewClientImpl(this));
        localSwiftReuseTouchWebView.setWebChromeClient(new TenDocWebViewPool.WebChromeClientImpl(this));
        jdField_a_of_type_JavaUtilList.add(localSwiftReuseTouchWebView);
      }
      TenDocWebPreLoadHelper.a = paramString;
      return;
    }
  }
  
  public boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public boolean a(String paramString)
  {
    if ((a()) && (!TextUtils.isEmpty(paramString)))
    {
      TouchWebView localTouchWebView = (TouchWebView)a().get(0);
      localTouchWebView.setWebViewClient(new TenDocWebViewPool.WebViewClientImpl(this));
      localTouchWebView.setWebChromeClient(new TenDocWebViewPool.WebChromeClientImpl(this));
      localTouchWebView.loadUrlOriginal(paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocWebViewPool
 * JD-Core Version:    0.7.0.1
 */