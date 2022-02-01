package com.tencent.mobileqq.profile.PersonalityLabel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class PersonalityLabelGalleryActivity$ListViewAdapter$1
  extends RecyclerView.OnScrollListener
{
  PersonalityLabelGalleryActivity$ListViewAdapter$1(PersonalityLabelGalleryActivity.ListViewAdapter paramListViewAdapter, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append("onScrollStateChanged newState:");
      paramRecyclerView.append(paramInt);
      QLog.i("PersonalityLabelGalleryActivity", 2, paramRecyclerView.toString());
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrolled dx:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" dy:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("PersonalityLabelGalleryActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 > 0)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      int i = paramRecyclerView.getChildCount();
      int j = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findLastVisibleItemPositions(null);
      paramInt2 = 0;
      int k = paramRecyclerView[0];
      paramRecyclerView = PersonalityLabelGalleryActivity.l(this.b.a).get(Long.valueOf(this.a.id));
      paramInt1 = paramInt2;
      if (paramRecyclerView != null)
      {
        paramInt1 = paramInt2;
        if (((Integer)paramRecyclerView).intValue() == 1) {
          paramInt1 = 1;
        }
      }
      if ((!PersonalityLabelGalleryActivity.n(this.b.a)) && (paramInt1 == 0) && (i > 0) && (k >= j - 1))
      {
        PersonalityLabelGalleryActivity.a(this.b.a, true);
        QLog.i("PersonalityLabelGalleryActivity", 2, "load more photos");
        localObject = (PersonalityLabelHandler)this.b.a.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL);
        if (PersonalityLabelGalleryActivity.i(this.b.a)) {
          paramRecyclerView = this.b.a.app.getCurrentAccountUin();
        } else {
          paramRecyclerView = PersonalityLabelGalleryActivity.h(this.b.a);
        }
        ((PersonalityLabelHandler)localObject).a(paramRecyclerView, this.a.id, 20, (byte[])PersonalityLabelGalleryActivity.k(this.b.a).get(Long.valueOf(this.a.id)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */