package com.tencent.mobileqq.newnearby.impl;

import android.content.Intent;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class NearbyMsgboxImpl$1
  implements TabLayoutCompat.OnTabSelectedListener
{
  NearbyMsgboxImpl$1(NearbyMsgboxImpl paramNearbyMsgboxImpl, int paramInt1, boolean paramBoolean, int paramInt2, BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    if (paramTab == null) {
      return;
    }
    int i = ((Integer)paramTab.a()).intValue();
    if (i == this.a) {
      return;
    }
    paramTab = new Intent();
    paramTab.putExtra("curIndex", i);
    if (this.b) {
      i = this.c;
    } else {
      i = 0;
    }
    paramTab.putExtra("unReadMsgNum", i);
    this.d.setResult(-1, paramTab);
    this.d.finish();
    this.d.overridePendingTransition(0, 0);
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyMsgboxImpl.1
 * JD-Core Version:    0.7.0.1
 */