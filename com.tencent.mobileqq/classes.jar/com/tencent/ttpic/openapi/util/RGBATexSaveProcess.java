package com.tencent.ttpic.openapi.util;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.util.TexSaveProcess;
import java.util.HashSet;
import java.util.Set;

public class RGBATexSaveProcess
  implements TexSaveProcess
{
  private static Set<String> blackList = new HashSet();
  private final int MAX_DATA_SIZE = 35389440;
  private byte[] mData;
  private BaseFilter mFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mRenderFrame = new Frame();
  
  static
  {
    blackList.add("HUAWEI_LYA-AL00");
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 * paramInt2 * 4;
    if ((this.mData == null) || (this.mData.length != paramInt1)) {
      this.mData = new byte[paramInt1];
    }
  }
  
  private boolean isInBlackList()
  {
    String str = DeviceInstance.getInstance().getDeviceName();
    return (str != null) && ((str.startsWith("HUAWEI")) || (blackList.contains(str)));
  }
  
  public void clear()
  {
    this.mFilter.ClearGLSL();
    this.mRenderFrame.clear();
    this.mData = null;
  }
  
  public void init()
  {
    this.mFilter.applyFilterChain(true, 0.0F, 0.0F);
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 * paramInt3 * 4;
    if ((i <= 0) || (i > 35389440)) {
      return new byte[0];
    }
    init();
    initData(paramInt2, paramInt3);
    if (isInBlackList())
    {
      Frame localFrame = new Frame();
      this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame);
      BenchUtil.benchStart("saveTextureToRgbaBuffer");
      GlUtil.saveTextureToRgbaBuffer(localFrame.getTextureId(), paramInt2, paramInt3, this.mData, localFrame.getFBO());
      BenchUtil.benchEnd("saveTextureToRgbaBuffer");
      localFrame.clear();
    }
    for (;;)
    {
      return this.mData;
      this.mRenderFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
      this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mRenderFrame);
      BenchUtil.benchStart("saveTextureToRgbaBuffer");
      GlUtil.saveTextureToRgbaBuffer(this.mRenderFrame.getTextureId(), paramInt2, paramInt3, this.mData, this.mRenderFrame.getFBO());
      BenchUtil.benchEnd("saveTextureToRgbaBuffer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.RGBATexSaveProcess
 * JD-Core Version:    0.7.0.1
 */