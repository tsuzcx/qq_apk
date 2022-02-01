package com.tencent.mobileqq.nearby.gameroom;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

@RoutePage(desc="游戏房间开始邀请界面", path="/nearby/gameroom/invite")
public class GameRoomInviteActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static final String CGI_GET_FRIEDN_BOARD_LIST = "https://nearby.qq.com/cgi-bin/werewolf/get_friend_board_list";
  private static final int REQ_CODE_SHARE_TO_QQ = 111;
  public static final String TAG = "GameRoomInviteActivity";
  public static final int TYPE_HEADER = 1;
  public static final int TYPE_INVITE = 2;
  public static SparseArray<String> errorCodeMsgs = new SparseArray();
  boolean hasMore;
  boolean isEntered = false;
  boolean isHandleReqListError = true;
  protected boolean isInviteTroop = true;
  boolean isLoading = false;
  boolean isRequested = false;
  protected GameRoomInviteActivity.UserGridAdapter mAdapter;
  protected ImageView mBgView;
  WerewolvesDataManager mDataManager;
  protected WerewolvesObserver mGameRoomObserver = new GameRoomInviteActivity.13(this);
  protected long mGc = -1L;
  protected PlayerInvitePanel mGridView;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  protected Button mInviteButton;
  protected String mInviteId;
  List<InviteUser> mInviteUsers = new ArrayList();
  protected boolean mIsOwner = true;
  WereWolvesLoadingView mLoadingView;
  protected ImageView mLogoView;
  protected long mOwnerUin;
  protected Button mPrepareOrStartBtn;
  LinearLayout mRecentInviteLayout;
  RecentUserInvitePanel mRecentInvitePanel;
  protected int mRefreshDelay = 1000;
  protected View mRightButton;
  protected int mRoomNum = 10;
  protected Button mStartButton;
  protected View mStartInviteLayout;
  protected TextView mStatusText;
  List<GameRoomInviteActivity.GameRoomUser> mUsers = new ArrayList();
  WerewolvesHandler mWwHandler;
  WerewolvesPluginManager mWwPluginManager;
  protected int mZoneId = 0;
  protected HttpWebCgiAsyncTask.Callback onGetRecommendData = new GameRoomInviteActivity.21(this);
  int retryTimes = 0;
  
  static
  {
    errorCodeMsgs.put(-1, HardCodeUtil.a(2131705216));
    errorCodeMsgs.put(1000, HardCodeUtil.a(2131705200));
    errorCodeMsgs.put(1001, HardCodeUtil.a(2131705206));
    errorCodeMsgs.put(1002, HardCodeUtil.a(2131705243));
    errorCodeMsgs.put(1003, HardCodeUtil.a(2131705239));
    errorCodeMsgs.put(1004, "邀请id不存在");
    errorCodeMsgs.put(1005, "接受邀请时uin已经存在");
    errorCodeMsgs.put(1006, HardCodeUtil.a(2131705246));
    errorCodeMsgs.put(1007, HardCodeUtil.a(2131705219));
    errorCodeMsgs.put(1008, HardCodeUtil.a(2131705191));
    errorCodeMsgs.put(1009, HardCodeUtil.a(2131705208));
    errorCodeMsgs.put(1010, HardCodeUtil.a(2131705214));
    errorCodeMsgs.put(1011, HardCodeUtil.a(2131705220));
  }
  
  private Intent createShareIntent()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=");
    ((StringBuilder)localObject1).append(this.mInviteId);
    ((StringBuilder)localObject1).append("&roomNum=");
    ((StringBuilder)localObject1).append(this.mRoomNum);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.app.getCurrentNickname());
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705245));
    String str = ((StringBuilder)localObject1).toString();
    int i = this.mRoomNum;
    if (i == 10)
    {
      i = this.mZoneId;
      if (i == 1) {
        localObject1 = HardCodeUtil.a(2131705196);
      } else if (i == 2) {
        localObject1 = HardCodeUtil.a(2131705175);
      } else {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
      }
    }
    else if (i == 12)
    {
      localObject1 = HardCodeUtil.a(2131705187);
    }
    else
    {
      localObject1 = HardCodeUtil.a(2131705193);
    }
    localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(HardCodeUtil.a(2131705171), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a("https://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
    ((AbsShareMsg)localObject2).addItem(localAbsStructMsgItem);
    ((AbsShareMsg)localObject2).mCommentText = null;
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("forward_type", 41);
    ((Intent)localObject1).putExtra("share_comment_message", "");
    ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    return localObject1;
  }
  
  private void shareInviteMsg(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(createShareIntent().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    ShareMsgHelper.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.mDataManager.a(paramString, paramInt, this.mInviteId);
  }
  
  public void createLocalHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    paramHotChatInfo.isGameRoom = true;
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject).update(paramHotChatInfo);
    ((EntityManager)localObject).close();
    localObject = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    List localList = ((HotChatManager)localObject).a();
    if ((localList != null) && (!localList.contains(paramHotChatInfo))) {
      localList.add(paramHotChatInfo);
    }
    ((HotChatManager)localObject).a(paramHotChatInfo, 4);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559485);
    this.mWwHandler = ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER));
    this.mWwPluginManager = this.mWwHandler.a("");
    this.mDataManager = ((WerewolvesDataManager)this.app.getManager(QQManagerFactory.WEREWOLVES_MANAGER));
    this.mStartButton = ((Button)findViewById(2131367505));
    this.mInviteButton = ((Button)findViewById(2131367499));
    this.mStartInviteLayout = findViewById(2131377833);
    this.mPrepareOrStartBtn = ((Button)findViewById(2131367504));
    this.mStatusText = ((TextView)findViewById(2131367506));
    this.mBgView = ((ImageView)findViewById(2131363496));
    this.mLogoView = ((ImageView)findViewById(2131368487));
    this.mLoadingView = ((WereWolvesLoadingView)findViewById(2131372874));
    this.mLoadingView.b.setBackgroundDrawable(null);
    this.mStartButton.setOnClickListener(this);
    this.mInviteButton.setOnClickListener(this);
    this.mPrepareOrStartBtn.setOnClickListener(this);
    paramBundle = getIntent();
    this.mInviteId = paramBundle.getStringExtra("inviteId");
    this.mRoomNum = paramBundle.getIntExtra("roomNum", 10);
    this.mZoneId = paramBundle.getIntExtra("zoneId", 0);
    this.mGc = paramBundle.getLongExtra("gc", -1L);
    this.isInviteTroop = paramBundle.getBooleanExtra("isInviteTroop", true);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = findViewById(2131376636);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131369202).setOnClickListener(new GameRoomInviteActivity.1(this));
    this.mRightButton = findViewById(2131369210);
    this.mRightButton.setOnClickListener(new GameRoomInviteActivity.2(this));
    this.mRecentInvitePanel = ((RecentUserInvitePanel)findViewById(2131368951));
    this.mRecentInvitePanel.setOnClickListener(new GameRoomInviteActivity.3(this));
    this.mRecentInviteLayout = ((LinearLayout)findViewById(2131368950));
    this.mRecentInviteLayout.setVisibility(4);
    this.mGridView = ((PlayerInvitePanel)findViewById(2131367507));
    this.mAdapter = new GameRoomInviteActivity.UserGridAdapter(this, null);
    this.mGridView.setColumnCount(6);
    this.mGridView.setAdapter(this.mAdapter);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(Color.parseColor("#323e6f"));
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", paramBundle);
    this.mBgView.setBackgroundDrawable((Drawable)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    paramBundle.mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_werewolf_logo.png", (URLDrawable.URLDrawableOptions)localObject);
    this.mLogoView.setImageDrawable(paramBundle);
    this.mLogoView.setVisibility(4);
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131694424, 1).a();
    } else {
      loadPlugin();
    }
    this.app.addObserver(this.mGameRoomObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.mGameRoomObserver);
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.mDataManager = ((WerewolvesDataManager)this.app.getManager(QQManagerFactory.WEREWOLVES_MANAGER));
    if (TextUtils.isEmpty(this.mInviteId))
    {
      setIntent(paramIntent);
      this.mInviteId = paramIntent.getStringExtra("inviteId");
      this.mRoomNum = paramIntent.getIntExtra("roomNum", 10);
      this.mZoneId = paramIntent.getIntExtra("zoneId", 0);
      this.mGc = paramIntent.getLongExtra("gc", -1L);
    }
    if (!TextUtils.isEmpty(this.mInviteId))
    {
      init(true);
      return;
    }
    this.mWwHandler.a(new GameRoomInviteActivity.5(this));
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInvite(false);
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = getSelf();
    if ((this.mUsers != null) && (localGameRoomUser != null) && (localGameRoomUser.jdField_a_of_type_Boolean)) {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).showFloatView(0, this.mInviteId, this.mRoomNum, 0L, null);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInvite(true);
    if (((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).getFloatViewState() == 0) {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    }
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).onActivityResume();
  }
  
  protected void exitInvite()
  {
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    this.mRightButton.setEnabled(false);
    localWerewolvesHandler.a(this.mInviteId, false, new GameRoomInviteActivity.11(this));
  }
  
  public void finish()
  {
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = getSelf();
    if ((localGameRoomUser != null) && (!localGameRoomUser.jdField_a_of_type_Boolean)) {
      exitInvite();
    }
    super.finish();
  }
  
  public void getRecommendData()
  {
    if (TextUtils.isEmpty(this.mInviteId)) {
      return;
    }
    List localList = this.mInviteUsers;
    if ((localList != null) && (localList.size() > 0))
    {
      this.mRecentInvitePanel.a(this.mInviteUsers, this.hasMore);
      return;
    }
    if (this.isRequested) {
      return;
    }
    this.isRequested = true;
    ThreadManager.post(new GameRoomInviteActivity.20(this), 5, null, false);
  }
  
  public GameRoomInviteActivity.GameRoomUser getSelf()
  {
    Object localObject = this.mUsers;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameRoomInviteActivity.GameRoomUser localGameRoomUser = (GameRoomInviteActivity.GameRoomUser)((Iterator)localObject).next();
        if (localGameRoomUser.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          return localGameRoomUser;
        }
      }
    }
    return null;
  }
  
  protected void gotoGameChatPie(HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.isEntered;
      if (bool) {
        return;
      }
      ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).gotoGameChatPie(this, paramHotChatInfo, paramInt, paramString1, paramString2);
      this.app.removeObserver(this.mGameRoomObserver);
      this.isEntered = true;
      finish();
      return;
    }
    finally {}
  }
  
  public void handle8e4Error(int paramInt, oidb_0x8e4.RspBody paramRspBody, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handle8e4Error errorCode = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" errorMsg = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("GameRoomInviteActivity", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = paramRspBody.string_err_title.has();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject4 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject2 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
    }
    else
    {
      localObject2 = null;
    }
    Object localObject4 = paramString;
    if (paramRspBody.string_err_msg.has())
    {
      localObject3 = paramRspBody.string_err_msg.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
      localObject3 = localObject1;
      localObject4 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = localObject1;
        localObject3 = localObject1;
      }
    }
    if (paramInt == 1009)
    {
      paramString = DialogUtil.a(this, 230);
      paramString.setTitle(localObject2);
      paramString.setMessage((CharSequence)localObject3);
      paramString.setPositiveButton(HardCodeUtil.a(2131705163), new GameRoomInviteActivity.14(this, paramRspBody));
      paramString.setNegativeButton(2131690728, new GameRoomInviteActivity.15(this, paramString));
      if (!isFinishing()) {
        paramString.show();
      }
    }
    else
    {
      if (paramInt == 1008)
      {
        this.mWwHandler.a(new GameRoomInviteActivity.16(this, localObject2, (String)localObject3));
        return;
      }
      if ((paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010))
      {
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            if (paramInt != -1)
            {
              paramRspBody = new StringBuilder();
              paramRspBody.append((String)localObject4);
              paramRspBody.append("errorCode = ");
              paramRspBody.append(paramInt);
              paramRspBody.append(" errorMsg = ");
              paramRspBody.append((String)errorCodeMsgs.get(paramInt));
              QQToast.a(this, 1, paramRspBody.toString(), 0).a();
            }
          }
          else {
            QQToast.a(this, 1, (CharSequence)localObject4, 0).a();
          }
          return;
        }
        if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007) && (paramInt != 1013))
        {
          if ((paramInt != -1) && (!isFinishing())) {
            QQToast.a(this, 1, (CharSequence)localObject4, 0).a();
          }
        }
        else if (!isFinishing()) {
          ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this, localObject2, (String)localObject3);
        }
      }
      else if (!isFinishing())
      {
        showCreateNewTeamDialog(localObject2, (String)localObject3, true);
      }
    }
  }
  
  protected void init(boolean paramBoolean)
  {
    this.isLoading = false;
    this.mLoadingView.setVisibility(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: mInviteId = ");
      localStringBuilder.append(this.mInviteId);
      QLog.d("GameRoomInviteActivity", 2, localStringBuilder.toString());
    }
    this.mLogoView.setVisibility(0);
    if (!TextUtils.isEmpty(this.mInviteId))
    {
      reqUserList();
      return;
    }
    this.mWwHandler.a(new GameRoomInviteActivity.4(this, paramBoolean));
  }
  
  protected void invite()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694424, 1).a();
      return;
    }
    ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.mRoomNum, this.mZoneId, new GameRoomInviteActivity.10(this));
    report("start_page", "clk_invite");
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void loadPlugin()
  {
    if (!this.mWwPluginManager.a())
    {
      this.isLoading = true;
      this.mLoadingView.setVisibility(0);
      this.mLoadingView.b();
      this.mWwPluginManager.a();
      report("load_page", "in_cnt");
      return;
    }
    init(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtras(paramIntent);
      Object localObject2 = StructMsgFactory.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      int i = ((Intent)localObject1).getIntExtra("uintype", -1);
      ShareMsgHelper.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.mDataManager.a(str, i, this.mInviteId);
      localObject1 = this.mInviteUsers.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (InviteUser)((Iterator)localObject1).next();
        if ((((InviteUser)localObject2).jdField_a_of_type_Int == i) && (((InviteUser)localObject2).jdField_a_of_type_JavaLangString.equals(str))) {
          if (!((InviteUser)localObject2).jdField_a_of_type_Boolean)
          {
            ((InviteUser)localObject2).jdField_a_of_type_Boolean = true;
            this.mRecentInvitePanel.a((InviteUser)localObject2);
          }
        }
      }
      i = paramIntent.getIntExtra("uintype", 0);
      if (i == 0) {
        report("start_page", "share_friend");
      } else if (i == 1) {
        report("start_page", "share_grp");
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mStartButton)
    {
      startGame();
      return;
    }
    if (paramView == this.mInviteButton)
    {
      invite();
      return;
    }
    if (paramView == this.mPrepareOrStartBtn)
    {
      if (this.mIsOwner)
      {
        startGame();
        return;
      }
      prepareOrCancel();
    }
  }
  
  void prepareOrCancel()
  {
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = getSelf();
    if (localGameRoomUser == null) {
      return;
    }
    if (!localGameRoomUser.jdField_a_of_type_Boolean) {
      report("invite_page", "clk_ready");
    }
    this.mWwHandler.b(this.mInviteId, localGameRoomUser.jdField_a_of_type_Boolean ^ true, new GameRoomInviteActivity.17(this, localGameRoomUser));
  }
  
  protected void refreshRepeat()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler.postDelayed(this, this.mRefreshDelay);
    }
  }
  
  protected void refreshUI()
  {
    Object localObject;
    if (this.mIsOwner)
    {
      localObject = this.mUsers;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        this.mStatusText.setText(HardCodeUtil.a(2131705169));
        this.mStatusText.setVisibility(0);
        this.mPrepareOrStartBtn.setVisibility(0);
        this.mPrepareOrStartBtn.setText(HardCodeUtil.a(2131705176));
        this.mPrepareOrStartBtn.setTextColor(-1);
        this.mPrepareOrStartBtn.setBackgroundResource(2130841377);
        this.mStartInviteLayout.setVisibility(8);
        this.mInviteButton.setVisibility(8);
        this.mRightButton.setVisibility(0);
        this.mRightButton.setEnabled(true);
      }
      else
      {
        this.mPrepareOrStartBtn.setVisibility(8);
        this.mStartInviteLayout.setVisibility(0);
        this.mInviteButton.setVisibility(0);
        this.mStartButton.setVisibility(0);
        this.mStatusText.setVisibility(8);
        this.mRightButton.setVisibility(4);
      }
    }
    else
    {
      localObject = getSelf();
      if (localObject != null)
      {
        this.mPrepareOrStartBtn.setVisibility(0);
        this.mStartInviteLayout.setVisibility(8);
        this.mInviteButton.setVisibility(8);
        this.mStartButton.setVisibility(8);
        this.mRightButton.setVisibility(0);
        this.mRightButton.setEnabled(true);
        this.mStatusText.setVisibility(0);
        if (((GameRoomInviteActivity.GameRoomUser)localObject).jdField_a_of_type_Boolean)
        {
          this.mPrepareOrStartBtn.setText(HardCodeUtil.a(2131705234));
          this.mPrepareOrStartBtn.setBackgroundResource(2130841380);
          this.mPrepareOrStartBtn.setTextColor(-16777216);
          this.mStatusText.setText(HardCodeUtil.a(2131705188));
        }
        else
        {
          this.mPrepareOrStartBtn.setText(HardCodeUtil.a(2131705242));
          this.mPrepareOrStartBtn.setBackgroundResource(2130841377);
          this.mPrepareOrStartBtn.setTextColor(-1);
          this.mStatusText.setText(HardCodeUtil.a(2131705189));
        }
      }
      else
      {
        this.mPrepareOrStartBtn.setVisibility(0);
        this.mStartInviteLayout.setVisibility(8);
        this.mStartButton.setVisibility(8);
        this.mRightButton.setVisibility(8);
        this.mStatusText.setVisibility(8);
      }
      this.mRightButton.setVisibility(4);
    }
    this.mPrepareOrStartBtn.setPadding(0, 0, 0, 0);
  }
  
  protected void report(String paramString1, String paramString2)
  {
    ReportController.b(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  protected void reqUserList()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      return;
    }
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    if (TextUtils.isEmpty(this.mInviteId)) {
      return;
    }
    localWerewolvesHandler.a(this.mInviteId, new GameRoomInviteActivity.12(this));
  }
  
  public void run()
  {
    reqUserList();
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
  
  protected void shareToMobileQQ()
  {
    ForwardBaseOption.a(this, createShareIntent(), 111);
  }
  
  protected void showCreateNewTeamDialog(String paramString1, String paramString2, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(2131690529, new GameRoomInviteActivity.18(this, paramBoolean));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705215), new GameRoomInviteActivity.19(this));
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
    this.isHandleReqListError = false;
  }
  
  protected void showMyInviteDialog(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    String str = this.mInviteId;
    if ((str != null) && (str.equals(paramString1))) {
      return;
    }
    paramString1 = DialogUtil.a(this, 230, paramString2, paramString3, HardCodeUtil.a(2131705178), HardCodeUtil.a(2131705204), new GameRoomInviteActivity.6(this, paramBoolean, paramString1), new GameRoomInviteActivity.7(this));
    if (!isFinishing()) {
      paramString1.show();
    }
  }
  
  protected void startGame()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694424, 1).a();
      return;
    }
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    if (this.mIsOwner)
    {
      if (this.mInviteButton.getVisibility() == 0)
      {
        localWerewolvesHandler.a(new GameRoomInviteActivity.8(this, localWerewolvesHandler));
        report("start_page", "clk_start");
        return;
      }
      localWerewolvesHandler.b(this.mInviteId, new GameRoomInviteActivity.9(this));
      report("invite_page", "clk_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity
 * JD-Core Version:    0.7.0.1
 */