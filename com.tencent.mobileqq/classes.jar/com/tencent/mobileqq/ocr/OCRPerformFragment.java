package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageSectBean;
import com.tencent.mobileqq.ocr.view.OcrImageTextBean;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.OcrScrollGestureListener;
import com.tencent.mobileqq.ocr.view.OcrScrollGestureListener.OcrPerformListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.OCRAccountUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OCRPerformFragment
  extends QPublicBaseFragment
  implements Handler.Callback, View.OnClickListener, OcrScrollGestureListener.OcrPerformListener
{
  private volatile boolean A;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private long F = -1L;
  private int G = 0;
  private int H = -1;
  private PicOcrObserver I = new OCRPerformFragment.6(this);
  private OCRObserver J = new OCRPerformFragment.11(this);
  private final WeakReferenceHandler a = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private QBaseActivity b;
  private String c;
  private OCRHandler d;
  private PicOcrRspResult e;
  private BroadcastReceiver f = null;
  private View g;
  private String h;
  private ImageView i;
  private ScanSuccessView j;
  private TranslateLanguageOptionsView k;
  private TranslateLanguageOptionsView l;
  private RelativeLayout m;
  private RelativeLayout n;
  private RelativeLayout o;
  private RelativeLayout p;
  private GestureFrameLayout q;
  private OcrImageTextView r;
  private LinearLayout s;
  private ActionSheet t;
  private BubbleLayout u;
  private QQProgressDialog v;
  private ImageView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("param_ocr_is_cache", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrIsCache", true, 0L, 0L, localHashMap, "");
  }
  
  private void a(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localHashMap.put("param_ocr_cost", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrCost", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, OCRPerformFragment.class);
    localIntent.putExtra("param_ocr_path", paramString1);
    localIntent.putExtra("PARAM_FROM", paramInt1);
    localIntent.addFlags(67108864);
    localIntent.putExtra("param_ocr_md5", paramString2);
    localIntent.putExtra("param_business_type", paramInt2);
    QPublicFragmentActivity.start(paramActivity, localIntent, OCRPerformFragment.class);
    paramActivity.overridePendingTransition(0, 0);
    OCRPerformUtil.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131439530);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.e) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).getTabText()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131439529);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.e) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).getTabText()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131439528);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.e) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).getTabText()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131439527);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.e) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).getTabText()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131439531);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.e) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).getTabText()).trim());
    }
    this.h = getResources().getString(2131897075);
    this.g = paramView;
    this.r = ((OcrImageTextView)paramView.findViewById(2131439521));
    this.r.setVisibility(0);
    this.r.setOnClickListener(this);
    this.m = ((RelativeLayout)paramView.findViewById(2131439523));
    localObject = (ImageButton)paramView.findViewById(2131439525);
    ((ImageButton)localObject).setOnClickListener(this);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131887625), null);
    this.n = ((RelativeLayout)paramView.findViewById(2131439522));
    this.n.setOnClickListener(this);
    this.w = ((ImageView)paramView.findViewById(2131439517));
    this.x = ((TextView)paramView.findViewById(2131439518));
    this.u = ((BubbleLayout)paramView.findViewById(2131439513));
    this.u.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131439526);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131897100), null);
    ((EyeButton)localObject).setLonTouchListener(new OCRPerformFragment.3(this));
    this.y = ((TextView)paramView.findViewById(2131447814));
    this.z = ((TextView)paramView.findViewById(2131447810));
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p = ((RelativeLayout)paramView.findViewById(2131439532));
    a(OCRPerformUtil.c, false);
    this.o = ((RelativeLayout)paramView.findViewById(2131439524));
    this.o.bringToFront();
    UniformUtils.a(this.b, this.o);
    this.s = ((LinearLayout)paramView.findViewById(2131439520));
    this.s.setVisibility(4);
    this.q = ((GestureFrameLayout)paramView.findViewById(2131434167));
  }
  
  private void a(PicOcrRspResult paramPicOcrRspResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateOcrResultData：");
      localStringBuilder.append(paramPicOcrRspResult.toString());
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      OCRPerformUtil.e = OCRPerformUtil.a(paramPicOcrRspResult.f);
      if (!OCRPerformUtil.a)
      {
        OCRPerformUtil.c = OCRPerformUtil.a(OCRPerformUtil.c, paramPicOcrRspResult.d, paramPicOcrRspResult.g, paramPicOcrRspResult.h);
        OCRPerformUtil.d = OCRPerformUtil.a(OCRPerformUtil.d, paramPicOcrRspResult.d, paramPicOcrRspResult.g, paramPicOcrRspResult.h);
      }
      if (OCRPerformUtil.b != null)
      {
        OCRPerformUtil.b.a = paramPicOcrRspResult.d;
        OCRPerformUtil.b.b = this.H;
        OCRPerformUtil.b.f = paramPicOcrRspResult.a;
        OCRPerformUtil.b.c = this.c;
        OCRPerformUtil.b.l = paramPicOcrRspResult.e;
        OCRPerformUtil.b.i = paramPicOcrRspResult.j;
        OCRPerformUtil.b.j = paramPicOcrRspResult.k;
        OCRPerformUtil.b.e = paramPicOcrRspResult.i;
        OCRPerformUtil.b.g = paramPicOcrRspResult.l;
      }
      paramPicOcrRspResult.m = BaseImageUtil.h(this.c);
      OCRPerformUtil.g = paramPicOcrRspResult;
    }
    if (OCRPerformUtil.a)
    {
      a(OCRPerformUtil.c.d, OCRPerformUtil.c.e, false);
      return;
    }
    this.r.setResultNormal(OCRPerformUtil.g);
    AccessibilityUtil.a(this.r, OCRPerformUtil.e, null);
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateSrcLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.k;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.k.dismiss();
    }
    localObject = this.l;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.l.dismiss();
      return;
    }
    if (paramOCRLanHolder.f != null)
    {
      if (paramOCRLanHolder.f.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramOCRLanHolder.f.size())
      {
        String str = (String)paramOCRLanHolder.f.get(i1);
        if (str.equalsIgnoreCase(paramOCRLanHolder.d)) {
          i2 = i1;
        }
        TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
        localOptionItem.b = str;
        localOptionItem.a = OCRPerformUtil.a(str);
        ((List)localObject).add(localOptionItem);
        i1 += 1;
      }
      this.l = TranslateLanguageOptionsView.a(this.b, (List)localObject, i2, new OCRPerformFragment.7(this, paramOCRLanHolder));
      i1 = this.y.getMeasuredWidth() / 2;
      i2 = DisplayUtil.a(this.b, 75.0F);
      this.y.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.l.showAsDropDown(this.y, i1 - i2, 0);
      this.l.setOnDismissListener(new OCRPerformFragment.8(this, paramOCRLanHolder));
    }
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2130842356;
    } else {
      i1 = 2130842355;
    }
    if (paramBoolean) {
      localObject = "#00CAFC";
    } else {
      localObject = "#FFFFFF";
    }
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.g.findViewById(2131439531);
    if (localOCRBottomTabView != null)
    {
      localOCRBottomTabView.setTabImage(getResources().getDrawable(i1));
      localOCRBottomTabView.setTabTextColor(Color.parseColor((String)localObject));
    }
    Object localObject = this.p;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    if (!paramBoolean) {
      return;
    }
    if (paramOCRLanHolder == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTranslateTitle, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.y.setText(paramOCRLanHolder.b(paramOCRLanHolder.d));
    this.z.setText(paramOCRLanHolder.b(paramOCRLanHolder.e));
    if ((paramOCRLanHolder.f != null) && (paramOCRLanHolder.f.size() > 1))
    {
      this.y.setClickable(true);
      localObject = getResources().getDrawable(2130847828);
      this.y.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    else
    {
      this.y.setClickable(false);
      this.y.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if ((paramOCRLanHolder.g != null) && (paramOCRLanHolder.g.size() > 1))
    {
      this.z.setClickable(true);
      paramOCRLanHolder = getResources().getDrawable(2130847828);
      this.z.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramOCRLanHolder);
      return;
    }
    this.z.setClickable(false);
    this.z.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("src:");
      localStringBuilder.append(paramTranslateResult.b);
      localStringBuilder.append(", dst:");
      localStringBuilder.append(paramTranslateResult.c);
      localStringBuilder.append(", OCRLanHolder:");
      localStringBuilder.append(OCRPerformUtil.c.a());
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    if (OCRPerformUtil.c != null)
    {
      OCRPerformUtil.c.d(paramTranslateResult.b);
      OCRPerformUtil.c.e(paramTranslateResult.c);
      OCRPerformUtil.d.c(OCRPerformUtil.c.e);
      a(OCRPerformUtil.c, OCRPerformUtil.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, new Object[] { paramTranslateResult.b() });
    }
    this.r.setResultSection(paramTranslateResult);
    AccessibilityUtil.a(this.r, paramTranslateResult.d(), null);
  }
  
  private void a(OCRReqContext paramOCRReqContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.g != null))
    {
      a(1);
      a(OCRPerformUtil.g, false);
      return;
    }
    if (paramOCRReqContext == null)
    {
      paramOCRReqContext = new StringBuilder();
      paramOCRReqContext.append("requestOcr, reqContext is null!!! BusinessType = ");
      paramOCRReqContext.append(this.H);
      QLog.d("OCRPerformFragment", 2, paramOCRReqContext.toString());
      return;
    }
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramOCRReqContext.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, file not exist, picPath:");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRPerformFragment", 1, localStringBuilder.toString());
      QQToast.makeText(this.b, 1, 2131897083, 0).show();
      return;
    }
    if (this.A)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, in ocr request, ");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRPerformFragment", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr:");
      localStringBuilder.append(paramOCRReqContext.c);
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    k();
    this.A = true;
    this.F = System.currentTimeMillis();
    ((IPicOcrService)this.b.getAppRuntime().getRuntimeService(IPicOcrService.class, "")).requestOcr(paramOCRReqContext, this.I);
    this.G += 1;
  }
  
  private void a(String paramString)
  {
    OCRPerformUtil.f = i();
    Intent localIntent = new Intent(this.b, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    QPublicFragmentActivity.start(this.b, localIntent, OCRResultFragmentNew.class);
    this.b.overridePendingTransition(0, 0);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.h != null))
    {
      a(OCRPerformUtil.h);
      return;
    }
    if (this.A)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, inTranslateRequestNow");
      }
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!NetworkUtil.isNetworkAvailable(this.b))
      {
        QQToast.makeText(this.b, 1, 2131889169, 0).show();
        OCRPerformUtil.a("0X800B557", 0);
        return;
      }
      String str = String.valueOf(OCRPerformUtil.e);
      if (TextUtils.isEmpty(str))
      {
        QLog.d("OCRPerformFragment", 1, "requestTranslate, mInputTransText null");
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestTranslate, srcLan:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", dstLan:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
      }
      this.A = true;
      b(false);
      Object localObject = this.d;
      if (localObject != null) {
        ((OCRHandler)localObject).a(str, paramString1, paramString2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, srcLan/dstLan is null");
    }
  }
  
  private void a(List<OcrImageTextBean> paramList, List<OcrImageSectBean> paramList1)
  {
    paramList = new OcrScrollGestureListener(this.q, paramList, paramList1, this, this);
    this.q.getGestureProxy().a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    String str1 = getResources().getString(2131897104);
    String str2 = getResources().getString(2131897107);
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.g.findViewById(2131439527);
    if (paramBoolean)
    {
      String str3 = String.valueOf(localOCRBottomTabView.getTabText());
      StringBuilder localStringBuilder;
      if (!str3.contains(str2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str3);
        localStringBuilder.append(str2);
        localOCRBottomTabView.setTabText(localStringBuilder.toString());
      }
      localOCRBottomTabView = (OCRBottomTabView)this.g.findViewById(2131439530);
      str3 = String.valueOf(localOCRBottomTabView.getTabText());
      if (!str3.contains(str2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str3);
        localStringBuilder.append(str2);
        localOCRBottomTabView.setTabText(localStringBuilder.toString());
      }
      localOCRBottomTabView = (OCRBottomTabView)this.g.findViewById(2131439529);
      str3 = String.valueOf(localOCRBottomTabView.getTabText());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.h = this.h.replace(str1, str2);
      return;
    }
    localOCRBottomTabView.setTabText(getResources().getString(2131897101));
    ((OCRBottomTabView)this.g.findViewById(2131439530)).setTabText(getResources().getString(2131889658));
    ((OCRBottomTabView)this.g.findViewById(2131439531)).setTabText(getResources().getString(2131897095));
    ((OCRBottomTabView)this.g.findViewById(2131439529)).setTabText(getResources().getString(2131897102));
    this.h = getResources().getString(2131897075);
  }
  
  private void b(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateDstLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.l.dismiss();
    }
    localObject = this.k;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.k.dismiss();
      return;
    }
    if (paramOCRLanHolder.g != null)
    {
      if (paramOCRLanHolder.g.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramOCRLanHolder.g.size())
      {
        String str = (String)paramOCRLanHolder.g.get(i1);
        if (!str.equalsIgnoreCase(paramOCRLanHolder.d))
        {
          if (str.equalsIgnoreCase(paramOCRLanHolder.e)) {
            i2 = i1;
          }
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.b = str;
          localOptionItem.a = OCRPerformUtil.a(str);
          ((List)localObject).add(localOptionItem);
        }
        i1 += 1;
      }
      this.k = TranslateLanguageOptionsView.a(this.b, (List)localObject, i2, new OCRPerformFragment.9(this, paramOCRLanHolder));
      i1 = this.z.getMeasuredWidth() / 2;
      i2 = DisplayUtil.a(this.b, 75.0F);
      this.z.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.k.showAsDropDown(this.z, i1 - i2, 0);
      this.k.setOnDismissListener(new OCRPerformFragment.10(this, paramOCRLanHolder));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQProgressDialog localQQProgressDialog = this.v;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.v.dismiss();
      }
    }
    else
    {
      if (this.v == null)
      {
        this.v = new QQProgressDialog(this.b, getResources().getDimensionPixelSize(2131299920));
        this.v.c(2131897099);
      }
      if (!this.b.isFinishing()) {
        this.v.show();
      }
      OCRPerformUtil.a("0X800B556", 0);
    }
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.w.setImageResource(2130842352);
      this.x.setText(2131897105);
      this.n.setVisibility(0);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.n.setVisibility(8);
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_select_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.n.setVisibility(0);
      this.w.setImageResource(2130842353);
      this.x.setText(2131897106);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.n.setVisibility(8);
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_fullText_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.u.setVisibility(0);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.u.setVisibility(8);
  }
  
  private CharSequence i()
  {
    OcrImageTextView localOcrImageTextView = this.r;
    if ((localOcrImageTextView != null) && (localOcrImageTextView.b()))
    {
      OCRPerformUtil.f = this.r.c();
      return OCRPerformUtil.f;
    }
    if ((OCRPerformUtil.a) && (OCRPerformUtil.h != null)) {
      return OCRPerformUtil.h.a();
    }
    return OCRPerformUtil.e;
  }
  
  private void j()
  {
    this.t = ActionSheet.create(this.b);
    this.t.addButton(this.h);
    this.t.addButton(2131897074);
    this.t.addCancelButton(2131887648);
    this.t.setOnButtonClickListener(new OCRPerformFragment.4(this));
    this.t.show();
  }
  
  private void k()
  {
    this.o.setVisibility(8);
    this.s.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.j == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.j = new ScanSuccessView(this.b);
      this.j.setShowProgress(false);
      this.j.setBackgroundColor(2130706432);
      this.j.setScale(ScreenUtil.SCREEN_WIDTH);
      this.m.addView(this.j, localLayoutParams);
      this.j.setScanText(HardCodeUtil.a(2131905634));
    }
    if (this.i == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.i = new ImageView(this.b);
      this.i.setImageResource(2130844389);
      localLayoutParams.leftMargin = DisplayUtil.a(this.b, 12.0F);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.b) + DisplayUtil.a(this.b, 12.0F));
      } else {
        localLayoutParams.topMargin = DisplayUtil.a(this.b, 12.0F);
      }
      this.m.addView(this.i, localLayoutParams);
      this.i.setOnClickListener(new OCRPerformFragment.5(this));
      this.i.bringToFront();
    }
  }
  
  private void l()
  {
    if (this.i != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeBackBtn");
      }
      this.i.setVisibility(8);
      this.m.removeView(this.i);
      this.i = null;
    }
    if (this.j != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeView");
      }
      this.j.setVisibility(8);
      this.m.removeView(this.j);
      this.j = null;
    }
    this.o.setVisibility(0);
    this.s.setVisibility(0);
  }
  
  public void a()
  {
    OcrImageTextView localOcrImageTextView = this.r;
    if (localOcrImageTextView != null) {
      a(localOcrImageTextView.getOcrImageTextList(), this.r.getOcrTransTextList());
    }
    l();
    d();
  }
  
  public void b()
  {
    a(this.r.b());
  }
  
  public void c()
  {
    if (!this.D)
    {
      this.D = true;
      f();
    }
  }
  
  public void d()
  {
    if (!this.C)
    {
      this.C = true;
      g();
      return;
    }
    if ((!this.D) && (!this.r.a(this.q.getHeight())))
    {
      this.D = true;
      f();
      return;
    }
    if (!this.E)
    {
      this.E = true;
      h();
    }
  }
  
  public boolean e()
  {
    float f1 = this.q.getGestureProxy().c().d();
    boolean bool;
    if (f1 > 1.0F) {
      bool = true;
    } else if (f1 == 1.0F) {
      bool = this.r.a(this.q.getHeight()) ^ true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, new Object[] { "checkImageFitView, zoom:", Float.valueOf(f1), " result:", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("what:");
      localStringBuilder.append(paramMessage.what);
      QLog.i("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    if (paramMessage.what == 100)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        this.r.setImageBitmap(paramMessage);
        this.B = true;
        if (this.e != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.I.onUpdate(100, true, this.e);
          return true;
        }
      }
      else
      {
        QQToast.makeText(this.b, 1, 2131897079, 0).show();
        onBackEvent();
        return true;
      }
    }
    else
    {
      if (paramMessage.what == 101)
      {
        QQToast.makeText(MobileQQ.sMobileQQ, 1, 2131897084, 0).show();
        onBackEvent();
        return true;
      }
      if (paramMessage.what == 102)
      {
        paramMessage = (PicOcrRspResult)paramMessage.obj;
        if (paramMessage != null)
        {
          if (this.B)
          {
            if (QLog.isColorLevel()) {
              QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
            }
            this.I.onUpdate(100, true, paramMessage);
            return true;
          }
          this.e = paramMessage;
        }
      }
    }
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771994);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(5);
      paramActivity.getWindow().addFlags(134217728);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = ((QBaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    QBaseActivity localQBaseActivity = this.b;
    if (localQBaseActivity != null) {
      localQBaseActivity.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i6 = paramView.getId();
    if (i6 == 2131439525)
    {
      OCRPerformUtil.a("0X800AAE0", 0);
      onBackEvent();
    }
    else
    {
      int i3 = 1;
      int i4 = 1;
      int i5 = 1;
      int i1 = 1;
      Object localObject;
      if (i6 == 2131439526)
      {
        localObject = this.r;
        ((OcrImageTextView)localObject).setShowTextMask(((OcrImageTextView)localObject).a() ^ true);
      }
      else if (i6 == 2131439528)
      {
        OCRPerformUtil.b(this.b, this.c);
        if (OCRPerformUtil.a) {
          localObject = "0X800B55C";
        } else {
          localObject = "0X800AAE2";
        }
        OCRPerformUtil.a((String)localObject, 0);
      }
      else
      {
        int i2 = 2;
        if (i6 == 2131439527)
        {
          BaseMenuUtil.copy(String.valueOf(i()), "OCRPerformFragment");
          if (OCRPerformUtil.a) {
            localObject = "0X800B55D";
          } else {
            localObject = "0X800AAE7";
          }
          if (this.r.b()) {
            i1 = 2;
          }
          OCRPerformUtil.a((String)localObject, i1);
        }
        else if (i6 == 2131439531)
        {
          OCRPerformUtil.a ^= true;
          if (OCRPerformUtil.a) {
            localObject = "0X800B555";
          } else {
            localObject = "0X800B562";
          }
          if (this.r.b()) {
            i1 = i2;
          } else {
            i1 = 1;
          }
          OCRPerformUtil.a((String)localObject, i1);
          a(false);
          if (OCRPerformUtil.a)
          {
            a(OCRPerformUtil.c.d, OCRPerformUtil.c.e, true);
            OCRPerformUtil.d.c(OCRPerformUtil.c.e);
          }
          else
          {
            a(OCRPerformUtil.c, false);
            a(OCRPerformUtil.b, true);
            OCRPerformUtil.d.a(OCRPerformUtil.c);
          }
        }
        else if (i6 == 2131439530)
        {
          if (OCRPerformUtil.a) {
            localObject = "0X800B55E";
          } else {
            localObject = "0X800AAE8";
          }
          i1 = i3;
          if (this.r.b()) {
            i1 = 2;
          }
          OCRPerformUtil.a((String)localObject, i1);
          j();
        }
        else if (i6 == 2131439529)
        {
          if ((this.u != null) && (this.s.getVisibility() != 8)) {
            this.u.setVisibility(8);
          }
          a(this.c);
          if (OCRPerformUtil.a) {
            localObject = "0X800B561";
          } else {
            localObject = "0X800AAEC";
          }
          i1 = i4;
          if (this.r.b()) {
            i1 = 2;
          }
          OCRPerformUtil.a((String)localObject, i1);
        }
        else if (i6 == 2131431492)
        {
          BaseMenuUtil.copy(String.valueOf(i()), "OCRPerformFragment");
          OCRPerformUtil.a("0X800AAEF", 0);
        }
        else if (i6 == 2131433636)
        {
          OCRPerformUtil.a(this.b, String.valueOf(i()));
          OCRPerformUtil.a("0X800AAF0", 0);
        }
        else if (i6 == 2131447830)
        {
          TranslateFragment.a(this.b, String.valueOf(i()));
          i1 = i5;
          if (this.r.b()) {
            i1 = 2;
          }
          OCRPerformUtil.a("0X800AAEB", i1);
        }
        else if (i6 == 2131439522)
        {
          this.n.setVisibility(8);
          d();
        }
        else if (i6 == 2131447814)
        {
          a(OCRPerformUtil.c);
        }
        else if (i6 == 2131447810)
        {
          b(OCRPerformUtil.c);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    OCRPerformUtil.a = false;
    paramBundle = this.b.getIntent();
    this.c = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPicPath=");
      localStringBuilder.append(this.c);
      QLog.e("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    this.H = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (OCRPerformUtil.b == null)
    {
      OCRPerformUtil.b = new OCRReqContext();
      OCRPerformUtil.b.a = "";
      OCRPerformUtil.b.h = false;
    }
    OCRPerformUtil.b.b = this.H;
    OCRPerformUtil.b.f = paramBundle;
    OCRPerformUtil.b.c = this.c;
    this.f = new OCRPerformFragment.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      this.b.registerReceiver(this.f, paramBundle);
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.b.getAppRuntime() != null)
    {
      this.b.addObserver(this.J);
      this.b.addObserver(this.I);
    }
    this.d = ((OCRHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.a));
    MetricsApi.getDefault().buildSuccessRateCounter("OCR_REQUEST");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627612, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(OCRPerformUtil.b, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "onDestroy!");
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      this.b.unregisterReceiver((BroadcastReceiver)localObject);
      this.f = null;
    }
    this.b.removeObserver(this.J);
    this.b.removeObserver(this.I);
    localObject = this.r;
    if (localObject != null)
    {
      ((OcrImageTextView)localObject).e();
      this.r.d();
    }
    OCRPerformUtil.a();
    this.b = null;
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("qq_sub_business_id", -1) == 103))
    {
      if (this.b.isInMultiWindow())
      {
        QQToast.makeText(this.b, 2131892957, 0).show();
      }
      else
      {
        this.c = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        this.r.setImageURI(Uri.fromFile(new File(this.c)));
        this.q.getGestureProxy().e();
        this.r.setShowTextMask(false);
        OCRPerformUtil.b.c();
        OCRPerformUtil.b.b(this.c);
        OCRPerformUtil.b.a(true);
        a(OCRPerformUtil.b, false);
      }
      ReportController.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */