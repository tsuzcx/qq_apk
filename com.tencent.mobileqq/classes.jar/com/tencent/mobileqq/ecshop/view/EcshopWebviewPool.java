package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class EcshopWebviewPool
{
  private static volatile EcshopWebviewPool jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebviewPool;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HashMap<String, EcshopWebview> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static EcshopWebviewPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebviewPool == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebviewPool == null) {
          jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebviewPool = new EcshopWebviewPool();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebviewPool;
  }
  
  public EcshopWebview a(Context paramContext, String paramString)
  {
    label182:
    for (;;)
    {
      try
      {
        Object localObject;
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【getWebView】= ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.size());
            ((StringBuilder)localObject).append(" preLoadUrl: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.i("Ecshop_EcshopWebviewPool", 2, ((StringBuilder)localObject).toString());
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
          {
            paramString = (EcshopWebview)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          }
          else
          {
            localObject = EcshopWebview.a(paramContext);
            if (StringUtil.a(paramString)) {
              break label182;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
            break label182;
          }
          if (paramString != null)
          {
            localObject = (ViewGroup)paramString.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeView(paramString);
            }
            ((MutableContextWrapper)paramString.getContext()).setBaseContext(paramContext);
          }
          else
          {
            paramString = EcshopWebview.a(paramContext);
          }
          return paramString;
        }
        paramString = (String)localObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("Ecshop_EcshopWebviewPool", 1, QLog.getStackTraceString(paramString));
        return EcshopWebview.a(paramContext);
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    QLog.i("Ecshop_EcshopWebviewPool", 2, "ecshop recycleWebView  ");
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    paramTouchWebView = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTouchWebView != null) {
      paramTouchWebView.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!StringUtil.a(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopWebviewPool
 * JD-Core Version:    0.7.0.1
 */