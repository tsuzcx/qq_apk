import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class srb
  extends sqq<sqz>
{
  protected List<sqc> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      sqc localsqc = (sqc)((Iterator)localObject).next();
      if ((localsqc.jdField_b_of_type_Long >= ((sqz)a()).jdField_a_of_type_Long) && (localsqc.jdField_b_of_type_Long <= ((sqz)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localsqc);
      }
    }
    return localArrayList;
  }
  
  protected List<sqb> a(@NonNull List<sqc> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new sqb(((sqz)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((sqz)a()).jdField_a_of_type_Long, ((sqz)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((sqz)a()).c;
    Object localObject = tcz.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((sqz)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((sqz)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(sqb.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((sqz)a()).jdField_b_of_type_Int) {
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
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<sqb> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srb
 * JD-Core Version:    0.7.0.1
 */