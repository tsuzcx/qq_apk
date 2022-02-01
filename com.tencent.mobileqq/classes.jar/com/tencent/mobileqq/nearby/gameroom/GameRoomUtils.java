package com.tencent.mobileqq.nearby.gameroom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
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
    paramString = DialogUtil.a(paramActivity, 230, null, HardCodeUtil.a(2131705164), HardCodeUtil.a(2131705170), HardCodeUtil.a(2131705095), new GameRoomUtils.6(paramActivity, paramString, paramInt, paramLong), new GameRoomUtils.7());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    QQCustomDialog localQQCustomDialog;
    do
    {
      return paramString1;
      localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      localQQCustomDialog.setTitle(paramString1);
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131705104), new GameRoomUtils.4());
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705089), new GameRoomUtils.5(paramActivity));
      paramString1 = localQQCustomDialog;
    } while (paramActivity.isFinishing());
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694615, new GameRoomUtils.3());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
      localQQCustomDialog.setTitle(paramString1);
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131705108), new GameRoomUtils.1());
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705096), new GameRoomUtils.2(paramContext, paramString3, paramInt));
      localQQCustomDialog.show();
      return localQQCustomDialog;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = "https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=" + paramInt;
    if (HttpUtil.isValidUrl(str)) {}
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
    ((EntityManager)localObject).update(paramHotChatInfo);
    ((EntityManager)localObject).close();
    localObject = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
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
    SharedPreUtils.f(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomUtils
 * JD-Core Version:    0.7.0.1
 */