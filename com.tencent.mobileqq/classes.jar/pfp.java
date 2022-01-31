import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageTracer;
import com.tencent.component.media.image.MessageQueueDecodeMultiplexTask;
import com.tencent.component.media.image.ProgressTracer;
import java.util.Iterator;
import java.util.List;

public class pfp
  extends Handler
{
  public pfp(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 13: 
    case 11: 
    case 8: 
      MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask;
      do
      {
        for (;;)
        {
          return;
          paramMessage = (MessageQueueDecodeMultiplexTask)paramMessage.obj;
          if (!MessageQueueDecodeMultiplexTask.a(paramMessage))
          {
            ImageManager.getInstance().c(paramMessage.getImageKey());
            if (paramMessage.getNextTask() != null)
            {
              ImageTracer.start(paramMessage.getImageKey().url);
              paramMessage.getNextTask().excuteTask();
              return;
            }
            localObject1 = paramMessage.getImageKey();
            if ((localObject1 != null) && (((ImageKey)localObject1).options != null)) {
              ((ImageKey)localObject1).options.errCode = ImageManager.getErrorString((ImageKey)localObject1, 700);
            }
            paramMessage.setResult(9, new Object[0]);
            return;
            paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
            if ((paramMessage != null) && (paramMessage.getImageKey() != null))
            {
              paramMessage = MessageQueueDecodeMultiplexTask.a(paramMessage.getImageKey().hashCodeEx());
              if (paramMessage != null)
              {
                paramMessage = paramMessage.iterator();
                while (paramMessage.hasNext())
                {
                  localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage.next();
                  if ((localObject1 != null) && (((MessageQueueDecodeMultiplexTask)localObject1).isCanceled()))
                  {
                    ((MessageQueueDecodeMultiplexTask)localObject1).setResult(13, new Object[0]);
                  }
                  else if ((localObject1 != null) && (!((MessageQueueDecodeMultiplexTask)localObject1).isCanceled()) && (!MessageQueueDecodeMultiplexTask.a((MessageQueueDecodeMultiplexTask)localObject1)))
                  {
                    ImageManager.getInstance().c(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey());
                    if (((MessageQueueDecodeMultiplexTask)localObject1).getNextTask() != null)
                    {
                      ImageTracer.start(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().url);
                      ((MessageQueueDecodeMultiplexTask)localObject1).getNextTask().excuteTask();
                    }
                    else
                    {
                      ((MessageQueueDecodeMultiplexTask)localObject1).setResult(9, new Object[0]);
                    }
                  }
                }
              }
            }
          }
        }
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
        localObject2 = MessageQueueDecodeMultiplexTask.a(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
            if (localMessageQueueDecodeMultiplexTask != null) {
              localMessageQueueDecodeMultiplexTask.setResult(11, new Object[] { paramMessage[1] });
            }
          }
        }
        ((MessageQueueDecodeMultiplexTask)localObject1).setResult(11, new Object[] { paramMessage[1] });
        return;
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
      } while ((localObject1 == null) || (((MessageQueueDecodeMultiplexTask)localObject1).getImageKey() == null));
      ProgressTracer.print(4, ((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().urlKey);
      localObject2 = MessageQueueDecodeMultiplexTask.a(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
          if (localMessageQueueDecodeMultiplexTask != null) {
            localMessageQueueDecodeMultiplexTask.setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
          }
        }
      }
      ((MessageQueueDecodeMultiplexTask)localObject1).setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
      return;
    }
    paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
    if ((paramMessage != null) && (paramMessage.getImageKey() != null))
    {
      ProgressTracer.print(1002, paramMessage.getImageKey().url);
      localObject1 = MessageQueueDecodeMultiplexTask.a(paramMessage.getImageKey().hashCodeEx());
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageQueueDecodeMultiplexTask)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((MessageQueueDecodeMultiplexTask)localObject2).setResult(9, new Object[0]);
          }
        }
      }
    }
    paramMessage.setResult(9, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfp
 * JD-Core Version:    0.7.0.1
 */