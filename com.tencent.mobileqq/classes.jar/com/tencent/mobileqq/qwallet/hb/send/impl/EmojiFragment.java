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
  public long a;
  protected TextWatcher a;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public View a;
  public Button a;
  public EditText a;
  public ImageView a;
  public EmojiRedpacketUserGuideDialog a;
  public EmoticonTemplateRecyclerView a;
  public EmojiFragment.TemplateBundleInfo a;
  private EmojiFragment.TemplateInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo;
  public String a;
  private List<EmojiFragment.TemplateInfo> jdField_a_of_type_JavaUtilList;
  public int b;
  private SparseArray<ImageView> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  public EditText b;
  private String jdField_b_of_type_JavaLangString;
  public int c;
  int d = 0;
  
  public EmojiFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo = new EmojiFragment.TemplateBundleInfo();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidTextTextWatcher = new EmojiFragment.1(this);
    this.jdField_b_of_type_Int = -1;
  }
  
  private List<EmojiFragment.TemplateInfo> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject1;
        if (StringUtil.a(paramString1))
        {
          localObject1 = RedPacketManagerImpl.getHbPannelConfig(8);
          if (localObject1 == null) {
            break label247;
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
            break label252;
          }
          return localArrayList;
          if (i < paramString1.length())
          {
            localObject1 = new EmojiFragment.TemplateInfo();
            ((EmojiFragment.TemplateInfo)localObject1).jdField_a_of_type_Int = i;
            Object localObject2 = paramString1.optJSONObject(i);
            if (localObject2 != null)
            {
              ((EmojiFragment.TemplateInfo)localObject1).jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("rId");
              ((EmojiFragment.TemplateInfo)localObject1).c = ((JSONObject)localObject2).optInt("skinId");
              ((EmojiFragment.TemplateInfo)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("text");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramString2);
              ((StringBuilder)localObject2).append(((EmojiFragment.TemplateInfo)localObject1).jdField_b_of_type_Int);
              ((StringBuilder)localObject2).append(".png");
              ((EmojiFragment.TemplateInfo)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
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
      label247:
      paramString1 = null;
      continue;
      label252:
      int i = 0;
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    try
    {
      HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo);
      paramView.findViewById(R.id.aB).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmoticonTemplateRecyclerView = ((EmoticonTemplateRecyclerView)paramView.findViewById(R.id.ce));
      paramBundle = new EmojiFragment.TemplateListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity);
      this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.heartList, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.prefix);
      paramBundle.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmoticonTemplateRecyclerView.setAdapter(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmoticonTemplateRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, 4, 1, false));
      paramBundle = new EmojiFragment.TempGridItemLayoutDecoration(this, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, 4);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmoticonTemplateRecyclerView.addItemDecoration(paramBundle);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new MoneyWatcher(this.jdField_b_of_type_AndroidWidgetEditText));
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.aT));
      if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.recv_type))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
        paramView.findViewById(R.id.cp).setVisibility(8);
      }
      else
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.people_num))
        {
          paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(R.string.aC));
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.people_num);
          localStringBuilder.append(HardCodeUtil.a(R.string.aD));
          paramBundle.setHint(localStringBuilder.toString());
        }
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        a((EmojiFragment.TemplateInfo)this.jdField_a_of_type_JavaUtilList.get(0));
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.biz_params;
      if (!StringUtil.a(paramBundle)) {
        this.jdField_b_of_type_JavaLangString = new JSONObject(paramBundle).optString("temp_id");
      }
      if (!StringUtil.a(this.jdField_b_of_type_JavaLangString)) {
        b(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.u));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      c();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void a(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localTemplateInfo = (EmojiFragment.TemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localTemplateInfo.jdField_b_of_type_Int == paramTemplateInfo.jdField_b_of_type_Int) {
          localTemplateInfo.jdField_a_of_type_Boolean = true;
        } else {
          localTemplateInfo.jdField_a_of_type_Boolean = false;
        }
        i += 1;
      }
    }
    EmojiFragment.TemplateInfo localTemplateInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo;
    if (localTemplateInfo != null) {
      a((URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(localTemplateInfo.jdField_b_of_type_Int), false, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo.jdField_b_of_type_Int, (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo.jdField_b_of_type_Int));
    }
    if (paramTemplateInfo != null) {
      a((URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramTemplateInfo.jdField_b_of_type_Int), true, paramTemplateInfo.jdField_b_of_type_Int, (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramTemplateInfo.jdField_b_of_type_Int));
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo = paramTemplateInfo;
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        paramString = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramString.hasNext()) {
          break label121;
        }
        localObject = (EmojiFragment.TemplateInfo)paramString.next();
        if (i != ((EmojiFragment.TemplateInfo)localObject).jdField_b_of_type_Int) {
          continue;
        }
        a((EmojiFragment.TemplateInfo)localObject);
        i = 1;
        if (i == 0)
        {
          QQToast.a(getActivity(), R.string.C, 0).a();
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processDefaultTmpSelected occur an exception: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("EmojiFragment", 1, ((StringBuilder)localObject).toString());
        QQToast.a(getActivity(), R.string.C, 0).a();
      }
      return;
      label121:
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
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    if (paramBoolean)
    {
      paramImageView = new Bundle();
      paramImageView.putBoolean("key_play_apng", false);
      ThreadManager.excute(new EmojiFragment.2(this, QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a, paramImageView)), 16, null, true);
    }
  }
  
  public void a(EmojiFragment.TemplateInfo paramTemplateInfo, ImageView paramImageView)
  {
    this.jdField_b_of_type_Int = paramTemplateInfo.jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramTemplateInfo.jdField_a_of_type_JavaLangString;
    this.c = paramTemplateInfo.c;
    c();
    if (this.jdField_a_of_type_AndroidWidgetImageView == paramImageView) {
      return;
    }
    paramImageView.setBackgroundResource(R.drawable.h);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    a(paramTemplateInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("phiz.wrappacket.wrap");
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
    localMap.put("feedsid", String.valueOf(this.jdField_b_of_type_Int));
    localMap.put("bus_type", "2");
    localMap.put("total_num", localObject);
    localMap.put("total_amount", QwUtils.a(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    localMap.put("channel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("");
    localMap.put("skin_id", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateBundleInfo.panel_name);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (this.jdField_b_of_type_Int != -1)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      QLog.i("EmojiFragment", 2, "info is not complete...");
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(R.string.I));
      return;
    }
    if ((QwUtils.a((String)localObject) > 0.0F) && (QwUtils.a(str) > 0.0F))
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(getString(R.string.I));
      ((StringBuffer)localObject).append(str);
      ((StringBuffer)localObject).append("元");
      this.jdField_a_of_type_AndroidWidgetButton.setText(((StringBuffer)localObject).toString());
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(R.string.I));
  }
  
  public void d()
  {
    EmojiRedpacketUserGuideDialog localEmojiRedpacketUserGuideDialog = this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiRedpacketUserGuideDialog;
    if (localEmojiRedpacketUserGuideDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiRedpacketUserGuideDialog = new EmojiRedpacketUserGuideDialog(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity);
    } else if (localEmojiRedpacketUserGuideDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiRedpacketUserGuideDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiRedpacketUserGuideDialog.show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.u)
    {
      b();
      return;
    }
    if (i == R.id.aB) {
      d();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getWindow().setSoftInputMode(32);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(R.layout.h, null);
    a(this.jdField_a_of_type_AndroidViewView, getArguments());
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.jdField_b_of_type_AndroidUtilSparseArray;
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
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("phiz.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment
 * JD-Core Version:    0.7.0.1
 */