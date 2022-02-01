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
  private ArrayList<ViewModel> a;
  protected String g;
  protected View h;
  protected Handler i;
  protected int j;
  protected int k;
  
  public ViewModel() {}
  
  public ViewModel(View paramView)
  {
    this.h = paramView;
    this.i = new Handler(Looper.getMainLooper(), this);
    this.a = new ArrayList();
  }
  
  public ViewModel(String paramString, View paramView)
  {
    this(paramView);
    this.g = paramString;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = f(paramString);
    if (localObject != null)
    {
      this.h.setBackgroundDrawable((Drawable)localObject);
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
      int m = e(paramString);
      return m;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
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
    if ((this.h != null) && (paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      Object localObject1 = paramJSONObject.optString("width");
      Object localObject2 = paramJSONObject.optString("height");
      this.j = b((String)localObject1);
      this.k = b((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("class = ");
        ((StringBuilder)localObject1).append(this.h.getClass().getSimpleName());
        ((StringBuilder)localObject1).append(" width = ");
        ((StringBuilder)localObject1).append(this.j);
        ((StringBuilder)localObject1).append(" height = ");
        ((StringBuilder)localObject1).append(this.k);
        QLog.i("JsonInflateViewModel", 0, ((StringBuilder)localObject1).toString());
      }
      localObject1 = a(this.j, this.k);
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
  
  public void a() {}
  
  public void a(ViewModel paramViewModel)
  {
    if (paramViewModel == null) {
      return;
    }
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramViewModel);
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
      this.h.setPivotX(0.0F);
      this.h.setPivotY(0.0F);
      this.h.setRotation(Float.parseFloat(paramString2));
      return;
    }
    if ("id".equals(paramString1))
    {
      this.h.setId(Integer.parseInt(paramString2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g);
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
        ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = e(paramString2);
        return;
      }
      if ("y".equals(paramString1)) {
        ((ViewGroup.MarginLayoutParams)paramLayoutParams).topMargin = e(paramString2);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.h != null) && (paramJSONObject != null))
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
  
  public void ad_()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.ad_();
      }
    }
  }
  
  protected void b() {}
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.c();
      }
    }
  }
  
  public ViewModel d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(this.g);
    Object localObject1 = null;
    Object localObject2 = null;
    Iterator localIterator = null;
    if (!bool)
    {
      localObject2 = this.a;
      if (localObject2 == null) {
        return null;
      }
      if (((ArrayList)localObject2).size() == 0)
      {
        localObject1 = localIterator;
        if (this.g.equals(paramString)) {
          localObject1 = this;
        }
        return localObject1;
      }
      localIterator = this.a.iterator();
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
        localObject2 = ((ViewModel)localObject2).d(paramString);
        localObject1 = localObject2;
      } while (localObject2 == null);
    }
    return localObject2;
  }
  
  protected int e(String paramString)
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
          m = Integer.parseInt(paramString.substring(0, paramString.indexOf("w")));
          n = j();
        }
        else if (paramString.endsWith("h"))
        {
          m = Integer.parseInt(paramString.substring(0, paramString.indexOf("h")));
          n = k();
        }
        else
        {
          m = Integer.parseInt(paramString);
          n = j();
        }
      }
      catch (Exception localException)
      {
        int m;
        int n;
        localException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIntegerValue exception: value =  ");
        localStringBuilder.append(paramString);
        QLog.e("JsonInflateViewModel", 1, localStringBuilder.toString());
        return 0;
      }
      m = m * n / 10000;
      return m;
    }
  }
  
  protected Drawable f(String paramString)
  {
    if (paramString.startsWith("#")) {
      return new ColorDrawable(Color.parseColor(paramString));
    }
    return null;
  }
  
  public void g()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewModel localViewModel = (ViewModel)localIterator.next();
      if (localViewModel != null) {
        localViewModel.g();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected int j()
  {
    return ViewUtils.getScreenWidth();
  }
  
  protected int k()
  {
    return ViewUtils.getScreenHeight();
  }
  
  public View l()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.ViewModel
 * JD-Core Version:    0.7.0.1
 */