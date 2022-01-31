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

class sty
  extends SimpleJob<Void>
{
  sty(stw paramstw, String paramString, List paramList)
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
      shp localshp = shp.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localshp.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localshp.c);
        }
        this.jdField_a_of_type_Stw.b.add(localshp.c);
        paramJobContext.add(localshp);
      }
      localObject = shp.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((shp)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((shp)localObject).c);
        }
        this.jdField_a_of_type_Stw.b.add(((shp)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Stw.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sty
 * JD-Core Version:    0.7.0.1
 */