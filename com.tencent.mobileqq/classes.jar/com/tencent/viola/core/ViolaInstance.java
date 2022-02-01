package com.tencent.viola.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import com.tencent.viola.bridge.NativeInvokeHelper;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodCreateBody;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContextImpl;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.dom.DomObjectFooterCell;
import com.tencent.viola.ui.dom.DomObjectKdRefresh;
import com.tencent.viola.ui.dom.DomObjectList;
import com.tencent.viola.ui.dom.DomObjectModal;
import com.tencent.viola.ui.dom.DomObjectPage;
import com.tencent.viola.ui.dom.DomObjectSlider;
import com.tencent.viola.ui.dom.DomObjectSmartHeader;
import com.tencent.viola.ui.dom.DomObjectText;
import com.tencent.viola.ui.dom.DomObjectVInstance;
import com.tencent.viola.ui.dom.DomObjectWaterfallList;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import com.tencent.viola.vinstance.VInstanceManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.security.auth.Destroyable;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaInstance
  implements IActivityState
{
  public static final int SCROLL_POSITION_STATE_BOTTOM = 2;
  public static final int SCROLL_POSITION_STATE_NROMAL = 0;
  public static final int SCROLL_POSITION_STATE_TOP = 1;
  public static final String TAG = "ViolaInstance";
  public static long jsCreateInstanceEnd;
  public static long jsCreateInstanceStart;
  public static long pageEnd;
  public static long pageStart;
  private boolean compatMode;
  private String currentVInstanceId;
  private boolean enableLayerType = true;
  private boolean isDestroy;
  private boolean isGlobalMode;
  private boolean isResume;
  private WeakReference<Activity> mActivityReference;
  public long mApplyLayoutAndEventEnd = 0L;
  public long mApplyLayoutAndEventStart = 0L;
  public long mBindDataEnd = 0L;
  public long mBindDataStart = 0L;
  private WeakReference<Context> mContextReference;
  private String mCreateBodyCache;
  public long mCreateComponentTreeEnd = 0L;
  public long mCreateComponentTreeStart = 0L;
  public long mCreateDomEnd = 0L;
  public long mCreateDomStart = 0L;
  public long mCreateViewEnd = 0L;
  public long mCreateViewStart = 0L;
  private WeakReference<Fragment> mFragmentReference;
  private int mHeight;
  private String mInitData;
  private String mInstanceId;
  private int mInstanceViewPortWidth = 750;
  private boolean mIsReceiveOrder = true;
  private volatile boolean mIsReportEnded = false;
  public int mJsErrorCountOpen = 0;
  public int mJsErrorCountRunning = 0;
  private View.OnLayoutChangeListener mLayoutChangeListener = new ViolaInstance.2(this);
  public long mLayoutEnd = 0L;
  public long mLayoutStart = 0L;
  private ConcurrentHashMap<String, Integer> mLifeCycleMap = new ConcurrentHashMap();
  private String mMasterListRef;
  private String mMasterVideoRef;
  private int mMatchWindowsX;
  private int mMatchWindowsY;
  private int mMaxDeepLayer;
  private int mMaxVDomDeepLayer;
  private boolean mMeasuredExactly = true;
  public boolean mNVMeasuredExactly = true;
  private NativeInvokeHelper mNativeInvokeHelper;
  public long mPageStartTime = 0L;
  private boolean mPageVisiable = true;
  private ViolaRenderContainer mRenderContainer;
  public long mRenderJsStartTime = 0L;
  private boolean mRendered;
  private HashMap<String, String> mReportDataMap = new HashMap();
  private VComponentContainer mRootComp;
  private String mUrl;
  private ViolaInstance.ViolaPageListener mViolaPageListener;
  private int mWidth;
  private VComponentContainer preCreateBodyRootComp;
  private View preCreateBodyView;
  private volatile boolean supportNativeVue;
  private int transformCount;
  
  public ViolaInstance(Application paramApplication, String paramString)
  {
    this(paramApplication, null, null, null, 0L, paramString);
    this.isGlobalMode = true;
  }
  
  public ViolaInstance(Application paramApplication, WeakReference paramWeakReference1, WeakReference paramWeakReference2, Object paramObject, long paramLong, String paramString)
  {
    pageStart = System.currentTimeMillis();
    this.mUrl = paramString;
    ViolaSDKManager.getInstance().setCurrentViolaInstance(this);
    this.mContextReference = paramWeakReference1;
    this.mFragmentReference = paramWeakReference2;
    this.mInstanceId = ViolaSDKManager.getInstance().generateInstanceId();
    paramWeakReference1 = new StringBuilder();
    paramWeakReference1.append("violaInstance create,instanceId=");
    paramWeakReference1.append(this.mInstanceId);
    ViolaLogUtils.d("ViolaInstance", paramWeakReference1.toString());
    init();
    ViolaEnvironment.sApplication = paramApplication;
    detectCompatMode(paramString);
  }
  
  private void addRealBody(VComponentContainer paramVComponentContainer)
  {
    if ((paramVComponentContainer != null) && (paramVComponentContainer.getHostView() != null))
    {
      if (this.mRenderContainer == null) {
        return;
      }
      if (paramVComponentContainer.getHostView().getParent() != null) {
        ((ViewGroup)paramVComponentContainer.getHostView().getParent()).removeView(paramVComponentContainer.getHostView());
      }
      this.mRenderContainer.addView(paramVComponentContainer.getHostView(), 0);
    }
  }
  
  private void dealReportWhenDestroy()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(ViolaEnvironment.JS_ERROR_AFTER_RENDER, Integer.toString(this.mJsErrorCountRunning));
    localHashMap.putAll(getReportCommonData());
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportRunningData(localHashMap, this.mUrl);
    }
    ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaJsError", localHashMap);
    if ((!this.mIsReportEnded) && (!this.mReportDataMap.isEmpty()))
    {
      this.mIsReportEnded = true;
      this.mReportDataMap.putAll(getReportCommonData());
      ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaData", this.mReportDataMap);
    }
  }
  
  private void destroyView(View paramView)
  {
    try
    {
      if ((paramView instanceof ViewGroup))
      {
        localObject = (ViewGroup)paramView;
        int i = 0;
        while (i < ((ViewGroup)localObject).getChildCount())
        {
          destroyView(((ViewGroup)localObject).getChildAt(i));
          i += 1;
        }
        ((ViewGroup)localObject).removeViews(0, ((ViewGroup)paramView).getChildCount());
      }
      if ((paramView instanceof Destroyable))
      {
        ((Destroyable)paramView).destroy();
        return;
      }
    }
    catch (Exception paramView)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroyView Exception e:");
      ((StringBuilder)localObject).append(paramView.getMessage());
      ViolaLogUtils.e("ViolaInstance", ((StringBuilder)localObject).toString());
    }
  }
  
  private void detectCompatMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = Uri.parse(paramString);
    if (paramString == null) {
      return;
    }
    paramString = paramString.getQueryParameter("v_fwMode");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("1"))) {
      this.compatMode = true;
    }
  }
  
  private void ensureRenderArchor()
  {
    if ((this.mRenderContainer == null) && (getContext() != null))
    {
      this.mRenderContainer = new ViolaRenderContainer(getContext());
      this.mRenderContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      this.mRenderContainer.setBackgroundColor(0);
      this.mRenderContainer.setViolaInstance(this);
      this.mRenderContainer.addOnLayoutChangeListener(this.mLayoutChangeListener);
    }
  }
  
  private HashMap<String, String> getReportCommonData()
  {
    HashMap localHashMap = new HashMap();
    if ((ViolaSDKManager.getInstance().getReportDelegate() != null) && (ViolaSDKManager.getInstance().getReportDelegate().getBaseReportData(this.mUrl) != null)) {
      localHashMap.putAll(ViolaSDKManager.getInstance().getReportDelegate().getBaseReportData(this.mUrl));
    }
    localHashMap.put(ViolaEnvironment.COMMON_OPERATION_VERSION, Build.VERSION.RELEASE);
    localHashMap.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
    localHashMap.put(ViolaEnvironment.COMMON_BIZ, this.mUrl);
    localHashMap.put(ViolaEnvironment.COMMON_PLATFORM, "0");
    if (!TextUtils.isEmpty(this.mUrl)) {
      localHashMap.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(this.mUrl));
    }
    return localHashMap;
  }
  
  private boolean init()
  {
    this.mNativeInvokeHelper = new NativeInvokeHelper();
    ViolaDomObjectManager.registerDomObj("div", DomObject.class);
    ViolaDomObjectManager.registerDomObj("text", DomObjectText.class);
    ViolaDomObjectManager.registerDomObj("cell", DomObjectCell.class);
    ViolaDomObjectManager.registerDomObj("page", DomObjectPage.class);
    ViolaDomObjectManager.registerDomObj("list", DomObjectList.class);
    ViolaDomObjectManager.registerDomObj("modal", DomObjectModal.class);
    ViolaDomObjectManager.registerDomObj("waterfall-list", DomObjectWaterfallList.class);
    ViolaDomObjectManager.registerDomObj("footer-cell", DomObjectFooterCell.class);
    ViolaDomObjectManager.registerDomObj("slider", DomObjectSlider.class);
    ViolaDomObjectManager.registerDomObj("kdrefresh", DomObjectKdRefresh.class);
    ViolaDomObjectManager.registerDomObj("smart-header", DomObjectSmartHeader.class);
    ViolaDomObjectManager.registerDomObj("instance", DomObjectVInstance.class);
    return true;
  }
  
  private void onRootCompCreateInNativeVueMode(VComponentContainer paramVComponentContainer, boolean paramBoolean)
  {
    if (paramVComponentContainer != null)
    {
      if (paramVComponentContainer.getHostView() == null) {
        return;
      }
      if (paramBoolean)
      {
        onRootCompCreateInNormalMode(paramVComponentContainer);
        this.preCreateBodyView = paramVComponentContainer.getHostView();
        this.preCreateBodyRootComp = paramVComponentContainer;
        return;
      }
      addRealBody(paramVComponentContainer);
    }
  }
  
  private void onRootCompCreateInNormalMode(VComponentContainer paramVComponentContainer)
  {
    if ((paramVComponentContainer != null) && (paramVComponentContainer.getHostView() != null))
    {
      ViolaRenderContainer localViolaRenderContainer = this.mRenderContainer;
      if (localViolaRenderContainer == null) {
        return;
      }
      localViolaRenderContainer.removeAllViews();
      if (paramVComponentContainer.getHostView().getParent() == null) {
        this.mRenderContainer.addView(paramVComponentContainer.getHostView());
      } else {
        this.mRenderContainer.addView((View)paramVComponentContainer.getRealView().getParent());
      }
      if (!this.mRendered)
      {
        ViolaLogUtils.e("ViolaInstance", "violaInstance pageEndMonitor end!");
        pageEndMonitor();
      }
      this.mRendered = true;
      if (this.isResume) {
        this.mRootComp.onActivityResume();
      }
    }
  }
  
  private void removeNativeVueView(View paramView)
  {
    if (this.mRenderContainer != null)
    {
      if (paramView == null) {
        return;
      }
      VComponentContainer localVComponentContainer = this.preCreateBodyRootComp;
      if (localVComponentContainer != null)
      {
        localVComponentContainer.destroyComp();
        this.preCreateBodyRootComp = null;
      }
      this.mRenderContainer.removeView(paramView);
      this.preCreateBodyView = null;
    }
  }
  
  private void resetLocalVariable()
  {
    this.mLifeCycleMap.clear();
    this.mRendered = false;
    this.mIsReportEnded = false;
    this.mMasterListRef = null;
    this.mMasterVideoRef = null;
  }
  
  private String tryAddNativeVue(String paramString)
  {
    if (this.supportNativeVue) {
      try
      {
        Object localObject = new JSONObject(paramString);
        ((JSONObject)localObject).put("isNativeVue", 1);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryAddNativeVue error: ");
        localStringBuilder.append(localJSONException.getMessage());
        ViolaLogUtils.e("ViolaInstance", localStringBuilder.toString());
      }
    }
    return paramString;
  }
  
  private void updatePageDestroy()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("pageDestroy", 1);
      updateInstance(localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void addPageOpenJsErrorCount()
  {
    this.mJsErrorCountOpen += 1;
  }
  
  public void addRunningJsErrorCount()
  {
    this.mJsErrorCountRunning += 1;
  }
  
  public void clearCurrentPageInstance()
  {
    ViolaSDKManager.getInstance().clearCurrentPageInstance(this);
  }
  
  public boolean consumeBackKeyEvent()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if ((!localVComponent.isDestroyed()) && (localVComponent.consumeBackKeyEvent())) {
          return true;
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((BaseModule)((Iterator)localObject).next()).onActivityBack()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void decreaseTransformCount()
  {
    this.transformCount -= 1;
    try
    {
      if (this.transformCount == 0) {
        updateInstance(new JSONObject().put("preCreateBodyAnimationFinish", 1).toString());
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void destroy()
  {
    try
    {
      if (this.mRootComp != null)
      {
        this.mRootComp.destroy();
        destroyView(this.mRenderContainer);
        this.mRootComp = null;
        this.mRenderContainer = null;
      }
      ViolaLogUtils.destroy();
      dealReportWhenDestroy();
      resetLocalVariable();
      ViolaSDKManager.getInstance().destroyInstance(this.mInstanceId);
      if (this.mContextReference != null)
      {
        this.mContextReference.clear();
        this.mContextReference = null;
      }
      if (this.mFragmentReference != null)
      {
        this.mFragmentReference.clear();
        this.mFragmentReference = null;
      }
      if (this.mActivityReference != null)
      {
        this.mActivityReference.clear();
        this.mActivityReference = null;
      }
      this.isDestroy = true;
      return;
    }
    finally {}
  }
  
  public void enableLayerType(boolean paramBoolean)
  {
    this.enableLayerType = paramBoolean;
  }
  
  public Activity getActivity()
  {
    WeakReference localWeakReference = this.mFragmentReference;
    if (localWeakReference != null) {
      return ((Fragment)localWeakReference.get()).getActivity();
    }
    return getBizActivity();
  }
  
  public Activity getBizActivity()
  {
    WeakReference localWeakReference = this.mActivityReference;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public Map<String, VComponent> getComponentMap()
  {
    RenderActionContextImpl localRenderActionContextImpl = ViolaSDKManager.getInstance().getRenderManager().getRenderContext(this.mInstanceId);
    if (localRenderActionContextImpl != null) {
      return localRenderActionContextImpl.getRegistryComponents();
    }
    return null;
  }
  
  public Context getContext()
  {
    if (this.isGlobalMode) {
      return VInstanceManager.getInstance().getCurrentContext(this.currentVInstanceId);
    }
    WeakReference localWeakReference = this.mContextReference;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public Fragment getFragment()
  {
    WeakReference localWeakReference = this.mFragmentReference;
    if (localWeakReference != null) {
      return (Fragment)localWeakReference.get();
    }
    return null;
  }
  
  public String getInstanceId()
  {
    return this.mInstanceId;
  }
  
  public int getInstanceViewPortWidth()
  {
    return this.mInstanceViewPortWidth;
  }
  
  public ConcurrentHashMap<String, Integer> getLifeCycleMap()
  {
    return this.mLifeCycleMap;
  }
  
  public PointF getLocationOnRenderContainer(float[] paramArrayOfFloat)
  {
    PointF localPointF = new PointF();
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length < 2) {
        return localPointF;
      }
      ViolaRenderContainer localViolaRenderContainer = this.mRenderContainer;
      if (localViolaRenderContainer != null)
      {
        int[] arrayOfInt = new int[2];
        localViolaRenderContainer.getLocationOnScreen(arrayOfInt);
        localPointF.x = (paramArrayOfFloat[0] - arrayOfInt[0]);
        localPointF.y = (paramArrayOfFloat[1] - arrayOfInt[1]);
      }
    }
    return localPointF;
  }
  
  public JSONObject getMainPerformance()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pageStart", pageStart);
      localJSONObject.put("pageFinish", pageEnd);
      localJSONObject.put("jsStart", jsCreateInstanceStart);
      localJSONObject.put("jsFinish", jsCreateInstanceEnd);
      localJSONObject.put("pageCostTime", pageEnd - pageStart);
      localJSONObject.put("jsCostTime", jsCreateInstanceEnd - jsCreateInstanceStart);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMainPerformance JSONException e:");
      localStringBuilder.append(localJSONException.getMessage());
      ViolaLogUtils.e("ViolaInstance", localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  public String getMasterListRef()
  {
    return this.mMasterListRef;
  }
  
  public String getMasterVideoRef()
  {
    return this.mMasterVideoRef;
  }
  
  public int getMatchWindowsX()
  {
    int j = this.mMatchWindowsX;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int getMatchWindowsY()
  {
    int j = this.mMatchWindowsY;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int getMaxDomDeep()
  {
    return this.mMaxVDomDeepLayer;
  }
  
  public <T> T getModule(String paramString)
  {
    return ViolaModuleManager.getModule(this.mInstanceId, paramString);
  }
  
  public NativeInvokeHelper getNativeInvokeHelper()
  {
    return this.mNativeInvokeHelper;
  }
  
  public int getPageOpenJsErrorCount()
  {
    return this.mJsErrorCountOpen;
  }
  
  public ViolaRenderContainer getRenderContainer()
  {
    return this.mRenderContainer;
  }
  
  public int getRenderContainerHeight()
  {
    ViolaRenderContainer localViolaRenderContainer = this.mRenderContainer;
    if (localViolaRenderContainer == null) {
      return 0;
    }
    return localViolaRenderContainer.getHeight();
  }
  
  public int getRenderContainerWidth()
  {
    ViolaRenderContainer localViolaRenderContainer = this.mRenderContainer;
    if (localViolaRenderContainer == null) {
      return 0;
    }
    return localViolaRenderContainer.getWidth();
  }
  
  public VComponentContainer getRootComp()
  {
    return this.mRootComp;
  }
  
  public View getRootView()
  {
    VComponentContainer localVComponentContainer = this.mRootComp;
    if (localVComponentContainer != null) {
      return localVComponentContainer.getRealView();
    }
    return null;
  }
  
  public int getRunningJsErrorCount()
  {
    return this.mJsErrorCountRunning;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public ViolaInstance.ViolaPageListener getViolaPageListener()
  {
    return this.mViolaPageListener;
  }
  
  public void hidePreCreateBody()
  {
    removeNativeVueView(this.preCreateBodyView);
  }
  
  public void increaseTransformCount()
  {
    this.transformCount += 1;
  }
  
  public boolean isCompatMode()
  {
    return this.compatMode;
  }
  
  public boolean isDestroy()
  {
    return this.isDestroy;
  }
  
  public boolean isGlobalMode()
  {
    return this.isGlobalMode;
  }
  
  public boolean isLayerTypeEnabled()
  {
    return this.enableLayerType;
  }
  
  public boolean isPageVisiable()
  {
    return this.mPageVisiable;
  }
  
  public boolean isReceiveOrder()
  {
    VComponentContainer localVComponentContainer = this.mRootComp;
    if (localVComponentContainer != null) {
      return (localVComponentContainer.isCreated()) || (this.mIsReceiveOrder);
    }
    return this.mIsReceiveOrder;
  }
  
  public boolean isRenderJsEnd()
  {
    return this.mRendered;
  }
  
  public boolean isRootMeasuredExactly()
  {
    return this.mMeasuredExactly;
  }
  
  public boolean isSupportNativeVue()
  {
    return this.supportNativeVue;
  }
  
  public boolean onActivityBack()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityBack();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityBack();
      }
    }
    return false;
  }
  
  public void onActivityCreate()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityCreate();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityCreate();
      }
    }
  }
  
  public void onActivityDestroy()
  {
    updatePageDestroy();
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed())
        {
          localVComponent.onActivityDestroy();
          DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(this.mInstanceId);
          if (localDOMActionContext != null)
          {
            localDOMActionContext.unregisterComponent(localVComponent.getRef());
            localDOMActionContext.unregisterDOMObject(localVComponent.getRef());
          }
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInstance.3(this, (Map)localObject), 3000L);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInstance.4(this), 3000L);
    if (this.mViolaPageListener != null) {
      this.mViolaPageListener = null;
    }
  }
  
  public void onActivityPause()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityPause();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityPause();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = getComponentMap();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (VComponent)((Iterator)localObject1).next();
        if (!((VComponent)localObject2).isDestroyed()) {
          ((VComponent)localObject2).onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    localObject1 = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseModule)((Iterator)localObject1).next();
        if ((localObject2 instanceof IActivityState)) {
          ((BaseModule)localObject2).onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    localObject1 = ViolaModuleManager.sGlobalModuleMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseModule)((Iterator)localObject1).next();
      if ((localObject2 instanceof IActivityState)) {
        ((BaseModule)localObject2).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onActivityResume()
  {
    this.isResume = true;
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityResume();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityResume();
      }
    }
  }
  
  public void onActivityStart()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityStart();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityStart();
      }
    }
  }
  
  public void onActivityStop()
  {
    Object localObject = getComponentMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VComponent localVComponent = (VComponent)((Iterator)localObject).next();
        if (!localVComponent.isDestroyed()) {
          localVComponent.onActivityStop();
        }
      }
    }
    localObject = ViolaModuleManager.findModuleMapById(this.mInstanceId);
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityStop();
      }
    }
  }
  
  public void onLayoutChangeCallBack(View paramView) {}
  
  public void onRootCreated(VComponentContainer paramVComponentContainer, boolean paramBoolean)
  {
    ViolaLogUtils.e("ViolaInstance", "violaInstance onRootCreated start!");
    if (!this.isDestroy)
    {
      ViolaLogUtils.e("ViolaInstance", "violaInstance pageEndMonitor postOnUiThread start!");
      ViolaSDKManager.getInstance().postOnUiThread(new ViolaInstance.1(this, paramVComponentContainer, paramBoolean));
      return;
    }
    ViolaLogUtils.e("ViolaInstance", "onRootCreated is destroy");
  }
  
  public void pageEndMonitor()
  {
    pageEnd = System.currentTimeMillis();
    this.mIsReceiveOrder = true;
    Object localObject = ViolaSDKManager.getInstance().getReportDelegate();
    if (localObject != null)
    {
      ((IReportDelegate)localObject).addReportData(ViolaEnvironment.KEY_RENDER_JS, ViolaEnvironment.JS_END);
      if (this.mPageStartTime != 0L) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_PAGE, Long.toString(System.currentTimeMillis() - this.mPageStartTime));
      }
      if ((this.mLayoutStart != 0L) && (this.mLayoutEnd != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_LAYOUT, Long.toString(this.mLayoutEnd - this.mLayoutStart));
      }
      if (this.mRenderJsStartTime != 0L) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_RENDER_JS, Long.toString(System.currentTimeMillis() - this.mRenderJsStartTime));
      }
      if ((this.mCreateViewStart != 0L) && (this.mCreateViewEnd != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_CREATE_VIEW, Long.toString(this.mCreateViewEnd - this.mCreateViewStart));
      }
      if ((this.mApplyLayoutAndEventStart != 0L) && (this.mApplyLayoutAndEventEnd != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_APPLY_LAYPUTANDEVENT, Long.toString(this.mApplyLayoutAndEventEnd - this.mApplyLayoutAndEventStart));
      }
      if ((this.mBindDataStart != 0L) && (this.mBindDataEnd != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_BIND_DATA, Long.toString(this.mBindDataEnd - this.mBindDataStart));
      }
      if ((this.mCreateDomStart != 0L) && (this.mCreateDomEnd != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_DOM_TREE, Long.toString(this.mCreateDomEnd - this.mCreateDomStart));
      }
      if ((this.mCreateComponentTreeEnd != 0L) && (this.mCreateComponentTreeStart != 0L)) {
        ((IReportDelegate)localObject).addReportData(ViolaEnvironment.TIME_COMPONENT_TREE, Long.toString(this.mCreateComponentTreeEnd - this.mCreateComponentTreeStart));
      }
      ((IReportDelegate)localObject).addReportData(ViolaEnvironment.JS_ERROR_BEFORE_RENDER, Integer.toString(this.mJsErrorCountOpen));
      ((IReportDelegate)localObject).reportData(this.mUrl);
      ((IReportDelegate)localObject).reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_OPEN_END, this.mUrl);
    }
    this.mReportDataMap.put(ViolaEnvironment.KEY_RENDER_JS, ViolaEnvironment.JS_END);
    if (this.mPageStartTime != 0L) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_PAGE, Long.toString(System.currentTimeMillis() - this.mPageStartTime));
    }
    if ((this.mLayoutStart != 0L) && (this.mLayoutEnd != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_LAYOUT, Long.toString(this.mLayoutEnd - this.mLayoutStart));
    }
    if (this.mRenderJsStartTime != 0L) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_RENDER_JS, Long.toString(System.currentTimeMillis() - this.mRenderJsStartTime));
    }
    if ((this.mCreateViewStart != 0L) && (this.mCreateViewEnd != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_CREATE_VIEW, Long.toString(this.mCreateViewEnd - this.mCreateViewStart));
    }
    if ((this.mApplyLayoutAndEventStart != 0L) && (this.mApplyLayoutAndEventEnd != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_APPLY_LAYPUTANDEVENT, Long.toString(this.mApplyLayoutAndEventEnd - this.mApplyLayoutAndEventStart));
    }
    if ((this.mBindDataStart != 0L) && (this.mBindDataEnd != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_BIND_DATA, Long.toString(this.mBindDataEnd - this.mBindDataStart));
    }
    if ((this.mCreateDomStart != 0L) && (this.mCreateDomEnd != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_DOM_TREE, Long.toString(this.mCreateDomEnd - this.mCreateDomStart));
    }
    if ((this.mCreateComponentTreeEnd != 0L) && (this.mCreateComponentTreeStart != 0L)) {
      this.mReportDataMap.put(ViolaEnvironment.TIME_COMPONENT_TREE, Long.toString(this.mCreateComponentTreeEnd - this.mCreateComponentTreeStart));
    }
    this.mReportDataMap.put(ViolaEnvironment.JS_ERROR_BEFORE_RENDER, Integer.toString(this.mJsErrorCountOpen));
    if (localObject != null) {
      this.mReportDataMap.putAll(getReportCommonData());
    }
    this.mIsReportEnded = true;
    ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaData", this.mReportDataMap);
    localObject = this.mViolaPageListener;
    if (localObject != null) {
      ((ViolaInstance.ViolaPageListener)localObject).pageOpenSuccess();
    }
  }
  
  public void reRenderJSSource(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    dealReportWhenDestroy();
    resetLocalVariable();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("violaInstance reRenderJSSource start!,jsUrl=");
    localStringBuilder.append(this.mUrl);
    ViolaLogUtils.d("ViolaInstance", localStringBuilder.toString());
    renderJsStartMonitor();
    jsCreateInstanceStart = System.currentTimeMillis();
    this.mInitData = paramString2;
    this.mCreateBodyCache = paramString3;
    paramString2 = tryAddNativeVue(paramString2);
    ensureRenderArchor();
    ViolaSDKManager.getInstance().createInstanceJSSource(this, paramString1, paramString3, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("violaInstance reRenderJSSource end!,jsUrl=");
    paramString1.append(this.mUrl);
    ViolaLogUtils.d("ViolaInstance", paramString1.toString());
  }
  
  @Deprecated
  public void render(String paramString1, String paramString2)
  {
    if (!this.mRendered)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("violaInstance render start!,jsUrl=");
      localStringBuilder.append(this.mUrl);
      ViolaLogUtils.e("ViolaInstance", localStringBuilder.toString());
      renderJsStartMonitor();
      jsCreateInstanceStart = System.currentTimeMillis();
      ensureRenderArchor();
      paramString2 = tryAddNativeVue(paramString2);
      ViolaSDKManager.getInstance().createInstance(this, paramString1, null, paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("violaInstance render end!,jsUrl=");
      paramString1.append(this.mUrl);
      ViolaLogUtils.e("ViolaInstance", paramString1.toString());
    }
  }
  
  public void renderJSSource(String paramString1, String paramString2, String paramString3)
  {
    if (!this.mRendered)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("violaInstance renderJSSource start!,jsUrl=");
      localStringBuilder.append(this.mUrl);
      ViolaLogUtils.e("ViolaInstance", localStringBuilder.toString());
      renderJsStartMonitor();
      jsCreateInstanceStart = System.currentTimeMillis();
      this.mInitData = paramString2;
      this.mCreateBodyCache = paramString3;
      paramString2 = tryAddNativeVue(paramString2);
      ensureRenderArchor();
      ViolaSDKManager.getInstance().createInstanceJSSource(this, paramString1, paramString3, paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("violaInstance renderJSSource end!,jsUrl=");
      paramString1.append(this.mUrl);
      ViolaLogUtils.e("ViolaInstance", paramString1.toString());
    }
  }
  
  public void renderJsEndMonitor()
  {
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.addReportData(ViolaEnvironment.TIME_REVEIVE_ORDER, Long.toString(System.currentTimeMillis() - this.mRenderJsStartTime));
    }
    this.mReportDataMap.put(ViolaEnvironment.TIME_REVEIVE_ORDER, Long.toString(System.currentTimeMillis() - this.mRenderJsStartTime));
    this.mIsReceiveOrder = true;
  }
  
  public void renderJsStartMonitor()
  {
    this.mIsReceiveOrder = false;
    this.mRenderJsStartTime = System.currentTimeMillis();
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.addReportData(ViolaEnvironment.KEY_RENDER_JS, ViolaEnvironment.JS_START);
    }
    this.mReportDataMap.put(ViolaEnvironment.KEY_RENDER_JS, ViolaEnvironment.JS_START);
  }
  
  public void renderVueDomDirectly(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new MethodCreateBody(new JSONObject(paramString));
        ViolaSDKManager.getInstance().registerInstanceAndId(this);
        bool = true;
        ((MethodCreateBody)localObject).setCreateFromNativeVue(true);
        ViolaSDKManager.getInstance().getDomManager().postAction(this.mInstanceId, (DOMAction)localObject, true);
        if (!TextUtils.isEmpty(paramString))
        {
          this.supportNativeVue = bool;
          return;
        }
      }
      catch (Exception paramString)
      {
        this.supportNativeVue = false;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[renderVueDom] error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        ViolaLogUtils.e("ViolaInstance", ((StringBuilder)localObject).toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void setBizActivity(Activity paramActivity)
  {
    this.mActivityReference = new WeakReference(paramActivity);
  }
  
  public void setCurrentVInstanceId(String paramString)
  {
    this.currentVInstanceId = paramString;
  }
  
  public void setHttpReportData(long paramLong, int paramInt)
  {
    if (paramLong != 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(ViolaEnvironment.HTTP_TIME, Long.toString(paramLong));
      localHashMap.put(ViolaEnvironment.HTTP_DATA_LENGTH, Integer.toString(paramInt));
      localHashMap.putAll(getReportCommonData());
      IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
      if (localIReportDelegate != null) {
        localIReportDelegate.reportHttpData(localHashMap, this.mUrl);
      }
      ViolaReportManager.getInstance().postDataToBeacon("actKanDianViolaHttpData", localHashMap);
    }
  }
  
  public void setInstanceViewPortWidth(int paramInt)
  {
    this.mInstanceViewPortWidth = paramInt;
  }
  
  public void setMasterListRef(String paramString)
  {
    this.mMasterListRef = paramString;
  }
  
  public void setMasterVideoRef(String paramString)
  {
    this.mMasterVideoRef = paramString;
  }
  
  public void setMaxDomDeep(int paramInt)
  {
    this.mMaxVDomDeepLayer = paramInt;
  }
  
  public void setPageVisibility(boolean paramBoolean)
  {
    this.mPageVisiable = paramBoolean;
  }
  
  public void setRenderContainer(ViolaRenderContainer paramViolaRenderContainer)
  {
    if (paramViolaRenderContainer != null)
    {
      paramViolaRenderContainer.setViolaInstance(this);
      paramViolaRenderContainer.addOnLayoutChangeListener(this.mLayoutChangeListener);
    }
    this.mRenderContainer = paramViolaRenderContainer;
    if (this.mRenderContainer != null)
    {
      paramViolaRenderContainer = new RelativeLayout.LayoutParams(-1, -1);
      this.mRenderContainer.setLayoutParams(paramViolaRenderContainer);
      this.mRenderContainer.setBackgroundColor(0);
      paramViolaRenderContainer = new int[2];
      this.mRenderContainer.getLocationInWindow(paramViolaRenderContainer);
      this.mMatchWindowsX = paramViolaRenderContainer[0];
      this.mMatchWindowsY = paramViolaRenderContainer[1];
    }
  }
  
  public void setRootMeasuredExactly(boolean paramBoolean)
  {
    this.mMeasuredExactly = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    if ((this.mWidth == 0) && (this.mHeight == 0))
    {
      this.mWidth = getRenderContainerWidth();
      this.mHeight = getRenderContainerHeight();
    }
    if ((this.mWidth == paramInt1) && (this.mHeight == paramInt2) && (isRootMeasuredExactly())) {
      return;
    }
    Object localObject1 = new JSONObject();
    Object localObject2 = this.mRootComp;
    if (localObject2 == null) {
      return;
    }
    Object localObject3 = ((VComponentContainer)localObject2).getRealView();
    if (localObject3 != null)
    {
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject3).getLayoutParams();
      if (localLayoutParams != null)
      {
        if ((((View)localObject3).getWidth() == paramInt1) && (((View)localObject3).getHeight() == paramInt2)) {
          return;
        }
        setRootMeasuredExactly(true);
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        ((View)localObject3).setLayoutParams(localLayoutParams);
        float f1 = paramInt1;
        try
        {
          f1 = FlexConvertUtils.px2dip(f1);
          float f2 = FlexConvertUtils.px2dip(paramInt2);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(f1);
          ((StringBuilder)localObject3).append("dp");
          ((JSONObject)localObject1).put("width", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(f2);
          ((StringBuilder)localObject3).append("dp");
          ((JSONObject)localObject1).put("defaultHeight", ((StringBuilder)localObject3).toString());
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("style", localObject1);
          localObject1 = new MethodUpdateElement(((VComponent)localObject2).getRef(), (JSONObject)localObject3);
          if ((localObject1 instanceof DOMAction)) {
            ViolaSDKManager.getInstance().getDomManager().postAction(getInstanceId(), (DOMAction)localObject1, false);
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" for body ,call uddate body setSize width :");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(",height:");
          ((StringBuilder)localObject1).append(paramInt2);
          ViolaLogUtils.d("ViolaInstance", ((StringBuilder)localObject1).toString());
          return;
        }
        catch (JSONException localJSONException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setSize JSONException e:");
          ((StringBuilder)localObject2).append(localJSONException.getMessage());
          ViolaLogUtils.e("ViolaInstance", ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void setViolaPageListener(ViolaInstance.ViolaPageListener paramViolaPageListener)
  {
    this.mViolaPageListener = paramViolaPageListener;
  }
  
  public void updateCurrentPageInstance()
  {
    ViolaSDKManager.getInstance().setCurrentViolaInstance(this);
  }
  
  public void updateInstance(String paramString)
  {
    ViolaSDKManager.getInstance().updateInstance(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance
 * JD-Core Version:    0.7.0.1
 */