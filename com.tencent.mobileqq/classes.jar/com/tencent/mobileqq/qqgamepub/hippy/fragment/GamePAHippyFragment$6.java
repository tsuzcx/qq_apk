package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

class GamePAHippyFragment$6
  implements RecyclerView.OnListScrollListener
{
  GamePAHippyFragment$6(GamePAHippyFragment paramGamePAHippyFragment, View paramView) {}
  
  public void onDragEnd() {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (((LinearLayoutManager)((HippyListView)this.a).getLayoutManager()).findFirstVisibleItemPosition() == 0)
    {
      GamePAHippyFragment.e(this.b).setVisibility(0);
      if (GamePAHippyFragment.f(this.b) != null) {
        GamePAHippyFragment.f(this.b).a();
      }
    }
    else
    {
      GameVideoManager.a().b();
      GamePAHippyFragment.e(this.b).setVisibility(8);
      if (GamePAHippyFragment.f(this.b) != null) {
        GamePAHippyFragment.f(this.b).b();
      }
    }
    if (GamePAHippyFragment.e(this.b).getVisibility() == 0)
    {
      paramInt1 = QQGameUIHelper.a((HippyListView)this.a);
      GamePAHippyFragment.e(this.b).scrollTo(0, paramInt1);
    }
  }
  
  public void onScrollEnd() {}
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.6
 * JD-Core Version:    0.7.0.1
 */