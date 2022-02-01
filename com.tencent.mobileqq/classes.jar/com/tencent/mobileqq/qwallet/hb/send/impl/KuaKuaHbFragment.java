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
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
  protected KuaKuaHbFragment.KuaKuaHbBundleInfo a;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChooseItemView jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
  String jdField_b_of_type_JavaLangString;
  
  public KuaKuaHbFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo = new KuaKuaHbFragment.KuaKuaHbBundleInfo();
  }
  
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
                this.jdField_a_of_type_JavaLangString = str1;
                this.jdField_b_of_type_JavaLangString = localJSONObject.optString("typeId");
                return true;
              }
              localJSONArray = localJSONObject.optJSONArray("recommend");
              j = 0;
              if (j < localJSONArray.length())
              {
                str2 = localJSONArray.getString(j);
                if (paramString2.trim().equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = str1;
                  this.jdField_b_of_type_JavaLangString = localJSONObject.optString("typeId");
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
  
  private void e()
  {
    if (!b()) {
      return;
    }
    int i = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    Object localObject1 = QwUtils.a(String.valueOf(QwUtils.a(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QQToast.a(getActivity(), R.string.h, 0).a();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo, this.jdField_a_of_type_Int, i, (String)localObject1, "hongbao.wrap.go");
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.jdField_a_of_type_Int));
    localMap.put("type", "1");
    localMap.put("wishing", localObject2);
    localMap.put("bus_type", "2");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    localMap.put("total_num", ((StringBuilder)localObject2).toString());
    localMap.put("total_amount", localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId);
      ((StringBuilder)localObject1).append("");
      localMap.put("skin_id", ((StringBuilder)localObject1).toString());
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type_id", this.jdField_b_of_type_JavaLangString);
      localMap.put("client_extend", ((JSONObject)localObject1).toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.panel_name);
  }
  
  protected String a()
  {
    return HardCodeUtil.a(R.string.bR);
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
            this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("typeId");
            paramJSONArray = ((JSONObject)localObject).optJSONArray("subjects");
            paramString = ((JSONObject)localObject).optJSONArray("recommend");
            localObject = new LinkedHashSet();
            a((LinkedHashSet)localObject, paramString);
            this.jdField_b_of_type_Int = ((LinkedHashSet)localObject).size();
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
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cz));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cw));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView = new ChooseItemView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, new KuaKuaHbFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setMaxLines(8);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView = new ChooseItemView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, null);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setMaxLines(8);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aJ));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aK));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bizParams:");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
      QLog.i("KuaKuaHbFragment", 2, paramBundle.toString());
    }
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cp).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num))
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.aY));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.bc));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new KuaKuaHbFragment.2(this));
    this.jdField_b_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    QWalletTools.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
    if (paramBundle != null) {
      paramBundle.a();
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new KuaKuaHbFragment.3(this));
  }
  
  public boolean a()
  {
    if ((super.a()) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim()))) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public int b()
  {
    return R.layout.l;
  }
  
  public void b()
  {
    d();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList);
    if (!c()) {
      this.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(0));
    }
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a((List)localObject, false, new KuaKuaHbFragment.4(this), null, null);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView);
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(this.jdField_a_of_type_JavaLangString, false);
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramString = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList, paramString);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(paramString, false, new KuaKuaHbFragment.5(this), null, new KuaKuaHbFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setRecommendCnt(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView);
    paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.getLayoutParams();
    paramString.width = -1;
    paramString.height = a();
  }
  
  public boolean c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo;
    if ((localObject1 != null) && (!StringUtil.a(((KuaKuaHbFragment.KuaKuaHbBundleInfo)localObject1).biz_params)) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList.length() < 1) {
        return false;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bizParams:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
          QLog.i("KuaKuaHbFragment", 2, ((StringBuilder)localObject1).toString());
        }
        if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params))
        {
          Object localObject2 = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
          localObject1 = ((JSONObject)localObject2).optString("subject");
          localObject2 = ((JSONObject)localObject2).optString("subject_type");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (a((String)localObject2, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList)))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
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
  
  public void d()
  {
    try
    {
      JSONObject localJSONObject = RedPacketManagerImpl.getHbPannelConfig(15);
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId = localJSONObject.optInt("skinId");
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList = localJSONObject.optJSONArray("subjectList");
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
    if (paramView.getId() == R.id.u) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KuaKuaHbFragment
 * JD-Core Version:    0.7.0.1
 */