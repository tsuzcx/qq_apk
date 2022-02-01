package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class NowLiveFragment$5
  implements PopupMenuDialog.OnClickActionListener
{
  NowLiveFragment$5(NowLiveFragment paramNowLiveFragment) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMenuItem = new StringBuilder();
        paramMenuItem.append("");
        paramMenuItem.append(this.a.e);
        paramMenuItem = paramMenuItem.toString();
        localObject = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramMenuItem);
        ((Intent)localObject).putExtra("reqType", 1);
        ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131707675));
        this.a.startActivity((Intent)localObject);
        return;
      }
      paramMenuItem = new StringBuilder();
      paramMenuItem.append("");
      paramMenuItem.append(this.a.d);
      paramMenuItem = paramMenuItem.toString();
      localObject = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMenuItem);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    paramMenuItem = this.a.getBaseActivity().getIntent().getStringExtra("big_brother_source_key");
    if (((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).isAppInstalled())
    {
      localObject = new Bundle();
      if (!TextUtils.isEmpty(paramMenuItem)) {
        ((Bundle)localObject).putString("big_brother_source_key", paramMenuItem);
      }
      ((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).beginLive((Bundle)localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.a.c);
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    if (!TextUtils.isEmpty(paramMenuItem)) {
      localIntent.putExtra("big_brother_source_key", paramMenuItem);
    }
    localIntent.putExtra("reqType", 1);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.5
 * JD-Core Version:    0.7.0.1
 */