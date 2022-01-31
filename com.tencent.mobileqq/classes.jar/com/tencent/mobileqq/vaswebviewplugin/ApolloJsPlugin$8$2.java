package com.tencent.mobileqq.vaswebviewplugin;

import aiwi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloJsPlugin$8$2
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$8$2(ApolloJsPlugin.8 param8, aiwi paramaiwi, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.val$checker != null) {
      this.val$checker.a(this.val$startCheckParam);
    }
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm", 0, 3, new String[] { String.valueOf(this.val$startCheckParam.game.gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.8.2
 * JD-Core Version:    0.7.0.1
 */