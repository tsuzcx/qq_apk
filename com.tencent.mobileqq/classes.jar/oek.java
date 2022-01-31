import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class oek
  implements AbsListView.OnScrollListener
{
  public oek(MystoryListView paramMystoryListView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((MystoryListView.a(this.a) != 1) && (paramAbsListView.getCount() != 0)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (MystoryListView.a(this.a) != null) {
        MystoryListView.a(this.a).a(paramAbsListView, paramInt);
      }
      return;
      MystoryListView.a(this.a, false);
      continue;
      View localView = paramAbsListView.getChildAt(0);
      MystoryListView.a(this.a, paramAbsListView.getFirstVisiblePosition());
      if (localView != null)
      {
        MystoryListView.b(this.a, localView.getTop());
        MystoryListView.c(this.a, localView.getBottom());
        MystoryListView.d(this.a, localView.getHeight());
      }
      MystoryListView.a(this.a, true);
      MystoryListView.e(this.a, 0);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    int k;
    int m;
    int i;
    if ((this.a.jdField_a_of_type_AndroidAppActivity != null) && (MystoryListView.a(this.a) != 1) && (paramAbsListView.getCount() != 0))
    {
      if (-MystoryListView.b(this.a) > UIUtils.b(this.a.jdField_a_of_type_AndroidAppActivity) * 3) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(true);
      }
      if ((paramInt3 == 0) || (!MystoryListView.a(this.a))) {
        return;
      }
      View localView = paramAbsListView.getChildAt(0);
      j = localView.getTop();
      k = localView.getBottom();
      m = localView.getHeight();
      if (paramInt1 <= MystoryListView.c(this.a)) {
        break label257;
      }
      MystoryListView.b(this.a, MystoryListView.d(this.a) + MystoryListView.e(this.a));
      i = j - MystoryListView.d(this.a);
    }
    for (;;)
    {
      MystoryListView.e(this.a, MystoryListView.g(this.a) + i);
      MystoryListView.f(this.a, i + MystoryListView.b(this.a));
      MystoryListView.b(this.a, j);
      MystoryListView.c(this.a, k);
      MystoryListView.d(this.a, m);
      MystoryListView.a(this.a, paramInt1);
      if (MystoryListView.a(this.a) == null) {
        break;
      }
      MystoryListView.a(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label257:
      if (paramInt1 < MystoryListView.c(this.a))
      {
        MystoryListView.c(this.a, MystoryListView.f(this.a) - MystoryListView.e(this.a));
        i = k - MystoryListView.f(this.a);
      }
      else
      {
        i = k - MystoryListView.f(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */