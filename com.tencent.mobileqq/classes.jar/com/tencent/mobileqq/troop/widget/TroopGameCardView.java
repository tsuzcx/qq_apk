package com.tencent.mobileqq.troop.widget;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoep;
import aofu;
import bgfz;
import bgpm;
import bgpn;
import bgpp;
import bgpq;
import bgpr;
import bgps;
import bgpt;
import bgpu;
import bhbt;
import bhbu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.GradeDistributedInfo;
import com.tencent.mobileqq.data.troop.TroopGameInfo;
import com.tencent.mobileqq.mini.util.ColorUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class TroopGameCardView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  public aofu a;
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
  public String a;
  private Map<Integer, View> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public TroopGameCardView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aofu = new bgpm(this);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramContext);
  }
  
  private View a(String paramString, float paramFloat, int paramInt1, Integer paramInteger, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    View localView = View.inflate(getContext(), 2131561593, null);
    Object localObject1 = localView.findViewById(2131363416);
    Object localObject2;
    if (paramInt3 == 4)
    {
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.LayoutParams)localObject2).width = ViewUtils.dpToPx(48.0F);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = (TextView)localView.findViewById(2131378658);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject1).setText(paramString);
    }
    if (paramBoolean2) {
      ((TextView)localObject1).setTextColor(ColorUtil.parseColor("#98989F"));
    }
    paramString = (TextView)localView.findViewById(2131372550);
    paramString.setText(String.valueOf(paramInt1) + "%");
    paramString.setTextColor(ColorUtil.parseColor(bhbt.m(paramInteger.intValue())));
    if (paramBoolean1)
    {
      paramInt1 = 0;
      paramString.setVisibility(paramInt1);
      localObject1 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
      if (localObject1 != null) {
        paramString.setTypeface((Typeface)localObject1);
      }
      localObject1 = localView.findViewById(2131376416);
      if (!paramBoolean1) {
        break label628;
      }
      paramString = bhbt.k(paramInteger.intValue());
      label208:
      paramInt1 = ColorUtil.parseColor(paramString);
      if (!paramBoolean1) {
        break label640;
      }
      paramString = bhbt.l(paramInteger.intValue());
      label227:
      a((View)localObject1, paramInt1, ColorUtil.parseColor(paramString));
      paramString = bgfz.a();
      if (paramString != null)
      {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131376417);
        Bitmap localBitmap = bhbt.a(paramString + "game_bar_bg_column_" + paramInt3 + ".png");
        if (localBitmap != null) {
          ((ImageView)localObject2).setImageBitmap(localBitmap);
        }
        localObject2 = (ImageView)localView.findViewById(2131376418);
        if (100.0F * paramFloat <= 27.0F) {
          break label652;
        }
        paramString = bhbt.a(paramString + "column_game_grade_" + paramInt3 + ".png");
        if (paramString != null)
        {
          ((ImageView)localObject2).setImageBitmap(paramString);
          ((ImageView)localObject2).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramString = localView.findViewById(2131364685);
      paramString.setTag(paramInteger);
      paramString.setOnClickListener(new bgpr(this));
      paramInt1 = ViewUtils.dpToPx(6.0F);
      paramInt3 = Math.max(ViewUtils.dpToPx(6.0F), (int)(ViewUtils.dpToPx(100.0F) * paramFloat));
      int i = Math.max(ViewUtils.dpToPx(6.0F), (int)(paramInt3 * 1.1F));
      int j = Math.max(ViewUtils.dpToPx(6.0F), (int)(paramInt3 * 0.95F));
      int k = Math.max(ViewUtils.dpToPx(6.0F), (int)(paramInt3 * 1.02F));
      paramFloat = 233.0F / 1048.0F;
      float f1 = 183.0F / 1048.0F + paramFloat;
      float f2 = 266.0F / 1048.0F;
      paramString = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("height", new Keyframe[] { Keyframe.ofInt(0.0F, paramInt1), Keyframe.ofInt(paramFloat, i), Keyframe.ofInt(f1, j), Keyframe.ofInt(paramFloat + f1 + f2, k), Keyframe.ofInt(1.0F, paramInt3) }) });
      paramString.addUpdateListener(new bgps(this, paramString, (View)localObject1));
      paramString.setStartDelay(paramInt2);
      paramString.setDuration((int)1048.0F);
      paramString.start();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localView);
      return localView;
      paramInt1 = 8;
      break;
      label628:
      paramString = bhbt.i(paramInteger.intValue());
      break label208;
      label640:
      paramString = bhbt.j(paramInteger.intValue());
      break label227;
      label652:
      ((ImageView)localObject2).setVisibility(8);
    }
  }
  
  private void a()
  {
    if (!NetworkUtil.isNetworkAvailable(getContext())) {
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
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardView", 2, "init");
      }
      setOrientation(1);
      View localView = View.inflate(paramContext, 2131561603, null);
      addView(localView);
      localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
      this.jdField_a_of_type_AndroidViewView = View.inflate(paramContext, 2131561592, null);
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
    localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0F));
    paramView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TextView paramTextView, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("startColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) }), PropertyValuesHolder.ofObject("endColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) }) });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new bgpt(this, paramView));
    localValueAnimator.addListener(new bgpu(this, paramTextView, paramBoolean));
    localValueAnimator.start();
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
      paramQQAppInterface = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "getTroopGameCardInfo");
    }
    paramQQAppInterface.C(this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(Integer paramInteger)
  {
    b(this.jdField_a_of_type_JavaLangInteger);
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372550);
      a(localView.findViewById(2131376416), ColorUtil.parseColor(bhbt.i(paramInteger.intValue())), ColorUtil.parseColor(bhbt.j(paramInteger.intValue())), ColorUtil.parseColor(bhbt.k(paramInteger.intValue())), ColorUtil.parseColor(bhbt.l(paramInteger.intValue())), localTextView, true);
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, ViewGroup paramViewGroup, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(getContext(), 2131561594, null);
    Object localObject = localView.findViewById(2131367527);
    if (paramBoolean) {
      ((View)localObject).setBackgroundResource(2130850771);
    }
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    if (ViewUtils.dpToPx(110.0F) * 3 + ViewUtils.dpToPx(16.0F) * 2 + 26 >= localDisplayMetrics.widthPixels)
    {
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((localDisplayMetrics.widthPixels - ViewUtils.dpToPx(16.0F) * 2 - 26) / 3);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardView", 2, "createGameCardDetailView setting bgV width = " + localLayoutParams.width);
        }
      }
    }
    localObject = (TextView)localView.findViewById(2131379001);
    ((TextView)localObject).setText(paramString1);
    if (paramBoolean) {
      ((TextView)localObject).setTextColor(ColorUtil.parseColor("#FFFFFF"));
    }
    paramString1 = (TextView)localView.findViewById(2131365538);
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
      if (paramBoolean) {
        paramString1.setTextColor(ColorUtil.parseColor("#98989F"));
      }
      paramString1 = (TextView)localView.findViewById(2131372148);
      paramString2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/qq_font_troop_member_number.ttf");
      if (paramString2 != null) {
        paramString1.setTypeface(paramString2);
      }
      paramString2 = (TextView)localView.findViewById(2131378589);
      paramString2.setVisibility(8);
      if (paramBoolean)
      {
        paramString1.setTextColor(ColorUtil.parseColor("#FFFFFF"));
        paramString2.setTextColor(ColorUtil.parseColor("#FFFFFF"));
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
      ((ValueAnimator)localObject).addUpdateListener(new bgpp(this, paramString1, paramString2));
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
      paramString2.addUpdateListener(new bgpq(this, paramString1));
      paramString2.setDuration(paramInt2);
      paramString2.start();
    }
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
  
  private void b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramInteger))
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
      TextView localTextView = (TextView)localView.findViewById(2131372550);
      a(localView.findViewById(2131376416), ColorUtil.parseColor(bhbt.k(paramInteger.intValue())), ColorUtil.parseColor(bhbt.l(paramInteger.intValue())), ColorUtil.parseColor(bhbt.i(paramInteger.intValue())), ColorUtil.parseColor(bhbt.j(paramInteger.intValue())), localTextView, false);
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
      bgpn localbgpn = new bgpn(this);
      TextView localTextView = (TextView)paramView.findViewById(2131379043);
      paramView = (ImageView)paramView.findViewById(2131362985);
      localTextView.setOnClickListener(localbgpn);
      paramView.setOnClickListener(localbgpn);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView != null) && (ThemeUtil.isInNightMode(paramView))) {
        localTextView.setTextColor(ColorUtil.parseColor("#98989F"));
      }
      return;
      paramView.setBackgroundResource(2130839496);
      continue;
      paramView.setBackgroundResource(2130839512);
      continue;
      paramView.setBackgroundResource(2130839506);
      continue;
      paramView.setBackgroundResource(2130839503);
    }
  }
  
  public void a(boolean paramBoolean, TroopGameInfo paramTroopGameInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "updateGameCardView");
    }
    setVisibility(0);
    bhbu.a("grpProfile", "grpProfile_exp", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131363417);
    boolean bool2 = false;
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = bool2;
    if (localObject2 != null)
    {
      bool1 = bool2;
      if (ThemeUtil.isInNightMode((AppRuntime)localObject2)) {
        bool1 = true;
      }
    }
    localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365562);
    ((RelativeLayout)localObject2).removeAllViews();
    int i;
    Object localObject3;
    long l2;
    long l1;
    label380:
    long l3;
    if ((paramBoolean) && (!b(paramTroopGameInfo))) {
      if (!a(paramTroopGameInfo))
      {
        ((RelativeLayout)localObject2).setVisibility(0);
        i = Math.round((float)(paramTroopGameInfo.fightScoreRank * 100.0D));
        localObject3 = String.format(getContext().getString(2131719579), new Object[] { String.valueOf(i) });
        a(getContext().getString(2131719566), (String)localObject3, paramTroopGameInfo.fightScore, 9, (ViewGroup)localObject2, 500, bool1);
        a(getContext().getString(2131719580), "", paramTroopGameInfo.weekGPlayGameCount, 13, (ViewGroup)localObject2, 666, bool1);
        a(getContext().getString(2131719581), "", paramTroopGameInfo.weekPlayUserCount, 11, (ViewGroup)localObject2, 833, bool1);
        if (a(paramTroopGameInfo.gradeDistributedList)) {
          break label638;
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363415);
        ((LinearLayout)localObject1).removeAllViews();
        if (bool1)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131363414).setBackgroundResource(2130850769);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370111).setBackgroundColor(ColorUtil.parseColor("#424242"));
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370112).setBackgroundColor(ColorUtil.parseColor("#373737"));
        }
        localObject2 = paramTroopGameInfo.gradeDistributedList.iterator();
        l2 = 0L;
        l1 = 0L;
        if (!((Iterator)localObject2).hasNext()) {
          break label459;
        }
        localObject3 = (GradeDistributedInfo)((Iterator)localObject2).next();
        l3 = ((GradeDistributedInfo)localObject3).userCount;
        if (((GradeDistributedInfo)localObject3).userCount <= l1) {
          break label704;
        }
        l1 = ((GradeDistributedInfo)localObject3).userCount;
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(((GradeDistributedInfo)localObject3).grade);
      }
    }
    label528:
    label550:
    label704:
    for (;;)
    {
      l2 = l3 + l2;
      break label380;
      ((RelativeLayout)localObject2).setVisibility(8);
      break;
      label459:
      i = 0;
      if (i < paramTroopGameInfo.gradeDistributedList.size())
      {
        localObject3 = (GradeDistributedInfo)paramTroopGameInfo.gradeDistributedList.get(i);
        localObject2 = bhbt.a(((GradeDistributedInfo)localObject3).grade);
        float f1;
        float f2;
        int j;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (l1 <= 0L) {
            break label622;
          }
          f1 = (float)((GradeDistributedInfo)localObject3).userCount / (float)l1;
          if (l2 <= 0L) {
            break label627;
          }
          f2 = (float)((GradeDistributedInfo)localObject3).userCount / (float)l2 * 100.0F;
          j = Math.round(f2);
          localObject3 = new Integer(((GradeDistributedInfo)localObject3).grade);
          if (((Integer)localObject3).compareTo(this.jdField_a_of_type_JavaLangInteger) != 0) {
            break label633;
          }
        }
        label622:
        label627:
        label633:
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((LinearLayout)localObject1).addView(a((String)localObject2, f1, j, (Integer)localObject3, paramBoolean, i * 50, i + 1, bool1));
          i += 1;
          break;
          f1 = 0.0F;
          break label528;
          f2 = 0.0F;
          break label550;
        }
        label638:
        ((View)localObject1).setVisibility(8);
      }
      return;
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
      ((View)localObject1).setVisibility(8);
      ((RelativeLayout)localObject2).setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView
 * JD-Core Version:    0.7.0.1
 */