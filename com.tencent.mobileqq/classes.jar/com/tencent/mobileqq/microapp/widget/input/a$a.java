package com.tencent.mobileqq.microapp.widget.input;

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
      if ((paramObject instanceof String))
      {
        if ("hideKeyboard".equals((String)paramObject)) {
          return;
        }
        if ("hideInput".equals((String)paramObject)) {
          this.a.a(false);
        }
      }
      else if ((paramObject instanceof Integer))
      {
        if (a.b(this.a) == null) {
          return;
        }
        paramObservable = new JSONObject();
        paramObservable.put("inputId", a.a(this.a));
        paramObservable.put("height", paramObject);
        a.b(this.a).getCurrentPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), a.b(this.a).getCurrentPageWebview().pageWebviewId);
        return;
      }
    }
    catch (Exception paramObservable)
    {
      paramObservable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */