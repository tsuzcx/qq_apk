package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
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
      localView = View.inflate(this.mContext, 2131561599, null);
    }
    paramView = (Button)localView.findViewById(2131364082);
    paramView.setText((CharSequence)this.mDatas.get(paramInt));
    paramView.setContentDescription((CharSequence)this.mDatas.get(paramInt));
    paramView.setBackgroundDrawable(this.this$0.getShapeDrawable(12));
    if (ThemeUtil.isNowThemeIsNight(this.this$0.getApp().getAppRuntime(), false, null)) {
      paramView.setTextColor(Color.parseColor("#B0B3BF"));
    } else {
      paramView.setTextColor(Color.parseColor("#03081A"));
    }
    paramView.setOnClickListener(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter.1(this, paramView));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.LabelFlowAdapter
 * JD-Core Version:    0.7.0.1
 */