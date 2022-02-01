package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.PanoramicLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupRenderObj
  extends BaseRenderObj
{
  private static final String TAG = "GroupRenderObj";
  private FBO[] fboList;
  private boolean isRunning;
  protected List<BaseRenderObj> renderObjLists = new ArrayList();
  
  private void destroyFrameBuffers()
  {
    FBO[] arrayOfFBO = this.fboList;
    int j = arrayOfFBO.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFBO[i].destroy();
      i += 1;
    }
  }
  
  public void addFilter(BaseRenderObj paramBaseRenderObj)
  {
    if (paramBaseRenderObj == null) {
      return;
    }
    if (!this.isRunning)
    {
      this.renderObjLists.add(paramBaseRenderObj);
      return;
    }
    addPreDrawTask(new GroupRenderObj.1(this, paramBaseRenderObj));
  }
  
  public void addFilterList(List<BaseRenderObj> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (!this.isRunning)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseRenderObj localBaseRenderObj = (BaseRenderObj)paramList.next();
        this.renderObjLists.add(localBaseRenderObj);
      }
    }
    addPreDrawTask(new GroupRenderObj.2(this, paramList));
  }
  
  public void destroy()
  {
    destroyFrameBuffers();
    Iterator localIterator = this.renderObjLists.iterator();
    while (localIterator.hasNext()) {
      ((BaseRenderObj)localIterator.next()).destroy();
    }
    this.isRunning = false;
  }
  
  public void drawToFBO(int paramInt, FBO paramFBO)
  {
    runPreDrawTasks();
    if (this.fboList != null)
    {
      if (paramFBO == null) {
        return;
      }
      int k = this.renderObjLists.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        BaseRenderObj localBaseRenderObj = (BaseRenderObj)this.renderObjLists.get(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDrawFrame: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" / ");
        localStringBuilder.append(k);
        localStringBuilder.append(" ");
        localStringBuilder.append(localBaseRenderObj.getClass().getSimpleName());
        localStringBuilder.append(" |previousTexture=");
        localStringBuilder.append(i);
        PanoramicLogUtil.Log(localStringBuilder.toString());
        if (paramInt < k - 1)
        {
          localBaseRenderObj.setViewport();
          this.fboList[paramInt].bind();
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
          if ((localBaseRenderObj instanceof GroupRenderObj)) {
            ((GroupRenderObj)localBaseRenderObj).drawToFBO(i, this.fboList[paramInt]);
          } else {
            localBaseRenderObj.onDrawFrame(i);
          }
          this.fboList[paramInt].unbind();
          i = this.fboList[paramInt].getFrameBufferTextureId();
        }
        else
        {
          paramFBO.bind();
          localBaseRenderObj.setViewport();
          if ((localBaseRenderObj instanceof GroupRenderObj)) {
            ((GroupRenderObj)localBaseRenderObj).drawToFBO(i, paramFBO);
          } else {
            localBaseRenderObj.onDrawFrame(i);
          }
          paramFBO.unbind();
        }
        paramInt += 1;
      }
    }
  }
  
  public void init()
  {
    Iterator localIterator = this.renderObjLists.iterator();
    while (localIterator.hasNext()) {
      ((BaseRenderObj)localIterator.next()).init();
    }
    this.isRunning = true;
  }
  
  public void onDrawFrame(int paramInt)
  {
    throw new RuntimeException("Illegal call");
  }
  
  public void onRenderObjChanged(int paramInt1, int paramInt2)
  {
    super.onRenderObjChanged(paramInt1, paramInt2);
    int k = this.renderObjLists.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ((BaseRenderObj)this.renderObjLists.get(i)).onRenderObjChanged(paramInt1, paramInt2);
      i += 1;
    }
    if (this.fboList != null)
    {
      destroyFrameBuffers();
      this.fboList = null;
    }
    if (this.fboList == null)
    {
      paramInt2 = k - 1;
      this.fboList = new FBO[paramInt2];
      paramInt1 = j;
      while (paramInt1 < paramInt2)
      {
        BaseRenderObj localBaseRenderObj = (BaseRenderObj)this.renderObjLists.get(paramInt1);
        this.fboList[paramInt1] = localBaseRenderObj.createFBO();
        paramInt1 += 1;
      }
    }
  }
  
  public void switchFilterAt(BaseRenderObj paramBaseRenderObj, int paramInt)
  {
    if (paramBaseRenderObj != null)
    {
      if (paramInt >= this.renderObjLists.size()) {
        return;
      }
      addPreDrawTask(new GroupRenderObj.4(this, paramBaseRenderObj, paramInt));
    }
  }
  
  public void switchLastFilter(BaseRenderObj paramBaseRenderObj)
  {
    if (paramBaseRenderObj == null) {
      return;
    }
    if (!this.isRunning)
    {
      if (this.renderObjLists.size() > 0)
      {
        List localList = this.renderObjLists;
        ((BaseRenderObj)localList.remove(localList.size() - 1)).destroy();
      }
      this.renderObjLists.add(paramBaseRenderObj);
      return;
    }
    addPreDrawTask(new GroupRenderObj.3(this, paramBaseRenderObj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj
 * JD-Core Version:    0.7.0.1
 */