package com.tencent.open.agent;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import java.util.ArrayList;
import java.util.List;

public abstract class OpenFrame
  extends InnerFrame
{
  protected FriendDataManager i;
  protected FriendChooser j;
  protected InnerFrameManager k;
  protected BaseQQAppInterface l;
  protected LayoutInflater m;
  
  public OpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.j = ((FriendChooser)super.getActivity());
    this.k = super.getInnerFrameManager();
    this.l = super.getAppIntf();
    this.m = this.j.getLayoutInflater();
    this.i = FriendDataManager.a();
  }
  
  public abstract void g();
  
  public List<Friend> getDataForSearch()
  {
    ArrayList localArrayList = new ArrayList(50);
    int n = 0;
    while (n < this.i.c())
    {
      localArrayList.addAll(this.i.d(n));
      n += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenFrame
 * JD-Core Version:    0.7.0.1
 */