import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class nxf
  extends SimpleJob
{
  public nxf(MemoryDataPuller paramMemoryDataPuller, VideoCollectionItem paramVideoCollectionItem) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = paramJobContext.a(DateCollectionListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_JavaLangString));
    boolean bool1;
    boolean bool2;
    label56:
    List localList;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label239;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_Boolean) {
        break label403;
      }
      localList = paramJobContext.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem, 10L);
      paramVarArgs = new DateCollectionListPageLoader.GetCollectionListEvent(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.c, new ErrorMessage());
      paramVarArgs.jdField_b_of_type_Boolean = true;
      paramVarArgs.c = bool2;
      paramVarArgs.e = true;
      paramVarArgs.jdField_a_of_type_Boolean = bool1;
      paramVarArgs.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label245;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label166:
      if (paramJobContext != null) {
        break label274;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_Boolean = true;
      if (!bool2) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.a(null, 0);
      label195:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label263;
      }
    }
    label263:
    for (paramJobContext = "null";; paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key)
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , not found in db , start get from net , spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      return null;
      bool1 = false;
      break;
      label239:
      bool2 = false;
      break label56;
      label245:
      paramJobContext = null;
      break label166;
      label250:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.c();
      break label195;
    }
    label274:
    if ((localMemoryInfoEntry != null) && (paramJobContext.dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
    {
      paramVarArgs.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_Boolean = true;
      label306:
      Dispatchers.get().dispatch(paramVarArgs);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a(localList, false);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label386;
      }
      paramJobContext = "null";
      label335:
      if (!paramVarArgs.jdField_a_of_type_Boolean) {
        break label397;
      }
    }
    label386:
    label397:
    for (paramVarArgs = "true";; paramVarArgs = "false")
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , isEnd = %s ,spend time = %d", new Object[] { paramJobContext, paramVarArgs, Long.valueOf(System.currentTimeMillis() - l) });
      break;
      paramVarArgs.jdField_a_of_type_Boolean = false;
      break label306;
      paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key;
      break label335;
    }
    label403:
    if (bool2) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.a(null, 0);
    }
    for (;;)
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", String.format("Req from net ,  spend time = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      break;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxf
 * JD-Core Version:    0.7.0.1
 */