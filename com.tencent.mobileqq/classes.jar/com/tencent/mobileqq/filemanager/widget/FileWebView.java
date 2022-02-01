package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import atvo;
import atxf;
import atxg;
import com.tencent.qphone.base.util.QLog;
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
  extends WebView
{
  float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long = 0L;
  atxg jdField_a_of_type_Atxg;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
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
  
  public boolean a(WebView paramWebView, String paramString, atxf paramatxf)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    Object localObject1 = paramString.split("[?]");
    int i;
    Object localObject2;
    WebView localWebView;
    if ((paramString.length() > 1) && (localObject1.length > 1))
    {
      paramWebView = localObject1[0];
      paramString = localObject1[1].replaceFirst("p=", "");
      paramWebView = Arrays.asList((paramWebView + "/#").split("/"));
      if (paramWebView.size() < 5) {
        return false;
      }
      if (!((String)paramWebView.get(2)).equalsIgnoreCase("preview")) {
        return false;
      }
      String str = (String)paramWebView.get(3);
      localObject1 = null;
      try
      {
        paramWebView = atvo.a(paramString);
        localObject1 = paramWebView;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          Method[] arrayOfMethod;
          int j;
          if (QLog.isColorLevel()) {
            QLog.e("FileWebView", 1, "paramString parse fail!,paramString:" + paramString);
          }
          paramWebView.printStackTrace();
          continue;
          i += 1;
          paramWebView = localWebView;
        }
      }
      arrayOfMethod = paramatxf.getClass().getMethods();
      j = arrayOfMethod.length;
      i = 0;
      paramWebView = null;
      if (i < j)
      {
        localObject2 = arrayOfMethod[i];
        localWebView = paramWebView;
        if (((Method)localObject2).getName().equals(str))
        {
          paramWebView = ((Method)localObject2).getParameterTypes();
          localWebView = paramWebView;
          if (paramWebView.length == ((LinkedHashMap)localObject1).size())
          {
            localWebView = paramWebView;
            paramWebView = (WebView)localObject2;
            label214:
            if (paramWebView != null) {
              break label278;
            }
            paramatxf.webLog(paramString);
            return true;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label278:
        if (((LinkedHashMap)localObject1).size() == 0)
        {
          paramWebView.invoke(paramatxf, new Object[0]);
          return true;
        }
        paramString = ((LinkedHashMap)localObject1).values().toArray();
        localObject1 = new Object[localWebView.length];
        i = 0;
        if (i < localWebView.length)
        {
          localObject2 = a(localWebView[i], i).toString().toLowerCase();
          if ((((String)localObject2).contains("int")) || (((String)localObject2).contains("integer"))) {
            localObject1[i] = Integer.valueOf(Integer.parseInt((String)paramString[i]));
          } else if (((String)localObject2).contains("long")) {
            localObject1[i] = Long.valueOf(Long.parseLong((String)paramString[i]));
          }
        }
      }
      catch (IllegalAccessException paramWebView)
      {
        QLog.e("FileWebView", 2, "invoke method exception!!! IllegalAccessException");
        return false;
        if (((String)localObject2).contains("string")) {
          localObject1[i] = ((String)paramString[i]);
        }
      }
      catch (IllegalArgumentException paramWebView)
      {
        QLog.e("FileWebView", 2, "invoke method exception!!! IllegalArgumentException");
        return false;
        if (!((String)localObject2).contains("boolean")) {
          break label554;
        }
        localObject1[i] = Boolean.valueOf(Boolean.parseBoolean((String)paramString[i]));
      }
      catch (InvocationTargetException paramWebView)
      {
        QLog.e("FileWebView", 1, "invoke method exception!!! InvocationTargetException");
        return false;
        paramWebView.invoke(paramatxf, (Object[])localObject1);
        return true;
      }
      catch (Exception paramWebView)
      {
        QLog.e("FileWebView", 1, "invoke method exception!!! Exception");
        return false;
      }
      localWebView = paramWebView;
      paramWebView = null;
      break label214;
      paramWebView = "";
      paramString = "";
      break;
      label554:
      i += 1;
    }
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.jdField_a_of_type_JavaUtilTimer + " this " + this + "is cancel");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Atxg == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
      {
        this.jdField_a_of_type_Atxg.e();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.c = paramMotionEvent.getY();
      if (this.jdField_b_of_type_Float > this.c)
      {
        getContentHeight();
        getHeight();
        int i = getWebScrollY();
        getScale();
        if ((getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D) || (i == 0))
        {
          this.jdField_a_of_type_Atxg.b();
          this.jdField_a_of_type_Atxg.c();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_Atxg.a();
      }
      do
      {
        this.jdField_a_of_type_Atxg.c();
        break;
        this.jdField_a_of_type_Atxg.f();
      } while (getScrollY() >= 1.0F);
      this.jdField_a_of_type_Atxg.a(false);
      this.jdField_a_of_type_Atxg.c();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Atxg.d();
    }
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
    if (this.jdField_a_of_type_Atxg == null) {}
    do
    {
      return;
      paramInt1 = getContentHeight();
      paramInt3 = getView().getHeight();
      int i = getWebScrollY();
      float f = getScale();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileWebView", 4, "contentHeight[" + paramInt1 + "],height[" + paramInt3 + "],scroolY[" + i + "],scale[" + f + "]");
      }
      f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
      if ((f < paramInt3 * 2) && (!atvo.a())) {
        this.jdField_a_of_type_Atxg.g();
      }
      if (f < 2.5D) {
        this.jdField_a_of_type_Atxg.b();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.jdField_a_of_type_Atxg.a(false);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(atxg paramatxg)
  {
    this.jdField_a_of_type_Atxg = paramatxg;
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
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */