package com.tencent.mobileqq.wink.edit.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class AEEditorFilterBean
  implements Serializable
{
  public static final String EFFECT_AI_ID = "effect_aieffect";
  public static final String EFFECT_NONE_ID = "none";
  @NotNull
  private AEEditorEffectGroupListBean.AEEditorEffectItem editorEffectItem = new AEEditorEffectGroupListBean.AEEditorEffectItem();
  @NotNull
  private AEFilterExtendBean effectExtendBean = new AEFilterExtendBean();
  private String effectId;
  private String name;
  @SerializedName("picurl")
  private String picUrl;
  private int progress = -1;
  @Expose(deserialize=false, serialize=false)
  public AEEditorFilterBean.FilterID type = AEEditorFilterBean.FilterID.CLIENT;
  private int uploadMaxSize;
  
  public static AEEditorFilterBean createAiFilterInstance()
  {
    AEEditorFilterBean localAEEditorFilterBean = new AEEditorFilterBean();
    localAEEditorFilterBean.editorEffectItem.setHideApplyAll(1);
    localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.AIFilter;
    localAEEditorFilterBean.effectId = "effect_aieffect";
    return localAEEditorFilterBean;
  }
  
  public static AEEditorFilterBean createNonFilterInstance()
  {
    AEEditorFilterBean localAEEditorFilterBean = new AEEditorFilterBean();
    localAEEditorFilterBean.editorEffectItem.setHideApplyAll(1);
    localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.NON;
    localAEEditorFilterBean.effectId = "none";
    return localAEEditorFilterBean;
  }
  
  public AEEditorEffectGroupListBean.AEEditorEffectItem getEditorEffectItem()
  {
    return this.editorEffectItem;
  }
  
  @NotNull
  public AEFilterExtendBean getEffectExtendBean()
  {
    return this.effectExtendBean;
  }
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  public int getUploadMaxSize()
  {
    return this.uploadMaxSize;
  }
  
  public void setEditorEffectItem(@NotNull AEEditorEffectGroupListBean.AEEditorEffectItem paramAEEditorEffectItem)
  {
    this.editorEffectItem = paramAEEditorEffectItem;
  }
  
  public void setEffectExtendBean(@NotNull AEFilterExtendBean paramAEFilterExtendBean)
  {
    this.effectExtendBean = paramAEFilterExtendBean;
  }
  
  public void setEffectId(String paramString)
  {
    this.effectId = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPicUrl(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void setUploadMaxSize(int paramInt)
  {
    this.uploadMaxSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.bean.AEEditorFilterBean
 * JD-Core Version:    0.7.0.1
 */