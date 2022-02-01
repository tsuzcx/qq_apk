package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor.RichTitleConfBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.music.LyricStateListener;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AioFriendTitleHelper
  implements ILifeCycleHelper, LyricStateListener
{
  public static int a = 259200;
  private BaseChatPie b;
  private boolean c;
  private boolean d;
  private TextView e;
  private TextView f;
  private ViewFlipper g;
  private View.OnClickListener h = new AioFriendTitleHelper.3(this);
  
  public AioFriendTitleHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private void a(RichStatus paramRichStatus)
  {
    if (paramRichStatus != null)
    {
      String str = paramRichStatus.getPlainText();
      long l1 = paramRichStatus.time;
      long l2 = NetConnInfoCenter.getServerTime();
      paramRichStatus = RichTitleConfProcessor.a();
      if (paramRichStatus != null)
      {
        a = (int)(paramRichStatus.a * 60.0D * 60.0D);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("needShowRichSubTitle-> richTitleConfBean.c2c_time_interval = ");
          localStringBuilder.append(paramRichStatus.a);
          QLog.d("AioFriendTitleHelper", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramRichStatus = new StringBuilder();
        paramRichStatus.append("needShowRichSubTitle-> c = ");
        paramRichStatus.append(l2);
        paramRichStatus.append(" time = ");
        paramRichStatus.append(l1);
        paramRichStatus.append(" needShow =");
        boolean bool;
        if (l2 - l1 < a) {
          bool = true;
        } else {
          bool = false;
        }
        paramRichStatus.append(bool);
        QLog.d("AioFriendTitleHelper", 2, paramRichStatus.toString());
      }
      if (l2 - l1 < a)
      {
        this.c = (TextUtils.isEmpty(str) ^ true);
        a(str);
        ReportController.b(this.b.d, "CliOper", "", "", "0X800A66A", "0X800A66A", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      if ((this.g.getCurrentView() == this.e) && (this.c)) {
        this.g.showNext();
      }
    }
    else if (this.g.getCurrentView() != this.e) {
      this.g.showNext();
    }
    if (this.g.isFlipping()) {
      this.g.stopFlipping();
    }
    if (paramBoolean2) {
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.b.d, i(), this.e, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioFriendTitleHelper", 2, new Object[] { "resetSubTitleText, ", paramString });
    }
  }
  
  private Friends i()
  {
    return ((FriendsManager)this.b.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.b.ah.b);
  }
  
  private void j()
  {
    if ((!TextUtils.isEmpty(this.e.getText())) && (!TextUtils.isEmpty(this.f.getText())))
    {
      if ((this.e.getVisibility() == 0) && (this.f.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 1 startFlipping all Visibility");
        }
        this.g.showNext();
      }
      if (!this.g.isFlipping()) {
        this.g.startFlipping();
      }
    }
    else
    {
      if ((TextUtils.isEmpty(this.e.getText())) && (this.g.getCurrentView() == this.e))
      {
        this.g.showNext();
        return;
      }
      if ((TextUtils.isEmpty(this.f.getText())) && (this.g.getCurrentView() == this.f)) {
        this.g.showNext();
      }
    }
  }
  
  public void a()
  {
    b(null);
  }
  
  public void a(ViewFlipper paramViewFlipper, TextView paramTextView1, TextView paramTextView2)
  {
    this.g = paramViewFlipper;
    this.g.setOutAnimation(null);
    this.e = paramTextView1;
    this.f = paramTextView2;
    e();
    d();
    paramViewFlipper = this.e;
    if ((paramViewFlipper instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)paramViewFlipper).setLyricStateListener(this);
    }
  }
  
  protected void a(String paramString)
  {
    TextView localTextView = this.f;
    if ((localTextView != null) && (this.g != null) && (localTextView != null))
    {
      if (this.b.ah == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.f.setVisibility(0);
      this.f.setText(new QQText(paramString, 3, 12));
      this.f.setCompoundDrawables(null, null, null, null);
      this.f.setOnClickListener(this.h);
      b("");
    }
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowRichSubTitle, onShowSubTitleText() isShowInputStatus =  ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" statusText = ");
      localStringBuilder.append(paramString);
      QLog.i("AioFriendTitleHelper", 2, localStringBuilder.toString());
    }
    if (!this.c) {
      return false;
    }
    this.b.f.runOnUiThread(new AioFriendTitleHelper.2(this, paramBoolean, paramString));
    return true;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    if ((!this.b.bf) && (!this.c)) {
      return;
    }
    if (h())
    {
      a(false, false, "isListenTogetherTime");
      return;
    }
    if (this.d)
    {
      a(false, true, "isInputting");
      return;
    }
    if (g())
    {
      a(true, true, "isStatusOffline");
      return;
    }
    if (!this.b.bf)
    {
      a(true, true, "mChatPie.setSubTitleVisible");
      return;
    }
    if (f())
    {
      a(false, false, "isPlayLyric");
      return;
    }
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle");
      }
      j();
    }
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.b.d, i(), this.e, true);
  }
  
  public void c()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((ViewFlipper)localObject).getCurrentView() != this.e) {
        this.g.showNext();
      }
      this.g.stopFlipping();
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((TextView)localObject).setText("");
      if (QLog.isColorLevel()) {
        QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> destroy()");
      }
    }
    this.d = false;
    this.c = false;
    localObject = this.e;
    if ((localObject instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)localObject).f();
    }
  }
  
  protected void d()
  {
    RichStatus localRichStatus = ((StatusManager)this.b.d.getManager(QQManagerFactory.STATUS_MANAGER)).a(this.b.ah.b, false);
    if ((localRichStatus != null) && (!localRichStatus.isEmpty()))
    {
      a(localRichStatus);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AioFriendTitleHelper.1(this));
  }
  
  public void e()
  {
    TextView localTextView = this.f;
    if (localTextView != null)
    {
      if (this.g == null) {
        return;
      }
      localTextView.setText("");
      this.g.stopFlipping();
    }
  }
  
  public boolean f()
  {
    TextView localTextView = this.e;
    if ((localTextView instanceof OnlineStatusLyricView)) {
      return ((OnlineStatusLyricView)localTextView).d();
    }
    return false;
  }
  
  public boolean g()
  {
    Object localObject = ((FriendsManager)this.b.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.b.ah.b);
    if (localObject == null)
    {
      ThreadManager.post(new AioFriendTitleHelper.4(this), 8, null, true);
      return false;
    }
    int i = OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needShowRichSubTitle, isStatusOffline() -> status = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("AioFriendTitleHelper", 2, ((StringBuilder)localObject).toString());
    }
    return i == 0;
  }
  
  public String getTag()
  {
    return "AioFriendTitleHelper";
  }
  
  public boolean h()
  {
    Object localObject = this.b;
    int j = 0;
    if (localObject == null) {
      return false;
    }
    localObject = (C2CListenTogetherPanel)((BaseChatPie)localObject).q(32);
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((C2CListenTogetherPanel)localObject).e()) {
        i = 1;
      }
    }
    if (i != 0) {
      return true;
    }
    return ((TogetherControlHelper)this.b.q(43)).e();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 11)
        {
          if (paramInt != 15) {
            return;
          }
          c();
          return;
        }
        ViewFlipper localViewFlipper = this.g;
        if ((localViewFlipper != null) && (localViewFlipper.isFlipping())) {
          this.g.stopFlipping();
        }
      }
      else
      {
        b("");
      }
    }
    else {
      a(this.b.K, this.b.I, this.b.J);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper
 * JD-Core Version:    0.7.0.1
 */