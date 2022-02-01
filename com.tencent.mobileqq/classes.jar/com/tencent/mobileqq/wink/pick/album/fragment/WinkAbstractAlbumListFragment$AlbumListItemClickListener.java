package com.tencent.mobileqq.wink.pick.album.fragment;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.pick.album.adapter.WinkAlbumListAdapter;
import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class WinkAbstractAlbumListFragment$AlbumListItemClickListener
  implements AdapterView.OnItemClickListener
{
  private WinkAbstractAlbumListFragment$AlbumListItemClickListener(WinkAbstractAlbumListFragment paramWinkAbstractAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.e.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView != null) && (paramAdapterView.mMediaFileCount > 0) && (!TextUtils.isEmpty(paramAdapterView.name)))
    {
      boolean bool = this.a.b.a(paramAdapterView, paramInt, paramView);
      if (this.a.a != null) {
        this.a.a.a(paramAdapterView, paramInt, bool);
      }
      return;
    }
    QQToast.makeText(this.a.getActivity(), 2131886616, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */