package com.tencent.mobileqq.newfriend.ui.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.widget.XBaseAdapter;

public abstract class SystemMsgListBaseAdapter
  extends XBaseAdapter
{
  public int d = -1;
  public SystemMsgListView e;
  
  public SystemMsgListBaseAdapter(SystemMsgListView paramSystemMsgListView)
  {
    this.e = paramSystemMsgListView;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void a(NewFriendBaseBuilder paramNewFriendBaseBuilder) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public abstract void c();
  
  public IFaceDecoder d()
  {
    return null;
  }
  
  public int i()
  {
    return 0;
  }
  
  public int m()
  {
    return -1;
  }
  
  public int n()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */