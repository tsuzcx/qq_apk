import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;

class mzm
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  mzm(mzl parammzl, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.postImmediately(new mzn(this, paramInt, paramString1, paramString2), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */