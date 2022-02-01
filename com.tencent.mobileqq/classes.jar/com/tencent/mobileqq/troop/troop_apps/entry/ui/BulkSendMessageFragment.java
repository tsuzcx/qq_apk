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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.IHomeworkHandler;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
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
  protected IFaceDecoder a;
  private HomeworkObserver a;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver = new BulkSendMessageFragment.2(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.mContentView.findViewById(2131366076));
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
      ((ViewGroup.LayoutParams)localObject).height = ((int)(this.mDensity * 150.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(HardCodeUtil.a(2131701447));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnTouchListener(new BulkSendMessageFragment.3(this));
    this.mContentView.setOnTouchListener(new BulkSendMessageFragment.4(this));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131363918);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380028));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)this.mContentView.findViewById(2131380309));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364052));
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701455));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131369861);
    this.mContentView.findViewById(2131364056).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380036));
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.mContentView.findViewById(2131377497).setVisibility(8);
    } else {
      this.mContentView.findViewById(2131377497).setOnClickListener(new BulkSendMessageFragment.5(this));
    }
    setTitle(HardCodeUtil.a(2131701441));
    c();
    b();
    localObject = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    TroopReportor.a("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localObject });
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
    paramActivity.overridePendingTransition(2130772342, 2130772004);
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
    ColorStateList localColorStateList;
    if (i > 300) {
      localColorStateList = getResources().getColorStateList(2131167200);
    } else {
      localColorStateList = getResources().getColorStateList(2131167144);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(300);
    localObject = ((StringBuilder)localObject).toString();
    if (localColorStateList != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  private void c()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length();
    int k = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool2 = true;
    int i;
    if (k > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1;
    if ((j >= 1) && (j <= 300) && (i != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (k > 0) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject = String.format(Locale.getDefault(), "（%d个）", new Object[] { Integer.valueOf(k) });
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    k = 8;
    if (j != 0) {
      j = 0;
    } else {
      j = 8;
    }
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
    if (((BulkSendMessageFragment.ListAdapter)localObject).jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Int) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((BulkSendMessageFragment.ListAdapter)localObject).jdField_a_of_type_Boolean = bool1;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.notifyDataSetChanged();
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ActionSheet)localObject).addButton((String)localIterator.next());
      }
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new BulkSendMessageFragment.6(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  protected void a(BulkSendMessageFragment.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(3, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.f();
      }
      paramBitmap = localBitmap;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, 3, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("extra.GROUP_UIN");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramLayoutInflater = ((ITroopAppService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopAppService.class, "all")).getAppConfig("BulkChatMessageConfig");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "ReadConfig: ", String.valueOf(paramLayoutInflater) });
    }
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_Int = paramLayoutInflater.optInt("user_limit", this.jdField_a_of_type_Int);
      paramLayoutInflater.optJSONArray("hints");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.mContentView, this, ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 160);
  }
  
  protected int getContentLayoutId()
  {
    return 2131560620;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return;
      }
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
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_app.BulkSendMessageFragment", 1, new Object[] { "SelectMember canceled! requestCode: ", Integer.valueOf(paramInt1), new NullPointerException() });
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Error! SelectMember return null! requestCode: ");
        paramIntent.append(paramInt1);
        QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, paramIntent.toString(), new NullPointerException());
      }
    }
    else if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if (QLog.isColorLevel()) {
        paramIntent = paramIntent.iterator();
      }
    }
    else
    {
      while (paramIntent.hasNext())
      {
        QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", ((ResultRecord)paramIntent.next()).uin });
        continue;
        QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null!", new NullPointerException());
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    getBaseActivity().overridePendingTransition(0, 2130772015);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363918)
    {
      if (i != 2131364052)
      {
        if (i != 2131364056) {
          break label605;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() == 0)
        {
          QQToast.a(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701445), new Object[0]), 1).a();
          break label605;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length() < 4)
        {
          QQToast.a(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701443), new Object[] { Integer.valueOf(4) }), 1).a();
          break label605;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label605;
        }
        QQToast.a(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131701451), new Object[0]), 1).a();
        break label605;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (((String)localObject).length() < 4)
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701446), new Object[] { Integer.valueOf(4) });
        QQToast.a(getBaseActivity(), 1, (CharSequence)localObject, 1).a();
        break label605;
      }
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701450), new Object[0]);
        QQToast.a(getBaseActivity(), 1, (CharSequence)localObject, 1).a();
        break label605;
      }
    }
    try
    {
      homework.ReqSend1V1Msg localReqSend1V1Msg = new homework.ReqSend1V1Msg();
      i = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localReqSend1V1Msg.to_uins.add(Long.valueOf(Long.parseLong(str)));
      }
      localReqSend1V1Msg.text.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqSend1V1Msg.int32_time_zone.set(i);
      localReqSend1V1Msg.group_id.set(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI.a();
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI = null;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$StoryProgressUI = UIUtils.a(getBaseActivity(), HardCodeUtil.a(2131701454));
      ((IHomeworkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName())).a(localReqSend1V1Msg);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label449:
      break label449;
    }
    Object localObject = HardCodeUtil.a(2131701453);
    QQToast.a(getBaseActivity(), 1, (CharSequence)localObject, 1).a();
    break label605;
    localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("param_from", 21);
    ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList);
    ((Intent)localObject).putStringArrayListExtra("param_delete_filter_member_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$ListAdapter.jdField_a_of_type_JavaUtilArrayList);
    ((Intent)localObject).putExtra("param_pick_max_num", this.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("param_pick_title_string", HardCodeUtil.a(2131701452));
    RouteUtils.a(getActivity(), (Intent)localObject, "/troop/memberlist/TroopMemberList", 2);
    getBaseActivity().overridePendingTransition(2130772342, 2130772004);
    TroopReportor.a("Grp_edu", "MassMessage", "Member_Edit", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
    label605:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof BulkSendMessageFragment.ViewHolder)))
        {
          localObject = (BulkSendMessageFragment.ViewHolder)localObject;
          if (paramString == null)
          {
            a((BulkSendMessageFragment.ViewHolder)localObject, null, false);
          }
          else if (paramString.equals(((BulkSendMessageFragment.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
          {
            ((BulkSendMessageFragment.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment
 * JD-Core Version:    0.7.0.1
 */