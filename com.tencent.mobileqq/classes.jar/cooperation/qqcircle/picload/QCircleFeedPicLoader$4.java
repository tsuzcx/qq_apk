package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.utils.FileUtils;

class QCircleFeedPicLoader$4
  implements Runnable
{
  QCircleFeedPicLoader$4(QCircleFeedPicLoader paramQCircleFeedPicLoader, Option paramOption, QCirclePicStateListener paramQCirclePicStateListener) {}
  
  public void run()
  {
    this.this$0.showDrawable(this.val$option, this.val$option.getLoadingDrawable());
    if (FileUtils.a(this.this$0.getPicLocalPath(this.val$option)))
    {
      if (this.val$option.isPreDecode())
      {
        this.val$option.mLoadType = 1;
        this.this$0.decodeFile(this.val$option, this.val$listener);
      }
      return;
    }
    Option localOption1 = this.val$option;
    Option localOption2 = this.val$option;
    localOption1.mLoadType = 2;
    QCircleFeedPicLoader.access$000(this.this$0, this.val$option, this.val$listener);
    QCircleNetSpeed.g().start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.4
 * JD-Core Version:    0.7.0.1
 */