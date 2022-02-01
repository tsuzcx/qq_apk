package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReadInJoyNaviController
{
  public static int b = 0;
  public static int c = 0;
  public static int d = 7;
  public static final int e = ViewUtils.dip2px(5.0F);
  public int a = 0;
  protected ReadInJoyObserver f = new ReadInJoyNaviController.3(this);
  private ViewGroup g;
  private ReadInJoyNavigationGridview h;
  private ImageView i;
  private boolean j = true;
  
  public ReadInJoyNaviController(ViewGroup paramViewGroup, ReadInJoyNavigationGridview paramReadInJoyNavigationGridview, ImageView paramImageView)
  {
    this.g = paramViewGroup;
    this.h = paramReadInJoyNavigationGridview;
    this.i = paramImageView;
    this.h.setChannelButtonListener(new ReadInJoyNaviController.ChannelButtonListenerImpl(this));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.f);
    a();
  }
  
  public static String a(int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    JSONObject localJSONObject = RIJTransMergeKanDianReport.h();
    int k;
    if (paramInt != 0)
    {
      k = 1;
      if (paramInt == 1) {
        if (paramChannelCoverInfo == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("channel_id", paramChannelCoverInfo.mChannelCoverId);
        if (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl)) {
          break label106;
        }
        paramInt = k;
        localJSONObject.put("content_type", paramInt);
        localJSONObject.put("channel_index", c);
      }
      catch (Exception paramChannelCoverInfo)
      {
        paramChannelCoverInfo.printStackTrace();
      }
      localJSONObject.put("channel_id", -1);
      localJSONObject.put("content_type", -1);
      localJSONObject.put("channel_index", -1);
      return localJSONObject.toString();
      label106:
      paramInt = 2;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str;
    if (paramInt != 0) {
      if (paramInt != 1) {
        str = "";
      }
    }
    for (;;)
    {
      break;
      str = "0X8008B83";
      continue;
      str = "0X8008B81";
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", paramString, false);
  }
  
  private void a(long paramLong)
  {
    RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.4(this), paramLong);
  }
  
  private List<ChannelCoverInfo> b(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (!localChannelCoverInfo.isExternalExposure) {
          localArrayList.add(localChannelCoverInfo);
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("filtered channel list size: ");
    paramList.append(localArrayList.size());
    QLog.d("ReadInJoyNaviController", 2, paramList.toString());
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      List localList = localReadInJoyLogicManager.getReadInJoyLogicEngine().c(0);
      if ((localList != null) && (localList.size() != 0))
      {
        a(localList);
      }
      else
      {
        localReadInJoyLogicManager.getReadInJoyLogicEngine().e(0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNaviController", 2, "No channel Cache info.");
        }
      }
      localReadInJoyLogicManager.getReadInJoyLogicEngine().a(0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.h.getAdapterCount() <= 0)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "No channel info.");
      }
      return;
    }
    b = paramInt;
    if (this.g.findViewWithTag("mReadInJoyNavigation") == null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      localLayoutParams.topMargin = this.a;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.h.getChannels().iterator();
      int k = 0;
      while (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = ((ChannelCoverInfo)localIterator.next()).clone();
        if (localChannelCoverInfo != null)
        {
          boolean bool;
          if (paramInt == localChannelCoverInfo.mChannelCoverId) {
            bool = true;
          } else {
            bool = false;
          }
          localChannelCoverInfo.isSelected = bool;
          if (paramInt == localChannelCoverInfo.mChannelCoverId) {
            c = k;
          }
        }
        localArrayList.add(localChannelCoverInfo);
        k += 1;
      }
      a(localArrayList);
      this.h.setAlpha(0.0F);
      this.g.addView(this.h, localLayoutParams);
      this.h.setTag("mReadInJoyNavigation");
      RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.1(this), 0L);
    }
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if (c())
    {
      if (paramChannelCoverInfo != null)
      {
        int k = 0;
        Iterator localIterator = this.h.getChannels().iterator();
        while (localIterator.hasNext())
        {
          ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
          if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == paramChannelCoverInfo.mChannelCoverId))
          {
            c = k;
            break;
          }
          k += 1;
        }
      }
      RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.2(this, paramChannelCoverInfo), 0L);
    }
  }
  
  public void a(List<ChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNaviController", 2, "setAdapterData.");
    }
    this.h.setNaviBarAdapterDataSet(b(paramList));
  }
  
  public void b()
  {
    ReadInJoyNavigationGridview localReadInJoyNavigationGridview = this.h;
    if (localReadInJoyNavigationGridview != null) {
      localReadInJoyNavigationGridview.b();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.f);
  }
  
  public boolean c()
  {
    return this.g.findViewWithTag("mReadInJoyNavigation") != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController
 * JD-Core Version:    0.7.0.1
 */