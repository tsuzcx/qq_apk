package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import android.view.View.DragShadowBuilder;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1$1(SystemDragUtils.TouchHandler.1 param1, SystemDragUtils.DropItem paramDropItem) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((SystemDragUtils.DropItem)localObject).a()))
    {
      localObject = new View.DragShadowBuilder(this.a.b);
      this.a.b.startDrag(this.a.c, (View.DragShadowBuilder)localObject, "QQ_AIO_DRAG", 256);
    }
    else
    {
      QQToast.makeText((Context)this.b.this$0.b.get(), SystemDragUtils.d(), 0).show();
    }
    SystemDragUtils.TouchHandler.a(this.b.this$0, this.b.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1.1
 * JD-Core Version:    0.7.0.1
 */