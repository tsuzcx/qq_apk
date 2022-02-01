package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import org.jetbrains.annotations.NotNull;

public abstract class QCirclePicDownLoader$PicDownLoadListener
{
  Option mOption;
  
  QCirclePicDownLoader$PicDownLoadListener(@NotNull Option paramOption)
  {
    this.mOption = paramOption;
  }
  
  void onResult(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDownLoader.PicDownLoadListener
 * JD-Core Version:    0.7.0.1
 */