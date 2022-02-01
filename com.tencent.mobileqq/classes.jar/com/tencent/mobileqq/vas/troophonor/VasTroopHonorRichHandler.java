package com.tencent.mobileqq.vas.troophonor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelEffectView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberRankItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;

public class VasTroopHonorRichHandler
{
  public void a(int paramInt, byte paramByte, TroopMemberRankItem paramTroopMemberRankItem)
  {
    String str2;
    String str1;
    if (TroopHonorUtils.a(4, paramByte) == 1) {
      switch (paramInt)
      {
      default: 
        str2 = "#798CBF";
        str1 = "#A9BEF2";
        paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_4.png";
        paramTroopMemberRankItem.a = new int[] { Color.parseColor(str2), Color.parseColor(str1) };
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor", 2, "honor_rich_handleRichLevel," + paramInt + " " + paramTroopMemberRankItem.b);
      }
      return;
      str2 = "#FF9000";
      str1 = "#FFD325";
      paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_1.png";
      break;
      str2 = "#00BEDB";
      str1 = "#0EE0CE";
      paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_2.png";
      break;
      str2 = "#B766FF";
      str1 = "#FF83D5";
      paramTroopMemberRankItem.b = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_3.png";
      break;
      paramTroopMemberRankItem.b = null;
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      VasApngFactory.Options localOptions = new VasApngFactory.Options();
      localOptions.a(URLDrawableHelper.TRANSPARENT);
      localOptions.a(new int[] { 0 });
      paramString = VasApngFactory.a(paramString, localOptions);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troophonor.VasTroopHonorRichHandler
 * JD-Core Version:    0.7.0.1
 */