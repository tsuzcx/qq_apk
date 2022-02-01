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
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<UserActionCollector.FeedScrollStateInfo> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c = 0L;
  
  public UserActionCollector$OnScrollChangeListenerWrapper(UserActionCollector paramUserActionCollector)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, AbsListView paramAbsListView)
  {
    int j = paramAbsListView.getChildCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    while (i < j)
    {
      View localView = paramAbsListView.getChildAt(i);
      Object localObject1 = UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector, paramAbsListView, k + i);
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (AbsBaseArticleInfo)localObject1;
        String str = UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector, (AbsBaseArticleInfo)localObject1);
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          localObject1 = (UserActionCollector.FeedScrollStateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        } else {
          localObject1 = null;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new UserActionCollector.FeedScrollStateInfo(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector);
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (paramBoolean1)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Int = localView.getTop();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).d = localView.getBottom();
        }
        else if (paramBoolean2)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).c = localView.getTop();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).e = localView.getBottom();
        }
        localObject1 = UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector, localView);
        if ((localObject1 != null) && (((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long == 0L))
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
        }
        else if (localObject1 != null)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.a();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Long - ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long));
        }
      }
      i += 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false, false, paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.jdField_a_of_type_Long == 0L) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_Long == 0L) {
          this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        }
        UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector, paramAbsListView, false);
        a(true, false, paramAbsListView);
        return;
      }
      a(false, true, paramAbsListView);
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      paramAbsListView = ((ReadInJoyXListView)localObject).a;
      float[] arrayOfFloat = ((ReadInJoyXListView)localObject).b;
      UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector, new int[4]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[0] = ((int)paramAbsListView[0]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[1] = ((int)paramAbsListView[1]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[2] = ((int)arrayOfFloat[0]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[3] = ((int)arrayOfFloat[1]);
      localObject = new UserActionCollector.GestureEvent(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector);
      if (arrayOfFloat[1] - paramAbsListView[1] > 0.0F) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      ((UserActionCollector.GestureEvent)localObject).jdField_a_of_type_Int = paramInt;
      ((UserActionCollector.GestureEvent)localObject).jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.i);
      ((UserActionCollector.GestureEvent)localObject).c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
      ((UserActionCollector.GestureEvent)localObject).jdField_a_of_type_Float = ((float)((UserActionCollector.GestureEvent)localObject).jdField_b_of_type_Long * 1.0F / (float)((UserActionCollector.GestureEvent)localObject).c);
      long l = this.c;
      if (l == 0L) {
        l = this.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.jdField_a_of_type_Long;
      } else {
        l = this.jdField_b_of_type_Long - l;
      }
      ((UserActionCollector.GestureEvent)localObject).jdField_a_of_type_Long = l;
      paramAbsListView = new StringBuilder();
      paramAbsListView.append(UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[0]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[1]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[2]);
      paramAbsListView.append("_");
      paramAbsListView.append(UserActionCollector.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector)[3]);
      ((UserActionCollector.GestureEvent)localObject).jdField_a_of_type_JavaLangString = paramAbsListView.toString();
      ((UserActionCollector.GestureEvent)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector.b.add(localObject);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.OnScrollChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */