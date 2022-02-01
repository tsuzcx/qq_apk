package com.tencent.mobileqq.widget.share;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetV2
  implements ShareActionSheet
{
  protected boolean A = true;
  protected GridView B;
  protected GridView C;
  protected GridView D;
  private final ShareActionSheetV2.Param E;
  private FaceObserver F = new ShareActionSheetV2.2(this);
  private ResultReceiver G;
  private boolean H;
  private Application.ActivityLifecycleCallbacks I = new ShareActionSheetV2.3(this);
  private ShareActionSheet.IShareActionSheetV2BottomBar J;
  private View K;
  private boolean L;
  private String M;
  private Intent N;
  private SparseArray<INonMainProcAvatarLoader> O;
  private DialogInterface.OnDismissListener P = new ShareActionSheetV2.4(this);
  private ShareActionSheet.OnItemClickListener Q;
  private int R = 0;
  private int S = 0;
  private int T = 0;
  private DialogInterface.OnShowListener U = new ShareActionSheetV2.5(this);
  private DialogInterface.OnShowListener V;
  private DialogInterface.OnDismissListener W;
  private DialogInterface.OnCancelListener X = new ShareActionSheetV2.6(this);
  private DialogInterface.OnCancelListener Y;
  protected Context a;
  protected AdapterView.OnItemClickListener b = new ShareActionSheetV2.1(this);
  protected ActionSheet c;
  protected View d;
  protected ElasticHorScrView e;
  protected ElasticHorScrView f;
  protected ElasticHorScrView g;
  protected LinearLayout h;
  protected TextView i;
  protected LinearLayout j;
  protected ImageView k;
  protected int l;
  protected int m;
  protected int n;
  protected Bundle o;
  protected CharSequence p;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] q;
  protected List<ShareActionSheetBuilder.ActionSheetItem> r = new ArrayList(0);
  protected boolean s = false;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  protected ShareActionSheetV2.AdViewManager z;
  
  public ShareActionSheetV2(ShareActionSheetV2.Param paramParam)
  {
    this.E = paramParam;
    this.a = paramParam.context;
    paramParam = this.a.getResources();
    this.t = paramParam.getDimensionPixelSize(2131297127);
    this.v = this.t;
    this.w = paramParam.getDimensionPixelOffset(2131297129);
    this.x = paramParam.getDimensionPixelOffset(2131297130);
    this.z = new ShareActionSheetV2.AdViewManager();
    int i1 = paramParam.getDisplayMetrics().widthPixels;
    int i2 = paramParam.getDisplayMetrics().heightPixels;
    if (i1 > i2) {
      i1 = i2;
    }
    i1 = (i1 - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
    setIconMarginLeftRight(i1);
    setRowMarginLeftRight((int)(i1 * 6 / 5.5F));
    i();
  }
  
  private int a(List<ShareActionSheetBuilder.ActionSheetItem> paramList, TextView paramTextView)
  {
    paramTextView.setText(a(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.v, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private void a(ElasticHorScrView paramElasticHorScrView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      paramElasticHorScrView.setMove(true);
      return;
    }
    paramElasticHorScrView.setMove(false);
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    String str2 = ((Activity)this.a).getIntent().getStringExtra("big_brother_source_key");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = e();
    }
    if (paramActionSheetItem.action == 73)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, c(), "", str1, "");
      return;
    }
    if (paramActionSheetItem.action == 72)
    {
      ReportController.b(null, "dc00898", "", paramActionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, c(), "", str1, paramActionSheetItem.reportID);
      return;
    }
    if (paramInt == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, c(), "", str1, paramActionSheetItem.reportID);
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, c(), "", str1, paramActionSheetItem.reportID);
    }
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    int i1 = 0;
    while (i1 < this.B.getChildCount())
    {
      paramString2 = this.B.getChildAt(i1).getTag();
      if ((paramString2 != null) && ((paramString2 instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder)))
      {
        paramString2 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramString2;
        if (TextUtils.equals(paramString1, paramString2.c.uin))
        {
          paramString2.c.iconDrawable = new BitmapDrawable(paramBitmap);
          paramString2.b.setBackgroundDrawable(paramString2.c.iconDrawable);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(ArrayList<ResultRecord> paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(boolean paramBoolean)
  {
    setOpenSource(null);
    if (isShowing())
    {
      if (paramBoolean) {}
      try
      {
        this.c.superDismiss();
        break label33;
        this.c.dismiss();
        label33:
        this.d = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
      }
    }
  }
  
  private String c()
  {
    ShareActionSheetV2.Param localParam = this.E;
    if ((localParam != null) && (localParam.reportDataR2 > 0)) {
      return String.valueOf(this.E.reportDataR2);
    }
    return "";
  }
  
  private void d()
  {
    Object localObject2 = ((Activity)this.a).getIntent().getStringExtra("big_brother_source_key");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = e();
    }
    localObject2 = new StringBuilder();
    List[] arrayOfList = b();
    if (arrayOfList.length > 0)
    {
      int i1 = 0;
      while (i1 < arrayOfList[0].size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)arrayOfList[0].get(i1);
        if (i1 != 0) {
          ((StringBuilder)localObject2).append(';');
        }
        ((StringBuilder)localObject2).append(localActionSheetItem.reportID);
        i1 += 1;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, c(), "", (String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(((Activity)this.a).getIntent().getStringExtra("url"))) {
      return "biz_src_general_url";
    }
    return "";
  }
  
  private void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy() called #this = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.O;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i1 = 0;
      while (i1 < this.O.size())
      {
        int i2 = this.O.keyAt(i1);
        localObject = (INonMainProcAvatarLoader)this.O.get(i2);
        if (localObject != null) {
          ((INonMainProcAvatarLoader)localObject).c();
        }
        i1 += 1;
      }
      this.O.clear();
    }
    g();
  }
  
  private void g()
  {
    ResultReceiver localResultReceiver = this.G;
    if (localResultReceiver != null)
    {
      localResultReceiver.send(1, new Bundle());
      this.G = null;
    }
  }
  
  private void h()
  {
    ((Application)this.a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.I);
  }
  
  private void i()
  {
    ((Application)this.a.getApplicationContext()).registerActivityLifecycleCallbacks(this.I);
  }
  
  private boolean j()
  {
    if (this.R != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
      }
      return false;
    }
    if (this.N == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
      }
      return false;
    }
    return true;
  }
  
  private void k()
  {
    try
    {
      if (!isShowing())
      {
        if (this.L) {
          NavigationBarUtil.b(getWindow());
        }
        this.c.show();
        if (this.L)
        {
          NavigationBarUtil.a(getWindow());
          NavigationBarUtil.c(getWindow());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void l()
  {
    if (this.E.fullScreen)
    {
      this.c = ((ActionSheet)ActionSheetHelper.c(this.a, null));
    }
    else
    {
      int i1 = 2131624003;
      if (this.E.flagNotTouchModal) {
        i1 = 2131624004;
      }
      this.c = ((ActionSheet)ActionSheetHelper.a(this.a, null, i1, this.E.lp));
    }
    this.c.setOnShowListener(this.U);
    this.c.setOnDismissListener(new ShareActionSheetV2.7(this));
    this.c.setOnCancelListener(this.X);
    if ((this.d == null) || (this.s)) {
      this.d = a();
    }
    this.c.setActionContentView(this.d, null);
    Window localWindow = this.c.getWindow();
    if (this.E.dimAmount == -1.0F)
    {
      localObject = this.c.getRootView();
      if (localObject != null) {
        ((ViewGroup)localObject).setBackgroundColor(0);
      }
    }
    else
    {
      localWindow.setDimAmount(this.E.dimAmount);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -1);
    this.c.setOutsideDismissEnableCompat(this.E.canceledOnTouchOutside);
    Object localObject = localWindow.getAttributes();
    if (this.E.flagNotTouchModal) {
      localWindow.setLayout(-1, -2);
    }
    if (this.E.flagNotTouchModal) {
      localWindow.setFlags(32, 32);
    }
    localWindow.setAttributes((WindowManager.LayoutParams)localObject);
  }
  
  private void m()
  {
    g();
    Object localObject = new Intent();
    Intent localIntent = this.N;
    if (localIntent != null) {
      localObject = localIntent;
    }
    ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
    ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
    ((Intent)localObject).putExtra("caller_name", this.a.getClass().getSimpleName());
    ((Intent)localObject).putExtra("forward_source_business_type", -1);
    ((Intent)localObject).putExtra("key_req", 2);
    ((Intent)localObject).putExtra("PARAM_ActivityResultReceiver", new ShareActionSheetV2.MyResultReceiver(this));
    this.a.startActivity((Intent)localObject);
    ((Activity)this.a).overridePendingTransition(0, 0);
  }
  
  private boolean n()
  {
    Bundle localBundle = this.o;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBundle != null)
    {
      bool1 = bool2;
      if (localBundle.getBoolean("is_force_night_theme", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @TargetApi(9)
  protected View a()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createViewFlipper() called #this = ");
      ((StringBuilder)localObject1).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, ((StringBuilder)localObject1).toString());
    }
    View localView = View.inflate(this.a, 2131624529, null);
    this.z.a((RelativeLayout)localView.findViewById(2131427848));
    this.K = localView.findViewById(2131427558);
    this.j = ((LinearLayout)localView.findViewById(2131427556));
    if ((QQTheme.isNowThemeIsNight()) || (n()))
    {
      this.K.setBackgroundResource(2130851814);
      this.j.setBackgroundResource(2130851814);
    }
    this.i = ((TextView)localView.findViewById(2131427554));
    if (this.A)
    {
      this.i.setVisibility(0);
      localObject1 = this.p;
      if (localObject1 != null) {
        this.i.setText((CharSequence)localObject1);
      }
    }
    else
    {
      hideTitle();
    }
    this.e = ((ElasticHorScrView)localView.findViewById(2131445371));
    this.f = ((ElasticHorScrView)localView.findViewById(2131445372));
    this.g = ((ElasticHorScrView)localView.findViewById(2131445373));
    this.h = ((LinearLayout)localView.findViewById(2131427545));
    Object localObject1 = b();
    Object localObject3;
    if (localObject1.length > 0) {
      localObject3 = this.r;
    } else {
      localObject3 = new ArrayList(0);
    }
    boolean bool1 = ((List)localObject3).isEmpty() ^ true;
    Object localObject2;
    if (localObject1.length > 0) {
      localObject2 = localObject1[0];
    } else {
      localObject2 = new ArrayList(0);
    }
    boolean bool2 = ((List)localObject2).isEmpty() ^ true;
    if (localObject1.length > 1) {
      localObject1 = localObject1[1];
    } else {
      localObject1 = new ArrayList(0);
    }
    boolean bool3 = true ^ ((List)localObject1).isEmpty();
    Object localObject4 = (TextView)LayoutInflater.from(this.a).inflate(2131624527, null);
    ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.v, -2));
    int i1 = a((List)localObject3, (TextView)localObject4);
    int i2 = a((List)localObject2, (TextView)localObject4);
    int i3 = a((List)localObject1, (TextView)localObject4);
    i2 = Math.max(Math.max(i1, i2), i3);
    i3 = this.a.getResources().getDimensionPixelOffset(2131297126);
    int i4;
    int i5;
    if (bool1)
    {
      this.B = ((GridView)localView.findViewById(2131434385));
      if (Build.VERSION.SDK_INT >= 9) {
        this.e.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject3).iterator();
      i1 = 0;
      while (((Iterator)localObject4).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility == 0) {
          i1 += 1;
        }
      }
      i4 = this.u + getIconWidth() + this.u;
      this.B.setColumnWidth(i4);
      this.B.setNumColumns(i1);
      localObject4 = this.B.getLayoutParams();
      GridView localGridView = this.B;
      localGridView.setPadding(this.y, localGridView.getPaddingTop(), this.y, this.B.getPaddingBottom());
      i5 = this.y;
      ((ViewGroup.LayoutParams)localObject4).width = (i1 * i4 + i5 + i5);
      this.l = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.t + this.w + i2 + i3);
      this.B.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.B.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.a, (List)localObject3, this));
      this.B.setSelector(new ColorDrawable(0));
      this.B.setOnItemClickListener(this.b);
    }
    if (bool2)
    {
      this.C = ((GridView)localView.findViewById(2131434386));
      if (Build.VERSION.SDK_INT >= 9) {
        this.f.setOverScrollMode(2);
      }
      localObject3 = ((List)localObject2).iterator();
      i1 = 0;
      while (((Iterator)localObject3).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject3).next()).visibility == 0) {
          i1 += 1;
        }
      }
      i4 = this.u + getIconWidth() + this.u;
      this.C.setColumnWidth(i4);
      this.C.setNumColumns(i1);
      localObject3 = this.C.getLayoutParams();
      localObject4 = this.C;
      ((GridView)localObject4).setPadding(this.y, ((GridView)localObject4).getPaddingTop(), this.y, this.C.getPaddingBottom());
      i5 = this.y;
      ((ViewGroup.LayoutParams)localObject3).width = (i1 * i4 + i5 + i5);
      this.m = ((ViewGroup.LayoutParams)localObject3).width;
      ((ViewGroup.LayoutParams)localObject3).height = (this.t + this.w + i2 + i3);
      this.C.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.C.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.a, (List)localObject2, this));
      this.C.setSelector(new ColorDrawable(0));
      this.C.setOnItemClickListener(this.b);
    }
    if (bool3)
    {
      this.D = ((GridView)localView.findViewById(2131434387));
      if (Build.VERSION.SDK_INT >= 9) {
        this.g.setOverScrollMode(2);
      }
      this.D.setSmoothScrollbarEnabled(false);
      localObject2 = ((List)localObject1).iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility == 0) {
          i1 += 1;
        }
      }
      i4 = this.u + getIconWidth() + this.u;
      this.D.setColumnWidth(i4);
      this.D.setNumColumns(i1);
      localObject2 = this.D.getLayoutParams();
      localObject3 = this.D;
      ((GridView)localObject3).setPadding(this.y, ((GridView)localObject3).getPaddingTop(), this.y, this.D.getPaddingBottom());
      i5 = this.y;
      ((ViewGroup.LayoutParams)localObject2).width = (i4 * i1 + i5 + i5);
      this.n = ((ViewGroup.LayoutParams)localObject2).width;
      ((ViewGroup.LayoutParams)localObject2).height = (this.t + this.w + i2 + i3);
      this.D.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.D.setNumColumns(i1);
      this.D.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.a, (List)localObject1, this));
      this.D.setSelector(new ColorDrawable(0));
      this.D.setOnItemClickListener(this.b);
    }
    this.k = ((ImageView)localView.findViewById(2131427546));
    this.k.setOnClickListener(new ShareActionSheetV2.8(this));
    if ((!bool1) || (this.R == 8)) {
      this.e.setVisibility(8);
    }
    if ((!bool2) || (this.S == 8)) {
      this.f.setVisibility(8);
    }
    if ((!bool3) || (this.T == 8)) {
      this.g.setVisibility(8);
    }
    localView.post(new ShareActionSheetV2.9(this));
    localObject1 = this.J;
    if (localObject1 != null)
    {
      localObject1 = ((ShareActionSheet.IShareActionSheetV2BottomBar)localObject1).b();
      if (localObject1 != null) {
        this.h.addView((View)localObject1);
      }
    }
    return localView;
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int i1 = 0;
    while (i1 < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i1)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    List[] arrayOfList = this.q;
    if (arrayOfList != null) {
      return arrayOfList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss() called #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    a(false);
  }
  
  public void dismissImmediately()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismissImmediately() called #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    a(true);
  }
  
  public View findViewById(int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    localObject = ((ActionSheet)localObject).getWindow();
    if (localObject != null) {
      return ((Window)localObject).findViewById(paramInt);
    }
    return null;
  }
  
  public ActionSheet getActionSheet()
  {
    return this.c;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    View localView = this.K;
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.o;
  }
  
  public int getIconWidth()
  {
    return this.t;
  }
  
  public String getOpenSource()
  {
    return this.M;
  }
  
  public Window getWindow()
  {
    ActionSheet localActionSheet = this.c;
    if (localActionSheet == null) {
      return null;
    }
    return localActionSheet.getWindow();
  }
  
  public void hideTitle()
  {
    this.A = false;
    TextView localTextView = this.i;
    if ((localTextView != null) && (localTextView.getVisibility() != 8)) {
      this.i.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    ActionSheet localActionSheet = this.c;
    return (localActionSheet != null) && (localActionSheet.isShowing());
  }
  
  public void onConfigurationChanged()
  {
    if (this.a != null)
    {
      if (!isShowing()) {
        return;
      }
      int i1 = this.a.getResources().getDisplayMetrics().widthPixels - this.y;
      a(this.e, i1, this.l);
      a(this.f, i1, this.m);
      a(this.g, i1, this.n);
    }
  }
  
  public void refresh()
  {
    ActionSheet localActionSheet = this.c;
    if (localActionSheet == null) {
      return;
    }
    if (localActionSheet.isShowing())
    {
      this.d = a();
      this.c.setActionContentView(this.d, null);
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    setActionSheetItems(new ArrayList[] { (ArrayList)paramList1, (ArrayList)paramList2 });
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.q = paramArrayOfList;
    this.s = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    paramCharSequence = this.i;
    if (paramCharSequence != null) {
      paramCharSequence.setText(this.p);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.z.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.z.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.J = paramIShareActionSheetV2BottomBar;
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCancelListener() called with: listener = [");
      localStringBuilder.append(paramOnCancelListener);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    this.Y = paramOnCancelListener;
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.o = paramBundle;
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIntentForStartForwardRecentActivity() called with: intent = [");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    this.N = paramIntent;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.Q = paramOnItemClickListener;
    this.s = true;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOnDismissListener() called with: dismissListener = [");
      localStringBuilder.append(paramOnDismissListener);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    this.W = paramOnDismissListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.V = paramOnShowListener;
  }
  
  public void setOpenSource(String paramString)
  {
    this.M = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.R = paramInt1;
    this.S = paramInt2;
    this.T = paramInt3;
  }
  
  public void show()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("show() called #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    if ((!this.H) && (!isShowing()))
    {
      this.H = true;
      if (j())
      {
        m();
        return;
      }
      l();
      k();
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("show() isShowing #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
  }
  
  public void updateUI() {}
  
  public void updateUIIfShowing() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */