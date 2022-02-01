package com.tencent.pts.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewGroup;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PTSAppInstance
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private static final String TAG = "PTSAppInstance";
  private float containerWidth;
  private Context context;
  private String frameTreeJson;
  protected PTSItemData itemData;
  private String pageJs;
  private String pageName;
  private PTSComposer ptsComposer;
  private PTSRootNode rootNode;
  private int rootNodeType;
  private ViewGroup rootView;
  private int uniqueId = NEXT_ID.getAndIncrement();
  
  private void init(int paramInt)
  {
    this.rootNode = new PTSRootNode(this, this.rootView, paramInt);
    initPTSAppInstance(this.frameTreeJson, this.pageJs);
  }
  
  private void release()
  {
    this.context = null;
    this.rootView = null;
    this.rootNode = null;
  }
  
  public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    PTSRootNode localPTSRootNode = this.rootNode;
    if (localPTSRootNode != null) {
      localPTSRootNode.addOnRecyclerViewScrollListener(paramOnScrollListener);
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public PTSItemData getItemData()
  {
    return this.itemData;
  }
  
  public PTSJSBridge getJsBridge()
  {
    return null;
  }
  
  public PTSLiteBridge getLiteBridge()
  {
    return null;
  }
  
  public String getPageName()
  {
    return this.pageName;
  }
  
  public PTSComposer getPtsComposer()
  {
    return this.ptsComposer;
  }
  
  public PTSRootNode getRootNode()
  {
    return this.rootNode;
  }
  
  public int getRootNodeType()
  {
    return this.rootNodeType;
  }
  
  public float getRootViewWidth()
  {
    float f = this.containerWidth;
    if (f > 0.0F) {
      return f;
    }
    return PTSDeviceUtil.getScreenWidthDp();
  }
  
  float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return PTSNodeFactory.getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4);
  }
  
  public int getUniqueID()
  {
    return this.uniqueId;
  }
  
  abstract void initPTSAppInstance(String paramString1, String paramString2);
  
  public boolean isJsAppInstance()
  {
    return this instanceof PTSAppInstance.PTSJsAppInstance;
  }
  
  public boolean isLiteAppInstance()
  {
    return this instanceof PTSAppInstance.PTSLiteAppInstance;
  }
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    PTSLog.i("PTSAppInstance", "[onDestroy], destroy PTSJNIHandler.");
    release();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    this.itemData = paramPTSItemData;
  }
  
  public void setPtsComposer(PTSComposer paramPTSComposer)
  {
    this.ptsComposer = paramPTSComposer;
  }
  
  public void setPtsLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if ((this instanceof PTSAppInstance.PTSLiteAppInstance))
    {
      PTSAppInstance.PTSLiteAppInstance.access$000((PTSAppInstance.PTSLiteAppInstance)this, paramIPTSLiteEventListener);
      return;
    }
    PTSLog.i("PTSAppInstance", "[setLiteEventListener] failed, this is not PTSLiteAppInstance.");
  }
  
  public void triggerExposureEvent()
  {
    PTSRootNode localPTSRootNode = getRootNode();
    if ((localPTSRootNode != null) && (localPTSRootNode.getRootNodeInfo() != null))
    {
      Object localObject = localPTSRootNode.getRootNodeInfo();
      HashMap localHashMap = ((PTSNodeInfo)localObject).getEventInfo();
      localObject = ((PTSNodeInfo)localObject).getAttributes().getEventPtsOnExposure();
      if (isLiteAppInstance())
      {
        ((PTSAppInstance.PTSLiteAppInstance)this).triggerLiteEvent(2, (String)localObject, localHashMap, localPTSRootNode.getRootView(), getPtsComposer());
        return;
      }
      PTSLog.e("PTSAppInstance", "[triggerExposureEvent] failed, is not PTSLiteAppInstance.");
      return;
    }
    PTSLog.e("PTSAppInstance", "[triggerExposureEvent], ptsRootNode or rootNodeInfo is null.");
  }
  
  public String updateData(String paramString)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance
 * JD-Core Version:    0.7.0.1
 */