package com.tencent.mobileqq.gamecenter.hippy;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.util.QQGameUIHelper;
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
    if (((LinearLayoutManager)((HippyListView)this.jdField_a_of_type_AndroidViewView).getLayoutManager()).findFirstVisibleItemPosition() == 0) {
      GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountHippyFragment).setVisibility(0);
    }
    for (;;)
    {
      if (GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountHippyFragment).getVisibility() == 0)
      {
        paramInt1 = QQGameUIHelper.a((HippyListView)this.jdField_a_of_type_AndroidViewView);
        GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountHippyFragment).scrollTo(0, paramInt1);
      }
      return;
      GameVideoManager.a().a();
      GamePubAccountHippyFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountHippyFragment).setVisibility(8);
    }
  }
  
  public void onScrollEnd() {}
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.6
 * JD-Core Version:    0.7.0.1
 */