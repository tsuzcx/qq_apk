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
import bgid;
import bgkk;
import bgln;
import bhbp;
import bhbq;
import bhcq;
import bhes;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.sdk.runtime.widget.CanvasView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeViewContainer
  extends FrameLayout
{
  protected float a;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<MiniAppTextArea> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private bhcq jdField_a_of_type_Bhcq;
  private PageWebviewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private List<bhbq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArray<CoverView> b = new SparseArray();
  
  public NativeViewContainer(Context paramContext, PageWebviewContainer paramPageWebviewContainer)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = DisplayUtil.getDensity(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = paramPageWebviewContainer;
    this.jdField_a_of_type_Bhcq = new bhcq(this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext().getApplicationContext()).inflate(2131559348, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370481)).setOnClickListener(new bhbp(this));
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void b(bgid parambgid)
  {
    bgkk.a(new NativeViewContainer.3(this, parambgid));
  }
  
  private void c(bgid parambgid)
  {
    bgkk.a(new NativeViewContainer.4(this, parambgid));
  }
  
  private void d(bgid parambgid)
  {
    bgkk.a(new NativeViewContainer.5(this, parambgid));
  }
  
  private void e(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      bgkk.a(new NativeViewContainer.6(this, i, localJSONObject1, parambgid, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void f(int paramInt)
  {
    int i = 0;
    if (i < this.b.size())
    {
      int j = this.b.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.b.get(j);
      if ((localCoverView1 != null) && (localCoverView1.a() == paramInt))
      {
        if (localCoverView1.a() != 0) {
          break label70;
        }
        removeView(localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        CoverView localCoverView2 = (CoverView)this.b.get(localCoverView1.a());
        if (localCoverView2 != null) {
          localCoverView2.removeView(localCoverView1);
        }
      }
    }
  }
  
  private void f(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject1.optInt("inputId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("inputId", i);
      String str = localJSONObject1.optString("data");
      if (!TextUtils.isEmpty(str)) {
        localJSONObject2.put("data", str);
      }
      bgkk.a(new NativeViewContainer.7(this, localJSONObject1, parambgid, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void g(bgid parambgid)
  {
    try
    {
      int i = new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("inputId");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("inputId", i);
      bgkk.a(new NativeViewContainer.8(this, i, parambgid, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void h(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject1.optInt("canvasId");
      int j = localJSONObject1.optInt("parentId");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("position");
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("containerId", i);
      bgkk.a(new NativeViewContainer.10(this, localJSONObject1, i, j, localJSONObject2, localJSONObject1.optString("data"), parambgid, localJSONObject3));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void i(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject2.optInt("canvasId");
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("position");
      boolean bool = localJSONObject2.optBoolean("hide", false);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgkk.a(new NativeViewContainer.11(this, i, localJSONObject1, bool, parambgid, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void j(bgid parambgid)
  {
    try
    {
      bgkk.a(new NativeViewContainer.12(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("canvasId"), parambgid));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localJSONException);
    }
  }
  
  private void k(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      a(localJSONObject.optInt("canvasId"), localJSONObject.optBoolean("reserve", false), localJSONObject.optBoolean("useHardwareAccelerate"), localJSONObject.optJSONArray("actions"), parambgid.a, parambgid.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.b(parambgid.a, null, parambgid.jdField_b_of_type_Int);
      return;
    }
    catch (JSONException parambgid)
    {
      parambgid.printStackTrace();
    }
  }
  
  private void l(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.b.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
        return;
      }
      ((CanvasView)localCoverView).a(this, getContext(), localJSONObject, parambgid.a, parambgid.jdField_b_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
    }
  }
  
  private void m(bgid parambgid)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.b.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
        return;
      }
      ((CanvasView)localCoverView).a(parambgid.a, localJSONObject, parambgid.jdField_b_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
    }
  }
  
  private void n(bgid parambgid)
  {
    try
    {
      Object localObject = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
      int i = ((JSONObject)localObject).optInt("canvasId");
      CoverView localCoverView = (CoverView)this.b.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("method", parambgid.a);
        localJSONObject.put("data", localObject);
        localJSONObject.put("callbackId", parambgid.jdField_b_of_type_Int);
        localJSONArray.put(localJSONObject);
        localObject = new bhes(true, localJSONArray, false);
        ((CanvasView)localCoverView).a((bhes)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(parambgid.a, null, parambgid.jdField_b_of_type_Int);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.b();
    }
    return 0;
  }
  
  public CoverView a(int paramInt)
  {
    return (CoverView)this.b.get(paramInt);
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
  
  public String a(bgid parambgid)
  {
    QMLog.d("NativeViewContainer", "event = " + parambgid.a + ", params = " + parambgid.jdField_b_of_type_JavaLangString);
    if ("showKeyboard".equals(parambgid.a)) {
      a(parambgid);
    }
    for (;;)
    {
      return null;
      if ("hideKeyboard".equals(parambgid.a)) {
        b(parambgid);
      } else if ("updateInput".equals(parambgid.a)) {
        c(parambgid);
      } else if ("setKeyboardValue".equals(parambgid.a)) {
        d(parambgid);
      } else if ("insertTextArea".equals(parambgid.a)) {
        e(parambgid);
      } else if ("updateTextArea".equals(parambgid.a)) {
        f(parambgid);
      } else if ("removeTextArea".equals(parambgid.a)) {
        g(parambgid);
      } else if ("insertCanvas".equals(parambgid.a)) {
        h(parambgid);
      } else if ("updateCanvas".equals(parambgid.a)) {
        i(parambgid);
      } else if ("removeCanvas".equals(parambgid.a)) {
        j(parambgid);
      } else if ("drawCanvas".equals(parambgid.a)) {
        k(parambgid);
      } else if ("canvasToTempFilePath".equals(parambgid.a)) {
        l(parambgid);
      } else if ("canvasPutImageData".equals(parambgid.a)) {
        m(parambgid);
      } else if ("canvasGetImageData".equals(parambgid.a)) {
        n(parambgid);
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
  
  public void a(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    QMLog.d("NativeViewContainer", "addCoverView(). parentViewId = " + paramInt1 + ", coverViewId = " + paramInt2 + ", coverView = " + paramCoverView);
    new StringBuilder("addCoverView(). ").append("parentViewId = ").append(paramInt1).append("coverViewId = ").append(paramInt2).append("coverView = ").append(paramCoverView).append("fixed = ").append(paramBoolean);
    if (paramCoverView == null) {
      QMLog.w("NativeViewContainer", "Failed to add coverView, coverView is null");
    }
    CoverView localCoverView;
    do
    {
      return;
      this.b.put(paramInt2, paramCoverView);
      if (paramInt1 == 0)
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(paramCoverView);
          return;
        }
        addView(paramCoverView);
        return;
      }
      localCoverView = a(paramInt1);
    } while (localCoverView == null);
    localCoverView.addView(paramCoverView);
  }
  
  public void a(int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    int i = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("width") + 0.5F);
    int j = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("height") + 0.5F);
    int k = a().getMeasuredHeight();
    QMLog.i("NativeViewContainer", "insertCanvas currentWebview.getMeasuredHeight: " + k + "---canvas height----" + paramJSONObject.optInt("height") + "---" + j + "---canvasId---" + paramInt1);
    k = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("left") + 0.5F);
    int m = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("top") + 0.5F);
    CoverView localCoverView = (CoverView)this.b.get(paramInt1);
    paramJSONObject = localCoverView;
    if (localCoverView == null)
    {
      paramJSONObject = new CanvasView(getContext(), this, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(), paramString, paramInt1, paramBoolean2, paramBoolean, paramBoolean3);
      this.b.put(paramInt1, paramJSONObject);
      addView(paramJSONObject);
      paramJSONObject.setParentId(paramInt2);
    }
    if ((paramJSONObject instanceof CanvasView))
    {
      paramJSONObject.setContentDescription("CanvasView " + paramInt1);
      if (paramBoolean1) {
        paramJSONObject.setVisibility(8);
      }
      paramString = new FrameLayout.LayoutParams(i, j);
      paramString.leftMargin = k;
      paramString.topMargin = m;
      paramJSONObject.setLayoutParams(paramString);
    }
  }
  
  public void a(int paramInt, JSONObject paramJSONObject, bgid parambgid)
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
        break label118;
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
      ((MiniAppTextArea)localObject1).setAttributes(paramInt, paramJSONObject, parambgid);
      return;
      label118:
      if (bool) {
        a().addView((View)localObject1);
      } else {
        addView((View)localObject1);
      }
    }
  }
  
  public void a(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    CoverView localCoverView = (CoverView)this.b.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      QMLog.e("NativeViewContainer", "updateCanvas failed! appCanvas return null! canvasId: " + paramInt);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        localCoverView.setVisibility(8);
      }
      while (paramJSONObject != null)
      {
        paramInt = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("width") + 0.5F);
        int i = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("height") + 0.5F);
        int j = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("left") + 0.5F);
        int k = (int)(this.jdField_a_of_type_Float * paramJSONObject.optInt("top") + 0.5F);
        paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
        paramJSONObject.leftMargin = j;
        paramJSONObject.topMargin = k;
        localCoverView.setLayoutParams(paramJSONObject);
        return;
        localCoverView.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, String paramString, int paramInt2)
  {
    CoverView localCoverView = (CoverView)this.b.get(paramInt1);
    if (!(localCoverView instanceof CanvasView))
    {
      QMLog.e("NativeViewContainer", "updateCanvas failed! appCanvas return null! canvasId: " + paramInt1);
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.c(paramString, null, paramInt2);
      return;
    }
    paramJSONArray = new bhes(paramBoolean1, paramJSONArray, paramBoolean2);
    ((CanvasView)localCoverView).a(paramJSONArray);
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(paramView, paramLayoutParams);
    }
  }
  
  void a(bgid parambgid)
  {
    try
    {
      int i = new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("inputId");
      if (i > 0)
      {
        bgkk.a(new NativeViewContainer.1(this, i, parambgid));
        return;
      }
      if (System.currentTimeMillis() - 0L > 1000L)
      {
        System.currentTimeMillis();
        bgkk.a(new NativeViewContainer.2(this, parambgid), 200L);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("NativeViewContainer", parambgid.a + " error.", localException);
    }
  }
  
  public void a(bgln parambgln)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a(parambgln);
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
      QMLog.e("NativeViewContainer", "updateTextArea error.", paramJSONObject);
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
  public boolean a(bhbq parambhbq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 574 2 0
    //   19: ifne +18 -> 37
    //   22: aload_0
    //   23: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 577 2 0
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
    //   0	47	1	parambhbq	bhbq
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
  public boolean b(bhbq parambhbq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 574 2 0
    //   19: ifeq +18 -> 37
    //   22: aload_0
    //   23: getfield 38	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 584 2 0
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
    //   0	47	1	parambhbq	bhbq
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
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 50.0F));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void d(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.b.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      return;
    }
    f(paramInt);
    int i = localCoverView.a();
    if (i != 0) {
      if (this.b.get(i) != null) {
        ((CoverView)this.b.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.b.remove(paramInt);
      return;
      if (localCoverView.a()) {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.removeView(localCoverView);
      } else {
        removeView(localCoverView);
      }
    }
  }
  
  public void e(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.b.get(paramInt);
    if (localCoverView == null) {
      return;
    }
    f(paramInt);
    int i = localCoverView.a();
    if (i != 0) {
      if (this.b.get(i) != null) {
        ((CoverView)this.b.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.b.remove(paramInt);
      return;
      if (localCoverView.a()) {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.removeView(localCoverView);
      } else {
        removeView(localCoverView);
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setCurInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(bgln parambgln)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setSoftKeyboardStateListener(parambgln);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer
 * JD-Core Version:    0.7.0.1
 */