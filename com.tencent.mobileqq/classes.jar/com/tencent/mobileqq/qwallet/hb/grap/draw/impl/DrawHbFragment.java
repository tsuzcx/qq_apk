package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  DrawHbFragment.DrawHbBundleInfo a = new DrawHbFragment.DrawHbBundleInfo();
  RelativeLayout b;
  ChooseItemView c;
  protected TextWatcher d = new DrawHbFragment.7(this);
  private EditText l;
  private EditText m;
  private TextView n;
  private Button o;
  private String p;
  private long q = 0L;
  
  public static List<String> a(String paramString1, String paramString2, String paramString3)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(localLinkedHashSet, paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      try
      {
        paramString1 = new JSONArray(paramString3);
        int i = 0;
        while (i < paramString1.length())
        {
          paramString3 = paramString1.optJSONObject(i);
          if (paramString3 != null) {
            a(localLinkedHashSet, paramString3.optString("subjects"));
          }
          i += 1;
        }
        a(localLinkedHashSet, paramString2);
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return new LinkedList(localLinkedHashSet);
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.a);
    this.l = ((EditText)paramView.findViewById(R.id.bb));
    this.m = ((EditText)paramView.findViewById(R.id.b));
    this.m.addTextChangedListener(this.d);
    paramBundle = this.m;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.o = ((Button)paramView.findViewById(R.id.p));
    this.n = ((TextView)paramView.findViewById(R.id.cP));
    StringBuilder localStringBuilder;
    try
    {
      if (TextUtils.isEmpty(this.a.drawParam))
      {
        paramBundle = RedPacketManagerImpl.getHbPannelConfig(10);
        if (paramBundle != null)
        {
          this.a.skinId = paramBundle.optString("skinId");
          this.a.drawParam = paramBundle.optString("subjects");
          this.a.recommend = paramBundle.optString("recommend");
          this.a.modelList = paramBundle.optString("modelList");
        }
      }
      paramBundle = this.a.biz_params;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("bizParams:");
        localStringBuilder.append(paramBundle);
        QLog.i("DrawHbFragment", 2, localStringBuilder.toString());
      }
      if (!StringUtil.isEmpty(paramBundle))
      {
        paramBundle = new JSONObject(paramBundle).optString("subject", "");
        if ((!TextUtils.isEmpty(paramBundle)) && (e(paramBundle))) {
          this.n.setText(paramBundle);
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (HbInfo.b.contains(this.a.recv_type))
    {
      this.l.setText("1");
      paramView.findViewById(R.id.cD).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.a.people_num))
      {
        paramBundle = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.aw));
        localStringBuilder.append(this.a.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.ax));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.l.addTextChangedListener(this.d);
    }
    this.o.setOnClickListener(this);
    this.n.addTextChangedListener(this.d);
    this.n.setOnClickListener(new DrawHbFragment.2(this));
    QWalletTools.a(this.n, 0.6F);
    this.b = ((RelativeLayout)paramView.findViewById(R.id.aR));
    this.c = new ChooseItemView(getQBaseActivity(), new DrawHbFragment.3(this));
    this.c.setOnClickListener(new DrawHbFragment.4(this));
    paramBundle = a(this.a.recommend, this.a.drawParam, this.a.modelList);
    this.c.a(paramBundle, false, new DrawHbFragment.5(this), null, new DrawHbFragment.6(this, paramView));
    this.c.setRecommendCnt(c());
    this.c.setStyle(1);
    this.b.addView(this.c);
    paramView = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramView.width = -1;
    paramView.height = b();
    paramView = this.c;
    if (paramView != null) {
      paramView.b();
    }
  }
  
  private static void a(LinkedHashSet<String> paramLinkedHashSet, String paramString)
  {
    if (paramLinkedHashSet != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.optString(i);
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
  
  private void a(boolean paramBoolean)
  {
    this.o.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.o.setText(getString(R.string.I));
    }
  }
  
  private int c()
  {
    if (TextUtils.isEmpty(this.a.recommend)) {
      return 0;
    }
    try
    {
      int i = new JSONArray(this.a.recommend).length();
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(this.a.drawParam)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.a.drawParam);
        int i = 0;
        while (i < localJSONArray.length())
        {
          String str = localJSONArray.optString(i);
          if (!TextUtils.isEmpty(str))
          {
            boolean bool = str.trim().equals(paramString);
            if (bool) {
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private String d(String paramString)
  {
    if (!TextUtils.isEmpty(this.a.modelList)) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.a.modelList);
        int i = 0;
        while (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = localJSONArray1.optJSONObject(i);
          if (localJSONObject != null)
          {
            JSONArray localJSONArray2 = localJSONObject.optJSONArray("subjects");
            if (localJSONArray2 != null)
            {
              int j = 0;
              while (j < localJSONArray2.length())
              {
                String str = localJSONArray2.optString(j);
                if ((!TextUtils.isEmpty(str)) && (str.trim().equals(paramString)))
                {
                  str = localJSONObject.optString("id");
                  boolean bool = TextUtils.isEmpty(str);
                  if (!bool) {
                    return str;
                  }
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    String str = this.n.getText().toString().trim();
    this.p = str;
    if (TextUtils.isEmpty(str))
    {
      a(false);
      return;
    }
    Object localObject = this.l.getText().toString();
    str = this.m.getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      if ((QwUtils.a((String)localObject) > 0.0F) && (QwUtils.a(str) > 0.0F))
      {
        a(true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(R.string.I));
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.av));
        str = ((StringBuilder)localObject).toString();
        this.o.setText(str);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  private void e()
  {
    long l1 = System.currentTimeMillis();
    if (this.q + 1000L > l1) {
      return;
    }
    this.q = l1;
    Object localObject = this.l.getText().toString();
    String str = this.m.getText().toString();
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("type", "1");
    localMap.put("wishing", this.p);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.b(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.i);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(this.a.skinId)) {
      localMap.put("skin_id", this.a.skinId);
    }
    if (!c(this.p))
    {
      localMap.put("feedsid", d(this.p));
      localMap.put("subchannel", "1");
    }
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.a.panel_name);
  }
  
  private boolean e(String paramString)
  {
    return (c(paramString)) || (!TextUtils.isEmpty(d(paramString)));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.p)
    {
      this.f.addHbUploadData("draw.wrappacket.wrap");
      e();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.w, null);
    paramLayoutInflater.setOnClickListener(new DrawHbFragment.1(this));
    a(paramLayoutInflater, getArguments());
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("DrawHbFragment", 2, "DrawHb enter...");
      if (this.f != null) {
        this.f.addHbUploadData("draw.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment
 * JD-Core Version:    0.7.0.1
 */