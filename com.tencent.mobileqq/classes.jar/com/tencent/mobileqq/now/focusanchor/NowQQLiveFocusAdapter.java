package com.tencent.mobileqq.now.focusanchor;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.focusanchor.focousinterface.FocusLiveStreamListener;
import com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager;
import com.tencent.mobileqq.now.focusanchor.focusdata.NowQQLiveAnchorInfo;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class NowQQLiveFocusAdapter
  extends RecyclerView.Adapter<NowQQLiveFocusAdapter.ViewHolder>
  implements FocusLiveStreamListener
{
  private BaseActivity a;
  private List<NowQQLiveAnchorInfo> b;
  
  public NowQQLiveFocusAdapter(BaseActivity paramBaseActivity, List<NowQQLiveAnchorInfo> paramList)
  {
    this.a = paramBaseActivity;
    this.b = paramList;
    FocusLiveStreamDataManager.a().a(this);
  }
  
  public NowQQLiveFocusAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new NowQQLiveFocusAdapter.ViewHolder(View.inflate(paramViewGroup.getContext(), 2131625539, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(NowQQLiveFocusAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    NowQQLiveAnchorInfo localNowQQLiveAnchorInfo = (NowQQLiveAnchorInfo)this.b.get(paramInt);
    paramViewHolder.b.setText(localNowQQLiveAnchorInfo.d());
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramViewHolder.a, localNowQQLiveAnchorInfo.e(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramViewHolder.c.setAnimationRes(2130842337);
    paramViewHolder.c.a();
    NowQQLiveDataReport.b(String.valueOf(localNowQQLiveAnchorInfo.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<NowQQLiveAnchorInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQLiveFocusAdapter
 * JD-Core Version:    0.7.0.1
 */