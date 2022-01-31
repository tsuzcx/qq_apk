package com.tencent.pts.core;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class PTSAppInstance
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private static ThreadLocal<TextView> sTextView;
  private final String TAG = "PTSAppInstance";
  private Activity mActivity;
  private String mAppName;
  private String mAppPath;
  private PTSItemData mItemData;
  private PTSJSBridge mPTSJSBridge;
  private PTSRootNode mRootNode;
  private int mRootNodeType;
  private ViewGroup mRootView;
  private int mUniqueID = NEXT_ID.getAndIncrement();
  
  private void init(int paramInt)
  {
    this.mRootNode = new PTSRootNode(this, this.mRootView, paramInt);
    this.mPTSJSBridge.initAppJSBundle(this.mAppName, this.mAppPath, this);
  }
  
  public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.mRootNode.addOnRecyclerViewScrollListener(paramOnScrollListener);
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public PTSItemData getItemData()
  {
    return this.mItemData;
  }
  
  public PTSJSBridge getJSBridge()
  {
    return this.mPTSJSBridge;
  }
  
  public PTSRootNode getRootNode()
  {
    return this.mRootNode;
  }
  
  public int getRootNodeType()
  {
    return this.mRootNodeType;
  }
  
  public float getRootViewWidth()
  {
    float f2 = PTSDeviceUtil.getScreenWidthDp();
    float f1 = f2;
    if (this.mRootView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mRootView.getLayoutParams();
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
      Object localObject = getActivity().getApplicationContext();
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
    return this.mUniqueID;
  }
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    PTSLog.i("PTSAppInstance", "[onDestroy], destroy PTSJNIHandler.");
    PTSJNIHandler.destroy(this, this.mPTSJSBridge.getJSEnvID());
    if (sTextView != null)
    {
      sTextView.remove();
      sTextView = null;
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance
 * JD-Core Version:    0.7.0.1
 */