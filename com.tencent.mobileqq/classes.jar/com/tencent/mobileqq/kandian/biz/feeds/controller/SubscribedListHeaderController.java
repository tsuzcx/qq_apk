package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribedListHeaderController
{
  private VafContext a = new VafContext();
  private TemplateFactory b;
  private FrameLayout c;
  private JSONObject d;
  private TemplateBean e;
  private Container f;
  
  public SubscribedListHeaderController(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    this.a.setContext(paramActivity);
    this.a.setCurActivity(paramActivity);
    this.b = TemplateFactory.a("default_feeds", true);
    ProteusSupportUtil.a(this.a, "default_feeds");
    this.a.setTemplateFactory(this.b);
    this.c = paramFrameLayout;
    b();
  }
  
  private void b()
  {
    try
    {
      String str = (String)RIJSPUtils.b("readinjoy_follow_subscribed_list_data_key", "");
      if (!TextUtils.isEmpty(str))
      {
        a(new JSONObject(str));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      if (this.c == null) {
        return;
      }
    }
    try
    {
      TemplateBean localTemplateBean;
      if (this.b != null) {
        localTemplateBean = this.b.getTemplateBean(paramJSONObject);
      } else {
        localTemplateBean = null;
      }
      if (localTemplateBean == null)
      {
        QLog.d("SubscribedListHeaderController", 1, "templateBean is null");
        return;
      }
      if (this.d == null)
      {
        Container localContainer = this.a.getViewFactory().inflate(this.a, localTemplateBean);
        if (localContainer == null) {
          return;
        }
        localContainer.setBackgroundResource(2130842690);
        this.c.addView(localContainer, -1, -1);
        this.c.setVisibility(0);
        this.f = localContainer;
      }
      ProteusSupportUtil.a(this.f, this.a, localTemplateBean);
      ViewFactory.findClickableViewListener(this.f.getVirtualView(), new SubscribedListHeaderController.1(this, localTemplateBean));
      ProteusSupportUtil.a(this.f, this.e, localTemplateBean);
      this.d = paramJSONObject;
      this.e = localTemplateBean;
      ProteusSupportUtil.a(localTemplateBean, this.f.getVirtualView(), "expose_T");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("update subscribed list data : ");
      paramJSONObject.append(this.d);
      QLog.d("SubscribedListHeaderController", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public boolean a()
  {
    return this.c.getVisibility() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscribedListHeaderController
 * JD-Core Version:    0.7.0.1
 */