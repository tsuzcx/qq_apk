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
    Object localObject = this.this$0;
    Option localOption = this.val$option;
    ((QCircleFeedPicLoader)localObject).showDrawable(localOption, localOption.getLoadingDrawable());
    if (FileUtils.fileExists(this.this$0.getPicLocalPath(this.val$option)))
    {
      if (this.val$option.isPreDecode())
      {
        localObject = this.val$option;
        ((Option)localObject).mLoadType = 1;
        this.this$0.decodeFile((Option)localObject, this.val$listener);
      }
    }
    else
    {
      localObject = this.val$option;
      ((Option)localObject).mLoadType = 2;
      QCircleFeedPicLoader.access$000(this.this$0, (Option)localObject, this.val$listener);
      QCircleNetSpeed.g().start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.4
 * JD-Core Version:    0.7.0.1
 */