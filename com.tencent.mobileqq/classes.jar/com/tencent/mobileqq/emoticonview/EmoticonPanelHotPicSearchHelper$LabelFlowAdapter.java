package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class EmoticonPanelHotPicSearchHelper$LabelFlowAdapter
  extends BaseAdapter
{
  private Context mContext;
  private List<String> mDatas;
  
  public EmoticonPanelHotPicSearchHelper$LabelFlowAdapter(Context paramContext, List<String> paramList)
  {
    Object localObject;
    this.mDatas = localObject;
    this.mContext = paramList;
  }
  
  public int getCount()
  {
    return this.mDatas.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mDatas.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.mContext, 2131627962, null);
    }
    paramView = (Button)localView.findViewById(2131430045);
    paramView.setText((CharSequence)this.mDatas.get(paramInt));
    paramView.setContentDescription((CharSequence)this.mDatas.get(paramInt));
    paramView.setBackgroundDrawable(this.this$0.getShapeDrawable(12));
    if ((this.this$0.needSkin()) && (ThemeUtil.isNowThemeIsNight(this.this$0.getApp().getAppRuntime(), false, null))) {
      paramView.setTextColor(Color.parseColor("#B0B3BF"));
    } else {
      paramView.setTextColor(Color.parseColor("#03081A"));
    }
    paramView.setOnClickListener(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter.1(this, paramView));
    if ((this.this$0.mInteractionListener != null) && (((IGuildTempApi)QRoute.api(IGuildTempApi.class)).checkChatPie(this.this$0.mInteractionListener.getBaseChatPie())))
    {
      paramView.setBackgroundDrawable(ViewUtils.getShapeDrawable(Color.parseColor("#2F3033"), ViewUtils.dip2px(12.0F)));
      paramView.setTextColor(Color.parseColor("#C1C1C1"));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.LabelFlowAdapter
 * JD-Core Version:    0.7.0.1
 */