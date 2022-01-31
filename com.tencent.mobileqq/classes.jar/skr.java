import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class skr
  implements slx<taq, tcb>
{
  public skr(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull taq paramtaq, @Nullable tcb paramtcb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtcb == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Skj });
    }
    label541:
    do
    {
      return;
      ((skl)this.a.jdField_a_of_type_Skj).d = (paramtcb.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((skl)this.a.jdField_a_of_type_Skj).a();
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtcb.jdField_a_of_type_JavaLangString });
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramtcb.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((skl)this.a.jdField_a_of_type_Skj).a(paramtcb.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramtcb.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramtcb.d))
        {
          ((skl)this.a.jdField_a_of_type_Skj).g = paramtcb.d;
          urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramtcb.d });
        }
        if (!TextUtils.isEmpty(paramtcb.e))
        {
          ((skl)this.a.jdField_a_of_type_Skj).g = paramtcb.e;
          urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramtcb.e });
        }
        ((skl)this.a.jdField_a_of_type_Skj).b = paramtcb.jdField_a_of_type_JavaUtilList;
        urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((skl)this.a.jdField_a_of_type_Skj).b);
        ((skl)this.a.jdField_a_of_type_Skj).e = paramtcb.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Skj });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new swr().a(((skl)this.a.jdField_a_of_type_Skj).g);
        if (paramtcb.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramtaq = paramtcb.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtaq.hasNext())
        {
          paramtcb = ((tbc)paramtaq.next()).a.values().iterator();
          while (paramtcb.hasNext())
          {
            paramErrorMessage = (String)paramtcb.next();
            new swr().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramtcb.jdField_a_of_type_JavaLangString)) {
          urk.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtcb.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Skj });
    } while ((paramtaq.a == null) || (paramtaq.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((skl)this.a.jdField_a_of_type_Skj).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramtaq.a.e))
      {
        j = 2;
        label667:
        paramtcb = paramtaq.a.a();
        if (paramtaq.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramtaq = "2";; paramtaq = "1")
    {
      urp.a("video_edit", "pub_url", j, i, new String[] { paramtcb, "", paramtaq });
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      j = 1;
      break label667;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     skr
 * JD-Core Version:    0.7.0.1
 */