package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import bghp;
import bgnt;
import bojv;
import boos;
import bpnc;
import bpnd;
import bpnf;
import bpni;
import bpnj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xar;

public class DoodleEmojiItem
  implements Cloneable
{
  public static final String POI_PASTER_LIST = "poi_poster_list";
  public String config;
  public String download_icon;
  public String download_url;
  public String download_wording;
  @Deprecated
  public int hide;
  public String icon;
  public Map<String, Map<String, bpnd>> mCityRes;
  public List<bpnf> mInfoItemList;
  public List<bpnj> mItemList;
  public String mLocalEmojiFolderPath;
  public int mask;
  public String md5;
  public String name;
  public String pack_id;
  public String random_position;
  public int type;
  
  public DoodleEmojiItem() {}
  
  public DoodleEmojiItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.pack_id = paramString1;
    this.icon = paramString2;
    this.download_icon = null;
    this.name = paramString3;
    this.download_url = paramString4;
    this.config = paramString5;
    this.md5 = paramString6;
    this.type = 1;
    this.mask = 0;
  }
  
  public DoodleEmojiItem(xar paramxar)
  {
    this.pack_id = paramxar.a;
    this.icon = paramxar.jdField_b_of_type_JavaLangString;
    this.download_icon = paramxar.c;
    this.name = paramxar.d;
    this.download_url = paramxar.e;
    this.config = paramxar.g;
    this.md5 = paramxar.f;
    this.type = paramxar.jdField_b_of_type_Int;
  }
  
  public static DoodleEmojiItem getDoodleEmojiItemFromJsonObj(JSONObject paramJSONObject)
  {
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)bghp.a(paramJSONObject, DoodleEmojiItem.class);
    if ((localDoodleEmojiItem != null) && (localDoodleEmojiItem.type != 1))
    {
      try
      {
        if (localDoodleEmojiItem.type == 2)
        {
          localDoodleEmojiItem.mItemList = bpni.a(paramJSONObject.getJSONArray("poi_poster_list"));
          return localDoodleEmojiItem;
        }
        if (localDoodleEmojiItem.type != 3) {
          return localDoodleEmojiItem;
        }
        localDoodleEmojiItem.mInfoItemList = bpnc.a(paramJSONObject.getJSONArray("info_poster_list"));
        localDoodleEmojiItem.mCityRes = bpnc.a(paramJSONObject.optJSONArray("city_res"));
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "parsed information item list");
        }
        paramJSONObject = (boos)bojv.a().c(12);
        if (bgnt.h(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMInformationPasterManager", 2, "batchPullAllRes");
          }
          paramJSONObject.a(localDoodleEmojiItem.mInfoItemList);
          return localDoodleEmojiItem;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, paramJSONObject, new Object[0]);
        }
        paramJSONObject.printStackTrace();
        return null;
      }
      paramJSONObject.a(localDoodleEmojiItem);
    }
    return localDoodleEmojiItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (DoodleEmojiItem)paramObject;
    return this.pack_id.equals(paramObject.pack_id);
  }
  
  public String getLocalEmojiFolderPath()
  {
    return this.mLocalEmojiFolderPath;
  }
  
  public int hashCode()
  {
    return this.pack_id.hashCode();
  }
  
  public void setLocalEmojiFolderPath(String paramString)
  {
    this.mLocalEmojiFolderPath = paramString;
  }
  
  public String toString()
  {
    return "DoodleEmojiItem{pack_id='" + this.pack_id + '\'' + ", icon='" + this.icon + '\'' + ", download_icon='" + this.download_icon + '\'' + ", name='" + this.name + '\'' + ", download_url='" + this.download_url + '\'' + ", md5='" + this.md5 + '\'' + ", mLocalEmojiFolderPath='" + this.mLocalEmojiFolderPath + '\'' + ", config='" + this.config + '\'' + ", mask=" + this.mask + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem
 * JD-Core Version:    0.7.0.1
 */