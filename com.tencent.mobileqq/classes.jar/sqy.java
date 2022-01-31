import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sqy
  extends sqn<sqw>
{
  protected List<spz> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      spz localspz = (spz)((Iterator)localObject).next();
      if ((localspz.jdField_b_of_type_Long >= ((sqw)a()).jdField_a_of_type_Long) && (localspz.jdField_b_of_type_Long <= ((sqw)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localspz);
      }
    }
    return localArrayList;
  }
  
  protected List<spy> a(@NonNull List<spz> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new spy(((sqw)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((sqw)a()).jdField_a_of_type_Long, ((sqw)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((sqw)a()).c;
    Object localObject = tcw.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((sqw)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((sqw)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(spy.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((sqw)a()).jdField_b_of_type_Int) {
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
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<spy> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqy
 * JD-Core Version:    0.7.0.1
 */