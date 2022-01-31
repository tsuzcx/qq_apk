package com.tencent.mobileqq.nearby.gameroom;

import ajjy;
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
import aphp;
import asgb;
import asgk;
import asgl;
import asgm;
import asgn;
import asgo;
import asgq;
import asgr;
import asgs;
import asgt;
import asgu;
import asgv;
import asgw;
import asgx;
import asgz;
import asha;
import ashb;
import ashc;
import ashd;
import ashe;
import ashg;
import ashh;
import ashi;
import ashs;
import asif;
import asih;
import awqx;
import awui;
import awum;
import awuv;
import awuw;
import azgl;
import azvv;
import babr;
import bafb;
import baic;
import bbfc;
import bbfq;
import bbfs;
import bbmy;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;
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
  public int a;
  public long a;
  protected Handler a;
  protected View a;
  protected Button a;
  protected ImageView a;
  public LinearLayout a;
  protected TextView a;
  public asgb a;
  public ashi a;
  public asif a;
  protected azgl a;
  bbfc a;
  protected bbfq a;
  public bbfs a;
  protected PlayerInvitePanel a;
  public RecentUserInvitePanel a;
  public WereWolvesLoadingView a;
  public List<ashh> a;
  public boolean a;
  public int b;
  public long b;
  public View b;
  protected Button b;
  protected ImageView b;
  public String b;
  public List<asih> b;
  public boolean b;
  public int c;
  protected Button c;
  boolean c;
  public int d;
  public boolean d;
  public boolean e = true;
  public boolean f = false;
  public boolean g;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(-1, ajjy.a(2131639326));
    jdField_a_of_type_AndroidUtilSparseArray.put(1000, ajjy.a(2131639310));
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, ajjy.a(2131639316));
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, ajjy.a(2131639353));
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, ajjy.a(2131639349));
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "邀请id不存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "接受邀请时uin已经存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1006, ajjy.a(2131639356));
    jdField_a_of_type_AndroidUtilSparseArray.put(1007, ajjy.a(2131639329));
    jdField_a_of_type_AndroidUtilSparseArray.put(1008, ajjy.a(2131639301));
    jdField_a_of_type_AndroidUtilSparseArray.put(1009, ajjy.a(2131639318));
    jdField_a_of_type_AndroidUtilSparseArray.put(1010, ajjy.a(2131639324));
    jdField_a_of_type_AndroidUtilSparseArray.put(1011, ajjy.a(2131639330));
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
    this.jdField_a_of_type_Bbfq = new asgo(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Azgl = new asgx(this);
  }
  
  private Intent a()
  {
    Object localObject2 = "mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=" + this.jdField_b_of_type_JavaLangString + "&roomNum=" + this.jdField_a_of_type_Int;
    String str = this.app.getCurrentNickname() + ajjy.a(2131639355);
    Object localObject1;
    if (this.jdField_a_of_type_Int == 10) {
      if (this.jdField_b_of_type_Int == 1) {
        localObject1 = ajjy.a(2131639306);
      }
    }
    for (;;)
    {
      localObject2 = new awui(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(ajjy.a(2131639281), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
      awum localawum = awuv.a(2);
      localawum.a("http://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
      ((AbsShareMsg)localObject2).addItem(localawum);
      ((AbsShareMsg)localObject2).mCommentText = null;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 41);
      ((Intent)localObject1).putExtra("share_comment_message", "");
      ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      return localObject1;
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject1 = ajjy.a(2131639285);
      }
      else
      {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
        continue;
        if (this.jdField_a_of_type_Int == 12) {
          localObject1 = ajjy.a(2131639297);
        } else {
          localObject1 = ajjy.a(2131639303);
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = awuw.a(a().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    baic.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.jdField_a_of_type_Asif.a(paramString, paramInt, this.jdField_b_of_type_JavaLangString);
  }
  
  public ashh a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ashh localashh = (ashh)localIterator.next();
        if (localashh.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          return localashh;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639279));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setText(ajjy.a(2131639286));
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840871);
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
    ashh localashh = a();
    if (localashh != null)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localashh.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(ajjy.a(2131639344));
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840874);
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639298));
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
      this.jdField_c_of_type_AndroidWidgetButton.setText(ajjy.a(2131639352));
      this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840871);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639299));
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
          paramString = babr.a(this, 230);
          paramString.setTitle(localObject2);
          paramString.setMessage((CharSequence)localObject3);
          paramString.setPositiveButton(ajjy.a(2131639273), new asgq(this, paramRspBody));
          paramString.setNegativeButton(2131625035, new asgr(this, paramString));
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
                  this.jdField_a_of_type_Bbfc.a(new asgs(this, localObject2, (String)localObject3));
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
            bbmy.a(this, 1, (String)localObject4 + "errorCode = " + paramInt + " errorMsg = " + (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), 0).a();
            return;
            bbmy.a(this, 1, (CharSequence)localObject4, 0).a();
            return;
            if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007) && (paramInt != 1013)) {
              break;
            }
          } while (isFinishing());
          ashs.a(this, localObject2, (String)localObject3);
          return;
        } while ((paramInt == -1) || (isFinishing()));
        bbmy.a(this, 1, (CharSequence)localObject4, 0).a();
        return;
        label458:
        localObject1 = localObject3;
      }
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
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
    //   22: invokestatic 481	ashs:a	(Landroid/content/Context;Lcom/tencent/mobileqq/data/HotChatInfo;ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 156	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: aload_0
    //   30: getfield 111	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_a_of_type_Bbfq	Lbbfq;
    //   33: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajfe;)V
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
  
  public void a(String paramString1, String paramString2)
  {
    awqx.b(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    bafb localbafb = babr.a(this, 230);
    localbafb.setTitle(paramString1);
    localbafb.setMessage(paramString2);
    localbafb.setNegativeButton(2131624770, new asgu(this, paramBoolean));
    localbafb.setPositiveButton(ajjy.a(2131639325), new asgv(this));
    if (!isFinishing()) {
      localbafb.show();
    }
    this.e = false;
  }
  
  public void a(boolean paramBoolean)
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
    this.jdField_a_of_type_Bbfc.a(new asha(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString1))) {}
    do
    {
      return;
      paramString1 = babr.a(this, 230, paramString2, paramString3, ajjy.a(2131639288), ajjy.a(2131639314), new ashc(this, paramBoolean, paramString1), new ashd(this));
    } while (isFinishing());
    paramString1.show();
  }
  
  protected void b()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      bbmy.a(this, 1, 2131628948, 1).a();
    }
    bbfc localbbfc;
    do
    {
      return;
      localbbfc = (bbfc)this.app.a(107);
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      localbbfc.a(new ashe(this, localbbfc));
      a("start_page", "clk_start");
      return;
    }
    localbbfc.b(this.jdField_b_of_type_JavaLangString, new ashg(this));
    a("invite_page", "clk_start");
  }
  
  public void c()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      bbmy.a(this, 1, 2131628948, 1).a();
      return;
    }
    ((bbfc)this.app.a(107)).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new asgl(this));
    a("start_page", "clk_invite");
  }
  
  public void d()
  {
    bbfc localbbfc = (bbfc)this.app.a(107);
    this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    localbbfc.a(this.jdField_b_of_type_JavaLangString, false, new asgm(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131493759);
    this.jdField_a_of_type_Asgb = asgb.a();
    this.jdField_a_of_type_Bbfc = ((bbfc)this.app.a(107));
    this.jdField_a_of_type_Bbfs = this.jdField_a_of_type_Bbfc.a("");
    this.jdField_a_of_type_Asif = ((asif)this.app.getManager(247));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301324));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131301318));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131310644);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131301323));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301325));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297594));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302182));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = ((WereWolvesLoadingView)findViewById(2131306082));
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
      paramBundle = findViewById(2131309578);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = azvv.a(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131302804).setOnClickListener(new asgk(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302810);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new asgw(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel = ((RecentUserInvitePanel)findViewById(2131302653));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.setOnClickListener(new asgz(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302652));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel = ((PlayerInvitePanel)findViewById(2131301326));
    this.jdField_a_of_type_Ashi = new ashi(this, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setColumnCount(6);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setAdapter(this.jdField_a_of_type_Ashi);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(Color.parseColor("#323e6f"));
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    paramBundle.mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramBundle = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/nearby_werewolf_logo.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    if (!NetworkUtils.isNetworkAvailable(this)) {
      bbmy.a(this, 1, 2131628948, 1).a();
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_a_of_type_Bbfq);
      return true;
      h();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Bbfq);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Asif = ((asif)this.app.getManager(247));
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
    this.jdField_a_of_type_Bbfc.a(new ashb(this));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Asgb.jdField_c_of_type_Boolean = false;
    ashh localashh = a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localashh != null) && (localashh.jdField_a_of_type_Boolean)) {
      asgb.a().a(0, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Asgb.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Asgb.a() == 0) {
      this.jdField_a_of_type_Asgb.d();
    }
    this.jdField_a_of_type_Asgb.e();
  }
  
  public void e()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {}
    bbfc localbbfc;
    do
    {
      return;
      localbbfc = (bbfc)this.app.a(107);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    localbbfc.a(this.jdField_b_of_type_JavaLangString, new asgn(this));
  }
  
  public void f()
  {
    aphp.a(this, a(), 111);
  }
  
  public void finish()
  {
    ashh localashh = a();
    if ((localashh != null) && (!localashh.jdField_a_of_type_Boolean)) {
      d();
    }
    super.finish();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_c_of_type_Int);
    }
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_Bbfs.a())
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
      this.jdField_a_of_type_Bbfs.a();
      a("load_page", "in_cnt");
      return;
    }
    a(true);
  }
  
  void i()
  {
    ashh localashh = a();
    if (localashh == null) {
      return;
    }
    if (!localashh.jdField_a_of_type_Boolean) {
      a("invite_page", "clk_ready");
    }
    bbfc localbbfc = this.jdField_a_of_type_Bbfc;
    String str = this.jdField_b_of_type_JavaLangString;
    if (!localashh.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localbbfc.b(str, bool, new asgt(this, localashh));
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
      Object localObject2 = awuw.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      i = ((Intent)localObject1).getIntExtra("uintype", -1);
      baic.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.jdField_a_of_type_Asif.a(str, i, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (asih)((Iterator)localObject1).next();
        if ((((asih)localObject2).jdField_a_of_type_Int == i) && (((asih)localObject2).jdField_a_of_type_JavaLangString.equals(str))) {
          if (!((asih)localObject2).jdField_a_of_type_Boolean)
          {
            ((asih)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a((asih)localObject2);
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
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        c();
        return;
      }
    } while (paramView != this.jdField_c_of_type_AndroidWidgetButton);
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return;
    }
    i();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity
 * JD-Core Version:    0.7.0.1
 */