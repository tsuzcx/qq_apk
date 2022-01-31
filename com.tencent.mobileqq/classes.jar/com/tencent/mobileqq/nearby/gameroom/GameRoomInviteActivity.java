package com.tencent.mobileqq.nearby.gameroom;

import alpo;
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
import arum;
import autg;
import autp;
import autq;
import autr;
import auts;
import autt;
import autv;
import autw;
import autx;
import auty;
import autz;
import auua;
import auub;
import auuc;
import auue;
import auuf;
import auug;
import auuh;
import auui;
import auuj;
import auul;
import auum;
import auun;
import auux;
import auvk;
import auvm;
import azmj;
import azqg;
import azqk;
import azqt;
import azqu;
import bcgo;
import bcwh;
import bdcd;
import bdfq;
import bdir;
import behr;
import beif;
import beih;
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
import com.tencent.mobileqq.widget.QQToast;
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
  public autg a;
  public auun a;
  public auvk a;
  protected bcgo a;
  behr a;
  protected beif a;
  public beih a;
  protected PlayerInvitePanel a;
  public RecentUserInvitePanel a;
  public WereWolvesLoadingView a;
  public List<auum> a;
  public boolean a;
  public int b;
  public long b;
  public View b;
  protected Button b;
  protected ImageView b;
  public String b;
  public List<auvm> b;
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
    jdField_a_of_type_AndroidUtilSparseArray.put(-1, alpo.a(2131705494));
    jdField_a_of_type_AndroidUtilSparseArray.put(1000, alpo.a(2131705478));
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, alpo.a(2131705484));
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, alpo.a(2131705521));
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, alpo.a(2131705517));
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "邀请id不存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "接受邀请时uin已经存在");
    jdField_a_of_type_AndroidUtilSparseArray.put(1006, alpo.a(2131705524));
    jdField_a_of_type_AndroidUtilSparseArray.put(1007, alpo.a(2131705497));
    jdField_a_of_type_AndroidUtilSparseArray.put(1008, alpo.a(2131705469));
    jdField_a_of_type_AndroidUtilSparseArray.put(1009, alpo.a(2131705486));
    jdField_a_of_type_AndroidUtilSparseArray.put(1010, alpo.a(2131705492));
    jdField_a_of_type_AndroidUtilSparseArray.put(1011, alpo.a(2131705498));
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
    this.jdField_a_of_type_Beif = new autt(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bcgo = new auuc(this);
  }
  
  private Intent a()
  {
    Object localObject2 = "mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=" + this.jdField_b_of_type_JavaLangString + "&roomNum=" + this.jdField_a_of_type_Int;
    String str = this.app.getCurrentNickname() + alpo.a(2131705523);
    Object localObject1;
    if (this.jdField_a_of_type_Int == 10) {
      if (this.jdField_b_of_type_Int == 1) {
        localObject1 = alpo.a(2131705474);
      }
    }
    for (;;)
    {
      localObject2 = new azqg(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(alpo.a(2131705449), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
      azqk localazqk = azqt.a(2);
      localazqk.a("http://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
      ((AbsShareMsg)localObject2).addItem(localazqk);
      ((AbsShareMsg)localObject2).mCommentText = null;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 41);
      ((Intent)localObject1).putExtra("share_comment_message", "");
      ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      return localObject1;
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject1 = alpo.a(2131705453);
      }
      else
      {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
        continue;
        if (this.jdField_a_of_type_Int == 12) {
          localObject1 = alpo.a(2131705465);
        } else {
          localObject1 = alpo.a(2131705471);
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = azqu.a(a().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    bdir.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.jdField_a_of_type_Auvk.a(paramString, paramInt, this.jdField_b_of_type_JavaLangString);
  }
  
  public auum a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        auum localauum = (auum)localIterator.next();
        if (localauum.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          return localauum;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131705447));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setText(alpo.a(2131705454));
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841053);
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
    auum localauum = a();
    if (localauum != null)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localauum.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(alpo.a(2131705512));
        this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841056);
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131705466));
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
      this.jdField_c_of_type_AndroidWidgetButton.setText(alpo.a(2131705520));
      this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130841053);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131705467));
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
          paramString = bdcd.a(this, 230);
          paramString.setTitle(localObject2);
          paramString.setMessage((CharSequence)localObject3);
          paramString.setPositiveButton(alpo.a(2131705441), new autv(this, paramRspBody));
          paramString.setNegativeButton(2131690648, new autw(this, paramString));
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
                  this.jdField_a_of_type_Behr.a(new autx(this, localObject2, (String)localObject3));
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
          auux.a(this, localObject2, (String)localObject3);
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
    //   22: invokestatic 481	auux:a	(Landroid/content/Context;Lcom/tencent/mobileqq/data/HotChatInfo;ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 156	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: aload_0
    //   30: getfield 111	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_a_of_type_Beif	Lbeif;
    //   33: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lalkr;)V
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
    azmj.b(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    bdfq localbdfq = bdcd.a(this, 230);
    localbdfq.setTitle(paramString1);
    localbdfq.setMessage(paramString2);
    localbdfq.setNegativeButton(2131690382, new autz(this, paramBoolean));
    localbdfq.setPositiveButton(alpo.a(2131705493), new auua(this));
    if (!isFinishing()) {
      localbdfq.show();
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
    this.jdField_a_of_type_Behr.a(new auuf(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString1))) {}
    do
    {
      return;
      paramString1 = bdcd.a(this, 230, paramString2, paramString3, alpo.a(2131705456), alpo.a(2131705482), new auuh(this, paramBoolean, paramString1), new auui(this));
    } while (isFinishing());
    paramString1.show();
  }
  
  protected void b()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131694766, 1).a();
    }
    behr localbehr;
    do
    {
      return;
      localbehr = (behr)this.app.a(107);
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      localbehr.a(new auuj(this, localbehr));
      a("start_page", "clk_start");
      return;
    }
    localbehr.b(this.jdField_b_of_type_JavaLangString, new auul(this));
    a("invite_page", "clk_start");
  }
  
  public void c()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694766, 1).a();
      return;
    }
    ((behr)this.app.a(107)).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new autq(this));
    a("start_page", "clk_invite");
  }
  
  public void d()
  {
    behr localbehr = (behr)this.app.a(107);
    this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    localbehr.a(this.jdField_b_of_type_JavaLangString, false, new autr(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559381);
    this.jdField_a_of_type_Autg = autg.a();
    this.jdField_a_of_type_Behr = ((behr)this.app.a(107));
    this.jdField_a_of_type_Beih = this.jdField_a_of_type_Behr.a("");
    this.jdField_a_of_type_Auvk = ((auvk)this.app.getManager(247));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367052));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367046));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376939);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131367051));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367053));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363179));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367934));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = ((WereWolvesLoadingView)findViewById(2131372097));
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
      paramBundle = findViewById(2131375812);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = bcwh.a(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131368613).setOnClickListener(new autp(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368621);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new auub(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel = ((RecentUserInvitePanel)findViewById(2131368421));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.setOnClickListener(new auue(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368420));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel = ((PlayerInvitePanel)findViewById(2131367054));
    this.jdField_a_of_type_Auun = new auun(this, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setColumnCount(6);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setAdapter(this.jdField_a_of_type_Auun);
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
      QQToast.a(this, 1, 2131694766, 1).a();
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_a_of_type_Beif);
      return true;
      h();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Beif);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Auvk = ((auvk)this.app.getManager(247));
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
    this.jdField_a_of_type_Behr.a(new auug(this));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Autg.jdField_c_of_type_Boolean = false;
    auum localauum = a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localauum != null) && (localauum.jdField_a_of_type_Boolean)) {
      autg.a().a(0, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Autg.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Autg.a() == 0) {
      this.jdField_a_of_type_Autg.d();
    }
    this.jdField_a_of_type_Autg.e();
  }
  
  public void e()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {}
    behr localbehr;
    do
    {
      return;
      localbehr = (behr)this.app.a(107);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    localbehr.a(this.jdField_b_of_type_JavaLangString, new auts(this));
  }
  
  public void f()
  {
    arum.a(this, a(), 111);
  }
  
  public void finish()
  {
    auum localauum = a();
    if ((localauum != null) && (!localauum.jdField_a_of_type_Boolean)) {
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
    if (!this.jdField_a_of_type_Beih.a())
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
      this.jdField_a_of_type_Beih.a();
      a("load_page", "in_cnt");
      return;
    }
    a(true);
  }
  
  void i()
  {
    auum localauum = a();
    if (localauum == null) {
      return;
    }
    if (!localauum.jdField_a_of_type_Boolean) {
      a("invite_page", "clk_ready");
    }
    behr localbehr = this.jdField_a_of_type_Behr;
    String str = this.jdField_b_of_type_JavaLangString;
    if (!localauum.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localbehr.b(str, bool, new auty(this, localauum));
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
      Object localObject2 = azqu.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      i = ((Intent)localObject1).getIntExtra("uintype", -1);
      bdir.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.jdField_a_of_type_Auvk.a(str, i, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (auvm)((Iterator)localObject1).next();
        if ((((auvm)localObject2).jdField_a_of_type_Int == i) && (((auvm)localObject2).jdField_a_of_type_JavaLangString.equals(str))) {
          if (!((auvm)localObject2).jdField_a_of_type_Boolean)
          {
            ((auvm)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a((auvm)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity
 * JD-Core Version:    0.7.0.1
 */