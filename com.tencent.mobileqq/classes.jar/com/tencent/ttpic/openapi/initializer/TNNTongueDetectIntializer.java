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
    boolean bool = loadAllSoFiles();
    if (!bool) {}
    int i;
    do
    {
      return false;
      i = this.tnnTongueDetect.init(FileUtils.genSeperateFileDir(getFinalResourcesDir()) + "tongueReg.onnx.opt.onnx" + ".rapidproto.wmc", FileUtils.genSeperateFileDir(getFinalResourcesDir()) + "tongueReg.onnx.opt.onnx" + ".rapidmodel.wmc", "ARM");
    } while ((!bool) || (i != 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNTongueDetectIntializer
 * JD-Core Version:    0.7.0.1
 */