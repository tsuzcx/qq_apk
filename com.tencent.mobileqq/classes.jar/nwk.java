import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NormalCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverAdapter;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverAdapter.OnHolderItemClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.ArrayList;
import java.util.List;

public class nwk
  implements StoryDiscoverAdapter.OnHolderItemClickListener
{
  public nwk(StoryDiscoverAdapter paramStoryDiscoverAdapter) {}
  
  public void a(View paramView, int paramInt)
  {
    Object localObject2 = (CardItem)StoryDiscoverAdapter.a(this.a).get(paramInt);
    if (((CardItem)localObject2).cardType == 4) {
      if (((CardItem)localObject2).gatherCardInfo.b() == 0) {
        StoryDiscoverActivity.a((Activity)paramView.getContext(), ((CardItem)localObject2).gatherCardInfo.a(), ((CardItem)localObject2).gatherCardInfo.a(), (CardItem)localObject2, "1", StoryDiscoverAdapter.a(this.a));
      }
    }
    label124:
    Object localObject1;
    for (;;)
    {
      if (StoryDiscoverAdapter.b(this.a) == 0)
      {
        paramView = null;
        switch (((CardItem)localObject2).cardType)
        {
        default: 
          StoryReportor.a("content_flow", "clk_card", 0, 0, new String[] { paramView });
          if (((CardItem)localObject2).cardType == 4)
          {
            if (((CardItem)localObject2).gatherCardInfo != null)
            {
              paramView = String.valueOf(((CardItem)localObject2).gatherCardInfo.a());
              label170:
              if (((CardItem)localObject2).gatherCardInfo == null) {
                break label376;
              }
              localObject1 = ((CardItem)localObject2).gatherCardInfo.a();
              label188:
              StoryReportor.a("content_flow", "clk_hot", 0, 0, new String[] { paramView, "", localObject1 });
            }
          }
          else
          {
            label215:
            return;
            localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", ((CardItem)localObject2).gatherCardInfo.d());
            paramView.getContext().startActivity((Intent)localObject1);
            continue;
            paramView = ((CardItem)localObject2).getCardVideoInfo();
            if (paramView == null) {
              continue;
            }
            paramInt = StoryDiscoverAdapter.a(this.a).get(paramInt, -1);
            if (paramInt >= 0) {
              break label525;
            }
            paramInt = StoryDiscoverAdapter.a(this.a).indexOf(paramView);
          }
          break;
        }
      }
    }
    label518:
    label525:
    for (;;)
    {
      if (StoryDiscoverAdapter.b(this.a) == 0) {}
      for (int i = 63;; i = 64)
      {
        StoryPlayVideoActivity.a((Activity)StoryDiscoverAdapter.a(this.a).getContext(), null, StoryDiscoverAdapter.a(this.a), paramInt, i);
        break;
      }
      paramView = "1";
      break label124;
      paramView = "2";
      break label124;
      paramView = "3";
      break label124;
      paramView = "4";
      break label124;
      paramView = "";
      break label170;
      label376:
      localObject1 = "";
      break label188;
      if (StoryDiscoverAdapter.b(this.a) != 2) {
        break label215;
      }
      if (StoryDiscoverAdapter.a(this.a) != null)
      {
        paramView = String.valueOf(StoryDiscoverAdapter.a(this.a).mTopicId);
        if (StoryDiscoverAdapter.a(this.a) == null) {
          break label511;
        }
        localObject1 = StoryDiscoverAdapter.a(this.a).mSubjectName;
        label440:
        if ((((CardItem)localObject2).normalCardInfo == null) || (((CardItem)localObject2).normalCardInfo.a() == null)) {
          break label518;
        }
      }
      for (localObject2 = ((CardItem)localObject2).normalCardInfo.a().a();; localObject2 = "")
      {
        StoryReportor.a("content_flow", "clk_hot_page", 0, 0, new String[] { paramView, "", localObject1, localObject2 });
        return;
        paramView = "";
        break;
        label511:
        localObject1 = "";
        break label440;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwk
 * JD-Core Version:    0.7.0.1
 */