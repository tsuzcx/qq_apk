package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.utils.SharedPreUtils;

class RIJDataFetchManager$6
  implements Runnable
{
  RIJDataFetchManager$6(RIJDataFetchManager paramRIJDataFetchManager) {}
  
  public void run()
  {
    boolean bool = this.this$0.h();
    int m = 2;
    Object localObject2 = "0";
    int k = 0;
    Object localObject1;
    int j;
    int i;
    if (!bool)
    {
      if ((RIJDataFetchManager.a(this.this$0).q() instanceof BaseActivity)) {
        bool = SharedPreUtils.bz(RIJDataFetchManager.a(this.this$0).q(), ((BaseActivity)RIJDataFetchManager.a(this.this$0).q()).getCurrentAccountUin());
      } else {
        bool = false;
      }
      if ((RIJDataFetchManager.a(this.this$0).q() instanceof BaseActivity)) {
        localObject1 = ((ReadInJoySkinManager)((BaseActivity)RIJDataFetchManager.a(this.this$0).q()).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b();
      } else {
        localObject1 = "0";
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
      {
        if (bool) {
          j = 1;
        } else {
          j = 2;
        }
        i = 1;
      }
      else
      {
        j = 0;
        i = 0;
        localObject1 = localObject2;
      }
      if ((RIJDataFetchManager.a(this.this$0).q() instanceof BaseActivity))
      {
        localObject2 = (ReadInJoyRefreshManager)((BaseActivity)RIJDataFetchManager.a(this.this$0).q()).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((((ReadInJoyRefreshManager)localObject2).d() == 1) && (((ReadInJoyRefreshManager)localObject2).e()))
        {
          localObject1 = ((ReadInJoyRefreshManager)localObject2).c();
          i = m;
          j = k;
          break label261;
        }
      }
    }
    else
    {
      i = 0;
      j = k;
      localObject1 = localObject2;
    }
    label261:
    RIJFrameworkReportManager.a(RIJDataFetchManager.a(this.this$0).r(), j, (String)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.6
 * JD-Core Version:    0.7.0.1
 */