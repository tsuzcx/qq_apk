package com.tencent.mobileqq.troop.troop_apps.entry.ui;

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
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopHandler.TroopBulkSendMessage;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import tencent.im.troop.homework.ReqSend1V1Msg;

public class BulkSendMessageFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, SoftKeyboardObserver.OnSoftKeyboardToggledListener, DecodeTaskCompletionListener
{
  protected int a;
  public Handler a;
  protected View a;
  protected Button a;
  protected TextView a;
  public SoftKeyboardObserver a;
  protected UIUtils.StoryProgressUI a;
  protected QQAppInterface a;
  private TroopBusinessObserver a;
  protected IFaceDecoder a;
  protected BulkSendMessageFragment.ListAdapter a;
  protected ClearableEditText a;
  protected MyGridView a;
  public Runnable a;
  protected String a;
  protected List<String> a;
  public View b;
  protected TextView b;
  
  public BulkSendMessageFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter = new BulkSendMessageFragment.ListAdapter(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaLangRunnable = new BulkSendMessageFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new BulkSendMessageFragment.2(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.mContentView.findViewById(2131366174));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(HardCodeUtil.a(2131701307));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnTouchListener(new BulkSendMessageFragment.3(this));
    this.mContentView.setOnTouchListener(new BulkSendMessageFragment.4(this));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131363991);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380763));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)this.mContentView.findViewById(2131381044));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364131));
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701315));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131370193);
    this.mContentView.findViewById(2131364135).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380771));
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.mContentView.findViewById(2131378069).setVisibility(8);
    }
    for (;;)
    {
      setTitle(HardCodeUtil.a(2131701301));
      c();
      b();
      localObject = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      TroopReportor.a("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localObject });
      return;
      this.mContentView.findViewById(2131378069).setOnClickListener(new BulkSendMessageFragment.5(this));
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
    paramActivity.overridePendingTransition(2130772314, 2130771992);
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
    if (i > 300) {}
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131167175);; localColorStateList = getResources().getColorStateList(2131167119))
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
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
        break label211;
      }
    }
    label194:
    label200:
    label205:
    label211:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((BulkSendMessageFragment.ListAdapter)localObject).jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.notifyDataSetChanged();
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localActionSheet.addButton((String)localIterator.next());
    }
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new BulkSendMessageFragment.6(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(BulkSendMessageFragment.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(3, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.c();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, 3, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramLayoutInflater = ((TroopAppMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR)).a("BulkChatMessageConfig");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "ReadConfig: ", String.valueOf(paramLayoutInflater) });
    }
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_Int = paramLayoutInflater.optInt("user_limit", this.jdField_a_of_type_Int);
      if (paramLayoutInflater.optJSONArray("hints") == null) {}
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.mContentView, this, ImmersiveUtils.getStatusBarHeight(getActivity()) + 160);
  }
  
  public int getContentLayoutId()
  {
    return 2131560732;
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
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", ((ResultRecord)paramIntent.next()).uin });
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
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.size() - paramIntent.size();
        if ((paramInt1 == 2) && (paramInt2 != 0))
        {
          localObject = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          TroopReportor.a("Grp_edu", "MassMessage", "MemberEdit_Complete", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localObject, String.valueOf(paramInt2) });
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.notifyDataSetChanged();
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
    getActivity().overridePendingTransition(0, 2130772003);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = TroopMemberListActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, 21);
      ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject).putStringArrayListExtra("param_delete_filter_member_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("param_pick_max_num", this.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("param_pick_title_string", HardCodeUtil.a(2131701312));
      startActivityForResult((Intent)localObject, 2);
      getActivity().overridePendingTransition(2130772314, 2130771992);
      TroopReportor.a("Grp_edu", "MassMessage", "Member_Edit", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (((String)localObject).length() < 4)
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701306), new Object[] { Integer.valueOf(4) });
        QQToast.a(getActivity(), 1, (CharSequence)localObject, 1).a();
      }
      else if (!NetworkUtil.g(getActivity()))
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701310), new Object[0]);
        QQToast.a(getActivity(), 1, (CharSequence)localObject, 1).a();
      }
      else
      {
        TroopHandler localTroopHandler;
        homework.ReqSend1V1Msg localReqSend1V1Msg;
        int i;
        String str1;
        try
        {
          localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          localReqSend1V1Msg = new homework.ReqSend1V1Msg();
          i = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            localReqSend1V1Msg.to_uins.add(Long.valueOf(Long.parseLong(str2)));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          str1 = HardCodeUtil.a(2131701313);
          QQToast.a(getActivity(), 1, str1, 1).a();
        }
        localReqSend1V1Msg.text.set(ByteStringMicro.copyFromUtf8(str1));
        localReqSend1V1Msg.int32_time_zone.set(i);
        localReqSend1V1Msg.group_id.set(Long.parseLong(this.jdField_a_of_type_JavaLangString));
        if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI.a();
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI = null;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI = UIUtils.a(getActivity(), HardCodeUtil.a(2131701314));
        TroopHandler.TroopBulkSendMessage.a(localTroopHandler, localReqSend1V1Msg);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() == 0) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701305), new Object[0]), 1).a();
        } else if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() < 4) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701303), new Object[] { Integer.valueOf(4) }), 1).a();
        } else if (this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701311), new Object[0]), 1).a();
        }
      }
    }
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
        if ((localObject != null) && ((localObject instanceof BulkSendMessageFragment.ViewHolder)))
        {
          localObject = (BulkSendMessageFragment.ViewHolder)localObject;
          if (paramString != null) {
            break label72;
          }
          a((BulkSendMessageFragment.ViewHolder)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((BulkSendMessageFragment.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((BulkSendMessageFragment.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment
 * JD-Core Version:    0.7.0.1
 */