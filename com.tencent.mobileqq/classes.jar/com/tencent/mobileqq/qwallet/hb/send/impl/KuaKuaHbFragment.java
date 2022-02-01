package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KuaKuaHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  protected KuaKuaHbFragment.KuaKuaHbBundleInfo o = new KuaKuaHbFragment.KuaKuaHbBundleInfo();
  String p;
  String q;
  int r;
  private TextView s;
  private TextView t;
  private ChooseItemView u;
  private ChooseItemView v;
  private RelativeLayout w;
  private RelativeLayout x;
  
  private void a(LinkedHashSet<String> paramLinkedHashSet, JSONArray paramJSONArray)
  {
    if ((paramLinkedHashSet != null) && (paramJSONArray != null))
    {
      if (paramJSONArray.length() < 0) {
        return;
      }
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          String str = paramJSONArray.optString(i);
          if (!TextUtils.isEmpty(str)) {
            paramLinkedHashSet.add(str);
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramLinkedHashSet)
      {
        paramLinkedHashSet.printStackTrace();
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramJSONArray != null))
    {
      if (paramJSONArray.length() < 0) {
        return false;
      }
      i = 0;
    }
    for (;;)
    {
      int j;
      try
      {
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            String str1 = localJSONObject.optString("typeName");
            if ((!TextUtils.isEmpty(str1)) && (str1.trim().equals(paramString1)))
            {
              JSONArray localJSONArray = localJSONObject.optJSONArray("subjects");
              j = 0;
              int k = localJSONArray.length();
              String str2;
              if (j < k)
              {
                str2 = localJSONArray.getString(j);
                if (!paramString2.trim().equals(str2)) {
                  break label234;
                }
                this.p = str1;
                this.q = localJSONObject.optString("typeId");
                return true;
              }
              localJSONArray = localJSONObject.optJSONArray("recommend");
              j = 0;
              if (j < localJSONArray.length())
              {
                str2 = localJSONArray.getString(j);
                if (paramString2.trim().equals(str2))
                {
                  this.p = str1;
                  this.q = localJSONObject.optString("typeId");
                  return true;
                }
                j += 1;
                continue;
              }
            }
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
      label234:
      j += 1;
    }
  }
  
  private void m()
  {
    if (!i()) {
      return;
    }
    int i = QwUtils.a(this.c.getText().toString(), 1);
    Object localObject1 = QwUtils.b(String.valueOf(QwUtils.a(this.d.getText().toString())));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QQToast.makeText(getActivity(), R.string.h, 0).show();
      return;
    }
    Object localObject2 = this.s.getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    a(this.o, this.i, i, (String)localObject1, "hongbao.wrap.go");
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.i));
    localMap.put("type", "1");
    localMap.put("wishing", localObject2);
    localMap.put("bus_type", "2");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    localMap.put("total_num", ((StringBuilder)localObject2).toString());
    localMap.put("total_amount", localObject1);
    if (this.o.skinId > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.o.skinId);
      ((StringBuilder)localObject1).append("");
      localMap.put("skin_id", ((StringBuilder)localObject1).toString());
    }
    try
    {
      this.s.getText().toString();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type_id", this.q);
      localMap.put("client_extend", ((JSONObject)localObject1).toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.o.panel_name);
  }
  
  public LinkedList<String> a(JSONArray paramJSONArray)
  {
    localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("typeId");
          String str2 = ((JSONObject)localObject).optString("typeName");
          String str3 = ((JSONObject)localObject).optString("subjects");
          localObject = ((JSONObject)localObject).optString("recommend");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty((CharSequence)localObject)))) {
            localLinkedHashSet.add(str2);
          }
        }
        i += 1;
      }
      return new LinkedList(localLinkedHashSet);
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public List<String> a(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() < 0) {
        return null;
      }
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).optString("typeName");
          if ((!TextUtils.isEmpty(str)) && (paramString.equals(str)))
          {
            this.q = ((JSONObject)localObject).optString("typeId");
            paramJSONArray = ((JSONObject)localObject).optJSONArray("subjects");
            paramString = ((JSONObject)localObject).optJSONArray("recommend");
            localObject = new LinkedHashSet();
            a((LinkedHashSet)localObject, paramString);
            this.r = ((LinkedHashSet)localObject).size();
            a((LinkedHashSet)localObject, paramJSONArray);
            paramJSONArray = new LinkedList((Collection)localObject);
            return paramJSONArray;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.o);
    this.s = ((TextView)this.a.findViewById(R.id.cP));
    this.t = ((TextView)this.a.findViewById(R.id.cM));
    this.u = new ChooseItemView(this.f, new KuaKuaHbFragment.1(this));
    this.u.setMaxLines(8);
    this.u.setStyle(1);
    this.v = new ChooseItemView(this.f, null);
    this.v.setMaxLines(8);
    this.v.setStyle(1);
    this.w = ((RelativeLayout)this.a.findViewById(R.id.aR));
    this.x = ((RelativeLayout)this.a.findViewById(R.id.aS));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bizParams:");
      paramBundle.append(this.o.biz_params);
      QLog.i("KuaKuaHbFragment", 2, paramBundle.toString());
    }
    if (HbInfo.b.contains(this.o.recv_type))
    {
      this.c.setText("1");
      this.a.findViewById(R.id.cD).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.o.people_num))
      {
        paramBundle = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.bc));
        localStringBuilder.append(this.o.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.bg));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.c.addTextChangedListener(this.n);
    }
    this.b.setOnClickListener(this);
    this.s.addTextChangedListener(this.n);
    this.s.setOnClickListener(new KuaKuaHbFragment.2(this));
    this.t.addTextChangedListener(this.n);
    QWalletTools.a(this.s, 0.6F);
    paramBundle = this.u;
    if (paramBundle != null) {
      paramBundle.b();
    }
    this.a.setOnClickListener(new KuaKuaHbFragment.3(this));
  }
  
  public void c()
  {
    k();
    Object localObject = a(this.o.subjectList);
    if (!l()) {
      this.p = ((String)((List)localObject).get(0));
    }
    this.v.a((List)localObject, false, new KuaKuaHbFragment.4(this), null, null);
    this.v.setStyle(1);
    this.x.addView(this.v);
    localObject = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    this.t.setText(this.p);
    this.v.a(this.p, false);
    c(this.p);
  }
  
  public void c(String paramString)
  {
    this.r = 0;
    this.w.removeAllViews();
    paramString = a(this.o.subjectList, paramString);
    this.u.a(paramString, false, new KuaKuaHbFragment.5(this), null, new KuaKuaHbFragment.6(this));
    this.u.setRecommendCnt(this.r);
    this.u.setStyle(1);
    this.w.addView(this.u);
    paramString = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    paramString.width = -1;
    paramString.height = b();
  }
  
  protected String d()
  {
    return HardCodeUtil.a(R.string.bV);
  }
  
  public boolean h()
  {
    if ((super.h()) && (TextUtils.isEmpty(this.s.getText().toString().trim()))) {
      this.b.setEnabled(false);
    }
    return this.b.isEnabled();
  }
  
  public int j()
  {
    return R.layout.o;
  }
  
  public void k()
  {
    try
    {
      JSONObject localJSONObject = RedPacketManagerImpl.getHbPannelConfig(15);
      if (localJSONObject != null)
      {
        this.o.skinId = localJSONObject.optInt("skinId");
        this.o.subjectList = localJSONObject.optJSONArray("subjectList");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean l()
  {
    Object localObject1 = this.o;
    if ((localObject1 != null) && (!StringUtil.isEmpty(((KuaKuaHbFragment.KuaKuaHbBundleInfo)localObject1).biz_params)) && (this.o.subjectList != null))
    {
      if (this.o.subjectList.length() < 1) {
        return false;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bizParams:");
          ((StringBuilder)localObject1).append(this.o.biz_params);
          QLog.i("KuaKuaHbFragment", 2, ((StringBuilder)localObject1).toString());
        }
        if (!StringUtil.isEmpty(this.o.biz_params))
        {
          Object localObject2 = new JSONObject(this.o.biz_params);
          localObject1 = ((JSONObject)localObject2).optString("subject");
          localObject2 = ((JSONObject)localObject2).optString("subject_type");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (a((String)localObject2, (String)localObject1, this.o.subjectList)))
          {
            this.s.setText((CharSequence)localObject1);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.z) {
      m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KuaKuaHbFragment
 * JD-Core Version:    0.7.0.1
 */