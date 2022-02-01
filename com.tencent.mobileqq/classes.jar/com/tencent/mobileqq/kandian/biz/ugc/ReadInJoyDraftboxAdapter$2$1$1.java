package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ReadInJoyDraftboxAdapter$2$1$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1$1(ReadInJoyDraftboxAdapter.2.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ReadInJoyDraftboxAdapter.a(this.b.a.c);
    int i;
    if (this.a) {
      i = 2131910453;
    } else {
      i = 2131910324;
    }
    QQToast.makeText((Context)localObject, 2, HardCodeUtil.a(i), 1).show();
    if (this.a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyDraftboxAdapter.a(this.b.a.c, this.b.a.a));
      ((StringBuilder)localObject).append("");
      PublicAccountReportUtils.a(null, "", "0X80096E0", "0X80096E0", 0, 0, ((StringBuilder)localObject).toString(), "", "", "", false);
      ReadInJoyDraftboxAdapter.c(this.b.a.c).remove(this.b.a.b);
      this.b.a.c.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */