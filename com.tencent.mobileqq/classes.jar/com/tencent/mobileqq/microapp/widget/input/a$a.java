package com.tencent.mobileqq.microapp.widget.input;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public final class a$a
  implements Observer
{
  public a$a(a parama) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if (!(paramObject instanceof String)) {
        break label110;
      }
      if ("hideKeyboard".equals((String)paramObject))
      {
        if (a.b(this.a) == null) {
          return;
        }
        if (a.b(this.a).getContext() == null) {
          return;
        }
        paramObservable = (InputMethodManager)a.b(this.a).getContext().getSystemService("input_method");
        if (paramObservable == null) {
          return;
        }
        paramObservable.hideSoftInputFromWindow(a.b(this.a).getWindowToken(), 0);
        return;
      }
    }
    catch (Exception paramObservable)
    {
      paramObservable.printStackTrace();
      return;
    }
    if ("hideInput".equals((String)paramObject))
    {
      this.a.a(false);
      return;
      label110:
      if (((paramObject instanceof Integer)) && (a.b(this.a) != null))
      {
        paramObservable = new JSONObject();
        paramObservable.put("inputId", a.a(this.a));
        paramObservable.put("height", paramObject);
        a.b(this.a).getCurrentPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), a.b(this.a).getCurrentPageWebview().pageWebviewId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */