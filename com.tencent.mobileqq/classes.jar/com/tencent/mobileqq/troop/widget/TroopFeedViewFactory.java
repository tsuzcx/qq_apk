package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  protected Context a;
  protected QQAppInterface b;
  protected SessionInfo c;
  protected Drawable d = null;
  protected Drawable e = null;
  protected Drawable f = null;
  protected TroopFeedsDataManager g;
  protected TroopFeedsCenterLogic h;
  protected HashMap<Integer, TroopFeedViewFactory.ViewProvider> i = new LinkedHashMap();
  long j = 0L;
  int k = 1000;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    this.a = paramContext;
    this.c = paramSessionInfo;
    this.b = paramQQAppInterface;
    this.g = paramTroopFeedsDataManager;
    this.h = paramTroopFeedsCenterLogic;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (this.i.get(Integer.valueOf(2)) != null) {
      return null;
    }
    int m = b(paramTroopFeedItem.type);
    TroopFeedViewFactory.ViewProvider localViewProvider2 = (TroopFeedViewFactory.ViewProvider)this.i.get(Integer.valueOf(m));
    TroopFeedViewFactory.ViewProvider localViewProvider1 = localViewProvider2;
    if (localViewProvider2 == null)
    {
      localViewProvider1 = a(m);
      this.i.put(Integer.valueOf(m), localViewProvider1);
    }
    if (localViewProvider1 != null) {
      return localViewProvider1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected TroopFeedViewFactory.ViewProvider a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new TroopFeedViewFactory.NormalViewProvider(this);
      }
      return new TroopFeedViewFactory.VoteViewProvider(this);
    }
    return new TroopFeedViewFactory.NormalViewProvider(this);
  }
  
  public void a()
  {
    this.i.remove(Integer.valueOf(2));
  }
  
  protected int b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 5) && (paramInt != 10) && (paramInt != 12) && (paramInt != 18) && (paramInt != 19) && (paramInt != 131)) {}
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof TroopFeedViewFactory.ADViewProvider.ViewHolder))
    {
      this.h.b(true);
    }
    else if (SystemClock.uptimeMillis() - this.j >= this.k)
    {
      this.j = SystemClock.uptimeMillis();
      Object localObject = new Intent(this.a, QQBrowserActivity.class);
      TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c.b);
      String str = this.b.getCurrentAccountUin();
      if ((localTroopInfo != null) && (str != null))
      {
        if (str.equals(localTroopInfo.troopowneruin))
        {
          m = 0;
          break label152;
        }
        if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str)))
        {
          m = 1;
          break label152;
        }
      }
      int m = 2;
      label152:
      ((Intent)localObject).putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.c.b, Integer.valueOf(m) }));
      this.a.startActivity((Intent)localObject);
      localObject = paramView.getTag();
      if ((localObject instanceof TroopFeedViewFactory.ViewHolder))
      {
        localObject = ((TroopFeedViewFactory.ViewHolder)localObject).f;
        if ((localObject != null) && (((TroopFeedItem)localObject).isStoryType())) {
          ReportController.b(this.b, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.c.b, "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory
 * JD-Core Version:    0.7.0.1
 */