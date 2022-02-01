package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.temp.IFriendsManager;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.util.ArrayList<Ljava.lang.String;>;>;
import java.util.Iterator;
import java.util.Map;

public class ExclusiveHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  protected TextWatcher a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HbInfo.BundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo = new HbInfo.BundleInfo();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  
  public ExclusiveHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new ExclusiveHbFragment.1(this);
  }
  
  private String a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        localStringBuffer.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuffer.append("|");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private ArrayList<ArrayList<String>> a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getAppRuntime();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if (paramIntent == null) {
        return localArrayList1;
      }
      Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
      if (localObject1 != null)
      {
        paramIntent = (IFriendsManager)localBaseQQAppInterface.getRuntimeService(IFriendsManager.class);
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(localResultRecord.uin))
          {
            localArrayList2.add(localResultRecord.uin);
            if (TextUtils.isEmpty(localResultRecord.name))
            {
              Object localObject2;
              if (this.jdField_a_of_type_JavaLangString.equals("1"))
              {
                localObject2 = paramIntent.findFriendEntityByUin(localResultRecord.uin);
                if (localObject2 != null) {
                  localResultRecord.name = ((Friends)localObject2).getFriendNick();
                }
              }
              else if (this.jdField_a_of_type_JavaLangString.equals("2"))
              {
                localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).DiscussionManager$getDiscussMemberName(localBaseQQAppInterface, this.jdField_b_of_type_JavaLangString, localResultRecord.uin);
                if (localObject2 != null) {
                  localResultRecord.name = ((String)localObject2);
                }
              }
              else if (this.jdField_a_of_type_JavaLangString.equals("3"))
              {
                localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(localBaseQQAppInterface, this.jdField_b_of_type_JavaLangString, localResultRecord.uin);
                if (localObject2 != null) {
                  if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).autoremark;
                  } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).troopnick;
                  } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).friendnick;
                  } else {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).memberuin;
                  }
                }
              }
            }
            if (!TextUtils.isEmpty(localResultRecord.name)) {
              localArrayList3.add(localResultRecord.name);
            }
          }
        }
      }
      localArrayList1.add(localArrayList2);
      localArrayList1.add(localArrayList3);
      return localArrayList1;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("ExclusiveHbFragment", 1, paramIntent, new Object[0]);
    }
    return localArrayList1;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.recv_type;
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("recv_uin");
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.j));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.D));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.cv));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(R.id.aM));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(HbBusiUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic(), HardCodeUtil.a(R.string.aK)));
    paramView.findViewById(R.id.az).setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("bizParams:");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.biz_params);
      QLog.i("ExclusiveHbFragment", 2, paramView.toString());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(R.string.I));
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Int = 2;
    c();
    f();
  }
  
  private void c()
  {
    int i;
    if (this.jdField_b_of_type_Int == 1) {
      i = R.drawable.B;
    } else {
      i = R.drawable.A;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Int == 1) {
      i = R.string.H;
    } else {
      i = R.string.G;
    }
    ((TextView)localObject).setText(i);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Int == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aN));
      i = R.string.H;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aF));
      i = R.string.G;
    }
    ((StringBuilder)localObject).append(getString(i));
    localTextView.setContentDescription(((StringBuilder)localObject).toString());
    e();
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    try
    {
      Object localObject = a(this.jdField_a_of_type_JavaUtilArrayList);
      if ((!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localMap.put("grab_uin_list", localObject);
        this.jdField_c_of_type_JavaLangString = String.valueOf(a());
        a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, QwUtils.a(this.jdField_c_of_type_JavaLangString), "only.wrappacket.wrap");
        localMap.put("type", String.valueOf(1));
        localMap.put("wishing", HbBusiUtils.a(this.jdField_b_of_type_AndroidWidgetEditText));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append("");
        localMap.put("bus_type", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append("");
        localMap.put("total_num", ((StringBuilder)localObject).toString());
        localMap.put("total_amount", QwUtils.a(this.jdField_c_of_type_JavaLangString));
        localMap.put("channel", String.valueOf(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
        ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.panel_name);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.showCommonHbToast(HardCodeUtil.a(R.string.aJ));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExclusiveHbFragment", 1, localException, new Object[0]);
    }
  }
  
  private void e()
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
    {
      float f = a();
      if (f <= 0.0F)
      {
        a(false);
        return;
      }
      this.jdField_c_of_type_JavaLangString = String.valueOf(f);
      a(true);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(R.string.I));
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aI));
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      return;
    }
    a(false);
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(HardCodeUtil.a(R.string.aG));
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(HardCodeUtil.a(R.string.aH));
    localTextView.setSingleLine();
    localTextView.setTextSize(15.0F);
    localTextView.setTextColor(getActivity().getResources().getColor(R.color.f));
    QWalletTools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0.6F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
    e();
  }
  
  protected float a()
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    if (this.jdField_b_of_type_Int == 1) {
      return this.jdField_c_of_type_Int * f;
    }
    return f;
  }
  
  public void a(ArrayList<ArrayList<String>> paramArrayList)
  {
    if (!isDetached())
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        return;
      }
      Object localObject2 = null;
      int j = 0;
      Object localObject1;
      if ((paramArrayList != null) && (paramArrayList.size() > 1))
      {
        localObject1 = (ArrayList)paramArrayList.get(0);
        localObject2 = (ArrayList)paramArrayList.get(1);
        paramArrayList = (ArrayList<ArrayList<String>>)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = null;
        paramArrayList = (ArrayList<ArrayList<String>>)localObject2;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        int k = paramArrayList.size();
        localObject2 = new StringBuffer();
        int i = 0;
        while (i < k)
        {
          try
          {
            String str = (String)paramArrayList.get(i);
            ImageView localImageView = new ImageView(getActivity());
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.b(32.0F), ViewUtils.b(32.0F));
            localLayoutParams.setMargins(-ViewUtils.a(5.0F), 0, 0, 0);
            localImageView.setLayoutParams(localLayoutParams);
            localImageView.setImageDrawable(FaceDrawable.getFaceDrawable((BaseQQAppInterface)getQBaseActivity().getAppRuntime(), 1, str));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          i += 1;
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          i = j;
          while (i < ((ArrayList)localObject1).size())
          {
            if (!TextUtils.isEmpty((CharSequence)((ArrayList)localObject1).get(i))) {
              ((StringBuffer)localObject2).append((String)((ArrayList)localObject1).get(i));
            }
            ((StringBuffer)localObject2).append(" ,");
            i += 1;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramArrayList = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.aM));
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.aL));
          ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
          paramArrayList.setContentDescription(((StringBuilder)localObject1).toString());
        }
        e();
        return;
      }
      f();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1) && (paramIntent != null)) {
      a(a(paramIntent));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("only.wrappacket.wrap");
      d();
      return;
    }
    if (i == R.id.cv)
    {
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_b_of_type_Int = 2;
      } else {
        this.jdField_b_of_type_Int = 1;
      }
      c();
      return;
    }
    if ((i == R.id.az) || (i == R.id.aM))
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long + 1200L > l) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.callForwardPage(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.recv_type, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.i, null);
    a(paramLayoutInflater, getArguments());
    b();
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("ExclusiveHbFragment", 2, "ExclusiveHb enter...");
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("only.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ExclusiveHbFragment
 * JD-Core Version:    0.7.0.1
 */