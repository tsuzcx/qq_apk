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
    return localObject;
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    return buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
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
    //   13: ldc 101
    //   15: invokestatic 107	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_0
    //   19: ireturn
    //   20: new 38	com/tencent/pts/core/itemview/PTSItemData$Builder
    //   23: dup
    //   24: invokespecial 39	com/tencent/pts/core/itemview/PTSItemData$Builder:<init>	()V
    //   27: aload_0
    //   28: getfield 78	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   31: invokevirtual 43	com/tencent/pts/core/itemview/PTSItemData$Builder:withPageName	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   34: aload_0
    //   35: getfield 80	com/tencent/pts/core/PTSComposer:frameTreeString	Ljava/lang/String;
    //   38: invokevirtual 46	com/tencent/pts/core/itemview/PTSItemData$Builder:withFrameTreeJson	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   41: aload_0
    //   42: getfield 82	com/tencent/pts/core/PTSComposer:jsonData	Ljava/lang/String;
    //   45: invokevirtual 49	com/tencent/pts/core/itemview/PTSItemData$Builder:withJsonData	(Ljava/lang/String;)Lcom/tencent/pts/core/itemview/PTSItemData$Builder;
    //   48: invokevirtual 53	com/tencent/pts/core/itemview/PTSItemData$Builder:build	()Lcom/tencent/pts/core/itemview/PTSItemData;
    //   51: astore 5
    //   53: aload_0
    //   54: new 55	com/tencent/pts/core/PTSAppInstance$Builder
    //   57: dup
    //   58: invokespecial 56	com/tencent/pts/core/PTSAppInstance$Builder:<init>	()V
    //   61: iconst_1
    //   62: invokevirtual 60	com/tencent/pts/core/PTSAppInstance$Builder:withRootNodeType	(I)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   65: aload 5
    //   67: invokevirtual 64	com/tencent/pts/core/PTSAppInstance$Builder:withItemData	(Lcom/tencent/pts/core/itemview/PTSItemData;)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   70: aload_0
    //   71: getfield 84	com/tencent/pts/core/PTSComposer:containerWidth	F
    //   74: invokevirtual 68	com/tencent/pts/core/PTSAppInstance$Builder:withContainerWidth	(F)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   77: aconst_null
    //   78: invokevirtual 72	com/tencent/pts/core/PTSAppInstance$Builder:withLiteEventListener	(Lcom/tencent/pts/core/lite/IPTSLiteEventListener;)Lcom/tencent/pts/core/PTSAppInstance$Builder;
    //   81: invokevirtual 75	com/tencent/pts/core/PTSAppInstance$Builder:build	()Lcom/tencent/pts/core/PTSAppInstance;
    //   84: putfield 30	com/tencent/pts/core/PTSComposer:ptsAppInstance	Lcom/tencent/pts/core/PTSAppInstance;
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 25	com/tencent/pts/core/PTSComposer:hasDestroyed	Z
    //   92: iload_2
    //   93: istore_1
    //   94: ldc 8
    //   96: new 109	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   103: ldc 112
    //   105: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload_1
    //   109: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc 121
    //   114: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_0
    //   118: getfield 78	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   121: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 107	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iload_1
    //   131: ireturn
    //   132: astore 5
    //   134: iconst_0
    //   135: istore_1
    //   136: ldc 8
    //   138: new 109	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   145: ldc 127
    //   147: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 78	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   154: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 129
    //   159: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 5
    //   164: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 135	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -79 -> 94
    //   176: astore 5
    //   178: iconst_0
    //   179: istore_1
    //   180: ldc 8
    //   182: new 109	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   189: ldc 127
    //   191: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: getfield 78	com/tencent/pts/core/PTSComposer:pageName	Ljava/lang/String;
    //   198: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 129
    //   203: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 5
    //   208: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 135	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: goto -123 -> 94
    //   220: astore 5
    //   222: iload 4
    //   224: istore_1
    //   225: goto -45 -> 180
    //   228: astore 5
    //   230: iload_3
    //   231: istore_1
    //   232: goto -96 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	PTSComposer
    //   0	235	1	paramBoolean	boolean
    //   6	87	2	bool1	boolean
    //   1	230	3	bool2	boolean
    //   3	220	4	bool3	boolean
    //   51	15	5	localPTSItemData	PTSItemData
    //   132	31	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   176	31	5	localException1	java.lang.Exception
    //   220	1	5	localException2	java.lang.Exception
    //   228	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   20	87	132	java/lang/IllegalArgumentException
    //   20	87	176	java/lang/Exception
    //   87	92	220	java/lang/Exception
    //   87	92	228	java/lang/IllegalArgumentException
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
  
  public void destroy()
  {
    if (!this.hasDestroyed)
    {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSComposer
 * JD-Core Version:    0.7.0.1
 */