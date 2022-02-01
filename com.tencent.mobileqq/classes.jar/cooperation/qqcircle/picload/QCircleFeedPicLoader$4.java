package cooperation.qqcircle.picload;

import com.tencent.mobileqq.filemanager.util.FileUtil;

class QCircleFeedPicLoader$4
  implements Runnable
{
  QCircleFeedPicLoader$4(QCircleFeedPicLoader paramQCircleFeedPicLoader, Option paramOption, QCircleFeedPicLoader.QCirclePicStateListener paramQCirclePicStateListener) {}
  
  public void run()
  {
    QCircleFeedPicLoader.access$100(this.this$0, this.val$option, this.val$option.getLoadingDrawable());
    if (FileUtil.isFileExists(this.this$0.getPicLocalPath(this.val$option)))
    {
      if (this.val$option.isPreDecode())
      {
        this.val$option.mLoadType = 1;
        QCircleFeedPicLoader.access$200(this.this$0, this.val$option, this.val$listener);
      }
      return;
    }
    Option localOption1 = this.val$option;
    Option localOption2 = this.val$option;
    localOption1.mLoadType = 2;
    QCircleFeedPicLoader.access$300(this.this$0, this.val$option, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.4
 * JD-Core Version:    0.7.0.1
 */