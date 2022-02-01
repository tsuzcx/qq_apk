package com.tencent.mobileqq.mediabrowser;

import android.graphics.Rect;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.List;

public class IMediaBrowserService$BrowserInfo
{
  private IMediaBrowserProvider a;
  private List<RichMediaBrowserInfo> b;
  private int c;
  private Rect d;
  
  public IMediaBrowserService$BrowserInfo(IMediaBrowserProvider paramIMediaBrowserProvider, List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    this.a = paramIMediaBrowserProvider;
    this.b = paramList;
    this.c = paramInt;
  }
  
  public IMediaBrowserProvider a()
  {
    return this.a;
  }
  
  public void a(Rect paramRect)
  {
    this.d = paramRect;
  }
  
  public List<RichMediaBrowserInfo> b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public Rect d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo
 * JD-Core Version:    0.7.0.1
 */