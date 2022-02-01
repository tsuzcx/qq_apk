package com.tencent.mobileqq.wink.pick.album.logic;

import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.wink.pick.album.adapter.WinkAlbumListAdapter;
import com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class WinkAlbumListLogicBase$3
  implements Runnable
{
  WinkAlbumListLogicBase$3(WinkAlbumListLogicBase paramWinkAlbumListLogicBase, WinkAlbumListAdapter paramWinkAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    Object localObject = this.a.b(((WinkAbstractAlbumListFragment)this.this$0.a.get()).getActivity(), 2147483647, -1, this.b, -1, false, null);
    this.a.c((QQAlbumInfo)localObject);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    localObject = this.b;
    if ((localObject != null) && (((MediaFileFilter)localObject).showVideo()))
    {
      localObject = this.a.a(((WinkAbstractAlbumListFragment)this.this$0.a.get()).getActivity());
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
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */