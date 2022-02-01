package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DocsEntranceHelper
  implements View.OnClickListener, IHomeworkHelper
{
  protected String a = "";
  protected PublishHomeWorkFragment b;
  protected View c;
  protected TextView d;
  protected View e;
  protected LinearLayout f;
  protected TextView g;
  protected View h;
  protected Boolean i = Boolean.valueOf(false);
  protected String j = "";
  protected int k = 0;
  protected String l = "";
  protected String m = "";
  protected JSONObject n = null;
  protected boolean o = false;
  protected long p = 0L;
  protected boolean q = false;
  protected boolean r = true;
  protected boolean s = false;
  
  public DocsEntranceHelper(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.b = paramPublishHomeWorkFragment;
    this.a = paramString;
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToDocs");
    }
    paramView = (PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605);
    if (paramView != null)
    {
      paramView = paramView.e();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=");
      paramView.append(this.a);
      paramView.append("&appid=");
      paramView.append("101458937");
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramView);
      RouteUtils.a(this.b.getActivity(), (Intent)localObject, "/base/browser", 265);
      if (this.b.c() != null) {
        this.b.c().b();
      }
      if (this.d.getVisibility() == 0)
      {
        a(false, 3);
        c(false);
        d(false);
      }
    }
    Bundle localBundle = this.b.d();
    Object localObject = this.a;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = "";
    }
    TroopReportor.a("Grp_edu", "homework", "createHW_doc_clk", 0, 0, new String[] { paramView, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.postImmediately(new DocsEntranceHelper.3(this, paramBoolean, paramInt), null, false);
  }
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
    }
    paramView = (PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605);
    if (paramView != null)
    {
      paramView = paramView.f();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=");
      paramView.append(this.a);
      paramView.append("&appid=");
      paramView.append("101458937");
      paramView.append("&examid=");
      paramView.append(this.m);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramView);
      RouteUtils.a(this.b.getActivity(), localIntent, "/base/browser");
      if (this.b.c() != null) {
        this.b.c().b();
      }
    }
  }
  
  private void c(View paramView)
  {
    a(false);
    paramView = this.f;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.b.a(2);
  }
  
  private void c(boolean paramBoolean)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setVisibility(0);
        this.d.setText("");
        this.d.setBackgroundResource(0);
        this.d.setCompoundDrawablesWithIntrinsicBounds(2130837936, 0, 0, 0);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private boolean c()
  {
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605);
    boolean bool = false;
    if ((localPublishHwkThirdPartyEntryConfig != null) && (!localPublishHwkThirdPartyEntryConfig.d())) {
      return false;
    }
    int i1 = PreferenceManager.getDefaultSharedPreferences(this.b.getActivity()).getInt(d(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i1) }));
    }
    if (i1 < 3) {
      bool = true;
    }
    return bool;
  }
  
  private String d()
  {
    if (this.b.getActivity() == null) {
      localObject1 = null;
    } else {
      localObject1 = (AppInterface)this.b.getQBaseActivity().getAppRuntime();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject2 instanceof AppInterface)) {
        localObject1 = (AppInterface)localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return "publish_hw_docs_guide_counts";
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("publish_hw_docs_guide_counts");
    ((StringBuilder)localObject1).append(((AppInterface)localObject2).getCurrentAccountUin());
    return ((StringBuilder)localObject1).toString();
  }
  
  private void d(boolean paramBoolean)
  {
    View localView = this.e;
    if (localView != null)
    {
      if ((paramBoolean) && (!this.o))
      {
        localView.setVisibility(0);
        this.o = true;
        return;
      }
      this.e.setVisibility(8);
    }
  }
  
  public void a()
  {
    this.c = this.b.c(2131440851);
    this.d = ((TextView)this.b.c(2131440853));
    this.e = this.b.c(2131440003);
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605);
    if (localPublishHwkThirdPartyEntryConfig != null) {
      if (localPublishHwkThirdPartyEntryConfig.d())
      {
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        if (this.b.b() == 1) {
          this.c.setClickable(true);
        } else {
          this.c.setClickable(false);
        }
      }
      else
      {
        this.c.setVisibility(8);
      }
    }
    this.f = ((LinearLayout)this.b.c(2131447971));
    this.f.setOnClickListener(this);
    if (!this.i.booleanValue()) {
      this.f.setVisibility(8);
    }
    this.g = ((TextView)this.f.findViewById(2131448123));
    this.h = this.f.findViewById(2131447932);
    this.h.setOnClickListener(this);
    this.s = c();
    if (this.s)
    {
      c(true);
      a(true, 1);
      return;
    }
    c(false);
    d(false);
  }
  
  public void a(int paramInt)
  {
    if ((this.i.booleanValue()) && (paramInt == 1))
    {
      Bundle localBundle = this.b.d();
      String str2 = this.a;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", "createHW_doc", 0, 0, new String[] { str1, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 265) {
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult data == null");
      return;
    }
    Object localObject = paramIntent.getStringExtra("params");
    if (((String)localObject).isEmpty())
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult strData.isEmpty");
      return;
    }
    paramIntent = null;
    try
    {
      localObject = new JSONObject((String)localObject);
      paramIntent = (Intent)localObject;
    }
    catch (JSONException localJSONException)
    {
      label65:
      break label65;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
      return;
    }
    this.j = paramIntent.optString("title");
    this.l = paramIntent.optString("course_name");
    this.m = paramIntent.optString("exam_id");
    this.g.setText(this.j);
    this.f.setVisibility(0);
    a(true);
    this.b.a(2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2)
    {
      if (paramBoolean)
      {
        this.c.setEnabled(false);
        return;
      }
      this.c.setEnabled(true);
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.i.booleanValue())
    {
      JSONObject localJSONObject = this.n;
      if (localJSONObject != null)
      {
        paramJSONArray.put(localJSONObject);
        return;
      }
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "exam");
        localJSONObject.put("exam_type", "1");
        localJSONObject.put("appid", "101458937");
        localJSONObject.put("exam_id", this.m);
        localJSONObject.put("course_name", this.l);
        localJSONObject.put("exam_count", String.valueOf(this.k));
        localJSONObject.put("title", this.j);
        paramJSONArray.put(localJSONObject);
        return;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("exam_type");
    String str3 = paramJSONObject.optString("appid");
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101458937")))
    {
      this.n = paramJSONObject;
      str1 = paramJSONObject.optString("title");
      this.g.setText(str1);
      this.m = paramJSONObject.optString("exam_id");
      this.f.setVisibility(0);
      this.f.setClickable(false);
      this.h.setVisibility(8);
      a(true);
      this.b.a(2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = Boolean.valueOf(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (!paramBoolean)
    {
      d(false);
    }
    else if (this.r)
    {
      this.r = false;
      if (this.s) {
        ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.1(this), 500L);
      }
    }
    if (!this.i.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      d(false);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.2(this), 20L);
  }
  
  public boolean b()
  {
    return this.i.booleanValue();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131440851) {
      a(paramView);
    } else if (i1 == 2131447971) {
      b(paramView);
    } else if (i1 == 2131447932) {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper
 * JD-Core Version:    0.7.0.1
 */