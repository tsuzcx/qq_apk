package com.tencent.mobileqq.now.focusanchor;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager;
import com.tencent.mobileqq.now.focusanchor.util.QQDataUtil;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class NowQQFocusHandler
{
  public static void a(BaseActivity paramBaseActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (NowQQFocusViewHolder)paramViewHolder;
    paramViewHolder.b.setText(QQDataUtil.a());
    paramViewHolder.a.setImageDrawable(QQDataUtil.a(paramBaseActivity));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    paramViewHolder.d.setLayoutManager(localLinearLayoutManager);
    paramBaseActivity = new NowQQLiveFocusAdapter(paramBaseActivity, FocusLiveStreamDataManager.a().c());
    paramViewHolder.d.setAdapter(paramBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusHandler
 * JD-Core Version:    0.7.0.1
 */