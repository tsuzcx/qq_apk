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
  private static final String KEY_LIST = "QzoneMsg_recommand_photo_list_";
  private static final String KEY_TITLE = "QzoneMsg_recommand_photo_key_";
  private static final String TAG = "[PhotoAlbum]LocalPhotoGroupData";
  public String capTime;
  public ArrayList<String> pathList = new ArrayList();
  public long startTime;
  public String title;
  public String unikey;
  
  public static LocalPhotoGroupData getLocalPhotoGroupDataFromSp(long paramLong)
  {
    QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... pushTime:", Long.valueOf(paramLong) });
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QzoneMsg_recommand_photo_key_");
    ((StringBuilder)localObject1).append(paramLong);
    Object localObject2 = LocalMultiProcConfig.getString(((StringBuilder)localObject1).toString(), "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QzoneMsg_recommand_photo_list_");
    ((StringBuilder)localObject1).append(paramLong);
    localObject1 = LocalMultiProcConfig.getString(((StringBuilder)localObject1).toString(), "");
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
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
      while (i < localObject1.length)
      {
        if (new File(localObject1[i]).exists()) {
          ((LocalPhotoGroupData)localObject2).pathList.add(localObject1[i]);
        } else {
          QZLog.w("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... not exist !! i:", Integer.valueOf(i), " path:", localObject1[i] });
        }
        i += 1;
      }
      if (((LocalPhotoGroupData)localObject2).pathList.size() != 0)
      {
        QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... return localPhotoGroupData:", ((LocalPhotoGroupData)localObject2).toString() });
        return localObject2;
      }
      QZLog.w("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... no photos" });
      return null;
    }
    QZLog.e("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "getLocalPhotoGroupDataFromSp... key:", localObject2, " pathlist:", localObject1 });
    return null;
  }
  
  public void saveSp(long paramLong)
  {
    int i = 0;
    QZLog.d("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "saveSp... pushTime:", Long.valueOf(paramLong) });
    if (paramLong == 0L) {
      QZLog.e("[PhotoAlbum]LocalPhotoGroupData", 1, new Object[] { "saveSp... pushTime == 0" });
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.unikey);
    localStringBuilder1.append(";");
    localStringBuilder1.append(this.title);
    localStringBuilder1.append(";");
    localStringBuilder1.append(this.capTime);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("QzoneMsg_recommand_photo_key_");
    localStringBuilder2.append(paramLong);
    LocalMultiProcConfig.putString(localStringBuilder2.toString(), localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    while (i < this.pathList.size())
    {
      if (i == this.pathList.size() - 1)
      {
        localStringBuilder1.append((String)this.pathList.get(i));
      }
      else
      {
        localStringBuilder1.append((String)this.pathList.get(i));
        localStringBuilder1.append(";");
      }
      i += 1;
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("QzoneMsg_recommand_photo_list_");
    localStringBuilder2.append(paramLong);
    LocalMultiProcConfig.putString(localStringBuilder2.toString(), localStringBuilder1.toString());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocalPhotoGroupData{");
    localStringBuffer.append("unikey='");
    localStringBuffer.append(this.unikey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", title='");
    localStringBuffer.append(this.title);
    localStringBuffer.append('\'');
    localStringBuffer.append(", capTime='");
    localStringBuffer.append(this.capTime);
    localStringBuffer.append('\'');
    localStringBuffer.append(", startTime=");
    localStringBuffer.append(this.startTime);
    localStringBuffer.append(", pathList=");
    localStringBuffer.append(this.pathList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.provider.LocalPhotoGroupData
 * JD-Core Version:    0.7.0.1
 */