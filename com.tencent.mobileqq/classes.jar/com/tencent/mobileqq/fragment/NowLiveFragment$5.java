package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class NowLiveFragment$5
  implements PopupMenuDialog.OnClickActionListener
{
  NowLiveFragment$5(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (DynamicNowManager.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(paramMenuItem)) {
          ((Bundle)localObject).putString("big_brother_source_key", paramMenuItem);
        }
        DynamicNowManager.d((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(paramMenuItem)) {
        localIntent.putExtra("big_brother_source_key", paramMenuItem);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      paramMenuItem = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMenuItem);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    paramMenuItem = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramMenuItem);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131707650));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.5
 * JD-Core Version:    0.7.0.1
 */