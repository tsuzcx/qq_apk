package com.tencent.mobileqq.filemanager.link;

import adky;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqsc;
import arkl;
import arkm;
import arkn;
import arko;
import arks;
import arkt;
import arni;
import arof;
import arvo;
import bdfq;
import bevy;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class LinkByWeiyunFragment
  extends IphoneTitleBarFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, arkl, bevy, ShareActionSheet.OnItemClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#00000000");
  private View jdField_a_of_type_AndroidViewView;
  private arko jdField_a_of_type_Arko;
  private arks jdField_a_of_type_Arks;
  private arkt jdField_a_of_type_Arkt;
  private bdfq jdField_a_of_type_Bdfq;
  private FileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString)))) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramFileManagerEntity != null) {
      localIntent.putExtra("fileinfo", arvo.a(paramFileManagerEntity));
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("key_local_file_path", paramString);
    }
    localIntent.putExtra("key_by_qr_code", paramBoolean);
    adky.a(paramContext, localIntent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
    if (paramBoolean) {}
    for (paramContext = "0X800A9D5";; paramContext = "0X800A9D4")
    {
      arkn.a(paramContext, arkn.a(paramFileManagerEntity, paramString), null);
      return;
    }
  }
  
  private boolean b()
  {
    Bundle localBundle = getArguments();
    Object localObject = (ForwardFileInfo)localBundle.getParcelable("fileinfo");
    if (localObject != null)
    {
      AppInterface localAppInterface = getActivity().getAppInterface();
      if ((localAppInterface instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((QQAppInterface)localAppInterface).a().a(((ForwardFileInfo)localObject).b());
      }
    }
    localObject = localBundle.getString("key_local_file_path");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = new FileInfo((String)localObject);
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("key_by_qr_code", false);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a() > 0L))
      {
        bool = true;
        return arkn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, bool);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LinkByWeiyunFragment<FileAssistant>", 2, "initData : local file not fount for " + (String)localObject);
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void c()
  {
    int i;
    label31:
    Object localObject;
    TextView localTextView;
    AsyncImageView localAsyncImageView;
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131698518;
      setTitle(getString(i));
      if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
        break label191;
      }
      i = 2131165323;
      this.mContentView.findViewById(2131372273).setBackgroundResource(i);
      this.mContentView.findViewById(2131369483).setBackgroundResource(i);
      localObject = (TextView)this.mContentView.findViewById(2131376469);
      localTextView = (TextView)this.mContentView.findViewById(2131376467);
      localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131376468);
      str = a();
      if (((TextView)localObject).getMeasuredWidth() > 0) {
        break label198;
      }
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    }
    for (;;)
    {
      localTextView.setText(arof.a(a()));
      localAsyncImageView.setImageResource(arni.b(str));
      i = a();
      if ((i == 5) || (i == 0))
      {
        localObject = b();
        if (arof.b((String)localObject))
        {
          if (i != 5) {
            break label220;
          }
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
        }
      }
      return;
      i = 2131698530;
      break;
      label191:
      i = 2131167206;
      break label31;
      label198:
      ((TextView)localObject).setText(arni.a(str, false, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    label220:
    localAsyncImageView.setAsyncImage((String)localObject);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Arkt = new arkt(this, this.mContentView.findViewById(2131376462), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Arko = new arko(this, this.mContentView.findViewById(2131372278), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Arks = new arks(this, (ViewGroup)this.mContentView.findViewById(2131375981));
  }
  
  private void e()
  {
    bdfq localbdfq;
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = new bdfq(getActivity(), 2131755801);
      this.jdField_a_of_type_Bdfq.setContentView(2131558943);
      localbdfq = this.jdField_a_of_type_Bdfq;
      if (!this.jdField_a_of_type_Boolean) {
        break label123;
      }
    }
    label123:
    for (int i = 2131698509;; i = 2131698510)
    {
      localbdfq.setTitle(i);
      this.jdField_a_of_type_Bdfq.setMessage(null);
      this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, this);
      this.jdField_a_of_type_Bdfq.setPositiveButton(2131693165, this);
      this.jdField_a_of_type_Bdfq.setCancelable(true);
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.show();
      }
      return;
    }
  }
  
  public int a()
  {
    int i = 5;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
    }
    do
    {
      return i;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo == null) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a() == 5);
    return arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a();
    }
    return 0L;
  }
  
  public arkm a()
  {
    if (this.jdField_a_of_type_Arkt == null) {
      return new arkm();
    }
    return this.jdField_a_of_type_Arkt.a();
  }
  
  public BaseActivity a()
  {
    return getActivity();
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arko != null) {
      this.jdField_a_of_type_Arko.a();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Arko == null) || (this.jdField_a_of_type_Arks == null)) {
      return;
    }
    Object localObject = a();
    int i;
    label84:
    label126:
    ShareActionSheet localShareActionSheet;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      ((BaseActivity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_xl_weiyun");
      paramBitmap = new ShareActionSheetV2.Param();
      paramBitmap.context = ((Context)localObject);
      paramBitmap.fullScreen = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(paramBitmap);
      paramBitmap = new Intent();
      if (!this.jdField_a_of_type_Boolean) {
        break label214;
      }
      i = 1;
      paramBitmap.putExtra("forward_type", i);
      paramBitmap.putExtra("key_share_data_line_support_type", 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramBitmap);
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (!this.jdField_a_of_type_Boolean) {
        break label219;
      }
      i = 0;
      paramBitmap.setRowVisibility(0, 0, i);
      localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (!this.jdField_a_of_type_Boolean) {
        break label225;
      }
      paramBitmap = this.jdField_a_of_type_Arks.a((Context)localObject);
      label157:
      if (!this.jdField_a_of_type_Boolean) {
        break label237;
      }
    }
    label214:
    label219:
    label225:
    label237:
    for (localObject = this.jdField_a_of_type_Arks.b((Context)localObject);; localObject = this.jdField_a_of_type_Arko.b((Context)localObject))
    {
      localShareActionSheet.setActionSheetItems(paramBitmap, (List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      i = -1;
      break label84;
      i = 8;
      break label126;
      paramBitmap = this.jdField_a_of_type_Arko.a((Context)localObject);
      break label157;
    }
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      arkn.a(1, 2131720019, true);
      return;
    }
    arkn.a(2, 2131720038, true);
  }
  
  public boolean a()
  {
    return super.onBackEvent();
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if ((!isAdded()) || (isDetached()) || (isRemoving())) {}
    while ((this.jdField_a_of_type_Arks == null) || (!this.jdField_a_of_type_Arks.a(paramBitmap, paramInt, paramString))) {
      return false;
    }
    return true;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c();
    }
    return "";
  }
  
  public void b()
  {
    arkt localarkt;
    if (this.jdField_a_of_type_Arkt != null)
    {
      localarkt = this.jdField_a_of_type_Arkt;
      if ((this.jdField_a_of_type_Arko != null) && (this.jdField_a_of_type_Arko.a())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localarkt.a(bool);
      return;
    }
  }
  
  public String c()
  {
    this.jdField_a_of_type_JavaLangString = Long.toString(System.currentTimeMillis());
    WXShareHelper.a().a(this);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560657;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Arko != null) && (this.jdField_a_of_type_Arko.b()))
    {
      e();
      return true;
    }
    return a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bdfq)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_Arko != null) {
      this.jdField_a_of_type_Arko.b();
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!b()) {
      a();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    WXShareHelper.a().b(this);
    if (this.jdField_a_of_type_Arkt != null)
    {
      this.jdField_a_of_type_Arkt.a();
      this.jdField_a_of_type_Arkt = null;
    }
    if (this.jdField_a_of_type_Arko != null)
    {
      this.jdField_a_of_type_Arko.c();
      this.jdField_a_of_type_Arko = null;
    }
    if (this.jdField_a_of_type_Arks != null)
    {
      this.jdField_a_of_type_Arks.a();
      this.jdField_a_of_type_Arks = null;
    }
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int j = paramActionSheetItem.action;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131721478;
      }
    }
    for (;;)
    {
      if (i != -1) {
        arkn.a(0, i, false);
      }
      do
      {
        return;
        if (WXShareHelper.a().b()) {
          break label186;
        }
        i = 2131721479;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, "onItemClick.chooseChannel: " + j);
        }
      } while ((this.jdField_a_of_type_Arko == null) || (this.jdField_a_of_type_Arks == null));
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Arks.a(paramActionSheetItem);
        if (!this.jdField_a_of_type_Boolean) {
          break label179;
        }
      }
      label179:
      for (paramActionSheetItem = "0X800A9DB";; paramActionSheetItem = "0X800A9DA")
      {
        arkn.a(paramActionSheetItem, arkn.c(j), null);
        return;
        this.jdField_a_of_type_Arko.a(paramActionSheetItem);
        break;
      }
      label186:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.link.LinkByWeiyunFragment
 * JD-Core Version:    0.7.0.1
 */