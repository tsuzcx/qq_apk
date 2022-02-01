package com.tencent.mobileqq.kandian.glue.viola;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.utils.FileUtils;

class ViolaAccessHelper$5$2$1
  implements Runnable
{
  ViolaAccessHelper$5$2$1(ViolaAccessHelper.5.2 param2, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), this.a);
      return;
    }
    if (((localObject instanceof String)) && (!this.a.equals(localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.5.2.1
 * JD-Core Version:    0.7.0.1
 */