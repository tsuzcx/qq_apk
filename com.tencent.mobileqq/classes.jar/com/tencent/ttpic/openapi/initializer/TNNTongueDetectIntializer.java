package com.tencent.ttpic.openapi.initializer;

import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.youtu.rapidnet.library.TNNTongue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TNNTongueDetectIntializer
  extends Feature
{
  private static final String TAG = "TNNTongueDetectIntializer";
  public static final ModelInfo[] TONGUE_MODEL = { new ModelInfo(true, "tonguedetect", "tongueReg.onnx.opt.onnx.rapidproto.wmc"), new ModelInfo(true, "tonguedetect", "tongueReg.onnx.opt.onnx.rapidmodel.wmc") };
  private static final String TONGUE_MODEL_NAME = "tongueReg.onnx.opt.onnx";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tongue_detector") };
  private final TNNTongue tnnTongueDetect = new TNNTongue();
  
  protected boolean destroyImpl()
  {
    synchronized (this.tnnTongueDetect)
    {
      this.tnnTongueDetect.deinit();
      return true;
    }
  }
  
  public float forward(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return this.tnnTongueDetect.forward(paramArrayOfByte, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, TONGUE_MODEL);
    return localArrayList;
  }
  
  public String getName()
  {
    return "TNNTongueDetectIntializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return initTongue();
  }
  
  public boolean initTongue()
  {
    boolean bool3 = loadAllSoFiles();
    boolean bool2 = false;
    if (!bool3) {
      return false;
    }
    TNNTongue localTNNTongue = this.tnnTongueDetect;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(getFinalResourcesDir()));
    ((StringBuilder)localObject).append("tongueReg.onnx.opt.onnx");
    ((StringBuilder)localObject).append(".rapidproto.wmc");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.genSeperateFileDir(getFinalResourcesDir()));
    localStringBuilder.append("tongueReg.onnx.opt.onnx");
    localStringBuilder.append(".rapidmodel.wmc");
    int i = localTNNTongue.init((String)localObject, localStringBuilder.toString(), "ARM");
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNTongueDetectIntializer
 * JD-Core Version:    0.7.0.1
 */