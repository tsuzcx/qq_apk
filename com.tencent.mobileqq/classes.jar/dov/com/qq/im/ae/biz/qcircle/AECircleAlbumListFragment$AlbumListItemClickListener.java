package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import dov.com.qq.im.ae.biz.qcircle.adapter.AlbumListAdapter;

class AECircleAlbumListFragment$AlbumListItemClickListener
  implements AdapterView.OnItemClickListener
{
  private AECircleAlbumListFragment$AlbumListItemClickListener(AECircleAlbumListFragment paramAECircleAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name))) {
      QQToast.a(this.a.getActivity(), 2131690059, 0).a();
    }
    boolean bool;
    do
    {
      return;
      bool = this.a.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListLogic.a(paramAdapterView, paramInt, paramView);
    } while (this.a.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment$IAlbumListBack == null);
    this.a.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment$IAlbumListBack.a(paramAdapterView, paramInt, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */