package com.tencent.mobileqq.kandian.glue.viola;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;

final class ViolaAccessHelper$1
  implements Runnable
{
  public void run()
  {
    ViolaAccessHelper.j(Integer.toString(3256));
    ViolaAccessHelper.j(ViolaBizUtils.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viola_cache_file_viola_qq_page_data_new_main_js_");
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localObject = FileUtils.readObject(localStringBuilder.toString());
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        break label77;
      }
    }
    localObject = null;
    label77:
    ViolaAccessHelper.c(null, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.1
 * JD-Core Version:    0.7.0.1
 */