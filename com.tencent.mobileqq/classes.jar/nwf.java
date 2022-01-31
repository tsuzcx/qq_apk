import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class nwf
  extends SimpleJob
{
  public nwf(MemoriesVideoListSegment paramMemoriesVideoListSegment, String paramString1, int paramInt, View paramView, String paramString2) {}
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    boolean bool = true;
    Object localObject = (MemoryManager)SuperManager.a(19);
    paramJobContext = new ArrayList();
    paramVarArgs = ((MemoryManager)localObject).a(MemoriesVideoListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).jdField_a_of_type_JavaLangString, paramJobContext);
    if ((paramVarArgs == null) || (paramVarArgs.size() == 0))
    {
      AssertUtils.a("data key null for unionId:%s", new Object[] { MemoriesVideoListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).jdField_a_of_type_JavaLangString });
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    MemoriesVideoListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).a(localArrayList);
    int i = paramVarArgs.indexOf(this.jdField_a_of_type_JavaLangString);
    localObject = ((MemoryManager)localObject).a(DateCollectionListPageLoader.a(MemoriesVideoListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).jdField_a_of_type_JavaLangString));
    if ((localObject != null) && (((MemoryInfoEntry)localObject).isEnd == 1)) {}
    for (;;)
    {
      localObject = ((UserManager)SuperManager.a(2)).b(MemoriesVideoListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).jdField_a_of_type_JavaLangString);
      ThreadManager.getUIHandler().post(new nwg(this, paramVarArgs, i, paramJobContext, bool, (QQUserUIItem)localObject));
      return null;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwf
 * JD-Core Version:    0.7.0.1
 */