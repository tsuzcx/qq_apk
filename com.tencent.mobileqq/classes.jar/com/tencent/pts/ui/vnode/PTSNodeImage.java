package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSImageView;

public class PTSNodeImage
  extends PTSNodeVirtual<PTSImageView>
{
  private PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private void setImageSrc(String paramString) {}
  
  public PTSImageView initView()
  {
    return new PTSImageView(this);
  }
  
  public void resetAll() {}
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return false;
      if (!paramString.equals("src")) {
        break;
      }
      i = 0;
      break;
    } while (!(paramObject instanceof String));
    setImageSrc((String)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */