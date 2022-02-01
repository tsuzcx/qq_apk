package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoShelfTemplate
{
  @Expose
  private String audioName;
  @Expose
  private List<String> crazyFaceList;
  @Expose
  private String desc;
  @Expose
  private String filterLutName;
  @Expose
  private List<VideoFrameItem> frameList;
  @Expose
  private int frameSize;
  private List<String> fullpathCrazyFaceFileName = new ArrayList();
  private boolean isFromAssets = false;
  @Expose
  private int itemID;
  private String materialPath;
  @Expose
  private String name;
  @Expose
  private int needWatermark;
  @Expose
  private List<MaskNodeGroup> nodeGroupList;
  @Expose
  private String pagFileName;
  @Expose
  private String previewVideoName;
  @Expose
  private int previewVideoType;
  @Expose
  private String tip;
  @Expose
  private int[] tipTemplate;
  @Expose
  private int version;
  @Expose
  private int videoHeight;
  @Expose
  private String videoName;
  @Expose
  private int videoTemplateType;
  @Expose
  private int videoWidth;
  @Expose
  private float[] watermarkRect;
  
  public String getAudioPath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getMaterialPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.audioName);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.isFromAssets) {
      localObject = str.replace("assets://", "");
    }
    return localObject;
  }
  
  public List<String> getCrazyFaceList()
  {
    Object localObject = this.fullpathCrazyFaceFileName;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return this.fullpathCrazyFaceFileName;
    }
    localObject = this.crazyFaceList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.crazyFaceList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getMaterialPath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        if (this.isFromAssets) {
          str.replace("assets://", "");
        }
        this.fullpathCrazyFaceFileName.add(str);
      }
    }
    return this.fullpathCrazyFaceFileName;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getFilterLutName()
  {
    return this.filterLutName;
  }
  
  public String getFilterLutPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getMaterialPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.filterLutName);
    return localStringBuilder.toString();
  }
  
  public List<VideoFrameItem> getFrameList()
  {
    return this.frameList;
  }
  
  public int getFrameSize()
  {
    return this.frameSize;
  }
  
  public int getItemID()
  {
    return this.itemID;
  }
  
  public String getMaterialPath()
  {
    return this.materialPath;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getNeedWatermark()
  {
    return this.needWatermark;
  }
  
  public List<MaskNodeGroup> getNodeGroupList()
  {
    return this.nodeGroupList;
  }
  
  public String getPagFileName()
  {
    return this.pagFileName;
  }
  
  public String getPagFilePath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getMaterialPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(getPagFileName());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.isFromAssets) {
      localObject = str.replace("assets://", "");
    }
    return localObject;
  }
  
  public String getPreviewVideoName()
  {
    return this.previewVideoName;
  }
  
  public String getPreviewVideoPath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getMaterialPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(getPreviewVideoName());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.isFromAssets) {
      localObject = str.replace("assets://", "");
    }
    return localObject;
  }
  
  public int getPreviewVideoType()
  {
    return this.previewVideoType;
  }
  
  public String getTip()
  {
    return this.tip;
  }
  
  public int[] getTipTemplate()
  {
    return this.tipTemplate;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public String getVideoName()
  {
    String str2 = this.videoName;
    String str1 = str2;
    if (str2 == null) {
      str1 = "Video_Pag.mp4";
    }
    return str1;
  }
  
  public String getVideoPath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getMaterialPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(getVideoName());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.isFromAssets) {
      localObject = str.replace("assets://", "");
    }
    return localObject;
  }
  
  public int getVideoTemplateType()
  {
    return this.videoTemplateType;
  }
  
  public int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public float[] getWatermarkRect()
  {
    return this.watermarkRect;
  }
  
  public boolean isFromAssets()
  {
    return this.isFromAssets;
  }
  
  public void setFromAssets(boolean paramBoolean)
  {
    this.isFromAssets = paramBoolean;
  }
  
  public void setMaterialPath(String paramString)
  {
    this.materialPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate
 * JD-Core Version:    0.7.0.1
 */