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
  private static final int a = Color.parseColor("#00000000");
  private FileManagerEntity b;
  private FileInfo c;
  private boolean d;
  private WeiyunShareSettingController e;
  private WeiyunShareProcessController f;
  private WeiyunShareQrController g;
  private QQCustomDialog h;
  private ShareActionSheet i;
  private AsyncImageView j;
  private View k;
  private String l;
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString))) {
        return;
      }
      Intent localIntent = new Intent();
      if (paramFileManagerEntity != null) {
        localIntent.putExtra("fileinfo", ForwardFileOption.b(paramFileManagerEntity));
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
  
  private boolean k()
  {
    Object localObject1 = getArguments();
    Object localObject2 = (ForwardFileInfo)((Bundle)localObject1).getParcelable("fileinfo");
    if (localObject2 != null)
    {
      localObject3 = getBaseActivity().getAppInterface();
      if ((localObject3 instanceof QQAppInterface)) {
        this.b = ((QQAppInterface)localObject3).getFileManagerDataCenter().a(((ForwardFileInfo)localObject2).e());
      }
    }
    localObject2 = ((Bundle)localObject1).getString("key_local_file_path");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.c = new FileInfo((String)localObject2);
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
    this.d = ((Bundle)localObject1).getBoolean("key_by_qr_code", false);
    localObject1 = this.c;
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((FileInfo)localObject1).f() > 0L) {
        bool1 = true;
      }
    }
    return LinkUtils.a(this.b, bool1);
  }
  
  private void l()
  {
    if (this.d) {
      m = 2131896159;
    } else {
      m = 2131896171;
    }
    setTitle(getString(m));
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      m = 2131165583;
    } else {
      m = 2131168487;
    }
    this.mContentView.findViewById(2131440665).setBackgroundResource(m);
    this.mContentView.findViewById(2131437251).setBackgroundResource(m);
    Object localObject = (TextView)this.mContentView.findViewById(2131445722);
    TextView localTextView = (TextView)this.mContentView.findViewById(2131445720);
    AsyncImageView localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131445721);
    String str = d();
    if (((TextView)localObject).getMeasuredWidth() <= 0) {
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    } else {
      ((TextView)localObject).setText(FileManagerUtil.a(str, true, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    localTextView.setText(FileUtil.a(e()));
    localAsyncImageView.setImageResource(FileManagerUtil.i(str));
    int m = f();
    if ((m == 5) || (m == 0))
    {
      localObject = g();
      if (FileUtil.b((String)localObject))
      {
        if (m == 5)
        {
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
          return;
        }
        localAsyncImageView.setAsyncImage((String)localObject);
      }
    }
  }
  
  private void m()
  {
    this.e = new WeiyunShareSettingController(this, this.mContentView.findViewById(2131445714), this.d);
    this.f = new WeiyunShareProcessController(this, this.mContentView.findViewById(2131440670), this.d);
    this.g = new WeiyunShareQrController(this, (ViewGroup)this.mContentView.findViewById(2131445137));
  }
  
  private void n()
  {
    if (this.h == null)
    {
      this.h = new QQCustomDialog(getBaseActivity(), 2131953338);
      this.h.setContentView(2131624611);
      QQCustomDialog localQQCustomDialog = this.h;
      int m;
      if (this.d) {
        m = 2131896150;
      } else {
        m = 2131896151;
      }
      localQQCustomDialog.setTitle(m);
      this.h.setMessage(null);
      this.h.setNegativeButton(2131887648, this);
      this.h.setPositiveButton(2131890045, this);
      this.h.setCancelable(true);
      this.h.setCanceledOnTouchOutside(false);
    }
    if (!this.h.isShowing()) {
      this.h.show();
    }
  }
  
  public IShareRouter.ShareOptions a()
  {
    WeiyunShareSettingController localWeiyunShareSettingController = this.e;
    if (localWeiyunShareSettingController == null) {
      return new IShareRouter.ShareOptions();
    }
    return localWeiyunShareSettingController.a();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.f != null)
    {
      if (this.g == null) {
        return;
      }
      Object localObject = getBaseActivity();
      if (this.i == null)
      {
        ((BaseActivity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_xl_weiyun");
        paramBitmap = new ShareActionSheetV2.Param();
        paramBitmap.context = ((Context)localObject);
        paramBitmap.fullScreen = false;
        this.i = ShareActionSheetFactory.create(paramBitmap);
        paramBitmap = new Intent();
        int m;
        if (this.d) {
          m = 1;
        } else {
          m = -1;
        }
        paramBitmap.putExtra("forward_type", m);
        paramBitmap.putExtra("key_share_data_line_support_type", 1);
        this.i.setIntentForStartForwardRecentActivity(paramBitmap);
        paramBitmap = this.i;
        if (this.d) {
          m = 0;
        } else {
          m = 8;
        }
        paramBitmap.setRowVisibility(0, 0, m);
        ShareActionSheet localShareActionSheet = this.i;
        if (this.d) {
          paramBitmap = this.g.a((Context)localObject);
        } else {
          paramBitmap = this.f.a((Context)localObject);
        }
        if (this.d) {
          localObject = this.g.b((Context)localObject);
        } else {
          localObject = this.f.b((Context)localObject);
        }
        localShareActionSheet.setActionSheetItems(paramBitmap, (List)localObject);
      }
      this.i.setItemClickListenerV2(this);
      if (!this.i.isShowing()) {
        this.i.show();
      }
    }
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
        WeiyunShareQrController localWeiyunShareQrController = this.g;
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
  
  public void b()
  {
    WeiyunShareProcessController localWeiyunShareProcessController = this.f;
    if (localWeiyunShareProcessController != null) {
      localWeiyunShareProcessController.a();
    }
  }
  
  public FileManagerEntity c()
  {
    return this.b;
  }
  
  public String d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).fileName;
    }
    localObject = this.c;
    if (localObject != null) {
      return ((FileInfo)localObject).e();
    }
    return "";
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    l();
    m();
  }
  
  public long e()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).fileSize;
    }
    localObject = this.c;
    if (localObject != null) {
      return ((FileInfo)localObject).f();
    }
    return 0L;
  }
  
  public int f()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).nFileType;
    }
    localObject = this.c;
    if (localObject != null)
    {
      if (((FileInfo)localObject).l() == 5) {
        return 5;
      }
      return FileManagerUtil.c(this.c.e());
    }
    return -1;
  }
  
  public String g()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).getFilePath();
    }
    localObject = this.c;
    if (localObject != null) {
      return ((FileInfo)localObject).d();
    }
    return "";
  }
  
  protected int getContentLayoutId()
  {
    return 2131627073;
  }
  
  public void h()
  {
    WeiyunShareSettingController localWeiyunShareSettingController = this.e;
    if (localWeiyunShareSettingController != null)
    {
      WeiyunShareProcessController localWeiyunShareProcessController = this.f;
      boolean bool;
      if ((localWeiyunShareProcessController != null) && (localWeiyunShareProcessController.b())) {
        bool = false;
      } else {
        bool = true;
      }
      localWeiyunShareSettingController.a(bool);
    }
  }
  
  public String i()
  {
    this.l = Long.toString(System.currentTimeMillis());
    WXShareHelper.a().a(this);
    return this.l;
  }
  
  public boolean j()
  {
    return super.onBackEvent();
  }
  
  public boolean onBackEvent()
  {
    WeiyunShareProcessController localWeiyunShareProcessController = this.f;
    if ((localWeiyunShareProcessController != null) && (localWeiyunShareProcessController.c()))
    {
      n();
      return true;
    }
    return j();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface.equals(this.h)) && (paramInt != 0))
    {
      if (paramInt != 1) {
        return;
      }
      paramDialogInterface = this.f;
      if (paramDialogInterface != null) {
        paramDialogInterface.d();
      }
      j();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.k)
    {
      ShareActionSheet localShareActionSheet = this.i;
      if (localShareActionSheet != null) {
        localShareActionSheet.dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!k()) {
      j();
    }
  }
  
  public void onDestroy()
  {
    this.k = null;
    Object localObject = this.j;
    if (localObject != null)
    {
      ((AsyncImageView)localObject).setImageDrawable(null);
      this.j = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).dismiss();
      this.i = null;
    }
    this.l = null;
    WXShareHelper.a().b(this);
    localObject = this.e;
    if (localObject != null)
    {
      ((WeiyunShareSettingController)localObject).b();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((WeiyunShareProcessController)localObject).e();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((WeiyunShareQrController)localObject).a();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.h = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (!this.d)
    {
      paramShareActionSheet = this.i;
      if (paramShareActionSheet != null) {
        paramShareActionSheet.dismiss();
      }
    }
    int n = paramActionSheetItem.action;
    if ((n == 9) || (n == 10))
    {
      int m;
      if (!WXShareHelper.a().b()) {
        m = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        m = 2131918155;
      } else {
        m = -1;
      }
      if (m != -1)
      {
        LinkUtils.a(0, m, false);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramShareActionSheet = new StringBuilder();
      paramShareActionSheet.append("onItemClick.chooseChannel: ");
      paramShareActionSheet.append(n);
      QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, paramShareActionSheet.toString());
    }
    paramShareActionSheet = this.f;
    if (paramShareActionSheet != null)
    {
      WeiyunShareQrController localWeiyunShareQrController = this.g;
      if (localWeiyunShareQrController == null) {
        return;
      }
      if (this.d) {
        localWeiyunShareQrController.a(paramActionSheetItem);
      } else {
        paramShareActionSheet.a(paramActionSheetItem);
      }
      if (this.d) {
        paramActionSheetItem = "0X800A9DB";
      } else {
        paramActionSheetItem = "0X800A9DA";
      }
      LinkUtils.a(paramActionSheetItem, LinkUtils.d(n), null);
    }
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    String str = this.l;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      int m = paramBaseResp.errCode;
      if (m != -2)
      {
        if (m != 0)
        {
          LinkUtils.a(1, 2131916544, true);
          return;
        }
        LinkUtils.a(2, 2131916563, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment
 * JD-Core Version:    0.7.0.1
 */