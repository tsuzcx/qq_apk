package cooperation.qzone.provider;

import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class LocalPhotoGroupData
  implements Serializable
{
  public String capTime;
  public ArrayList<String> pathList = new ArrayList();
  public long startTime;
  public String title;
  public String unikey;
  
  public static LocalPhotoGroupData getLocalPhotoGroupDataFromSp(long paramLong)
  {
    QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... pushTime:", Long.valueOf(paramLong) });
    Object localObject2 = LocalMultiProcConfig.getString("QzoneMsg_recommand_photo_key_" + paramLong, "");
    Object localObject1 = LocalMultiProcConfig.getString("QzoneMsg_recommand_photo_list_" + paramLong, "");
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      QZLog.e("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... key:", localObject2, " pathlist:", localObject1 });
      return null;
    }
    String[] arrayOfString = ((String)localObject2).split(";");
    if (arrayOfString.length != 3)
    {
      QZLog.e("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... list.length != 3" });
      return null;
    }
    localObject2 = new LocalPhotoGroupData();
    ((LocalPhotoGroupData)localObject2).unikey = arrayOfString[0];
    ((LocalPhotoGroupData)localObject2).title = arrayOfString[1];
    ((LocalPhotoGroupData)localObject2).capTime = arrayOfString[2];
    localObject1 = ((String)localObject1).split(";");
    int i = 0;
    if (i < localObject1.length)
    {
      if (new File(localObject1[i]).exists()) {
        ((LocalPhotoGroupData)localObject2).pathList.add(localObject1[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        QZLog.w("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... not exist !! i:", Integer.valueOf(i), " path:", localObject1[i] });
      }
    }
    if (((LocalPhotoGroupData)localObject2).pathList.size() != 0)
    {
      QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... return localPhotoGroupData:", ((LocalPhotoGroupData)localObject2).toString() });
      return localObject2;
    }
    QZLog.w("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... no photos" });
    return null;
  }
  
  public void saveSp(long paramLong)
  {
    QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "saveSp... pushTime:", Long.valueOf(paramLong) });
    if (paramLong == 0L) {
      QZLog.e("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "saveSp... pushTime == 0" });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.unikey).append(";").append(this.title).append(";").append(this.capTime);
    LocalMultiProcConfig.putString("QzoneMsg_recommand_photo_key_" + paramLong, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.pathList.size())
    {
      if (i == this.pathList.size() - 1) {
        localStringBuilder.append((String)this.pathList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)this.pathList.get(i)).append(";");
      }
    }
    LocalMultiProcConfig.putString("QzoneMsg_recommand_photo_list_" + paramLong, localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocalPhotoGroupData{");
    localStringBuffer.append("unikey='").append(this.unikey).append('\'');
    localStringBuffer.append(", title='").append(this.title).append('\'');
    localStringBuffer.append(", capTime='").append(this.capTime).append('\'');
    localStringBuffer.append(", startTime=").append(this.startTime);
    localStringBuffer.append(", pathList=").append(this.pathList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.provider.LocalPhotoGroupData
 * JD-Core Version:    0.7.0.1
 */