package com.tencent.timi.game.smoba.impl.util.gamecore;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.Logger;

public class GameCoreUtil
{
  public static boolean a(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, GameInstallCheckCallback paramGameInstallCheckCallback)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "游戏";
    }
    if (!SchemeUtil.a(paramString2))
    {
      if (paramBoolean)
      {
        paramString1 = new StringBuilder();
        paramString1.append("isGameInstalled showDialog  - ");
        paramString1.append(str);
        paramString1.append(" - ");
        paramString1.append(paramString3);
        Logger.a("GameCoreUtil", paramString1.toString());
        paramString1 = new CommonDialog.Builder(paramActivity);
        paramString2 = new StringBuilder();
        paramString2.append("未安装");
        paramString2.append(str);
        paramString1 = paramString1.a(paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append("需要先安装");
        paramString2.append(str);
        paramString2.append("，才能一起开黑哦");
        paramString1.c(paramString2.toString()).d("去下载").a(new GameCoreUtil.2(paramGameInstallCheckCallback, paramActivity, paramString3, str)).e("晚点再说").b(new GameCoreUtil.1(paramGameInstallCheckCallback)).a().show();
        if (paramGameInstallCheckCallback != null) {
          paramGameInstallCheckCallback.a();
        }
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.gamecore.GameCoreUtil
 * JD-Core Version:    0.7.0.1
 */