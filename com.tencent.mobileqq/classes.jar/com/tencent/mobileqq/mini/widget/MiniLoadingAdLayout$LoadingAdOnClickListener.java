package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class MiniLoadingAdLayout$LoadingAdOnClickListener
  implements View.OnClickListener
{
  public static final int TYPE_CLICK_BAR = 1;
  public static final int TYPE_CLICK_IMG = 0;
  private AdProxy.ILoadingAdListener loadingAdListener;
  private int type;
  
  public MiniLoadingAdLayout$LoadingAdOnClickListener(MiniLoadingAdLayout paramMiniLoadingAdLayout, int paramInt, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    this.type = paramInt;
    this.loadingAdListener = paramILoadingAdListener;
  }
  
  public void onClick(View paramView)
  {
    QLog.i("MiniLoadingAdLayout", 1, "LoadingAd reportClick");
    paramView = new GdtHandler.Params();
    paramView.q = 11;
    paramView.r = new WeakReference((Activity)this.this$0.getContext());
    paramView.a = MiniLoadingAdLayout.access$100(this.this$0);
    paramView.b = true;
    paramView.e = MiniLoadingAdLayout.access$900(this.this$0);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("big_brother_ref_source_key", "biz_src_miniappD");
    paramView.p = ((Bundle)localObject1);
    localObject1 = this.this$0;
    localObject1 = MiniLoadingAdLayout.access$1000((MiniLoadingAdLayout)localObject1, MiniLoadingAdLayout.access$000((MiniLoadingAdLayout)localObject1));
    Object localObject2 = this.this$0;
    localObject2 = MiniLoadingAdLayout.access$200((MiniLoadingAdLayout)localObject2, MiniLoadingAdLayout.access$000((MiniLoadingAdLayout)localObject2), MiniLoadingAdLayout.access$100(this.this$0).getUrlForClick(), 5);
    paramView.n = ((JSONObject)localObject1).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report click antiSpamParams=");
    localStringBuilder.append(((JSONObject)localObject1).toString());
    QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString());
    GdtHandler.a(paramView);
    MiniLoadingAdLayout.report((Bundle)localObject2);
    paramView = this.loadingAdListener;
    if (paramView != null) {
      paramView.onAdClick(this.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.LoadingAdOnClickListener
 * JD-Core Version:    0.7.0.1
 */