package com.tencent.richframework.sender.interceptor;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MergeReqInterceptor<T, E extends SenderChain>
  implements ReqInterceptor<T, E>
{
  private static final Map<String, Object> a = new ConcurrentHashMap();
  
  public abstract T a(T paramT1, T paramT2);
  
  public abstract String a(T paramT);
  
  public void a(T paramT, E paramE)
  {
    if ((paramT != null) && (paramE != null)) {
      try
      {
        String str = a(paramT);
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = a.get(str);
          if (localObject == null)
          {
            QLog.d(a(paramT), 1, "preReq is null");
            a.put(str, paramT);
          }
          else
          {
            localObject = a(localObject, paramT);
            if (localObject == null) {
              a.remove(str);
            } else {
              a.put(str, localObject);
            }
          }
          EventControlUtils.a(str, b(paramT), new MergeReqInterceptor.1(this, str, paramE));
        }
        else
        {
          paramE.a(paramT);
        }
        return;
      }
      finally {}
    }
  }
  
  public abstract long b(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.interceptor.MergeReqInterceptor
 * JD-Core Version:    0.7.0.1
 */