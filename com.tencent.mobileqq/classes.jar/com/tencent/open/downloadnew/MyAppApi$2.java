package com.tencent.open.downloadnew;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.util.GlobalUtil;

final class MyAppApi$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!ControlPolicyUtil.p()) {
        return;
      }
      GlobalUtil.getInstance().setContext(CommonDataAdapter.a().b());
      if (MyAppApi.x())
      {
        MyAppApi.y();
        return;
      }
      MyAppApi.z();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("activity not found error:");
      localStringBuilder.append(localException.getMessage());
      LogUtility.e("TAMST_WAKE", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.2
 * JD-Core Version:    0.7.0.1
 */