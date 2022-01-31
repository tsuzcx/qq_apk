package com.tencent.mobileqq.nearby.gameroom;

import aepb;
import aepc;
import aepd;
import aepe;
import aepf;
import aepg;
import aeph;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameRoomUtils
{
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = DialogUtil.a(paramActivity, 230, null, "当前正在组队中，无法加入", "返回", "查看我的组队", new aepg(paramActivity, paramString, paramInt, paramLong), new aeph());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton("返回", new aepe());
    localQQCustomDialog.setPositiveButton("发起新的游戏", new aepf(paramActivity));
    if (!paramActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = DialogUtil.a(paramContext, 230);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setPositiveButton(2131433016, new aepd());
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton("返回", new aepb());
    localQQCustomDialog.setPositiveButton("查看我的组队", new aepc(paramContext, paramString3, paramInt));
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = "https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=" + paramInt;
    if (HttpUtil.a(str)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", URLUtil.guessUrl(str));
      localIntent.putExtra("op_type", "wolf");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameRoomUtils", 2, "发起新游戏 error, " + paramContext);
    }
  }
  
  public static void a(Context paramContext, HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramHotChatInfo.isGameRoom = true;
    Object localObject = localQQAppInterface.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject).a(paramHotChatInfo);
    ((EntityManager)localObject).a();
    localObject = (HotChatManager)localQQAppInterface.getManager(59);
    List localList = ((HotChatManager)localObject).a();
    if ((localList != null) && (!localList.contains(paramHotChatInfo))) {
      localList.add(paramHotChatInfo);
    }
    ((HotChatManager)localObject).a(paramHotChatInfo, 4);
    paramHotChatInfo = new Intent(paramContext, ChatActivity.class);
    paramHotChatInfo.putExtra("uin", paramInt + "");
    paramHotChatInfo.putExtra("uintype", 1);
    paramHotChatInfo.putExtra("troop_uin", paramInt + "");
    paramHotChatInfo.putExtra("uinname", paramString2);
    paramHotChatInfo.putExtra("hotnamecode", paramString1);
    paramHotChatInfo = AIOUtils.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    SharedPreUtils.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    SharedPreUtils.l(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomUtils
 * JD-Core Version:    0.7.0.1
 */