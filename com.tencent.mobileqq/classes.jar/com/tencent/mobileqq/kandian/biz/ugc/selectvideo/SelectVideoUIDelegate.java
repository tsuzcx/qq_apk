package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SelectVideoUIDelegate
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, PlayerStatusListener
{
  private IReadInJoyPlayer a;
  private ViewGroup b = (ViewGroup)LayoutInflater.from(BaseApplication.getContext()).inflate(2131626096, null, false);
  private SeekBar c;
  private ProgressBar d;
  private ImageButton e;
  private ViewGroup f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private TextView j;
  private ViewGroup k;
  private boolean l = false;
  private AlbumUtils.LocalMediaInfo m;
  private Handler n = new SelectVideoUIDelegate.InnerHandler(this);
  
  private int a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    return 1;
  }
  
  private void a(int paramInt)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.e.clearAnimation();
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.e.setImageDrawable(localResources.getDrawable(2130844326));
      this.e.setTag(Integer.valueOf(2));
      return;
    }
    this.e.setImageDrawable(localResources.getDrawable(2130844327));
    this.e.setTag(Integer.valueOf(1));
  }
  
  private void a(long paramLong)
  {
    int i1 = (int)(paramLong / 1000L);
    if (!this.l)
    {
      this.c.setProgress(i1);
      this.d.setProgress(i1);
    }
    this.g.setText(ReadInJoyDisplayUtils.a(i1));
  }
  
  private void d()
  {
    this.c = ((SeekBar)this.b.findViewById(2131445496));
    this.d = ((ProgressBar)this.b.findViewById(2131449693));
    this.e = ((ImageButton)this.b.findViewById(2131440375));
    this.f = ((ViewGroup)this.b.findViewById(2131449514));
    this.g = ((TextView)this.b.findViewById(2131449695));
    this.h = ((TextView)this.b.findViewById(2131449538));
    this.i = ((ImageView)this.b.findViewById(2131431470));
    this.j = ((TextView)this.b.findViewById(2131448814));
    this.c.setOnSeekBarChangeListener(this);
    this.e.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.f.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private void e()
  {
    int i1 = (int)this.a.j() / 1000;
    this.c.setMax(i1);
    this.d.setMax(i1);
    a(0L);
    this.h.setText(ReadInJoyDisplayUtils.a(i1));
    this.g.setText(ReadInJoyDisplayUtils.a(0));
  }
  
  private void f()
  {
    this.a = ReadInJoyPlayerFactory.get().createPlayer(1000);
    this.a.a(this);
  }
  
  private void g()
  {
    this.a.d(true);
    this.a.e(false);
  }
  
  private boolean h()
  {
    return this.e.getVisibility() == 0;
  }
  
  private void i()
  {
    if (this.f.getVisibility() != 0) {
      return;
    }
    this.f.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  private void j()
  {
    if (l())
    {
      i();
      return;
    }
    k();
  }
  
  private void k()
  {
    if (this.f.getVisibility() == 0) {
      return;
    }
    if (this.a.t()) {
      a(1);
    } else if (this.a.u()) {
      a(2);
    }
    VideoFeedsHelper.a(this.f, 0, 300);
    this.d.setVisibility(8);
    this.n.removeMessages(101);
    if (this.a.u()) {
      this.n.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private boolean l()
  {
    return this.f.getVisibility() == 0;
  }
  
  public void a()
  {
    this.a.D();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QLog.e("RIJUGC.SelectVideoUIDelegate", 1, "attachVideoView failed for containerView is null.");
      return;
    }
    this.k = paramViewGroup;
    paramViewGroup.setEnabled(false);
    d();
    f();
    this.a.a(paramViewGroup);
    paramViewGroup.addView(this.b);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return;
    }
    this.m = paramLocalMediaInfo;
    this.j.setText(paramLocalMediaInfo.i);
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.1(this, paramLocalMediaInfo));
  }
  
  public void b()
  {
    this.a.C();
  }
  
  public void beforeVideoStart() {}
  
  public void c()
  {
    this.a.F();
  }
  
  public void onBufferEnd() {}
  
  public void onBufferStart() {}
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == this.e.getId())
    {
      i1 = a(paramView);
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.a.f();
        return;
      }
      this.a.e();
      return;
    }
    if (i1 == this.k.getId()) {
      j();
    }
  }
  
  public void onCompletion() {}
  
  public void onFirstFrameRendered() {}
  
  public void onProgressChanged(long paramLong)
  {
    a(paramLong);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.l = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.l = false;
    int i1 = paramSeekBar.getProgress();
    this.a.b(i1 * 1000);
  }
  
  public void onVideoEnd(int paramInt) {}
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onVideoOpen() {}
  
  public void onVideoPause()
  {
    if (h()) {
      a(1);
    }
    this.n.removeMessages(101);
  }
  
  public void onVideoPrepared()
  {
    g();
    this.a.e();
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.2(this));
  }
  
  public void onVideoRestart()
  {
    a(2);
    this.n.removeMessages(101);
    this.n.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStart()
  {
    a(2);
    this.n.removeMessages(101);
    this.n.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */