package com.tencent.mobileqq.filemanager.link;

import abtu;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoza;
import aprf;
import aprg;
import aprh;
import apri;
import aprm;
import aprn;
import apue;
import apvb;
import aqce;
import bbgg;
import bbjc;
import bbje;
import bbjh;
import bbkx;
import bcwh;
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
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class LinkByWeiyunFragment
  extends IphoneTitleBarFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, AdapterView.OnItemClickListener, aprf, bcwh
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#00000000");
  private View jdField_a_of_type_AndroidViewView;
  private apri jdField_a_of_type_Apri;
  private aprm jdField_a_of_type_Aprm;
  private aprn jdField_a_of_type_Aprn;
  private bbgg jdField_a_of_type_Bbgg;
  private bbjc jdField_a_of_type_Bbjc;
  private FileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString)))) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramFileManagerEntity != null) {
      localIntent.putExtra("fileinfo", aqce.a(paramFileManagerEntity));
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("key_local_file_path", paramString);
    }
    localIntent.putExtra("key_by_qr_code", paramBoolean);
    abtu.a(paramContext, localIntent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
    if (paramBoolean) {}
    for (paramContext = "0X800A9D5";; paramContext = "0X800A9D4")
    {
      aprh.a(paramContext, aprh.a(paramFileManagerEntity, paramString), null);
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
        return aprh.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, bool);
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
      i = 2131698218;
      setTitle(getString(i));
      if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
        break label191;
      }
      i = 2131165288;
      this.mContentView.findViewById(2131371954).setBackgroundResource(i);
      this.mContentView.findViewById(2131369248).setBackgroundResource(i);
      localObject = (TextView)this.mContentView.findViewById(2131375968);
      localTextView = (TextView)this.mContentView.findViewById(2131375966);
      localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131375967);
      str = a();
      if (((TextView)localObject).getMeasuredWidth() > 0) {
        break label198;
      }
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    }
    for (;;)
    {
      localTextView.setText(apvb.a(a()));
      localAsyncImageView.setImageResource(apue.b(str));
      i = a();
      if ((i == 5) || (i == 0))
      {
        localObject = b();
        if (apvb.b((String)localObject))
        {
          if (i != 5) {
            break label220;
          }
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
        }
      }
      return;
      i = 2131698230;
      break;
      label191:
      i = 2131167148;
      break label31;
      label198:
      ((TextView)localObject).setText(apue.a(str, false, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    label220:
    localAsyncImageView.setAsyncImage((String)localObject);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aprn = new aprn(this, this.mContentView.findViewById(2131375961), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Apri = new apri(this, this.mContentView.findViewById(2131371959), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aprm = new aprm(this, (ViewGroup)this.mContentView.findViewById(2131375491));
  }
  
  private void e()
  {
    bbgg localbbgg;
    if (this.jdField_a_of_type_Bbgg == null)
    {
      this.jdField_a_of_type_Bbgg = new bbgg(getActivity(), 2131755791);
      this.jdField_a_of_type_Bbgg.setContentView(2131558906);
      localbbgg = this.jdField_a_of_type_Bbgg;
      if (!this.jdField_a_of_type_Boolean) {
        break label123;
      }
    }
    label123:
    for (int i = 2131698209;; i = 2131698210)
    {
      localbbgg.setTitle(i);
      this.jdField_a_of_type_Bbgg.setMessage(null);
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, this);
      this.jdField_a_of_type_Bbgg.setPositiveButton(2131693063, this);
      this.jdField_a_of_type_Bbgg.setCancelable(true);
      this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.show();
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
    return apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
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
  
  public aprg a()
  {
    if (this.jdField_a_of_type_Aprn == null) {
      return new aprg();
    }
    return this.jdField_a_of_type_Aprn.a();
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
    if (this.jdField_a_of_type_Apri != null) {
      this.jdField_a_of_type_Apri.a();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Apri == null) || (this.jdField_a_of_type_Aprm == null)) {
      return;
    }
    BaseActivity localBaseActivity = a();
    if (this.jdField_a_of_type_Bbjc == null)
    {
      this.jdField_a_of_type_Bbjc = new bbjc(localBaseActivity);
      this.jdField_a_of_type_Bbjc.a(localBaseActivity.getString(2131719497));
      this.jdField_a_of_type_Bbjc.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = new AsyncImageView(localBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bbkx.a(61.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bbkx.a(61.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bbkx.a(16.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_Bbjc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (RelativeLayout.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(null);
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(paramBitmap);
    }
    Object localObject = this.jdField_a_of_type_Bbjc;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramBitmap = this.jdField_a_of_type_Aprm.a(localBaseActivity);; paramBitmap = this.jdField_a_of_type_Apri.a(localBaseActivity))
    {
      ((bbjc)localObject).a(paramBitmap);
      if (this.jdField_a_of_type_Bbjc.a()) {
        break;
      }
      this.jdField_a_of_type_Bbjc.a();
      this.jdField_a_of_type_Bbjc.d(jdField_a_of_type_Int);
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getParent();
      if ((!(paramBitmap instanceof View)) || (paramBitmap == this.jdField_a_of_type_AndroidViewView)) {
        break;
      }
      paramBitmap = (View)paramBitmap;
      this.jdField_a_of_type_AndroidViewView = paramBitmap;
      paramBitmap.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this);
      return;
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
      aprh.a(1, 2131719476, true);
      return;
    }
    aprh.a(2, 2131719495, true);
  }
  
  public boolean a()
  {
    return super.onBackEvent();
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if ((!isAdded()) || (isDetached()) || (isRemoving())) {}
    while ((this.jdField_a_of_type_Aprm == null) || (!this.jdField_a_of_type_Aprm.a(paramBitmap, paramInt, paramString))) {
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
    aprn localaprn;
    if (this.jdField_a_of_type_Aprn != null)
    {
      localaprn = this.jdField_a_of_type_Aprn;
      if ((this.jdField_a_of_type_Apri != null) && (this.jdField_a_of_type_Apri.a())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localaprn.a(bool);
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
    return 2131560482;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Apri != null) && (this.jdField_a_of_type_Apri.b()))
    {
      e();
      return true;
    }
    return a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bbgg)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_Apri != null) {
      this.jdField_a_of_type_Apri.b();
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_Bbjc != null)) {
      this.jdField_a_of_type_Bbjc.b();
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
    if (this.jdField_a_of_type_Bbjc != null)
    {
      this.jdField_a_of_type_Bbjc.b();
      this.jdField_a_of_type_Bbjc = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    WXShareHelper.a().b(this);
    if (this.jdField_a_of_type_Aprn != null)
    {
      this.jdField_a_of_type_Aprn.a();
      this.jdField_a_of_type_Aprn = null;
    }
    if (this.jdField_a_of_type_Apri != null)
    {
      this.jdField_a_of_type_Apri.c();
      this.jdField_a_of_type_Apri = null;
    }
    if (this.jdField_a_of_type_Aprm != null)
    {
      this.jdField_a_of_type_Aprm.a();
      this.jdField_a_of_type_Aprm = null;
    }
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bbjc != null)) {
      this.jdField_a_of_type_Bbjc.b();
    }
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LinkByWeiyunFragment<FileAssistant>", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    int j = ((bbjh)paramAdapterView).a.c;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131720906;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        aprh.a(0, i, false);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720907;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, "onItemClick.chooseChannel: " + paramInt + "," + j);
        }
        if ((this.jdField_a_of_type_Apri == null) || (this.jdField_a_of_type_Aprm == null)) {
          break;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Aprm.a(j);
          if (!this.jdField_a_of_type_Boolean) {
            break label257;
          }
        }
        label257:
        for (paramAdapterView = "0X800A9DB";; paramAdapterView = "0X800A9DA")
        {
          aprh.a(paramAdapterView, aprh.c(j), null);
          return;
          this.jdField_a_of_type_Apri.a(j);
          break;
        }
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.link.LinkByWeiyunFragment
 * JD-Core Version:    0.7.0.1
 */