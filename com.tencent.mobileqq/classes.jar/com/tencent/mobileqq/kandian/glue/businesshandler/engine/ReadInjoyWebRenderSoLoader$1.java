package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.biz.viola.constants.IViolaBizLibHandlerConst;
import com.tencent.mobileqq.kandian.biz.viola.constants.IViolaLibHandlerConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReadInjoyWebRenderSoLoader$1
  implements Runnable
{
  ReadInjoyWebRenderSoLoader$1(LoadLibCallback paramLoadLibCallback) {}
  
  public void run()
  {
    Object localObject = ReadInjoyWebRenderSoLoader.b();
    try
    {
      String str = HttpUtil.openUrl(BaseApplication.context, (String)localObject, "GET", null, null);
      bool = QLog.isColorLevel();
      if (bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("open :");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", result: ");
        localStringBuilder.append(str);
        QLog.d("viola.ReadInjoyWebRenderSoLoader", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(str))
      {
        ReadInjoyWebRenderSoLoader.c();
        break label290;
      }
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).optInt("reJSC", 0) != 1) {
        break label312;
      }
      j = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        label290:
        continue;
        int j = 0;
        continue;
        int i = 0;
        if (j != 0)
        {
          j = 0;
          bool = true;
          continue;
          bool = false;
          j += 1;
          continue;
          bool = false;
          i += 1;
        }
      }
    }
    if (((JSONObject)localObject).optInt("reBiz", 0) == 1)
    {
      i = 1;
      break label319;
      if (j < IViolaLibHandlerConst.a.length)
      {
        if ((!bool) || (!ReadInjoyWebRenderSoLoader.b(IViolaLibHandlerConst.a[j]))) {
          break label330;
        }
        bool = true;
        break label332;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkReinstallSoDel delJSC : ");
        ((StringBuilder)localObject).append(bool);
        QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, ((StringBuilder)localObject).toString());
      }
      ReadInjoyWebRenderSoLoader.c();
      if (i != 0)
      {
        i = 0;
        bool = true;
        if (i < IViolaBizLibHandlerConst.a.length)
        {
          if ((!bool) || (!ReadInjoyWebRenderSoLoader.b(IViolaBizLibHandlerConst.a[i]))) {
            break label339;
          }
          bool = true;
          break label341;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkReinstallSoDel delBiz : ");
          ((StringBuilder)localObject).append(bool);
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, ((StringBuilder)localObject).toString());
        }
      }
      ReadInjoyWebRenderSoLoader.d();
      ReadInJoyWebRenderEngine.a("viola.ReadInjoyWebRenderSoLoader", this.a);
      return;
      ReadInjoyWebRenderSoLoader.c();
      ReadInjoyWebRenderSoLoader.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader.1
 * JD-Core Version:    0.7.0.1
 */