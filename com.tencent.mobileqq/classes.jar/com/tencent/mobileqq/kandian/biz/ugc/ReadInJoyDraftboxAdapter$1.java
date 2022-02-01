package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;

class ReadInJoyDraftboxAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDraftboxAdapter$1(ReadInJoyDraftboxAdapter paramReadInJoyDraftboxAdapter, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ReadInJoyDraftboxAdapter.a(this.b), ReadInJoyDeliverUGCActivity.class);
    paramView.putExtra("readinjoy_draftbox_id", this.a.getId());
    paramView.putExtra("is_from_kan_dian", true);
    paramView.putExtra("support_topic", true);
    if ((ReadInJoyDraftboxAdapter.a(this.b) instanceof BaseActivity))
    {
      if (this.a.type == 0) {
        ((BaseActivity)ReadInJoyDraftboxAdapter.a(this.b)).startActivityForResult(paramView, 1000);
      }
      paramView = new StringBuilder();
      paramView.append(ReadInJoyDraftboxAdapter.a(this.b, this.a));
      paramView.append("");
      PublicAccountReportUtils.a(null, "", "0X80096DF", "0X80096DF", 0, 0, paramView.toString(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.1
 * JD-Core Version:    0.7.0.1
 */