package com.tencent.mobileqq.nearby.gameroom;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class GameRoomInviteActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static SparseArray<String> a;
  public static String a;
  protected int a;
  protected long a;
  protected Handler a;
  protected View a;
  protected Button a;
  protected ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  protected GameRoomAVController a;
  protected GameRoomInviteActivity.UserGridAdapter a;
  protected PlayerInvitePanel a;
  RecentUserInvitePanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel;
  WerewolvesDataManager jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager;
  protected HttpWebCgiAsyncTask.Callback a;
  WereWolvesLoadingView jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView;
  WerewolvesHandler jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler;
  protected WerewolvesObserver a;
  WerewolvesPluginManager jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
  List<GameRoomInviteActivity.GameRoomUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected Button b;
  protected ImageView b;
  protected String b;
  List<WerewolvesDataManager.InviteUser> b;
  protected boolean b;
  protected int c;
  protected Button c;
  boolean c;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = true;
  boolean f = false;
  boolean g;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(-1, HardCodeUtil.a(2131705139));
    jdField_a_of_type_AndroidUtilSparseArray.put(1000, HardCodeUtil.a(2131705123));
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, HardCodeUtil.a(2131705129));
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, HardCodeUtil.a(2131705166));
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, HardCodeUtil.a(2131705162));
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "邀请id不存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "接受邀请时uin已经存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1006, HardCodeUtil.a(2131705169));
    jdField_a_of_type_AndroidUtilSparseArray.put(1007, HardCodeUtil.a(2131705142));
    jdField_a_of_type_AndroidUtilSparseArray.put(1008, HardCodeUtil.a(2131705114));
    jdField_a_of_type_AndroidUtilSparseArray.put(1009, HardCodeUtil.a(2131705131));
    jdField_a_of_type_AndroidUtilSparseArray.put(1010, HardCodeUtil.a(2131705137));
    jdField_a_of_type_AndroidUtilSparseArray.put(1011, HardCodeUtil.a(2131705143));
  }
  
  public GameRoomInviteActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Int = 1000;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver = new GameRoomInviteActivity.13(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new GameRoomInviteActivity.21(this);
  }
  
  private Intent a()
  {
    Object localObject2 = "mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=" + this.jdField_b_of_type_JavaLangString + "&roomNum=" + this.jdField_a_of_type_Int;
    String str = this.app.getCurrentNickname() + HardCodeUtil.a(2131705168);
    Object localObject1;
    if (this.jdField_a_of_type_Int == 10) {
      if (this.jdField_b_of_type_Int == 1) {
        localObject1 = HardCodeUtil.a(2131705119);
      }
    }
    for (;;)
    {
      localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(HardCodeUtil.a(2131705094), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      localAbsStructMsgItem.a("https://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
      ((AbsShareMsg)localObject2).addItem(localAbsStructMsgItem);
      ((AbsShareMsg)localObject2).mCommentText = null;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 41);
      ((Intent)localObject1).putExtra("share_comment_message", "");
      ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      return localObject1;
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject1 = HardCodeUtil.a(2131705098);
      }
      else
      {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
        continue;
        if (this.jdField_a_of_type_Int == 12) {
          localObject1 = HardCodeUtil.a(2131705110);
        } else {
          localObject1 = HardCodeUtil.a(2131705116);
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(a().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    ShareMsgHelper.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.a(paramString, paramInt, this.jdField_b_of_type_JavaLangString);
  }
  
  public GameRoomInviteActivity.GameRoomUser a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        GameRoomInviteActivity.GameRoomUser localGameRoomUser = (GameRoomInviteActivity.GameRoomUser)localIterator.next();
        if (localGameRoomUser.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          return localGameRoomUser;
        }
      }
    }
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705092));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705099));
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841496);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setPadding(0, 0, 0, 0);
        return;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = a();
    if (localGameRoomUser != null)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localGameRoomUser.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705157));
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841499);
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705111));
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
      this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705165));
      this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841496);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705112));
      continue;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "handle8e4Error errorCode = " + paramInt + " errorMsg = " + paramString);
    }
    Object localObject4;
    if (paramRspBody.string_err_title.has())
    {
      localObject4 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject2 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
    }
    for (Object localObject2 = null;; localObject2 = null)
    {
      localObject4 = paramString;
      if (paramRspBody.string_err_msg.has())
      {
        localObject3 = paramRspBody.string_err_msg.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label458;
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        localObject4 = paramString;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = localObject1;
          localObject3 = localObject1;
        }
        if (paramInt == 1009)
        {
          paramString = DialogUtil.a(this, 230);
          paramString.setTitle(localObject2);
          paramString.setMessage((CharSequence)localObject3);
          paramString.setPositiveButton(HardCodeUtil.a(2131705086), new GameRoomInviteActivity.14(this, paramRspBody));
          paramString.setNegativeButton(2131690800, new GameRoomInviteActivity.15(this, paramString));
          if (!isFinishing()) {
            paramString.show();
          }
        }
        label374:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt == 1008)
                {
                  this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(new GameRoomInviteActivity.16(this, localObject2, (String)localObject3));
                  return;
                }
                if ((paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010)) {
                  break;
                }
              } while (isFinishing());
              a(localObject2, (String)localObject3, true);
              return;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label374;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                break;
              }
            } while (paramInt == -1);
            QQToast.a(this, 1, (String)localObject4 + "errorCode = " + paramInt + " errorMsg = " + (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), 0).a();
            return;
            QQToast.a(this, 1, (CharSequence)localObject4, 0).a();
            return;
            if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007) && (paramInt != 1013)) {
              break;
            }
          } while (isFinishing());
          GameRoomUtils.a(this, localObject2, (String)localObject3);
          return;
        } while ((paramInt == -1) || (isFinishing()));
        QQToast.a(this, 1, (CharSequence)localObject4, 0).a();
        return;
        label458:
        localObject1 = localObject3;
      }
    }
  }
  
  /* Error */
  protected void a(com.tencent.mobileqq.data.HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_c_of_type_Boolean	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: iload_2
    //   19: aload_3
    //   20: aload 4
    //   22: invokestatic 481	com/tencent/mobileqq/nearby/gameroom/GameRoomUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/data/HotChatInfo;ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 156	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: aload_0
    //   30: getfield 111	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver	Lcom/tencent/mobileqq/werewolves/WerewolvesObserver;
    //   33: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 104	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_c_of_type_Boolean	Z
    //   41: aload_0
    //   42: invokevirtual 486	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:finish	()V
    //   45: goto -32 -> 13
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	GameRoomInviteActivity
    //   0	53	1	paramHotChatInfo	com.tencent.mobileqq.data.HotChatInfo
    //   0	53	2	paramInt	int
    //   0	53	3	paramString1	String
    //   0	53	4	paramString2	String
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	48	finally
    //   16	45	48	finally
  }
  
  protected void a(String paramString1, String paramString2)
  {
    ReportController.b(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(2131690601, new GameRoomInviteActivity.18(this, paramBoolean));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705138), new GameRoomInviteActivity.19(this));
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
    this.e = false;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "init: mInviteId = " + this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(new GameRoomInviteActivity.4(this, paramBoolean));
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString1))) {}
    do
    {
      return;
      paramString1 = DialogUtil.a(this, 230, paramString2, paramString3, HardCodeUtil.a(2131705101), HardCodeUtil.a(2131705127), new GameRoomInviteActivity.6(this, paramBoolean, paramString1), new GameRoomInviteActivity.7(this));
    } while (isFinishing());
    paramString1.show();
  }
  
  protected void b()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131694459, 1).a();
    }
    WerewolvesHandler localWerewolvesHandler;
    do
    {
      return;
      localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      localWerewolvesHandler.a(new GameRoomInviteActivity.8(this, localWerewolvesHandler));
      a("start_page", "clk_start");
      return;
    }
    localWerewolvesHandler.b(this.jdField_b_of_type_JavaLangString, new GameRoomInviteActivity.9(this));
    a("invite_page", "clk_start");
  }
  
  protected void c()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694459, 1).a();
      return;
    }
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new GameRoomInviteActivity.10(this));
    a("start_page", "clk_invite");
  }
  
  protected void d()
  {
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    localWerewolvesHandler.a(this.jdField_b_of_type_JavaLangString, false, new GameRoomInviteActivity.11(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559608);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController = GameRoomAVController.a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler = ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a("");
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager = ((WerewolvesDataManager)this.app.getManager(QQManagerFactory.WEREWOLVES_MANAGER));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367746));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367740));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378419);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131367745));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367747));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363573));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368755));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = ((WereWolvesLoadingView)findViewById(2131373294));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = getIntent();
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("inviteId");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("roomNum", 10);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("zoneId", 0);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("gc", -1L);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("isInviteTroop", true);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = findViewById(2131377159);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131369487).setOnClickListener(new GameRoomInviteActivity.1(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369495);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new GameRoomInviteActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel = ((RecentUserInvitePanel)findViewById(2131369222));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.setOnClickListener(new GameRoomInviteActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369221));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel = ((PlayerInvitePanel)findViewById(2131367748));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter = new GameRoomInviteActivity.UserGridAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setColumnCount(6);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(Color.parseColor("#323e6f"));
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    paramBundle.mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_werewolf_logo.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131694459, 1).a();
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
      return true;
      h();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager = ((WerewolvesDataManager)this.app.getManager(QQManagerFactory.WEREWOLVES_MANAGER));
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      setIntent(paramIntent);
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("roomNum", 10);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("zoneId", 0);
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("gc", -1L);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(new GameRoomInviteActivity.5(this));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_c_of_type_Boolean = false;
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localGameRoomUser != null) && (localGameRoomUser.jdField_a_of_type_Boolean)) {
      GameRoomAVController.a().a(0, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.e();
  }
  
  protected void e()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {}
    WerewolvesHandler localWerewolvesHandler;
    do
    {
      return;
      localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    localWerewolvesHandler.a(this.jdField_b_of_type_JavaLangString, new GameRoomInviteActivity.12(this));
  }
  
  protected void f()
  {
    ForwardBaseOption.a(this, a(), 111);
  }
  
  public void finish()
  {
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = a();
    if ((localGameRoomUser != null) && (!localGameRoomUser.jdField_a_of_type_Boolean)) {
      d();
    }
    super.finish();
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_c_of_type_Int);
    }
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a())
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
      a("load_page", "in_cnt");
      return;
    }
    a(true);
  }
  
  void i()
  {
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = a();
    if (localGameRoomUser == null) {
      return;
    }
    if (!localGameRoomUser.jdField_a_of_type_Boolean) {
      a("invite_page", "clk_ready");
    }
    WerewolvesHandler localWerewolvesHandler = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler;
    String str = this.jdField_b_of_type_JavaLangString;
    if (!localGameRoomUser.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localWerewolvesHandler.b(str, bool, new GameRoomInviteActivity.17(this, localGameRoomUser));
      return;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a(this.jdField_b_of_type_JavaUtilList, this.g);
        return;
      }
    } while (this.f);
    this.f = true;
    ThreadManager.post(new GameRoomInviteActivity.20(this), 5, null, false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtras(paramIntent);
      Object localObject2 = StructMsgFactory.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      i = ((Intent)localObject1).getIntExtra("uintype", -1);
      ShareMsgHelper.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.a(str, i, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WerewolvesDataManager.InviteUser)((Iterator)localObject1).next();
        if ((((WerewolvesDataManager.InviteUser)localObject2).jdField_a_of_type_Int == i) && (((WerewolvesDataManager.InviteUser)localObject2).jdField_a_of_type_JavaLangString.equals(str))) {
          if (!((WerewolvesDataManager.InviteUser)localObject2).jdField_a_of_type_Boolean)
          {
            ((WerewolvesDataManager.InviteUser)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a((WerewolvesDataManager.InviteUser)localObject2);
          }
        }
      }
      i = paramIntent.getIntExtra("uintype", 0);
      if (i != 0) {
        break label207;
      }
      a("start_page", "share_friend");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label207:
      if (i == 1) {
        a("start_page", "share_grp");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton) {
        c();
      } else if (paramView == this.jdField_c_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Boolean) {
          b();
        } else {
          i();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void run()
  {
    e();
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if ((this.mActNeedImmersive) && (this.mSystemBarComp == null)) {
        this.mSystemBarComp = new SystemBarCompact(this, true, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity
 * JD-Core Version:    0.7.0.1
 */