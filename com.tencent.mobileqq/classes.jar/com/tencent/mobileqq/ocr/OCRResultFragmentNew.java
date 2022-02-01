package com.tencent.mobileqq.ocr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.CancelDialogListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.ocr.api.impl.PicOcrHandler;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.participle.ParticipleObserver;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TenDocOCRExportHandler;
import com.tencent.mobileqq.teamwork.TenDocOCRExportObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OCRResultFragmentNew
  extends QPublicBaseFragment
  implements Handler.Callback, View.OnClickListener, OCRPerformUtil.TextWatcher
{
  public static final String[] a = { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  private QBaseActivity A;
  private int B = -1;
  private ParticipleObserver C = new OCRResultFragmentNew.6(this);
  private TenDocOCRExportObserver D = new OCRResultFragmentNew.7(this, this.A);
  private PicOcrObserver E = new OCRResultFragmentNew.10(this);
  ParticipleBottomMenuView b;
  OCRBottomTabView c;
  OCRBottomTabView d;
  ParticipleView e;
  ViewGroup f;
  View g;
  View h;
  View i;
  EditText j;
  ViewGroup k;
  ViewGroup l;
  ActionSheet m;
  URLImageView n;
  GestureFrameLayout o;
  FrameLayout p;
  ImageView q;
  TextView r;
  private int s = -1;
  private boolean t = false;
  private TDProgressDialog u;
  private Dialog v;
  private ProgressView w;
  private boolean x;
  private MqqHandler y;
  private String z;
  
  private CharSequence a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new QQText(paramCharSequence, 8, 16);
    }
    return String.valueOf(paramCharSequence);
  }
  
  private void a(int paramInt)
  {
    this.s = paramInt;
    if (paramInt == 0)
    {
      this.h.setVisibility(0);
      this.g.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131167310)));
      this.f.setVisibility(0);
      this.j.setVisibility(0);
      this.k.setVisibility(0);
      this.j.setText(a(OCRPerformUtil.f, true));
      this.b.setVisibility(8);
      this.e.setVisibility(8);
      this.d.setTabImage(getResources().getDrawable(2130842355));
      this.d.setTabText(getResources().getString(2131908224));
      a(this.A);
      UniformUtils.a(this.A, this.l, false, 0);
    }
    if (paramInt == 2)
    {
      a(this.A);
      d();
      this.f.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.h.setVisibility(8);
      this.e.setVisibility(0);
      this.b.b();
      this.g.setBackgroundDrawable(getResources().getDrawable(2130838332));
      UniformUtils.a(this.A, this.l, false, 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(Color.parseColor("#12B7F5"));
    if (AppSetting.e) {
      paramEditText.setAutoLinkMask(7);
    } else {
      paramEditText.setAutoLinkMask(0);
    }
    paramEditText.addTextChangedListener(new OCRResultFragmentNew.2(this));
    if (c()) {
      paramEditText.setCustomSelectionActionModeCallback(new OCRResultFragmentNew.3(this, paramEditText));
    }
    this.g.getViewTreeObserver().addOnGlobalLayoutListener(new OCRResultFragmentNew.4(this, paramEditText));
    paramEditText.setOnTouchListener(new OCRResultFragmentNew.5(this));
  }
  
  private void a(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity != null) {
      ((InputMethodManager)paramQBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.j.getWindowToken(), 0);
    }
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder != null)
    {
      if (paramOCRLanHolder.b.isEmpty()) {
        return;
      }
      this.m = ActionSheet.create(this.A);
      this.m.setMainTitle(2131897089);
      ArrayList localArrayList = new ArrayList(paramOCRLanHolder.b.size());
      Iterator localIterator = paramOCRLanHolder.b.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = paramOCRLanHolder.a((String)localIterator.next());
        if (localPair != null)
        {
          this.m.addRadioButton((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramOCRLanHolder.a));
          localArrayList.add(localPair.first);
        }
      }
      this.m.addCancelButton(2131887648);
      this.m.setOnButtonClickListener(new OCRResultFragmentNew.9(this, localArrayList, paramOCRLanHolder));
      try
      {
        this.m.show();
        return;
      }
      catch (Exception paramOCRLanHolder)
      {
        paramOCRLanHolder.printStackTrace();
      }
    }
  }
  
  private void a(OCRReqContext paramOCRReqContext)
  {
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramOCRReqContext.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, file not exist, picPath:");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      QQToast.makeText(this.A, 1, 2131897083, 0).show();
      return;
    }
    if (this.t)
    {
      QQToast.makeText(this.A, 0, 2131897086, 0).show();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, in ocr request, ");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr:");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRResultFragmentNew", 2, localStringBuilder.toString());
    }
    this.t = true;
    paramOCRReqContext = (PicOcrHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(PicOcrHandler.a);
    if (paramOCRReqContext != null) {
      paramOCRReqContext.a(OCRPerformUtil.b);
    }
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this.A))
    {
      QQToast.makeText(this.A, HardCodeUtil.a(2131905638), 0).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    f();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      ((IParticipleApi)QRoute.api(IParticipleApi.class)).participleTheContent((AppInterface)localAppRuntime, paramString);
    }
    if (localAppRuntime != null) {
      ReportController.b(localAppRuntime, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
    }
  }
  
  private void c(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.makeText(this.A, 1, 2131889169, 0).show();
      return;
    }
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestExport2Doc, file not exist, picPath:");
      localStringBuilder.append(paramString);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      QQToast.makeText(this.A, 1, 2131897083, 0).show();
      return;
    }
    if (this.x)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestExport2Doc, in export request, ");
      localStringBuilder.append(paramString);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, String.format("requestExport2Doc: %s", new Object[] { this.z }));
    }
    this.x = true;
    this.z = paramString;
    ((TenDocOCRExportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(TenDocOCRExportHandler.a)).a(this.z);
  }
  
  public static boolean c()
  {
    String str = DeviceInfoUtil.f();
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    Object localObject;
    if (!bool2)
    {
      localObject = a;
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (str.equals(localObject[i1])) {
          break label57;
        }
        i1 += 1;
      }
    }
    bool1 = true;
    label57:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportAddContextMenu mode:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",isSupport: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("OCRResultFragmentNew", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  private void d() {}
  
  private void e()
  {
    this.b.setOnMenuClickListener(new OCRResultFragmentNew.8(this));
    this.b.a(this.e);
  }
  
  private void f()
  {
    Dialog localDialog = this.v;
    if (localDialog == null)
    {
      this.w = new ProgressView(this.A);
      this.v = new ReportDialog(this.A);
      if (this.v.getWindow() != null) {
        this.v.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.v.setCanceledOnTouchOutside(false);
      this.v.requestWindowFeature(1);
      this.v.setContentView(this.w);
      this.v.setOnCancelListener(new CancelDialogListener(this.A));
    }
    else
    {
      localDialog.dismiss();
    }
    this.w.setProgressText(HardCodeUtil.a(2131905640));
    this.v.show();
  }
  
  public CharSequence a()
  {
    if (this.s == 0) {
      return OCRPerformUtil.a(this.j);
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    try
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.A, "/base/browser");
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str, "s_qq_ocr_save");
      localActivityURIRequest.extra().putString("tdsourcetag", "s_qq_ocr_save");
      localActivityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
      localActivityURIRequest.extra().putString("fragment_class", ((ITeamWorkDocsListFragment)QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
      if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(this.A, paramString, localActivityURIRequest.extra().getString("tdsourcetag")))
      {
        localActivityURIRequest.extra().putString("url", paramString);
        QRoute.startUri(localActivityURIRequest, null);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.i("OCRResultFragmentNew", 1, paramString.toString());
    }
  }
  
  public CharSequence b()
  {
    if (this.s == 0)
    {
      EditText localEditText = this.j;
      if (localEditText == null) {
        return OCRPerformUtil.e;
      }
      return localEditText.getText();
    }
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771994);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    paramActivity.getWindow().setSoftInputMode(16);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, "doOnActivityResult:OCRResultFragmentNew");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.A = ((QBaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    a(this.A);
    if (this.s == 2) {
      a(0);
    } else {
      this.A.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 == 2131433639)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        OCRPerformUtil.a(this.A, b().toString());
      } else {
        OCRPerformUtil.a(this.A, ((CharSequence)localObject).toString());
      }
      OCRPerformUtil.a("0X8009C84", 0);
    }
    else if (i1 == 2131447831)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        TranslateFragment.a(this.A, String.valueOf(b()));
      } else {
        TranslateFragment.a(this.A, String.valueOf(localObject));
      }
      OCRPerformUtil.a("0X800AAF2", 0);
    }
    else if (i1 == 2131431421)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        BaseMenuUtil.copy(b().toString(), "OCRResultFragmentNew");
      } else {
        BaseMenuUtil.copy(((CharSequence)localObject).toString(), "OCRResultFragmentNew");
      }
      OCRPerformUtil.a("0X800AAF1", 0);
    }
    else if (i1 == 2131439840)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        b(String.valueOf(b()));
      } else {
        b(String.valueOf(localObject));
      }
      OCRPerformUtil.a("0X800A357", 2);
    }
    else if (i1 == 2131432674)
    {
      OCRPerformUtil.a("0X800A161", 0);
      c(this.z);
    }
    else if (i1 == 2131439516)
    {
      a(OCRPerformUtil.d);
    }
    else if (i1 == 2131429218)
    {
      onBackEvent();
    }
    else if (i1 == 2131439512)
    {
      localObject = this.p;
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        this.p.setVisibility(8);
        OCRPerformUtil.a("0X800AC96", 0);
      }
    }
    else if (i1 == 2131439537)
    {
      if ((this.z != null) && (this.p != null))
      {
        a(this.A);
        this.p.setVisibility(0);
      }
      OCRPerformUtil.a("0X800AC95", 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.z = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.y = new MqqHandler(Looper.getMainLooper(), this);
    this.u = new TDProgressDialog(this.A);
    this.A.addObserver(this.C);
    this.A.addObserver(this.D);
    this.A.addObserver(this.E);
    OCRPerformUtil.a("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i2 = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131627613, paramViewGroup, false);
    this.g = paramLayoutInflater.findViewById(2131445137);
    this.h = paramLayoutInflater.findViewById(2131447587);
    this.f = ((ViewGroup)paramLayoutInflater.findViewById(2131439539));
    this.j = ((EditText)paramLayoutInflater.findViewById(2131439534));
    this.k = ((ViewGroup)paramLayoutInflater.findViewById(2131429707));
    this.l = ((ViewGroup)paramLayoutInflater.findViewById(2131429711));
    this.e = ((ParticipleView)paramLayoutInflater.findViewById(2131440910));
    this.b = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131439839));
    this.d = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131447831));
    this.c = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131432674));
    this.i = paramLayoutInflater.findViewById(2131439516);
    paramLayoutInflater.findViewById(2131439840).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131433639).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131431421).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131429218).setOnClickListener(this);
    a(this.j);
    e();
    paramViewGroup = this.i;
    int i1;
    if (OCRPerformUtil.a) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    paramViewGroup.setVisibility(i1);
    this.i.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.o = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131433918));
    this.o.getGestureProxy().a(new OCRResultFragmentNew.1(this));
    this.n = ((URLImageView)paramLayoutInflater.findViewById(2131431354));
    this.p = ((FrameLayout)paramLayoutInflater.findViewById(2131433917));
    this.q = ((ImageView)paramLayoutInflater.findViewById(2131439512));
    this.q.setOnClickListener(this);
    if (this.z != null)
    {
      paramViewGroup = getResources().getDrawable(2130853309);
      paramViewGroup = OCRPerformUtil.a(this.n, paramViewGroup);
      this.n.setImageDrawable(URLDrawable.getFileDrawable(this.z, paramViewGroup));
    }
    this.r = ((TextView)paramLayoutInflater.findViewById(2131439537));
    this.r.setOnClickListener(this);
    a(0);
    a(this.A);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131439533);
    if (bool) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    paramViewGroup.setVisibility(i1);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.A.removeObserver(this.C);
    this.A.removeObserver(this.D);
    this.A.removeObserver(this.E);
    Dialog localDialog = this.v;
    if (localDialog != null)
    {
      localDialog.setOnCancelListener(null);
      this.v.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */