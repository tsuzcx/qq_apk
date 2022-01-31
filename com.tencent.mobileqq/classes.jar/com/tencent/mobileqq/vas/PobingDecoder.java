package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import aufy;
import bdhb;
import bdtm;
import bdts;
import bdwn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PobingDecoder
  implements bdts, Runnable
{
  private static final HashMap<Integer, Integer> b = new PobingDecoder.1();
  int jdField_a_of_type_Int;
  WeakReference<aufy<bdtm>> jdField_a_of_type_JavaLangRefWeakReference;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public PobingDecoder(int paramInt, HashMap<Integer, String> paramHashMap, aufy<bdtm> paramaufy)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaufy);
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
    bdtm localbdtm = new bdtm();
    bdwn localbdwn = bdwn.a;
    if (!localbdwn.a(((QQAppInterface)localObject).getApp(), this.jdField_a_of_type_Int))
    {
      if (!paramBoolean)
      {
        localbdwn.download((QQAppInterface)localObject, this.jdField_a_of_type_Int, this, false);
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
      Bitmap localBitmap = localbdwn.a(((QQAppInterface)localObject).getApp(), this.jdField_a_of_type_Int, (String)localEntry.getValue());
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
      localbdtm.jdField_a_of_type_JavaUtilHashMap.put(localEntry.getKey(), localBitmap);
    }
    label197:
    localObject = bdhb.a(new File(localbdwn.getDir(((QQAppInterface)localObject).getApp(), localbdwn.getScid(this.jdField_a_of_type_Int)), "config.json"));
    try
    {
      localbdtm.b = Color.parseColor(new JSONObject((String)localObject).getString("textColor"));
      localbdtm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ThreadManagerV2.getUIHandlerV2().post(new PobingDecoder.2(this, localbdtm));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localbdtm.b = a(this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder
 * JD-Core Version:    0.7.0.1
 */