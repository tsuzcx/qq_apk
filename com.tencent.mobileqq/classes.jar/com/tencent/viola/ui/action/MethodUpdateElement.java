package com.tencent.viola.ui.action;

import android.text.TextUtils;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MethodUpdateElement
  implements DOMAction, RenderAction
{
  public static String TAG = "MethodUpdateElement";
  private volatile boolean applyLayout;
  private DomObject mDomObject;
  private String mRef;
  private String mRootRef;
  private JSONObject mUpdateData;
  private boolean needReflow = false;
  private volatile boolean sync;
  private Map<String, Object> updateAttrs;
  private Map<String, Object> updateStyles;
  
  public MethodUpdateElement(String paramString, JSONObject paramJSONObject)
  {
    this(paramString, paramJSONObject, false, true);
  }
  
  public MethodUpdateElement(String paramString, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mRef = paramString;
    this.mUpdateData = paramJSONObject;
    this.sync = paramBoolean1;
    this.applyLayout = paramBoolean2;
  }
  
  private void bindData(VComponent paramVComponent)
  {
    DomObject localDomObject = this.mDomObject;
    if (localDomObject != null)
    {
      if (paramVComponent == null) {
        return;
      }
      paramVComponent.bindData(localDomObject);
    }
  }
  
  private void tryCompatVR(Map<String, Object> paramMap, VComponent paramVComponent)
  {
    if ((paramMap != null) && (paramMap.containsKey("vr")) && (paramVComponent != null))
    {
      if (this.mDomObject == null) {
        return;
      }
      paramMap = paramMap.get("vr");
      Object localObject = this.mDomObject.getAttributes().get("vr");
      if ((localObject != null) && (paramMap != null) && (localObject.toString().equals(paramMap.toString()))) {
        return;
      }
      paramVComponent.tryCompatVR(this.mDomObject);
    }
  }
  
  public void executeAsync(String paramString)
  {
    DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(paramString);
    paramString = ViolaUtils.getRenderActionContext(paramString);
    if (localDOMActionContext != null)
    {
      if (paramString == null) {
        return;
      }
      executeDom(localDOMActionContext);
      executeRender(paramString);
    }
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    DomObject localDomObject;
    if (!paramDOMActionContext.isDestory())
    {
      if (this.mUpdateData == null) {
        return;
      }
      localDomObject = paramDOMActionContext.getDomByRef(this.mRef);
      if (localDomObject == null) {
        return;
      }
    }
    try
    {
      if (this.mUpdateData.has("style"))
      {
        this.updateStyles = ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("style"));
        localDomObject.updateStyle(this.updateStyles);
        if (!ViolaUtils.isBindDataOpmOpen()) {
          localDomObject.traverseTree(new DomObject.Consumer[] { paramDOMActionContext.getApplyStyleConsumer() });
        }
      }
      if (this.mUpdateData.has("attr"))
      {
        this.updateAttrs = ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("attr"));
        localDomObject.updateAttr(this.updateAttrs);
      }
      this.mDomObject = localDomObject;
      this.mRootRef = paramDOMActionContext.getRootRef();
      if (!this.sync) {
        paramDOMActionContext.postRenderTask(this);
      }
      return;
    }
    catch (JSONException paramDOMActionContext) {}
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    VComponent localVComponent = paramRenderActionContext.getComponent(this.mRef);
    if (localVComponent != null)
    {
      if (TextUtils.isEmpty(this.mRootRef)) {
        return;
      }
      int j = 0;
      Map localMap = this.updateAttrs;
      int i = j;
      if (localMap != null)
      {
        localVComponent.updateAttrs(localMap);
        tryCompatVR(this.updateAttrs, localVComponent);
        i = j;
        if (DomObject.shouldDirty(this.updateAttrs)) {
          i = 1;
        }
      }
      localMap = this.updateStyles;
      j = i;
      if (localMap != null)
      {
        localVComponent.updateStyle(localMap, true);
        j = i;
        if (DomObject.shouldDirty(this.updateStyles)) {
          j = 1;
        }
      }
      paramRenderActionContext = paramRenderActionContext.getComponent(this.mRootRef);
      if ((paramRenderActionContext != null) && (this.applyLayout)) {
        if (ViolaUtils.isLayoutOpmOpen()) {
          paramRenderActionContext.applyLayout();
        } else {
          paramRenderActionContext.applyLayoutAndEvent();
        }
      }
      bindData(localVComponent);
      if (j != 0)
      {
        localVComponent.notifyChange(1, this.mRef);
        localVComponent.notifyWhenChange("update", this.mDomObject);
      }
      localVComponent.updateLifeCycle("updated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodUpdateElement
 * JD-Core Version:    0.7.0.1
 */