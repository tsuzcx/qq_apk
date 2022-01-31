import com.tencent.biz.qqstory.base.preload.cachecleaner.AbsCleanStep;
import com.tencent.biz.qqstory.base.preload.cachecleaner.AbsCleanStep.CleanContext;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep;
import com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep;
import com.tencent.biz.qqstory.base.preload.cachecleaner.TimeCleanStep;
import com.tencent.biz.qqstory.base.preload.cachecleaner.UploadTmpVideoCleanStep;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;

public class nai
  implements Runnable
{
  public nai(CacheCleaner paramCacheCleaner) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.cleaner:CacheCleaner", "start clean cache");
    Object localObject = new TimeCleanStep(CacheCleaner.a);
    CapacityCleanStep localCapacityCleanStep = new CapacityCleanStep(CacheCleaner.b);
    MyVideoCleanStep localMyVideoCleanStep = new MyVideoCleanStep(CacheCleaner.c);
    UploadTmpVideoCleanStep localUploadTmpVideoCleanStep = new UploadTmpVideoCleanStep(CacheCleaner.d);
    localCapacityCleanStep.a(localMyVideoCleanStep).a(localUploadTmpVideoCleanStep).a((AbsCleanStep)localObject);
    localObject = new AbsCleanStep.CleanContext();
    ((AbsCleanStep.CleanContext)localObject).jdField_a_of_type_Boolean = FileUtils.a();
    ((AbsCleanStep.CleanContext)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
    localCapacityCleanStep.a((AbsCleanStep.CleanContext)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nai
 * JD-Core Version:    0.7.0.1
 */