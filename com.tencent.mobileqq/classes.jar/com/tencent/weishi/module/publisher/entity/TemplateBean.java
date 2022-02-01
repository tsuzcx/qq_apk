package com.tencent.weishi.module.publisher.entity;

import android.text.TextUtils;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.utils.CollectionUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TemplateBean
  implements Serializable, Cloneable
{
  public static final int STATUS_DOWNLOADED = 1;
  public static final int STATUS_NOT_DOWNLOAD = 0;
  public static final String TEMPLATE_JSON = "template.json";
  public boolean canChange;
  public String category = "";
  public String coverUrl = "";
  public String fileSuffix = "";
  public boolean isStuckPoint;
  public String musicId = "";
  public MusicMaterialMetaDataBean musicMaterialMetaDataBean;
  public int reserveSource;
  public String spec = "";
  public int status = 0;
  public String subCategoryId = "";
  public ArrayList<String> subcategories = null;
  public List<String> tags = null;
  public String templateId = "";
  public String templateJsonPath;
  public String templateName = "";
  public String templatePath;
  public int templateType = 0;
  public int templateUiType = 0;
  public String url = "";
  public long version = 0L;
  public int zipFile = 0;
  
  public TemplateBean clone()
  {
    TemplateBean localTemplateBean = new TemplateBean();
    localTemplateBean.templateId = this.templateId;
    localTemplateBean.templateName = this.templateName;
    localTemplateBean.url = this.url;
    localTemplateBean.spec = this.spec;
    if (!CollectionUtils.isEmpty(this.tags)) {
      localTemplateBean.tags = new ArrayList(this.tags);
    }
    localTemplateBean.coverUrl = this.coverUrl;
    localTemplateBean.templateType = this.templateType;
    localTemplateBean.musicId = this.musicId;
    localTemplateBean.category = this.category;
    if (!CollectionUtils.isEmpty(this.subcategories)) {
      localTemplateBean.subcategories = new ArrayList(this.subcategories);
    }
    localTemplateBean.version = this.version;
    localTemplateBean.isStuckPoint = this.isStuckPoint;
    localTemplateBean.canChange = this.canChange;
    localTemplateBean.reserveSource = this.reserveSource;
    localTemplateBean.templateUiType = this.templateUiType;
    if (this.musicMaterialMetaDataBean != null) {
      localTemplateBean.musicMaterialMetaDataBean = this.musicMaterialMetaDataBean.deepClone();
    }
    localTemplateBean.status = this.status;
    localTemplateBean.zipFile = this.zipFile;
    localTemplateBean.version = this.version;
    localTemplateBean.fileSuffix = this.fileSuffix;
    localTemplateBean.templateJsonPath = this.templateJsonPath;
    localTemplateBean.templatePath = this.templatePath;
    localTemplateBean.subCategoryId = this.subCategoryId;
    return localTemplateBean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof TemplateBean)) {
        return false;
      }
      paramObject = (TemplateBean)paramObject;
    } while ((this.templateId != null) && (this.templateId.equals(paramObject.templateId)));
    return false;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public String getMusicId()
  {
    return this.musicId;
  }
  
  public MusicMaterialMetaDataBean getMusicMaterialMetaDataBean()
  {
    return this.musicMaterialMetaDataBean;
  }
  
  public String getSpec()
  {
    return this.spec;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public ArrayList<String> getSubcategories()
  {
    return this.subcategories;
  }
  
  public List<String> getTags()
  {
    return this.tags;
  }
  
  public String getTemplateId()
  {
    return this.templateId;
  }
  
  public String getTemplateJsonDir()
  {
    if (!TextUtils.isEmpty(this.templateJsonPath))
    {
      int i = this.templateJsonPath.indexOf("template.json");
      return this.templateJsonPath.substring(0, i - 1);
    }
    return null;
  }
  
  public String getTemplateJsonPath()
  {
    return this.templateJsonPath;
  }
  
  public String getTemplateName()
  {
    return this.templateName;
  }
  
  public int getTemplateType()
  {
    return this.templateType;
  }
  
  public int getTemplateUiType()
  {
    return this.templateUiType;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public long getVersion()
  {
    return this.version;
  }
  
  public boolean isExist()
  {
    if (TextUtils.isEmpty(this.templateJsonPath)) {
      return true;
    }
    return new File(this.templateJsonPath).exists();
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public void setMusicId(String paramString)
  {
    this.musicId = paramString;
  }
  
  public void setMusicMaterialMetaDataBean(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    this.musicMaterialMetaDataBean = paramMusicMaterialMetaDataBean;
  }
  
  public void setSpec(String paramString)
  {
    this.spec = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setSubcategories(ArrayList<String> paramArrayList)
  {
    this.subcategories = paramArrayList;
  }
  
  public void setTags(ArrayList<String> paramArrayList)
  {
    this.tags = paramArrayList;
  }
  
  public void setTemplateId(String paramString)
  {
    this.templateId = paramString;
  }
  
  public void setTemplateJsonPath(String paramString)
  {
    this.templateJsonPath = paramString;
  }
  
  public void setTemplateName(String paramString)
  {
    this.templateName = paramString;
  }
  
  public void setTemplateType(int paramInt)
  {
    this.templateType = paramInt;
    if (paramInt == 2) {
      this.category = "videofunny";
    }
    while (paramInt != 1) {
      return;
    }
    this.category = "autoTemplate";
  }
  
  public void setTemplateUiType(int paramInt)
  {
    this.templateUiType = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVersion(long paramLong)
  {
    this.version = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    return "TemplateBean{templateId='" + this.templateId + '\'' + ", templateName='" + this.templateName + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.entity.TemplateBean
 * JD-Core Version:    0.7.0.1
 */