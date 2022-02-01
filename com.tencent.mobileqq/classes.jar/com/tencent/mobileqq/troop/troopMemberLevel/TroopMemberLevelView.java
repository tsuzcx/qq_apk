package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.MosaicEffect;

public class TroopMemberLevelView
  extends ColorNickTextView
{
  public TroopMemberLevelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopMemberLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setTroopMemberLevel(QQAppInterface paramQQAppInterface, boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramBoolean1)
    {
      setTextColor(paramInt2);
      if (paramInt1 != -1)
      {
        IBizTroopMemberInfoService localIBizTroopMemberInfoService = (IBizTroopMemberInfoService)paramQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "");
        if (localIBizTroopMemberInfoService != null) {
          paramQQAppInterface = localIBizTroopMemberInfoService.getTroopMemberLevelDrawable(paramInt1, paramString);
        } else {
          paramQQAppInterface = null;
        }
        QQAppInterface localQQAppInterface = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = BizTroopUtil.a(getResources(), paramInt1);
          localQQAppInterface = paramQQAppInterface;
          if (localIBizTroopMemberInfoService != null)
          {
            localIBizTroopMemberInfoService.saveTroopMemberLevelDrawable(paramInt1, paramString, paramQQAppInterface);
            localQQAppInterface = paramQQAppInterface;
          }
        }
        setBackgroundDrawable(localQQAppInterface);
      }
      if (getVisibility() != 0) {
        setVisibility(0);
      }
      setText(paramString);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(HardCodeUtil.a(2131899197));
      paramQQAppInterface.append(paramString);
      setContentDescription(paramQQAppInterface.toString());
      paramQQAppInterface = AIOLongShotHelper.f();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.c()) && (paramQQAppInterface.d()))
      {
        setMosaicEffect(new MosaicEffect(10));
        return;
      }
      setMosaicEffect(null);
      return;
    }
    if (getVisibility() != 8) {
      setVisibility(8);
    }
    setMosaicEffect(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelView
 * JD-Core Version:    0.7.0.1
 */