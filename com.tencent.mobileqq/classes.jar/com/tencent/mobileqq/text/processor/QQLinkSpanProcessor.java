package com.tencent.mobileqq.text.processor;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.LinkSpanEntity;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQLinkSpanProcessor
  implements ISpanProcessor
{
  public static String a;
  
  public void doGrab(GrabParams paramGrabParams, ISpanCallback paramISpanCallback)
  {
    if (paramGrabParams != null)
    {
      if (paramISpanCallback == null) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (TextUtils.isEmpty(a))
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null) {
          a = ((AppRuntime)localObject1).getAccount();
        }
        localObject2 = a;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        a = (String)localObject1;
      }
      if (paramGrabParams.text != null)
      {
        if (a.length() > 3)
        {
          localObject1 = a;
          if (((String)localObject1).charAt(((String)localObject1).length() - 3) == '0')
          {
            localObject1 = a;
            if (((String)localObject1).charAt(((String)localObject1).length() - 2) == '1')
            {
              localObject1 = new HashMap();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramGrabParams.text.length());
              ((StringBuilder)localObject2).append("");
              ((HashMap)localObject1).put("length", ((StringBuilder)localObject2).toString());
              localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
              boolean bool;
              if (paramGrabParams.text.length() < 1000) {
                bool = true;
              } else {
                bool = false;
              }
              ((StatisticCollector)localObject2).collectPerformance(null, "qq_url_length_report", bool, 0L, 0L, (HashMap)localObject1, null);
            }
          }
        }
        if (paramGrabParams.text.length() < 1000)
        {
          localObject2 = QQTextParseLinkUtil.a(paramGrabParams.text);
          localObject1 = null;
          if ((paramGrabParams.message instanceof MessageRecord)) {
            localObject1 = (MessageRecord)paramGrabParams.message;
          }
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            paramGrabParams = ((List)localObject2).iterator();
            while (paramGrabParams.hasNext())
            {
              localObject2 = (LinkSpanEntity)paramGrabParams.next();
              paramISpanCallback.addSpan(new LinkSpan(((LinkSpanEntity)localObject2).a, a, (MessageRecord)localObject1), ((LinkSpanEntity)localObject2).b, ((LinkSpanEntity)localObject2).c, 33);
            }
          }
        }
      }
    }
  }
  
  public int doPlain(Object paramObject, int paramInt1, int paramInt2, int paramInt3, StringBuffer paramStringBuffer)
  {
    return 0;
  }
  
  public boolean matchGrab(int paramInt)
  {
    return (paramInt & 0x8) == 8;
  }
  
  public boolean matchPlain(Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQLinkSpanProcessor
 * JD-Core Version:    0.7.0.1
 */