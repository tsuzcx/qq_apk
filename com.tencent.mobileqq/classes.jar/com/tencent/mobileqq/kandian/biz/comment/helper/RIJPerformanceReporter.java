package com.tencent.mobileqq.kandian.biz.comment.helper;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@RequiresApi(api=16)
public class RIJPerformanceReporter
  implements Choreographer.FrameCallback
{
  private static final RIJPerformanceReporter jdField_a_of_type_ComTencentMobileqqKandianBizCommentHelperRIJPerformanceReporter = new RIJPerformanceReporter();
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.5F, 3.0F, 6.0F };
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0, 0, 0, 0 };
  private float b = -1.0F;
  
  private RIJPerformanceReporter()
  {
    b();
  }
  
  private int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  public static RIJPerformanceReporter a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizCommentHelperRIJPerformanceReporter;
  }
  
  private void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject1 = new JSONObject();
      try
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (Map.Entry)localIterator.next();
          ((JSONObject)localObject1).put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
        QQAppInterface localQQAppInterface;
        return;
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("json create fail: ");
        ((StringBuilder)localObject2).append(localJSONException.toString());
        QLog.d("RIJPerformanceReporter", 1, ((StringBuilder)localObject2).toString());
        paramMap = (String)paramMap.get("scene");
        localObject1 = ((JSONObject)localObject1).toString();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
        if (localQQAppInterface == null) {
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(localQQAppInterface, localQQAppInterface.getAccount(), "0X800BACE", "0X800BACE", 0, 0, "", "", paramMap, (String)localObject1, false);
      }
    }
  }
  
  private boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 16) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAladdinConfigAladdinConfig == null) {
      this.jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = Aladdin.get(456);
    }
    if (this.jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("performance_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    int i = 0;
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!b()) {
      return;
    }
    int j = jdField_a_of_type_ArrayOfFloat.length;
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l = ((float)l + this.jdField_a_of_type_ArrayOfInt[i] * this.b * jdField_a_of_type_ArrayOfFloat[i]);
      i += 1;
    }
    float f = Math.min((float)l * 1.0F / this.jdField_a_of_type_Float, 1.0F);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("comment_level", String.valueOf(paramInt2));
    localHashMap.put("fluency", String.format("%.2f", new Object[] { Float.valueOf(f) }));
    if (-1 != paramInt3) {
      localHashMap.put("type", String.valueOf(paramInt3));
    }
    a(localHashMap);
  }
  
  private boolean b()
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] != 0)
      {
        i = j;
        break label33;
      }
      i += 1;
    }
    i = 1;
    label33:
    return i ^ 0x1;
  }
  
  public void a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Long > 0L) {
        return;
      }
      b();
      if (Float.compare(this.b, 0.0F) <= 0.0F)
      {
        float f = ((WindowManager)BaseApplication.getContext().getSystemService("window")).getDefaultDisplay().getRefreshRate();
        if (f >= 0.0F) {
          this.b = (1000.0F / f);
        }
      }
      if (Float.compare(this.b, 0.0F) <= 0.0F) {
        this.b = 16.666666F;
      }
      this.b = (Math.round(this.b * 100.0F) / 100.0F);
      Choreographer.getInstance().postFrameCallback(this);
    }
  }
  
  public void a(int paramInt)
  {
    a(1, 0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Choreographer.getInstance().removeFrameCallback(this);
    b(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!a()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(2));
    localHashMap.put("comment_level", String.valueOf(paramInt1));
    localHashMap.put("error_code", String.valueOf(paramInt3));
    localHashMap.put("type", String.valueOf(paramInt2));
    if ((paramBundle != null) && (paramBundle.containsKey("send_time")))
    {
      long l = paramBundle.getLong("send_time");
      localHashMap.put("duration", String.valueOf(SystemClock.elapsedRealtime() - l));
    }
    a(localHashMap);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (!a()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(3));
    localHashMap.put("comment_level", String.valueOf(paramInt1));
    localHashMap.put("error_code", String.valueOf(paramInt2));
    if ((paramLong > 0L) && (paramLong < 20000L)) {
      localHashMap.put("duration", String.valueOf(paramLong));
    }
    a(localHashMap);
  }
  
  public void doFrame(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (l != 0L)
    {
      float f = (float)(paramLong - l) * 1.0F / 1000000.0F;
      int i = a(Math.max((int)(f / this.b) - 1, 0));
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] += 1;
      this.jdField_a_of_type_Float += f;
    }
    this.jdField_a_of_type_Long = paramLong;
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter
 * JD-Core Version:    0.7.0.1
 */