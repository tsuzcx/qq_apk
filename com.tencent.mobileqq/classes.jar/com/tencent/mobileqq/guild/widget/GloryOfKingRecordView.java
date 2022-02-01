package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameGloryKingData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GloryOfKingRecordView
  extends LinearLayout
{
  private final int a = 792;
  private final int b = 90;
  private final int c = 113;
  private volatile boolean d;
  private ViewGroup e;
  private LinearLayout f;
  
  public GloryOfKingRecordView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GloryOfKingRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GloryOfKingRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    int i = getMeasuredWidth();
    if (i > 0)
    {
      float f1 = i / 792;
      i = (int)(90.0F * f1);
      int j = (int)(f1 * 113.0F);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.f.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = j;
      this.f.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(Context paramContext)
  {
    this.e = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131625106, this));
    this.f = ((LinearLayout)this.e.findViewById(2131444161));
  }
  
  public void a(GuildProfileGameGloryKingData paramGuildProfileGameGloryKingData, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showGameGloryKingUI gloryKingData: ");
      ((StringBuilder)localObject1).append(paramGuildProfileGameGloryKingData);
      QLog.i("GloryOfKingRecordView", 1, ((StringBuilder)localObject1).toString());
    }
    ITroopGameCardUtilsApi localITroopGameCardUtilsApi = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
    Object localObject2 = paramGuildProfileGameGloryKingData.d();
    Object localObject1 = null;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localITroopGameCardUtilsApi.getImageBitmap((String)localObject2);
    }
    ImageView localImageView;
    if (paramGuildProfileGameGloryKingData.b())
    {
      localImageView = (ImageView)this.e.findViewById(2131446288);
      localObject2 = localImageView;
      if (!TextUtils.isEmpty(paramGuildProfileGameGloryKingData.c()))
      {
        ((TextView)this.e.findViewById(2131446294)).setText(paramGuildProfileGameGloryKingData.c());
        localObject2 = localImageView;
      }
    }
    else
    {
      localImageView = (ImageView)this.e.findViewById(2131444163);
      String str = paramGuildProfileGameGloryKingData.f();
      localObject2 = localImageView;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localITroopGameCardUtilsApi.getImageBitmap(str);
        ((ImageView)this.e.findViewById(2131444162)).setImageBitmap((Bitmap)localObject2);
        localObject2 = localImageView;
      }
    }
    if (localObject1 != null) {
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    }
    localObject1 = paramGuildProfileGameGloryKingData.e();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localITroopGameCardUtilsApi.getImageBitmap((String)localObject1);
      if (localObject2 != null) {
        ((ImageView)this.e.findViewById(2131444160)).setImageBitmap((Bitmap)localObject2);
      }
    }
    localObject2 = paramGuildProfileGameGloryKingData.a();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)this.e.findViewById(2131444164)).setText((CharSequence)localObject2);
    }
    localObject1 = paramGuildProfileGameGloryKingData.g();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)this.e.findViewById(2131447793)).setText((CharSequence)localObject1);
    }
    localObject1 = paramGuildProfileGameGloryKingData.h();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)this.e.findViewById(2131439093)).setText((CharSequence)localObject1);
    }
    localObject1 = paramGuildProfileGameGloryKingData.i();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)this.e.findViewById(2131450185)).setText((CharSequence)localObject1);
    }
    localObject1 = paramGuildProfileGameGloryKingData.j();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)this.e.findViewById(2131434301)).setText((CharSequence)localObject1);
    }
    localObject1 = paramGuildProfileGameGloryKingData.k();
    if ((paramAppInterface != null) && (localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int j = ((List)localObject1).size();
      int i = 0;
      while (i < j)
      {
        if (i == 0)
        {
          paramGuildProfileGameGloryKingData = (ImageView)this.e.findViewById(2131445114);
        }
        else if (i == 1)
        {
          paramGuildProfileGameGloryKingData = (ImageView)this.e.findViewById(2131445115);
        }
        else
        {
          if (i != 2) {
            break;
          }
          paramGuildProfileGameGloryKingData = (ImageView)this.e.findViewById(2131445116);
        }
        int k = ViewUtils.dpToPx(19.5F);
        paramAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramAppInterface.mRequestWidth = k;
        paramAppInterface.mRequestHeight = k;
        paramAppInterface = URLDrawable.getDrawable((String)((List)localObject1).get(i), paramAppInterface);
        if (paramAppInterface != null)
        {
          paramAppInterface.setTag(new int[] { k, k, k / 2 });
          paramAppInterface.setDecodeHandler(QQGuildUtil.c);
          paramGuildProfileGameGloryKingData.setImageDrawable(paramAppInterface);
        }
        i += 1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GloryOfKingRecordView
 * JD-Core Version:    0.7.0.1
 */