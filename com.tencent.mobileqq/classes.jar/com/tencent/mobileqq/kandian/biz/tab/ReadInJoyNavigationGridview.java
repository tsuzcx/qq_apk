package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private ViewGroup a;
  private GridView b;
  private ReadInJoyNavigationAdapter c;
  private boolean d = false;
  private View e;
  private ReadInJoyNavigationGridview.NaviMaskTouchListener f;
  private ReadInJoyNavigationGridview.NaviBarHandler g;
  private List<ChannelCoverInfo> h;
  
  public ReadInJoyNavigationGridview(Context paramContext, ReadInJoyNavigationGridview.NaviMaskTouchListener paramNaviMaskTouchListener)
  {
    super(paramContext);
    a(paramContext);
    this.g = new ReadInJoyNavigationGridview.NaviBarHandler(this);
    this.f = paramNaviMaskTouchListener;
    this.d = false;
  }
  
  private void a(Context paramContext)
  {
    this.a = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131626291, this));
    this.b = ((GridView)this.a.findViewById(2131439144));
    this.e = this.a.findViewById(2131439145);
    this.c = new ReadInJoyNavigationAdapter(paramContext);
    GridView localGridView = this.b;
    localGridView.setPadding(localGridView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.b.getPaddingRight(), this.b.getPaddingBottom());
    this.b.setAdapter(this.c);
    this.e.setOnTouchListener(new ReadInJoyNavigationGridview.1(this));
  }
  
  private void c()
  {
    List localList = this.h;
    if ((localList != null) && (localList.size() > 0)) {
      this.c.a(this.h);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.d = true;
    this.h = null;
    this.g.removeMessages(1);
  }
  
  public int getAdapterCount()
  {
    return this.c.getCount();
  }
  
  public List<ChannelCoverInfo> getChannels()
  {
    return this.h;
  }
  
  public View getNaviBar()
  {
    return this.b;
  }
  
  public void setChannelButtonListener(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.c.a(paramChannelButtonListener);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.h = paramList;
    this.g.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */