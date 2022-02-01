package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.emoticon.api.IAniStickerTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class SysEmoAniStickerAIOOperation
  implements IAniStickerAIOOperation
{
  protected Context a;
  protected BaseQQAppInterface b;
  protected BaseSessionInfo c;
  
  public SysEmoAniStickerAIOOperation(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    this.a = paramContext;
    this.b = paramBaseQQAppInterface;
    this.c = paramBaseSessionInfo;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 2131431492) {
      return 1;
    }
    if (paramInt == 2131433636) {
      return 2;
    }
    if (paramInt == 2131438943) {
      return 3;
    }
    if (paramInt == 2131432813) {
      return 4;
    }
    if (paramInt == 2131439015) {
      return 5;
    }
    if (paramInt == 2131444634) {
      return 6;
    }
    if (paramInt == 2131431695) {
      return 7;
    }
    if (paramInt == 2131450309) {
      return 8;
    }
    if (paramInt == 2131432607) {
      return 9;
    }
    if (paramInt == 2131444651) {
      return 10;
    }
    if (paramInt == 2131428089) {
      return 11;
    }
    return 0;
  }
  
  protected void a(int paramInt, MessageForAniSticker paramMessageForAniSticker)
  {
    if (paramMessageForAniSticker.isAniStickerRandom()) {
      paramMessageForAniSticker = "0X800BCD1";
    } else {
      paramMessageForAniSticker = "0X800BBDA";
    }
    paramInt = a(paramInt);
    ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", paramMessageForAniSticker, paramMessageForAniSticker, paramInt, 0, "", "", "", "");
  }
  
  protected void a(MessageForAniSticker paramMessageForAniSticker)
  {
    ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).launchWriteTogether(paramMessageForAniSticker, this.a);
  }
  
  protected void a(MessageForAniSticker paramMessageForAniSticker, String paramString)
  {
    ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).forwardMsg(this.a, this.b, paramMessageForAniSticker, this.c);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, MessageForAniSticker paramMessageForAniSticker)
  {
    ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).checkAndAddTogetherWriteMenu(this.b, this.c, this.a, paramMessageForAniSticker, paramQQCustomMenu);
  }
  
  public int aniStickerType()
  {
    return 1;
  }
  
  protected void b(MessageForAniSticker paramMessageForAniSticker)
  {
    ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).addFavoriteForAniSticker(this.a, this.b, paramMessageForAniSticker);
  }
  
  protected void b(MessageForAniSticker paramMessageForAniSticker, String paramString)
  {
    paramMessageForAniSticker = paramMessageForAniSticker.getSummaryMsg();
    if (paramMessageForAniSticker != null) {
      try
      {
        ((ClipboardManager)this.a.getSystemService("clipboard")).setText(paramMessageForAniSticker);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("Copy message, msg=");
          paramString.append(paramMessageForAniSticker);
          QLog.d("SysEmoAniStickerAIOOperation", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramMessageForAniSticker)
      {
        QLog.e("SysEmoAniStickerAIOOperation", 2, paramMessageForAniSticker.toString());
      }
    }
  }
  
  protected void c(MessageForAniSticker paramMessageForAniSticker)
  {
    ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).delMsg(this.a, this.b, paramMessageForAniSticker);
  }
  
  public void getCustomMenuItem(QQCustomMenu paramQQCustomMenu, MessageForAniSticker paramMessageForAniSticker)
  {
    if ((paramMessageForAniSticker != null) && (paramQQCustomMenu != null))
    {
      paramQQCustomMenu.a(2131431492, HardCodeUtil.a(2131888241), 2130839057);
      paramQQCustomMenu.a(2131433636, this.a.getString(2131889668), 2130839066);
      paramQQCustomMenu.a(2131432813, this.a.getString(2131889171), 2130839065);
      if (this.c.a == 1) {
        a(paramQQCustomMenu, paramMessageForAniSticker);
      }
    }
  }
  
  public HashMap<Integer, Bundle> getDefaultMenuItem(MessageForAniSticker paramMessageForAniSticker)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(2131444634), new Bundle());
    localHashMap.put(Integer.valueOf(2131444651), new Bundle());
    if ((paramMessageForAniSticker != null) && (paramMessageForAniSticker.extraflag != 32768) && (!((MessageCache)this.b.getMsgCache()).f(paramMessageForAniSticker))) {
      localHashMap.put(Integer.valueOf(2131438943), new Bundle());
    }
    localHashMap.put(Integer.valueOf(2131449133), new Bundle());
    localHashMap.put(Integer.valueOf(2131431695), new Bundle());
    localHashMap.put(Integer.valueOf(2131439015), new Bundle());
    localHashMap.put(Integer.valueOf(2131428089), new Bundle());
    return localHashMap;
  }
  
  public void onClick(View paramView, MessageForAniSticker paramMessageForAniSticker)
  {
    if (paramMessageForAniSticker.checkMsgCanPreview()) {
      ((IAniStickerTempApi)QRoute.api(IAniStickerTempApi.class)).openTextPreview(paramView, this.b, (Activity)this.a, this.c);
    }
  }
  
  public boolean onMenuItemClicked(int paramInt, Context paramContext, MessageForAniSticker paramMessageForAniSticker)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.b;
    String str = "";
    paramContext = str;
    if (localBaseQQAppInterface != null)
    {
      paramContext = localBaseQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(paramContext)) {
        paramContext = str;
      }
    }
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 2131431695)
    {
      c(paramMessageForAniSticker);
      bool1 = bool2;
    }
    else if (paramInt == 2131431492)
    {
      b(paramMessageForAniSticker, paramContext);
      bool1 = bool2;
    }
    else if (paramInt == 2131433636)
    {
      a(paramMessageForAniSticker, paramContext);
      bool1 = bool2;
    }
    else if (paramInt == 2131432813)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        b(paramMessageForAniSticker);
        bool1 = bool2;
      }
    }
    else if (paramInt == 2131450309)
    {
      a(paramMessageForAniSticker);
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    a(paramInt, paramMessageForAniSticker);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SysEmoAniStickerAIOOperation
 * JD-Core Version:    0.7.0.1
 */