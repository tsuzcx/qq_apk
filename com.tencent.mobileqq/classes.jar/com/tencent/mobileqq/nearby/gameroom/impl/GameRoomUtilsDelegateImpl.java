package com.tencent.mobileqq.nearby.gameroom.impl;

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
import com.tencent.mobileqq.nearby.gameroom.IGameRoomUtilsDelegate;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameRoomUtilsDelegateImpl
  implements IGameRoomUtilsDelegate
{
  public void enterNewGame(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (HttpUtil.isValidUrl((String)localObject)) {
      try
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", URLUtil.guessUrl((String)localObject));
        localIntent.putExtra("op_type", "wolf");
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("发起新游戏 error, ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.d("GameRoomUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void gotoGameChatPie(Context paramContext, Object paramObject, int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = (HotChatInfo)paramObject;
    paramObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((HotChatInfo)localObject1).isGameRoom = true;
    Object localObject2 = paramObject.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject2).update((Entity)localObject1);
    ((EntityManager)localObject2).close();
    localObject2 = (HotChatManager)paramObject.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    List localList = ((HotChatManager)localObject2).a();
    if ((localList != null) && (!localList.contains(localObject1))) {
      localList.add(localObject1);
    }
    ((HotChatManager)localObject2).a((HotChatInfo)localObject1, 4);
    localObject1 = new Intent(paramContext, ChatActivity.class);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("");
    ((Intent)localObject1).putExtra("uin", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("uintype", 1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("");
    ((Intent)localObject1).putExtra("troop_uin", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("uinname", paramString2);
    ((Intent)localObject1).putExtra("hotnamecode", paramString1);
    paramString1 = AIOUtils.a((Intent)localObject1, new int[] { 2 });
    paramString1.addFlags(268435456);
    paramContext.startActivity(paramString1);
    SharedPreUtils.a(paramContext, paramObject.getCurrentAccountUin(), false, System.currentTimeMillis());
    SharedPreUtils.f(paramContext, paramObject.getCurrentAccountUin(), true);
  }
  
  public QQCustomDialog showConfirmDialog(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694583, new GameRoomUtilsDelegateImpl.3(this));
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public QQCustomDialog showCreateNewGameDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      return null;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131705181), new GameRoomUtilsDelegateImpl.4(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705166), new GameRoomUtilsDelegateImpl.5(this, paramActivity));
    if (!paramActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
    return localQQCustomDialog;
  }
  
  public final void showErrorCodeDialog(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    QQToast.a(paramContext, 1, HardCodeUtil.a(2131705222), 1).a();
  }
  
  public QQCustomDialog showMyInviteDialog(Activity paramActivity, String paramString, int paramInt)
  {
    return showMyInviteDialog(paramActivity, paramString, paramInt, 0L);
  }
  
  public QQCustomDialog showMyInviteDialog(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = DialogUtil.a(paramActivity, 230, null, HardCodeUtil.a(2131705241), HardCodeUtil.a(2131705247), HardCodeUtil.a(2131705172), new GameRoomUtilsDelegateImpl.6(this, paramActivity, paramString, paramInt, paramLong), new GameRoomUtilsDelegateImpl.7(this));
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public QQCustomDialog showTeamExistDialog(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
      localQQCustomDialog.setTitle(paramString1);
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131705185), new GameRoomUtilsDelegateImpl.1(this));
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705173), new GameRoomUtilsDelegateImpl.2(this, paramContext, paramString3, paramInt));
      localQQCustomDialog.show();
      return localQQCustomDialog;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomUtilsDelegateImpl
 * JD-Core Version:    0.7.0.1
 */