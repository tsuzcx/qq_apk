package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.DragView;
import java.util.HashMap;

public class AIOBrowserScene
  extends MainBrowserScene
{
  public TextureView a;
  private AIOBrowserPresenter b;
  private View c;
  private Handler d;
  
  public AIOBrowserScene(Context paramContext, AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    super(paramContext, paramAIOBrowserPresenter);
    this.mContext = paramContext;
    this.b = paramAIOBrowserPresenter;
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("data_changed_error", paramString);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "richmediaBrowserDataChanged", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 19002) && ((this.mContext instanceof Activity)))
    {
      if (paramInt2 == -1) {
        ((Activity)this.mContext).setResult(-1, paramIntent);
      }
      ((Activity)this.mContext).finish();
      return;
    }
    if (paramInt1 == 19000) {
      return;
    }
    if (paramInt1 == 19005)
    {
      if (paramInt2 == -1)
      {
        paramIntent = c();
        if (paramIntent != null) {
          paramIntent.d();
        }
      }
    }
    else
    {
      if (paramInt1 == 103) {
        return;
      }
      if ((paramInt2 == -1) && (paramInt1 == 0) && ((this.mContext instanceof Activity)))
      {
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).startChatAndSendMsg((Activity)this.mContext, paramIntent.getExtras());
        if (ParamsManager.a().i() == 9501) {
          ((Activity)this.mContext).finish();
        }
      }
      else if ((paramInt2 == -1) && (paramInt1 == 10001))
      {
        QQToast.makeText(this.mContext, 2131915756, 0).show();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextureView localTextureView = this.a;
    if (localTextureView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextureView.setVisibility(i);
    }
  }
  
  public boolean a()
  {
    TextureView localTextureView = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTextureView != null)
    {
      bool1 = bool2;
      if (localTextureView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.postDelayed(new AIOBrowserScene.1(this), 1000L);
    }
  }
  
  public boolean back()
  {
    a(false);
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.d = new Handler(Looper.getMainLooper());
  }
  
  public AIOBrowserBaseView c()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((AIOBrowserPresenter)localObject).b != null))
    {
      localObject = this.b.b.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = this.b.getDecoratorPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localObject instanceof AIOBrowserBasePresenter)) {
          return ((AIOBrowserBasePresenter)localObject).b;
        }
      }
    }
    return null;
  }
  
  public void initView()
  {
    super.initView();
    this.mDragView.setOriginRect(ParamsManager.a().t());
    this.c = LayoutInflater.from(this.mContext).inflate(2131629203, null);
    if (BrowserDanmakuUtils.a()) {
      this.a = ((TextureView)this.c.findViewById(2131431573));
    }
    getContentView().addView(this.c);
  }
  
  public boolean needEnterRectAnimation()
  {
    return true;
  }
  
  public boolean needExitRectAnimation()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    try
    {
      super.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      a("AIOBrowserScene");
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDataSetChanged exception = ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOBrowserScene", 4, localStringBuilder.toString());
    }
  }
  
  public void onContentMove(float paramFloat)
  {
    super.onContentMove(paramFloat);
    Object localObject = this.b;
    if (localObject != null) {
      ((AIOBrowserPresenter)localObject).a(false);
    }
    localObject = c();
    if (localObject != null) {
      ((AIOBrowserBaseView)localObject).b(false);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mRoot.setVisibility(4);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.d;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.d = null;
    }
  }
  
  public void onGestureFinish()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      Object localObject2 = null;
      RichMediaBrowserInfo localRichMediaBrowserInfo = ((AIOBrowserPresenter)localObject1).b.getSelectedItem();
      localObject1 = localObject2;
      if (localRichMediaBrowserInfo != null)
      {
        localObject1 = localObject2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if (localRichMediaBrowserInfo.baseData.getType() == 100)
          {
            localObject1 = "0X8009AB2";
          }
          else
          {
            localObject1 = localObject2;
            if (localRichMediaBrowserInfo.baseData.getType() == 101) {
              localObject1 = "0X8009AB3";
            }
          }
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, ParamsManager.a().o(), 0, "", "", "", "");
      }
      this.b.k();
    }
    super.onGestureFinish();
  }
  
  public void onResetPosition()
  {
    if (ParamsManager.a().o() == 4) {
      return;
    }
    super.onResetPosition();
    Object localObject = this.b;
    if (localObject != null) {
      ((AIOBrowserPresenter)localObject).f();
    }
    localObject = c();
    if (localObject != null) {
      ((AIOBrowserBaseView)localObject).b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene
 * JD-Core Version:    0.7.0.1
 */