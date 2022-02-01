package cooperation.qqcircle.picload.avatar;

import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.QCircleFeedPicLoader.QCirclePicStateListener;

class QCircleAvatarLoader$QCircleAvatarCheckTask$2
  extends QCircleFeedPicLoader.QCirclePicStateListener
{
  QCircleAvatarLoader$QCircleAvatarCheckTask$2(QCircleAvatarLoader.QCircleAvatarCheckTask paramQCircleAvatarCheckTask, QCircleAvatarInfo paramQCircleAvatarInfo) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    if (paramInt == QCircleFeedPicLoader.STATE_SUCCESS) {
      QCircleAvatarLoader.QCircleAvatarCheckTask.access$700(this.this$1, this.val$info.getUin(), paramOption);
    }
    while ((paramInt != QCircleFeedPicLoader.STATE_DECODE_FAILED) && (paramInt != QCircleFeedPicLoader.STATE_DOWN_FAILED)) {
      return;
    }
    QCircleAvatarLoader.QCircleAvatarCheckTask.access$600(this.this$1, this.val$info.getUin(), paramOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask.2
 * JD-Core Version:    0.7.0.1
 */