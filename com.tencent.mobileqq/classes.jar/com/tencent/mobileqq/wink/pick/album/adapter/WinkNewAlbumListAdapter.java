package com.tencent.mobileqq.wink.pick.album.adapter;

import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.pick.album.fragment.WinkAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class WinkNewAlbumListAdapter
  extends WinkAlbumListAdapter
{
  public boolean o;
  public long p;
  
  public WinkNewAlbumListAdapter(WinkAlbumListFragment paramWinkAlbumListFragment)
  {
    super(paramWinkAlbumListFragment);
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo)
  {
    if (!this.g.isEmpty())
    {
      QQAlbumInfo localQQAlbumInfo = (QQAlbumInfo)this.g.get(0);
      if (!localQQAlbumInfo.id.equals("$RecentAlbumId")) {
        if (localQQAlbumInfo.id.equals("qzone_album")) {
          this.g.add(1, paramQQAlbumInfo);
        } else {
          this.g.add(0, paramQQAlbumInfo);
        }
      }
    }
    if ((this.o) && (this.p > 0L) && (b()))
    {
      paramQQAlbumInfo = new QQAlbumInfo();
      paramQQAlbumInfo.id = "qzone_album";
      paramQQAlbumInfo.name = "空间相册";
      paramQQAlbumInfo.mMediaFileCount = ((int)this.p);
      this.g.add(0, paramQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
      }
    }
  }
  
  boolean b()
  {
    if (this.g.size() != 0)
    {
      int i = 0;
      while (i < this.g.size())
      {
        if (((QQAlbumInfo)this.g.get(i)).id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.adapter.WinkNewAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */