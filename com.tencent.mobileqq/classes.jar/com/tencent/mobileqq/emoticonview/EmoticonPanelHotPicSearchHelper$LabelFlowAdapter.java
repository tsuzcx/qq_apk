package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if (paramView == null) {
      paramView = View.inflate(this.mContext, 2131559207, null);
    }
    for (;;)
    {
      Button localButton = (Button)paramView.findViewById(2131364161);
      localButton.setText((CharSequence)this.mDatas.get(paramInt));
      localButton.setContentDescription((CharSequence)this.mDatas.get(paramInt));
      localButton.setBackgroundDrawable(this.this$0.getShapeDrawable(12));
      if (ThemeUtil.isNowThemeIsNight(this.this$0.getApp().getAppRuntime(), false, null)) {
        localButton.setTextColor(Color.parseColor("#B0B3BF"));
      }
      for (;;)
      {
        localButton.setOnClickListener(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter.1(this, localButton));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localButton.setTextColor(Color.parseColor("#03081A"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.LabelFlowAdapter
 * JD-Core Version:    0.7.0.1
 */