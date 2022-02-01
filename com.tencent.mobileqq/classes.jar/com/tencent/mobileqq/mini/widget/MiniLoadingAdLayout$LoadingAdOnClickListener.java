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
    paramView.c = 11;
    paramView.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.this$0.getContext());
    paramView.jdField_a_of_type_ComTencentGdtadAditemGdtAd = MiniLoadingAdLayout.access$100(this.this$0);
    paramView.jdField_a_of_type_Boolean = true;
    paramView.b = MiniLoadingAdLayout.access$900(this.this$0);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniappD");
    paramView.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
    localObject = MiniLoadingAdLayout.access$1000(this.this$0, MiniLoadingAdLayout.access$000(this.this$0));
    Bundle localBundle = MiniLoadingAdLayout.access$200(this.this$0, MiniLoadingAdLayout.access$000(this.this$0), MiniLoadingAdLayout.access$100(this.this$0).getUrlForClick(), 5);
    paramView.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
    QLog.i("MiniLoadingAdLayout", 1, "report click antiSpamParams=" + ((JSONObject)localObject).toString());
    GdtHandler.a(paramView);
    MiniLoadingAdLayout.report(localBundle);
    if (this.loadingAdListener != null) {
      this.loadingAdListener.onAdClick(this.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.LoadingAdOnClickListener
 * JD-Core Version:    0.7.0.1
 */