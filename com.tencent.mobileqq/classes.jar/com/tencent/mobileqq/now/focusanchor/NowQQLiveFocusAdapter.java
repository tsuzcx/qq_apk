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
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List<NowQQLiveAnchorInfo> jdField_a_of_type_JavaUtilList;
  
  public NowQQLiveFocusAdapter(BaseActivity paramBaseActivity, List<NowQQLiveAnchorInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    FocusLiveStreamDataManager.a().a(this);
  }
  
  public NowQQLiveFocusAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new NowQQLiveFocusAdapter.ViewHolder(View.inflate(paramViewGroup.getContext(), 2131559517, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(NowQQLiveFocusAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    NowQQLiveAnchorInfo localNowQQLiveAnchorInfo = (NowQQLiveAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localNowQQLiveAnchorInfo.b());
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, localNowQQLiveAnchorInfo.c(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841495);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    NowQQLiveDataReport.b(String.valueOf(localNowQQLiveAnchorInfo.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<NowQQLiveAnchorInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQLiveFocusAdapter
 * JD-Core Version:    0.7.0.1
 */