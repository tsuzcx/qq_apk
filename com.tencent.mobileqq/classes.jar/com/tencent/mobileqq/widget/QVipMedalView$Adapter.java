package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.MedalList.Info;
import java.util.ArrayList;

public class QVipMedalView$Adapter
{
  private MedalList a;
  
  public int a()
  {
    MedalList localMedalList = this.a;
    if (localMedalList != null) {
      return localMedalList.infoList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    MedalList localMedalList = this.a;
    if ((localMedalList != null) && (localMedalList.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).type;
    }
    return 0;
  }
  
  public String a(int paramInt)
  {
    MedalList localMedalList = this.a;
    if ((localMedalList != null) && (localMedalList.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).value;
    }
    return null;
  }
  
  public void a(MedalList paramMedalList)
  {
    this.a = paramMedalList;
  }
  
  public int b(int paramInt)
  {
    MedalList localMedalList = this.a;
    if ((localMedalList != null) && (localMedalList.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).isRemind;
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    MedalList localMedalList = this.a;
    if ((localMedalList != null) && (localMedalList.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).tipsTimes;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QVipMedalView.Adapter
 * JD-Core Version:    0.7.0.1
 */