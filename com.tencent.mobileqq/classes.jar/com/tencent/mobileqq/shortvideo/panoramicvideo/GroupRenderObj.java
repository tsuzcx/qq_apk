package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.PanoramicLogUtil;
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
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (this.isRunning) {
        break;
      }
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
    if ((this.fboList == null) || (paramFBO == null)) {
      return;
    }
    int j = this.renderObjLists.size();
    int i = 0;
    label29:
    BaseRenderObj localBaseRenderObj;
    if (i < j)
    {
      localBaseRenderObj = (BaseRenderObj)this.renderObjLists.get(i);
      PanoramicLogUtil.Log("onDrawFrame: " + i + " / " + j + " " + localBaseRenderObj.getClass().getSimpleName() + " |previousTexture=" + paramInt);
      if (i >= j - 1) {
        break label194;
      }
      localBaseRenderObj.setViewport();
      this.fboList[i].bind();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      if (!(localBaseRenderObj instanceof GroupRenderObj)) {
        break label185;
      }
      ((GroupRenderObj)localBaseRenderObj).drawToFBO(paramInt, this.fboList[i]);
    }
    for (;;)
    {
      this.fboList[i].unbind();
      paramInt = this.fboList[i].getFrameBufferTextureId();
      i += 1;
      break label29;
      break;
      label185:
      localBaseRenderObj.onDrawFrame(paramInt);
    }
    label194:
    paramFBO.bind();
    localBaseRenderObj.setViewport();
    if ((localBaseRenderObj instanceof GroupRenderObj)) {
      ((GroupRenderObj)localBaseRenderObj).drawToFBO(paramInt, paramFBO);
    }
    for (;;)
    {
      paramFBO.unbind();
      break;
      localBaseRenderObj.onDrawFrame(paramInt);
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
    int j = 0;
    super.onRenderObjChanged(paramInt1, paramInt2);
    int k = this.renderObjLists.size();
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
      this.fboList = new FBO[k - 1];
      paramInt1 = j;
      while (paramInt1 < k - 1)
      {
        BaseRenderObj localBaseRenderObj = (BaseRenderObj)this.renderObjLists.get(paramInt1);
        this.fboList[paramInt1] = localBaseRenderObj.createFBO();
        paramInt1 += 1;
      }
    }
  }
  
  public void switchFilterAt(BaseRenderObj paramBaseRenderObj, int paramInt)
  {
    if ((paramBaseRenderObj == null) || (paramInt >= this.renderObjLists.size())) {
      return;
    }
    addPreDrawTask(new GroupRenderObj.4(this, paramBaseRenderObj, paramInt));
  }
  
  public void switchLastFilter(BaseRenderObj paramBaseRenderObj)
  {
    if (paramBaseRenderObj == null) {
      return;
    }
    if (!this.isRunning)
    {
      if (this.renderObjLists.size() > 0) {
        ((BaseRenderObj)this.renderObjLists.remove(this.renderObjLists.size() - 1)).destroy();
      }
      this.renderObjLists.add(paramBaseRenderObj);
      return;
    }
    addPreDrawTask(new GroupRenderObj.3(this, paramBaseRenderObj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj
 * JD-Core Version:    0.7.0.1
 */