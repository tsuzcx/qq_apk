package com.tencent.mobileqq.vas.trooppobing;

import android.graphics.Color;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PobingDecoder
  implements QuickUpdateListener, Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<PobingDecoder.DecodeCallBack> jdField_a_of_type_JavaLangRefWeakReference;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public PobingDecoder(int paramInt, HashMap<Integer, String> paramHashMap, PobingDecoder.DecodeCallBack paramDecodeCallBack)
  {
    this.jdField_a_of_type_Int = ((Integer)PobingManager.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDecodeCallBack);
    ThreadManagerV2.excute(this, 64, null, false);
  }
  
  private static int a(int paramInt)
  {
    Integer localInteger = (Integer)PobingManager.d.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return -16777216;
    }
    return localInteger.intValue();
  }
  
  public static PobingDecoder.BitmapsCache a(PobingDecoder.DecodeData paramDecodeData, boolean paramBoolean)
  {
    if ((paramDecodeData != null) && (paramDecodeData.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (paramDecodeData.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        return null;
      }
      String str;
      if (paramBoolean) {
        str = PobingManager.b(paramDecodeData.jdField_a_of_type_Int);
      } else {
        str = PobingManager.a(paramDecodeData.jdField_a_of_type_Int);
      }
      PobingDecoder.BitmapsCache localBitmapsCache = a(str);
      if (localBitmapsCache != null) {
        return localBitmapsCache;
      }
      localBitmapsCache = new PobingDecoder.BitmapsCache();
      Iterator localIterator = paramDecodeData.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (paramDecodeData.jdField_a_of_type_Int != 2004)
        {
          Object localObject = (String)paramDecodeData.jdField_a_of_type_JavaUtilHashMap.get(localInteger);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = PobingUpdateCallback.sInstance.decodeBitmap((String)localObject);
            if (localObject == null)
            {
              if (paramDecodeData.jdField_a_of_type_Int != 2000) {
                return null;
              }
            }
            else {
              localBitmapsCache.jdField_a_of_type_JavaUtilHashMap.put(localInteger, localObject);
            }
          }
        }
      }
      localBitmapsCache.jdField_a_of_type_Int = ((Integer)PobingManager.c.get(Integer.valueOf(paramDecodeData.jdField_a_of_type_Int))).intValue();
      localBitmapsCache.jdField_b_of_type_Int = paramDecodeData.jdField_b_of_type_Int;
      localBitmapsCache.jdField_b_of_type_JavaUtilHashMap = paramDecodeData.jdField_a_of_type_JavaUtilHashMap;
      GlobalImageCache.a.put(str, localBitmapsCache);
      paramDecodeData = new StringBuilder();
      paramDecodeData.append("troop_pobing,cache_add,");
      paramDecodeData.append(localBitmapsCache.jdField_a_of_type_Int);
      QLog.d("PobingDecoder", 2, paramDecodeData.toString());
      return localBitmapsCache;
    }
    return null;
  }
  
  public static PobingDecoder.BitmapsCache a(String paramString)
  {
    paramString = (PobingDecoder.BitmapsCache)GlobalImageCache.a.get(paramString);
    if (paramString != null) {
      paramString.jdField_a_of_type_Int = ((Integer)PobingManager.c.get(Integer.valueOf(paramString.jdField_a_of_type_Int))).intValue();
    }
    return paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = new PobingDecoder.DecodeData();
    PobingUpdateCallback localPobingUpdateCallback = PobingUpdateCallback.sInstance;
    if (!localPobingUpdateCallback.isCardExists(((QQAppInterface)localObject2).getApp(), this.jdField_a_of_type_Int))
    {
      if (!paramBoolean)
      {
        localPobingUpdateCallback.download(this.jdField_a_of_type_Int, this, false);
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("troop_pobing,bitmaps still missing after download: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.e("PobingDecoder", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      String str = localPobingUpdateCallback.getFilePathById(((QQAppInterface)localObject2).getApp(), this.jdField_a_of_type_Int, (String)localEntry.getValue());
      ((PobingDecoder.DecodeData)localObject1).jdField_a_of_type_JavaUtilHashMap.put(localEntry.getKey(), str);
    }
    localObject2 = FileUtils.readFileContent(new File(localPobingUpdateCallback.getDir(((QQAppInterface)localObject2).getApp(), localPobingUpdateCallback.getScid(this.jdField_a_of_type_Int)), "config.json"));
    try
    {
      ((PobingDecoder.DecodeData)localObject1).jdField_b_of_type_Int = Color.parseColor(new JSONObject((String)localObject2).getString("textColor"));
    }
    catch (Exception localException)
    {
      ((PobingDecoder.DecodeData)localObject1).jdField_b_of_type_Int = a(this.jdField_a_of_type_Int);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("content:");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.e("PobingDecoder", 1, ((StringBuilder)localObject3).toString(), localException);
    }
    ((PobingDecoder.DecodeData)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localObject2 = (PobingDecoder.DecodeCallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 != null) {
      ((PobingDecoder.DecodeCallBack)localObject2).a((PobingDecoder.DecodeData)localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("troop_pobing,decode_callback,");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    QLog.d("PobingDecoder", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      a(true);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("troop_pobing,res_onCompleted: ");
    paramString2.append(paramString1);
    paramString2.append(" error:");
    paramString2.append(paramInt1);
    paramString2.append(", ");
    paramString2.append(paramInt2);
    QLog.e("PobingDecoder", 1, paramString2.toString());
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.trooppobing.PobingDecoder
 * JD-Core Version:    0.7.0.1
 */