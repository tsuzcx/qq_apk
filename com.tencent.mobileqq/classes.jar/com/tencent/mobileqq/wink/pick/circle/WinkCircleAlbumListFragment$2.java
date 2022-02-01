package com.tencent.mobileqq.wink.pick.circle;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class WinkCircleAlbumListFragment$2
  implements MessageQueue.IdleHandler
{
  WinkCircleAlbumListFragment$2(WinkCircleAlbumListFragment paramWinkCircleAlbumListFragment, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load Scroll Position,index:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" top:");
      localStringBuilder.append(this.b);
      QLog.d("AlbumListActivity", 2, localStringBuilder.toString());
    }
    this.c.f.setSelectionFromTop(this.a, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListFragment.2
 * JD-Core Version:    0.7.0.1
 */