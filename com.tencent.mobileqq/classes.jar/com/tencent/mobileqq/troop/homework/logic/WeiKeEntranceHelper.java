package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiKeEntranceHelper
  implements View.OnClickListener, IHomeworkHelper
{
  protected String a = "";
  protected PublishHomeWorkFragment b;
  protected View c;
  protected LinearLayout d;
  protected TextView e;
  protected View f;
  protected Boolean g = Boolean.valueOf(false);
  protected String h = "";
  protected int i = 0;
  protected String j = "";
  protected int k = 0;
  protected JSONObject l = null;
  
  public WeiKeEntranceHelper(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.b = paramPublishHomeWorkFragment;
    this.a = paramString;
  }
  
  private void c(View paramView)
  {
    a(false);
    paramView = this.d;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.b.a(1);
  }
  
  public void a()
  {
    this.c = this.b.c(2131440873);
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605);
    if (localPublishHwkThirdPartyEntryConfig != null) {
      if (localPublishHwkThirdPartyEntryConfig.a())
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
    this.d = ((LinearLayout)this.b.c(2131447973));
    this.d.setOnClickListener(this);
    if (!this.g.booleanValue()) {
      this.d.setVisibility(8);
    }
    this.e = ((TextView)this.b.c(2131447980));
    this.f = this.b.c(2131448120);
    this.f.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    if ((this.g.booleanValue()) && (paramInt == 1))
    {
      Bundle localBundle = this.b.d();
      String str2 = this.a;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { str1, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 264) {
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
      label62:
      break label62;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
      return;
    }
    this.h = paramIntent.optString("title");
    this.i = paramIntent.optInt("num", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131895212));
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131895213));
    ((StringBuilder)localObject).append(")\n");
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131895214));
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(this.h);
    localObject = ((StringBuilder)localObject).toString();
    this.j = paramIntent.optString("course_name");
    this.k = paramIntent.optInt("exam_id", -1);
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("type", "str");
      paramIntent.put("text", localObject);
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramIntent);
      if (this.b.c() != null)
      {
        this.b.c().setDataByEdit((JSONArray)localObject);
        this.b.q();
      }
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    this.e.setText(this.h);
    this.d.setVisibility(0);
    a(true);
    this.b.a(1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramBoolean)
      {
        this.c.setEnabled(false);
        return;
      }
      this.c.setEnabled(true);
    }
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToWeiKe");
    }
    InputMethodUtil.a(this.b.getActivity());
    paramView = new Intent();
    StringBuilder localStringBuilder = new StringBuilder(((PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605)).b());
    localStringBuilder.append("?gc=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("&appid=");
    localStringBuilder.append("101036803");
    localStringBuilder.append("&_wwv=128&_wv=3");
    paramView.putExtra("url", localStringBuilder.toString());
    RouteUtils.a(this.b.getActivity(), paramView, "/base/browser", 264);
    if (this.b.c() != null) {
      this.b.c().b();
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.g.booleanValue())
    {
      JSONObject localJSONObject = this.l;
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
        localJSONObject.put("appid", "101036803");
        localJSONObject.put("exam_id", String.valueOf(this.k));
        localJSONObject.put("course_name", this.j);
        localJSONObject.put("exam_count", String.valueOf(this.i));
        localJSONObject.put("title", this.h);
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
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101036803")))
    {
      this.l = paramJSONObject;
      str1 = paramJSONObject.optString("exam_id");
      paramJSONObject = paramJSONObject.optString("title");
      this.e.setText(paramJSONObject);
      this.k = Integer.valueOf(str1).intValue();
      this.d.setVisibility(0);
      this.d.setClickable(false);
      this.f.setVisibility(8);
      a(true);
      this.b.a(1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = Boolean.valueOf(paramBoolean);
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickWeiKeLink");
    }
    paramView = ((PublishHwkThirdPartyEntryConfig)QConfigManager.b().b(605)).c();
    if (paramView.isEmpty()) {
      return;
    }
    paramView = new StringBuilder(paramView);
    paramView.append("?gc=");
    paramView.append(this.a);
    paramView.append("&appid=");
    paramView.append("101036803");
    paramView.append("&examid=");
    paramView.append(this.k);
    paramView.append("&_wwv=128&_wv=3");
    paramView = paramView.toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramView);
    RouteUtils.a(this.b.getActivity(), localIntent, "/base/browser");
    if (this.b.c() != null) {
      this.b.c().b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.g.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.d.setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WeiKeEntranceHelper.1(this), 20L);
  }
  
  public boolean b()
  {
    return this.g.booleanValue();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131440873) {
      a(paramView);
    } else if (m == 2131447972) {
      b(paramView);
    } else if (m == 2131448120) {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper
 * JD-Core Version:    0.7.0.1
 */