package cooperation.qqcircle.picload.avatar;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
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
      RFLog.d("QCircleAvatar", RFLog.USR, "seq = " + QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq() + "  from server success, info:" + paramQCircleAvatarInfo.toString());
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$400(this.this$1, paramQCircleAvatarInfo);
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$500(this.this$1, this.val$option, paramQCircleAvatarInfo);
      if (QCircleAvatarLoader.access$200(this.this$1.this$0).containsKey(this.val$option.getUin()))
      {
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)QCircleAvatarLoader.access$200(this.this$1.this$0).get(this.val$option.getUin());
        Iterator localIterator = localConcurrentHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          AvatarOption localAvatarOption = (AvatarOption)localConcurrentHashMap.remove((Integer)localIterator.next());
          QCircleAvatarLoader.QCircleAvatarCheckTask.access$500(this.this$1, localAvatarOption, paramQCircleAvatarInfo);
        }
      }
    }
    else
    {
      RFLog.d("QCircleAvatar", RFLog.USR, "seq = " + QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq() + "  from server failed, retCode:" + paramInt);
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$600(this.this$1, this.val$option.getUin(), this.val$option);
    }
    RFLog.d("QCircleAvatar", RFLog.USR, "seq = " + QCircleAvatarLoader.QCircleAvatarCheckTask.access$300(this.this$1).getSeq() + "  request cost times:" + (System.currentTimeMillis() - this.val$option.mStartTime.longValue()));
    QCircleAvatarLoader.access$100(this.this$1.this$0).remove(this.val$option.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask.1
 * JD-Core Version:    0.7.0.1
 */