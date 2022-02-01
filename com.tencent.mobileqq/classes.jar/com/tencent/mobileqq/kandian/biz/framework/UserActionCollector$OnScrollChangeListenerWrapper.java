package com.tencent.mobileqq.kandian.biz.framework;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserActionCollector$OnScrollChangeListenerWrapper
  implements AbsListView.OnScrollListener
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public boolean d = false;
  public ArrayList<UserActionCollector.FeedScrollStateInfo> e = new ArrayList();
  public HashMap<String, Integer> f = new HashMap();
  private int h;
  
  public UserActionCollector$OnScrollChangeListenerWrapper(UserActionCollector paramUserActionCollector) {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, AbsListView paramAbsListView)
  {
    int j = paramAbsListView.getChildCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    while (i < j)
    {
      View localView = paramAbsListView.getChildAt(i);
      Object localObject1 = UserActionCollector.a(this.g, paramAbsListView, k + i);
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (AbsBaseArticleInfo)localObject1;
        String str = UserActionCollector.a(this.g, (AbsBaseArticleInfo)localObject1);
        if (this.f.containsKey(str)) {
          localObject1 = (UserActionCollector.FeedScrollStateInfo)this.e.get(((Integer)this.f.get(str)).intValue());
        } else {
          localObject1 = null;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.h += localView.getHeight();
          localObject2 = new UserActionCollector.FeedScrollStateInfo(this.g);
          ((UserActionCollector.FeedScrollStateInfo)localObject2).a = str;
          ((UserActionCollector.FeedScrollStateInfo)localObject2).b = localView.getHeight();
          this.e.add(localObject2);
          this.f.put(str, Integer.valueOf(this.e.size() - 1));
        }
        if (paramBoolean1)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).c = localView.getTop();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).e = localView.getBottom();
        }
        else if (paramBoolean2)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).d = localView.getTop();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).f = localView.getBottom();
        }
        localObject1 = UserActionCollector.a(this.g, localView);
        if ((localObject1 != null) && (((UserActionCollector.FeedScrollStateInfo)localObject2).h == 0L))
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).h = System.currentTimeMillis();
        }
        else if (localObject1 != null)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).i = System.currentTimeMillis();
          localObject1 = this.g.e();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).g = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((UserActionCollector.FeedScrollStateInfo)localObject2).i - ((UserActionCollector.FeedScrollStateInfo)localObject2).h));
        }
      }
      i += 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d) {
      a(false, false, paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView != null)
    {
      if (this.g.o == 0L) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        this.e.clear();
        this.f.clear();
        this.g.u = true;
        this.d = true;
        this.h = 0;
        this.b = System.currentTimeMillis();
        if (this.a == 0L) {
          this.a = this.b;
        }
        UserActionCollector.a(this.g, paramAbsListView, false);
        a(true, false, paramAbsListView);
        return;
      }
      a(false, true, paramAbsListView);
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      paramAbsListView = ((ReadInJoyXListView)localObject).r;
      float[] arrayOfFloat = ((ReadInJoyXListView)localObject).s;
      UserActionCollector.a(this.g, new int[4]);
      UserActionCollector.a(this.g)[0] = ((int)paramAbsListView[0]);
      UserActionCollector.a(this.g)[1] = ((int)paramAbsListView[1]);
      UserActionCollector.a(this.g)[2] = ((int)arrayOfFloat[0]);
      UserActionCollector.a(this.g)[3] = ((int)arrayOfFloat[1]);
      localObject = new UserActionCollector.GestureEvent(this.g);
      if (arrayOfFloat[1] - paramAbsListView[1] > 0.0F) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      ((UserActionCollector.GestureEvent)localObject).a = paramInt;
      ((UserActionCollector.GestureEvent)localObject).c = (this.h - this.g.s);
      ((UserActionCollector.GestureEvent)localObject).d = (System.currentTimeMillis() - this.b);
      ((UserActionCollector.GestureEvent)localObject).e = ((float)((UserActionCollector.GestureEvent)localObject).c * 1.0F / (float)((UserActionCollector.GestureEvent)localObject).d);
      long l = this.c;
      if (l == 0L) {
        l = this.b - this.g.o;
      } else {
        l = this.b - l;
      }
      ((UserActionCollector.GestureEvent)localObject).b = l;
      paramAbsListView = new StringBuilder();
      paramAbsListView.append(UserActionCollector.a(this.g)[0]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.g)[1]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.g)[2]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.g)[3]);
      ((UserActionCollector.GestureEvent)localObject).f = paramAbsListView.toString();
      ((UserActionCollector.GestureEvent)localObject).h = new ArrayList(this.e);
      this.g.n.add(localObject);
      this.c = System.currentTimeMillis();
      this.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.OnScrollChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */