package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.PagerChangeListener;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePhotoPeviewerAdapter;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePhotoPeviewerAdapter.PhotoViewHolder;
import com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QCircleViewerPart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver, QCirclePagerSnapHelper.PagerChangeListener
{
  private RecyclerView a;
  private RecyclerView.LayoutManager b;
  private QCirclePhotoPeviewerAdapter e;
  private QCirclePagerSnapHelper f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private List<String> j;
  private int k = 0;
  
  private void d()
  {
    PublishCustomDialog.a(g(), g().getResources().getString(2131895832), null, 2131887648, 2131888010, new QCircleViewerPart.1(this), new QCircleViewerPart.2(this)).show();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[QcirclePublish]QCircleViewerPart", 1, "QCircleViewerPart... intent == null");
      c().finish();
      return;
    }
    this.j = paramIntent.getStringArrayListExtra("key_photo_previewer_list");
    this.k = paramIntent.getIntExtra("key_photo_previewer_cur_position", 0);
    paramIntent = this.j;
    if ((paramIntent != null) && (paramIntent.size() != 0))
    {
      QLog.d("[QcirclePublish]QCircleViewerPart", 1, new Object[] { "QCircleViewerPart... list:", this.j });
      return;
    }
    QLog.w("[QcirclePublish]QCircleViewerPart", 1, "QCircleViewerPart... mList == null || mList.size() == 0");
    c().finish();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.g = ((TextView)paramView.findViewById(2131441735));
    this.h = ((TextView)paramView.findViewById(2131441736));
    this.i = ((ImageView)paramView.findViewById(2131431689));
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    paramView.findViewById(2131441796).setVisibility(8);
    this.a = ((RecyclerView)paramView.findViewById(2131441818));
    this.a.setVisibility(0);
    this.b = new LinearLayoutManager(g(), 0, false);
    this.f = new QCirclePagerSnapHelper();
    this.e = new QCirclePhotoPeviewerAdapter((ArrayList)this.j, this.f);
    this.a.setLayoutManager(this.b);
    this.a.setAdapter(this.e);
    this.a.scrollToPosition(this.k);
    this.f.a(this);
    this.f.a(this.a);
    if (this.j != null)
    {
      paramView = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(this.j.size());
      paramView.setText(localStringBuilder.toString());
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof QCirclePhotoPeviewerAdapter.PhotoViewHolder))
    {
      TextView localTextView = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      paramViewHolder = (QCirclePhotoPeviewerAdapter.PhotoViewHolder)paramViewHolder;
      localStringBuilder.append(paramViewHolder.b + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(this.j.size());
      localTextView.setText(localStringBuilder.toString());
      this.k = paramViewHolder.b;
    }
  }
  
  public void b() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441735) {
      c().finish();
    } else if (paramView.getId() == 2131431689) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.QCircleViewerPart
 * JD-Core Version:    0.7.0.1
 */