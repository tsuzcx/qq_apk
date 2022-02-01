package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiRedpacketUserGuideDialog;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmoticonTemplateRecyclerView;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class EmojiFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  public View a;
  public Button b;
  public EditText c;
  public EditText d;
  public EmojiFragment.TemplateBundleInfo l = new EmojiFragment.TemplateBundleInfo();
  public EmoticonTemplateRecyclerView m;
  public long n = 0L;
  protected TextWatcher o = new EmojiFragment.1(this);
  public ImageView p;
  public int q = -1;
  public String r;
  public int s;
  int t = 0;
  public EmojiRedpacketUserGuideDialog u;
  private List<EmojiFragment.TemplateInfo> v;
  private String w;
  private EmojiFragment.TemplateInfo x;
  private SparseArray<URLDrawable> y = new SparseArray();
  private SparseArray<ImageView> z = new SparseArray();
  
  private void a(View paramView, Bundle paramBundle)
  {
    try
    {
      HbInfo.a(paramBundle, this.l);
      paramView.findViewById(R.id.aJ).setOnClickListener(this);
      this.m = ((EmoticonTemplateRecyclerView)paramView.findViewById(R.id.cs));
      paramBundle = new EmojiFragment.TemplateListAdapter(this, this.f);
      this.v = b(this.l.heartList, this.l.prefix);
      paramBundle.a(this.v);
      this.m.setAdapter(paramBundle);
      this.m.setLayoutManager(new GridLayoutManager(this.f, 4, 1, false));
      paramBundle = new EmojiFragment.TempGridItemLayoutDecoration(this, this.f, 4);
      this.m.addItemDecoration(paramBundle);
      this.d = ((EditText)paramView.findViewById(R.id.b));
      this.d.addTextChangedListener(new MoneyWatcher(this.d));
      this.d.addTextChangedListener(this.o);
      this.c = ((EditText)paramView.findViewById(R.id.bb));
      if (HbInfo.b.contains(this.l.recv_type))
      {
        this.c.setText("1");
        paramView.findViewById(R.id.cD).setVisibility(8);
      }
      else
      {
        if (!TextUtils.isEmpty(this.l.people_num))
        {
          paramBundle = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(R.string.aH));
          localStringBuilder.append(this.l.people_num);
          localStringBuilder.append(HardCodeUtil.a(R.string.aI));
          paramBundle.setHint(localStringBuilder.toString());
        }
        this.c.addTextChangedListener(this.o);
      }
      if ((this.v != null) && (this.v.size() > 0)) {
        a((EmojiFragment.TemplateInfo)this.v.get(0));
      }
      paramBundle = this.l.biz_params;
      if (!StringUtil.isEmpty(paramBundle)) {
        this.w = new JSONObject(paramBundle).optString("temp_id");
      }
      if (!StringUtil.isEmpty(this.w)) {
        c(this.w);
      }
      this.b = ((Button)paramView.findViewById(R.id.z));
      this.b.setOnClickListener(this);
      d();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void a(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    if (this.v != null)
    {
      int i = 0;
      while (i < this.v.size())
      {
        localTemplateInfo = (EmojiFragment.TemplateInfo)this.v.get(i);
        if (localTemplateInfo.b == paramTemplateInfo.b) {
          localTemplateInfo.g = true;
        } else {
          localTemplateInfo.g = false;
        }
        i += 1;
      }
    }
    EmojiFragment.TemplateInfo localTemplateInfo = this.x;
    if (localTemplateInfo != null) {
      a((URLDrawable)this.y.get(localTemplateInfo.b), false, this.x.b, (ImageView)this.z.get(this.x.b));
    }
    if (paramTemplateInfo != null) {
      a((URLDrawable)this.y.get(paramTemplateInfo.b), true, paramTemplateInfo.b, (ImageView)this.z.get(paramTemplateInfo.b));
    }
    this.x = paramTemplateInfo;
  }
  
  private List<EmojiFragment.TemplateInfo> b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject1;
        if (StringUtil.isEmpty(paramString1))
        {
          localObject1 = RedPacketManagerImpl.getHbPannelConfig(8);
          if (localObject1 == null) {
            break label255;
          }
          paramString1 = ((JSONObject)localObject1).optJSONArray("heartList");
          paramString2 = ((JSONObject)localObject1).optString("prefix");
        }
        else
        {
          paramString1 = new JSONArray(paramString1);
        }
        if (paramString1 != null)
        {
          if (paramString1.length() != 0) {
            break label260;
          }
          return localArrayList;
          if (i < paramString1.length())
          {
            localObject1 = new EmojiFragment.TemplateInfo();
            ((EmojiFragment.TemplateInfo)localObject1).a = i;
            Object localObject2 = paramString1.optJSONObject(i);
            if (localObject2 != null)
            {
              ((EmojiFragment.TemplateInfo)localObject1).b = ((JSONObject)localObject2).optInt("rId");
              ((EmojiFragment.TemplateInfo)localObject1).c = ((JSONObject)localObject2).optInt("skinId");
              ((EmojiFragment.TemplateInfo)localObject1).d = ((JSONObject)localObject2).optString("text");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramString2);
              ((StringBuilder)localObject2).append(((EmojiFragment.TemplateInfo)localObject1).b);
              ((StringBuilder)localObject2).append(".png");
              ((EmojiFragment.TemplateInfo)localObject1).e = ((StringBuilder)localObject2).toString();
              localArrayList.add(localObject1);
            }
            i += 1;
            continue;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("init emoji template data throw an exception: ");
          paramString2.append(paramString1);
          QLog.e("EmojiFragment", 1, paramString2.toString());
        }
      }
      return localArrayList;
      label255:
      paramString1 = null;
      continue;
      label260:
      int i = 0;
    }
  }
  
  private void c(String paramString)
  {
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        paramString = this.v.iterator();
        if (!paramString.hasNext()) {
          break label122;
        }
        localObject = (EmojiFragment.TemplateInfo)paramString.next();
        if (i != ((EmojiFragment.TemplateInfo)localObject).b) {
          continue;
        }
        a((EmojiFragment.TemplateInfo)localObject);
        i = 1;
        if (i == 0)
        {
          QQToast.makeText(getActivity(), R.string.C, 0).show();
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processDefaultTmpSelected occur an exception: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("EmojiFragment", 1, ((StringBuilder)localObject).toString());
        QQToast.makeText(getActivity(), R.string.C, 0).show();
      }
      return;
      label122:
      int i = 0;
    }
  }
  
  public void a(URLDrawable paramURLDrawable, boolean paramBoolean, int paramInt, ImageView paramImageView)
  {
    if (paramURLDrawable == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_play_apng", paramBoolean);
    Object localObject = paramURLDrawable.getURL().getFile();
    paramURLDrawable = (URLDrawable)localObject;
    if (((String)localObject).startsWith(File.separator)) {
      paramURLDrawable = ((String)localObject).substring(1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thread name: ");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      QLog.i("EmojiFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramImageView == null) {
      return;
    }
    localObject = QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a, localBundle);
    paramImageView.setImageDrawable((Drawable)localObject);
    this.y.put(paramInt, localObject);
    if (paramBoolean)
    {
      paramImageView = new Bundle();
      paramImageView.putBoolean("key_play_apng", false);
      ThreadManager.excute(new EmojiFragment.2(this, QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a, paramImageView)), 16, null, true);
    }
  }
  
  public void a(EmojiFragment.TemplateInfo paramTemplateInfo, ImageView paramImageView)
  {
    this.q = paramTemplateInfo.b;
    this.r = paramTemplateInfo.d;
    this.s = paramTemplateInfo.c;
    d();
    if (this.p == paramImageView) {
      return;
    }
    paramImageView.setBackgroundResource(R.drawable.h);
    ImageView localImageView = this.p;
    if (localImageView != null) {
      localImageView.setBackgroundDrawable(null);
    }
    this.p = paramImageView;
    a(paramTemplateInfo);
  }
  
  public void c()
  {
    this.f.addHbUploadData("phiz.wrappacket.wrap");
    long l1 = System.currentTimeMillis();
    if (this.n + 1000L > l1) {
      return;
    }
    this.n = l1;
    Object localObject = this.c.getText().toString();
    String str = this.d.getText().toString();
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.r);
    localMap.put("feedsid", String.valueOf(this.q));
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.b(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("");
    localMap.put("channel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append("");
    localMap.put("skin_id", ((StringBuilder)localObject).toString());
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.l.panel_name);
  }
  
  public void d()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = this.c.getText().toString();
    String str = this.d.getText().toString();
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (this.q != -1)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      QLog.i("EmojiFragment", 2, "info is not complete...");
      this.b.setEnabled(false);
      this.b.setText(getString(R.string.I));
      return;
    }
    if ((QwUtils.a((String)localObject) > 0.0F) && (QwUtils.a(str) > 0.0F))
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(getString(R.string.I));
      ((StringBuffer)localObject).append(str);
      ((StringBuffer)localObject).append("元");
      this.b.setText(((StringBuffer)localObject).toString());
      this.b.setEnabled(true);
      return;
    }
    this.b.setEnabled(false);
    this.b.setText(getString(R.string.I));
  }
  
  public void e()
  {
    EmojiRedpacketUserGuideDialog localEmojiRedpacketUserGuideDialog = this.u;
    if (localEmojiRedpacketUserGuideDialog == null) {
      this.u = new EmojiRedpacketUserGuideDialog(this.f);
    } else if (localEmojiRedpacketUserGuideDialog.isShowing()) {
      this.u.dismiss();
    }
    this.u.show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.z)
    {
      c();
      return;
    }
    if (i == R.id.aJ) {
      e();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f.getWindow().setSoftInputMode(32);
    this.a = paramLayoutInflater.inflate(R.layout.h, null);
    a(this.a, getArguments());
    return this.a;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    SparseArray localSparseArray = this.y;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.z;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManager.getUIHandler().post(new EmojiFragment.3(this));
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("EmojiFragment", 2, "phiz redpacket enter...");
      if (this.f != null) {
        this.f.addHbUploadData("phiz.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment
 * JD-Core Version:    0.7.0.1
 */