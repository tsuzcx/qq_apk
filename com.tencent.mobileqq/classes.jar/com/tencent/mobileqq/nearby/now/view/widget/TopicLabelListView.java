package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class TopicLabelListView
  extends LinearLayout
{
  private final String a = "TopicLabelListView";
  private Context b;
  private HorizontalListView c;
  private List<String> d;
  private BaseAdapter e = new TopicLabelListView.1(this);
  
  public TopicLabelListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    this.c = new HorizontalListView(paramContext);
    this.c.setDividerWidth((int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(paramContext, 5.0F));
    this.c.setAdapter(this.e);
    addView(this.c, -1, -1);
  }
  
  public void setData(List<String> paramList)
  {
    this.d = paramList;
    this.e.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView
 * JD-Core Version:    0.7.0.1
 */