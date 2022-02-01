package com.tencent.mobileqq.mini.widget;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class MiniAppTextArea$KeyboardHiddenObserver
  implements Observer
{
  public MiniAppTextArea$KeyboardHiddenObserver(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i = 0;
    if (MiniAppTextArea.access$500(this.this$0) != null) {
      try
      {
        if ((paramObject instanceof String))
        {
          if (((!"confirm".equals((String)paramObject)) && (!"hideKeyboard".equals((String)paramObject))) || ((this.this$0.isFocused()) || ("hideInput".equals((String)paramObject))))
          {
            MiniAppTextArea.access$802(this.this$0, false);
            if ((MiniAppTextArea.access$500(this.this$0) != null) && (MiniAppTextArea.access$500(this.this$0).appBrandRuntime != null) && (MiniAppTextArea.access$500(this.this$0).appBrandRuntime.getCurPage() != null)) {
              MiniAppTextArea.access$500(this.this$0).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
            }
            if (MiniAppTextArea.access$900(this.this$0) != 0) {
              EditAreaAnimatorUtil.editAreaAnimator(MiniAppTextArea.access$500(this.this$0), MiniAppTextArea.access$900(this.this$0), 0.0F, 1.0F, 1.0F);
            }
            MiniAppTextArea.access$1000(this.this$0, (String)paramObject);
            MiniAppTextArea.access$902(this.this$0, 0);
            MiniAppTextArea.access$1102(this.this$0, 0);
          }
        }
        else if ((paramObject instanceof Integer))
        {
          MiniAppTextArea.access$302(this.this$0, (int)(Integer.valueOf(String.valueOf(paramObject)).intValue() * DisplayUtil.getDensity(this.this$0.getContext())));
          if ((DisplayUtil.hasNavBar(MiniAppTextArea.access$500(this.this$0).appBrandRuntime.activity)) && (DisplayUtil.isNavigationBarExist(MiniAppTextArea.access$500(this.this$0).appBrandRuntime.activity))) {
            MiniAppTextArea.access$302(this.this$0, MiniAppTextArea.access$300(this.this$0) + DisplayUtil.getNavigationBarHeight(MiniAppTextArea.access$500(this.this$0).appBrandRuntime.activity));
          }
          MiniAppTextArea.access$1200(this.this$0);
          if (this.this$0.isFocused())
          {
            if (MiniAppTextArea.access$100(this.this$0))
            {
              j = MiniAppTextArea.access$200(this.this$0);
              int k = MiniAppTextArea.access$300(this.this$0);
              int m = MiniAppTextArea.access$400(this.this$0);
              MiniAppTextArea.access$500(this.this$0).appBrandRuntime.getCurPage().showKeyBoardConfirmView(j - k - m);
            }
            MiniAppTextArea.access$500(this.this$0).appBrandRuntime.jsPluginEngine.setCurInputId(MiniAppTextArea.access$1300(this.this$0));
            paramObservable = new JSONObject();
            paramObservable.put("inputId", MiniAppTextArea.access$1300(this.this$0));
            int j = MiniAppTextArea.access$300(this.this$0);
            if (MiniAppTextArea.access$100(this.this$0)) {
              i = MiniAppTextArea.access$400(this.this$0);
            }
            paramObservable.put("height", (int)((i + j) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
            MiniAppTextArea.access$500(this.this$0).getPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), MiniAppTextArea.access$500(this.this$0).getPageWebview().pageWebviewId);
            return;
          }
        }
      }
      catch (Exception paramObservable)
      {
        QLog.e("MiniAppTextArea", 1, "KeyboardHiddenObserver error.", paramObservable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */