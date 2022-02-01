package com.tencent.richframework.sender.call;

import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.chain.BaseSenderChain.BaseSenderChainBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleCall
  extends BaseCall<Object>
{
  public void a()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.a);
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.b);
    localObject1 = BaseSenderChain.BaseSenderChainBuilder.a().a((List)localObject1).b((List)localObject2).a(0).b(0).a(this.d).a(new WeakReference(this.c)).b();
    localObject2 = this.e.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((BaseSenderChain)localObject1).a(((Iterator)localObject2).next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.call.SimpleCall
 * JD-Core Version:    0.7.0.1
 */