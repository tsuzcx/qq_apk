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
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0);
  private static final Map<Integer, GetRecommendWordUtils.RspRecommendInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_a_of_type_Long = 0L;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ISoftKeyboardObserverTemp jdField_a_of_type_ComQwalletTempISoftKeyboardObserverTemp;
  private IPasswdRedBagService jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService;
  private IWordChainBiz jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz;
  private WordChainHbFragment.IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo = new WordChainHbFragment.IdiomHbBundleInfo();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<WordChainHbFragment.WordChainTypeLabel> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<GetRecommendWords.CopyWriter> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  
  private IWordChainBiz a(int paramInt)
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
  
  private String a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz != null))
      {
        Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
        localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz.a((List)localObject, paramBoolean);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WordChainHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz;
      if (localObject != null)
      {
        localObject = ((IWordChainBiz)localObject).a(paramInt);
        this.jdField_c_of_type_AndroidWidgetEditText.setFilters((InputFilter[])localObject);
      }
    }
  }
  
  private void a(TextView paramTextView, WordChainHbFragment.WordChainTypeLabel paramWordChainTypeLabel)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.X));
    paramTextView.setTextColor(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo != null) && ((paramTextView.getTag() instanceof WordChainHbFragment.WordChainTypeLabel)))
    {
      Object localObject = (WordChainHbFragment.WordChainTypeLabel)paramTextView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = ((WordChainHbFragment.WordChainTypeLabel)localObject).jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(paramTextView.getText().toString());
      ((TextView)localObject).setText(localStringBuilder.toString());
      if (this.jdField_c_of_type_Boolean) {
        jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_last_selete_label", this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel).apply();
      }
      a(paramWordChainTypeLabel.jdField_b_of_type_Int);
      d();
      if (this.jdField_c_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_c_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
        if (!TextUtils.isEmpty(paramWordChainTypeLabel.jdField_b_of_type_JavaLangString)) {
          this.jdField_c_of_type_AndroidWidgetEditText.setHint(paramWordChainTypeLabel.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
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
  
  private void d()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = (GetRecommendWordUtils.RspRecommendInfo)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
    if ((localRspRecommendInfo == null) || (localRspRecommendInfo.jdField_a_of_type_JavaUtilList.isEmpty()) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - localRspRecommendInfo.jdField_a_of_type_Long) > 86400000L)) {
      GetRecommendWordUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.recv_type, new WordChainHbFragment.1(this));
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic() != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = new WordChainHbFragment.WordChainTypeLabel();
      localWordChainTypeLabel.jdField_a_of_type_JavaLangString = HardCodeUtil.a(R.string.dy);
      localWordChainTypeLabel.jdField_a_of_type_Int = 0;
      localWordChainTypeLabel.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localWordChainTypeLabel);
    }
  }
  
  private void f()
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.W));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private void g()
  {
    e();
    this.jdField_a_of_type_AndroidViewViewGroup.post(new WordChainHbFragment.2(this));
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      int j = ((ViewGroup)localObject).getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localObject instanceof TextView))
          {
            localObject = (TextView)localObject;
            WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = (WordChainHbFragment.WordChainTypeLabel)((TextView)localObject).getTag();
            WordChainHbFragment.IdiomHbBundleInfo localIdiomHbBundleInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo;
            if ((localIdiomHbBundleInfo != null) && (localIdiomHbBundleInfo.currSelectedSubChannel == localWordChainTypeLabel.jdField_a_of_type_Int))
            {
              a((TextView)localObject, localWordChainTypeLabel);
              this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void i()
  {
    boolean bool = StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.biz_params);
    int j = 0;
    int i = j;
    if (!bool) {
      try
      {
        this.jdField_c_of_type_Boolean = false;
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.biz_params);
        String str2 = localJSONObject.optString("idiom", "");
        int k = localJSONObject.optInt("sub_channel", 0);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = k;
        i = j;
        if (!TextUtils.isEmpty(str2))
        {
          this.jdField_c_of_type_AndroidWidgetEditText.setText(str2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(k, str2);
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
      String str1 = HbBusiUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic(), a());
      this.jdField_c_of_type_AndroidWidgetEditText.setHint(str1);
    }
  }
  
  private void j()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.a(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localMap.put("channel", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.skinId);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
    ((StringBuilder)localObject).append("");
    localMap.put("subchannel", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.panel_name);
  }
  
  protected String a()
  {
    return HardCodeUtil.a(R.string.aU);
  }
  
  public List<GetRecommendWords.CopyWriter> a(int paramInt)
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = (GetRecommendWordUtils.RspRecommendInfo)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localRspRecommendInfo != null) {
      return localRspRecommendInfo.jdField_a_of_type_JavaUtilList;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bizParams:");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
    }
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cp).setVisibility(8);
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.people_num))
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(R.string.aY));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.people_num);
        localStringBuilder.append(HardCodeUtil.a(R.string.bc));
        paramBundle.setHint(localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new WordChainHbFragment.3(this));
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ay).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cM));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.h);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ap);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cy));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cx));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isFlyMe: ");
      paramBundle.append(SystemUtil.d());
      paramBundle.append(" isMeizu:");
      paramBundle.append(SystemUtil.e());
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("biz_params: ");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      QLog.i("WordChainHbFragment", 2, paramBundle.toString());
    }
  }
  
  public boolean a()
  {
    IWordChainBiz localIWordChainBiz = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz;
    if (localIWordChainBiz != null) {
      localIWordChainBiz.a(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim());
    }
    if (super.a())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicIWordChainBiz.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  protected void aN_()
  {
    super.aN_();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class));
    g();
  }
  
  public int b()
  {
    return R.layout.k;
  }
  
  public void b()
  {
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    i();
    c();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.showToast(paramString);
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
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
    if (i == R.id.u)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("idiom.wrappacket.wrap");
      j();
      return;
    }
    if (i == R.id.ay)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long + 100L > l) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      paramView = a(true);
      this.jdField_c_of_type_AndroidWidgetEditText.setText(paramView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, paramView);
      this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
      d();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ISoftKeyboardObserverTemp localISoftKeyboardObserverTemp = this.jdField_a_of_type_ComQwalletTempISoftKeyboardObserverTemp;
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
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("idiom.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */