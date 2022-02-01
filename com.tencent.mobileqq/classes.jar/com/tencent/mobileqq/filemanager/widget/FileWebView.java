package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;

public class FileWebView
  extends DtX5WebView
{
  float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long = 0L;
  FileWebView.TitilebarEventInterface jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  final int jdField_b_of_type_Int = 80;
  float c = 0.0F;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11)
    {
      setZoomControlGone(this);
      return;
    }
    getSettings().setDisplayZoomControls(false);
  }
  
  private Class a(ParameterizedType paramParameterizedType, int paramInt)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments()[paramInt];
    if ((paramParameterizedType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramParameterizedType).getRawType();
    }
    if ((paramParameterizedType instanceof GenericArrayType)) {
      return (Class)((GenericArrayType)paramParameterizedType).getGenericComponentType();
    }
    if ((paramParameterizedType instanceof TypeVariable)) {
      return a(((TypeVariable)paramParameterizedType).getBounds()[0], 0);
    }
    return (Class)paramParameterizedType;
  }
  
  private Class a(Type paramType, int paramInt)
  {
    if ((paramType instanceof ParameterizedType)) {
      return a((ParameterizedType)paramType, paramInt);
    }
    if ((paramType instanceof TypeVariable)) {
      return a(((TypeVariable)paramType).getBounds()[0], 0);
    }
    return (Class)paramType;
  }
  
  public boolean a(WebView paramWebView, String paramString, FileWebView.JSInterface paramJSInterface)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    Object localObject1 = paramString.split("[?]");
    i = paramString.length();
    paramString = "";
    if ((i > 1) && (localObject1.length > 1))
    {
      paramWebView = localObject1[0];
      paramString = localObject1[1].replaceFirst("p=", "");
    }
    else
    {
      paramWebView = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView);
    ((StringBuilder)localObject1).append("/#");
    paramWebView = Arrays.asList(((StringBuilder)localObject1).toString().split("/"));
    if (paramWebView.size() < 5) {
      return false;
    }
    if (!((String)paramWebView.get(2)).equalsIgnoreCase("preview")) {
      return false;
    }
    String str = (String)paramWebView.get(3);
    try
    {
      localObject1 = FileManagerUtil.a(paramString);
    }
    catch (Exception paramWebView)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("paramString parse fail!,paramString:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("FileWebView", 1, ((StringBuilder)localObject1).toString());
      }
      paramWebView.printStackTrace();
      localObject1 = null;
    }
    Method[] arrayOfMethod = paramJSInterface.getClass().getMethods();
    int j = arrayOfMethod.length;
    paramWebView = null;
    i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = arrayOfMethod[i];
      localObject2 = paramWebView;
      if (((Method)localObject3).getName().equals(str))
      {
        paramWebView = ((Method)localObject3).getParameterTypes();
        localObject2 = paramWebView;
        if (paramWebView.length == ((LinkedHashMap)localObject1).size())
        {
          localObject2 = localObject3;
          break label300;
        }
      }
      i += 1;
      paramWebView = (WebView)localObject2;
    }
    Object localObject2 = null;
    label300:
    if (localObject2 == null)
    {
      paramJSInterface.webLog(paramString);
      return true;
    }
    try
    {
      if (((LinkedHashMap)localObject1).size() == 0)
      {
        ((Method)localObject2).invoke(paramJSInterface, new Object[0]);
        return true;
      }
      paramString = ((LinkedHashMap)localObject1).values().toArray();
      localObject1 = new Object[paramWebView.length];
      i = 0;
    }
    catch (IllegalAccessException paramWebView)
    {
      break label565;
    }
    catch (IllegalArgumentException paramWebView)
    {
      break label554;
    }
    catch (InvocationTargetException paramWebView)
    {
      break label543;
    }
    catch (Exception paramWebView)
    {
      for (;;) {}
    }
    if (i < paramWebView.length) {
      localObject3 = paramWebView[i];
    }
    try
    {
      localObject3 = a((Type)localObject3, i).toString().toLowerCase();
      if ((!((String)localObject3).contains("int")) && (!((String)localObject3).contains("integer")))
      {
        if (((String)localObject3).contains("long")) {
          localObject1[i] = Long.valueOf(Long.parseLong((String)paramString[i]));
        } else if (((String)localObject3).contains("string")) {
          localObject1[i] = ((String)paramString[i]);
        } else if (((String)localObject3).contains("boolean")) {
          localObject1[i] = Boolean.valueOf(Boolean.parseBoolean((String)paramString[i]));
        }
      }
      else {
        localObject1[i] = Integer.valueOf(Integer.parseInt((String)paramString[i]));
      }
    }
    catch (IllegalAccessException paramWebView)
    {
      break label565;
    }
    catch (IllegalArgumentException paramWebView)
    {
      break label554;
    }
    catch (InvocationTargetException paramWebView)
    {
      break label543;
    }
    catch (Exception paramWebView)
    {
      break label532;
      i += 1;
    }
    ((Method)localObject2).invoke(paramJSInterface, (Object[])localObject1);
    return true;
    label532:
    QLog.e("FileWebView", 1, "invoke method exception!!! Exception");
    return false;
    label543:
    QLog.e("FileWebView", 1, "invoke method exception!!! InvocationTargetException");
    return false;
    label554:
    QLog.e("FileWebView", 2, "invoke method exception!!! IllegalArgumentException");
    return false;
    label565:
    QLog.e("FileWebView", 2, "invoke method exception!!! IllegalAccessException");
    return false;
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("memoryleaktest webview timer ");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilTimer);
        localStringBuilder.append(" this ");
        localStringBuilder.append(this);
        localStringBuilder.append("is cancel");
        QLog.d("FileWebView", 4, localStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
        }
      }
      else
      {
        if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.e();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.c = paramMotionEvent.getY();
        if (this.jdField_b_of_type_Float > this.c)
        {
          getContentHeight();
          getHeight();
          i = getWebScrollY();
          getScale();
          if ((getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) >= 1.0D) && (i != 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
            return super.dispatchTouchEvent(paramMotionEvent);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.f();
          if (getScrollY() < 1.0F)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
            return super.dispatchTouchEvent(paramMotionEvent);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
      }
    }
    else
    {
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return;
    }
    paramInt1 = getContentHeight();
    paramInt3 = getView().getHeight();
    int i = getWebScrollY();
    float f = getScale();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("contentHeight[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("],height[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("],scroolY[");
      localStringBuilder.append(i);
      localStringBuilder.append("],scale[");
      localStringBuilder.append(f);
      localStringBuilder.append("]");
      QLog.d("FileWebView", 4, localStringBuilder.toString());
    }
    f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
    if ((f < paramInt3 * 2) && (!FileManagerUtil.a())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.g();
    }
    if (f < 2.5D) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
    }
    if ((paramInt2 == 0) && (paramInt4 != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(FileWebView.TitilebarEventInterface paramTitilebarEventInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface = paramTitilebarEventInterface;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
      }
      return;
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    catch (SecurityException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */