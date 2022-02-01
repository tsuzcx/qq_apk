package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class b$1
  implements a
{
  b$1(b paramb) {}
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = b.x();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError => id:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" params:");
    localStringBuilder.append(paramString3);
    TXCLog.e((String)localObject, localStringBuilder.toString());
    if (b.a(this.a) != null)
    {
      paramString1 = new Bundle();
      paramString1.putInt("EVT_ID", paramInt);
      paramString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        if (paramString3 == null) {
          paramString3 = "";
        }
        ((StringBuilder)localObject).append(paramString3);
        paramString1.putCharSequence("EVT_MSG", ((StringBuilder)localObject).toString());
      }
      this.a.onNotifyEvent(paramInt, paramString1);
    }
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = b.x();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent => id:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" params:");
    localStringBuilder.append(paramString3);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    if (b.a(this.a) != null)
    {
      paramString1 = new Bundle();
      paramString1.putInt("EVT_ID", paramInt);
      paramString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        if (paramString3 == null) {
          paramString3 = "";
        }
        ((StringBuilder)localObject).append(paramString3);
        paramString1.putCharSequence("EVT_MSG", ((StringBuilder)localObject).toString());
      }
      this.a.onNotifyEvent(paramInt, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.1
 * JD-Core Version:    0.7.0.1
 */