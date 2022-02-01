package cooperation.vip.jsoninflate.model;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ViewModel
  implements Handler.Callback
{
  protected int a;
  protected Handler a;
  protected View a;
  private ArrayList<ViewModel> a;
  protected int b;
  protected String c;
  
  public ViewModel(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ViewModel(String paramString, View paramView)
  {
    this(paramView);
    this.c = paramString;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append(" set background drawable = null not match value = ");
    ((StringBuilder)localObject).append(paramString);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  private int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -2;
    }
    try
    {
      if ("fill".equals(paramString)) {
        return -1;
      }
      if ("fit".equals(paramString)) {
        return -2;
      }
      int i = a(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  protected int a()
  {
    return ViewUtils.a();
  }
  
  protected int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      try
      {
        if (paramString.endsWith("w"))
        {
          i = Integer.parseInt(paramString.substring(0, paramString.indexOf("w")));
          j = a();
        }
        else if (paramString.endsWith("h"))
        {
          i = Integer.parseInt(paramString.substring(0, paramString.indexOf("h")));
          j = b();
        }
        else
        {
          i = Integer.parseInt(paramString);
          j = a();
        }
      }
      catch (Exception localException)
      {
        int i;
        int j;
        localException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIntegerValue exception: value =  ");
        localStringBuilder.append(paramString);
        QLog.e("JsonInflateViewModel", 1, localStringBuilder.toString());
        return 0;
      }
      i = i * j / 10000;
      return i;
    }
  }
  
  protected Drawable a(String paramString)
  {
    if (paramString.startsWith("#")) {
      return new ColorDrawable(Color.parseColor(paramString));
    }
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected ViewGroup.LayoutParams a(int paramInt1, int paramInt2)
  {
    return new ViewGroup.LayoutParams(paramInt1, paramInt2);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    return paramLayoutParams;
  }
  
  public ViewGroup.LayoutParams a(JSONObject paramJSONObject, ViewModel paramViewModel)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      Object localObject1 = paramJSONObject.optString("width");
      Object localObject2 = paramJSONObject.optString("height");
      this.jdField_a_of_type_Int = b((String)localObject1);
      this.b = b((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("class = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewView.getClass().getSimpleName());
        ((StringBuilder)localObject1).append(" width = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" height = ");
        ((StringBuilder)localObject1).append(this.b);
        QLog.i("JsonInflateViewModel", 0, ((StringBuilder)localObject1).toString());
      }
      localObject1 = a(this.jdField_a_of_type_Int, this.b);
      localObject2 = paramJSONObject.keys();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        a(str, paramJSONObject.optString(str), (ViewGroup.LayoutParams)localObject1);
      }
      paramViewModel.a((ViewGroup.LayoutParams)localObject1, paramJSONObject);
      return localObject1;
    }
    return null;
  }
  
  public ViewModel a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(this.c);
    Object localObject1 = null;
    Object localObject2 = null;
    Iterator localIterator = null;
    if (!bool)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 == null) {
        return null;
      }
      if (((ArrayList)localObject2).size() == 0)
      {
        localObject1 = localIterator;
        if (this.c.equals(paramString)) {
          localObject1 = this;
        }
        return localObject1;
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (ViewModel)localIterator.next();
        } while (localObject2 == null);
        localObject2 = ((ViewModel)localObject2).a(paramString);
        localObject1 = localObject2;
      } while (localObject2 == null);
    }
    return localObject2;
  }
  
  public void a() {}
  
  public void a(ViewModel paramViewModel)
  {
    if (paramViewModel == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramViewModel);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ("background_color".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("rotate".equals(paramString1))
    {
      this.jdField_a_of_type_AndroidViewView.setPivotX(0.0F);
      this.jdField_a_of_type_AndroidViewView.setPivotY(0.0F);
      this.jdField_a_of_type_AndroidViewView.setRotation(Float.parseFloat(paramString2));
      return;
    }
    if ("id".equals(paramString1))
    {
      this.jdField_a_of_type_AndroidViewView.setId(Integer.parseInt(paramString2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(" illegal attr :");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" = ");
    localStringBuilder.append(paramString2);
    QLog.e("JsonInflateViewModel", 1, localStringBuilder.toString());
  }
  
  protected void a(String paramString1, String paramString2, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      if ("x".equals(paramString1))
      {
        ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = a(paramString2);
        return;
      }
      if ("y".equals(paramString1)) {
        ((ViewGroup.MarginLayoutParams)paramLayoutParams).topMargin = a(paramString2);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramJSONObject != null))
    {
      if (paramJSONObject.length() == 0) {
        return;
      }
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(str, paramJSONObject.optString(str));
      }
      b();
    }
  }
  
  protected int b()
  {
    return ViewUtils.b();
  }
  
  protected void b() {}
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.c();
      }
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.e();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.f();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.ViewModel
 * JD-Core Version:    0.7.0.1
 */