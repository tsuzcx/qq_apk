package com.tencent.mobileqq.now.focusanchor.focusdata;

import com.tencent.mobileqq.now.focusanchor.focousinterface.FocusLiveStreamListener;
import java.util.ArrayList;
import java.util.List;

public class FocusLiveStreamDataManager
  implements FocusLiveStreamListener
{
  private static volatile FocusLiveStreamDataManager c;
  private List<NowQQLiveAnchorInfo> a = new ArrayList();
  private FocusLiveStreamListener b;
  
  public static FocusLiveStreamDataManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new FocusLiveStreamDataManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(FocusLiveStreamListener paramFocusLiveStreamListener)
  {
    this.b = paramFocusLiveStreamListener;
  }
  
  public void a(List<NowQQLiveAnchorInfo> paramList)
  {
    this.a = paramList;
    FocusLiveStreamListener localFocusLiveStreamListener = this.b;
    if (localFocusLiveStreamListener != null) {
      localFocusLiveStreamListener.a(paramList);
    }
  }
  
  public void b()
  {
    new FocusLiveStreamDataImpl().a(this);
  }
  
  public List<NowQQLiveAnchorInfo> c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.a.clear();
    this.b = null;
    c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager
 * JD-Core Version:    0.7.0.1
 */