import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.SimpleStepResultCallback;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;

class nzr
  implements SimpleStep.SimpleStepResultCallback
{
  nzr(nzq paramnzq, String paramString) {}
  
  public void a(GetMyStoryVideoListStep.Result paramResult)
  {
    if ((paramResult.a != null) && (TextUtils.equals(paramResult.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)))
    {
      NewMyStorySegment.a(this.jdField_a_of_type_Nzq.a).a = paramResult.a;
      NewMyStorySegment.a(this.jdField_a_of_type_Nzq.a).sendMessage(NewMyStorySegment.a(this.jdField_a_of_type_Nzq.a).obtainMessage(0, NewMyStorySegment.a(this.jdField_a_of_type_Nzq.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzr
 * JD-Core Version:    0.7.0.1
 */