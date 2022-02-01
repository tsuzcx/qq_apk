package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopAioKeywordTipBar
  extends TroopAioAgent
  implements View.OnClickListener
{
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopAioKeywordTipBar.1(this);
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private TroopAioKeywordTipBar.ViewHolder jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
  private TroopAioKeywordTipInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo;
  private TroopAioTips jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopAioKeywordTipBar.4(this);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MessageRecord jdField_b_of_type_ComTencentMobileqqDataMessageRecord;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f;
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = paramTroopAioKeywordTipInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (!b()) {
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageRecord.uniseq);
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder = new TroopAioKeywordTipBar.ViewHolder(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560607, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379145));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379148));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).b = ((TextView)((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379147));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((TroopAioKeywordTipBar.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379144));
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851086);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130844014);
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.icon);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.e();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
      if (((URLDrawable)localObject1).getStatus() == 2) {
        ((URLDrawable)localObject1).restartDownload();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject1);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.b.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.b.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.b.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup) < 0)
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      int i = TroopAioMsgNavigateBar.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131379333, 2131374119, 2131374255, 2131374250 });
      if (i > 0) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, i);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject1 = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      ((Animation)localObject1).setDuration(500L);
      this.jdField_b_of_type_Boolean = true;
      ((Animation)localObject1).setAnimationListener(new TroopAioKeywordTipBar.2(this));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.getAnimation() == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject1);
      }
      localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("notice_center_new");
      if (paramMessageRecord.isSend()) {
        localObject1 = "exp_keyword_input";
      } else {
        localObject1 = "exp_keyword_msg";
      }
      ((ReportTask)localObject2).d((String)localObject1).a(new String[] { paramMessageRecord.frienduin, String.valueOf(paramTroopAioKeywordTipInfo.ruleId), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword") }).a();
      return;
    }
    catch (MalformedURLException paramMessageRecord)
    {
      paramTroopAioKeywordTipInfo = new StringBuilder();
      paramTroopAioKeywordTipInfo.append("tryShow,e=");
      paramTroopAioKeywordTipInfo.append(paramMessageRecord.toString());
      QLog.i("TroopAioKeywordTipBar", 1, paramTroopAioKeywordTipInfo.toString());
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt < 0) {
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    boolean bool1 = bool2;
    if (paramInt >= i - j)
    {
      bool1 = bool2;
      if (paramInt <= k - m) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b(paramMessageRecord.uniseq));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder != null) && (this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup) < 0) {
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setAnimationListener(new TroopAioKeywordTipBar.3(this, paramBoolean));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.getAnimation() == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool2 = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    boolean bool1 = true;
    Object localObject;
    if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null))
    {
      if (this.f != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "tryShow, mScrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE");
        }
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
      if ((localObject != null) && (((TroopAioTips)localObject).g()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "tryShow, hasRightTopTipBar");
        }
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryShow, not inVisiblePosition,tipInfo is null");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.i("TroopAioKeywordTipBar", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword"));
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
      if ((!localList.contains(localStringBuilder.toString())) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()))
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword"));
        localStringBuilder.append("_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
        localList.add(localStringBuilder.toString());
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject != null) && (((MessageRecord)localObject).isSend()))
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword"));
        localStringBuilder.append("_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
        ((List)localObject).remove(localStringBuilder.toString());
      }
    }
  }
  
  public View a()
  {
    TroopAioKeywordTipBar.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder;
    if (localViewHolder != null) {
      return localViewHolder.jdField_a_of_type_AndroidViewViewGroup;
    }
    return null;
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.f = paramInt;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollStateChange,isInitSuccess == false");
      }
      return;
    }
    if (this.f == 0)
    {
      if ((this.jdField_b_of_type_Boolean) && (!a(this.jdField_d_of_type_Int))) {
        b(false);
      }
      a(paramLong);
      return;
    }
    if (this.c)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.c = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.c)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
      this.c = true;
    }
  }
  
  public void a(TroopAioTips paramTroopAioTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void d()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup) >= 0))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar$ViewHolder = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollToBottom,isInitSuccess == false");
      }
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().size();
    if (i == this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "curMsgCount == mLastScrollToBottomListViewCount");
      }
      return;
    }
    this.e = i;
    a(0, 0L);
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioListRefresh,isInitSuccess == false");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      h();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url)) {
        try
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$GCODE$")) {
            localObject2 = ((String)localObject1).replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
          }
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$TEXT$")) {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText))
            {
              localObject1 = ((String)localObject2).replace("$TEXT$", Base64Util.encodeToString(((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).sb.toString().getBytes(), 0));
            }
            else
            {
              localObject1 = localObject2;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                localObject1 = localObject2;
                if ((localMessageForStructing.structingMsg instanceof AbsShareMsg)) {
                  localObject1 = ((String)localObject2).replace("$TEXT$", Base64Util.encodeToString(((AbsShareMsg)localMessageForStructing.structingMsg).mContentTitle.getBytes(), 0));
                }
              }
            }
          }
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$KEYWORD$")) {
            localObject2 = ((String)localObject1).replace("$KEYWORD$", Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword").getBytes(), 0));
          }
          if (((String)localObject2).startsWith("http"))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClass(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", (String)localObject2);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          else if (((String)localObject2).startsWith("mqqapi"))
          {
            localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
            if (localObject1 != null) {
              ((JumpAction)localObject1).a();
            }
          }
          if (!QLog.isColorLevel()) {
            break label433;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onClick, url=");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.i("TroopAioKeywordTipBar", 2, ((StringBuilder)localObject1).toString());
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("error=");
          ((StringBuilder)localObject2).append(localException.toString());
          ((StringBuilder)localObject2).append(",url=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url);
          QLog.i("TroopAioKeywordTipBar", 1, ((StringBuilder)localObject2).toString());
        }
      } else {
        QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo.url is empty");
      }
      label433:
      Object localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("notice_center_new");
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
        str = "clk_keyword_input";
      } else {
        str = "clk_keyword_msg";
      }
      ((ReportTask)localObject2).d(str).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword") }).a();
      b(true);
    }
    else
    {
      QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo == null || mCurrentTipMR != null");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar
 * JD-Core Version:    0.7.0.1
 */