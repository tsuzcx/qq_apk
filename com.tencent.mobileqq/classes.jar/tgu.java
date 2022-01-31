import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class tgu
  extends SimpleJob<Void>
{
  tgu(tgs paramtgs, String paramString, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = new ArrayList();
    paramVarArgs = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVarArgs.hasNext())
    {
      Object localObject = (StoryVideoItem)paramVarArgs.next();
      sul localsul = sul.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localsul.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localsul.c);
        }
        this.jdField_a_of_type_Tgs.b.add(localsul.c);
        paramJobContext.add(localsul);
      }
      localObject = sul.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((sul)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((sul)localObject).c);
        }
        this.jdField_a_of_type_Tgs.b.add(((sul)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Tgs.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgu
 * JD-Core Version:    0.7.0.1
 */