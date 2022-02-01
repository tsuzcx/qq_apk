package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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
    TroopManager localTroopManager;
    if (paramBoolean1)
    {
      setTextColor(paramInt2);
      if (paramInt1 != -1)
      {
        localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager == null) {
          break label199;
        }
      }
    }
    label199:
    for (paramQQAppInterface = localTroopManager.a(paramInt1, paramString);; paramQQAppInterface = null)
    {
      QQAppInterface localQQAppInterface = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = TroopUtils.a(getResources(), paramInt1);
        localQQAppInterface = paramQQAppInterface;
        if (localTroopManager != null)
        {
          localTroopManager.a(paramInt1, paramString, paramQQAppInterface);
          localQQAppInterface = paramQQAppInterface;
        }
      }
      setBackgroundDrawable(localQQAppInterface);
      if (getVisibility() != 0) {
        setVisibility(0);
      }
      setText(paramString);
      setContentDescription(HardCodeUtil.a(2131701039) + paramString);
      paramQQAppInterface = AIOLongShotHelper.a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramQQAppInterface.b())) {
        setMosaicEffect(new MosaicEffect(10));
      }
      do
      {
        do
        {
          return;
          setMosaicEffect(null);
          return;
        } while (this == null);
        if (getVisibility() != 8) {
          setVisibility(8);
        }
      } while (this == null);
      setMosaicEffect(null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelView
 * JD-Core Version:    0.7.0.1
 */