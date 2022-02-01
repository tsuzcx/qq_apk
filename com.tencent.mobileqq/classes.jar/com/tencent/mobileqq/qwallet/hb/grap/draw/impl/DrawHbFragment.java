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
  private long jdField_a_of_type_Long = 0L;
  protected TextWatcher a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ChooseItemView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
  DrawHbFragment.DrawHbBundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo = new DrawHbFragment.DrawHbBundleInfo();
  private String jdField_a_of_type_JavaLangString;
  private EditText b;
  
  public DrawHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new DrawHbFragment.7(this);
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.modelList)) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.modelList);
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
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.aT));
    this.b = ((EditText)paramView.findViewById(R.id.b));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    paramBundle = this.b;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.k));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.cz));
    StringBuilder localStringBuilder;
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.drawParam))
      {
        paramBundle = RedPacketManagerImpl.getHbPannelConfig(10);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.skinId = paramBundle.optString("skinId");
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.drawParam = paramBundle.optString("subjects");
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.recommend = paramBundle.optString("recommend");
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.modelList = paramBundle.optString("modelList");
        }
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.biz_params;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("bizParams:");
        localStringBuilder.append(paramBundle);
        QLog.i("DrawHbFragment", 2, localStringBuilder.toString());
      }
      if (!StringUtil.a(paramBundle))
      {
        paramBundle = new JSONObject(paramBundle).optString("subject", "");
        if ((!TextUtils.isEmpty(paramBundle)) && (c(paramBundle))) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      paramView.findViewById(R.id.cp).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.people_num))
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.ap));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.aq));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new DrawHbFragment.2(this));
    QWalletTools.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(R.id.aJ));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView = new ChooseItemView(getQBaseActivity(), new DrawHbFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setOnClickListener(new DrawHbFragment.4(this));
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.recommend, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.drawParam, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.modelList);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(paramBundle, false, new DrawHbFragment.5(this), null, new DrawHbFragment.6(this, paramView));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setRecommendCnt(b());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView);
    paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.getLayoutParams();
    paramView.width = -1;
    paramView.height = a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
    if (paramView != null) {
      paramView.a();
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
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(R.string.I));
    }
  }
  
  private int b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.recommend)) {
      return 0;
    }
    try
    {
      int i = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.recommend).length();
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private void b()
  {
    String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
    this.jdField_a_of_type_JavaLangString = str;
    if (TextUtils.isEmpty(str))
    {
      a(false);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    str = this.b.getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      if ((QwUtils.a((String)localObject) > 0.0F) && (QwUtils.a(str) > 0.0F))
      {
        a(true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(R.string.I));
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.ao));
        str = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  private boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.drawParam)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.drawParam);
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
  
  private void c()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.b.getText().toString();
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    localMap.put("type", "1");
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.a(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.skinId);
    }
    if (!b(this.jdField_a_of_type_JavaLangString))
    {
      localMap.put("feedsid", a(this.jdField_a_of_type_JavaLangString));
      localMap.put("subchannel", "1");
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawHbFragment$DrawHbBundleInfo.panel_name);
  }
  
  private boolean c(String paramString)
  {
    return (b(paramString)) || (!TextUtils.isEmpty(a(paramString)));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.k)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("draw.wrappacket.wrap");
      c();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.t, null);
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
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("draw.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment
 * JD-Core Version:    0.7.0.1
 */