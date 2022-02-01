package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.open.agent.util.QQLiteStatusUtil;

class BaseCardContainer$6
  implements Runnable
{
  BaseCardContainer$6(BaseCardContainer paramBaseCardContainer, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    BaseCardContainer.a(this.this$0, Drawable.createFromPath(QQLiteStatusUtil.b((String)localObject)));
    if (BaseCardContainer.a(this.this$0) != null)
    {
      Message.obtain(this.this$0.i, 10001).sendToTarget();
      return;
    }
    localObject = BaseCardContainer.a(this.this$0, (String)localObject);
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
    {
      BaseCardContainer.a(this.this$0, (Drawable)localObject);
      Message.obtain(this.this$0.i, 10001).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.6
 * JD-Core Version:    0.7.0.1
 */