package dov.com.qq.im.ae.album.fragment;

import dov.com.qq.im.ae.album.logic.AEAlbumListLogic;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicDefault;

public class AEAlbumListFragment
  extends AEAbstractAlbumListFragment
{
  protected AEAlbumListLogic a()
  {
    return AEAlbumListLogicDefault.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */