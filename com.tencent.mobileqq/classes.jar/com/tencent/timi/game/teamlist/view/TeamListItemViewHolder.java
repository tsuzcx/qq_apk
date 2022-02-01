package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.teamlist.presenter.TeamListVerticalAdapter.OnTeamClickListener;
import com.tencent.timi.game.teamlist.util.URLDrawableUtil;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo;

public class TeamListItemViewHolder
  extends RecyclerView.ViewHolder
{
  private View a;
  private RCImageView b;
  private TextView c;
  private MediumBoldTextView d;
  private MediumBoldTextView e;
  private MediumBoldTextView f;
  private RelativeLayout g;
  private TeamListAvatarStorkRoundImageView h;
  private TeamListAvatarStorkRoundImageView i;
  private TeamListAvatarStorkRoundImageView j;
  private TeamListAvatarStorkRoundImageView k;
  private TeamListAvatarStorkRoundImageView l;
  private ArrayList<TeamListAvatarStorkRoundImageView> m = new ArrayList();
  
  public TeamListItemViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = paramView;
    this.b = ((RCImageView)paramView.findViewById(2131446875));
    this.c = ((TextView)paramView.findViewById(2131446886));
    this.d = ((MediumBoldTextView)paramView.findViewById(2131446887));
    this.e = ((MediumBoldTextView)paramView.findViewById(2131446885));
    this.f = ((MediumBoldTextView)paramView.findViewById(2131446884));
    this.g = ((RelativeLayout)paramView.findViewById(2131446877));
    this.h = ((TeamListAvatarStorkRoundImageView)paramView.findViewById(2131446879));
    this.i = ((TeamListAvatarStorkRoundImageView)paramView.findViewById(2131446880));
    this.j = ((TeamListAvatarStorkRoundImageView)paramView.findViewById(2131446881));
    this.k = ((TeamListAvatarStorkRoundImageView)paramView.findViewById(2131446882));
    this.l = ((TeamListAvatarStorkRoundImageView)paramView.findViewById(2131446883));
    this.m.add(this.h);
    this.m.add(this.i);
    this.m.add(this.j);
    this.m.add(this.k);
    this.m.add(this.l);
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.a.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ViewUtils.dpToPx(paramFloat1);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramInt == 3) {
      localObject = this.a.getContext().getResources().getDrawable(2130853099);
    } else {
      localObject = this.a.getContext().getResources().getDrawable(2130853098);
    }
    this.b.setRadius(ViewUtils.dip2px(15.0F));
    this.b.setImageDrawable(URLDrawableUtil.a(paramString1, (Drawable)localObject, paramFloat1, paramFloat2));
    this.f.setBackgroundDrawable(URLDrawableUtil.a(paramString2, 62.0F, 18.0F));
    paramString1 = this.m.iterator();
    while (paramString1.hasNext()) {
      ((TeamListAvatarStorkRoundImageView)paramString1.next()).setDrawable(URLDrawableUtil.a(paramString3, 21.0F, 21.0F));
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, List<Integer> paramList, TeamListVerticalAdapter.OnTeamClickListener paramOnTeamClickListener)
  {
    this.a.setOnClickListener(new TeamListItemViewHolder.1(this, paramOnTeamClickListener, paramLong, paramInt1, paramInt2, paramList));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c.setText(paramString1);
    this.d.setText(paramString2);
    this.e.setText(paramString3);
    this.f.setText(paramString4);
  }
  
  public void a(List<PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo> paramList, String paramString1, String paramString2)
  {
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TeamListAvatarStorkRoundImageView)((Iterator)localObject).next()).setVisibility(8);
    }
    int n = 0;
    while (n < paramList.size())
    {
      localObject = (PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)paramList.get(n);
      TeamListAvatarStorkRoundImageView localTeamListAvatarStorkRoundImageView = (TeamListAvatarStorkRoundImageView)this.m.get(n);
      localTeamListAvatarStorkRoundImageView.setVisibility(0);
      if (((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject).uid.get() != 0L)
      {
        int i1 = ((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject).gender.get();
        if (i1 == 1) {
          localTeamListAvatarStorkRoundImageView.setBlueBg();
        } else if (i1 == 2) {
          localTeamListAvatarStorkRoundImageView.setPinkBg();
        } else {
          localTeamListAvatarStorkRoundImageView.setNormal();
        }
        Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130853132);
        if (!TextUtils.isEmpty(((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject).avatar.get())) {
          localTeamListAvatarStorkRoundImageView.setDrawable(URLDrawableUtil.a(((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject).avatar.get(), localDrawable, 21.0F, 21.0F));
        } else {
          localTeamListAvatarStorkRoundImageView.setDrawable(localDrawable);
        }
      }
      else if (((PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo)localObject).status.get() == 0)
      {
        localTeamListAvatarStorkRoundImageView.setNormal();
        localTeamListAvatarStorkRoundImageView.setDrawable(URLDrawableUtil.a(paramString1, 21.0F, 21.0F));
      }
      else
      {
        localTeamListAvatarStorkRoundImageView.setNormal();
        localTeamListAvatarStorkRoundImageView.setDrawable(URLDrawableUtil.a(paramString2, 21.0F, 21.0F));
      }
      n += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListItemViewHolder
 * JD-Core Version:    0.7.0.1
 */