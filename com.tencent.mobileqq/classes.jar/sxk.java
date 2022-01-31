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

public class sxk
  implements syq<tnj, tou>
{
  public sxk(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull tnj paramtnj, @Nullable tou paramtou, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtou == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Sxc });
    }
    label541:
    do
    {
      return;
      ((sxe)this.a.jdField_a_of_type_Sxc).d = (paramtou.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((sxe)this.a.jdField_a_of_type_Sxc).a();
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtou.jdField_a_of_type_JavaLangString });
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramtou.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((sxe)this.a.jdField_a_of_type_Sxc).a(paramtou.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramtou.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramtou.d))
        {
          ((sxe)this.a.jdField_a_of_type_Sxc).g = paramtou.d;
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramtou.d });
        }
        if (!TextUtils.isEmpty(paramtou.e))
        {
          ((sxe)this.a.jdField_a_of_type_Sxc).g = paramtou.e;
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramtou.e });
        }
        ((sxe)this.a.jdField_a_of_type_Sxc).b = paramtou.jdField_a_of_type_JavaUtilList;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((sxe)this.a.jdField_a_of_type_Sxc).b);
        ((sxe)this.a.jdField_a_of_type_Sxc).e = paramtou.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Sxc });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new tjk().a(((sxe)this.a.jdField_a_of_type_Sxc).g);
        if (paramtou.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramtnj = paramtou.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtnj.hasNext())
        {
          paramtou = ((tnv)paramtnj.next()).a.values().iterator();
          while (paramtou.hasNext())
          {
            paramErrorMessage = (String)paramtou.next();
            new tjk().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramtou.jdField_a_of_type_JavaLangString)) {
          ved.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtou.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Sxc });
    } while ((paramtnj.a == null) || (paramtnj.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((sxe)this.a.jdField_a_of_type_Sxc).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramtnj.a.e))
      {
        j = 2;
        label667:
        paramtou = paramtnj.a.a();
        if (paramtnj.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramtnj = "2";; paramtnj = "1")
    {
      vei.a("video_edit", "pub_url", j, i, new String[] { paramtou, "", paramtnj });
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
 * Qualified Name:     sxk
 * JD-Core Version:    0.7.0.1
 */