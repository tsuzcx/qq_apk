package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import ajya;
import akhp;
import akhv;
import akil;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bagy;
import bagz;
import baha;
import bahb;
import bahc;
import bahd;
import bahe;
import baiz;
import baxy;
import baxz;
import bbbp;
import bbef;
import bbfj;
import bcql;
import bfpc;
import bfpp;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mxk;
import mxl;
import org.json.JSONObject;
import tencent.im.troop.homework.ReqSend1V1Msg;
import vzl;
import vzo;

public class BulkSendMessageFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, baxz, mxl
{
  public int a;
  private akil a;
  public Handler a;
  protected View a;
  protected Button a;
  protected TextView a;
  public bahd a;
  protected baxy a;
  public QQAppInterface a;
  public ClearableEditText a;
  protected MyGridView a;
  public Runnable a;
  public String a;
  public List<String> a;
  public mxk a;
  public vzo a;
  public View b;
  protected TextView b;
  
  public BulkSendMessageFragment()
  {
    this.jdField_a_of_type_Bahd = new bahd(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaLangRunnable = new BulkSendMessageFragment.1(this);
    this.jdField_a_of_type_Akil = new bagy(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.mContentView.findViewById(2131365515));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getLayoutParams();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(300) });
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i, i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setGravity(48);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((int)(150.0F * this.mDensity));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(ajya.a(2131701231));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnTouchListener(new bagz(this));
    this.mContentView.setOnTouchListener(new baha(this));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131363525);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378471));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)this.mContentView.findViewById(2131378752));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Bahd);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363649));
    this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131701239));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131369034);
    this.mContentView.findViewById(2131363652).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378482));
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.mContentView.findViewById(2131376107).setVisibility(8);
    }
    for (;;)
    {
      setTitle(ajya.a(2131701225));
      c();
      b();
      localObject = bbbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      bbbp.a("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localObject });
      return;
      this.mContentView.findViewById(2131376107).setOnClickListener(new bahb(this));
    }
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.a(paramActivity, localIntent, BulkSendMessageFragment.class);
    paramActivity.overridePendingTransition(2130772278, 2130771990);
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
    if (i > 300) {}
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131166984);; localColorStateList = getResources().getColorStateList(2131166933))
    {
      String str = i + "/" + 300;
      if (localColorStateList != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void c()
  {
    int k = 8;
    boolean bool2 = true;
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length();
    int m = this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList.size();
    int i;
    label52:
    label59:
    Object localObject;
    if (m > 0)
    {
      i = 1;
      if ((j < 1) || (j > 300) || (i == 0)) {
        break label194;
      }
      bool1 = true;
      if (m <= 0) {
        break label200;
      }
      j = 1;
      localObject = String.format(Locale.getDefault(), "（%d个）", new Object[] { Integer.valueOf(m) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (j == 0) {
        break label205;
      }
      j = 0;
      label103:
      ((TextView)localObject).setVisibility(j);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(bool1);
      localObject = this.jdField_a_of_type_AndroidViewView;
      j = k;
      if (i != 0) {
        j = 0;
      }
      ((View)localObject).setVisibility(j);
      localObject = this.jdField_a_of_type_Bahd;
      if (this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
        break label211;
      }
    }
    label194:
    label200:
    label205:
    label211:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((bahd)localObject).jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Bahd.notifyDataSetChanged();
      return;
      i = 0;
      break;
      bool1 = false;
      break label52;
      j = 0;
      break label59;
      j = 8;
      break label103;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localbfpc.c((String)localIterator.next());
    }
    localbfpc.c(2131690596);
    localbfpc.a(new bahc(this, localbfpc));
    localbfpc.show();
  }
  
  public void a(bahe parambahe, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (parambahe.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Baxy.b(3, parambahe.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bbef.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Baxy.a())
        {
          this.jdField_a_of_type_Baxy.a(parambahe.jdField_a_of_type_JavaLangString, 3, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      parambahe.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
    b();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("extra.GROUP_UIN");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    this.jdField_a_of_type_Baxy = new baxy(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramLayoutInflater = ((baiz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109)).a("BulkChatMessageConfig");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "ReadConfig: ", String.valueOf(paramLayoutInflater) });
    }
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_Int = paramLayoutInflater.optInt("user_limit", this.jdField_a_of_type_Int);
      if (paramLayoutInflater.optJSONArray("hints") == null) {}
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_Mxk = new mxk(this.mContentView, this, ImmersiveUtils.getStatusBarHeight(getActivity()) + 160);
  }
  
  public int getContentLayoutId()
  {
    return 2131560303;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break;
        }
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
        if (QLog.isColorLevel())
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", ((ResultRecord)paramIntent.next()).jdField_a_of_type_JavaLangString });
          }
        }
      }
      QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null!", new NullPointerException());
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringArrayListExtra("extra_member_uin_list");
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = paramIntent.iterator();
          while (((Iterator)localObject).hasNext()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", (String)((Iterator)localObject).next() });
          }
        }
        paramInt2 = this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList.size() - paramIntent.size();
        if ((paramInt1 == 2) && (paramInt2 != 0))
        {
          localObject = bbbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          bbbp.a("Grp_edu", "MassMessage", "MemberEdit_Complete", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localObject, String.valueOf(paramInt2) });
        }
        this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramIntent);
        this.jdField_a_of_type_Bahd.notifyDataSetChanged();
        c();
        return;
      }
      if (paramInt2 != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(".troop.troop_app.BulkSendMessageFragment", 1, new Object[] { "SelectMember canceled! requestCode: ", Integer.valueOf(paramInt1), new NullPointerException() });
    return;
    QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null! requestCode: " + paramInt1, new NullPointerException());
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    getActivity().overridePendingTransition(0, 2130772001);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = TroopMemberListActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, 21);
      paramView.putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList);
      paramView.putStringArrayListExtra("param_delete_filter_member_list", this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList);
      paramView.putExtra("param_pick_max_num", this.jdField_a_of_type_Int);
      paramView.putExtra("param_pick_title_string", ajya.a(2131701236));
      startActivityForResult(paramView, 2);
      getActivity().overridePendingTransition(2130772278, 2130771990);
      bbbp.a("Grp_edu", "MassMessage", "Member_Edit", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (paramView.length() < 4)
      {
        paramView = String.format(Locale.getDefault(), ajya.a(2131701230), new Object[] { Integer.valueOf(4) });
        bcql.a(getActivity(), 1, paramView, 1).a();
        return;
      }
      if (!bbfj.g(getActivity()))
      {
        paramView = String.format(Locale.getDefault(), ajya.a(2131701234), new Object[0]);
        bcql.a(getActivity(), 1, paramView, 1).a();
        return;
      }
      akhp localakhp;
      homework.ReqSend1V1Msg localReqSend1V1Msg;
      int i;
      try
      {
        localakhp = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        localReqSend1V1Msg = new homework.ReqSend1V1Msg();
        i = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
        Iterator localIterator = this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localReqSend1V1Msg.to_uins.add(Long.valueOf(Long.parseLong(str)));
        }
        localReqSend1V1Msg.text.set(ByteStringMicro.copyFromUtf8(paramView));
      }
      catch (NumberFormatException paramView)
      {
        paramView = ajya.a(2131701237);
        bcql.a(getActivity(), 1, paramView, 1).a();
        return;
      }
      localReqSend1V1Msg.int32_time_zone.set(i);
      localReqSend1V1Msg.group_id.set(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Vzo != null)
      {
        this.jdField_a_of_type_Vzo.a();
        this.jdField_a_of_type_Vzo = null;
      }
      this.jdField_a_of_type_Vzo = vzl.a(getActivity(), ajya.a(2131701238));
      akhv.a(localakhp, localReqSend1V1Msg);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() == 0)
      {
        bcql.a(getActivity(), 1, String.format(Locale.getDefault(), ajya.a(2131701229), new Object[0]), 1).a();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() < 4)
      {
        bcql.a(getActivity(), 1, String.format(Locale.getDefault(), ajya.a(2131701227), new Object[] { Integer.valueOf(4) }), 1).a();
        return;
      }
    } while (!this.jdField_a_of_type_Bahd.jdField_a_of_type_JavaUtilArrayList.isEmpty());
    bcql.a(getActivity(), 1, String.format(Locale.getDefault(), ajya.a(2131701235), new Object[0]), 1).a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof bahe)))
        {
          localObject = (bahe)localObject;
          if (paramString != null) {
            break label72;
          }
          a((bahe)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((bahe)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((bahe)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_Baxy.a(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_Mxk.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment
 * JD-Core Version:    0.7.0.1
 */