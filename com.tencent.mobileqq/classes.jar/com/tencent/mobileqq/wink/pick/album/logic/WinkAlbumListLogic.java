package com.tencent.mobileqq.wink.pick.album.logic;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.pick.album.data.WinkPhotoCommonDataCreator;
import com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class WinkAlbumListLogic<K extends WinkAbstractAlbumListFragment>
{
  public static volatile WinkAlbumListLogic d;
  public WeakReference<K> a;
  protected PhotoCommonBaseData b;
  public AlbumListBaseData c;
  public WinkAlbumListLogic.IalbumListAdapterCallBack e = null;
  
  protected WinkAlbumListLogic(K paramK)
  {
    this.a = new WeakReference(paramK);
    this.b = WinkPhotoCommonDataCreator.a();
    this.b.addHoldNember();
    this.c = new AlbumListBaseData();
    if (QLog.isColorLevel())
    {
      paramK = new StringBuilder();
      paramK.append("AlbumListLogic new，activity = ");
      paramK.append(this.a);
      paramK.append(",PhotoCommonData = ");
      paramK.append(this.b);
      QLog.d("AlbumListActivity", 2, paramK.toString());
    }
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
  
  public void dA_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListLogic new，fragment = ");
      localStringBuilder.append(this.a.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.b);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.b.releaseCommonData();
    d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */