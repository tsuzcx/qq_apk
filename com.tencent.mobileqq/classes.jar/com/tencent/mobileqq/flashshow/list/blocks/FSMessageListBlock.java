package com.tencent.mobileqq.flashshow.list.blocks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.events.FSAtUpdateEvent;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.request.list.FSMessageNoticeRequest;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.view.message.FSBusinessMessageItemView;
import com.tencent.mobileqq.flashshow.view.message.FSCommentOrReplyMessageItemView;
import com.tencent.mobileqq.flashshow.view.message.FSDefaultMessageItemView;
import com.tencent.mobileqq.flashshow.view.message.FSFollowMessageItemView;
import com.tencent.mobileqq.flashshow.view.message.FSUnsupportedMessageItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetNoticeListRspData;

public class FSMessageListBlock
  extends FSBaseListBlock<FeedCloudMeta.StNotice, FeedCloudRead.StGetNoticeListRsp>
{
  private static final int MESSAGE_TYPE_UNSUPPORTED = SUPPORT_MESSAGE_TYPES.length;
  private static final int[] SUPPORT_MESSAGE_TYPES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
  private static final String TAG = "QCircleMessageListBlock";
  private TextView mTvTitle;
  private TextView mTvUnReadNum;
  
  public FSMessageListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void clearLocalRedPointInfo()
  {
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).setBubbleRedPointReaded();
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).setBottomRedPointReaded();
  }
  
  private void reportExpose()
  {
    FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(17).setSubActionType(1).setThrActionType(0));
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StNotice paramStNotice)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.feedAttchInfo.get();
  }
  
  public int getContentLayoutId()
  {
    return 2131624821;
  }
  
  public List<Part> getCustomParts()
  {
    return new ArrayList();
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_MESSAGE_NOTICE();
  }
  
  public String getEmptyHint()
  {
    return FSConfig.l();
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.isFinish.get() == 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      int i = ((FeedCloudMeta.StNotice)this.mDataList.get(paramInt)).noticeType.get();
      paramInt = i;
      if (i >= 0)
      {
        paramInt = i;
        if (i < MESSAGE_TYPE_UNSUPPORTED) {
          return i;
        }
      }
    }
    else
    {
      paramInt = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED");
    localStringBuilder.append(paramInt);
    QLog.e("QCircleMessageListBlock", 2, localStringBuilder.toString());
    return MESSAGE_TYPE_UNSUPPORTED;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StNotice> paramIDataCallBack, String paramString) {}
  
  public List<FeedCloudMeta.StNotice> getListDataFromRsp(FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    return paramStGetNoticeListRsp.vecNotice.get();
  }
  
  public String getLogTag()
  {
    return "QCircleMessageListBlock";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public BaseRequest getRequest(String paramString)
  {
    return new FSMessageNoticeRequest(paramString, false);
  }
  
  public String getTitle()
  {
    return FSHardCodeUtil.a(2131889731);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624828, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131448792));
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131448696));
    this.mTvTitle.setText(FSHardCodeUtil.a(2131889731));
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return SUPPORT_MESSAGE_TYPES.length + 1;
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    super.handleResponse(paramBoolean1, paramBoolean2, paramLong, paramString1, paramString2, paramStGetNoticeListRsp);
    if ((paramBoolean1) && (paramLong == 0L) && (!paramBoolean2) && (paramStGetNoticeListRsp != null) && (paramStGetNoticeListRsp.busiRspData.has()))
    {
      paramString1 = new QQCircleFeedBase.StGetNoticeListRspData();
      try
      {
        paramString1.mergeFrom(paramStGetNoticeListRsp.busiRspData.get().toByteArray());
        if (paramString1.rspTimestamp.has())
        {
          FSEeveeRedPointHelper.getInstance().saveLastReadBubbleRedPointTimestamp(paramString1.rspTimestamp.get());
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("QCircleMessageListBlock", 1, "handleResponse parse StGetNoticeListRspData error!", paramString1);
      }
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    super.loadData(paramLoadInfo);
    clearLocalRedPointInfo();
    if (paramLoadInfo.c())
    {
      FSCommentHelper.a().c();
      return;
    }
    if (paramLoadInfo.d()) {
      FSCommentHelper.a().c();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (256 == paramInt1) {
      SimpleEventBus.getInstance().dispatchEvent(new FSAtUpdateEvent(getContext(), paramIntent));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    reportExpose();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((FSBaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append("  ");
    localStringBuilder.append(this);
    QLog.d("QCircleMessageListBlock", 4, localStringBuilder.toString());
  }
  
  public FSBaseListBlock.BaseListVH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("QCircleMessageListBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new FSBaseListBlock.BaseListVH(new FSUnsupportedMessageItemView(getParentFragment().getActivity()));
    case 15: 
      return new FSBaseListBlock.BaseListVH(new FSBusinessMessageItemView(getParentFragment().getActivity()));
    case 4: 
      return new FSBaseListBlock.BaseListVH(new FSFollowMessageItemView(getParentFragment().getActivity(), paramInt));
    case 1: 
    case 2: 
      paramViewGroup = new FSCommentOrReplyMessageItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setRecyclerView(getParentRecyclerView());
      return new FSBaseListBlock.BaseListVH(paramViewGroup);
    }
    return new FSBaseListBlock.BaseListVH(new FSDefaultMessageItemView(getParentFragment().getActivity(), paramInt, getBlockMerger().f()));
  }
  
  public void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleMessageListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      TextView localTextView = this.mTvTitle;
      if (paramBoolean) {
        paramView = Typeface.DEFAULT_BOLD;
      } else {
        paramView = Typeface.DEFAULT;
      }
      localTextView.setTypeface(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.blocks.FSMessageListBlock
 * JD-Core Version:    0.7.0.1
 */