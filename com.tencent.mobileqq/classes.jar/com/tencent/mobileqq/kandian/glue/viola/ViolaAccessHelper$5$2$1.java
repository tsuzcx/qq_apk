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
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (((localObject instanceof String)) && (!this.jdField_a_of_type_JavaLangString.equals(localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.5.2.1
 * JD-Core Version:    0.7.0.1
 */