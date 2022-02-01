package com.tencent.mobileqq.kandian.biz.channel;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class ChannelClassificationListView<T extends ChannelClassificationListView.IClassData>
  extends DisableSlideHorizontalListView
{
  private ArrayList<T> a = new ArrayList();
  private AdapterView.OnItemClickListener b;
  private ChannelClassificationListView<T>.ClassificationAdapter c;
  private int d;
  
  public ChannelClassificationListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ChannelClassificationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = new ChannelClassificationListView.ClassificationAdapter(this, null);
    setAdapter(this.c);
    setDividerWidth(DisplayUtil.a(getContext(), 10.0F));
    setOnScrollStateChangedListener(new ChannelClassificationListView.1(this));
  }
  
  public void setData(int paramInt, ArrayList<T> paramArrayList)
  {
    this.d = paramInt;
    this.a = paramArrayList;
    this.c.notifyDataSetChanged();
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.b = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView
 * JD-Core Version:    0.7.0.1
 */