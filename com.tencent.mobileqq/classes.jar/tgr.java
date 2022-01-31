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

class tgr
  extends SimpleJob<Void>
{
  tgr(tgp paramtgp, String paramString, List paramList)
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
      sui localsui = sui.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localsui.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localsui.c);
        }
        this.jdField_a_of_type_Tgp.b.add(localsui.c);
        paramJobContext.add(localsui);
      }
      localObject = sui.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((sui)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((sui)localObject).c);
        }
        this.jdField_a_of_type_Tgp.b.add(((sui)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_Tgp.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgr
 * JD-Core Version:    0.7.0.1
 */