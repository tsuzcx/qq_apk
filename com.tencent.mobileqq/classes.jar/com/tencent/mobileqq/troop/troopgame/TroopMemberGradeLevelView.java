package com.tencent.mobileqq.troop.troopgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberGradeLevelView
  extends LinearLayout
{
  private static final int e = ViewUtils.dip2px(16.0F);
  private static final int f = ViewUtils.dip2px(16.0F);
  private int a = -1;
  private final int b = 8;
  private final String c = ".png";
  private final ImageView d;
  
  public TroopMemberGradeLevelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopMemberGradeLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopMemberGradeLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    this.d = new ImageView(paramContext);
    addView(this.d);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 8: 
      if (paramInt2 > 5)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("8");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("7");
      return localStringBuilder.toString();
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("6");
      return localStringBuilder.toString();
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("5");
      return localStringBuilder.toString();
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("4");
      return localStringBuilder.toString();
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("3");
      return localStringBuilder.toString();
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("2");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 9: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("1");
        return ((StringBuilder)localObject).toString();
      case 8: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("2");
        return ((StringBuilder)localObject).toString();
      case 7: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("3");
        return ((StringBuilder)localObject).toString();
      case 6: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("4");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("5");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void a(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(e, f);
    paramMemberGradeLevelInfo = VasUtil.a().getGameCardManager().getCardResPath(2, paramMemberGradeLevelInfo.gameCardId);
    if (TextUtils.isEmpty(paramMemberGradeLevelInfo))
    {
      this.d.setImageDrawable(null);
      return;
    }
    paramMemberGradeLevelInfo = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramMemberGradeLevelInfo, new ApngOptions(), paramMemberGradeLevelInfo);
    this.d.setLayoutParams(localLayoutParams);
    if (paramMemberGradeLevelInfo != null)
    {
      this.d.setImageDrawable(paramMemberGradeLevelInfo);
      setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberGradeLevelView", 2, "new_game_card aio bitmap null");
    }
    this.d.setImageDrawable(null);
  }
  
  public void b(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    setVisibility(8);
    this.a = paramMemberGradeLevelInfo.gradeLevel;
    paramMemberGradeLevelInfo = new LinearLayout.LayoutParams(e, f);
    Bitmap localBitmap = getImageBitmap();
    this.d.setLayoutParams(paramMemberGradeLevelInfo);
    if (localBitmap != null)
    {
      this.d.setImageBitmap(localBitmap);
      setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel bitmap is null");
    }
    this.d.setImageBitmap(null);
  }
  
  public Bitmap getImageBitmap()
  {
    int j = this.a;
    if (j <= 0) {
      return null;
    }
    int i = j / 100000;
    j = j % 100000 / 10000;
    Object localObject1 = TroopGameCardResDownloadManager.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("aio_game_grade_");
    localObject2 = a(i, j, ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return null;
    }
    localObject1 = localObject2;
    if (i != 8)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_");
      localObject2 = a(j, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return null;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".png");
    localObject1 = ((StringBuilder)localObject2).toString();
    return ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject1);
  }
  
  public void setTroopMemberGradeLevel(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    if (paramMemberGradeLevelInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "new_game_card info is null");
      }
      setVisibility(8);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_game_card memUin: ");
      localStringBuilder.append(paramMemberGradeLevelInfo.toString());
      QLog.d("TroopMemberGradeLevelView", 2, localStringBuilder.toString());
    }
    if ((paramMemberGradeLevelInfo.gameCardSwitch == 1) && (paramMemberGradeLevelInfo.gradeLevel > 0))
    {
      b(paramMemberGradeLevelInfo);
      return;
    }
    a(paramMemberGradeLevelInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView
 * JD-Core Version:    0.7.0.1
 */