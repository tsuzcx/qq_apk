package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter;
import java.util.List;

public class MiniAppProfileCardGuestView
  extends LinearLayout
{
  private IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter adapter;
  private ColorStateList attrValue;
  private int colorInt;
  private boolean isTheme;
  private Context mContext;
  protected LayoutInflater mLayoutInflater;
  protected RecyclerView mRecyclerView;
  
  public MiniAppProfileCardGuestView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MiniAppProfileCardGuestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MiniAppProfileCardGuestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mLayoutInflater.inflate(2131627707, this, true);
    this.mRecyclerView = ((RecyclerView)findViewById(2131433808));
    this.mRecyclerView.setVisibility(0);
  }
  
  public void setData(List<MISC.StAppPlayingInfo> paramList, String paramString1, String paramString2)
  {
    if (paramList.size() <= 0)
    {
      setVisibility(8);
      return;
    }
    paramString1 = new MiniAppProfileCardGuestView.1(this, paramString1);
    setVisibility(0);
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      this.adapter = new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter(paramList, paramString2, paramString1);
      this.adapter.b(2062);
      this.mRecyclerView.setAdapter(this.adapter);
    }
    setOnClickListener(paramString1);
  }
  
  public void setTextColor(int paramInt)
  {
    this.isTheme = true;
    this.colorInt = paramInt;
    this.adapter.a(paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.isTheme = true;
    this.attrValue = paramColorStateList;
    this.adapter.a(paramColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.miniapp.MiniAppProfileCardGuestView
 * JD-Core Version:    0.7.0.1
 */