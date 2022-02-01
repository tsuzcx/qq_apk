package com.tencent.mobileqq.filemanageraux.link;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LinkByWeiyunFragment
  extends IphoneTitleBarFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, IShareRouter, ShareActionSheet.OnItemClickListener, WXShareHelper.WXShareListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#00000000");
  private View jdField_a_of_type_AndroidViewView;
  private FileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private WeiyunShareProcessController jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
  private WeiyunShareQrController jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController;
  private WeiyunShareSettingController jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString))) {
        return;
      }
      Intent localIntent = new Intent();
      if (paramFileManagerEntity != null) {
        localIntent.putExtra("fileinfo", ForwardFileOption.a(paramFileManagerEntity));
      }
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("key_local_file_path", paramString);
      }
      localIntent.putExtra("key_by_qr_code", paramBoolean);
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
      if (paramBoolean) {
        paramContext = "0X800A9D5";
      } else {
        paramContext = "0X800A9D4";
      }
      LinkUtils.a(paramContext, LinkUtils.a(paramFileManagerEntity, paramString), null);
    }
  }
  
  private boolean b()
  {
    Object localObject1 = getArguments();
    Object localObject2 = (ForwardFileInfo)((Bundle)localObject1).getParcelable("fileinfo");
    if (localObject2 != null)
    {
      localObject3 = getBaseActivity().getAppInterface();
      if ((localObject3 instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((QQAppInterface)localObject3).getFileManagerDataCenter().a(((ForwardFileInfo)localObject2).b());
      }
    }
    localObject2 = ((Bundle)localObject1).getString("key_local_file_path");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = new FileInfo((String)localObject2);
    }
    catch (Throwable localThrowable)
    {
      label90:
      boolean bool2;
      boolean bool1;
      break label90;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("initData : local file not fount for ");
    ((StringBuilder)localObject3).append((String)localObject2);
    QLog.e("LinkByWeiyunFragment<FileAssistant>", 2, ((StringBuilder)localObject3).toString());
    bool2 = false;
    this.jdField_a_of_type_Boolean = ((Bundle)localObject1).getBoolean("key_by_qr_code", false);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((FileInfo)localObject1).a() > 0L) {
        bool1 = true;
      }
    }
    return LinkUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, bool1);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698258;
    } else {
      i = 2131698270;
    }
    setTitle(getString(i));
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      i = 2131165341;
    } else {
      i = 2131167410;
    }
    this.mContentView.findViewById(2131373078).setBackgroundResource(i);
    this.mContentView.findViewById(2131370089).setBackgroundResource(i);
    Object localObject = (TextView)this.mContentView.findViewById(2131377333);
    TextView localTextView = (TextView)this.mContentView.findViewById(2131377331);
    AsyncImageView localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131377332);
    String str = a();
    if (((TextView)localObject).getMeasuredWidth() <= 0) {
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    } else {
      ((TextView)localObject).setText(FileManagerUtil.a(str, true, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    localTextView.setText(FileUtil.a(a()));
    localAsyncImageView.setImageResource(FileManagerUtil.b(str));
    int i = a();
    if ((i == 5) || (i == 0))
    {
      localObject = b();
      if (FileUtil.a((String)localObject))
      {
        if (i == 5)
        {
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
          return;
        }
        localAsyncImageView.setAsyncImage((String)localObject);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController = new WeiyunShareSettingController(this, this.mContentView.findViewById(2131377326), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController = new WeiyunShareProcessController(this, this.mContentView.findViewById(2131373083), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController = new WeiyunShareQrController(this, (ViewGroup)this.mContentView.findViewById(2131376809));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131756189);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558978);
      QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2131698249;
      } else {
        i = 2131698250;
      }
      localQQCustomDialog.setTitle(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131692932, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).nFileType;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (localObject != null)
    {
      if (((FileInfo)localObject).a() == 5) {
        return 5;
      }
      return FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
    }
    return -1;
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).fileSize;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (localObject != null) {
      return ((FileInfo)localObject).a();
    }
    return 0L;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public IShareRouter.ShareOptions a()
  {
    WeiyunShareSettingController localWeiyunShareSettingController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController;
    if (localWeiyunShareSettingController == null) {
      return new IShareRouter.ShareOptions();
    }
    return localWeiyunShareSettingController.a();
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).fileName;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (localObject != null) {
      return ((FileInfo)localObject).d();
    }
    return "";
  }
  
  public void a()
  {
    WeiyunShareProcessController localWeiyunShareProcessController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
    if (localWeiyunShareProcessController != null) {
      localWeiyunShareProcessController.a();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController == null) {
        return;
      }
      Object localObject = getBaseActivity();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        ((BaseActivity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_xl_weiyun");
        paramBitmap = new ShareActionSheetV2.Param();
        paramBitmap.context = ((Context)localObject);
        paramBitmap.fullScreen = false;
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(paramBitmap);
        paramBitmap = new Intent();
        int i;
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        } else {
          i = -1;
        }
        paramBitmap.putExtra("forward_type", i);
        paramBitmap.putExtra("key_share_data_line_support_type", 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramBitmap);
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
        if (this.jdField_a_of_type_Boolean) {
          i = 0;
        } else {
          i = 8;
        }
        paramBitmap.setRowVisibility(0, 0, i);
        ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
        if (this.jdField_a_of_type_Boolean) {
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController.a((Context)localObject);
        } else {
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController.a((Context)localObject);
        }
        if (this.jdField_a_of_type_Boolean) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController.b((Context)localObject);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController.b((Context)localObject);
        }
        localShareActionSheet.setActionSheetItems(paramBitmap, (List)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      }
    }
  }
  
  public boolean a()
  {
    return super.onBackEvent();
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    boolean bool3 = isAdded();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!isDetached())
      {
        if (isRemoving()) {
          return false;
        }
        WeiyunShareQrController localWeiyunShareQrController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController;
        bool1 = bool2;
        if (localWeiyunShareQrController != null)
        {
          bool1 = bool2;
          if (localWeiyunShareQrController.a(paramBitmap, paramInt, paramString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).getFilePath();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (localObject != null) {
      return ((FileInfo)localObject).c();
    }
    return "";
  }
  
  public void b()
  {
    WeiyunShareSettingController localWeiyunShareSettingController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController;
    if (localWeiyunShareSettingController != null)
    {
      WeiyunShareProcessController localWeiyunShareProcessController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
      boolean bool;
      if ((localWeiyunShareProcessController != null) && (localWeiyunShareProcessController.a())) {
        bool = false;
      } else {
        bool = true;
      }
      localWeiyunShareSettingController.a(bool);
    }
  }
  
  public String c()
  {
    this.jdField_a_of_type_JavaLangString = Long.toString(System.currentTimeMillis());
    WXShareHelper.a().a(this);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560815;
  }
  
  public boolean onBackEvent()
  {
    WeiyunShareProcessController localWeiyunShareProcessController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
    if ((localWeiyunShareProcessController != null) && (localWeiyunShareProcessController.b()))
    {
      e();
      return true;
    }
    return a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) && (paramInt != 0))
    {
      if (paramInt != 1) {
        return;
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
      if (paramDialogInterface != null) {
        paramDialogInterface.b();
      }
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (localShareActionSheet != null) {
        localShareActionSheet.dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (localObject != null)
    {
      ((AsyncImageView)localObject).setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    WXShareHelper.a().b(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController;
    if (localObject != null)
    {
      ((WeiyunShareSettingController)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareSettingController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
    if (localObject != null)
    {
      ((WeiyunShareProcessController)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController;
    if (localObject != null)
    {
      ((WeiyunShareQrController)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramShareActionSheet != null) {
        paramShareActionSheet.dismiss();
      }
    }
    int j = paramActionSheetItem.action;
    if ((j == 9) || (j == 10))
    {
      int i;
      if (!WXShareHelper.a().a()) {
        i = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        i = 2131720479;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        LinkUtils.a(0, i, false);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramShareActionSheet = new StringBuilder();
      paramShareActionSheet.append("onItemClick.chooseChannel: ");
      paramShareActionSheet.append(j);
      QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, paramShareActionSheet.toString());
    }
    paramShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareProcessController;
    if (paramShareActionSheet != null)
    {
      WeiyunShareQrController localWeiyunShareQrController = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkWeiyunShareQrController;
      if (localWeiyunShareQrController == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        localWeiyunShareQrController.a(paramActionSheetItem);
      } else {
        paramShareActionSheet.a(paramActionSheetItem);
      }
      if (this.jdField_a_of_type_Boolean) {
        paramActionSheetItem = "0X800A9DB";
      } else {
        paramActionSheetItem = "0X800A9DA";
      }
      LinkUtils.a(paramActionSheetItem, LinkUtils.c(j), null);
    }
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          LinkUtils.a(1, 2131719009, true);
          return;
        }
        LinkUtils.a(2, 2131719027, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment
 * JD-Core Version:    0.7.0.1
 */