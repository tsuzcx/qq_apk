package com.tencent.pts.core;

import android.text.TextUtils;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

public class PTSJNIHandler
{
  private static String TAG = "PTSJNIHandler";
  private static HashMap<Integer, PTSAppInstance> sAppInstanceMap = new HashMap();
  
  public static void addPTSAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    sAppInstanceMap.put(Integer.valueOf(paramPTSAppInstance.getUniqueID()), paramPTSAppInstance);
  }
  
  public static void clearPTSAppInstance()
  {
    sAppInstanceMap.clear();
  }
  
  private static PTSAppInstance getAppInstance(int paramInt)
  {
    return (PTSAppInstance)sAppInstanceMap.get(Integer.valueOf(paramInt));
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return PTSNodeFactory.getCustomTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return PTSNodeFactory.getCustomTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return PTSNodeFactory.getCustomTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static String getPageInfo(int paramInt, String paramString)
  {
    Object localObject = getAppInstance(paramInt);
    String str = "";
    if (localObject != null)
    {
      localObject = ((PTSAppInstance)localObject).getItemData();
      if (localObject != null) {
        str = ((PTSItemData)localObject).getJSONData();
      }
    }
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      PTSLog.i(TAG, "[getPageInfo], key = " + paramString + ", res = " + (String)localObject);
      return localObject;
      PTSLog.e(TAG, "[getPageInfo], data is null.");
      continue;
      PTSLog.e(TAG, "[getPageInfo], app not found.");
    }
  }
  
  public static float[] getRichTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return PTSNodeFactory.getRichTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    PTSAppInstance localPTSAppInstance = getAppInstance(paramInt);
    if (localPTSAppInstance != null) {
      return localPTSAppInstance.getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4);
    }
    return new float[2];
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return PTSNodeFactory.getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void layoutRefreshCallback(List<PTSLayoutTempPatch> paramList, int paramInt)
  {
    PTSThreadUtil.runOnUIThread(new PTSJNIHandler.2(paramInt, paramList));
  }
  
  public static boolean refreshNodeList(List<PTSNodeInfo> paramList, int paramInt)
  {
    PTSThreadUtil.runOnUIThread(new PTSJNIHandler.1(paramInt, paramList));
    return true;
  }
  
  public static void removePTSAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    sAppInstanceMap.remove(Integer.valueOf(paramPTSAppInstance.getUniqueID()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler
 * JD-Core Version:    0.7.0.1
 */