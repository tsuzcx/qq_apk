package dov.com.qq.im.ae.config;

import aukm;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.BubbleData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CategoryMaterialEmoEntity
  extends aukm
{
  public String additionalFields;
  public String bigId;
  public String bigName;
  public String bigThumbUrl;
  public String bubbleId;
  public String bubbleText;
  public String id;
  public String packageUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  public static List<CategoryMaterialEmoEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp paramGetCategoryMaterialRsp)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramGetCategoryMaterialRsp.Categories.iterator();
    if (localIterator1.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)localIterator1.next();
      Iterator localIterator2 = localMetaCategory.materials.iterator();
      label46:
      MetaMaterial localMetaMaterial;
      CategoryMaterialEmoEntity localCategoryMaterialEmoEntity;
      if (localIterator2.hasNext())
      {
        localMetaMaterial = (MetaMaterial)localIterator2.next();
        localCategoryMaterialEmoEntity = new CategoryMaterialEmoEntity();
        localCategoryMaterialEmoEntity.bigId = localMetaCategory.id;
        localCategoryMaterialEmoEntity.bigName = localMetaCategory.name;
        localCategoryMaterialEmoEntity.bigThumbUrl = localMetaCategory.thumbUrl;
        if ((paramGetCategoryMaterialRsp.BubbleData == null) || (!paramGetCategoryMaterialRsp.BubbleData.Id.endsWith(localMetaMaterial.id))) {
          break label260;
        }
        str = paramGetCategoryMaterialRsp.BubbleData.Id;
        label140:
        localCategoryMaterialEmoEntity.bubbleId = str;
        if ((paramGetCategoryMaterialRsp.BubbleData == null) || (!paramGetCategoryMaterialRsp.BubbleData.Id.endsWith(localMetaMaterial.id))) {
          break label266;
        }
      }
      label260:
      label266:
      for (String str = paramGetCategoryMaterialRsp.BubbleData.DisplayText;; str = "")
      {
        localCategoryMaterialEmoEntity.bubbleText = str;
        localCategoryMaterialEmoEntity.id = localMetaMaterial.id;
        localCategoryMaterialEmoEntity.thumbUrl = localMetaMaterial.thumbUrl;
        localCategoryMaterialEmoEntity.thumbWidth = localMetaMaterial.thumbWidth;
        localCategoryMaterialEmoEntity.thumbHeight = localMetaMaterial.thumbHeight;
        localCategoryMaterialEmoEntity.packageUrl = localMetaMaterial.packageUrl;
        localCategoryMaterialEmoEntity.additionalFields = mapToJson(localMetaMaterial.additionalFields);
        localArrayList.add(localCategoryMaterialEmoEntity);
        break label46;
        break;
        str = "";
        break label140;
      }
    }
    return localArrayList;
  }
  
  private static String mapToJson(Map<String, String> paramMap)
  {
    return new Gson().toJson(paramMap);
  }
  
  public String toString()
  {
    return "CategoryMaterialEmoEntity{bigId='" + this.bigId + '\'' + ", bigName='" + this.bigName + '\'' + ", bigThumbUrl='" + this.bigThumbUrl + '\'' + ", id='" + this.id + '\'' + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", packageUrl='" + this.packageUrl + '\'' + ", additionalFields='" + this.additionalFields + '\'' + ", bubbleId='" + this.bubbleId + '\'' + ", bubbleText='" + this.bubbleText + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CategoryMaterialEmoEntity
 * JD-Core Version:    0.7.0.1
 */