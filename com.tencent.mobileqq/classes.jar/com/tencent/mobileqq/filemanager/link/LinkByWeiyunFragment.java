package com.tencent.mobileqq.filemanager.link;

import abju;
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
import aoig;
import aozl;
import aozm;
import aozn;
import aozo;
import aozs;
import aozt;
import apck;
import apdh;
import apir;
import bafb;
import bahv;
import bahx;
import baia;
import bajq;
import bbsh;
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
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class LinkByWeiyunFragment
  extends IphoneTitleBarFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, AdapterView.OnItemClickListener, aozl, bbsh
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#00000000");
  private View jdField_a_of_type_AndroidViewView;
  private aozo jdField_a_of_type_Aozo;
  private aozs jdField_a_of_type_Aozs;
  private aozt jdField_a_of_type_Aozt;
  private bafb jdField_a_of_type_Bafb;
  private bahv jdField_a_of_type_Bahv;
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
      localIntent.putExtra("fileinfo", apir.a(paramFileManagerEntity));
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("key_local_file_path", paramString);
    }
    localIntent.putExtra("key_by_qr_code", paramBoolean);
    abju.a(paramContext, localIntent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
    if (paramBoolean) {}
    for (paramContext = "0X800A9D5";; paramContext = "0X800A9D4")
    {
      aozn.a(paramContext, aozn.a(paramFileManagerEntity, paramString), null);
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
        return aozn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, bool);
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
    Object localObject;
    TextView localTextView;
    AsyncImageView localAsyncImageView;
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131632486;
      setTitle(getString(i));
      localObject = (TextView)this.mContentView.findViewById(2131310201);
      localTextView = (TextView)this.mContentView.findViewById(2131310199);
      localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131310200);
      str = a();
      if (((TextView)localObject).getMeasuredWidth() > 0) {
        break label152;
      }
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    }
    for (;;)
    {
      localTextView.setText(apdh.a(a()));
      localAsyncImageView.setImageResource(apck.b(str));
      i = a();
      if ((i == 5) || (i == 0))
      {
        localObject = b();
        if (apdh.b((String)localObject))
        {
          if (i != 5) {
            break label174;
          }
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
        }
      }
      return;
      i = 2131632498;
      break;
      label152:
      ((TextView)localObject).setText(apck.a(str, false, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    label174:
    localAsyncImageView.setAsyncImage((String)localObject);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aozt = new aozt(this, this.mContentView.findViewById(2131310194), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aozo = new aozo(this, this.mContentView.findViewById(2131306264), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aozs = new aozs(this, (ViewGroup)this.mContentView.findViewById(2131309736));
  }
  
  private void e()
  {
    bafb localbafb;
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = new bafb(getActivity(), 2131690181);
      this.jdField_a_of_type_Bafb.setContentView(2131493345);
      localbafb = this.jdField_a_of_type_Bafb;
      if (!this.jdField_a_of_type_Boolean) {
        break label123;
      }
    }
    label123:
    for (int i = 2131632477;; i = 2131632478)
    {
      localbafb.setTitle(i);
      this.jdField_a_of_type_Bafb.setMessage(null);
      this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, this);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131627423, this);
      this.jdField_a_of_type_Bafb.setCancelable(true);
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.show();
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
    return apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
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
  
  public aozm a()
  {
    if (this.jdField_a_of_type_Aozt == null) {
      return new aozm();
    }
    return this.jdField_a_of_type_Aozt.a();
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
    if (this.jdField_a_of_type_Aozo != null) {
      this.jdField_a_of_type_Aozo.a();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Aozo == null) || (this.jdField_a_of_type_Aozs == null)) {
      return;
    }
    BaseActivity localBaseActivity = a();
    if (this.jdField_a_of_type_Bahv == null)
    {
      this.jdField_a_of_type_Bahv = new bahv(localBaseActivity);
      this.jdField_a_of_type_Bahv.a(localBaseActivity.getString(2131653614));
      this.jdField_a_of_type_Bahv.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = new AsyncImageView(localBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bajq.a(61.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bajq.a(61.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bajq.a(16.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_Bahv.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (RelativeLayout.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(null);
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(paramBitmap);
    }
    Object localObject = this.jdField_a_of_type_Bahv;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramBitmap = this.jdField_a_of_type_Aozs.a(localBaseActivity);; paramBitmap = this.jdField_a_of_type_Aozo.a(localBaseActivity))
    {
      ((bahv)localObject).a(paramBitmap);
      if (this.jdField_a_of_type_Bahv.a()) {
        break;
      }
      this.jdField_a_of_type_Bahv.a();
      this.jdField_a_of_type_Bahv.d(jdField_a_of_type_Int);
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
      aozn.a(1, 2131653595, true);
      return;
    }
    aozn.a(2, 2131653612, true);
  }
  
  public boolean a()
  {
    return super.onBackEvent();
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if ((!isAdded()) || (isDetached()) || (isRemoving())) {}
    while ((this.jdField_a_of_type_Aozs == null) || (!this.jdField_a_of_type_Aozs.a(paramBitmap, paramInt, paramString))) {
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
    aozt localaozt;
    if (this.jdField_a_of_type_Aozt != null)
    {
      localaozt = this.jdField_a_of_type_Aozt;
      if ((this.jdField_a_of_type_Aozo != null) && (this.jdField_a_of_type_Aozo.a())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localaozt.a(bool);
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
    return 2131494911;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Aozo != null) && (this.jdField_a_of_type_Aozo.b()))
    {
      e();
      return true;
    }
    return a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bafb)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_Aozo != null) {
      this.jdField_a_of_type_Aozo.b();
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_Bahv != null)) {
      this.jdField_a_of_type_Bahv.b();
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
    if (this.jdField_a_of_type_Bahv != null)
    {
      this.jdField_a_of_type_Bahv.b();
      this.jdField_a_of_type_Bahv = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    WXShareHelper.a().b(this);
    if (this.jdField_a_of_type_Aozt != null)
    {
      this.jdField_a_of_type_Aozt.a();
      this.jdField_a_of_type_Aozt = null;
    }
    if (this.jdField_a_of_type_Aozo != null)
    {
      this.jdField_a_of_type_Aozo.c();
      this.jdField_a_of_type_Aozo = null;
    }
    if (this.jdField_a_of_type_Aozs != null)
    {
      this.jdField_a_of_type_Aozs.a();
      this.jdField_a_of_type_Aozs = null;
    }
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bahv != null)) {
      this.jdField_a_of_type_Bahv.b();
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
    int j = ((baia)paramAdapterView).a.c;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131655008;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        aozn.a(0, i, false);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131655009;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, "onItemClick.chooseChannel: " + paramInt + "," + j);
        }
        if ((this.jdField_a_of_type_Aozo == null) || (this.jdField_a_of_type_Aozs == null)) {
          break;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Aozs.a(j);
          if (!this.jdField_a_of_type_Boolean) {
            break label257;
          }
        }
        label257:
        for (paramAdapterView = "0X800A9DB";; paramAdapterView = "0X800A9DA")
        {
          aozn.a(paramAdapterView, aozn.c(j), null);
          return;
          this.jdField_a_of_type_Aozo.a(j);
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