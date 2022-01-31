import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class str
  extends SimpleJob<Void>
{
  str(sto paramsto, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = sto.a(this.jdField_a_of_type_Sto, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    long l1;
    if (paramJobContext != null)
    {
      paramVarArgs = ((tcz)tdc.a(5)).a(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null) {
        break label132;
      }
      l1 = 0L;
      if (paramJobContext.updatedMs <= 0L) {
        break label141;
      }
    }
    label132:
    label141:
    for (long l2 = paramJobContext.updatedMs;; l2 = System.currentTimeMillis())
    {
      int i = paramJobContext.compressLevel;
      vel.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(i), this.jdField_a_of_type_JavaLangString });
      veg.a("Q.qqstory.DownloadUrlManager", "report url level , vid = %s , compress level = %d , cms = %d , dms = %d", this.jdField_a_of_type_JavaLangString, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2));
      return null;
      l1 = paramVarArgs.mCreateTime;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     str
 * JD-Core Version:    0.7.0.1
 */