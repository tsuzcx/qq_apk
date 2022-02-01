package com.tencent.mobileqq.troop.widget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import mqq.app.AppRuntime;

class TroopGameCardView$2
  extends TroopGameObserver
{
  TroopGameCardView$2(TroopGameCardView paramTroopGameCardView) {}
  
  public void a(String paramString, int paramInt, TroopGameActivityInfo paramTroopGameActivityInfo)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    TroopGameCardView.a(this.a, paramTroopGameActivityInfo);
    this.a.a(paramTroopGameActivityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.2
 * JD-Core Version:    0.7.0.1
 */