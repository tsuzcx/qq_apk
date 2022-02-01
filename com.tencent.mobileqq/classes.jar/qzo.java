import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public final class qzo
{
  @NotNull
  public static final ArrayList<qzp> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    String str = "date_modified DESC limit " + paramInt2 + " offset " + paramInt1;
    localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "duration", "resolution", "title", "mime_type" }, "duration>0", null, str);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      paramInt1 = 0;
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new qzp();
        ((qzp)localObject2).jdField_a_of_type_Boolean = true;
        ((qzp)localObject2).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((qzp)localObject2).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((qzp)localObject2).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((qzp)localObject2).jdField_d_of_type_Long = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("duration"));
        ((qzp)localObject2).jdField_c_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("resolution"));
        ((qzp)localObject2).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((qzp)localObject2).jdField_d_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("title"));
        ((qzp)localObject2).jdField_a_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((qzp)localObject2).f = ((qzp)localObject2).jdField_b_of_type_JavaLangString;
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
        QLog.d("AlbumUtils", 2, "queryVideoList index:" + paramInt1);
        paramInt1 += 1;
      }
    }
    return localArrayList;
  }
  
  @NotNull
  public static final ArrayList<qzp> b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    Object localObject3 = "date_modified DESC limit " + paramInt2 + " offset " + paramInt1;
    localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "mime_type" }, null, null, (String)localObject3);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new qzp();
        ((qzp)localObject2).jdField_a_of_type_Boolean = false;
        ((qzp)localObject2).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((qzp)localObject2).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((qzp)localObject2).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((qzp)localObject2).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((qzp)localObject2).jdField_a_of_type_JavaLangString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((qzp)localObject2).e = ((qzp)localObject2).jdField_b_of_type_JavaLangString;
        ((qzp)localObject2).f = ((qzp)localObject2).e;
        localObject3 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject3).mediaWidth = ((qzp)localObject2).a();
        ((LocalMediaInfo)localObject3).mediaHeight = ((qzp)localObject2).b();
        ((LocalMediaInfo)localObject3).path = ((qzp)localObject2).jdField_b_of_type_JavaLangString;
        ((qzp)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject3);
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzo
 * JD-Core Version:    0.7.0.1
 */