package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

class GamePubAccountHippyFragment$6
  implements RecyclerView.OnListScrollListener
{
  GamePubAccountHippyFragment$6(GamePubAccountHippyFragment paramGamePubAccountHippyFragment, View paramView) {}
  
  public void onDragEnd() {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (((LinearLayoutManager)((HippyListView)this.jdField_a_of_type_AndroidViewView).getLayoutManager()).findFirstVisibleItemPosition() == 0)
    {
      GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).setVisibility(0);
      if (GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment) != null) {
        GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).a();
      }
    }
    else
    {
      GameVideoManager.a().a();
      GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).setVisibility(8);
      if (GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment) != null) {
        GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).b();
      }
    }
    if (GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).getVisibility() == 0)
    {
      paramInt1 = QQGameUIHelper.a((HippyListView)this.jdField_a_of_type_AndroidViewView);
      GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment).scrollTo(0, paramInt1);
    }
  }
  
  public void onScrollEnd() {}
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment.6
 * JD-Core Version:    0.7.0.1
 */