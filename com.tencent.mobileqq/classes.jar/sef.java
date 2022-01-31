import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sef
  extends sdu<sed>
{
  protected List<sdg> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      sdg localsdg = (sdg)((Iterator)localObject).next();
      if ((localsdg.jdField_b_of_type_Long >= ((sed)a()).jdField_a_of_type_Long) && (localsdg.jdField_b_of_type_Long <= ((sed)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localsdg);
      }
    }
    return localArrayList;
  }
  
  protected List<sdf> a(@NonNull List<sdg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new sdf(((sed)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((sed)a()).jdField_a_of_type_Long, ((sed)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((sed)a()).c;
    Object localObject = sqd.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((sed)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((sed)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(sdf.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((sed)a()).jdField_b_of_type_Int) {
            break;
          }
          return null;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<sdf> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sef
 * JD-Core Version:    0.7.0.1
 */