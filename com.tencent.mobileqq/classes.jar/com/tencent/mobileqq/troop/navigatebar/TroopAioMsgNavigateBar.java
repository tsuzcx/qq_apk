package com.tencent.mobileqq.troop.navigatebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
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
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class TroopAioMsgNavigateBar
  extends TroopAioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  static long jdField_a_of_type_Long = 2147483647L;
  private float jdField_a_of_type_Float = 0.0F;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  INavigateBar jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar;
  TroopAioNavigateBarManager jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager;
  private URLThemeImageView jdField_a_of_type_ComTencentWidgetURLThemeImageView;
  protected Object a;
  private String jdField_a_of_type_JavaLangString = null;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  public AtomicBoolean a;
  long jdField_b_of_type_Long = jdField_a_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  protected long c;
  private View jdField_c_of_type_AndroidViewView;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  private Object jdField_c_of_type_JavaLangObject;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  protected int d;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  private int g = -1;
  
  public TroopAioMsgNavigateBar()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView == null) {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379816));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, paramString)) {
      return;
    }
    Object localObject2;
    if ((this.g != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getVisibility() == 0))
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localObject1 == null) || (((FriendsManager)localObject1).b(paramString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        label262:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        }
        label289:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label581;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      if (this.g == 22)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof TroopAioAgent.Message)) {
          break label583;
        }
        long l = ((TroopAioAgent.Message)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label439:
          if ((localObject1 == null) || (!AnonymousChatHelper.a((MessageRecord)localObject1))) {
            break label583;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843891);
        }
      }
    }
    label581:
    label583:
    for (Object localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
      break label262;
      localObject1 = null;
      break label439;
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break label262;
      ViewUtils.b(this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, 4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label289;
      }
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      break label289;
      break;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "hideMsgNavigateBarInternal, type = " + paramInt);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.g);
      if (paramInt != 0) {
        break label129;
      }
      this.g = -1;
    }
    label129:
    while (!b())
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      return;
    }
    if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      setChanged();
      notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
    }
    f();
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    do
    {
      return;
      this.jdField_f_of_type_Boolean = false;
    } while ((this.jdField_c_of_type_AndroidViewView.getVisibility() != 8) || (this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewAnimationAnimation == null));
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_b_of_type_AndroidViewView.getTag(), this.jdField_b_of_type_JavaLangString);
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.2(this));
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "click nav bar: navigateType = " + this.g + ", navigateSeq = " + this.jdField_c_of_type_Long);
    }
    this.jdField_f_of_type_Boolean = true;
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if ((this.jdField_e_of_type_Boolean) && (c())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (TroopAioNavigateUtil.a(this.g))
    {
      o();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.b(this.g, this.jdField_b_of_type_AndroidViewView.getTag(), this.jdField_b_of_type_JavaLangString);
    k();
  }
  
  private void o()
  {
    if ((ListUtils.a(this.jdField_a_of_type_JavaUtilList)) || (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof TroopAioAgent.Message)))
    {
      k();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    TroopAioAgent.Message localMessage = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      long l1 = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
      TroopAioAgent.Message.a(this.g, l1, localMessage);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "sizeAfterClick = " + i + ", mArrowImageRotated = " + this.jdField_d_of_type_Boolean + ", seq = " + l1);
      }
      l1 = jdField_a_of_type_Long;
      if (i > 0)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          this.jdField_d_of_type_Boolean = true;
        }
        long l2 = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l2);
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView != null)
        {
          l1 = l2;
          if (localMessageRecord != null)
          {
            a(localMessageRecord.senderuin);
            l1 = l2;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, localMessage, this.jdField_b_of_type_JavaLangString, i, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, l1);
      if ((i > 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "onClick notify");
        }
        setChanged();
        notifyObservers(localMessage);
        return;
      }
    }
    k();
  }
  
  public int a()
  {
    return this.g;
  }
  
  protected long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  @Nullable
  protected MessageRecord a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        localObject1 = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.4(this, paramInt));
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    try
    {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560719, null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        localLayoutParams.addRule(11);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      int i = a(new int[] { 2131380004, 2131374581, 2131374717, 2131374712 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131379814);
      }
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
      this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379819));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379818));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379815));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      a(paramString2);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844110);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166261));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166261));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130851226);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(paramInt, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("Navigate.TroopAioMsgNavigateBar", 2, "mNavitigationBarContainer, inflate error: " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong)
  {
    if ((paramLong > this.jdField_b_of_type_Long) && (this.jdField_d_of_type_Int > 0)) {
      this.jdField_d_of_type_Int -= 1;
    }
    f();
  }
  
  protected void a(BaseTroopAioMsgNavigateBarDelegate.Entity paramEntity)
  {
    if (this.g != 102) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramEntity.a();
    this.jdField_b_of_type_JavaLangString = paramEntity.a();
    if (this.jdField_c_of_type_Boolean)
    {
      j();
      return;
    }
    k();
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (!c())) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < paramList.size())
        {
          localObject = (ChatMessage)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).uniseq));
          i += 1;
          continue;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "removeMsgSeqOnScoll, sizeAfterRemove = " + i);
        }
        if (i == 0) {
          break label354;
        }
        paramList = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
        if ((paramList == null) || ((!paramList.jdField_a_of_type_Boolean) && (!paramList.jdField_b_of_type_Boolean))) {
          break label214;
        }
        if (paramList.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719026));
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719042));
      continue;
      label214:
      Resources localResources;
      if ((paramList != null) && (paramList.c == 17))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (i > 99) {}
        for (paramList = "99+";; paramList = Integer.valueOf(i))
        {
          ((TextView)localObject).setText(localResources.getString(2131694393, new Object[] { paramList }));
          break;
        }
      }
      if ((paramList != null) && (paramList.c == 100))
      {
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (i > 99) {}
        for (paramList = "99+";; paramList = Integer.valueOf(i))
        {
          ((TextView)localObject).setText(localResources.getString(2131699390, new Object[] { paramList }));
          break;
        }
        label354:
        this.jdField_f_of_type_Boolean = false;
        k();
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(paramInt);
  }
  
  public boolean b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0))
    {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 1, "isNeedToShowNavigateBar exception: isInitSuccess = " + this.jdField_a_of_type_Boolean + ", mHasShowBar = " + this.jdField_b_of_type_Boolean + ", mUnreadCount = " + this.jdField_d_of_type_Int);
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(i, this.jdField_d_of_type_Int);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isNeedToShowNavigateBar: navigateType:").append(i).append(", mUnreadCount = ").append(this.jdField_d_of_type_Int).append(", isNeedToShow:").append(bool);
      if (!c()) {
        break label218;
      }
    }
    label218:
    for (String str = ", mMulNativigateSeqList size:" + this.jdField_a_of_type_JavaUtilList.size();; str = "")
    {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, str);
      return bool;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager = ((TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    QLog.d("Navigate.TroopAioMsgNavigateBar", 1, "onInit: troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ", uinType = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", mUnreadCount = " + this.jdField_d_of_type_Int + ", mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1, this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, "", 0, null);
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.jdField_e_of_type_Int = localDisplayMetrics.heightPixels;
    this.jdField_f_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298054));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar = new NavigateBarDelegateFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public boolean c()
  {
    return (TroopAioNavigateUtil.a(this.g)) && (!ListUtils.a(this.jdField_a_of_type_JavaUtilList));
  }
  
  public void d()
  {
    QLog.d("Navigate.TroopAioMsgNavigateBar", 1, "onUninit, troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 0);
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.jdField_c_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.b();
  }
  
  protected boolean d()
  {
    return this.jdField_c_of_type_Boolean;
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
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
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
            k();
          }
        }
      }
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded");
    }
    if (!b()) {
      return;
    }
    g();
    TroopAioMsgNavigateBar.1 local1 = new TroopAioMsgNavigateBar.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  protected void g()
  {
    this.g = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != -1L) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new TroopAioMsgNavigateBar.SeqComparator(null));
      }
      if (ListUtils.a(this.jdField_a_of_type_JavaUtilList)) {}
    }
    for (this.jdField_c_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();; this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "initNavigateType, mMulNativigateSeqList.size = " + this.jdField_a_of_type_JavaUtilList.size() + ", navigateType = " + this.g + ", navShMsgSeq = " + this.jdField_d_of_type_Long + ", navigateSeq = " + this.jdField_c_of_type_Long);
      }
      return;
    }
  }
  
  protected void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = null;
    ??? = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (??? != null)
    {
      ??? = ((TroopManager)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((??? != null) && (((TroopInfo)???).hasOrgs())) {
        this.jdField_e_of_type_Boolean = true;
      }
    }
    long l1;
    Object localObject2;
    if (c())
    {
      if (this.jdField_e_of_type_Boolean)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (??? != null)
        {
          l1 = ((com.tencent.imcore.message.Message)???).shmsgseq;
          long l2 = this.jdField_c_of_type_Long;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((!ListUtils.a(this.jdField_a_of_type_JavaUtilList)) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null))
      {
        localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        l1 = TroopAioAgent.Message.a(this.g, ((ChatMessage)localObject2).shmsgseq, ((ChatMessage)localObject2).uniseq);
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (l1 > ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
            break label598;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label598;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        l1 = jdField_a_of_type_Long;
        ??? = a();
        if (??? != null) {
          l1 = ((MessageRecord)???).shmsgseq;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaLangObject, l1, this.jdField_b_of_type_Long, this.jdField_d_of_type_Int);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("prepareShowNavigateBar, navigateType = ").append(this.g).append(", navigateSeq = ").append(this.jdField_c_of_type_Long).append("， mMulNativigateSeqList.size = ").append(ListUtils.a(this.jdField_a_of_type_JavaUtilList)).append(", firstMsgSeq = ").append(l1).append(", mTroopLastReadSeq = ").append(this.jdField_b_of_type_Long).append(", unreadCount = ").append(this.jdField_d_of_type_Int).append(", entity = ");
          if (localObject2 == null)
          {
            ??? = "null";
            QLog.d("Navigate.TroopAioMsgNavigateBar", 2, (String)???);
          }
        }
        else
        {
          if (localObject2 != null) {
            break label527;
          }
          this.jdField_c_of_type_Boolean = false;
          return;
        }
      }
      ??? = localObject3.toString();
      continue;
      label527:
      if ((c()) && (ListUtils.a(this.jdField_a_of_type_JavaUtilList))) {}
      for (this.jdField_c_of_type_Boolean = false;; this.jdField_c_of_type_Boolean = localObject3.a())
      {
        this.jdField_b_of_type_JavaLangString = localObject3.a();
        this.jdField_c_of_type_JavaLangObject = localObject3.a();
        this.jdField_c_of_type_JavaLangString = localObject3.b();
        this.jdField_b_of_type_JavaLangObject = localObject3.b();
        return;
      }
      label598:
      i -= 1;
    }
  }
  
  protected void i()
  {
    if ((this.g != 102) || (!this.jdField_c_of_type_Boolean)) {
      j();
    }
    BaseTroopAioMsgNavigateBarDelegate localBaseTroopAioMsgNavigateBarDelegate;
    do
    {
      return;
      localBaseTroopAioMsgNavigateBarDelegate = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(102);
    } while (!(localBaseTroopAioMsgNavigateBarDelegate instanceof TroopAioMsgNavigateNotification));
    ((TroopAioMsgNavigateNotification)localBaseTroopAioMsgNavigateBarDelegate).c();
  }
  
  protected void j()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(this.g, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangString);
      m();
      b();
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    MessageRecord localMessageRecord = a();
    if (localMessageRecord != null) {
      if ((this.jdField_d_of_type_Long <= this.jdField_b_of_type_Long) || (this.jdField_d_of_type_Long < localMessageRecord.shmsgseq)) {}
    }
    for (;;)
    {
      if ((i != 0) && (a(this.g)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(TroopAioAgent.Message.a(this.g, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType = " + this.g + ", navigateSeq = " + this.jdField_c_of_type_Long + ", navShMsgSeq = " + this.jdField_d_of_type_Long);
        }
      }
      k();
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void k()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.3(this));
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
      if ((this.jdField_b_of_type_JavaLangObject != null) && ((this.jdField_b_of_type_JavaLangObject instanceof AioPushData)))
      {
        paramAnimation = (AioPushData)this.jdField_b_of_type_JavaLangObject;
        if (!paramAnimation.isShow)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_active", 0, 0, new String[] { String.valueOf(paramAnimation.busId), paramAnimation.actId });
          HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAnimation, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_b_of_type_JavaLangObject = null;
      }
      if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
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
        QLog.i("Navigate.TroopAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362375: 
        k();
        break;
      case 2131362585: 
      case 2131379814: 
        n();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */