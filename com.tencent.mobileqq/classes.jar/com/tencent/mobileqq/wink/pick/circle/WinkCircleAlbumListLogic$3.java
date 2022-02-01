package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.wink.pick.circle.adapter.AlbumListAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class WinkCircleAlbumListLogic$3
  implements Runnable
{
  WinkCircleAlbumListLogic$3(WinkCircleAlbumListLogic paramWinkCircleAlbumListLogic, AlbumListAdapter paramAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    Object localObject = AlbumListAdapter.b(((WinkCircleAlbumListFragment)this.this$0.a.get()).getActivity());
    this.a.c((QQAlbumInfo)localObject);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    localObject = this.b;
    if ((localObject != null) && (((MediaFileFilter)localObject).showVideo()))
    {
      localObject = this.a.a(((WinkCircleAlbumListFragment)this.this$0.a.get()).getActivity());
      this.a.e((QQAlbumInfo)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=");
        localStringBuilder.append(((QQAlbumInfo)localObject).mMediaFileCount);
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
    }
    LogTag.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListLogic.3
 * JD-Core Version:    0.7.0.1
 */