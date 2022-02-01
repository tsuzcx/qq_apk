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
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.ChatXListView;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
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
    int k;
    for (int j = 0; i < paramVarArgs.length; j = k)
    {
      View localView = paramRelativeLayout.findViewById(paramVarArgs[i]);
      int n = m;
      k = j;
      if (localView != null) {
        if (localView.getVisibility() != 0)
        {
          n = m;
          k = j;
        }
        else
        {
          int i1 = localView.getBottom();
          n = m;
          k = j;
          if (i1 >= j)
          {
            n = paramVarArgs[i];
            k = i1;
          }
        }
      }
      i += 1;
      m = n;
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
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379145));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, paramString)) {
      return;
    }
    if ((this.g != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getVisibility() == 0))
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      Object localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (!((FriendsManager)localObject1).b(paramString)))
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
      }
      else if (this.g == 22)
      {
        localObject2 = this.jdField_b_of_type_AndroidViewView.getTag();
        boolean bool = localObject2 instanceof TroopAioAgent.Message;
        Object localObject3 = null;
        localObject1 = localObject3;
        if (bool)
        {
          long l = ((TroopAioAgent.Message)localObject2).jdField_a_of_type_Long;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l, 0L);
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localObject2 = (MessageRecord)((List)localObject1).get(0);
          } else {
            localObject2 = null;
          }
          localObject1 = localObject3;
          if (localObject2 != null)
          {
            localObject1 = localObject3;
            if (AnonymousChatHelper.a((MessageRecord)localObject2))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843811);
              localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a((MessageRecord)localObject2).b), (Drawable)localObject1, (Drawable)localObject1);
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
        }
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      }
    }
    else
    {
      ViewUtils.b(this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, 4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideMsgNavigateBarInternal, type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.g);
      if (paramInt == 0)
      {
        this.g = -1;
      }
      else if (b())
      {
        if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)))
        {
          setChanged();
          notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
        }
        f();
        return;
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewAnimationAnimation != null))
      {
        localObject = this.jdField_c_of_type_AndroidViewView;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          this.jdField_b_of_type_AndroidViewView.clearAnimation();
          this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
      }
    }
  }
  
  private void l()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    if (localView.getVisibility() == 8)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if ((localView != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
      {
        this.jdField_a_of_type_Float = 0.0F;
        localView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_b_of_type_AndroidViewView.getTag(), this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.2(this));
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click nav bar: navigateType = ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", navigateSeq = ");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
    }
    this.jdField_f_of_type_Boolean = true;
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if ((this.jdField_e_of_type_Boolean) && (c())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
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
    TroopAioAgent.Message localMessage;
    if ((!ListUtils.a(this.jdField_a_of_type_JavaUtilList)) && ((this.jdField_b_of_type_AndroidViewView.getTag() instanceof TroopAioAgent.Message)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      localMessage = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
    }
    label383:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        long l = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
        TroopAioAgent.Message.a(this.g, l, localMessage);
        int i = this.jdField_a_of_type_JavaUtilList.size();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sizeAfterClick = ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", mArrowImageRotated = ");
          ((StringBuilder)localObject2).append(this.jdField_d_of_type_Boolean);
          ((StringBuilder)localObject2).append(", seq = ");
          ((StringBuilder)localObject2).append(l);
          QLog.d("Navigate.TroopAioMsgNavigateBar", 2, ((StringBuilder)localObject2).toString());
        }
        l = jdField_a_of_type_Long;
        if (i <= 0) {
          break label386;
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          this.jdField_d_of_type_Boolean = true;
        }
        l = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
        if ((this.jdField_a_of_type_ComTencentWidgetURLThemeImageView == null) || (localObject2 == null)) {
          break label383;
        }
        a(((MessageRecord)localObject2).senderuin);
        break label383;
        this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, localMessage, this.jdField_b_of_type_JavaLangString, i, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, l);
        if ((i > 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Navigate.TroopAioMsgNavigateBar", 2, "onClick notify");
          }
          setChanged();
          notifyObservers(localMessage);
          return;
        }
        k();
        return;
      }
      k();
      return;
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      return (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
    }
    return null;
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
    if (this.jdField_c_of_type_AndroidViewView == null) {
      try
      {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560607, null);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      catch (Exception paramString1)
      {
        paramObject = new StringBuilder();
        paramObject.append("mNavitigationBarContainer, inflate error: ");
        paramObject.append(paramString1.getMessage());
        QLog.e("Navigate.TroopAioMsgNavigateBar", 2, paramObject.toString());
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = a(new int[] { 2131379333, 2131374119, 2131374255, 2131374250 });
    if (i > 0) {
      localLayoutParams.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131379143);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379148));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379147));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379144));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(paramString2);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844014);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166272));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166272));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130851142);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(paramInt, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(long paramLong)
  {
    if (paramLong > this.jdField_b_of_type_Long)
    {
      int i = this.jdField_d_of_type_Int;
      if (i > 0) {
        this.jdField_d_of_type_Int = (i - 1);
      }
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
    if (paramList != null)
    {
      if (!c()) {
        return;
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      int i = 0;
      try
      {
        Object localObject;
        while (i < paramList.size())
        {
          localObject = (ChatMessage)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).uniseq));
          i += 1;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("removeMsgSeqOnScoll, sizeAfterRemove = ");
          paramList.append(i);
          QLog.d("Navigate.TroopAioMsgNavigateBar", 2, paramList.toString());
        }
        if (i != 0)
        {
          paramList = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
          if ((paramList != null) && ((paramList.jdField_a_of_type_Boolean) || (paramList.jdField_b_of_type_Boolean)))
          {
            if (paramList.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718742));
            } else {
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718758));
            }
          }
          else
          {
            Resources localResources;
            if ((paramList != null) && (paramList.c == 17))
            {
              localObject = this.jdField_a_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (i > 99) {
                paramList = "99+";
              } else {
                paramList = Integer.valueOf(i);
              }
              ((TextView)localObject).setText(localResources.getString(2131694358, new Object[] { paramList }));
            }
            else if ((paramList != null) && (paramList.c == 100))
            {
              localObject = this.jdField_b_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (i > 99) {
                paramList = "99+";
              } else {
                paramList = Integer.valueOf(i);
              }
              ((TextView)localObject).setText(localResources.getString(2131699495, new Object[] { paramList }));
            }
          }
        }
        else
        {
          this.jdField_f_of_type_Boolean = false;
          k();
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(paramInt);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Int > 0))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(i, this.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToShowNavigateBar: navigateType:");
        localStringBuilder.append(i);
        localStringBuilder.append(", mUnreadCount = ");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(", isNeedToShow:");
        localStringBuilder.append(bool);
        if (c())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(", mMulNativigateSeqList size:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        QLog.d("Navigate.TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
      }
      return bool;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNeedToShowNavigateBar exception: isInitSuccess = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(", mHasShowBar = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append(", mUnreadCount = ");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    QLog.d("Navigate.TroopAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager = ((TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInit: troopUin = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", uinType = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", mUnreadCount = ");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append(", mTroopLastReadSeq:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    QLog.d("Navigate.TroopAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int;
      long l = this.jdField_b_of_type_Long;
      ((TroopAioNavigateBarManager)localObject).a(str, i, 1, l, l, "", 0, null);
    }
    localObject = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_e_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_f_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298048));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar = new NavigateBarDelegateFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
  }
  
  public boolean c()
  {
    return (TroopAioNavigateUtil.a(this.g)) && (!ListUtils.a(this.jdField_a_of_type_JavaUtilList));
  }
  
  protected void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUninit, troopUin = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    QLog.d("Navigate.TroopAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, 0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
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
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
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
    this.g = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.g);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject;
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString) != -1L) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new TroopAioMsgNavigateBar.SeqComparator(null));
      }
      if (!ListUtils.a(this.jdField_a_of_type_JavaUtilList))
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        this.jdField_c_of_type_Long = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue();
      }
    }
    else
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initNavigateType, mMulNativigateSeqList.size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)localObject).append(", navigateType = ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(", navShMsgSeq = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
      ((StringBuilder)localObject).append(", navigateSeq = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      QLog.d("Navigate.TroopAioMsgNavigateBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = null;
    ??? = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (??? != null)
    {
      ??? = ((TroopManager)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if ((??? != null) && (((TroopInfo)???).hasOrgs())) {
        this.jdField_e_of_type_Boolean = true;
      }
    }
    long l1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (c())
    {
      if (this.jdField_e_of_type_Boolean)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
        if (??? != null)
        {
          l1 = ((com.tencent.imcore.message.Message)???).shmsgseq;
          long l2 = this.jdField_c_of_type_Long;
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(l1 - l2);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)???, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, (String)localObject2, "", "", localStringBuilder.toString());
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
            break label661;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label661;
        }
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
      l1 = jdField_a_of_type_Long;
      ??? = a();
      if (??? != null) {
        l1 = ((MessageRecord)???).shmsgseq;
      }
      BaseTroopAioMsgNavigateBarDelegate.Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(this.g, this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaLangObject, l1, this.jdField_b_of_type_Long, this.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("prepareShowNavigateBar, navigateType = ");
        localStringBuilder.append(this.g);
        localStringBuilder.append(", navigateSeq = ");
        localStringBuilder.append(this.jdField_c_of_type_Long);
        localStringBuilder.append("， mMulNativigateSeqList.size = ");
        localStringBuilder.append(ListUtils.a(this.jdField_a_of_type_JavaUtilList));
        localStringBuilder.append(", firstMsgSeq = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mTroopLastReadSeq = ");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        localStringBuilder.append(", unreadCount = ");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(", entity = ");
        if (localEntity == null) {
          ??? = "null";
        } else {
          ??? = localEntity.toString();
        }
        localStringBuilder.append((String)???);
        QLog.d("Navigate.TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
      }
      if (localEntity == null)
      {
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      if ((c()) && (ListUtils.a(this.jdField_a_of_type_JavaUtilList))) {
        this.jdField_c_of_type_Boolean = false;
      } else {
        this.jdField_c_of_type_Boolean = localEntity.a();
      }
      this.jdField_b_of_type_JavaLangString = localEntity.a();
      this.jdField_c_of_type_JavaLangObject = localEntity.a();
      this.jdField_c_of_type_JavaLangString = localEntity.b();
      this.jdField_b_of_type_JavaLangObject = localEntity.b();
      return;
      label661:
      i -= 1;
    }
  }
  
  protected void i()
  {
    if ((this.g == 102) && (this.jdField_c_of_type_Boolean))
    {
      BaseTroopAioMsgNavigateBarDelegate localBaseTroopAioMsgNavigateBarDelegate = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarINavigateBar.a(102);
      if ((localBaseTroopAioMsgNavigateBarDelegate instanceof TroopAioMsgNavigateNotification)) {
        ((TroopAioMsgNavigateNotification)localBaseTroopAioMsgNavigateBarDelegate).c();
      }
    }
    else
    {
      j();
    }
  }
  
  protected void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        a(this.g, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangString);
        m();
        b();
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
        return;
      }
      Object localObject = a();
      int j = 0;
      int i = j;
      if (localObject != null)
      {
        long l = this.jdField_d_of_type_Long;
        i = j;
        if (l > this.jdField_b_of_type_Long)
        {
          i = j;
          if (l >= ((MessageRecord)localObject).shmsgseq) {
            i = 1;
          }
        }
      }
      if ((i != 0) && (a(this.g)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(TroopAioAgent.Message.a(this.g, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyUi==>navigateType = ");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(", navigateSeq = ");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject).append(", navShMsgSeq = ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
          QLog.d("Navigate.TroopAioMsgNavigateBar.troop.special_msg", 2, ((StringBuilder)localObject).toString());
        }
      }
      k();
    }
  }
  
  public void k()
  {
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.3(this));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (paramAnimation == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
      if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (paramAnimation == null) {
        return;
      }
      if ((paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation)) && (this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Navigate.TroopAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    else
    {
      int i = paramView.getId();
      if (i != 2131362331)
      {
        if ((i == 2131362541) || (i == 2131379143)) {
          n();
        }
      }
      else {
        k();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */