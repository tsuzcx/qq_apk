package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FaceAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static int a = 1;
  private static int g;
  private BaseQQAppInterface b;
  private final AsyncListDiffer<UserInfo> c;
  private FaceAdapter.OnItemClickListener d;
  private volatile List<UserInfo> e;
  private LocalUserInfo f;
  
  public FaceAdapter(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    this.b = paramBaseQQAppInterface;
    this.c = new AsyncListDiffer(this, new FaceAdapter.1(this));
  }
  
  public void a(FaceAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.d = paramOnItemClickListener;
  }
  
  public void a(List<UserInfo> paramList, LocalUserInfo paramLocalUserInfo)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.e = ((List)localObject);
    this.f = paramLocalUserInfo;
    this.c.submitList(this.e);
  }
  
  public int getItemCount()
  {
    return this.c.getCurrentList().size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == this.c.getCurrentList().size()) {
      return a;
    }
    return g;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt == this.c.getCurrentList().size()) && ((paramViewHolder instanceof FaceAdapter.InviteViewHolder)))
    {
      ((FaceAdapter.InviteViewHolder)paramViewHolder).itemView.setOnClickListener(new FaceAdapter.2(this, paramInt));
      return;
    }
    UserInfo localUserInfo = (UserInfo)this.c.getCurrentList().get(paramInt);
    paramViewHolder = (FaceViewHolder)paramViewHolder;
    paramViewHolder.a(localUserInfo, this.f);
    paramViewHolder.itemView.setTag(localUserInfo);
    paramViewHolder.itemView.setOnClickListener(new FaceAdapter.3(this, paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("FaceAdapter", 2, "onCreateViewHolder ");
    if (paramInt == a)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624994, paramViewGroup, false);
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramViewGroup, "em_sgrp_voicechannel_list_invite", null);
      return new FaceAdapter.InviteViewHolder(this, paramViewGroup);
    }
    return new FaceViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624995, paramViewGroup, false), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceAdapter
 * JD-Core Version:    0.7.0.1
 */