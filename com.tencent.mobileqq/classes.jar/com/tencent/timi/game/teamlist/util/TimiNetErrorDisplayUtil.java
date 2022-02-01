package com.tencent.timi.game.teamlist.util;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

public class TimiNetErrorDisplayUtil
{
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("timiErrCode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("\ntimiSubErrCode");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("\ntimiErrMsg");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("timiDisplayErrMsg\n");
    localStringBuilder.append(paramString3);
    Logger.c(paramString1, localStringBuilder.toString());
    CustomToastView.a(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.util.TimiNetErrorDisplayUtil
 * JD-Core Version:    0.7.0.1
 */