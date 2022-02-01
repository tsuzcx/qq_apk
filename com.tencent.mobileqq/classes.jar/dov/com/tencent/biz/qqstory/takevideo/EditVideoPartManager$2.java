package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class EditVideoPartManager$2
  extends SimpleJob<Object>
{
  EditVideoPartManager$2(EditVideoPartManager paramEditVideoPartManager, String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    StoryReportor.a("video_edit", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ArrayOfJavaLangString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */