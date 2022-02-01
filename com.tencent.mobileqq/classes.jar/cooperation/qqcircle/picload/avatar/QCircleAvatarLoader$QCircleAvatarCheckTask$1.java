package cooperation.qqcircle.picload.avatar;

import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QCircleAvatarLoader$QCircleAvatarCheckTask$1
  implements IAvatarListener
{
  QCircleAvatarLoader$QCircleAvatarCheckTask$1(QCircleAvatarLoader.QCircleAvatarCheckTask paramQCircleAvatarCheckTask, AvatarOption paramAvatarOption) {}
  
  public void onAvatarBack(boolean paramBoolean, int paramInt, QCircleAvatarInfo paramQCircleAvatarInfo)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seq = ");
      ((StringBuilder)localObject).append(QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq());
      ((StringBuilder)localObject).append("  from server success, info:");
      ((StringBuilder)localObject).append(paramQCircleAvatarInfo.toString());
      QLog.d("QCircleAvatar", 1, ((StringBuilder)localObject).toString());
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$400(this.this$1, paramQCircleAvatarInfo);
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$500(this.this$1, this.val$option, paramQCircleAvatarInfo);
      if (QCircleAvatarLoader.access$200(this.this$1.this$0).containsKey(this.val$option.getUin()))
      {
        localObject = (ConcurrentHashMap)QCircleAvatarLoader.access$200(this.this$1.this$0).get(this.val$option.getUin());
        Iterator localIterator = ((ConcurrentHashMap)localObject).keySet().iterator();
        while (localIterator.hasNext())
        {
          AvatarOption localAvatarOption = (AvatarOption)((ConcurrentHashMap)localObject).remove((Integer)localIterator.next());
          QCircleAvatarLoader.QCircleAvatarCheckTask.access$500(this.this$1, localAvatarOption, paramQCircleAvatarInfo);
        }
      }
    }
    else
    {
      paramQCircleAvatarInfo = new StringBuilder();
      paramQCircleAvatarInfo.append("seq = ");
      paramQCircleAvatarInfo.append(QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq());
      paramQCircleAvatarInfo.append("  from server failed, retCode:");
      paramQCircleAvatarInfo.append(paramInt);
      QLog.d("QCircleAvatar", 1, paramQCircleAvatarInfo.toString());
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$600(this.this$1, this.val$option.getUin(), this.val$option);
    }
    paramQCircleAvatarInfo = new StringBuilder();
    paramQCircleAvatarInfo.append("seq = ");
    paramQCircleAvatarInfo.append(QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq());
    paramQCircleAvatarInfo.append("  request cost times:");
    paramQCircleAvatarInfo.append(System.currentTimeMillis() - this.val$option.mStartTime.longValue());
    QLog.d("QCircleAvatar", 1, paramQCircleAvatarInfo.toString());
    QCircleAvatarLoader.access$100(this.this$1.this$0).remove(this.val$option.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask.1
 * JD-Core Version:    0.7.0.1
 */