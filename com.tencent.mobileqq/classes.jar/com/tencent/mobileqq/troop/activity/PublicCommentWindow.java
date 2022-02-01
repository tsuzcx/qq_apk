package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicCommentWindow
  extends ReportDialog
  implements View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected ImageView a;
  protected EditText b;
  protected Button c;
  protected InputMethodRelativeLayout d;
  protected SystemAndEmojiEmoticonPanel e;
  protected FrameLayout f = null;
  protected JSONObject g = null;
  protected String h = null;
  protected int i = 0;
  protected int j = 0;
  protected String k = null;
  protected boolean l = false;
  protected long m = 0L;
  protected Handler n = null;
  protected boolean o = false;
  protected PublicCommentWindow.JsEventReceiver p = null;
  protected ArrayList<String> q = null;
  protected QBaseActivity r;
  protected String s;
  
  public PublicCommentWindow(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super(paramQBaseActivity);
    requestWindowFeature(1);
    this.r = paramQBaseActivity;
    a(paramBundle);
  }
  
  protected void a()
  {
    String str = this.b.getEditableText().toString();
    if (!android.text.TextUtils.isEmpty(str)) {
      TroopBarUtils.i.put(this.h, str);
    }
  }
  
  public void a(Activity paramActivity)
  {
    long l1 = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131625950, null);
    setContentView(paramActivity);
    a(paramActivity);
    b();
    super.show();
    paramActivity = getWindow().getAttributes();
    paramActivity.x = 0;
    paramActivity.y = 0;
    paramActivity.width = -1;
    paramActivity.windowAnimations = 16973824;
    paramActivity.gravity = 83;
    paramActivity.softInputMode = 21;
    getWindow().setBackgroundDrawable(new ColorDrawable());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("PublicCommentWindow show time = ");
      paramActivity.append(System.currentTimeMillis() - l1);
      QLog.d("PublicCommentPopupWindow", 2, paramActivity.toString());
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("options");
    this.s = paramBundle.getString("onclose");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Comment option: ");
      paramBundle.append(str);
      QLog.d("PublicCommentPopupWindow", 2, paramBundle.toString());
    }
    try
    {
      this.g = new JSONObject(str);
      this.h = this.g.optString("draftID");
      this.i = this.g.optInt("maxContentLength");
      this.j = this.g.optInt("minContentLength");
      this.k = this.g.optString("contentPlaceholder");
      this.q = new ArrayList();
      try
      {
        paramBundle = Uri.parse(this.g.optString("referer"));
        this.q.add(paramBundle.getHost());
      }
      catch (NullPointerException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramBundle));
        }
      }
      this.p = new PublicCommentWindow.JsEventReceiver(this);
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.r.registerReceiver(this.p, paramBundle);
      return;
    }
    catch (JSONException paramBundle)
    {
      break label216;
    }
    catch (NullPointerException paramBundle)
    {
      label211:
      label216:
      break label211;
    }
    dismiss();
    return;
    dismiss();
  }
  
  protected void a(View paramView)
  {
    this.d = ((InputMethodRelativeLayout)paramView.findViewById(2131445137));
    this.a = ((ImageView)paramView.findViewById(2131432400));
    this.b = ((EditText)paramView.findViewById(2131435808));
    this.c = ((Button)paramView.findViewById(2131445580));
    this.f = ((FrameLayout)paramView.findViewById(2131436914));
    this.a.setOnClickListener(this);
    this.c.setSelected(true);
    this.c.setEnabled(true);
    this.c.setOnClickListener(this);
    paramView.findViewById(2131447846).setOnClickListener(this);
    this.e = TroopBarPublishUtils.a(this.r, this.f, this.b, this);
    this.d.setOnSizeChangedListenner(this);
    this.n = new Handler();
    this.b.setHint(this.k);
  }
  
  protected void a(String paramString)
  {
    try
    {
      EventApiPlugin.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.a(paramString, null, null)), this.q, null);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      Object localObject = this.r;
      if ((localObject instanceof SwiftWebViewFragmentSupporter))
      {
        localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
        if (localObject != null)
        {
          localObject = ((WebViewFragment)localObject).getWebView();
          if (localObject != null)
          {
            if (paramBoolean)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("{\"code\":0,\"data\":{\"retcode\":0,\"result\":");
              localStringBuilder.append(paramString2);
              localStringBuilder.append("}}");
              ((CustomWebView)localObject).callJs(paramString1, new String[] { localStringBuilder.toString() });
              return;
            }
            ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":-1}" });
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SystemAndEmojiEmoticonPanel localSystemAndEmojiEmoticonPanel = this.e;
    if (localSystemAndEmojiEmoticonPanel == null) {
      return;
    }
    if (paramBoolean)
    {
      EventApiPlugin.a("qbrowserCommentOnCreate", null, this.q, null);
      if (this.e.getVisibility() == 0) {
        this.e.setVisibility(8);
      }
      this.a.setImageResource(2130849798);
      this.a.setContentDescription(this.r.getString(2131894012));
      return;
    }
    if ((localSystemAndEmojiEmoticonPanel.getVisibility() == 8) && (!this.o)) {
      dismiss();
    }
  }
  
  protected boolean b()
  {
    String str = (String)TroopBarUtils.i.get(this.h);
    TroopBarUtils.i.clear();
    if (!android.text.TextUtils.isEmpty(str))
    {
      this.b.setText(str);
      this.b.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.b);
  }
  
  public void dismiss()
  {
    PublicCommentWindow.JsEventReceiver localJsEventReceiver = this.p;
    if (localJsEventReceiver != null)
    {
      this.r.unregisterReceiver(localJsEventReceiver);
      this.p = null;
    }
    if (this.e != null) {
      this.e = null;
    }
    InputMethodUtil.b(this.b);
    if (!this.l) {
      a();
    }
    EventApiPlugin.a("qbrowserCommentOnClose", null, this.q, null);
    super.dismiss();
  }
  
  public void emoticonMall() {}
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131432400)
    {
      if (i1 != 2131445580)
      {
        if (i1 == 2131447846) {
          dismiss();
        }
      }
      else {
        send();
      }
    }
    else if (System.currentTimeMillis() - this.m >= 500L)
    {
      this.m = System.currentTimeMillis();
      if (this.e.getVisibility() == 0)
      {
        this.e.setVisibility(8);
        InputMethodUtil.a(this.b);
        this.a.setImageResource(2130849798);
        this.a.setContentDescription(this.r.getString(2131894012));
      }
      else
      {
        this.o = true;
        InputMethodUtil.b(this.b);
        this.n.postDelayed(new PublicCommentWindow.1(this), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    Object localObject = TroopBarUtils.a(this.b);
    int i1;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).trim();
      i1 = ((String)localObject).length();
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QQToast.makeText(this.r, 2131894030, 0).show(this.r.getTitleBarHeight());
      return;
    }
    int i2 = this.j;
    if (i1 < i2)
    {
      localObject = this.r;
      QQToast.makeText((Context)localObject, ((QBaseActivity)localObject).getString(2131894028, new Object[] { Integer.valueOf(i2) }), 0).show(this.r.getTitleBarHeight());
      return;
    }
    i2 = this.i;
    if (i1 > i2)
    {
      localObject = this.r;
      QQToast.makeText((Context)localObject, ((QBaseActivity)localObject).getString(2131894029, new Object[] { Integer.valueOf(i2) }), 0).show(this.r.getTitleBarHeight());
      return;
    }
    if (!HttpUtil.isConnect(this.r))
    {
      QQToast.makeText(this.r, 2131892074, 0).show(this.r.getTitleBarHeight());
      return;
    }
    a((String)localObject);
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(null, this.r, this.b, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow
 * JD-Core Version:    0.7.0.1
 */