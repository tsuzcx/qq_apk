package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.OnDragListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.OnDropListener;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import java.util.List;

public class RIJDynamicChannelGridViewAdapter
  extends RIJBaseChannelGridViewAdapter
  implements View.OnClickListener, ReadInJoyDynamicGridView.OnDragListener, ReadInJoyDynamicGridView.OnDropListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private final RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback g;
  private final int h;
  private int i = 0;
  
  public RIJDynamicChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback paramDynamicAdapterCallback, int paramInt3)
  {
    super(paramContext, paramInt1, paramInt2, paramDynamicAdapterCallback);
    this.h = paramInt3;
    this.g = paramDynamicAdapterCallback;
  }
  
  private int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int k = -1291845632;
    int j = k;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.fontsColor != 0) {
        return paramTabChannelCoverInfo.fontsColor;
      }
      j = k;
      if (paramTabChannelCoverInfo.isCurrent) {
        j = -15550475;
      }
    }
    return j;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g.a(this, paramInt1, paramInt2);
  }
  
  public void cS_()
  {
    this.g.a();
  }
  
  List<TabChannelCoverInfo> d(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int j = this.h;
      if ((j >= 0) && (j < paramList.size())) {
        ((TabChannelCoverInfo)paramList.get(this.h)).isCurrent = true;
      }
      int m = 0;
      j = 0;
      TabChannelCoverInfo localTabChannelCoverInfo;
      while (j < paramList.size())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(j);
        if (localTabChannelCoverInfo != null)
        {
          boolean bool;
          if (j == this.h) {
            bool = true;
          } else {
            bool = false;
          }
          localTabChannelCoverInfo.isCurrent = bool;
        }
        j += 1;
      }
      int k = 0;
      j = m;
      while (j < paramList.size())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(j);
        m = k;
        if (localTabChannelCoverInfo != null)
        {
          if (localTabChannelCoverInfo.reason != 4) {
            break;
          }
          m = k + 1;
        }
        j += 1;
        k = m;
      }
      this.i = k;
      this.g.a(this.i);
      return paramList;
    }
    QLog.d("RIJDynamicChannelGridViewAdapter", 2, "No channel Cache info.");
    return paramList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131626282, null);
      paramView = new RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder();
      paramView.a = ((LinearLayout)paramViewGroup.findViewById(2131437237));
      paramView.b = ((AutoFitTextView)paramViewGroup.findViewById(2131430505));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131444531));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131444538));
      paramView.e = ((ImageView)paramViewGroup.findViewById(2131431716));
      paramView.e.setOnClickListener(this);
      paramView.b.setOnGetMaxWidthCallback(paramView);
      paramView.f = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131436420));
      if (paramView.f != null) {
        paramView.f.setCorner(this.d);
      }
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    paramViewGroup.setAlpha(1.0F);
    paramView.b.setText(localTabChannelCoverInfo.mChannelCoverName);
    paramView.b.setTextColor(a(localTabChannelCoverInfo));
    Object localObject = paramView.e;
    int j;
    if (this.f) {
      j = 0;
    } else {
      j = 8;
    }
    ((ImageView)localObject).setVisibility(j);
    paramView.e.setTag(localTabChannelCoverInfo);
    paramView.e.setTag(2131444305, Integer.valueOf(paramInt));
    if ((paramInt < this.i) && (this.f))
    {
      paramViewGroup.setAlpha(0.5F);
      paramView.e.setVisibility(8);
    }
    if (this.f)
    {
      paramView.c.setVisibility(8);
      paramView.d.setVisibility(8);
      return paramViewGroup;
    }
    localObject = paramView.c;
    if (RIJChannelHelper.a(localTabChannelCoverInfo) == 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject).setVisibility(paramInt);
    if ((RIJChannelHelper.a(localTabChannelCoverInfo) == 1) && (localTabChannelCoverInfo.redPoint.d <= 0L))
    {
      paramView.d.setVisibility(0);
      a(localTabChannelCoverInfo, paramView.d);
      return paramViewGroup;
    }
    paramView.d.setVisibility(8);
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131431716) {
      return;
    }
    int j = ((Integer)paramView.getTag(2131444305)).intValue();
    paramView = (TabChannelCoverInfo)paramView.getTag();
    QLog.d("RIJDynamicChannelGridViewAdapter", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(j) });
    this.g.a(j, paramView, this);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.g.a(paramAdapterView, this, paramInt, paramView);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.g.b(paramAdapterView, this, paramInt, paramView);
    return true;
  }
  
  public void p_(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */