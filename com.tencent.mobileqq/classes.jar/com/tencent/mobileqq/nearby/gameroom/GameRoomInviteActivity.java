package com.tencent.mobileqq.nearby.gameroom;

import ajya;
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
import aqbe;
import atch;
import atcq;
import atcr;
import atcs;
import atct;
import atcu;
import atcw;
import atcx;
import atcy;
import atcz;
import atda;
import atdb;
import atdc;
import atdd;
import atdf;
import atdg;
import atdh;
import atdi;
import atdj;
import atdk;
import atdm;
import atdn;
import atdo;
import atdy;
import atel;
import aten;
import axqy;
import axum;
import axuq;
import axuz;
import axva;
import baic;
import baxn;
import bbdj;
import bbgu;
import bbjx;
import bciq;
import bcje;
import bcjg;
import bcql;
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
  public atch a;
  public atdo a;
  public atel a;
  protected baic a;
  bciq a;
  protected bcje a;
  public bcjg a;
  protected PlayerInvitePanel a;
  public RecentUserInvitePanel a;
  public WereWolvesLoadingView a;
  public List<atdn> a;
  public boolean a;
  public int b;
  public long b;
  public View b;
  protected Button b;
  protected ImageView b;
  public String b;
  public List<aten> b;
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
    jdField_a_of_type_AndroidUtilSparseArray.put(-1, ajya.a(2131705122));
    jdField_a_of_type_AndroidUtilSparseArray.put(1000, ajya.a(2131705106));
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, ajya.a(2131705112));
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, ajya.a(2131705149));
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, ajya.a(2131705145));
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "邀请id不存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "接受邀请时uin已经存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1006, ajya.a(2131705152));
    jdField_a_of_type_AndroidUtilSparseArray.put(1007, ajya.a(2131705125));
    jdField_a_of_type_AndroidUtilSparseArray.put(1008, ajya.a(2131705097));
    jdField_a_of_type_AndroidUtilSparseArray.put(1009, ajya.a(2131705114));
    jdField_a_of_type_AndroidUtilSparseArray.put(1010, ajya.a(2131705120));
    jdField_a_of_type_AndroidUtilSparseArray.put(1011, ajya.a(2131705126));
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
    this.jdField_a_of_type_Bcje = new atcu(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Baic = new atdd(this);
  }
  
  private Intent a()
  {
    Object localObject2 = "mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=" + this.jdField_b_of_type_JavaLangString + "&roomNum=" + this.jdField_a_of_type_Int;
    String str = this.app.getCurrentNickname() + ajya.a(2131705151);
    Object localObject1;
    if (this.jdField_a_of_type_Int == 10) {
      if (this.jdField_b_of_type_Int == 1) {
        localObject1 = ajya.a(2131705102);
      }
    }
    for (;;)
    {
      localObject2 = new axum(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(ajya.a(2131705077), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
      axuq localaxuq = axuz.a(2);
      localaxuq.a("http://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
      ((AbsShareMsg)localObject2).addItem(localaxuq);
      ((AbsShareMsg)localObject2).mCommentText = null;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 41);
      ((Intent)localObject1).putExtra("share_comment_message", "");
      ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      return localObject1;
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject1 = ajya.a(2131705081);
      }
      else
      {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
        continue;
        if (this.jdField_a_of_type_Int == 12) {
          localObject1 = ajya.a(2131705093);
        } else {
          localObject1 = ajya.a(2131705099);
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = axva.a(a().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    bbjx.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.jdField_a_of_type_Atel.a(paramString, paramInt, this.jdField_b_of_type_JavaLangString);
  }
  
  public atdn a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        atdn localatdn = (atdn)localIterator.next();
        if (localatdn.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          return localatdn;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705075));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setText(ajya.a(2131705082));
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840935);
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
    atdn localatdn = a();
    if (localatdn != null)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localatdn.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(ajya.a(2131705140));
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840938);
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705094));
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
      this.jdField_c_of_type_AndroidWidgetButton.setText(ajya.a(2131705148));
      this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130840935);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705095));
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
          paramString = bbdj.a(this, 230);
          paramString.setTitle(localObject2);
          paramString.setMessage((CharSequence)localObject3);
          paramString.setPositiveButton(ajya.a(2131705069), new atcw(this, paramRspBody));
          paramString.setNegativeButton(2131690596, new atcx(this, paramString));
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
                  this.jdField_a_of_type_Bciq.a(new atcy(this, localObject2, (String)localObject3));
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
            bcql.a(this, 1, (String)localObject4 + "errorCode = " + paramInt + " errorMsg = " + (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), 0).a();
            return;
            bcql.a(this, 1, (CharSequence)localObject4, 0).a();
            return;
            if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007) && (paramInt != 1013)) {
              break;
            }
          } while (isFinishing());
          atdy.a(this, localObject2, (String)localObject3);
          return;
        } while ((paramInt == -1) || (isFinishing()));
        bcql.a(this, 1, (CharSequence)localObject4, 0).a();
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
    //   22: invokestatic 481	atdy:a	(Landroid/content/Context;Lcom/tencent/mobileqq/data/HotChatInfo;ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 156	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: aload_0
    //   30: getfield 111	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_a_of_type_Bcje	Lbcje;
    //   33: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajte;)V
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
    axqy.b(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    bbgu localbbgu = bbdj.a(this, 230);
    localbbgu.setTitle(paramString1);
    localbbgu.setMessage(paramString2);
    localbbgu.setNegativeButton(2131690331, new atda(this, paramBoolean));
    localbbgu.setPositiveButton(ajya.a(2131705121), new atdb(this));
    if (!isFinishing()) {
      localbbgu.show();
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
    this.jdField_a_of_type_Bciq.a(new atdg(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString1))) {}
    do
    {
      return;
      paramString1 = bbdj.a(this, 230, paramString2, paramString3, ajya.a(2131705084), ajya.a(2131705110), new atdi(this, paramBoolean, paramString1), new atdj(this));
    } while (isFinishing());
    paramString1.show();
  }
  
  protected void b()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      bcql.a(this, 1, 2131694610, 1).a();
    }
    bciq localbciq;
    do
    {
      return;
      localbciq = (bciq)this.app.a(107);
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      localbciq.a(new atdk(this, localbciq));
      a("start_page", "clk_start");
      return;
    }
    localbciq.b(this.jdField_b_of_type_JavaLangString, new atdm(this));
    a("invite_page", "clk_start");
  }
  
  public void c()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      bcql.a(this, 1, 2131694610, 1).a();
      return;
    }
    ((bciq)this.app.a(107)).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new atcr(this));
    a("start_page", "clk_invite");
  }
  
  public void d()
  {
    bciq localbciq = (bciq)this.app.a(107);
    this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    localbciq.a(this.jdField_b_of_type_JavaLangString, false, new atcs(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559330);
    this.jdField_a_of_type_Atch = atch.a();
    this.jdField_a_of_type_Bciq = ((bciq)this.app.a(107));
    this.jdField_a_of_type_Bcjg = this.jdField_a_of_type_Bciq.a("");
    this.jdField_a_of_type_Atel = ((atel)this.app.getManager(247));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366934));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366928));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376439);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131366933));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366935));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363143));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367800));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = ((WereWolvesLoadingView)findViewById(2131371779));
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
      paramBundle = findViewById(2131375329);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = baxn.a(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131368429).setOnClickListener(new atcq(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368435);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new atdc(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel = ((RecentUserInvitePanel)findViewById(2131368275));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.setOnClickListener(new atdf(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368274));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel = ((PlayerInvitePanel)findViewById(2131366936));
    this.jdField_a_of_type_Atdo = new atdo(this, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setColumnCount(6);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setAdapter(this.jdField_a_of_type_Atdo);
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
      bcql.a(this, 1, 2131694610, 1).a();
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_a_of_type_Bcje);
      return true;
      h();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Bcje);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Atel = ((atel)this.app.getManager(247));
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
    this.jdField_a_of_type_Bciq.a(new atdh(this));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Atch.jdField_c_of_type_Boolean = false;
    atdn localatdn = a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localatdn != null) && (localatdn.jdField_a_of_type_Boolean)) {
      atch.a().a(0, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Atch.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Atch.a() == 0) {
      this.jdField_a_of_type_Atch.d();
    }
    this.jdField_a_of_type_Atch.e();
  }
  
  public void e()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {}
    bciq localbciq;
    do
    {
      return;
      localbciq = (bciq)this.app.a(107);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    localbciq.a(this.jdField_b_of_type_JavaLangString, new atct(this));
  }
  
  public void f()
  {
    aqbe.a(this, a(), 111);
  }
  
  public void finish()
  {
    atdn localatdn = a();
    if ((localatdn != null) && (!localatdn.jdField_a_of_type_Boolean)) {
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
    if (!this.jdField_a_of_type_Bcjg.a())
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
      this.jdField_a_of_type_Bcjg.a();
      a("load_page", "in_cnt");
      return;
    }
    a(true);
  }
  
  void i()
  {
    atdn localatdn = a();
    if (localatdn == null) {
      return;
    }
    if (!localatdn.jdField_a_of_type_Boolean) {
      a("invite_page", "clk_ready");
    }
    bciq localbciq = this.jdField_a_of_type_Bciq;
    String str = this.jdField_b_of_type_JavaLangString;
    if (!localatdn.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localbciq.b(str, bool, new atcz(this, localatdn));
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
      Object localObject2 = axva.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      i = ((Intent)localObject1).getIntExtra("uintype", -1);
      bbjx.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.jdField_a_of_type_Atel.a(str, i, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aten)((Iterator)localObject1).next();
        if ((((aten)localObject2).jdField_a_of_type_Int == i) && (((aten)localObject2).jdField_a_of_type_JavaLangString.equals(str))) {
          if (!((aten)localObject2).jdField_a_of_type_Boolean)
          {
            ((aten)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a((aten)localObject2);
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