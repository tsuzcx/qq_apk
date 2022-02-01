package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class KandianNegativeWindow
  extends PopupWindow
{
  public final int a;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new KandianNegativeWindow.2(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  KandianNegativeWindow.OnUninterestConfirmListener jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$OnUninterestConfirmListener;
  KandianNegativeWindow.iClickInterface jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface = new KandianNegativeWindow.4(this);
  NegativeChildrenLayout jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
  public final String a;
  ArrayList<DislikeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap(6);
  public final int b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public final String b;
  ArrayList<DislikeInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public final int c;
  View jdField_c_of_type_AndroidViewView;
  String jdField_c_of_type_JavaLangString = "";
  ArrayList<DislikeInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  public final int d;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString = "";
  ArrayList<DislikeInfo> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public final int e;
  View jdField_e_of_type_AndroidViewView;
  ArrayList<DislikeInfo> jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  public final int f;
  View jdField_f_of_type_AndroidViewView;
  ArrayList<View> jdField_f_of_type_JavaUtilArrayList = new ArrayList();
  public final int g = 3;
  int h = -1;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n = 0;
  protected int o;
  protected int p;
  protected int q;
  int r;
  
  public KandianNegativeWindow(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "KandianNegativeWindow";
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 5;
    this.jdField_e_of_type_Int = 8;
    this.jdField_f_of_type_Int = 9;
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705993);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560247, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private String a(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while ((i1 < paramArrayList.size()) && (i1 < 3))
    {
      if (!TextUtils.isEmpty(((DislikeInfo)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString))
      {
        if (i1 != 0) {
          localStringBuilder.append("、");
        }
        localStringBuilder.append(((DislikeInfo)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
    float f1 = 1.0F;
    float f2;
    Object localObject1;
    if (paramBoolean)
    {
      f1 = -1.0F;
      f2 = 1.0F;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    else
    {
      f2 = -1.0F;
      localObject1 = localObject2;
    }
    localObject2 = new TranslateAnimation(1, f2, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f1, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation((Animation)localObject2);
    ((View)localObject1).startAnimation(localTranslateAnimation);
  }
  
  private void a(Object paramObject, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("folder_status", ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).getReportFolderStatus());
      localJSONObject.put("kandian_mode", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getKanDianMode());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.q);
      localJSONObject.put("feeds_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.p);
      localStringBuilder.append("");
      localJSONObject.put("channel_id", localStringBuilder.toString());
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = "";
      }
      localJSONObject.put("rowkey", this.jdField_d_of_type_JavaLangString);
      paramObject = (DislikeInfo)paramObject;
      if (paramObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.jdField_a_of_type_Long);
        localStringBuilder.append("");
        localJSONObject.put("tag_id", localStringBuilder.toString());
        localJSONObject.put("tag_name", paramObject.jdField_a_of_type_JavaLangString);
        if (paramBoolean) {
          this.jdField_c_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
        }
      }
    }
    catch (Exception paramObject)
    {
      label243:
      break label243;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009990", "0X8009990", 0, 0, String.valueOf(this.r), "", this.jdField_c_of_type_JavaLangString, localJSONObject.toString(), false);
  }
  
  private boolean a(View paramView, int[] paramArrayOfInt)
  {
    int i3 = b();
    paramView.getLocationOnScreen(paramArrayOfInt);
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfInt[0];
    int i2 = paramArrayOfInt[1];
    boolean bool;
    if (paramArrayOfInt[1] + i3 + paramView.getHeight() <= this.j)
    {
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 8);
      setAnimationStyle(2131755041);
      bool = false;
    }
    else
    {
      setAnimationStyle(2131755044);
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 - i3 - paramView.getHeight() / 8);
      bool = true;
    }
    b(paramView, bool);
    c(paramView, bool);
    paramArrayOfInt[0] = ((this.i - this.k) / 2);
    if ((this.h > 0) && (this.j > 0) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0)) {
      i3 = this.m;
    }
    ThreadManager.executeOnSubThread(new KandianNegativeWindow.3(this, localStringBuilder, i1, i2, true));
    return true;
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = 0;
    if (arrayOfInt[0] >= this.i * 2 / 3) {
      i1 = 1;
    }
    if (paramBoolean)
    {
      if (i1 != 0) {
        i1 = 2131755043;
      } else {
        i1 = 2131755044;
      }
    }
    else if (i1 != 0) {
      i1 = 2131755040;
    } else {
      i1 = 2131755041;
    }
    setAnimationStyle(i1);
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
    if (paramBoolean) {
      localLayoutParams.addRule(12);
    } else {
      localLayoutParams.addRule(10);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i1 = localObject[0];
    int i2 = paramView.getWidth() / 2;
    int i3 = this.l;
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    if (!paramBoolean) {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = (i1 + i2 - i3 - paramView.getWidth() / 5);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    b(paramBoolean);
  }
  
  private void e()
  {
    d();
    int i1 = this.jdField_f_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      if (i1 <= 1)
      {
        ((View)this.jdField_f_of_type_JavaUtilArrayList.get(0)).setBackgroundResource(2130843061);
        return;
      }
      ((View)this.jdField_f_of_type_JavaUtilArrayList.get(0)).setBackgroundResource(2130843063);
      ((View)this.jdField_f_of_type_JavaUtilArrayList.get(i1 - 1)).setBackgroundResource(2130843062);
    }
  }
  
  protected int a()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = i2;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > i2) {
      i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
    }
    i2 = i1;
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > i1) {
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
    }
    i1 = i2;
    if (this.jdField_d_of_type_JavaUtilArrayList.size() > i2) {
      i1 = this.jdField_d_of_type_JavaUtilArrayList.size();
    }
    i2 = i1;
    if (i1 > 6) {
      i2 = 6;
    }
    return i2;
  }
  
  protected void a()
  {
    setHeight(b());
    e();
  }
  
  public void a(float paramFloat)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    b();
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    this.jdField_d_of_type_JavaLangString = paramString;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
        if (localDislikeInfo != null)
        {
          paramInt1 = localDislikeInfo.jdField_c_of_type_Int;
          if ((paramInt1 != 1) && (paramInt1 != 2))
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 == 5) {
                this.jdField_c_of_type_JavaUtilArrayList.add(localDislikeInfo);
              }
            }
            else
            {
              if (TextUtils.isEmpty(localDislikeInfo.jdField_a_of_type_JavaLangString))
              {
                String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localDislikeInfo.jdField_a_of_type_Long));
                paramString = str;
                if (str == null) {
                  paramString = "";
                }
                localDislikeInfo.jdField_a_of_type_JavaLangString = paramString;
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(localDislikeInfo);
            }
          }
          else {
            this.jdField_a_of_type_JavaUtilArrayList.add(localDislikeInfo);
          }
          paramString = new StringBuilder();
          paramString.append("dislikeInfo,");
          paramString.append(localDislikeInfo.toString());
          QLog.e("KandianNegativeWindow", 1, paramString.toString());
        }
      }
      paramInt1 = paramArrayList.size();
    }
    else
    {
      paramInt1 = 0;
    }
    paramArrayList = new DislikeInfo();
    paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramArrayList.jdField_c_of_type_Int = 9;
    paramArrayList.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaUtilArrayList.add(paramArrayList);
    paramArrayList = new DislikeInfo();
    paramArrayList.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131717940);
    paramArrayList.jdField_c_of_type_Int = 8;
    paramArrayList.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaUtilArrayList.add(paramArrayList);
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_AndroidViewView, 2130841735, HardCodeUtil.a(2131705999), true);
    a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_AndroidViewView, 2130841740, HardCodeUtil.a(2131706009), true);
    paramArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    a(paramArrayList, this.jdField_d_of_type_AndroidViewView, 2130841727, a(paramArrayList), false);
    a(this.jdField_d_of_type_JavaUtilArrayList, this.jdField_e_of_type_AndroidViewView, 2130841732, HardCodeUtil.a(2131706005), false);
    a(this.jdField_e_of_type_JavaUtilArrayList, this.jdField_f_of_type_AndroidViewView, 2130841726, BaseApplicationImpl.getContext().getString(2131717940), false);
    a();
    paramArrayList = new StringBuilder();
    paramArrayList.append("setData,size:");
    paramArrayList.append(paramInt1);
    QLog.e("KandianNegativeWindow", 1, paramArrayList.toString());
  }
  
  protected void a(int paramInt, View paramView)
  {
    if (paramInt > 0) {
      this.jdField_f_of_type_JavaUtilArrayList.add(paramView);
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371755);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371751);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371757);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371754);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131371753);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371758));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371759));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364625));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370637));
    ((ImageView)paramView.findViewById(2131366870).findViewById(2131369933)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i = ((int)DeviceInfoUtil.i());
    this.j = ((int)DeviceInfoUtil.j());
    this.l = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298867));
    this.k = (this.i - this.l * 2);
    setWidth(this.k);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365169));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(1L), HardCodeUtil.a(2131706006));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(2L), HardCodeUtil.a(2131706004));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(3L), HardCodeUtil.a(2131705995));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(4L), HardCodeUtil.a(2131705996));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(5L), HardCodeUtil.a(2131706001));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(6L), HardCodeUtil.a(2131706000));
    this.m = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298848));
    this.jdField_e_of_type_AndroidViewView.findViewById(2131377256).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    setOnDismissListener(new KandianNegativeWindow.1(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(View paramView, KandianNegativeWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    if (isShowing()) {
      dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$OnUninterestConfirmListener = paramOnUninterestConfirmListener;
    paramOnUninterestConfirmListener = new int[2];
    try
    {
      bool = a(paramView, paramOnUninterestConfirmListener);
    }
    catch (Exception localException)
    {
      boolean bool;
      label30:
      break label30;
    }
    bool = false;
    if (bool)
    {
      showAtLocation(paramView, 51, paramOnUninterestConfirmListener[0], paramOnUninterestConfirmListener[1]);
      a(0.8F);
      a(this);
    }
  }
  
  public void a(PopupWindow paramPopupWindow)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = (View)paramPopupWindow.getContentView().getParent();
      } else {
        localObject1 = paramPopupWindow.getContentView();
      }
      Object localObject2 = localObject1;
      if (paramPopupWindow.getBackground() != null) {
        localObject2 = (View)((View)localObject1).getParent();
      }
      paramPopupWindow = (WindowManager)paramPopupWindow.getContentView().getContext().getSystemService("window");
      Object localObject1 = (WindowManager.LayoutParams)((View)localObject2).getLayoutParams();
      ((WindowManager.LayoutParams)localObject1).flags |= 0x2;
      ((WindowManager.LayoutParams)localObject1).dimAmount = 0.2F;
      paramPopupWindow.updateViewLayout((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    catch (Exception paramPopupWindow) {}
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramIReadInJoyModel != null) {}
    for (;;)
    {
      try
      {
        i1 = paramIReadInJoyModel.g();
        i2 = paramIReadInJoyModel.c();
        paramIReadInJoyModel = paramIReadInJoyModel.a();
        if (paramIReadInJoyModel == null) {
          break label118;
        }
        String str = paramIReadInJoyModel.innerUniqueID;
        i3 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramIReadInJoyModel);
        paramIReadInJoyModel = str;
        a(i1, i2, i3, paramArrayList, paramIReadInJoyModel);
        return;
      }
      catch (Exception paramIReadInJoyModel)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("setData error! msg=");
        paramArrayList.append(paramIReadInJoyModel);
        QLog.e("KandianNegativeWindow", 1, paramArrayList.toString());
        return;
      }
      paramIReadInJoyModel = null;
      int i1 = 0;
      int i2 = 0;
      continue;
      label118:
      paramIReadInJoyModel = "";
      int i3 = 0;
    }
  }
  
  protected void a(ArrayList<DislikeInfo> paramArrayList, View paramView, int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = paramArrayList.isEmpty();
    int i1 = 8;
    int i2 = i1;
    if (!bool)
    {
      i2 = i1;
      if (!TextUtils.isEmpty(paramString))
      {
        ((TextView)paramView.findViewById(2131369163)).setText(paramString);
        paramString = (TextView)paramView.findViewById(2131369159);
        ImageView localImageView = (ImageView)paramView.findViewById(2131369143);
        ((ImageView)paramView.findViewById(2131369083)).setImageResource(paramInt);
        if (paramBoolean)
        {
          paramArrayList = a(paramArrayList);
          paramView.setTag(null);
        }
        else
        {
          paramView.setTag(paramArrayList.get(0));
          paramArrayList = "";
        }
        if (!TextUtils.isEmpty(paramArrayList)) {
          i1 = 0;
        }
        localImageView.setVisibility(i1);
        paramString.setText(paramArrayList);
        paramString.setVisibility(i1);
        this.n += 1;
        i2 = 0;
      }
    }
    paramView.setVisibility(i2);
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = 8;
    int i2 = 0;
    if (!paramBoolean)
    {
      i1 = 0;
      i2 = 8;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(i1);
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(i2);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout, paramBoolean);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean);
  }
  
  protected int b()
  {
    if (this.h <= 0)
    {
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      this.h = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    }
    int i1 = (a() + 1) * this.m + this.h;
    b(this.jdField_b_of_type_AndroidViewView);
    int i2 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() * this.n + this.h;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_f_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n = 0;
  }
  
  protected void b(View paramView)
  {
    paramView.measure(0, 0);
  }
  
  protected void c()
  {
    dismiss();
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$OnUninterestConfirmListener != null)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof DislikeInfo))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add((DislikeInfo)paramView);
        this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$OnUninterestConfirmListener.a(null, this.o, localArrayList, null);
      }
    }
  }
  
  protected void d()
  {
    this.jdField_f_of_type_JavaUtilArrayList.clear();
    a(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_b_of_type_AndroidViewView);
    a(this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_c_of_type_AndroidViewView);
    a(this.jdField_c_of_type_JavaUtilArrayList.size(), this.jdField_d_of_type_AndroidViewView);
    a(this.jdField_d_of_type_JavaUtilArrayList.size(), this.jdField_e_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow
 * JD-Core Version:    0.7.0.1
 */