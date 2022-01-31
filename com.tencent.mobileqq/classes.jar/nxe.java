import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
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

public class nxe
  extends SimpleJob
{
  public nxe(MemoryDataPuller paramMemoryDataPuller) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (MemoryManager)SuperManager.a(19);
    paramVarArgs = paramJobContext.a(DateCollectionListPageLoader.a(this.a.jdField_b_of_type_JavaLangString));
    boolean bool;
    DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1))
    {
      bool = true;
      List localList = paramJobContext.a(this.a.jdField_b_of_type_JavaLangString, null, 10L);
      localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.a.c, new ErrorMessage());
      localGetCollectionListEvent.jdField_b_of_type_Boolean = true;
      localGetCollectionListEvent.c = true;
      localGetCollectionListEvent.e = true;
      localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
      localGetCollectionListEvent.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label234;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label144:
      if (paramJobContext != null) {
        break label239;
      }
      localGetCollectionListEvent.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = true;
      label162:
      Dispatchers.get().dispatch(localGetCollectionListEvent);
      this.a.a(localList, false);
      if (!localGetCollectionListEvent.jdField_a_of_type_Boolean) {
        break label282;
      }
    }
    label282:
    for (paramJobContext = "true";; paramJobContext = "false")
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      this.a.d();
      return null;
      bool = false;
      break;
      label234:
      paramJobContext = null;
      break label144;
      label239:
      if ((paramVarArgs != null) && (paramJobContext.dbIndex >= paramVarArgs.maxCollectionIndex))
      {
        localGetCollectionListEvent.jdField_a_of_type_Boolean = bool;
        this.a.jdField_b_of_type_Boolean = true;
        break label162;
      }
      localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxe
 * JD-Core Version:    0.7.0.1
 */