package com.tencent.mobileqq.troop.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.TroopAvatarController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;

public class TroopMoreDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, TroopPhotoController.OnGotoBigPicListener, DecodeTaskCompletionListener
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopMoreDetailFragment.2(this);
  protected IFaceDecoder a;
  ExpandableTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  TextView d;
  TextView e;
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ImageUtil.c();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(a())) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private QQAppInterface a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity.getAppInterface() instanceof QQAppInterface))) {
      return (QQAppInterface)localFragmentActivity.getAppInterface();
    }
    return null;
  }
  
  private String a(long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = getResources().getString(2131696111) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368281));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379987));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380048));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379848));
    this.c = ((TextView)a(2131379947));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)a(2131379919));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = ((TroopMoreDetailView)a(2131379985));
    this.d = ((TextView)a(2131380045));
    this.e = ((TextView)a(2131380006));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = QVipBigTroopExpiredProcessor.c();
    if ((paramBoolean) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
      {
        localObject2 = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (paramBoolean)
        {
          i = 15;
          String str2 = VipUtils.a(0, i).toString();
          String str3 = HardCodeUtil.a(2131715516);
          TroopMoreDetailFragment.3 local3 = new TroopMoreDetailFragment.3(this, paramBoolean);
          if (!paramBoolean) {
            break label169;
          }
          localObject1 = "0X800A57F";
          label114:
          if (!paramBoolean) {
            break label176;
          }
          i = 1;
          label120:
          VipUtils.a((Context)localObject2, str1, str2, str3, local3, (String)localObject1, i, paramBoolean);
        }
      }
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
        return;
        i = 8;
        break;
        label169:
        localObject1 = "0X8009E38";
        break label114;
        label176:
        i = 2;
        break label120;
        VipUtils.a(getActivity(), paramBoolean);
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", false);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean);
    if (!paramBoolean)
    {
      localObject2 = AnimationUtils.a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    gotoBigPic((Bundle)localObject1);
    ReportController.b(a(), "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private void b()
  {
    setTitle(HardCodeUtil.a(2131715522));
    d();
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(20);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    LongClickCopyAction.attachCopyAction(this.jdField_a_of_type_AndroidWidgetTextView, HardCodeUtil.a(2131715525));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    LongClickCopyAction.attachCopyAction(this.jdField_b_of_type_AndroidWidgetTextView, HardCodeUtil.a(2131715526));
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(str1, 11, 15));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new TroopMoreDetailFragment.1(this));
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
          i = 0;
        }
        if ((i <= 0) || (this.jdField_a_of_type_Boolean)) {
          break label434;
        }
        str1 = String.format(getResources().getString(2131693432), new Object[] { Integer.valueOf(i) });
        this.c.setText(str1);
        this.c.setContentDescription(str1);
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        label358:
        if (!this.jdField_a_of_type_Boolean) {
          break label446;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a();
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label434:
      this.c.setVisibility(8);
      break label358;
      label446:
      this.d.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
      {
        this.d.setVisibility(8);
        label474:
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label660;
        }
      }
      label660:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label665;
        }
        this.e.setVisibility(0);
        this.e.setText(getResources().getString(2131693433));
        this.e.setContentDescription(getResources().getString(2131693433));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
        {
          this.d.setVisibility(8);
          break label474;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
        {
          this.d.setText(getString(2131696261));
          break label474;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
        {
          this.d.setText(getString(2131696261));
          break label474;
        }
        this.d.setVisibility(8);
        break label474;
      }
      label665:
      this.e.setVisibility(8);
    }
  }
  
  private void c()
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a();
      } while (localObject == null);
      localObject = (TroopHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject == null);
    ((TroopHandler)localObject).a(1, BizTroopHandler.a(this.jdField_a_of_type_JavaLangString), 0L, 2, 6, 0, false);
  }
  
  private void d()
  {
    Drawable localDrawable = a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {}
    while (!(paramLayoutInflater.getAppInterface() instanceof QQAppInterface)) {
      return;
    }
    paramLayoutInflater.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    a();
    b();
    c();
  }
  
  public int getContentLayoutId()
  {
    return 2131560815;
  }
  
  public void gotoBigPic(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(getActivity(), TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int i;
    if (!localBundle.getBoolean("IS_COVER"))
    {
      i = 1;
      if (i == 0) {
        break label220;
      }
      if (!bool) {
        break label213;
      }
      i = 260;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i), localBundle }));
      }
      startActivityForResult(paramBundle, i);
      return;
      i = 0;
      break;
      label213:
      i = 261;
      continue;
      label220:
      if (bool) {
        i = 258;
      } else {
        i = 259;
      }
    }
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_qidian_private_troop", false);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = ((TroopInfoData)paramBundle.getSerializable("key_troop_info_data"));
    this.jdField_a_of_type_Int = paramBundle.getInt("troop_auth_submit_time", 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramBundle.getAppInterface().getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBundle.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 98: 
    case 99: 
    default: 
      return;
    }
    d();
  }
  
  public void onClick(View paramView)
  {
    if (UIUtils.b()) {}
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = getActivity();
      if (localObject1 != null)
      {
        localObject2 = (QQAppInterface)((FragmentActivity)localObject1).getAppInterface();
        if (localObject2 != null) {
          switch (paramView.getId())
          {
          }
        }
      }
    }
    label96:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label270;
      }
      localObject1 = "0";
    }
    for (;;)
    {
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, "0", (String)localObject1, "");
      break;
      localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject1 = new Intent((Context)localObject1, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      super.startActivity((Intent)localObject1);
      break;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label96;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new TroopAvatarController(getActivity(), getActivity(), (QQAppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
      break label96;
      label270:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        d();
      }
    }
  }
  
  public void onDestroyView()
  {
    this.jdField_b_of_type_Boolean = true;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPicPicked(str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */