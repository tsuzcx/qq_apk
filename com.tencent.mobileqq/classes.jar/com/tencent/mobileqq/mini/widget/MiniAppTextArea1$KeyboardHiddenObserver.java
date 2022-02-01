package com.tencent.mobileqq.mini.widget;

import android.os.Build;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class MiniAppTextArea1$KeyboardHiddenObserver
  implements Observer
{
  public MiniAppTextArea1$KeyboardHiddenObserver(MiniAppTextArea1 paramMiniAppTextArea1) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool1 = false;
    if (MiniAppTextArea1.access$600(this.this$0) != null)
    {
      int i;
      try
      {
        if ((paramObject instanceof String))
        {
          MiniAppTextArea1.access$802(this.this$0, false);
          if ((("confirm".equals((String)paramObject)) || ("hideKeyboard".equals((String)paramObject))) && ((!this.this$0.isFocused()) && (!"hideInput".equals((String)paramObject)))) {
            return;
          }
          if ((MiniAppTextArea1.access$600(this.this$0) != null) && (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime != null) && (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage() != null)) {
            MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
          }
          MiniAppTextArea1.access$2100(this.this$0, (String)paramObject);
          return;
        }
        if (!(paramObject instanceof Integer)) {
          return;
        }
        MiniAppTextArea1.access$802(this.this$0, true);
        if ((!MiniAppTextArea1.access$700(this.this$0)) && (MiniAppTextArea1.access$100(this.this$0))) {
          MiniAppTextArea1.access$702(this.this$0, true);
        }
      }
      catch (Exception paramObservable)
      {
        int j;
        label323:
        QLog.e("MiniAppTextArea1", 1, "KeyboardHiddenObserver error.", paramObservable);
        return;
      }
      try
      {
        paramObservable = new JSONObject();
        paramObservable.put("inputId", MiniAppTextArea1.access$900(this.this$0));
        j = MiniAppTextArea1.access$400(this.this$0);
        if (!MiniAppTextArea1.access$200(this.this$0)) {
          break label550;
        }
        i = MiniAppTextArea1.access$500(this.this$0);
        paramObservable.put("height", (int)((i + j) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
        QLog.d("MiniAppTextArea1", 1, "onKeyboardShow : " + paramObservable.toString());
        MiniAppTextArea1.access$600(this.this$0).getPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), MiniAppTextArea1.access$600(this.this$0).getPageWebview().pageWebviewId);
      }
      catch (Throwable paramObservable)
      {
        label550:
        break label323;
      }
      MiniAppTextArea1.access$402(this.this$0, (int)(Integer.valueOf(String.valueOf(paramObject)).intValue() * DisplayUtil.getDensity(this.this$0.getContext())));
      if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        bool1 = DisplayUtil.checkNavigationBarShow(MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.activity);
      }
      for (;;)
      {
        QLog.d("MiniAppTextArea1", 1, " hasNavBar : " + bool1);
        if (bool1) {
          MiniAppTextArea1.access$402(this.this$0, MiniAppTextArea1.access$400(this.this$0) + DisplayUtil.getNavigationBarHeight(MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.activity));
        }
        if (!this.this$0.isFocused()) {
          return;
        }
        if (MiniAppTextArea1.access$200(this.this$0))
        {
          i = MiniAppTextArea1.access$300(this.this$0);
          j = MiniAppTextArea1.access$400(this.this$0);
          int k = MiniAppTextArea1.access$500(this.this$0);
          MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().showKeyBoardConfirmView(i - j - k);
        }
        MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.jsPluginEngine.setCurInputId(MiniAppTextArea1.access$900(this.this$0));
        return;
        i = 0;
        break;
        if ((!DisplayUtil.hasNavBar(MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.activity)) || (!DisplayUtil.isNavigationBarExist(MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.activity)))
        {
          boolean bool2 = DisplayUtil.isFlymeOS7NavBarShow();
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */