package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class QQGameHippyRecyclerView
  extends HippyRecyclerView
{
  public QQGameHippyRecyclerView(Context paramContext)
  {
    super(paramContext);
    initRecyclerView();
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.setHasStableIds(true);
    }
    super.setAdapter(paramAdapter);
  }
  
  public void setListData()
  {
    super.setListData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setListData ..");
      localStringBuilder.append(this);
      QLog.i("QQGameHippyRecyclerView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.QQGameHippyRecyclerView
 * JD-Core Version:    0.7.0.1
 */