package com.tencent.pts.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PTSAppInstance
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private static ThreadLocal<TextView> sTextView;
  private final String TAG = "PTSAppInstance";
  private String appName;
  private Context context;
  private String frameTreeJson;
  private PTSItemData itemData;
  private String pageJs;
  private PTSRootNode rootNode;
  private int rootNodeType;
  private ViewGroup rootView;
  private int uniqueId = NEXT_ID.getAndIncrement();
  
  private void init(int paramInt)
  {
    PTSDeviceUtil.init(this.context);
    this.rootNode = new PTSRootNode(this, this.rootView, paramInt);
    initPTSAppInstance(this.frameTreeJson, this.pageJs);
  }
  
  public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.rootNode.addOnRecyclerViewScrollListener(paramOnScrollListener);
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
    float f2 = PTSDeviceUtil.getScreenWidthDp();
    float f1 = f2;
    if (this.rootView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.rootView.getLayoutParams();
      f1 = f2;
      if (localLayoutParams != null)
      {
        f1 = f2;
        if (localLayoutParams.width > 0) {
          f1 = PTSValueConvertUtil.px2dp(localLayoutParams.width);
        }
      }
    }
    PTSLog.i("PTSAppInstance", "getRootViewWidth, width = " + f1 + " dp");
    return f1;
  }
  
  float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Object localObject = getContext().getApplicationContext();
      if (sTextView == null) {
        sTextView = new PTSAppInstance.1(this, (Context)localObject);
      }
      TextView localTextView = (TextView)sTextView.get();
      if (localTextView == null) {
        localTextView = new TextView((Context)localObject);
      }
      for (;;)
      {
        localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        float f1 = PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(paramString2));
        float f2 = PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(paramString3) - PTSValueConvertUtil.getFloat(paramString2));
        int i = PTSValueConvertUtil.getInt(paramString4);
        if (TextUtils.isEmpty(paramString1)) {}
        for (localObject = "";; localObject = paramString1.trim())
        {
          localTextView.setText((CharSequence)localObject);
          localTextView.setTextSize(0, f1);
          localTextView.setLineSpacing(f2, 1.0F);
          localTextView.setMaxLines(i);
          localObject = new float[2];
          localObject[0] = PTSDeviceUtil.getScreenWidthDp();
          localObject[1] = 3.4028235E+38F;
          if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 2))
          {
            localObject[0] = Math.min(paramArrayOfFloat[0], PTSDeviceUtil.getScreenWidthDp());
            localObject[1] = Math.min(paramArrayOfFloat[1], 3.4028235E+38F);
          }
          localTextView.measure(View.MeasureSpec.makeMeasureSpec((int)PTSValueConvertUtil.dp2px(localObject[0]), -2147483648), View.MeasureSpec.makeMeasureSpec((int)PTSValueConvertUtil.dp2px(localObject[1]), -2147483648));
          paramArrayOfFloat = new float[2];
          paramArrayOfFloat[0] = PTSValueConvertUtil.px2dp(localTextView.getMeasuredWidth());
          paramArrayOfFloat[1] = PTSValueConvertUtil.px2dp(localTextView.getMeasuredHeight());
          if (PTSLog.isDebug())
          {
            PTSLog.i("PTSAppInstance", "getMeasuredSize, constrainedMeasure width = " + localObject[0] + ", constrainedMeasure height = " + localObject[1]);
            PTSLog.i("PTSAppInstance", "getMeasuredSize, measuredWidth = " + paramArrayOfFloat[0] + ", measureHeight = " + paramArrayOfFloat[1] + ", content = " + paramString1 + ", fontSize = " + paramString2 + ", lineHeight = " + paramString3 + ", lineClamp = " + paramString4);
          }
          return paramArrayOfFloat;
        }
      }
    }
    finally {}
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
    if (sTextView != null)
    {
      sTextView.remove();
      sTextView = null;
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    this.itemData = paramPTSItemData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance
 * JD-Core Version:    0.7.0.1
 */