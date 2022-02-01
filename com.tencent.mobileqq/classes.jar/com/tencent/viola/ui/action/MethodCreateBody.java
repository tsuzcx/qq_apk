package com.tencent.viola.ui.action;

import android.text.TextUtils;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

public class MethodCreateBody
  extends MethodAbsAdd
{
  public static String TAG = "MethodCreateBody";
  private volatile boolean createFromNativeVue;
  private JSONObject mData;
  
  public MethodCreateBody(JSONObject paramJSONObject)
  {
    this.mData = paramJSONObject;
  }
  
  private void forceBatch()
  {
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    if (this.createFromNativeVue)
    {
      localViolaDomManager.forceNvBatch();
      return;
    }
    localViolaDomManager.forceBatch();
  }
  
  private boolean isRootMeasuredExactly(ViolaInstance paramViolaInstance)
  {
    if (this.createFromNativeVue) {
      return paramViolaInstance.mNVMeasuredExactly;
    }
    return paramViolaInstance.isRootMeasuredExactly();
  }
  
  private void setRootMeasuredExactly(ViolaInstance paramViolaInstance, boolean paramBoolean)
  {
    if (this.createFromNativeVue)
    {
      paramViolaInstance.mNVMeasuredExactly = paramBoolean;
      return;
    }
    paramViolaInstance.setRootMeasuredExactly(paramBoolean);
  }
  
  private void setRootRef(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    if (this.createFromNativeVue)
    {
      paramDOMActionContext.setNvRootRef(paramDomObject.getRef());
      return;
    }
    paramDOMActionContext.setRootRef(paramDomObject.getRef());
  }
  
  protected void appendDomToTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    ViolaInstance localViolaInstance = paramDOMActionContext.getInstance();
    if (localViolaInstance != null)
    {
      float f = localViolaInstance.getRenderContainerHeight() / FlexConvertUtils.getScreenWidth() * 750.0F;
      if (f == 0.0F)
      {
        setRootMeasuredExactly(localViolaInstance, false);
        ViolaLogUtils.e(TAG, "测试算出来的高度：appendDomToTree");
      }
      paramDomObject.initRoot(paramDomObject.getRef(), f, 750.0F);
      setRootRef(paramDOMActionContext, paramDomObject);
      this.mRootRef = paramDomObject.getRef();
    }
  }
  
  protected VComponent createComponent(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    return generateComponentTree(paramDOMActionContext, paramDomObject, null);
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    ViolaLogUtils.d("debugForTimeCost", "executeDom before : " + System.currentTimeMillis());
    ViolaInstance localViolaInstance = paramDOMActionContext.getInstance();
    long l = System.currentTimeMillis();
    addDomInternal(paramDOMActionContext, this.mData);
    paramDOMActionContext.postRenderTask(this);
    ViolaLogUtils.d("debugForTimeCost", "executeDom after : " + System.currentTimeMillis());
    if (localViolaInstance != null)
    {
      localViolaInstance.mLayoutStart = l;
      localViolaInstance.mLayoutEnd = System.currentTimeMillis();
      ViolaLogUtils.d("debugForTimeCost", "executeDom : " + (System.currentTimeMillis() - l));
    }
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    if ((paramRenderActionContext == null) || (TextUtils.isEmpty(this.mRootRef))) {
      return;
    }
    ViolaLogUtils.e(TAG, "violaInstance executeRender start!");
    VComponent localVComponent = paramRenderActionContext.getComponent(this.mRootRef);
    paramRenderActionContext = paramRenderActionContext.getInstance();
    if ((paramRenderActionContext == null) || (paramRenderActionContext.getContext() == null))
    {
      ViolaLogUtils.e(TAG, "instance is null or instance is destroy!");
      return;
    }
    if (ViolaSDKManager.getInstance().getRenderManager() == null)
    {
      ViolaLogUtils.e(TAG, "violaInstance renderManager null!");
      return;
    }
    if (localVComponent == null)
    {
      ViolaLogUtils.e(TAG, "component null!");
      return;
    }
    paramRenderActionContext.mCreateViewStart = System.currentTimeMillis();
    float f;
    if (!isRootMeasuredExactly(paramRenderActionContext))
    {
      f = paramRenderActionContext.getRenderContainerHeight() / FlexConvertUtils.getScreenWidth() * 750.0F;
      if (f != 0.0F) {
        break label208;
      }
      setRootMeasuredExactly(paramRenderActionContext, false);
    }
    for (;;)
    {
      localVComponent.createView();
      paramRenderActionContext.mCreateViewEnd = System.currentTimeMillis();
      paramRenderActionContext.mApplyLayoutAndEventStart = System.currentTimeMillis();
      localVComponent.applyLayoutAndEvent();
      paramRenderActionContext.mApplyLayoutAndEventEnd = System.currentTimeMillis();
      paramRenderActionContext.mBindDataStart = System.currentTimeMillis();
      localVComponent.bindData();
      paramRenderActionContext.mBindDataEnd = System.currentTimeMillis();
      ViolaLogUtils.e(TAG, "violaInstance executeRender end!");
      if (!(localVComponent instanceof VComponentContainer)) {
        break;
      }
      paramRenderActionContext.onRootCreated((VComponentContainer)localVComponent, this.createFromNativeVue);
      return;
      label208:
      localVComponent.getDomObject().initRoot(localVComponent.getDomObject().getRef(), f, 750.0F);
      if (f != localVComponent.getDomObject().getLayoutHeight()) {
        forceBatch();
      }
      setRootMeasuredExactly(paramRenderActionContext, true);
    }
  }
  
  public boolean isCreateFromNativeVue()
  {
    return this.createFromNativeVue;
  }
  
  public void setCreateFromNativeVue(boolean paramBoolean)
  {
    this.createFromNativeVue = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodCreateBody
 * JD-Core Version:    0.7.0.1
 */