package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import awzc;
import bhny;
import bhog;
import bhrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PobingDecoder
  implements bhog, Runnable
{
  private static final HashMap<Integer, Integer> b = new PobingDecoder.1();
  int jdField_a_of_type_Int;
  WeakReference<awzc<bhny>> jdField_a_of_type_JavaLangRefWeakReference;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public PobingDecoder(int paramInt, HashMap<Integer, String> paramHashMap, awzc<bhny> paramawzc)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramawzc);
    ThreadManagerV2.excute(this, 64, null, false);
  }
  
  private static int a(int paramInt)
  {
    Integer localInteger = (Integer)b.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return -16777216;
    }
    return localInteger.intValue();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bhny localbhny = new bhny();
    bhrt localbhrt = bhrt.a;
    if (!localbhrt.a(((QQAppInterface)localObject).getApp(), this.jdField_a_of_type_Int))
    {
      if (!paramBoolean)
      {
        localbhrt.download((QQAppInterface)localObject, this.jdField_a_of_type_Int, this, false);
        return;
      }
      QLog.e("PobingDecoder", 1, "bitmaps still missing after download: " + this.jdField_a_of_type_Int);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label197;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bitmap localBitmap = localbhrt.a(((QQAppInterface)localObject).getApp(), this.jdField_a_of_type_Int, (String)localEntry.getValue());
      if (localBitmap == null)
      {
        if (this.jdField_a_of_type_Int != 2000) {
          break;
        }
        if (!"addgroup_preview.png".equals(localEntry.getValue())) {
          continue;
        }
        return;
      }
      localbhny.jdField_a_of_type_JavaUtilHashMap.put(localEntry.getKey(), localBitmap);
    }
    label197:
    localObject = FileUtils.readFileContent(new File(localbhrt.getDir(((QQAppInterface)localObject).getApp(), localbhrt.getScid(this.jdField_a_of_type_Int)), "config.json"));
    try
    {
      localbhny.b = Color.parseColor(new JSONObject((String)localObject).getString("textColor"));
      localbhny.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ThreadManagerV2.getUIHandlerV2().post(new PobingDecoder.2(this, localbhny));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localbhny.b = a(this.jdField_a_of_type_Int);
        QLog.e("PobingDecoder", 1, "content:" + (String)localObject, localException);
      }
    }
  }
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      a(true);
      return;
    }
    QLog.e("PobingDecoder", 1, "onCompleted: " + paramString1 + " error:" + paramInt1 + ", " + paramInt2);
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder
 * JD-Core Version:    0.7.0.1
 */