package com.tencent.qqmini.sdk.runtime.core.page;

import bgho;
import bgil;
import bglq;
import bhbb;
import bhbi;
import bhbs;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BasePageWebview
{
  private static final boolean b;
  private bgho jdField_a_of_type_Bgho;
  private bhbb jdField_a_of_type_Bhbb;
  private bhbi jdField_a_of_type_Bhbi;
  private ShareState jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  protected EmbeddedWidgetClientFactory a;
  public ArrayList<bhbs> a;
  private boolean jdField_a_of_type_Boolean;
  public int c;
  
  static
  {
    boolean bool = true;
    if (bglq.a("qqminiapp", "enable_embedded_video", 1) == 1) {}
    for (;;)
    {
      jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public PageWebview(bgho parambgho, AppBrandPageContainer paramAppBrandPageContainer, bhbi parambhbi)
  {
    super(parambgho.a(), paramAppBrandPageContainer);
    this.jdField_a_of_type_Bgho = parambgho;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    this.jdField_a_of_type_Bhbi = parambhbi;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState = new ShareState();
    this.jdField_a_of_type_Bhbb = new bhbb();
    a();
  }
  
  public bhbb a()
  {
    return this.jdField_a_of_type_Bhbb;
  }
  
  public ShareState a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState;
  }
  
  public EmbeddedWidgetClientFactory a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory;
  }
  
  public void a()
  {
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
    try
    {
      if (getX5WebViewExtension() != null)
      {
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
        IX5WebViewExtension localIX5WebViewExtension = getX5WebViewExtension();
        EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory;
        boolean bool = localIX5WebViewExtension.registerEmbeddedWidget(new String[] { "video" }, localEmbeddedWidgetClientFactory);
        QMLog.d("miniapp-embedded", "registerEmbeddedWidget : " + bool + "; " + (System.currentTimeMillis() - l));
        if ((bool) && (jdField_b_of_type_Boolean)) {}
        this.jdField_a_of_type_Bhbb.a(true);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "registerEmbeddedWidget error,", localThrowable);
    }
  }
  
  public void a(bhbs parambhbs)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(parambhbs))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambhbs);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.onResume();
    QMLog.d("PageWebview", "pagewebview onResume, id is " + this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_Bhbi != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer != null) && (this.jdField_a_of_type_Bgho != null)) {
      if (this.jdField_a_of_type_Bgho.a() == null) {
        break label242;
      }
    }
    label242:
    for (Object localObject1 = this.jdField_a_of_type_Bgho.a().appId;; localObject1 = null)
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a() != null) {}
      for (Object localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a().a();; localObject2 = null)
      {
        localObject1 = "\"" + (String)localObject1 + ":" + (String)localObject2 + ":VISIBLE\"";
        this.jdField_a_of_type_Bhbi.a("document.title=" + (String)localObject1, null);
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap() != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap().entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (VideoEmbeddedWidgetClient)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if (localObject2 != null) {
              ((VideoEmbeddedWidgetClient)localObject2).webviewResume();
            }
          }
        }
        return;
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap() != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)((Map.Entry)localIterator.next()).getValue();
        if (localVideoEmbeddedWidgetClient != null) {
          localVideoEmbeddedWidgetClient.webviewDestory();
        }
        localIterator.remove();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QMLog.d("PageWebview", "pagewebview onPause, id is  " + this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Bhbi != null) {
      this.jdField_a_of_type_Bhbi.a("document.title=\"\"", null);
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap() != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentQqminiSdkRuntimePluginEmbeddedWidgetClientFactory.getVideoEmbeddedWidgetClientMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)((Map.Entry)localIterator.next()).getValue();
        if (localVideoEmbeddedWidgetClient != null) {
          localVideoEmbeddedWidgetClient.webviewPause();
        }
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bhbs)localIterator.next()).a(paramInt2);
      }
    }
    this.c = paramInt2;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2.put("windowWidth", (int)(paramInt1 / DisplayUtil.getDensity(getContext())));
      localJSONObject2.put("windowHeight", (int)(paramInt2 / DisplayUtil.getDensity(getContext())));
      localJSONObject1.put("size", localJSONObject2);
      this.jdField_a_of_type_Bgho.a(bgil.a("onViewDidResize", localJSONObject1.toString(), b()));
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bhbi.a("onViewDidResize", localJSONObject1.toString(), b());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("PageWebview", "onSizeChanged, JSONException!", localJSONException);
      }
      QMLog.d("PageWebview", "page not ready, do nothing.");
    }
  }
  
  public void setOnWebviewScrollListener(bhbs parambhbs)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhbs);
  }
  
  public void setPageJsLoadSucc(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */