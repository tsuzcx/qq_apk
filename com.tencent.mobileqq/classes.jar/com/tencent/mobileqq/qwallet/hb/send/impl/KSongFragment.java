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
  private long jdField_a_of_type_Long = 0L;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KSongFragment.KsongBundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo = new KSongFragment.KsongBundleInfo();
  private IQWalletRedService jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService;
  
  private void d()
  {
    try
    {
      if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.biz_params))
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.biz_params);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id = localJSONObject.optString("song_id");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_name = localJSONObject.optString("song_name");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_singer = localJSONObject.optString("song_singer");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_name, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_singer }));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        a();
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.biz_params = null;
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
  
  private void e()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.b.getText().toString();
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_name);
    localStringBuilder.append("-");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_singer);
    localMap.put("wishing", localStringBuilder.toString());
    localMap.put("feedsid", this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.a(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.panel_name);
  }
  
  protected String a()
  {
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.q));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    QWalletTools.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
    d();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("biz_params: ");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.biz_params);
      QLog.i("KSongFragment", 2, paramBundle.toString());
    }
  }
  
  public boolean a()
  {
    if ((super.a()) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id == null)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public int b()
  {
    return R.layout.s;
  }
  
  public void b()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService = ((IQWalletRedService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQWalletRedService.class));
    this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService.doShowReport("3001");
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
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id = paramIntent.optString("musicID");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_singer = paramIntent.optString("singer");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_name = paramIntent.optString("musicName");
        d();
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
    if (i == R.id.q) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService.doClick("3001");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("ksong.wrappacket.choosesong");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry))
        {
          QLog.i("KSongFragment", 2, "error, url is null...");
          paramView = RedPacketManagerImpl.getHbPannelConfig(7);
          if (paramView == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry = paramView.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("%s");
        paramView = str;
        if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry.contains("?"))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry.endsWith("?")) {
            break label252;
          }
          paramView = "";
        }
        localStringBuilder.append(paramView);
        localStringBuilder.append("musicID=%s");
        paramView = localStringBuilder.toString();
        if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id == null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry;
        } else {
          paramView = String.format(paramView, new Object[] { this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.pick_entry, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKSongFragment$KsongBundleInfo.song_id });
        }
        a(paramView);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (i == R.id.u)
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("ksong.wrappacket.wrap");
        e();
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
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("ksong.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KSongFragment
 * JD-Core Version:    0.7.0.1
 */