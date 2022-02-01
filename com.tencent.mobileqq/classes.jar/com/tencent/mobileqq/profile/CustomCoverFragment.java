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
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aogu;
import aogx;
import azvi;
import azvj;
import azvk;
import azvl;
import azvp;
import azvq;
import azxs;
import azxt;
import bdll;
import bhhz;
import bhkd;
import bhtq;
import bhzq;
import bjbv;
import bmtd;
import bmtk;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CustomCoverFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new azvj(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aogx jdField_a_of_type_Aogx = new azvi(this);
  private azvp jdField_a_of_type_Azvp;
  private azxs jdField_a_of_type_Azxs;
  private bjbv jdField_a_of_type_Bjbv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Vector<Integer> jdField_a_of_type_JavaUtilVector;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public CustomCoverFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azvk(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      startTitleProgress();
      ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).f(this.f);
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.e = paramInt;
      ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g(paramInt);
      this.jdField_a_of_type_Bjbv.a(0, getString(2131698117), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(paramInt), "");
    }
  }
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidNetUri = FriendProfileCardActivity.a(paramFragmentActivity, 1021);
    bdll.b(paramFragmentActivity.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(paramFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_takeaphoto", "", 1, 0, 0, "", "", "");
  }
  
  private void a(List<profileItem> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Azxs != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        profileItem localprofileItem = (profileItem)paramList.next();
        this.jdField_a_of_type_Azxs.a(localprofileItem.itemid, true);
        if (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(localprofileItem.itemid))) {
          this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(localprofileItem.itemid));
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840586);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840584);
  }
  
  public String a(int paramInt)
  {
    azxt localazxt = this.jdField_a_of_type_Azxs.a(paramInt, false);
    if ((localazxt != null) && (!TextUtils.isEmpty(localazxt.c)))
    {
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: " + localazxt.c);
      return localazxt.c;
    }
    QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: null");
    return "";
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getString(2131692985));
    if (this.mLeftBackText != null) {
      this.mLeftBackText.setText("");
    }
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.jdField_c_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_default_key", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_Azxs = ((bhzq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).jdField_a_of_type_Azxs;
    int i = bhtq.a(3.0F);
    this.jdField_a_of_type_Int = ((bhtq.a() - i * 2) / 3);
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.77F));
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ((bhzq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).jdField_a_of_type_Azxs.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
    this.jdField_a_of_type_Bjbv = new bjbv(getActivity(), 2131561501);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getActivity().getResources().getDrawable(2130850750);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131376407));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
      this.jdField_a_of_type_Azvp = new azvp(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azvp);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new azvq(this, i));
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "doOnCreateView: mIsDefaultTypeCard=" + this.jdField_c_of_type_Boolean);
      }
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "doOnCreateView: ", paramLayoutInflater);
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562095;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "handleMessage: refresh list");
      }
      this.jdField_a_of_type_Azvp.notifyDataSetChanged();
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
      localIntent.putExtra("upload_uri_key", this.jdField_a_of_type_AndroidNetUri);
    }
    if ((paramInt1 == 1020) || (paramInt1 == 1021))
    {
      if (paramInt2 == -1)
      {
        localIntent.putExtra("req_code_key", paramInt1);
        getActivity().setResult(paramInt2, localIntent);
        getActivity().finish();
      }
    }
    else if ((paramInt1 == 2001) && (paramInt2 == -1))
    {
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onActivityResult: ");
      paramInt1 = localIntent.getIntExtra("cover_id_key", 0);
      localIntent.putExtra("req_code_key", 2002);
      localIntent.putExtra("card_url_key", a(paramInt1));
      getActivity().setResult(paramInt2, localIntent);
      getActivity().finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, localIntent);
  }
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.app == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131361948: 
        if (Build.VERSION.SDK_INT >= 23) {
          if (localFragmentActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            localFragmentActivity.requestPermissions(new azvl(this, localFragmentActivity), 1, new String[] { "android.permission.CAMERA" });
          }
        }
        break;
      case 2131361953: 
        localObject = new Intent(localFragmentActivity, NewPhotoListActivity.class);
        ((Intent)localObject).putExtra("enter_from", 44);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localFragmentActivity.getClass().getName());
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
        ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        int i = bhhz.c(localFragmentActivity);
        int j = bhhz.d(localFragmentActivity);
        ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", i);
        ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", j);
        ((Intent)localObject).putExtra("PhotoConst.32_Bit_Config", true);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", i);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", j);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", bhhz.a(localFragmentActivity.app));
        ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        ((Intent)localObject).putExtra("action_cover_pick_gallery", true);
        startActivity((Intent)localObject);
        bhkd.anim(localFragmentActivity, false, true);
        bdll.b(localFragmentActivity.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(localFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_album", "", 1, 0, 0, "", "", "");
        break;
      case 2131361962: 
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
        ((Bundle)localObject).putInt("_input_max", 1);
        ((Bundle)localObject).putBoolean("key_multiple_model_need_download_img", true);
        bmtk localbmtk = bmtk.a();
        localbmtk.a = localFragmentActivity.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
        ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
        bmtd.a(localFragmentActivity, localbmtk, (Bundle)localObject, 1020);
        bdll.b(localFragmentActivity.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(localFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_qzone", "", 1, 0, 0, "", "", "");
        continue;
        a(localFragmentActivity);
        continue;
        a(localFragmentActivity);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Azxs != null)) {
      this.jdField_a_of_type_Azxs.jdField_a_of_type_AndroidOsHandler = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment
 * JD-Core Version:    0.7.0.1
 */