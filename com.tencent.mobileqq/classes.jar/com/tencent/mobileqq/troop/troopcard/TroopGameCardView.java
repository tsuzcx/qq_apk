package com.tencent.mobileqq.troop.troopcard;

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
import android.os.Bundle;
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
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.GradeDistributedInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopGameCardView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  public DownloadParams.DecodeHandler a;
  TroopGameObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver = new TroopGameCardView.1(this);
  private TroopGameActivityInfo jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo;
  private TroopGameInfo jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameInfo;
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
  String jdField_a_of_type_JavaLangString = "";
  private Map<Integer, View> jdField_a_of_type_JavaUtilMap = new HashMap();
  TroopGameObserver b = new TroopGameCardView.2(this);
  
  public TroopGameCardView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new TroopGameCardView.10(this);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramContext);
  }
  
  private View a(String paramString, float paramFloat, int paramInt1, Integer paramInteger, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    View localView = View.inflate(getContext(), 2131561554, null);
    Object localObject1 = localView.findViewById(2131363428);
    if (paramInt3 == 4)
    {
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.LayoutParams)localObject2).width = ViewUtils.b(48.0F);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = (TextView)localView.findViewById(2131378460);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject1).setText(paramString);
    }
    if (paramBoolean2) {
      ((TextView)localObject1).setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#98989F"));
    }
    paramString = (TextView)localView.findViewById(2131372439);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramInt1));
    ((StringBuilder)localObject1).append("%");
    paramString.setText(((StringBuilder)localObject1).toString());
    paramString.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedTextColorById(paramInteger.intValue())));
    if (paramBoolean1) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    paramString.setVisibility(paramInt1);
    localObject1 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
    if (localObject1 != null) {
      paramString.setTypeface((Typeface)localObject1);
    }
    localObject1 = localView.findViewById(2131376301);
    Object localObject2 = (ITroopCardApi)QRoute.api(ITroopCardApi.class);
    if (paramBoolean1) {
      paramString = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedStartColorById(paramInteger.intValue());
    } else {
      paramString = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedStartColorById(paramInteger.intValue());
    }
    paramInt1 = ((ITroopCardApi)localObject2).parseColor(paramString);
    localObject2 = (ITroopCardApi)QRoute.api(ITroopCardApi.class);
    if (paramBoolean1) {
      paramString = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedEndColorById(paramInteger.intValue());
    } else {
      paramString = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedEndColorById(paramInteger.intValue());
    }
    a((View)localObject1, paramInt1, ((ITroopCardApi)localObject2).parseColor(paramString));
    paramString = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    if (paramString != null)
    {
      localObject2 = (ImageView)((View)localObject1).findViewById(2131376302);
      Object localObject3 = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("game_bar_bg_column_");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(".png");
      localObject3 = ((ITroopGameCardUtilsApi)localObject3).getImageBitmap(localStringBuilder.toString());
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      }
      localObject2 = (ImageView)localView.findViewById(2131376303);
      if (paramFloat * 100.0F > 27.0F)
      {
        localObject3 = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("column_game_grade_");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(".png");
        paramString = ((ITroopGameCardUtilsApi)localObject3).getImageBitmap(localStringBuilder.toString());
        if (paramString != null)
        {
          ((ImageView)localObject2).setImageBitmap(paramString);
          ((ImageView)localObject2).setVisibility(0);
        }
      }
      else
      {
        ((ImageView)localObject2).setVisibility(8);
      }
    }
    paramString = localView.findViewById(2131364689);
    paramString.setTag(paramInteger);
    paramString.setOnClickListener(new TroopGameCardView.6(this));
    paramInt1 = ViewUtils.b(6.0F);
    paramInt3 = Math.max(ViewUtils.b(6.0F), (int)(ViewUtils.b(100.0F) * paramFloat));
    int i = ViewUtils.b(6.0F);
    paramFloat = paramInt3;
    i = Math.max(i, (int)(1.1F * paramFloat));
    int j = Math.max(ViewUtils.b(6.0F), (int)(0.95F * paramFloat));
    int k = Math.max(ViewUtils.b(6.0F), (int)(paramFloat * 1.02F));
    paramString = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("height", new Keyframe[] { Keyframe.ofInt(0.0F, paramInt1), Keyframe.ofInt(0.2223283F, i), Keyframe.ofInt(0.3969466F, j), Keyframe.ofInt(0.8730916F, k), Keyframe.ofInt(1.0F, paramInt3) }) });
    paramString.addUpdateListener(new TroopGameCardView.7(this, paramString, (View)localObject1));
    paramString.setStartDelay(paramInt2);
    paramString.setDuration((int)1048.0F);
    paramString.start();
    this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localView);
    return localView;
  }
  
  private void a()
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGameCardView", 2, "network not avail.");
      }
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof AppInterface))
    {
      localObject = (AppInterface)localObject;
      a((AppInterface)localObject);
      b((AppInterface)localObject);
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "init");
      }
      setOrientation(1);
      localObject = View.inflate(paramContext, 2131561565, null);
      addView((View)localObject);
      ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
      this.jdField_a_of_type_AndroidViewView = View.inflate(paramContext, 2131561553, null);
      addView(this.jdField_a_of_type_AndroidViewView);
      a(this.jdField_a_of_type_AndroidViewView, 3);
      setVisibility(8);
      a();
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init exception: ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("TroopGameCardView", 2, ((StringBuilder)localObject).toString());
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
  
  private void a(AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
    paramAppInterface = (ITroopGameHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "getTroopGameCardInfo");
      }
      paramAppInterface.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(TroopGameActivityInfo paramTroopGameActivityInfo, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    int i = 8;
    if (paramTroopGameActivityInfo == null)
    {
      paramRelativeLayout.setVisibility(8);
      return;
    }
    paramRelativeLayout.setVisibility(0);
    View localView = View.inflate(getContext(), 2131561556, null);
    Object localObject1 = (URLImageView)localView.findViewById(2131368159);
    if (!TextUtils.isEmpty(paramTroopGameActivityInfo.iconUrl))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.b(20.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.b(20.0F);
      localObject2 = URLDrawable.getDrawable(paramTroopGameActivityInfo.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
      if (localObject2 != null)
      {
        int j = ViewUtils.b(20.0F);
        ((URLDrawable)localObject2).setTag(a(j, j, ViewUtils.b(5.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(this.jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler);
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((URLImageView)localObject1).setVisibility(0);
      }
    }
    else
    {
      ((URLImageView)localObject1).setVisibility(8);
    }
    localObject1 = (TextView)localView.findViewById(2131378784);
    Object localObject2 = (TextView)localView.findViewById(2131362033);
    ((TextView)localObject2).setText(new DecimalFormat(",###").format(paramTroopGameActivityInfo.activityValue));
    TextView localTextView = (TextView)localView.findViewById(2131381193);
    localTextView.setText(paramTroopGameActivityInfo.rankText);
    if (paramBoolean)
    {
      localView.setBackgroundResource(2130851116);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject2).setTextColor(-1);
      localTextView.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#98989F"));
    }
    localObject1 = (ImageView)localView.findViewById(2131362975);
    if (!TextUtils.isEmpty(paramTroopGameActivityInfo.rankEntrance)) {
      i = 0;
    }
    ((ImageView)localObject1).setVisibility(i);
    TroopReportor.a("grpProfile", "grpProfile_score", "grpProfile_ad_exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "", "" });
    paramRelativeLayout.addView(localView);
  }
  
  private void a(TroopGameInfo paramTroopGameInfo, View paramView, boolean paramBoolean)
  {
    if (!a(paramTroopGameInfo.gradeDistributedList))
    {
      paramView.setVisibility(0);
      paramView = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363427);
      paramView.removeAllViews();
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131363426).setBackgroundResource(2130851114);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131370044).setBackgroundColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#424242"));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131370045).setBackgroundColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#373737"));
      }
      Object localObject1 = paramTroopGameInfo.gradeDistributedList.iterator();
      long l1 = 0L;
      long l2 = l1;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GradeDistributedInfo)((Iterator)localObject1).next();
        long l3 = l2 + ((GradeDistributedInfo)localObject2).userCount;
        l2 = l3;
        if (((GradeDistributedInfo)localObject2).userCount > l1)
        {
          l1 = ((GradeDistributedInfo)localObject2).userCount;
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(((GradeDistributedInfo)localObject2).grade);
          l2 = l3;
        }
      }
      int i = 0;
      while (i < paramTroopGameInfo.gradeDistributedList.size())
      {
        localObject2 = (GradeDistributedInfo)paramTroopGameInfo.gradeDistributedList.get(i);
        localObject1 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getMajorGradeTagById(((GradeDistributedInfo)localObject2).grade);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          float f2 = 0.0F;
          float f1;
          if (l1 > 0L) {
            f1 = (float)((GradeDistributedInfo)localObject2).userCount / (float)l1;
          } else {
            f1 = 0.0F;
          }
          if (l2 > 0L) {
            f2 = (float)((GradeDistributedInfo)localObject2).userCount / (float)l2 * 100.0F;
          }
          int j = Math.round(f2);
          localObject2 = new Integer(((GradeDistributedInfo)localObject2).grade);
          boolean bool;
          if (((Integer)localObject2).compareTo(this.jdField_a_of_type_JavaLangInteger) == 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramView.addView(a((String)localObject1, f1, j, (Integer)localObject2, bool, i * 50, i + 1, paramBoolean));
        }
        i += 1;
      }
    }
    paramView.setVisibility(8);
  }
  
  private void a(TroopGameInfo paramTroopGameInfo, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (!a(paramTroopGameInfo))
    {
      paramRelativeLayout.setVisibility(0);
      int i = Math.round((float)(paramTroopGameInfo.fightScoreRank * 100.0D));
      String str = String.format(getContext().getString(2131719890), new Object[] { String.valueOf(i) });
      a(getContext().getString(2131719871), str, paramTroopGameInfo.fightScore, 9, paramRelativeLayout, 500, paramBoolean);
      a(getContext().getString(2131719891), "", paramTroopGameInfo.weekGPlayGameCount, 13, paramRelativeLayout, 666, paramBoolean);
      a(getContext().getString(2131719892), "", paramTroopGameInfo.weekPlayUserCount, 11, paramRelativeLayout, 833, paramBoolean);
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  private void a(Integer paramInteger)
  {
    b(this.jdField_a_of_type_JavaLangInteger);
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372439);
      a(localView.findViewById(2131376301), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedStartColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedEndColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedStartColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedEndColorById(paramInteger.intValue())), localTextView, true);
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, ViewGroup paramViewGroup, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(getContext(), 2131561555, null);
    Object localObject2 = localView.findViewById(2131367472);
    if (paramBoolean) {
      ((View)localObject2).setBackgroundResource(2130851116);
    }
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    if (ViewUtils.b(110.0F) * 3 + ViewUtils.b(16.0F) * 2 + 26 >= localDisplayMetrics.widthPixels)
    {
      localObject1 = ((View)localObject2).getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.LayoutParams)localObject1).width = ((localDisplayMetrics.widthPixels - ViewUtils.b(16.0F) * 2 - 26) / 3);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createGameCardDetailView setting bgV width = ");
          ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).width);
          QLog.d("TroopGameCardView", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    Object localObject1 = (TextView)localView.findViewById(2131378784);
    ((TextView)localObject1).setText(paramString1);
    if (paramBoolean) {
      ((TextView)localObject1).setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#FFFFFF"));
    }
    paramString1 = (TextView)localView.findViewById(2131365536);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
    else
    {
      paramString1.setVisibility(8);
    }
    if (paramBoolean) {
      paramString1.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#98989F"));
    }
    paramString1 = (TextView)localView.findViewById(2131372033);
    paramString2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
    if (paramString2 != null) {
      paramString1.setTypeface(paramString2);
    }
    paramString2 = (TextView)localView.findViewById(2131378384);
    paramString2.setVisibility(8);
    if (paramBoolean)
    {
      paramString1.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#FFFFFF"));
      paramString2.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#FFFFFF"));
    }
    int i;
    if (paramLong > 9999L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString1.setText("0.0");
      double d = paramLong;
      Double.isNaN(d);
      localObject1 = ValueAnimator.ofFloat(new float[] { 0.0F, new BigDecimal(d * 1.0D / 10000.0D).setScale(1, 4).floatValue() });
      ((ValueAnimator)localObject1).addUpdateListener(new TroopGameCardView.4(this, paramString1, paramString2));
      ((ValueAnimator)localObject1).setDuration(paramInt2);
      ((ValueAnimator)localObject1).start();
    }
    else
    {
      paramString1.setText("0");
      paramString2 = ValueAnimator.ofInt(new int[] { 0, (int)paramLong });
      paramString2.addUpdateListener(new TroopGameCardView.5(this, paramString1));
      paramString2.setDuration(paramInt2);
      paramString2.start();
    }
    paramViewGroup.addView(localView);
    paramString1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    paramString1.addRule(paramInt1);
    localView.setLayoutParams(paramString1);
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return (localAppRuntime != null) && (ThemeUtil.isInNightMode(localAppRuntime));
  }
  
  private boolean a(TroopGameInfo paramTroopGameInfo)
  {
    boolean bool = true;
    if (paramTroopGameInfo == null) {
      return true;
    }
    if ((paramTroopGameInfo.fightScore != 0L) || (paramTroopGameInfo.weekGPlayGameCount != 0L) || (paramTroopGameInfo.weekPlayUserCount != 0L)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGameDetailsEmpty = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", score = ");
      localStringBuilder.append(paramTroopGameInfo.fightScore);
      localStringBuilder.append(", gameCount = ");
      localStringBuilder.append(paramTroopGameInfo.weekGPlayGameCount);
      localStringBuilder.append(", userCount = ");
      localStringBuilder.append(paramTroopGameInfo.weekPlayUserCount);
      QLog.d("TroopGameCardView", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean a(List<GradeDistributedInfo> paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("isGradeDistributedListEmpty = ");
      paramList.append(bool);
      QLog.d("TroopGameCardView", 2, paramList.toString());
    }
    return bool;
  }
  
  private void b(AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramAppInterface.addObserver(this.b);
    paramAppInterface = (ITroopGameHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "getTroopGameActivityInfo");
      }
      paramAppInterface.a(this.jdField_a_of_type_JavaLangString, 1104466820);
    }
  }
  
  private void b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372439);
      a(localView.findViewById(2131376301), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedStartColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getSelectedEndColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedStartColorById(paramInteger.intValue())), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor(((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getUnselectedEndColorById(paramInteger.intValue())), localTextView, false);
    }
  }
  
  private boolean b(TroopGameInfo paramTroopGameInfo)
  {
    if (paramTroopGameInfo == null) {
      return true;
    }
    return (a(paramTroopGameInfo.gradeDistributedList)) && (a(paramTroopGameInfo));
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            paramView.setBackgroundResource(2130839440);
          }
        }
        else {
          paramView.setBackgroundResource(2130839443);
        }
      }
      else {
        paramView.setBackgroundResource(2130839449);
      }
    }
    else {
      paramView.setBackgroundResource(2130839433);
    }
    TroopGameCardView.3 local3 = new TroopGameCardView.3(this);
    TextView localTextView = (TextView)paramView.findViewById(2131378825);
    paramView = (ImageView)paramView.findViewById(2131362975);
    localTextView.setOnClickListener(local3);
    paramView.setOnClickListener(local3);
    paramView = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramView != null) && (ThemeUtil.isInNightMode(paramView))) {
      localTextView.setTextColor(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).parseColor("#98989F"));
    }
  }
  
  public void a(TroopGameActivityInfo paramTroopGameActivityInfo)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameInfo)) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362030);
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
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363429);
    boolean bool = a();
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365560);
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
  
  public int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new int[] { paramInt1, paramInt2, paramInt3 };
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362030)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo;
      if (localObject1 != null)
      {
        localObject1 = ((TroopGameActivityInfo)localObject1).rankEntrance;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = new ActivityURIRequest(getContext(), "/base/browser");
          Intent localIntent = new Intent();
          boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameDataTroopGameActivityInfo.iconUrl);
          localIntent.putExtra("url", (String)localObject1);
          ((ActivityURIRequest)localObject2).extra().putAll(localIntent.getExtras());
          QRoute.startUri((URIRequest)localObject2, null);
          localObject2 = this.jdField_a_of_type_JavaLangString;
          if ((bool ^ true)) {
            localObject1 = "1";
          } else {
            localObject1 = "2";
          }
          TroopReportor.a("grpProfile", "grpProfile_score", "grpProfile_score_clk", 0, 0, new String[] { localObject2, localObject1, "", "" });
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopGameCardView
 * JD-Core Version:    0.7.0.1
 */