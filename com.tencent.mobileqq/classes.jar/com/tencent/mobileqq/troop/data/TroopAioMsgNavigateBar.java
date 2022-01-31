package com.tencent.mobileqq.troop.data;

import ajcu;
import ajcv;
import ajcx;
import ajcy;
import ajcz;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class TroopAioMsgNavigateBar
  extends TroopAioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  public static long a;
  protected float a;
  public Handler a;
  protected Animation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Object a;
  public String a;
  public List a;
  public AtomicBoolean a;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public Object b;
  public String b;
  public boolean b;
  public long c;
  View c;
  protected Animation c;
  public String c;
  protected boolean c;
  public int d;
  public long d;
  String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  public boolean g;
  
  static
  {
    jdField_a_of_type_Long = 2147483647L;
  }
  
  public TroopAioMsgNavigateBar()
  {
    this.jdField_b_of_type_Long = jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new ajcu(this, Looper.getMainLooper());
  }
  
  public static int a(RelativeLayout paramRelativeLayout, int... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int m = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      View localView = paramRelativeLayout.findViewById(paramVarArgs[i]);
      int k = m;
      int n = j;
      if (localView != null)
      {
        if (localView.getVisibility() == 0) {
          break label69;
        }
        n = j;
        k = m;
      }
      for (;;)
      {
        i += 1;
        m = k;
        j = n;
        break;
        label69:
        int i1 = localView.getBottom();
        k = m;
        n = j;
        if (i1 >= j)
        {
          k = paramVarArgs[i];
          n = i1;
        }
      }
    }
    return m;
  }
  
  private int a(int... paramVarArgs)
  {
    return a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVarArgs);
  }
  
  private void a(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368278));
    }
    if (this.jdField_e_of_type_Int == 22)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838080);
      return;
    }
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localObject1 == null) || (((FriendsManager)localObject1).b(paramString))) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        label257:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        }
        label284:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label605;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      if (this.jdField_e_of_type_Int == 20)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof TroopAioAgent.Message)) {
          break label607;
        }
        long l = ((TroopAioAgent.Message)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label434:
          if ((localObject1 == null) || (!AnonymousChatHelper.a((MessageRecord)localObject1))) {
            break label607;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841252);
        }
      }
    }
    label605:
    label607:
    for (Object localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break label257;
      localObject1 = null;
      break label434;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break label257;
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846275);
        break label284;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label284;
      }
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      break label284;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 15;
  }
  
  private void b(int paramInt)
  {
    TroopInfoManager localTroopInfoManager;
    if (this.jdField_a_of_type_Boolean)
    {
      localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null) {
        break label25;
      }
    }
    label25:
    label171:
    label254:
    for (;;)
    {
      return;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
        if (paramInt != 0) {
          break label171;
        }
        this.jdField_e_of_type_Int = -1;
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0)) {
          break label254;
        }
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, this.jdField_e_of_type_Int);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          this.jdField_e_of_type_Int = localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          this.jdField_e_of_type_Int = localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        }
      }
    }
  }
  
  private void i()
  {
    this.jdField_f_of_type_Boolean = false;
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_e_of_type_Int != 1) {
        break label201;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label128;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    label128:
    label201:
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
          if (this.jdField_e_of_type_Int == 4)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 3)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 21)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 15)
          {
            if (((TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 13)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 6)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 20)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
            for (localObject = "Grp_Dis_replyMsg";; localObject = "Grp_AIO")
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", (String)localObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
            }
          }
          if (this.jdField_e_of_type_Int == 17)
          {
            ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2013", "0", false);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 24)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
        } while (this.jdField_e_of_type_Int != 18);
        localObject = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
      } while ((localObject == null) || (!(localObject instanceof MessageForArkApp)));
      localObject = ((MessageForArkApp)localObject).ark_app_message;
    } while (localObject == null);
    ArkAppDataReport.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject).appName);
  }
  
  private void j()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new ajcx(this));
      return;
    }
    i();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          return localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          return localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        }
      }
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new ajcz(this, paramInt));
      return;
    }
    b(paramInt);
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969852, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = a(new int[] { 2131362422, 2131363508, 2131362153, 2131362130 });
    if (i > 0) {
      localLayoutParams.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131368277);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368281));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368282));
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(paramString2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368280));
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label440;
      }
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841463);
      label301:
      if (paramInt != 1) {
        break label453;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846314);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      if (paramInt == 22)
      {
        float f1 = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText("测试字符串测试字符串测");
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f1);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label440:
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841464);
      break label301;
      label453:
      if (paramInt == 22)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838081);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff8444"));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff8444"));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846315);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((paramLong > this.jdField_b_of_type_Long) && (this.jdField_d_of_type_Int > 0)) {
      this.jdField_d_of_type_Int -= 1;
    }
    f();
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (!c())) {}
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      i = 0;
      while (i < paramList.size())
      {
        localObject = (ChatMessage)paramList.get(i);
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(((ChatMessage)localObject).shmsgseq))) {
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
        }
        i += 1;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i == 0) {
        break label231;
      }
      paramList = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      if ((paramList == null) || ((!paramList.jdField_a_of_type_Boolean) && (!paramList.jdField_b_of_type_Boolean))) {
        break;
      }
      if (paramList.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131437906));
        return;
      }
    } while (!paramList.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131437905));
    return;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (i > 99) {}
    for (paramList = "99+";; paramList = Integer.valueOf(i))
    {
      ((TextView)localObject).setText(localResources.getString(2131435365, new Object[] { paramList }));
      return;
    }
    label231:
    this.jdField_f_of_type_Boolean = false;
    h();
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_b_of_type_Long == jdField_a_of_type_Long) || (this.jdField_c_of_type_Boolean) || (paramList == null) || (paramList.size() == 0)) {}
    label304:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.a((MessageRecord)localObject2));
      }
      for (long l = ((ChatMessage)localObject2).shmsgseq;; l = 0L)
      {
        if ((l > this.jdField_b_of_type_Long) || (this.jdField_b_of_type_Long == 0L) || (l == 0L)) {
          break label304;
        }
        this.jdField_c_of_type_Boolean = true;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, "", MessageCache.a(), -4009, 1, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = this.jdField_b_of_type_Long;
        Object localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)localObject3, (String)localObject2, false, false);
        localObject2 = new ArrayList();
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).add((ChatMessage)((Iterator)localObject3).next());
        }
        MsgProxyUtils.a((List)localObject2, (MessageRecord)localObject1, true);
        paramList.clear();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramList.add((ChatMessage)((Iterator)localObject1).next());
        }
        break;
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      this.jdField_e_of_type_Int = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while (this.jdField_e_of_type_Int == 22)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        this.jdField_e_of_type_Int = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
      }
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0))
    {
      QLog.e("TroopAioMsgNavigateBar", 1, "[isNeedToShowNavigateBar] exception " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean + " " + this.jdField_d_of_type_Int);
      return false;
    }
    boolean bool;
    if (this.jdField_e_of_type_Int == 1)
    {
      if ((this.jdField_d_of_type_Int < 15) || (this.jdField_d_of_type_Int > 200)) {
        break label456;
      }
      bool = true;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("navigateType:").append(this.jdField_e_of_type_Int).append("|isNeedToShow:").append(bool);
        if (!c()) {
          break label450;
        }
      }
      label450:
      for (localObject = ", |mMulNativigateSeqList size:" + this.jdField_a_of_type_JavaUtilList.size();; localObject = "")
      {
        QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, (String)localObject);
        return bool;
        if ((this.jdField_e_of_type_Int != 21) && (this.jdField_e_of_type_Int != 13) && (this.jdField_e_of_type_Int != 15) && (this.jdField_e_of_type_Int != 6) && (this.jdField_e_of_type_Int != 24) && (this.jdField_e_of_type_Int != 16) && (this.jdField_e_of_type_Int != 20) && (this.jdField_e_of_type_Int != 19) && (this.jdField_e_of_type_Int != 4) && (this.jdField_e_of_type_Int != 3) && (this.jdField_e_of_type_Int != 17) && (this.jdField_e_of_type_Int != 5) && (this.jdField_e_of_type_Int != 10) && (this.jdField_e_of_type_Int != 12) && (this.jdField_e_of_type_Int != 18) && (this.jdField_e_of_type_Int != 22)) {
          break label456;
        }
        bool = true;
        break;
      }
      label456:
      bool = false;
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "onInit==>mUnreadCount:" + this.jdField_d_of_type_Int + "|mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    }
    Object localObject;
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label352;
      }
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "", 0);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_f_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131558813));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      return;
      label352:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 1, this.jdField_b_of_type_Long, "", 0);
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_e_of_type_Int == 15) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      Object localObject = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localObject != null)
      {
        long l2 = ((TroopAioAgent.Message)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((TroopAioAgent.Message)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            h();
          }
        }
      }
    }
  }
  
  public void f()
  {
    ThreadManager.post(new ajcv(this), 8, null, true);
  }
  
  public void g()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      a(this.jdField_e_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangString);
      j();
      b();
      return;
    }
    if ((this.jdField_e_of_type_Int == 21) || (this.jdField_e_of_type_Int == 13) || (this.jdField_e_of_type_Int == 15) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 19) || (this.jdField_e_of_type_Int == 16) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 12) || (this.jdField_e_of_type_Int == 18)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        setChanged();
        notifyObservers(TroopAioAgent.Message.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
    for (;;)
    {
      h();
      return;
      if ((this.jdField_e_of_type_Int == 20) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if (localMessageRecord != null) {
          notifyObservers(TroopAioAgent.Message.a(this.jdField_e_of_type_Int, localMessageRecord.shmsgseq, this.jdField_d_of_type_Int));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
  }
  
  public void h()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new ajcy(this));
      return;
    }
    b(-1);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_b_of_type_AndroidViewView == null) || (paramAnimation == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof AioPushData)))
      {
        paramAnimation = (AioPushData)this.jdField_a_of_type_JavaLangObject;
        if (!paramAnimation.isShow)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_active", 0, 0, new String[] { String.valueOf(paramAnimation.busId), paramAnimation.actId });
          HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAnimation, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_JavaLangObject = null;
      }
      if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      h();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      continue;
      if (this.jdField_e_of_type_Int != 21) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_e_of_type_Int == 15)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label1673;
      }
      if (this.jdField_e_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      if (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof TroopAioAgent.Message)) {
        break label1673;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      TroopAioAgent.Message localMessage = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      i = this.jdField_a_of_type_JavaUtilList.size();
      localMessage.jdField_a_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
      int j = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, "sizeAfterClick:" + j + ", mArrowImageRotated:" + this.jdField_d_of_type_Boolean);
      }
      if (j != 0)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          this.jdField_d_of_type_Boolean = true;
        }
        paramView = null;
        if (this.jdField_b_of_type_AndroidWidgetImageView != null)
        {
          long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
          paramView = (View)localObject;
          if (localObject != null)
          {
            a(((MessageRecord)localObject).senderuin);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject).senderuin));
            paramView = (View)localObject;
          }
        }
        if (!MessageForQQWalletMsg.isRedPacketMsg(paramView)) {
          break label781;
        }
        paramView = (MessageForQQWalletMsg)paramView;
        if ((paramView.messageType != 7) && (paramView.messageType != 8)) {
          break label755;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131437905));
        localMessage.jdField_b_of_type_Boolean = true;
      }
      while ((i != 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(localMessage);
        return;
        label755:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131437906));
        localMessage.jdField_a_of_type_Boolean = true;
      }
      label781:
      localMessage.jdField_a_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (j > 99) {}
      for (paramView = "99+";; paramView = Integer.valueOf(j))
      {
        ((TextView)localObject).setText(localResources.getString(2131435365, new Object[] { paramView }));
        break;
      }
      if (!localMessage.jdField_a_of_type_Boolean) {
        break label1673;
      }
    }
    label1673:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (this.jdField_e_of_type_Int == 13)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 24)
      {
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (i = 2;; i = 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 19)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 20)
      {
        MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
        for (paramView = "Grp_Dis_replyMsg";; paramView = "Grp_AIO")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramView, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 6)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 17)
      {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2014", "0", false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 4)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 3)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 18)
      {
        paramView = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_b_of_type_Long);
        if ((paramView == null) || (!(paramView instanceof MessageForArkApp))) {
          break;
        }
        paramView = ((MessageForArkApp)paramView).ark_app_message;
        if (paramView == null) {
          break;
        }
        ArkAppDataReport.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.appName);
        break;
      }
      if ((this.jdField_e_of_type_Int != 22) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("TroopAioMsgNavigateBar", 2, "[onClick] into page");
      break;
      h();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */