package dov.com.qq.im.capture.data;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DoodleMusicCategoryItem
  implements Cloneable
{
  public int a;
  public String a;
  public List a;
  public boolean a;
  
  public DoodleMusicCategoryItem() {}
  
  public DoodleMusicCategoryItem(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("categoryName")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("categoryName");
    }
    if (paramJSONObject.has("tagid")) {
      this.jdField_a_of_type_Int = paramJSONObject.getInt("tagid");
    }
    this.jdField_a_of_type_Boolean = "1".equals(paramJSONObject.optString("random_position"));
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        MusicItemInfo localMusicItemInfo = new MusicItemInfo(str);
        localMusicItemInfo.d = this.jdField_a_of_type_JavaLangString;
        localArrayList.add(localMusicItemInfo);
        if (QLog.isColorLevel()) {
          QLog.i("DoodleMusicCategoryItem", 2, "getDoodleMusicListFromJsonString" + str);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = localArrayList;
    }
  }
  
  public MusicItemInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)localIterator.next();
        if (localMusicItemInfo.jdField_a_of_type_Int == paramInt) {
          return localMusicItemInfo;
        }
      }
    }
    return null;
  }
  
  public DoodleMusicCategoryItem a()
  {
    try
    {
      DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)super.clone();
      return localDoodleMusicCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.DoodleMusicCategoryItem
 * JD-Core Version:    0.7.0.1
 */