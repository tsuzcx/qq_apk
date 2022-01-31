import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller.StoryVidListReceiver;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;

public class nbw
  extends SimpleJob
{
  public nbw(TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (StoryManager)SuperManager.a(5);
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Int == 3)) {}
    for (paramJobContext = paramJobContext.f(this.a.jdField_a_of_type_JavaLangString);; paramJobContext = null)
    {
      paramVarArgs = paramJobContext;
      if (paramJobContext == null) {
        paramVarArgs = new ArrayList();
      }
      if (paramVarArgs.size() > 0)
      {
        this.a.a(paramVarArgs);
        SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Found %s vid list from local , pullType is %d , %s", new Object[] { this.a.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int), paramVarArgs }));
        return null;
      }
      SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Cannot found %s vid list from local , pullType is %d , request from net", new Object[] { this.a.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver == null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver = new TroopVidToVideoInfoPuller.StoryVidListReceiver(this.a);
        Dispatchers.get().registerSubscriber(this.a.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerTroopUidToVidListHandler = new TroopUidToVidListHandler(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerTroopUidToVidListHandler.a();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbw
 * JD-Core Version:    0.7.0.1
 */