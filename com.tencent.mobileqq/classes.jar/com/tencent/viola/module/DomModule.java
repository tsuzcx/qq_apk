package com.tencent.viola.module;

import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodAddElement;
import com.tencent.viola.ui.action.MethodCreateBody;
import com.tencent.viola.ui.action.MethodRemoveElement;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.ui.action.RenderAction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DomModule
  extends BaseModule
{
  public static final String DOM_MODULE_NAME = "dom";
  public static final String METHOD_ADD_ELEMENT = "addElement";
  public static final String METHOD_CREATE_BODY = "createBody";
  public static final String METHOD_REMOVE_ELEMENT = "removeElement";
  public static final String METHOD_UPDATE_ELEMENT = "updateElement";
  
  public boolean invokeComponetMethod(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray)
  {
    paramString1 = ViolaSDKManager.getInstance().getRenderManager().getComponent(paramString1, paramString2);
    if (paramString1 == null) {
      return false;
    }
    ViolaSDKManager.getInstance().postOnUiThread(new DomModule.1(this, paramString1, paramString3, paramJSONArray));
    return true;
  }
  
  public boolean invokeDomMethod(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1368682686: 
      if (paramString.equals("createBody")) {
        i = 0;
      }
      break;
    case 1136179699: 
      if (paramString.equals("updateElement")) {
        i = 3;
      }
      break;
    case 245397275: 
      if (paramString.equals("addElement")) {
        i = 1;
      }
      break;
    case -467344936: 
      if (paramString.equals("removeElement")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            return true;
          }
        }
      }
    }
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        paramString = new MethodUpdateElement((String)((JSONArray)paramObject).get(0), (JSONObject)((JSONArray)paramObject).get(1));
        if ((paramString instanceof DOMAction))
        {
          postAction((DOMAction)paramString, false);
          return true;
        }
        postAction((RenderAction)paramString);
        return true;
        if ((paramObject instanceof JSONArray))
        {
          paramString = new MethodRemoveElement((String)((JSONArray)paramObject).get(0));
          if ((paramString instanceof DOMAction))
          {
            postAction((DOMAction)paramString, false);
            return true;
          }
          postAction((RenderAction)paramString);
          return true;
          if ((paramObject instanceof JSONArray))
          {
            paramString = new MethodAddElement((String)((JSONArray)paramObject).get(0), (JSONObject)((JSONArray)paramObject).get(1), ((Integer)((JSONArray)paramObject).get(2)).intValue());
            if ((paramString instanceof DOMAction))
            {
              postAction((DOMAction)paramString, false);
              return true;
            }
            postAction((RenderAction)paramString);
            return true;
            if (getViolaInstance() != null) {
              getViolaInstance().renderJsEndMonitor();
            }
            ViolaInstance.jsCreateInstanceEnd = System.currentTimeMillis();
            if ((paramObject instanceof JSONObject))
            {
              paramString = new MethodCreateBody((JSONObject)paramObject);
              if ((paramString instanceof DOMAction))
              {
                postAction((DOMAction)paramString, true);
                return true;
              }
              postAction((RenderAction)paramString);
            }
          }
        }
      }
      return true;
    }
    catch (JSONException paramString) {}
    return true;
  }
  
  public void postAction(DOMAction paramDOMAction, boolean paramBoolean)
  {
    ViolaSDKManager.getInstance().getDomManager().postAction(getViolaInstance().getInstanceId(), paramDOMAction, paramBoolean);
  }
  
  public void postAction(RenderAction paramRenderAction)
  {
    ViolaSDKManager.getInstance().getRenderManager().runOnThread(getViolaInstance().getInstanceId(), paramRenderAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.DomModule
 * JD-Core Version:    0.7.0.1
 */