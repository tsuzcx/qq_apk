package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.LooperGifImage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountGifPlayTimeHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCapsuleView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyFeedsHeaderViewController
  extends HeaderViewController
  implements View.OnClickListener
{
  protected static int e = 0;
  private static Drawable i = new ColorDrawable(Color.parseColor("#F1F3F6"));
  private static int j = Color.parseColor("#47000000");
  protected boolean a = false;
  HotWordSearchEntryDataModel b;
  protected UniteSearchHandler c;
  protected UniteSearchObserver d = new ReadInJoyFeedsHeaderViewController.2(this);
  protected String f;
  protected boolean g = true;
  protected BroadcastReceiver h = new ReadInJoyFeedsHeaderViewController.4(this);
  private Context k;
  private View l;
  private URLImageView m;
  private ReadInJoyCapsuleView n;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController o;
  private ReadInJoyCapsuleView p;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController q;
  private ReadInJoyCapsuleView r;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController s;
  private LooperGifImage t;
  private ReadInJoyObserver u = new ReadInJoyFeedsHeaderViewController.1(this);
  private URLDrawableDownListener v = new ReadInJoyFeedsHeaderViewController.6(this);
  
  public ReadInJoyFeedsHeaderViewController(Context paramContext)
  {
    this.k = paramContext;
    this.l = LayoutInflater.from(this.k).inflate(2131626247, null);
    Object localObject = this.l.findViewById(2131447277);
    this.n = ((ReadInJoyCapsuleView)this.l.findViewById(2131430303));
    this.o = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.n);
    this.p = ((ReadInJoyCapsuleView)this.l.findViewById(2131430302));
    this.q = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.p);
    this.r = ((ReadInJoyCapsuleView)this.l.findViewById(2131430301));
    this.s = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.r);
    this.m = ((URLImageView)this.l.findViewById(2131436419));
    b(a(ReadInJoyLogicEngine.a().c(0)));
    ((View)localObject).setOnClickListener(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.u);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.d);
    g();
    localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.h, (IntentFilter)localObject);
  }
  
  private URLDrawable a(ChannelCoverInfo paramChannelCoverInfo, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramChannelCoverInfo = new PublicAccountGifPlayTimeHttpDownloaderImpl().getPubURL(paramChannelCoverInfo.externalExposureBackgroundUrl);
    if (paramChannelCoverInfo == null) {
      return null;
    }
    paramChannelCoverInfo = URLDrawable.getDrawable(paramChannelCoverInfo, (URLDrawable.URLDrawableOptions)localObject);
    if ((paramChannelCoverInfo.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramChannelCoverInfo.getCurrDrawable()).getImage();
      paramChannelCoverInfo.setIndividualPause(paramBoolean ^ true);
      ((AbstractGifImage)localObject).reset();
    }
    return paramChannelCoverInfo;
  }
  
  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = Collections.emptyList();
    }
    return localObject;
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a(paramList).iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      if ((localChannelCoverInfo.isExternalExposure) && (((RIJShowKanDianTabSp.c()) && (!ReadInJoyHelper.v())) || (localChannelCoverInfo.mChannelCoverId != 56)))
      {
        paramList = localChannelCoverInfo.externalExposureBackgroundUrl;
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.equals(ReadInJoyHelper.g(localChannelCoverInfo.mChannelCoverId), paramList)))
        {
          if (localChannelCoverInfo.isExternalExposurePersist) {
            paramList = "";
          }
          ReadInJoyHelper.a(paramList, localChannelCoverInfo.mChannelCoverId);
          ReadInJoyHelper.a(localChannelCoverInfo.mChannelCoverId, false);
        }
        localArrayList.add(localChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    URLDrawable localURLDrawable = a(paramChannelCoverInfo, true);
    if (localURLDrawable == null) {
      return;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      if ((localURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)localURLDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof LooperGifImage))
        {
          this.t = ((LooperGifImage)localAbstractGifImage);
          this.t.a(new ReadInJoyFeedsHeaderViewController.5(this, paramChannelCoverInfo));
        }
      }
      this.v.onLoadSuccessed(this.m, localURLDrawable);
    }
    else
    {
      localURLDrawable.startDownload();
    }
    this.m.setURLDrawableDownListener(this.v);
    this.m.setImageDrawable(localURLDrawable);
    this.m.setTag(paramChannelCoverInfo);
    this.m.setOnClickListener(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("is_pic", i1);
      a(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      label38:
      break label38;
    }
    throw new IllegalArgumentException("fail to construct json object");
  }
  
  private static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt != 56)
      {
        if (paramInt != 1000000) {
          return 0;
        }
        return 2130843979;
      }
      return 2130843982;
    }
    if (paramInt != 56)
    {
      if (paramInt != 1000000) {
        return 0;
      }
      return 2130843978;
    }
    return 2130843981;
  }
  
  private void b(List<ChannelCoverInfo> paramList)
  {
    this.n.setVisibility(8);
    this.p.setVisibility(8);
    this.r.setVisibility(8);
    this.m.setVisibility(8);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      int i1 = localChannelCoverInfo.mChannelCoverId;
      ReadInJoyCapsuleView localReadInJoyCapsuleView = null;
      if (i1 == 56)
      {
        localReadInJoyCapsuleView = this.n;
        paramList = this.o;
      }
      else if (localChannelCoverInfo.mChannelCoverId == 1000000)
      {
        localReadInJoyCapsuleView = this.p;
        paramList = this.q;
      }
      else if (localChannelCoverInfo.mChannelCoverId == 2000000)
      {
        a(localChannelCoverInfo);
        paramList = null;
      }
      else
      {
        localReadInJoyCapsuleView = this.r;
        paramList = this.s;
      }
      if (localReadInJoyCapsuleView != null)
      {
        localReadInJoyCapsuleView.setVisibility(0);
        localReadInJoyCapsuleView.setText(localChannelCoverInfo.mChannelCoverName);
        paramList.a(localChannelCoverInfo, this);
      }
    }
  }
  
  public void a()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "reportExposure");
    if (this.o.a() != null) {
      a("0X8008B88", this.o.c());
    }
    if (this.q.a() != null) {
      a("0X8008B89", this.q.c());
    }
  }
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.l);
  }
  
  public void b()
  {
    this.g = false;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.u);
    this.o.d();
    this.q.d();
    this.s.d();
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.d);
    this.k.unregisterReceiver(this.h);
    this.a = true;
    LooperGifImage localLooperGifImage = this.t;
    if (localLooperGifImage != null) {
      localLooperGifImage.a();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.g) {
      this.g = false;
    } else {
      f();
    }
    AbstractGifImage.resumeAll();
  }
  
  public void d() {}
  
  protected void f()
  {
    HotWordSearchEntryDataModel localHotWordSearchEntryDataModel = this.b;
    if ((localHotWordSearchEntryDataModel != null) && (localHotWordSearchEntryDataModel.b != null))
    {
      if (this.b.b.size() == 0) {
        return;
      }
      int i1 = this.b.b.size();
      this.f = ((HotWordSearchEntryDataModel.HotSearchItem)this.b.b.get(e % i1)).title;
      ((TextView)this.l.findViewById(2131447277)).setText(this.f);
      e += 1;
    }
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    IReadInJoySearchJumpUrlConfBean localIReadInJoySearchJumpUrlConfBean = ReadInjoySearchJumpurlConfProcessor.a();
    if ((localIReadInJoySearchJumpUrlConfBean != null) && (!TextUtils.isEmpty(localIReadInJoySearchJumpUrlConfBean.a())))
    {
      this.b = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 6, false);
      ThreadManager.post(new ReadInJoyFeedsHeaderViewController.3(this, localQQAppInterface), 5, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject1 = null;
    switch (i1)
    {
    default: 
      return;
    case 2131447277: 
      Object localObject2 = this.b;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((HotWordSearchEntryDataModel)localObject2).b != null)
        {
          paramView = (View)localObject1;
          if (this.b.b.size() > 0)
          {
            paramView = (View)localObject1;
            if (e > 0)
            {
              i1 = this.b.b.size();
              paramView = (HotWordSearchEntryDataModel.HotSearchItem)this.b.b.get((e - 1) % i1);
            }
          }
        }
      }
      RIJWebSearchUtils.a((Activity)this.k, paramView);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search").ver1(this.f);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(paramView, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
      return;
    case 2131436419: 
      localObject1 = (ChannelCoverInfo)paramView.getTag();
      ReadInJoyUtils.a(paramView.getContext(), ((ChannelCoverInfo)localObject1).mChannelJumpUrl);
      a("0X800920D", new JSONObject());
      return;
    case 2131430303: 
      paramView = this.o.a();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
      ((HashMap)localObject1).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
      ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(this.k, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject1);
      a("0X8008B84", this.o.c());
      return;
    }
    this.q.a();
    ViolaAccessHelper.a(this.k, HardCodeUtil.a(2131910524), "https://kandian.qq.com/viola/bundle_hotTopic.js?v_bid=3256&statusColor=1", null);
    a("0X8008B85", this.q.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController
 * JD-Core Version:    0.7.0.1
 */