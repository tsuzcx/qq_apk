import com.tencent.biz.qqstory.base.QQStoryBanInfo;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.qphone.base.util.QLog;

public class nnl
  extends QQStoryObserver
{
  public nnl(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, QQStoryBanInfo paramQQStoryBanInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyVideoVisiblePersonPageView", 2, "onGetVideoReaderConfig: isSuccess " + paramBoolean + ", QQStoryBanInfo = " + paramQQStoryBanInfo);
    }
    if (paramBoolean)
    {
      if (paramQQStoryBanInfo != null) {
        this.a.a(paramQQStoryBanInfo.a);
      }
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnl
 * JD-Core Version:    0.7.0.1
 */