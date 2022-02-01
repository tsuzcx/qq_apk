package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelCoverView
  implements AdapterView.OnItemClickListener
{
  public static int a = 2;
  public static int b = 1;
  protected ReadInJoyObserver c = new ChannelCoverView.ChannelCoverViewObserver(this, null);
  private LinearLayout d;
  private ArrayList<ChannelCoverInfo> e = new ArrayList();
  private Context f;
  private int g;
  private HorizontalListView h;
  private ChannelCoverSimpleAdapter i;
  private ListView j;
  
  public ChannelCoverView(Context paramContext, int paramInt, ListView paramListView)
  {
    this.g = paramInt;
    this.f = paramContext;
    this.j = paramListView;
    this.e = ((ArrayList)ReadInJoyLogicEngine.a().c(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "ChannelCoverView createSimpleView");
    }
    a(paramContext);
    paramContext = this.e;
    if ((paramContext != null) && (paramContext.size() > 0)) {
      this.j.addHeaderView(this.d);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.c);
    paramContext = this.e;
    if ((paramContext == null) || (paramContext.size() == 0)) {
      ReadInJoyLogicEngine.a().e(paramInt);
    }
    ReadInJoyLogicEngine.a().a(paramInt);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    a(paramString, paramChannelCoverInfo, paramInt, -1, -1);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadManager.post(new ChannelCoverView.3(paramChannelCoverInfo, paramInt1, paramInt2, paramInt3, paramString), 5, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ChannelCoverView.2(paramChannelCoverInfo, paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.c);
    this.e = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onDestroy()");
    }
  }
  
  void a(Context paramContext)
  {
    this.d = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2131624408, null, false));
    LinearLayout localLinearLayout = (LinearLayout)this.d.findViewById(2131431280);
    this.h = ((HorizontalListView)this.d.findViewById(2131450165));
    this.h.setOverScrollMode(2);
    this.h.setDividerWidth(AIOUtils.b(6.0F, paramContext.getResources()));
    this.i = new ChannelCoverSimpleAdapter(paramContext, this.e, this.g);
    this.h.setAdapter(this.i);
    this.h.setOverScrollMode(2);
    if (this.g == 56)
    {
      this.h.setOnTouchListener(new ChannelCoverView.4(this, paramContext));
      localLinearLayout.setPadding(0, (int)DisplayUtils.a(paramContext, 2.0F), 0, (int)DisplayUtils.a(paramContext, 2.0F));
    }
    if (this.g == 41523) {
      this.d.setPadding(0, AIOUtils.b(10.0F, paramContext.getResources()), 0, 0);
    }
  }
  
  public LinearLayout b()
  {
    return this.d;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.e.size() > paramInt)
    {
      paramAdapterView = (ChannelCoverInfo)this.e.get(paramInt);
      if (TextUtils.isEmpty(paramAdapterView.mChannelJumpUrl))
      {
        paramView = new HashMap();
        paramView.put("param_key_ariticle_id", Long.valueOf(paramAdapterView.mArticleId));
        paramView.put("param_key_channel_cover_style", Integer.valueOf(paramAdapterView.mChannelCoverStyle));
        if (this.g == 56) {
          ReadInJoyActivityHelper.INSTANCE.launchVideoSubChannelActivity(this.f, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
        } else {
          ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(this.f, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("launchChannelActivity info.mArticleId:");
          paramView.append(paramAdapterView.mArticleId);
          paramView.append(" info.mChannelCoverStyle: ");
          paramView.append(paramAdapterView.mChannelCoverStyle);
          paramView.append(" info.mChannelCoverId:");
          paramView.append(paramAdapterView.mChannelCoverId);
          paramView.append(" info.mChannelCoverName:");
          paramView.append(paramAdapterView.mChannelCoverName);
          paramView.append(" info.mChannelType: ");
          paramView.append(paramAdapterView.mChannelType);
          QLog.d("ChannelCoverView", 2, paramView.toString());
        }
        if (this.g == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverView.1(this, paramAdapterView));
        }
      }
      else
      {
        paramView = new Intent(this.f, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView.mChannelJumpUrl);
        this.f.startActivity(paramView);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("info.mChannelJumpUrl:");
          paramView.append(paramAdapterView.mChannelJumpUrl);
          QLog.d("ChannelCoverView", 2, paramView.toString());
        }
        paramAdapterView.mPreUpdateTime = paramAdapterView.mUpdateTime;
      }
      if (this.g == 0) {
        a("0X8007F02", paramAdapterView, a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView
 * JD-Core Version:    0.7.0.1
 */