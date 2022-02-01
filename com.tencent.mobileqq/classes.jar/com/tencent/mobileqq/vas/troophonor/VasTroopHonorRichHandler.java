package com.tencent.mobileqq.vas.troophonor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelEffectView;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;

public class VasTroopHonorRichHandler
{
  public void a(int paramInt, byte paramByte, TroopMemberRankItem paramTroopMemberRankItem)
  {
    Object localObject;
    if (TroopHonorUtils.a(4, paramByte) == 1)
    {
      String str;
      switch (paramInt)
      {
      default: 
        paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_4.png";
        str = "#798CBF";
        localObject = "#A9BEF2";
        break;
      case 302: 
        paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_3.png";
        str = "#B766FF";
        localObject = "#FF83D5";
        break;
      case 301: 
        paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_2.png";
        str = "#00BEDB";
        localObject = "#0EE0CE";
        break;
      case 300: 
        paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_1.png";
        str = "#FF9000";
        localObject = "#FFD325";
      }
      paramTroopMemberRankItem.a = new int[] { Color.parseColor(str), Color.parseColor((String)localObject) };
    }
    else
    {
      paramTroopMemberRankItem.b = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("honor_rich_handleRichLevel,");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramTroopMemberRankItem.b);
      QLog.d("TroopHonor", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ApngOptions localApngOptions = new ApngOptions();
      localApngOptions.a(URLDrawableHelperConstants.a);
      localApngOptions.a(new int[] { 0 });
      paramString = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions);
      if (paramString != null)
      {
        paramContext = new TroopMemberLevelEffectView(paramContext);
        paramContext.setLayoutParams(new RelativeLayout.LayoutParams(paramInt, ViewUtils.a(14.0F)));
        paramContext.setScaleType(ImageView.ScaleType.FIT_START);
        paramContext.setLeftCropRect(new Rect(0, 0, ViewUtils.a(51.0F), ViewUtils.a(14.0F)));
        paramContext.setCurrentDrawable(paramString);
        paramViewGroup.addView(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troophonor.VasTroopHonorRichHandler
 * JD-Core Version:    0.7.0.1
 */