package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;

class FlowDecodeScreenSurfaceBase$1
  implements FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView
{
  FlowDecodeScreenSurfaceBase$1(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase) {}
  
  public GLSurfaceView.EGLConfigChooser a()
  {
    return new FlowDecodeScreenSurfaceBase.SimpleEGLConfigChooser(this.a, true);
  }
  
  public GLSurfaceView.EGLContextFactory a()
  {
    return new FlowDecodeScreenSurfaceBase.1.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.1
 * JD-Core Version:    0.7.0.1
 */