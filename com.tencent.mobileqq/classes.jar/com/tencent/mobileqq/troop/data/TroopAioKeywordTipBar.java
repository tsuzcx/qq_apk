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
  private TroopAioKeywordTipBar.ViewHolder d;
  private TroopAioKeywordTipInfo e;
  private MessageRecord f;
  private int g;
  private TroopAioTips h;
  private boolean i;
  private boolean j = false;
  private List<String> k = new ArrayList();
  private int l;
  private boolean m = false;
  private int n;
  private MessageRecord o;
  private MessageObserver p = new TroopAioKeywordTipBar.1(this);
  private Runnable q = new TroopAioKeywordTipBar.4(this);
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    this.e = paramTroopAioKeywordTipInfo;
    this.f = paramMessageRecord;
    if (!g()) {
      return;
    }
    this.g = this.I.a(paramMessageRecord.uniseq);
    Object localObject1;
    if (this.d == null)
    {
      this.d = new TroopAioKeywordTipBar.ViewHolder(this);
      this.d.a = ((ViewGroup)LayoutInflater.from(this.E).inflate(2131626652, null));
      this.d.a.setOnClickListener(this);
      localObject1 = this.d;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).b = ((URLThemeImageView)((TroopAioKeywordTipBar.ViewHolder)localObject1).a.findViewById(2131447881));
      localObject1 = this.d;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).c = ((TextView)((TroopAioKeywordTipBar.ViewHolder)localObject1).a.findViewById(2131447884));
      localObject1 = this.d;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).d = ((TextView)((TroopAioKeywordTipBar.ViewHolder)localObject1).a.findViewById(2131447883));
      localObject1 = this.d;
      ((TroopAioKeywordTipBar.ViewHolder)localObject1).e = ((ImageView)((TroopAioKeywordTipBar.ViewHolder)localObject1).a.findViewById(2131447880));
      this.d.e.setImageResource(2130853321);
    }
    this.d.a.setBackgroundResource(2130844969);
    try
    {
      localObject1 = new URL(this.e.icon);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.j();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
      if (((URLDrawable)localObject1).getStatus() == 2) {
        ((URLDrawable)localObject1).restartDownload();
      }
      this.d.b.setImageDrawable((Drawable)localObject1);
      if (TextUtils.isEmpty(this.e.title))
      {
        this.d.c.setVisibility(8);
      }
      else
      {
        this.d.c.setVisibility(0);
        this.d.c.setText(this.e.title);
      }
      if (TextUtils.isEmpty(this.e.summary))
      {
        this.d.d.setVisibility(8);
      }
      else
      {
        this.d.d.setVisibility(0);
        this.d.d.setText(this.e.summary);
      }
      if (this.G.indexOfChild(this.d.a) < 0)
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.E, 18.0F);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        this.G.addView(this.d.a, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)this.d.a.getLayoutParams();
      int i1 = TroopAioMsgNavigateBar.a(this.G, new int[] { 2131448070, 2131442214, 2131442350, 2131442345 });
      if (i1 > 0) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, i1);
      }
      this.d.a.setVisibility(0);
      localObject1 = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      ((Animation)localObject1).setDuration(500L);
      this.i = true;
      ((Animation)localObject1).setAnimationListener(new TroopAioKeywordTipBar.2(this));
      if (this.d.a.getAnimation() == null) {
        this.d.a.startAnimation((Animation)localObject1);
      }
      localObject2 = new ReportTask(this.D).a("dc00899").b("Grp_AIO").c("notice_center_new");
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
    int i1 = this.J.getFirstVisiblePosition();
    int i2 = this.J.getHeaderViewsCount();
    int i3 = this.J.getLastVisiblePosition();
    int i4 = this.J.getHeaderViewsCount();
    boolean bool1 = bool2;
    if (paramInt >= i1 - i2)
    {
      bool1 = bool2;
      if (paramInt <= i3 - i4) {
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
    return a(this.I.b(paramMessageRecord.uniseq));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.M) && (this.d != null) && (this.i))
    {
      if (this.G.indexOfChild(this.d.a) < 0) {
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setAnimationListener(new TroopAioKeywordTipBar.3(this, paramBoolean));
      if (this.d.a.getAnimation() == null) {
        this.d.a.startAnimation(localTranslateAnimation);
      }
    }
  }
  
  private boolean g()
  {
    boolean bool2 = a(this.f);
    boolean bool1 = true;
    Object localObject;
    if ((bool2) && (this.e != null))
    {
      if (this.n != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "tryShow, mScrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE");
        }
        return false;
      }
      localObject = this.h;
      if ((localObject != null) && (((TroopAioTips)localObject).p()))
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
      if (this.e != null) {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.i("TroopAioKeywordTipBar", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private void h()
  {
    if ((this.e != null) && (this.f != null))
    {
      List localList = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f.getExtInfoFromExtStr("key_aio_keyword"));
      localStringBuilder.append("_");
      localStringBuilder.append(this.e.ruleId);
      if ((!localList.contains(localStringBuilder.toString())) && (this.f.isSend()))
      {
        localList = this.k;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.f.getExtInfoFromExtStr("key_aio_keyword"));
        localStringBuilder.append("_");
        localStringBuilder.append(this.e.ruleId);
        localList.add(localStringBuilder.toString());
      }
    }
  }
  
  private void i()
  {
    if (this.e != null)
    {
      Object localObject = this.f;
      if ((localObject != null) && (((MessageRecord)localObject).isSend()))
      {
        localObject = this.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.f.getExtInfoFromExtStr("key_aio_keyword"));
        localStringBuilder.append("_");
        localStringBuilder.append(this.e.ruleId);
        ((List)localObject).remove(localStringBuilder.toString());
      }
    }
  }
  
  protected void a()
  {
    this.D.addObserver(this.p);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.n = paramInt;
    if (!this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollStateChange,isInitSuccess == false");
      }
      return;
    }
    if (this.n == 0)
    {
      if ((this.i) && (!a(this.g))) {
        b(false);
      }
      a(paramLong);
      return;
    }
    if (this.j)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.q);
      this.j = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.j)
    {
      ThreadManager.getUIHandler().postDelayed(this.q, paramLong);
      this.j = true;
    }
  }
  
  public void a(TroopAioTips paramTroopAioTips)
  {
    this.h = paramTroopAioTips;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  protected void b()
  {
    this.m = false;
    this.D.removeObserver(this.p);
    if ((this.G != null) && (this.d != null) && (this.G.indexOfChild(this.d.a) >= 0))
    {
      this.G.removeView(this.d.a);
      this.d = null;
    }
    this.i = false;
    this.e = null;
    this.f = null;
    this.g = -1;
    this.k.clear();
  }
  
  public void c()
  {
    if (!this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollToBottom,isInitSuccess == false");
      }
      return;
    }
    int i1 = this.I.a().size();
    if (i1 == this.l)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "curMsgCount == mLastScrollToBottomListViewCount");
      }
      return;
    }
    this.l = i1;
    a(0, 0L);
  }
  
  public void d()
  {
    if (!this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioListRefresh,isInitSuccess == false");
      }
      return;
    }
    if (this.f != null) {
      this.g = this.I.a(this.f.uniseq);
    }
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public View f()
  {
    TroopAioKeywordTipBar.ViewHolder localViewHolder = this.d;
    if (localViewHolder != null) {
      return localViewHolder.a;
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if ((this.e != null) && (this.f != null))
    {
      i();
      if (!TextUtils.isEmpty(this.e.url)) {
        try
        {
          Object localObject1 = this.e.url;
          localObject2 = localObject1;
          if (this.e.url.contains("$GCODE$")) {
            localObject2 = ((String)localObject1).replace("$GCODE$", this.f.frienduin);
          }
          localObject1 = localObject2;
          if (this.e.url.contains("$TEXT$")) {
            if ((this.f instanceof MessageForText))
            {
              localObject1 = ((String)localObject2).replace("$TEXT$", Base64Util.encodeToString(((MessageForText)this.f).sb.toString().getBytes(), 0));
            }
            else
            {
              localObject1 = localObject2;
              if ((this.f instanceof MessageForStructing))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)this.f;
                localObject1 = localObject2;
                if ((localMessageForStructing.structingMsg instanceof AbsShareMsg)) {
                  localObject1 = ((String)localObject2).replace("$TEXT$", Base64Util.encodeToString(((AbsShareMsg)localMessageForStructing.structingMsg).mContentTitle.getBytes(), 0));
                }
              }
            }
          }
          localObject2 = localObject1;
          if (this.e.url.contains("$KEYWORD$")) {
            localObject2 = ((String)localObject1).replace("$KEYWORD$", Base64Util.encodeToString(this.f.getExtInfoFromExtStr("key_aio_keyword").getBytes(), 0));
          }
          if (((String)localObject2).startsWith("http"))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClass(this.E, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", (String)localObject2);
            this.E.startActivity((Intent)localObject1);
          }
          else if (((String)localObject2).startsWith("mqqapi"))
          {
            localObject1 = JumpParser.a(this.D, this.E, (String)localObject2);
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
          ((StringBuilder)localObject2).append(this.e.url);
          QLog.i("TroopAioKeywordTipBar", 1, ((StringBuilder)localObject2).toString());
        }
      } else {
        QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo.url is empty");
      }
      label433:
      Object localObject2 = new ReportTask(this.D).a("dc00899").b("Grp_AIO").c("notice_center_new");
      String str;
      if (this.f.isSend()) {
        str = "clk_keyword_input";
      } else {
        str = "clk_keyword_msg";
      }
      ((ReportTask)localObject2).d(str).a(new String[] { this.f.frienduin, String.valueOf(this.e.ruleId), this.f.getExtInfoFromExtStr("key_aio_keyword") }).a();
      b(true);
    }
    else
    {
      QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo == null || mCurrentTipMR != null");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar
 * JD-Core Version:    0.7.0.1
 */