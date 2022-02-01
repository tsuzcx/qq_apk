package cooperation.qzone.model;

public class BusinessAlbumInfo$Privacy
{
  public static final int QZ_ALBUM_PERMISSION_ANSWER = 5;
  public static final int QZ_ALBUM_PERMISSION_ANSWER_OLD = 2;
  public static final int QZ_ALBUM_PERMISSION_BLACKLIST = 8;
  public static final int QZ_ALBUM_PERMISSION_FRIEND = 4;
  public static final int QZ_ALBUM_PERMISSION_PRIVATE = 3;
  public static final int QZ_ALBUM_PERMISSION_PUBLIC = 1;
  public static final int QZ_ALBUM_PERMISSION_SOMEONE = 6;
  
  public static String getDescription(int paramInt)
  {
    return BusinessAlbumInfo.getPrivNameFromAlbum(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.BusinessAlbumInfo.Privacy
 * JD-Core Version:    0.7.0.1
 */