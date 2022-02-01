package com.tencent.timi.game.tgpa;

import android.content.Context;
import com.tencent.timi.game.tgpa.helper.TGPAInnerHelper;
import com.tencent.timi.game.tgpa.service.TgpaInterProcessService;

public class TGPAUtil
{
  public static void a()
  {
    TGPAInnerHelper.a().d();
  }
  
  public static void a(Context paramContext)
  {
    TgpaInterProcessService.a(paramContext);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    TgpaInterProcessService.a(paramContext, paramBoolean);
  }
  
  public static void a(TGPAUtil.TGPAGameDataCallback paramTGPAGameDataCallback)
  {
    TGPAInnerHelper.a().a(paramTGPAGameDataCallback);
  }
  
  public static void b(TGPAUtil.TGPAGameDataCallback paramTGPAGameDataCallback)
  {
    TGPAInnerHelper.a().b(paramTGPAGameDataCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.TGPAUtil
 * JD-Core Version:    0.7.0.1
 */