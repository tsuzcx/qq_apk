package com.tencent.mobileqq.troop.troopcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;

public class TroopMoreDetailFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, DecodeTaskCompletionListener, TroopPhotoController.OnGotoBigPicListener
{
  int jdField_a_of_type_Int;
  protected IFaceDecoder a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMoreDetailFragment.2(this);
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
  ExpandableTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  boolean jdField_c_of_type_Boolean = false;
  ImageView d;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  TextView k;
  
  private Drawable a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseImageUtil.f();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(a())) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  private AppInterface a()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && ((localQBaseActivity.getAppRuntime() instanceof AppInterface))) {
      return (AppInterface)localQBaseActivity.getAppRuntime();
    }
    return null;
  }
  
  private String a(long paramLong)
  {
    if (paramLong > 0L)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131696128));
      localStringBuilder.append(localSimpleDateFormat.format(Long.valueOf(paramLong * 1000L)));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131368033));
    this.g = ((TextView)a(2131379316));
    this.h = ((TextView)a(2131379377));
    this.d = ((ImageView)a(2131379177));
    this.i = ((TextView)a(2131379276));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)a(2131379248));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView = ((TroopMoreDetailView)a(2131379314));
    this.j = ((TextView)a(2131379374));
    this.k = ((TextView)a(2131379335));
  }
  
  private void c()
  {
    a(HardCodeUtil.a(2131715444));
    e();
    this.g.setMaxLines(20);
    this.g.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName);
    this.g.setEllipsize(TextUtils.TruncateAt.END);
    LongClickCopyAction.attachCopyAction(this.g, HardCodeUtil.a(2131715447));
    this.h.setText(this.jdField_a_of_type_JavaLangString);
    LongClickCopyAction.attachCopyAction(this.h, HardCodeUtil.a(2131715448));
    String str = a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopCreateTime);
    Object localObject = str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText((CharSequence)localObject, 11, 15));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new TroopMoreDetailFragment.1(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwAuthGroupType != 2L) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwAuthGroupType != 1L))
      {
        this.d.setVisibility(8);
      }
      else
      {
        this.d.setVisibility(0);
        this.d.setOnClickListener(this);
      }
    }
    else {
      this.d.setVisibility(8);
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nTroopGrade;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
      m = 0;
    }
    int n = 1;
    if ((m > 0) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = String.format(getResources().getString(2131693387), new Object[] { Integer.valueOf(m) });
      this.i.setText((CharSequence)localObject);
      this.i.setContentDescription((CharSequence)localObject);
      this.i.setVisibility(0);
      this.i.setOnClickListener(this);
    }
    else
    {
      this.i.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
    }
    else
    {
      this.j.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 1) {
        this.j.setVisibility(8);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 0) {
        this.j.setVisibility(8);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 2) {
        this.j.setText(getString(2131696280));
      } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 3) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 4)) {
        this.j.setVisibility(8);
      } else {
        this.j.setText(getString(2131696280));
      }
      if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
        m = n;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        this.k.setVisibility(0);
        this.k.setText(getResources().getString(2131693388));
        this.k.setContentDescription(getResources().getString(2131693388));
      }
      else
      {
        this.k.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.setGuestVisitor(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a();
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = QVipBigTroopExpiredProcessor.c();
    if ((paramBoolean) && (((QVipBigTroopExpiredConfig)localObject).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModiftyTroopHeadFreezed(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, getQBaseActivity());
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("IS_COVER", false);
    ((Bundle)localObject).putBoolean("IS_EDIT", paramBoolean);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleEditClosed(paramBoolean, this.jdField_c_of_type_AndroidWidgetImageView, (Bundle)localObject);
    b((Bundle)localObject);
    ReportController.b(a(), "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str, localObject });
  }
  
  private void d()
  {
    if (getQBaseActivity() == null) {
      return;
    }
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = (ITroopMemberListHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
    if (localObject != null) {
      ((ITroopMemberListHandler)localObject).a(1, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.jdField_a_of_type_JavaLangString), 0L, 2, 6, 0, false);
    }
  }
  
  private void e()
  {
    Drawable localDrawable = a();
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  protected int a()
  {
    return 2131560688;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_qidian_private_troop", false);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = ((TroopInfoData)paramBundle.getSerializable("key_troop_info_data"));
    this.jdField_a_of_type_Int = paramBundle.getInt("troop_auth_submit_time", 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    paramBundle = getQBaseActivity();
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramBundle.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)paramBundle.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getQBaseActivity();
    if (paramLayoutInflater == null) {
      return;
    }
    if (!(paramLayoutInflater.getAppRuntime() instanceof AppInterface)) {
      return;
    }
    paramLayoutInflater.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    a();
    c();
    d();
  }
  
  public void b(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(getQBaseActivity(), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int m;
    if ((localBundle.getBoolean("IS_COVER") ^ true))
    {
      if (bool) {
        m = 260;
      } else {
        m = 261;
      }
    }
    else if (bool) {
      m = 258;
    } else {
      m = 259;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailFragment", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(m), localBundle }));
    }
    startActivityForResult(paramBundle, m);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 != 98) && (paramInt1 != 99))
    {
      if (paramInt1 != 260) {
        return;
      }
      e();
    }
  }
  
  public void onClick(View paramView)
  {
    if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick())
    {
      Object localObject1 = getQBaseActivity();
      if (localObject1 != null)
      {
        Object localObject2 = (AppInterface)((QBaseActivity)localObject1).getAppRuntime();
        if (localObject2 != null)
        {
          int m = paramView.getId();
          Object localObject3;
          if (m == 2131379177)
          {
            localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
            localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_JavaLangString });
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("url", (String)localObject2);
            ((ActivityURIRequest)localObject1).extra().putAll(((Intent)localObject3).getExtras());
            QRoute.startUri((URIRequest)localObject1, null);
          }
          else if (m == 2131368033)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead)
            {
              c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
              {
                if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController = new TroopAvatarController(getQBaseActivity(), getQBaseActivity(), (AppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
                  this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this);
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c();
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c();
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
              localObject1 = "0";
            }
            for (;;)
            {
              break;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
                localObject1 = "1";
              } else {
                localObject1 = "2";
              }
            }
            ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, (String)localObject3, "0", (String)localObject1, "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))) {
        e();
      }
    }
  }
  
  public void onDestroyView()
  {
    this.jdField_c_of_type_Boolean = true;
    Object localObject = getQBaseActivity();
    if (localObject == null) {
      return;
    }
    ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).f();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */