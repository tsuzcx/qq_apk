package com.tencent.mobileqq.shortvideo.dancemachine;

public class ResourceManager$ScanResource
{
  public String bottomText;
  public String facebottomText;
  public String facemaskPic;
  private String faceprefix_scan;
  public String facerecognizePic;
  public String facetopText;
  public String maskPic;
  private String prefix_scan;
  public String recognizePic;
  public String scanBg;
  public String scanContent;
  public String scanPic;
  public String topText;
  
  public ResourceManager$ScanResource(ResourceManager paramResourceManager)
  {
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("bodyScan/");
    this.prefix_scan = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("faceScan/");
    this.faceprefix_scan = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("recognize.png");
    this.recognizePic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("scan.png");
    this.scanPic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("mask.png");
    this.maskPic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.faceprefix_scan);
    paramResourceManager.append("facerecognize.png");
    this.facerecognizePic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.faceprefix_scan);
    paramResourceManager.append("facemask.png");
    this.facemaskPic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("scan_bg.png");
    this.scanBg = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("scan_content.png");
    this.scanContent = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("bottom_text.png");
    this.bottomText = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix_scan);
    paramResourceManager.append("top_text.png");
    this.topText = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.faceprefix_scan);
    paramResourceManager.append("face_bottom_text.png");
    this.facebottomText = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.faceprefix_scan);
    paramResourceManager.append("face_top_text.png");
    this.facetopText = paramResourceManager.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ScanResource
 * JD-Core Version:    0.7.0.1
 */