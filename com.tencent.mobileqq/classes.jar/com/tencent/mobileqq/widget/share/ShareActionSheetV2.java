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
  protected int a;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new ShareActionSheetV2.3(this);
  protected Context a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new ShareActionSheetV2.6(this);
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ShareActionSheetV2.4(this);
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = new ShareActionSheetV2.5(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected Bundle a;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private SparseArray<INonMainProcAvatarLoader> jdField_a_of_type_AndroidUtilSparseArray;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected ElasticHorScrView a;
  private FaceObserver jdField_a_of_type_ComTencentMobileqqArmapFaceObserver = new ShareActionSheetV2.2(this);
  private ShareActionSheet.IShareActionSheetV2BottomBar jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$IShareActionSheetV2BottomBar;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  protected ShareActionSheetV2.AdViewManager a;
  private final ShareActionSheetV2.Param jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param;
  protected ActionSheet a;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected List<ShareActionSheetBuilder.ActionSheetItem> a;
  protected boolean a;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a;
  protected int b;
  private DialogInterface.OnCancelListener jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener;
  private DialogInterface.OnDismissListener jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener;
  private DialogInterface.OnShowListener jdField_b_of_type_AndroidContentDialogInterface$OnShowListener;
  private View jdField_b_of_type_AndroidViewView;
  protected GridView b;
  protected LinearLayout b;
  protected ElasticHorScrView b;
  protected boolean b;
  protected int c;
  protected GridView c;
  protected ElasticHorScrView c;
  private boolean c;
  protected int d;
  private boolean d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  public ShareActionSheetV2(ShareActionSheetV2.Param paramParam)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new ShareActionSheetV2.1(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param = paramParam;
    this.jdField_a_of_type_AndroidContentContext = paramParam.context;
    paramParam = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_d_of_type_Int = paramParam.getDimensionPixelSize(2131296796);
    this.f = this.jdField_d_of_type_Int;
    this.g = paramParam.getDimensionPixelOffset(2131296798);
    this.h = paramParam.getDimensionPixelOffset(2131296799);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager = new ShareActionSheetV2.AdViewManager();
    int m = paramParam.getDisplayMetrics().widthPixels;
    int n = paramParam.getDisplayMetrics().heightPixels;
    if (m > n) {
      m = n;
    }
    m = (m - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
    setIconMarginLeftRight(m);
    setRowMarginLeftRight((int)(m * 6 / 5.5F));
    e();
  }
  
  private int a(List<ShareActionSheetBuilder.ActionSheetItem> paramList, TextView paramTextView)
  {
    paramTextView.setText(a(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.f, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private String a()
  {
    ShareActionSheetV2.Param localParam = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param;
    if ((localParam != null) && (localParam.reportDataR2 > 0)) {
      return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.reportDataR2);
    }
    return "";
  }
  
  private void a()
  {
    Object localObject2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = b();
    }
    localObject2 = new StringBuilder();
    List[] arrayOfList = a();
    if (arrayOfList.length > 0)
    {
      int m = 0;
      while (m < arrayOfList[0].size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)arrayOfList[0].get(m);
        if (m != 0) {
          ((StringBuilder)localObject2).append(';');
        }
        ((StringBuilder)localObject2).append(localActionSheetItem.reportID);
        m += 1;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, a(), "", (String)localObject1, ((StringBuilder)localObject2).toString());
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
    String str2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = b();
    }
    if (paramActionSheetItem.action == 73)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, a(), "", str1, "");
      return;
    }
    if (paramActionSheetItem.action == 72)
    {
      ReportController.b(null, "dc00898", "", paramActionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, a(), "", str1, paramActionSheetItem.reportID);
      return;
    }
    if (paramInt == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, a(), "", str1, paramActionSheetItem.reportID);
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, a(), "", str1, paramActionSheetItem.reportID);
    }
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    int m = 0;
    while (m < this.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
    {
      paramString2 = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(m).getTag();
      if ((paramString2 != null) && ((paramString2 instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder)))
      {
        paramString2 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramString2;
        if (TextUtils.equals(paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uin))
        {
          paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramBitmap);
          paramString2.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        }
      }
      m += 1;
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
        this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
        break label33;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        label33:
        this.jdField_a_of_type_AndroidViewView = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
      }
    }
  }
  
  private boolean a()
  {
    if (this.j != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
      }
      return false;
    }
    return true;
  }
  
  private String b()
  {
    if (!TextUtils.isEmpty(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("url"))) {
      return "biz_src_general_url";
    }
    return "";
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy() called #this = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int n = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(m);
        localObject = (INonMainProcAvatarLoader)this.jdField_a_of_type_AndroidUtilSparseArray.get(n);
        if (localObject != null) {
          ((INonMainProcAvatarLoader)localObject).b();
        }
        m += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    c();
  }
  
  private void c()
  {
    ResultReceiver localResultReceiver = this.jdField_a_of_type_AndroidOsResultReceiver;
    if (localResultReceiver != null)
    {
      localResultReceiver.send(1, new Bundle());
      this.jdField_a_of_type_AndroidOsResultReceiver = null;
    }
  }
  
  private void d()
  {
    ((Application)this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void e()
  {
    ((Application)this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void f()
  {
    try
    {
      if (!isShowing())
      {
        if (this.jdField_d_of_type_Boolean) {
          NavigationBarUtil.b(getWindow());
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        if (this.jdField_d_of_type_Boolean)
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
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.fullScreen)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_AndroidContentContext, null));
    }
    else
    {
      int m = 2131558465;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        m = 2131558466;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, m, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.lp));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ShareActionSheetV2.7(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    Window localWindow = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
    localWindow.setDimAmount(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.dimAmount);
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.canceledOnTouchOutside);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
      localWindow.setLayout(-1, -2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
      localWindow.setFlags(32, 32);
    }
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void h()
  {
    c();
    Object localObject = new Intent();
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (localIntent != null) {
      localObject = localIntent;
    }
    ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
    ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
    ((Intent)localObject).putExtra("caller_name", this.jdField_a_of_type_AndroidContentContext.getClass().getSimpleName());
    ((Intent)localObject).putExtra("forward_source_business_type", -1);
    ((Intent)localObject).putExtra("key_req", 2);
    ((Intent)localObject).putExtra("PARAM_ActivityResultReceiver", new ShareActionSheetV2.MyResultReceiver(this));
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
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
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558907, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager.a((RelativeLayout)localView.findViewById(2131362261));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131361997);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361996));
    if (QQTheme.a())
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850046);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130850046);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361994));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_JavaLangCharSequence;
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    else
    {
      hideTitle();
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377007));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377008));
    this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377009));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361985));
    Object localObject1 = a();
    Object localObject3;
    if (localObject1.length > 0) {
      localObject3 = this.jdField_a_of_type_JavaUtilList;
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
    Object localObject4 = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558905, null);
    ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.f, -2));
    int m = a((List)localObject3, (TextView)localObject4);
    int n = a((List)localObject2, (TextView)localObject4);
    int i1 = a((List)localObject1, (TextView)localObject4);
    n = Math.max(Math.max(m, n), i1);
    i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296795);
    int i2;
    int i3;
    if (bool1)
    {
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367810));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject3).iterator();
      m = 0;
      while (((Iterator)localObject4).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility == 0) {
          m += 1;
        }
      }
      i2 = this.e + getIconWidth() + this.e;
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i2);
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      GridView localGridView = this.jdField_a_of_type_AndroidWidgetGridView;
      localGridView.setPadding(this.i, localGridView.getPaddingTop(), this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
      i3 = this.i;
      ((ViewGroup.LayoutParams)localObject4).width = (m * i2 + i3 + i3);
      this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_d_of_type_Int + this.g + n + i1);
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject3, this));
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    if (bool2)
    {
      this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367811));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject3 = ((List)localObject2).iterator();
      m = 0;
      while (((Iterator)localObject3).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject3).next()).visibility == 0) {
          m += 1;
        }
      }
      i2 = this.e + getIconWidth() + this.e;
      this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(i2);
      this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject3 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
      localObject4 = this.jdField_b_of_type_AndroidWidgetGridView;
      ((GridView)localObject4).setPadding(this.i, ((GridView)localObject4).getPaddingTop(), this.i, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
      i3 = this.i;
      ((ViewGroup.LayoutParams)localObject3).width = (m * i2 + i3 + i3);
      this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject3).width;
      ((ViewGroup.LayoutParams)localObject3).height = (this.jdField_d_of_type_Int + this.g + n + i1);
      this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject2, this));
      this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    if (bool3)
    {
      this.jdField_c_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367812));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      this.jdField_c_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
      localObject2 = ((List)localObject1).iterator();
      m = 0;
      while (((Iterator)localObject2).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility == 0) {
          m += 1;
        }
      }
      i2 = this.e + getIconWidth() + this.e;
      this.jdField_c_of_type_AndroidWidgetGridView.setColumnWidth(i2);
      this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject2 = this.jdField_c_of_type_AndroidWidgetGridView.getLayoutParams();
      localObject3 = this.jdField_c_of_type_AndroidWidgetGridView;
      ((GridView)localObject3).setPadding(this.i, ((GridView)localObject3).getPaddingTop(), this.i, this.jdField_c_of_type_AndroidWidgetGridView.getPaddingBottom());
      i3 = this.i;
      ((ViewGroup.LayoutParams)localObject2).width = (i2 * m + i3 + i3);
      this.jdField_c_of_type_Int = ((ViewGroup.LayoutParams)localObject2).width;
      ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_d_of_type_Int + this.g + n + i1);
      this.jdField_c_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
      this.jdField_c_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject1, this));
      this.jdField_c_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_c_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361986));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ShareActionSheetV2.8(this));
    if ((!bool1) || (this.j == 8)) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    if ((!bool2) || (this.k == 8)) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    if ((!bool3) || (this.l == 8)) {
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    localView.post(new ShareActionSheetV2.9(this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$IShareActionSheetV2BottomBar;
    if (localObject1 != null)
    {
      localObject1 = ((ShareActionSheet.IShareActionSheetV2BottomBar)localObject1).b();
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
    }
    return localView;
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int m = 0;
    while (m < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(m)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      m += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    List[] arrayOfList = this.jdField_a_of_type_ArrayOfJavaUtilList;
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
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
    return this.jdField_a_of_type_ComTencentWidgetActionSheet;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public int getIconWidth()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String getOpenSource()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Window getWindow()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet == null) {
      return null;
    }
    return localActionSheet.getWindow();
  }
  
  public void hideTitle()
  {
    this.jdField_b_of_type_Boolean = false;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    return (localActionSheet != null) && (localActionSheet.isShowing());
  }
  
  public void onConfigurationChanged()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (!isShowing()) {
        return;
      }
      int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.i;
      a(this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_a_of_type_Int);
      a(this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_b_of_type_Int);
      a(this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_c_of_type_Int);
    }
  }
  
  public void refresh()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet == null) {
      return;
    }
    if (localActionSheet.isShowing())
    {
      this.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    setActionSheetItems(new ArrayList[] { (ArrayList)paramList1, (ArrayList)paramList2 });
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    paramCharSequence = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramCharSequence != null) {
      paramCharSequence.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$IShareActionSheetV2BottomBar = paramIShareActionSheetV2BottomBar;
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
    this.jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener = paramOnCancelListener;
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.e = paramInt;
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
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_b_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void setOpenSource(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
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
    if ((!this.jdField_c_of_type_Boolean) && (!isShowing()))
    {
      this.jdField_c_of_type_Boolean = true;
      if (a())
      {
        h();
        return;
      }
      g();
      f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */