package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoStoreWebViewFragment$1
  implements View.OnClickListener
{
  EmoStoreWebViewFragment$1(EmoStoreWebViewFragment paramEmoStoreWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (EmoStoreWebViewFragment.access$000(this.this$0)) {
        ReportController.a(null, "dc00898", "", "", "0X800B8C8", "0X800B8C8", 0, 0, "", "", "", "");
      }
      Intent localIntent1 = localFragmentActivity.getIntent();
      Intent localIntent2 = new Intent(localFragmentActivity, EmosmActivity.class);
      localIntent2.putExtra("key_emojimall_detail_chat_type", localIntent1.getIntExtra("key_emojimall_detail_chat_type", -1));
      localIntent2.putExtra("key_emojimall_detail_chat_uin", localIntent1.getStringExtra("key_emojimall_detail_chat_uin"));
      localIntent2.putExtra("emojimall_src", localIntent1.getIntExtra("emojimall_src", 1));
      localFragmentActivity.startActivity(localIntent2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */