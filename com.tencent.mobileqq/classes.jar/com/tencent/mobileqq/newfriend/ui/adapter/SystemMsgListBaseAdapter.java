package com.tencent.mobileqq.newfriend.ui.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.widget.XBaseAdapter;

public abstract class SystemMsgListBaseAdapter
  extends XBaseAdapter
{
  public int a;
  public SystemMsgListView a;
  
  public SystemMsgListBaseAdapter(SystemMsgListView paramSystemMsgListView)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView = paramSystemMsgListView;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    return null;
  }
  
  public IFaceDecoder a()
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void a(NewFriendBaseBuilder paramNewFriendBaseBuilder) {}
  
  public int b()
  {
    return -1;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public int c()
  {
    return 0;
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */