package com.tencent.mobileqq.troop.fragment;

import aile;
import ailh;
import ailn;
import alkk;
import alpo;
import alzf;
import alzw;
import amab;
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
import aoql;
import awnh;
import azmj;
import baig;
import baiq;
import bbtr;
import bbts;
import bbtt;
import bcws;
import bcwt;
import bdaj;
import bdda;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import xod;
import zen;

public class TroopMoreDetailFragment
  extends IphoneTitleBarFragment
  implements ailn, View.OnClickListener, bcwt
{
  int jdField_a_of_type_Int;
  private ailh jdField_a_of_type_Ailh;
  amab jdField_a_of_type_Amab = new bbts(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bcws a;
  ExpandableTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  public String a;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  TextView c;
  TextView d;
  TextView e;
  
  public TroopMoreDetailFragment()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Bcws != null)
    {
      localObject2 = this.jdField_a_of_type_Bcws.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bdda.a();
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
      localObject = getResources().getString(2131696602) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367506));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378461));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378290));
    this.c = ((TextView)a(2131378379));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)a(2131378352));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = ((TroopMoreDetailView)a(2131378413));
    this.d = ((TextView)a(2131378458));
    this.e = ((TextView)a(2131378422));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = aoql.c();
    if ((paramBoolean) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean = alzw.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
      {
        localObject2 = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (paramBoolean)
        {
          i = 15;
          String str2 = VipUtils.a(0, i).toString();
          String str3 = alpo.a(2131716041);
          bbtt localbbtt = new bbtt(this, paramBoolean);
          if (!paramBoolean) {
            break label167;
          }
          localObject1 = "0X800A57F";
          label114:
          if (!paramBoolean) {
            break label174;
          }
          i = 1;
          label120:
          VipUtils.a((Context)localObject2, str1, str2, str3, localbbtt, (String)localObject1, i, paramBoolean);
        }
      }
      for (;;)
      {
        azmj.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
        return;
        i = 8;
        break;
        label167:
        localObject1 = "0X8009E38";
        break label114;
        label174:
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
      localObject2 = zen.a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    a((Bundle)localObject1);
    azmj.b(a(), "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      bdaj.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private void b()
  {
    setTitle(alpo.a(2131716046));
    d();
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(20);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    awnh.a(this.jdField_a_of_type_AndroidWidgetTextView, alpo.a(2131716049));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    awnh.a(this.jdField_b_of_type_AndroidWidgetTextView, alpo.a(2131716050));
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new baig(str1, 11, 15));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setEditableFactory(baiq.a);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new bbtr(this));
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
          break label432;
        }
        str1 = String.format(getResources().getString(2131693673), new Object[] { Integer.valueOf(i) });
        this.c.setText(str1);
        this.c.setContentDescription(str1);
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        label356:
        if (!this.jdField_a_of_type_Boolean) {
          break label444;
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
      label432:
      this.c.setVisibility(8);
      break label356;
      label444:
      this.d.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
      {
        this.d.setVisibility(8);
        label472:
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label658;
        }
      }
      label658:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label663;
        }
        this.e.setVisibility(0);
        this.e.setText(getResources().getString(2131693674));
        this.e.setContentDescription(getResources().getString(2131693674));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
        {
          this.d.setVisibility(8);
          break label472;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
        {
          this.d.setText(getString(2131696752));
          break label472;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
        {
          this.d.setText(getString(2131696752));
          break label472;
        }
        this.d.setVisibility(8);
        break label472;
      }
      label663:
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
      localObject = (alzf)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((alzf)localObject).a(1, alkk.a(this.jdField_a_of_type_JavaLangString), 0L, 2, 6, 0, false);
  }
  
  private void d()
  {
    Drawable localDrawable = a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  public void a(Bundle paramBundle)
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
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {}
    while (!(paramLayoutInflater.getAppInterface() instanceof QQAppInterface)) {
      return;
    }
    paramLayoutInflater.addObserver(this.jdField_a_of_type_Amab);
    a();
    b();
    c();
  }
  
  public int getContentLayoutId()
  {
    return 2131560494;
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
    this.jdField_a_of_type_Bcws = new bcws(paramBundle, paramBundle.getAppInterface());
    this.jdField_a_of_type_Bcws.a(this);
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
    if (xod.b()) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = getActivity();
      } while (localObject2 == null);
      localObject1 = (QQAppInterface)((FragmentActivity)localObject2).getAppInterface();
    } while (localObject1 == null);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367506: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label250;
        }
        paramView = "0";
      }
      break;
    }
    for (;;)
    {
      azmj.b((QQAppInterface)localObject1, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, (String)localObject2, "0", paramView, "");
      return;
      paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("url", paramView);
      super.startActivity((Intent)localObject1);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break;
      }
      if (this.jdField_a_of_type_Ailh == null)
      {
        this.jdField_a_of_type_Ailh = new aile(getActivity(), getActivity(), (QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_Ailh.a(this);
      }
      this.jdField_a_of_type_Ailh.c();
      break;
      label250:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        paramView = "1";
      } else {
        paramView = "2";
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
    localFragmentActivity.removeObserver(this.jdField_a_of_type_Amab);
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    if (this.jdField_a_of_type_Ailh != null) {
      this.jdField_a_of_type_Ailh.f();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Ailh != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Ailh.a(str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */