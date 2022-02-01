package com.tencent.pts.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;

public class PTSComposer
{
  private static final String TAG = "PTSComposer";
  private Application.ActivityLifecycleCallbacks activityLifecycleCallback;
  private float containerWidth;
  private String frameTreeString;
  private boolean hasDestroyed = false;
  private String jsonData;
  private String pageName;
  private PTSAppInstance ptsAppInstance;
  private PTSComposer.IPTSUpdateDataListener updateDataListener;
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, float paramFloat, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    Object localObject = new PTSItemData.Builder().withPageName(paramString1).withFrameTreeJson(paramString2).withJsonData(paramString3).build();
    paramIPTSLiteEventListener = new PTSAppInstance.Builder().withRootNodeType(1).withItemData((PTSItemData)localObject).withContainerWidth(paramFloat).withLiteEventListener(paramIPTSLiteEventListener).build();
    localObject = new PTSComposer();
    ((PTSComposer)localObject).ptsAppInstance = paramIPTSLiteEventListener;
    ((PTSComposer)localObject).pageName = paramString1;
    ((PTSComposer)localObject).frameTreeString = paramString2;
    ((PTSComposer)localObject).jsonData = paramString3;
    ((PTSComposer)localObject).containerWidth = paramFloat;
    paramIPTSLiteEventListener.setPtsComposer((PTSComposer)localObject);
    return localObject;
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    return buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener, PTSComposer.IPTSUpdateDataListener paramIPTSUpdateDataListener)
  {
    paramString1 = buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
    paramString1.updateDataListener = paramIPTSUpdateDataListener;
    return paramString1;
  }
  
  /* Error */
  private boolean rebuildPtsAppInstance(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: iconst_1
    //   6: istore_2
    //   7: iload_1
    //   8: ifne +12 -> 20
    //   11: ldc 8
    //   13: ldc 112
    //   15: invokestatic 118	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_0
    //   19: ireturn
    //   20: new 40	com/tencent/pts/core/itemview/PTSItemData$Builder
    //   23: dup
    //   24: invokespecial 41	com/tencent/pts/core/itemview/PTSItemData$Builder:<init>	()V
    //   27: aload_0
    //   28: getfield 80	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   31: invokevirtual 45	com/tencent/pts/core/itemview/PTSItemData$Builder:withPageName	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   34: aload_0
    //   35: getfield 82	com/tencent/pts/core/PTSComposer:frameTreeString	Ljava/lang/String;
    //   38: invokevirtual 48	com/tencent/pts/core/itemview/PTSItemData$Builder:withFrameTreeJson	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   41: aload_0
    //   42: getfield 84	com/tencent/pts/core/PTSComposer:jsonData	Ljava/lang/String;
    //   45: invokevirtual 51	com/tencent/pts/core/itemview/PTSItemData$Builder:withJsonData	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   48: invokevirtual 55	com/tencent/pts/core/itemview/PTSItemData$Builder:build	()Lcom/tencent/pts/core/itemview/PTSItemData;
    //   51: astore 5
    //   53: aload_0
    //   54: new 57	com/tencent/pts/core/PTSAppInstance$Builder
    //   57: dup
    //   58: invokespecial 58	com/tencent/pts/core/PTSAppInstance$Builder:<init>	()V
    //   61: iconst_1
    //   62: invokevirtual 62	com/tencent/pts/core/PTSAppInstance$Builder:withRootNodeType	(I)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   65: aload 5
    //   67: invokevirtual 66	com/tencent/pts/core/PTSAppInstance$Builder:withItemData	(Lcom/tencent/pts/core/itemview/PTSItemData;)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   70: aload_0
    //   71: getfield 86	com/tencent/pts/core/PTSComposer:containerWidth	F
    //   74: invokevirtual 70	com/tencent/pts/core/PTSAppInstance$Builder:withContainerWidth	(F)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   77: aconst_null
    //   78: invokevirtual 74	com/tencent/pts/core/PTSAppInstance$Builder:withLiteEventListener	(Lcom/tencent/pts/core/lite/IPTSLiteEventListener;)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   81: invokevirtual 77	com/tencent/pts/core/PTSAppInstance$Builder:build	()Lcom/tencent/pts/core/PTSAppInstance;
    //   84: putfield 32	com/tencent/pts/core/PTSComposer:ptsAppInstance	Lcom/tencent/pts/core/PTSAppInstance;
    //   87: aload_0
    //   88: getfield 32	com/tencent/pts/core/PTSComposer:ptsAppInstance	Lcom/tencent/pts/core/PTSAppInstance;
    //   91: aload_0
    //   92: invokevirtual 92	com/tencent/pts/core/PTSAppInstance:setPtsComposer	(Lcom/tencent/pts/core/PTSComposer;)V
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 27	com/tencent/pts/core/PTSComposer:hasDestroyed	Z
    //   100: iload_2
    //   101: istore_1
    //   102: ldc 8
    //   104: new 120	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   111: ldc 123
    //   113: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_1
    //   117: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: ldc 132
    //   122: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 80	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   129: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 118	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iload_1
    //   139: ireturn
    //   140: astore 5
    //   142: iconst_0
    //   143: istore_1
    //   144: ldc 8
    //   146: new 120	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   153: ldc 138
    //   155: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 80	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   162: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 140
    //   167: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 146	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: goto -79 -> 102
    //   184: astore 5
    //   186: iconst_0
    //   187: istore_1
    //   188: ldc 8
    //   190: new 120	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   197: ldc 138
    //   199: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: getfield 80	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   206: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 140
    //   211: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 5
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 146	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: goto -123 -> 102
    //   228: astore 5
    //   230: iload 4
    //   232: istore_1
    //   233: goto -45 -> 188
    //   236: astore 5
    //   238: iload_3
    //   239: istore_1
    //   240: goto -96 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	PTSComposer
    //   0	243	1	paramBoolean	boolean
    //   6	95	2	bool1	boolean
    //   1	238	3	bool2	boolean
    //   3	228	4	bool3	boolean
    //   51	15	5	localPTSItemData	PTSItemData
    //   140	31	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   184	31	5	localException1	java.lang.Exception
    //   228	1	5	localException2	java.lang.Exception
    //   236	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   20	95	140	java/lang/IllegalArgumentException
    //   20	95	184	java/lang/Exception
    //   95	100	228	java/lang/Exception
    //   95	100	236	java/lang/IllegalArgumentException
  }
  
  private void registerActivityLifecycleCallbacks(Context paramContext)
  {
    if (((paramContext instanceof Activity)) && (this.activityLifecycleCallback == null))
    {
      paramContext = ((Activity)paramContext).getApplication();
      this.activityLifecycleCallback = new PTSComposer.1(this, paramContext);
      if (paramContext != null)
      {
        paramContext.registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
        PTSLog.i("PTSComposer", "[registerActivityLifecycleCallbacks] finished, appInstance = " + this.ptsAppInstance);
      }
    }
  }
  
  private void unregisterLifecycleCallbacks(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getApplication();
      if (paramContext != null)
      {
        paramContext.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
        PTSLog.i("PTSComposer", "[unregisterLifecycleCallbacks] finished");
      }
    }
  }
  
  public void destroy()
  {
    if (!this.hasDestroyed)
    {
      unregisterLifecycleCallbacks(this.ptsAppInstance.getContext());
      this.updateDataListener = null;
      this.ptsAppInstance.onDestroy();
      this.hasDestroyed = true;
      PTSLog.i("PTSComposer", "[destroy] PTSComposer.");
      return;
    }
    PTSLog.i("PTSComposer", "[destroy] hasDestroyed, no need to call.");
  }
  
  public String getJsonData()
  {
    return this.jsonData;
  }
  
  public String getPageName()
  {
    return this.pageName;
  }
  
  public PTSAppInstance getPtsAppInstance()
  {
    return this.ptsAppInstance;
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    Object localObject = paramPTSItemView.getContext();
    if (localObject == null)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, context is null.");
      return paramPTSItemView;
    }
    this.ptsAppInstance.setContext((Context)localObject);
    localObject = this.ptsAppInstance.getRootNode();
    if (localObject != null) {
      ((PTSRootNode)localObject).setRootView(paramPTSItemView);
    }
    for (;;)
    {
      paramPTSItemView.bindData(this.ptsAppInstance);
      registerActivityLifecycleCallbacks(paramPTSItemView.getContext());
      return paramPTSItemView;
      PTSLog.e("PTSComposer", "[layoutTopView] ptsRootNode is null.");
    }
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    paramPTSItemView = layoutToView(paramPTSItemView);
    this.ptsAppInstance.setPtsLiteEventListener(paramIPTSLiteEventListener);
    return paramPTSItemView;
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView, IPTSLiteEventListener paramIPTSLiteEventListener, boolean paramBoolean)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if ((this.hasDestroyed) && (!rebuildPtsAppInstance(paramBoolean)))
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    paramPTSItemView = layoutToView(paramPTSItemView);
    this.ptsAppInstance.setPtsLiteEventListener(paramIPTSLiteEventListener);
    return paramPTSItemView;
  }
  
  public void setData(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[setData] failed, PTSComposer has been destroyed.");
      return;
    }
    paramString = this.ptsAppInstance.getItemData();
    paramString = new PTSItemData.Builder().withPageName(paramString.getPageName()).withFrameTreeJson(paramString.getFrameTreeJson()).withJsonData(str).build();
    this.ptsAppInstance.setItemData(paramString);
    this.jsonData = str;
  }
  
  public void triggerExposureEvent()
  {
    this.ptsAppInstance.triggerExposureEvent();
  }
  
  public String updateData(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[setData] failed, PTSComposer has been destroyed.");
      return this.jsonData;
    }
    this.jsonData = this.ptsAppInstance.updateData(str);
    if (this.updateDataListener != null) {
      this.updateDataListener.onDataUpdated(this.jsonData);
    }
    return this.jsonData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSComposer
 * JD-Core Version:    0.7.0.1
 */