package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;

public class PTSNodeImage
  extends PTSNodeVirtual
{
  public static final String TAG = "PTSNodeImage";
  private String imageUrl;
  
  public PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance, "img", null);
  }
  
  private void setImageSrc(String paramString) {}
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setImageSrc(this.imageUrl);
  }
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if (("src".equalsIgnoreCase(paramString)) && ((paramObject instanceof String)))
    {
      this.imageUrl = ((String)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */