package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView.HeadViewVisibleListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QQGameWebViewDelegate
  extends BaseViewDelegate<QQGameWebPresenter>
{
  private QQGamePubWebView c;
  private QQGameWebViewBuilder d;
  private QQGameHeadLayout e;
  private QQGameWebViewDelegate.QQGameWebViewCallBack f;
  
  public QQGameWebViewDelegate(QQGameWebPresenter paramQQGameWebPresenter, View paramView)
  {
    super(paramQQGameWebPresenter, paramView);
    this.e = ((QQGameHeadLayout)paramView.findViewById(2131442587));
    this.c = ((QQGamePubWebView)paramView.findViewById(2131442590));
    this.e.attachToRootView();
    this.c.attachHeaderView(this.e);
  }
  
  public QQGameHeadLayout a()
  {
    return this.e;
  }
  
  public void a(QBaseActivity paramQBaseActivity, GameWebCostLogic paramGameWebCostLogic, QQGamePubWebView.HeadViewVisibleListener paramHeadViewVisibleListener)
  {
    paramGameWebCostLogic.g();
    if (this.c == null) {
      this.c = new QQGamePubWebView(paramQBaseActivity);
    }
    GameVideoManager.a().a(this.c);
    this.d = new QQGameWebViewDelegate.1(this, paramQBaseActivity, paramQBaseActivity, ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), this.c, paramGameWebCostLogic);
    new WebViewDirector(this.d).a(null, ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), null);
    this.c = ((QQGamePubWebView)this.d.getWebView());
    this.c.setViewVisibleListener(paramHeadViewVisibleListener);
    this.c.setWillNotCacheDrawing(false);
    this.c.setDrawingCacheEnabled(true);
    paramGameWebCostLogic.h();
  }
  
  public void a(QQGameWebViewDelegate.QQGameWebViewCallBack paramQQGameWebViewCallBack)
  {
    this.f = paramQQGameWebViewCallBack;
  }
  
  public void a(String paramString, GameWebCostLogic paramGameWebCostLogic)
  {
    if (this.c == null)
    {
      QLog.e("QQGameWebViewDelegate", 1, "doGetAllMsgLogic webView is null");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("paramUrl = ");
      localStringBuilder.append(paramString);
      QLog.d("QQGameWebViewDelegate", 1, localStringBuilder.toString());
    }
    paramGameWebCostLogic.b();
    this.d.setTimeBeforeLoadUrl(System.currentTimeMillis());
    this.c.loadUrl(paramString);
  }
  
  public void a(Map<String, Object> paramMap)
  {
    try
    {
      if ((this.c != null) && (paramMap != null))
      {
        this.c.getPluginEngine().a(this.c.getUrl(), 8589934621L, paramMap);
        return;
      }
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public void b()
  {
    QQGameWebViewBuilder localQQGameWebViewBuilder = this.d;
    if (localQQGameWebViewBuilder != null) {
      localQQGameWebViewBuilder.onPause();
    }
  }
  
  public void c()
  {
    QQGameWebViewBuilder localQQGameWebViewBuilder = this.d;
    if (localQQGameWebViewBuilder != null) {
      localQQGameWebViewBuilder.onResume();
    }
  }
  
  public void d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((QQGamePubWebView)localObject).h();
    }
    localObject = this.d;
    if (localObject != null) {
      ((QQGameWebViewBuilder)localObject).onDestroy();
    }
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate
 * JD-Core Version:    0.7.0.1
 */