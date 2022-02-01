package com.tencent.qcircle.weseevideo.composition.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.VignettingFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.FeatureUtils;

public class VignettingFilter2
  extends VignettingFilter
{
  public VignettingFilter2()
  {
    Bitmap localBitmap = FeatureUtils.getEncryptedBitmap("assets://raw/sh/", FeatureManager.getResourceDir(), "darkcornermask_revert_s.png");
    if (BitmapUtils.isLegal(localBitmap)) {
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.filter.VignettingFilter2
 * JD-Core Version:    0.7.0.1
 */