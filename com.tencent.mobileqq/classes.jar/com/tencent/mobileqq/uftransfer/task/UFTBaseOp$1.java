package com.tencent.mobileqq.uftransfer.task;

class UFTBaseOp$1
  implements Runnable
{
  UFTBaseOp$1(UFTBaseOp paramUFTBaseOp, UFTBaseOp.OpRetData paramOpRetData) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    UFTBaseOp localUFTBaseOp = this.this$0;
    localUFTBaseOp.a = true;
    if (UFTBaseOp.a(localUFTBaseOp) != null) {
      UFTBaseOp.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.UFTBaseOp.1
 * JD-Core Version:    0.7.0.1
 */