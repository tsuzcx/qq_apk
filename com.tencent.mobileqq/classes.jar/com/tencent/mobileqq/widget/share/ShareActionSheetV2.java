package com.tencent.mobileqq.widget.share;

import aljq;
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
import anoe;
import anoi;
import azib;
import azmj;
import bdip;
import beuj;
import beun;
import beuo;
import beup;
import beuq;
import beur;
import beus;
import beut;
import beuu;
import beuv;
import beux;
import bhpy;
import bhql;
import bhxo;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yhj;

public class ShareActionSheetV2
  implements ShareActionSheet
{
  protected int a;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new beup(this);
  public Context a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new beus(this);
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new beuq(this);
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = new beur(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private SparseArray<anoe> jdField_a_of_type_AndroidUtilSparseArray;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  public GridView a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private anoi jdField_a_of_type_Anoi = new beuo(this);
  private beuj jdField_a_of_type_Beuj;
  protected beux a;
  public bhpy a;
  protected ElasticHorScrView a;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  private final ShareActionSheetV2.Param jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected List<ShareActionSheetBuilder.ActionSheetItem> a;
  protected boolean a;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a;
  protected int b;
  private DialogInterface.OnCancelListener jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener;
  private DialogInterface.OnDismissListener jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener;
  private DialogInterface.OnShowListener jdField_b_of_type_AndroidContentDialogInterface$OnShowListener;
  public GridView b;
  protected LinearLayout b;
  protected ElasticHorScrView b;
  protected boolean b;
  protected int c;
  public GridView c;
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
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new beun(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param = paramParam;
    this.jdField_a_of_type_AndroidContentContext = paramParam.context;
    paramParam = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_d_of_type_Int = paramParam.getDimensionPixelSize(2131296685);
    this.f = this.jdField_d_of_type_Int;
    this.g = paramParam.getDimensionPixelOffset(2131296687);
    this.h = paramParam.getDimensionPixelOffset(2131296688);
    this.jdField_a_of_type_Beux = new beux();
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
    String str = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    StringBuilder localStringBuilder = new StringBuilder();
    List[] arrayOfList = a();
    if (arrayOfList.length > 0)
    {
      int m = 0;
      while (m < arrayOfList[0].size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)arrayOfList[0].get(m);
        if (m != 0) {
          localStringBuilder.append(';');
        }
        localStringBuilder.append(localActionSheetItem.reportID);
        m += 1;
      }
    }
    azmj.b(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, a(), "", str, localStringBuilder.toString());
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
    String str = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    if (paramActionSheetItem.action == 73) {
      azmj.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, a(), "", str, "");
    }
    do
    {
      return;
      if (paramActionSheetItem.action == 72)
      {
        azmj.b(null, "dc00898", "", paramActionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, a(), "", str, paramActionSheetItem.reportID);
        return;
      }
      if (paramInt == 1)
      {
        azmj.b(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, a(), "", str, paramActionSheetItem.reportID);
        return;
      }
    } while (paramInt != 2);
    azmj.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, a(), "", str, paramActionSheetItem.reportID);
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
        if ((paramString2 instanceof bdip))
        {
          paramString2 = (bdip)paramString2;
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
      if (!azib.a()) {
        break label135;
      }
    }
    label135:
    for (paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130849079);; paramArrayList.iconDrawable = ((Resources)localObject1).getDrawable(2130849078))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
      g();
      f();
      return;
    }
    label150:
    Object localObject2 = (ResultRecord)paramArrayList.get(m);
    Object localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(72);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ResultRecord)localObject2).b;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin = ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType = ((ResultRecord)localObject2).jdField_a_of_type_Int;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
    Object localObject3 = new StringBuilder().append("isNewTroop=");
    int n;
    if (((ResultRecord)localObject2).jdField_a_of_type_Boolean)
    {
      n = 1;
      label228:
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = n;
      if ((6000 == ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uinType) && (TextUtils.equals(aljq.z, ((ShareActionSheetBuilder.ActionSheetItem)localObject1).uin)))
      {
        localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(26);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).reportID = ((ShareActionSheetBuilder.ActionSheetItem)localObject2).reportID;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = false;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843762;
        if (azib.a()) {
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843761;
        }
        if (bhxo.a())
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          ((Paint)localObject2).setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon).copy(Bitmap.Config.ARGB_8888, true);
        localCanvas = new Canvas((Bitmap)localObject3);
        if (!azib.a()) {
          continue;
        }
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), 10.0F, 10.0F, (Paint)localObject2);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconDrawable = new BitmapDrawable((Bitmap)localObject3);
      }
      catch (Throwable localThrowable)
      {
        Canvas localCanvas;
        QLog.e("ShareActionSheetV2", 1, "onRecentUserChanged: no night mode mask", localThrowable);
        continue;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      m += 1;
      break;
      n = 0;
      break label228;
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
          this.jdField_a_of_type_Bhpy.e();
          this.jdField_a_of_type_AndroidViewView = null;
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
        }
        this.jdField_a_of_type_Bhpy.dismiss();
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
        anoe localanoe = (anoe)this.jdField_a_of_type_AndroidUtilSparseArray.get(n);
        if (localanoe != null) {
          localanoe.b();
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
          yhj.b(getWindow());
        }
        this.jdField_a_of_type_Bhpy.show();
        if (this.jdField_d_of_type_Boolean)
        {
          yhj.a(getWindow());
          yhj.c(getWindow());
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
    for (this.jdField_a_of_type_Bhpy = ((bhpy)bhql.b(this.jdField_a_of_type_AndroidContentContext, null));; this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null, m, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.lp)))
    {
      this.jdField_a_of_type_Bhpy.setOnShowListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener);
      this.jdField_a_of_type_Bhpy.a(new beut(this));
      this.jdField_a_of_type_Bhpy.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidViewView = a();
      }
      this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_AndroidViewView, null);
      Window localWindow = this.jdField_a_of_type_Bhpy.getWindow();
      localWindow.setDimAmount(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.dimAmount);
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -1);
      this.jdField_a_of_type_Bhpy.c(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.canceledOnTouchOutside);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        localWindow.setLayout(-1, -2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        localWindow.setFlags(32, 32);
      }
      localWindow.setAttributes(localLayoutParams);
      return;
      m = 2131558431;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        m = 2131558432;
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
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558866, null);
    this.jdField_a_of_type_Beux.a((RelativeLayout)localView.findViewById(2131362143));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361922));
    if (bhxo.a()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849081);
    }
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361920));
    Object localObject3;
    Object localObject1;
    label234:
    Object localObject2;
    label258:
    label283:
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
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376155));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376156));
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376158));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361911));
      localObject3 = a();
      if (localObject3.length <= 0) {
        break label476;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if (((List)localObject1).isEmpty()) {
        n = 0;
      }
      if (localObject3.length <= 0) {
        break label489;
      }
      localObject2 = localObject3[0];
      if (((List)localObject2).isEmpty()) {
        i1 = 0;
      }
      if (localObject3.length <= 1) {
        break label502;
      }
      localObject3 = localObject3[1];
      if (((List)localObject3).isEmpty()) {
        i2 = 0;
      }
      localObject4 = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558864, null);
      ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.f, -2));
      m = a((List)localObject1, (TextView)localObject4);
      i3 = a((List)localObject2, (TextView)localObject4);
      i4 = a((List)localObject3, (TextView)localObject4);
      i3 = Math.max(Math.max(m, i3), i4);
      i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296684);
      if (n == 0) {
        break label690;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367297));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      m = 0;
      label436:
      if (!((Iterator)localObject4).hasNext()) {
        break label515;
      }
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
        break label1367;
      }
      m += 1;
    }
    label515:
    label690:
    label1361:
    label1364:
    label1367:
    for (;;)
    {
      break label436;
      hideTitle();
      break;
      label476:
      localObject1 = new ArrayList(0);
      break label234;
      label489:
      localObject2 = new ArrayList(0);
      break label258;
      label502:
      localObject3 = new ArrayList(0);
      break label283;
      int i5 = this.e + getIconWidth() + this.e;
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i5);
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (i5 * m + this.i + this.i);
      this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new beuv(this.jdField_a_of_type_AndroidContentContext, (List)localObject1, this));
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      if (i1 != 0)
      {
        this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367298));
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        }
        localObject1 = ((List)localObject2).iterator();
        m = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
            break label1364;
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
        this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new beuv(this.jdField_a_of_type_AndroidContentContext, (List)localObject2, this));
        this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
        this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        if (i2 != 0)
        {
          this.jdField_c_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367299));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          this.jdField_c_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
          localObject1 = ((List)localObject3).iterator();
          m = 0;
          if (((Iterator)localObject1).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
              break label1361;
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
          this.jdField_c_of_type_AndroidWidgetGridView.setAdapter(new beuv(this.jdField_a_of_type_AndroidContentContext, (List)localObject3, this));
          this.jdField_c_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_c_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361912));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new beuu(this));
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
          if (this.jdField_a_of_type_Beuj != null)
          {
            localObject1 = this.jdField_a_of_type_Beuj.b();
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
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
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
    if (this.jdField_a_of_type_Bhpy == null) {}
    Window localWindow;
    do
    {
      return null;
      localWindow = this.jdField_a_of_type_Bhpy.getWindow();
    } while (localWindow == null);
    return localWindow.findViewById(paramInt);
  }
  
  public bhpy getActionSheet()
  {
    return this.jdField_a_of_type_Bhpy;
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
    if (this.jdField_a_of_type_Bhpy == null) {
      return null;
    }
    return this.jdField_a_of_type_Bhpy.getWindow();
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
    return (this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing());
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
    if (this.jdField_a_of_type_Bhpy == null) {}
    while (!this.jdField_a_of_type_Bhpy.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_AndroidViewView, null);
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
    this.jdField_a_of_type_Beux.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_Beux.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(beuj parambeuj)
  {
    this.jdField_a_of_type_Beuj = parambeuj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */