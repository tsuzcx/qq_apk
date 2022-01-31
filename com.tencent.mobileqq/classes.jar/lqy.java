import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESimpleSticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.FacePointsFilter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Llrl;>;
import org.jetbrains.annotations.NotNull;

public class lqy
  extends lrh
{
  private AESimpleSticker jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private AIAttr jdField_a_of_type_ComTencentAekitPluginCoreAIAttr = new AIAttr(new AIAttrProvider(null));
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private FacePointsFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private final String jdField_a_of_type_JavaLangString = "AEFilter-" + Integer.toHexString(hashCode());
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public lqy()
  {
    super(1);
  }
  
  private Frame a(List<lrm> paramList, Frame paramFrame)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      float[][] arrayOfFloat = ((TTFaceOriginDataModel)((lrm)paramList.get(i)).jdField_a_of_type_JavaUtilList.get(0)).facePoint;
      ArrayList localArrayList2 = new ArrayList(arrayOfFloat.length);
      int j = 0;
      while (j < arrayOfFloat.length)
      {
        localArrayList2.add(new PointF(arrayOfFloat[j][0], arrayOfFloat[j][1]));
        j += 1;
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateVideoSize(paramFrame.width, paramFrame.height, 1.0D);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateMultiPoints(localArrayList1);
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.render(paramFrame);
  }
  
  @NotNull
  protected Frame a(List<lrl> paramList, long paramLong)
  {
    Object localObject2 = (lrl)paramList.get(0);
    Object localObject1 = ((lrl)paramList.get(0)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    ArrayList localArrayList = new ArrayList();
    if (((lrl)localObject2).a())
    {
      int i = 0;
      while (i < ((lrl)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        localArrayList.addAll(((lrm)((lrl)localObject2).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaUtilList);
        i += 1;
      }
    }
    localObject1 = FaceDetectUtil.genFaceAttr(localArrayList, ((Frame)localObject1).width, ((Frame)localObject1).height, 0);
    this.jdField_a_of_type_ComTencentAekitPluginCoreAIAttr.setFaceAttr(localObject1);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setAIAttr(this.jdField_a_of_type_ComTencentAekitPluginCoreAIAttr);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setFaceAttr((PTFaceAttr)localObject1);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.updateVideoSize(paramList.width, paramList.height, ((PTFaceAttr)localObject1).getFaceDetectScale());
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setRatio(paramList.width / paramList.height);
    localObject1 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.render(paramList);
    if ((paramList != localObject1) && (!paramList.unlock())) {
      paramList.clear();
    }
    if ((this.d) && (((lrl)localObject2).a()))
    {
      localObject2 = a(((lrl)localObject2).jdField_a_of_type_JavaUtilList, (Frame)localObject1);
      paramList = (List<lrl>)localObject2;
      if (localObject2 != localObject1)
      {
        paramList = (List<lrl>)localObject2;
        if (!((Frame)localObject1).unlock()) {
          ((Frame)localObject1).clear();
        }
      }
    }
    for (paramList = (List<lrl>)localObject2;; paramList = (List<lrl>)localObject1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentFilterBaseFilter.render(paramList);
      if (paramList != localObject1) {
        paramList.unlock();
      }
      return localObject1;
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker == null))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = new AESimpleSticker(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + ", material=" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId());
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.apply();
    }
    if ((this.d) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter == null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = new FacePointsFilter();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.apply();
    }
    this.jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentFilterBaseFilter.hashCode()));
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()));
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + " cleared");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = VideoSDKMaterialParser.parseVideoMaterial(this.jdField_b_of_type_JavaLangString, "params");
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: parse material=" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId());
    this.jdField_a_of_type_Boolean = VideoMaterialUtil.isGestureDetectMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
    this.jdField_b_of_type_Boolean = VideoMaterialUtil.isBodyDetectMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
    this.c = VideoMaterialUtil.isSegmentMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: gesture=" + this.jdField_a_of_type_Boolean + ", body=" + this.jdField_b_of_type_Boolean + ", segment=" + this.c);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = new AESimpleSticker(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + ", material=" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId());
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.apply();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + " cleared");
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()) + " cleared");
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqy
 * JD-Core Version:    0.7.0.1
 */