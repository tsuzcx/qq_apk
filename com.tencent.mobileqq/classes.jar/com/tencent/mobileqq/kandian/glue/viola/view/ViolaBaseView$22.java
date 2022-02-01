package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.viola.utils.ViolaUtils;

class ViolaBaseView$22
  implements Runnable
{
  ViolaBaseView$22(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ViolaBaseView.b(this.this$0))) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_");
    ((StringBuilder)localObject).append(ViolaUtils.getPageName(this.this$0.a));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_");
      ((StringBuilder)localObject).append(ViolaUtils.getPageName(this.this$0.a));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), ViolaBaseView.b(this.this$0));
    }
    else if (((localObject instanceof String)) && (!localObject.equals(ViolaBaseView.b(this.this$0))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_");
      ((StringBuilder)localObject).append(ViolaUtils.getPageName(this.this$0.a));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
      FileUtils.writeObject(((StringBuilder)localObject).toString(), ViolaBaseView.b(this.this$0));
    }
    ViolaBaseView.c(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.22
 * JD-Core Version:    0.7.0.1
 */