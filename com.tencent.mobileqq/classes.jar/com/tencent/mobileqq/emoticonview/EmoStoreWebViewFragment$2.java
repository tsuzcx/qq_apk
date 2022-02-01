package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoStoreWebViewFragment$2
  implements View.OnClickListener
{
  EmoStoreWebViewFragment$2(EmoStoreWebViewFragment paramEmoStoreWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0.getQBaseActivity();
    if (localObject != null)
    {
      if (EmoStoreWebViewFragment.access$100(this.this$0)) {
        ReportController.a(null, "dc00898", "", "", "0X800B8C8", "0X800B8C8", 0, 0, "", "", "", "");
      }
      Intent localIntent = ((Activity)localObject).getIntent();
      localObject = new ActivityURIRequest((Context)localObject, "/base/activity/EmosmActivity");
      ((ActivityURIRequest)localObject).extra().putInt("key_emojimall_detail_chat_type", localIntent.getIntExtra("key_emojimall_detail_chat_type", -1));
      ((ActivityURIRequest)localObject).extra().putString("key_emojimall_detail_chat_uin", localIntent.getStringExtra("key_emojimall_detail_chat_uin"));
      ((ActivityURIRequest)localObject).extra().putInt("emojimall_src", localIntent.getIntExtra("emojimall_src", 1));
      QRoute.startUri((URIRequest)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.2
 * JD-Core Version:    0.7.0.1
 */