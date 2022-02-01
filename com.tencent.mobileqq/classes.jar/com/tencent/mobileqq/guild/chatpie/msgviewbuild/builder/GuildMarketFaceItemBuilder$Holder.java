package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;

public class GuildMarketFaceItemBuilder$Holder
  extends BaseGuildMsgViewBuild.ViewHolder
{
  public TriangleView A;
  ImageView B;
  public BreathAnimationLayout C;
  public IPicEmoticonInfo a;
  EmoticonPackage b;
  public ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  DuiButtonImageView g;
  public ImageView h;
  public ImageView i;
  public FrameLayout n;
  public ProgressBar o;
  public TextView p;
  public boolean s;
  public long t;
  public int u = -1;
  public boolean v = false;
  public PttAudioPlayView w;
  public PttAudioWaveView x;
  public RelativeLayout y;
  public RelativeLayout z;
  
  public void a()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).b();
    }
    localObject = this.x;
    if (localObject != null) {
      ((PttAudioWaveView)localObject).b();
    }
    localObject = this.B;
    if ((localObject != null) && ((((ImageView)localObject).getDrawable() instanceof Animatable))) {
      ((Animatable)this.B.getDrawable()).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */