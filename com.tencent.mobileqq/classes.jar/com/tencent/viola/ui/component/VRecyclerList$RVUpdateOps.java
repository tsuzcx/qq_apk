package com.tencent.viola.ui.component;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VRecyclerList$RVUpdateOps
  extends Handler
{
  public static final int MSG_BATCH = 1;
  public static final int MSG_BATCH_DELAY = 20;
  public static final int TYPE_ADD = 0;
  public static final int TYPE_REMOVE = 1;
  private List<VRecyclerList.UpdateOp> mBatchList = new ArrayList();
  private DomObject targetDomToKeep = null;
  
  public VRecyclerList$RVUpdateOps(VRecyclerList paramVRecyclerList)
  {
    super(Looper.getMainLooper());
  }
  
  private int calculateKeepPosition(DomObject paramDomObject)
  {
    int j = VRecyclerList.access$200(this.this$0).findItemIndex(paramDomObject);
    int k = ((VRecyclerView)this.this$0.getHostView()).getCurrentSnapPosition();
    int i = j;
    if (k >= 0)
    {
      if (j >= 0) {
        return j;
      }
      i = k;
    }
    return i;
  }
  
  private void doDelayNotifyItemChange(VRecyclerList.UpdateOp paramUpdateOp)
  {
    if (VRecyclerList.UpdateOp.access$900(paramUpdateOp) == 0)
    {
      if ((this.this$0.getHostView() != null) && (((VRecyclerView)this.this$0.getHostView()).isComputingLayout()))
      {
        ((VRecyclerView)this.this$0.getHostView()).post(new VRecyclerList.RVUpdateOps.2(this, paramUpdateOp));
        return;
      }
      VRecyclerList.access$200(this.this$0).notifyItemInsert(VRecyclerList.UpdateOp.access$800(paramUpdateOp), VRecyclerList.UpdateOp.access$1000(paramUpdateOp));
      return;
    }
    if (VRecyclerList.UpdateOp.access$900(paramUpdateOp) == 1)
    {
      if ((this.this$0.getHostView() != null) && (((VRecyclerView)this.this$0.getHostView()).isComputingLayout()))
      {
        ((VRecyclerView)this.this$0.getHostView()).post(new VRecyclerList.RVUpdateOps.3(this, paramUpdateOp));
        return;
      }
      VRecyclerList.access$200(this.this$0).notifyItemRemove(VRecyclerList.UpdateOp.access$800(paramUpdateOp));
    }
  }
  
  private DomObject findDomByAttr()
  {
    Object localObject = this.mBatchList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      VRecyclerList.UpdateOp localUpdateOp = (VRecyclerList.UpdateOp)((Iterator)localObject).next();
      if ("1".equals(String.valueOf(VRecyclerList.UpdateOp.access$800(localUpdateOp).getAttributes().get("keepTop"))))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findDomByAttr: ");
        ((StringBuilder)localObject).append(VRecyclerList.UpdateOp.access$800(localUpdateOp));
        ViolaLogUtils.d("VRecyclerList", ((StringBuilder)localObject).toString());
        return VRecyclerList.UpdateOp.access$800(localUpdateOp);
      }
    }
    return null;
  }
  
  private DomObject findDomByPosition()
  {
    int i = pollKeepTopItemAttr();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("findDomByPosition: ");
    localStringBuilder.append(i);
    ViolaLogUtils.d("VRecyclerList", localStringBuilder.toString());
    return VRecyclerList.access$200(this.this$0).getItem(i);
  }
  
  private DomObject findKeepDom(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.targetDomToKeep == null)
      {
        this.targetDomToKeep = findDomByAttr();
        if ((this.targetDomToKeep == null) && (((VRecyclerView)this.this$0.getHostView()).getCurrentSnapPosition() < 0)) {
          this.targetDomToKeep = findDomByPosition();
        }
      }
    }
    else {
      this.targetDomToKeep = null;
    }
    return this.targetDomToKeep;
  }
  
  private int getKeepPositionAttr()
  {
    try
    {
      float f = ViolaUtils.getFloat(this.this$0.getDomObject().getAttributes().get("keepPosition"));
      return (int)f;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needKeepPosition error:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VRecyclerList", localStringBuilder.toString());
      localException.printStackTrace();
    }
    return 0;
  }
  
  private void handleBatch()
  {
    if (VRecyclerList.access$200(this.this$0) == null) {
      return;
    }
    post(new VRecyclerList.RVUpdateOps.1(this));
  }
  
  /* Error */
  private int pollKeepTopItemAttr()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/viola/ui/component/VRecyclerList$RVUpdateOps:this$0	Lcom/tencent/viola/ui/component/VRecyclerList;
    //   4: invokevirtual 215	com/tencent/viola/ui/component/VRecyclerList:getDomObject	()Lcom/tencent/viola/ui/dom/DomObject;
    //   7: invokevirtual 151	com/tencent/viola/ui/dom/DomObject:getAttributes	()Lcom/tencent/viola/ui/dom/Attr;
    //   10: ldc 243
    //   12: invokevirtual 159	com/tencent/viola/ui/dom/Attr:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: fconst_0
    //   16: invokestatic 248	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   19: invokestatic 251	com/tencent/viola/utils/ViolaUtils:getFloat	(Ljava/lang/Object;Ljava/lang/Float;)F
    //   22: fstore_1
    //   23: fload_1
    //   24: f2i
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 23	com/tencent/viola/ui/component/VRecyclerList$RVUpdateOps:this$0	Lcom/tencent/viola/ui/component/VRecyclerList;
    //   30: invokevirtual 215	com/tencent/viola/ui/component/VRecyclerList:getDomObject	()Lcom/tencent/viola/ui/dom/DomObject;
    //   33: invokevirtual 151	com/tencent/viola/ui/dom/DomObject:getAttributes	()Lcom/tencent/viola/ui/dom/Attr;
    //   36: ldc 243
    //   38: invokevirtual 254	com/tencent/viola/ui/dom/Attr:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: iload_2
    //   43: ireturn
    //   44: astore_3
    //   45: goto +64 -> 109
    //   48: astore_3
    //   49: new 171	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   56: astore 4
    //   58: aload 4
    //   60: ldc_w 256
    //   63: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: aload_3
    //   70: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 183
    //   79: aload 4
    //   81: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 231	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_3
    //   88: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: getfield 23	com/tencent/viola/ui/component/VRecyclerList$RVUpdateOps:this$0	Lcom/tencent/viola/ui/component/VRecyclerList;
    //   95: invokevirtual 215	com/tencent/viola/ui/component/VRecyclerList:getDomObject	()Lcom/tencent/viola/ui/dom/DomObject;
    //   98: invokevirtual 151	com/tencent/viola/ui/dom/DomObject:getAttributes	()Lcom/tencent/viola/ui/dom/Attr;
    //   101: ldc 243
    //   103: invokevirtual 254	com/tencent/viola/ui/dom/Attr:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 23	com/tencent/viola/ui/component/VRecyclerList$RVUpdateOps:this$0	Lcom/tencent/viola/ui/component/VRecyclerList;
    //   113: invokevirtual 215	com/tencent/viola/ui/component/VRecyclerList:getDomObject	()Lcom/tencent/viola/ui/dom/DomObject;
    //   116: invokevirtual 151	com/tencent/viola/ui/dom/DomObject:getAttributes	()Lcom/tencent/viola/ui/dom/Attr;
    //   119: ldc 243
    //   121: invokevirtual 254	com/tencent/viola/ui/dom/Attr:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: aload_3
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	RVUpdateOps
    //   22	2	1	f	float
    //   25	18	2	i	int
    //   44	1	3	localObject	Object
    //   48	78	3	localException	Exception
    //   56	24	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	23	44	finally
    //   49	91	44	finally
    //   0	23	48	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.RVUpdateOps
 * JD-Core Version:    0.7.0.1
 */