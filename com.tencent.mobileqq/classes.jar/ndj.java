import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class ndj
  extends SimpleJob
{
  public ndj(QQStoryObserver paramQQStoryObserver, String paramString, Boolean paramBoolean, boolean paramBoolean1, int paramInt) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (UserManager)SuperManager.a(2);
    paramVarArgs = paramJobContext.b(this.jdField_a_of_type_JavaLangString);
    if (paramVarArgs != null) {
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      paramVarArgs.isSubscribe = i;
      paramJobContext.a(paramVarArgs);
      ThreadManager.getUIHandler().post(new ndk(this));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndj
 * JD-Core Version:    0.7.0.1
 */