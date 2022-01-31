package dov.com.qq.im.aeeditor.module.filter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AEEditorFilterBean
  implements Serializable
{
  private float defaultAlpha;
  private String lutName;
  private String name;
  @SerializedName("picurl")
  private String picUrl;
  private String sid;
  @Expose(deserialize=false, serialize=false)
  public AEEditorFilterBean.FilterID type = AEEditorFilterBean.FilterID.COLOR;
  
  public static AEEditorFilterBean createAiFilterInstance()
  {
    AEEditorFilterBean localAEEditorFilterBean = new AEEditorFilterBean();
    localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.AIFilter;
    localAEEditorFilterBean.sid = "lut_aieffect";
    return localAEEditorFilterBean;
  }
  
  public static AEEditorFilterBean createComicsFilterInstance()
  {
    AEEditorFilterBean localAEEditorFilterBean = new AEEditorFilterBean();
    localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.Comics;
    localAEEditorFilterBean.sid = "lut_comics";
    localAEEditorFilterBean.picUrl = "https://down.qq.com/shadow_qqcamera/LUTFilterResource/cover/comic_cover@3x.png";
    return localAEEditorFilterBean;
  }
  
  public static AEEditorFilterBean createNonFilterInstance()
  {
    AEEditorFilterBean localAEEditorFilterBean = new AEEditorFilterBean();
    localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.NON;
    localAEEditorFilterBean.sid = "lut_blank";
    return localAEEditorFilterBean;
  }
  
  public float getDefaultAlpha()
  {
    return this.defaultAlpha;
  }
  
  public String getLutName()
  {
    return this.lutName;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public void setDefaultAlpha(float paramFloat)
  {
    this.defaultAlpha = paramFloat;
  }
  
  public void setLutName(String paramString)
  {
    this.lutName = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPicUrl(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean
 * JD-Core Version:    0.7.0.1
 */