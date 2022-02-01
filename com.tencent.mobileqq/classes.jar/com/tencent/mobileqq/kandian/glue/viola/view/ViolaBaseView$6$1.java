package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.utils.FileUtils;

class ViolaBaseView$6$1
  implements Runnable
{
  ViolaBaseView$6$1(ViolaBaseView.6 param6) {}
  
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
      FileUtils.writeObject(((StringBuilder)localObject).toString(), ViolaBaseView.g(this.a.c));
      return;
    }
    if (((localObject instanceof String)) && (!ViolaBaseView.g(this.a.c).equals(localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), ViolaBaseView.g(this.a.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.6.1
 * JD-Core Version:    0.7.0.1
 */