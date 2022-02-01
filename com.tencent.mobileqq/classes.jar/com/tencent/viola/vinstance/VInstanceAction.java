package com.tencent.viola.vinstance;

import android.content.Context;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.diff.DomDiffUtils;
import com.tencent.viola.ui.dom.DomObjectVInstance;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class VInstanceAction
  implements Preconditor.PreconditionListener
{
  public static final int STATE_INITING = 1;
  public static final int STATE_INIT_FAIL = 2;
  public static final int STATE_INIT_SUCCESS = 3;
  public static final String TAG = "Wormhole";
  protected Map<String, String> bindFailMap = new ConcurrentHashMap();
  private Map<String, ConditionVariable> conditionVariableMap = new ConcurrentHashMap();
  protected Map<String, VInstanceAction.VInstanceEventListener> eventMap = new HashMap();
  protected Map<String, String> failMap = new ConcurrentHashMap();
  protected ConcurrentHashMap<String, WeakReference<DomObjectVInstance>> instanceMap = new ConcurrentHashMap();
  private Set<String> onScreenItems = new HashSet();
  private JSONObject param;
  protected Map<String, String> pendingMap = new ConcurrentHashMap();
  protected Preconditor preconditor;
  protected AtomicInteger state = new AtomicInteger();
  protected ViolaInstance violaInstance;
  
  public VInstanceAction(Preconditor paramPreconditor, ViolaInstance paramViolaInstance, JSONObject paramJSONObject)
  {
    this.violaInstance = paramViolaInstance;
    this.param = paramJSONObject;
    this.preconditor = paramPreconditor;
    paramPreconditor.setPreconditionListener(this);
  }
  
  private VInstance getVInstanceFromDomContext(String paramString)
  {
    Object localObject = this.violaInstance;
    if (localObject == null) {
      return null;
    }
    localObject = ViolaUtils.getDomActionContext(((ViolaInstance)localObject).getInstanceId());
    if (localObject == null) {
      return null;
    }
    paramString = ((DOMActionContext)localObject).getComponent(paramString);
    if ((paramString instanceof VInstance)) {
      return (VInstance)paramString;
    }
    return null;
  }
  
  private VInstance getVInstanceFromItemView(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    paramView = (ViewGroup)paramView;
    int i = 0;
    while (i < paramView.getChildCount())
    {
      View localView = paramView.getChildAt(i);
      if ((localView instanceof VInstanceView))
      {
        paramView = (VInstanceView)localView;
        break label54;
      }
      i += 1;
    }
    paramView = null;
    label54:
    if (paramView == null) {
      return null;
    }
    return paramView.getComponent();
  }
  
  private boolean isOnScreen(VInstance paramVInstance, String paramString)
  {
    paramVInstance = (String)((VFrameLayout)paramVInstance.getHostView()).getTag();
    if (paramVInstance == null) {
      return false;
    }
    boolean bool = this.onScreenItems.contains(paramVInstance);
    if (paramVInstance.equals(paramString)) {
      bool = true;
    }
    return bool;
  }
  
  private void removeId(String paramString)
  {
    this.eventMap.remove(paramString);
    this.failMap.remove(paramString);
    this.pendingMap.remove(paramString);
    this.bindFailMap.remove(paramString);
    this.conditionVariableMap.remove(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release id: ");
    localStringBuilder.append(paramString);
    ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
  }
  
  private void tryUpdateInstanceWhenBindFail(String paramString1, String paramString2)
  {
    addBindFailQueue(paramString1, paramString2);
    if (!this.pendingMap.containsKey(paramString1)) {
      createVInstance(paramString1, paramString2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryUpdateInstanceWhenBindFail. id: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", state: ");
    localStringBuilder.append(this.state.get());
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramString2);
    ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
  }
  
  private void unregister(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(this.violaInstance.getInstanceId());
    if (localDOMActionContext == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VComponent localVComponent = localDOMActionContext.getComponent((String)paramList.next());
      if (localVComponent != null) {
        localVComponent.unregisterFromContext(true);
      }
    }
  }
  
  protected boolean addBindFailQueue(String paramString1, String paramString2)
  {
    if ((!this.bindFailMap.containsKey(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.bindFailMap.put(paramString1, paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBindFailQueue, id: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("state: ");
      localStringBuilder.append(this.state.get());
      localStringBuilder.append(", data: ");
      localStringBuilder.append(paramString2);
      ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  protected boolean addFailQueue(String paramString1, String paramString2)
  {
    if ((!this.failMap.containsKey(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.failMap.put(paramString1, paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFailQueue, id: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("state: ");
      localStringBuilder.append(this.state.get());
      localStringBuilder.append(", data: ");
      localStringBuilder.append(paramString2);
      ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void addListener(String paramString, VInstanceAction.VInstanceEventListener paramVInstanceEventListener)
  {
    this.eventMap.put(paramString, paramVInstanceEventListener);
  }
  
  protected boolean addPendingUpdateQueue(String paramString1, String paramString2)
  {
    if ((!this.pendingMap.containsKey(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.pendingMap.put(paramString1, paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPendingUpdateQueue, id: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", state: ");
      localStringBuilder.append(this.state.get());
      localStringBuilder.append(", data: ");
      localStringBuilder.append(paramString2);
      ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void addVInstance(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addVInstance, ref: ");
    localStringBuilder.append(paramString1);
    ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = ViolaUtils.findDomObject(paramString2, paramString1);
      if ((paramString1 instanceof DomObjectVInstance))
      {
        paramString1 = (DomObjectVInstance)paramString1;
        paramString1.tryAddAppearEvents();
        paramString2 = paramString1.getId();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addVInstance, id: ");
        localStringBuilder.append(paramString2);
        ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
        this.instanceMap.put(paramString2, new WeakReference(paramString1));
        onAddVInstance(paramString2, paramString1);
      }
    }
  }
  
  public boolean bindData(String paramString1, String paramString2, View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindData, id: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", state: ");
    ((StringBuilder)localObject).append(this.state);
    ((StringBuilder)localObject).append(", data: ");
    ((StringBuilder)localObject).append(paramString2);
    ViolaLogUtils.d("Wormhole", ((StringBuilder)localObject).toString());
    DomObjectVInstance localDomObjectVInstance = getDomObjectVInstance(paramString1);
    if (localDomObjectVInstance == null)
    {
      paramView = new StringBuilder();
      paramView.append("bindData fail: ");
      paramView.append(paramString1);
      paramView.append("state: ");
      paramView.append(this.state.get());
      paramView.append(", data: ");
      paramView.append(paramString2);
      ViolaLogUtils.d("Wormhole", paramView.toString());
      tryUpdateInstanceWhenBindFail(paramString1, paramString2);
      return false;
    }
    localObject = getVInstanceFromItemView(paramView);
    if (localObject == null)
    {
      localObject = getVInstanceFromDomContext(localDomObjectVInstance.getRef());
      if (localObject == null)
      {
        tryUpdateInstanceWhenBindFail(paramString1, paramString2);
        return false;
      }
      ((VInstance)localObject).lazy(false);
      if (((VInstance)localObject).getHostView() == null) {
        ((VInstance)localObject).createView(paramView.getContext());
      }
      View localView = ((VInstance)localObject).getHostView();
      if ((localView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      paramString2 = (String)localObject;
      if ((paramView instanceof ViewGroup))
      {
        ((ViewGroup)paramView).addView(localView);
        paramString2 = (String)localObject;
      }
    }
    else
    {
      boolean bool = isOnScreen((VInstance)localObject, paramString1);
      DomDiffUtils.diffComponent((VComponent)localObject, localDomObjectVInstance, ViolaUtils.getDomActionContext(this.violaInstance.getInstanceId()), null, bool);
      paramString2 = (String)localObject;
    }
    paramString2.onBindData(localDomObjectVInstance);
    ((VFrameLayout)paramString2.getHostView()).setTag(paramString1);
    this.onScreenItems.add(paramString1);
    return true;
  }
  
  public boolean bindNativeVueView(String paramString1, String paramString2, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindDataWithoutView, id: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", state: ");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramString2);
    ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
    if ((paramView instanceof VInstanceView))
    {
      paramString1 = ((VInstanceView)paramView).getComponent();
      if (paramString1 != null)
      {
        paramString1.bindData();
        return true;
      }
    }
    else
    {
      paramView = getDomObjectVInstance(paramString1);
      if (paramView == null)
      {
        paramView = new StringBuilder();
        paramView.append("bindData fail: ");
        paramView.append(paramString1);
        paramView.append("state: ");
        paramView.append(this.state.get());
        paramView.append(", data: ");
        paramView.append(paramString2);
        ViolaLogUtils.e("Wormhole", paramView.toString());
        tryUpdateInstanceWhenBindFail(paramString1, paramString2);
        return false;
      }
      paramString1 = getVInstanceFromDomContext(paramView.getRef());
      if (paramString1 != null)
      {
        paramString1.bindData();
        return true;
      }
    }
    return false;
  }
  
  public View createNativeVueView(String paramString, Context paramContext)
  {
    Object localObject = getDomObjectVInstance(paramString);
    if (localObject == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("createNativeVueView fail. dom is null:  ");
      paramContext.append(paramString);
      paramContext.append("state: ");
      paramContext.append(this.state.get());
      ViolaLogUtils.e("Wormhole", paramContext.toString());
      return null;
    }
    localObject = getVInstanceFromDomContext(((DomObjectVInstance)localObject).getRef());
    if (localObject == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("createNativeVueView fail. component is null:  ");
      paramContext.append(paramString);
      paramContext.append("state: ");
      paramContext.append(this.state.get());
      ViolaLogUtils.e("Wormhole", paramContext.toString());
      return null;
    }
    ((VInstance)localObject).lazy(false);
    if (((VInstance)localObject).getHostView() == null)
    {
      ((VInstance)localObject).createView(paramContext);
      ((VInstance)localObject).applyEvents();
      ((VInstance)localObject).applyLayout();
    }
    return ((VInstance)localObject).getHostView();
  }
  
  public abstract void createVInstance(String paramString1, String paramString2);
  
  public boolean createVInstanceSync(String paramString1, String paramString2)
  {
    ConditionVariable localConditionVariable = new ConditionVariable();
    createVInstance(paramString1, paramString2);
    this.conditionVariableMap.put(paramString1, localConditionVariable);
    boolean bool = localConditionVariable.block(1000L);
    this.conditionVariableMap.remove(paramString1);
    paramString2 = new StringBuilder();
    paramString2.append("id: ");
    paramString2.append(paramString1);
    paramString2.append(", su: ");
    paramString2.append(bool);
    ViolaLogUtils.e("Wormhole", paramString2.toString());
    return bool;
  }
  
  public void disappear(View paramView)
  {
    paramView = getVInstanceFromItemView(paramView);
    if (paramView == null) {
      return;
    }
    paramView.didDisAppear();
    paramView = (String)((VFrameLayout)paramView.getHostView()).getTag();
    this.onScreenItems.remove(paramView);
  }
  
  abstract void doInit(boolean paramBoolean);
  
  public Context getContext(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bool)
    {
      if (this.violaInstance == null) {
        return null;
      }
      paramString = (WeakReference)this.instanceMap.get(paramString);
      localObject1 = localObject2;
      if (paramString != null)
      {
        if (paramString.get() == null) {
          return null;
        }
        paramString = (DomObjectVInstance)paramString.get();
        paramString = ViolaUtils.findComponent(this.violaInstance.getInstanceId(), paramString.getRef());
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = paramString.getContext();
        }
      }
    }
    return localObject1;
  }
  
  public DomObjectVInstance getDomObjectVInstance(String paramString)
  {
    paramString = (WeakReference)this.instanceMap.get(paramString);
    if (paramString != null) {
      return (DomObjectVInstance)paramString.get();
    }
    return null;
  }
  
  public int getHeight(String paramString)
  {
    paramString = getDomObjectVInstance(paramString);
    if (paramString == null) {
      return 0;
    }
    return (int)paramString.getLayoutHeight();
  }
  
  public int getWidth(String paramString)
  {
    paramString = getDomObjectVInstance(paramString);
    if (paramString == null) {
      return 0;
    }
    return (int)paramString.getLayoutWidth();
  }
  
  public void init(boolean paramBoolean)
  {
    try
    {
      int i = this.state.get();
      if ((i != 1) && (i != 3))
      {
        this.state.set(1);
        ViolaSDKManager.getInstance().postOnThreadPool(new VInstanceAction.3(this, paramBoolean));
        return;
      }
      return;
    }
    finally {}
  }
  
  void notifyError()
  {
    Iterator localIterator = this.eventMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((VInstanceAction.VInstanceEventListener)localEntry.getValue()).onError((String)localEntry.getKey());
    }
  }
  
  void notifyRefreshItem(String paramString)
  {
    VInstanceAction.VInstanceEventListener localVInstanceEventListener = (VInstanceAction.VInstanceEventListener)this.eventMap.get(paramString);
    if (localVInstanceEventListener != null) {
      localVInstanceEventListener.onRefreshItem(paramString);
    }
  }
  
  public void onAddVInstance(String paramString, DomObjectVInstance paramDomObjectVInstance)
  {
    this.pendingMap.remove(paramString);
    paramDomObjectVInstance = (String)this.bindFailMap.remove(paramString);
    if (paramDomObjectVInstance != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAddVInstance] refreshItem, id: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", data: ");
      localStringBuilder.append(paramDomObjectVInstance);
      ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
      ViolaSDKManager.getInstance().postOnUiThread(new VInstanceAction.4(this, paramString));
    }
    paramString = (ConditionVariable)this.conditionVariableMap.remove(paramString);
    if (paramString != null) {
      paramString.open();
    }
  }
  
  public void onError()
  {
    this.state.compareAndSet(1, 2);
    notifyError();
    Preconditor localPreconditor = this.preconditor;
    if ((localPreconditor != null) && (localPreconditor.getAdapter() != null)) {
      this.preconditor.getAdapter().onInitError();
    }
    ViolaLogUtils.d("Wormhole", "initError");
  }
  
  public void onScroll(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    VInstance localVInstance = getVInstanceFromItemView(paramView);
    if (localVInstance == null) {
      return;
    }
    localVInstance.tryFireAppearEventSet(paramViewGroup, (int)paramView.getY(), paramInt1, paramInt2);
  }
  
  public void onSuccess()
  {
    ViolaBridgeManager.getInstance().post(new VInstanceAction.1(this));
    this.state.compareAndSet(1, 3);
    tryRunFailQueue();
    Preconditor localPreconditor = this.preconditor;
    if ((localPreconditor != null) && (localPreconditor.getAdapter() != null)) {
      this.preconditor.getAdapter().onInitSuccess();
    }
    ViolaLogUtils.d("Wormhole", "initSuccess");
  }
  
  public void release(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    if (this.state.get() == 3) {
      this.violaInstance.updateInstance(str);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      removeId(paramString1);
    }
    paramString1 = (WeakReference)this.instanceMap.remove(paramString1);
    if (paramString1 != null)
    {
      if (paramString1.get() == null) {
        return;
      }
      paramString1 = getVInstanceFromDomContext(((DomObjectVInstance)paramString1.get()).getRef());
      if (paramString1 != null) {
        paramString1.unregisterFromContext(true);
      }
    }
  }
  
  public void release(List<String> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.state.get() == 3) {
        this.violaInstance.updateInstance(paramString);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        removeId((String)paramList.next());
      }
    }
  }
  
  public void removeListener(String paramString)
  {
    this.eventMap.remove(paramString);
  }
  
  protected void retryInit()
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new VInstanceAction.5(this));
  }
  
  protected void tryRunFailQueue()
  {
    Iterator localIterator = this.failMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.violaInstance.updateInstance((String)localEntry.getValue());
      addPendingUpdateQueue((String)localEntry.getKey(), (String)localEntry.getValue());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doInit] failQueue, id: ");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(", value: ");
      localStringBuilder.append((String)localEntry.getValue());
      ViolaLogUtils.d("Wormhole", localStringBuilder.toString());
    }
    this.failMap.clear();
  }
  
  public abstract void updateInstance(String paramString1, String paramString2);
  
  public void willAppear(View paramView, ViewGroup paramViewGroup)
  {
    VInstance localVInstance = getVInstanceFromItemView(paramView);
    if (localVInstance == null) {
      return;
    }
    paramView.post(new VInstanceAction.2(this, localVInstance, paramView, paramViewGroup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceAction
 * JD-Core Version:    0.7.0.1
 */