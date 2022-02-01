package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.ISoftKeyboardObserverTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ConfigLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ContinueChainBizImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspRecommendInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.IdiomWordChainBizImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.KeyWordChainBizImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.WordChainBizImpl;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class WordChainHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static SharedPreferences o = MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0);
  private static final Map<Integer, GetRecommendWordUtils.RspRecommendInfo> q = new HashMap();
  private ArrayList<WordChainHbFragment.WordChainTypeLabel> A = new ArrayList();
  private IWordChainBiz B;
  private SparseArray<String> C = new SparseArray();
  private ISoftKeyboardObserverTemp D;
  private TextView E;
  private boolean F = true;
  private long G = 0L;
  private WordChainHbFragment.IdiomHbBundleInfo p = new WordChainHbFragment.IdiomHbBundleInfo();
  private List<GetRecommendWords.CopyWriter> r = new CopyOnWriteArrayList();
  private String s;
  private IPasswdRedBagService t;
  private ViewGroup u;
  private RelativeLayout v;
  private View w;
  private View x;
  private TextView y;
  private TextView z;
  
  private String a(boolean paramBoolean)
  {
    try
    {
      if ((this.p != null) && (this.B != null))
      {
        Object localObject = a(this.p.currSelectedSubChannel);
        localObject = this.B.a((List)localObject, paramBoolean);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WordChainHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void a(TextView paramTextView, WordChainHbFragment.WordChainTypeLabel paramWordChainTypeLabel)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.Y));
    paramTextView.setTextColor(-1);
    if ((this.p != null) && ((paramTextView.getTag() instanceof WordChainHbFragment.WordChainTypeLabel)))
    {
      Object localObject = (WordChainHbFragment.WordChainTypeLabel)paramTextView.getTag();
      this.p.currSelectedSubChannel = ((WordChainHbFragment.WordChainTypeLabel)localObject).b;
      this.B = b(this.p.currSelectedSubChannel);
      this.y.setText("");
      localObject = this.y;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.y.getText());
      localStringBuilder.append(paramTextView.getText().toString());
      ((TextView)localObject).setText(localStringBuilder.toString());
      if (this.F) {
        o.edit().putInt("sp_key_last_selete_label", this.p.currSelectedSubChannel).apply();
      }
      c(paramWordChainTypeLabel.c);
      n();
      if (this.l != null)
      {
        this.l.setText((CharSequence)this.C.get(this.p.currSelectedSubChannel));
        if (!TextUtils.isEmpty(paramWordChainTypeLabel.d)) {
          this.l.setHint(paramWordChainTypeLabel.d);
        }
      }
    }
  }
  
  private IWordChainBiz b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return new ContinueChainBizImpl(this);
        }
        return new KeyWordChainBizImpl();
      }
      return new WordChainBizImpl();
    }
    return new IdiomWordChainBizImpl();
  }
  
  private void c(int paramInt)
  {
    if (this.p != null)
    {
      Object localObject = this.B;
      if (localObject != null)
      {
        localObject = ((IWordChainBiz)localObject).a(paramInt);
        this.l.setFilters((InputFilter[])localObject);
      }
    }
  }
  
  private void d(int paramInt)
  {
    this.x.setVisibility(paramInt);
    this.v.setVisibility(paramInt);
    this.u.setVisibility(paramInt);
    this.w.setVisibility(paramInt);
    if (paramInt == 0) {
      try
      {
        InputMethodUtil.a(getQBaseActivity());
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void n()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = (GetRecommendWordUtils.RspRecommendInfo)q.get(Integer.valueOf(this.p.currSelectedSubChannel));
    if ((localRspRecommendInfo == null) || (localRspRecommendInfo.a.isEmpty()) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - localRspRecommendInfo.b) > 86400000L)) {
      GetRecommendWordUtils.a(this.g, this.p.currSelectedSubChannel, this.p.recv_type, new WordChainHbFragment.1(this));
    }
  }
  
  private void o()
  {
    if ((this.f != null) && (this.f.getConfigLogic() != null)) {
      this.A = this.f.getConfigLogic().a(this.i, this.p);
    }
    if (this.A.isEmpty())
    {
      WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = new WordChainHbFragment.WordChainTypeLabel();
      localWordChainTypeLabel.a = HardCodeUtil.a(R.string.dB);
      localWordChainTypeLabel.b = 0;
      localWordChainTypeLabel.c = 4;
      this.A.add(localWordChainTypeLabel);
    }
  }
  
  private void p()
  {
    TextView localTextView = this.E;
    if (localTextView != null)
    {
      localTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.X));
      this.E.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private void q()
  {
    o();
    this.u.post(new WordChainHbFragment.2(this));
  }
  
  private void r()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      int j = ((ViewGroup)localObject).getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localObject = this.u.getChildAt(i);
          if ((localObject instanceof TextView))
          {
            localObject = (TextView)localObject;
            WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = (WordChainHbFragment.WordChainTypeLabel)((TextView)localObject).getTag();
            WordChainHbFragment.IdiomHbBundleInfo localIdiomHbBundleInfo = this.p;
            if ((localIdiomHbBundleInfo != null) && (localIdiomHbBundleInfo.currSelectedSubChannel == localWordChainTypeLabel.b))
            {
              a((TextView)localObject, localWordChainTypeLabel);
              this.E = ((TextView)localObject);
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void s()
  {
    boolean bool = StringUtil.isEmpty(this.p.biz_params);
    int j = 0;
    int i = j;
    if (!bool) {
      try
      {
        this.F = false;
        JSONObject localJSONObject = new JSONObject(this.p.biz_params);
        String str2 = localJSONObject.optString("idiom", "");
        int k = localJSONObject.optInt("sub_channel", 0);
        this.p.currSelectedSubChannel = k;
        i = j;
        if (!TextUtils.isEmpty(str2))
        {
          this.l.setText(str2);
          this.C.put(k, str2);
          i = 1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i = j;
      }
    }
    if (i == 0)
    {
      String str1 = HbBusiUtils.a(this.i, this.p, this.f.getConfigLogic(), d());
      this.l.setHint(str1);
    }
  }
  
  private void t()
  {
    long l = System.currentTimeMillis();
    if (this.G + 1000L > l) {
      return;
    }
    this.G = l;
    Object localObject = this.c.getText().toString();
    String str = this.d.getText().toString();
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.s);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.b(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.i);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(this.p.skinId)) {
      localMap.put("skin_id", this.p.skinId);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.p.currSelectedSubChannel);
    ((StringBuilder)localObject).append("");
    localMap.put("subchannel", ((StringBuilder)localObject).toString());
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.p.panel_name);
  }
  
  public List<GetRecommendWords.CopyWriter> a(int paramInt)
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = (GetRecommendWordUtils.RspRecommendInfo)q.get(Integer.valueOf(paramInt));
    if (localRspRecommendInfo != null) {
      return localRspRecommendInfo.a;
    }
    return this.r;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.p);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bizParams:");
      paramBundle.append(this.p.biz_params);
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
    }
    if (HbInfo.b.contains(this.p.recv_type))
    {
      this.c.setText("1");
      this.a.findViewById(R.id.cD).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.p.people_num))
      {
        paramBundle = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.bc));
        localStringBuilder.append(this.p.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.bg));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.c.addTextChangedListener(this.n);
    }
    this.l.setFocusable(true);
    this.l.setOnFocusChangeListener(new WordChainHbFragment.3(this));
    this.a.setClickable(true);
    this.a.findViewById(R.id.aG).setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.u = ((ViewGroup)this.a.findViewById(R.id.K));
    this.v = ((RelativeLayout)this.a.findViewById(R.id.dh));
    this.w = this.a.findViewById(R.id.m);
    this.x = this.a.findViewById(R.id.aw);
    this.y = ((TextView)this.a.findViewById(R.id.cO));
    this.z = ((TextView)this.a.findViewById(R.id.cN));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isFlyMe: ");
      paramBundle.append(SystemUtil.g());
      paramBundle.append(" isMeizu:");
      paramBundle.append(SystemUtil.h());
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("biz_params: ");
      paramBundle.append(this.p.biz_params);
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
    }
  }
  
  public void c()
  {
    this.l.addTextChangedListener(this.n);
    s();
    e();
  }
  
  public void c(String paramString)
  {
    this.f.showToast(paramString);
  }
  
  protected String d()
  {
    return HardCodeUtil.a(R.string.aY);
  }
  
  protected void dj_()
  {
    super.dj_();
    this.t = ((IPasswdRedBagService)this.g.getRuntimeService(IPasswdRedBagService.class));
    q();
  }
  
  public boolean h()
  {
    IWordChainBiz localIWordChainBiz = this.B;
    if (localIWordChainBiz != null) {
      localIWordChainBiz.b(this.l.getText().toString().trim());
    }
    if (super.h())
    {
      this.s = this.l.getText().toString().trim();
      if (this.B != null) {
        this.b.setEnabled(this.B.a(this.s));
      }
    }
    return this.b.isEnabled();
  }
  
  public int j()
  {
    return R.layout.n;
  }
  
  public int k()
  {
    String str = this.c.getText().toString();
    if (TextUtils.isEmpty(str)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.z)
    {
      this.f.addHbUploadData("idiom.wrappacket.wrap");
      t();
      return;
    }
    if (i == R.id.aG)
    {
      this.f.addHbUploadData("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.G + 100L > l) {
        return;
      }
      this.G = l;
      paramView = a(true);
      this.l.setText(paramView);
      this.C.put(this.p.currSelectedSubChannel, paramView);
      this.l.setSelection(this.l.getText().length());
      n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ISoftKeyboardObserverTemp localISoftKeyboardObserverTemp = this.D;
    if (localISoftKeyboardObserverTemp != null) {
      localISoftKeyboardObserverTemp.destroy();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("WordChainHbFragment", 2, "idiom enter...");
      if (this.f != null) {
        this.f.addHbUploadData("idiom.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */