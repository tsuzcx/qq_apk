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

public class sxn
  implements syt<tnm, tox>
{
  public sxn(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull tnm paramtnm, @Nullable tox paramtox, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtox == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Sxf });
    }
    label541:
    do
    {
      return;
      ((sxh)this.a.jdField_a_of_type_Sxf).d = (paramtox.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((sxh)this.a.jdField_a_of_type_Sxf).a();
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtox.jdField_a_of_type_JavaLangString });
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramtox.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((sxh)this.a.jdField_a_of_type_Sxf).a(paramtox.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramtox.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramtox.d))
        {
          ((sxh)this.a.jdField_a_of_type_Sxf).g = paramtox.d;
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramtox.d });
        }
        if (!TextUtils.isEmpty(paramtox.e))
        {
          ((sxh)this.a.jdField_a_of_type_Sxf).g = paramtox.e;
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramtox.e });
        }
        ((sxh)this.a.jdField_a_of_type_Sxf).b = paramtox.jdField_a_of_type_JavaUtilList;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((sxh)this.a.jdField_a_of_type_Sxf).b);
        ((sxh)this.a.jdField_a_of_type_Sxf).e = paramtox.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Sxf });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new tjn().a(((sxh)this.a.jdField_a_of_type_Sxf).g);
        if (paramtox.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramtnm = paramtox.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtnm.hasNext())
        {
          paramtox = ((tny)paramtnm.next()).a.values().iterator();
          while (paramtox.hasNext())
          {
            paramErrorMessage = (String)paramtox.next();
            new tjn().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramtox.jdField_a_of_type_JavaLangString)) {
          veg.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramtox.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Sxf });
    } while ((paramtnm.a == null) || (paramtnm.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((sxh)this.a.jdField_a_of_type_Sxf).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramtnm.a.e))
      {
        j = 2;
        label667:
        paramtox = paramtnm.a.a();
        if (paramtnm.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramtnm = "2";; paramtnm = "1")
    {
      vel.a("video_edit", "pub_url", j, i, new String[] { paramtox, "", paramtnm });
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
 * Qualified Name:     sxn
 * JD-Core Version:    0.7.0.1
 */