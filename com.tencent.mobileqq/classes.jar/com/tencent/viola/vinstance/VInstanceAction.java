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
    if (this.violaInstance == null) {
      return null;
    }
    DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(this.violaInstance.getInstanceId());
    if (localDOMActionContext == null) {
      return null;
    }
    paramString = localDOMActionContext.getComponent(paramString);
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
    View localView;
    if (i < paramView.getChildCount())
    {
      localView = paramView.getChildAt(i);
      if (!(localView instanceof VInstanceView)) {}
    }
    for (paramView = (VInstanceView)localView;; paramView = null)
    {
      if (paramView == null)
      {
        return null;
        i += 1;
        break;
      }
      return paramView.getComponent();
    }
  }
  
  private boolean isOnScreen(VInstance paramVInstance, String paramString)
  {
    paramVInstance = (String)((VFrameLayout)paramVInstance.getHostView()).getTag();
    if (paramVInstance == null) {
      return false;
    }
    boolean bool = this.onScreenItems.contains(paramVInstance);
    if (paramVInstance.equals(paramString)) {
      return true;
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
    ViolaLogUtils.d("Wormhole", "release id: " + paramString);
  }
  
  private void tryUpdateInstanceWhenBindFail(String paramString1, String paramString2)
  {
    addBindFailQueue(paramString1, paramString2);
    if (!this.pendingMap.containsKey(paramString1)) {
      createVInstance(paramString1, paramString2);
    }
    ViolaLogUtils.d("Wormhole", "tryUpdateInstanceWhenBindFail. id: " + paramString1 + ", state: " + this.state.get() + ", data: " + paramString2);
  }
  
  private void unregister(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(this.violaInstance.getInstanceId());
      if (localDOMActionContext != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          VComponent localVComponent = localDOMActionContext.getComponent((String)paramList.next());
          if (localVComponent != null) {
            localVComponent.unregisterFromContext(true);
          }
        }
      }
    }
  }
  
  protected boolean addBindFailQueue(String paramString1, String paramString2)
  {
    if ((!this.bindFailMap.containsKey(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.bindFailMap.put(paramString1, paramString2);
      ViolaLogUtils.d("Wormhole", "addBindFailQueue, id: " + paramString1 + "state: " + this.state.get() + ", data: " + paramString2);
      return true;
    }
    return false;
  }
  
  protected boolean addFailQueue(String paramString1, String paramString2)
  {
    if ((!this.failMap.containsKey(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.failMap.put(paramString1, paramString2);
      ViolaLogUtils.d("Wormhole", "addFailQueue, id: " + paramString1 + "state: " + this.state.get() + ", data: " + paramString2);
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
      ViolaLogUtils.d("Wormhole", "addPendingUpdateQueue, id: " + paramString1 + ", state: " + this.state.get() + ", data: " + paramString2);
      return true;
    }
    return false;
  }
  
  public void addVInstance(String paramString1, String paramString2)
  {
    ViolaLogUtils.d("Wormhole", "addVInstance, ref: " + paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = ViolaUtils.findDomObject(paramString2, paramString1);
    } while (!(paramString1 instanceof DomObjectVInstance));
    paramString1 = (DomObjectVInstance)paramString1;
    paramString1.tryAddAppearEvents();
    paramString2 = paramString1.getId();
    ViolaLogUtils.d("Wormhole", "addVInstance, id: " + paramString2);
    this.instanceMap.put(paramString2, new WeakReference(paramString1));
    onAddVInstance(paramString2, paramString1);
  }
  
  public boolean bindData(String paramString1, String paramString2, View paramView)
  {
    ViolaLogUtils.d("Wormhole", "bindData, id: " + paramString1 + ", state: " + this.state + ", data: " + paramString2);
    DomObjectVInstance localDomObjectVInstance = getDomObjectVInstance(paramString1);
    if (localDomObjectVInstance == null)
    {
      ViolaLogUtils.d("Wormhole", "bindData fail: " + paramString1 + "state: " + this.state.get() + ", data: " + paramString2);
      tryUpdateInstanceWhenBindFail(paramString1, paramString2);
      return false;
    }
    VInstance localVInstance = getVInstanceFromItemView(paramView);
    if (localVInstance == null)
    {
      localVInstance = getVInstanceFromDomContext(localDomObjectVInstance.getRef());
      if (localVInstance == null)
      {
        tryUpdateInstanceWhenBindFail(paramString1, paramString2);
        return false;
      }
      localVInstance.lazy(false);
      if (localVInstance.getHostView() == null) {
        localVInstance.createView(paramView.getContext());
      }
      paramString2 = localVInstance.getHostView();
      if ((paramString2.getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramString2.getParent()).removeView(paramString2);
      }
      if ((paramView instanceof ViewGroup)) {
        ((ViewGroup)paramView).addView(paramString2);
      }
    }
    for (paramString2 = localVInstance;; paramString2 = localVInstance)
    {
      paramString2.onBindData(localDomObjectVInstance);
      ((VFrameLayout)paramString2.getHostView()).setTag(paramString1);
      this.onScreenItems.add(paramString1);
      return true;
      boolean bool = isOnScreen(localVInstance, paramString1);
      DomDiffUtils.diffComponent(localVInstance, localDomObjectVInstance, ViolaUtils.getDomActionContext(this.violaInstance.getInstanceId()), null, bool);
    }
  }
  
  public boolean bindNativeVueView(String paramString1, String paramString2, View paramView)
  {
    ViolaLogUtils.d("Wormhole", "bindDataWithoutView, id: " + paramString1 + ", state: " + this.state + ", data: " + paramString2);
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
        ViolaLogUtils.e("Wormhole", "bindData fail: " + paramString1 + "state: " + this.state.get() + ", data: " + paramString2);
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
      ViolaLogUtils.e("Wormhole", "createNativeVueView fail. dom is null:  " + paramString + "state: " + this.state.get());
      return null;
    }
    localObject = getVInstanceFromDomContext(((DomObjectVInstance)localObject).getRef());
    if (localObject == null)
    {
      ViolaLogUtils.e("Wormhole", "createNativeVueView fail. component is null:  " + paramString + "state: " + this.state.get());
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
    ViolaLogUtils.e("Wormhole", "id: " + paramString1 + ", su: " + bool);
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
    if ((TextUtils.isEmpty(paramString)) || (this.violaInstance == null)) {}
    do
    {
      return null;
      paramString = (WeakReference)this.instanceMap.get(paramString);
    } while ((paramString == null) || (paramString.get() == null));
    paramString = (DomObjectVInstance)paramString.get();
    paramString = ViolaUtils.findComponent(this.violaInstance.getInstanceId(), paramString.getRef());
    if (paramString != null) {}
    for (paramString = paramString.getContext();; paramString = null) {
      return paramString;
    }
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
  
  /* Error */
  public void init(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/viola/vinstance/VInstanceAction:state	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpeq +8 -> 20
    //   15: iload_2
    //   16: iconst_3
    //   17: if_icmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 65	com/tencent/viola/vinstance/VInstanceAction:state	Ljava/util/concurrent/atomic/AtomicInteger;
    //   27: iconst_1
    //   28: invokevirtual 405	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   31: invokestatic 411	com/tencent/viola/core/ViolaSDKManager:getInstance	()Lcom/tencent/viola/core/ViolaSDKManager;
    //   34: new 413	com/tencent/viola/vinstance/VInstanceAction$3
    //   37: dup
    //   38: aload_0
    //   39: iload_1
    //   40: invokespecial 416	com/tencent/viola/vinstance/VInstanceAction$3:<init>	(Lcom/tencent/viola/vinstance/VInstanceAction;Z)V
    //   43: invokevirtual 420	com/tencent/viola/core/ViolaSDKManager:postOnThreadPool	(Ljava/lang/Runnable;)V
    //   46: goto -26 -> 20
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	VInstanceAction
    //   0	54	1	paramBoolean	boolean
    //   9	9	2	i	int
    //   49	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	49	finally
    //   23	46	49	finally
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
      ViolaLogUtils.d("Wormhole", "[onAddVInstance] refreshItem, id: " + paramString + ", data: " + paramDomObjectVInstance);
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
    if ((this.preconditor != null) && (this.preconditor.getAdapter() != null)) {
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
    if ((this.preconditor != null) && (this.preconditor.getAdapter() != null)) {
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
    if ((paramString1 == null) || (paramString1.get() == null)) {}
    do
    {
      return;
      paramString1 = getVInstanceFromDomContext(((DomObjectVInstance)paramString1.get()).getRef());
    } while (paramString1 == null);
    paramString1.unregisterFromContext(true);
  }
  
  public void release(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
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
      ViolaLogUtils.d("Wormhole", "[doInit] failQueue, id: " + (String)localEntry.getKey() + ", value: " + (String)localEntry.getValue());
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