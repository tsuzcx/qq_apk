package com.tencent.mobileqq.hiboom;

import adpe;
import adpf;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView
  extends FlashChatTextEffectView
  implements Handler.Callback
{
  public Handler a;
  public HiBoomPanelView.HiBoomAdapter a;
  private VasQuickUpdateManager.CallBacker a;
  int jdField_b_of_type_Int;
  StaggeredGridLayoutManager jdField_b_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  BaseChatPie jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  OnHolderItemClickListener jdField_b_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new adpf(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramBaseChatPie = (HiBoomManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      ((VasQuickUpdateManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(183)).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.jdField_b_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
      this.jdField_b_of_type_Int = paramInt;
      setClipToPadding(false);
      a();
      b();
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a.size();
  }
  
  public FlashChatItem a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a == null) {
      return null;
    }
    return (HiBoomItem)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a.get(paramInt);
  }
  
  @TargetApi(9)
  public void a()
  {
    setOverScrollMode(2);
    this.jdField_b_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    setLayoutManager(this.jdField_b_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = new HiBoomPanelView.HiBoomAdapter(this, this.jdField_b_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter);
  }
  
  public void a(int paramInt)
  {
    HiBoomManager localHiBoomManager = (HiBoomManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    if (paramInt == -1)
    {
      localHiBoomManager.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a != null)
    {
      localHiBoomManager.jdField_a_of_type_Int = ((HiBoomItem)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a.get(paramInt)).jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.notifyDataSetChanged();
      return;
    }
    QLog.e("HiBoomFont.HiBoomPanelView", 1, "select position = " + paramInt + " no item");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "loadData");
    }
    HiBoomManager localHiBoomManager = (HiBoomManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    if (!localHiBoomManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.post(new adpe(this, localHiBoomManager), 8, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(localHiBoomManager.b);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b();
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    paramView = (HiBoomManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (paramView.jdField_a_of_type_JavaLangObject)
      {
        paramView.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        ((VasQuickUpdateManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(183)).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        b();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel gone");
    }
    synchronized (paramView.jdField_a_of_type_JavaLangObject)
    {
      paramView.jdField_a_of_type_AndroidOsHandler = null;
      ((VasQuickUpdateManager)this.jdField_b_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */