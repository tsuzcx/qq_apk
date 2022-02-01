package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspGroupWordsListInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspRecommendInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ShengpiziBizImpl;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class ShengpiziHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
  private IWordChainBiz jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz;
  private GetRecommendWordUtils.RspRecommendInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplGetRecommendWordUtils$RspRecommendInfo;
  private ShengpiziHbFragment.ShengpiziHbBundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo = new ShengpiziHbFragment.ShengpiziHbBundleInfo();
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  String jdField_a_of_type_JavaLangString = "";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<GetRecommendWordUtils.RspGroupWordsListInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 5;
  private List<GetRecommendWords.CopyWriter> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private EditText d;
  
  private void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setIsShow(false);
    paramTextView.setTextColor(Color.parseColor("#FF2151"));
    int i = ((Integer)paramTextView.getTag()).intValue();
    GetRecommendWordUtils.RspGroupWordsListInfo localRspGroupWordsListInfo = (GetRecommendWordUtils.RspGroupWordsListInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(localRspGroupWordsListInfo.wordList, false, new ShengpiziHbFragment.3(this, paramTextView), new ShengpiziHbFragment.4(this), null);
    this.d.setFocusable(true);
    if (this.jdField_a_of_type_JavaLangCharSequence.equals(paramTextView.getText())) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(this.jdField_a_of_type_JavaLangString, false);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.post(new ShengpiziHbFragment.5(this));
  }
  
  private void e()
  {
    if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.biz_params)) {
      try
      {
        String str = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.biz_params).optString("subject", "");
        if (!TextUtils.isEmpty(str))
        {
          this.d.setText(str);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      GetRecommendWordUtils.RspGroupWordsListInfo localRspGroupWordsListInfo = (GetRecommendWordUtils.RspGroupWordsListInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_JavaUtilArrayList.add(localRspGroupWordsListInfo.name);
      i += 1;
    }
  }
  
  private void g()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new ShengpiziHbFragment.2(this));
  }
  
  private void h()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(Color.parseColor("#898D9B"));
    }
  }
  
  private void i()
  {
    if (!b()) {
      return;
    }
    int i = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    String str = QwUtils.a(String.valueOf(QwUtils.a(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())));
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(getActivity(), R.string.h, 0).a();
      return;
    }
    Object localObject2 = b();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (String)this.d.getHint();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo, this.jdField_a_of_type_Int, i, str, "hongbao.wrap.go");
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    ((Map)localObject2).put("channel", String.valueOf(this.jdField_a_of_type_Int));
    ((Map)localObject2).put("type", "1");
    ((Map)localObject2).put("wishing", localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("total_num", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("total_amount", str);
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.skinId > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.skinId);
      ((StringBuilder)localObject1).append("");
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "shengpizi");
      ((Map)localObject2).put("client_extend", ((JSONObject)localObject1).toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a((Map)localObject2);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.panel_name);
  }
  
  private void j()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplGetRecommendWordUtils$RspRecommendInfo;
    if ((localRspRecommendInfo == null) || (localRspRecommendInfo.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplGetRecommendWordUtils$RspRecommendInfo.jdField_a_of_type_JavaUtilList.size() <= 0) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplGetRecommendWordUtils$RspRecommendInfo.jdField_a_of_type_Long) > 86400000L)) {
      GetRecommendWordUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 4, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.recv_type, new ShengpiziHbFragment.6(this));
    }
  }
  
  protected String a()
  {
    return HardCodeUtil.a(R.string.cK);
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz != null))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz.a(a(), paramBoolean);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ShengPiZiHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  public List<GetRecommendWords.CopyWriter> a()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplGetRecommendWordUtils$RspRecommendInfo;
    if (localRspRecommendInfo != null) {
      return localRspRecommendInfo.jdField_a_of_type_JavaUtilList;
    }
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo);
    d();
    QLog.i("ShengPiZiHbFragment", 2, "init view...");
    this.d = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.C));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.hint)) {
      this.d.setHint(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.hint);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aJ));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView = new ChooseItemView(getContext(), null);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setTextSizeInDp(15);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setBackgroundResource(R.drawable.ap);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView);
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.getLayoutParams();
    paramBundle.width = -1;
    paramBundle.height = a();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.d.setFocusable(true);
    this.d.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ax).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.E));
  }
  
  public boolean a()
  {
    super.a();
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  protected void aN_()
  {
    super.aN_();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz = new ShengpiziBizImpl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append("");
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "rarelyword.wrappacket.show", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public int b()
  {
    return R.layout.p;
  }
  
  public String b()
  {
    return this.d.getText().toString();
  }
  
  public void b()
  {
    c();
    e();
    this.jdField_a_of_type_JavaUtilList = GetRecommendWordUtils.a();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      g();
    }
    GetRecommendWordUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 4, new ShengpiziHbFragment.1(this));
  }
  
  public void d()
  {
    try
    {
      JSONObject localJSONObject = RedPacketManagerImpl.getHbPannelConfig(16);
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.skinId = localJSONObject.optInt("skinId");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.hint = localJSONObject.optString("hint");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment$ShengpiziHbBundleInfo.expl_prefix_url = localJSONObject.optString("expl_prefix_url");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.u)
    {
      i();
      return;
    }
    if (i == R.id.ax)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long + 100L > l) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      paramView = a(true);
      this.d.setText(paramView);
      paramView = this.d;
      paramView.setSelection(paramView.getText().length());
      j();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      a("hongbao.wrap.hopngbaokey", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment
 * JD-Core Version:    0.7.0.1
 */