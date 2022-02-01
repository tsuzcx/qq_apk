package cooperation.qzone;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class RDMEtraMsgCollector
{
  public static final int ACTIVITY_SIZE = 5;
  public static final int CLICK_SIZE = 10;
  public static final int LIFECYCLE_SIZE = 10;
  private static final String TAG = "RDMEtraMsgCollector";
  private static RDMEtraMsgCollector instance;
  public LoopQueue<String> activityEventQueue = new LoopQueue(10);
  public LoopQueue<String> activityNameQueue = new LoopQueue(5);
  public LoopQueue<String> userActionQueue = new LoopQueue(10);
  
  public static RDMEtraMsgCollector getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new RDMEtraMsgCollector();
      }
      RDMEtraMsgCollector localRDMEtraMsgCollector = instance;
      return localRDMEtraMsgCollector;
    }
    finally {}
  }
  
  public void addActionSheetClick(String paramString, View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ");
    localStringBuilder.append(paramString);
    if (paramView != null)
    {
      localStringBuilder.append("  actionSheet click view  id:0x");
      localStringBuilder.append(Integer.toHexString(paramView.getId()));
    }
    localStringBuilder.append(" which:");
    localStringBuilder.append(paramInt);
    getInstance().addUserAction(localStringBuilder.toString());
  }
  
  public void addActivityEvent(String paramString)
  {
    if (paramString != null)
    {
      LoopQueue localLoopQueue = this.activityEventQueue;
      if (localLoopQueue != null)
      {
        if (localLoopQueue.isFull()) {
          this.activityEventQueue.remove();
        }
        this.activityEventQueue.add(paramString);
      }
    }
  }
  
  public void addActivityName(String paramString)
  {
    if (paramString != null)
    {
      LoopQueue localLoopQueue = this.activityNameQueue;
      if (localLoopQueue != null)
      {
        if (localLoopQueue.isFull()) {
          this.activityNameQueue.remove();
        }
        this.activityNameQueue.add(paramString);
      }
    }
  }
  
  public void addNoramlClickAction(String paramString, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ");
    localStringBuilder.append(paramString);
    if (paramView != null)
    {
      localStringBuilder.append("  click view  id:0x");
      localStringBuilder.append(Integer.toHexString(paramView.getId()));
    }
    addUserAction(localStringBuilder.toString());
  }
  
  public void addNormalItemClickAction(String paramString, ViewGroup paramViewGroup, View paramView, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ");
    localStringBuilder.append(paramString);
    if (paramViewGroup != null)
    {
      localStringBuilder.append("parent id: ");
      localStringBuilder.append(paramViewGroup.getId());
    }
    if (paramView != null)
    {
      localStringBuilder.append("view id: ");
      localStringBuilder.append(paramView.getId());
    }
    localStringBuilder.append(" onItemclick view  position:0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append(" id");
    localStringBuilder.append(paramLong);
    getInstance().addUserAction(localStringBuilder.toString());
  }
  
  public void addUserAction(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (this.userActionQueue != null)
        {
          if (this.userActionQueue.isFull()) {
            this.userActionQueue.remove();
          }
          this.userActionQueue.add(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("RDMEtraMsgCollector", 2, "", paramString);
        }
      }
    }
  }
  
  public void destroy()
  {
    LoopQueue localLoopQueue = this.activityNameQueue;
    if (localLoopQueue != null)
    {
      localLoopQueue.clear();
      this.activityNameQueue = null;
    }
    localLoopQueue = this.activityEventQueue;
    if (localLoopQueue != null)
    {
      localLoopQueue.clear();
      this.activityEventQueue = null;
    }
    localLoopQueue = this.userActionQueue;
    if (localLoopQueue != null)
    {
      localLoopQueue.clear();
      this.userActionQueue = null;
    }
    instance = null;
  }
  
  public String getEtraMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityNameQueue:\n");
    LoopQueue localLoopQueue = this.activityNameQueue;
    if (localLoopQueue != null)
    {
      localStringBuilder.append(localLoopQueue);
      localStringBuilder.append("\n");
    }
    localStringBuilder.append(" \n activityEventQueue:\n");
    localLoopQueue = this.activityEventQueue;
    if (localLoopQueue != null) {
      localStringBuilder.append(localLoopQueue);
    }
    localStringBuilder.append(" \n userActionQueue:\n");
    localLoopQueue = this.userActionQueue;
    if (localLoopQueue != null) {
      localStringBuilder.append(localLoopQueue);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.RDMEtraMsgCollector
 * JD-Core Version:    0.7.0.1
 */