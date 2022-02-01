package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.NickWrapper.NickString;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ProfileNameView
  extends RelativeLayout
{
  String a = "";
  NickWrapper.NickString b;
  int c = 0;
  ColorNickTextView d;
  ColorNickTextView e;
  ETTextViewPlus f;
  LinearLayout g;
  protected boolean h = false;
  protected ImageView i = null;
  protected int j;
  private int k;
  private Context l;
  private LayoutInflater m;
  private float n;
  private int o = 0;
  private int p;
  private int q;
  private View.OnClickListener r;
  
  public ProfileNameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.l = paramContext;
    this.m = LayoutInflater.from(paramContext);
    paramContext = getResources().getDisplayMetrics();
    this.n = paramContext.density;
    if (this.n == 0.0F) {
      this.n = 0.1F;
    }
    this.c = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - ScreenUtil.dip2px(188.0F));
    this.j = getResources().getColor(2131168212);
    this.p = 24;
    this.q = 20;
    a();
  }
  
  private void a()
  {
    this.m.inflate(2131627731, this);
    this.d = ((ColorNickTextView)findViewById(2131435717));
    this.e = ((ColorNickTextView)findViewById(2131435718));
    this.f = ((ETTextViewPlus)findViewById(2131435719));
    this.f.setVisibility(8);
    this.g = ((LinearLayout)findViewById(2131444859));
    this.e.setVisibility(8);
    this.g.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setTextColor(this.j);
    this.e.setTextColor(this.j);
    this.d.setTextSize(1, this.p);
    this.e.setTextSize(1, this.q);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((paramProfileCardInfo.isTroopMemberCard) && (paramViewGroup != null))
    {
      if (paramTextView == null) {
        return;
      }
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (TroopMemberCardUtils.a(localTroopManager.f(paramProfileCardInfo.troopUin), paramProfileCardInfo.troopMemberCard, paramTextView))
      {
        paramViewGroup.setVisibility(0);
        paramTextView.setPadding(10, 2, 10, 2);
        if (localTroopManager.Z(paramProfileCardInfo.troopUin))
        {
          TroopRankConfig.a().a(paramProfileCardInfo.troopUin, paramProfileCardInfo.allInOne.uin, false);
        }
        else
        {
          int i1 = paramProfileCardInfo.troopMemberCard.memberRole;
          if ((i1 == 1) || (i1 == 2) || (i1 == 3)) {
            paramViewGroup.setOnClickListener(new ProfileNameView.TroopRankClick(paramQQAppInterface, paramProfileCardInfo));
          }
          if ((TroopRankConfig.a().a(paramProfileCardInfo.troopUin, paramProfileCardInfo.allInOne.uin)) && (this.i == null))
          {
            this.i = new ImageView(this.l);
            paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
            paramQQAppInterface.addRule(7, paramTextView.getId());
            paramQQAppInterface.setMargins(0, 0, 0, 0);
            this.i.setId(2131444531);
            this.i.setLayoutParams(paramQQAppInterface);
            this.i.setVisibility(0);
            this.i.setImageResource(2130852589);
            paramViewGroup.addView(this.i);
          }
        }
        if (!this.h)
        {
          TroopRankConfig.b("grp_data", "exp_medal");
          this.h = true;
        }
      }
      else
      {
        paramViewGroup.setVisibility(8);
        paramTextView.setText(null);
        paramTextView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, TroopHonorView paramTroopHonorView, float paramFloat)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.troopMemberCard != null))
    {
      paramQQAppInterface = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
      if (!paramQQAppInterface.isSupportTroopHonor(paramProfileCardInfo.troopUin))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
        return;
      }
      paramQQAppInterface = paramQQAppInterface.convertToHonorList(paramProfileCardInfo.troopMemberCard.honorList, Byte.valueOf(paramProfileCardInfo.troopMemberCard.honorRichTag));
      paramTroopHonorView.setHonorList(paramQQAppInterface, paramFloat);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        paramTroopHonorView.setVisibility(0);
        paramTroopHonorView.setOnClickListener(new ProfileNameView.1(this, paramProfileCardInfo));
      }
      else
      {
        paramTroopHonorView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.card", 2, String.format("updateTroopHonorView, honorList: %s", new Object[] { paramQQAppInterface }));
      }
    }
    else
    {
      paramTroopHonorView.setHonorList(null);
      paramTroopHonorView.setVisibility(8);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, TroopMemberNewLevelView paramTroopMemberNewLevelView)
  {
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null))
    {
      if (paramTroopMemberNewLevelView == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("call updateTroopMemberNewLevelView troopUin : ");
        ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
        QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((TroopManager)localObject2).g(paramProfileCardInfo.troopUin);
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("updateTroopMemberNewLevelView troopInfo is null. troopUin : ");
          paramQQAppInterface.append(paramProfileCardInfo.troopUin);
          QLog.d("ProfileNameView", 2, paramQQAppInterface.toString());
        }
        return;
      }
      int i2 = paramProfileCardInfo.troopMemberCard.newRealLevel;
      int i1 = i2;
      if (i2 == 0) {
        i1 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramProfileCardInfo.troopMemberCard.realLevel);
      }
      localObject1 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem((TroopInfo)localObject1, paramProfileCardInfo.allInOne.uin, i1, paramProfileCardInfo.troopMemberCard.titleId, paramProfileCardInfo.troopMemberCard.mUniqueTitle, paramProfileCardInfo.troopMemberCard.honorRichTag);
      if ((localObject1 != null) && (paramTroopMemberNewLevelView != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("troopMemberRankItem :");
          ((StringBuilder)localObject2).append(((TroopMemberRankItem)localObject1).toString());
          QLog.d("ProfileNameView", 2, ((StringBuilder)localObject2).toString());
        }
        paramTroopMemberNewLevelView.setTroopMemberNewLevel((TroopMemberRankItem)localObject1);
        paramTroopMemberNewLevelView.setOnClickListener(new ProfileNameView.2(this, paramProfileCardInfo, paramQQAppInterface));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateTroopMemberNewLevelView failed - troopUin : ");
        paramQQAppInterface.append(paramProfileCardInfo.troopUin);
        QLog.d("ProfileNameView", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public float a(TextView paramTextView, String paramString, Paint paramPaint)
  {
    return new NickWrapper.NickString(paramString, (int)(paramTextView.getTextSize() / this.n)).c(4).a(paramPaint);
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable TextView paramTextView, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyNickSpanText: ");
      localStringBuilder.append(paramString);
      QLog.d("ProfileNameView", 2, localStringBuilder.toString());
    }
    if ((paramTextView != null) && (paramString != null))
    {
      paramTextView.setTextColor(this.j);
      paramString = new ColorNickText(paramString, (int)(paramTextView.getTextSize() / this.n)).b();
      paramTextView.setText(paramString);
      ColorNickManager.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  @RequiresApi(api=16)
  public void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int i1;
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null) && ((!ProfilePAUtils.isFromGuild(paramProfileCardInfo.allInOne.pa)) || (paramProfileCardInfo.card != null)) && ((ProfilePAUtils.isFromGuild(paramProfileCardInfo.allInOne.pa)) || (paramProfileCardInfo.profileName != null)))
    {
      this.k = 3;
      setVisibility(0);
      this.d.setTextSize(1, this.p);
      this.e.setTextSize(1, this.q);
      i1 = getMeasuredWidth();
      if (i1 > this.c) {
        this.c = i1;
      }
    }
    try
    {
      if (ProfilePAUtils.isFromGuild(paramProfileCardInfo.allInOne.pa))
      {
        localObject1 = paramProfileCardInfo.card;
        if (TextUtils.isEmpty(((Card)localObject1).strReMark)) {
          localObject1 = ((Card)localObject1).strNick;
        } else {
          localObject1 = ((Card)localObject1).strReMark;
        }
      }
    }
    catch (NullPointerException localNullPointerException1)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      String str;
      Resources localResources;
      float f1;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f2;
      boolean bool;
      float f3;
      int i2;
      float f4;
      int i3;
      break label201;
    }
    try
    {
      this.d.setBackground(null);
      this.e.setBackground(null);
      setBackground(null);
    }
    catch (NullPointerException localNullPointerException2)
    {
      break label204;
    }
    localObject1 = paramProfileCardInfo.profileName.a.b;
    break label204;
    label201:
    localObject1 = null;
    label204:
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else if (ProfilePAUtils.isPaTypeShowAccount(paramProfileCardInfo.allInOne))
    {
      localObject2 = String.valueOf(paramProfileCardInfo.allInOne.uin);
    }
    else
    {
      localObject2 = " ";
    }
    if ((paramProfileCardInfo.card != null) && (!paramProfileCardInfo.card.isNoCover()) && (!paramProfileCardInfo.isQQGuildCard))
    {
      this.d.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      this.e.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
    }
    else
    {
      this.d.setShadowLayer(0.0F, 0.0F, 0.0F, this.e.getCurrentTextColor());
      localObject1 = this.e;
      ((ColorNickTextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, ((ColorNickTextView)localObject1).getCurrentTextColor());
    }
    this.b = new NickWrapper.NickString((String)localObject2, (int)(this.d.getTextSize() / this.n));
    localObject3 = this.b.c(4);
    this.b.b(4);
    str = String.format("%s:%s", new Object[] { this.l.getString(2131888119), this.b });
    if ((!Utils.c(paramProfileCardInfo.allInOne.uin)) && (!paramProfileCardInfo.isTroopMemberCard))
    {
      this.k = 3;
      localObject2 = this.b.toString();
      this.d.setText((CharSequence)localObject2);
      this.d.setSingleLine(true);
      this.d.setMaxLines(1);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.g.setVisibility(8);
      localObject1 = this.d.getPaint();
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localObject1 == null)
      {
        paramQQAppInterface = new TextPaint(1);
        paramQQAppInterface.density = this.n;
        paramQQAppInterface.setTextSize(this.d.getTextSize());
      }
      if (paramQQAppInterface.measureText((String)localObject2) >= this.c) {
        this.d.setTextSize(1, this.q);
      }
    }
    else
    {
      localResources = this.l.getResources();
      this.g.setVisibility(0);
      localObject1 = this.g.findViewById(2131428898);
      if (Utils.c(paramProfileCardInfo.allInOne.uin))
      {
        ((View)localObject1).setVisibility(0);
        f1 = localResources.getDimensionPixelSize(2131298265) + 0.0F;
      }
      else
      {
        ((View)localObject1).setVisibility(8);
        f1 = 0.0F;
      }
      localViewGroup = (ViewGroup)this.g.findViewById(2131430374);
      if (paramProfileCardInfo.isTroopMemberCard)
      {
        if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramProfileCardInfo.troopUin))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("call old level troopUin : ");
            ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
          }
          localTextView = (TextView)localViewGroup.findViewById(2131430373);
          a(paramQQAppInterface, paramProfileCardInfo, localViewGroup, localTextView);
          localObject2 = localTextView.getPaint();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new TextPaint(1);
            ((TextPaint)localObject1).density = this.n;
          }
          f2 = f1;
          if (localViewGroup.getVisibility() != 0) {
            break label1049;
          }
          f2 = f1 + ((TextPaint)localObject1).measureText(localTextView.getText().toString()) + localTextView.getPaddingLeft();
          f1 = localTextView.getPaddingRight();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("call new level troopUin : ");
            ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (TroopMemberNewLevelView)findViewById(2131448037);
          f2 = f1;
          if (localObject1 == null) {
            break label1049;
          }
          a(paramQQAppInterface, paramProfileCardInfo, (TroopMemberNewLevelView)localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("call old level troopUin : ");
            ((StringBuilder)localObject2).append(paramProfileCardInfo.troopUin);
            if (((TroopMemberNewLevelView)localObject1).getVisibility() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((StringBuilder)localObject2).append(String.valueOf(bool));
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject2).toString());
          }
          f2 = f1;
          if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
            break label1049;
          }
          f3 = ((TroopMemberNewLevelView)localObject1).getExpectedWidth() + ViewUtils.dip2px(2.0F);
          f2 = f1;
          f1 = f3;
        }
        f2 += f1;
        label1049:
        localObject1 = (TroopHonorView)this.g.findViewById(2131430377);
        a(paramQQAppInterface, paramProfileCardInfo, (TroopHonorView)localObject1, this.c - f2);
        f1 = f2;
        if (((TroopHonorView)localObject1).getVisibility() == 0) {
          f1 = f2 + ((TroopHonorView)localObject1).getExpectedWidth();
        }
      }
      else
      {
        localViewGroup.setVisibility(8);
      }
      i2 = localResources.getDimensionPixelSize(2131298266);
      f2 = f1 + i2;
      this.d.setSingleLine();
      localObject2 = this.d.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.n;
        ((TextPaint)localObject1).setTextSize(this.d.getTextSize());
      }
      f3 = ((NickWrapper.NickString)localObject3).a((Paint)localObject1);
      if (f3 + f2 < this.c)
      {
        a(paramQQAppInterface, this.d, this.b.c());
        this.e.setVisibility(8);
        paramQQAppInterface = this.d;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.c) }));
        }
        this.k = 1;
      }
      else
      {
        ((TextPaint)localObject1).setTextSize(ScreenUtil.dip2px(this.q));
        f1 = ((NickWrapper.NickString)localObject3).a((Paint)localObject1);
        i1 = this.c;
        if (f1 + f2 < i1)
        {
          this.d.setTextSize(1, this.q);
          a(paramQQAppInterface, this.d, this.b.c());
          this.e.setVisibility(8);
          paramQQAppInterface = this.d;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.c) }));
          }
          this.k = 1;
        }
        else if (f3 < i1)
        {
          a(paramQQAppInterface, this.d, this.b.c());
          this.e.setVisibility(8);
          paramQQAppInterface = this.e;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.c) }));
          }
          this.k = 2;
        }
        else if (f1 < i1)
        {
          this.d.setTextSize(1, this.q);
          a(paramQQAppInterface, this.d, this.b.c());
          this.e.setVisibility(8);
          paramQQAppInterface = this.e;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.c) }));
          }
          this.k = 2;
        }
        else if (paramProfileCardInfo.isTroopMemberCard)
        {
          localObject2 = this.b.c();
          if ((!((String)localObject2).contains("<")) && (paramProfileCardInfo.troopMemberCard.colorCardId <= 0))
          {
            this.k = 2;
            localObject1 = this.e;
            this.d.setTextSize(1, this.q);
            this.d.setEllipsize(null);
            this.e.setTextSize(1, this.q);
            this.e.setVisibility(0);
            f4 = this.c - ScreenUtil.dip2px(4.0F);
            i1 = 1;
            for (f1 = 0.0F; (f1 <= f4) && (i1 < ((String)localObject2).length()); f1 = a((TextView)localObject3, ((String)localObject2).substring(0, i1), this.d.getPaint()))
            {
              localObject3 = this.d;
              i1 += 1;
            }
            localObject3 = this.e;
            i3 = i1 - 1;
            f1 = a((TextView)localObject3, ((String)localObject2).substring(i3), this.e.getPaint()) + this.e.getPaddingLeft() + this.e.getPaddingRight();
            if (f1 + f2 > f4)
            {
              f1 = f4 - f2;
              if (f1 < a(this.e, ((String)localObject2).substring(i3, i1 + 1), this.e.getPaint()))
              {
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.e.setVisibility(8);
                a(paramQQAppInterface, this.d, (String)localObject2);
              }
              else
              {
                this.e.setWidth((int)f1);
                localObject3 = ((String)localObject2).substring(0, i3);
                localObject2 = ((String)localObject2).substring(i3);
                a(paramQQAppInterface, this.d, (String)localObject3);
                a(paramQQAppInterface, this.e, (String)localObject2);
              }
            }
            else
            {
              this.e.setWidth((int)f1);
              localObject3 = ((String)localObject2).substring(0, i3);
              localObject2 = ((String)localObject2).substring(i3);
              a(paramQQAppInterface, this.d, (String)localObject3);
              a(paramQQAppInterface, this.e, (String)localObject2);
            }
            if (QLog.isColorLevel()) {
              QLog.i("ProfileNameView", 2, String.format("update 5 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.c) }));
            }
            paramQQAppInterface = (QQAppInterface)localObject1;
          }
          else
          {
            this.k = 1;
            a(paramQQAppInterface, this.d, (String)localObject2);
            this.d.setCustomCloth(paramProfileCardInfo.troopMemberCard.colorCardId);
          }
        }
        else
        {
          this.k = 2;
          this.d.setTextSize(1, this.q);
          this.d.setEllipsize(TextUtils.TruncateAt.END);
          this.d.setWidth((int)(this.c - f2));
          localObject1 = this.d;
          a(paramQQAppInterface, (TextView)localObject1, this.b.c());
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
      localObject2 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, paramQQAppInterface.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, paramQQAppInterface.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, paramQQAppInterface.getId());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i2;
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else if (paramQQAppInterface == this.e)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.d.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 0);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i2;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
        this.g.setMinimumHeight(0);
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.f.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, this.f.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.f.getId());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i2;
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    setContentDescription(str);
    setTag(new DataTag(88, this.b.toString()));
    setOnClickListener(this.r);
    if (!ProfilePAUtils.isFromGuild(paramProfileCardInfo.allInOne.pa)) {
      LongClickCopyAction.attachCopyAction(this, getResources().getString(2131888244), this.b.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.c), this.b.toString() }));
    }
    return;
    setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("update failed troopUin : ");
      if (paramProfileCardInfo != null) {
        paramQQAppInterface = paramProfileCardInfo.troopUin;
      } else {
        paramQQAppInterface = "";
      }
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public ETTextViewPlus getEtNameView()
  {
    if (this.f != null)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      return this.f;
    }
    return null;
  }
  
  public int getLayoutWidth()
  {
    int i2 = this.f.getPaddingLeft() + (int)this.f.getPaint().measureText(this.f.getText().toString()) + this.f.getPaddingRight();
    Object localObject = (TextView)findViewById(2131430373);
    int i1 = i2;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i1 = i2;
      if (!TextUtils.isEmpty(((TextView)localObject).getText())) {
        i1 = (int)(i2 + (ViewUtils.dpToPx(4.0F) + ((TextView)localObject).getPaddingLeft() + ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString()) + ((TextView)localObject).getPaddingRight()));
      }
    }
    localObject = (TroopHonorView)this.g.findViewById(2131430377);
    i2 = i1;
    if (((TroopHonorView)localObject).getVisibility() == 0) {
      i2 = i1 + (((TroopHonorView)localObject).getPaddingLeft() + ((TroopHonorView)localObject).getExpectedWidth() + ((TroopHonorView)localObject).getPaddingRight());
    }
    localObject = (TroopMemberNewLevelView)this.g.findViewById(2131448037);
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (((TroopMemberNewLevelView)localObject).getVisibility() == 0) {
        i1 = (int)(i2 + (((TroopMemberNewLevelView)localObject).getExpectedWidth() + ViewUtils.dip2px(2.0F)));
      }
    }
    return i1;
  }
  
  public int getMode()
  {
    return this.k;
  }
  
  public int getTextColor()
  {
    return this.d.getCurrentTextColor();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof View))
    {
      paramInt1 = ((View)localViewParent).getMeasuredWidth();
      if (this.c < paramInt1) {
        this.c = paramInt1;
      }
    }
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.r = paramOnClickListener;
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      this.d.setTextColor(this.j);
      this.e.setTextColor(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView
 * JD-Core Version:    0.7.0.1
 */