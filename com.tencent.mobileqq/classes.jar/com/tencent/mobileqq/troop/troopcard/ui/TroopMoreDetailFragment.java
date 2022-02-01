package com.tencent.mobileqq.troop.troopcard.ui;

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
  TroopInfoData A;
  int B;
  protected IFaceDecoder C;
  boolean D = false;
  TroopObserver E = new TroopMoreDetailFragment.2(this);
  private TroopPhotoController F;
  ImageView a;
  TextView b;
  ImageView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  ExpandableTextView w;
  TroopMoreDetailView x;
  boolean y;
  String z;
  
  private <T extends View> T a(int paramInt)
  {
    return this.t.findViewById(paramInt);
  }
  
  private String a(long paramLong)
  {
    if (paramLong > 0L)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131893893));
      localStringBuilder.append(localSimpleDateFormat.format(Long.valueOf(paramLong * 1000L)));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void b()
  {
    this.a = ((ImageView)a(2131434878));
    this.b = ((TextView)a(2131448053));
    this.d = ((TextView)a(2131448117));
    this.c = ((ImageView)a(2131447913));
    this.e = ((TextView)a(2131448013));
    this.w = ((ExpandableTextView)a(2131447985));
    this.x = ((TroopMoreDetailView)a(2131448051));
    this.f = ((TextView)a(2131448114));
    this.g = ((TextView)a(2131448072));
  }
  
  private void c()
  {
    a(HardCodeUtil.a(2131912921));
    e();
    this.b.setMaxLines(20);
    this.b.setText(this.A.newTroopName);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    LongClickCopyAction.attachCopyAction(this.b, HardCodeUtil.a(2131912924));
    this.d.setText(this.z);
    LongClickCopyAction.attachCopyAction(this.d, HardCodeUtil.a(2131912925));
    String str = a(this.A.mTroopCreateTime);
    Object localObject = str;
    if (!TextUtils.isEmpty(this.A.mRichFingerMemo))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append(this.A.mRichFingerMemo);
      localObject = ((StringBuilder)localObject).toString();
    }
    this.w.setText(new QQText((CharSequence)localObject, 11, 15));
    this.w.getContentTextView().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.w.getContentTextView().setMovementMethod(LinkMovementMethod.getInstance());
    this.w.setOnExpandStateChangeListener(new TroopMoreDetailFragment.1(this));
    if ((this.A.dwGroupFlagExt & 0x800) != 0L)
    {
      if ((this.A.dwAuthGroupType != 2L) && (this.A.dwAuthGroupType != 1L))
      {
        this.c.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
      }
    }
    else {
      this.c.setVisibility(8);
    }
    int i = this.A.nTroopGrade;
    if ((this.A.dwGroupFlagExt & 0x800000) != 8388608L) {
      i = 0;
    }
    int j = 1;
    if ((i > 0) && (!this.y))
    {
      localObject = String.format(getResources().getString(2131890936), new Object[] { Integer.valueOf(i) });
      this.e.setText((CharSequence)localObject);
      this.e.setContentDescription((CharSequence)localObject);
      this.e.setVisibility(0);
      this.e.setOnClickListener(this);
    }
    else
    {
      this.e.setVisibility(8);
    }
    if (this.y)
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
    else
    {
      this.f.setVisibility(0);
      if (this.A.troopTypeExt == 1) {
        this.f.setVisibility(8);
      } else if (this.A.troopTypeExt == 0) {
        this.f.setVisibility(8);
      } else if (this.A.troopTypeExt == 2) {
        this.f.setText(getString(2131894046));
      } else if ((this.A.troopTypeExt != 3) && (this.A.troopTypeExt != 4)) {
        this.f.setVisibility(8);
      } else {
        this.f.setText(getString(2131894046));
      }
      if ((TroopInfo.hasPayPrivilege(this.A.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.A.mTroopPrivilegeFlag, 512))) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.g.setVisibility(0);
        this.g.setText(getResources().getString(2131890937));
        this.g.setContentDescription(getResources().getString(2131890937));
      }
      else
      {
        this.g.setVisibility(8);
      }
    }
    this.x.setGuestVisitor(false);
    this.x.setTroopInfoData(this.A);
    this.x.a();
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = QVipBigTroopExpiredProcessor.e();
    if ((paramBoolean) && (((QVipBigTroopExpiredConfig)localObject).mIsEnable) && (this.A.mIsFreezed == 1) && (this.A.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModiftyTroopHeadFreezed(this.A, getQBaseActivity());
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("IS_COVER", false);
    ((Bundle)localObject).putBoolean("IS_EDIT", paramBoolean);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleEditClosed(paramBoolean, this.a, (Bundle)localObject);
    b((Bundle)localObject);
    ReportController.b(f(), "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.A.troopUin, "", "", "");
    String str = this.A.troopUin;
    if (this.A.isMember) {
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
    Object localObject = f();
    if (localObject == null) {
      return;
    }
    localObject = (ITroopMemberListHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
    if (localObject != null) {
      ((ITroopMemberListHandler)localObject).a(1, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.z), 0L, 2, 6, 0, false);
    }
  }
  
  private void e()
  {
    Drawable localDrawable = g();
    this.a.setImageDrawable(localDrawable);
    if ((this.A.hasSetNewTroopHead) || (this.A.isOwnerOrAdim())) {
      this.a.setOnClickListener(this);
    }
  }
  
  private AppInterface f()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && ((localQBaseActivity.getAppRuntime() instanceof AppInterface))) {
      return (AppInterface)localQBaseActivity.getAppRuntime();
    }
    return null;
  }
  
  private Drawable g()
  {
    Object localObject1 = this.C;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.A.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.C.isPausing())
        {
          this.C.requestDecodeFace(this.A.troopUin, 4, true);
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
      localObject2 = BaseImageUtil.k();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(f())) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  protected int a()
  {
    return 2131626733;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.y = paramBundle.getBoolean("key_qidian_private_troop", false);
    this.A = ((TroopInfoData)paramBundle.getSerializable("key_troop_info_data"));
    this.B = paramBundle.getInt("troop_auth_submit_time", 0);
    this.z = this.A.troopUin;
    paramBundle = getQBaseActivity();
    if (paramBundle == null) {
      return;
    }
    this.C = ((IQQAvatarService)paramBundle.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)paramBundle.getAppRuntime());
    this.C.setDecodeTaskCompletionListener(this);
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
    paramLayoutInflater.addObserver(this.E);
    b();
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
    localBundle.putString("troop_uin", this.A.troopUin);
    localBundle.putLong("troop_flag_ext", this.A.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.B);
    localBundle.putBoolean("troop_info_is_member", this.A.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.A.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int i;
    if ((localBundle.getBoolean("IS_COVER") ^ true))
    {
      if (bool) {
        i = 260;
      } else {
        i = 261;
      }
    }
    else if (bool) {
      i = 258;
    } else {
      i = 259;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailFragment", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i), localBundle }));
    }
    startActivityForResult(paramBundle, i);
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
          int i = paramView.getId();
          Object localObject3;
          if (i == 2131447913)
          {
            localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
            localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.z });
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("url", (String)localObject2);
            ((ActivityURIRequest)localObject1).extra().putAll(((Intent)localObject3).getExtras());
            QRoute.startUri((URIRequest)localObject1, null);
          }
          else if (i == 2131434878)
          {
            if (this.A.hasSetNewTroopHead)
            {
              c(this.A.isOwnerOrAdim());
            }
            else
            {
              if (this.A.isOwnerOrAdim())
              {
                if (this.F == null)
                {
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putString("troopUin", this.A.troopUin);
                  ((Bundle)localObject1).putInt("type", 1);
                  this.F = new TroopAvatarController(getQBaseActivity(), getQBaseActivity(), (AppInterface)localObject2, (Bundle)localObject1);
                  this.F.a(this);
                }
                this.F.b();
              }
              this.F.b();
            }
            localObject3 = this.A.troopUin;
            if (this.A.bOwner) {
              localObject1 = "0";
            }
            for (;;)
            {
              break;
              if (this.A.bAdmin) {
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
      if ((paramString != null) && (paramString.equals(this.A.troopUin))) {
        e();
      }
    }
  }
  
  public void onDestroyView()
  {
    this.D = true;
    Object localObject = getQBaseActivity();
    if (localObject == null) {
      return;
    }
    ((QBaseActivity)localObject).removeObserver(this.E);
    localObject = this.C;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.F;
    if (localObject != null) {
      ((TroopPhotoController)localObject).e();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.F != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.F.b(str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */