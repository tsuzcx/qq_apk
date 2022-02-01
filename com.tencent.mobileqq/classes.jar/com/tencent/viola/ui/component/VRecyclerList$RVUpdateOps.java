package com.tencent.viola.ui.component;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.list.VRecyclerView;
import java.util.ArrayList;
import java.util.List;

class VRecyclerList$RVUpdateOps
  extends Handler
{
  public static final int MSG_BATCH = 1;
  public static final int MSG_BATCH_DELAY = 20;
  public static final int TYPE_ADD = 0;
  public static final int TYPE_REMOVE = 1;
  private List<VRecyclerList.UpdateOp> mBatchList = new ArrayList();
  
  public VRecyclerList$RVUpdateOps(VRecyclerList paramVRecyclerList)
  {
    super(Looper.getMainLooper());
  }
  
  private void doDelayNotifyItemChange(VRecyclerList.UpdateOp paramUpdateOp)
  {
    if (VRecyclerList.UpdateOp.access$400(paramUpdateOp) == 0) {
      if ((this.this$0.getHostView() != null) && (((VRecyclerView)this.this$0.getHostView()).isComputingLayout())) {
        ((VRecyclerView)this.this$0.getHostView()).post(new VRecyclerList.RVUpdateOps.2(this, paramUpdateOp));
      }
    }
    while (VRecyclerList.UpdateOp.access$400(paramUpdateOp) != 1)
    {
      return;
      VRecyclerList.access$100(this.this$0).notifyItemInsert(VRecyclerList.UpdateOp.access$500(paramUpdateOp), VRecyclerList.UpdateOp.access$600(paramUpdateOp));
      return;
    }
    if ((this.this$0.getHostView() != null) && (((VRecyclerView)this.this$0.getHostView()).isComputingLayout()))
    {
      ((VRecyclerView)this.this$0.getHostView()).post(new VRecyclerList.RVUpdateOps.3(this, paramUpdateOp));
      return;
    }
    VRecyclerList.access$100(this.this$0).notifyItemRemove(VRecyclerList.UpdateOp.access$500(paramUpdateOp));
  }
  
  private void handleBatch()
  {
    if (VRecyclerList.access$100(this.this$0) == null) {
      return;
    }
    post(new VRecyclerList.RVUpdateOps.1(this));
  }
  
  private void sendDelayBatchMsg()
  {
    if (hasMessages(1)) {
      removeMessages(1);
    }
    sendEmptyMessageDelayed(1, 20L);
  }
  
  public void add(DomObject paramDomObject, int paramInt)
  {
    this.mBatchList.add(new VRecyclerList.UpdateOp(0, paramDomObject, paramInt));
    sendDelayBatchMsg();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      handleBatch();
    }
  }
  
  public void remove(DomObject paramDomObject)
  {
    this.mBatchList.add(new VRecyclerList.UpdateOp(1, paramDomObject, -1));
    sendDelayBatchMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.RVUpdateOps
 * JD-Core Version:    0.7.0.1
 */