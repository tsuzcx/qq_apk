package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.common.wormhole.WormholeManager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class DomObjectTKDWormhole
  extends DomObject
{
  private String a;
  private int b;
  
  public HippyMap a(Object paramObject)
  {
    HippyMap localHippyMap1 = new HippyMap();
    HippyMap localHippyMap2 = new HippyMap();
    if ((paramObject instanceof JSONObject)) {
      try
      {
        Object localObject = ((JSONObject)paramObject).keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localHippyMap2.pushString(str, ((JSONObject)paramObject).getString(str));
        }
        if (!(paramObject instanceof String)) {
          break label137;
        }
      }
      catch (JSONException paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getWormholeHippyMap json error:");
        ((StringBuilder)localObject).append(paramObject.getMessage());
        ViolaLogUtils.e("DomObjectTKDWormhole", ((StringBuilder)localObject).toString());
        localHippyMap1.pushObject("data", localHippyMap2);
      }
    } else {
      localHippyMap1.pushString("data", (String)paramObject);
    }
    label137:
    localHippyMap1.pushString("wormholeId", this.a);
    return localHippyMap1;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroy()
  {
    super.destroy();
    WormholeManager.a().a(Integer.valueOf(getRef()).intValue());
  }
  
  public void parseFromJson(JSONObject paramJSONObject)
  {
    super.parseFromJson(paramJSONObject);
    if (getAttributes().containsKey("data"))
    {
      this.a = WormholeManager.a().b();
      this.b = (Integer.valueOf(getInstanceId()).intValue() + 10076);
      paramJSONObject = a(getAttributes().get("data"));
      paramJSONObject.pushString("wormholeId", this.a);
      WormholeManager.a().a(paramJSONObject, this.a, Integer.valueOf(getRef()), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.DomObjectTKDWormhole
 * JD-Core Version:    0.7.0.1
 */