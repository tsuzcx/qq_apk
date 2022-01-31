package com.tencent.mobileqq.widget.share;

import ajsf;
import alxg;
import alxk;
import android.annotation.TargetApi;
import android.app.Activity;
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
import axmt;
import axqw;
import bbje;
import bbjh;
import bcuq;
import bcur;
import bcuw;
import bcux;
import bcuy;
import bcuz;
import bcva;
import bcvb;
import bcvc;
import bcvd;
import bcvf;
import bcvg;
import bfol;
import bfoy;
import bfwa;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wsu;

public class ShareActionSheetV2
  implements bcuq
{
  protected int a;
  private alxk jdField_a_of_type_Alxk = new bcux(this);
  public Context a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new bcva(this);
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new bcuy(this);
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = new bcuz(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private SparseArray<alxg> jdField_a_of_type_AndroidUtilSparseArray;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  public GridView a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private bcur jdField_a_of_type_Bcur;
  protected bcvf a;
  private final bcvg jdField_a_of_type_Bcvg;
  public bfol a;
  protected ElasticHorScrView a;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected List<bbje> a;
  protected boolean a;
  protected List<bbje>[] a;
  protected int b;
  private DialogInterface.OnCancelListener jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener;
  private DialogInterface.OnDismissListener jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener;
  private DialogInterface.OnShowListener jdField_b_of_type_AndroidContentDialogInterface$OnShowListener;
  public GridView b;
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
  
  public ShareActionSheetV2(bcvg parambcvg)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bcuw(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bcvg = parambcvg;
    this.jdField_a_of_type_AndroidContentContext = parambcvg.jdField_a_of_type_AndroidContentContext;
    parambcvg = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_d_of_type_Int = parambcvg.getDimensionPixelSize(2131296669);
    this.f = this.jdField_d_of_type_Int;
    this.g = parambcvg.getDimensionPixelOffset(2131296671);
    this.h = parambcvg.getDimensionPixelOffset(2131296672);
    this.jdField_a_of_type_Bcvf = new bcvf();
    int m = parambcvg.getDisplayMetrics().widthPixels;
    int n = parambcvg.getDisplayMetrics().heightPixels;
    if (m > n) {
      m = n;
    }
    for (;;)
    {
      m = (m - (int)(a() * 5.2F)) / (((int)5.2F + 1) * 2);
      c(m);
      b((int)(m * 6 / 5.5F));
      return;
    }
  }
  
  private int a(List<bbje> paramList, TextView paramTextView)
  {
    paramTextView.setText(a(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.f, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private void a(bbje parambbje, int paramInt)
  {
    String str = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    if (parambbje.jdField_c_of_type_Int == 73) {
      axqw.b(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, "", "", str, "");
    }
    do
    {
      return;
      if (parambbje.jdField_c_of_type_Int == 72)
      {
        axqw.b(null, "dc00898", "", parambbje.jdField_c_of_type_JavaLangString, "0X800AB3E", "0X800AB3E", 0, 0, "", "", str, parambbje.jdField_d_of_type_JavaLangString);
        return;
      }
      if (paramInt == 1)
      {
        axqw.b(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, "", "", str, parambbje.jdField_d_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 2);
    axqw.b(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, "", "", str, parambbje.jdField_d_of_type_JavaLangString);
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
        if ((paramString2 instanceof bbjh))
        {
          paramString2 = (bbjh)paramString2;
          if (TextUtils.equals(paramString1, paramString2.jdField_a_of_type_Bbje.jdField_c_of_type_JavaLangString))
          {
            paramString2.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramBitmap);
            paramString2.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString2.jdField_a_of_type_Bbje.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
      paramArrayList = bbje.a(73);
      paramArrayList.jdField_b_of_type_Boolean = false;
      localObject1 = BaseApplicationImpl.getApplication().getResources();
      if (!axmt.a()) {
        break label135;
      }
    }
    label135:
    for (paramArrayList.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Resources)localObject1).getDrawable(2130848641);; paramArrayList.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Resources)localObject1).getDrawable(2130848640))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
      m();
      l();
      return;
    }
    label150:
    Object localObject2 = (ResultRecord)paramArrayList.get(m);
    Object localObject1 = bbje.a(72);
    ((bbje)localObject1).jdField_a_of_type_JavaLangString = ((ResultRecord)localObject2).jdField_b_of_type_JavaLangString;
    ((bbje)localObject1).jdField_c_of_type_JavaLangString = ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString;
    ((bbje)localObject1).f = ((ResultRecord)localObject2).jdField_a_of_type_Int;
    ((bbje)localObject1).jdField_b_of_type_Boolean = false;
    Object localObject3 = new StringBuilder().append("isNewTroop=");
    int n;
    if (((ResultRecord)localObject2).jdField_a_of_type_Boolean)
    {
      n = 1;
      label228:
      ((bbje)localObject1).jdField_b_of_type_JavaLangString = n;
      if ((6000 == ((bbje)localObject1).f) && (TextUtils.equals(ajsf.z, ((bbje)localObject1).jdField_c_of_type_JavaLangString)))
      {
        localObject2 = bbje.a(26);
        ((bbje)localObject1).jdField_a_of_type_JavaLangString = ((bbje)localObject2).jdField_a_of_type_JavaLangString;
        ((bbje)localObject1).jdField_d_of_type_JavaLangString = ((bbje)localObject2).jdField_d_of_type_JavaLangString;
        ((bbje)localObject1).jdField_b_of_type_Boolean = false;
        ((bbje)localObject1).jdField_b_of_type_Int = 2130843408;
        if (axmt.a()) {
          ((bbje)localObject1).jdField_b_of_type_Int = 2130843407;
        }
        if (bfwa.a())
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
        localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), ((bbje)localObject1).jdField_b_of_type_Int).copy(Bitmap.Config.ARGB_8888, true);
        localCanvas = new Canvas((Bitmap)localObject3);
        if (!axmt.a()) {
          continue;
        }
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), 10.0F, 10.0F, (Paint)localObject2);
        ((bbje)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject3);
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
  
  private void b(boolean paramBoolean)
  {
    a(null);
    if (a())
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Bfol.e();
          this.jdField_a_of_type_AndroidViewView = null;
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
        }
        this.jdField_a_of_type_Bfol.dismiss();
      }
    }
  }
  
  private boolean b()
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
  
  private void i()
  {
    String str = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getStringExtra("big_brother_source_key");
    StringBuilder localStringBuilder = new StringBuilder();
    List[] arrayOfList = a();
    if (arrayOfList.length > 0)
    {
      int m = 0;
      while (m < arrayOfList[0].size())
      {
        bbje localbbje = (bbje)arrayOfList[0].get(m);
        if (m != 0) {
          localStringBuilder.append(';');
        }
        localStringBuilder.append(localbbje.jdField_d_of_type_JavaLangString);
        m += 1;
      }
    }
    axqw.b(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, "", "", str, localStringBuilder.toString());
  }
  
  private void j()
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
        alxg localalxg = (alxg)this.jdField_a_of_type_AndroidUtilSparseArray.get(n);
        if (localalxg != null) {
          localalxg.b();
        }
        m += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    k();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, new Bundle());
      this.jdField_a_of_type_AndroidOsResultReceiver = null;
    }
  }
  
  private void l()
  {
    try
    {
      if (!a())
      {
        if (this.jdField_d_of_type_Boolean) {
          wsu.b(a());
        }
        this.jdField_a_of_type_Bfol.show();
        if (this.jdField_d_of_type_Boolean)
        {
          wsu.a(a());
          wsu.c(a());
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
  
  private void m()
  {
    if (this.jdField_a_of_type_Bcvg.jdField_a_of_type_Boolean) {}
    int m;
    for (this.jdField_a_of_type_Bfol = ((bfol)bfoy.b(this.jdField_a_of_type_AndroidContentContext, null));; this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null, m, this.jdField_a_of_type_Bcvg.jdField_a_of_type_AndroidViewViewGroup$LayoutParams)))
    {
      this.jdField_a_of_type_Bfol.setOnShowListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener);
      this.jdField_a_of_type_Bfol.a(new bcvb(this));
      this.jdField_a_of_type_Bfol.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidViewView = a();
      }
      this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_AndroidViewView, null);
      Window localWindow = this.jdField_a_of_type_Bfol.getWindow();
      localWindow.setDimAmount(this.jdField_a_of_type_Bcvg.jdField_a_of_type_Float);
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -1);
      this.jdField_a_of_type_Bfol.c(this.jdField_a_of_type_Bcvg.jdField_c_of_type_Boolean);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (this.jdField_a_of_type_Bcvg.jdField_b_of_type_Boolean) {
        localWindow.setLayout(-1, -2);
      }
      if (this.jdField_a_of_type_Bcvg.jdField_b_of_type_Boolean) {
        localWindow.setFlags(32, 32);
      }
      localWindow.setAttributes(localLayoutParams);
      return;
      m = 2131558431;
      if (this.jdField_a_of_type_Bcvg.jdField_b_of_type_Boolean) {
        m = 2131558432;
      }
    }
  }
  
  private void n()
  {
    k();
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
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @TargetApi(9)
  protected View a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "createViewFlipper() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558830, null);
    this.jdField_a_of_type_Bcvf.a((RelativeLayout)localView.findViewById(2131362137));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361921));
    if (bfwa.a()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848643);
    }
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361919));
    Object localObject3;
    Object localObject1;
    label219:
    Object localObject2;
    label243:
    Object localObject4;
    label268:
    int m;
    int i3;
    int i4;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375661));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375662));
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375663));
      localObject3 = a();
      if (localObject3.length <= 0) {
        break label461;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if (((List)localObject1).isEmpty()) {
        n = 0;
      }
      if (localObject3.length <= 0) {
        break label474;
      }
      localObject2 = localObject3[0];
      if (((List)localObject2).isEmpty()) {
        i1 = 0;
      }
      if (localObject3.length <= 1) {
        break label487;
      }
      localObject3 = localObject3[1];
      if (((List)localObject3).isEmpty()) {
        i2 = 0;
      }
      localObject4 = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558828, null);
      ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.f, -2));
      m = a((List)localObject1, (TextView)localObject4);
      i3 = a((List)localObject2, (TextView)localObject4);
      i4 = a((List)localObject3, (TextView)localObject4);
      i3 = Math.max(Math.max(m, i3), i4);
      i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296668);
      if (n == 0) {
        break label675;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367167));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      m = 0;
      label421:
      if (!((Iterator)localObject4).hasNext()) {
        break label500;
      }
      if (((bbje)((Iterator)localObject4).next()).jdField_d_of_type_Int != 0) {
        break label1320;
      }
      m += 1;
    }
    label675:
    label1317:
    label1320:
    for (;;)
    {
      break label421;
      f();
      break;
      label461:
      localObject1 = new ArrayList(0);
      break label219;
      label474:
      localObject2 = new ArrayList(0);
      break label243;
      label487:
      localObject3 = new ArrayList(0);
      break label268;
      label500:
      int i5 = this.e + a() + this.e;
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i5);
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(m);
      localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (i5 * m + this.i + this.i);
      this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new bcvd(this.jdField_a_of_type_AndroidContentContext, (List)localObject1, this));
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      if (i1 != 0)
      {
        this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367168));
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        }
        localObject1 = ((List)localObject2).iterator();
        m = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((bbje)((Iterator)localObject1).next()).jdField_d_of_type_Int != 0) {
            break label1317;
          }
          m += 1;
        }
      }
      for (;;)
      {
        break;
        i5 = this.e + a() + this.e;
        this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(i5);
        this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(m);
        localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
        this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
        ((ViewGroup.LayoutParams)localObject1).width = (i5 * m + this.i + this.i);
        this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
        this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new bcvd(this.jdField_a_of_type_AndroidContentContext, (List)localObject2, this));
        this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
        this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        if (i2 != 0)
        {
          this.jdField_c_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367169));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          this.jdField_c_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
          localObject1 = ((List)localObject3).iterator();
          m = 0;
          if (((Iterator)localObject1).hasNext())
          {
            if (((bbje)((Iterator)localObject1).next()).jdField_d_of_type_Int != 0) {
              break label1314;
            }
            m += 1;
          }
        }
        for (;;)
        {
          break;
          i5 = this.e + a() + this.e;
          this.jdField_c_of_type_AndroidWidgetGridView.setColumnWidth(i5);
          this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
          localObject1 = this.jdField_c_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_c_of_type_AndroidWidgetGridView.setPadding(this.i, this.jdField_c_of_type_AndroidWidgetGridView.getPaddingTop(), this.i, this.jdField_c_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject1).width = (i5 * m + this.i + this.i);
          this.jdField_c_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_d_of_type_Int + this.g + i3 + i4);
          this.jdField_c_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_c_of_type_AndroidWidgetGridView.setNumColumns(m);
          this.jdField_c_of_type_AndroidWidgetGridView.setAdapter(new bcvd(this.jdField_a_of_type_AndroidContentContext, (List)localObject3, this));
          this.jdField_c_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_c_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361912));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bcvc(this));
          if ((n == 0) || (this.j == 8)) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((i1 == 0) || (this.k == 8)) {
            this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((i2 == 0) || (this.l == 8)) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          localView.post(new ShareActionSheetV2.8(this));
          return localView;
        }
      }
    }
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_Bfol == null) {}
    Window localWindow;
    do
    {
      return null;
      localWindow = this.jdField_a_of_type_Bfol.getWindow();
    } while (localWindow == null);
    return localWindow.findViewById(paramInt);
  }
  
  public Window a()
  {
    if (this.jdField_a_of_type_Bfol == null) {
      return null;
    }
    return this.jdField_a_of_type_Bfol.getWindow();
  }
  
  public bfol a()
  {
    return this.jdField_a_of_type_Bfol;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<bbje> paramList)
  {
    Object localObject = "";
    int m = 0;
    if (m < paramList.size())
    {
      String str = ((bbje)paramList.get(m)).jdField_a_of_type_JavaLangString;
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "show() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.jdField_c_of_type_Boolean) || (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "show() isShowing #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (b())
    {
      n();
      return;
    }
    m();
    l();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setCancelListener() called with: listener = [" + paramOnCancelListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_b_of_type_AndroidContentDialogInterface$OnCancelListener = paramOnCancelListener;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setOnDismissListener() called with: dismissListener = [" + paramOnDismissListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_b_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setIntentForStartForwardRecentActivity() called with: intent = [" + paramIntent + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_Bcvf.a(paramView, paramLayoutParams);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void a(bcur parambcur)
  {
    this.jdField_a_of_type_Bcur = parambcur;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<bbje> paramList1, List<bbje> paramList2)
  {
    a(new ArrayList[] { (ArrayList)paramList1, (ArrayList)paramList2 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<bbje>[] paramArrayOfList)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing());
  }
  
  public List<bbje>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismiss() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    b(false);
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismissImmediately() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    b(true);
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Bcvf.a(paramInt);
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (!a())) {
      return;
    }
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.i;
    a(this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_a_of_type_Int);
    a(this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_b_of_type_Int);
    a(this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView, m, this.jdField_c_of_type_Int);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bfol == null) {}
    while (!this.jdField_a_of_type_Bfol.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_AndroidViewView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */