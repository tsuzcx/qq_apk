package com.tencent.qqmini.sdk.runtime.core.page;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import bekj;
import bekz;
import belx;
import betc;
import bfcc;
import bfcd;
import bfda;
import bfgl;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeViewContainer
  extends FrameLayout
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<MiniAppTextArea> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private bfda jdField_a_of_type_Bfda;
  private PageWebviewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private List<bfcd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArray<CoverView> b = new SparseArray();
  
  public NativeViewContainer(Context paramContext, PageWebviewContainer paramPageWebviewContainer)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = paramPageWebviewContainer;
    this.jdField_a_of_type_Bfda = new bfda(this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext().getApplicationContext()).inflate(2131559300, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370213)).setOnClickListener(new bfcc(this));
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void b(bekj parambekj)
  {
    bekz.a(new NativeViewContainer.3(this, parambekj));
  }
  
  private void c(bekj parambekj)
  {
    bekz.a(new NativeViewContainer.4(this, parambekj));
  }
  
  private void d(bekj parambekj)
  {
    bekz.a(new NativeViewContainer.5(this, parambekj));
  }
  
  private void e(bekj parambekj)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambekj.b);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      bekz.a(new NativeViewContainer.6(this, i, localJSONObject1, parambekj, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("NativeViewContainer", parambekj.a + " error.", localJSONException);
    }
  }
  
  private void f(bekj parambekj)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambekj.b);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      bekz.a(new NativeViewContainer.7(this, localJSONObject1, parambekj, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("NativeViewContainer", parambekj.a + " error.", localJSONException);
    }
  }
  
  private void g(bekj parambekj)
  {
    try
    {
      int i = new JSONObject(parambekj.b).optInt("inputId");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("inputId", i);
      bekz.a(new NativeViewContainer.8(this, i, parambekj, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("NativeViewContainer", parambekj.a + " error.", localJSONException);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.b();
    }
    return 0;
  }
  
  public PageWebview a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a();
    }
    return null;
  }
  
  public PageWebviewContainer a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  }
  
  public MiniAppTextArea a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localMiniAppTextArea != null) {
        return localMiniAppTextArea;
      }
    }
    return null;
  }
  
  public String a(bekj parambekj)
  {
    betc.a("NativeViewContainer", "event = " + parambekj.a + ", params = " + parambekj.b);
    if ("showKeyboard".equals(parambekj.a)) {
      a(parambekj);
    }
    for (;;)
    {
      return null;
      if ("hideKeyboard".equals(parambekj.a)) {
        b(parambekj);
      } else if ("updateInput".equals(parambekj.a)) {
        c(parambekj);
      } else if ("setKeyboardValue".equals(parambekj.a)) {
        d(parambekj);
      } else if ("insertTextArea".equals(parambekj.a)) {
        e(parambekj);
      } else if ("updateTextArea".equals(parambekj.a)) {
        f(parambekj);
      } else if ("removeTextArea".equals(parambekj.a)) {
        g(parambekj);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    localMiniAppTextArea.b();
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    int i = localMiniAppTextArea.a();
    if (i != 0) {
      if (this.b.get(i) != null) {
        ((CoverView)this.b.get(i)).removeView(localMiniAppTextArea);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
      return;
      if (localMiniAppTextArea.a()) {
        a().removeView(localMiniAppTextArea);
      } else {
        removeView(localMiniAppTextArea);
      }
    }
  }
  
  public void a(int paramInt, JSONObject paramJSONObject, bekj parambekj)
  {
    Object localObject2 = (MiniAppTextArea)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int i = paramJSONObject.optInt("parentId");
    boolean bool = paramJSONObject.optBoolean("fixed", false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new MiniAppTextArea(getContext(), this);
      ((MiniAppTextArea)localObject1).setFixed(bool);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
      if (i == 0) {
        break label119;
      }
      localObject2 = (FrameLayout)this.b.get(i);
      if (localObject2 != null)
      {
        ((FrameLayout)localObject2).addView((View)localObject1);
        ((MiniAppTextArea)localObject1).setParentId(i);
      }
    }
    for (;;)
    {
      ((MiniAppTextArea)localObject1).setAttributes(paramInt, paramJSONObject, parambekj);
      return;
      label119:
      if (bool) {
        a().addView((View)localObject1);
      } else {
        addView((View)localObject1);
      }
    }
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(paramView, paramLayoutParams);
    }
  }
  
  void a(bekj parambekj)
  {
    try
    {
      int i = new JSONObject(parambekj.b).optInt("inputId");
      if (i > 0)
      {
        bekz.a(new NativeViewContainer.1(this, i, parambekj));
        return;
      }
      if (System.currentTimeMillis() - 0L > 1000L)
      {
        System.currentTimeMillis();
        bekz.a(new NativeViewContainer.2(this, parambekj), 200L);
        return;
      }
    }
    catch (Exception localException)
    {
      betc.d("NativeViewContainer", parambekj.a + " error.", localException);
    }
  }
  
  public void a(belx parambelx)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(parambelx);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("inputId");
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localMiniAppTextArea == null) {
        return;
      }
      localMiniAppTextArea.a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      betc.d("NativeViewContainer", "updateTextArea error.", paramJSONObject);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a();
    }
    return false;
  }
  
  /* Error */
  public boolean a(bfcd parambfcd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 349 2 0
    //   19: ifne +18 -> 37
    //   22: aload_0
    //   23: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 352 2 0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_2
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	NativeViewContainer
    //   0	47	1	parambfcd	bfcd
    //   32	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	33	42	finally
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a();
    }
    return 0;
  }
  
  public void b(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = a(paramInt);
    if (localMiniAppTextArea != null) {
      localMiniAppTextArea.c();
    }
  }
  
  /* Error */
  public boolean b(bfcd parambfcd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 349 2 0
    //   19: ifeq +18 -> 37
    //   22: aload_0
    //   23: getfield 37	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 359 2 0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_2
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	NativeViewContainer
    //   0	47	1	parambfcd	bfcd
    //   32	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	33	42	finally
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, bfgl.a(getContext(), 50.0F));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setCurInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(belx parambelx)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setSoftKeyboardStateListener(parambelx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer
 * JD-Core Version:    0.7.0.1
 */