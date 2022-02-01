package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class StartLiveTopicLabelListView
  extends LinearLayout
{
  private final String a = "TopicLabelListView";
  private Context b;
  private HorizontalListView c;
  private List<String> d;
  private StartLiveTopicLabelListView.IAddTopicClickListener e;
  private int f = ((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveNormalGap();
  private int g = -1;
  private int h = ((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveGap();
  private int i = -1;
  private BaseAdapter j = new StartLiveTopicLabelListView.1(this);
  
  public StartLiveTopicLabelListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    this.c = new HorizontalListView(paramContext);
    this.c.setDividerWidth((int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(paramContext, 5.0F));
    this.c.setAdapter(this.j);
    addView(this.c, -1, -1);
  }
  
  public void setData(List<String> paramList)
  {
    this.d = paramList;
    this.j.notifyDataSetChanged();
  }
  
  public void setItemAddLabelResId(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setItemAddLabelTextColor(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setItemResId(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView
 * JD-Core Version:    0.7.0.1
 */