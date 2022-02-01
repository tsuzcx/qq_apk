package dov.com.qq.im.ae.album.fragment;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import dov.com.qq.im.ae.album.adapter.AEAlbumListAdapter;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogic;

class AEAbstractAlbumListFragment$AlbumListItemClickListener
  implements AdapterView.OnItemClickListener
{
  private AEAbstractAlbumListFragment$AlbumListItemClickListener(AEAbstractAlbumListFragment paramAEAbstractAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_DovComQqImAeAlbumAdapterAEAlbumListAdapter.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name))) {
      QQToast.a(this.a.getActivity(), 2131690059, 0).a();
    }
    boolean bool;
    do
    {
      return;
      bool = this.a.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic.a(paramAdapterView, paramInt, paramView);
    } while (this.a.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment$IAlbumListBack == null);
    this.a.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment$IAlbumListBack.a(paramAdapterView, paramInt, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */