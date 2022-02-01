package cooperation.qqcircle.picload.avatar;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;

class QCircleAvatarLoader$QCircleAvatarCheckTask$2
  extends QCirclePicStateListener
{
  QCircleAvatarLoader$QCircleAvatarCheckTask$2(QCircleAvatarLoader.QCircleAvatarCheckTask paramQCircleAvatarCheckTask, QCircleAvatarInfo paramQCircleAvatarInfo) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    if (paramInt == 6)
    {
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$700(this.this$1, this.val$info.getUin(), paramOption);
      return;
    }
    if ((paramInt == 8) || (paramInt == 7)) {
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$600(this.this$1, this.val$info.getUin(), paramOption);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask.2
 * JD-Core Version:    0.7.0.1
 */