package com.tencent.mobileqq.wink.pick.album.fragment;

import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic;
import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogicDefault;

public class WinkAlbumListFragment
  extends WinkAbstractAlbumListFragment
{
  protected WinkAlbumListLogic a()
  {
    return WinkAlbumListLogicDefault.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.fragment.WinkAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */