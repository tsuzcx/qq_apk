package com.tencent.mobileqq.wink.editor;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkResManager;
import com.tencent.mobileqq.wink.edit.log.TavCutQLog;
import com.tencent.mobileqq.wink.editor.view.ProgressView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.config.DynamicSoConfig;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ISessionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public abstract class WinkTAVCutBaseFragment
  extends BasePartFragment
{
  protected ICutSession a;
  protected IPlayer b;
  protected Handler c = new Handler(Looper.getMainLooper());
  protected Dialog d;
  protected ProgressView e;
  private boolean f = false;
  
  private void n()
  {
    WinkResManager.a(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath());
    TavCut.a(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightAssetsDir());
    TavCut.a(new ArrayList(Collections.singleton(new DynamicSoConfig(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath(), "liblight-sdk.so", false))));
  }
  
  private void o()
  {
    TavCut.a(getActivity());
    TavCutQLog.a(2, 6);
    this.a = TavCut.a.b();
    RenderModel localRenderModel = TavCut.a.c(a());
    this.a.a(localRenderModel);
    if (f() != null) {
      this.a.a(f());
    }
    this.b = TavCut.a.a(e());
    this.b.b(k());
    this.b.a(i());
    if (g() != null) {
      this.b.a(g());
    }
    this.a.a(this.b);
  }
  
  private void u()
  {
    Object localObject;
    if (this.D == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister mContentView == null , subPage: ");
      ((StringBuilder)localObject).append(b());
      QLog.i("BasePartFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    if (!TextUtils.isEmpty(l())) {
      localObject = l();
    } else {
      localObject = b();
    }
    VideoReport.setPageId(this.D, (String)localObject);
    VideoReport.setPageParams(this.D, new WinkDTParamBuilder().buildPageParams(m()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister subPage: ");
    localStringBuilder.append(b());
    localStringBuilder.append(", pageId: ");
    localStringBuilder.append((String)localObject);
    QLog.i("BasePartFragment", 1, localStringBuilder.toString());
  }
  
  protected abstract String a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    u();
  }
  
  protected abstract FrameLayout e();
  
  protected abstract ISessionListener f();
  
  protected abstract IPlayer.PlayerListener g();
  
  protected void h()
  {
    this.a.g();
  }
  
  protected boolean i()
  {
    return true;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public abstract String l();
  
  protected Map<String, Object> m()
  {
    return null;
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    n();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    h();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.b.c())
    {
      this.b.b();
      this.f = true;
      return;
    }
    this.f = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.f) {
      this.b.a();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkTAVCutBaseFragment
 * JD-Core Version:    0.7.0.1
 */