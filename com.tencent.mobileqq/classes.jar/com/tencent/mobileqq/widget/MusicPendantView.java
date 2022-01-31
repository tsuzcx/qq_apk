package com.tencent.mobileqq.widget;

import akuw;
import akux;
import akuy;
import akva;
import akvb;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.util.WeakReference;

public class MusicPendantView
  extends RelativeLayout
  implements Handler.Callback
{
  private static boolean d;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akuy(this);
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public MusicPendantListener a;
  private ArcImageView jdField_a_of_type_ComTencentMobileqqWidgetArcImageView;
  protected WeakReference a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public boolean b;
  private ImageView c;
  public boolean c;
  
  public MusicPendantView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener = new akuw(this);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  public MusicPendantView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener = new akuw(this);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  public MusicPendantView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener = new akuw(this);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(QQPlayerService.a())) || (MusicPendantManager.a.equalsIgnoreCase(QQPlayerService.a()))) {
          break label127;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantView", 1, "updatePlayOrPauseState() exception", localException);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839449);
      return;
      label127:
      do
      {
        if (paramInt == 3)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839450);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        if (paramInt == 2) {
          break;
        }
      } while (paramInt != 1);
    }
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2130970417, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView = ((ArcImageView)findViewById(2131370459));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370458));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370460));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new akux(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370456);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370457);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370455));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370454));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
  }
  
  public void a()
  {
    float f2 = 0.0F;
    for (;;)
    {
      try
      {
        String str2;
        if (MusicPendantManager.a.equalsIgnoreCase(QQPlayerService.a()))
        {
          Object localObject = QQPlayerService.a();
          if (localObject == null) {
            break label317;
          }
          localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
          str2 = MusicPendantManager.a().b();
          if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase((String)localObject))) {
            break label259;
          }
          int i = QQPlayerService.a();
          a(i);
          localObject = QQPlayerService.a();
          if (localObject != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(((SongInfo)localObject).b);
          }
          f1 = QQPlayerService.f();
          float f3 = QQPlayerService.d();
          if (f3 <= 0.0F) {
            break label303;
          }
          f1 /= f3;
          break label305;
          this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.setProgress(f1);
          if ((i == 2) || (i == 1) || (i == 3))
          {
            if (this.jdField_a_of_type_AndroidOsHandler != null) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1005);
            }
            postInvalidate();
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            break label316;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
          return;
        }
        if ((QQPlayerService.g() < QQPlayerService.c() - 1) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
        continue;
        QLog.e("MusicPendantView", 1, "refreshPlayState() " + localException + " is not current user:" + str2);
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantView", 1, "refreshPlayState() exception", localException);
        return;
      }
      label259:
      continue;
      label303:
      label305:
      do
      {
        break;
        f1 = 0.0F;
      } while (f1 >= 0.0F);
      float f1 = f2;
      continue;
      label316:
      return;
      label317:
      String str1 = "";
    }
  }
  
  public void a(Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicPendantView", 2, String.format("updateView card=%s", new Object[] { paramCard }) + ", isCardTroopMemberCard:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
    localMessage.obj = paramCard;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    try
    {
      Intent localIntent = MusicPendantManager.a().a(true);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(localIntent, 10000);
      }
      for (;;)
      {
        ReportController.b(MusicPendantManager.a().a(), "CliOper", "", "", "0X8005C9F", "0X8005C9F", 0, 0, "", "", "", "");
        return;
        QLog.e("MusicPendantView", 1, "openMusicPendantSettingPage() Activity is null!");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantView", 1, "openMusicPendantSettingPage() exception", localException);
    }
  }
  
  public void b(Card paramCard)
  {
    if (paramCard != null)
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MusicPendantView", 2, String.format("updateViewLocal mNowShowFlag=%s", new Object[] { Integer.valueOf(paramCard.mNowShowFlag) }));
          }
          if (paramCard.mNowShowFlag == 1)
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject = paramCard.mNowShowJumpUrl;
            this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new akva(this, (String)localObject, paramCard));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            if (!this.jdField_b_of_type_Boolean) {
              setVisibility(0);
            }
            this.jdField_a_of_type_Boolean = true;
            return;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          Object localObject = MusicPendantManager.a();
          if ((!NetworkUtil.g(BaseApplicationImpl.getContext())) || ((!((MusicPendantManager)localObject).a()) && ((!paramCard.visibleMusicPendant) || (((MusicPendantManager)localObject).a() == null) || (((MusicPendantManager)localObject).a().length <= 0)))) {
            break;
          }
          if (!this.jdField_b_of_type_Boolean) {
            setVisibility(0);
          }
          this.jdField_a_of_type_Boolean = true;
          a(QQPlayerService.a());
          if ((paramCard.showRedPointMusicPendant) || ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!d)))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.a(true);
            ThreadManager.post(new akvb(this), 8, null, true);
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              return;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
            return;
          }
        }
        catch (Exception paramCard)
        {
          QLog.e("MusicPendantView", 1, "updateViewLocal() exception", paramCard);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.a(false);
      }
      setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      MusicPendantManager.a().d();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      }
    }
    else
    {
      setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
      QLog.e("MusicPendantView", 1, "updateViewLocal() card is null!");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (paramMessage == null) {
      i = 200;
    }
    Object localObject1;
    for (;;)
    {
      if (paramMessage != null)
      {
        try
        {
          localObject1 = paramMessage.obj;
        }
        catch (Exception paramMessage)
        {
          QLog.e("MusicPendantView", 1, "mPlayClickListener.onClick() exception", paramMessage);
          return true;
        }
        i = paramMessage.what;
        continue;
        a();
        return true;
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          postInvalidate();
          return true;
          paramMessage = localObject2;
          if (localObject1 != null)
          {
            paramMessage = localObject2;
            if ((localObject1 instanceof Card)) {
              paramMessage = (Card)localObject1;
            }
          }
          b(paramMessage);
          return true;
          if (paramMessage == null) {
            break label283;
          }
        }
      }
    }
    label283:
    for (int i = paramMessage.arg1;; i = -1)
    {
      a(i);
      a();
      return true;
      if ((localObject1 != null) && ((localObject1 instanceof SongInfo))) {}
      for (paramMessage = (SongInfo)localObject1;; paramMessage = null)
      {
        if ((paramMessage != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.b);
        }
        a();
        return true;
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        postInvalidate();
        return true;
      }
      for (;;)
      {
        switch (i)
        {
        }
        return true;
        localObject1 = null;
      }
    }
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MusicPendantView
 * JD-Core Version:    0.7.0.1
 */