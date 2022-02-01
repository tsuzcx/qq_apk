import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class lqb
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  int d = 0;
  int e = 0;
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, PendantItem paramPendantItem, lox paramlox, int paramInt4)
  {
    String str;
    label34:
    label43:
    StringBuilder localStringBuilder;
    if ((paramFilterDesc == null) || (paramFilterDesc.name == null))
    {
      paramFilterDesc = "null";
      if ((paramPendantItem != null) && (paramPendantItem.getId() != null)) {
        break label519;
      }
      str = "null";
      if (paramVideoMaterial != null) {
        break label529;
      }
      paramVideoMaterial = "null";
      if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int) || (paramInt3 != this.jdField_c_of_type_Int) || (paramBoolean != this.jdField_b_of_type_Boolean) || (this.d != paramlox.a()) || (this.jdField_a_of_type_Boolean != paramlox.jdField_a_of_type_Boolean) || (this.e != paramInt4) || (!TextUtils.equals(paramFilterDesc, this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)) || (!TextUtils.equals(paramVideoMaterial, this.jdField_c_of_type_JavaLangString)))
      {
        localStringBuilder = new StringBuilder().append("RenderInfoLog, frameIndex[").append(paramLong).append("], width[").append(this.jdField_a_of_type_Int).append("->").append(paramInt1).append("], height[").append(this.jdField_b_of_type_Int).append("->").append(paramInt2).append("], angle[").append(this.jdField_c_of_type_Int).append("->").append(paramInt3).append("], needFaceData[").append(this.jdField_b_of_type_Boolean).append("->").append(paramBoolean).append("], mDataLen[").append(this.d).append("->").append(paramlox.a()).append("], mBeautyLevel[").append(this.e).append("->").append(paramInt4).append("], isFront[").append(this.jdField_a_of_type_Boolean).append("->").append(paramlox.jdField_a_of_type_Boolean).append("], getFrameAngle[").append(lqe.a(paramlox.jdField_a_of_type_Boolean)).append("], fAngle[").append((paramlox.d - lqe.a(paramlox.jdField_a_of_type_Boolean) - 1 + 4) % 4).append("], strFilterDesc[").append(paramFilterDesc).append("], strPendantItem[").append(str).append("], pendantItem[");
        if ((paramPendantItem != null) && (paramPendantItem.getId() != null)) {
          break label539;
        }
      }
    }
    label519:
    label529:
    label539:
    for (paramPendantItem = "null";; paramPendantItem = paramPendantItem.getId())
    {
      QLog.w(paramString, 1, paramPendantItem + "], strFilters[" + paramVideoMaterial + "]");
      this.jdField_a_of_type_Boolean = paramlox.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_Int = paramInt3;
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaLangString = paramFilterDesc;
      this.jdField_b_of_type_JavaLangString = str;
      this.jdField_c_of_type_JavaLangString = paramVideoMaterial;
      this.d = paramlox.a();
      this.e = paramInt4;
      return;
      paramFilterDesc = paramFilterDesc.name;
      break;
      str = paramPendantItem.getId();
      break label34;
      paramVideoMaterial = paramVideoMaterial.toString();
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lqb
 * JD-Core Version:    0.7.0.1
 */