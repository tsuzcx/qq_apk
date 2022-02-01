package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

public class TeamPlayerViewHolder
  extends RecyclerView.ViewHolder
{
  public AvatarRoundImageView a;
  public AvatarTextView b;
  public ImageView c;
  public TextView d;
  public AvatarSpeakingMicImageView e;
  public MicWaveViewLottie f;
  public View g;
  public ImageView h;
  public ImageView i;
  public TextView j;
  public URLImageView k;
  public ImageView l;
  public TeamLaneStateView m;
  
  public TeamPlayerViewHolder(@NonNull View paramView, long paramLong)
  {
    super(paramView);
    this.a = ((AvatarRoundImageView)paramView.findViewById(2131434047));
    this.b = ((AvatarTextView)paramView.findViewById(2131434051));
    this.c = ((ImageView)paramView.findViewById(2131434052));
    this.d = ((TextView)paramView.findViewById(2131434053));
    this.e = ((AvatarSpeakingMicImageView)paramView.findViewById(2131434050));
    this.f = ((MicWaveViewLottie)paramView.findViewById(2131434054));
    this.g = paramView.findViewById(2131434049);
    this.h = ((ImageView)paramView.findViewById(2131434046));
    this.i = ((ImageView)paramView.findViewById(2131434044));
    this.j = ((TextView)paramView.findViewById(2131434045));
    this.k = ((URLImageView)paramView.findViewById(2131434257));
    this.l = ((ImageView)paramView.findViewById(2131434277));
    this.m = ((TeamLaneStateView)paramView.findViewById(2131446909));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerViewHolder
 * JD-Core Version:    0.7.0.1
 */