package com.tencent.mobileqq.mini.mainpage;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;

class MainPageFragment$1
  implements View.OnLongClickListener
{
  MainPageFragment$1(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    MiniCacheFreeManager.freeCache(MainPageFragment.getUin(), MainPageFragment.access$000(this.this$0));
    this.this$0.getBaseActivity().finish();
    Toast.makeText(paramView.getContext(), HardCodeUtil.a(2131904342), 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.1
 * JD-Core Version:    0.7.0.1
 */