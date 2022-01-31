import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class nrj
  extends SimpleJob
{
  public nrj(StoryPickerFragment paramStoryPickerFragment, String paramString, int paramInt, View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem) {}
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    boolean bool = true;
    paramJobContext = QQStoryContext.a().b();
    Object localObject = (MemoryManager)SuperManager.a(19);
    paramVarArgs = new ArrayList();
    ArrayList localArrayList1 = ((MemoryManager)localObject).a(paramJobContext, paramVarArgs);
    if ((localArrayList1 == null) || (localArrayList1.size() == 0)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerFragment.a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerFragment.a.b(localArrayList2, true);
    }
    int i = localArrayList1.indexOf(this.jdField_a_of_type_JavaLangString);
    localObject = ((MemoryManager)localObject).a(paramJobContext);
    if ((localObject != null) && (((MemoryInfoEntry)localObject).isEnd == 1)) {}
    for (;;)
    {
      ThreadManager.getUIHandler().post(new nrk(this, paramJobContext, localArrayList1, i, paramVarArgs, bool));
      return null;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrj
 * JD-Core Version:    0.7.0.1
 */