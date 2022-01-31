import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;

class nes
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  nes(ner paramner, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.postImmediately(new net(this, paramInt, paramString1, paramString2), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nes
 * JD-Core Version:    0.7.0.1
 */