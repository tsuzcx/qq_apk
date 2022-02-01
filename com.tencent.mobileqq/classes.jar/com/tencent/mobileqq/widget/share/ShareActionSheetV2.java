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
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ThemeImageWrapper;
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
    this.jdField_d_of_type_Int = paramParam.getDimensionPixelSize(2131296816);
    this.f = this.jdField_d_of_type_Int;
    this.g = paramParam.getDimensionPixelOffset(2131296818);
    this.h = paramParam.getDimensionPixelOffset(2131296819);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager = new ShareActionSheetV2.AdViewManager();
    int m = paramParam.getDisplayMetrics().widthPixels;
    int n = paramParam.getDisplayMetrics().heightPixels;
    if (m > n) {
      m = n;
    }
    for (;;)
    {
      m = (m - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
      setIconMarginLeftRight(m);
      setRowMarginLeftRight((int)(m * 6 / 5.5F));
      e();
      return;
    }
  }
  
  private int a(List<ShareActionSheetBuilder.ActionSheetItem> paramList, TextView paramTextView)
  {
    paramTextView.setText(a(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.f, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.reportDataR2 > 0)) {
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
    if (paramActionSheetItem.action == 73) {
      ReportController.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, a(), "", str1, "");
    }
    do
    {
      return;
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
    } while (paramInt != 2);
    ReportController.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, a(), "", str1, paramActionSheetItem.reportID);
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    int m = 0;
    if (m < this.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
    {
      paramString2 = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(m).getTag();
      if (paramString2 == null) {}
      for (;;)
      {
        m += 1;
        break;
        if ((paramString2 instanceof ShareActionSheetBuilder.ActionSheetItemViewHolder))
        {
          paramString2 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramString2;
          if (TextUtils.equals(paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uin))
          {
            paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramBitmap);
            paramString2.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString2.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onRecentUserChanged() called with: recentUsers = [" + paramArrayList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    int m = 0;
    if ((paramArrayList != null) && (m < paramArrayList.size()))
    {
      if (m < 15) {
        break label150;
      }
      paramArrayList = ShareActionSheetBuilder.ActionSheetItem.build(73);
      paramArrayList.iconNeedBg = false;
      localObject1 = BaseApplicationImpl.getApplication().getResources();
      if (!QQTheme.e()) {
        break label135;
      }
    }
    label135:
    for (paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130850118);; paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130850117))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
      g();
      f();
      return;
    }
    label150:
    Object localObject2 = (ResultRecord)paramArrayList.get(m);
    Object localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(72);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ResultRecord)localObject2).name;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin = ((ResultRecord)localObject2).uin;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType = ((ResultRecord)localObject2).type;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
    Object localObject3 = new StringBuilder().append("isNewTroop=");
    if (((ResultRecord)localObject2).isNewTroop) {}
    for (int n = 1;; n = 0)
    {
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = n;
      if ((6000 != ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType) || (!TextUtils.equals(AppConstants.DATALINE_PC_UIN, ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin))) {
        break label493;
      }
      if ((!(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.context instanceof PublicTransFragmentActivity)) || (!((PublicTransFragmentActivity)this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.context).getIntent().getStringExtra("public_fragment_class").contains("AIOEmotionFragment"))) {
        break label320;
      }
      m += 1;
      break;
    }
    label320:
    localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(26);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).reportID = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).reportID;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844376;
    if (QQTheme.e()) {
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844375;
    }
    if (ThemeImageWrapper.isNightMode())
    {
      localObject2 = new Paint();
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
    }
    for (;;)
    {
      try
      {
        localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon).copy(Bitmap.Config.ARGB_8888, true);
        localCanvas = new Canvas((Bitmap)localObject3);
        if (!QQTheme.e()) {
          continue;
        }
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), 10.0F, 10.0F, (Paint)localObject2);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconDrawable = new BitmapDrawable((Bitmap)localObject3);
      }
      catch (Throwable localThrowable)
      {
        Canvas localCanvas;
        label493:
        QLog.e("ShareActionSheetV2", 1, "onRecentUserChanged: no night mode mask", localThrowable);
        continue;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      break;
      localCanvas.drawCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, localCanvas.getWidth() / 2, (Paint)localObject2);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    setOpenSource(null);
    if (isShowing())
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
          this.jdField_a_of_type_AndroidViewView = null;
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
    }
  }
  
  private boolean a()
  {
    if (this.j != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
      }
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
    return false;
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
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDestroy() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int n = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(m);
        INonMainProcAvatarLoader localINonMainProcAvatarLoader = (INonMainProcAvatarLoader)this.jdField_a_of_type_AndroidUtilSparseArray.get(n);
        if (localINonMainProcAvatarLoader != null) {
          localINonMainProcAvatarLoader.b();
        }
        m += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, new Bundle());
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
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheetV2", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.fullScreen) {}
    int m;
    for (this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_AndroidContentContext, null));; this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, m, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.lp)))
    {
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
      return;
      m = 2131558437;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        m = 2131558438;
      }
    }
  }
  
  private void h()
  {
    c();
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      localIntent = this.jdField_a_of_type_AndroidContentIntent;
    }
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentTranslucentActivity.class);
    localIntent.putExtra("caller_name", this.jdField_a_of_type_AndroidContentContext.getClass().getSimpleName());
    localIntent.putExtra("forward_source_business_type", -1);
    localIntent.putExtra("key_req", ForwardRecentActivity.g);
    localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareActionSheetV2.MyResultReceiver(this));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
  }
  
  @TargetApi(9)
  protected View a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "createViewFlipper() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559013, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$AdViewManager.a((RelativeLayout)localView.findViewById(2131362237));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131361981);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361980));
    if (ThemeImageWrapper.isNightMode())
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850120);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130850120);
    }
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361978));
    Object localObject3;
    Object localObject1;
    label256:
    Object localObject2;
    label280:
    label305:
    Object localObject4;
    int m;
    int i3;
    int i4;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377563));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377564));
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377565));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361969));
      localObject3 = a();
      if (localObject3.length <= 0) {
        break label498;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if (((List)localObject1).isEmpty()) {
        n = 0;
      }
      if (localObject3.length <= 0) {
        break label511;
      }
      localObject2 = localObject3[0];
      if (((List)localObject2).isEmpty()) {
        i1 = 0;
      }
      if (localObject3.length <= 1) {
        break label524;
      }
      localObject3 = localObject3[1];
      if (((List)localObject3).isEmpty()) {
        i2 = 0;
      }
      localObject4 = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559011, null);
      ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.f, -2));
      m = a((List)localObject1, (TextView)localObject4);
      i3 = a((List)localObject2, (TextView)localObject4);
      i4 = a((List)localObject3, (TextView)localObject4);
      i3 = Math.max(Math.max(m, i3), i4);
      i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296815);
      if (n == 0) {
        break label712;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131368058));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      m = 0;
      label458:
      if (!((Iterator)localObject4).hasNext()) {
        break label537;
      }
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
        break label1389;
      }
      m += 1;
    }
    label524:
    label537:
    label712:
    label1383:
    label1386:
    label1389:
    for (;;)
    {
      break label458;
      hideTitle();
      break;
      label498:
      localObject1 = new ArrayList(0);
      break label256;
      label511:
      localObject2 = new ArrayList(0);
      break label280;
      localObject3 = new ArrayList(0);
      break label305;
      int i5 = this.e + getIconWidth() + this.e;
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i5);
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (i5 * m + this.i + this.i);
      this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject1, this));
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      if (i1 != 0)
      {
        this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131368059));
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        }
        localObject1 = ((List)localObject2).iterator();
        m = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
            break label1386;
          }
          m += 1;
        }
      }
      for (;;)
      {
        break;
        i5 = this.e + getIconWidth() + this.e;
        this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(i5);
        this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(m);
        localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
        this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
        ((ViewGroup.LayoutParams)localObject1).width = (i5 * m + this.i + this.i);
        this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
        this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject2, this));
        this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
        this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        if (i2 != 0)
        {
          this.jdField_c_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131368060));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          this.jdField_c_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
          localObject1 = ((List)localObject3).iterator();
          m = 0;
          if (((Iterator)localObject1).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
              break label1383;
            }
            m += 1;
          }
        }
        for (;;)
        {
          break;
          i5 = this.e + getIconWidth() + this.e;
          this.jdField_c_of_type_AndroidWidgetGridView.setColumnWidth(i5);
          this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
          localObject1 = this.jdField_c_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_c_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_c_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_c_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject1).width = (i5 * m + this.i + this.i);
          this.jdField_c_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
          this.jdField_c_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
          this.jdField_c_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetV2.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject3, this));
          this.jdField_c_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_c_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361970));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ShareActionSheetV2.8(this));
          if ((n == 0) || (this.j == 8)) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((i1 == 0) || (this.k == 8)) {
            this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((i2 == 0) || (this.l == 8)) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          localView.post(new ShareActionSheetV2.9(this));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$IShareActionSheetV2BottomBar != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$IShareActionSheetV2BottomBar.b();
            if (localObject1 != null) {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            }
          }
          return localView;
        }
      }
    }
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int m = 0;
    if (m < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(m)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      m += 1;
      break;
      return localObject;
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismiss() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    a(false);
  }
  
  public void dismissImmediately()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismissImmediately() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    a(true);
  }
  
  public View findViewById(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {}
    Window localWindow;
    do
    {
      return null;
      localWindow = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
    } while (localWindow == null);
    return localWindow.findViewById(paramInt);
  }
  
  public ActionSheet getActionSheet()
  {
    return this.jdField_a_of_type_ComTencentWidgetActionSheet;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return this.jdField_b_of_type_AndroidViewView.getHeight();
    }
    return 0;
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
  }
  
  public void hideTitle()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    return (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
  }
  
  public void onConfigurationChanged()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (!isShowing())) {
      return;
    }
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.i;
    a(this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_a_of_type_Int);
    a(this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_b_of_type_Int);
    a(this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_c_of_type_Int);
  }
  
  public void refresh()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {}
    while (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
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
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
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
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setCancelListener() called with: listener = [" + paramOnCancelListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener = paramOnCancelListener;
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setIntentForStartForwardRecentActivity() called with: intent = [" + paramIntent + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
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
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setOnDismissListener() called with: dismissListener = [" + paramOnDismissListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
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
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "show() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.jdField_c_of_type_Boolean) || (isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "show() isShowing #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (a())
    {
      h();
      return;
    }
    g();
    f();
  }
  
  public void updateUI() {}
  
  public void updateUIIfShowing() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */