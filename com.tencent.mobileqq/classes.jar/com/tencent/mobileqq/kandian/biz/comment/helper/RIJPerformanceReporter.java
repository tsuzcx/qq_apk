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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  private static final RIJPerformanceReporter a = new RIJPerformanceReporter();
  private static final float[] b = { 1.0F, 1.5F, 3.0F, 6.0F };
  private final int[] c = { 0, 0, 0, 0, 0, 0 };
  private long d;
  private float e;
  private float f = -1.0F;
  private AladdinConfig g;
  
  private RIJPerformanceReporter()
  {
    d();
  }
  
  public static RIJPerformanceReporter a()
  {
    return a;
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
        localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
        if (localQQAppInterface == null) {
          return;
        }
        PublicAccountReportUtils.a(localQQAppInterface, localQQAppInterface.getAccount(), "0X800BACE", "0X800BACE", 0, 0, "", "", paramMap, (String)localObject1, false);
      }
    }
  }
  
  private int b(int paramInt)
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
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!e()) {
      return;
    }
    int j = b.length;
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l = ((float)l + this.c[i] * this.f * b[i]);
      i += 1;
    }
    float f1 = Math.min((float)l * 1.0F / this.e, 1.0F);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("comment_level", String.valueOf(paramInt2));
    localHashMap.put("fluency", String.format("%.2f", new Object[] { Float.valueOf(f1) }));
    if (-1 != paramInt3) {
      localHashMap.put("type", String.valueOf(paramInt3));
    }
    a(localHashMap);
  }
  
  private boolean c()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 16) {
      return false;
    }
    if (this.g == null) {
      this.g = Aladdin.get(456);
    }
    if (this.g.getIntegerFromString("performance_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    this.d = 0L;
    this.e = 0.0F;
    int i = 0;
    while (i < 6)
    {
      this.c[i] = 0;
      i += 1;
    }
  }
  
  private boolean e()
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      if (this.c[i] != 0)
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
  
  public void a(int paramInt)
  {
    a(1, 0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Choreographer.getInstance().removeFrameCallback(this);
    b(paramInt1, paramInt2, paramInt3);
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!c()) {
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
    if (!c()) {
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
  
  public void b()
  {
    if (c())
    {
      if (this.d > 0L) {
        return;
      }
      d();
      if (Float.compare(this.f, 0.0F) <= 0.0F)
      {
        Display localDisplay = ((WindowManager)BaseApplication.getContext().getSystemService("window")).getDefaultDisplay();
        if (localDisplay != null)
        {
          float f1 = localDisplay.getRefreshRate();
          if (f1 >= 0.0F) {
            this.f = (1000.0F / f1);
          }
        }
      }
      if (Float.compare(this.f, 0.0F) <= 0.0F) {
        this.f = 16.666666F;
      }
      this.f = (Math.round(this.f * 100.0F) / 100.0F);
      Choreographer.getInstance().postFrameCallback(this);
    }
  }
  
  public void doFrame(long paramLong)
  {
    long l = this.d;
    if (l != 0L)
    {
      float f1 = (float)(paramLong - l) * 1.0F / 1000000.0F;
      int i = b(Math.max((int)(f1 / this.f) - 1, 0));
      int[] arrayOfInt = this.c;
      arrayOfInt[i] += 1;
      this.e += f1;
    }
    this.d = paramLong;
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter
 * JD-Core Version:    0.7.0.1
 */