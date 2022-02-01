package com.tencent.mobileqq.profile;

import ProfileLogic.QC.profileItem;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CustomCoverFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  public View.OnClickListener a = new CustomCoverFragment.3(this);
  private RecyclerView b;
  private CustomCoverFragment.RecycleViewAdapter c;
  private ImageView d;
  private View e;
  private QQProgressNotifier f;
  private Drawable g;
  private Handler h;
  private QQAppInterface i;
  private ProfileCardManager j;
  private int k;
  private int l;
  private Vector<Integer> m;
  private int n = 2;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private Uri u;
  private SVIPObserver v = new CustomCoverFragment.1(this);
  private DialogInterface.OnCancelListener w = new CustomCoverFragment.2(this);
  
  private void a()
  {
    if (this.i != null)
    {
      startTitleProgress();
      ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).f(this.s);
    }
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    this.u = ProfileCardUtils.enterSnapshot(paramBaseActivity, 1021);
    ReportController.b(paramBaseActivity.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
    VasWebviewUtil.a(paramBaseActivity.app.getCurrentAccountUin(), "defaultcard", "photo_takeaphoto", "", 1, 0, 0, "", "", "");
  }
  
  private void a(List<profileItem> paramList)
  {
    if ((paramList != null) && (this.i != null) && (this.j != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        profileItem localprofileItem = (profileItem)paramList.next();
        this.j.a(localprofileItem.itemid, true);
        if (!this.m.contains(Integer.valueOf(localprofileItem.itemid))) {
          this.m.add(Integer.valueOf(localprofileItem.itemid));
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    ImageView localImageView = this.d;
    if (localImageView != null)
    {
      if (paramBoolean)
      {
        localImageView.setImageResource(2130841442);
        return;
      }
      localImageView.setImageResource(2130841440);
    }
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = this.i;
    if (localQQAppInterface != null)
    {
      this.r = paramInt;
      ((ISVIPHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(paramInt);
      this.f.a(0, getString(2131896940), 0, this.w);
      VasWebviewUtil.a(this.i.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(paramInt), "");
    }
  }
  
  public String a(int paramInt)
  {
    ProfileCardManager.DefaultCardItem localDefaultCardItem = this.j.a(paramInt, false);
    if ((localDefaultCardItem != null) && (!TextUtils.isEmpty(localDefaultCardItem.d)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemCoverUrl: ");
      localStringBuilder.append(localDefaultCardItem.d);
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, localStringBuilder.toString());
      return localDefaultCardItem.d;
    }
    QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: null");
    return "";
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getString(2131890829));
    if (this.mLeftBackText != null) {
      this.mLeftBackText.setText("");
    }
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.t = getBaseActivity().getIntent().getBooleanExtra("is_default_key", true);
    this.i = getBaseActivity().app;
    this.j = ((VasExtensionManager)this.i.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
    int i1 = ViewUtils.dip2px(3.0F);
    this.k = ((ViewUtils.getScreenWidth() - i1 * 2) / 3);
    this.l = ((int)(this.k * 0.77F));
    this.m = new Vector();
    this.h = new Handler(this);
    ((VasExtensionManager)this.i.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e.h = this.h;
    this.f = new QQProgressNotifier(getActivity(), 2131627752);
    try
    {
      this.g = getActivity().getResources().getDrawable(2130853415);
    }
    catch (Exception paramLayoutInflater)
    {
      QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "doOnCreateView: ", paramLayoutInflater);
    }
    this.b = ((RecyclerView)this.mContentView.findViewById(2131444519));
    this.b.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
    this.c = new CustomCoverFragment.RecycleViewAdapter(this);
    this.b.setAdapter(this.c);
    this.b.addItemDecoration(new CustomCoverFragment.SpaceItemDecoration(this, i1));
    a();
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("doOnCreateView: mIsDefaultTypeCard=");
      paramLayoutInflater.append(this.t);
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramLayoutInflater.toString());
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131628436;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "handleMessage: refresh list");
      }
      this.c.notifyDataSetChanged();
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramInt1 == 1021) {
      localIntent.putExtra("upload_uri_key", this.u);
    }
    if ((paramInt1 != 1020) && (paramInt1 != 1021))
    {
      if ((paramInt1 == 2001) && (paramInt2 == -1))
      {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onActivityResult: ");
        paramInt1 = localIntent.getIntExtra("cover_id_key", 0);
        localIntent.putExtra("req_code_key", 2002);
        localIntent.putExtra("card_url_key", a(paramInt1));
        getActivity().setResult(paramInt2, localIntent);
        getActivity().finish();
      }
    }
    else if (paramInt2 == -1)
    {
      localIntent.putExtra("req_code_key", paramInt1);
      getActivity().setResult(paramInt2, localIntent);
      getActivity().finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, localIntent);
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (localBaseActivity.app != null))
    {
      int i1 = paramView.getId();
      if (i1 != 2131427518)
      {
        Object localObject;
        if (i1 != 2131427524)
        {
          if (i1 == 2131427541)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
            ((Bundle)localObject).putInt("_input_max", 1);
            ((Bundle)localObject).putBoolean("key_multiple_model_need_download_img", true);
            QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
            localUserInfo.qzone_uin = localBaseActivity.app.getCurrentAccountUin();
            ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
            ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
            QZoneHelper.forwardToPersonalAlbumSelect(localBaseActivity, localUserInfo, (Bundle)localObject, 1020);
            ReportController.b(localBaseActivity.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
            VasWebviewUtil.a(localBaseActivity.app.getCurrentAccountUin(), "defaultcard", "photo_qzone", "", 1, 0, 0, "", "", "");
          }
        }
        else
        {
          localObject = new Intent(localBaseActivity, NewPhotoListActivity.class);
          ((Intent)localObject).putExtra("enter_from", 44);
          ((Intent)localObject).putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationProfileCustomCover.a);
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localBaseActivity.getClass().getName());
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
          ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
          ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
          ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
          ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
          i1 = ProfileCardUtil.c(localBaseActivity);
          int i2 = ProfileCardUtil.d(localBaseActivity);
          ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", i1);
          ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", i2);
          ((Intent)localObject).putExtra("PhotoConst.32_Bit_Config", true);
          ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", i1);
          ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", i2);
          ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", ProfileCardUtil.a(localBaseActivity.app));
          ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
          ((Intent)localObject).putExtra("action_cover_pick_gallery", true);
          startActivity((Intent)localObject);
          AlbumUtil.anim(localBaseActivity, false, true);
          ReportController.b(localBaseActivity.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
          VasWebviewUtil.a(localBaseActivity.app.getCurrentAccountUin(), "defaultcard", "photo_album", "", 1, 0, 0, "", "", "");
        }
      }
      else if (Build.VERSION.SDK_INT >= 23)
      {
        if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          localBaseActivity.requestPermissions(new CustomCoverFragment.4(this, localBaseActivity), 1, new String[] { "android.permission.CAMERA" });
        } else {
          a(localBaseActivity);
        }
      }
      else
      {
        a(localBaseActivity);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      ProfileCardManager localProfileCardManager = this.j;
      if (localProfileCardManager != null) {
        localProfileCardManager.h = null;
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramIntent.putExtra("req_code_key", 1025);
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QQAppInterface localQQAppInterface = this.i;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.v);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QQAppInterface localQQAppInterface = this.i;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.v);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment
 * JD-Core Version:    0.7.0.1
 */