package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.io.File;
import mqq.app.MobileQQ;

public class AudioItem
  extends UploadEditItem<AudioItem.AudioViewHolder, AudioInfo>
{
  boolean a = false;
  private LayoutInflater d;
  private Context e;
  private VoicePlayer f;
  private boolean g = false;
  private AudioInfo h;
  private VoicePlayer.VoicePlayerListener i = new AudioItem.3(this);
  private BroadcastReceiver j = new AudioItem.4(this);
  
  public AudioItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.e = paramContext;
    this.d = LayoutInflater.from(paramContext);
    paramXMediaEditor = new IntentFilter();
    paramXMediaEditor.addAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    paramXMediaEditor.addAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    if (!this.a)
    {
      this.e.registerReceiver(this.j, paramXMediaEditor);
      this.a = true;
    }
  }
  
  private void g(AudioInfo paramAudioInfo)
  {
    if (this.g) {
      return;
    }
    this.g = true;
    this.h = paramAudioInfo;
    paramAudioInfo.f = true;
    this.f = new VoicePlayer(paramAudioInfo.a, new Handler());
    this.f.a(this.e);
    this.f.h();
    this.f.a(this.i);
    this.f.c();
    AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.b.findViewHolderForAdapterPosition(paramAudioInfo.g);
    if (localAudioViewHolder != null)
    {
      if (paramAudioInfo.f)
      {
        paramAudioInfo = (AnimationDrawable)this.e.getResources().getDrawable(2130772405);
        localAudioViewHolder.a.setImageDrawable(paramAudioInfo);
        paramAudioInfo.start();
        return;
      }
      localAudioViewHolder.a.setImageResource(2130848916);
    }
  }
  
  private void h(AudioInfo paramAudioInfo)
  {
    TroopHomeworkHelper.UploadFileTask localUploadFileTask = new TroopHomeworkHelper.UploadFileTask(MobileQQ.sMobileQQ.waitAppRuntime(null), paramAudioInfo.a, paramAudioInfo.e);
    localUploadFileTask.a(new AudioItem.AudioUploadCallback(this, paramAudioInfo));
    paramAudioInfo.o = 1;
    ThreadManager.post(new AudioItem.2(this, localUploadFileTask), 8, null, true);
  }
  
  public AudioItem.AudioViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new AudioItem.AudioViewHolder(this.d.inflate(2131627885, paramViewGroup, false));
    b(paramViewGroup.b, paramViewGroup);
    b(paramViewGroup.c, paramViewGroup);
    b(paramViewGroup.e, paramViewGroup);
    if (this.b.getLeftRightPadding() != 0)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      localLayoutParams.leftMargin = this.b.getLeftRightPadding();
      localLayoutParams.rightMargin = this.b.getLeftRightPadding();
    }
    return paramViewGroup;
  }
  
  public void a()
  {
    if (this.g) {
      b(this.h);
    }
    if (this.a)
    {
      this.e.unregisterReceiver(this.j);
      this.a = false;
    }
  }
  
  public void a(View paramView, AudioItem.AudioViewHolder paramAudioViewHolder)
  {
    int k = paramView.getId();
    if (k == 2131428877)
    {
      if ((TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.f).a)) && (TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.f).b))) {
        return;
      }
      a((AudioInfo)paramAudioViewHolder.f);
      return;
    }
    if (k == 2131444738)
    {
      h((AudioInfo)paramAudioViewHolder.f);
      paramAudioViewHolder.d.setVisibility(4);
      paramAudioViewHolder.a.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
      return;
    }
    if (k == 2131430825)
    {
      this.c.a(paramAudioViewHolder);
      paramView = this.h;
      if ((paramView != null) && (paramView.f) && (this.h.g == ((AudioInfo)paramAudioViewHolder.f).g)) {
        b(this.h);
      }
    }
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    if (this.g)
    {
      if (paramAudioInfo.f)
      {
        b(paramAudioInfo);
        return;
      }
      b(this.h);
      c(paramAudioInfo);
      return;
    }
    c(paramAudioInfo);
  }
  
  public void a(AudioItem.AudioViewHolder paramAudioViewHolder, AudioInfo paramAudioInfo, int paramInt)
  {
    if (paramInt != 0)
    {
      paramAudioViewHolder.a.setVisibility(0);
      paramAudioViewHolder.b.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
    }
    else
    {
      paramAudioViewHolder.b.setVisibility(0);
      paramInt = paramAudioInfo.o;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              paramAudioViewHolder.d.setVisibility(0);
              paramAudioViewHolder.a.setVisibility(0);
              paramAudioViewHolder.c.setVisibility(4);
            }
          }
          else
          {
            paramAudioViewHolder.d.setVisibility(4);
            paramAudioViewHolder.a.setVisibility(4);
            paramAudioViewHolder.c.setVisibility(0);
          }
        }
        else
        {
          paramAudioViewHolder.d.setVisibility(4);
          paramAudioViewHolder.a.setVisibility(4);
          paramAudioViewHolder.c.setVisibility(4);
        }
      }
      else
      {
        paramAudioViewHolder.d.setVisibility(4);
        paramAudioViewHolder.a.setVisibility(4);
        paramAudioViewHolder.c.setVisibility(4);
      }
    }
    TextView localTextView = paramAudioViewHolder.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInfo.c);
    localStringBuilder.append("\"");
    localTextView.setText(localStringBuilder.toString());
    if (paramAudioInfo.f)
    {
      paramAudioInfo = (AnimationDrawable)this.e.getResources().getDrawable(2130772405);
      paramAudioViewHolder.a.setImageDrawable(paramAudioInfo);
      paramAudioInfo.start();
      return;
    }
    paramAudioViewHolder.a.setImageResource(2130848916);
  }
  
  public void b(AudioInfo paramAudioInfo)
  {
    if ((paramAudioInfo != null) && (paramAudioInfo.f))
    {
      this.g = false;
      this.f.f();
      this.f = null;
      paramAudioInfo.f = false;
      this.h = null;
      AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.b.findViewHolderForAdapterPosition(paramAudioInfo.g);
      if (localAudioViewHolder != null)
      {
        if (paramAudioInfo.f)
        {
          paramAudioInfo = (AnimationDrawable)this.e.getResources().getDrawable(2130772405);
          localAudioViewHolder.a.setImageDrawable(paramAudioInfo);
          paramAudioInfo.start();
          return;
        }
        localAudioViewHolder.a.setImageResource(2130848916);
      }
    }
  }
  
  public void c(AudioInfo paramAudioInfo)
  {
    if ((!TextUtils.isEmpty(paramAudioInfo.a)) && (new File(paramAudioInfo.a).exists()))
    {
      g(paramAudioInfo);
      return;
    }
    if (!TextUtils.isEmpty(paramAudioInfo.b))
    {
      if (!NetworkUtil.isNetworkAvailable(this.e))
      {
        paramAudioInfo = this.e;
        QQToast.makeText(paramAudioInfo, paramAudioInfo.getString(2131891334), 0).show();
        return;
      }
      ThreadManager.post(new AudioItem.1(this, paramAudioInfo), 8, null, true);
    }
  }
  
  public void d(AudioInfo paramAudioInfo)
  {
    e(paramAudioInfo);
  }
  
  public void e(AudioInfo paramAudioInfo)
  {
    if (TextUtils.isEmpty(paramAudioInfo.b))
    {
      if (paramAudioInfo.o != 0) {
        return;
      }
      h(paramAudioInfo);
    }
  }
  
  public void f(AudioInfo paramAudioInfo)
  {
    if ((TextUtils.isEmpty(paramAudioInfo.b)) && (paramAudioInfo.o == 1)) {
      h(paramAudioInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem
 * JD-Core Version:    0.7.0.1
 */