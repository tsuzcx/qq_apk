package com.tencent.mobileqq.troop.widget;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.GradeDistributedInfo;
import com.tencent.mobileqq.data.troop.TroopGameInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.ColorUtils;
import com.tencent.mobileqq.util.TroopGameCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class TroopGameCardView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopGameCardView.1(this);
  private TroopGameInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopGameInfo;
  TroopGameObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver = new TroopGameCardView.2(this);
  private TroopGameActivityInfo jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo;
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
  String jdField_a_of_type_JavaLangString = "";
  private Map<Integer, View> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public TroopGameCardView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramContext);
  }
  
  private View a(String paramString, float paramFloat, int paramInt1, Integer paramInteger, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    View localView = View.inflate(getContext(), 2131561711, null);
    Object localObject1 = localView.findViewById(2131363501);
    Object localObject2;
    if (paramInt3 == 4)
    {
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.LayoutParams)localObject2).width = ViewUtils.b(48.0F);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = (TextView)localView.findViewById(2131379091);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject1).setText(paramString);
    }
    if (paramBoolean2) {
      ((TextView)localObject1).setTextColor(ColorUtils.a("#98989F"));
    }
    paramString = (TextView)localView.findViewById(2131372860);
    paramString.setText(String.valueOf(paramInt1) + "%");
    paramString.setTextColor(ColorUtils.a(TroopGameCardUtil.m(paramInteger.intValue())));
    if (paramBoolean1)
    {
      paramInt1 = 0;
      paramString.setVisibility(paramInt1);
      localObject1 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
      if (localObject1 != null) {
        paramString.setTypeface((Typeface)localObject1);
      }
      localObject1 = localView.findViewById(2131376809);
      if (!paramBoolean1) {
        break label628;
      }
      paramString = TroopGameCardUtil.k(paramInteger.intValue());
      label208:
      paramInt1 = ColorUtils.a(paramString);
      if (!paramBoolean1) {
        break label640;
      }
      paramString = TroopGameCardUtil.l(paramInteger.intValue());
      label227:
      a((View)localObject1, paramInt1, ColorUtils.a(paramString));
      paramString = TroopGameCardResDownloadManager.a();
      if (paramString != null)
      {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131376810);
        Bitmap localBitmap = TroopGameCardUtil.a(paramString + "game_bar_bg_column_" + paramInt3 + ".png");
        if (localBitmap != null) {
          ((ImageView)localObject2).setImageBitmap(localBitmap);
        }
        localObject2 = (ImageView)localView.findViewById(2131376811);
        if (100.0F * paramFloat <= 27.0F) {
          break label652;
        }
        paramString = TroopGameCardUtil.a(paramString + "column_game_grade_" + paramInt3 + ".png");
        if (paramString != null)
        {
          ((ImageView)localObject2).setImageBitmap(paramString);
          ((ImageView)localObject2).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramString = localView.findViewById(2131364801);
      paramString.setTag(paramInteger);
      paramString.setOnClickListener(new TroopGameCardView.6(this));
      paramInt1 = ViewUtils.b(6.0F);
      paramInt3 = Math.max(ViewUtils.b(6.0F), (int)(ViewUtils.b(100.0F) * paramFloat));
      int i = Math.max(ViewUtils.b(6.0F), (int)(paramInt3 * 1.1F));
      int j = Math.max(ViewUtils.b(6.0F), (int)(paramInt3 * 0.95F));
      int k = Math.max(ViewUtils.b(6.0F), (int)(paramInt3 * 1.02F));
      paramFloat = 233.0F / 1048.0F;
      float f1 = 183.0F / 1048.0F + paramFloat;
      float f2 = 266.0F / 1048.0F;
      paramString = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("height", new Keyframe[] { Keyframe.ofInt(0.0F, paramInt1), Keyframe.ofInt(paramFloat, i), Keyframe.ofInt(f1, j), Keyframe.ofInt(paramFloat + f1 + f2, k), Keyframe.ofInt(1.0F, paramInt3) }) });
      paramString.addUpdateListener(new TroopGameCardView.7(this, paramString, (View)localObject1));
      paramString.setStartDelay(paramInt2);
      paramString.setDuration((int)1048.0F);
      paramString.start();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localView);
      return localView;
      paramInt1 = 8;
      break;
      label628:
      paramString = TroopGameCardUtil.i(paramInteger.intValue());
      break label208;
      label640:
      paramString = TroopGameCardUtil.j(paramInteger.intValue());
      break label227;
      label652:
      ((ImageView)localObject2).setVisibility(8);
    }
  }
  
  private void a()
  {
    if (!NetworkUtil.g(getContext())) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGameCardView", 2, "network not avail.");
      }
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    a((QQAppInterface)localAppRuntime);
    b((QQAppInterface)localAppRuntime);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "init");
      }
      setOrientation(1);
      View localView = View.inflate(paramContext, 2131561722, null);
      addView(localView);
      localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
      this.jdField_a_of_type_AndroidViewView = View.inflate(paramContext, 2131561710, null);
      addView(this.jdField_a_of_type_AndroidViewView);
      a(this.jdField_a_of_type_AndroidViewView, 3);
      setVisibility(8);
      a();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TroopGameCardView", 2, "init exception: " + paramContext.getMessage());
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
    localGradientDrawable.setCornerRadius(ViewUtils.b(8.0F));
    paramView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TextView paramTextView, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("startColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) }), PropertyValuesHolder.ofObject("endColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) }) });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new TroopGameCardView.8(this, paramView));
    localValueAnimator.addListener(new TroopGameCardView.9(this, paramTextView, paramBoolean));
    localValueAnimator.start();
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      paramQQAppInterface = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "getTroopGameCardInfo");
    }
    paramQQAppInterface.y(this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(TroopGameInfo paramTroopGameInfo, View paramView, boolean paramBoolean)
  {
    if (!a(paramTroopGameInfo.gradeDistributedList))
    {
      paramView.setVisibility(0);
      paramView = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363500);
      paramView.removeAllViews();
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131363499).setBackgroundResource(2130851198);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131370383).setBackgroundColor(ColorUtils.a("#424242"));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131370384).setBackgroundColor(ColorUtils.a("#373737"));
      }
      Object localObject1 = paramTroopGameInfo.gradeDistributedList.iterator();
      long l3 = 0L;
      Object localObject2;
      long l2;
      for (long l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = l2)
      {
        localObject2 = (GradeDistributedInfo)((Iterator)localObject1).next();
        long l4 = ((GradeDistributedInfo)localObject2).userCount;
        l2 = l1;
        if (((GradeDistributedInfo)localObject2).userCount > l1)
        {
          l2 = ((GradeDistributedInfo)localObject2).userCount;
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(((GradeDistributedInfo)localObject2).grade);
        }
        l3 = l4 + l3;
      }
      int i = 0;
      if (i < paramTroopGameInfo.gradeDistributedList.size())
      {
        localObject2 = (GradeDistributedInfo)paramTroopGameInfo.gradeDistributedList.get(i);
        localObject1 = TroopGameCardUtil.a(((GradeDistributedInfo)localObject2).grade);
        float f1;
        label256:
        float f2;
        label278:
        int j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (l1 <= 0L) {
            break label351;
          }
          f1 = (float)((GradeDistributedInfo)localObject2).userCount / (float)l1;
          if (l3 <= 0L) {
            break label357;
          }
          f2 = (float)((GradeDistributedInfo)localObject2).userCount / (float)l3 * 100.0F;
          j = Math.round(f2);
          localObject2 = new Integer(((GradeDistributedInfo)localObject2).grade);
          if (((Integer)localObject2).compareTo(this.jdField_a_of_type_JavaLangInteger) != 0) {
            break label363;
          }
        }
        label351:
        label357:
        label363:
        for (boolean bool = true;; bool = false)
        {
          paramView.addView(a((String)localObject1, f1, j, (Integer)localObject2, bool, i * 50, i + 1, paramBoolean));
          i += 1;
          break;
          f1 = 0.0F;
          break label256;
          f2 = 0.0F;
          break label278;
        }
      }
    }
    else
    {
      paramView.setVisibility(8);
    }
  }
  
  private void a(TroopGameInfo paramTroopGameInfo, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (!a(paramTroopGameInfo))
    {
      paramRelativeLayout.setVisibility(0);
      int i = Math.round((float)(paramTroopGameInfo.fightScoreRank * 100.0D));
      String str = String.format(getContext().getString(2131720157), new Object[] { String.valueOf(i) });
      a(getContext().getString(2131720138), str, paramTroopGameInfo.fightScore, 9, paramRelativeLayout, 500, paramBoolean);
      a(getContext().getString(2131720158), "", paramTroopGameInfo.weekGPlayGameCount, 13, paramRelativeLayout, 666, paramBoolean);
      a(getContext().getString(2131720159), "", paramTroopGameInfo.weekPlayUserCount, 11, paramRelativeLayout, 833, paramBoolean);
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  private void a(TroopGameActivityInfo paramTroopGameActivityInfo, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramTroopGameActivityInfo == null)
    {
      paramRelativeLayout.setVisibility(8);
      return;
    }
    paramRelativeLayout.setVisibility(0);
    View localView = View.inflate(getContext(), 2131561713, null);
    Object localObject1 = (URLImageView)localView.findViewById(2131368408);
    if (!TextUtils.isEmpty(paramTroopGameActivityInfo.iconUrl))
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.b(20.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.b(20.0F);
      localObject2 = URLDrawable.getDrawable(paramTroopGameActivityInfo.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
      if (localObject2 != null)
      {
        i = ViewUtils.b(20.0F);
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(5.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.j);
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((URLImageView)localObject1).setVisibility(0);
      }
      localObject1 = (TextView)localView.findViewById(2131379432);
      localObject2 = (TextView)localView.findViewById(2131362018);
      ((TextView)localObject2).setText(new DecimalFormat(",###").format(paramTroopGameActivityInfo.activityValue));
      TextView localTextView = (TextView)localView.findViewById(2131381989);
      localTextView.setText(paramTroopGameActivityInfo.rankText);
      if (paramBoolean)
      {
        localView.setBackgroundResource(2130851200);
        ((TextView)localObject1).setTextColor(-1);
        ((TextView)localObject2).setTextColor(-1);
        localTextView.setTextColor(ColorUtils.a("#98989F"));
      }
      localObject1 = (ImageView)localView.findViewById(2131363027);
      if (!TextUtils.isEmpty(paramTroopGameActivityInfo.rankEntrance)) {
        break label332;
      }
    }
    label332:
    for (int i = 8;; i = 0)
    {
      ((ImageView)localObject1).setVisibility(i);
      TroopReportor.a("grpProfile", "grpProfile_score", "grpProfile_ad_exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "", "" });
      paramRelativeLayout.addView(localView);
      return;
      ((URLImageView)localObject1).setVisibility(8);
      break;
    }
  }
  
  private void a(Integer paramInteger)
  {
    b(this.jdField_a_of_type_JavaLangInteger);
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372860);
      a(localView.findViewById(2131376809), ColorUtils.a(TroopGameCardUtil.i(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.j(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.k(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.l(paramInteger.intValue())), localTextView, true);
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, ViewGroup paramViewGroup, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(getContext(), 2131561712, null);
    Object localObject = localView.findViewById(2131367715);
    if (paramBoolean) {
      ((View)localObject).setBackgroundResource(2130851200);
    }
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    if (ViewUtils.b(110.0F) * 3 + ViewUtils.b(16.0F) * 2 + 26 >= localDisplayMetrics.widthPixels)
    {
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((localDisplayMetrics.widthPixels - ViewUtils.b(16.0F) * 2 - 26) / 3);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardView", 2, "createGameCardDetailView setting bgV width = " + localLayoutParams.width);
        }
      }
    }
    localObject = (TextView)localView.findViewById(2131379432);
    ((TextView)localObject).setText(paramString1);
    if (paramBoolean) {
      ((TextView)localObject).setTextColor(ColorUtils.a("#FFFFFF"));
    }
    paramString1 = (TextView)localView.findViewById(2131365699);
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
      if (paramBoolean) {
        paramString1.setTextColor(ColorUtils.a("#98989F"));
      }
      paramString1 = (TextView)localView.findViewById(2131372450);
      paramString2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
      if (paramString2 != null) {
        paramString1.setTypeface(paramString2);
      }
      paramString2 = (TextView)localView.findViewById(2131379021);
      paramString2.setVisibility(8);
      if (paramBoolean)
      {
        paramString1.setTextColor(ColorUtils.a("#FFFFFF"));
        paramString2.setTextColor(ColorUtils.a("#FFFFFF"));
      }
      if (paramLong <= 9999L) {
        break label439;
      }
      i = 1;
      label322:
      if (i == 0) {
        break label445;
      }
      paramString1.setText("0.0");
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, new BigDecimal(paramLong * 1.0D / 10000.0D).setScale(1, 4).floatValue() });
      ((ValueAnimator)localObject).addUpdateListener(new TroopGameCardView.4(this, paramString1, paramString2));
      ((ValueAnimator)localObject).setDuration(paramInt2);
      ((ValueAnimator)localObject).start();
    }
    for (;;)
    {
      paramViewGroup.addView(localView);
      paramString1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      paramString1.addRule(paramInt1);
      localView.setLayoutParams(paramString1);
      return;
      paramString1.setVisibility(8);
      break;
      label439:
      i = 0;
      break label322;
      label445:
      paramString1.setText("0");
      paramString2 = ValueAnimator.ofInt(new int[] { 0, (int)paramLong });
      paramString2.addUpdateListener(new TroopGameCardView.5(this, paramString1));
      paramString2.setDuration(paramInt2);
      paramString2.start();
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      bool1 = bool2;
      if (ThemeUtil.isInNightMode(localAppRuntime)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(TroopGameInfo paramTroopGameInfo)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramTroopGameInfo == null) {
      return bool2;
    }
    if ((paramTroopGameInfo.fightScore == 0L) && (paramTroopGameInfo.weekGPlayGameCount == 0L) && (paramTroopGameInfo.weekPlayUserCount == 0L)) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopGameCardView", 2, "isGameDetailsEmpty = " + bool1 + ", score = " + paramTroopGameInfo.fightScore + ", gameCount = " + paramTroopGameInfo.weekGPlayGameCount + ", userCount = " + paramTroopGameInfo.weekPlayUserCount);
      return bool1;
      bool1 = false;
    }
  }
  
  private boolean a(List<GradeDistributedInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "isGradeDistributedListEmpty = " + bool);
      }
      return bool;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
      paramQQAppInterface = (ITroopGameHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "getTroopGameActivityInfo");
    }
    paramQQAppInterface.a(this.jdField_a_of_type_JavaLangString, 1104466820);
  }
  
  private void b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372860);
      a(localView.findViewById(2131376809), ColorUtils.a(TroopGameCardUtil.k(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.l(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.i(paramInteger.intValue())), ColorUtils.a(TroopGameCardUtil.j(paramInteger.intValue())), localTextView, false);
    }
  }
  
  private boolean b(TroopGameInfo paramTroopGameInfo)
  {
    if (paramTroopGameInfo == null) {}
    while ((a(paramTroopGameInfo.gradeDistributedList)) && (a(paramTroopGameInfo))) {
      return true;
    }
    return false;
  }
  
  protected void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      TroopGameCardView.3 local3 = new TroopGameCardView.3(this);
      TextView localTextView = (TextView)paramView.findViewById(2131379474);
      paramView = (ImageView)paramView.findViewById(2131363027);
      localTextView.setOnClickListener(local3);
      paramView.setOnClickListener(local3);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView != null) && (ThemeUtil.isInNightMode(paramView))) {
        localTextView.setTextColor(ColorUtils.a("#98989F"));
      }
      return;
      paramView.setBackgroundResource(2130839575);
      continue;
      paramView.setBackgroundResource(2130839591);
      continue;
      paramView.setBackgroundResource(2130839585);
      continue;
      paramView.setBackgroundResource(2130839582);
    }
  }
  
  public void a(TroopGameActivityInfo paramTroopGameActivityInfo)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopGameInfo)) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362014);
    localRelativeLayout.setOnClickListener(this);
    a(paramTroopGameActivityInfo, localRelativeLayout, a());
  }
  
  public void a(boolean paramBoolean, TroopGameInfo paramTroopGameInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "updateGameCardView");
    }
    setVisibility(0);
    TroopReportor.a("grpProfile", "grpProfile_exp", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363502);
    boolean bool = a();
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365723);
    localRelativeLayout.removeAllViews();
    if ((paramBoolean) && (!b(paramTroopGameInfo)))
    {
      a(paramTroopGameInfo, localRelativeLayout, bool);
      a(paramTroopGameInfo, localView, bool);
      return;
    }
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "updateGameCardView. hide gamecardView");
      }
      setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "updateGameCardView. gameinfo empty!");
    }
    localView.setVisibility(8);
    localRelativeLayout.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131362014) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo == null)) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo.rankEntrance;
    } while (TextUtils.isEmpty(str));
    Object localObject = new Intent(getContext(), QQBrowserActivity.class);
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo.iconUrl))
    {
      i = 1;
      label71:
      ((Intent)localObject).putExtra("url", str);
      getContext().startActivity((Intent)localObject);
      localObject = this.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label149;
      }
    }
    label149:
    for (String str = "1";; str = "2")
    {
      TroopReportor.a("grpProfile", "grpProfile_score", "grpProfile_score_clk", 0, 0, new String[] { localObject, str, "", "" });
      break;
      i = 0;
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView
 * JD-Core Version:    0.7.0.1
 */