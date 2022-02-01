package com.tencent.mobileqq.troop.temporaryban;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.temporaryban.config.TemporarilyBannedTroopTipsConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TemporarilyBannedTroopTipHelper
{
  private DialogInterface.OnClickListener a(String paramString1, Context paramContext, String paramString2)
  {
    if (paramString1.equals("miniapp")) {
      return c(paramContext, paramString2);
    }
    return b();
  }
  
  public static TemporarilyBannedTroopTipHelper a()
  {
    return TemporarilyBannedTroopTipHelper.Holder.a();
  }
  
  private void a(Context paramContext, TemporarilyBannedTroopTipsItem paramTemporarilyBannedTroopTipsItem, String paramString)
  {
    String str1 = paramTemporarilyBannedTroopTipsItem.b;
    String str2 = paramTemporarilyBannedTroopTipsItem.a;
    if (paramTemporarilyBannedTroopTipsItem.c.size() == 1)
    {
      paramTemporarilyBannedTroopTipsItem = (TemporarilyBannedTroopTipsBtn)paramTemporarilyBannedTroopTipsItem.c.get(0);
      paramString = a(paramTemporarilyBannedTroopTipsItem.b, paramContext, paramString);
      DialogUtil.a(paramContext, 230, str2, str1, paramTemporarilyBannedTroopTipsItem.a, null, null, paramString).show();
      return;
    }
    if (paramTemporarilyBannedTroopTipsItem.c.size() > 1)
    {
      TemporarilyBannedTroopTipsBtn localTemporarilyBannedTroopTipsBtn = (TemporarilyBannedTroopTipsBtn)paramTemporarilyBannedTroopTipsItem.c.get(0);
      paramTemporarilyBannedTroopTipsItem = (TemporarilyBannedTroopTipsBtn)paramTemporarilyBannedTroopTipsItem.c.get(1);
      DialogInterface.OnClickListener localOnClickListener = a(localTemporarilyBannedTroopTipsBtn.b, paramContext, paramString);
      paramString = a(paramTemporarilyBannedTroopTipsItem.b, paramContext, paramString);
      DialogUtil.a(paramContext, 230, str2, str1, localTemporarilyBannedTroopTipsBtn.a, paramTemporarilyBannedTroopTipsItem.a, paramString, localOnClickListener).show();
      return;
    }
    QLog.e("OpenTemporarilyBannedTroopHelper", 1, "TemporarilyBannedTroopTipHelper Config Error!");
  }
  
  private void a(Context paramContext, TemporarilyBannedTroopTipsConfig paramTemporarilyBannedTroopTipsConfig, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramTemporarilyBannedTroopTipsConfig.a, paramString);
      return;
    }
    a(paramContext, paramTemporarilyBannedTroopTipsConfig.b, paramString);
  }
  
  private void a(Context paramContext, String paramString)
  {
    DialogUtil.a(paramContext, 230, null, paramContext.getString(2131892345), paramContext.getString(2131892346), paramContext.getString(2131892347), c(paramContext, paramString), b()).show();
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramString);
      return;
    }
    b(paramContext, paramString);
  }
  
  private boolean a(AppInterface paramAppInterface, String paramString)
  {
    paramString = ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    boolean bool2 = false;
    if (paramString == null)
    {
      QLog.e("OpenTemporarilyBannedTroopHelper", 1, "showTips troopInfo null!");
      return false;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramAppInterface))
    {
      bool1 = bool2;
      if (paramAppInterface.equals(paramString.troopowneruin)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private DialogInterface.OnClickListener b()
  {
    return new TemporarilyBannedTroopTipHelper.1(this);
  }
  
  private void b(Context paramContext, String paramString)
  {
    DialogUtil.a(paramContext, 230, null, paramContext.getString(2131892344), paramContext.getString(2131892343), null, null, b()).show();
  }
  
  private DialogInterface.OnClickListener c(Context paramContext, String paramString)
  {
    return new TemporarilyBannedTroopTipHelper.2(this, paramContext, paramString);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if ((paramAppInterface != null) && ((paramContext instanceof Activity)) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pkgOther%2Fpages%2Fscene_dismissed%2Findex&_vt=3&via=tencent_csd&_sig=2171357820&_nq=type%3Dpermanent_block%26function_type%3D1%26group_code%3D");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      boolean bool = a(paramAppInterface, paramString);
      paramAppInterface = (TemporarilyBannedTroopTipsConfig)QConfigManager.b().b(755);
      if ((paramAppInterface != null) && (paramAppInterface.a != null) && (paramAppInterface.b != null))
      {
        a(paramContext, paramAppInterface, (String)localObject, bool);
        return;
      }
      a(paramContext, (String)localObject, bool);
      return;
    }
    QLog.e("OpenTemporarilyBannedTroopHelper", 1, "showTips arg error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.TemporarilyBannedTroopTipHelper
 * JD-Core Version:    0.7.0.1
 */