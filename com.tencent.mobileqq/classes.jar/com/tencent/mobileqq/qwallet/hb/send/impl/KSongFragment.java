package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KSongFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private TextView o;
  private KSongFragment.KsongBundleInfo p = new KSongFragment.KsongBundleInfo();
  private IQWalletRedService q;
  private long r = 0L;
  
  private void k()
  {
    try
    {
      if (!StringUtil.isEmpty(this.p.biz_params))
      {
        JSONObject localJSONObject = new JSONObject(this.p.biz_params);
        this.p.song_id = localJSONObject.optString("song_id");
        this.p.song_name = localJSONObject.optString("song_name");
        this.p.song_singer = localJSONObject.optString("song_singer");
      }
      if (!TextUtils.isEmpty(this.p.song_id))
      {
        this.o.setText(String.format("%s %s", new Object[] { this.p.song_name, this.p.song_singer }));
        this.o.setTextColor(-16777216);
        h();
      }
      this.p.biz_params = null;
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSongInfoOnControl throw an exception: ");
      localStringBuilder.append(localException);
      QLog.e("KSongFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    if (this.r + 1000L > l) {
      return;
    }
    this.r = l;
    Object localObject = this.c.getText().toString();
    String str = this.d.getText().toString();
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.p.song_name);
    localStringBuilder.append("-");
    localStringBuilder.append(this.p.song_singer);
    localMap.put("wishing", localStringBuilder.toString());
    localMap.put("feedsid", this.p.song_id);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.b(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.i);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.p.panel_name);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.p);
    this.o = ((TextView)this.a.findViewById(R.id.v));
    this.o.setOnClickListener(this);
    this.b.setOnClickListener(this);
    QWalletTools.a(this.o, 0.6F);
    k();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("biz_params: ");
      paramBundle.append(this.p.biz_params);
      QLog.i("KSongFragment", 2, paramBundle.toString());
    }
  }
  
  public void c()
  {
    e();
    this.q = ((IQWalletRedService)this.g.getRuntimeService(IQWalletRedService.class));
    this.q.doShowReport("3001");
  }
  
  protected String d()
  {
    return "";
  }
  
  public boolean h()
  {
    if ((super.h()) && (this.p.song_id == null)) {
      this.b.setEnabled(false);
    }
    return this.b.isEnabled();
  }
  
  public int j()
  {
    return R.layout.v;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 16) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("h5arg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("h5call = ");
      localStringBuilder.append(paramIntent);
      QLog.i("KSongFragment", 2, localStringBuilder.toString());
      try
      {
        paramIntent = new JSONObject(paramIntent);
        this.p.song_id = paramIntent.optString("musicID");
        this.p.song_singer = paramIntent.optString("singer");
        this.p.song_name = paramIntent.optString("musicName");
        k();
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    String str = "?";
    int i = paramView.getId();
    if (i == R.id.v) {}
    for (;;)
    {
      try
      {
        this.q.doClick("3001");
        this.f.addHbUploadData("ksong.wrappacket.choosesong");
        if (TextUtils.isEmpty(this.p.pick_entry))
        {
          QLog.i("KSongFragment", 2, "error, url is null...");
          paramView = RedPacketManagerImpl.getHbPannelConfig(7);
          if (paramView == null) {
            return;
          }
          this.p.pick_entry = paramView.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("%s");
        paramView = str;
        if (this.p.pick_entry.contains("?"))
        {
          if (!this.p.pick_entry.endsWith("?")) {
            break label252;
          }
          paramView = "";
        }
        localStringBuilder.append(paramView);
        localStringBuilder.append("musicID=%s");
        paramView = localStringBuilder.toString();
        if (this.p.song_id == null) {
          paramView = this.p.pick_entry;
        } else {
          paramView = String.format(paramView, new Object[] { this.p.pick_entry, this.p.song_id });
        }
        a(paramView);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (i == R.id.z)
      {
        this.f.addHbUploadData("ksong.wrappacket.wrap");
        l();
      }
      return;
      label252:
      paramView = "&";
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("KSongFragment", 2, "ksong enter...");
      if (this.f != null) {
        this.f.addHbUploadData("ksong.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KSongFragment
 * JD-Core Version:    0.7.0.1
 */